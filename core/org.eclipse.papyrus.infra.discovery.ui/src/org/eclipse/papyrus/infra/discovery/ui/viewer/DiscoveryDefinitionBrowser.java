/*******************************************************************************
 * Copyright (c)  2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *     CEA LIST - adaptation to Papyrus needs
 *******************************************************************************/
package org.eclipse.papyrus.infra.discovery.ui.viewer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.infra.discovery.DiscoveryDefinition;
import org.eclipse.papyrus.infra.discovery.InstallableComponent;

/**
 *
 * @author Cedric Brun <cedric.brun@obeo.fr>
 * @author Remi Schnekenburger
 *
 */
public class DiscoveryDefinitionBrowser {

	private DiscoveryDefinition definition;

	public DiscoveryDefinitionBrowser(DiscoveryDefinition definition) {
		this.definition = definition;
	}

	public Collection<InstallableComponent> getAllInstallableComponents() {
		List<InstallableComponent> components = new ArrayList<InstallableComponent>();
		Iterator<EObject> it = definition.eAllContents();
		while (it.hasNext()) {
			EObject cur = it.next();
			if (cur instanceof InstallableComponent) {
				components.add((InstallableComponent) cur);
			}
		}
		return components;
	}

}
