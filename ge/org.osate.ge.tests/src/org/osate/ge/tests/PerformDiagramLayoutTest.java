package org.osate.ge.tests;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PerformDiagramLayoutTest {
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
	public void performDiagramLayout() {
		final SWTBotGefEditor editor = bot.getEditor(ElementNames.packageName);
		final PictogramElement pe = (((GraphitiShapeEditPart) editor.getEditPart(ElementNames.abstractTypeName).part()))
				.getPictogramElement();
		final GraphicsAlgorithm beforeLayoutGa = pe.getGraphicsAlgorithm();

		final int beforeX = beforeLayoutGa.getX();
		final int beforeY = beforeLayoutGa.getY();

		editor.clickContextMenu("Layout Diagram");
		final GraphicsAlgorithm afterLayoutGa = pe.getGraphicsAlgorithm();

		final int afterX = afterLayoutGa.getX();
		final int afterY = afterLayoutGa.getY();
		Assert.assertTrue(beforeX != afterX || beforeY != afterY);
	}
}
