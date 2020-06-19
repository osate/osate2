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
import static org.osate.ge.tests.endToEnd.util.OsateGeTestCommands.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestUtil.*;
import static org.osate.ge.tests.endToEnd.util.UiTestUtil.*;

import org.junit.Test;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.tests.endToEnd.util.DiagramElementReference;
import org.osate.ge.tests.endToEnd.util.DiagramReference;
import org.osate.ge.tests.endToEnd.util.Menus;

/**
 * This class is the primary end to end test. It creates a complete model and exercises a large part of the graphical editor.
 * The model is of the architecture of a notional robot which points a laser rangefinder to generate a point cloud and supports
 * hosting an on-board user application which uses the point cloud.
 * It creates a model consisting of multiple projects:
 *    - Shared - Types shared between hardware and software
 *    - Hardware
 *    - Software
 *    - Integrated - Contains a system implementation which integrates the hardware and software components.
 */
public class PrimaryEndToEndTest {
	private static final String SHARED = "shared";
	private static final String HARDWARE = "hardware";
	private static final String HARDWARE_COMPONENTS_PACKAGE = HARDWARE + "::components";
	private static final String HARDWARE_COMPONENTS_DIAGRAM = HARDWARE + "_components";
	private static final String SOFTWARE = "software";
	private static final String INTEGRATED = "integrated";
	private static final String SERVO_INTERFACE = "ServoInterface";

	@Test
	public void testGraphicalEditor() {
		prepareForTesting();
		createSharedProject();
		createHardwareProject();
		createSoftwareProject();
		createIntegratedProject();
		additionalTests();
	}

	private void createSharedProject() {
//		 * - Shared(Project)
//		 *   - shared(package)
//		 *     - ServoInterface Feature Group
		createAadlProject(SHARED);
		createNewPackageWithPackageDiagram(SHARED, SHARED);

		final DiagramReference sharedDiagram = defaultDiagram(SHARED, SHARED);
		final DiagramElementReference sharedPkg = packageElement(SHARED);
		createElementAndLayout(sharedDiagram, sharedPkg, "Feature Group Type",
				getClassifierRelativeReference("new_classifier"), "abcdefghijklmnopqrstuvwxyz");

		renameElementFromDiagramEditor(sharedDiagram, sharedPkg,
				getClassifierRelativeReference("abcdefghijklmnopqrstuvwxyz"), SERVO_INTERFACE);

		saveAndClose(sharedDiagram);
	}

