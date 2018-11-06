/**
 * Copyright (c) 2015 Carnegie Mellon University.
 * All Rights Reserved.
 *
 * THIS SOFTWARE IS PROVIDED "AS IS," WITH NO WARRANTIES WHATSOEVER.
 * CARNEGIE MELLON UNIVERSITY EXPRESSLY DISCLAIMS TO THE FULLEST
 * EXTENT PERMITTEDBY LAW ALL EXPRESS, IMPLIED, AND STATUTORY
 * WARRANTIES, INCLUDING, WITHOUT LIMITATION, THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE, AND
 * NON-INFRINGEMENT OF PROPRIETARY RIGHTS.

 * This Program is distributed under a BSD license.
 * Please see license.txt file or permission@sei.cmu.edu for more
 * information.
 *
 * DM-0003411
 */

package org.osate.aadl2.errormodel.faulttree.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.faulttree.util.SiriusUtil;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ui.dialogs.Dialog;

public final class FTGraphicalViewHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ComponentInstance target;
		FaultTree ftmodel = getTarget(HandlerUtil.getCurrentSelection(event));
		if (ftmodel == null) {
			Dialog.showInfo("Fault Tree Viewer", "Please choose a fault tree");
			return IStatus.ERROR;
		}
			SiriusUtil.INSTANCE.autoOpenModel(ftmodel, ResourceUtil.getFile(ftmodel.eResource()).getProject(),
						"viewpoint:/org.osate.aadl2.errormodel.faulttree.design/FaultTree", "IconicFaultTree",
						"Fault Tree");
			return Status.OK_STATUS;
	}

	private FaultTree getTarget(ISelection currentSelection) {
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection iss = (IStructuredSelection) currentSelection;
			if (iss.size() == 1) {
				Object obj = iss.getFirstElement();
				if (obj instanceof FaultTree) {
					return (FaultTree) obj;
				}
				if (obj instanceof IFile) {
					ResourceSet rset = OsateResourceUtil.createXtextResourceSet();
					Resource res = OsateResourceUtil.getResource((IResource) obj, rset);
					EList<EObject> rl = res.getContents();
					if (!rl.isEmpty()) {
						if (rl.get(0) instanceof FaultTree) {
							return (FaultTree) rl.get(0);
						}
					}
				}
			}
		}
		return null;
	}

}
