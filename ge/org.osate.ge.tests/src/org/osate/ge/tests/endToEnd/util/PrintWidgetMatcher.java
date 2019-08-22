package org.osate.ge.tests.endToEnd.util;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Widget;
import org.hamcrest.CustomMatcher;

// Print all available widgets. Used for debugging.
public class PrintWidgetMatcher extends CustomMatcher<Widget> {
	private static String AUTOMATED_SWTBOT_TESTING_KEY = "org.eclipse.swtbot.widget.key";

	public PrintWidgetMatcher(final String id) {
		super("Print Widget Matcher");
		System.err.println("<Printing Widgets> id : " + id);
	}

	@Override
	public boolean matches(final Object item) {
		System.err.println("Item: " + item);
		if (item instanceof Combo) {
			final Combo combo = (Combo) item;
			System.err.println("Combo: " + combo + " Data: " + combo.getData(AUTOMATED_SWTBOT_TESTING_KEY));
		} else if (item instanceof Button) {
			final Button button = (Button) item;
			System.err.println("Button: " + button + " Data: " + button.getData(AUTOMATED_SWTBOT_TESTING_KEY));
		}
		return true;
	}
}