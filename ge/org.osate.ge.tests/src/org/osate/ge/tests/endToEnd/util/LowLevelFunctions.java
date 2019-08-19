package org.osate.ge.tests.endToEnd.util;

import static org.eclipse.swtbot.swt.finder.SWTBotAssert.assertContains;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.eclipse.core.runtime.Platform;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.eclipse.gef.finder.SWTGefBot;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.waits.DefaultCondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotButton;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;

/**
 * Low-level test function implemented with SWTBot. More abstract test functions will use these.
 *
 */
public class LowLevelFunctions {
	private static final SWTGefBot bot;

	// All methods are static
	private LowLevelFunctions() {
	}

	static {
		bot = new SWTGefBot();
		SWTBotPreferences.TIMEOUT = 5000;

		assertEquals("Unsupported Eclipse product. Run test with the expected Eclipse product.",
				"org.osate.branding.org.osate.product", Platform.getProduct().getId());
		assertOsateShellIsActive();
	}

	public static void assertOsateShellIsActive() {
		assertContains("OSATE2", bot.activeShell().getText());
	}

	public static void clickMenu(final String... texts) {
		final SWTBotMenu menu = bot.menu().menu(texts);
		menu.click();
	}

	public static void waitForWindowWithTitle(final String text) {
		bot.waitUntil(Conditions.shellIsActive(text));
	}

	public static void setTextField(final int index, final String value, final String expectedOriginalValue) {
		final SWTBotText text = bot.text(0);
		assertEquals("Original value of text is not the expected value", expectedOriginalValue, text.getText());
		text.setText(value);
		assertEquals("New value not valid", value, text.getText());
	}

	public static void clickButton(final String text) {
		final SWTBotButton btn = bot.button(text);
		btn.click();
	}

	public static void assertAadlNavigatorIsVisible() {
		getAadlNavigator();
	}


	public static void waitUntilProjectExistsInAadlNavigator(final String projectName) {
		// Wait until the project appears in the AADL navigator
		bot.waitUntil(new DefaultCondition() {
			@Override
			public boolean test() throws Exception {
				final SWTBotView navigatorView = getAadlNavigator();
				final SWTBotTree tree = navigatorView.bot().tree(0);
				return Arrays.stream(tree.getAllItems()).filter(item -> item.getText().equals(projectName)).findAny()
						.isPresent();
			}

			@Override
			public String getFailureMessage() {
				return "Project '" + projectName + "' not found in AADL navigator";
			}

		});
	}

	/**
	 * Throws exception if unable to find the AADL Navigator view
	 */
	private static SWTBotView getAadlNavigator() {
		return bot.viewByTitle("AADL Navigator");
	}
}
