package org.osate.ge.tests.endToEnd.util;

import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.assertAadlNavigatorIsVisible;
import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.assertOsateShellIsActive;
import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.clickButton;
import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.clickMenu;
import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.setTextField;
import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.waitForWindowWithTitle;
import static org.osate.ge.tests.endToEnd.util.LowLevelFunctions.waitUntilProjectExistsInAadlNavigator;

public class HighLevelFunctions {
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
