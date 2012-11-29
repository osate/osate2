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

package org.osate.imv.ui.actions;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.actions.ActionFactory;
import org.osate.imv.image.AutoImageType;
import org.osate.imv.image.ImageSaver;


public class AutoImageAction extends Action implements ActionFactory.IWorkbenchAction, PropertyChangeListener {

	private static final String ID = "org.osate.imv.ui.actions.autoImage";

	private static final String NONE_LBL = "None";
	private static final String PNG_LBL = "PNG";
	private static final String JPG_LBL = "JPG";
	private static final String GIF_LBL = "GIF";


	private AutoImageType imageType;
	private ImageSaver imageSaver;

	public AutoImageAction(AutoImageType imageType, ImageSaver imageSaver) {
		this.imageType = imageType;
		this.imageSaver = imageSaver;
		String label = "";
		switch(imageType) {
		case NONE:
			label = NONE_LBL;
			break;
		case PNG:
			label = PNG_LBL;
			break;
		case JPG:
			label = JPG_LBL;
			break;
		case GIF:
			label = GIF_LBL;
			break;
		}

		setId(ID);
		setText(label);

		this.setChecked(imageSaver.getAutoImageType() == imageType);

		// Register for changes to the image type.
		imageSaver.addPropertyChangeListener(ImageSaver.AUTO_IMAGE_TYPE_PROPERTY, this);
	}

	@Override
	public void run() {
		imageSaver.setAutoImageType(this.imageType);
	}

	@Override
	public void dispose() {
		imageSaver.removePropertyChangeListener(ImageSaver.AUTO_IMAGE_TYPE_PROPERTY, this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(event.getPropertyName().equals(ImageSaver.AUTO_IMAGE_TYPE_PROPERTY)) {
			this.setChecked(imageSaver.getAutoImageType() == imageType);
		}
	}

}
