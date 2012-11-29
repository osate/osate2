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

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.TextUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Display;
import org.osate.imv.aadldiagram.draw2d.ResizableMevFigure;


public class ComponentTitleBorder extends AbstractBorder{

	/**
	 * The border's title.
	 */
	private String title;

	private Font font;
	private Dimension textSize;

	public ComponentTitleBorder(String title){
		this.title = title;
		this.font = getDefaultFont();
		this.textSize = getTextSize();
	}

	private Font getDefaultFont(){
		return new Font(Display.getCurrent(), "Arial", 9, SWT.BOLD);
	}

	private Dimension getTextSize(){
		Dimension d = null;
		if(font != null){
			d = TextUtilities.INSTANCE.getTextExtents(title, font);
		}else{
			d = new Dimension();
		}
		return d;
	}

	@Override
	public Insets getInsets(IFigure figure) {
		int titleHeight = textSize.height + ResizableMevFigure.SELECTION_HANDLE_WIDTH;
		int top = titleHeight > 5 ? titleHeight : 5;
		return new Insets(top, 5, 5, 5);
	}

	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		Rectangle bounds = figure.getBounds();
		// Configure GC.
		graphics.setFont(font);
		graphics.setForegroundColor(ColorConstants.black);
		graphics.setBackgroundColor(ColorConstants.white);

		// Calculate label position.
		int x = (int)(bounds.x + (0.5f * (bounds.width - textSize.width)));
		int y = bounds.y + figure.getInsets().top - textSize.height;

		// Draw label.
		graphics.drawText(title, x, y);
	}

	public void dispose(){
		if(font != null){
			font.dispose();
			font = null;
		}
	}

}
