package org.osate.ge.tests;

import static org.junit.Assert.assertTrue;

import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.ge.internal.ui.properties.SetFeatureGroupInversePropertySection;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

public class FeatureGroupTest {
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
	public void setFeatureClassifier() {
		final AgeSWTBotGefEditor editor = bot.getEditor(ElementNames.packageName);
		bot.resizeEditPart(editor, new Point(600, 600), ElementNames.packageName);
		bot.openPropertiesView();

		bot.createToolItemAndRename(editor, AbstractType.class, new Point(20, 20), ElementNames.abstractTypeName,
				ElementNames.packageName);

		bot.resizeEditPart(editor, new Point(200, 200), ElementNames.abstractTypeName);

		bot.createToolItemAndRename(editor, FeatureGroup.class, new Point(30, 30), ElementNames.featureGroupName,
				ElementNames.abstractTypeName);
		bot.createToolItemAndRename(editor, FeatureGroupType.class, new Point(25, 250),
				ElementNames.featureGroupTypeName, ElementNames.packageName);

		bot.selectElement(editor, ElementNames.featureGroupName);
		bot.selectWidget("AADL");
		bot.clickButton("Choose...");

		final GraphitiShapeEditPart fgtGsep = (GraphitiShapeEditPart) bot
				.findEditPart(editor, ElementNames.featureGroupTypeName).part();
		final FeatureGroupType fgt = (FeatureGroupType) AgeGefBot.getBusinessObject(editor,
				fgtGsep.getPictogramElement());
		bot.clickTableOption(fgt.getQualifiedName());
		bot.clickButton("OK");

		final GraphitiShapeEditPart gsep = (GraphitiShapeEditPart) bot
				.findChild(editor, editor.getEditPart(ElementNames.abstractTypeName), ElementNames.featureGroupName)
				.get(0).part();
		final PictogramElement pe = gsep.getPictogramElement();
		assertTrue(isClassifierSet(editor, pe));
		assertTrue(setFeatureDirection(editor, pe));
		assertTrue(setFeatureInverse(editor,
				pe));
	}

	private boolean isClassifierSet(final SWTBotGefEditor editor, final PictogramElement pe) {
		final FeatureGroup fg = (FeatureGroup) AgeGefBot.getBusinessObject(editor, pe);
		return ElementNames.featureGroupTypeName.equalsIgnoreCase(fg.getClassifier().getName());
	}

	public boolean setFeatureDirection(final SWTBotGefEditor editor, final PictogramElement pe) {
		bot.selectElement(editor, ElementNames.featureGroupName);
		bot.clickRadio("Input");
		final FeatureGroup fg = (FeatureGroup) AgeGefBot.getBusinessObject(editor, pe);
		return fg.getDirection() == DirectionType.IN;
	}

	public boolean setFeatureInverse(final SWTBotGefEditor editor, final PictogramElement pe) {
		bot.clickCheckBoxWithId(SetFeatureGroupInversePropertySection.setFeatureGroupInverseUniqueId);
		final FeatureGroup fg = (FeatureGroup) AgeGefBot.getBusinessObject(editor, pe);
		return fg.isInverse();
	}
}
