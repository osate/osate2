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

package org.osate.imv.providers;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ConnectionReference;


public class FigureLabelProvider extends BaseLabelProvider implements ILabelProvider{

	@Override
	public Image getImage(Object element) {
		// Images not currently used for AADL figures.
		return null;
	}

	@Override
	public String getText(Object element) {
		Assert.isNotNull(element);
		String text = null;
		if (element instanceof ConnectionReference){
			element = ((ConnectionReference) element).getOwner();
		}
		if(element instanceof NamedElement)
			return ((NamedElement)element).getFullName();
		return text;
	}

}
