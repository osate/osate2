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