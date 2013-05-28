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

import org.eclipse.zest.layouts.LayoutBendPoint;
import org.eclipse.zest.layouts.LayoutEntity;
import org.eclipse.zest.layouts.LayoutRelationship;
import org.eclipse.zest.layouts.constraints.LayoutConstraint;
import org.osate.imv.aadldiagram.adapters.AadlFlowPathAdapter;
import org.osate.imv.aadldiagram.adapters.IAadlElementAdapter;


public class GraphLayoutFlowPath implements LayoutRelationship {

	private Object layoutInformation = null;

	private AadlFlowPathAdapter adapter;

	public GraphLayoutFlowPath(AadlFlowPathAdapter adapter) {
		this.adapter = adapter;
	}

	public void clearBendPoints() {
		// Not used.
	}

	public LayoutEntity getDestinationInLayout() {
		// We need to return the destinations parent figure if the parent figure is not
		// currently the container figure.
		IAadlElementAdapter parentAdapter = this.adapter.getDestinationAdapter().getParentAdapter();
		if(!parentAdapter.isContainer())
			return (LayoutEntity)parentAdapter.getLayoutItem();
		else
			return (LayoutEntity)this.adapter.getDestinationAdapter().getLayoutItem();
	}

	public Object getLayoutInformation() {
		return layoutInformation;
	}

	public LayoutEntity getSourceInLayout() {
		// We need to return the sources parent figure if the parent figure is not
		// currently the container figure.
		IAadlElementAdapter parentAdapter = this.adapter.getSourceAdapter().getParentAdapter();
		if(!parentAdapter.isContainer())
			return (LayoutEntity)parentAdapter.getLayoutItem();
		else
			return (LayoutEntity)this.adapter.getSourceAdapter().getLayoutItem();
	}

	public void populateLayoutConstraint(LayoutConstraint constraint) {
		// Not used.
	}

	public void setBendPoints(LayoutBendPoint[] bendPoints) {
		// Not used.
	}

	public void setLayoutInformation(Object layoutInformation) {
		this.layoutInformation = layoutInformation;
	}

	public Object getGraphData() {
		return this.adapter.getModelElement();
	}

	public void setGraphData(Object o) {
		// Do nothing.
	}

}
