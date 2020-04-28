/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.tests.endToEnd;

import static org.osate.ge.internal.services.impl.DeclarativeReferenceBuilder.*;
import static org.osate.ge.tests.endToEnd.util.OsateGePrototypeTestCommands.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestCommands.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestUtil.*;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.*;

import org.eclipse.swt.widgets.Shell;
import org.junit.Test;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.tests.endToEnd.util.DiagramElementReference;
import org.osate.ge.tests.endToEnd.util.DiagramReference;

/**
 * This class is an end to end test focusing on prototypes and prototype bindings.
 */
public class PrototypeEndToEndTest {
	private static final String PROTOTYPE_TEST = "prototype_test";
	private static final String INTERFACES = "interfaces";

	@Test
	public void testPrototypes() {
		createAadlProject(PROTOTYPE_TEST);
		createNewPackageWithPackageDiagram(PROTOTYPE_TEST, PROTOTYPE_TEST);

		createInterfacesPackage();
		createSubsystemTypes();
		createTestSystem();
		createAndEditPrototypes();
	}

	private void createInterfacesPackage() {
		//
		// Create feature group with prototype
		//
		createNewPackageWithPackageDiagram(PROTOTYPE_TEST, INTERFACES);
		final DiagramReference diagram = defaultDiagram(PROTOTYPE_TEST, INTERFACES);
		final DiagramElementReference pkgElement = packageElement(INTERFACES);
		final RelativeBusinessObjectReference pkg = getPackageRelativeReference(INTERFACES);

		createElementAndLayout(diagram, pkgElement, "Feature Group Type",
				getClassifierRelativeReference("new_classifier"), "subsystem_interface");
		final DiagramElementReference subsystemInterface = element(pkg,
				getClassifierRelativeReference("subsystem_interface"));

		// Create Prototypes
		createPrototype(diagram, "subsystem_interface_new_prototype", subsystemInterface);
		renamePrototype(diagram, "subsystem_interface_new_prototype", "message_cpt", subsystemInterface);
		setPrototypeType(diagram, "message_cpt", "Data", subsystemInterface);

		createPrototype(diagram, "subsystem_interface_new_prototype", subsystemInterface);
		renamePrototype(diagram, "subsystem_interface_new_prototype", "event_fpt", subsystemInterface);
		setPrototypeType(diagram, "event_fpt", "Feature", subsystemInterface);

		//
		// Create event data port which uses the message prototype
		//
		createElementAndLayout(diagram, subsystemInterface, "Event Data Port",
				getFeatureRelativeReference("subsystem_interface_new_feature"), "message_out");

		setExtendedOrFeatureClassifierFromPropertiesView(diagram, "interfaces::subsystem_interface.message_cpt",
				element(pkg, getClassifierRelativeReference("subsystem_interface"),
						getFeatureRelativeReference("message_out")));

		// Create an abstract feature that uses the event feature prototype
		createElementAndLayout(diagram, subsystemInterface, "Abstract Feature",
				getFeatureRelativeReference("subsystem_interface_new_feature"), "events");

		// Set direction to output
		setFeatureDirectionFromPropertiesView(diagram, "Bidirectional", element(pkg,
				getClassifierRelativeReference("subsystem_interface"), getFeatureRelativeReference("events")));

		setFeaturePrototypeFromPropertiesView(diagram, "interfaces::subsystem_interface.event_fpt", element(pkg,
				getClassifierRelativeReference("subsystem_interface"), getFeatureRelativeReference("events")));
	}

	private void createSubsystemTypes() {
		final DiagramReference diagram = defaultDiagram(PROTOTYPE_TEST, PROTOTYPE_TEST);
		final DiagramElementReference pkgElement = packageElement(PROTOTYPE_TEST);
		final RelativeBusinessObjectReference pkg = getPackageRelativeReference(PROTOTYPE_TEST);

		// Create subsystem system type
		createElementAndLayout(diagram, pkgElement, "System Type", getClassifierRelativeReference("new_classifier"),
				"subsystem");
		final DiagramElementReference subsystem = element(pkg, getClassifierRelativeReference("subsystem"));

		// Create feature group prototype
		createPrototype(diagram, "subsystem_new_prototype", subsystem);
		renamePrototype(diagram, "subsystem_new_prototype", "iface_pt", subsystem);
		setPrototypeType(diagram, "iface_pt", "Feature Group", subsystem);

		// Create subsystem extension
		createElementAndLayout(diagram, pkgElement, "System Type", getClassifierRelativeReference("new_classifier"),
				"subsystem_ext");
		final DiagramElementReference subsystemExt = element(pkg, getClassifierRelativeReference("subsystem_ext"));
		setExtendedOrFeatureClassifierFromPropertiesView(diagram, "prototype_test::subsystem", subsystemExt);

		// Set bindings
		setClassifierBindingsFromPropertiesView(diagram, () -> {
			// Edit the binding for iface_pt
			clickButton("Choose...", 0);
			waitForWindowWithTitle("Select Classifier and Prototype Bindings");
			selectListItem(0, "interfaces::subsystem_interface");
			clickButton("OK");
		}, subsystemExt);
	}

