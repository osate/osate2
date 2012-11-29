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

package org.osate.imv.ui.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

public class GradientHelper{

	private static Image oldImage = null;

	public static void applyGradientBG(Composite composite) {
		Rectangle rect = composite.getClientArea();
		Image newImage = new Image(composite.getDisplay(), 1, Math.max(1,
		rect.height));
		GC gc = new GC(newImage);
		gc
		.setForeground(composite.getDisplay().getSystemColor(
		SWT.COLOR_WHITE));
		gc.setBackground(new Color(composite.getDisplay(), 228, 234, 243));
		gc.fillGradientRectangle(0, 0, 1, rect.height, true);
		gc.dispose();
		composite.setBackgroundImage(newImage);

		if (oldImage != null)
		oldImage.dispose();
		oldImage = newImage;
	}
}
