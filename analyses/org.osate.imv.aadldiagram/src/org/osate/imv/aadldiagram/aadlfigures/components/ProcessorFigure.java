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

public class ProcessorFigure extends ComponentFigure {
	private static final int TILT_WIDTH = 8;
	private static final int LINE_WIDTH = 2;
	private static final int TOP_PARALLELOGRAM_HEIGHT = 10;

	private int lineWidth;
	private boolean virtual;

	public ProcessorFigure(boolean virtual) {
		this.lineWidth = LINE_WIDTH;
		this.virtual = virtual;
	}

	@Override
	public void paintFigure(Graphics g){
		super.paintFigure(g);

		// Configure graphic context.
		g.setLineWidth(lineWidth);
		g.setForegroundColor(ColorConstants.black);
		g.setBackgroundColor(this.getAADLBackgroundColor());
		g.setLineJoin(SWT.JOIN_ROUND);
		g.setAntialias(SWT.ON);

		if(this.virtual)
			g.setLineStyle(SWT.LINE_DASH);

		Rectangle r = this.getClientArea();

		int topParallelogramHeight = TOP_PARALLELOGRAM_HEIGHT;

		Rectangle bottomRect = new Rectangle(r.x, r.y + topParallelogramHeight, r.width - TILT_WIDTH, r.height - topParallelogramHeight);
		// Fill bottom rectangle.
		g.fillRectangle(bottomRect);

		// Draw outline for bottom rect.
		g.drawLine(bottomRect.getTopLeft(), bottomRect.getBottomLeft());
		g.drawLine(bottomRect.getBottomLeft(), bottomRect.getBottomRight());

		// Create point list.
		PointList points = new PointList();
		points.addPoint(r.x + TILT_WIDTH, r.y);
		points.addPoint(r.x + r.width, r.y);
		points.addPoint(r.x + (r.width - TILT_WIDTH), r.y + topParallelogramHeight);
		points.addPoint(r.x, r.y + topParallelogramHeight);

		// Fill top parallelogram.
		g.fillPolygon(points);
		// Draw top parallelogram.
		g.drawPolygon(points);


		// Point list for side parallelogram.
		points.removeAllPoints();
		points.addPoint(r.getRight().x, r.y);
		points.addPoint(r.getRight().x, r.getBottom().y - topParallelogramHeight);
		points.addPoint(r.getRight().x - TILT_WIDTH, r.getBottom().y);
		points.addPoint(r.getRight().x - TILT_WIDTH, r.y + topParallelogramHeight);

		// Fill and draw side parallelogram.
		g.fillPolygon(points);
		g.drawPolygon(points);
	}

}
