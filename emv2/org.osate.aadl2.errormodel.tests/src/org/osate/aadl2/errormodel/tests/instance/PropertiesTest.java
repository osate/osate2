package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.osate.pluginsupport.ScopeFunctions.with;

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
import org.osate.aadl2.errormodel.instance.ErrorPathInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
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

	@Test
	public void testLookupOnSinkFromImplExtension() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_sink_from_impl_extension.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(3);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);

		assertEquals(6, sink.getOwnedPropertyAssociations().size());
		assertEquals("Value in s.i1", ((StringLiteral) lookup(sink, "ps::string1")).getValue());
		assertEquals("Value in s.i2", ((StringLiteral) lookup(sink, "ps::string2")).getValue());
		assertEquals("Value in s.i3", ((StringLiteral) lookup(sink, "ps::string3")).getValue());
		assertEquals("Value in s.i2 overrides value in s.i1", ((StringLiteral) lookup(sink, "ps::string4")).getValue());
		assertEquals("Value in s.i3 overrides value in s.i2", ((StringLiteral) lookup(sink, "ps::string5")).getValue());
		assertEquals("Value in s.i3 overrides value in s.i2 and s.i1",
				((StringLiteral) lookup(sink, "ps::string6")).getValue());
	}

	@Test
	public void testLookupOnSinkFromTypeAndImpl() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_sink_from_type_and_impl.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(3);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);

		assertEquals(7, sink.getOwnedPropertyAssociations().size());
		assertEquals("Value in s1", ((StringLiteral) lookup(sink, "ps::string1")).getValue());
		assertEquals("Value in s2", ((StringLiteral) lookup(sink, "ps::string2")).getValue());
		assertEquals("Value in s1.i", ((StringLiteral) lookup(sink, "ps::string3")).getValue());
		assertEquals("Value in s2.i", ((StringLiteral) lookup(sink, "ps::string4")).getValue());
		assertEquals("Value in s1.i overrides value in s1", ((StringLiteral) lookup(sink, "ps::string5")).getValue());
		assertEquals("Value in s2.i overrides value in s2", ((StringLiteral) lookup(sink, "ps::string6")).getValue());
		assertEquals("Value in s1.i overrides value in s2", ((StringLiteral) lookup(sink, "ps::string7")).getValue());
	}

	@Test
	public void testLookupOnSinkFromContainer() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_sink_from_container.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		var inner = systemInstance.getComponentInstances().get(0).getComponentInstances().get(0);
		var annexInstance = (EMV2AnnexInstance) inner.getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);

		assertEquals(6, sink.getOwnedPropertyAssociations().size());
		assertEquals("Value in inner", ((StringLiteral) lookup(sink, "ps::string1")).getValue());
		assertEquals("Value in middle.i", ((StringLiteral) lookup(sink, "ps::string2")).getValue());
		assertEquals("Value in outer.i", ((StringLiteral) lookup(sink, "ps::string3")).getValue());
		assertEquals("Value in middle.i overrides value in inner",
				((StringLiteral) lookup(sink, "ps::string4")).getValue());
		assertEquals("Value in outer.i overrides value in middle.i",
				((StringLiteral) lookup(sink, "ps::string5")).getValue());
		assertEquals("Value in outer.i overrides value in middle.i and inner",
				((StringLiteral) lookup(sink, "ps::string6")).getValue());
	}

	@Test
	public void testCheckContainmentPath() throws Exception {
		var pkg = testHelper.parseFile(PATH + "check_containment_path.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var systemInstance = InstantiateModel.instantiate(system);
		with(systemInstance.getComponentInstances().get(0), middle1 -> {
			with(middle1.getComponentInstances().get(0), inner1 -> {
				var annexInstance = (EMV2AnnexInstance) inner1.getAnnexInstances().get(0);
				var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);

				assertEquals(1, sink.getOwnedPropertyAssociations().size());
				assertEquals("Value on inner1.sink1, but not inner2.sink1",
						((StringLiteral) lookup(sink, "ps::string1")).getValue());
			});
			with(middle1.getComponentInstances().get(1), inner2 -> {
				var annexInstance = (EMV2AnnexInstance) inner2.getAnnexInstances().get(0);
				var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);

				assertEquals(0, sink.getOwnedPropertyAssociations().size());
			});
		});
		with(systemInstance.getComponentInstances().get(1), middle2 -> {
			with(middle2.getComponentInstances().get(0), inner1 -> {
				var annexInstance = (EMV2AnnexInstance) inner1.getAnnexInstances().get(0);
				var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);

				assertEquals(2, sink.getOwnedPropertyAssociations().size());
				assertEquals("Value on inner1.sink1, but not inner2.sink1",
						((StringLiteral) lookup(sink, "ps::string1")).getValue());
				assertEquals("Value on middle2.inner1.sink1, but not others",
						((StringLiteral) lookup(sink, "ps::string2")).getValue());
			});
			with(middle2.getComponentInstances().get(1), inner2 -> {
				var annexInstance = (EMV2AnnexInstance) inner2.getAnnexInstances().get(0);
				var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);

				assertEquals(0, sink.getOwnedPropertyAssociations().size());
			});
		});
	}

	@Test
	public void testLookupOnSinkFromContainerWithExtension() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_sink_from_container_with_extension.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		var systemInstance = InstantiateModel.instantiate(system);
		var inner = systemInstance.getComponentInstances().get(0);
		var annexInstance = (EMV2AnnexInstance) inner.getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);

		assertEquals(3, sink.getOwnedPropertyAssociations().size());
		assertEquals("Value in outer.i1", ((StringLiteral) lookup(sink, "ps::string1")).getValue());
		assertEquals("Value in outer.i2", ((StringLiteral) lookup(sink, "ps::string2")).getValue());
		assertEquals("Value in outer.i2 overrides value in outer.i1",
				((StringLiteral) lookup(sink, "ps::string3")).getValue());
	}

	@Test
	public void testCheckTarget() throws Exception {
		var pkg = testHelper.parseFile(PATH + "check_target.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);

		with((ErrorSinkInstance) annexInstance.getErrorFlows().get(0), sink1 -> {
			assertEquals(1, sink1.getOwnedPropertyAssociations().size());
			assertEquals("Value on sink1, but not sink2", ((StringLiteral) lookup(sink1, "ps::string1")).getValue());
		});
		with((ErrorSinkInstance) annexInstance.getErrorFlows().get(1), sink2 -> {
			assertEquals(0, sink2.getOwnedPropertyAssociations().size());
		});
	}

	@Test
	public void testPropertiesOnPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_propagation.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);

		assertEquals(8, annexInstance.getPropagations().size());
		with(annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f1", propagation.getName());
			assertEquals(3, propagation.getOwnedPropertyAssociations().size());
			assertTrue(((BooleanLiteral) lookup(propagation, "ps::boolean_for_all")).getValue());
			assertTrue(((BooleanLiteral) lookup(propagation, "ps::boolean_for_propagation")).getValue());
			assertEquals("Value on in propagation", ((StringLiteral) lookup(propagation, "ps::string1")).getValue());
		});
		with(annexInstance.getPropagations().get(1), propagation -> {
			assertEquals("f2", propagation.getName());
			assertEquals(1, propagation.getOwnedPropertyAssociations().size());
			assertEquals("Value on out propagation", ((StringLiteral) lookup(propagation, "ps::string1")).getValue());
		});
		with(annexInstance.getPropagations().get(2), propagation -> {
			assertEquals("f3", propagation.getName());
			assertEquals(1, propagation.getOwnedPropertyAssociations().size());
			assertEquals("Value on in and out propagation",
					((StringLiteral) lookup(propagation, "ps::string1")).getValue());
		});
		with(annexInstance.getPropagations().get(3), propagation -> {
			assertEquals("fg1.f4", propagation.getName());
			assertEquals(1, propagation.getOwnedPropertyAssociations().size());
			assertEquals("Value on propagation in feature group",
					((StringLiteral) lookup(propagation, "ps::string1")).getValue());
		});
		with(annexInstance.getPropagations().get(4), propagation -> {
			assertEquals("fg1.fg2.fg3.f5", propagation.getName());
			assertEquals(1, propagation.getOwnedPropertyAssociations().size());
			assertEquals("Value on propagation nested in feature group",
					((StringLiteral) lookup(propagation, "ps::string1")).getValue());
		});
		with(annexInstance.getPropagations().get(5), propagation -> {
			assertEquals("point1", propagation.getName());
			assertEquals(1, propagation.getOwnedPropertyAssociations().size());
			assertEquals("Value on point propagation", ((StringLiteral) lookup(propagation, "ps::string1")).getValue());
		});
		with(annexInstance.getPropagations().get(6), propagation -> {
			assertEquals("access", propagation.getName());
			assertEquals(1, propagation.getOwnedPropertyAssociations().size());
			assertEquals("Value on access propagation",
					((StringLiteral) lookup(propagation, "ps::string1")).getValue());
		});
		with(annexInstance.getPropagations().get(7), propagation -> {
			assertEquals("memory", propagation.getName());
			assertEquals(1, propagation.getOwnedPropertyAssociations().size());
			assertEquals("Value on binding propagation",
					((StringLiteral) lookup(propagation, "ps::string1")).getValue());
		});
	}

	@Test
	public void testPropertiesOnSource() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_source.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var source = (ErrorSourceInstance) annexInstance.getErrorFlows().get(0);

		assertEquals(3, source.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(source, "ps::boolean_for_all")).getValue());
		assertTrue(((BooleanLiteral) lookup(source, "ps::boolean_for_error_flow")).getValue());
		assertTrue(((BooleanLiteral) lookup(source, "ps::boolean_for_error_source")).getValue());
	}

	@Test
	public void testPropertiesOnPath() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_path.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var path = (ErrorPathInstance) annexInstance.getErrorFlows().get(0);

		assertEquals(3, path.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(path, "ps::boolean_for_all")).getValue());
		assertTrue(((BooleanLiteral) lookup(path, "ps::boolean_for_error_flow")).getValue());
		assertTrue(((BooleanLiteral) lookup(path, "ps::boolean_for_error_path")).getValue());
	}

	@Test
	public void testPropertiesOnPropagationPath() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_propagation_path.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var path = annexInstance.getPropagationPaths().get(0);

		assertEquals(2, path.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(path, "ps::boolean_for_all")).getValue());
		assertTrue(((BooleanLiteral) lookup(path, "ps::boolean_for_propagation_path")).getValue());
	}

	@Test
	public void testPropertiesOnState() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_state.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var state = annexInstance.getStates().get(0);

		assertEquals(5, state.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(state, "ps::boolean_for_all")).getValue());
		assertTrue(((BooleanLiteral) lookup(state, "ps::boolean_for_error_behavior_state")).getValue());
		assertEquals("Value in machine1", ((StringLiteral) lookup(state, "ps::string1")).getValue());
		assertEquals("Value in s", ((StringLiteral) lookup(state, "ps::string2")).getValue());
		assertEquals("Value in s overrides value in machine1",
				((StringLiteral) lookup(state, "ps::string3")).getValue());
	}

	private static PropertyExpression lookup(NamedElement holder, String name) {
		Property property = Aadl2GlobalScopeUtil.get(holder, Aadl2Package.eINSTANCE.getProperty(), name);
		return holder.getSimplePropertyValue(property);
	}
}