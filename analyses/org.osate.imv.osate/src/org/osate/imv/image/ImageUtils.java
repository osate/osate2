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

package org.osate.imv.image;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.SWTGraphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class ImageUtils {

	public static Image getImage(IFigure figure) {
		Rectangle bounds = figure.getBounds();

		Image image = new Image(Display.getCurrent(), bounds.width, bounds.height);
		GC gc = new GC(image);

		SWTGraphics draw2dGC = new SWTGraphics(gc);
		figure.paint(draw2dGC);

		// Cleanup
		draw2dGC.dispose();
		gc.dispose();

		return image;
	}

}
