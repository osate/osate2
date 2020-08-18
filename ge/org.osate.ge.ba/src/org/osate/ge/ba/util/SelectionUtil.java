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
package org.osate.ge.ba.util;

import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.BusinessObjectContext;

import com.google.common.collect.ImmutableList;

public class SelectionUtil {
	public static ISelection getCurrentSelection() {
		final IWorkbenchWindow win = getActiveWorkbenchWindow();
		if (win == null) {
			return StructuredSelection.EMPTY;
		}

		return win.getSelectionService().getSelection();
	}

	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		final IWorkbench wb = PlatformUI.getWorkbench();
		if (wb == null) {
			return null;
		}

		return wb.getActiveWorkbenchWindow();
	}

	public static IEditorPart getActiveEditorFromContext(final Object evaluationContext) {
		if (!(evaluationContext instanceof IEvaluationContext)) {
			return null;
		}

		final IEvaluationContext context = (IEvaluationContext) evaluationContext;
		final Object editorObj = context.getVariable(ISources.ACTIVE_EDITOR_NAME);
		return editorObj instanceof IEditorPart ? (IEditorPart) editorObj : null;
	}

	public static ImmutableList<BusinessObjectContext> getSelectedBusinessObjectContexts() {
		final ISelection selection = getCurrentSelection();
		if (!(selection instanceof IStructuredSelection)) {
			return ImmutableList.of();
		}

		final IStructuredSelection ss = (IStructuredSelection) selection;
		final ImmutableList.Builder<BusinessObjectContext> bocs = ImmutableList.builderWithExpectedSize(ss.size());
		for (final Object sel : ss.toList()) {
			final BusinessObjectContext boc = Adapters.adapt(sel, BusinessObjectContext.class);
			if (boc == null) {
				return ImmutableList.of();
			}

			bocs.add(boc);
		}

		return bocs.build();
	}
}
