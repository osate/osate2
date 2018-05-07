package org.osate.ge.tests;

import org.eclipse.swt.graphics.Point;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.AbstractType;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

public class RenameClassifierTest {
	private final AgeGefBot bot = new AgeGefBot();

	@Before
	public void setUp() {
		bot.maximize();
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
		bot.createToolItemAndRename(editor, AbstractType.class, new Point(20, 20), ElementNames.abstractTypeName,
				ElementNames.packageName);

		Assert.assertTrue(editor.getEditPart(ElementNames.abstractTypeName) != null);
	}
}