	// Creates a test system implementation and subsystem which uses the previously created interface feature group and subsystem
	private void createTestSystem() {
		final DiagramReference diagram = defaultDiagram(PROTOTYPE_TEST, PROTOTYPE_TEST);
		final DiagramElementReference pkgElement = packageElement(PROTOTYPE_TEST);
		final RelativeBusinessObjectReference pkg = getPackageRelativeReference(PROTOTYPE_TEST);

		// Create system system implementation
		createImplementationWithNewType(diagram, pkgElement, "System Implementation", "impl", "test_system");

		// Create subsystem subcomponent and set classifier
		createElementAndLayout(diagram, element(pkg, getClassifierRelativeReference("test_system.impl")),
				"System Subcomponent", getSubcomponentRelativeReference("test_system_impl_new_subcomponent"), "ss");
		setSubcomponentClassifierFromPropertiesView(diagram, "prototype_test::subsystem", () -> {
			final Shell dialog = getActiveShell();

			// Edit the binding for iface_pt
			clickButton("Choose...");
			waitForOtherWindowWithTitle("Select Classifier and Prototype Bindings", dialog);
			selectListItem(0, "interfaces::subsystem_interface");

			// Edit the binding for event_fpt
			final Shell bindingDialog = getActiveShell();
			setComboBoxSelection(0, "data");
			setComboBoxSelection(1, "out");
			clickButton("Choose...", 0);
			waitForOtherWindowWithTitle("Select Classifier and Prototype Bindings", bindingDialog);
			selectListItem(0, "Base_Types::Integer");
			clickButton("OK");

			// Edit the binding for message_cpt
			clickButton("Choose...", 1);
			waitForOtherWindowWithTitle("Select Classifier and Prototype Bindings", bindingDialog);
			selectListItem(0, "Base_Types::String");
			clickButton("OK");

			// Confirm the dialog for the binding for iface_pt
			clickButton("OK");
		}, element(pkg, getClassifierRelativeReference("test_system.impl"), getSubcomponentRelativeReference("ss")));

	}

	// Assumes the prototype_test package exists
	// Create prototypes of various types. More exhaustive than other tests.
	private void createAndEditPrototypes() {
		final DiagramReference diagram = defaultDiagram(PROTOTYPE_TEST, PROTOTYPE_TEST);
		final DiagramElementReference pkgElement = packageElement(PROTOTYPE_TEST);
		final RelativeBusinessObjectReference pkg = getPackageRelativeReference(PROTOTYPE_TEST);

		// Create system which will have prototypes
		createElementAndLayout(diagram, pkgElement, "System Type", getClassifierRelativeReference("new_classifier"),
				"top");
		final DiagramElementReference top = element(pkg, getClassifierRelativeReference("top"));

		// Create system which will extend the other one and will be used to test prototype refinement
		createElementAndLayout(diagram, pkgElement, "System Type", getClassifierRelativeReference("new_classifier"),
				"top_ext");
		final DiagramElementReference topExt = element(pkg, getClassifierRelativeReference("top_ext"));

		// Set Extension
		setExtendedOrFeatureClassifierFromPropertiesView(diagram, "prototype_test::top",
				element(pkg, getClassifierRelativeReference("top_ext")));

		//
		// Create a process prototype
		//
		createPrototype(diagram, "top_new_prototype", top);
		renamePrototype(diagram, "top_new_prototype", "process_pt", top);

		// Cycle through different types
		setPrototypeType(diagram, "process_pt", "Feature", top);
		setPrototypeType(diagram, "process_pt", "Feature Group", top);
		setPrototypeType(diagram, "process_pt", "Abstract", top);
		setPrototypeType(diagram, "process_pt", "Bus", top);
		setPrototypeType(diagram, "process_pt", "Data", top);
		setPrototypeType(diagram, "process_pt", "Device", top);
		setPrototypeType(diagram, "process_pt", "Feature Group", top);
		setPrototypeType(diagram, "process_pt", "Memory", top);
		setPrototypeType(diagram, "process_pt", "Processor", top);
		setPrototypeType(diagram, "process_pt", "Subprogram", top);
		setPrototypeType(diagram, "process_pt", "Subprogram Group", top);
		setPrototypeType(diagram, "process_pt", "System", top);
		setPrototypeType(diagram, "process_pt", "Thread", top);
		setPrototypeType(diagram, "process_pt", "Thread Group", top);
		setPrototypeType(diagram, "process_pt", "Virtual Bus", top);
		setPrototypeType(diagram, "process_pt", "Virtual Processor", top);
		setPrototypeType(diagram, "process_pt", "Process", top);

		setPrototypeArray(diagram, "process_pt", false, true, top);

		//
		// Create a feature group prototype
		//
		createPrototype(diagram, "top_new_prototype", element(pkg, getClassifierRelativeReference("top")));
		renamePrototype(diagram, "top_new_prototype", "feature_group_pt", top);
		setPrototypeType(diagram, "process_pt", "Feature Group", top);

		//
		// Create a feature prototype
		//
		createPrototype(diagram, "top_new_prototype", element(pkg, getClassifierRelativeReference("top")));
		renamePrototype(diagram, "top_new_prototype", "feature_pt", top);
		setPrototypeType(diagram, "feature_pt", "Feature", top);
		setPrototypeDirection(diagram, "feature_pt", "Output", top);
		setPrototypeDirection(diagram, "feature_pt", "Unspecified", top);
		setPrototypeDirection(diagram, "feature_pt", "Input", top);
		setPrototypeConstrainingClassifier(diagram, "feature_pt", "Base_Types::Boolean", top);

		//
		// Create a prototype and then remove it
		//
		createPrototype(diagram, "top_new_prototype", top);

		// Remove
		removePrototype(diagram, "top_new_prototype", top);

		//
		// Refinement
		//
		setPrototypeRefined(diagram, "feature_pt", "prototype_test::top", false, true, topExt);
		renamePrototype(diagram, "feature_pt", "feature_pt_renamed", topExt);
	}
}
