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

public class SubprogramGroupFigure extends ComponentFigure {

	private static final int LINE_WIDTH = 2;

	private int lineWidth = LINE_WIDTH;

	public SubprogramGroupFigure() {
	}

	@Override
	public void paintFigure(Graphics g){
		super.paintFigure(g);

		// Configure GC.
		g.setLineWidth(this.lineWidth);
		g.setForegroundColor(ColorConstants.black);
		g.setLineStyle(SWT.LINE_DASH);
		g.setBackgroundColor(getBackgroundColor());
		g.setAntialias(SWT.ON);

		// Get client rectangle.
		Rectangle r = this.getClientArea();

		// Fill and draw figure.
		g.fillOval(r);
		g.drawOval(r);
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}

}
