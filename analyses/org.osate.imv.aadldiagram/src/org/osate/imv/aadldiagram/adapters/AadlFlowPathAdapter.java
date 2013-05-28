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

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.zest.layouts.LayoutRelationship;
import org.osate.imv.aadldiagram.aadlfigures.AadlFigureFactory;
import org.osate.imv.aadldiagram.draw2d.SelectableMevConnectionFigure;
import org.osate.imv.aadldiagram.layout.GraphLayoutFlowPath;
import org.osate.imv.aadldiagram.visitors.AadlAdapterVisitor;


public class AadlFlowPathAdapter extends AbstractAadlElementAdapter {

	public static final int HIGLIGHTED_LINE_WIDTH = 3;
	public static final int NORMAL_LINE_WIDTH = 1;

	private SelectableMevConnectionFigure figure;

	private IAadlElementAdapter sourceAdapter;
	private IAadlElementAdapter destinationAdapter;

//	private ConnectionDecorationType decorationType;

	/**
	 * Used by the auto-layout algorithms.
	 */
	private LayoutRelationship layoutItem;

	public AadlFlowPathAdapter(Object modelElement, /*ConnectionDecorationType decorationType,*/ ILabelProvider labelProvider, IAadlElementAdapter sourceAdapter, IAadlElementAdapter destinationAdapter) {
		super(modelElement, labelProvider);

		Assert.isNotNull(sourceAdapter);
		Assert.isNotNull(destinationAdapter);

		this.sourceAdapter = sourceAdapter;
		this.destinationAdapter = destinationAdapter;
//		this.decorationType = decorationType;
	}

	@Override
	public SelectableMevConnectionFigure getFigure() {
		if(figure == null) {
			// Build figure.
			figure = AadlFigureFactory.getInstance().buildFigure(this);
			figure.addMouseListener(this);
			figure.addMouseMotionListener(this);
			figure.addFigureListener(this);
		}

		return figure;
	}


	@Override
	public void accept(AadlAdapterVisitor visitor) {
		visitor.visitAadlFlowPathAdapter(this);
	}

	@Override
	public void highlight(boolean highlight, Color highlightColor) {
		super.highlight(highlight, highlightColor);
		// Since this is a connection, the line width will be increased when the connection
		// is highlighted.
		if(highlight)
			this.getFigure().setLineWidth(HIGLIGHTED_LINE_WIDTH);
		else
			this.getFigure().setLineWidth(NORMAL_LINE_WIDTH);
	}

	@Override
	public LayoutRelationship getLayoutItem() {
		return new GraphLayoutFlowPath(this);
	}

	@Override
	public void setSelected(boolean selected) {
		super.setSelected(selected);
		this.getFigure().setSelected(selected);
	}

	public IAadlElementAdapter getSourceAdapter() {
		return sourceAdapter;
	}

	public void setSourceAdapter(IAadlElementAdapter sourceAdapter) {
		this.sourceAdapter = sourceAdapter;
	}

	public IAadlElementAdapter getDestinationAdapter() {
		return destinationAdapter;
	}

	public void setDestinationAdapter(IAadlElementAdapter destinationAdapter) {
		this.destinationAdapter = destinationAdapter;
	}

//	public ConnectionDecorationType getDecorationType() {
//		return decorationType;
//	}
//
//	public void setDecorationType(ConnectionDecorationType decorationType) {
//		this.decorationType = decorationType;
//	}

	@Override
	public void mousePressed(MouseEvent me) {
		super.mousePressed(me);
		this.getFigure().mousePressed(me);
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		super.mouseReleased(me);
		this.getFigure().mouseReleased(me);
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		super.mouseDragged(me);
		this.getFigure().mouseDragged(me);
	}

	@Override
	public void mouseMoved(MouseEvent me) {
		super.mouseMoved(me);
		this.getFigure().mouseMoved(me);
	}

	@Override
	public void mouseExited(MouseEvent me) {
		super.mouseExited(me);
		this.getFigure().mouseExited(me);
	}

	@Override
	public ConnectionAnchor getConnectionAnchor(Connection connection) {
		return null; // Since this is a connection, it does not return a connection anchor.
	}
}
