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

public class AbstractFigure extends ComponentFigure {

	private int lineWidth;

	public AbstractFigure() {
		this.lineWidth = 2;
	}

	@Override
	public void paintFigure(Graphics g){
		super.paintFigure(g);

		// Configure context.
		g.setLineWidth(lineWidth);
		g.setForegroundColor(ColorConstants.black);
		g.setBackgroundColor(getBackgroundColor());
		g.setLineStyle(SWT.LINE_DASH);
		g.setAntialias(SWT.ON);

		Rectangle r = this.getClientArea();

		// Paint figure.
		g.fillRectangle(r);
		g.drawRectangle(r);
	}

}
