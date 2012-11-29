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

package org.osate.imv.aadldiagram.aadlfigures.components;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

public class MemoryFigure extends ComponentFigure {

	private static final int LINE_WIDTH = 2;
	private static final int CURVE_HEIGHT = 6;
	private static final int OVAL_HEIGHT = CURVE_HEIGHT * 2;

	public MemoryFigure() {
	}

	@Override
	public void paintFigure(Graphics g){
		super.paintFigure(g);

		g.setLineWidth(LINE_WIDTH);
		g.setAntialias(SWT.ON);
		g.setForegroundColor(ColorConstants.black);
		g.setBackgroundColor(getBackgroundColor());

		// Outer rectangle.
		Rectangle drawingArea = this.getClientArea();

		// Bottom oval.
		g.fillOval(drawingArea.x, drawingArea.getBottom().y - OVAL_HEIGHT, drawingArea.width, OVAL_HEIGHT);
		g.drawOval(drawingArea.x, drawingArea.getBottom().y - OVAL_HEIGHT, drawingArea.width, OVAL_HEIGHT);

		// Fill inside rectangle.
		g.fillRectangle(drawingArea.x, drawingArea.y + CURVE_HEIGHT, drawingArea.width, drawingArea.height - OVAL_HEIGHT);

		// Top oval.
		g.fillOval(drawingArea.x, drawingArea.y, drawingArea.width, OVAL_HEIGHT);
		g.drawOval(drawingArea.x, drawingArea.y, drawingArea.width, OVAL_HEIGHT);

		// Sides.
		g.drawLine(drawingArea.x, drawingArea.y + CURVE_HEIGHT, drawingArea.x, drawingArea.getBottom().y - CURVE_HEIGHT); // left
		g.drawLine(drawingArea.getRight().x, drawingArea.y + CURVE_HEIGHT, drawingArea.getRight().x, drawingArea.getBottom().y - CURVE_HEIGHT); // right
	}

}
