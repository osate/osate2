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

package org.osate.imv.aadldiagram.aadlfigures.features;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;


public class FeatureConnectionAnchor extends AbstractConnectionAnchor{

	public FeatureConnectionAnchor(FeatureFigure owner){
		super(owner);
	}

	@Override
	public Point getLocation(Point reference) {
		Point point = null;
		FeatureFigure figure = (FeatureFigure)getOwner();

		point = figure.getConnectionAnchorPoint();

		figure.translateToAbsolute(point);

		return point;
	}

	@Override
	public Point getReferencePoint() {
		return this.getLocation(null);
	}

}
