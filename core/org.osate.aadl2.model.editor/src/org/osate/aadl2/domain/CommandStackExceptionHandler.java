/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 * </copyright>
 */
package org.osate.aadl2.domain;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.ExceptionHandler;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.presentation.Aadl2EditorPlugin;

/**
 * An exception handler for the shared editing domain's command stack, that
 * shows errors in a pop-up dialog.
 *
 * @author Christian W. Damus (cdamus)
 */
public class CommandStackExceptionHandler implements ExceptionHandler {

	// Documentation copied from the inherited specification
	@Override
	public void handleException(final Exception e) {
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
			@Override
			public void run() {
				Shell shell = null;
				IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

				if (window != null) {
					shell = window.getShell();
				}

				if (e instanceof RollbackException) {
					RollbackException rbe = (RollbackException) e;

					ErrorDialog.openError(shell, "Command failed",
							"Changes automatically rolled back due to validation failure.", rbe.getStatus());
				} else {
					ErrorDialog.openError(shell, "Command failed",
							"An exception occurred during execution of the command.", new Status(IStatus.ERROR,
									Aadl2EditorPlugin.getPlugin().getSymbolicName(), 1, e.getLocalizedMessage(), e));
				}
			}
		});
	}

}
