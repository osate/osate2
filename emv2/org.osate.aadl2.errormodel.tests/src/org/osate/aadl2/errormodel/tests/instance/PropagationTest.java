package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertEquals;
import static org.osate.testsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.BindingReference;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.FeatureReference;
import org.osate.aadl2.errormodel.instance.PointReference;
import org.osate.aadl2.errormodel.instance.TypeReference;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class PropagationTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/Propagations/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testBindingReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "binding_reference_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(0, annexInstance.getInPropagations().size());
		assertEquals(6, annexInstance.getOutPropagations().size());
		with((BindingReference) annexInstance.getOutPropagations().get(0), propagation -> {
			assertEquals("processor", propagation.getName());
			assertEquals(BindingType.PROCESSOR, propagation.getBinding());
			assertEquals("processor", propagation.getErrorPropagation().getKind());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ServiceError", ((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
		with((BindingReference) annexInstance.getOutPropagations().get(1), propagation -> {
			assertEquals("memory", propagation.getName());
			assertEquals(BindingType.MEMORY, propagation.getBinding());
			assertEquals("memory", propagation.getErrorPropagation().getKind());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ServiceError", ((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
		with((BindingReference) annexInstance.getOutPropagations().get(2), propagation -> {
			assertEquals("connection", propagation.getName());
			assertEquals(BindingType.CONNECTION, propagation.getBinding());
			assertEquals("connection", propagation.getErrorPropagation().getKind());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ServiceError", ((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
		with((BindingReference) annexInstance.getOutPropagations().get(3), propagation -> {
			assertEquals("binding", propagation.getName());
			assertEquals(BindingType.BINDING, propagation.getBinding());
			assertEquals("binding", propagation.getErrorPropagation().getKind());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ServiceError", ((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
		with((BindingReference) annexInstance.getOutPropagations().get(4), propagation -> {
			assertEquals("bindings", propagation.getName());
			assertEquals(BindingType.BINDINGS, propagation.getBinding());
			assertEquals("bindings", propagation.getErrorPropagation().getKind());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ServiceError", ((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
		with((BindingReference) annexInstance.getOutPropagations().get(5), propagation -> {
			assertEquals("access", propagation.getName());
			assertEquals(BindingType.ACCESS, propagation.getBinding());
			assertEquals("access", propagation.getErrorPropagation().getKind());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ServiceError", ((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
	}

	@Test
	public void testFeatureReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "feature_reference_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(0, annexInstance.getInPropagations().size());
		assertEquals(4, annexInstance.getOutPropagations().size());
		with((FeatureReference) annexInstance.getOutPropagations().get(0), propagation -> {
			assertEquals("f1", propagation.getName());
			assertEquals("f1", propagation.getFeature().getName());
			assertEquals("f1",
					((AbstractFeature) propagation.getErrorPropagation().getFeatureorPPRef().getFeatureorPP())
							.getName());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ServiceError", ((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
		with((FeatureReference) annexInstance.getOutPropagations().get(1), propagation -> {
			assertEquals("fg1.f2", propagation.getName());
			assertEquals("f2", propagation.getFeature().getName());
			assertEquals("f2",
					((AbstractFeature) propagation.getErrorPropagation().getFeatureorPPRef().getNext().getFeatureorPP())
							.getName());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ServiceError", ((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
		with((FeatureReference) annexInstance.getOutPropagations().get(2), propagation -> {
			assertEquals("fg1.fg2.f3", propagation.getName());
			assertEquals("f3", propagation.getFeature().getName());
			assertEquals("f3",
					((AbstractFeature) propagation.getErrorPropagation()
							.getFeatureorPPRef()
							.getNext()
							.getNext()
							.getFeatureorPP()).getName());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ServiceError", ((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
		with((FeatureReference) annexInstance.getOutPropagations().get(3), propagation -> {
			assertEquals("fg1.fg2.fg3.f4", propagation.getName());
			assertEquals("f4", propagation.getFeature().getName());
			assertEquals("f4",
					((AbstractFeature) propagation.getErrorPropagation()
							.getFeatureorPPRef()
							.getNext()
							.getNext()
							.getNext()
							.getFeatureorPP()).getName());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ServiceError", ((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
	}

	@Test
	public void testPointReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "point_reference_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(0, annexInstance.getInPropagations().size());
		assertEquals(1, annexInstance.getOutPropagations().size());
		with((PointReference) annexInstance.getOutPropagations().get(0), propagation -> {
			assertEquals("point1", propagation.getName());
			assertEquals("point1", propagation.getPoint().getName());
			assertEquals("point1",
					((PropagationPoint) propagation.getErrorPropagation().getFeatureorPPRef().getFeatureorPP())
							.getName());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ServiceError", ((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
	}

	@Test
	public void testInternalFeatureReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "internal_feature_reference_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		// Tests that propagations which point to internal features are not instantiated.
		assertEquals(0, annexInstance.getInPropagations().size());
		assertEquals(0, annexInstance.getOutPropagations().size());
	}

	@Test
	public void testContainment() throws Exception {
		var pkg = testHelper.parseFile(PATH + "containment_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		// Tests that error containments are not instantiated.
		assertEquals(0, annexInstance.getInPropagations().size());
		assertEquals(0, annexInstance.getOutPropagations().size());
	}

	@Test
	public void testInPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "in_propagation_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getInPropagations().size());
		assertEquals(0, annexInstance.getOutPropagations().size());
		with((FeatureReference) annexInstance.getInPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals("f", propagation.getFeature().getName());
			assertEquals("f", ((AbstractFeature) propagation.getErrorPropagation().getFeatureorPPRef().getFeatureorPP())
					.getName());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ServiceError", ((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
	}

	@Test
	public void testInOutPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "in_out_propagation_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getInPropagations().size());
		assertEquals(1, annexInstance.getOutPropagations().size());
		with((FeatureReference) annexInstance.getInPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals("f", propagation.getFeature().getName());
			assertEquals("f", ((AbstractFeature) propagation.getErrorPropagation().getFeatureorPPRef().getFeatureorPP())
					.getName());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ServiceError", ((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
		with((FeatureReference) annexInstance.getOutPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals("f", propagation.getFeature().getName());
			assertEquals("f", ((AbstractFeature) propagation.getErrorPropagation().getFeatureorPPRef().getFeatureorPP())
					.getName());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ItemValueError",
					((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
	}

	@Test
	public void testOverriddenPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "overridden_propagation_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(0, annexInstance.getInPropagations().size());
		assertEquals(1, annexInstance.getOutPropagations().size());
		with((FeatureReference) annexInstance.getOutPropagations().get(0), propagation -> {
			assertEquals("f", propagation.getName());
			assertEquals("f", propagation.getFeature().getName());
			assertEquals("f", ((AbstractFeature) propagation.getErrorPropagation().getFeatureorPPRef().getFeatureorPP())
					.getName());
			assertEquals(1, propagation.getTokens().size());
			assertEquals("ItemTimingError",
					((TypeReference) propagation.getTokens().get(0)).getDeclaredType().getName());
		});
	}
}