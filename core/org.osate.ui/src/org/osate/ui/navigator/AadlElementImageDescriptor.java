/*
 * <copyright>
 * Copyright  2007 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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