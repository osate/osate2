/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil.                                               *
 * Contributions by Peter Feiler and Julien Delange                                 *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.aadldiagram.connectiondecorations;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.swt.SWT;

public class PortConnectionDecoration extends Figure implements RotatableDecoration {

	private static final Dimension SIZE = new Dimension(20, 20);

	public static enum DecorationType {DELAYED, IMMEDIATE};

	private float rotationDegrees;
	private DecorationType decorationType;

	/**
	 * Constructs a PortConnectionDecoration.
	 */
	public PortConnectionDecoration(DecorationType decorationType) {
		this.decorationType = decorationType;
		this.getBounds().setSize(SIZE);
	}

	/**
	 * Sets the location of this figure.
	 *
	 * @param p The location
	 */
	@Override
	public void setLocation(Point p)
	{
		this.getBounds().setLocation(p.x - (int)(SIZE.width / 2.0f), p.y - (int)(SIZE.height / 2.0f));
	}

	/**
	 * Sets the reference point used to determine the rotation angle.
	 *
	 * @param p
	 *            The reference point
	 */
	@Override
	public void setReferencePoint(Point ref)
	{
		Point pt = Point.SINGLETON;
		pt.setLocation(ref);
		pt.negate().translate(getBounds().getLocation());
		rotationDegrees = (float)Math.toDegrees(Math.atan2(pt.y, pt.x));
		this.repaint();
	}


	@Override
	public void paintFigure(Graphics g) {
		// Configure GC.
		g.setForegroundColor(ColorConstants.black);
		g.setLineWidth(2);
		g.setAntialias(SWT.ON);

		// Transform GC
		g.translate(this.getBounds().getCenter());
		g.rotate(this.rotationDegrees);

		switch(this.decorationType)
		{
			case IMMEDIATE:
			{
				this.paintImmediateConnectionDecoration(g);
				break;
			}
			case DELAYED:
			{
				this.paintDelayedConnectionDecoration(g);
				break;
			}
		}
	}

	protected void paintImmediateConnectionDecoration(Graphics g) {
		// First arrow.
		int arrowStartX = 0;
		int h = 5, w = 7;
		g.drawLine(arrowStartX, h, arrowStartX - w, 0);
		g.drawLine(arrowStartX, -h, arrowStartX - w, 0);
		// Seconds arrow.
		arrowStartX = 8;
		g.drawLine(arrowStartX, h, arrowStartX - w, 0);
		g.drawLine(arrowStartX, -h, arrowStartX - w, 0);
	}

	protected void paintDelayedConnectionDecoration(Graphics g) {
		int x = 0;
		int h = 5;
		g.drawLine(x, h, x, -h);
		x = -4;
		g.drawLine(x, h, x, -h);
	}

}
