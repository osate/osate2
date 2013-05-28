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

public class DeviceFigure extends ComponentFigure {
	private static final int LINE_GAP = 4;
	private static final int LINE_WIDTH = 2;
	private static final int DIAGONAL_LINE_WIDTH = 2;

	public DeviceFigure()
	{
	}

	@Override
	public void paintFigure(Graphics g)
	{
		super.paintFigure(g);

		g.setLineWidth(LINE_WIDTH);
		g.setAntialias(SWT.ON);
		g.setForegroundColor(ColorConstants.black);
		g.setBackgroundColor(this.getAADLBackgroundColor());

		// Outer rectangle.
		Rectangle outerRect = this.getClientArea();
		// Inner rectangle.
		Rectangle innerRect = outerRect.getCopy().shrink(LINE_GAP, LINE_GAP);
		// Draw outer rectangle with fill.
		g.drawRectangle(outerRect);
		g.fillRectangle(outerRect);
		// Draw inner rectangle.
		g.drawRectangle(innerRect);

		// Set line width for diagonals.
		g.setLineWidth(DIAGONAL_LINE_WIDTH);
		// End caps will be rounded.
		g.setLineCap(SWT.CAP_ROUND);
		// Draw diagonal lines at corners.
		g.drawLine(outerRect.getTopLeft(), innerRect.getTopLeft()); // Top left
		g.drawLine(outerRect.getTopRight(), innerRect.getTopRight()); // Top right
		g.drawLine(outerRect.getBottomLeft(), innerRect.getBottomLeft()); // Bottom left
		g.drawLine(outerRect.getBottomRight(), innerRect.getBottomRight()); // Bottom right
	}
}
