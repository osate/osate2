package org.osate.ge.tests.endToEnd;

import static org.osate.ge.tests.endToEnd.util.HighLevelFunctions.assertReadyToTest;
import static org.osate.ge.tests.endToEnd.util.HighLevelFunctions.createAadlProject;

import org.junit.Test;

/**
 * This class is the primary end to end test. It creates a complete model and exercises a large part of the graphical editor.
 *
 */
public class PrimaryEndToEndTest {
	@Test
	public void testGraphicalEditor() {
		assertReadyToTest();

		// Create Projects
		createAadlProject("shared");
		createAadlProject("hardware");
		createAadlProject("software");
		createAadlProject("integrated");
	}
}
