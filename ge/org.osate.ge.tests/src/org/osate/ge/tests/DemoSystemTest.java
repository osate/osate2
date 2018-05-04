package org.osate.ge.tests;

import static org.junit.Assert.assertTrue;

import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.BusSubcomponent;
import org.osate.aadl2.BusType;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.FeatureConnection;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.ProcessorType;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.ge.internal.ui.tools.SetBindingTool;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

public class DemoSystemTest {
	private final String hw = "hardware";
	private final String sw = "software";
	private final String cpu = "cpu";
	private final String application = "application";
	private final String projectName = "demo_test";
	private final String demo_system = "demo_system";
	private final String implName = "impl";
	private final AgeGefBot bot = new AgeGefBot();

	@Before
	public void setUp() {
		bot.maximize();
		bot.createNewProjectAndPackage(projectName, hw);
		bot.openDiagram(new String[] { projectName }, hw);
	}

	@After
	public void tearDown() {
		bot.deleteProject(projectName);
	}

	@Test
	public void runDemoTest() {
		final AgeSWTBotGefEditor editor = bot.getEditor(hw);
		bot.resizeEditPart(editor, new Point(600, 600), hw);
		bot.createTypeAndImplementation(editor, new Point(25, 25), implName, hw,
				ToolTypes.getToolItem(SystemImplementation.class), hw);

		bot.createToolItemAndRename(editor, ProcessorType.class, new Point(20, 150), cpu, hw);
		bot.createToolItemAndRename(editor, DeviceType.class, new Point(300, 150), "sensor", hw);
		bot.createToolItemAndRename(editor, DeviceType.class, new Point(300, 300), "actuator", hw);
		bot.createToolItemAndRename(editor, BusType.class, new Point(20, 400), "ethernet_switch", hw);
		bot.createToolItemAndRename(editor, FeatureGroupType.class, new Point(300, 500), "sensor_data", hw);
		bot.executeContextMenuCommand(editor, hw, "Layout Diagram");

		bot.createAADLPackage(projectName, sw);

		final AgeSWTBotGefEditor swEditor = bot.getEditor(sw);
		bot.resizeEditPart(swEditor, new Point(600, 600), sw);
		bot.createToolItemAndRename(swEditor, ProcessorType.class, new Point(20, 150), "sensor_fuser", sw);
		bot.createToolItemAndRename(swEditor, ProcessorType.class, new Point(300, 150), "actuator_controller", sw);
		bot.createTypeAndImplementation(swEditor, new Point(50, 50), implName, application,
				ToolTypes.getToolItem(SystemImplementation.class), sw);

		bot.createAADLPackage(projectName, demo_system);
		final SWTBotGefEditor demoTestEditor = bot.getEditor(demo_system);
		bot.resizeEditPart(demoTestEditor, new Point(600, 600), demo_system);
		bot.createTypeAndImplementation(demoTestEditor, new Point(50, 50), implName, demo_system,
				ToolTypes.getToolItem(SystemImplementation.class), demo_system);

		final String demoSysImpl = demo_system + "." + implName;
		bot.openAssociatedDiagramFromContextMenu(demoTestEditor, demoSysImpl);

		final AgeSWTBotGefEditor demoSysImplEditor = bot.getEditor(demo_system + "_" + demo_system + "_" + implName);
		bot.clickElement(demoSysImplEditor, demo_system + "." + implName);
		bot.executeContextMenuCommand(demoSysImplEditor, demoSysImpl, "All Filters");
		bot.resizeEditPart(demoSysImplEditor, new Point(600, 600), demoSysImpl);

		bot.openPropertiesView();

		final String swSc = "sw";
		bot.createToolItemAndRename(demoSysImplEditor, SystemSubcomponent.class, new Point(50, 50), swSc, demoSysImpl);
		bot.setElementOptionButtonInPropertiesView(demoSysImplEditor, "AADL", "Choose...", new String[] { swSc });
		bot.clickTableOption(AgeGefBot.qualifiedName(sw, application + "." + implName));
		bot.clickButton("OK");

		final String hwSc = "hw";
		bot.createToolItemAndRename(demoSysImplEditor, SystemSubcomponent.class, new Point(50, 150), hwSc, demoSysImpl);
		bot.setElementOptionButtonInPropertiesView(demoSysImplEditor, "AADL", "Choose...", new String[] { hwSc });
		bot.clickTableOption(AgeGefBot.qualifiedName(hw, hw + "." + implName));
		bot.clickButton("OK");

		demoTestEditor.click(demo_system);
		bot.executeContextMenuCommand(demoSysImplEditor, hwSc, "All Filters");
		bot.resizeEditPart(demoSysImplEditor, new Point(350, 350), hwSc);

		// Create devices
		bot.createToolItemAndRename(demoSysImplEditor, DeviceSubcomponent.class, new Point(20, 20), "sensor1", hwSc);
		bot.executeContextMenuCommand(demoSysImplEditor, "sensor1", "All Filters");
		bot.setElementOptionButtonInPropertiesView(demoSysImplEditor, "AADL", "Choose...", new String[] { "sensor1" });
		bot.clickTableOption(AgeGefBot.qualifiedName(hw, "sensor"));
		bot.clickButton("OK");

		bot.createToolItemAndRename(demoSysImplEditor, BusAccess.class, new Point(80, 20), "ba_req", "sensor1");

		bot.createToolItemAndRename(demoSysImplEditor, DataPort.class, new Point(20, 20), "dp_out", "sensor1");
		bot.setElementOptionRadioInPropertiesView(demoSysImplEditor, "AADL", "Output", "dp_out");
		bot.createToolItemAndRename(demoSysImplEditor, DeviceSubcomponent.class, new Point(20, 200), "sensor2", swSc);
		bot.executeContextMenuCommand(demoSysImplEditor, "sensor2", "All Filters");
		bot.setElementOptionButtonInPropertiesView(demoSysImplEditor, "AADL", "Choose...", new String[] { "sensor2" });
		bot.clickTableOption(AgeGefBot.qualifiedName(hw, "actuator"));
		bot.clickButton("OK");

		bot.createToolItemAndRename(demoSysImplEditor, DataPort.class, new Point(20, 20), "dp_in", "sensor2");
		bot.setElementOptionRadioInPropertiesView(demoSysImplEditor, "AADL", "Input", "dp_in");

		bot.createToolItemAndRename(demoSysImplEditor, ProcessorSubcomponent.class, new Point(20, 20), "cpu1",
				demoSysImpl);
		bot.createToolItemAndRename(demoSysImplEditor, ProcessorSubcomponent.class, new Point(400, 20), "cpu2",
				demoSysImpl);

		bot.selectWidget("AADL");
		bot.selectElements(demoSysImplEditor, new String[] { "cpu1" }, new String[] { "cpu2" });
		bot.clickButton("Choose...");
		bot.clickTableOption(AgeGefBot.qualifiedName(hw, cpu));
		bot.clickButton("OK");

		bot.createToolItemAndRename(demoSysImplEditor, BusAccess.class, new Point(20, 20), "ba", "cpu1");
		bot.createToolItemAndRename(demoSysImplEditor, BusSubcomponent.class, new Point(400, 400), "ethernet_switch",
				demoSysImpl);
		bot.setElementOptionButtonInPropertiesView(demoSysImplEditor, "AADL", "Choose...",
				new String[] { "ethernet_switch" });
		bot.clickTableOption(AgeGefBot.qualifiedName(hw, "ethernet_switch"));
		bot.clickButton("OK");

		bot.createToolItemAndRename(demoSysImplEditor, FeatureGroup.class, new Point(5, 300), "actuator_data",
				demoSysImpl);
		bot.setElementOptionButtonInPropertiesView(demoSysImplEditor, "AADL", "Choose...",
				new String[] { "actuator_data" });
		bot.clickTableOption(AgeGefBot.qualifiedName(hw, "sensor_data"));
		bot.clickButton("OK");

		bot.createToolItemAndRename(demoSysImplEditor, DataPort.class, new Point(5, 5), "sd1", "actuator_data");
		bot.createToolItemAndRename(demoSysImplEditor, DataPort.class, new Point(5, 20), "sd2", "actuator_data");

		bot.setElementOptionRadioInPropertiesView(demoSysImplEditor, "AADL", "Output", "sd1");
		bot.setElementOptionRadioInPropertiesView(demoSysImplEditor, "AADL", "Output", "sd2");

		bot.setElementOptionButtonInPropertiesView(demoSysImplEditor, "AADL", "Choose...", new String[] { "ba" });
		bot.clickTableOption(AgeGefBot.qualifiedName(hw, "ethernet_switch"));
		bot.clickButton("OK");

		demoSysImplEditor.activateTool(ToolTypes.getToolItem(FeatureConnection.class));

		// Create Connection 1
		bot.clickElements(demoSysImplEditor, new String[] { "actuator_data", "sd1" }, new String[] { "cpu1", "ba" });

		// Create Connection 2
		bot.clickElements(demoSysImplEditor, new String[] { "cpu1", "ba" }, new String[] { "cpu2", "ba" });

		// Create Connection 3
		bot.clickElements(demoSysImplEditor, new String[] { "actuator_data", "sd1" }, new String[] { "cpu2", "ba" });

		final GraphitiShapeEditPart gsep = (GraphitiShapeEditPart) bot.findEditPart(demoSysImplEditor, demoSysImpl)
				.part();
		final SystemImplementation si = (SystemImplementation) AgeGefBot.getAgeFeatureProvider(demoSysImplEditor)
				.getBusinessObjectForPictogramElement(gsep.getPictogramElement());

		assertTrue(si.getOwnedPropertyAssociations().isEmpty());

		// Add binding
		demoSysImplEditor.select(demoSysImpl);
		bot.clickToolbarButtonWithTooltip("Bind...");
		bot.waitUntilShellIsActive("Bind");
		bot.clickCombo(SetBindingTool.setBindingIdentifier, "Actual_Connection_Binding");
		demoSysImplEditor.select(bot.findEditPart(demoSysImplEditor, "cpu2"));
		bot.clickButton("OK");

		assertTrue(!si.getOwnedPropertyAssociations().isEmpty());
	}
}
