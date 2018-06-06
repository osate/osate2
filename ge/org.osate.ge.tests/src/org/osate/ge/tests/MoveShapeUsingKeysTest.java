package org.osate.ge.tests;

import static org.junit.Assert.assertTrue;

import java.awt.event.KeyEvent;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.swt.graphics.Point;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.AbstractType;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

public class MoveShapeUsingKeysTest {
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
	public void moveShape() {
		final AgeSWTBotGefEditor editor = bot.getEditor(ElementNames.packageName);
		bot.resizeEditPart(editor, new Point(600, 600), ElementNames.packageName);

		bot.createToolItemAndRename(editor, AbstractType.class, new Point(25, 25), ElementNames.abstractTypeName,
				ElementNames.packageName);
		bot.resizeEditPart(editor, new Point(300, 300), ElementNames.abstractTypeName);

		final GraphitiShapeEditPart gsep = (GraphitiShapeEditPart)editor.getSWTBotGefViewer().getEditPart(ElementNames.abstractTypeName).part();
		final PictogramElement pe = gsep.getPictogramElement();
		final GraphicsAlgorithm gaBefore = pe.getGraphicsAlgorithm();
		final int beforeX = gaBefore.getX();
		final int beforeY = gaBefore.getY();
		editor.getSWTBotGefViewer().select(ElementNames.abstractTypeName);

		// Enable move shape mode
		bot.keyPress(KeyEvent.VK_PERIOD);

		// Move shape down
		for (int i = 0; i < 10; i++) {
			bot.keyPress(KeyEvent.VK_DOWN);
			bot.keyRelease(KeyEvent.VK_DOWN);
		}

		// Stop move shape mode
		bot.keyRelease(KeyEvent.VK_PERIOD);
		bot.keyPress(KeyEvent.VK_ENTER);
		bot.keyRelease(KeyEvent.VK_ENTER);

		final GraphicsAlgorithm gaAfter = pe.getGraphicsAlgorithm();
		assertTrue(beforeX != gaAfter.getX() || beforeY != gaAfter.getY());
	}
}
