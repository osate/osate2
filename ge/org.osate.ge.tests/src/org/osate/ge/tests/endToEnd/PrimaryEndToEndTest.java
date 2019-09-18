package org.osate.ge.tests.endToEnd;

import static org.osate.ge.internal.services.impl.DeclarativeReferenceBuilder.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestCommands.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestUtil.*;

import org.junit.Test;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
import org.osate.ge.tests.endToEnd.util.DiagramElementReference;
import org.osate.ge.tests.endToEnd.util.DiagramReference;

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

		createElementAndLayout(defaultDiagram(SHARED, SHARED), packageElement(SHARED), "Feature Group Type",
				getClassifierRelativeReference("new_classifier"), SERVO_INTERFACE);

		renameElementFromDiagram(defaultDiagram(SHARED, SHARED),
				element(getPackageRelativeReference(SHARED)), getClassifierRelativeReference(SERVO_INTERFACE), "AA");
		renameElementFromDiagram(defaultDiagram(SHARED, SHARED), element(getPackageRelativeReference(SHARED)),
				getClassifierRelativeReference("AA"), SERVO_INTERFACE);
	}

	private void createHardwareProject() {
//		 * - Hardware(Project)
//		 *   - hardware(package)
//		 *     - robot.impl(system implementation)
//		 *       - yaw_servo(hardware::components::servo subcomponent). For rotating base of robot.
//		 *       - pitch_servo(hardware::components::servo subcomponent). For adjusting pitch of range finder
//		 *       - rangefinder(hardware::components::rangefinder subcomponent).
//		 *       - cpu : (hardware::components::cpu subcomponent).
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

		createImplementationWithNewType(defaultDiagram(HARDWARE, HARDWARE), packageElement(HARDWARE),
				"System Implementation", "impl", "robot");

		// Create Device Type servo
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM),
				packageElement(HARDWARE_COMPONENTS_PACKAGE), "Device Type",
				getClassifierRelativeReference("new_classifier"), "servo");

		final RelativeBusinessObjectReference componentsPackage = getPackageRelativeReference(
				HARDWARE_COMPONENTS_PACKAGE);

		// Bus Access eth
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM),
				element(componentsPackage, getClassifierRelativeReference("servo")), "Bus Access",
				getFeatureRelativeReference("servo_new_feature"), "eth");

		// Feature group interface
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM),
				element(componentsPackage, getClassifierRelativeReference("servo")), "Feature Group",
				getFeatureRelativeReference("servo_new_feature"), "interface");

		// Set classifier shared::ServoInterface
		setClassifierFromPropertiesView(defaultDiagram(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM), "shared::ServoInterface",
				element(componentsPackage, getClassifierRelativeReference("servo"),
						getFeatureRelativeReference("interface")));

		// Device type rangefinder
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM),
				packageElement(HARDWARE_COMPONENTS_PACKAGE), "Device Type",
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

		// Create cpu.impl
		createImplementationWithNewType(defaultDiagram(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM),
				packageElement(HARDWARE_COMPONENTS_PACKAGE),
				"Processor Implementation", "impl",
				"cpu");

		// Create memory type rom
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM),
				packageElement(HARDWARE_COMPONENTS_PACKAGE), "Memory Type",
				getClassifierRelativeReference("new_classifier"), "rom");

		// Create memory type ram
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM),
				packageElement(HARDWARE_COMPONENTS_PACKAGE), "Memory Type",
				getClassifierRelativeReference("new_classifier"), "ram");

		final RelativeBusinessObjectReference hardwarePkgRef = getPackageRelativeReference(HARDWARE);
		final DiagramElementReference robotImpl = element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"));

		// Create device subcomponent yaw_servo
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE), robotImpl, "Device Subcomponent",
				getSubcomponentRelativeReference("robot_impl_new_subcomponent"), "yaw_servo");

		// Set classifier
		setClassifierFromPropertiesView(defaultDiagram(HARDWARE, HARDWARE), "hardware::components::servo",
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("yaw_servo")));

		showContentsAndLayout(defaultDiagram(HARDWARE, HARDWARE), element(hardwarePkgRef,
				getClassifierRelativeReference("robot.impl"), getSubcomponentRelativeReference("yaw_servo")));

		// Create subcomponent pitch_servo
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE), robotImpl, "Device Subcomponent",
				getSubcomponentRelativeReference("robot_impl_new_subcomponent"), "pitch_servo");

		// Set classifier for pitch_servo
		setClassifierFromPropertiesView(defaultDiagram(HARDWARE, HARDWARE), "hardware::components::servo",
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("pitch_servo")));

		showContentsAndLayout(defaultDiagram(HARDWARE, HARDWARE), element(hardwarePkgRef,
				getClassifierRelativeReference("robot.impl"), getSubcomponentRelativeReference("pitch_servo")));

		// Create subcomponent
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE), robotImpl, "Device Subcomponent",
				getSubcomponentRelativeReference("robot_impl_new_subcomponent"), "rangefinder");

		// Set classifier for rangefinder
		setClassifierFromPropertiesView(defaultDiagram(HARDWARE, HARDWARE), "hardware::components::rangefinder",
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("rangefinder")));

		showContentsAndLayout(defaultDiagram(HARDWARE, HARDWARE), element(hardwarePkgRef,
				getClassifierRelativeReference("robot.impl"), getSubcomponentRelativeReference("rangefinder")));

		// Create CPU subcomponent
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE), robotImpl, "Processor Subcomponent",
				getSubcomponentRelativeReference("robot_impl_new_subcomponent"), "cpu");

		// Set classifier for cpu
		setClassifierFromPropertiesView(defaultDiagram(HARDWARE, HARDWARE), "hardware::components::cpu",
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("cpu")));

		// Create Eth subcomponent
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE), robotImpl, "Virtual Bus Subcomponent",
				getSubcomponentRelativeReference("robot_impl_new_subcomponent"), "ethernet_buses");

		// Set classifier for ethernet_buses
		setSubcomponentToNewTypeFromPropertiesView(defaultDiagram(HARDWARE, HARDWARE),
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses")),
				HARDWARE_COMPONENTS_PACKAGE, "ethernet");

		// Create eth bus access in ethernet_buses
		createElementAndLayout(defaultDiagram(HARDWARE, HARDWARE),
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses")),
				"Bus Access", getFeatureRelativeReference("ethernet_new_feature"), "eth");

		// Set classifier
		setClassifierFromPropertiesView(defaultDiagram(HARDWARE, HARDWARE), "hardware::components::ethernet",
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses"), getFeatureRelativeReference("eth")));

		// Set bus access to provides
		clickRadioButtonInPropertiesView(defaultDiagram(HARDWARE, HARDWARE), "Provides", "AADL",
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses"), getFeatureRelativeReference("eth")));

		// Set classifier for rangefinder::eth and servo::eth
		setClassifierFromPropertiesView(defaultDiagram(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM), "hardware::components::ethernet",
				element(componentsPackage, getClassifierRelativeReference("rangefinder"),
						getFeatureRelativeReference("eth")),
				element(componentsPackage, getClassifierRelativeReference("servo"),
						getFeatureRelativeReference("eth")));

		// Set requires bus access
		clickRadioButtonInPropertiesView(defaultDiagram(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM), "Requires", "AADL",
				element(componentsPackage, getClassifierRelativeReference("rangefinder"),
						getFeatureRelativeReference("eth")),
				element(componentsPackage, getClassifierRelativeReference("servo"),
						getFeatureRelativeReference("eth")));

		// Create connection from ethernet_buses.eth to pitch_servo.eth
		createConnection(defaultDiagram(HARDWARE, HARDWARE),
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses"), getFeatureRelativeReference("eth")),
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("pitch_servo"), getFeatureRelativeReference("eth")),
				"Access Connection",
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl")),
				getConnectionRelativeReference("robot_impl_new_connection"), "pitch_servo_con");

		createConnection(defaultDiagram(HARDWARE, HARDWARE),
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses"), getFeatureRelativeReference("eth")),
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("rangefinder"), getFeatureRelativeReference("eth")),
				"Access Connection",
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl")),
				getConnectionRelativeReference("robot_impl_new_connection"), "rangefinder_con");

		createConnection(defaultDiagram(HARDWARE, HARDWARE),
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("ethernet_buses"), getFeatureRelativeReference("eth")),
				element(hardwarePkgRef, getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("yaw_servo"), getFeatureRelativeReference("eth")),
				"Access Connection",
				element(getPackageRelativeReference(HARDWARE), getClassifierRelativeReference("robot.impl")),
				getConnectionRelativeReference("robot_impl_new_connection"), "yaw_servo_con");
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
		// add flows and everything connected
		createAadlProjectWithReferencedProjects(SOFTWARE, SHARED);
		createNewPackageWithPackageDiagram(SOFTWARE, SOFTWARE);

		// Create Device Type PointCloud
		createElementAndLayout(defaultDiagram(SOFTWARE, SOFTWARE), packageElement(SOFTWARE), "Data Type",
				getClassifierRelativeReference("new_classifier"), "PointCloud");

		// Create Device Type Direction
		createElementAndLayout(defaultDiagram(SOFTWARE, SOFTWARE), packageElement(SOFTWARE), "Data Type",
				getClassifierRelativeReference("new_classifier"), "Direction");

		// Create Process Implementation point_cloud_generator
		createImplementationWithNewType(defaultDiagram(SOFTWARE, SOFTWARE), packageElement(SOFTWARE),
				"Process Implementation", "impl", "point_cloud_generator");

		// Create Thread Group Implementation threads
		createImplementationWithNewType(defaultDiagram(SOFTWARE, SOFTWARE), packageElement(SOFTWARE),
				"Thread Group Implementation", "impl", "threads");

		// Create Thread Type pointer
		createElementAndLayout(defaultDiagram(SOFTWARE, SOFTWARE), packageElement(SOFTWARE), "Thread Type",
				getClassifierRelativeReference("new_classifier"), "pointer");

		// Create Thread Implementation integrator
		createImplementationWithNewType(defaultDiagram(SOFTWARE, SOFTWARE), packageElement(SOFTWARE),
				"Thread Implementation", "impl", "integrator");

		// Create point_cloud data access in point_cloud_generator.impl
		createElementAndLayout(defaultDiagram(SOFTWARE, SOFTWARE),
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl")),
				"Data Access", getFeatureRelativeReference("point_cloud_generator_new_feature"), "point_cloud");

		// Set point_cloud data access to provides
		clickRadioButtonInPropertiesView(defaultDiagram(SOFTWARE, SOFTWARE), "Provides", "AADL",
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getFeatureRelativeReference("point_cloud")));

		// Set point_cloud classifier to software::PointCloud
		setClassifierFromPropertiesView(defaultDiagram(SOFTWARE, SOFTWARE), "software::PointCloud",
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getFeatureRelativeReference("point_cloud")));

		// Create threads subcomponent
		createElementAndLayout(defaultDiagram(SOFTWARE, SOFTWARE),
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl")),
				"Thread Group Subcomponent",
				getSubcomponentRelativeReference("point_cloud_generator_impl_new_subcomponent"),
				"threads");

		// Set classifier to software::threads.impl
		setClassifierFromPropertiesView(defaultDiagram(SOFTWARE, SOFTWARE), "software::threads.impl",
				element(getPackageRelativeReference(SOFTWARE),
						getClassifierRelativeReference("point_cloud_generator.impl"),
						getSubcomponentRelativeReference("threads")));

		// Create pointer subcomponent in threads.impl
		createElementAndLayout(defaultDiagram(SOFTWARE, SOFTWARE),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				"Thread Subcomponent", getSubcomponentRelativeReference("threads_impl_new_subcomponent"), "pointer");

		// Set classifier for pointer to shared::pointer
		setClassifierFromPropertiesView(defaultDiagram(SOFTWARE, SOFTWARE), "software::pointer",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("pointer")));

		// Create integrator subcomponent in threads.impl
		createElementAndLayout(defaultDiagram(SOFTWARE, SOFTWARE),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl")),
				"Thread Subcomponent", getSubcomponentRelativeReference("threads_impl_new_subcomponent"), "integrator");

		// Set classifier for integrator to shared::integrator
		setClassifierFromPropertiesView(defaultDiagram(SOFTWARE, SOFTWARE), "software::integrator.impl",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("threads.impl"),
						getSubcomponentRelativeReference("integrator")));

		// Create yaw_servo_interface feature group in pointer
		createElementAndLayout(defaultDiagram(SOFTWARE, SOFTWARE),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer")),
				"Feature Group", getFeatureRelativeReference("pointer_new_feature"), "yaw_servo_interface");

		// Set yaw_servo_interface classifier to shared::ServoInterface
		setClassifierFromPropertiesView(defaultDiagram(SOFTWARE, SOFTWARE), "shared::ServoInterface",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer"),
						getFeatureRelativeReference("yaw_servo_interface")));

		// Create pitch_servo_interface feature group in pointer
		createElementAndLayout(defaultDiagram(SOFTWARE, SOFTWARE),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer")),
				"Feature Group", getFeatureRelativeReference("pointer_new_feature"), "pitch_servo_interface");

		// Set pitch_servo_interface classifier to shared::ServoInterface
		setClassifierFromPropertiesView(defaultDiagram(SOFTWARE, SOFTWARE), "shared::ServoInterface",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer"),
						getFeatureRelativeReference("pitch_servo_interface")));

		// Create direction data port in pointer
		createElementAndLayout(defaultDiagram(SOFTWARE, SOFTWARE),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer")), "Data Port",
				getFeatureRelativeReference("pointer_new_feature"), "direction");

		// Set direction to output
		clickRadioButtonInPropertiesView(defaultDiagram(SOFTWARE, SOFTWARE), "Output", "AADL",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer"),
						getFeatureRelativeReference("direction")));

		// Set direction classifier to Direction
		setClassifierFromPropertiesView(defaultDiagram(SOFTWARE, SOFTWARE), "software::Direction",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("pointer"),
						getFeatureRelativeReference("direction")));

		// Create point_cloud data access in integrator.impl
		createElementAndLayout(defaultDiagram(SOFTWARE, SOFTWARE),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl")),
				"Data Access", getFeatureRelativeReference("integrator_new_feature"), "point_cloud");

		// Set point_cloud classifier to software::PointCloud
		setClassifierFromPropertiesView(defaultDiagram(SOFTWARE, SOFTWARE), "software::PointCloud",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl"),
						getFeatureRelativeReference("point_cloud")));

		// Create direction data port in integrator.impl
		createElementAndLayout(defaultDiagram(SOFTWARE, SOFTWARE),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl")),
				"Data Port", getFeatureRelativeReference("integrator_new_feature"), "direction");

		// Set direction classifier to Direction
		setClassifierFromPropertiesView(defaultDiagram(SOFTWARE, SOFTWARE), "software::Direction",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl"),
						getFeatureRelativeReference("direction")));

		// Set direction to input
		clickRadioButtonInPropertiesView(defaultDiagram(SOFTWARE, SOFTWARE), "Input", "AADL",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl"),
						getFeatureRelativeReference("direction")));

		// Create range_i data port in integrator.impl
		createElementAndLayout(defaultDiagram(SOFTWARE, SOFTWARE),
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl")),
				"Data Port", getFeatureRelativeReference("integrator_new_feature"), "range_i");

		// Set range_i classifier to Integer
		setClassifierFromPropertiesView(defaultDiagram(SOFTWARE, SOFTWARE), "Base_Types::Integer",
				element(getPackageRelativeReference(SOFTWARE), getClassifierRelativeReference("integrator.impl"),
						getFeatureRelativeReference("range_i")));
	}

	private void createIntegratedProject() {
//		 * - Integrated(Project)
//		 *   - integrated(package)
//		 *     - robotic_system.base(system implementation)-
//		 *       - robot(subcomponent hardware::robot.impl)
//		 *       - point_cloud_generator(subcomponent software::point_cloud_generator.impl)
//		 *       - specialized_app(process)
//		 *       - sched1(virtual processor)
//		 *       - sched2(virtual processor)
//		 *       - bind processes to virtual processors
//		 *       - bind virtual processors to processor
//		 *     - robotic_system.specialized(system implementation)-
//		 *       - specialized_app(refined subcomponent specialized_app.impl)-
//		 *     - specialized_app.impl(process implementation)-
//		 *       - point_cloud(requires data access shared::PointCloud)
//		 *       - specialized_thread(subcomponent specialized_thread) - Cannot happen?
//		 *     - specialized_thread(thread type)-
//		 *       - point_cloud(requires data access shared::PointCloud)
		createAadlProjectWithReferencedProjects(INTEGRATED, HARDWARE, SOFTWARE);
		createNewPackageWithPackageDiagram(INTEGRATED, INTEGRATED);

		// Create robotic_system.base system implementation
		createImplementationWithNewType(defaultDiagram(INTEGRATED, INTEGRATED),
				element(getPackageRelativeReference(INTEGRATED)), "System Implementation", "base", "robotic_system");

		// Create robotic_system.specialized System Implementation
		createImplementationWithExistingType(defaultDiagram(INTEGRATED, INTEGRATED),
				element(getPackageRelativeReference(INTEGRATED)), "System Implementation", "specialized",
				INTEGRATED, "robotic_system");

		// Create specialized_app Process Implementation
		createImplementationWithNewType(defaultDiagram(INTEGRATED, INTEGRATED),
				element(getPackageRelativeReference(INTEGRATED)), "System Implementation", "impl", "specialized_app");

		// Create specialized_thread Thread
		createElementAndLayout(defaultDiagram(INTEGRATED, INTEGRATED), element(getPackageRelativeReference(INTEGRATED)),
				"Thread Type", getClassifierRelativeReference("new_classifier"), "specialized_thread");

		// Create point_cloud data access in specialized_app
		createElementAndLayout(defaultDiagram(INTEGRATED, INTEGRATED),
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("specialized_app.impl")),
				"Data Access",
				getFeatureRelativeReference("specialized_app_new_feature"), "point_cloud");

		// Set point_cloud classifier to shared::PointCloud
		setClassifierFromPropertiesView(defaultDiagram(INTEGRATED, INTEGRATED), "software::PointCloud",
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("specialized_app.impl"),
						getFeatureRelativeReference("point_cloud")));

		// Create robot in robotic_system.base
		createElementAndLayout(defaultDiagram(INTEGRATED, INTEGRATED),
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("robotic_system.base")),
				"System Subcomponent", getSubcomponentRelativeReference("robotic_system_base_new_subcomponent"),
				"robot");

		// Set robot classifier to hardware::robot.impl
		setClassifierFromPropertiesView(defaultDiagram(INTEGRATED, INTEGRATED), "hardware::robot.impl",
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("robot")));

		// Create point_cloud_generator subcomponent in robotic_system_base
		createElementAndLayout(defaultDiagram(INTEGRATED, INTEGRATED),
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("robotic_system.base")),
				"Process Subcomponent", getSubcomponentRelativeReference("robotic_system_base_new_subcomponent"),
				"point_cloud_generator");

		// Set point_cloud_generator to software::point_cloud_generator.impl
		setClassifierFromPropertiesView(defaultDiagram(INTEGRATED, INTEGRATED), "software::point_cloud_generator.impl",
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("point_cloud_generator")));

		// Create specialized_app subcomponent in robotic_system.base
		createElementAndLayout(defaultDiagram(INTEGRATED, INTEGRATED),
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("robotic_system.base")),
				"Process Subcomponent", getSubcomponentRelativeReference("robotic_system_base_new_subcomponent"),
				"specialized_app");

		// Create sched1 subcomponent in robotic_system.specialized
		createElementAndLayout(defaultDiagram(INTEGRATED, INTEGRATED),
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("robotic_system.base")),
				"Virtual Processor Subcomponent",
				getSubcomponentRelativeReference("robotic_system_base_new_subcomponent"), "sched1");

		// Create sched2 subcomponent in robotic_system.specialized
		createElementAndLayout(defaultDiagram(INTEGRATED, INTEGRATED),
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("robotic_system.base")),
				"Virtual Processor Subcomponent",
				getSubcomponentRelativeReference("robotic_system_base_new_subcomponent"), "sched2");

		bindPropertyAssociations(defaultDiagram(INTEGRATED, INTEGRATED),
				new DiagramElementReference[] { element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("sched2")) },
				new DiagramElementReference[] { element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("sched1")) },
				"Actual_Processor_Binding");

		bindPropertyAssociations(defaultDiagram(INTEGRATED, INTEGRATED),
				new DiagramElementReference[] { element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("specialized_app")) },
				new DiagramElementReference[] { element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.base"),
						getSubcomponentRelativeReference("sched2")) },
				"Actual_Processor_Binding");

		// Create specialized_app subcomponent in robotic_system.specialized
		createElementAndLayout(defaultDiagram(INTEGRATED, INTEGRATED),
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("robotic_system.specialized")),
				"Process Subcomponent", getSubcomponentRelativeReference("robotic_system_specialized_new_subcomponent"),
				"specialized_app");

		// Set point_cloud requires
		clickRadioButtonInPropertiesView(defaultDiagram(INTEGRATED, INTEGRATED), "Requires", "AADL",
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("specialized_app.impl"),
						getFeatureRelativeReference("point_cloud")));

		// Create point_cloud data access in specialized_thread
		createElementAndLayout(defaultDiagram(INTEGRATED, INTEGRATED),
				element(getPackageRelativeReference(INTEGRATED),
						getClassifierRelativeReference("specialized_thread")),
				"Data Access", getFeatureRelativeReference("specialized_thread_new_feature"), "point_cloud");

		// Set point_cloud classifier to software::PointCloud
		setClassifierFromPropertiesView(defaultDiagram(INTEGRATED, INTEGRATED), "software::PointCloud",
				element(getPackageRelativeReference(INTEGRATED), getClassifierRelativeReference("specialized_thread"),
						getFeatureRelativeReference("point_cloud")));
	}

	// TODO: rename
	private void additionalTests() {
		// TODO: additional tests
		// TODO: Cleanup
		final DiagramReference diagram = defaultDiagram(HARDWARE, HARDWARE);

		// Hide Contents
		clickContextMenuOfDiagramElement(diagram, packageElement(HARDWARE), "Hide Contents", "All");
		// TODO: Contents contents. Can be done at this level? Fundamental objects. Sharing required BO

		// Show contents
		clickContextMenuOfDiagramElement(diagram, packageElement(HARDWARE), "Show Contents", "All");
		// TODO: Contents contents. Can be done at this level? Fundamental objects. Sharing required BO
	}
}
