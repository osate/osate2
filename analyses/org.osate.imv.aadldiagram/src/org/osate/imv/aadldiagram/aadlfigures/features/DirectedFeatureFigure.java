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

import org.eclipse.draw2d.Graphics;
import org.osate.imv.aadldiagram.adapters.FeatureDirectionType;


public abstract class DirectedFeatureFigure extends FeatureFigure {

	public DirectedFeatureFigure(String label, FeatureDirectionType direction,
			FeatureLabelStyle labelStyle) {
		super(label, direction, labelStyle);
	}

	protected void drawSymbol(Graphics g) {
		// Transform CTM based on port direction.
		accountForFeatureDirection(g);
	}

	protected void accountForFeatureDirection(Graphics g) {
		FeatureDirectionType direction = getDirection(); // Port direction (in, out, in out).
		FeatureOrientation orientation = getOrientation(); // Port orientation (north, south, east, west).
		float deg = 0.0f;
		float dx = 0, dy = 0;
		// Rotate to account for port direction.
		switch(direction){
		case IN: // in port direction
			switch(orientation){
			case NORTH:
			case WEST:
				deg = 180.0f;
				break;
			case SOUTH:
			case EAST:
				deg = 0.0f;
			}
			break;
		case OUT: // out port direction
			switch(orientation){
			case NORTH:
			case WEST:
				deg = 0.0f;
				break;
			case SOUTH:
			case EAST:
				deg = 180.0f;
			}
			break;
		case IN_OUT:
			switch(orientation){
			case NORTH:
			case WEST:
				deg = 0.0f;
				break;
			case SOUTH:
			case EAST:
				deg = 180.0f;
			}
			break;
		}

		dx = this.getSymbolHorizontalExtent() / 2.0f;
		dy = this.getSymbolVerticalExtent() / 2.0f;

		g.translate(dx, dy);
		g.rotate(deg); // Apply rotation.
		g.translate(-dx, -dy);
	}


}
