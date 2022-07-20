package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.instantiator.EMV2AnnexInstantiator;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;

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
		});
		with(annexInstance.getDetections().get(1), detection -> {
			// TODO Update after we generate names for unnamed detections.
			assertNull(detection.getName());
		});
		with(annexInstance.getDetections().get(2), detection -> {
			// TODO Update after we generate names for unnamed detections.
			assertNull(detection.getName());
		});
	}
}