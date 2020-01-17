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
package org.osate.aadl2.errormodel.faulttree.generation;

import static org.osate.result.util.ResultUtil.addRealValue;

import java.math.BigDecimal;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.FaultTree.Event;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeType;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph;
import org.osate.aadl2.errormodel.PropagationGraph.util.Util;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.result.ResultFactory;
import org.osate.result.util.ResultUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EMV2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;

public class CreateFTAModel {

	public static final String prefixState = "state ";
	public static final String prefixOutgoingPropagation = "outgoing propagation on ";

	public static FaultTree createFaultTree(ComponentInstance selection, final String startingPoint) {
		return createModel(selection, startingPoint, FaultTreeType.FAULT_TREE);
	}

	public static FaultTree createMinimalCutSet(ComponentInstance selection, final String startingPoint) {
		return createModel(selection, startingPoint, FaultTreeType.MINIMAL_CUT_SET);
	}

	public static FaultTree createFaultTrace(ComponentInstance selection, final String startingPoint) {
		return createModel(selection, startingPoint, FaultTreeType.FAULT_TRACE);
	}

	public static FaultTree createPartsFaultTree(ComponentInstance selection, final String startingPoint) {
		return createModel(selection, startingPoint, FaultTreeType.COMPOSITE_PARTS);
	}

	public static FaultTree createModel(ComponentInstance selection, final String startingPoint,
			FaultTreeType faultTreeType) {
		NamedElement errorStateOrPropagation=null;
		TypeToken errorType = null;

		if (startingPoint.startsWith(prefixState)) {
			String toProcess = startingPoint.replace(prefixState, "");
			for (ErrorBehaviorState ebs : EMV2Util.getAllErrorBehaviorStates(selection)) {
				if (ebs.getName().equalsIgnoreCase(toProcess)) {
					errorStateOrPropagation = ebs;
				}
			}

		}

		if (startingPoint.startsWith(prefixOutgoingPropagation)) {
			String toProcess = startingPoint.replace(prefixOutgoingPropagation, "");
			for (ErrorPropagation opc : EMV2Util.getAllOutgoingErrorPropagations(selection.getComponentClassifier())) {
				EList<TypeToken> result = EMV2TypeSetUtil.flattenTypesetElements(opc.getTypeSet());
				for (TypeToken tt : result) {
					String longName = EMV2Util.getPrintName(opc) + EMV2Util.getPrintName(tt);
					if (longName.equalsIgnoreCase(toProcess) && !tt.getType().isEmpty()) {
						errorStateOrPropagation = opc;
						errorType = tt;
					}
				}
			}
		}
		if (errorStateOrPropagation == null) {
			return null;
		}
		PropagationGraph currentPropagationGraph = Util.generatePropagationGraph(selection.getSystemInstance(), false);
		FTAGenerator generator = new FTAGenerator(currentPropagationGraph);
		FaultTree ftamodel = generator.getftaModel(selection, errorStateOrPropagation, errorType, faultTreeType);
		String rootname = ftamodel.getName() + (faultTreeType.equals(FaultTreeType.MINIMAL_CUT_SET) ? "_cutset"
				: (faultTreeType.equals(FaultTreeType.FAULT_TRACE) ? "_trace"
						: (faultTreeType.equals(FaultTreeType.COMPOSITE_PARTS) ? "_parts" : "_tree")));
		ftamodel.setName(rootname);
		return ftamodel;
	}

	// interface to ALISA returning Result format.

	public static AnalysisResult invokeFaultTree(ComponentInstance selection, final String startingPoint) {
		FaultTree ft = createFaultTree(selection, startingPoint);
		return createFTAAnalysisResult(selection, startingPoint, ft);
	}

	public static AnalysisResult invokePartsFaultTree(ComponentInstance selection, final String startingPoint) {
		FaultTree ft = createPartsFaultTree(selection, startingPoint);
		return createFTAAnalysisResult(selection, startingPoint, ft);
	}

	public static AnalysisResult createFTAAnalysisResult(EObject root, final String startingPoint, FaultTree ft) {
		AnalysisResult ftaResults = ResultUtil.createAnalysisResult("FTA", root);
		ResultUtil.addParameter(ftaResults, startingPoint);
		ftaResults.setModelElement(root);

		if (ft != null) {
			Result result = ResultFactory.eINSTANCE.createResult();
			ftaResults.getResults().add(result);
			result.setModelElement(root);
			result.setMessage("FTA occurrence probability results for " + ((InstanceObject) root).getName() + ":"
					+ startingPoint);
			Event rootevent = ft.getRoot();
			BigDecimal asP = rootevent.getAssignedProbability();
			BigDecimal coP = rootevent.getComputedProbability();
			if (coP == null) {
				addRealValue(result, 0.0);
			} else {
				addRealValue(result, coP.doubleValue());
			}
			if (asP == null) {
				addRealValue(result, 0.0);
			} else {
				addRealValue(result, asP.doubleValue());
			}
		} else {
			ftaResults.getResults().add(ResultUtil.createErrorResult("Fault tree analysis failed to run", root));
		}
		return ftaResults;
	}


}
