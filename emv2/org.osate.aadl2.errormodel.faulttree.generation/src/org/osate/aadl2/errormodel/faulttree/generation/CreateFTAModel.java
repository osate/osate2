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
