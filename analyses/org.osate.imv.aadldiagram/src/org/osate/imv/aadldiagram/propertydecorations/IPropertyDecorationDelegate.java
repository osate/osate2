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

package org.osate.imv.aadldiagram.propertydecorations;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;

public interface IPropertyDecorationDelegate {
	public void setAadlElement(Object element);
	public String getName();
	public void paintDecoration(Graphics g, Dimension figureSize);
	public void dispose();
}
