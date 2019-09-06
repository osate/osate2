package org.osate.ge.tests.endToEnd;

import static org.osate.ge.internal.services.impl.DeclarativeReferenceBuilder.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestCommands.*;
import static org.osate.ge.tests.endToEnd.util.OsateGeTestUtil.*;

import org.junit.Test;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;
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

		final RelativeBusinessObjectReference packageRef = getPackageRelativeReference(SHARED);
		createElementAndLayout("Feature Group Type", SERVO_INTERFACE, new RelativeBusinessObjectReference[] {
				packageRef, getClassifierRelativeReference("new_classifier") }, packageRef);
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

		final RelativeBusinessObjectReference hardwarePkgRef = getPackageRelativeReference(HARDWARE);
		setActiveEditor(HARDWARE, HARDWARE);
		createImplementationWithNewType("System Implementation", "impl", "robot", hardwarePkgRef);

		final RelativeBusinessObjectReference componentsPackage = getPackageRelativeReference(
				HARDWARE_COMPONENTS_PACKAGE);
		setActiveEditor(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM);

		// Create Virtual Bus Type ethernet
		// createElementAndLayout("Virtual Bus Type", "ethernet", new RelativeBusinessObjectReference[] {
		// componentsPackage, getRelativeReference(Classifier.class, "new_classifier") }, componentsPackage);

		// Create Device Type servo
		createElementAndLayout("Device Type", "servo", new RelativeBusinessObjectReference[] { componentsPackage,
				getClassifierRelativeReference("new_classifier") }, componentsPackage);

		// Bus Access eth
		createElementAndLayout(
				"Bus Access", "eth", new RelativeBusinessObjectReference[] { componentsPackage,
						getClassifierRelativeReference("servo"), getFeatureRelativeReference("servo_new_feature") },
				componentsPackage);

		// Feature group interface
		createElementAndLayout("Feature Group", "interface",
				new RelativeBusinessObjectReference[] { componentsPackage,
						getClassifierRelativeReference("servo"),
						getFeatureRelativeReference("servo_new_feature") },
				componentsPackage);

		// Set classifier shared::ServoInterface
		setClassifierFromPropertyView("shared::ServoInterface",
				new RelativeBusinessObjectReference[] { componentsPackage,
						getClassifierRelativeReference("servo"),
						getFeatureRelativeReference("interface") });

		// Device type rangefinder
		createElementAndLayout("Device Type", "rangefinder", new RelativeBusinessObjectReference[] { componentsPackage,
				getClassifierRelativeReference("new_classifier") }, componentsPackage);

		// Bus Access eth
		createElementAndLayout("Bus Access", "eth",
				new RelativeBusinessObjectReference[] { componentsPackage,
						getClassifierRelativeReference("rangefinder"),
						getFeatureRelativeReference("rangefinder_new_feature") },
				componentsPackage);

		// Set classifier for rangefinder::eth and servo::eth
		// setClassifierFromPropertyView("hardware::components::ethernet",
		// new RelativeBusinessObjectReference[] { componentsPackage,
		// getRelativeReference(Classifier.class, "rangefinder"),
		// getRelativeReference(Feature.class, "eth") },
		// new RelativeBusinessObjectReference[] { componentsPackage,
		// getRelativeReference(Classifier.class, "servo"), getRelativeReference(Feature.class, "eth") });

		/*
		 * // Set requires bus access
		 * clickRadioButtonInPropertyView("Requires", new RelativeBusinessObjectReference[] { componentsPackage,
		 * getRelativeReference(Classifier.class, "rangefinder"), getRelativeReference(Feature.class, "eth") },
		 * new RelativeBusinessObjectReference[] { componentsPackage,
		 * getRelativeReference(Classifier.class, "servo"), getRelativeReference(Feature.class, "eth") });
		 */
		// Data Port range_o
		createElementAndLayout("Data Port", "range_o", new RelativeBusinessObjectReference[] { componentsPackage,
				getClassifierRelativeReference("rangefinder"), getFeatureRelativeReference("rangefinder_new_feature") },
				componentsPackage);

		// Create cpu.impl
		createImplementationWithNewType("Processor Implementation", "impl", "cpu", componentsPackage);

		// Create memory type rom
		createElementAndLayout("Memory Type", "rom", new RelativeBusinessObjectReference[] { componentsPackage,
				getClassifierRelativeReference("new_classifier") }, componentsPackage);

		// Create memory type ram
		createElementAndLayout("Memory Type", "ram", new RelativeBusinessObjectReference[] { componentsPackage,
				getClassifierRelativeReference("new_classifier") }, componentsPackage);

		// Set hardware package editor active
		setActiveEditor(HARDWARE, HARDWARE);
		final RelativeBusinessObjectReference[] robotNewSCRef = new RelativeBusinessObjectReference[] { hardwarePkgRef,
				getClassifierRelativeReference("robot.impl"),
				getSubcomponentRelativeReference("robot_impl_new_subcomponent") };

		// Create device subcomponent yaw_servo
		createElementAndLayout("Device Subcomponent", "yaw_servo",
				robotNewSCRef,
				hardwarePkgRef);

		// Set classifier
		setClassifierFromPropertyView("hardware::components::servo",
				new RelativeBusinessObjectReference[] { hardwarePkgRef,
						getClassifierRelativeReference("robot.impl"), getSubcomponentRelativeReference("yaw_servo") });

		// Create subcomponent pitch_servo
		createElementAndLayout("Device Subcomponent", "pitch_servo", robotNewSCRef,
				hardwarePkgRef);

		// Set classifier for pitch_servo
		setClassifierFromPropertyView("hardware::components::servo",
				new RelativeBusinessObjectReference[] { hardwarePkgRef,
						getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("pitch_servo") });

		// Create subcomponent
		createElementAndLayout("Device Subcomponent", "rangefinder", robotNewSCRef,
				hardwarePkgRef);

		// Set classifier for rangefinder
		setClassifierFromPropertyView("hardware::components::rangefinder",
				new RelativeBusinessObjectReference[] { hardwarePkgRef,
						getClassifierRelativeReference("robot.impl"),
						getSubcomponentRelativeReference("rangefinder") });

		// Create CPU subcomponent
		createElementAndLayout("Processor Subcomponent", "cpu", robotNewSCRef,
				hardwarePkgRef);

		// Set classifier for cpu
		setClassifierFromPropertyView("hardware::components::cpu",
				new RelativeBusinessObjectReference[] { hardwarePkgRef,
						getClassifierRelativeReference("robot.impl"), getSubcomponentRelativeReference("cpu") });

		// Create Eth subcomponent
		createElementAndLayout("Virtual Bus Subcomponent", "ethernet_buses", robotNewSCRef,
				hardwarePkgRef);

		// Set classifier for ethernet_buses
		setSubcomponentToNewTypeFromPropertiesView(new RelativeBusinessObjectReference[] { hardwarePkgRef,
				getClassifierRelativeReference("robot.impl"), getSubcomponentRelativeReference("ethernet_buses") },
				HARDWARE_COMPONENTS_PACKAGE, "ethernet");

		setActiveEditor(HARDWARE, HARDWARE_COMPONENTS_DIAGRAM);

		// Set classifier for rangefinder::eth and servo::eth
		setClassifierFromPropertyView("hardware::components::ethernet",
				new RelativeBusinessObjectReference[] { componentsPackage,
						getClassifierRelativeReference("rangefinder"), getFeatureRelativeReference("eth") },
				new RelativeBusinessObjectReference[] { componentsPackage,
						getClassifierRelativeReference("servo"), getFeatureRelativeReference("eth") });

		// Set requires bus access
		clickRadioButtonInPropertyView("Requires", new RelativeBusinessObjectReference[] { componentsPackage,
				getClassifierRelativeReference("rangefinder"), getFeatureRelativeReference("eth") },
				new RelativeBusinessObjectReference[] { componentsPackage,
						getClassifierRelativeReference("servo"), getFeatureRelativeReference("eth") });
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
		createAadlProjectWithReferencedProjects(SOFTWARE, SHARED);
		createNewPackageWithPackageDiagram(SOFTWARE, SOFTWARE);

		// TODO

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
//		 *     - specialized_app.impl(process implementation)
//		 *       - point_cloud(requires data access shared::PointCloud)
//		 *       - specialized_thread(subcomponent specialized_thread)
//		 *     - specialized_thread(thread type)
//		 *       - point_cloud(requires data access shared::PointCloud)
		createAadlProjectWithReferencedProjects(INTEGRATED, HARDWARE, SOFTWARE);
		createNewPackageWithPackageDiagram(INTEGRATED, INTEGRATED);

	}

	// TODO: rename
	private void additionalTests() {
		// TODO: additional tests
		// TODO: Cleanup
		final DiagramReference diagram = diagram(HARDWARE, "diagrams", HARDWARE);

		// Hide Contents
		clickContextMenuOfDiagramElement(diagram, packageElement(HARDWARE), "Hide Contents", "All");
		// TODO: Contents contents. Can be done at this level? Fundamental objects. Sharing required BO

		// Show contents
		clickContextMenuOfDiagramElement(diagram, packageElement(HARDWARE), "Show Contents", "All");
		// TODO: Contents contents. Can be done at this level? Fundamental objects. Sharing required BO
	}
}
