package org.osate.ge.tests.endToEnd.util;

import static org.junit.Assert.assertEquals;
import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.assertAadlNavigatorIsVisible;
import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.assertOsateShellIsActive;
import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.clickButton;
import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.clickMenu;
import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.setTextField;
import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.waitForWindowWithTitle;
import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.waitUntilProjectExistsInAadlNavigator;

import org.eclipse.core.runtime.Platform;

public class HighLevelFunctions {
	public static void assertReadyToTest() {
		assertOsateProduct();
	}

	private static void assertOsateProduct() {
		assertEquals("Unsupported Eclipse product. Run test with the expected Eclipse product.",
				"org.osate.branding.osate2", Platform.getProduct().getId());
	}

	public static void createAadlProject(final String name) {
		assertOsateShellIsActive();
		assertAadlNavigatorIsVisible();
		clickMenu("File", "New", "AADL Project");
		waitForWindowWithTitle("New");
		setTextField(0, name, "");
		clickButton("Finish");
		waitUntilProjectExistsInAadlNavigator(name);
	}
}