	private void createHardwareProject() {
//		 * - Hardware(Project)
//		 *   - hardware(package)
//		 *     - robot.impl(system implementation)
//		 *       - yaw_servo(hardware::components::servo subcomponent). For rotating base of robot.
//		 *       - pitch_servo(hardware::components::servo subcomponent). For adjusting pitch of range finder
//		 *       - rangefinder(hardware::components::rangefinder subcomponent).
//		 *       - cpu : (hardware::components::cpu subcomponent).
//		 *       - ram : (hardware::components::ram subcomponent).
//		 *       - ethernet_buses : (hardware::components::ethernet subcomponent).
//		 *   - hardware::components(package)
//		 *       - servo(device)
//		 *         - eth(requires bus access ethernet)
//		 *         - interface(feature group shared::ServoInterface)
//		 *       - rangefinder(device)
//		 *         - eth(requires bus access ethernet)
//		 *         - range(out data port integer)
//		 *       - cpu(processor implementation)
//		 *         - eth(requires bus access ethernet)
//		 *         - rom(hardware::component::rom)
//		 *         - ram(hardware::component::ram)
//		 *       - rom(memory type)
//		 *       - ram(memory type)
//		 *       - ethernet(virtual bus type)
		createAadlProjectWithReferencedProjects(HARDWARE, SHARED);
		createNewPackageWithPackageDiagram(HARDWARE, HARDWARE);
		createNewPackageWithPackageDiagram(HARDWARE, HARDWARE_COMPONENTS_PACKAGE, HARDWARE_COMPONENTS_DIAGRAM);

		final DiagramReference hardwareDiagram = defaultDiagram(HARDWARE, HARDWARE);
		final DiagramElementReference hardwarePkg = packageElement(HARDWARE);
		createImplementationWithNewType(hardwareDiagram, hardwarePkg,
				"System Implementation", "impl", "robot");

		final DiagramReference hardwareComponentsDiagram = defaultDiagram(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM);
		final DiagramElementReference hardwareComponentsPkg = packageElement(HARDWARE_COMPONENTS_PACKAGE);
		// Create Device Type servo
		createElementAndLayout(hardwareComponentsDiagram,
				hardwareComponentsPkg, "Device Type",
				getClassifierRelativeReference("new_classifier"), "servo");

		final RelativeBusinessObjectReference componentsPackage = getPackageRelativeReference(
				HARDWARE_COMPONENTS_PACKAGE);

		// Bus Access eth
		createElementAndLayout(hardwareComponentsDiagram,
				element(componentsPackage, getClassifierRelativeReference("servo")), "Bus Access",
				getFeatureRelativeReference("servo_new_feature"), "eth");

		// Feature group interface
		createElementAndLayout(hardwareComponentsDiagram,
				element(componentsPackage, getClassifierRelativeReference("servo")), "Feature Group",
				getFeatureRelativeReference("servo_new_feature"), "interface");

		// Set classifier shared::ServoInterface
		setExtendedOrFeatureClassifierFromPropertiesView(hardwareComponentsDiagram, "shared::ServoInterface",
				element(componentsPackage, getClassifierRelativeReference("servo"),
						getFeatureRelativeReference("interface")));

		// Device type rangefinder
		createElementAndLayout(hardwareComponentsDiagram, hardwareComponentsPkg, "Device Type",
				getClassifierRelativeReference("new_classifier"), "rangefinder");

		// Bus Access eth
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM),
				element(componentsPackage, getClassifierRelativeReference("rangefinder")), "Bus Access",
				getFeatureRelativeReference("rangefinder_new_feature"), "eth");

		// Data Port range_o
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM),
				element(componentsPackage, getClassifierRelativeReference("rangefinder")), "Data Port",
				getFeatureRelativeReference("rangefinder_new_feature"),
				"range_o");

		// Set range_o to output
		setFeatureDirectionFromPropertiesView(hardwareComponentsDiagram, "Output",
				element(componentsPackage, getClassifierRelativeReference("rangefinder"),
						getFeatureRelativeReference("range_o")));

		// Set classifier Base_Types::Integer
		setExtendedOrFeatureClassifierFromPropertiesView(hardwareComponentsDiagram, "Base_Types::Integer", element(componentsPackage,
				getClassifierRelativeReference("rangefinder"), getFeatureRelativeReference("range_o")));

		// Create cpu.impl
		createImplementationWithNewType(hardwareComponentsDiagram, hardwareComponentsPkg,
				"Processor Implementation", "impl",
				"cpu");

		// Create memory type rom
		createElementAndLayout(hardwareComponentsDiagram, hardwareComponentsPkg, "Memory Type",
				getClassifierRelativeReference("new_classifier"), "rom");

		// Create memory type ram
		createElementAndLayout(hardwareComponentsDiagram, hardwareComponentsPkg, "Memory Type",
				getClassifierRelativeReference("new_classifier"), "ram");

		final RelativeBusinessObjectReference hardwarePkgRef = getPackageRelativeReference(HARDWARE);
		final DiagramElementReference robotImpl = element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"));

		// Feature group interface
		createElementAndLayout(hardwareDiagram,
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl")),
				"Feature Group", getFeatureRelativeReference("robot_new_feature"), "interface");

		// Set classifier to shared::ServoInterface
		setExtendedOrFeatureClassifierFromPropertiesView(hardwareDiagram, "shared::ServoInterface",
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl"),
						getFeatureRelativeReference("interface")));

		// Data Port range_o
		createElementAndLayout(hardwareDiagram,
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl")),
				"Data Port",
				getFeatureRelativeReference("robot_new_feature"), "range_o");

		// Set range_o to output
		setFeatureDirectionFromPropertiesView(hardwareDiagram, "Output",
				element(getPackageRelativeReference(HARDWARE),
				getClassifierRelativeReference("robot.impl"), getFeatureRelativeReference("range_o")));

		// Set classifier Base_Types::Integer
		setExtendedOrFeatureClassifierFromPropertiesView(hardwareDiagram, "Base_Types::Integer",
				element(getPackageRelativeReference(HARDWARE),
				getClassifierRelativeReference("robot.impl"), getFeatureRelativeReference("range_o")));

		// Create device subcomponent yaw_servo
		createElementAndLayout(hardwareDiagram, robotImpl, "Device Subcomponent",
				getSubcomponentRelativeReference("robot_impl_new_subcomponent"), "yaw_servo");

		// Set classifier
		setSubcomponentClassifierFromPropertiesView(hardwareDiagram, "hardware::components::servo",
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("yaw_servo")));

		showContentsAndLayout(hardwareDiagram, element(hardwarePkgRef,
				getClassifierRelativeReference("robot.impl"), getSubcomponentRelativeReference("yaw_servo")));

		// Create subcomponent pitch_servo
		createElementAndLayout(hardwareDiagram, robotImpl, "Device Subcomponent",
				getSubcomponentRelativeReference("robot_impl_new_subcomponent"), "pitch_servo");

		// Set classifier for pitch_servo
		setSubcomponentClassifierFromPropertiesView(hardwareDiagram, "hardware::components::servo",
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("pitch_servo")));

		showContentsAndLayout(hardwareDiagram, element(hardwarePkgRef,
				getClassifierRelativeReference("robot.impl"), getSubcomponentRelativeReference("pitch_servo")));

		// Create subcomponent
		createElementAndLayout(hardwareDiagram, robotImpl, "Device Subcomponent",
				getSubcomponentRelativeReference("robot_impl_new_subcomponent"), "rangefinder");

		// Set classifier for rangefinder
		setSubcomponentClassifierFromPropertiesView(hardwareDiagram, "hardware::components::rangefinder",
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("rangefinder")));

		showContentsAndLayout(hardwareDiagram, element(hardwarePkgRef,
				getClassifierRelativeReference("robot.impl"), getSubcomponentRelativeReference("rangefinder")));

		// Create CPU subcomponent
		createElementAndLayout(hardwareDiagram, robotImpl, "Processor Subcomponent",
				getSubcomponentRelativeReference("robot_impl_new_subcomponent"), "cpu");

		// Set classifier for cpu
		setSubcomponentClassifierFromPropertiesView(hardwareDiagram, "hardware::components::cpu",
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("cpu")));

		// Create RAM subcomponent
		createElementAndLayout(hardwareDiagram, robotImpl, "Memory Subcomponent",
				getSubcomponentRelativeReference("robot_impl_new_subcomponent"), "ram");
		final DiagramElementReference ram = element(getPackageRelativeReference(HARDWARE),
				getClassifierRelativeReference("robot.impl"),
				getSubcomponentRelativeReference("ram"));

		// Add, modify, and delete array dimension
		addArrayDimension(hardwareDiagram, 2, ram);
		modifyArrayDimension(hardwareDiagram, 0, 5, ram);
		deleteArrayDimension(hardwareDiagram, 0, ram);

		// Create Eth subcomponent
		createElementAndLayout(hardwareDiagram, robotImpl, "Virtual Bus Subcomponent",
				getSubcomponentRelativeReference("robot_impl_new_subcomponent"), "ethernet_buses");

		// Set classifier for ethernet_buses
		setSubcomponentToNewTypeFromPropertiesView(hardwareDiagram,
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses")),
				HARDWARE_COMPONENTS_PACKAGE, "ethernet");

		// Create eth bus access in ethernet_buses
		createElementAndLayout(hardwareDiagram,
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses")),
				"Bus Access", getFeatureRelativeReference("ethernet_new_feature"), "eth");

		// Set classifier
		setExtendedOrFeatureClassifierFromPropertiesView(hardwareDiagram, "hardware::components::ethernet",
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses"), getFeatureRelativeReference("eth")));

		// Set bus access to provides
		clickRadioButtonInPropertiesView(hardwareDiagram, "AADL", "Provides",
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses"), getFeatureRelativeReference("eth")));

		// Set classifier for rangefinder::eth and servo::eth
		setExtendedOrFeatureClassifierFromPropertiesView(hardwareComponentsDiagram, "hardware::components::ethernet",
				element(componentsPackage, getClassifierRelativeReference("rangefinder"),
						getFeatureRelativeReference("eth")),
				element(componentsPackage, getClassifierRelativeReference("servo"),
						getFeatureRelativeReference("eth")));

		// Set requires bus access
		clickRadioButtonInPropertiesView(hardwareComponentsDiagram, "AADL", "Requires",
				element(componentsPackage, getClassifierRelativeReference("rangefinder"),
						getFeatureRelativeReference("eth")),
				element(componentsPackage, getClassifierRelativeReference("servo"),
						getFeatureRelativeReference("eth")));

		// Create connection from ethernet_buses.eth to pitch_servo.eth
		createConnectionAndLayout(hardwareDiagram,
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses"), getFeatureRelativeReference("eth")),
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("pitch_servo"), getFeatureRelativeReference("eth")),
				"Access Connection",
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl")),
				getConnectionRelativeReference("robot_impl_new_connection"), "pitch_servo_con");

		createConnectionAndLayout(hardwareDiagram,
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses"), getFeatureRelativeReference("eth")),
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("rangefinder"), getFeatureRelativeReference("eth")),
				"Access Connection",
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl")),
				getConnectionRelativeReference("robot_impl_new_connection"), "rangefinder_con");

		createConnectionAndLayout(hardwareDiagram,
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses"), getFeatureRelativeReference("eth")),
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("yaw_servo"), getFeatureRelativeReference("eth")),
				"Access Connection",
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl")),
				getConnectionRelativeReference("robot_impl_new_connection"), "yaw_servo_con");

		// Create connections
		createConnectionAndLayout(hardwareDiagram,
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl"),
						getFeatureRelativeReference("interface")),
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("yaw_servo"), getFeatureRelativeReference("interface")),
				"Feature Group Connection",
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl")),
				getConnectionRelativeReference("robot_impl_new_connection"), "yaw_interface_connection");

		createConnectionAndLayout(hardwareDiagram,
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl"),
						getFeatureRelativeReference("interface")),
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("pitch_servo"), getFeatureRelativeReference("interface")),
				"Feature Group Connection",
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl")),
				getConnectionRelativeReference("robot_impl_new_connection"), "pitch_interface_connection");

		createConnectionAndLayout(hardwareDiagram,
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("rangefinder"), getFeatureRelativeReference("range_o")),
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl"),
						getFeatureRelativeReference("range_o")),
				"Port Connection",
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl")),
				getConnectionRelativeReference("robot_impl_new_connection"), "range_connection");
	}

	private void createSoftwareProject() {
//		 *  - Software(Project)
//		 *    - software(package)
//		 *      - PointCloud(data type)
//		 *      - direction(data type)
//		 *      - point_cloud_generator.impl(process implementation)
//		 *        - point_cloud(provides data access shared::PointCloud)
//		 *        - threads(thread group threads.impl)
//		 *      - threads.impl(thread group implementation)
//       *        - point_cloud(provides data access shared::PointCloud)
//		 *        - pointer(thread subcomponent thread pointer)
//		 *        - integrator(thread subcomponent integrator)
//		 *      - pointer(thread)
//		 *        - yaw_servo_interface(feature group shared::ServoInterface)
//		 *        - pitch_servo_interface(feature group shared::ServoInterface)
//		 *        - direction(out data port direction)
//		 *      - integrator.impl(thread implementation). Updates point clouds as new values are received
//		 *        - point_cloud(provides data access shared::PointCloud)
//		 *        - direction(in event port direction)
//		 *        - range(in data port integer)
		createAadlProjectWithReferencedProjects(SOFTWARE, SHARED);
		createNewPackageWithPackageDiagram(SOFTWARE, SOFTWARE);

		final DiagramReference softwareDiagram = defaultDiagram(SOFTWARE, SOFTWARE);
		final DiagramElementReference softwarePkg = packageElement(SOFTWARE);

		// Create Device Type PointCloud
		createElementAndLayout(softwareDiagram, softwarePkg, "Data Type",
				getClassifierRelativeReference("new_classifier"), "PointCloud");

		// Create Device Type Direction
		createElementAndLayout(softwareDiagram, softwarePkg, "Data Type",
				getClassifierRelativeReference("new_classifier"), "Direction");

		// Create Process Implementation point_cloud_generator
		createImplementationWithNewType(softwareDiagram, softwarePkg,
				"Process Implementation", "impl", "point_cloud_generator");

		// Create feature group for servo interface
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl")),
				"Feature Group", getFeatureRelativeReference("point_cloud_generator_new_feature"), "interface");

		// Create Thread Group Implementation threads
		createImplementationWithNewType(softwareDiagram, softwarePkg,
				"Thread Group Implementation", "impl", "threads");

		// Create Thread Type pointer
		createElementAndLayout(softwareDiagram, softwarePkg, "Thread Type",
				getClassifierRelativeReference("new_classifier"), "pointer");

		// Create Thread Implementation integrator
		createImplementationWithNewType(softwareDiagram, softwarePkg,
				"Thread Implementation", "impl", "integrator");

		// Create point_cloud data access in point_cloud_generator.impl
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl")),
				"Data Access", getFeatureRelativeReference("point_cloud_generator_new_feature"), "point_cloud");

		// Set point_cloud data access to provides
		clickRadioButtonInPropertiesView(softwareDiagram, "AADL", "Provides",
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getFeatureRelativeReference("point_cloud")));

		// Set point_cloud classifier to software::PointCloud
		setExtendedOrFeatureClassifierFromPropertiesView(softwareDiagram, "software::PointCloud",
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getFeatureRelativeReference("point_cloud")));

		// Create range_i data port in point_cloud_generator.impl
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl")),
				"Data Port", getFeatureRelativeReference("point_cloud_generator_new_feature"), "range_i");

		// Set range_i data port to input
		setFeatureDirectionFromPropertiesView(softwareDiagram, "Input",
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getFeatureRelativeReference("range_i")));

		// Set range_in classifier to Base_Types::Integer
		setExtendedOrFeatureClassifierFromPropertiesView(softwareDiagram, "Base_Types::Integer",
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getFeatureRelativeReference("range_i")));

		// Create threads subcomponent
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl")),
				"Thread Group Subcomponent",
				getSubcomponentRelativeReference("point_cloud_generator_impl_new_subcomponent"),
				"threads");

		// Set classifier to software::threads.impl
		setSubcomponentClassifierFromPropertiesView(softwareDiagram, "software::threads.impl",
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getSubcomponentRelativeReference("threads")));

		// Create point_cloud in threads.impl
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				"Data Access", getFeatureRelativeReference("threads_new_feature"), "point_cloud");

		// Set point_cloud to provides
		clickRadioButtonInPropertiesView(softwareDiagram, "AADL", "Provides",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getFeatureRelativeReference("point_cloud")));

		// Set point_cloud classifier to software::PointCloud
		setExtendedOrFeatureClassifierFromPropertiesView(softwareDiagram, "software::PointCloud",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getFeatureRelativeReference("point_cloud")));

		// Create range_i in threads.impl
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				"Data Port", getFeatureRelativeReference("threads_new_feature"), "range_i");

		// Set range_i to input
		setFeatureDirectionFromPropertiesView(softwareDiagram, "Input",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getFeatureRelativeReference("range_i")));

		// Set range_i classifier to Base_Types::Integer
		setExtendedOrFeatureClassifierFromPropertiesView(softwareDiagram, "Base_Types::Integer",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getFeatureRelativeReference("range_i")));

		// Create flow sink
		createFlowSpecification(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl")),
				"Flow Sink Specification", getFeatureRelativeReference("point_cloud"),
				getFlowSpecificationRelativeReference("point_cloud_generator_new_flow_spec"),
				"f_sink");

		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				"Feature Group", getFeatureRelativeReference("threads_new_feature"), "servo_interface");

		// Set classifier
		setExtendedOrFeatureClassifierFromPropertiesView(softwareDiagram, "shared::ServoInterface",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getFeatureRelativeReference("servo_interface")));

		// Show contents of threads
		showContentsAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getSubcomponentRelativeReference("threads")));

		// Create connection
		createConnectionAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getSubcomponentRelativeReference("threads"), getFeatureRelativeReference("servo_interface")),
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getFeatureRelativeReference("interface")),
				"Feature Group Connection",
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl")),
				getConnectionRelativeReference("point_cloud_generator_impl_new_connection"), "interface_connection");

		// Create connection
		createConnectionAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getFeatureRelativeReference("range_i")),
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getSubcomponentRelativeReference("threads"), getFeatureRelativeReference("range_i")),
				"Port Connection",
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl")),
				getConnectionRelativeReference("point_cloud_generator_impl_new_connection"), "range_connection");

		// Create pointer subcomponent in threads.impl
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				"Thread Subcomponent", getSubcomponentRelativeReference("threads_impl_new_subcomponent"), "pointer");

		// Set classifier for pointer to shared::pointer
		setSubcomponentClassifierFromPropertiesView(softwareDiagram, "software::pointer",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("pointer")));

		// Show pointer contents
		showContentsAndLayout(softwareDiagram, element(getPackageRelativeReference(SOFTWARE),
				getClassifierRelativeReference("threads.impl"), getSubcomponentRelativeReference("pointer")));

		// Create integrator subcomponent in threads.impl
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				"Thread Subcomponent", getSubcomponentRelativeReference("threads_impl_new_subcomponent"), "integrator");

		// Set classifier for integrator to shared::integrator
		setSubcomponentClassifierFromPropertiesView(softwareDiagram, "software::integrator.impl",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("integrator")));

		// Create yaw_servo_interface feature group in pointer
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer")),
				"Feature Group", getFeatureRelativeReference("pointer_new_feature"), "yaw_servo_interface");

		// Set yaw_servo_interface classifier to shared::ServoInterface
		setExtendedOrFeatureClassifierFromPropertiesView(softwareDiagram, "shared::ServoInterface",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer"),
						getFeatureRelativeReference("yaw_servo_interface")));

		// Create pitch_servo_interface feature group in pointer
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer")),
				"Feature Group", getFeatureRelativeReference("pointer_new_feature"), "pitch_servo_interface");

		// Set pitch_servo_interface classifier to shared::ServoInterface
		setExtendedOrFeatureClassifierFromPropertiesView(softwareDiagram, "shared::ServoInterface",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer"),
						getFeatureRelativeReference("pitch_servo_interface")));

		// Create direction data port in pointer
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer")), "Data Port",
				getFeatureRelativeReference("pointer_new_feature"), "direction");

		// Set direction to output
		setFeatureDirectionFromPropertiesView(softwareDiagram, "Output",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer"),
						getFeatureRelativeReference("direction")));

		// Set direction classifier to Direction
		setExtendedOrFeatureClassifierFromPropertiesView(softwareDiagram, "software::Direction",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer"),
						getFeatureRelativeReference("direction")));

		showContentsAndLayout(softwareDiagram, element(getPackageRelativeReference(SOFTWARE),
				getClassifierRelativeReference("threads.impl"), getSubcomponentRelativeReference("pointer")));

		// Create connection pointer.pitch_server and yaw_server to threads.impl.servo_interface
		createConnectionAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("pointer"),
						getFeatureRelativeReference("yaw_servo_interface")),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getFeatureRelativeReference("servo_interface")),
				"Feature Group Connection",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				getConnectionRelativeReference("threads_impl_new_connection"), "yaw_interface_connection");

		createConnectionAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("pointer"),
						getFeatureRelativeReference("pitch_servo_interface")),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getFeatureRelativeReference("servo_interface")),
				"Feature Group Connection",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				getConnectionRelativeReference("threads_impl_new_connection"), "pitch_interface_connection");

		// Create point_cloud data access in integrator.impl
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl")),
				"Data Access", getFeatureRelativeReference("integrator_new_feature"), "point_cloud");

		// Set point_cloud to provides
		clickRadioButtonInPropertiesView(softwareDiagram, "AADL", "Provides",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl"),
						getFeatureRelativeReference("point_cloud")));

		// Set point_cloud classifier to software::PointCloud
		setExtendedOrFeatureClassifierFromPropertiesView(softwareDiagram, "software::PointCloud",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl"),
						getFeatureRelativeReference("point_cloud")));

		// Create direction data port in integrator.impl
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl")),
				"Data Port", getFeatureRelativeReference("integrator_new_feature"), "direction");

		// Set direction classifier to Direction
		setExtendedOrFeatureClassifierFromPropertiesView(softwareDiagram, "software::Direction",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl"),
						getFeatureRelativeReference("direction")));

		// Set direction to input
		clickRadioButtonInPropertiesView(softwareDiagram, "AADL", "Input",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl"),
						getFeatureRelativeReference("direction")));

		// Create range_i data port in integrator.impl
		createElementAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl")),
				"Data Port", getFeatureRelativeReference("integrator_new_feature"), "range_i");

		// Set range_i classifier to Integer
		setExtendedOrFeatureClassifierFromPropertiesView(softwareDiagram, "Base_Types::Integer",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl"),
						getFeatureRelativeReference("range_i")));

		// Show integrator contents
		showContentsAndLayout(softwareDiagram, element(getPackageRelativeReference(SOFTWARE),
				getClassifierRelativeReference("threads.impl"), getSubcomponentRelativeReference("integrator")));

		// Create connection between pointer.direction and integrator.direction
		createConnectionAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("pointer"), getFeatureRelativeReference("direction")),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("integrator"), getFeatureRelativeReference("direction")),
				"Port Connection",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				getConnectionRelativeReference("threads_impl_new_connection"), "direction_connection");

		// Create flow source specification for pointer.direction
		createFlowSpecification(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("pointer")),
				"Flow Source Specification", getFeatureRelativeReference("direction"),
				getFlowSpecificationRelativeReference("pointer_new_flow_spec"), "f_source");

		// Create flow source specification for pointer.direction
		createFlowSpecification(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("integrator")),
				"Flow Sink Specification", getFeatureRelativeReference("direction"),
				getFlowSpecificationRelativeReference("integrator_new_flow_spec"),
				"f_sink");

		// Create end to end flow spec
		createEndToEndFlowSpecification(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				"software::threads.impl::direction_flow",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("pointer"), getFlowSpecificationRelativeReference("f_source")),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getConnectionRelativeReference("direction_connection")),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("integrator"), getFlowSpecificationRelativeReference("f_sink")));

		// Create flow source threads.impl.point_cloud
		createFlowSpecification(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				"Flow Source Specification", getFeatureRelativeReference("point_cloud"),
				getFlowSpecificationRelativeReference("threads_new_flow_spec"), "point_cloud_source");

		// Create flow sink threads.impl.integrator.point_cloud
		createFlowSpecification(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("integrator")),
				"Flow Sink Specification", getFeatureRelativeReference("point_cloud"),
				getFlowSpecificationRelativeReference("integrator_new_flow_spec"), "point_cloud_sink");

		// Create connection threads.impl.point_cloud -> threads.impl.integrator.point_cloud
		createConnectionAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("integrator"), getFeatureRelativeReference("point_cloud")),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getFeatureRelativeReference("point_cloud")),
				"Access Connection",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				getConnectionRelativeReference("threads_impl_new_connection"), "point_cloud_connection");

		// Create connection threads.impl.range_i -> threads.impl.integrator.range_i
		createConnectionAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getFeatureRelativeReference("range_i")),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("integrator"), getFeatureRelativeReference("range_i")),
				"Port Connection",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				getConnectionRelativeReference("threads_impl_new_connection"), "range_connection");

		// Create flow impl
		createFlowImplementation(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				"software::threads.impl::point_cloud_source",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getFlowSpecificationRelativeReference("point_cloud_source")),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("integrator"),
						getFlowSpecificationRelativeReference("point_cloud_sink")),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getConnectionRelativeReference("point_cloud_connection")),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getFeatureRelativeReference("point_cloud")));

		createConnectionAndLayout(softwareDiagram,
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getSubcomponentRelativeReference("threads"), getFeatureRelativeReference("point_cloud")),
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getFeatureRelativeReference("point_cloud")),
				"Access Connection",
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl")),
				getConnectionRelativeReference("point_cloud_generator_impl_new_connection"), "point_cloud_connection");
	}

	private void createIntegratedProject() {
//		 * - Integrated(Project)
//		 *   - integrated(package)
//		 *     - robotic_system.base(system implementation)
//		 *       - robot(subcomponent hardware::robot.impl)
//		 *       - point_cloud_generator(subcomponent software::point_cloud_generator.impl)
//		 *       - specialized_app(process)
//		 *       - sched1(virtual processor)
//		 *       - sched2(virtual processor)
//		 *       - bind processes to virtual processors
//		 *       - bind virtual processors to processor
//		 *     - robotic_system.specialized(system implementation)
//		 *       - specialized_app(refined subcomponent specialized_app.impl)
//		 *     - specialized_app.impl(process implementation)-
//		 *       - point_cloud(provides data access shared::PointCloud)
//		 *       - specialized_thread(subcomponent specialized_thread)
//		 *     - specialized_thread(thread type)
//		 *       - point_cloud(provides data access shared::PointCloud)
		createAadlProjectWithReferencedProjects(INTEGRATED, HARDWARE, SOFTWARE);
		createNewPackageWithPackageDiagram(INTEGRATED, INTEGRATED);

		final DiagramReference integratedDiagram = defaultDiagram(INTEGRATED, INTEGRATED);
		final DiagramElementReference integratedPkg = packageElement(INTEGRATED);

		// Create robotic_system.base system implementation
		createImplementationWithNewType(integratedDiagram, integratedPkg, "System Implementation", "base",
				"robotic_system");

		// Create robotic_system.specialized System Implementation
		createImplementationWithExistingType(integratedDiagram, integratedPkg, "System Implementation", "specialized",
				INTEGRATED, "robotic_system");

		// Extend robotic_system.base
		setExtendedOrFeatureClassifierFromPropertiesView(integratedDiagram, "integrated::robotic_system.base",
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized")));

		// Create specialized_app Process Implementation
		createImplementationWithNewType(integratedDiagram, integratedPkg, "Process Implementation", "impl",
				"specialized_app");

		// Create specialized_thread Thread
		createElementAndLayout(integratedDiagram, integratedPkg,
				"Thread Type", getClassifierRelativeReference("new_classifier"), "specialized_thread");

		// Create specialized_thread subcomponent in specialized_app
		createElementAndLayout(integratedDiagram,
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("specialized_app.impl")),
				"Thread Subcomponent", getSubcomponentRelativeReference("specialized_app_impl_new_subcomponent"),
				"specialized_thread");

		// Set classifier of specialized_thread to specialized_thread type
		setSubcomponentClassifierFromPropertiesView(integratedDiagram, "integrated::specialized_thread",
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("specialized_app.impl"),
						getSubcomponentRelativeReference("specialized_thread")));

		// Create point_cloud data access in specialized_thread
		createElementAndLayout(integratedDiagram,
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("specialized_thread")),
				"Data Access", getFeatureRelativeReference("specialized_thread_new_feature"), "point_cloud");

		// Set point_cloud classifier to software::PointCloud
		setExtendedOrFeatureClassifierFromPropertiesView(integratedDiagram, "software::PointCloud",
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("specialized_thread"),
						getFeatureRelativeReference("point_cloud")));

		// Show specialized_thread contents
		showContentsAndLayout(integratedDiagram,
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("specialized_app.impl"),
						getSubcomponentRelativeReference("specialized_thread")));

		// Create point_cloud data access in specialized_app
		createElementAndLayout(integratedDiagram,
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("specialized_app.impl")),
				"Data Access", getFeatureRelativeReference("specialized_app_new_feature"), "point_cloud");

		// Set point_cloud classifier to shared::PointCloud
		setExtendedOrFeatureClassifierFromPropertiesView(integratedDiagram, "software::PointCloud",
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("specialized_app.impl"),
						getFeatureRelativeReference("point_cloud")));

		// Create connection specialized_app.impl.point_cloud -> specialized_app.impl.specialized_thread.point_cloud
		createConnectionAndLayout(integratedDiagram, element(getPackageRelativeReference(INTEGRATED),
				getClassifierRelativeReference("specialized_app.impl"), getFeatureRelativeReference("point_cloud")),
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("specialized_app.impl"),
						getSubcomponentRelativeReference("specialized_thread"),
						getFeatureRelativeReference("point_cloud")),
				"Access Connection",
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("specialized_app.impl")),
				getConnectionRelativeReference("specialized_app_impl_new_connection"), "point_connection");

		final DiagramElementReference roboticSysBase = element(getPackageRelativeReference(INTEGRATED),
				getClassifierRelativeReference("robotic_system.base"));
		// Create robot in robotic_system.base
		createElementAndLayout(integratedDiagram, roboticSysBase, "System Subcomponent",
				getSubcomponentRelativeReference("robotic_system_base_new_subcomponent"),
				"robot");

		// Set robot classifier to hardware::robot.impl
		setSubcomponentClassifierFromPropertiesView(integratedDiagram, "hardware::robot.impl",
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("robot")));

		// Create point_cloud_generator subcomponent in robotic_system_base
		createElementAndLayout(integratedDiagram, roboticSysBase,
				"Process Subcomponent", getSubcomponentRelativeReference("robotic_system_base_new_subcomponent"),
				"point_cloud_generator");

		// Set point_cloud_generator to software::point_cloud_generator.impl
		setSubcomponentClassifierFromPropertiesView(integratedDiagram, "software::point_cloud_generator.impl",
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("point_cloud_generator")));

		// Create specialized_app subcomponent in robotic_system.base
		createElementAndLayout(integratedDiagram, roboticSysBase,
				"Process Subcomponent", getSubcomponentRelativeReference("robotic_system_base_new_subcomponent"),
				"specialized_app");

		// Create sched1 subcomponent in robotic_system.specialized
		createElementAndLayout(integratedDiagram, roboticSysBase,
				"Virtual Processor Subcomponent",
				getSubcomponentRelativeReference("robotic_system_base_new_subcomponent"), "sched1");

		// Create sched2 subcomponent in robotic_system.specialized
		createElementAndLayout(integratedDiagram, roboticSysBase,
				"Virtual Processor Subcomponent",
				getSubcomponentRelativeReference("robotic_system_base_new_subcomponent"), "sched2");

		// Show contents of robotic_system.specialized
		showContentsAndLayout(integratedDiagram, element(getPackageRelativeReference(INTEGRATED),
				getClassifierRelativeReference("robotic_system.specialized")));

		// Set specialized_app refined
		clickCheckboxInPropertiesView(integratedDiagram, "AADL", 0,
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized"),
						getSubcomponentRelativeReference("specialized_app")));

		// Set classifier for specialized_app
		setSubcomponentClassifierFromPropertiesView(integratedDiagram, "integrated::specialized_app.impl",
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized"),
						getSubcomponentRelativeReference("specialized_app")));

		// Show robotic_system.specialized contents
		showContentsAndLayout(integratedDiagram, element(getPackageRelativeReference(INTEGRATED),
				getClassifierRelativeReference("robotic_system.specialized")));

		// Show contents of specialized_app
		showContentsAndLayout(integratedDiagram,
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized"),
						getSubcomponentRelativeReference("specialized_app")));

		// Show contents of point cloud generator
		showContentsAndLayout(integratedDiagram,
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized"),
						getSubcomponentRelativeReference("point_cloud_generator")));

		// Show contents of robot
		showContentsAndLayout(integratedDiagram,
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized"),
				getSubcomponentRelativeReference("robot")));

		// Create connection in robotic_system.specialized from robot.range_o point_cloud_generator.range_i
		createConnectionAndLayout(integratedDiagram,
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized"),
						getSubcomponentRelativeReference("robot"), getFeatureRelativeReference("range_o")),
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized"),
						getSubcomponentRelativeReference("point_cloud_generator"),
						getFeatureRelativeReference("range_i")),
				"Port Connection",
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized")),
				getConnectionRelativeReference("robotic_system_specialized_new_connection"), "range_connection");

		// Create connection in robotic_system.specialized from point_cloud_generator.point_cloud to specialized_app.point_cloud
		createConnectionAndLayout(integratedDiagram,
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized"),
						getSubcomponentRelativeReference("point_cloud_generator"),
						getFeatureRelativeReference("point_cloud")),
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized"),
						getSubcomponentRelativeReference("specialized_app"),
						getFeatureRelativeReference("point_cloud")),
				"Access Connection",
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized")),
				getConnectionRelativeReference("robotic_system_specialized_new_connection"), "point_cloud_connection");

		// Create connection in robotic_system.specialized from point_cloud_generator.interface to robot.interface
		createConnectionAndLayout(integratedDiagram, element(getPackageRelativeReference(INTEGRATED),
				getClassifierRelativeReference("robotic_system.specialized"),
				getSubcomponentRelativeReference("point_cloud_generator"), getFeatureRelativeReference("interface")),
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized"),
						getSubcomponentRelativeReference("robot"), getFeatureRelativeReference("interface")),
				"Feature Group Connection",
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized")),
				getConnectionRelativeReference("robotic_system_specialized_new_connection"),
				"servo_interface_connection");

		// Create binding for specialized_app => sched2
		createBindPropertyAssociations(integratedDiagram,
				new DiagramElementReference[] { element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("specialized_app")) },
				new DiagramElementReference[] { element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("sched2")) },
				"Actual_Processor_Binding");

		// Create binding for point_cloud_generator => sched1
		createBindPropertyAssociations(integratedDiagram,
				new DiagramElementReference[] { element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("point_cloud_generator")) },
				new DiagramElementReference[] { element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("sched1")) },
				"Actual_Processor_Binding");

		// Show robot contents
		showContentsAndLayout(integratedDiagram, element(getPackageRelativeReference(INTEGRATED),
				getClassifierRelativeReference("robotic_system.base"), getSubcomponentRelativeReference("robot")));

		// Create binding for sched1 & sched2 => cpu
		createBindPropertyAssociations(integratedDiagram, new DiagramElementReference[] {
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("sched2")),
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("sched1")) },
				new DiagramElementReference[] { element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("robot"), getSubcomponentRelativeReference("cpu")) },
				"Actual_Processor_Binding");
	}

	/**
	 * Exercises additional functionality after the model has been created
	 */
	private void additionalTests() {
		final DiagramReference diagram = defaultDiagram(HARDWARE, HARDWARE);

		// Hide Contents
		clickContextMenuOfDiagramElement(diagram, packageElement(HARDWARE), Menus.HIDE_CONTENTS_ALL);

		// Show contents
		clickContextMenuOfDiagramElement(diagram, packageElement(HARDWARE), Menus.SHOW_CONTENTS_ALL);
	}
}
