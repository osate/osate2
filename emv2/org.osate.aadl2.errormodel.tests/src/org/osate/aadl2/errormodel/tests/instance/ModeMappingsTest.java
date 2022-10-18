package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
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
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.instantiator.EMV2AnnexInstantiator;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

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
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) ((SystemType) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)).getOwnedAnnexSubclauses().get(0)).getParsedAnnexSubclause()).getErrorStateToModeMappings()
					.get(0), modeMapping.getModeMapping());
			assertEquals("state1", modeMapping.getState().getName());
			assertNull(modeMapping.getTypeSet());
			assertIterableEquals(List.of("m1"), modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
		with(annexInstance.getModeMappings().get(1), modeMapping -> {
			assertEquals("state2 in modes (m2, m3, m4)", modeMapping.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) ((SystemType) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)).getOwnedAnnexSubclauses().get(0)).getParsedAnnexSubclause()).getErrorStateToModeMappings()
					.get(1), modeMapping.getModeMapping());
			assertEquals("state2", modeMapping.getState().getName());
			assertNull(modeMapping.getTypeSet());
			assertIterableEquals(List.of("m2", "m3", "m4"),
					modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
	}

	@Test
	public void testTypedSourceWithTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_source_with_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getModeMappings().size());
		with(annexInstance.getModeMappings().get(0), modeMapping -> {
			assertEquals("state1 {ServiceError} in modes (m1)", modeMapping.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) ((SystemType) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)).getOwnedAnnexSubclauses().get(0)).getParsedAnnexSubclause()).getErrorStateToModeMappings()
					.get(0), modeMapping.getModeMapping());
			assertEquals("state1", modeMapping.getState().getName());
			assertEquals("{ServiceError}", modeMapping.getTypeSet().getName());
			assertIterableEquals(List.of("m1"), modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
		with(annexInstance.getModeMappings().get(1), modeMapping -> {
			assertEquals(
					"state2 {ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError} in modes (m2)",
					modeMapping.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) ((SystemType) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)).getOwnedAnnexSubclauses().get(0)).getParsedAnnexSubclause()).getErrorStateToModeMappings()
					.get(1), modeMapping.getModeMapping());
			assertEquals("state2", modeMapping.getState().getName());
			assertEquals("{ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError}",
					modeMapping.getTypeSet().getName());
			assertIterableEquals(List.of("m2"), modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
	}

	@Test
	public void testTypedSourceWithoutTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_source_without_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getModeMappings().size());
		with(annexInstance.getModeMappings().get(0), modeMapping -> {
			assertEquals("state1 {CommonErrors} in modes (m1)", modeMapping.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) ((SystemType) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)).getOwnedAnnexSubclauses().get(0)).getParsedAnnexSubclause()).getErrorStateToModeMappings()
					.get(0), modeMapping.getModeMapping());
			assertEquals("state1", modeMapping.getState().getName());
			assertEquals("{CommonErrors}", modeMapping.getTypeSet().getName());
			assertIterableEquals(List.of("m1"), modeMapping.getModes().stream().map(NamedElement::getName).toList());
		});
	}
}