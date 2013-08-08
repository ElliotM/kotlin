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

package org.jetbrains.jet.lang.resolve.java.structure;

import com.intellij.psi.PsiPackage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.jet.lang.resolve.name.FqName;

import java.util.Collection;

import static org.jetbrains.jet.lang.resolve.java.structure.JavaElementCollectionFromPsiArrayUtil.classes;
import static org.jetbrains.jet.lang.resolve.java.structure.JavaElementCollectionFromPsiArrayUtil.packages;

public class JavaPackage extends JavaElementImpl {
    public JavaPackage(@NotNull PsiPackage psiPackage) {
        super(psiPackage);
    }

    @NotNull
    @Override
    public PsiPackage getPsi() {
        return (PsiPackage) super.getPsi();
    }

    @NotNull
    public Collection<JavaClass> getClasses() {
        return classes(getPsi().getClasses());
    }

    @NotNull
    public Collection<JavaPackage> getSubPackages() {
        return packages(getPsi().getSubPackages());
    }

    @NotNull
    public FqName getFqName() {
        return new FqName(getPsi().getQualifiedName());
    }
}