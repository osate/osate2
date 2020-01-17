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
package org.osate.mylyn.aadl.ui;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.mylyn.monitor.ui.AbstractUserInteractionMonitor;
import org.eclipse.ui.IWorkbenchPart;
import org.osate.aadl2.Element;
import org.osate.ui.utils.SelectionHelper;

public class AadlEditingMonitor extends AbstractUserInteractionMonitor {
	protected StructuredSelection currentSelection = null;

	@Override
	protected void handleWorkbenchPartSelection(final IWorkbenchPart part, final ISelection selection,
			final boolean contributeToContext) {
		EObject selectedElement = null;
		if (selection instanceof StructuredSelection) {
			final StructuredSelection structuredSelection = (StructuredSelection) selection;
			if (structuredSelection.equals(currentSelection)) {
				return;
			}
			currentSelection = structuredSelection;

			for (final Iterator<?> iterator = structuredSelection.iterator(); iterator.hasNext();) {
				final Object selectedObject = iterator.next();
				if (selectedObject instanceof Element) {
					selectedElement = (Element) selectedObject;
				}
				if (selectedElement != null) {
					super.handleElementSelection(part, selectedElement, contributeToContext);
				}
			}
		} else if (selection instanceof TextSelection) {
			selectedElement = SelectionHelper.getEObjectFromSelection(selection);
			if (selectedElement != null) {
				super.handleElementSelection(part, selectedElement, contributeToContext);
			}
		}
	}

}
