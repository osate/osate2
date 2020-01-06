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

package org.osate.aadl2.errormodel.faulttree.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeType;
import org.osate.aadl2.errormodel.faulttree.generation.Activator;
import org.osate.aadl2.errormodel.faulttree.generation.CreateFTAModel;
import org.osate.aadl2.errormodel.faulttree.util.SiriusUtil;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public final class FTAHandler extends AbstractHandler {

	private static String ERROR_STATE_NAME = null;
	private static FaultTreeType FAULT_TREE_TYPE = FaultTreeType.FAULT_TREE;
	private static boolean GRAPHIC_VIEW = false;
	private static List<String> stateNames = null;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ComponentInstance target;
		InstanceObject object = getTarget(HandlerUtil.getCurrentSelection(event));
		if (object == null) {
			Dialog.showInfo("Fault Tree Analysis", "Please choose an instance model");
			return IStatus.ERROR;
		}
		SystemInstance si = object.getSystemInstance();
		if (object instanceof ComponentInstance) {
			target = (ComponentInstance) object;
		} else {
			target = si;
		}

		if (!EMV2Util.hasComponentErrorBehaviorTransitions(target) && !EMV2Util.hasCompositeErrorBehavior(target)
				&& !EMV2Util.hasOutgoingPropagations(target)) {
			Dialog.showInfo("Fault Tree Analysis",
					"Your system instance or selected component instance must have outgoing propagations, error state transitions, or composite error states.");
			return IStatus.ERROR;
		}
		stateNames = new ArrayList<String>();
		for (ErrorPropagation outprop : EMV2Util.getAllOutgoingErrorPropagations(target.getComponentClassifier())) {
			EList<TypeToken> result = EMV2TypeSetUtil.flattenTypesetElements(outprop.getTypeSet());
			for (TypeToken tt : result) {
				String epName = CreateFTAModel.prefixOutgoingPropagation + EMV2Util.getPrintName(outprop)
						+ EMV2Util.getPrintName(tt);
				if (!stateNames.contains(epName)) {
					stateNames.add(epName);
				}
			}
		}
		Collection<ErrorBehaviorState> states = EMV2Util.getAllErrorBehaviorStates(target);
		if (!states.isEmpty()) {
			ErrorBehaviorState head = states.iterator().next();
			for (ErrorBehaviorState ebs : EMV2Util.getAllErrorBehaviorStates(target)) {
				if (ebs != head) {
					stateNames.add(CreateFTAModel.prefixState + EMV2Util.getPrintName(ebs));
				}
			}
			stateNames.add(CreateFTAModel.prefixState + EMV2Util.getPrintName(head));
		}
		if (stateNames.isEmpty()) {
			Dialog.showInfo("Fault Tree Analysis", "Selected system must have error states or error propagations");
			return IStatus.ERROR;
		}

		final Display d = PlatformUI.getWorkbench().getDisplay();
		d.syncExec(() -> {
			IWorkbenchWindow window;
			Shell sh;

			window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
			sh = window.getShell();

			FTADialog diag = new FTADialog(sh);
			diag.setValues(stateNames);
			diag.setTarget("'"
					+ (target instanceof SystemInstance ? target.getName() : target.getComponentInstancePath()) + "'");
			diag.open();
			ERROR_STATE_NAME = diag.getValue();
			FAULT_TREE_TYPE = diag.getFaultTreeType();
			GRAPHIC_VIEW = diag.isGraphicView();
		});

		if (ERROR_STATE_NAME != null) {
			if (FAULT_TREE_TYPE.equals(FaultTreeType.COMPOSITE_PARTS)
					&& ERROR_STATE_NAME.startsWith(CreateFTAModel.prefixOutgoingPropagation)) {
				Dialog.showInfo("Fault Tree Analysis", "Select error state for composite parts fault tree");
				return IStatus.ERROR;
			}
			if (FAULT_TREE_TYPE.equals(FaultTreeType.COMPOSITE_PARTS) && !EMV2Util.hasCompositeErrorBehavior(target)) {
				Dialog.showInfo("Fault Tree Analysis",
						"Selected system must have composite error states for composite parts fault tree analysis");
				return IStatus.ERROR;
			}
			FaultTree ftmodel = CreateFTAModel.createModel(target, ERROR_STATE_NAME, FAULT_TREE_TYPE);
			if (ftmodel == null) {
				Dialog.showInfo("Fault Tree Analysis",
						"No fault tree generated. Selected error propagation has no out propagation condition or path from an inner component");
				return IStatus.ERROR;
			}

			saveFaultTree(ftmodel);

			if (GRAPHIC_VIEW) {
				SiriusUtil.INSTANCE.autoOpenModel(ftmodel, ResourceUtil.getFile(si.eResource()).getProject(),
						"viewpoint:/org.osate.aadl2.errormodel.faulttree.design/FaultTree", "IconicFaultTree",
						"Fault Tree");
			} else {
				if (FAULT_TREE_TYPE.equals(FaultTreeType.MINIMAL_CUT_SET)) {
					SiriusUtil.INSTANCE.autoOpenModel(ftmodel, ResourceUtil.getFile(si.eResource()).getProject(),
							"viewpoint:/org.osate.aadl2.errormodel.faulttree.design/FaultTree", "MinimalCutSetTable",
							"Minimal Cutset");
				} else {
					SiriusUtil.INSTANCE.autoOpenModel(ftmodel, ResourceUtil.getFile(si.eResource()).getProject(),
							"viewpoint:/org.osate.aadl2.errormodel.faulttree.design/FaultTree", "FaultTreeTable",
							"Fault Tree");
				}
			}
			return Status.OK_STATUS;
		}

		return IStatus.ERROR;
	}

	private InstanceObject getTarget(ISelection currentSelection) {
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection iss = (IStructuredSelection) currentSelection;
			if (iss.size() == 1) {
				Object obj = iss.getFirstElement();
				if (obj instanceof InstanceObject) {
					return (InstanceObject) obj;
				}
				if (obj instanceof EObjectURIWrapper) {
					EObject eObject = new ResourceSetImpl().getEObject(((EObjectURIWrapper) obj).getUri(), true);
					if (eObject instanceof InstanceObject) {
						return (InstanceObject) eObject;
					}
				}
				if (obj instanceof IFile) {
					URI uri = OsateResourceUtil.toResourceURI((IFile) obj);
					Resource res = new ResourceSetImpl().getResource(uri, true);
					EList<EObject> rl = res.getContents();
					if (!rl.isEmpty()) {
						return (InstanceObject) rl.get(0);
					}
				}
			}
		}
		return null;
	}

	public URI saveFaultTree(FaultTree ftamodel) {
		URI ftaURI = EcoreUtil.getURI(ftamodel.getInstanceRoot()).trimFragment().trimFileExtension().trimSegments(1)
				.appendSegment("reports").appendSegment("fta").appendSegment(ftamodel.getName())
				.appendFileExtension("faulttree");
		AadlUtil.makeSureFoldersExist(new Path(ftaURI.toPlatformString(true)));
		Resource res = ftamodel.getInstanceRoot().eResource().getResourceSet().createResource(ftaURI);
		res.getContents().add(ftamodel);
		try {
			res.save(null);
		} catch (IOException e) {
			StatusManager.getManager().handle(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}
		return EcoreUtil.getURI(ftamodel);
	}

}
