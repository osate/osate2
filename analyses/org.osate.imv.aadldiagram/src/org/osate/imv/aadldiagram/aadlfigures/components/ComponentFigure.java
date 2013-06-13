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
import org.eclipse.swt.graphics.Color;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;
import org.osate.imv.aadldiagram.draw2d.ResizableMevFigure;
import org.osate.imv.aadldiagram.propertydecorations.IPropertyDecorationDelegate;
import org.osate.imv.aadldiagram.util.ErrorUtil;
import org.osate.imv.aadldiagram.viewer.AadlPersistentDiagramViewer;


public class ComponentFigure extends ResizableMevFigure {

	private List<IPropertyDecorationDelegate> propertyDecorations;
	private AadlComponentAdapter adapter;

	public ComponentFigure() {
		this.propertyDecorations = new ArrayList<IPropertyDecorationDelegate>();
		this.adapter = null;
	}

	public void setAdapter (AadlComponentAdapter a)
	{
		this.adapter = a;
	}
	
	public Color getAADLBackgroundColor ()
	{
		Color c;
		int factor;

		factor = ErrorUtil.INVALID_FACTOR;
		
		if (! AadlPersistentDiagramViewer.useError())
		{
			return getBackgroundColor();
		}
		
		if ( (adapter != null) && (adapter.getModelElement() instanceof ComponentInstance))
		{
//			factor = ErrorUtil.getFactorWithPath (AadlPersistentDiagramViewer.getErrorComponent(), 
//										  		 ((ComponentInstance) adapter.getModelElement()));
			factor = ErrorUtil.getFactorWithPath ((ComponentInstance) adapter.getModelElement());
			ErrorUtil.setCacheValue((ComponentInstance)adapter.getModelElement(), factor);
		}

		if ( (AadlPersistentDiagramViewer.useError()) && (factor != -1 ))
		{
			/*
			 * The factor is on a scale between 0 .. 100
			 * The RGB should be on a scale between 0 .. 255
			 * So, to scale the error factor to the RGB value,
			 * we make the following operation: rgb_value = error_factor * 2.5
			 * As we operate with integer only, we have to separate
			 * the * 2.5 into * 25 / 10. 
			 */
			c = new Color(null, 200 + factor / 3, 50 + factor / 3, 50 + factor);
			
			
		}	
		else
		{
			c = getBackgroundColor();
		}
		return c;
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
