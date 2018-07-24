package org.osate.ge.tests;

import java.util.function.Function;

import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.swt.graphics.Point;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.BusType;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

public class AlignElementsTest {
	private final String hw = "hardware";
	private final String sw = "software";
	private final String projectName = "demo_test";
	private final AgeGefBot bot = new AgeGefBot();
	private final String abstractImplName = ElementNames.abstractTypeName + ".impl";

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
		CreateConnectionTest.createNestedElementsWithPorts(bot, editor, hw);

		bot.selectElements(editor,
				new String[] { ElementNames.abstractSubcomponentName, ElementNames.abstractFeatureNewName },
				new String[] { ElementNames.abstractSubcomponentName2, ElementNames.abstractFeatureNewName2 });

		bot.clickToolbarButtonWithTooltip("Align Middle");

		final GraphitiShapeEditPart featureIn = (GraphitiShapeEditPart)bot.findEditPart(editor, ElementNames.abstractSubcomponentName,
				ElementNames.abstractFeatureNewName).part();
		final GraphitiShapeEditPart featureOut = (GraphitiShapeEditPart)bot.findEditPart(editor, ElementNames.abstractSubcomponentName2,
				ElementNames.abstractFeatureNewName2).part();

		int primaryLocation = findDiagramRelativeLocation(yLocation, featureOut);
		assertAligned(primaryLocation, findDiagramRelativeLocation(yLocation, featureIn));

		bot.resizeEditPart(editor, new Point(3000, 3000), hw);

		bot.createToolItemAndRename(editor, DeviceType.class, new Point(2500, 2500), "sensor", hw);
		bot.createToolItemAndRename(editor, DeviceType.class, new Point(300, 20), "actuator", hw);
		bot.createToolItemAndRename(editor, BusType.class, new Point(20, 400), "ethernet_switch", hw);
		bot.createToolItemAndRename(editor, FeatureGroupType.class, new Point(2000, 500), "sensor_data", hw);

		bot.selectElements(editor, new String[] { "sensor" }, new String[] { "actuator" },
				new String[] { "ethernet_switch" },
				new String[] { abstractImplName, ElementNames.abstractSubcomponentName });

		bot.clickToolbarButtonWithTooltip("Align Left");

		// TODO test with editor open/closed

		// sensor
		final GraphitiShapeEditPart primaryGcep = (GraphitiShapeEditPart) bot.getEditPart(editor, "sensor").part();
		primaryLocation = findDiagramRelativeLocation(xLocation, primaryGcep);

		// actuator
		GraphitiShapeEditPart gcep = (GraphitiShapeEditPart) bot.getEditPart(editor, "actuator").part();
		assertAligned(primaryLocation, findDiagramRelativeLocation(xLocation, gcep));

		// ethernet_switch
		gcep = (GraphitiShapeEditPart) bot.getEditPart(editor, "ethernet_switch").part();
		assertAligned(primaryLocation, findDiagramRelativeLocation(xLocation, gcep));

		// subcomponent
		gcep = (GraphitiShapeEditPart) bot.getEditPart(editor, ElementNames.abstractSubcomponentName).part();
		assertAligned(primaryLocation, findDiagramRelativeLocation(xLocation, gcep));
	}

	private Function<GraphitiShapeEditPart, Integer> xLocation = (gcep) -> gcep.getPictogramElement()
			.getGraphicsAlgorithm().getX();

	private Function<GraphitiShapeEditPart, Integer> yLocation = (gcep) -> gcep.getPictogramElement()
			.getGraphicsAlgorithm().getY();

	// TODO rename?
	private int findDiagramRelativeLocation(final Function<GraphitiShapeEditPart, Integer> func,
			GraphitiShapeEditPart gcep) {
		int loc = func.apply(gcep);
		while (gcep.getParent() instanceof GraphitiShapeEditPart) {
			gcep = (GraphitiShapeEditPart) gcep.getParent();
			loc += func.apply(gcep);
		}

		return loc;
	}

	private void assertAligned(final int primaryGcep, final int gcep) {
		Assert.assertEquals("location should match", primaryGcep, gcep, 0);
	}
}
