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
package org.osate.xtext.aadl2.ui.propertyview;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.yakindu.base.xtext.utils.jface.viewers.XtextStyledTextCellEditor;
import org.yakindu.base.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;

import com.google.inject.Injector;

/**
 * @since 2.0
 */
public class OsateStyledTextCellEditor extends XtextStyledTextCellEditor {
	private static final String CONTEXTMENUID = "org.yakindu.base.xtext.utils.jface.viewers.StyledTextXtextAdapterContextMenu";

	private final IProject project;

	public OsateStyledTextCellEditor(int style, Injector injector, IProject project) {
		super(style, injector);
		this.project = project;
	}

	@Override
	protected OsateStyledTextXtextAdapter createXtextAdapter() {
		return new OsateStyledTextXtextAdapter(this.getInjector(),
				getContextFakeResourceProvider() == null ? IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER
						: getContextFakeResourceProvider(),
				project);
	}

	@Override
	protected void initContextMenu(Control control) {
		MenuManager menuManager = createMenuManager();
		Menu contextMenu = menuManager.createContextMenu(control);
		control.setMenu(contextMenu);
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		IWorkbenchPartSite site = window.getActivePage().getActivePart().getSite();
		site.registerContextMenu(CONTEXTMENUID, menuManager, site.getSelectionProvider());
	}

	@Override
	protected void doSetValue(Object value) {
		if (value instanceof CellEditorPartialValue) {
			CellEditorPartialValue partialValue = (CellEditorPartialValue) value;
			getXtextAdapter().getXtextDocument().set(partialValue.getWholeText());
			getXtextAdapter().getXtextSourceviewer()
					.setDocument(getXtextAdapter().getXtextDocument(),
							getXtextAdapter().getXtextSourceviewer().getAnnotationModel(), partialValue.getOffset(),
							partialValue.getLength());
		} else {
			super.doSetValue(value);
		}
		// Reset the undo manager to prevend deletion of complete text if the
		// user hits ctrl+z after cell editor opens
		getXtextAdapter().getXtextSourceviewer().getUndoManager().reset();
	}

	@Override
	public OsateStyledTextXtextAdapter getXtextAdapter() {
		return (OsateStyledTextXtextAdapter) super.getXtextAdapter();
	}

}
