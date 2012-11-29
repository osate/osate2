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

package org.osate.imv.propertydecorations.threads;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.imv.aadldiagram.propertydecorations.IPropertyDecorationDelegate;
import org.osate.xtext.aadl2.properties.util.GetProperties;


public class DispatchPropertyDecorationDelegate implements IPropertyDecorationDelegate {

	private NamedElement context;

	private Font labelFont;

	public DispatchPropertyDecorationDelegate() {
		this.labelFont = new Font(Display.getCurrent(), "Arial", 9, SWT.BOLD);
	}

	@Override
	public void paintDecoration(Graphics g, Dimension figureSize) {
		if(this.context == null)
			return;

		String dispatchProtocol = this.getDispatchProtocol();
		if (dispatchProtocol != null) {

			String label = null;

			if (dispatchProtocol.equals("Periodic")) {
				label = this.getPeriod();
			} else if (dispatchProtocol.equals("Aperiodic")) {
				label = "A";
			} else if (dispatchProtocol.equals("Sporadic")) {
				label = "S:";
			} else if (dispatchProtocol.equals("Timed")) {
				label = "T:" + this.getPeriod();
			} else if (dispatchProtocol.equals("Hybrid")) {
				label = "H: " + this.getPeriod();
			} else if (dispatchProtocol.equals("Background")) {
				label = "B";
			} else {
				label = "n/a";
			}

			Dimension textSize = TextUtilities.INSTANCE.getTextExtents(label, this.labelFont);

			g.setBackgroundColor(ColorConstants.white);
			g.setForegroundColor(ColorConstants.black);
			g.setLineWidth(1);
			g.setAntialias(SWT.ON);
			// phf: offset decorator so it is in corner of thread
			Rectangle rect = new Rectangle(-5, -10, textSize.width + 14, textSize.height + 4);
			g.fillOval(rect);
			g.drawOval(rect);

			Point textLoc = Point.SINGLETON;
			// phf: added offset
			textLoc.x = (int) (0.5f * (rect.width - textSize.width)) -5;
			textLoc.y = (int) (0.5f * (rect.height - textSize.height)) -10;
			g.drawText(label, textLoc);
		}
	}

	private String getDispatchProtocol() {
		String retVal = null;
		EnumerationLiteral enumLiteral =  GetProperties.getDispatchProtocol(this.context);
		if(enumLiteral != null)
			retVal = enumLiteral.getName();
		return retVal;
	}


	private String getPeriod() {
		String retVal = null;
		double period = GetProperties.getPeriodinMS(this.context);
		retVal = String.valueOf((int)period) + "ms";
		return retVal;
	}

	@Override
	public void setAadlElement(Object element) {
		if(element instanceof NamedElement)
			this.context = (NamedElement)element;
	}

	@Override
	public void dispose() {
		if(this.labelFont != null)
			this.labelFont.dispose();
	}

	@Override
	public String getName() {
		return "Dispatch_Protocol";
	}
}
