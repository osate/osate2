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

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeType;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraphPath;
import org.osate.aadl2.errormodel.PropagationGraph.util.Util;
import org.osate.aadl2.errormodel.faulttree.generation.CreateFTAModel;
import org.osate.aadl2.errormodel.faulttree.util.SiriusUtil;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.ui.dialogs.Dialog;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EM2TypeSetUtil;
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
		PropagationGraph currentPropagationGraph = Util.generatePropagationGraph(target.getSystemInstance(), false);
		for (ErrorPropagation outprop : EMV2Util.getAllOutgoingErrorPropagations(target.getComponentClassifier())) {
			EList<PropagationGraphPath> paths = Util.getAllReversePropagationPaths(currentPropagationGraph, target,
					outprop);
			if (paths.isEmpty()) {
				if (EMV2Util.findOutgoingPropagationCondition(outprop, outprop) == null) {
					continue;
				}
			}
//			if (outprop.getFeatureorPPRef().getFeatureorPP() == null) {
//				// filter out binding points
//				continue;
//			}
			EList<TypeToken> result = EM2TypeSetUtil.flattenTypesetElements(outprop.getTypeSet(),
					EMV2Util.getUseTypes(outprop));
			for (TypeToken tt : result) {
				String epName = CreateFTAModel.prefixOutgoingPropagation + EMV2Util.getPrintName(outprop)
				+ EMV2Util.getPrintName(tt);
				if (!stateNames.contains(epName)) {
					stateNames.add(epName);
				}
			}
		}

		for (ErrorBehaviorState ebs : EMV2Util.getAllErrorBehaviorStates(target)) {
			if (ebs.getTypeSet() == null) {
				stateNames.add(CreateFTAModel.prefixState + EMV2Util.getPrintName(ebs));
			} else {
				EList<TypeToken> result = EM2TypeSetUtil.generateAllLeafTypeTokens(ebs.getTypeSet(),
						EMV2Util.getUseTypes(ebs));
				for (TypeToken tt : result) {
					String epName = CreateFTAModel.prefixState + EMV2Util.getPrintName(ebs) + EMV2Util.getPrintName(tt);
					if (!stateNames.contains(epName)) {
						stateNames.add(epName);
					}
				}
			}
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
			diag.setTarget(
					"'" + (target instanceof SystemInstance ? target.getName() : target.getComponentInstancePath())
					+ "'");
			diag.open();
			ERROR_STATE_NAME = diag.getValue();
			FAULT_TREE_TYPE = diag.getFaultTreeType();
			GRAPHIC_VIEW = diag.isGraphicView();
		});

		if (ERROR_STATE_NAME != null) {
			if (FAULT_TREE_TYPE.equals(FaultTreeType.COMPOSITE_PARTS)
					&& ERROR_STATE_NAME.startsWith(CreateFTAModel.prefixOutgoingPropagation)) {
				Dialog.showInfo("Fault Tree Analysis",
						"Select error state for composite parts fault tree");
				return IStatus.ERROR;
			}
			if (FAULT_TREE_TYPE.equals(FaultTreeType.COMPOSITE_PARTS)
					&& !EMV2Util.hasCompositeErrorBehavior(target)) {
				Dialog.showInfo("Fault Tree Analysis",
						"Selected system must have composite error states for composite parts fault tree analysis");
				return IStatus.ERROR;
			}
			FaultTree ftmodel = CreateFTAModel.createModel(target, ERROR_STATE_NAME, FAULT_TREE_TYPE);
				if (GRAPHIC_VIEW) {
				SiriusUtil.INSTANCE.autoOpenModel(ftmodel,
							ResourceUtil.getFile(si.eResource()).getProject(),
							"viewpoint:/org.osate.aadl2.errormodel.faulttree.design/FaultTree", "IconicFaultTree",
							"Fault Tree");
				} else {
					if (FAULT_TREE_TYPE.equals(FaultTreeType.MINIMAL_CUT_SET)) {
					SiriusUtil.INSTANCE.autoOpenModel(ftmodel,
								ResourceUtil.getFile(si.eResource()).getProject(),
								"viewpoint:/org.osate.aadl2.errormodel.faulttree.design/FaultTree",
								"MinimalCutSetTable", "Minimal Cutset");
					} else {
					SiriusUtil.INSTANCE.autoOpenModel(ftmodel,
								ResourceUtil.getFile(si.eResource()).getProject(),
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
				if (obj instanceof IFile) {
					Resource res = OsateResourceUtil.getResource((IResource) obj);
					EList<EObject> rl = res.getContents();
					if (!rl.isEmpty()) {
						return (InstanceObject) rl.get(0);
					}
				}
			}
		}
		return null;
	}

}
