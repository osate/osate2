package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.StringLiteral;
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

		assertEquals(3, sink.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(sink, "ps::boolean_for_all")).getValue());
		assertTrue(((BooleanLiteral) lookup(sink, "ps::boolean_for_error_flow")).getValue());
		assertTrue(((BooleanLiteral) lookup(sink, "ps::boolean_for_error_sink")).getValue());
	}

	@Test
	public void testLookupOnSinkFromTypeExtension() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_sink_from_type_extension.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(3);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);

		assertEquals(6, sink.getOwnedPropertyAssociations().size());
		assertEquals("Value in s1", ((StringLiteral) lookup(sink, "ps::string1")).getValue());
		assertEquals("Value in s2", ((StringLiteral) lookup(sink, "ps::string2")).getValue());
		assertEquals("Value in s3", ((StringLiteral) lookup(sink, "ps::string3")).getValue());
		assertEquals("Value in s2 overrides value in s1", ((StringLiteral) lookup(sink, "ps::string4")).getValue());
		assertEquals("Value in s3 overrides value in s2", ((StringLiteral) lookup(sink, "ps::string5")).getValue());
		assertEquals("Value in s3 overrides value in s2 and s1",
				((StringLiteral) lookup(sink, "ps::string6")).getValue());
	}

	private static PropertyExpression lookup(NamedElement holder, String name) {
		Property property = Aadl2GlobalScopeUtil.get(holder, Aadl2Package.eINSTANCE.getProperty(), name);
		return holder.getSimplePropertyValue(property);
	}
}