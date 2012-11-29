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
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.osate.imv.image.AutoImageType;
import org.osate.imv.image.ImageSaver;


public class AutoImageSaveNowAction extends Action implements ActionFactory.IWorkbenchAction, PropertyChangeListener {

	private static final String ID = "org.osate.imv.ui.actions.autoImageSaveNow";

	private static final String LABEL = "Save Image Now";

	private ImageSaver imageSaver;

	public AutoImageSaveNowAction(ImageSaver imageSaver) {
		this.imageSaver = imageSaver;

		setId(ID);
		setText(LABEL);
		this.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT));

		updateState();

		// Register for changes to the image type.
		imageSaver.addPropertyChangeListener(ImageSaver.AUTO_IMAGE_TYPE_PROPERTY, this);
	}

	@Override
	public void run() {
		imageSaver.forceAutomaticSave();
	}

	@Override
	public void dispose() {
		imageSaver.removePropertyChangeListener(ImageSaver.AUTO_IMAGE_TYPE_PROPERTY, this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if(event.getPropertyName().equals(ImageSaver.AUTO_IMAGE_TYPE_PROPERTY)) {
			updateState();
		}
	}

	private void updateState() {
		this.setEnabled(imageSaver.getAutoImageType() != AutoImageType.NONE);
	}

}
