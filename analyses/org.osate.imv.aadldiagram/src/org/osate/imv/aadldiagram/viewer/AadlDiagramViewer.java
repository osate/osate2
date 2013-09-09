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


import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osate.imv.aadldiagram.AadlDiagram;
import org.osate.imv.aadldiagram.adapters.AadlAdapterIterator;
import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;
import org.osate.imv.aadldiagram.adapters.IAadlElementAdapter;
import org.osate.imv.aadldiagram.adapters.IAadlElementAdapterListener;
import org.osate.imv.aadldiagram.providers.FlowHighlighterDelegate;
import org.osate.imv.aadldiagram.providers.IAadlAdapterProvider;
import org.osate.imv.aadldiagram.providers.IAadlContentProvider;
import org.osate.imv.aadldiagram.visitors.ConnectionFilterVisitor;
import org.osate.imv.aadldiagram.visitors.FilterVisitor;
import org.osate.imv.aadldiagram.visitors.FlowHighlighterVisitor;




public class AadlDiagramViewer extends Viewer implements IAadlElementAdapterListener {

	private IAadlAdapterProvider adapterProvider;

	private IAadlContentProvider contentProvider;

	private FlowHighlighterDelegate flowHighlighterDelegate;

	private AadlDiagram aadlDiagram;

	
	
	private Object inputElement;

	private List<AadlDiagramViewerListener> viewerListeners;
	
	protected Boolean forceRefresh = false;


	/**
	 * This viewer's parent control.
	 */
	private Control parent;

	/**
	 * The current selection.
	 */
	private ISelection selection = null;


	/**
	 * List of filters to apply to all elements.
	 */
	private List<ViewerFilter> filterList;


	public AadlDiagramViewer(Composite parent){
		this.parent = parent;
		this.viewerListeners = new ArrayList<AadlDiagramViewerListener>();
		// Create empty filter list.
		filterList = new ArrayList<ViewerFilter>();
		this.aadlDiagram = new AadlDiagram(parent);
	}


	public void dispose() {
		AadlComponentAdapter rootAdapter = this.getAadlDiagram().getRootAdapter();
		if(rootAdapter != null)
			rootAdapter.dispose();
	}

	public void addFilter(ViewerFilter filter){
		Assert.isNotNull(filter);
		// Add filter to end of list.
		addFilter(filter, -1);
	}

	public void addFilter(ViewerFilter filter, int index){
		if(index < 0)
			// Add to end of list.
			filterList.add(filter);
		else
			filterList.add(index, filter);
	}

	private void registerFigureListeners() {
		AadlAdapterIterator it = new AadlAdapterIterator(this.aadlDiagram.getRootAdapter());
		while(it.hasNext()) {
			it.next().addElementAdapterListener(this);
		}
	}

	protected AadlComponentAdapter getAadlAdapterForModelElement(Object element) {
		return this.adapterProvider.getContainerComponentAdapter(element, this.aadlDiagram.getNestingLevel());
	}

	@Override
	public void setInput(Object input) {
		if(forceRefresh||  (input != null && this.inputElement != input && this.contentProvider.isAllowedToBeContainer(input))) {

			this.fireInputElementWillChangeEvent(this.inputElement, this.inputElement = input);

			AadlComponentAdapter adapter = this.getAadlAdapterForModelElement(input);

			// Set root adapter.
			this.aadlDiagram.setRootAdapter(adapter);

			this.registerFigureListeners();

			this.fireInputElementChangedEvent(input);

			// Filter adapters.
			adapter.accept(new FilterVisitor(this.filterList, this));
			adapter.accept(new ConnectionFilterVisitor());
		}
	}
	public void updateRootAdapter() {
		this.adapterProvider.updateContainerComponentAdapter(this.aadlDiagram.getRootAdapter(), this.aadlDiagram.getNestingLevel());
}

