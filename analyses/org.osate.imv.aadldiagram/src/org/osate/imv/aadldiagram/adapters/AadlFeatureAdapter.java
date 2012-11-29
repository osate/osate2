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

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.zest.layouts.LayoutEntity;
import org.osate.imv.aadldiagram.aadlfigures.AadlFigureFactory;
import org.osate.imv.aadldiagram.aadlfigures.features.FeatureConnectionAnchor;
import org.osate.imv.aadldiagram.aadlfigures.features.FeatureFigure;
import org.osate.imv.aadldiagram.figuremovers.FeatureFigureMover;
import org.osate.imv.aadldiagram.figuremovers.IFigureMoverDelegate;
import org.osate.imv.aadldiagram.layout.LayoutGraphNode;
import org.osate.imv.aadldiagram.visitors.AadlAdapterVisitor;


public class AadlFeatureAdapter extends AbstractAadlElementAdapter {

	private FeatureFigure figure;

	/**
	 * Delegate for handling figure movement.
	 */
	private IFigureMoverDelegate figureMoverDelegate;

	/**
	 * Used by the auto-layout algorithms.
	 */
	private LayoutEntity layoutItem;

	private FeatureAdapterCategory category;

	private FeatureDirectionType directionType;

	public AadlFeatureAdapter(Object modelElement, FeatureAdapterCategory category, FeatureDirectionType directionType, ILabelProvider labelProvider) {
		super(modelElement, labelProvider);
		this.category = category;
		this.directionType = directionType;
	}

	@Override
	public FeatureFigure getFigure() {
		if(figure == null) {
			// Build figure.
			figure = AadlFigureFactory.getInstance().buildFigure(this);
			figure.addMouseListener(this);
			figure.addMouseMotionListener(this);
			figure.addFigureListener(this);
			this.figureMoverDelegate = this.getFigureMoverDelegate(figure);
		}

		return figure;
	}


	@Override
	public void accept(AadlAdapterVisitor visitor) {
		visitor.visitAadlFeatureAdapter(this);
	}

	@Override
	public LayoutEntity getLayoutItem() {
		if(this.layoutItem == null)
			this.layoutItem = new LayoutGraphNode(this.getFigure(), this.getModelElement());
		return this.layoutItem;
	}

	@Override
	public void setSelected(boolean selected) {
		super.setSelected(selected);
		this.getFigure().setSelected(selected);
	}

	@Override
	public void mousePressed(MouseEvent me) {
		super.mousePressed(me);
		this.figureMoverDelegate.mousePressed(me);
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		super.mouseDragged(me);
		this.figureMoverDelegate.mouseDragged(me);
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		super.mouseReleased(me);
		this.figureMoverDelegate.mouseReleased(me);
	}

	// Factory method.
	private IFigureMoverDelegate getFigureMoverDelegate(FeatureFigure figure) {
		return new FeatureFigureMover(figure);
	}

	public FeatureAdapterCategory getCategory() {
		return category;
	}

	public void setCategory(FeatureAdapterCategory category) {
		this.category = category;
	}

	public FeatureDirectionType getDirectionType() {
		return directionType;
	}

	public void setDirectionType(FeatureDirectionType directionType) {
		this.directionType = directionType;
	}

	@Override
	public ConnectionAnchor getConnectionAnchor(Connection connection) {
		return new FeatureConnectionAnchor(this.getFigure());
	}

}
