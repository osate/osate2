package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.osate.testsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.AccessPropagation;
import org.osate.aadl2.errormodel.instance.BindingPropagation;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.FeaturePropagation;
import org.osate.aadl2.errormodel.instance.PointPropagation;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class PropagationTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/Propagations/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testAccessPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "access_propagation_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagations().size());
		with((AccessPropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("access", propagation.getName());
			assertEquals(DirectionType.OUT, propagation.getDirection());
			assertNull(propagation.getInErrorPropagation());
			assertNull(propagation.getInTypeSet());
			assertEquals("access", propagation.getOutErrorPropagation().getKind());
			assertEquals("{ServiceError}", propagation.getOutTypeSet().getName());
		});
	}

	@Test
	public void testBindingReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "binding_reference_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(5, annexInstance.getPropagations().size());
		with((BindingPropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("processor", propagation.getName());
			assertEquals(BindingType.PROCESSOR, propagation.getBinding());
			assertEquals(DirectionType.OUT, propagation.getDirection());
			assertNull(propagation.getInErrorPropagation());
			assertNull(propagation.getInTypeSet());
			assertEquals("processor", propagation.getOutErrorPropagation().getKind());
			assertEquals("{ServiceError}", propagation.getOutTypeSet().getName());
		});
		with((BindingPropagation) annexInstance.getPropagations().get(1), propagation -> {
			assertEquals("memory", propagation.getName());
			assertEquals(BindingType.MEMORY, propagation.getBinding());
			assertEquals(DirectionType.OUT, propagation.getDirection());
			assertNull(propagation.getInErrorPropagation());
			assertNull(propagation.getInTypeSet());
			assertEquals("memory", propagation.getOutErrorPropagation().getKind());
			assertEquals("{ServiceError}", propagation.getOutTypeSet().getName());
		});
		with((BindingPropagation) annexInstance.getPropagations().get(2), propagation -> {
			assertEquals("connection", propagation.getName());
			assertEquals(BindingType.CONNECTION, propagation.getBinding());
			assertEquals(DirectionType.OUT, propagation.getDirection());
			assertNull(propagation.getInErrorPropagation());
			assertNull(propagation.getInTypeSet());
			assertEquals("connection", propagation.getOutErrorPropagation().getKind());
			assertEquals("{ServiceError}", propagation.getOutTypeSet().getName());
		});
		with((BindingPropagation) annexInstance.getPropagations().get(3), propagation -> {
			assertEquals("binding", propagation.getName());
			assertEquals(BindingType.BINDING, propagation.getBinding());
			assertEquals(DirectionType.OUT, propagation.getDirection());
			assertNull(propagation.getInErrorPropagation());
			assertNull(propagation.getInTypeSet());
			assertEquals("binding", propagation.getOutErrorPropagation().getKind());
			assertEquals("{ServiceError}", propagation.getOutTypeSet().getName());
		});
		with((BindingPropagation) annexInstance.getPropagations().get(4), propagation -> {
			assertEquals("bindings", propagation.getName());
			assertEquals(BindingType.BINDINGS, propagation.getBinding());
			assertEquals(DirectionType.OUT, propagation.getDirection());
			assertNull(propagation.getInErrorPropagation());
			assertNull(propagation.getInTypeSet());
			assertEquals("bindings", propagation.getOutErrorPropagation().getKind());
			assertEquals("{ServiceError}", propagation.getOutTypeSet().getName());
		});
	}

	@Test
	public void testFeatureReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "feature_reference_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(4, annexInstance.getPropagations().size());
		with((FeaturePropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f1", propagation.getName());
			assertEquals("f1", propagation.getFeature().getName());
			assertEquals(DirectionType.OUT, propagation.getDirection());
			assertNull(propagation.getInErrorPropagation());
			assertNull(propagation.getInTypeSet());
			assertEquals("f1",
					((AbstractFeature) propagation.getOutErrorPropagation().getFeatureorPPRef().getFeatureorPP())
							.getName());
			assertEquals("{ServiceError}", propagation.getOutTypeSet().getName());
		});
		with((FeaturePropagation) annexInstance.getPropagations().get(1), propagation -> {
			assertEquals("fg1.f2", propagation.getName());
			assertEquals("f2", propagation.getFeature().getName());
			assertEquals(DirectionType.OUT, propagation.getDirection());
			assertNull(propagation.getInErrorPropagation());
			assertNull(propagation.getInTypeSet());
			assertEquals("f2",
					((AbstractFeature) propagation.getOutErrorPropagation()
							.getFeatureorPPRef()
							.getNext()
							.getFeatureorPP()).getName());
			assertEquals("{ServiceError}", propagation.getOutTypeSet().getName());
		});
		with((FeaturePropagation) annexInstance.getPropagations().get(2), propagation -> {
			assertEquals("fg1.fg2.f3", propagation.getName());
			assertEquals("f3", propagation.getFeature().getName());
			assertEquals(DirectionType.OUT, propagation.getDirection());
			assertNull(propagation.getInErrorPropagation());
			assertNull(propagation.getInTypeSet());
			assertEquals("f3",
					((AbstractFeature) propagation.getOutErrorPropagation()
							.getFeatureorPPRef()
							.getNext()
							.getNext()
							.getFeatureorPP()).getName());
			assertEquals("{ServiceError}", propagation.getOutTypeSet().getName());
		});
		with((FeaturePropagation) annexInstance.getPropagations().get(3), propagation -> {
			assertEquals("fg1.fg2.fg3.f4", propagation.getName());
			assertEquals("f4", propagation.getFeature().getName());
			assertEquals(DirectionType.OUT, propagation.getDirection());
			assertNull(propagation.getInErrorPropagation());
			assertNull(propagation.getInTypeSet());
			assertEquals("f4",
					((AbstractFeature) propagation.getOutErrorPropagation()
							.getFeatureorPPRef()
							.getNext()
							.getNext()
							.getNext()
							.getFeatureorPP()).getName());
			assertEquals("{ServiceError}", propagation.getOutTypeSet().getName());
		});
	}

	@Test
	public void testPointReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "point_reference_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagations().size());
		with((PointPropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("point1", propagation.getName());
			assertEquals("point1", propagation.getPoint().getName());
			assertEquals(DirectionType.OUT, propagation.getDirection());
			assertNull(propagation.getInErrorPropagation());
			assertNull(propagation.getInTypeSet());
			assertEquals("point1",
					((PropagationPoint) propagation.getOutErrorPropagation().getFeatureorPPRef().getFeatureorPP())
							.getName());
			assertEquals("{ServiceError}", propagation.getOutTypeSet().getName());
		});
	}

	@Test
	public void testInternalFeatureReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "internal_feature_reference_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		// Tests that propagations which point to internal features are not instantiated.
		assertEquals(0, annexInstance.getPropagations().size());
	}

	@Test
	public void testContainment() throws Exception {
		var pkg = testHelper.parseFile(PATH + "containment_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		// Tests that error containments are not instantiated.
		assertEquals(0, annexInstance.getPropagations().size());
	}

	@Test
	public void testInPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "in_propagation_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagations().size());
		with((FeaturePropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals("f", propagation.getFeature().getName());
			assertEquals(DirectionType.IN, propagation.getDirection());
			assertEquals("f",
					((AbstractFeature) propagation.getInErrorPropagation().getFeatureorPPRef().getFeatureorPP())
							.getName());
			assertEquals("{ServiceError}", propagation.getInTypeSet().getName());
			assertNull(propagation.getOutErrorPropagation());
			assertNull(propagation.getOutTypeSet());
		});
	}

	@Test
	public void testInOutPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "in_out_propagation_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(4, annexInstance.getPropagations().size());
		with((FeaturePropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals("f", propagation.getFeature().getName());
			assertEquals(DirectionType.IN_OUT, propagation.getDirection());
			assertEquals("f",
					((AbstractFeature) propagation.getInErrorPropagation().getFeatureorPPRef().getFeatureorPP())
							.getName());
			assertEquals("{ServiceError}", propagation.getInTypeSet().getName());
			assertEquals("f",
					((AbstractFeature) propagation.getOutErrorPropagation().getFeatureorPPRef().getFeatureorPP())
							.getName());
			assertEquals("{ItemValueError}", propagation.getOutTypeSet().getName());
		});
		with((PointPropagation) annexInstance.getPropagations().get(1), propagation -> {
			assertEquals("point1", propagation.getName());
			assertEquals("point1", propagation.getPoint().getName());
			assertEquals(DirectionType.IN_OUT, propagation.getDirection());
			assertEquals("point1",
					((PropagationPoint) propagation.getInErrorPropagation().getFeatureorPPRef().getFeatureorPP())
							.getName());
			assertEquals("{ServiceError}", propagation.getInTypeSet().getName());
			assertEquals("point1",
					((PropagationPoint) propagation.getOutErrorPropagation().getFeatureorPPRef().getFeatureorPP())
							.getName());
			assertEquals("{ItemValueError}", propagation.getOutTypeSet().getName());
		});
		with((AccessPropagation) annexInstance.getPropagations().get(2), propagation -> {
			assertEquals("access", propagation.getName());
			assertEquals(DirectionType.IN_OUT, propagation.getDirection());
			assertEquals("access", propagation.getInErrorPropagation().getKind());
			assertEquals("{ServiceError}", propagation.getInTypeSet().getName());
			assertEquals("ACCESS", propagation.getOutErrorPropagation().getKind());
			assertEquals("{ItemValueError}", propagation.getOutTypeSet().getName());
		});
		with((BindingPropagation) annexInstance.getPropagations().get(3), propagation -> {
			assertEquals("processor", propagation.getName());
			assertEquals(BindingType.PROCESSOR, propagation.getBinding());
			assertEquals(DirectionType.IN_OUT, propagation.getDirection());
			assertEquals("processor", propagation.getInErrorPropagation().getKind());
			assertEquals("{ServiceError}", propagation.getInTypeSet().getName());
			assertEquals("PROCESSOR", propagation.getOutErrorPropagation().getKind());
			assertEquals("{ItemValueError}", propagation.getOutTypeSet().getName());
		});
	}

	@Test
	public void testOverriddenPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "overridden_propagation_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagations().size());
		with((FeaturePropagation) annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals("f", propagation.getFeature().getName());
			assertEquals(DirectionType.OUT, propagation.getDirection());
			assertNull(propagation.getInErrorPropagation());
			assertNull(propagation.getInTypeSet());
			assertEquals("f",
					((AbstractFeature) propagation.getOutErrorPropagation().getFeatureorPPRef().getFeatureorPP())
							.getName());
			assertEquals("{ItemTimingError}", propagation.getOutTypeSet().getName());
		});
	}
}