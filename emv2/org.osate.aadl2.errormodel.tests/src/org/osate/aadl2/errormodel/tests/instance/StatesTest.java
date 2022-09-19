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
public class StatesTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/States/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@BeforeAll
	public static void enableEMV2Instantiator() {
		System.setProperty(EMV2AnnexInstantiator.PROPERTY_NAME, "true");
	}

	@Test
	public void testErrorStates() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_states.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getStates().size());
		with(annexInstance.getStates().get(0), state -> {
			assertEquals("state1", state.getName());
			assertEquals("state1", state.getState().getName());
			assertNull(state.getTypeSet());
		});
		with(annexInstance.getStates().get(1), state -> {
			assertEquals("state2", state.getName());
			assertEquals("state2", state.getState().getName());
			assertNull(state.getTypeSet());
		});
		with(annexInstance.getStates().get(2), state -> {
			assertEquals("state3", state.getName());
			assertEquals("state3", state.getState().getName());
			assertNull(state.getTypeSet());
		});
		assertEquals("state1", annexInstance.getInitialState().getName());
	}

	@Test
	public void testFirstNotInitial() throws Exception {
		var pkg = testHelper.parseFile(PATH + "first_not_initial.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getStates().size());
		with(annexInstance.getStates().get(0), state -> {
			assertEquals("state1", state.getName());
			assertEquals("state1", state.getState().getName());
			assertNull(state.getTypeSet());
		});
		with(annexInstance.getStates().get(1), state -> {
			assertEquals("state2", state.getName());
			assertEquals("state2", state.getState().getName());
			assertNull(state.getTypeSet());
		});
		with(annexInstance.getStates().get(2), state -> {
			assertEquals("state3", state.getName());
			assertEquals("state3", state.getState().getName());
			assertNull(state.getTypeSet());
		});
		assertEquals("state2", annexInstance.getInitialState().getName());
	}

	@Test
	public void testReferenceToStandardStateMachine() throws Exception {
		var pkg = testHelper.parseFile(PATH + "reference_to_standard_state_machine.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getStates().size());
		with(annexInstance.getStates().get(0), state -> {
			assertEquals("Operational", state.getName());
			assertEquals("Operational", state.getState().getName());
			assertNull(state.getTypeSet());
		});
		with(annexInstance.getStates().get(1), state -> {
			assertEquals("FailStop", state.getName());
			assertEquals("FailStop", state.getState().getName());
			assertNull(state.getTypeSet());
		});
		assertEquals("Operational", annexInstance.getInitialState().getName());
	}

	@Test
	public void testStatesWithTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "states_with_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getStates().size());
		with(annexInstance.getStates().get(0), state -> {
			assertEquals("state1", state.getName());
			assertEquals("state1", state.getState().getName());
			assertEquals("{ServiceError}", state.getTypeSet().getName());
		});
		with(annexInstance.getStates().get(1), state -> {
			assertEquals("state2", state.getName());
			assertEquals("state2", state.getState().getName());
			assertEquals("{ServiceError, ItemTimingError, ReplicationError * ConcurrencyError}",
					state.getTypeSet().getName());
		});
		with(annexInstance.getStates().get(2), state -> {
			assertEquals("state3", state.getName());
			assertEquals("state3", state.getState().getName());
			assertEquals("{TimingRelatedError}", state.getTypeSet().getName());
		});
		assertEquals("state1", annexInstance.getInitialState().getName());
	}
}