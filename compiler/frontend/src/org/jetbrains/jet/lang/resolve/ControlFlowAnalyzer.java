/*
 * Copyright 2010-2013 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.jet.lang.resolve;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.jet.lang.cfg.JetFlowInformationProvider;
import org.jetbrains.jet.lang.descriptors.PropertyAccessorDescriptor;
import org.jetbrains.jet.lang.descriptors.PropertyDescriptor;
import org.jetbrains.jet.lang.descriptors.SimpleFunctionDescriptor;
import org.jetbrains.jet.lang.psi.*;
import org.jetbrains.jet.lang.types.JetType;

import javax.inject.Inject;
import java.util.Map;

import static org.jetbrains.jet.lang.types.TypeUtils.NO_EXPECTED_TYPE;

public class ControlFlowAnalyzer {
    private TopDownAnalysisParameters topDownAnalysisParameters;
    private BindingTrace trace;

    @Inject
    public void setTopDownAnalysisParameters(TopDownAnalysisParameters topDownAnalysisParameters) {
        this.topDownAnalysisParameters = topDownAnalysisParameters;
    }

    @Inject
    public void setTrace(BindingTrace trace) {
        this.trace = trace;
    }

    public void process(@NotNull BodiesResolveContext bodiesResolveContext) {
        for (JetFile file : bodiesResolveContext.getFiles()) {
            if (!bodiesResolveContext.completeAnalysisNeeded(file)) continue;
            checkDeclarationContainer(file);
        }
        for (JetClassOrObject aClass : bodiesResolveContext.getClasses().keySet()) {
            if (!bodiesResolveContext.completeAnalysisNeeded(aClass)) continue;
            checkDeclarationContainer(aClass);
        }
        for (Map.Entry<JetNamedFunction, SimpleFunctionDescriptor> entry : bodiesResolveContext.getFunctions().entrySet()) {
            JetNamedFunction function = entry.getKey();
            SimpleFunctionDescriptor functionDescriptor = entry.getValue();
            if (!bodiesResolveContext.completeAnalysisNeeded(function)) continue;
            JetType expectedReturnType = !function.hasBlockBody() && !function.hasDeclaredReturnType()
                                               ? NO_EXPECTED_TYPE
                                               : functionDescriptor.getReturnType();
            assert expectedReturnType != null
                    : "functionDescriptor is not yet fully initialized or broken so return type is null " + functionDescriptor;
            checkFunction(function, expectedReturnType);
        }
        for (Map.Entry<JetProperty, PropertyDescriptor> entry : bodiesResolveContext.getProperties().entrySet()) {
            JetProperty property = entry.getKey();
            if (!bodiesResolveContext.completeAnalysisNeeded(property)) continue;
            PropertyDescriptor propertyDescriptor = entry.getValue();
            checkProperty(property, propertyDescriptor);
        }
    }

    private void checkDeclarationContainer(JetDeclarationContainer declarationContainer) {
        // A pseudocode of class/object initialization corresponds to a class/object
        // or initialization of properties corresponds to a package declared in a file
        JetFlowInformationProvider flowInformationProvider = new JetFlowInformationProvider((JetElement) declarationContainer, trace);
        flowInformationProvider.recordInitializedVariables();

        if (topDownAnalysisParameters.isDeclaredLocally()) return;

        flowInformationProvider.markUninitializedVariables();
    }

    private void checkProperty(JetProperty property, PropertyDescriptor propertyDescriptor) {
        for (JetPropertyAccessor accessor : property.getAccessors()) {
            PropertyAccessorDescriptor accessorDescriptor = accessor.isGetter()
                                                            ? propertyDescriptor.getGetter()
                                                            : propertyDescriptor.getSetter();
            assert accessorDescriptor != null : "no property accessor descriptor " + accessor.getText();
            JetType returnType = accessorDescriptor.getReturnType();
            assert returnType != null : "property accessor has no return type " + accessorDescriptor;
            checkFunction(accessor, returnType);
        }
    }

    private void checkFunction(@NotNull JetDeclarationWithBody function, @NotNull JetType expectedReturnType) {
        JetExpression bodyExpression = function.getBodyExpression();
        if (bodyExpression == null) return;
        JetFlowInformationProvider flowInformationProvider = new JetFlowInformationProvider(function, trace);
        flowInformationProvider.checkFunction(function, expectedReturnType, topDownAnalysisParameters.isDeclaredLocally());
    }
}
