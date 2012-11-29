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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.osate.imv.aadldiagram.draw2d.ResizableMevFigure;
import org.osate.imv.aadldiagram.propertydecorations.IPropertyDecorationDelegate;


public class ComponentFigure extends ResizableMevFigure {

	private List<IPropertyDecorationDelegate> propertyDecorations;

	public ComponentFigure() {
		this.propertyDecorations = new ArrayList<IPropertyDecorationDelegate>();
	}

	public Rectangle getFeatureBounds() {
		// Clip bounds so that features will be contained within the client area
		// but the resize handle should still be visible outside of the client area.
		Rectangle featureBounds = getBounds().getCopy();
		Insets borderInsets = getInsets();
		int insetOffset = (int) ResizableMevFigure.SELECTION_HANDLE_WIDTH;
		featureBounds.shrink(new Insets(borderInsets.top - insetOffset,
				borderInsets.left - insetOffset, borderInsets.bottom
						- insetOffset, borderInsets.right - insetOffset));
		return featureBounds;
	}

	public void addPropertyDecorationDelegate(IPropertyDecorationDelegate delegate) {
		//delegate.setAadlElement(getElement());
		this.propertyDecorations.add(delegate);
	}

	@Override
	protected void paintClientArea(Graphics graphics) {
		Rectangle rect = this.getClientArea();
		Dimension size = rect.getSize();

		try {
			graphics.pushState();

			// Translate GC.
			graphics.translate(rect.x, rect.y);

			// Paint property decorations.
			for (IPropertyDecorationDelegate delegate : this.propertyDecorations) {
				delegate.paintDecoration(graphics, size);
				graphics.restoreState();
			}

		} catch (Exception e) {
			System.err.println("PropertyDecorationDelegate error: " + e.getMessage());
		} finally {
			graphics.popState();
		}

		// Clip to the containers bounds.
		graphics.clipRect(getBounds());
		graphics.pushState();
		paintChildren(graphics);
		graphics.popState();
	}


	public void dispose() {
		for(IPropertyDecorationDelegate delegate : this.propertyDecorations)
			delegate.dispose();
	}

}
