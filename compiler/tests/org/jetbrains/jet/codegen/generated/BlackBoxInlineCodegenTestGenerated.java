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

package org.jetbrains.jet.codegen.generated;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;
import java.util.regex.Pattern;
import org.jetbrains.jet.JetTestUtils;
import org.jetbrains.jet.test.InnerTestClasses;
import org.jetbrains.jet.test.TestMetadata;

import org.jetbrains.jet.codegen.generated.AbstractBlackBoxCodegenTest;

/** This class is generated by {@link org.jetbrains.jet.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/codegen/boxInline")
public class BlackBoxInlineCodegenTestGenerated extends AbstractBlackBoxCodegenTest {
    public void testAllFilesPresentInBoxInline() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/codegen/boxInline"), Pattern.compile("^([^\\.]+)$"), false);
    }
    
    @TestMetadata("captureInlinable")
    public void testCaptureInlinable() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/captureInlinable");
    }
    
    @TestMetadata("captureInlinableAndOther")
    public void testCaptureInlinableAndOther() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/captureInlinableAndOther");
    }
    
    @TestMetadata("captureThisAndReceiver")
    public void testCaptureThisAndReceiver() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/captureThisAndReceiver");
    }
    
    @TestMetadata("closureChain")
    public void testClosureChain() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/closureChain");
    }
    
    @TestMetadata("cycles")
    public void testCycles() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/cycles");
    }
    
    @TestMetadata("differentObjects")
    public void testDifferentObjects() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/differentObjects");
    }
    
    @TestMetadata("extension")
    public void testExtension() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/extension");
    }
    
    @TestMetadata("forEachLine")
    public void testForEachLine() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/forEachLine");
    }
    
    @TestMetadata("generics")
    public void testGenerics() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/generics");
    }
    
    @TestMetadata("identityCheck")
    public void testIdentityCheck() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/identityCheck");
    }
    
    @TestMetadata("ifBranches")
    public void testIfBranches() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/ifBranches");
    }
    
    @TestMetadata("inlineChain")
    public void testInlineChain() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/inlineChain");
    }
    
    @TestMetadata("lambdaClassClash")
    public void testLambdaClassClash() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/lambdaClassClash");
    }
    
    @TestMetadata("lambdaInLambda")
    public void testLambdaInLambda() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/lambdaInLambda");
    }
    
    @TestMetadata("lambdaInLambda2")
    public void testLambdaInLambda2() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/lambdaInLambda2");
    }
    
    @TestMetadata("lambdaInLambdaNoInline")
    public void testLambdaInLambdaNoInline() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/lambdaInLambdaNoInline");
    }
    
    @TestMetadata("localFunInLambda")
    public void testLocalFunInLambda() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/localFunInLambda");
    }
    
    @TestMetadata("namespace")
    public void testNamespace() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/namespace");
    }
    
    @TestMetadata("noInline")
    public void testNoInline() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/noInline");
    }
    
    @TestMetadata("noInlineLambdaX2")
    public void testNoInlineLambdaX2() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/noInlineLambdaX2");
    }
    
    @TestMetadata("params")
    public void testParams() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/params");
    }
    
    @TestMetadata("regeneratedLambdaName")
    public void testRegeneratedLambdaName() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/regeneratedLambdaName");
    }
    
    @TestMetadata("rootConstructor")
    public void testRootConstructor() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/rootConstructor");
    }
    
    @TestMetadata("severalClosures")
    public void testSeveralClosures() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/severalClosures");
    }
    
    @TestMetadata("severalUsage")
    public void testSeveralUsage() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/severalUsage");
    }
    
    @TestMetadata("simpleDouble")
    public void testSimpleDouble() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/simpleDouble");
    }
    
    @TestMetadata("simpleGenerics")
    public void testSimpleGenerics() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/simpleGenerics");
    }
    
    @TestMetadata("simpleInt")
    public void testSimpleInt() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/simpleInt");
    }
    
    @TestMetadata("simpleLambda")
    public void testSimpleLambda() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/simpleLambda");
    }
    
    @TestMetadata("simpleObject")
    public void testSimpleObject() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/simpleObject");
    }
    
    @TestMetadata("stackHeightBug")
    public void testStackHeightBug() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/stackHeightBug");
    }
    
    @TestMetadata("tryCatchFinally")
    public void testTryCatchFinally() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/tryCatchFinally");
    }
    
    @TestMetadata("tryCatchFinally2")
    public void testTryCatchFinally2() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/tryCatchFinally2");
    }
    
    @TestMetadata("use")
    public void testUse() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/use");
    }
    
    @TestMetadata("with")
    public void testWith() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/with");
    }
    
    @TestMetadata("withoutInline")
    public void testWithoutInline() throws Exception {
        doTestMultiFile("compiler/testData/codegen/boxInline/withoutInline");
    }
    
}
