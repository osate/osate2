package org.osate.ge.tests;

import static org.junit.Assert.assertNotEquals;

import org.eclipse.draw2d.Connection;
import org.eclipse.graphiti.features.impl.AbstractFeature;
import org.eclipse.graphiti.ui.platform.GraphitiConnectionEditPart;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefConnectionEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.impl.FeatureConnectionImpl;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

public class MoveBendpointsBetweenSelectedShapesTest {
	private final AgeGefBot bot = new AgeGefBot();

	@Before
	public void setUp() {
		bot.maximize();
		bot.createNewProjectAndPackage(ElementNames.projectName, ElementNames.packageName);
		bot.openDiagram(new String[] { ElementNames.projectName }, ElementNames.packageName);
		bot.createAbstractTypeAndImplementation(ElementNames.packageName, new Point(30, 30));
	}

	@After
	public void tearDown() {
		bot.deleteProject(ElementNames.projectName);
	}

	@Test
	public void moveConnectedShapes() {
		final AgeSWTBotGefEditor editor = bot.getEditor(ElementNames.packageName);
		bot.resizeEditPart(editor, new Point(150, 150), ElementNames.abstractTypeName);
		bot.openPropertiesView();

		final String abstractTypeName2 = ElementNames.abstractTypeName + "2";
		bot.createToolItemAndRename(editor, ToolTypes.getToolItem(AbstractType.class), new Point(20, 350),
				abstractTypeName2, ElementNames.packageName);

		// Create feature set to output
		bot.createToolItemAndRename(editor, ToolTypes.getToolItem(AbstractFeature.class), new Point(10, 10),
				ElementNames.abstractFeatureNewName, abstractTypeName2);
		bot.setElementOptionRadioInPropertiesView(editor, "AADL", "Output", ElementNames.abstractFeatureNewName);

		final String abstractTypeName3 = ElementNames.abstractTypeName + "3";
		bot.createToolItemAndRename(editor, ToolTypes.getToolItem(AbstractType.class), new Point(300, 20),
				abstractTypeName3,
				ElementNames.packageName);

		// Create feature
		bot.createToolItemAndRename(editor, ToolTypes.getToolItem(AbstractFeature.class), new Point(10, 10),
				ElementNames.abstractFeatureNewName, abstractTypeName3);

		// Open impl diagram
		final String abstractImplName = ElementNames.abstractTypeName + ".impl";
		bot.openAssociatedDiagramFromContextMenu(editor, abstractImplName);

		// Create subcomponents
		final AgeSWTBotGefEditor implEditor = bot
				.getEditor(ElementNames.packageName + "_" + abstractImplName.replace(".", "_"));
		bot.resizeEditPart(implEditor, new Point(400, 400), abstractImplName);
		bot.createToolItemAndRename(implEditor, AbstractSubcomponent.class, new Point(20, 20),
				ElementNames.abstractSubcomponentName, abstractImplName);

		bot.createToolItemAndRename(implEditor, AbstractSubcomponent.class, new Point(20, 250),
				ElementNames.abstractSubcomponentName2, abstractImplName);

		bot.setElementOptionButtonInPropertiesView(implEditor, "AADL", "Choose...",
				new String[] { ElementNames.abstractSubcomponentName });
		bot.clickTableOption(AgeGefBot.qualifiedName(ElementNames.packageName, abstractTypeName2));
		bot.clickButton("OK");

		bot.sleep(1);

		bot.setElementOptionButtonInPropertiesView(implEditor, "AADL", "Choose...",
				new String[] { ElementNames.abstractSubcomponentName2 });
		bot.clickTableOption(AgeGefBot.qualifiedName(ElementNames.packageName, abstractTypeName3));
		bot.clickButton("OK");

		final SWTBotGefEditPart featureOut = bot.findEditPart(implEditor, ElementNames.abstractSubcomponentName,
				ElementNames.abstractFeatureNewName);
		final SWTBotGefEditPart featureIn = bot.findEditPart(implEditor, ElementNames.abstractSubcomponentName2,
				ElementNames.abstractFeatureNewName);

		// Create connection
		implEditor.activateTool("Feature Connection");
		implEditor.click(featureOut);
		implEditor.click(featureIn);
		implEditor.activateDefaultTool();

		// Move bendpoint
		bot.mouseSelectElement(implEditor, featureOut);
		final SWTBotGefConnectionEditPart connectionEditPart = bot.getNewConnection(implEditor,
				FeatureConnectionImpl.class);

		implEditor.select(connectionEditPart);
		final Connection connection = ((GraphitiConnectionEditPart) connectionEditPart.part()).getConnectionFigure();

		// Drag connection bendpoint
		bot.clickConnection(implEditor, connection);
		final Point dragOffset = new Point(30, 30);
		bot.dragConnectionMidpoint(implEditor, connection, dragOffset);

		bot.sleep(1);

		// Original connection mid point
		final org.eclipse.draw2d.geometry.Point originalMidPoint = connection.getPoints().getMidpoint();

		// Move subcomponents
		bot.selectElements(implEditor, new String[] { ElementNames.abstractSubcomponentName },
				new String[] { ElementNames.abstractSubcomponentName2 });
		bot.dragElements(implEditor, ElementNames.abstractSubcomponentName, dragOffset);

		bot.sleep(1);

		// Get connection after move
		final SWTBotGefConnectionEditPart connectionEditPartAfterMove = bot.getNewConnection(implEditor,
				FeatureConnectionImpl.class);
		final Connection connectionAfterMove = ((GraphitiConnectionEditPart) connectionEditPartAfterMove.part())
				.getConnectionFigure();

		// New midpoint
		final org.eclipse.draw2d.geometry.Point newMidPoint = connectionAfterMove.getPoints().getMidpoint();

		assertNotEquals(originalMidPoint.x, newMidPoint.x);
		assertNotEquals(originalMidPoint.y, newMidPoint.y);
	}
}
