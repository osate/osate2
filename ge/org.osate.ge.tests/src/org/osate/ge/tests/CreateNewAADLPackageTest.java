package org.osate.ge.tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateNewAADLPackageTest {
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
	public void createNewAADLPackage() {
		// Node path to package
		final String[] nodePath = new String[] { ElementNames.projectName, "diagrams" };
		// Make sure new package exists
		Assert.assertTrue(
				bot.getTree().expandNode(nodePath).getNodes().contains(ElementNames.packageName + ".aadl_diagram"));
	}
}
