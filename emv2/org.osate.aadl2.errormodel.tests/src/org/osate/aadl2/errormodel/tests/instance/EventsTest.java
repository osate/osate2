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
import org.osate.aadl2.errormodel.instance.ErrorEventInstance;
import org.osate.aadl2.errormodel.instance.RecoverEventInstance;
import org.osate.aadl2.errormodel.instance.RepairEventInstance;
import org.osate.aadl2.errormodel.instance.instantiator.EMV2AnnexInstantiator;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class EventsTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/Events/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@BeforeAll
	public static void enableEMV2Instantiator() {
		System.setProperty(EMV2AnnexInstantiator.PROPERTY_NAME, "true");
	}

	@Test
	public void testErrorEventsInStateMachine() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_events_in_state_machine.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(4, annexInstance.getEvents().size());
		with((ErrorEventInstance) annexInstance.getEvents().get(0), event -> {
			assertEquals("event1", event.getName());
			assertEquals("event1", event.getErrorEvent().getName());
			assertNull(event.getTypeSet());
		});
		with((ErrorEventInstance) annexInstance.getEvents().get(1), event -> {
			assertEquals("event2", event.getName());
			assertEquals("event2", event.getErrorEvent().getName());
			assertEquals("{ServiceError}", event.getTypeSet().getName());
		});
		with((ErrorEventInstance) annexInstance.getEvents().get(2), event -> {
			assertEquals("event3", event.getName());
			assertEquals("event3", event.getErrorEvent().getName());
			assertNull(event.getTypeSet());
		});
		with((ErrorEventInstance) annexInstance.getEvents().get(3), event -> {
			assertEquals("event4", event.getName());
			assertEquals("event4", event.getErrorEvent().getName());
			assertEquals("{ItemTimingError, ItemValueError}", event.getTypeSet().getName());
		});
	}

	@Test
	public void testErrorEventsInComponentErrorBehavior() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_events_in_component_error_behavior.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(4, annexInstance.getEvents().size());
		with((ErrorEventInstance) annexInstance.getEvents().get(0), event -> {
			assertEquals("event1", event.getName());
			assertEquals("event1", event.getErrorEvent().getName());
			assertNull(event.getTypeSet());
		});
		with((ErrorEventInstance) annexInstance.getEvents().get(1), event -> {
			assertEquals("event2", event.getName());
			assertEquals("event2", event.getErrorEvent().getName());
			assertEquals("{ServiceError}", event.getTypeSet().getName());
		});
		with((ErrorEventInstance) annexInstance.getEvents().get(2), event -> {
			assertEquals("event3", event.getName());
			assertEquals("event3", event.getErrorEvent().getName());
			assertNull(event.getTypeSet());
		});
		with((ErrorEventInstance) annexInstance.getEvents().get(3), event -> {
			assertEquals("event4", event.getName());
			assertEquals("event4", event.getErrorEvent().getName());
			assertEquals("{ItemTimingError, ItemValueError}", event.getTypeSet().getName());
		});
	}

	@Test
	public void testRecoverEventsInStateMachine() throws Exception {
		var pkg = testHelper.parseFile(PATH + "recover_events_in_state_machine.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getEvents().size());
		with((RecoverEventInstance) annexInstance.getEvents().get(0), event -> {
			assertEquals("recover1", event.getName());
			assertEquals("recover1", event.getRecoverEvent().getName());
		});
		with((RecoverEventInstance) annexInstance.getEvents().get(1), event -> {
			assertEquals("recover2", event.getName());
			assertEquals("recover2", event.getRecoverEvent().getName());
		});
	}

	@Test
	public void testRepairEventsInStateMachine() throws Exception {
		var pkg = testHelper.parseFile(PATH + "repair_events_in_state_machine.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getEvents().size());
		with((RepairEventInstance) annexInstance.getEvents().get(0), event -> {
			assertEquals("repair1", event.getName());
			assertEquals("repair1", event.getRepairEvent().getName());
		});
	}
}