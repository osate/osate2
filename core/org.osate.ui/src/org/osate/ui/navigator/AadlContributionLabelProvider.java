/*
 * <copyright>
 * Copyright  2018 by Carnegie Mellon University, all rights reserved.
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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.osate.ui.OsateUiPlugin;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

public class AadlContributionLabelProvider extends LabelProvider implements IDescriptionProvider {

	@Override
	public String getText(Object element) {
		String text = null;
		if (element instanceof VirtualPluginResources) {
			text = "Plug-in Contributions";
		} else if (element instanceof ContributedDirectory) {
			List<String> directoryPath = ((ContributedDirectory) element).getPath();
			text = directoryPath.get(directoryPath.size() - 1);
		} else if (element instanceof ContributedAadlStorage) {
			text = ((ContributedAadlStorage) element).getName();
		}
		return text;
	}

	@Override
	public Image getImage(Object element) {
		Image image = null;
		if (element instanceof VirtualPluginResources) {
			image = OsateUiPlugin.getImageDescriptor("icons/library_obj.gif").createImage();
		} else if (element instanceof ContributedDirectory) {
			image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		} else if (element instanceof ContributedAadlStorage) {
			image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
		}
		return image;
	}

	@Override
	public String getDescription(Object element) {
		String description = null;
		if (element instanceof VirtualPluginResources) {
			description = "Plug-in Contributions";
		} else if (element instanceof ContributedDirectory) {
			List<String> directoryPath = ((ContributedDirectory) element).getPath();
			description = "Plug-in Contributions/" + String.join("/", directoryPath);
		} else if (element instanceof ContributedAadlStorage) {
			String[] segments = ((ContributedAadlStorage) element).getUri().segments();
			int i = 2;
			while (segments[i].startsWith("resource") || segments[i].startsWith("package")
					|| segments[i].startsWith("propert")) {
				i++;
			}
			description = "Plug-in Contributions/"
					+ Arrays.asList(segments).stream().skip(i).collect(Collectors.joining("/"));
		}
		return description;
	}

}