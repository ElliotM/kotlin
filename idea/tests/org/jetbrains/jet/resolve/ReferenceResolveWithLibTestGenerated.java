/*
 * Copyright 2010-2014 JetBrains s.r.o.
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

package org.jetbrains.jet.resolve;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;
import java.util.regex.Pattern;
import org.jetbrains.jet.JetTestUtils;
import org.jetbrains.jet.test.InnerTestClasses;
import org.jetbrains.jet.test.TestMetadata;

import org.jetbrains.jet.resolve.AbstractReferenceResolveWithLibTest;

/** This class is generated by {@link org.jetbrains.jet.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("idea/testData/resolve/referenceWithLib")
public class ReferenceResolveWithLibTestGenerated extends AbstractReferenceResolveWithLibTest {
    public void testAllFilesPresentInReferenceWithLib() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("idea/testData/resolve/referenceWithLib"), Pattern.compile("^(.+)\\.kt$"), false);
    }
    
    @TestMetadata("delegatedPropertyWithTypeParameters.kt")
    public void testDelegatedPropertyWithTypeParameters() throws Exception {
        doTest("idea/testData/resolve/referenceWithLib/delegatedPropertyWithTypeParameters.kt");
    }
    
    @TestMetadata("fakeOverride.kt")
    public void testFakeOverride() throws Exception {
        doTest("idea/testData/resolve/referenceWithLib/fakeOverride.kt");
    }
    
    @TestMetadata("fakeOverride2.kt")
    public void testFakeOverride2() throws Exception {
        doTest("idea/testData/resolve/referenceWithLib/fakeOverride2.kt");
    }
    
    @TestMetadata("iteratorWithTypeParameter.kt")
    public void testIteratorWithTypeParameter() throws Exception {
        doTest("idea/testData/resolve/referenceWithLib/iteratorWithTypeParameter.kt");
    }
    
    @TestMetadata("packageOfLibDeclaration.kt")
    public void testPackageOfLibDeclaration() throws Exception {
        doTest("idea/testData/resolve/referenceWithLib/packageOfLibDeclaration.kt");
    }
    
    @TestMetadata("sameNameInLib.kt")
    public void testSameNameInLib() throws Exception {
        doTest("idea/testData/resolve/referenceWithLib/sameNameInLib.kt");
    }
    
    @TestMetadata("setWithTypeParameters.kt")
    public void testSetWithTypeParameters() throws Exception {
        doTest("idea/testData/resolve/referenceWithLib/setWithTypeParameters.kt");
    }
    
}
