/*******************************************************************************
 * Copyright 2005-2006, CHISEL Group, University of Victoria, Victoria, BC,
 * Canada. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: The Chisel Group, University of Victoria IBM CAS, IBM Toronto
 * Lab
 ******************************************************************************/
package org.osate.ui.projectvisualization;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.ui.OsateUiPlugin;

/**
 * General utility classes for dealing with bundle dependencies.
 * @author Ian Bull
 * 
 */
public class AnalysisUtil {
	/**
	 * Finds all the callers for bundle within bunldes[]
	 * 
	 * @return
	 */
	public static Object[] getAllCallers(Object bundle, Object[] bundles) {
		HashSet<Object> callers = new HashSet<>();
		for (int i = 0; i < bundles.length; i++) {
			HashSet<Object> hashSet = new HashSet<>();
			hashSet.addAll(Arrays.asList(getPrerequisites(new Object[] { bundles[i] })));
			if (hashSet.contains(bundle)) {
				callers.add(bundles[i]);
			}
		}
		return callers.toArray(new Object[callers.size()]);
	}

	public static Object[] getPrerequisites(Object[] bundles) {
		if (bundles == null || bundles.length == 0) {
			return new Object[0];
		}
		Set<Object> reachable = new HashSet<>(bundles.length);
		for (int i = 0; i < bundles.length; i++) {
			addPrerequisites(bundles[i], reachable);
		}
		return reachable.toArray(new Object[reachable.size()]);
	}

	public static Object[] getDependencies(Object bundle) {
		if (bundle == null) {
			return new Object[0];
		}
		IProject project = (IProject) bundle;
		try {
			return project.getReferencedProjects();
		} catch (CoreException e) {
			StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
			return new Object[0];
		}
	}

	private static void addPrerequisites(Object bundle, Set<Object> reachable) {
		if (reachable.contains(bundle)) {
			return;
		}
		reachable.add(bundle);

		Object[] dependencies = getDependencies(bundle);
		for (int i = 0; i < dependencies.length; i++) {
			addPrerequisites(dependencies[i], reachable);
		}
	}
}
