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

import org.eclipse.jface.action.Action;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.osate.imv.image.ImageSaver;


public class SaveImageAsAction extends Action implements ActionFactory.IWorkbenchAction {

	private static final String ID = "org.osate.imv.ui.actions.saveImageAsAction";

	private static final String LABEL = "Save Image As";

	private ImageSaver imageSaver;

	public SaveImageAsAction(ImageSaver imageSaver) {
		this.imageSaver = imageSaver;

		setId(ID);
		setText(LABEL);
		this.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVEAS_EDIT));
	}

	@Override
	public void run() {
		imageSaver.save();
	}

	@Override
	public void dispose() {
		// Nothing to dispose of.
	}

}
