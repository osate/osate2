package org.osate.ge.swt;

import java.util.function.Consumer;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;

/**
 * Contains static utility functions including.
 * @since 1.1
  */
public class SwtUtil {
	private static final String AUTOMATED_SWTBOT_TESTING_KEY = "org.eclipse.swtbot.widget.key";

	private SwtUtil() {
	}

	/**
	 * Sets up the display, creates a shell, and provides the specified consumer with it. Exits when the shell is disposed.
	 * @param run is the consumer to call after setting up the window.
	 */
	public static void run(final Consumer<Shell> run) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("View Test");
		shell.setSize(640, 480);
		shell.setLayout(new FillLayout());

		run.accept(shell);

		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	/**
	 * Creates a display and runs the specified runnable. Useful for testing dialogs.
	 * @param runnable is the runnable to call after creating the display.
	 */
	public static void runDialog(final Runnable runnable) {
		final Display display = new Display();
		runnable.run();
		display.dispose();
	}

	/**
	 * Sets the visibility of a control and the exclude field of its layout data. Throws exception if layout data is not a GridData
	 * @param c the control for which to set visibility and exclusion.
	 * @param visible the new value for control visibility.
	 */
	public static void setVisibilityAndExclusion(final Control c, final boolean visible) {
		c.setVisible(visible);

		final Object layoutData = c.getLayoutData();
		if (layoutData == null) {
			throw new RuntimeException("Layout data is null");
		} else if (layoutData instanceof GridData) {
			((GridData) layoutData).exclude = !visible;
		} else {
			throw new RuntimeException("Unsupported layout data type: " + layoutData.getClass().getName());
		}
	}

	public static void setColorsToMatchParent(final Control c) {
		c.setBackground(c.getParent().getBackground());
		c.setForeground(c.getParent().getForeground());
	}

	/**
	 * Assigns an identifier to a widget to allow identification during automated testing.
	 * @param widget is the widget for which to test the id.
	 * @param value is the id to assign.
	 */
	public static void setTestingId(final Widget widget, final String value) {
		widget.setData(SwtUtil.AUTOMATED_SWTBOT_TESTING_KEY, value);
	}

	/**
	 * Returns the value of the id assigned to the widget for allow identification during automated testing
	 * @param widget is the widget for which to return the id.
	 * @return the id for the widget or null if one has not been assigned.
	 */
	public static String getTestingId(final Widget widget) {
		final Object value = widget.getData(SwtUtil.AUTOMATED_SWTBOT_TESTING_KEY);
		return value == null ? null : value.toString();
	}
}
