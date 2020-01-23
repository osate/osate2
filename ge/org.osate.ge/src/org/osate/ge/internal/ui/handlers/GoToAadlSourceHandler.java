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
package org.osate.ge.internal.ui.handlers;

import java.util.List;
import java.util.Objects;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.EmfContainerProvider;
import org.osate.ge.internal.ui.editor.AgeDiagramEditor;

public class GoToAadlSourceHandler extends AbstractHandler {
	@Override
	public void setEnabled(final Object evaluationContext) {
		boolean enabled = false;
		final List<BusinessObjectContext> selectedBusinessObjectContexts = AgeHandlerUtil
				.getSelectedBusinessObjectContexts();
		if (selectedBusinessObjectContexts.size() == 1) {
			final Object selectedBo = selectedBusinessObjectContexts.get(0).getBusinessObject();
			final EObject boEObj = getEObject(selectedBo);
			if (boEObj != null) {
				final URI uri = EcoreUtil.getURI(boEObj);
				if (uri != null && boEObj.eResource() instanceof XtextResource) {
					final XtextResource res = (XtextResource) boEObj.eResource();
					if (res.getResourceServiceProvider().get(GlobalURIEditorOpener.class) != null) {
						enabled = true;
					}
				}
			}
		}

		setBaseEnabled(enabled);
	}

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
		if (!(activeEditor instanceof AgeDiagramEditor)) {
			throw new RuntimeException("Unexpected editor: " + activeEditor);
		}

		// Get diagram and selected BOCs
		final List<BusinessObjectContext> selectedBusinessObjectContexts = AgeHandlerUtil
				.getSelectedBusinessObjectContexts();
		if (selectedBusinessObjectContexts.size() == 0) {
			throw new RuntimeException("No element selected");
		}

		final Object selectedBo = selectedBusinessObjectContexts.get(0).getBusinessObject();
		final EObject boEObj = getEObject(selectedBo);
		if (boEObj == null) {
			throw new RuntimeException("Unsupported type: " + selectedBo);
		}

		final URI uri = Objects.requireNonNull(EcoreUtil.getURI(boEObj), "Unable to get URI for business object");
		if (!(boEObj.eResource() instanceof XtextResource)) {
			throw new RuntimeException("The resource of the loaded business object resource is not an XtextResource");
		}

		final XtextResource res = (XtextResource) boEObj.eResource();
		final GlobalURIEditorOpener opener = Objects.requireNonNull(
				(GlobalURIEditorOpener) res.getResourceServiceProvider().get(GlobalURIEditorOpener.class),
				"unable to get global URI Editor opener");
		opener.open(uri, true);
		return true;
	}

	private static EObject getEObject(final Object bo) {
		if (bo instanceof EObject) {
			return (EObject) bo;
		} else if (bo instanceof EmfContainerProvider) {
			return ((EmfContainerProvider) bo).getEmfContainer();
		} else {
			return null;
		}
	}
}
