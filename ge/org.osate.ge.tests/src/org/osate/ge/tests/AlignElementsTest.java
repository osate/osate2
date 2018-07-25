package org.osate.ge.tests;

import java.util.function.Function;

import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.swt.graphics.Point;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.BusType;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

public class AlignElementsTest {
	private final AgeGefBot bot = new AgeGefBot();
	private static final String hw = "hardware";
	private static final String projectName = "demo_test";
	private static final String abstractImplName = ElementNames.abstractTypeName + ".impl";

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
		// Create nested elements
		bot.createAbstractTypeAndImplementation(hw, new Point(30, 30));

		bot.resizeEditPart(editor, new Point(150, 150), ElementNames.abstractTypeName);
		bot.openPropertiesView();

		// Create ports and subcomponent
		createNestedElements(editor);

		// Extend subcomponent classifier
		bot.setElementOptionButtonInPropertiesView(editor, "AADL", "Choose...",
				new String[] { ElementNames.abstractSubcomponentName });

		bot.clickTableOption(AgeGefBot.qualifiedName(hw, ElementNames.abstractTypeName));
		bot.clickButton("OK");

		editor.setFocus();

		// Show children of subcomponent
		bot.selectElements(editor, new String[] { abstractImplName,
				ElementNames.abstractSubcomponentName });
		editor.clickContextMenu(AgeGefBot.allFilters);

		bot.selectElements(editor,
				new String[] { ElementNames.abstractSubcomponentName, ElementNames.abstractFeatureNewName },
				new String[] { abstractImplName, ElementNames.abstractFeatureNewName2 });

		bot.clickToolbarButtonWithTooltip("Align Top");

		// Close text editor
		bot.saveAndCloseEditor(hw + ".aadl");

		final GraphitiShapeEditPart featureIn = (GraphitiShapeEditPart)bot.findEditPart(editor, ElementNames.abstractSubcomponentName,
				ElementNames.abstractFeatureNewName).part();
		final GraphitiShapeEditPart featureOut = (GraphitiShapeEditPart) bot
				.findEditPart(editor, abstractImplName,
				ElementNames.abstractFeatureNewName2).part();

		// Check if elements are aligned
		int primaryLocation = findDiagramRelativeLocation(yLocation, featureOut);
		assertAligned(primaryLocation, findDiagramRelativeLocation(yLocation, featureIn));

		bot.resizeEditPart(editor, new Point(1500, 1500), hw);

		bot.createToolItemAndRename(editor, DeviceType.class, new Point(900, 900), "sensor", hw);
		bot.createToolItemAndRename(editor, DeviceType.class, new Point(300, 20), "actuator", hw);
		bot.createToolItemAndRename(editor, BusType.class, new Point(20, 400), "ethernet_switch", hw);
		bot.createToolItemAndRename(editor, FeatureGroupType.class, new Point(1100, 500), "sensor_data", hw);

		bot.selectElements(editor, new String[] { "sensor" }, new String[] { "actuator" },
				new String[] { "ethernet_switch" },
				new String[] { abstractImplName, ElementNames.abstractSubcomponentName });

		bot.clickToolbarButtonWithTooltip("Align Left");

		// Check if elements are aligned
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

	private void createNestedElements(final AgeSWTBotGefEditor editor) {
		bot.createToolItemAndRename(editor, AbstractFeature.class, new Point(15, 15),
				ElementNames.abstractFeatureNewName, ElementNames.abstractTypeName);
		bot.createToolItemAndRename(editor, AbstractFeature.class, new Point(100, 100),
				ElementNames.abstractFeatureNewName2, ElementNames.abstractTypeName);

		final String abstractImplName = ElementNames.abstractTypeName + ".impl";
		bot.resizeEditPart(editor, new Point(250, 200), abstractImplName);
		bot.executeContextMenuCommand(editor, abstractImplName, AgeGefBot.allFilters);

		bot.clickElement(editor, abstractImplName);
		bot.createToolItemAndRename(editor, AbstractSubcomponent.class, new Point(200, 100),
				ElementNames.abstractSubcomponentName, abstractImplName);
	}

	private static final Function<GraphitiShapeEditPart, Integer> xLocation = (gcep) -> gcep.getPictogramElement()
			.getGraphicsAlgorithm().getX();

	private static final Function<GraphitiShapeEditPart, Integer> yLocation = (gcep) -> gcep.getPictogramElement()
			.getGraphicsAlgorithm().getY();

	private static int findDiagramRelativeLocation(final Function<GraphitiShapeEditPart, Integer> getLocation,
			GraphitiShapeEditPart gcep) {
		int loc = getLocation.apply(gcep);
		while (gcep.getParent() instanceof GraphitiShapeEditPart) {
			gcep = (GraphitiShapeEditPart) gcep.getParent();
			loc += getLocation.apply(gcep);
		}

		return loc;
	}

	private void assertAligned(final int primaryGcep, final int gcep) {
		Assert.assertEquals("elements are not aligned", primaryGcep, gcep, 0);
	}
}