	public void resetRootAdapter() {

			this.fireInputElementWillChangeEvent(this.inputElement, this.inputElement );

			AadlComponentAdapter adapter = this.adapterProvider.getContainerComponentAdapter(this.inputElement, this.aadlDiagram.getNestingLevel());

			// Set root adapter.
			this.aadlDiagram.setRootAdapter(adapter);

			this.registerFigureListeners();

			this.fireInputElementChangedEvent(this.inputElement);

			// Filter adapters.
			adapter.accept(new FilterVisitor(this.filterList, this));
			adapter.accept(new ConnectionFilterVisitor());
	}


	@Override
	public Control getControl() {
		return parent;
	}

	@Override
	public Object getInput() {
		return inputElement;
	}

	@Override
	public ISelection getSelection() {
		return this.selection;
	}

	@Override
	public void refresh() {
		// Re-load view.
		setInput(this.aadlDiagram.getRootModelElement());
	}

	public void runFilters() {
		AadlComponentAdapter adapter = this.aadlDiagram.getRootAdapter();
		if(adapter != null) {
			adapter.accept(new FilterVisitor(this.filterList, this));
			adapter.accept(new ConnectionFilterVisitor());
			adapter.accept(new FlowHighlighterVisitor(this.flowHighlighterDelegate, adapter.getModelElement()));
			this.aadlDiagram.getScalableFigureLayeredPane().repaint();
		}
	}
	
	public void redrawDiagram(){
		this.aadlDiagram.getScalableFigureLayeredPane().repaint();
	}


	@Override
	public void setSelection(ISelection selection, boolean reveal) {
		this.selection = selection;

		if(selection != null){
			SelectionChangedEvent event = new SelectionChangedEvent(this, selection);
			fireSelectionChanged(event);
		}
	}

	public void setAdapterProvider(IAadlAdapterProvider provider){
		this.adapterProvider = provider;
	}

	public IAadlAdapterProvider getAdapterProvider() {
		return adapterProvider;
	}

	public IAadlContentProvider getContentProvider() {
		return contentProvider;
	}

	public void setContentProvider(IAadlContentProvider contentProvider) {
		this.contentProvider = contentProvider;
	}

	public AadlDiagram getAadlDiagram() {
		return aadlDiagram;
	}

	public FlowHighlighterDelegate getFlowHighlighterDelegate() {
		return flowHighlighterDelegate;
	}

	public void setFlowHighlighterDelegate(FlowHighlighterDelegate flowHighlighterDelegate) {
		this.flowHighlighterDelegate = flowHighlighterDelegate;
	}


	@Override
	public void singleClickOnFigure(IAadlElementAdapter source) {
		if(source != null && source != this.aadlDiagram.getSelectedAdapter()) {
			this.aadlDiagram.setSelectedAdapter(source);
			setSelection(new StructuredSelection(source.getModelElement()));
		}
	}

	@Override
	public void doubleClickOnFigure(IAadlElementAdapter source) {
		setInput(source.getModelElement());
	}

	@Override
	public void figureMoved(IAadlElementAdapter source) {
		this.fireFigureMovedEvent(source.getFigure());
	}

	public void addAadlDiagramViewerListener(AadlDiagramViewerListener l) {
		synchronized(this.viewerListeners) {
			if(!this.viewerListeners.contains(l))
				this.viewerListeners.add(l);
		}
	}

	public void removeAadlDiagramViewerListener(AadlDiagramViewerListener l) {
		synchronized(this.viewerListeners) {
			this.viewerListeners.remove(l);
		}
	}

	protected void fireInputElementWillChangeEvent(Object currentInput, Object newInput) {
		synchronized(this.viewerListeners) {
			for(AadlDiagramViewerListener l : this.viewerListeners)
				l.inputElementWillChange(currentInput, newInput);
		}
	}

	protected void fireInputElementChangedEvent(Object input) {
		synchronized(this.viewerListeners) {
			for(AadlDiagramViewerListener l : this.viewerListeners)
				l.inputElementChanged(input);
		}
	}

	protected void fireFigureMovedEvent(IFigure source) {
		synchronized(this.viewerListeners) {
			for(AadlDiagramViewerListener l : this.viewerListeners)
				l.figureMoved(source);
		}
	}
}



