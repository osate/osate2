package org.osate.alisa2.view.tests;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.tests.swtbot.support.api.AbstractSiriusSwtBotGefTestCase;
import org.eclipse.sirius.tests.swtbot.support.api.business.UILocalSession;
import org.eclipse.sirius.tests.swtbot.support.api.business.UIResource;
import org.eclipse.sirius.tests.swtbot.support.api.editor.SWTBotSiriusDiagramEditor;
import org.junit.Test;



// Check out AbstractSiriusSwtBotGefTestCase
//@RunWith(SWTBotJunit4ClassRunner.class)
public class BoundaryDiagramTests extends AbstractSiriusSwtBotGefTestCase {

//	private final static SWTWorkbenchBot bot = new SWTWorkbenchBot();

	private static final String PLUGIN_ID = "org.osate.alisa2.view.tests";
	private static final String REPRESENTATION_NAME = "ComponentHierarchy";
	private static final String REPRESENTATION_INSTANCE_NAME = "Component Hierarchy of PulseOx_Forwarding_System_imp_Instance";

	private static final String AIRD_FILE = "representations.aird";
	private static final String SAFE2_FILE1 = "pca-interlock.safe2";
	private static final String SAFE2_FILE2 = "pulseox-forwarding.safe2";

	private static final String DATA_UNIT_DIR = "src/test/resources/BoundaryDiagramTests/";
	private static final String POFWRD_DIR = "pulseox-forwarding/";
	private static final String AADL_DIR = POFWRD_DIR + "aadl/";
	private static final String INSTANCE_DIR = AADL_DIR + "instances/";

	// @formatter:off
	private static final String[] PROJECT_FILES = {
			AIRD_FILE,
			SAFE2_FILE1,
			POFWRD_DIR + SAFE2_FILE2,
//			AADL_DIR + "MAP_Error_Properties.aadl",
//			AADL_DIR + "MAP_Errors.aadl",
//			AADL_DIR + "MAP_Properties.aadl",
//			AADL_DIR + "PulseOx_Forwarding_Clinician.aadl",
//			AADL_DIR + "PulseOx_Forwarding_Display.aadl",
//			AADL_DIR + "PulseOx_Forwarding_Errors.aadl",
//			AADL_DIR + "PulseOx_Forwarding_Logic.aadl",
//			AADL_DIR + "PulseOx_Forwarding_Patient.aadl",
//			AADL_DIR + "PulseOx_Forwarding_Properties.aadl",
//			AADL_DIR + "PulseOx_Forwarding_System.aadl",
//			AADL_DIR + "PulseOx_Forwarding_Types.aadl",
//			AADL_DIR + "PulseOx_Interface.aadl",
			INSTANCE_DIR + "PulseOx_Forwarding_Logic_PulseOx_Logic_Process_imp_Instance.aaxl2",
			INSTANCE_DIR + "PulseOx_Forwarding_System_PulseOx_Forwarding_System_imp_Instance.aaxl2"
	};
	// @formatter:on

	// This might be able to be commented out...?
	private UILocalSession localSession;

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
		p.setX(p.x + 100);
		editor.doubleClick(p.x, p.y);
		bot.button("OK").click();
	}

	@Test
	public void testPredecessors() throws Throwable {
		assertEquals(1, editor.getEditPart("appLogic").sourceConnections().size());
	}

	@Test
	public void testSuccessors() throws Throwable {
		assertEquals(1, editor.getEditPart("appLogic").targetConnections().size());
	}

}
//