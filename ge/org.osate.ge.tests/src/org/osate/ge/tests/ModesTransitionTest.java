package org.osate.ge.tests;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransition;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;
import org.osate.ge.query.StandaloneQuery;
import org.osate.ge.services.QueryService;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

public class ModesTransitionTest {
	private final AgeGefBot bot = new AgeGefBot();
	final StandaloneQuery modeTransitionQuery = StandaloneQuery.create(
			(rootQuery) -> rootQuery.descendants().filter((d) -> d.getBusinessObject() instanceof ModeTransition));
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
	public void createModes() {
		final AgeSWTBotGefEditor editor = bot.getEditor(ElementNames.packageName);
		bot.resizeEditPart(editor, new Point(600, 600), ElementNames.packageName);
		editor.setFocus();

		// Create abstract type
		bot.createToolItemAndRename(editor, AbstractType.class, new Point(40, 40), ElementNames.abstractTypeName,
				ElementNames.packageName);
		bot.resizeEditPart(editor, new Point(300, 300), ElementNames.abstractTypeName);

		// Create feature
		bot.createToolItemAndRename(editor, AbstractFeature.class, new Point(15, 15), ElementNames.abstractFeatureNewName,
				ElementNames.abstractTypeName);

		// Create mode
		bot.createToolItemAndRename(editor, Mode.class, new Point(80, 90), ElementNames.mode,
				ElementNames.abstractTypeName);
		// Create mode
		bot.createToolItemAndRename(editor, Mode.class, new Point(80, 200), ElementNames.mode2,
				ElementNames.abstractTypeName);

		final SWTBotGefEditPart mode = bot.findEditPart(editor, ElementNames.abstractTypeName, ElementNames.mode);
		final SWTBotGefEditPart mode2 = bot.findEditPart(editor, ElementNames.abstractTypeName, ElementNames.mode2);

		// editor.select(ElementNames.abstractTypeName);
		bot.selectElement(editor, ElementNames.abstractTypeName);

		// Create Mode Transition
		editor.activateTool(ToolTypes.getToolItem(ModeTransition.class));
		editor.click(mode2);
		editor.click(mode);
		bot.clickButton("OK");

		final AgeDiagramEditor ageDiagramEditor = (AgeDiagramEditor) AgeGefBot.getAgeFeatureProvider(editor)
				.getDiagramTypeProvider().getDiagramBehavior().getDiagramContainer();
		final QueryService queryService = (QueryService) ageDiagramEditor.getAdapter(QueryService.class);

		Assert.assertTrue(queryService.getFirstResult(modeTransitionQuery, ageDiagramEditor.getAgeDiagram()) != null);
	}
}
