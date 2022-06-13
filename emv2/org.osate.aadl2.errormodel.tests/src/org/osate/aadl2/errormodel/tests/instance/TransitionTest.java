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
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.AllExpressionInstance;
import org.osate.aadl2.errormodel.instance.AllSources;
import org.osate.aadl2.errormodel.instance.AndExpressionInstance;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EventReference;
import org.osate.aadl2.errormodel.instance.NoErrorPropagationReference;
import org.osate.aadl2.errormodel.instance.OrExpressionInstance;
import org.osate.aadl2.errormodel.instance.PropagationReference;
import org.osate.aadl2.errormodel.instance.StateReference;
import org.osate.aadl2.errormodel.instance.instantiator.EMV2AnnexInstantiator;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class TransitionTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/Transitions/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@BeforeAll
	public static void enableEMV2Instantiator() {
		System.setProperty(EMV2AnnexInstantiator.PROPERTY_NAME, "true");
	}

	@Test
	public void testTransitionInStateMachine() throws Exception {
		var pkg = testHelper.parseFile(PATH + "transition_in_state_machine.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
		});
	}

	@Test
	public void testTransitionInComponentErrorBehavior() throws Exception {
		var pkg = testHelper.parseFile(PATH + "transition_in_component_error_behavior.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
		});
	}

	@Test
	public void testTransitionsInStateMachineAndComponentErrorBehavior() throws Exception {
		var pkg = testHelper.parseFile(PATH + "transitions_in_state_machine_and_component_error_behavior.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			assertEquals("error2", transition.getCondition().getName());
		});
	}

	@Test
	public void testOverrideTransitionInheritedFromClassifier() throws Exception {
		var pkg = testHelper.parseFile(PATH + "override_transition_inherited_from_classifier.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("TRANSITION1", transition.getName());
			assertEquals("TRANSITION1", transition.getTransition().getName());
			assertEquals("state2", transition.getSource().getName());
			assertEquals("recover1", transition.getCondition().getName());
		});
	}

	@Test
	public void testOverrideTransitionInheritedFromStateMachine() throws Exception {
		var pkg = testHelper.parseFile(PATH + "override_transition_inherited_from_state_machine.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("TRANSITION1", transition.getName());
			assertEquals("TRANSITION1", transition.getTransition().getName());
			assertEquals("state2", transition.getSource().getName());
			assertEquals("recover1", transition.getCondition().getName());
		});
	}

	@Test
	public void testInheritUnnamedTransitions() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherit_unnamed_transitions.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			// TODO Update after we generate names for unnamed transitions.
			assertNull(transition.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().get(0))
					.getParsedAnnexSubclause()).getTransitions().get(0), transition.getTransition());
			assertEquals("start", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			// TODO Update after we generate names for unnamed transitions.
			assertNull(transition.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)
					.getOwnedAnnexSubclauses()
					.get(0)).getParsedAnnexSubclause()).getTransitions().get(0), transition.getTransition());
			assertEquals("start", transition.getSource().getName());
			assertEquals("error2", transition.getCondition().getName());
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			// TODO Update after we generate names for unnamed transitions.
			assertNull(transition.getName());
			assertSame(
					((ErrorModelLibrary) ((DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0))
							.getParsedAnnexLibrary()).getBehaviors().get(0).getTransitions().get(0),
					transition.getTransition());
			assertEquals("start", transition.getSource().getName());
			assertEquals("error3", transition.getCondition().getName());
		});
	}

	@Test
	public void testUntypedSource() throws Exception {
		var pkg = testHelper.parseFile(PATH + "untyped_source.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			with((StateReference) transition.getSource(), source -> {
				assertEquals("state1", source.getName());
				assertEquals("state1", source.getState().getName());
				assertNull(source.getTypeSet());
			});
			assertEquals("error1", transition.getCondition().getName());
		});
	}

	@Test
	public void testTypedSourceWithTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_source_with_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			with((StateReference) transition.getSource(), source -> {
				assertEquals("state1 {ServiceError}", source.getName());
				assertEquals("state1", source.getState().getName());
				assertEquals("{ServiceError}", source.getTypeSet().getName());
			});
			assertEquals("error1", transition.getCondition().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			with((StateReference) transition.getSource(), source -> {
				assertEquals("state1 {ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError}",
						source.getName());
				assertEquals("state1", source.getState().getName());
				assertEquals("{ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError}",
						source.getTypeSet().getName());
			});
			assertEquals("error2", transition.getCondition().getName());
		});
	}

	@Test
	public void testTypedSourceWithoutTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_source_without_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			with((StateReference) transition.getSource(), source -> {
				assertEquals("state1 {CommonErrors}", source.getName());
				assertEquals("state1", source.getState().getName());
				assertEquals("{CommonErrors}", source.getTypeSet().getName());
			});
			assertEquals("error1", transition.getCondition().getName());
		});
	}

	@Test
	public void testAllSources() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_sources.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			with((AllSources) transition.getSource(), source -> {
				assertEquals("all", source.getName());
			});
			assertEquals("error1", transition.getCondition().getName());
		});
	}

	@Test
	public void testUntypedEvent() throws Exception {
		var pkg = testHelper.parseFile(PATH + "untyped_event.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(6, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("ok", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("error1", condition.getName());
				assertEquals("error1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("failure", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("recover1", condition.getName());
				assertEquals("recover1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("failure", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("repair1", condition.getName());
				assertEquals("repair1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition4", transition.getName());
			assertEquals("transition4", transition.getTransition().getName());
			assertEquals("ok", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("local_error1", condition.getName());
				assertEquals("local_error1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
		});
		with(annexInstance.getTransitions().get(4), transition -> {
			assertEquals("transition5", transition.getName());
			assertEquals("transition5", transition.getTransition().getName());
			assertEquals("failure", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("local_recover1", condition.getName());
				assertEquals("local_recover1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
		});
		with(annexInstance.getTransitions().get(5), transition -> {
			assertEquals("transition6", transition.getName());
			assertEquals("transition6", transition.getTransition().getName());
			assertEquals("failure", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("local_repair1", condition.getName());
				assertEquals("local_repair1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
		});
	}

	@Test
	public void testTypedEventWithTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_event_with_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("error1 {ServiceError}", condition.getName());
				assertEquals("error1", condition.getEvent().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("error1 {ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError}",
						condition.getName());
				assertEquals("error1", condition.getEvent().getName());
				assertEquals("{ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError}",
						condition.getTypeSet().getName());
			});
		});
	}

	@Test
	public void testTypedEventWithoutTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_event_without_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("error1 {CommonErrors}", condition.getName());
				assertEquals("error1", condition.getEvent().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
	}

	@Test
	public void testEventWithNoError() throws Exception {
		var pkg = testHelper.parseFile(PATH + "event_with_no_error.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("error1", condition.getName());
				assertEquals("error1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
		});
	}

	@Test
	public void testFindOverriddenEvents() throws Exception {
		var pkg = testHelper.parseFile(PATH + "find_overridden_events.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(6, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("ok", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("error1", condition.getName());
				assertEquals("ERROR1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("failure", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("recover1", condition.getName());
				assertEquals("RECOVER1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("failure", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("repair1", condition.getName());
				assertEquals("REPAIR1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition4", transition.getName());
			assertEquals("transition4", transition.getTransition().getName());
			assertEquals("ok", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("local_error1", condition.getName());
				assertEquals("LOCAL_ERROR1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
		});
		with(annexInstance.getTransitions().get(4), transition -> {
			assertEquals("transition5", transition.getName());
			assertEquals("transition5", transition.getTransition().getName());
			assertEquals("failure", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("local_recover1", condition.getName());
				assertEquals("LOCAL_RECOVER1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
		});
		with(annexInstance.getTransitions().get(5), transition -> {
			assertEquals("transition6", transition.getName());
			assertEquals("transition6", transition.getTransition().getName());
			assertEquals("failure", transition.getSource().getName());
			with((EventReference) transition.getCondition(), condition -> {
				assertEquals("local_repair1", condition.getName());
				assertEquals("LOCAL_REPAIR1", condition.getEvent().getName());
				assertNull(condition.getTypeSet());
			});
		});
	}

	@Test
	public void testLocalPropagationWithTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "local_propagation_with_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(4, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("f1 {ServiceError}", condition.getName());
				assertEquals("f1", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("access {ServiceError}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("point1 {ServiceError}", condition.getName());
				assertEquals("point1", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition4", transition.getName());
			assertEquals("transition4", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("processor {ServiceError}", condition.getName());
				assertEquals("processor", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
	}

	@Test
	public void testPropagationInFeatureGroupWithTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "propagation_in_feature_group_with_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("fg1.f1 {ServiceError}", condition.getName());
				assertEquals("fg1.f1", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("fg1.fg2.fg3.f2 {ServiceError}", condition.getName());
				assertEquals("fg1.fg2.fg3.f2", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
	}

	@Test
	public void testPropagationInSubcomponentWithTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "propagation_in_subcomponent_with_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(12, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition01", transition.getName());
			assertEquals("transition01", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.f1 {ServiceError}", condition.getName());
				assertEquals("f1", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition02", transition.getName());
			assertEquals("transition02", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.access {ServiceError}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition03", transition.getName());
			assertEquals("transition03", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.point1 {ServiceError}", condition.getName());
				assertEquals("point1", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition04", transition.getName());
			assertEquals("transition04", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.processor {ServiceError}", condition.getName());
				assertEquals("processor", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(4), transition -> {
			assertEquals("transition05", transition.getName());
			assertEquals("transition05", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.fg1.f2 {ServiceError}", condition.getName());
				assertEquals("fg1.f2", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(5), transition -> {
			assertEquals("transition06", transition.getName());
			assertEquals("transition06", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.fg1.fg2.fg3.f3 {ServiceError}", condition.getName());
				assertEquals("fg1.fg2.fg3.f3", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(6), transition -> {
			assertEquals("transition07", transition.getName());
			assertEquals("transition07", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.f4 {ServiceError}", condition.getName());
				assertEquals("f4", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(7), transition -> {
			assertEquals("transition08", transition.getName());
			assertEquals("transition08", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.access {ServiceError}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(8), transition -> {
			assertEquals("transition09", transition.getName());
			assertEquals("transition09", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.point2 {ServiceError}", condition.getName());
				assertEquals("point2", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(9), transition -> {
			assertEquals("transition10", transition.getName());
			assertEquals("transition10", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.memory {ServiceError}", condition.getName());
				assertEquals("memory", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(10), transition -> {
			assertEquals("transition11", transition.getName());
			assertEquals("transition11", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.fg4.f5 {ServiceError}", condition.getName());
				assertEquals("fg4.f5", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(11), transition -> {
			assertEquals("transition12", transition.getName());
			assertEquals("transition12", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.fg4.fg5.fg6.f6 {ServiceError}", condition.getName());
				assertEquals("fg4.fg5.fg6.f6", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
	}

	@Test
	public void testLocalPropagationWithoutTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "local_propagation_without_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(4, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("f1 {CommonErrors}", condition.getName());
				assertEquals("f1", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("access {CommonErrors}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("point1 {CommonErrors}", condition.getName());
				assertEquals("point1", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition4", transition.getName());
			assertEquals("transition4", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("processor {CommonErrors}", condition.getName());
				assertEquals("processor", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
	}

	@Test
	public void testPropagationInFeatureGroupWithoutTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "propagation_in_feature_group_without_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("fg1.f1 {CommonErrors}", condition.getName());
				assertEquals("fg1.f1", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("fg1.fg2.fg3.f2 {CommonErrors}", condition.getName());
				assertEquals("fg1.fg2.fg3.f2", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
	}

	@Test
	public void testPropagationInSubcomponentWithoutTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "propagation_in_subcomponent_without_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(12, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition01", transition.getName());
			assertEquals("transition01", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.f1 {CommonErrors}", condition.getName());
				assertEquals("f1", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition02", transition.getName());
			assertEquals("transition02", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.access {CommonErrors}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition03", transition.getName());
			assertEquals("transition03", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.point1 {CommonErrors}", condition.getName());
				assertEquals("point1", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition04", transition.getName());
			assertEquals("transition04", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.processor {CommonErrors}", condition.getName());
				assertEquals("processor", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(4), transition -> {
			assertEquals("transition05", transition.getName());
			assertEquals("transition05", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.fg1.f2 {CommonErrors}", condition.getName());
				assertEquals("fg1.f2", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(5), transition -> {
			assertEquals("transition06", transition.getName());
			assertEquals("transition06", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.fg1.fg2.fg3.f3 {CommonErrors}", condition.getName());
				assertEquals("fg1.fg2.fg3.f3", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(6), transition -> {
			assertEquals("transition07", transition.getName());
			assertEquals("transition07", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.f4 {CommonErrors}", condition.getName());
				assertEquals("f4", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(7), transition -> {
			assertEquals("transition08", transition.getName());
			assertEquals("transition08", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.access {CommonErrors}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(8), transition -> {
			assertEquals("transition09", transition.getName());
			assertEquals("transition09", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.point2 {CommonErrors}", condition.getName());
				assertEquals("point2", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(9), transition -> {
			assertEquals("transition10", transition.getName());
			assertEquals("transition10", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.memory {CommonErrors}", condition.getName());
				assertEquals("memory", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(10), transition -> {
			assertEquals("transition11", transition.getName());
			assertEquals("transition11", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.fg4.f5 {CommonErrors}", condition.getName());
				assertEquals("fg4.f5", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getTransitions().get(11), transition -> {
			assertEquals("transition12", transition.getName());
			assertEquals("transition12", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((PropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.fg4.fg5.fg6.f6 {CommonErrors}", condition.getName());
				assertEquals("fg4.fg5.fg6.f6", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
	}

	@Test
	public void testLocalPropagationWithNoError() throws Exception {
		var pkg = testHelper.parseFile(PATH + "local_propagation_with_no_error.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(4, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("f1 {noerror}", condition.getName());
				assertEquals("f1", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("access {noerror}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("point1 {noerror}", condition.getName());
				assertEquals("point1", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition4", transition.getName());
			assertEquals("transition4", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("processor {noerror}", condition.getName());
				assertEquals("processor", condition.getPropagation().getName());
			});
		});
	}

	@Test
	public void testPropagationInFeatureGroupWithNoError() throws Exception {
		var pkg = testHelper.parseFile(PATH + "propagation_in_feature_group_with_no_error.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("fg1.f1 {noerror}", condition.getName());
				assertEquals("fg1.f1", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("fg1.fg2.fg3.f2 {noerror}", condition.getName());
				assertEquals("fg1.fg2.fg3.f2", condition.getPropagation().getName());
			});
		});
	}

	@Test
	public void testPropagationInSubcomponentWithNoError() throws Exception {
		var pkg = testHelper.parseFile(PATH + "propagation_in_subcomponent_with_no_error.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(12, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition01", transition.getName());
			assertEquals("transition01", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.f1 {noerror}", condition.getName());
				assertEquals("f1", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition02", transition.getName());
			assertEquals("transition02", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.access {noerror}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition03", transition.getName());
			assertEquals("transition03", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.point1 {noerror}", condition.getName());
				assertEquals("point1", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition04", transition.getName());
			assertEquals("transition04", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.processor {noerror}", condition.getName());
				assertEquals("processor", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(4), transition -> {
			assertEquals("transition05", transition.getName());
			assertEquals("transition05", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.fg1.f2 {noerror}", condition.getName());
				assertEquals("fg1.f2", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(5), transition -> {
			assertEquals("transition06", transition.getName());
			assertEquals("transition06", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.fg1.fg2.fg3.f3 {noerror}", condition.getName());
				assertEquals("fg1.fg2.fg3.f3", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(6), transition -> {
			assertEquals("transition07", transition.getName());
			assertEquals("transition07", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.f4 {noerror}", condition.getName());
				assertEquals("f4", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(7), transition -> {
			assertEquals("transition08", transition.getName());
			assertEquals("transition08", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.access {noerror}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(8), transition -> {
			assertEquals("transition09", transition.getName());
			assertEquals("transition09", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.point2 {noerror}", condition.getName());
				assertEquals("point2", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(9), transition -> {
			assertEquals("transition10", transition.getName());
			assertEquals("transition10", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.memory {noerror}", condition.getName());
				assertEquals("memory", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(10), transition -> {
			assertEquals("transition11", transition.getName());
			assertEquals("transition11", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.fg4.f5 {noerror}", condition.getName());
				assertEquals("fg4.f5", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getTransitions().get(11), transition -> {
			assertEquals("transition12", transition.getName());
			assertEquals("transition12", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.fg4.fg5.fg6.f6 {noerror}", condition.getName());
				assertEquals("fg4.fg5.fg6.f6", condition.getPropagation().getName());
			});
		});
	}

	@Test
	public void testOrExpression() throws Exception {
		var pkg = testHelper.parseFile(PATH + "or_expression.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((OrExpressionInstance) transition.getCondition(), condition -> {
				assertEquals("error1 or error2", condition.getName());
				assertEquals("error1", condition.getLeft().getName());
				assertEquals("error2", condition.getRight().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((OrExpressionInstance) transition.getCondition(), condition -> {
				assertEquals("error3 or error4 or error5 or error6", condition.getName());
				with((OrExpressionInstance) condition.getLeft(), left1 -> {
					assertEquals("error3 or error4 or error5", left1.getName());
					with((OrExpressionInstance) left1.getLeft(), left2 -> {
						assertEquals("error3 or error4", left2.getName());
						assertEquals("error3", left2.getLeft().getName());
						assertEquals("error4", left2.getRight().getName());
					});
					assertEquals("error5", left1.getRight().getName());
				});
				assertEquals("error6", condition.getRight().getName());
			});
		});
	}

	@Test
	public void testAndExpression() throws Exception {
		var pkg = testHelper.parseFile(PATH + "and_expression.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((AndExpressionInstance) transition.getCondition(), condition -> {
				assertEquals("error1 and error2", condition.getName());
				assertEquals("error1", condition.getLeft().getName());
				assertEquals("error2", condition.getRight().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((AndExpressionInstance) transition.getCondition(), condition -> {
				assertEquals("error3 and error4 and error5 and error6", condition.getName());
				with((AndExpressionInstance) condition.getLeft(), left1 -> {
					assertEquals("error3 and error4 and error5", left1.getName());
					with((AndExpressionInstance) left1.getLeft(), left2 -> {
						assertEquals("error3 and error4", left2.getName());
						assertEquals("error3", left2.getLeft().getName());
						assertEquals("error4", left2.getRight().getName());
					});
					assertEquals("error5", left1.getRight().getName());
				});
				assertEquals("error6", condition.getRight().getName());
			});
		});
	}

	@Test
	public void testAllExpression() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_expression.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((AllExpressionInstance) transition.getCondition(), condition -> {
				assertEquals("all (error1)", condition.getName());
				assertEquals(0, condition.getMinusCount());
				assertIterableEquals(List.of("error1"),
						condition.getElements().stream().map(NamedElement::getName).toList());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((AllExpressionInstance) transition.getCondition(), condition -> {
				assertEquals("all (error2, error3, error4)", condition.getName());
				assertEquals(0, condition.getMinusCount());
				assertIterableEquals(List.of("error2", "error3", "error4"),
						condition.getElements().stream().map(NamedElement::getName).toList());
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((AllExpressionInstance) transition.getCondition(), condition -> {
				assertEquals("all - 2 (error5, error6, error7, error8, error9)", condition.getName());
				assertEquals(2, condition.getMinusCount());
				assertIterableEquals(List.of("error5", "error6", "error7", "error8", "error9"),
						condition.getElements().stream().map(NamedElement::getName).toList());
			});
		});
	}
}