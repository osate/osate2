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
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.ui.UiUtil;

/* Issue 2430: A lot of the work that used to be done in this class is now done in EObjectURIWrapper.Factory to
 * present having to resolve the URI in the EObjectURIWrapper over and over again.
 */
public class AadlElementLabelProvider extends AdapterFactoryLabelProvider implements IDescriptionProvider {
	public AadlElementLabelProvider() {
		super(UiUtil.getAdapterFactory());
	}

	@Override
	public Image getImage(Object object) {
		if (object instanceof EObjectURIWrapper) {
			return ((EObjectURIWrapper) object).getImage();
		} else {
			return null;
		}
	}

	@Override
	public String getText(Object object) {
		if (object instanceof EObjectURIWrapper) {
			return ((EObjectURIWrapper) object).getText();
		} else {
			return null;
		}
	}

	@Override
	public String getDescription(Object element) {
		if (element instanceof EObjectURIWrapper) {
			EObjectURIWrapper wrapper = (EObjectURIWrapper) element;
			URI uri = wrapper.getUri();
			StringBuilder description = new StringBuilder(getText(wrapper));
			description.append(" - ");
			if (uri.isPlatformPlugin()) {
				// contributed
				String[] segments = uri.segments();
				int i = 2;
				while (segments[i].startsWith("resource") || segments[i].startsWith("package")
						|| segments[i].startsWith("propert")) {
					i++;
				}
				description.append("Plug-in Contributions/");
				description.append(Arrays.stream(segments).skip(i).collect(Collectors.joining("/")));
			} else {
				String[] segments = uri.segments();
				description.append(Arrays.stream(segments).skip(1).collect(Collectors.joining("/")));
			}
			return description.toString();
		} else {
			return null;
		}
	}
}
