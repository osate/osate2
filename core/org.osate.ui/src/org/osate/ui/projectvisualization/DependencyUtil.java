/*******************************************************************************
 * Copyright (c) 2009 EclipseSource Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     EclipseSource Corporation - initial API and implementation
 *     Stefan Rock <stefan.rock@cas.de> - bug blah
 *******************************************************************************/
package org.osate.ui.projectvisualization;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;

/**
 * Provides some util methods to return bundles that depend on the
 * given bundle, i.e. that are callers.
 */
public class DependencyUtil {
	/**
	 * Calculates and returns a transitive closure of all dependent bundles of
	 * the given bundle.
	 * @param bundle
	 * @return
	 */
	public static Object[] getDependentBundles(Object bundle) {
		if (bundle instanceof IProject) {
			Set<IProject> reachable = new HashSet<>();
			reachable.add((IProject) bundle);
			getDependentBundles((IProject) bundle, reachable);
			return reachable.toArray();
		} else {
			return new Object[0];
		}
	}
	
	public static void getDependentBundles(IProject project, Set<IProject> reachable) {
		for (IProject referencing : project.getReferencingProjects()) {
			if (!reachable.contains(referencing)) {
				reachable.add(referencing);
				getDependentBundles(referencing, reachable);
			}
		}
	}

	/**
	 * Returns all bundles that 
	 * - are in the set of the transitive closure of dependent bundles for focussedBundle and 
	 * - that the currentBundle depends on.
	 * @param currentBundle
	 * @param focussedBundle
	 * @return
	 */
	public static Object[] getConnectedBundles(Object currentBundle, Object focussedBundle) {
		if (!(currentBundle instanceof IProject)) {
			return new Object[0];
		}
		return ((IProject) currentBundle).getReferencingProjects();
	}
	
}
