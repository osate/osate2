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
package org.eclipse.papyrus.infra.discovery.ui.viewer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.papyrus.infra.discovery.DiscoveryDefinition;

/**
 *
 * @author Cedric Brun <cedric.brun@obeo.fr>
 *
 */
public abstract class DiscoveryContentProvider {

	DiscoveryDefinition disco;

	public void update(IProgressMonitor monitor) throws InterruptedException {
		disco = getDiscovery();
		InstallationStatusUpdater installedUpdater = new InstallationStatusUpdater(disco);
		installedUpdater.update(monitor);
	}

	public DiscoveryDefinition getDiscovery() {
		if (disco == null) {
			disco = load();
		}
		return disco;
	}

	protected abstract DiscoveryDefinition load();

	public abstract String getTitle();

	public abstract String getDescription();

}
