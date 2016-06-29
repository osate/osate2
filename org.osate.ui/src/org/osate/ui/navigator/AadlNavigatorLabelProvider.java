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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.ui.OsateUiPlugin;
import org.osate.ui.UiUtil;
import org.osate.ui.navigator.AadlElementImageDescriptor.ModificationFlag;

public class AadlNavigatorLabelProvider extends DecoratingLabelProvider {
	public AadlNavigatorLabelProvider() {
		super(new WorkbenchLabelProvider(), null);
	}

	@Override
	public String getText(Object element) {
		StringBuilder text = new StringBuilder(super.getText(element));
		if (element instanceof PublicPackageSection) {
			text.append("Public Package Section");
		} else if (element instanceof PrivatePackageSection) {
			text.append("Private Package Section");
		} else if (element instanceof PropertyType) {
			text.append(UiUtil.getModelElementLabelProvider().getText(element));
		} else if (element instanceof InstanceObject) {
			text.append(UiUtil.getModelElementLabelProvider().getText(element));
		} else if (element instanceof NamedElement) {
			text.append(UiUtil.getModelElementLabelProvider().getText(element));
		}
		return text.toString();
	}

	@Override
	public Image getImage(Object element) {
		Image image;
		if (element instanceof PropertyType) {
			image = UiUtil.getModelElementLabelProvider().getImage(element);
		} else if (element instanceof InstanceObject) {
			image = UiUtil.getModelElementLabelProvider().getImage(element);
		} else if (element instanceof NamedElement) {
			image = UiUtil.getModelElementLabelProvider().getImage(element);
		} else {
			image = super.getImage(element);
		}
		return decorateImage(image, element);
	}

	private Image decorateImage(Image image, Object obj) {
		if (obj instanceof IResource) {
			ModificationFlag modification = getModification((IResource) obj);
			if (!modification.equals(ModificationFlag.NO_MODIFICATION)) {
				ImageImageDescriptor baseImage = new ImageImageDescriptor(image);
				Rectangle bounds = image.getBounds();
				return new AadlElementImageDescriptor(baseImage, modification, new Point(bounds.width, bounds.height))
						.createImage();
			} else {
				return image;
			}
		} else {
			return image;
		}
	}

	public static ModificationFlag getModification(IResource res) {
		if (res == null || !res.isAccessible()) {
			return ModificationFlag.NO_MODIFICATION;
		}
		ModificationFlag modification = ModificationFlag.NO_MODIFICATION;
		IMarker[] markers = null;
		try {
			markers = res.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		} catch (CoreException e) {
			OsateUiPlugin.log(e);
		}
		if (markers != null) {
			for (int i = 0; i < markers.length && !modification.equals(ModificationFlag.ADD_ERROR); i++) {
				if (markers[i].getAttribute(IMarker.SEVERITY, -1) == IMarker.SEVERITY_WARNING) {
					modification = ModificationFlag.ADD_WARNING;
				} else if (markers[i].getAttribute(IMarker.SEVERITY, -1) == IMarker.SEVERITY_ERROR) {
					modification = ModificationFlag.ADD_ERROR;
				}
			}
		}
		return modification;
	}
}