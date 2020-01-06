/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ui.navigator;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.osate.ui.OsateUiPlugin;

public class AadlElementImageDescriptor extends CompositeImageDescriptor {
	public enum ModificationFlag {
		NO_MODIFICATION, ADD_ERROR, ADD_WARNING, INVALID
	};

	private static final ImageDescriptor ERROR_IMAGE_DESCRIPTOR = create("error_co.gif");
	private static final ImageDescriptor WARNING_IMAGE_DESCRIPTOR = create("warning_co.gif");
	private static final ImageDescriptor STOP_IMAGE_DESCRIPTOR = create("stop_co.gif");

	private final ImageDescriptor baseImage;
	private final ModificationFlag modification;
	private final Point size;

	public AadlElementImageDescriptor(ImageDescriptor baseImage, ModificationFlag modification, Point size) {
		this.baseImage = baseImage;
		this.modification = modification;
		this.size = size;
	}

	@Override
	protected void drawCompositeImage(int width, int height) {
		ImageData bg = getImageData(baseImage);
		drawImage(bg, 0, 0);
		drawBottomLeft();
	}

	private void drawBottomLeft() {
		Point size = getSize();
		if (modification.equals(ModificationFlag.ADD_ERROR)) {
			ImageData data = getImageData(ERROR_IMAGE_DESCRIPTOR);
			drawImage(data, 0, size.y - data.height);
		} else if (modification.equals(ModificationFlag.ADD_WARNING)) {
			ImageData data = getImageData(WARNING_IMAGE_DESCRIPTOR);
			drawImage(data, 0, size.y - data.height);
		} else if (modification.equals(ModificationFlag.INVALID)) {
			ImageData data = getImageData(STOP_IMAGE_DESCRIPTOR);
			drawImage(data, 0, size.y - data.height);
		}
	}

	private ImageData getImageData(ImageDescriptor descriptor) {
		ImageData data = descriptor.getImageData();
		if (data == null) {
			data = new ImageData(6, 6, 1, new PaletteData(new RGB[] { new RGB(255, 0, 0) }));
			OsateUiPlugin.logErrorMessage("Image data not available: " + descriptor.toString());
		}
		return data;
	}

	@Override
	protected Point getSize() {
		return size;
	}

	private static ImageDescriptor create(String name) {
		try {
			URL baseURL = OsateUiPlugin.getDefault().getBundle().getEntry("/icons/");
			URL iconURL = new URL(baseURL, name);
			return ImageDescriptor.createFromURL(iconURL);
		} catch (MalformedURLException e) {
			return ImageDescriptor.getMissingImageDescriptor();
		}
	}
}