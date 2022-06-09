package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.AllSources;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EventReference;
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
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
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
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			// TODO Update after we generate names for unnamed transitions.
			assertNull(transition.getName());
			assertSame(
					((ErrorModelLibrary) ((DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0))
							.getParsedAnnexLibrary()).getBehaviors().get(0).getTransitions().get(0),
					transition.getTransition());
			assertEquals("start", transition.getSource().getName());
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
	public void testEventWithNoerror() throws Exception {
		var pkg = testHelper.parseFile(PATH + "event_with_noerror.aadl");
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
}