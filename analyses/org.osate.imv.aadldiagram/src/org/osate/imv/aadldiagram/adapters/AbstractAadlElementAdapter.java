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

package org.osate.imv.aadldiagram.adapters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Color;
import org.osate.imv.aadldiagram.visitors.AadlAdapterVisitor;


public abstract class AbstractAadlElementAdapter implements IAadlElementAdapter, MouseListener, MouseMotionListener, FigureListener{

	private Object modelElement;

	private IAadlElementAdapter parentAdapter;

	private boolean selected;

	private boolean container;

	private ILabelProvider labelProvider;

	private List<IAadlElementAdapterListener> adapterListeners;

	public AbstractAadlElementAdapter(Object modelElement, ILabelProvider labelProvider) {
		Assert.isNotNull(modelElement, "Model element must NOT be null");
		this.modelElement = modelElement;
		this.labelProvider = labelProvider;
		this.adapterListeners = new ArrayList<IAadlElementAdapterListener>();
	}

	@Override
	public Object getModelElement() {
		return this.modelElement;
	}

	@Override
	public void highlight(boolean highlight, Color highlightColor) {
		IFigure figure = this.getFigure();
		Color newColor = null;
		if(highlight) {
			newColor = highlightColor;
		} else {
			newColor = ColorConstants.black;
		}

		figure.setForegroundColor(newColor);
		figure.setBackgroundColor(newColor);
	}


	@Override
	public void accept(AadlAdapterVisitor visitor) {
		// Default implementation. Explicitly does nothing.
	}

	public Iterator<IAadlElementAdapter> getAllChildren() {
		// By default, an empty iterator is returned.
		return new ArrayList<IAadlElementAdapter>(0).iterator();
	}

	@Override
	public boolean isContainer() {
		return container;
	}

	@Override
	public void setContainer(boolean container) {
		this.container = container;
	}

	@Override
	public boolean isSelected() {
		return selected;
	}

	@Override
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	@Override
	public String toString() {
		return this.getLabelProvider().getText(this.getModelElement());
	}

	public ILabelProvider getLabelProvider() {
		return labelProvider;
	}

	public void setLabelProvider(ILabelProvider labelProvider) {
		this.labelProvider = labelProvider;
	}

	public IAadlElementAdapter getParentAdapter() {
		return this.parentAdapter;
	}

	public void setParentAdapter(IAadlElementAdapter parentAdapter) {
		this.parentAdapter = parentAdapter;
	}

	public void addElementAdapterListener(IAadlElementAdapterListener listener) {
		synchronized(this.adapterListeners) {
			if(!this.adapterListeners.contains(listener))
				this.adapterListeners.add(listener);
		}
	}

	public void removeElementAdapterListener(IAadlElementAdapterListener listener) {
		synchronized(this.adapterListeners) {
			this.adapterListeners.remove(listener);
		}
	}

	protected void fireFigureMovedEvent() {
		synchronized(this.adapterListeners) {
			for(IAadlElementAdapterListener listener : this.adapterListeners)
				listener.figureMoved(this);
		}
	}

	protected void fireSingleClickOnFigureEvent() {
		synchronized(this.adapterListeners) {
			for(IAadlElementAdapterListener listener : this.adapterListeners)
				listener.singleClickOnFigure(this);
		}
	}

	protected void fireDoubleClickOnFigureEvent() {
		synchronized(this.adapterListeners) {
			for(IAadlElementAdapterListener listener : this.adapterListeners)
				listener.doubleClickOnFigure(this);
		}
	}

	@Override
	public void dispose() {
		// Intended to be overridden by subclass.
	}

	@Override
	public void mousePressed(MouseEvent me) {
		this.fireSingleClickOnFigureEvent();
	}

	@Override
	public void mouseDoubleClicked(MouseEvent me) {
		this.fireDoubleClickOnFigureEvent();
	}

	@Override
	public void figureMoved(IFigure source) {
		this.fireFigureMovedEvent();
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		// Default behavior is to do nothing.
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		// Default behavior is to do nothing.
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		// Default behavior is to do nothing.
	}

	@Override
	public void mouseExited(MouseEvent me) {
		// Default behavior is to do nothing.
	}

	@Override
	public void mouseHover(MouseEvent me) {
		// Default behavior is to do nothing.
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		// Default behavior is to do nothing.
	}

}
