package org.osate.ge.tests.endToEnd;

import static org.osate.ge.tests.endToEnd.util.HighLevelFunctions.*;

import org.junit.Test;

/**
 * This class is the primary end to end test. It creates a complete model and exercises a large part of the graphical editor.
 *
 */
public class PrimaryEndToEndTest {
	private static final String SHARED = "shared";
	private static final String HARDWARE = "hardware";
	private static final String HARDWARE_COMPONENTS_PACKAGE = HARDWARE + "::components";
	private static final String HARDWARE_COMPONENTS_DIAGRAM = HARDWARE + "_components";
	private static final String SOFTWARE = "software";
	private static final String INTEGRATED = "integrated";

	@Test
	public void testGraphicalEditor() {
		createAadlProject(SHARED);
		createNewPackageWithPackageDiagram(SHARED, SHARED);

		createAadlProject(HARDWARE);
		createNewPackageWithPackageDiagram(HARDWARE, HARDWARE);
		createNewPackageWithPackageDiagram(HARDWARE, HARDWARE_COMPONENTS_PACKAGE, HARDWARE_COMPONENTS_DIAGRAM);

		createAadlProject(SOFTWARE);
		createNewPackageWithPackageDiagram(SOFTWARE, SOFTWARE);

		createAadlProject(INTEGRATED);
		createNewPackageWithPackageDiagram(INTEGRATED, INTEGRATED);
	}
}
