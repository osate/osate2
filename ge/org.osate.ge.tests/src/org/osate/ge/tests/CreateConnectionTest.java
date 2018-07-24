package org.osate.ge.tests;

import org.eclipse.draw2d.Connection;
import org.eclipse.graphiti.ui.platform.GraphitiConnectionEditPart;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefConnectionEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.impl.FeatureConnectionImpl;
import org.osate.ge.internal.ui.properties.AppearancePropertySection;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;
import org.osate.ge.tests.AgeGefBot.ConnectionPoint;

public class CreateConnectionTest {
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
	public void createConnection() {
		final AgeSWTBotGefEditor editor = bot.getEditor(ElementNames.packageName);
		bot.resizeEditPart(editor, new Point(150, 150), ElementNames.abstractTypeName);
		bot.openPropertiesView();

		bot.createToolItemAndRename(editor, AbstractFeature.class, new Point(15, 15),
				ElementNames.abstractFeatureNewName, ElementNames.abstractTypeName);
		bot.createToolItemAndRename(editor, AbstractFeature.class, new Point(100, 100),
				ElementNames.abstractFeatureNewName2, ElementNames.abstractTypeName);

		bot.setElementOptionRadioInPropertiesView(editor, "AADL", "Output", ElementNames.abstractFeatureNewName2);

		final String abstractImplName = ElementNames.abstractTypeName + ".impl";
		bot.resizeEditPart(editor, new Point(400, 400), abstractImplName);
		bot.executeContextMenuCommand(editor, abstractImplName, AgeGefBot.allFilters);

		createSubcomponents(editor, AbstractSubcomponent.class, abstractImplName);
		editor.setFocus();

		// Show children of subcomponents
		bot.selectElements(editor, new String[] { abstractImplName, ElementNames.abstractSubcomponentName },
				new String[] { abstractImplName, ElementNames.abstractSubcomponentName2 });
		editor.clickContextMenu(AgeGefBot.allFilters);

		bot.sleep(3);

		final SWTBotGefEditPart featureIn = bot.findEditPart(editor, ElementNames.abstractSubcomponentName,
				ElementNames.abstractFeatureNewName);
		final SWTBotGefEditPart featureOut = bot.findEditPart(editor, ElementNames.abstractSubcomponentName2,
				ElementNames.abstractFeatureNewName2);

		// Create connection
		editor.setFocus();
		bot.mouseSelectElement(editor, featureOut);
		editor.select(ElementNames.abstractSubcomponentName);
		editor.click(ElementNames.abstractSubcomponentName);
		editor.activateTool("Feature Connection");

		editor.click(featureOut);
		editor.click(featureIn);
		editor.activateDefaultTool();

		bot.mouseSelectElement(editor, featureOut);
		final SWTBotGefConnectionEditPart connectionEditPart = bot.getNewConnection(editor,
				FeatureConnectionImpl.class);
		editor.select(connectionEditPart);
		final Connection con = ((GraphitiConnectionEditPart) connectionEditPart.part()).getConnectionFigure();
		bot.clickConnection(editor, con);
		bot.selectWidget("Appearance");
		bot.clickCombo(AppearancePropertySection.primaryLabelVisibilityCombo, "Show");

		// Rename
		bot.renameConnection(editor, connectionEditPart, ConnectionPoint.MIDDLE, ElementNames.featureConnection);
	}

	private void createSubcomponents(final AgeSWTBotGefEditor editor, final Class<?> clazz, final String parent) {
		editor.setFocus();
		editor.select(ElementNames.packageName);
		editor.click(ElementNames.packageName);
		bot.createToolItemAndRename(editor, clazz, new Point(200, 100), ElementNames.abstractSubcomponentName, parent);
		bot.createToolItemAndRename(editor, clazz, new Point(150, 250), ElementNames.abstractSubcomponentName2, parent);
		bot.setElementOptionButtonInPropertiesView(editor, "AADL", "Choose...",
				new String[] { ElementNames.abstractSubcomponentName },
				new String[] { ElementNames.abstractSubcomponentName2 });

		bot.clickTableOption(AgeGefBot.qualifiedName(ElementNames.packageName, ElementNames.abstractTypeName));
		bot.clickButton("OK");
	}
}