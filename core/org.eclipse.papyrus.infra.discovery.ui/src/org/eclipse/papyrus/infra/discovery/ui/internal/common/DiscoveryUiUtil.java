/*******************************************************************************
 * Copyright (c) 2009 Tasktop Technologies and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Tasktop Technologies - initial API and implementation
 *     Obeo - adaptation for Amalgamation, EMF based and no Mylyn dependency
 *     CEA LIST - adaptation to Papyrus
 *******************************************************************************/

package org.eclipse.papyrus.infra.discovery.ui.internal.common;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * @author David Green
 * @author Steffen Pingel much of this is copied from TasksUiInternal
 */
public abstract class DiscoveryUiUtil {
	private DiscoveryUiUtil() {
	}

	/**
	 * Utility method to get the best parenting possible for a dialog. If there
	 * is a modal shell create it so as to avoid two modal dialogs. If not then
	 * return the shell of the active workbench window. If neither can be found
	 * return null.
	 * <p>
	 * <b>Note: Applied from patch on bug 99472.</b>
	 *
	 * @return Shell or <code>null</code>
	 */
	public static Shell getShell() {
		if (!PlatformUI.isWorkbenchRunning() || PlatformUI.getWorkbench().isClosing()) {
			return null;
		}
		Shell modal = getModalShellExcluding(null);
		if (modal != null) {
			return modal;
		}
		return getNonModalShell();
	}

	/**
	 * Get the active non modal shell. If there isn't one return null.
	 * <p>
	 * <b>Note: Applied from patch on bug 99472.</b>
	 *
	 * @return Shell
	 */
	public static Shell getNonModalShell() {
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (window == null) {
			IWorkbenchWindow[] windows = PlatformUI.getWorkbench().getWorkbenchWindows();
			if (windows.length > 0) {
				return windows[0].getShell();
			}
		} else {
			return window.getShell();
		}

		return null;
	}

	/**
	 * Return the modal shell that is currently open. If there isn't one then
	 * return null.
	 * <p>
	 * <b>Note: Applied from patch on bug 99472.</b>
	 *
	 * @param shell
	 *            A shell to exclude from the search. May be <code>null</code>.
	 * @return Shell or <code>null</code>.
	 */
	public static Shell getModalShellExcluding(Shell shell) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		Shell[] shells = workbench.getDisplay().getShells();
		int modal = SWT.APPLICATION_MODAL | SWT.SYSTEM_MODAL | SWT.PRIMARY_MODAL;
		for (Shell shell2 : shells) {
			if (shell2.equals(shell)) {
				break;
			}
			// Do not worry about shells that will not block the user.
			if (shell2.isVisible()) {
				int style = shell2.getStyle();
				if ((style & modal) != 0) {
					return shell2;
				}
			}
		}
		return null;
	}

	public static void displayStatus(Shell shell, final String title, final IStatus status, boolean showLinkToErrorLog) {


		String message = status.getMessage();

		if (showLinkToErrorLog) {
			message += "  \n see error log";
		}
		switch (status.getSeverity()) {
		case IStatus.CANCEL:
		case IStatus.INFO:
			createDialog(shell, title, message, MessageDialog.INFORMATION).open();
			break;
		case IStatus.WARNING:
			createDialog(shell, title, message, MessageDialog.WARNING).open();
			break;
		case IStatus.ERROR:
		default:
			createDialog(shell, title, message, MessageDialog.ERROR).open();
			break;
		}

	}

	public static MessageDialog createDialog(Shell shell, String title, String message, int type) {
		return new MessageDialog(shell, title, null, message, type, new String[] { IDialogConstants.OK_LABEL }, 0);
	}

}
