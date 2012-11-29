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

package org.osate.imv.aadldiagram.layout;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.zest.layouts.LayoutEntity;
import org.eclipse.zest.layouts.constraints.LayoutConstraint;

public class LayoutGraphNode implements LayoutEntity {

	private Object layoutInformation = null;

	private Figure target;
	private Object modelElement;

	public LayoutGraphNode(Figure target, Object modelElement) {
		this.target = target;
		this.modelElement = modelElement;
	}

	public double getHeightInLayout() {
		return this.target.getSize().height;
	}

	public Object getLayoutInformation() {
		return layoutInformation;
	}

	public String toString() {
		return this.modelElement.toString();
	}

	public double getWidthInLayout() {
		return this.target.getSize().width;
	}

	public double getXInLayout() {
		return this.target.getLocation().x;
	}

	public double getYInLayout() {
		return this.target.getLocation().y;
	}

	public void populateLayoutConstraint(LayoutConstraint constraint) {
		// Not used.
	}

	public void setLayoutInformation(Object internalEntity) {
		this.layoutInformation = internalEntity;
	}

	public void setLocationInLayout(double x, double y) {
		if(target.getParent() != null) {
			Rectangle constraint = new Rectangle(new Point((int)x, (int)y), this.target.getSize());
			this.target.getParent().getLayoutManager().setConstraint(this.target, constraint);
			this.target.setBounds(constraint);
		}
	}

	public void setSizeInLayout(double width, double height) {
		// The size will not be adjusted by the auto-layout algorithm.
	}

	/**
	 * Compares two nodes.
	 */
	public int compareTo(Object otherNode) {
		int rv = 0;
		String str = this.toString();
		if (str != null) {
			rv = str.compareTo(otherNode.toString());
		}
		return rv;
	}

	public Object getGraphData() {
		return this.modelElement;
	}

	public void setGraphData(Object o) {
		// Not used.
	}

}
