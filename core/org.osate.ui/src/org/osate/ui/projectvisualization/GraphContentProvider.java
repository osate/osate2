/*******************************************************************************
 * Copyright 2005, 2012 CHISEL Group, University of Victoria, Victoria, BC,
 * Canada. All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: The Chisel Group, University of Victoria IBM CAS, IBM Toronto
 * Lab
 ******************************************************************************/
package org.osate.ui.projectvisualization;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.zest.core.viewers.IGraphEntityContentProvider;

class GraphContentProvider implements IGraphEntityContentProvider {

	Object currentBundle = null;
	private boolean reverseBundleDependencies;

	private Object[] getDependencies(Object bundle) {
		if (bundle != null) {
			if (reverseBundleDependencies) {
				return DependencyUtil.getDependentBundles(bundle);
			}
			return AnalysisUtil.getPrerequisites(new Object[] { currentBundle });
		}
		return new Object[0];
	}

	// Returns all entities that should be linked with the given entity
	public Object[] getConnectedTo(Object entity) {
		Object[] bundles = null;
		if (reverseBundleDependencies) {
			bundles = DependencyUtil.getConnectedBundles(entity, currentBundle);
		} else {
			bundles = AnalysisUtil.getDependencies(entity);
		}
		return bundles;
	}

	public Object[] getElements(Object inputElement) {
		return getDependencies(inputElement);

	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		currentBundle = newInput;
	}

	public void setReverseBundleDependencies(boolean enable) {
		this.reverseBundleDependencies = enable;
	}

}