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

package org.jetbrains.jet.plugin.caches.resolve;

import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.util.ModificationTracker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jet.analyzer.AnalyzeExhaust;
import org.jetbrains.jet.lang.resolve.BindingContext;
import org.jetbrains.jet.lang.resolve.BodiesResolveContext;

public class KotlinDeclarationsCacheImpl implements KotlinDeclarationsCache, ModificationTracker {

    private static final Logger LOG = Logger.getInstance(KotlinDeclarationsCacheImpl.class);

    private final AnalyzeExhaust exhaust;

    public KotlinDeclarationsCacheImpl(@NotNull AnalyzeExhaust exhaust) {
        this.exhaust = exhaust;
        if (exhaust.isError()) {
            LOG.error(exhaust.getError());
        }
    }

    @Override
    @NotNull
    public BindingContext getBindingContext() {
        return exhaust.getBindingContext();
    }

    @Override
    public long getModificationCount() {
        BodiesResolveContext context = exhaust.getBodiesResolveContext();
        if (context == null) return 0;
        return context.getExceptionTracker().getModificationCount();
    }

    @NotNull
    public AnalyzeExhaust getAnalyzeExhaust() {
        return exhaust;
    }
}
