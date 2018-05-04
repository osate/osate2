package org.osate.ge.tests;

import org.eclipse.swt.graphics.Point;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

public class SetExtendedClassifierTest {
	private final AgeGefBot bot = new AgeGefBot();

	@Before
	public void setUp() {
		bot.maximize();
		bot.createNewProjectAndPackage(ElementNames.projectName, ElementNames.packageName);
		bot.openDiagram(new String[] { ElementNames.projectName }, ElementNames.packageName);
	}

	@After
	public void tearDown() {
		bot.deleteProject(ElementNames.projectName);
	}

	@Test
	public void setExtendedClassifier() {
		final AgeSWTBotGefEditor editor = bot.getEditor(ElementNames.packageName);
		editor.setFocus();
		editor.click(ElementNames.packageName);
		bot.resizeEditPart(editor, new Point(600, 600), ElementNames.packageName);

		bot.createToolItemAndRename(editor, AbstractType.class, new Point(60, 60), ElementNames.abstractTypeName,
				ElementNames.packageName);

		bot.createImplementation(editor, ToolTypes.getToolItem(AbstractImplementation.class),
				ElementNames.abstractTypeName, ElementNames.abstractTypeName, new Point(350, 350),
				ElementNames.packageName);
		bot.createImplementation(editor, ToolTypes.getToolItem(AbstractImplementation.class),
				ElementNames.abstractTypeName, ElementNames.abstractTypeName + 2, new Point(150, 150),
				ElementNames.packageName);

		final String implName = ElementNames.abstractTypeName + "." + ElementNames.abstractTypeName + 2;
		bot.selectElements(editor, new String[] { implName });
		bot.openPropertiesView();
		bot.selectWidget("AADL");
		bot.clickElements(editor, new String[] { implName });
		bot.selectElements(editor, new String[] { implName });
		bot.clickButton("Choose...");
		bot.clickButton("OK");
	}
}
