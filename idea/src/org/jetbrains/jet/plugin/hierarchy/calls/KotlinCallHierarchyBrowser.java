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

package org.jetbrains.jet.plugin.hierarchy.calls;

import com.intellij.ide.hierarchy.CallHierarchyBrowserBase;
import com.intellij.ide.hierarchy.HierarchyNodeDescriptor;
import com.intellij.ide.hierarchy.HierarchyTreeStructure;
import com.intellij.ide.hierarchy.JavaHierarchyUtil;
import com.intellij.ide.util.treeView.NodeDescriptor;
import com.intellij.openapi.actionSystem.ActionGroup;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.ui.PopupHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jet.plugin.hierarchy.HierarchyUtils;

import javax.swing.*;
import java.util.Comparator;
import java.util.Map;

public class KotlinCallHierarchyBrowser extends CallHierarchyBrowserBase {
    public KotlinCallHierarchyBrowser(@NotNull Project project, @NotNull PsiElement element) {
        super(project, element);
    }

    @Override
    protected void createTrees(@NotNull Map<String, JTree> type2TreeMap) {
        ActionGroup group = (ActionGroup) ActionManager.getInstance().getAction(IdeActions.GROUP_CALL_HIERARCHY_POPUP);

        JTree tree1 = createTree(false);
        PopupHandler.installPopupHandler(tree1, group, ActionPlaces.CALL_HIERARCHY_VIEW_POPUP, ActionManager.getInstance());
        BaseOnThisMethodAction baseOnThisMethodAction = new BaseOnThisMethodAction();
        baseOnThisMethodAction.registerCustomShortcutSet(
                ActionManager.getInstance().getAction(IdeActions.ACTION_CALL_HIERARCHY).getShortcutSet(), tree1
        );
        type2TreeMap.put(CALLEE_TYPE, tree1);

        JTree tree2 = createTree(false);
        PopupHandler.installPopupHandler(tree2, group, ActionPlaces.CALL_HIERARCHY_VIEW_POPUP, ActionManager.getInstance());
        baseOnThisMethodAction.registerCustomShortcutSet(
                ActionManager.getInstance().getAction(IdeActions.ACTION_CALL_HIERARCHY).getShortcutSet(), tree2
        );
        type2TreeMap.put(CALLER_TYPE, tree2);
    }

    private static PsiElement getTargetElement(@NotNull HierarchyNodeDescriptor descriptor) {
        if (descriptor instanceof KotlinCallHierarchyNodeDescriptor) {
            return ((KotlinCallHierarchyNodeDescriptor) descriptor).getTargetElement();
        }
        return null;
    }

    @Override
    protected PsiElement getElementFromDescriptor(@NotNull HierarchyNodeDescriptor descriptor) {
        return getTargetElement(descriptor);
    }

    @Override
    protected boolean isApplicableElement(@NotNull PsiElement element) {
        return HierarchyUtils.IS_CALL_HIERARCHY_ELEMENT.invoke(element);
    }

    @Override
    protected HierarchyTreeStructure createHierarchyTreeStructure(@NotNull String typeName, @NotNull PsiElement psiElement) {
        if (typeName.equals(CALLER_TYPE)) {
            return KotlinCallerMethodsTreeStructure.newInstance(myProject, psiElement, getCurrentScopeType());
        }

        if (typeName.equals(CALLEE_TYPE)) {
            return new KotlinCalleeMethodsTreeStructure(myProject, psiElement, getCurrentScopeType());
        }

        return null;
    }

    @Override
    protected Comparator<NodeDescriptor> getComparator() {
        return JavaHierarchyUtil.getComparator(myProject);
    }
}
