package org.osate.alisa2.view.tests;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.tests.swtbot.support.api.AbstractSiriusSwtBotGefTestCase;
import org.eclipse.sirius.tests.swtbot.support.api.business.UIResource;
import org.eclipse.sirius.tests.swtbot.support.api.editor.SWTBotSiriusDiagramEditor;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BoundaryDiagramTests extends AbstractSiriusSwtBotGefTestCase {

	private static final String PLUGIN_ID = "org.osate.alisa2.view.tests";
	private static final String REPRESENTATION_NAME = "ComponentHierarchy";
	private static final String REPRESENTATION_INSTANCE_NAME = "Component Hierarchy of PulseOx_Forwarding_System_imp_Instance";

	private static final String AIRD_FILE = "representations.aird";
	private static final String SAFE2_FILE1 = "pca-interlock.safe2";
	private static final String SAFE2_FILE2 = "pulseox-forwarding.safe2";

	private static final String DATA_UNIT_DIR = "src/test/resources/BoundaryDiagramTests/";
	private static final String AADL_DIAGRAMS_DIR = "diagrams/";
	private static final String POFWRD_DIR = "pulseox-forwarding/";
	private static final String AADL_DIR = POFWRD_DIR + "aadl/";
	private static final String INSTANCE_DIR = AADL_DIR + "instances/";

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	// @formatter:off
	private static final String[] PROJECT_FILES = {
			AIRD_FILE,
			SAFE2_FILE1,
			POFWRD_DIR + SAFE2_FILE2,
			AADL_DIAGRAMS_DIR + "PulseOx_Forwarding_System_PulseOx_Forwarding_System_imp.aadl_diagram",
			AADL_DIR + "MAP_Error_Properties.aadl",
			AADL_DIR + "MAP_Errors.aadl",
			AADL_DIR + "MAP_Properties.aadl",
			AADL_DIR + "PulseOx_Forwarding_Clinician.aadl",
			AADL_DIR + "PulseOx_Forwarding_Display.aadl",
			AADL_DIR + "PulseOx_Forwarding_Errors.aadl",
			AADL_DIR + "PulseOx_Forwarding_Logic.aadl",
			AADL_DIR + "PulseOx_Forwarding_Patient.aadl",
			AADL_DIR + "PulseOx_Forwarding_Properties.aadl",
			AADL_DIR + "PulseOx_Forwarding_System.aadl",
			AADL_DIR + "PulseOx_Forwarding_Types.aadl",
			AADL_DIR + "PulseOx_Interface.aadl",
			INSTANCE_DIR + "PulseOx_Forwarding_Logic_PulseOx_Logic_Process_imp_Instance.aaxl2",
			INSTANCE_DIR + "PulseOx_Forwarding_System_PulseOx_Forwarding_System_imp_Instance.aaxl2"
	};
	// @formatter:on

	@Override
	protected void onSetUpBeforeClosingWelcomePage() throws Exception {
		copyFileToTestProject(PLUGIN_ID, DATA_UNIT_DIR, PROJECT_FILES);

	}

	@Override
	protected void onSetUpAfterOpeningDesignerPerspective() throws Exception {
		super.onSetUpAfterOpeningDesignerPerspective();

		sessionAirdResource = new UIResource(designerProject, AIRD_FILE);
		localSession = designerPerspective.openSessionFromFile(sessionAirdResource, true);
		editor = (SWTBotSiriusDiagramEditor) openRepresentation(localSession.getOpenedSession(), REPRESENTATION_NAME,
				REPRESENTATION_INSTANCE_NAME, DDiagram.class);

		Point p = editor.getLocation(editor.getEditPart("appLogic"));
		// the edit part includes the port boxes to the left of the component box, so we
		// fudge the x value slightly to make sure we're clicking on the appLogic component
		p.setX(p.x + 100);
		editor.doubleClick(p.x, p.y);
		bot.button("OK").click();
	}

	@Test
	public void testTargetExists() throws Throwable {
		assertNotNull(editor.getEditPart("appLogic"));
	}

	@Test
	public void testPredecessorExists() throws Throwable {
		assertNotNull(editor.getEditPart("pulseOx"));
	}

	@Test
	public void testSuccessorExists() throws Throwable {
		assertNotNull(editor.getEditPart("appDisplay"));
	}
}