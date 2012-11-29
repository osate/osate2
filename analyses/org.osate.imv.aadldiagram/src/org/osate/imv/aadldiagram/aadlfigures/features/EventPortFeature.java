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
import org.eclipse.swt.SWT;
import org.osate.imv.aadldiagram.adapters.FeatureDirectionType;


public class EventPortFeature extends PortFeatureFigure {
	private int triangleHeight;
	private int triangleBase;

	public EventPortFeature(String label,
			FeatureDirectionType direction, FeatureLabelStyle labelStyle) {
		super(label, direction, labelStyle);
		triangleHeight = V_EXTENT;
		triangleBase = H_EXTENT;
	}

	@Override
	protected void drawSymbol(Graphics g) {
		super.drawSymbol(g);

		// Configure GC.
		g.setForegroundColor(this.getForegroundColor());
		g.setLineWidth(2);
		g.setLineCap(SWT.CAP_ROUND);


		int centerPoint = (int)Math.ceil((triangleBase / 2.0f)); // Center point of odd #.

		/* Draw outline for outer triangle.*/
		g.drawLine(centerPoint, 0, 0, triangleHeight); // Left side of triangle.
		g.drawLine(centerPoint, 0, triangleBase, triangleHeight); // Right side of triangle.
	}

}
