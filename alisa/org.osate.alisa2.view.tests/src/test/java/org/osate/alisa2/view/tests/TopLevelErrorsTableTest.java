package org.osate.alisa2.view.tests;

import org.eclipse.sirius.tests.swtbot.support.api.business.UIResource;
import org.eclipse.sirius.tests.swtbot.support.api.business.UITableRepresentation;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.Test;

public class TopLevelErrorsTableTest extends TestBase {

	private static final String ORIG_REPRESENTATION_NAME = "TopLevelErrors";
	private static final String ORIG_REPRESENTATION_INSTANCE_NAME = "new TopLevelErrors";

	@Override
	protected void onSetUpAfterOpeningDesignerPerspective() throws Exception {
		super.onSetUpAfterOpeningDesignerPerspective();

		sessionAirdResource = new UIResource(designerProject, AIRD_FILE);
		localSession = designerPerspective.openSessionFromFile(sessionAirdResource, true);

		localSession.getLocalSessionBrowser().perCategory().selectViewpoint("Hazard Analyst")
				.selectRepresentation(ORIG_REPRESENTATION_NAME)
				.selectRepresentationInstance(ORIG_REPRESENTATION_INSTANCE_NAME, UITableRepresentation.class).delete();

		final UITableRepresentation table = localSession.getLocalSessionBrowser().perCategory()
				.selectViewpoint("Hazard Analyst").selectRepresentation(ORIG_REPRESENTATION_NAME)
				.selectRepresentationInstance(ORIG_REPRESENTATION_INSTANCE_NAME, UITableRepresentation.class).open();
		SWTBotTreeItem[] items = table.getTable().getAllItems();
		System.err.println("items[0].cell(0) is " + items[0].cell(0));
		System.err.println("items[1].cell(1) is " + items[1].cell(1));
	}

	@Test
	public void testNothing() throws Throwable {
		assertTrue(false);
	}
}