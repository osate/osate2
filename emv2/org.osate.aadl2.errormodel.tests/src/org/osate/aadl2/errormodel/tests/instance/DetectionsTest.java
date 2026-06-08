/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.AllSources;
import org.osate.aadl2.errormodel.instance.ConditionPropagationReference;
import org.osate.aadl2.errormodel.instance.ConstantCode;
import org.osate.aadl2.errormodel.instance.CountExpression;
import org.osate.aadl2.errormodel.instance.CountExpressionOperation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EventReference;
import org.osate.aadl2.errormodel.instance.IntegerCode;
import org.osate.aadl2.errormodel.instance.NoErrorPropagationReference;
import org.osate.aadl2.errormodel.instance.SourceStateReference;
import org.osate.aadl2.errormodel.instance.StringCode;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class DetectionsTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/Detections/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testOverriddenDetection() throws Exception {
		var pkg = testHelper.parseFile(PATH + "overridden_detection.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getDetections().size());
		with(annexInstance.getDetections().get(0), detection -> {
			assertEquals("DETECTION1", detection.getName());
			assertEquals("DETECTION1", detection.getDetection().getName());
			assertEquals("state2", detection.getSource().getName());
			assertNull(detection.getCondition());
			assertEquals("f2", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
	}

	@Test
	public void testInheritUnnamedDetections() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherit_unnamed_detections.aadl", PATH + "my_set.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(5, annexInstance.getDetections().size());
		with(annexInstance.getDetections().get(0), detection -> {
			assertEquals("state3 -[]-> f3 ! (my_set::my_constant)", detection.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().get(0))
					.getParsedAnnexSubclause()).getErrorDetections().get(0), detection.getDetection());
			assertEquals("state3", detection.getSource().getName());
			assertNull(detection.getCondition());
			assertEquals("f3", detection.getDestination().getName());
			assertEquals("my_set::my_constant", detection.getErrorCode().getName());
		});
		with(annexInstance.getDetections().get(1), detection -> {
			assertEquals("state4 -[error4]-> f4 !", detection.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().get(0))
					.getParsedAnnexSubclause()).getErrorDetections().get(1), detection.getDetection());
			assertEquals("state4", detection.getSource().getName());
			assertEquals("error4", detection.getCondition().getName());
			assertEquals("f4", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
		with(annexInstance.getDetections().get(2), detection -> {
			assertEquals("state5 -[]-> f5 !", detection.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().get(0))
					.getParsedAnnexSubclause()).getErrorDetections().get(2), detection.getDetection());
			assertEquals("state5", detection.getSource().getName());
			assertNull(detection.getCondition());
			assertEquals("f5", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
		with(annexInstance.getDetections().get(3), detection -> {
			assertEquals("state2 -[]-> f2 ! (\"two\")", detection.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(1)
					.getOwnedAnnexSubclauses()
					.get(0)).getParsedAnnexSubclause()).getErrorDetections().get(0), detection.getDetection());
			assertEquals("state2", detection.getSource().getName());
			assertNull(detection.getCondition());
			assertEquals("f2", detection.getDestination().getName());
			assertEquals("\"two\"", detection.getErrorCode().getName());
		});
		with(annexInstance.getDetections().get(4), detection -> {
			assertEquals("state1 -[error1]-> f1 ! (1)", detection.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)
					.getOwnedAnnexSubclauses()
					.get(0)).getParsedAnnexSubclause()).getErrorDetections().get(0), detection.getDetection());
			assertEquals("state1", detection.getSource().getName());
			assertEquals("error1", detection.getCondition().getName());
			assertEquals("f1", detection.getDestination().getName());
			assertEquals("1", detection.getErrorCode().getName());
		});
	}

	@Test
	public void testUntypedSource() throws Exception {
		var pkg = testHelper.parseFile(PATH + "untyped_source.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getDetections().size());
		with(annexInstance.getDetections().get(0), detection -> {
			assertEquals("detection1", detection.getName());
			assertEquals("detection1", detection.getDetection().getName());
			with((SourceStateReference) detection.getSource(), source -> {
				assertEquals("state1", source.getName());
				assertEquals("state1", source.getState().getName());
				assertNull(source.getTypeSet());
			});
			assertNull(detection.getCondition());
			assertEquals("f1", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
	}

	@Test
	public void testTypedSourceWithTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_source_with_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getDetections().size());
		with(annexInstance.getDetections().get(0), detection -> {
			assertEquals("detection1", detection.getName());
			assertEquals("detection1", detection.getDetection().getName());
			with((SourceStateReference) detection.getSource(), source -> {
				assertEquals("state1 {ServiceError}", source.getName());
				assertEquals("state1", source.getState().getName());
				assertEquals("{ServiceError}", source.getTypeSet().getName());
			});
			assertNull(detection.getCondition());
			assertEquals("f1", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
		with(annexInstance.getDetections().get(1), detection -> {
			assertEquals("detection2", detection.getName());
			assertEquals("detection2", detection.getDetection().getName());
			with((SourceStateReference) detection.getSource(), source -> {
				assertEquals("state2 {ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError}",
						source.getName());
				assertEquals("state2", source.getState().getName());
				assertEquals("{ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError}",
						source.getTypeSet().getName());
			});
			assertNull(detection.getCondition());
			assertEquals("f2", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
	}

	@Test
	public void testTypedSourceWithoutTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_source_without_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getDetections().size());
		with(annexInstance.getDetections().get(0), detection -> {
			assertEquals("detection1", detection.getName());
			assertEquals("detection1", detection.getDetection().getName());
			with((SourceStateReference) detection.getSource(), source -> {
				assertEquals("state1 {CommonErrors}", source.getName());
				assertEquals("state1", source.getState().getName());
				assertEquals("{CommonErrors}", source.getTypeSet().getName());
			});
			assertNull(detection.getCondition());
			assertEquals("f1", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
	}

	@Test
	public void testAllSources() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_sources.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getDetections().size());
		with(annexInstance.getDetections().get(0), detection -> {
			assertEquals("detection1", detection.getName());
			assertEquals("detection1", detection.getDetection().getName());
			with((AllSources) detection.getSource(), source -> {
				assertEquals("all", source.getName());
			});
			assertNull(detection.getCondition());
			assertEquals("f1", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
	}

	@Test
	public void testConditionExpression() throws Exception {
		var pkg = testHelper.parseFile(PATH + "condition_expression.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getDetections().size());
		with(annexInstance.getDetections().get(0), detection -> {
			assertEquals("complicated_condition_expression", detection.getName());
			assertEquals("complicated_condition_expression", detection.getDetection().getName());
			assertEquals("state3", detection.getSource().getName());
			with((CountExpression) detection.getCondition(), condition -> {
				assertEquals("count(f4 {ItemTimingError}, f5 {noerror}) == 2", condition.getName());
				assertEquals(2, condition.getOperands().size());
				with((ConditionPropagationReference) condition.getOperands().get(0), operand -> {
					assertEquals("f4 {ItemTimingError}", operand.getName());
					assertEquals("f4", operand.getPropagation().getName());
					assertEquals("{ItemTimingError}", operand.getTypeSet().getName());
				});
				with((NoErrorPropagationReference) condition.getOperands().get(1), operand -> {
					assertEquals("f5 {noerror}", operand.getName());
					assertEquals("f5", operand.getPropagation().getName());
				});
				assertEquals(CountExpressionOperation.EQUALS, condition.getOperation());
				assertEquals(2, condition.getCount());
			});
			assertEquals("f3", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
		with(annexInstance.getDetections().get(1), detection -> {
			assertEquals("no_condition_expression", detection.getName());
			assertEquals("no_condition_expression", detection.getDetection().getName());
			assertEquals("state1", detection.getSource().getName());
			assertNull(detection.getCondition());
			assertEquals("f1", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
		with(annexInstance.getDetections().get(2), detection -> {
			assertEquals("simple_condition_expression", detection.getName());
			assertEquals("simple_condition_expression", detection.getDetection().getName());
			assertEquals("state2", detection.getSource().getName());
			with((EventReference) detection.getCondition(), condition -> {
				assertEquals("error1", condition.getName());
				assertEquals("error1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
			assertEquals("f2", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
	}

	@Test
	public void testFeatureDestination() throws Exception {
		var pkg = testHelper.parseFile(PATH + "feature_destination.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getDetections().size());
		with(annexInstance.getDetections().get(0), detection -> {
			assertEquals("detection1", detection.getName());
			assertEquals("detection1", detection.getDetection().getName());
			assertEquals("state1", detection.getSource().getName());
			assertNull(detection.getCondition());
			assertEquals("f1", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
		with(annexInstance.getDetections().get(1), detection -> {
			assertEquals("detection2", detection.getName());
			assertEquals("detection2", detection.getDetection().getName());
			assertEquals("state2", detection.getSource().getName());
			assertNull(detection.getCondition());
			assertEquals("f2", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
		with(annexInstance.getDetections().get(2), detection -> {
			assertEquals("detection3", detection.getName());
			assertEquals("detection3", detection.getDetection().getName());
			assertEquals("state3", detection.getSource().getName());
			assertNull(detection.getCondition());
			assertEquals("f3", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
	}

	@Test
	public void testInternalFeatureDestination() throws Exception {
		var pkg = testHelper.parseFile(PATH + "internal_feature_destination.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		// Tests that detections which point to internal features are not instantiated.
		assertEquals(0, annexInstance.getDetections().size());
	}

	@Test
	public void testErrorCodes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_codes.aadl", PATH + "my_set.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(4, annexInstance.getDetections().size());
		with(annexInstance.getDetections().get(0), detection -> {
			assertEquals("detection1", detection.getName());
			assertEquals("detection1", detection.getDetection().getName());
			assertEquals("state1", detection.getSource().getName());
			assertNull(detection.getCondition());
			assertEquals("f1", detection.getDestination().getName());
			assertNull(detection.getErrorCode());
		});
		with(annexInstance.getDetections().get(1), detection -> {
			assertEquals("detection2", detection.getName());
			assertEquals("detection2", detection.getDetection().getName());
			assertEquals("state2", detection.getSource().getName());
			assertNull(detection.getCondition());
			assertEquals("f2", detection.getDestination().getName());
			with((IntegerCode) detection.getErrorCode(), code -> {
				assertEquals("42", code.getName());
				assertEquals(42, code.getCode());
			});
		});
		with(annexInstance.getDetections().get(2), detection -> {
			assertEquals("detection3", detection.getName());
			assertEquals("detection3", detection.getDetection().getName());
			assertEquals("state3", detection.getSource().getName());
			assertNull(detection.getCondition());
			assertEquals("f3", detection.getDestination().getName());
			with((StringCode) detection.getErrorCode(), code -> {
				assertEquals("\"string literal\"", code.getName());
				assertEquals("string literal", code.getCode());
			});
		});
		with(annexInstance.getDetections().get(3), detection -> {
			assertEquals("detection4", detection.getName());
			assertEquals("detection4", detection.getDetection().getName());
			assertEquals("state4", detection.getSource().getName());
			assertNull(detection.getCondition());
			assertEquals("f4", detection.getDestination().getName());
			with((ConstantCode) detection.getErrorCode(), code -> {
				assertEquals("my_set::my_constant", code.getName());
				assertEquals("my_constant", code.getCode().getName());
			});
		});
	}

	@Test
	public void testInternalFEatureCondition() throws Exception {
		var pkg = testHelper.parseFile(PATH + "internal_feature_condition.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		// Tests that detections which point to propagations which point to internal features are not instantiated.
		assertEquals(0, annexInstance.getDetections().size());
	}
}