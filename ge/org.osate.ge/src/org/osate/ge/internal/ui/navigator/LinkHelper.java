/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.navigator.ILinkHelper;

public class LinkHelper implements ILinkHelper {

	@Override
	public IStructuredSelection findSelection(final IEditorInput anInput) {
		final IFile file = ResourceUtil.getFile(anInput);
		if(file != null) {
			return new StructuredSelection(file);
		}

		return StructuredSelection.EMPTY;
	}

	@Override
	public void activateEditor(final IWorkbenchPage aPage, final IStructuredSelection aSelection) {
		// Not used. The default activateEditor behavior works as desired.
	}
}
