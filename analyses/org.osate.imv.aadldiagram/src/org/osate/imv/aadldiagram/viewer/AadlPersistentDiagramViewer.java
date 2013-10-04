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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.widgets.Composite;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;
import org.osate.imv.aadldiagram.adapters.IAadlElementAdapter;
import org.osate.imv.aadldiagram.util.ErrorUtil;
import org.osate.imv.aadldiagram.visitors.RestoreStateVisitor;



public class AadlPersistentDiagramViewer extends AadlHierarchicalDiagramViewer {

	private IAadlAdapterSaverDelegate saverDelegate;
	private IAadlAdapterRestorerDelegate restorerDelegate;

	private static ComponentInstance errorComponent = null;
	private static boolean useError = false;
	
	private Set<AadlComponentAdapter> dirtyAdapters;

	public AadlPersistentDiagramViewer(Composite parent) {
		super(parent);
		this.dirtyAdapters = new HashSet<AadlComponentAdapter>();
	}

	public void save() {
		if(this.saverDelegate != null) {
			this.saverDelegate.saveDiagram(this.getAadlDiagram());
			for(Iterator<AadlComponentAdapter> it = this.dirtyAdapters.iterator(); it.hasNext();)
				this.saverDelegate.saveRootAdapter(it.next());
			this.dirtyAdapters.clear();
		}
	}

	public Iterator<AadlComponentAdapter> getDirtyAdapters() {
		return this.dirtyAdapters.iterator();
	}

	@Override
	public void figureMoved(IAadlElementAdapter source) {
		super.figureMoved(source);
		// Update set of dirty adapters.
		this.dirtyAdapters.add(this.getAadlDiagram().getRootAdapter());
	}

	@Override
	public void setInput(Object input) {
		AadlComponentAdapter prevAdapter = null;
		AadlComponentAdapter newAdapter = null;

		boolean restore = !this.isElementCached(input);

		prevAdapter = this.getAadlDiagram().getRootAdapter();
		super.setInput(input);
		if (restore) {
			newAdapter = this.getAadlDiagram().getRootAdapter();
			if (newAdapter != prevAdapter)
				this.restore(newAdapter);
		}
	}


	public void showErrors()
	{
		IAadlElementAdapter selectedAdapter = this.getAadlDiagram().getSelectedAdapter();
		System.out.println ("selected=" + selectedAdapter.getModelElement());
		if (selectedAdapter.getModelElement() instanceof ComponentInstance)
		{
			errorComponent = (ComponentInstance) (selectedAdapter.getModelElement());
			ErrorUtil.generateAnalysisModel (((ComponentInstance)selectedAdapter.getModelElement()).getSystemInstance());
			useError = true;
		}
		redrawDiagram();
 	}
	
	public void hideErrors()
	{
		System.out.println ("hideerror=" );

		useError = false;
		redrawDiagram();
 	}
	
	public static boolean useError ()
	{
		return useError;
	}
	
	public static ComponentInstance getErrorComponent ()
	{
		return errorComponent;
	}
	

	public void incrementComponentNestingHandler() {
			this.getAadlDiagram().incrementNestingLevel();
			this.updateRootAdapter();
			updateDiagram();
	}

	public void decrementComponentNestingHandler() {
		this.getAadlDiagram().decrementNestingLevel();
		updateDiagram();
 	}
	
	public void directConnectionHandler() {
		this.getAdapterProvider().setDirectConnection(true);
		updateDiagram();
 	}
	
	public void hierarchicalConnectionHandler() {
		this.getAdapterProvider().setDirectConnection(false);
		updateDiagram();
 	}
	
	public void updateDiagram(){
		Boolean tmprefresh = forceRefresh;
		forceRefresh = true;
		refresh();
		forceRefresh = tmprefresh;
//		redrawDiagram();
	}
	


	public void restore(AadlComponentAdapter adapter) {
		if(this.restorerDelegate != null) {
			this.restorerDelegate.restoreDiagram(this.getAadlDiagram());
			adapter.accept(new RestoreStateVisitor(this.restorerDelegate));
			this.getAadlDiagram().getScalableFigureLayeredPane().validate();
		}
	}

	public void setSaverDelegate(IAadlAdapterSaverDelegate saverDelegate) {
		Assert.isNotNull(saverDelegate);
		this.saverDelegate = saverDelegate;
	}

	public void setRestorerDelegate(IAadlAdapterRestorerDelegate restorerDelegate) {
		Assert.isNotNull(restorerDelegate);
		this.restorerDelegate = restorerDelegate;
	}

}
