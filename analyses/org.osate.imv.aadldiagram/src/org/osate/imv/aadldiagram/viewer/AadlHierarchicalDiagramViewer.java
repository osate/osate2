/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.aadldiagram.viewer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.widgets.Composite;
import org.osate.imv.aadldiagram.AadlDiagram;
import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;
import org.osate.imv.aadldiagram.adapters.IAadlElementAdapter;


public class AadlHierarchicalDiagramViewer extends AadlDiagramViewer {

	private Map<Object, AadlComponentAdapter> aadlDiagramCache;

	public AadlHierarchicalDiagramViewer(Composite parent) {
		super(parent);
		aadlDiagramCache = new HashMap<Object, AadlComponentAdapter>();
	}

	@Override
	public void dispose() {
		for(AadlComponentAdapter adapter : this.aadlDiagramCache.values())
			adapter.dispose();
	}

	public void stepInto() {
		IAadlElementAdapter selectedAdapter = this.getAadlDiagram().getSelectedAdapter();
		if(selectedAdapter != AadlDiagram.NO_SELECTED_ADAPTER)
			this.setInput(selectedAdapter.getModelElement());
	}

	public void stepOut() {
		// Get the parent of the container adapter.
		this.setInput(this.getContentProvider().getParent(this.getAadlDiagram().getRootModelElement()));
	}



	public void jumpToSystemInstance() {
		this.setInput(this.getContentProvider().getRoot(this.getAadlDiagram().getRootModelElement()));
	}

	public Collection<AadlComponentAdapter> getCachedAdapters() {
		return aadlDiagramCache.values();
	}

	public boolean isElementCached(Object element) {
		return this.aadlDiagramCache.containsKey(element);
	}

	@Override
	protected AadlComponentAdapter getAadlAdapterForModelElement(Object element) {
		// Check if the figure corresponding to the input object has already been cached.
		AadlComponentAdapter adapter = aadlDiagramCache.get(element);
		if (adapter == null || forceRefresh) {
			// Create container adapter.
			adapter = super.getAadlAdapterForModelElement(element);
			// Cache adapter.
			aadlDiagramCache.put(element, adapter);
		}

		return adapter;
	}

	public void resetRootAdapter() {
		Object element = this.getInput();
		AadlComponentAdapter adapter = aadlDiagramCache.get(element);
		if (adapter != null) {
			aadlDiagramCache.remove(element);
		}
		super.resetRootAdapter();
		aadlDiagramCache.put(element, getAadlDiagram().getRootAdapter());
	}


}
