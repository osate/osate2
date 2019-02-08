/*******************************************************************************
 * Copyright (c)  2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *     CEA LIST - adaptation to Papyrus
 *******************************************************************************/
package org.eclipse.papyrus.infra.discovery.ui.internal.common;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.infra.discovery.InstallableComponent;
import org.eclipse.papyrus.infra.discovery.ui.Activator;
import org.eclipse.papyrus.infra.discovery.ui.internal.wizards.Messages;

public class Installer {
	public static boolean install(Collection<InstallableComponent> descriptors, IRunnableContext context) {
		try {
			final PrepareInstallProfileJob job = new PrepareInstallProfileJob(descriptors);
			context.run(true, true, job);
		} catch (InvocationTargetException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, NLS.bind(Messages.ConnectorDiscoveryWizard_installProblems, new Object[] { e.getCause().getMessage() }), e.getCause());
			Activator.getDefault().getLog().log(status);
			DiscoveryUiUtil.displayStatus(DiscoveryUiUtil.getShell(), Messages.ConnectorDiscoveryWizard_cannotInstall, status, true);
			return false;
		} catch (InterruptedException e) {
			// canceled
			return false;
		}
		return true;
	}
}
