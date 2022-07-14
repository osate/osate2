package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.osate.pluginsupport.ScopeFunctions.with;

import java.math.BigDecimal;
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
import org.osate.aadl2.errormodel.instance.AllSources;
import org.osate.aadl2.errormodel.instance.BranchSameState;
import org.osate.aadl2.errormodel.instance.BranchStateReference;
import org.osate.aadl2.errormodel.instance.Branches;
import org.osate.aadl2.errormodel.instance.ConditionPropagationReference;
import org.osate.aadl2.errormodel.instance.CountExpression;
import org.osate.aadl2.errormodel.instance.CountExpressionOperation;
import org.osate.aadl2.errormodel.instance.DestinationStateReference;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EventReference;
import org.osate.aadl2.errormodel.instance.NoErrorPropagationReference;
import org.osate.aadl2.errormodel.instance.SameState;
import org.osate.aadl2.errormodel.instance.SourceStateReference;
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
			assertEquals("state2", transition.getDestination().getName());
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
			assertEquals("state2", transition.getDestination().getName());
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
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			assertEquals("error2", transition.getCondition().getName());
			assertEquals("state2", transition.getDestination().getName());
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
			assertEquals("state1", transition.getDestination().getName());
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
			assertEquals("state1", transition.getDestination().getName());
		});
	}

	@Test
	public void testInheritUnnamedTransitions() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherit_unnamed_transitions.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("start -[error1]-> failure1", transition.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().get(0))
					.getParsedAnnexSubclause()).getTransitions().get(0), transition.getTransition());
			assertEquals("start", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			assertEquals("failure1", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("start -[error2]-> failure2", transition.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)
					.getOwnedAnnexSubclauses()
					.get(0)).getParsedAnnexSubclause()).getTransitions().get(0), transition.getTransition());
			assertEquals("start", transition.getSource().getName());
			assertEquals("error2", transition.getCondition().getName());
			assertEquals("failure2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("start -[error3]-> failure3", transition.getName());
			assertSame(
					((ErrorModelLibrary) ((DefaultAnnexLibrary) pkg.getPublicSection().getOwnedAnnexLibraries().get(0))
							.getParsedAnnexLibrary()).getBehaviors().get(0).getTransitions().get(0),
					transition.getTransition());
			assertEquals("start", transition.getSource().getName());
			assertEquals("error3", transition.getCondition().getName());
			assertEquals("failure3", transition.getDestination().getName());
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
			with((SourceStateReference) transition.getSource(), source -> {
				assertEquals("state1", source.getName());
				assertEquals("state1", source.getState().getName());
				assertNull(source.getTypeSet());
			});
			assertEquals("error1", transition.getCondition().getName());
			assertEquals("state2", transition.getDestination().getName());
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
			with((SourceStateReference) transition.getSource(), source -> {
				assertEquals("state1 {ServiceError}", source.getName());
				assertEquals("state1", source.getState().getName());
				assertEquals("{ServiceError}", source.getTypeSet().getName());
			});
			assertEquals("error1", transition.getCondition().getName());
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			with((SourceStateReference) transition.getSource(), source -> {
				assertEquals("state1 {ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError}",
						source.getName());
				assertEquals("state1", source.getState().getName());
				assertEquals("{ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError}",
						source.getTypeSet().getName());
			});
			assertEquals("error2", transition.getCondition().getName());
			assertEquals("state3", transition.getDestination().getName());
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
			with((SourceStateReference) transition.getSource(), source -> {
				assertEquals("state1 {CommonErrors}", source.getName());
				assertEquals("state1", source.getState().getName());
				assertEquals("{CommonErrors}", source.getTypeSet().getName());
			});
			assertEquals("error1", transition.getCondition().getName());
			assertEquals("state2", transition.getDestination().getName());
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
			assertEquals("end_state", transition.getDestination().getName());
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
			assertEquals("failure", transition.getDestination().getName());
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
			assertEquals("ok", transition.getDestination().getName());
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
			assertEquals("ok", transition.getDestination().getName());
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
			assertEquals("failure", transition.getDestination().getName());
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
			assertEquals("ok", transition.getDestination().getName());
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
			assertEquals("ok", transition.getDestination().getName());
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
			assertEquals("state2", transition.getDestination().getName());
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
			assertEquals("state2", transition.getDestination().getName());
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
			assertEquals("state2", transition.getDestination().getName());
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
			assertEquals("state2", transition.getDestination().getName());
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
			assertEquals("failure", transition.getDestination().getName());
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
			assertEquals("ok", transition.getDestination().getName());
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
			assertEquals("ok", transition.getDestination().getName());
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
			assertEquals("failure", transition.getDestination().getName());
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
			assertEquals("ok", transition.getDestination().getName());
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
			assertEquals("ok", transition.getDestination().getName());
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
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("f1 {ServiceError}", condition.getName());
				assertEquals("f1", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("access {ServiceError}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("point1 {ServiceError}", condition.getName());
				assertEquals("point1", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition4", transition.getName());
			assertEquals("transition4", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("processor {ServiceError}", condition.getName());
				assertEquals("processor", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
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
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("fg1.f1 {ServiceError}", condition.getName());
				assertEquals("fg1.f1", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("fg1.fg2.fg3.f2 {ServiceError}", condition.getName());
				assertEquals("fg1.fg2.fg3.f2", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
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
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.f1 {ServiceError}", condition.getName());
				assertEquals("f1", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition02", transition.getName());
			assertEquals("transition02", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.access {ServiceError}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition03", transition.getName());
			assertEquals("transition03", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.point1 {ServiceError}", condition.getName());
				assertEquals("point1", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition04", transition.getName());
			assertEquals("transition04", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.processor {ServiceError}", condition.getName());
				assertEquals("processor", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(4), transition -> {
			assertEquals("transition05", transition.getName());
			assertEquals("transition05", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.fg1.f2 {ServiceError}", condition.getName());
				assertEquals("fg1.f2", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(5), transition -> {
			assertEquals("transition06", transition.getName());
			assertEquals("transition06", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.fg1.fg2.fg3.f3 {ServiceError}", condition.getName());
				assertEquals("fg1.fg2.fg3.f3", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(6), transition -> {
			assertEquals("transition07", transition.getName());
			assertEquals("transition07", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.f4 {ServiceError}", condition.getName());
				assertEquals("f4", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(7), transition -> {
			assertEquals("transition08", transition.getName());
			assertEquals("transition08", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.access {ServiceError}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(8), transition -> {
			assertEquals("transition09", transition.getName());
			assertEquals("transition09", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.point2 {ServiceError}", condition.getName());
				assertEquals("point2", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(9), transition -> {
			assertEquals("transition10", transition.getName());
			assertEquals("transition10", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.memory {ServiceError}", condition.getName());
				assertEquals("memory", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(10), transition -> {
			assertEquals("transition11", transition.getName());
			assertEquals("transition11", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.fg4.f5 {ServiceError}", condition.getName());
				assertEquals("fg4.f5", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(11), transition -> {
			assertEquals("transition12", transition.getName());
			assertEquals("transition12", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.fg4.fg5.fg6.f6 {ServiceError}", condition.getName());
				assertEquals("fg4.fg5.fg6.f6", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
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
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("f1 {CommonErrors}", condition.getName());
				assertEquals("f1", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("access {CommonErrors}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("point1 {CommonErrors}", condition.getName());
				assertEquals("point1", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition4", transition.getName());
			assertEquals("transition4", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("processor {CommonErrors}", condition.getName());
				assertEquals("processor", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
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
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("fg1.f1 {CommonErrors}", condition.getName());
				assertEquals("fg1.f1", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("fg1.fg2.fg3.f2 {CommonErrors}", condition.getName());
				assertEquals("fg1.fg2.fg3.f2", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
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
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.f1 {CommonErrors}", condition.getName());
				assertEquals("f1", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition02", transition.getName());
			assertEquals("transition02", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.access {CommonErrors}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition03", transition.getName());
			assertEquals("transition03", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.point1 {CommonErrors}", condition.getName());
				assertEquals("point1", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition04", transition.getName());
			assertEquals("transition04", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.processor {CommonErrors}", condition.getName());
				assertEquals("processor", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(4), transition -> {
			assertEquals("transition05", transition.getName());
			assertEquals("transition05", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.fg1.f2 {CommonErrors}", condition.getName());
				assertEquals("fg1.f2", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(5), transition -> {
			assertEquals("transition06", transition.getName());
			assertEquals("transition06", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.fg1.fg2.fg3.f3 {CommonErrors}", condition.getName());
				assertEquals("fg1.fg2.fg3.f3", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(6), transition -> {
			assertEquals("transition07", transition.getName());
			assertEquals("transition07", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.f4 {CommonErrors}", condition.getName());
				assertEquals("f4", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(7), transition -> {
			assertEquals("transition08", transition.getName());
			assertEquals("transition08", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.access {CommonErrors}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(8), transition -> {
			assertEquals("transition09", transition.getName());
			assertEquals("transition09", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.point2 {CommonErrors}", condition.getName());
				assertEquals("point2", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(9), transition -> {
			assertEquals("transition10", transition.getName());
			assertEquals("transition10", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.memory {CommonErrors}", condition.getName());
				assertEquals("memory", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(10), transition -> {
			assertEquals("transition11", transition.getName());
			assertEquals("transition11", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.fg4.f5 {CommonErrors}", condition.getName());
				assertEquals("fg4.f5", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(11), transition -> {
			assertEquals("transition12", transition.getName());
			assertEquals("transition12", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((ConditionPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.fg4.fg5.fg6.f6 {CommonErrors}", condition.getName());
				assertEquals("fg4.fg5.fg6.f6", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
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
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("access {noerror}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("point1 {noerror}", condition.getName());
				assertEquals("point1", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition4", transition.getName());
			assertEquals("transition4", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("processor {noerror}", condition.getName());
				assertEquals("processor", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
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
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("fg1.fg2.fg3.f2 {noerror}", condition.getName());
				assertEquals("fg1.fg2.fg3.f2", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
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
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition02", transition.getName());
			assertEquals("transition02", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.access {noerror}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition03", transition.getName());
			assertEquals("transition03", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.point1 {noerror}", condition.getName());
				assertEquals("point1", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition04", transition.getName());
			assertEquals("transition04", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.processor {noerror}", condition.getName());
				assertEquals("processor", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(4), transition -> {
			assertEquals("transition05", transition.getName());
			assertEquals("transition05", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.fg1.f2 {noerror}", condition.getName());
				assertEquals("fg1.f2", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(5), transition -> {
			assertEquals("transition06", transition.getName());
			assertEquals("transition06", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.fg1.fg2.fg3.f3 {noerror}", condition.getName());
				assertEquals("fg1.fg2.fg3.f3", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(6), transition -> {
			assertEquals("transition07", transition.getName());
			assertEquals("transition07", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.f4 {noerror}", condition.getName());
				assertEquals("f4", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(7), transition -> {
			assertEquals("transition08", transition.getName());
			assertEquals("transition08", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.access {noerror}", condition.getName());
				assertEquals("access", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(8), transition -> {
			assertEquals("transition09", transition.getName());
			assertEquals("transition09", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.point2 {noerror}", condition.getName());
				assertEquals("point2", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(9), transition -> {
			assertEquals("transition10", transition.getName());
			assertEquals("transition10", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.memory {noerror}", condition.getName());
				assertEquals("memory", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(10), transition -> {
			assertEquals("transition11", transition.getName());
			assertEquals("transition11", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.fg4.f5 {noerror}", condition.getName());
				assertEquals("fg4.f5", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(11), transition -> {
			assertEquals("transition12", transition.getName());
			assertEquals("transition12", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((NoErrorPropagationReference) transition.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.fg4.fg5.fg6.f6 {noerror}", condition.getName());
				assertEquals("fg4.fg5.fg6.f6", condition.getPropagation().getName());
			});
			assertEquals("state2", transition.getDestination().getName());
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
			with((CountExpression) transition.getCondition(), condition -> {
				assertEquals("count(error1, error2) >= 1", condition.getName());
				assertIterableEquals(List.of("error1", "error2"),
						condition.getOperands().stream().map(NamedElement::getName).toList());
				assertEquals(CountExpressionOperation.GREATER_EQUAL, condition.getOperation());
				assertEquals(1, condition.getCount());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((CountExpression) transition.getCondition(), condition -> {
				assertEquals("count(count(count(error3, error4) >= 1, error5) >= 1, error6) >= 1", condition.getName());
				assertEquals(2, condition.getOperands().size());
				with((CountExpression) condition.getOperands().get(0), nested1 -> {
					assertEquals("count(count(error3, error4) >= 1, error5) >= 1", nested1.getName());
					assertEquals(2, nested1.getOperands().size());
					with((CountExpression) nested1.getOperands().get(0), nested2 -> {
						assertEquals("count(error3, error4) >= 1", nested2.getName());
						assertIterableEquals(List.of("error3", "error4"),
								nested2.getOperands().stream().map(NamedElement::getName).toList());
						assertEquals(CountExpressionOperation.GREATER_EQUAL, nested2.getOperation());
						assertEquals(1, nested2.getCount());
					});
					assertEquals("error5", nested1.getOperands().get(1).getName());
					assertEquals(CountExpressionOperation.GREATER_EQUAL, nested1.getOperation());
					assertEquals(1, nested1.getCount());
				});
				assertEquals("error6", condition.getOperands().get(1).getName());
				assertEquals(CountExpressionOperation.GREATER_EQUAL, condition.getOperation());
				assertEquals(1, condition.getCount());
			});
			assertEquals("state2", transition.getDestination().getName());
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
			with((CountExpression) transition.getCondition(), condition -> {
				assertEquals("count(error1, error2) == 2", condition.getName());
				assertIterableEquals(List.of("error1", "error2"),
						condition.getOperands().stream().map(NamedElement::getName).toList());
				assertEquals(CountExpressionOperation.EQUALS, condition.getOperation());
				assertEquals(2, condition.getCount());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((CountExpression) transition.getCondition(), condition -> {
				assertEquals("count(count(count(error3, error4) == 2, error5) == 2, error6) == 2", condition.getName());
				assertEquals(2, condition.getOperands().size());
				with((CountExpression) condition.getOperands().get(0), nested1 -> {
					assertEquals("count(count(error3, error4) == 2, error5) == 2", nested1.getName());
					assertEquals(2, nested1.getOperands().size());
					with((CountExpression) nested1.getOperands().get(0), nested2 -> {
						assertEquals("count(error3, error4) == 2", nested2.getName());
						assertIterableEquals(List.of("error3", "error4"),
								nested2.getOperands().stream().map(NamedElement::getName).toList());
						assertEquals(CountExpressionOperation.EQUALS, nested2.getOperation());
						assertEquals(2, nested2.getCount());
					});
					assertEquals("error5", nested1.getOperands().get(1).getName());
					assertEquals(CountExpressionOperation.EQUALS, nested1.getOperation());
					assertEquals(2, nested1.getCount());
				});
				assertEquals("error6", condition.getOperands().get(1).getName());
				assertEquals(CountExpressionOperation.EQUALS, condition.getOperation());
				assertEquals(2, condition.getCount());
			});
			assertEquals("state2", transition.getDestination().getName());
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
			with((CountExpression) transition.getCondition(), condition -> {
				assertEquals("count(error1) == 1", condition.getName());
				assertIterableEquals(List.of("error1"),
						condition.getOperands().stream().map(NamedElement::getName).toList());
				assertEquals(CountExpressionOperation.EQUALS, condition.getOperation());
				assertEquals(1, condition.getCount());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((CountExpression) transition.getCondition(), condition -> {
				assertEquals("count(error2, error3, error4) == 3", condition.getName());
				assertIterableEquals(List.of("error2", "error3", "error4"),
						condition.getOperands().stream().map(NamedElement::getName).toList());
				assertEquals(CountExpressionOperation.EQUALS, condition.getOperation());
				assertEquals(3, condition.getCount());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((CountExpression) transition.getCondition(), condition -> {
				assertEquals("count(error5, error6, error7, error8, error9) == 3", condition.getName());
				assertIterableEquals(List.of("error5", "error6", "error7", "error8", "error9"),
						condition.getOperands().stream().map(NamedElement::getName).toList());
				assertEquals(CountExpressionOperation.EQUALS, condition.getOperation());
				assertEquals(3, condition.getCount());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
	}

	@Test
	public void testOrMoreExpression() throws Exception {
		var pkg = testHelper.parseFile(PATH + "or_more_expression.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((CountExpression) transition.getCondition(), condition -> {
				assertEquals("count(error1, error2, error3, error4, error5) >= 3", condition.getName());
				assertIterableEquals(List.of("error1", "error2", "error3", "error4", "error5"),
						condition.getOperands().stream().map(NamedElement::getName).toList());
				assertEquals(CountExpressionOperation.GREATER_EQUAL, condition.getOperation());
				assertEquals(3, condition.getCount());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
	}

	@Test
	public void testOrLessExpression() throws Exception {
		var pkg = testHelper.parseFile(PATH + "or_less_expression.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			with((CountExpression) transition.getCondition(), condition -> {
				assertEquals("count(error1, error2, error3, error4, error5) <= 3", condition.getName());
				assertIterableEquals(List.of("error1", "error2", "error3", "error4", "error5"),
						condition.getOperands().stream().map(NamedElement::getName).toList());
				assertEquals(CountExpressionOperation.LESS_EQUAL, condition.getOperation());
				assertEquals(3, condition.getCount());
			});
			assertEquals("state2", transition.getDestination().getName());
		});
	}

	@Test
	public void testUntypedDestination() throws Exception {
		var pkg = testHelper.parseFile(PATH + "untyped_destination.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state2", destination.getName());
				assertEquals("state2", destination.getState().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state3 {ServiceError}", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state4", destination.getName());
				assertEquals("state4", destination.getState().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
	}

	@Test
	public void testTypedDestinationWithType() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_destination_with_type.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state2 {ServiceError}", destination.getName());
				assertEquals("state2", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
	}

	@Test
	public void testTypedDestinationTypeFromSource() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_destination_type_from_source.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(8, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1 {ServiceError}", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state2 {ServiceError}", destination.getName());
				assertEquals("state2", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state3 {ServiceError}", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state4 {ServiceError}", destination.getName());
				assertEquals("state4", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("state5 {ServiceError}", transition.getSource().getName());
			assertEquals("error2", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state6 {ServiceError}", destination.getName());
				assertEquals("state6", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition4", transition.getName());
			assertEquals("transition4", transition.getTransition().getName());
			assertEquals("state7 {ServiceError}", transition.getSource().getName());
			assertEquals("error2", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state8 {ServiceError}", destination.getName());
				assertEquals("state8", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getTransitions().get(4), transition -> {
			assertEquals("transition5", transition.getName());
			assertEquals("transition5", transition.getTransition().getName());
			assertEquals("state9 {ServiceError}", transition.getSource().getName());
			assertEquals("f1 {noerror}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state10 {ServiceError}", destination.getName());
				assertEquals("state10", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getTransitions().get(5), transition -> {
			assertEquals("transition6", transition.getName());
			assertEquals("transition6", transition.getTransition().getName());
			assertEquals("state11 {ServiceError}", transition.getSource().getName());
			assertEquals("f2 {noerror}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state12 {ServiceError}", destination.getName());
				assertEquals("state12", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getTransitions().get(6), transition -> {
			assertEquals("transition7", transition.getName());
			assertEquals("transition7", transition.getTransition().getName());
			assertEquals("state13 {ServiceError}", transition.getSource().getName());
			assertEquals("sub1.f3 {noerror}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state14 {ServiceError}", destination.getName());
				assertEquals("state14", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getTransitions().get(7), transition -> {
			assertEquals("transition8", transition.getName());
			assertEquals("transition8", transition.getTransition().getName());
			assertEquals("state15 {ServiceError}", transition.getSource().getName());
			assertEquals("sub1.f4 {noerror}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state16 {ServiceError}", destination.getName());
				assertEquals("state16", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
	}

	@Test
	public void testTypedDestinationTypeFromCondition() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_destination_type_from_condition.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(6, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			assertEquals("error1 {ServiceError}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state2 {ServiceError}", destination.getName());
				assertEquals("state2", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state3", transition.getSource().getName());
			assertEquals("f1 {ServiceError}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state4 {ServiceError}", destination.getName());
				assertEquals("state4", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("state5", transition.getSource().getName());
			assertEquals("sub1.f3 {ServiceError}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state6 {ServiceError}", destination.getName());
				assertEquals("state6", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition4", transition.getName());
			assertEquals("transition4", transition.getTransition().getName());
			assertEquals("state7", transition.getSource().getName());
			assertEquals("error2 {ServiceError}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state8 {ServiceError}", destination.getName());
				assertEquals("state8", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getTransitions().get(4), transition -> {
			assertEquals("transition5", transition.getName());
			assertEquals("transition5", transition.getTransition().getName());
			assertEquals("state9", transition.getSource().getName());
			assertEquals("f2 {ServiceError}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state10 {ServiceError}", destination.getName());
				assertEquals("state10", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getTransitions().get(5), transition -> {
			assertEquals("transition6", transition.getName());
			assertEquals("transition6", transition.getTransition().getName());
			assertEquals("state11", transition.getSource().getName());
			assertEquals("sub1.f4 {ServiceError}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state12 {ServiceError}", destination.getName());
				assertEquals("state12", destination.getState().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
	}

	@Test
	public void testTypedDestinationCannotDetermineType() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_destination_cannot_determine_type.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(8, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1 {ServiceError}", transition.getSource().getName());
			assertEquals("error1 {ItemTimingError}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state2", destination.getName());
				assertEquals("state2", destination.getState().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state3 {CommonErrors}", transition.getSource().getName());
			assertEquals("error1 {CommonErrors}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state4", destination.getName());
				assertEquals("state4", destination.getState().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("state5 {ServiceError, ItemTimingError}", transition.getSource().getName());
			assertEquals("error2", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state6", destination.getName());
				assertEquals("state6", destination.getState().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition4", transition.getName());
			assertEquals("transition4", transition.getTransition().getName());
			assertEquals("state7", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state8", destination.getName());
				assertEquals("state8", destination.getState().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getTransitions().get(4), transition -> {
			assertEquals("transition5", transition.getName());
			assertEquals("transition5", transition.getTransition().getName());
			assertEquals("state9", transition.getSource().getName());
			assertEquals("f1 {noerror}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state10", destination.getName());
				assertEquals("state10", destination.getState().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getTransitions().get(5), transition -> {
			assertEquals("transition6", transition.getName());
			assertEquals("transition6", transition.getTransition().getName());
			assertEquals("state11", transition.getSource().getName());
			assertEquals("sub1.f2 {noerror}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state12", destination.getName());
				assertEquals("state12", destination.getState().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getTransitions().get(6), transition -> {
			assertEquals("transition7", transition.getName());
			assertEquals("transition7", transition.getTransition().getName());
			assertEquals("all", transition.getSource().getName());
			assertEquals("error1 {CommonErrors}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state13", destination.getName());
				assertEquals("state13", destination.getState().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getTransitions().get(7), transition -> {
			assertEquals("transition8", transition.getName());
			assertEquals("transition8", transition.getTransition().getName());
			assertEquals("state14", transition.getSource().getName());
			assertEquals("error1 {ServiceError, ItemTimingError}", transition.getCondition().getName());
			with((DestinationStateReference) transition.getDestination(), destination -> {
				assertEquals("state15", destination.getName());
				assertEquals("state15", destination.getState().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
	}

	@Test
	public void testSameState() throws Exception {
		var pkg = testHelper.parseFile(PATH + "same_state.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((SameState) transition.getDestination(), destination -> {
				assertEquals("same state", destination.getName());
			});
		});
	}

	@Test
	public void testBranchProbabilities() throws Exception {
		var pkg = testHelper.parseFile(PATH + "branch_probabilities.aadl", PATH + "my_set.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(4, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state2 with 0.20001, state3 with 0.79999)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state2 with 0.20001", branch.getName());
					assertEquals("state2", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.20001")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state3 with 0.79999", branch.getName());
					assertEquals("state3", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.79999")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
			assertEquals("transition2", transition.getTransition().getName());
			assertEquals("state4", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state5 with my_set::my_real, state6 with my_set::my_real)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state5 with my_set::my_real", branch.getName());
					assertEquals("state5", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertNull(branch.getProbability());
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state6 with my_set::my_real", branch.getName());
					assertEquals("state6", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertNull(branch.getProbability());
				});
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("transition3", transition.getName());
			assertEquals("transition3", transition.getTransition().getName());
			assertEquals("state7", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state8 with 0.1, state9 with 0.2, state10 with 0.7)", destination.getName());
				assertEquals(3, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state8 with 0.1", branch.getName());
					assertEquals("state8", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state9 with 0.2", branch.getName());
					assertEquals("state9", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.2")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(2), branch -> {
					assertEquals("state10 with 0.7", branch.getName());
					assertEquals("state10", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.7")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("transition4", transition.getName());
			assertEquals("transition4", transition.getTransition().getName());
			assertEquals("state11", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state12 with my_set::my_real, state13 with 0.25, state14 with others)",
						destination.getName());
				assertEquals(3, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state12 with my_set::my_real", branch.getName());
					assertEquals("state12", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertNull(branch.getProbability());
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state13 with 0.25", branch.getName());
					assertEquals("state13", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.25")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(2), branch -> {
					assertEquals("state14 with others", branch.getName());
					assertEquals("state14", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertNull(branch.getProbability());
				});
			});
		});
	}

	@Test
	public void testBranchStateReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "branch_state_reference.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(25, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("cannot_determine_type_1", transition.getName());
			assertEquals("cannot_determine_type_1", transition.getTransition().getName());
			assertEquals("state49 {ServiceError}", transition.getSource().getName());
			assertEquals("error2 {ItemTimingError}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state50 with 0.1, state51 with 0.9)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state50 with 0.1", branch.getName());
					assertEquals("state50", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state51 with 0.9", branch.getName());
					assertEquals("state51", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("cannot_determine_type_2", transition.getName());
			assertEquals("cannot_determine_type_2", transition.getTransition().getName());
			assertEquals("state52 {CommonErrors}", transition.getSource().getName());
			assertEquals("error2 {CommonErrors}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state53 with 0.1, state54 with 0.9)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state53 with 0.1", branch.getName());
					assertEquals("state53", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state54 with 0.9", branch.getName());
					assertEquals("state54", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			assertEquals("cannot_determine_type_3", transition.getName());
			assertEquals("cannot_determine_type_3", transition.getTransition().getName());
			assertEquals("state55 {ServiceError, ItemTimingError}", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state56 with 0.1, state57 with 0.9)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state56 with 0.1", branch.getName());
					assertEquals("state56", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state57 with 0.9", branch.getName());
					assertEquals("state57", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(3), transition -> {
			assertEquals("cannot_determine_type_4", transition.getName());
			assertEquals("cannot_determine_type_4", transition.getTransition().getName());
			assertEquals("state58", transition.getSource().getName());
			assertEquals("error2", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state59 with 0.1, state60 with 0.9)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state59 with 0.1", branch.getName());
					assertEquals("state59", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state60 with 0.9", branch.getName());
					assertEquals("state60", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(4), transition -> {
			assertEquals("cannot_determine_type_5", transition.getName());
			assertEquals("cannot_determine_type_5", transition.getTransition().getName());
			assertEquals("state61", transition.getSource().getName());
			assertEquals("f1 {noerror}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state62 with 0.1, state63 with 0.9)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state62 with 0.1", branch.getName());
					assertEquals("state62", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state63 with 0.9", branch.getName());
					assertEquals("state63", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(5), transition -> {
			assertEquals("cannot_determine_type_6", transition.getName());
			assertEquals("cannot_determine_type_6", transition.getTransition().getName());
			assertEquals("state64", transition.getSource().getName());
			assertEquals("sub1.f4 {noerror}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state65 with 0.1, state66 with 0.9)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state65 with 0.1", branch.getName());
					assertEquals("state65", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state66 with 0.9", branch.getName());
					assertEquals("state66", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(6), transition -> {
			assertEquals("cannot_determine_type_7", transition.getName());
			assertEquals("cannot_determine_type_7", transition.getTransition().getName());
			assertEquals("all", transition.getSource().getName());
			assertEquals("error2 {CommonErrors}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state67 with 0.1, state68 with 0.9)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state67 with 0.1", branch.getName());
					assertEquals("state67", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state68 with 0.9", branch.getName());
					assertEquals("state68", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(7), transition -> {
			assertEquals("cannot_determine_type_8", transition.getName());
			assertEquals("cannot_determine_type_8", transition.getTransition().getName());
			assertEquals("state69", transition.getSource().getName());
			assertEquals("error2 {ServiceError, ItemTimingError}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state70 with 0.1, state71 with 0.9)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state70 with 0.1", branch.getName());
					assertEquals("state70", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state71 with 0.9", branch.getName());
					assertEquals("state71", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(8), transition -> {
			assertEquals("from_condition_1", transition.getName());
			assertEquals("from_condition_1", transition.getTransition().getName());
			assertEquals("state31", transition.getSource().getName());
			assertEquals("error2 {ServiceError}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state32 {ServiceError} with 0.1, state33 {ServiceError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state32 {ServiceError} with 0.1", branch.getName());
					assertEquals("state32", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state33 {ServiceError} with 0.9", branch.getName());
					assertEquals("state33", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(9), transition -> {
			assertEquals("from_condition_2", transition.getName());
			assertEquals("from_condition_2", transition.getTransition().getName());
			assertEquals("state34", transition.getSource().getName());
			assertEquals("f1 {ServiceError}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state35 {ServiceError} with 0.1, state36 {ServiceError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state35 {ServiceError} with 0.1", branch.getName());
					assertEquals("state35", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state36 {ServiceError} with 0.9", branch.getName());
					assertEquals("state36", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(10), transition -> {
			assertEquals("from_condition_3", transition.getName());
			assertEquals("from_condition_3", transition.getTransition().getName());
			assertEquals("state37", transition.getSource().getName());
			assertEquals("sub1.f4 {ServiceError}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state38 {ServiceError} with 0.1, state39 {ServiceError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state38 {ServiceError} with 0.1", branch.getName());
					assertEquals("state38", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state39 {ServiceError} with 0.9", branch.getName());
					assertEquals("state39", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(11), transition -> {
			assertEquals("from_condition_4", transition.getName());
			assertEquals("from_condition_4", transition.getTransition().getName());
			assertEquals("state40", transition.getSource().getName());
			assertEquals("error3 {ServiceError}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state41 {ServiceError} with 0.1, state42 {ServiceError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state41 {ServiceError} with 0.1", branch.getName());
					assertEquals("state41", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state42 {ServiceError} with 0.9", branch.getName());
					assertEquals("state42", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(12), transition -> {
			assertEquals("from_condition_5", transition.getName());
			assertEquals("from_condition_5", transition.getTransition().getName());
			assertEquals("state43", transition.getSource().getName());
			assertEquals("f3 {ServiceError}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state44 {ServiceError} with 0.1, state45 {ServiceError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state44 {ServiceError} with 0.1", branch.getName());
					assertEquals("state44", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state45 {ServiceError} with 0.9", branch.getName());
					assertEquals("state45", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(13), transition -> {
			assertEquals("from_condition_6", transition.getName());
			assertEquals("from_condition_6", transition.getTransition().getName());
			assertEquals("state46", transition.getSource().getName());
			assertEquals("sub1.f6 {ServiceError}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state47 {ServiceError} with 0.1, state48 {ServiceError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state47 {ServiceError} with 0.1", branch.getName());
					assertEquals("state47", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state48 {ServiceError} with 0.9", branch.getName());
					assertEquals("state48", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(14), transition -> {
			assertEquals("from_source_1", transition.getName());
			assertEquals("from_source_1", transition.getTransition().getName());
			assertEquals("state7 {ServiceError}", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state8 {ServiceError} with 0.1, state9 {ServiceError} with 0.9)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state8 {ServiceError} with 0.1", branch.getName());
					assertEquals("state8", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state9 {ServiceError} with 0.9", branch.getName());
					assertEquals("state9", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(15), transition -> {
			assertEquals("from_source_2", transition.getName());
			assertEquals("from_source_2", transition.getTransition().getName());
			assertEquals("state10 {ServiceError}", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state11 {ServiceError} with 0.1, state12 {ServiceError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state11 {ServiceError} with 0.1", branch.getName());
					assertEquals("state11", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state12 {ServiceError} with 0.9", branch.getName());
					assertEquals("state12", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(16), transition -> {
			assertEquals("from_source_3", transition.getName());
			assertEquals("from_source_3", transition.getTransition().getName());
			assertEquals("state13 {ServiceError}", transition.getSource().getName());
			assertEquals("error2", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state14 {ServiceError} with 0.1, state15 {ServiceError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state14 {ServiceError} with 0.1", branch.getName());
					assertEquals("state14", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state15 {ServiceError} with 0.9", branch.getName());
					assertEquals("state15", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(17), transition -> {
			assertEquals("from_source_4", transition.getName());
			assertEquals("from_source_4", transition.getTransition().getName());
			assertEquals("state16 {ServiceError}", transition.getSource().getName());
			assertEquals("error2", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state17 {ServiceError} with 0.1, state18 {ServiceError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state17 {ServiceError} with 0.1", branch.getName());
					assertEquals("state17", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state18 {ServiceError} with 0.9", branch.getName());
					assertEquals("state18", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(18), transition -> {
			assertEquals("from_source_5", transition.getName());
			assertEquals("from_source_5", transition.getTransition().getName());
			assertEquals("state19 {ServiceError}", transition.getSource().getName());
			assertEquals("f1 {noerror}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state20 {ServiceError} with 0.1, state21 {ServiceError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state20 {ServiceError} with 0.1", branch.getName());
					assertEquals("state20", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state21 {ServiceError} with 0.9", branch.getName());
					assertEquals("state21", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(19), transition -> {
			assertEquals("from_source_6", transition.getName());
			assertEquals("from_source_6", transition.getTransition().getName());
			assertEquals("state22 {ServiceError}", transition.getSource().getName());
			assertEquals("f2 {noerror}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state23 {ServiceError} with 0.1, state24 {ServiceError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state23 {ServiceError} with 0.1", branch.getName());
					assertEquals("state23", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state24 {ServiceError} with 0.9", branch.getName());
					assertEquals("state24", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(20), transition -> {
			assertEquals("from_source_7", transition.getName());
			assertEquals("from_source_7", transition.getTransition().getName());
			assertEquals("state25 {ServiceError}", transition.getSource().getName());
			assertEquals("sub1.f4 {noerror}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state26 {ServiceError} with 0.1, state27 {ServiceError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state26 {ServiceError} with 0.1", branch.getName());
					assertEquals("state26", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state27 {ServiceError} with 0.9", branch.getName());
					assertEquals("state27", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(21), transition -> {
			assertEquals("from_source_8", transition.getName());
			assertEquals("from_source_8", transition.getTransition().getName());
			assertEquals("state28 {ServiceError}", transition.getSource().getName());
			assertEquals("sub1.f5 {noerror}", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state29 {ServiceError} with 0.1, state30 {ServiceError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state29 {ServiceError} with 0.1", branch.getName());
					assertEquals("state29", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state30 {ServiceError} with 0.9", branch.getName());
					assertEquals("state30", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(22), transition -> {
			assertEquals("untyped_1", transition.getName());
			assertEquals("untyped_1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state2 with 0.1, state3 with 0.9)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state2 with 0.1", branch.getName());
					assertEquals("state2", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state3 with 0.9", branch.getName());
					assertEquals("state3", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(23), transition -> {
			assertEquals("untyped_2", transition.getName());
			assertEquals("untyped_2", transition.getTransition().getName());
			assertEquals("state_a {ServiceError}", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state_b with 0.1, state_c with 0.9)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state_b with 0.1", branch.getName());
					assertEquals("state_b", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state_c with 0.9", branch.getName());
					assertEquals("state_c", branch.getState().getName());
					assertNull(branch.getTypeSet());
					assertNull(branch.getTypeToken());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
		with(annexInstance.getTransitions().get(24), transition -> {
			assertEquals("with_type", transition.getName());
			assertEquals("with_type", transition.getTransition().getName());
			assertEquals("state4", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state5 {ServiceError} with 0.1, state6 {ItemTimingError} with 0.9)",
						destination.getName());
				assertEquals(2, destination.getBranches().size());
				with((BranchStateReference) destination.getBranches().get(0), branch -> {
					assertEquals("state5 {ServiceError} with 0.1", branch.getName());
					assertEquals("state5", branch.getState().getName());
					assertEquals("{ServiceError}", branch.getTypeSet().getName());
					assertEquals("ServiceError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.1")) == 0);
				});
				with((BranchStateReference) destination.getBranches().get(1), branch -> {
					assertEquals("state6 {ItemTimingError} with 0.9", branch.getName());
					assertEquals("state6", branch.getState().getName());
					assertEquals("{ItemTimingError}", branch.getTypeSet().getName());
					assertEquals("ItemTimingError", branch.getTypeToken().getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
	}

	@Test
	public void testBranchSameState() throws Exception {
		var pkg = testHelper.parseFile(PATH + "branch_same_state.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getTransitions().size());
		with(annexInstance.getTransitions().get(0), transition -> {
			assertEquals("transition1", transition.getName());
			assertEquals("transition1", transition.getTransition().getName());
			assertEquals("state1", transition.getSource().getName());
			assertEquals("error1", transition.getCondition().getName());
			with((Branches) transition.getDestination(), destination -> {
				assertEquals("(state2 with 0.1, same state with 0.9)", destination.getName());
				assertEquals(2, destination.getBranches().size());
				assertEquals("state2 with 0.1", destination.getBranches().get(0).getName());
				with((BranchSameState) destination.getBranches().get(1), branch -> {
					assertEquals("same state with 0.9", branch.getName());
					assertTrue(branch.getProbability().compareTo(new BigDecimal("0.9")) == 0);
				});
			});
		});
	}
}