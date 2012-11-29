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

package org.osate.imv.aadldiagram.draw2d;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public abstract class SelectableMevFigure extends Figure {

	private static final Color DEFAULT_SELECTION_COLOR = ColorConstants.black;

	protected boolean selected;

	private Color selectionColor;

	public SelectableMevFigure() {
		this(DEFAULT_SELECTION_COLOR);
	}

	public SelectableMevFigure(Color selectionColor) {
		this.selected = false;
		this.selectionColor = selectionColor;
	}

	public void setSelected(boolean isSelected){
		selected = isSelected;
		this.repaint();
	}

	public boolean isSelected() {
		return this.selected;
	}

	@Override
	public void paintFigure(Graphics g){
		// Highlight figure if it is selected.
		if(selected){
			// Save graphics state.
			g.pushState();

			g.setLineWidth(1);
			g.setForegroundColor(this.selectionColor);
			g.setBackgroundColor(this.selectionColor);

			// Get bounds.
			Rectangle r = Rectangle.SINGLETON.setBounds(getBounds());

			int offset = (int)(ResizableMevFigure.SELECTION_HANDLE_WIDTH / 2.0f);
			g.drawRectangle(r.x + offset, r.y + offset, r.width - ResizableMevFigure.SELECTION_HANDLE_WIDTH, r.height - ResizableMevFigure.SELECTION_HANDLE_WIDTH);

			// Restore graphics state.
			g.popState();
		}
	}

	public Color getSelectionColor() {
		return selectionColor;
	}

	public void setSelectionColor(Color selectionColor) {
		this.selectionColor = selectionColor;
	}

}
