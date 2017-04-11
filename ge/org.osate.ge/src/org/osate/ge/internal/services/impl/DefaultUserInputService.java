/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.text.MessageFormat;
import java.util.Objects;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IMultiDeleteInfo;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.NamedElement;
import org.osate.ge.internal.services.UserInputService;

public class DefaultUserInputService implements UserInputService {
	private final IFeatureProvider fp;
	
	public DefaultUserInputService(final IFeatureProvider fp) {
		this.fp = Objects.requireNonNull(fp, "fp must not be null");
	}

	@Override
	public boolean confirmDelete(final IDeleteContext context) {
		final IMultiDeleteInfo multiDeleteInfo = context.getMultiDeleteInfo();
		if(multiDeleteInfo == null) {
			final Object bo = fp.getBusinessObjectForPictogramElement(context.getPictogramElement());
			if(bo == null) {
				return false;
			}
			
			final String elementName = (bo instanceof NamedElement) ? ((NamedElement) bo).getName() : null;
			final String msg = (elementName != null) ? MessageFormat.format("Are you sure you want to delete {0}?", elementName) : "Are you sure you want to delete this element?";
			if(!MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm Delete", msg)) {
				return false;
			}
		} else {
			if(multiDeleteInfo.isDeleteCanceled()) {
				return false;
			}
			
			if(multiDeleteInfo.isShowDialog()) {
				final String msg = MessageFormat.format("Are you sure you want to delete {0} elements?", multiDeleteInfo.getNumber());
				if(!MessageDialog.openQuestion(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), "Confirm Delete", msg)) {
					multiDeleteInfo.setDeleteCanceled(true);
					return false;
				}
				multiDeleteInfo.setShowDialog(false);
			}		
		}
		
		return true;
	}
}
