package org.osate.ge.tests;

import static org.junit.Assert.assertTrue;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

public class GoToTypeDiagramTest {
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
	public void goToTypeDiagram() throws WidgetNotFoundException, ClassNotFoundException {
		final AgeSWTBotGefEditor editor = bot.getEditor(ElementNames.packageName);
		bot.resizeEditPart(editor, new Point(600, 600), ElementNames.packageName);

		bot.createToolItemAndRename(editor, AbstractType.class, new Point(30, 30), ElementNames.abstractTypeName,
				ElementNames.packageName);

		bot.createImplementation(editor, ToolTypes.getToolItem(AbstractImplementation.class),
				ElementNames.abstractTypeName, "impl", new Point(100, 100), ElementNames.packageName);

		bot.openTypeDiagramFromContextMenu(editor, ElementNames.abstractTypeName + "." + "impl");

		assertTrue(bot.isActiveEditor(ElementNames.packageName + "_" + ElementNames.abstractTypeName));
	}
}
