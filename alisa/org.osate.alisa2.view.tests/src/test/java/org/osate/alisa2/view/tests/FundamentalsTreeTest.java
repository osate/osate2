package org.osate.alisa2.view.tests;

import org.eclipse.sirius.tests.swtbot.support.api.business.UIResource;
import org.eclipse.sirius.tree.DTree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Test;

public class FundamentalsTreeTest extends TestBase {

	private static final String ORIG_REPRESENTATION_NAME = "Fundamentals";
	private static final String ORIG_REPRESENTATION_INSTANCE_NAME = "new Fundamentals";

	private static SWTBot treeBot;
	private static SWTBotEditor treeEditor;

	@Override
	protected void onSetUpAfterOpeningDesignerPerspective() throws Exception {
		super.onSetUpAfterOpeningDesignerPerspective();

		// TODO: This doesn't actually create a new diagram, and it probably should.
		// see org.eclipse.sirius.tests.swtbot.DiagramCreationDescriptionTest.testNewRepresentationFromNode()
		// for a possible implementation.

		sessionAirdResource = new UIResource(designerProject, AIRD_FILE);
		localSession = designerPerspective.openSessionFromFile(sessionAirdResource, true);
		treeEditor = openRepresentation(localSession.getOpenedSession(), ORIG_REPRESENTATION_NAME,
				ORIG_REPRESENTATION_INSTANCE_NAME, DTree.class);

		treeBot = treeEditor.bot();
	}

	@Test
	public void testTreeNodesExist() throws Throwable {
		SWTBotTreeItem doiItem = treeBot.tree().getTreeItem("DeathOrInjury");
		assertNotNull(doiItem);
		doiItem.expand();

		SWTBotTreeItem phItem = doiItem.getNode("PatientHarmed");
		assertNotNull(phItem);
		phItem.expand();

		SWTBotTreeItem bidItem = phItem.getNode("BadInfoDisplayed");
		assertNotNull(bidItem);
		bidItem.expand();
		assertNotNull(bidItem.getNode("ShowGoodInfo"));

		SWTBotTreeItem ilItem = phItem.getNode("InfoLate");
		assertNotNull(ilItem);
		ilItem.expand();
		assertNotNull(ilItem.getNode("ShowInfoOnTime"));
	}

	@Test
	public void testTreeCorrectSize() throws Throwable {
		SWTBotTreeItem doiItem = treeBot.tree().getTreeItem("DeathOrInjury").expand();
		SWTBotTreeItem phItem = doiItem.getNode("PatientHarmed").expand();
		phItem.getNode("BadInfoDisplayed").expand();
		phItem.getNode("InfoLate").expand();
		assertEquals(6, treeBot.tree().visibleRowCount());
	}
}