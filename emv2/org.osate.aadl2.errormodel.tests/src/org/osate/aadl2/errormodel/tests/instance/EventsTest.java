/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.ErrorEventInstance;
import org.osate.aadl2.errormodel.instance.RecoverEventInstance;
import org.osate.aadl2.errormodel.instance.RepairEventInstance;
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
			assertEquals(0, event.getEventInitiators().size());
		});
		with((RecoverEventInstance) annexInstance.getEvents().get(1), event -> {
			assertEquals("recover2", event.getName());
			assertEquals("recover2", event.getRecoverEvent().getName());
			assertEquals(0, event.getEventInitiators().size());
		});
	}

	@Test
	public void testRecoverEventsInComponentErrorBehavior() throws Exception {
		var pkg = testHelper.parseFile(PATH + "recover_events_in_component_error_behavior.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(7, annexInstance.getEvents().size());
		with((RecoverEventInstance) annexInstance.getEvents().get(0), event -> {
			assertEquals("recover1", event.getName());
			assertEquals("recover1", event.getRecoverEvent().getName());
			assertEquals(0, event.getEventInitiators().size());
		});
		with((RecoverEventInstance) annexInstance.getEvents().get(1), event -> {
			assertEquals("recover2", event.getName());
			assertEquals("recover2", event.getRecoverEvent().getName());
			assertIterableEquals(List.of("ep1"),
					event.getEventInitiators().stream().map(NamedElement::getName).toList());
		});
		with((RecoverEventInstance) annexInstance.getEvents().get(2), event -> {
			assertEquals("recover3", event.getName());
			assertEquals("recover3", event.getRecoverEvent().getName());
			assertIterableEquals(List.of("mt1"),
					event.getEventInitiators().stream().map(NamedElement::getName).toList());
		});
		with((RecoverEventInstance) annexInstance.getEvents().get(3), event -> {
			assertEquals("recover4", event.getName());
			assertEquals("recover4", event.getRecoverEvent().getName());
			assertEquals(0, event.getEventInitiators().size());
		});
		with((RecoverEventInstance) annexInstance.getEvents().get(4), event -> {
			assertEquals("recover5", event.getName());
			assertEquals("recover5", event.getRecoverEvent().getName());
			assertIterableEquals(List.of("ep1", "mt1"),
					event.getEventInitiators().stream().map(NamedElement::getName).toList());
		});
		with((RecoverEventInstance) annexInstance.getEvents().get(5), event -> {
			assertEquals("recover6", event.getName());
			assertEquals("recover6", event.getRecoverEvent().getName());
			assertEquals(0, event.getEventInitiators().size());
		});
		with((RecoverEventInstance) annexInstance.getEvents().get(6), event -> {
			assertEquals("recover7", event.getName());
			assertEquals("recover7", event.getRecoverEvent().getName());
			assertIterableEquals(List.of("ep1", "mt1"),
					event.getEventInitiators().stream().map(NamedElement::getName).toList());
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
			assertEquals(0, event.getEventInitiators().size());
		});
	}

	@Test
	public void testRepairEventsInComponentErrorBehavior() throws Exception {
		var pkg = testHelper.parseFile(PATH + "repair_events_in_component_error_behavior.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(5, annexInstance.getEvents().size());
		with((RepairEventInstance) annexInstance.getEvents().get(0), event -> {
			assertEquals("repair1", event.getName());
			assertEquals("repair1", event.getRepairEvent().getName());
			assertEquals(0, event.getEventInitiators().size());
		});
		with((RepairEventInstance) annexInstance.getEvents().get(1), event -> {
			assertEquals("repair2", event.getName());
			assertEquals("repair2", event.getRepairEvent().getName());
			assertIterableEquals(List.of("ep1"),
					event.getEventInitiators().stream().map(NamedElement::getName).toList());
		});
		with((RepairEventInstance) annexInstance.getEvents().get(2), event -> {
			assertEquals("repair3", event.getName());
			assertEquals("repair3", event.getRepairEvent().getName());
			assertIterableEquals(List.of("mt1"),
					event.getEventInitiators().stream().map(NamedElement::getName).toList());
		});
		with((RepairEventInstance) annexInstance.getEvents().get(3), event -> {
			assertEquals("repair4", event.getName());
			assertEquals("repair4", event.getRepairEvent().getName());
			assertEquals(0, event.getEventInitiators().size());
		});
		with((RepairEventInstance) annexInstance.getEvents().get(4), event -> {
			assertEquals("repair5", event.getName());
			assertEquals("repair5", event.getRepairEvent().getName());
			assertIterableEquals(List.of("ep1", "mt1"),
					event.getEventInitiators().stream().map(NamedElement::getName).toList());
		});
	}

	@Test
	public void testEventsInStateMachineAndComponentErrorBehavior() throws Exception {
		var pkg = testHelper.parseFile(PATH + "events_in_state_machine_and_component_error_behavior.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(6, annexInstance.getEvents().size());
		with((ErrorEventInstance) annexInstance.getEvents().get(0), event -> {
			assertEquals("error1", event.getName());
			assertEquals("error1", event.getErrorEvent().getName());
			assertNull(event.getTypeSet());
		});
		with((ErrorEventInstance) annexInstance.getEvents().get(1), event -> {
			assertEquals("error2", event.getName());
			assertEquals("error2", event.getErrorEvent().getName());
			assertNull(event.getTypeSet());
		});
		with((RecoverEventInstance) annexInstance.getEvents().get(2), event -> {
			assertEquals("recover1", event.getName());
			assertEquals("recover1", event.getRecoverEvent().getName());
			assertEquals(0, event.getEventInitiators().size());
		});
		with((RecoverEventInstance) annexInstance.getEvents().get(3), event -> {
			assertEquals("recover2", event.getName());
			assertEquals("recover2", event.getRecoverEvent().getName());
			assertEquals(0, event.getEventInitiators().size());
		});
		with((RepairEventInstance) annexInstance.getEvents().get(4), event -> {
			assertEquals("repair1", event.getName());
			assertEquals("repair1", event.getRepairEvent().getName());
			assertEquals(0, event.getEventInitiators().size());
		});
		with((RepairEventInstance) annexInstance.getEvents().get(5), event -> {
			assertEquals("repair2", event.getName());
			assertEquals("repair2", event.getRepairEvent().getName());
			assertEquals(0, event.getEventInitiators().size());
		});
	}

	@Test
	public void testOverrideEventsInheritedFromClassifier() throws Exception {
		var pkg = testHelper.parseFile(PATH + "override_events_inherited_from_classifier.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getEvents().size());
		with((ErrorEventInstance) annexInstance.getEvents().get(0), event -> {
			assertEquals("ERROR1", event.getName());
			assertEquals("ERROR1", event.getErrorEvent().getName());
			assertEquals("{ItemTimingError}", event.getTypeSet().getName());
		});
		with((RecoverEventInstance) annexInstance.getEvents().get(1), event -> {
			assertEquals("RECOVER1", event.getName());
			assertEquals("RECOVER1", event.getRecoverEvent().getName());
			assertIterableEquals(List.of("ep2"),
					event.getEventInitiators().stream().map(NamedElement::getName).toList());
		});
		with((RepairEventInstance) annexInstance.getEvents().get(2), event -> {
			assertEquals("REPAIR1", event.getName());
			assertEquals("REPAIR1", event.getRepairEvent().getName());
			assertIterableEquals(List.of("ep2"),
					event.getEventInitiators().stream().map(NamedElement::getName).toList());
		});
	}

	@Test
	public void testOverrideEventsInheritedFromStateMachine() throws Exception {
		var pkg = testHelper.parseFile(PATH + "override_events_inherited_from_state_machine.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getEvents().size());
		with((ErrorEventInstance) annexInstance.getEvents().get(0), event -> {
			assertEquals("ERROR1", event.getName());
			assertEquals("ERROR1", event.getErrorEvent().getName());
			assertEquals("{ItemTimingError}", event.getTypeSet().getName());
		});
		with((RecoverEventInstance) annexInstance.getEvents().get(1), event -> {
			assertEquals("RECOVER1", event.getName());
			assertEquals("RECOVER1", event.getRecoverEvent().getName());
			assertIterableEquals(List.of("ep1"),
					event.getEventInitiators().stream().map(NamedElement::getName).toList());
		});
		with((RepairEventInstance) annexInstance.getEvents().get(2), event -> {
			assertEquals("REPAIR1", event.getName());
			assertEquals("REPAIR1", event.getRepairEvent().getName());
			assertIterableEquals(List.of("ep1"),
					event.getEventInitiators().stream().map(NamedElement::getName).toList());
		});
	}

	@Test
	public void testConflictingInheritedEvents() throws Exception {
		var pkg = testHelper.parseFile(PATH + "conflicting_inherited_events.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getEvents().size());
		with((ErrorEventInstance) annexInstance.getEvents().get(0), event -> {
			assertEquals("error1", event.getName());
			assertEquals("error1", event.getErrorEvent().getName());
			assertEquals("{ServiceError}", event.getTypeSet().getName());
		});
		with((RecoverEventInstance) annexInstance.getEvents().get(1), event -> {
			assertEquals("recover1", event.getName());
			assertEquals("recover1", event.getRecoverEvent().getName());
			assertEquals(0, event.getEventInitiators().size());
		});
		with((RepairEventInstance) annexInstance.getEvents().get(2), event -> {
			assertEquals("repair1", event.getName());
			assertEquals("repair1", event.getRepairEvent().getName());
			assertEquals(0, event.getEventInitiators().size());
		});
	}
}