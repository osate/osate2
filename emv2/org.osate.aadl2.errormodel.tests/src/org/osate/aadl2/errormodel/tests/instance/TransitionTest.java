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
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			assertEquals("transition2", transition.getName());
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
		});
		with(annexInstance.getTransitions().get(1), transition -> {
			// TODO Update after we generate names for unnamed transitions.
			assertNull(transition.getName());
		});
		with(annexInstance.getTransitions().get(2), transition -> {
			// TODO Update after we generate names for unnamed transitions.
			assertNull(transition.getName());
		});
	}
}