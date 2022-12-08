package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.Property;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.instantiator.EMV2AnnexInstantiator;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class PropertiesTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/Properties/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@BeforeAll
	public static void enableEMV2Instantiator() {
		System.setProperty(EMV2AnnexInstantiator.PROPERTY_NAME, "true");
	}

	@Test
	public void testSimpleBooleanOnSink() throws Exception {
		var pkg = testHelper.parseFile(PATH + "simple_boolean_on_sink.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);

		Property booleanForAll = Aadl2GlobalScopeUtil.get(sink, Aadl2Package.eINSTANCE.getProperty(),
				"ps::boolean_for_all");
		assertTrue(((BooleanLiteral) sink.getSimplePropertyValue(booleanForAll)).getValue());

		Property booleanForErrorFlow = Aadl2GlobalScopeUtil.get(sink, Aadl2Package.eINSTANCE.getProperty(),
				"ps::boolean_for_error_flow");
		assertTrue(((BooleanLiteral) sink.getSimplePropertyValue(booleanForErrorFlow)).getValue());

		Property booleanForErrorSink = Aadl2GlobalScopeUtil.get(sink, Aadl2Package.eINSTANCE.getProperty(),
				"ps::boolean_for_error_sink");
		assertTrue(((BooleanLiteral) sink.getSimplePropertyValue(booleanForErrorSink)).getValue());
	}
}