package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.AllSources;
import org.osate.aadl2.errormodel.instance.ConditionPropagationReference;
import org.osate.aadl2.errormodel.instance.CountExpression;
import org.osate.aadl2.errormodel.instance.CountExpressionOperation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EventReference;
import org.osate.aadl2.errormodel.instance.NoErrorPropagationReference;
import org.osate.aadl2.errormodel.instance.SourceStateReference;
import org.osate.aadl2.errormodel.instance.instantiator.EMV2AnnexInstantiator;
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

	@BeforeAll
	public static void enableEMV2Instantiator() {
		System.setProperty(EMV2AnnexInstantiator.PROPERTY_NAME, "true");
	}

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
		});
	}

	@Test
	public void testInheritUnnamedDetections() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherit_unnamed_detections.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getDetections().size());
		with(annexInstance.getDetections().get(0), detection -> {
			// TODO Update after we generate names for unnamed detections.
			assertNull(detection.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().get(0))
					.getParsedAnnexSubclause()).getErrorDetections().get(0), detection.getDetection());
			assertEquals("state3", detection.getSource().getName());
			assertNull(detection.getCondition());
		});
		with(annexInstance.getDetections().get(1), detection -> {
			// TODO Update after we generate names for unnamed detections.
			assertNull(detection.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(1)
					.getOwnedAnnexSubclauses()
					.get(0)).getParsedAnnexSubclause()).getErrorDetections().get(0), detection.getDetection());
			assertEquals("state2", detection.getSource().getName());
			assertNull(detection.getCondition());
		});
		with(annexInstance.getDetections().get(2), detection -> {
			// TODO Update after we generate names for unnamed detections.
			assertNull(detection.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)
					.getOwnedAnnexSubclauses()
					.get(0)).getParsedAnnexSubclause()).getErrorDetections().get(0), detection.getDetection());
			assertEquals("state1", detection.getSource().getName());
			assertNull(detection.getCondition());
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
		});
		with(annexInstance.getDetections().get(1), detection -> {
			assertEquals("no_condition_expression", detection.getName());
			assertEquals("no_condition_expression", detection.getDetection().getName());
			assertEquals("state1", detection.getSource().getName());
			assertNull(detection.getCondition());
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
		});
	}
}