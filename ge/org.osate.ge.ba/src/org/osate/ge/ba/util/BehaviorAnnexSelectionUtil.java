/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.ba.util;

import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.ba.BehaviorAnnexReferenceUtil;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ui.utils.SelectionHelper;

public class BehaviorAnnexSelectionUtil {
	private BehaviorAnnexSelectionUtil() {
	}

	/**
	 * Get diagram context based on selection and editor.
	 * @return an optional that contains a DefaultAnnexSubclause if
	 * the selection is a valid diagram context or empty if invalid
	 */
	public static Optional<DefaultAnnexSubclause> getDiagramContext(final ISelection selection,
			final IEditorPart editor) {
		if (editor instanceof XtextEditor) {
			final EObject selectedObject = SelectionHelper
					.getEObjectFromSelection(((XtextEditor) editor).getSelectionProvider().getSelection());
			return findDiagramContextForSelectedObject(selectedObject);
		}

		if (selection instanceof IStructuredSelection) {
			final List<BusinessObjectContext> selectedBusinessObjectContexts = SelectionUtil
					.getSelectedBusinessObjectContexts(selection);
			if (selectedBusinessObjectContexts.size() == 1) {
				return BehaviorAnnexSelectionUtil
						.findDiagramContextForSelectedObject(selectedBusinessObjectContexts.get(0).getBusinessObject());
			}
		}

		return Optional.empty();
	}

	private static Optional<DefaultAnnexSubclause> findDiagramContextForSelectedObject(final Object element) {
		if (element instanceof BehaviorAnnex || element instanceof BehaviorState
				|| element instanceof BehaviorTransition
				|| element instanceof BehaviorVariable) {
			return findDiagramContextForSelectedObject(((Element) element).getOwner());
		}

		if (element instanceof DefaultAnnexSubclause
				&& BehaviorAnnexReferenceUtil.ANNEX_NAME.equalsIgnoreCase(((NamedElement) element).getName())) {
			return Optional.of((DefaultAnnexSubclause) element);
		}

		return Optional.empty();
	}

	// Returns an optional of the active editor or empty if null
	public static Optional<IEditorPart> getActiveEditor() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if (workbench == null) {
			return Optional.empty();
		}

		final IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		if (window == null) {
			return Optional.empty();
		}

		final IWorkbenchPage page = window.getActivePage();
		if (page == null) {
			return Optional.empty();
		}

		return Optional.ofNullable(page.getActiveEditor());
	}
}
