/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil.                                               *
 * Contributions by Peter Feiler and Julien Delange                                 *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.aadldiagram.adapters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.zest.layouts.LayoutEntity;
import org.osate.imv.aadldiagram.aadlfigures.AadlFigureFactory;
import org.osate.imv.aadldiagram.aadlfigures.components.ComponentConnectionAnchor;
import org.osate.imv.aadldiagram.aadlfigures.components.ComponentFigure;
import org.osate.imv.aadldiagram.draw2d.ContainerFigureResizeDelegate;
import org.osate.imv.aadldiagram.draw2d.IResizableFigureDelegate;
import org.osate.imv.aadldiagram.draw2d.SubcomponentFigureResizeDelegate;
import org.osate.imv.aadldiagram.figuremovers.IFigureMoverDelegate;
import org.osate.imv.aadldiagram.figuremovers.SubComponentFigureMover;
import org.osate.imv.aadldiagram.layout.LayoutGraphNode;
import org.osate.imv.aadldiagram.visitors.AadlAdapterVisitor;


public class AadlComponentAdapter extends AbstractAadlElementAdapter {

	private ComponentFigure figure;

	private List<AadlComponentAdapter> childComponents;
	private List<AadlFeatureAdapter> childFeatures;
	private List<AadlBindingAdapter> childBindings;
	private List<AadlConnectionAdapter> childConnections;
	private List<AadlFlowPathAdapter> childFlowPaths;

	/**
	 * Delegate for handling figure movement.
	 */
	private IFigureMoverDelegate figureMoverDelegate;

	/**
	 * Used by the auto-layout algorithms.
	 */
	private LayoutEntity layoutItem;

	private ComponentAdapterCategory category;


	public AadlComponentAdapter(Object modelElement, ComponentAdapterCategory category, ILabelProvider labelProvider) {
		super(modelElement, labelProvider);
		this.category = category;
		this.createChildLists();
	}

	@Override
	public void dispose() {
		this.getFigure().dispose();

		// Dispose of children adapters.
		for(Iterator<IAadlElementAdapter> it = this.getAllChildren(); it.hasNext();)
			it.next().dispose();

		super.dispose();
	}

	@Override
	public ComponentFigure getFigure() {
		if(this.figure == null) {
			// Build figure.
			figure = AadlFigureFactory.getInstance().buildFigure(this);
			figure.addMouseListener(this);
			figure.addMouseMotionListener(this);
			figure.addFigureListener(this);
			figure.setResizableFigureDelegate(this.getResizableFigureDelegate());
			this.figureMoverDelegate = getFigureMoverDelegate(figure);
		}

		return this.figure;
	}


	@Override
	public void accept(AadlAdapterVisitor visitor) {
		visitor.visitAadlComponentAdapter(this);

		// Send visitor to direct child elements.
		for(Iterator<IAadlElementAdapter> it = this.getAllChildren(); it.hasNext();)
			it.next().accept(visitor);
	}

	@Override
	public void setSelected(boolean selected) {
		super.setSelected(selected);
		this.getFigure().setSelected(selected);
	}


	@Override
	public LayoutEntity getLayoutItem() {
		if(this.layoutItem == null)
			this.layoutItem = new LayoutGraphNode(this.getFigure(), this.getModelElement());
		return this.layoutItem;
	}

	public void addChild(AadlComponentAdapter adapter) {
		this.childComponents.add (adapter);
		this.addChildFigure(adapter);
	}

	public void removeChild(AadlComponentAdapter adapter) {
		this.childComponents.remove (adapter);
		this.removeChildFigure(adapter);
	}
	
	public void addChild (AadlBindingAdapter adapter) {
		this.childBindings.add (adapter);
		this.addChildFigure(adapter);
	}

	public void addChild(AadlFeatureAdapter adapter) {
		this.childFeatures.add(adapter);
		this.addChildFigure(adapter);
	}
	public void removeChild(AadlFeatureAdapter adapter) {
		this.childFeatures.remove(adapter);
		this.removeChildFigure(adapter);
	}

