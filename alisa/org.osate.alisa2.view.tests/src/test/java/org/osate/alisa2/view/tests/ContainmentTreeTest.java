package org.osate.alisa2.view.tests;

import org.eclipse.sirius.tests.swtbot.support.api.business.UIResource;
import org.eclipse.sirius.tree.DTree;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Test;

public class ContainmentTreeTest extends TestBase {

	private static final String ORIG_REPRESENTATION_NAME = "Containment";
	private static final String ORIG_REPRESENTATION_INSTANCE_NAME = "new Containment";

	private static SWTBot treeBot;
	private static SWTBotEditor treeEditor;

	@Override
	protected void onSetUpAfterOpeningDesignerPerspective() throws Exception {
		super.onSetUpAfterOpeningDesignerPerspective();

		sessionAirdResource = new UIResource(designerProject, AIRD_FILE);
		localSession = designerPerspective.openSessionFromFile(sessionAirdResource, true);
		treeEditor = openRepresentation(localSession.getOpenedSession(), ORIG_REPRESENTATION_NAME,
				ORIG_REPRESENTATION_INSTANCE_NAME, DTree.class);

		treeBot = treeEditor.bot();
	}

	@Test
	public void testTreeNodesExist() throws Throwable {
		assertNotNull(treeBot.tree().getTreeItem("patient"));
		assertNotNull(treeBot.tree().getTreeItem("clinician"));
		assertNotNull(treeBot.tree().getTreeItem("pulseOx"));

		SWTBotTreeItem alItem = treeBot.tree().getTreeItem("appLogic");
		assertNotNull(alItem);
		alItem.expand();
		assertNotNull(alItem.getNode("SpO2Val"));
		assertNotNull(alItem.getNode("CheckSpO2Thread"));

		SWTBotTreeItem adItem = treeBot.tree().getTreeItem("appDisplay");
		assertNotNull(adItem);
		adItem.expand();
		assertNotNull(adItem.getNode("UpdateSpO2Thread"));
		assertNotNull(adItem.getNode("HandleAlarmThread"));
	}

	@Test
	public void testTreeCorrectSize() throws Throwable {
		treeBot.tree().getTreeItem("appLogic").expand();
		treeBot.tree().getTreeItem("appDisplay").expand();
		assertEquals(9, treeBot.tree().visibleRowCount());
	}
}