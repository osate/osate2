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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.IBundleGroup;
import org.eclipse.core.runtime.IBundleGroupProvider;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.infra.discovery.DiscoveryDefinition;
import org.eclipse.papyrus.infra.discovery.InstallableComponent;

/**
 *
 * @author Cedric Brun <cedric.brun@obeo.fr>
 *
 */
public class InstallationStatusUpdater {

	private DiscoveryDefinitionBrowser discovery;

	public InstallationStatusUpdater(DiscoveryDefinition newdiscovery) {
		this.discovery = new DiscoveryDefinitionBrowser(newdiscovery);
	}

	public void update(IProgressMonitor monitor) throws InterruptedException {
		Set<String> installedFeatures = new HashSet<String>();
		IBundleGroupProvider[] bundleGroupProviders = Platform
				.getBundleGroupProviders();
		for (IBundleGroupProvider provider : bundleGroupProviders) {
			if (monitor.isCanceled()) {
				throw new InterruptedException();
			}
			IBundleGroup[] bundleGroups = provider.getBundleGroups();
			for (IBundleGroup group : bundleGroups) {
				installedFeatures.add(group.getIdentifier());
			}
		}
		Iterator<InstallableComponent> it = discovery
				.getAllInstallableComponents().iterator();
		while (it.hasNext()) {
			InstallableComponent comp = it.next();
			if (allFeaturesAreAlreadyInstalled(installedFeatures, comp)
					|| oneOfTheseIsAlreadyInstalled(comp.getHiddingFeatureID(),
							installedFeatures)) {
				comp.setInstalled(true);
			}
		}
	}

	private boolean oneOfTheseIsAlreadyInstalled(
			EList<String> hiddingFeatureID, Set<String> installedFeatures) {
		boolean oneIsInstalled = false;
		Iterator<String> it = hiddingFeatureID.iterator();
		while (it.hasNext() && !oneIsInstalled) {
			oneIsInstalled = (installedFeatures.contains(it.next()));
		}
		return oneIsInstalled;
	}

	private boolean allFeaturesAreAlreadyInstalled(
			Set<String> installedFeatures, InstallableComponent comp) {
		return installedFeatures.containsAll(comp.getId());
	}
}
