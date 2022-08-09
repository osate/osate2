package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.instantiator.EMV2AnnexInstantiator;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class ModeMappingsTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/ModeMappings/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@BeforeAll
	public static void enableEMV2Instantiator() {
		System.setProperty(EMV2AnnexInstantiator.PROPERTY_NAME, "true");
	}

	@Test
	public void testUntypedSource() throws Exception {
		var pkg = testHelper.parseFile(PATH + "untyped_source.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getModeMappings().size());
		with(annexInstance.getModeMappings().get(0), modeMapping -> {
			assertEquals("state1 in modes (m1)", modeMapping.getName());
			assertEquals("state1", modeMapping.getState().getName());
			assertNull(modeMapping.getTypeSet());
			assertNull(modeMapping.getTypeToken());
			assertIterableEquals(List.of("m1"), modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
		with(annexInstance.getModeMappings().get(1), modeMapping -> {
			assertEquals("state2 in modes (m2, m3, m4)", modeMapping.getName());
			assertEquals("state2", modeMapping.getState().getName());
			assertNull(modeMapping.getTypeSet());
			assertNull(modeMapping.getTypeToken());
			assertIterableEquals(List.of("m2", "m3", "m4"),
					modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
	}

	@Test
	public void testTypedSource() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_source.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getModeMappings().size());
		with(annexInstance.getModeMappings().get(0), modeMapping -> {
			assertEquals("state1 {ServiceError} in modes (m1)", modeMapping.getName());
			assertEquals("state1", modeMapping.getState().getName());
			assertEquals("{ServiceError}", modeMapping.getTypeSet().getName());
			assertEquals("ServiceError", modeMapping.getTypeToken().getName());
			assertIterableEquals(List.of("m1"), modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
		with(annexInstance.getModeMappings().get(1), modeMapping -> {
			assertEquals("state2 {ItemTimingError * ConcurrencyError} in modes (m2)", modeMapping.getName());
			assertEquals("state2", modeMapping.getState().getName());
			assertEquals("{ItemTimingError * ConcurrencyError}", modeMapping.getTypeSet().getName());
			assertEquals("ItemTimingError * ConcurrencyError", modeMapping.getTypeToken().getName());
			assertIterableEquals(List.of("m2"), modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
	}
}