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

import java.util.Iterator;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.zest.layouts.LayoutItem;
import org.osate.imv.aadldiagram.visitors.AadlAdapterVisitor;


public interface IAadlElementAdapter {
	public Object getModelElement();
	public void highlight(boolean highlight, Color highlightColor);
	public void setSelected(boolean selected);
	public boolean isSelected();
	public IFigure getFigure();
	public boolean isContainer();
	public void setContainer(boolean container);
	public void accept(AadlAdapterVisitor visitor);
	public IAadlElementAdapter getParentAdapter();
	public Iterator<IAadlElementAdapter> getAllChildren();
	public void setParentAdapter(IAadlElementAdapter parentAdapter);
	public void addElementAdapterListener(IAadlElementAdapterListener listener);
	public void removeElementAdapterListener(IAadlElementAdapterListener listener);
	public LayoutItem getLayoutItem();
	public void setLabelProvider(ILabelProvider provider);
	public ILabelProvider getLabelProvider();
	public ConnectionAnchor getConnectionAnchor(Connection connection);
	public void dispose();
}
