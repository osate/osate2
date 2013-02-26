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
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;

public class ProcessFigure extends ComponentFigure{
	private static final int TILT_WIDTH = 8;

	private int lineWidth;

	public ProcessFigure(){
		lineWidth = 2;
	}

	@Override
	public void paintFigure(Graphics g){
		super.paintFigure(g);

		g.setLineWidth(lineWidth);
		g.setForegroundColor(ColorConstants.black);
		g.setBackgroundColor(this.getAADLBackgroundColor());
		g.setAntialias(SWT.ON);

		Rectangle r = this.getClientArea();

		// Create point list.
		PointList points = new PointList();
		points.addPoint(r.x + TILT_WIDTH, r.y);
		points.addPoint(r.x + r.width, r.y);
		points.addPoint(r.x + (r.width - TILT_WIDTH), r.y + r.height);
		points.addPoint(r.x, r.y + r.height);
		points.addPoint(r.x + TILT_WIDTH, r.y);

		// Fill shape.
		g.fillPolygon(points);
		// Draw outline.
		g.drawPolygon(points);

	}

}
