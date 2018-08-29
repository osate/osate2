package org.osate.ge.tests;

import java.util.List;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeletingClassifierTest {
	private final AgeGefBot bot = new AgeGefBot();

	@Before
	public void setUp() {
		bot.maximize();
		bot.createNewProjectAndPackage(ElementNames.projectName, ElementNames.packageName);
		bot.openDiagram(new String[] { ElementNames.projectName }, ElementNames.packageName);
		bot.createAbstractTypeAndImplementation(ElementNames.packageName, new Point(25, 25));
	}

	@After
	public void tearDown() {
		bot.deleteProject(ElementNames.projectName);
	}

	@Test
	public void deleteClassifer() {
		final SWTBotGefEditor editor = bot.getEditor(ElementNames.packageName);
		editor.select(ElementNames.abstractTypeName + ".impl").clickContextMenu("Delete");
		bot.clickButton("Yes");
		editor.save();
		final List<SWTBotGefEditPart> list = editor.editParts(new AgeGefBot.FindEditPart(
				AgeGefBot.getAgeFeatureProvider(editor), ElementNames.abstractTypeName + ".impl"));
		Assert.assertTrue(list.isEmpty());
	}
}
