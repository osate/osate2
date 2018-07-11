package org.osate.ge.tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OpenExistingAADLModelTest {
	private final AgeGefBot bot = new AgeGefBot();

	@Before
	public void setUp() {
		bot.maximize();
		bot.createNewProjectAndPackage(ElementNames.projectName, ElementNames.packageName);
	}

	@After
	public void tearDown() {
		bot.deleteProject(ElementNames.projectName);
	}

	@Test
	public void openExistingAADLModel() {
		// Open Diagram
		bot.openDiagram(new String[] { ElementNames.projectName },
				ElementNames.packageName);
		// Assert editor opened
		assertTrue(bot.getEditor(ElementNames.packageName) != null);
	}
}
