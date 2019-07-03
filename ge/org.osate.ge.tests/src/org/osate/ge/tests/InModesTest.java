package org.osate.ge.tests;

import org.eclipse.graphiti.ui.platform.GraphitiConnectionEditPart;
import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefConnectionEditPart;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditPart;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.Mode;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.impl.FlowSpecificationImpl;
import org.osate.ge.tests.AgeGefBot.AgeSWTBotGefEditor;

import com.google.common.base.Objects;

// Test to configure ModalElement and ModalPath in modes
public class InModesTest {
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
	public void createModalElement() {
		final AgeSWTBotGefEditor editor = bot.getEditor(ElementNames.packageName);
		bot.resizeEditPart(editor, new Point(500, 250), ElementNames.abstractTypeName);
		final String abstractImplName = ElementNames.abstractTypeName + ".impl";
		bot.resizeEditPart(editor, new Point(400, 400), abstractImplName);
		bot.openPropertiesView();
		bot.executeContextMenuCommand(editor, abstractImplName, AgeGefBot.all);

		// Create modes
		bot.createToolItemAndRename(editor, Mode.class, new Point(5, 10), ElementNames.mode,
				ElementNames.abstractTypeName);
		bot.createToolItemAndRename(editor, Mode.class, new Point(350, 20), ElementNames.mode2,
				ElementNames.abstractTypeName);

		// Create feature
		bot.createToolItemAndRename(editor, AbstractFeature.class, new Point(15, 70),
				ElementNames.abstractFeatureNewName, ElementNames.abstractTypeName);

		// Set feature input
		bot.setElementOptionRadioInPropertiesView(editor, "AADL", "Input", ElementNames.abstractTypeName,
				ElementNames.abstractFeatureNewName);

		// Create Flow Spec
		final String flowSinkToolItem = "Flow Sink Specification";
		bot.createToolItem(editor, flowSinkToolItem, new Point(5, 5), ElementNames.abstractTypeName,
				ElementNames.abstractFeatureNewName);

		// Create subcomponent
		bot.createToolItemAndRename(editor, AbstractSubcomponent.class, new Point(150, 250),
				ElementNames.abstractSubcomponentName, abstractImplName);
		editor.select(ElementNames.abstractSubcomponentName);

		// Set subcomponent in mode
		bot.selectWidget("AADL");
		bot.clickCheckBox(ElementNames.mode);

		// Get subcomponent
		final GraphitiShapeEditPart gsep = (GraphitiShapeEditPart) editor
				.getEditPart(ElementNames.abstractSubcomponentName).part();
		final Subcomponent sc = (Subcomponent) AgeGefBot.getBusinessObject(editor, gsep.getPictogramElement());

		// Get mode
		bot.executeContextMenuCommand(editor, abstractImplName, AgeGefBot.all);
		final SWTBotGefEditPart modeEditPart = bot.findEditPart(editor, abstractImplName,
				ElementNames.mode);
		final Mode mode = (Mode) AgeGefBot.getBusinessObject(editor,
				((GraphitiShapeEditPart) modeEditPart.part()).getPictogramElement());
		final Mode scInMode = sc.getAllInModes().stream().filter(m -> Objects.equal(m, mode)).findAny().orElse(null);
		Assert.assertNotNull(scInMode);

		// Set flow spec in mode2
		final SWTBotGefConnectionEditPart flowSink = bot
				.getNewConnectionEditPart(editor, FlowSpecificationImpl.class, ElementNames.abstractTypeName)
				.get(0);
		editor.select(flowSink);
		bot.clickCheckBox(ElementNames.mode2);

		// Get flow spec
		final GraphitiConnectionEditPart gcep = (GraphitiConnectionEditPart) flowSink.part();
		final FlowSpecification fs = (FlowSpecification) AgeGefBot.getBusinessObject(editor,
				gcep.getPictogramElement());

		// Get mode2
		final SWTBotGefEditPart mode2EditPart = bot.findEditPart(editor, abstractImplName, ElementNames.mode2);
		final Mode mode2 = (Mode) AgeGefBot.getBusinessObject(editor,
				((GraphitiShapeEditPart) mode2EditPart.part()).getPictogramElement());

		// Get flow spec's in mode
		final Mode fsInMode = fs.getAllInModes().stream().filter(m -> Objects.equal(m, mode2)).findAny()
				.orElse(null);
		Assert.assertNotNull(fsInMode);
	}
}
