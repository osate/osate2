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
package org.osate.ge.internal.ui.navigator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.navigator.CommonNavigator;
import org.osate.ge.internal.ui.util.ContextHelpUtil;
import org.osate.ge.internal.util.DiagramUtil;

public class DiagramsView extends CommonNavigator {
	private final IResourceChangeListener resourceChangeListener = event -> {
		if (event.getDelta() != null) {
			// Refresh the view when resource changes are made
			final Control ctrl = getCommonViewer().getControl();
			if (ctrl != null && !ctrl.isDisposed()) {
				// Refresh the viewer if the change could affect it.
				if (needsRefresh(event.getDelta())) {
					ctrl.getDisplay().asyncExec(() -> getCommonViewer().refresh());
				}
			}
		}
	};

	private boolean needsRefresh(final IResourceDelta delta) {
		// Refresh if a container was added or removed.
		if (delta.getResource() instanceof IContainer
				&& ((delta.getKind() & IResourceDelta.ADDED) != 0 || (delta.getKind() & IResourceDelta.REMOVED) != 0)) {
			return true;
		}

		// Refresh if the change affected a diagram file.
		if (delta.getResource() instanceof IFile
				&& DiagramUtil.isDiagram((IFile) delta.getResource())) {
			return true;
		}

		// Check children
		for (final IResourceDelta child : delta.getAffectedChildren()) {
			if (needsRefresh(child)) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		ContextHelpUtil.setHelp(getCommonViewer().getControl(), ContextHelpUtil.AADL_DIAGRAMS_VIEW);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener);
	}

	@Override
	public void dispose() {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(resourceChangeListener);
		super.dispose();
	}
}
