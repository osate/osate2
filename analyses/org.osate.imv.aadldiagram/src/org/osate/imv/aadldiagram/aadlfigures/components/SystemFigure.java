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
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.swt.SWT;


public class SystemFigure extends ComponentFigure {
	private static final int CORNER_WIDTH = 10;
	private static final int CORNER_HEIGHT = 10;

	private Dimension corner = new Dimension(CORNER_WIDTH, CORNER_HEIGHT);
	private int lineWidth;

	public SystemFigure(){
		lineWidth = 2;
	}

	@Override
	public void paintFigure(Graphics g){
		super.paintFigure(g);
		fillShape(g);
		outlineShape(g);
	}


	protected void fillShape(Graphics g) {
		g.pushState();
		g.setBackgroundColor(this.getAADLBackgroundColor());
		g.fillRoundRectangle(getClientArea(), Math.max(0, corner.width),
				Math.max(0, corner.height));
		g.popState();
	}


	protected void outlineShape(Graphics g) {
		g.setLineWidth(lineWidth);
		g.setAntialias(SWT.ON);
		g.setForegroundColor(ColorConstants.black);

		g.drawRoundRectangle(getClientArea(), Math.max(0, corner.width),
				Math.max(0, corner.height));

	}

}
