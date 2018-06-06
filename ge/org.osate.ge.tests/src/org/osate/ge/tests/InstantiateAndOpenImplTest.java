package org.osate.ge.tests;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swtbot.eclipse.gef.finder.widgets.SWTBotGefEditor;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InstantiateAndOpenImplTest {
	private final AgeGefBot ageBot = new AgeGefBot();

	@Before
	public void setUp() {
		ageBot.maximize();
		ageBot.createNewProjectAndPackage(ElementNames.projectName, ElementNames.packageName);
		ageBot.openDiagram(new String[] { ElementNames.projectName }, ElementNames.packageName);
	}

	@After
	public void tearDown() {
		ageBot.deleteProject(ElementNames.projectName);
	}

	@Test
	public void instantiateImplTest() {
		createAndInstantiate(new Point(30, 30));
	}

	public void createAndInstantiate(final Point p) {
		ageBot.createAbstractTypeAndImplementation(ElementNames.packageName, p);
		ageBot.getEditor(ElementNames.packageName).select(ElementNames.abstractTypeName + ".impl")
				.clickContextMenu("Instantiate");
	}

	@Test
	public void openImplTest() {
		createAndInstantiate(new Point(45, 45));
		final SWTBotGefEditor editor = ageBot.getEditor(ElementNames.packageName);
		editor.setFocus();

		final String[] nodePath = new String[] { ElementNames.projectName, "instances" };
		// Expand tree path and select the aadl file to open
		final SWTBotTreeItem treeItem = ageBot.getTree().expandNode(nodePath).getNode(0).click();

		// Open Diagram
		treeItem.contextMenu("Open Diagram").click();
		ageBot.clickButton("Yes");
		ageBot.clickButton("OK");

		ageBot.waitUntil(new DefaultCondition() {
			@Override
			public boolean test() throws Exception {
				return ageBot.isActiveEditor(ElementNames.abstractTypeName + "_impl" + "_Instance");
			}

			@Override
			public String getFailureMessage() {
				return "Instance diagram not opened";
			}
		}, 5000);
	}
}