	public void addChild(AadlConnectionAdapter adapter) {
		this.childConnections.add(adapter);
		this.addChildFigure(adapter);
	}

	public void addChild(AadlFlowPathAdapter adapter) {
		this.childFlowPaths.add(adapter);
		this.addChildFigure(adapter);
	}

	public Iterator<AadlComponentAdapter> getChildComponents() {
		return this.childComponents.iterator();
	}

	public Iterator<AadlFeatureAdapter> getChildFeatures() {
		return this.childFeatures.iterator();
	}

	public Iterator<AadlConnectionAdapter> getChildConnections() {
		return this.childConnections.iterator();
	}

	public Iterator<AadlFlowPathAdapter> getChildFlowPaths() {
		return this.childFlowPaths.iterator();
	}

	public Iterator<IAadlElementAdapter> getAllChildren() {
		List<IAadlElementAdapter> retList = new ArrayList<IAadlElementAdapter>();

		retList.addAll(this.childComponents);
		retList.addAll(this.childFeatures);
		retList.addAll(this.childConnections);
		retList.addAll(this.childBindings);
		retList.addAll(this.childFlowPaths);
		// phf:  recurse on subcomponent adapters
		for(AadlComponentAdapter comp : this.childComponents) {
			for(Iterator<IAadlElementAdapter> it = comp.getAllChildren(); it.hasNext();)
				retList.add(it.next());
		}

		return retList.iterator();
	}

	private void createChildLists() {
		this.childComponents = new ArrayList<AadlComponentAdapter>();
		this.childFeatures = new ArrayList<AadlFeatureAdapter>();
		this.childConnections = new ArrayList<AadlConnectionAdapter>();
		this.childFlowPaths = new ArrayList<AadlFlowPathAdapter>();
		this.childBindings = new ArrayList<AadlBindingAdapter>();
	}

	private void addChildFigure(IAadlElementAdapter elementAdapter) {
		elementAdapter.setParentAdapter(this);
		this.getFigure().add(elementAdapter.getFigure());
	}

	private void removeChildFigure(IAadlElementAdapter elementAdapter) {
		this.getFigure().remove(elementAdapter.getFigure());
	}

	@Override
	public void mousePressed(MouseEvent me) {
		super.mousePressed(me);
		this.getFigure().mousePressed(me);
		if(!me.isConsumed())
			this.figureMoverDelegate.mousePressed(me);
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		super.mouseDragged(me);
		this.getFigure().mouseDragged(me);
		if(!me.isConsumed())
			this.figureMoverDelegate.mouseDragged(me);
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		super.mouseReleased(me);
		this.getFigure().mouseReleased(me);
		if(!me.isConsumed())
			this.figureMoverDelegate.mouseReleased(me);
	}

	// TODO XXX do we need FlowAnchor or can we use Connection anchors?
	public ConnectionAnchor getConnectionAnchor(Connection connection) {
		return new ComponentConnectionAnchor(this.getFigure(), connection);
	}

	public ComponentAdapterCategory getCategory() {
		return category;
	}

	public void setCategory(ComponentAdapterCategory category) {
		this.category = category;
	}

	protected IFigureMoverDelegate getFigureMoverDelegate(ComponentFigure figure) {
		if(!this.isContainer())
			return new SubComponentFigureMover(figure);
		else
			return new DummyFigureMoverDelegate(); // Container figures cannot be moved so we'll use a dummy delegate.
	}

	protected IResizableFigureDelegate getResizableFigureDelegate() {
		if(this.isContainer())
			return new ContainerFigureResizeDelegate(this);
		else
			return new SubcomponentFigureResizeDelegate();
	}

	/**
	 * Does not move figure (used for container figures).
	 */
	private class DummyFigureMoverDelegate implements IFigureMoverDelegate {
		public void mouseDragged(MouseEvent event) {}
		public void mouseReleased(MouseEvent event) {}
		public void mousePressed(MouseEvent event) {}
	}
}
