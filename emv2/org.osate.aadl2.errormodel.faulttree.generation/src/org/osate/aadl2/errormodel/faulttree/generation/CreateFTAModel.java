package org.osate.aadl2.errormodel.faulttree.generation;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.errormodel.FaultTree.FaultTree;
import org.osate.aadl2.errormodel.FaultTree.FaultTreeType;
import org.osate.aadl2.errormodel.PropagationGraph.PropagationGraph;
import org.osate.aadl2.errormodel.PropagationGraph.util.Util;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.util.EM2TypeSetUtil;
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
		ErrorTypes errorType =null;

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
				EList<TypeToken> result = EM2TypeSetUtil.flattenTypesetElements(opc.getTypeSet(),
						EMV2Util.getUseTypes(opc));
				for (TypeToken tt : result) {
					String longName = EMV2Util.getPrintName(opc) + EMV2Util.getPrintName(tt);
					if (longName.equalsIgnoreCase(toProcess) && !tt.getType().isEmpty()) {
						errorStateOrPropagation = opc;
						errorType = tt.getType().get(0);
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
		saveFaultTree(ftamodel);
		return ftamodel;
	}

	public static URI saveFaultTree(FaultTree ftamodel) {
		URI ftaURI = EcoreUtil.getURI(ftamodel.getInstanceRoot()).trimFragment().trimSegments(1)
				.appendSegment("reports").appendSegment("fta").appendSegment(ftamodel.getName() + ".faulttree");
		AadlUtil.makeSureFoldersExist(new Path(ftaURI.toPlatformString(true)));
		return OsateResourceUtil.saveEMFModel(ftamodel, ftaURI, ftamodel.getInstanceRoot());
	}

}
