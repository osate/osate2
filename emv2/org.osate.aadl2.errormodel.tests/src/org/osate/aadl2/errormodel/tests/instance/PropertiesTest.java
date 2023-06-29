package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.osate.pluginsupport.ScopeFunctions.with;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.ErrorEventInstance;
import org.osate.aadl2.errormodel.instance.ErrorPathInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.aadl2.errormodel.instance.RecoverEventInstance;
import org.osate.aadl2.errormodel.instance.RepairEventInstance;
import org.osate.aadl2.errormodel.instance.TypeInstance;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceReferenceValue;
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

	@Test
	public void testPropertiesOnErrorEvent() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_error_event.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);

		assertEquals(2, annexInstance.getEvents().size());
		with((ErrorEventInstance) annexInstance.getEvents().get(0), error -> {
			assertEquals("error1", error.getName());
			assertEquals(6, error.getOwnedPropertyAssociations().size());
			assertTrue(((BooleanLiteral) lookup(error, "ps::boolean_for_all")).getValue());
			assertTrue(((BooleanLiteral) lookup(error, "ps::boolean_for_error_behavior_event")).getValue());
			assertTrue(((BooleanLiteral) lookup(error, "ps::boolean_for_error_event")).getValue());
			assertEquals("Value in machine1", ((StringLiteral) lookup(error, "ps::string1")).getValue());
			assertEquals("Value in s", ((StringLiteral) lookup(error, "ps::string2")).getValue());
			assertEquals("Value in s overrides value in machine1",
					((StringLiteral) lookup(error, "ps::string3")).getValue());
		});
		with((ErrorEventInstance) annexInstance.getEvents().get(1), error -> {
			assertEquals("error2", error.getName());
			assertEquals(1, error.getOwnedPropertyAssociations().size());
			assertEquals("Don't search in state machine for value",
					((StringLiteral) lookup(error, "ps::string1")).getValue());
		});
	}

	@Test
	public void testPropertiesOnRecoverEvent() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_recover_event.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var recover = (RecoverEventInstance) annexInstance.getEvents().get(0);

		assertEquals(3, recover.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(recover, "ps::boolean_for_all")).getValue());
		assertTrue(((BooleanLiteral) lookup(recover, "ps::boolean_for_error_behavior_event")).getValue());
		assertTrue(((BooleanLiteral) lookup(recover, "ps::boolean_for_recover_event")).getValue());
	}

	@Test
	public void testPropertiesOnRepairEvent() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_repair_event.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var repair = (RepairEventInstance) annexInstance.getEvents().get(0);

		assertEquals(3, repair.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(repair, "ps::boolean_for_all")).getValue());
		assertTrue(((BooleanLiteral) lookup(repair, "ps::boolean_for_error_behavior_event")).getValue());
		assertTrue(((BooleanLiteral) lookup(repair, "ps::boolean_for_repair_event")).getValue());
	}

	@Test
	public void testPropertiesOnTransition() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_transition.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var transition = annexInstance.getTransitions().get(0);

		assertEquals(2, transition.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(transition, "ps::boolean_for_all")).getValue());
		assertTrue(((BooleanLiteral) lookup(transition, "ps::boolean_for_error_behavior_transition")).getValue());
	}

	@Test
	public void testPropertiesOnCondition() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_condition.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var condition = annexInstance.getConditions().get(0);

		assertEquals(2, condition.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(condition, "ps::boolean_for_all")).getValue());
		assertTrue(((BooleanLiteral) lookup(condition, "ps::boolean_for_outgoing_propagation_condition")).getValue());
	}

	@Test
	public void testPropertiesOnDetection() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_detection.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var detection = annexInstance.getDetections().get(0);

		assertEquals(2, detection.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(detection, "ps::boolean_for_all")).getValue());
		assertTrue(((BooleanLiteral) lookup(detection, "ps::boolean_for_error_detection")).getValue());
	}

	@Test
	public void testPropertiesOnCompositeState() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_composite_state.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var composite = annexInstance.getComposites().get(0);

		assertEquals(2, composite.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(composite, "ps::boolean_for_all")).getValue());
		assertTrue(((BooleanLiteral) lookup(composite, "ps::boolean_for_composite_state")).getValue());
	}

	@Test
	public void testPropertiesOnSubclause() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_subclause.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(3);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);

		assertEquals(9, annexInstance.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(annexInstance, "ps::boolean_for_all")).getValue());
		assertTrue(((BooleanLiteral) lookup(annexInstance, "ps::boolean_for_error_model_subclause")).getValue());
		assertEquals("Value in s1", ((StringLiteral) lookup(annexInstance, "ps::string1")).getValue());
		assertEquals("Value in s2", ((StringLiteral) lookup(annexInstance, "ps::string2")).getValue());
		assertEquals("Value in s1.i", ((StringLiteral) lookup(annexInstance, "ps::string3")).getValue());
		assertEquals("Value in s2.i", ((StringLiteral) lookup(annexInstance, "ps::string4")).getValue());
		assertEquals("Value in s2 overrides value in s1",
				((StringLiteral) lookup(annexInstance, "ps::string5")).getValue());
		assertEquals("Value in s2.i overrides value in s1.i",
				((StringLiteral) lookup(annexInstance, "ps::string6")).getValue());
		assertEquals("Value in s1.i overrides value in s2",
				((StringLiteral) lookup(annexInstance, "ps::string7")).getValue());
	}

	@Test
	public void testPropertiesOnStateMachine() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_state_machine.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var stateMachineProperties = annexInstance.getStateMachineProperties();

		assertEquals("machine1", stateMachineProperties.getName());

		assertEquals(2, stateMachineProperties.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(stateMachineProperties, "ps::boolean_for_all")).getValue());
		assertTrue(((BooleanLiteral) lookup(stateMachineProperties, "ps::boolean_for_error_behavior_state_machine"))
				.getValue());
	}

	@Test
	public void testSimpleBooleanOnTypeInSink() throws Exception {
		var pkg = testHelper.parseFile(PATH + "simple_boolean_on_type_in_sink.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);

		with((TypeInstance) sink.getTypeSet().flatten().get(0), type -> {
			assertEquals("ServiceError", type.getName());
			assertEquals(0, type.getOwnedPropertyAssociations().size());
		});
		with((TypeInstance) sink.getTypeSet().flatten().get(1), type -> {
			assertEquals("ItemTimingError", type.getName());
			assertEquals(3, type.getOwnedPropertyAssociations().size());
			assertTrue(((BooleanLiteral) lookup(type, "ps::boolean_for_all")).getValue());
			assertTrue(((BooleanLiteral) lookup(type, "ps::boolean_for_error_types")).getValue());
			assertTrue(((BooleanLiteral) lookup(type, "ps::boolean_for_error_type")).getValue());
		});
		with((TypeInstance) sink.getTypeSet().flatten().get(2), type -> {
			assertEquals("ItemValueError", type.getName());
			assertEquals(1, type.getOwnedPropertyAssociations().size());
			assertTrue(((BooleanLiteral) lookup(type, "ps::boolean_for_all")).getValue());
		});
	}

	@Test
	public void testPropertiesOnTypeInPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_type_in_propagation.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);

		assertEquals(8, annexInstance.getPropagations().size());
		with(annexInstance.getPropagations().get(0), propagation -> {
			assertEquals("f1", propagation.getName());

			var inType = propagation.getInTypeSet().flatten().get(0);
			assertEquals(1, inType.getOwnedPropertyAssociations().size());
			assertEquals("Value on type in in propagation", ((StringLiteral) lookup(inType, "ps::string1")).getValue());

			assertNull(propagation.getOutTypeSet());
		});
		with(annexInstance.getPropagations().get(1), propagation -> {
			assertEquals("f2", propagation.getName());

			assertNull(propagation.getInTypeSet());

			var outType = propagation.getOutTypeSet().flatten().get(0);
			assertEquals(1, outType.getOwnedPropertyAssociations().size());
			assertEquals("Value on out type in out propagation",
					((StringLiteral) lookup(outType, "ps::string1")).getValue());
		});
		with(annexInstance.getPropagations().get(2), propagation -> {
			assertEquals("f3", propagation.getName());

			var inType = propagation.getInTypeSet().flatten().get(0);
			assertEquals(1, inType.getOwnedPropertyAssociations().size());
			assertEquals("Value on type in in and out propagation",
					((StringLiteral) lookup(inType, "ps::string1")).getValue());

			var outType = propagation.getOutTypeSet().flatten().get(0);
			assertEquals(1, outType.getOwnedPropertyAssociations().size());
			assertEquals("Value on type in in and out propagation",
					((StringLiteral) lookup(outType, "ps::string1")).getValue());
		});
		with(annexInstance.getPropagations().get(3), propagation -> {
			assertEquals("fg1.f4", propagation.getName());

			var inType = propagation.getInTypeSet().flatten().get(0);
			assertEquals(1, inType.getOwnedPropertyAssociations().size());
			assertEquals("Value on type in propagation in feature group",
					((StringLiteral) lookup(inType, "ps::string1")).getValue());

			assertNull(propagation.getOutTypeSet());
		});
		with(annexInstance.getPropagations().get(4), propagation -> {
			assertEquals("fg1.fg2.fg3.f5", propagation.getName());

			var inType = propagation.getInTypeSet().flatten().get(0);
			assertEquals(1, inType.getOwnedPropertyAssociations().size());
			assertEquals("Value on type in propagation nested in feature group",
					((StringLiteral) lookup(inType, "ps::string1")).getValue());

			assertNull(propagation.getOutTypeSet());
		});
		with(annexInstance.getPropagations().get(5), propagation -> {
			assertEquals("point1", propagation.getName());

			assertNull(propagation.getInTypeSet());

			var outType = propagation.getOutTypeSet().flatten().get(0);
			assertEquals(1, outType.getOwnedPropertyAssociations().size());
			assertEquals("Value on type in point propagation",
					((StringLiteral) lookup(outType, "ps::string1")).getValue());
		});
		with(annexInstance.getPropagations().get(6), propagation -> {
			assertEquals("access", propagation.getName());

			var inType = propagation.getInTypeSet().flatten().get(0);
			assertEquals(1, inType.getOwnedPropertyAssociations().size());
			assertEquals("Value on type in access propagation",
					((StringLiteral) lookup(inType, "ps::string1")).getValue());

			assertNull(propagation.getOutTypeSet());
		});
		with(annexInstance.getPropagations().get(7), propagation -> {
			assertEquals("memory", propagation.getName());

			var inType = propagation.getInTypeSet().flatten().get(0);
			assertEquals(1, inType.getOwnedPropertyAssociations().size());
			assertEquals("Value on type in binding propagation",
					((StringLiteral) lookup(inType, "ps::string1")).getValue());

			assertNull(propagation.getOutTypeSet());
		});
	}

	@Test
	public void testPropertiesOnTypeInSource() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_type_in_source.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var source = (ErrorSourceInstance) annexInstance.getErrorFlows().get(0);
		var type = (TypeInstance) source.getTypeSet().flatten().get(0);

		assertEquals(1, type.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(type, "ps::boolean_for_all")).getValue());
	}

	@Test
	public void testPropertiesOnTypeInState() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_type_in_state.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var state = annexInstance.getStates().get(0);
		var type = (TypeInstance) state.getTypeSet().flatten().get(0);

		assertEquals(3, type.getOwnedPropertyAssociations().size());
		assertEquals("Value in machine1", ((StringLiteral) lookup(type, "ps::string1")).getValue());
		assertEquals("Value in s", ((StringLiteral) lookup(type, "ps::string2")).getValue());
		assertEquals("Value in s overrides value in machine1",
				((StringLiteral) lookup(type, "ps::string3")).getValue());
	}

	@Test
	public void testPropertiesOnTypeInErrorEvent() throws Exception {
		var pkg = testHelper.parseFile(PATH + "properties_on_type_in_error_event.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var event = (ErrorEventInstance) annexInstance.getEvents().get(0);
		var type = (TypeInstance) event.getTypeSet().flatten().get(0);

		assertEquals(1, type.getOwnedPropertyAssociations().size());
		assertTrue(((BooleanLiteral) lookup(type, "ps::boolean_for_all")).getValue());
	}

	@Test
	public void testLookupOnTypeFromTypeExtension() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_type_from_type_extension.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(3);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);
		var type = sink.getTypeSet().flatten().get(0);

		assertEquals(6, type.getOwnedPropertyAssociations().size());
		assertEquals("Value in s1", ((StringLiteral) lookup(type, "ps::string1")).getValue());
		assertEquals("Value in s2", ((StringLiteral) lookup(type, "ps::string2")).getValue());
		assertEquals("Value in s3", ((StringLiteral) lookup(type, "ps::string3")).getValue());
		assertEquals("Value in s2 overrides value in s1", ((StringLiteral) lookup(type, "ps::string4")).getValue());
		assertEquals("Value in s3 overrides value in s2", ((StringLiteral) lookup(type, "ps::string5")).getValue());
		assertEquals("Value in s3 overrides value in s2 and s1",
				((StringLiteral) lookup(type, "ps::string6")).getValue());
	}

	@Test
	public void testLookupOnTypeFromImplExtension() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_type_from_impl_extension.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(3);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);
		var type = sink.getTypeSet().flatten().get(0);

		assertEquals(6, type.getOwnedPropertyAssociations().size());
		assertEquals("Value in s.i1", ((StringLiteral) lookup(type, "ps::string1")).getValue());
		assertEquals("Value in s.i2", ((StringLiteral) lookup(type, "ps::string2")).getValue());
		assertEquals("Value in s.i3", ((StringLiteral) lookup(type, "ps::string3")).getValue());
		assertEquals("Value in s.i2 overrides value in s.i1", ((StringLiteral) lookup(type, "ps::string4")).getValue());
		assertEquals("Value in s.i3 overrides value in s.i2", ((StringLiteral) lookup(type, "ps::string5")).getValue());
		assertEquals("Value in s.i3 overrides value in s.i2 and s.i1",
				((StringLiteral) lookup(type, "ps::string6")).getValue());
	}

	@Test
	public void testLookupOnTypeFromTypeAndImpl() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_type_from_type_and_impl.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(3);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);
		var type = sink.getTypeSet().flatten().get(0);

		assertEquals(7, type.getOwnedPropertyAssociations().size());
		assertEquals("Value in s1", ((StringLiteral) lookup(type, "ps::string1")).getValue());
		assertEquals("Value in s2", ((StringLiteral) lookup(type, "ps::string2")).getValue());
		assertEquals("Value in s1.i", ((StringLiteral) lookup(type, "ps::string3")).getValue());
		assertEquals("Value in s2.i", ((StringLiteral) lookup(type, "ps::string4")).getValue());
		assertEquals("Value in s1.i overrides value in s1", ((StringLiteral) lookup(type, "ps::string5")).getValue());
		assertEquals("Value in s2.i overrides value in s2", ((StringLiteral) lookup(type, "ps::string6")).getValue());
		assertEquals("Value in s1.i overrides value in s2", ((StringLiteral) lookup(type, "ps::string7")).getValue());
	}

	@Test
	public void testLookupOnTypeFromContainer() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_type_from_container.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var middle = InstantiateModel.instantiate(system).getComponentInstances().get(0);
		var inner = middle.getComponentInstances().get(0);
		var annexInstance = (EMV2AnnexInstance) inner.getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);
		var type = sink.getTypeSet().flatten().get(0);

		assertEquals(6, type.getOwnedPropertyAssociations().size());
		assertEquals("Value in inner", ((StringLiteral) lookup(type, "ps::string1")).getValue());
		assertEquals("Value in middle.i", ((StringLiteral) lookup(type, "ps::string2")).getValue());
		assertEquals("Value in outer.i", ((StringLiteral) lookup(type, "ps::string3")).getValue());
		assertEquals("Value in middle.i overrides value in inner",
				((StringLiteral) lookup(type, "ps::string4")).getValue());
		assertEquals("Value in outer.i overrides value in middle.i",
				((StringLiteral) lookup(type, "ps::string5")).getValue());
		assertEquals("Value in outer.i overrides value in middle.i and inner",
				((StringLiteral) lookup(type, "ps::string6")).getValue());
	}

	@Test
	public void testLookupOnTypeFromContainerWithExtension() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_type_from_container_with_extension.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		var inner = InstantiateModel.instantiate(system).getComponentInstances().get(0);
		var annexInstance = (EMV2AnnexInstance) inner.getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);
		var type = sink.getTypeSet().flatten().get(0);

		assertEquals(3, type.getOwnedPropertyAssociations().size());
		assertEquals("Value in outer.i1", ((StringLiteral) lookup(type, "ps::string1")).getValue());
		assertEquals("Value in outer.i2", ((StringLiteral) lookup(type, "ps::string2")).getValue());
		assertEquals("Value in outer.i2 overrides value in outer.i1",
				((StringLiteral) lookup(type, "ps::string3")).getValue());
	}

	@Test
	public void testLookupOnTypeFromLibrary() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_type_from_library.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);
		var type = sink.getTypeSet().flatten().get(0);

		assertEquals(3, type.getOwnedPropertyAssociations().size());
		assertEquals("Value in library", ((StringLiteral) lookup(type, "ps::string1")).getValue());
		assertEquals("Value in s", ((StringLiteral) lookup(type, "ps::string2")).getValue());
		assertEquals("Value in s overrides value in library", ((StringLiteral) lookup(type, "ps::string3")).getValue());
	}

	@Test
	public void testLookupOnTypeFromSuperType() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_type_from_super_type.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);
		var type = sink.getTypeSet().flatten().get(0);

		assertEquals(6, type.getOwnedPropertyAssociations().size());
		assertEquals("Value on parent", ((StringLiteral) lookup(type, "ps::string1")).getValue());
		assertEquals("Value on middle", ((StringLiteral) lookup(type, "ps::string2")).getValue());
		assertEquals("Value on child", ((StringLiteral) lookup(type, "ps::string3")).getValue());
		assertEquals("Value in s", ((StringLiteral) lookup(type, "ps::string4")).getValue());
		assertEquals("Value on middle overrides value on parent",
				((StringLiteral) lookup(type, "ps::string5")).getValue());
		assertEquals("Value in s overrides value on parent", ((StringLiteral) lookup(type, "ps::string6")).getValue());
	}

	@Test
	public void testLookupOnTypeFromTypeSet() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_type_from_type_set.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);
		var type = sink.getTypeSet().flatten().get(0);

		assertEquals(5, type.getOwnedPropertyAssociations().size());
		assertEquals("Value on outer", ((StringLiteral) lookup(type, "ps::string1")).getValue());
		assertEquals("Value on inner", ((StringLiteral) lookup(type, "ps::string2")).getValue());
		assertEquals("Value on type1", ((StringLiteral) lookup(type, "ps::string3")).getValue());
		assertEquals("Value on inner overrides value on outer",
				((StringLiteral) lookup(type, "ps::string4")).getValue());
		assertEquals("Value on type1 overrides value on inner",
				((StringLiteral) lookup(type, "ps::string5")).getValue());
	}

	@Test
	public void testLookupOnTypeFromContainingElement() throws Exception {
		var pkg = testHelper.parseFile(PATH + "lookup_on_type_from_containing_element.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var sink = (ErrorSinkInstance) annexInstance.getErrorFlows().get(0);
		var type = sink.getTypeSet().flatten().get(0);

		assertEquals(4, type.getOwnedPropertyAssociations().size());
		assertEquals("Value on sink", ((StringLiteral) lookup(type, "ps::string1")).getValue());
		assertEquals("Value on set", ((StringLiteral) lookup(type, "ps::string2")).getValue());
		assertEquals("Value on type", ((StringLiteral) lookup(type, "ps::string3")).getValue());
		assertEquals("Value on set overrides value on sink", ((StringLiteral) lookup(type, "ps::string4")).getValue());
	}

	@Test
	public void testResolveNamedValueOnElement() throws Exception {
		var pkg = testHelper.parseFile(PATH + "resolve_named_value_on_element.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var event = annexInstance.getEvents().get(0);

		assertEquals(5, event.getOwnedPropertyAssociations().size());
		assertEquals("String Value", ((StringLiteral) lookup(event, "ps::string1")).getValue());
		assertEquals("String Value", ((StringLiteral) lookup(event, "ps::string2")).getValue());
		assertEquals("String Value", ((StringLiteral) lookup(event, "ps::string3")).getValue());
		assertEquals("Constant Value", ((StringLiteral) lookup(event, "ps::string4")).getValue());
		assertEquals("Default Value", ((StringLiteral) lookup(event, "ps::string5")).getValue());
	}

	@Test
	public void testResolveNamedValueOnType() throws Exception {
		var pkg = testHelper.parseFile(PATH + "resolve_named_value_on_type.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var event = (ErrorEventInstance) annexInstance.getEvents().get(0);
		var type = (TypeInstance) event.getTypeSet().flatten().get(0);

		assertEquals(5, type.getOwnedPropertyAssociations().size());
		assertEquals("String Value", ((StringLiteral) lookup(type, "ps::string1")).getValue());
		assertEquals("String Value", ((StringLiteral) lookup(type, "ps::string2")).getValue());
		assertEquals("String Value", ((StringLiteral) lookup(type, "ps::string3")).getValue());
		assertEquals("Constant Value", ((StringLiteral) lookup(type, "ps::string4")).getValue());
		assertEquals("Default Value", ((StringLiteral) lookup(type, "ps::string5")).getValue());
	}

	@Test
	public void testResolveNamedValueOnStateMachine() throws Exception {
		var pkg = testHelper.parseFile(PATH + "resolve_named_value_on_state_machine.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		var stateMachineProperties = annexInstance.getStateMachineProperties();

		assertEquals(5, stateMachineProperties.getOwnedPropertyAssociations().size());
		assertEquals("String Value", ((StringLiteral) lookup(stateMachineProperties, "ps::string1")).getValue());
		assertEquals("String Value", ((StringLiteral) lookup(stateMachineProperties, "ps::string2")).getValue());
		assertEquals("String Value", ((StringLiteral) lookup(stateMachineProperties, "ps::string3")).getValue());
		assertEquals("Constant Value", ((StringLiteral) lookup(stateMachineProperties, "ps::string4")).getValue());
		assertEquals("Default Value", ((StringLiteral) lookup(stateMachineProperties, "ps::string5")).getValue());
	}

	@Test
	public void testResolveNamedValueOnSubclause() throws Exception {
		var pkg = testHelper.parseFile(PATH + "resolve_named_value_on_subclause.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);

		assertEquals(5, annexInstance.getOwnedPropertyAssociations().size());
		assertEquals("String Value", ((StringLiteral) lookup(annexInstance, "ps::string1")).getValue());
		assertEquals("String Value", ((StringLiteral) lookup(annexInstance, "ps::string2")).getValue());
		assertEquals("String Value", ((StringLiteral) lookup(annexInstance, "ps::string3")).getValue());
		assertEquals("Constant Value", ((StringLiteral) lookup(annexInstance, "ps::string4")).getValue());
		assertEquals("Default Value", ((StringLiteral) lookup(annexInstance, "ps::string5")).getValue());
	}

	@Test
	public void testNestedNamedValues() throws Exception {
		var pkg = testHelper.parseFile(PATH + "nested_named_values.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);

		assertEquals(7, annexInstance.getOwnedPropertyAssociations().size());
		assertEquals("String Value", ((StringLiteral) lookup(annexInstance, "ps::string1")).getValue());
		assertEquals("String Value", ((StringLiteral) lookup(annexInstance, "ps::string2")).getValue());
		assertEquals("String Value", ((StringLiteral) lookup(annexInstance, "ps::string3")).getValue());
		assertIterableEquals(List.of("Element", "String Value", "Constant Value"),
				((ListValue) lookup(annexInstance, "ps::list1")).getOwnedListElements()
						.stream()
						.map(element -> ((StringLiteral) element).getValue())
						.toList());
		with((RecordValue) lookup(annexInstance, "ps::rec1"), recordValue -> {
			assertEquals(2, recordValue.getOwnedFieldValues().size());
			with(recordValue.getOwnedFieldValues().get(0), field1 -> {
				assertEquals("field1", field1.getProperty().getName());
				assertEquals("String Value", ((StringLiteral) field1.getOwnedValue()).getValue());
			});
			with(recordValue.getOwnedFieldValues().get(1), listField -> {
				assertEquals("list_field", listField.getProperty().getName());
				assertIterableEquals(List.of("Element", "String Value", "Constant Value"),
						((ListValue) listField.getOwnedValue()).getOwnedListElements()
								.stream()
								.map(element -> ((StringLiteral) element).getValue())
								.toList());
			});
		});
		with((RecordValue) lookup(annexInstance, "ps::rec2"), recordValue -> {
			assertEquals(1, recordValue.getOwnedFieldValues().size());
			with(recordValue.getOwnedFieldValues().get(0), field2 -> {
				assertEquals("field2", field2.getProperty().getName());
				with((RecordValue) field2.getOwnedValue(), field2Value -> {
					assertEquals(2, field2Value.getOwnedFieldValues().size());
					with(field2Value.getOwnedFieldValues().get(0), field1 -> {
						assertEquals("field1", field1.getProperty().getName());
						assertEquals("String Value", ((StringLiteral) field1.getOwnedValue()).getValue());
					});
					with(field2Value.getOwnedFieldValues().get(1), listField -> {
						assertEquals("list_field", listField.getProperty().getName());
						assertIterableEquals(List.of("Element", "String Value", "Constant Value"),
								((ListValue) listField.getOwnedValue()).getOwnedListElements()
										.stream()
										.map(element -> ((StringLiteral) element).getValue())
										.toList());
					});
				});
			});
		});
		with((RecordValue) lookup(annexInstance, "ps::rec3"), recordValue -> {
			assertEquals(1, recordValue.getOwnedFieldValues().size());
			with(recordValue.getOwnedFieldValues().get(0), field3 -> {
				assertEquals("field3", field3.getProperty().getName());
				with((RecordValue) field3.getOwnedValue(), field3Value -> {
					assertEquals(1, field3Value.getOwnedFieldValues().size());
					with(field3Value.getOwnedFieldValues().get(0), field2 -> {
						assertEquals("field2", field2.getProperty().getName());
						with((RecordValue) field2.getOwnedValue(), field2Value -> {
							assertEquals(2, field2Value.getOwnedFieldValues().size());
							with(field2Value.getOwnedFieldValues().get(0), field1 -> {
								assertEquals("field1", field1.getProperty().getName());
								assertEquals("String Value", ((StringLiteral) field1.getOwnedValue()).getValue());
							});
							with(field2Value.getOwnedFieldValues().get(1), listField -> {
								assertEquals("list_field", listField.getProperty().getName());
								assertIterableEquals(List.of("Element", "String Value", "Constant Value"),
										((ListValue) listField.getOwnedValue()).getOwnedListElements()
												.stream()
												.map(element -> ((StringLiteral) element).getValue())
												.toList());
							});
						});
					});
				});
			});
		});
	}

	@Test
	public void testReferenceProperties() throws Exception {
		var pkg = testHelper.parseFile(PATH + "reference_properties.aadl", PATH + "ps.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);

		assertEquals(3, annexInstance.getOwnedPropertyAssociations().size());
		assertEquals("sub1", ((ComponentInstance) ((InstanceReferenceValue) lookup(annexInstance, "ps::ref1"))
				.getReferencedInstanceObject()).getName());
		assertEquals("sub2", ((ComponentInstance) ((InstanceReferenceValue) lookup(annexInstance, "ps::ref2"))
				.getReferencedInstanceObject()).getName());
		assertEquals("sub3", ((ComponentInstance) ((InstanceReferenceValue) lookup(annexInstance, "ps::ref3"))
				.getReferencedInstanceObject()).getName());
	}

	private static PropertyExpression lookup(NamedElement holder, String name) {
		Property property = Aadl2GlobalScopeUtil.get(holder, Aadl2Package.eINSTANCE.getProperty(), name);
		return holder.getSimplePropertyValue(property);
	}
}