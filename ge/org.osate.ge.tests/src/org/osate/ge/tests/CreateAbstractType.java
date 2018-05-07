package org.osate.ge.tests;

import org.eclipse.swt.graphics.Point;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.impl.AbstractTypeImpl;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

public class CreateAbstractType {
	private final AgeGefBot bot = new AgeGefBot();

	@Before
	public void setUp() {
		bot.createNewProjectAndPackage(ElementNames.projectName, ElementNames.packageName);
	}

	@After
	public void tearDown() {
		bot.deleteProject(ElementNames.projectName);
	}

	@Test
	public void renameClassifer() {
		bot.openDiagram(new String[] { ElementNames.projectName }, ElementNames.packageName);
		final AgeSWTBotGefEditor editor = bot.getEditor(ElementNames.packageName);
		bot.createToolItem(editor, ToolTypes.getToolItem(AbstractType.class), new Point(20, 20),
				ElementNames.packageName);
		bot.getNewElement(editor, AbstractTypeImpl.class);
	}
}
