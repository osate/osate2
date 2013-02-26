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

public class ThreadGroupFigure extends ComponentFigure {

	private static final int CORNER_WIDTH = 14;
	private static final int CORNER_HEIGHT = 14;
	private static final int LINE_WIDTH = 2;

	private int cornerWidth = CORNER_WIDTH;
	private int cornerHeight = CORNER_HEIGHT;
	private int lineWidth = LINE_WIDTH;

	public ThreadGroupFigure() {
	}

	@Override
	public void paintFigure(Graphics g){
		super.paintFigure(g);

		// Configure GC.
		g.setLineWidth(this.lineWidth);
		g.setForegroundColor(ColorConstants.black);
		g.setBackgroundColor(this.getAADLBackgroundColor());
		g.setLineStyle(SWT.LINE_DASH);
		g.setAntialias(SWT.ON);

		// Get client rectangle.
		Rectangle r = this.getClientArea();

		// Fill and draw figure.
		g.fillRoundRectangle(r, Math.max(0, this.cornerWidth),
				Math.max(0, this.cornerHeight));
		g.drawRoundRectangle(r, Math.max(0, this.cornerWidth),
				Math.max(0, this.cornerHeight));
	}

	public int getCornerWidth() {
		return cornerWidth;
	}

	public void setCornerWidth(int cornerWidth) {
		this.cornerWidth = cornerWidth;
	}

	public int getCornerHeight() {
		return cornerHeight;
	}

	public void setCornerHeight(int cornerHeight) {
		this.cornerHeight = cornerHeight;
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}



}
