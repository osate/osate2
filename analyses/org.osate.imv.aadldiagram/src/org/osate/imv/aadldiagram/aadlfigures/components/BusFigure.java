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

public class BusFigure extends ComponentFigure{

	private int lineWidth;
	private boolean virtual;

	public BusFigure(boolean virtual){
		this.lineWidth = 2;
		this.virtual = virtual;
	}

	@Override
	public void paintFigure(Graphics g){
		super.paintFigure(g);

		g.setLineWidth(lineWidth);
		g.setForegroundColor(ColorConstants.black);
		g.setBackgroundColor(this.getAADLBackgroundColor());
		g.setAntialias(SWT.ON);

		if(this.virtual)
			g.setLineStyle(SWT.LINE_DASH);

		Rectangle r = this.getClientArea();

		int triangleHeight = (int)(r.width * 0.10f);
		int baseHeight = (int)(r.height * 0.80f);

		Rectangle baseBounds = new Rectangle(r.x + triangleHeight, r.y + (int) ((r.height - baseHeight) / 2.0f), r.width - (triangleHeight * 2), baseHeight);

		// Create point list.
		PointList points = new PointList();
		points.addPoint(r.x, r.getLeft().y);
		points.addPoint(r.x + triangleHeight, r.y);
		points.addPoint(baseBounds.x, baseBounds.y);
		points.addPoint(baseBounds.getRight().x, baseBounds.y);
		points.addPoint(r.getRight().x - triangleHeight, r.y);
		points.addPoint(r.getRight().x, r.getRight().y);
		points.addPoint(r.getRight().x - triangleHeight, r.getBottom().y);
		points.addPoint(baseBounds.getRight().x, baseBounds.getBottom().y);
		points.addPoint(baseBounds.x, baseBounds.getBottom().y);
		points.addPoint(r.x + triangleHeight, r.getBottom().y);


		// Fill shape.
		g.fillPolygon(points);
		// Draw outline.
		g.drawPolygon(points);
	}

}
