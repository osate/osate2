/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ui.dialogs;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.SaveAsDialog;

/**
 * This class provides <code>static</code> convenience methods for creating
 * standard info, warning, error, question, and "save as" dialog boxes
 * with out having to worry about whether the calling thread is the
 * SWT event thread or not.
 *
 * @author phf
 */
public final class Dialog {
	private Dialog() {
	}

	private static abstract class BooleanAnswer implements Runnable {
		/*
		 * Needs to be volatile because it will be set in the SWT thread
		 * and read from the Eclipse builder thread.
		 */
		public volatile boolean answer = false;
	}

	private static abstract class StringAnswer implements Runnable {
		/*
		 * Needs to be volatile because it will be set in the SWT thread
		 * and read from the Eclipse builder thread.
		 */
		public volatile String input = null;
	}

	private static abstract class IPathAnswer implements Runnable {
		/*
		 * Needs to be volatile because it will be set in the SWT thread
		 * and read from the Eclipse builder thread.
		 */
		public volatile IPath path = null;
	}

	private static abstract class IntAnswer implements Runnable {
		/*
		 * Needs to be volatile because it will be set in the SWT thread
		 * and read from the Eclipse builder thread.
		 */
		public volatile int answer = -1;
	}

	private static Shell getShell() {
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	}

	public static void showWarning(final String title, final String msg) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				MessageDialog.openWarning(getShell(), title, msg);
			}
		});
	}

	public static void showInfo(final String title, final String msg) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				MessageDialog.openInformation(getShell(), title, msg);
			}
		});
	}

	public static void showError(final String title, final String msg) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				MessageDialog.openError(getShell(), title, msg);
			}
		});
	}

	public static int showWindow(final Window window) {
		final IntAnswer runnable = new IntAnswer() {
			@Override
			public void run() {
				answer = window.open();
			}
		};
		Display.getDefault().syncExec(runnable);
		return runnable.answer;
	}

	public static boolean askQuestion(final String title, final String question) {
		final BooleanAnswer obj = new BooleanAnswer() {
			@Override
			public void run() {
				answer = MessageDialog.openQuestion(getShell(), title, question);
			}
		};
		Display.getDefault().syncExec(obj);
		return obj.answer;
	}

	public static int askQuestion(final String title, final String question, final String[] choices,
			final int defChoice) {
		final IntAnswer obj = new IntAnswer() {
			@Override
			public void run() {
				final MessageDialog dialog = new MessageDialog(getShell(), title, null, question,
						MessageDialog.QUESTION, choices, defChoice);
				answer = dialog.open();
			}
		};
		Display.getDefault().syncExec(obj);
		return obj.answer;
	}

	public static String getInput(final String title, final String prompt, final String initialValue,
			final IInputValidator validator) {
		final StringAnswer obj = new StringAnswer() {
			@Override
			public void run() {
				final InputDialog dialog = new InputDialog(getShell(), title, prompt, initialValue, validator);
				final int dialogResult = dialog.open();
				if (dialogResult == Window.OK) {
					input = dialog.getValue();
				} else {
					input = null;
				}
			}
		};
		Display.getDefault().syncExec(obj);
		return obj.input;
	}

	public static IPath saveAsDialog() {
		final IPathAnswer obj = new IPathAnswer() {
			@Override
			public void run() {
				SaveAsDialog saveAsDialog = new SaveAsDialog(getShell());
				saveAsDialog.open();
				path = saveAsDialog.getResult();
			}
		};
		Display.getDefault().syncExec(obj);
		return obj.path;
	}
}
