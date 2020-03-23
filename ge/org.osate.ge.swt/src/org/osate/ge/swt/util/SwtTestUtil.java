package org.osate.ge.swt.util;

import java.util.function.Consumer;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Contains functions for putting together tests to interactively test single components outside the Eclipse workbench.
 *
 */
public class SwtTestUtil {
	private SwtTestUtil() {
	}

	/**
	 * Sets up the display, creates a shell, and provides the specified consumer with it. Exits when the shell is disposed.
	 * @param run is the consumer to call after setting up the window.
	 */
	public static void run(final Consumer<Shell> run) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setText("Viewer Test");
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
}
