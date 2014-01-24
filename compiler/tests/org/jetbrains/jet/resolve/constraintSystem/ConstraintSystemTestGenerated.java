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

package org.jetbrains.jet.resolve.constraintSystem;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestSuite;

import java.io.File;
import java.util.regex.Pattern;
import org.jetbrains.jet.JetTestUtils;
import org.jetbrains.jet.test.InnerTestClasses;
import org.jetbrains.jet.test.TestMetadata;

import org.jetbrains.jet.resolve.constraintSystem.AbstractConstraintSystemTest;

/** This class is generated by {@link org.jetbrains.jet.generators.tests.TestsPackage}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("compiler/testData/constraintSystem")
@InnerTestClasses({ConstraintSystemTestGenerated.CheckStatus.class, ConstraintSystemTestGenerated.ComputeValues.class, ConstraintSystemTestGenerated.IntegerValueTypes.class, ConstraintSystemTestGenerated.SeveralVariables.class, ConstraintSystemTestGenerated.Variance.class})
public class ConstraintSystemTestGenerated extends AbstractConstraintSystemTest {
    public void testAllFilesPresentInConstraintSystem() throws Exception {
        JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/constraintSystem"), Pattern.compile("^(.+)\\.bounds$"), true);
    }
    
    @TestMetadata("compiler/testData/constraintSystem/checkStatus")
    public static class CheckStatus extends AbstractConstraintSystemTest {
        public void testAllFilesPresentInCheckStatus() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/constraintSystem/checkStatus"), Pattern.compile("^(.+)\\.bounds$"), true);
        }
        
        @TestMetadata("conflictingConstraints.bounds")
        public void testConflictingConstraints() throws Exception {
            doTest("compiler/testData/constraintSystem/checkStatus/conflictingConstraints.bounds");
        }
        
        @TestMetadata("successful.bounds")
        public void testSuccessful() throws Exception {
            doTest("compiler/testData/constraintSystem/checkStatus/successful.bounds");
        }
        
        @TestMetadata("typeConstructorMismatch.bounds")
        public void testTypeConstructorMismatch() throws Exception {
            doTest("compiler/testData/constraintSystem/checkStatus/typeConstructorMismatch.bounds");
        }
        
        @TestMetadata("unknownParameters.bounds")
        public void testUnknownParameters() throws Exception {
            doTest("compiler/testData/constraintSystem/checkStatus/unknownParameters.bounds");
        }
        
        @TestMetadata("violatedUpperBound.bounds")
        public void testViolatedUpperBound() throws Exception {
            doTest("compiler/testData/constraintSystem/checkStatus/violatedUpperBound.bounds");
        }
        
    }
    
    @TestMetadata("compiler/testData/constraintSystem/computeValues")
    public static class ComputeValues extends AbstractConstraintSystemTest {
        public void testAllFilesPresentInComputeValues() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/constraintSystem/computeValues"), Pattern.compile("^(.+)\\.bounds$"), true);
        }
        
        @TestMetadata("contradiction.bounds")
        public void testContradiction() throws Exception {
            doTest("compiler/testData/constraintSystem/computeValues/contradiction.bounds");
        }
        
        @TestMetadata("subTypeOfUpperBounds.bounds")
        public void testSubTypeOfUpperBounds() throws Exception {
            doTest("compiler/testData/constraintSystem/computeValues/subTypeOfUpperBounds.bounds");
        }
        
        @TestMetadata("superTypeOfLowerBounds1.bounds")
        public void testSuperTypeOfLowerBounds1() throws Exception {
            doTest("compiler/testData/constraintSystem/computeValues/superTypeOfLowerBounds1.bounds");
        }
        
        @TestMetadata("superTypeOfLowerBounds2.bounds")
        public void testSuperTypeOfLowerBounds2() throws Exception {
            doTest("compiler/testData/constraintSystem/computeValues/superTypeOfLowerBounds2.bounds");
        }
        
    }
    
    @TestMetadata("compiler/testData/constraintSystem/integerValueTypes")
    public static class IntegerValueTypes extends AbstractConstraintSystemTest {
        public void testAllFilesPresentInIntegerValueTypes() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/constraintSystem/integerValueTypes"), Pattern.compile("^(.+)\\.bounds$"), true);
        }
        
        @TestMetadata("byteOverflow.bounds")
        public void testByteOverflow() throws Exception {
            doTest("compiler/testData/constraintSystem/integerValueTypes/byteOverflow.bounds");
        }
        
        @TestMetadata("defaultLong.bounds")
        public void testDefaultLong() throws Exception {
            doTest("compiler/testData/constraintSystem/integerValueTypes/defaultLong.bounds");
        }
        
        @TestMetadata("numberAndAny.bounds")
        public void testNumberAndAny() throws Exception {
            doTest("compiler/testData/constraintSystem/integerValueTypes/numberAndAny.bounds");
        }
        
        @TestMetadata("numberAndString.bounds")
        public void testNumberAndString() throws Exception {
            doTest("compiler/testData/constraintSystem/integerValueTypes/numberAndString.bounds");
        }
        
        @TestMetadata("severalNumbers.bounds")
        public void testSeveralNumbers() throws Exception {
            doTest("compiler/testData/constraintSystem/integerValueTypes/severalNumbers.bounds");
        }
        
        @TestMetadata("simpleByte.bounds")
        public void testSimpleByte() throws Exception {
            doTest("compiler/testData/constraintSystem/integerValueTypes/simpleByte.bounds");
        }
        
        @TestMetadata("simpleInt.bounds")
        public void testSimpleInt() throws Exception {
            doTest("compiler/testData/constraintSystem/integerValueTypes/simpleInt.bounds");
        }
        
        @TestMetadata("simpleShort.bounds")
        public void testSimpleShort() throws Exception {
            doTest("compiler/testData/constraintSystem/integerValueTypes/simpleShort.bounds");
        }
        
    }
    
    @TestMetadata("compiler/testData/constraintSystem/severalVariables")
    public static class SeveralVariables extends AbstractConstraintSystemTest {
        public void testAllFilesPresentInSeveralVariables() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/constraintSystem/severalVariables"), Pattern.compile("^(.+)\\.bounds$"), true);
        }
        
        @TestMetadata("simpleDependency.bounds")
        public void testSimpleDependency() throws Exception {
            doTest("compiler/testData/constraintSystem/severalVariables/simpleDependency.bounds");
        }
        
    }
    
    @TestMetadata("compiler/testData/constraintSystem/variance")
    public static class Variance extends AbstractConstraintSystemTest {
        public void testAllFilesPresentInVariance() throws Exception {
            JetTestUtils.assertAllTestsPresentByMetadata(this.getClass(), "org.jetbrains.jet.generators.tests.TestsPackage", new File("compiler/testData/constraintSystem/variance"), Pattern.compile("^(.+)\\.bounds$"), true);
        }
        
        @TestMetadata("consumer.bounds")
        public void testConsumer() throws Exception {
            doTest("compiler/testData/constraintSystem/variance/consumer.bounds");
        }
        
        @TestMetadata("invariant.bounds")
        public void testInvariant() throws Exception {
            doTest("compiler/testData/constraintSystem/variance/invariant.bounds");
        }
        
        @TestMetadata("producer.bounds")
        public void testProducer() throws Exception {
            doTest("compiler/testData/constraintSystem/variance/producer.bounds");
        }
        
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite("ConstraintSystemTestGenerated");
        suite.addTestSuite(ConstraintSystemTestGenerated.class);
        suite.addTestSuite(CheckStatus.class);
        suite.addTestSuite(ComputeValues.class);
        suite.addTestSuite(IntegerValueTypes.class);
        suite.addTestSuite(SeveralVariables.class);
        suite.addTestSuite(Variance.class);
        return suite;
    }
}
