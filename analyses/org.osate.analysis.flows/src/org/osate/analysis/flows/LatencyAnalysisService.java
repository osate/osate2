package org.osate.analysis.flows;

import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.result.AnalysisResult;

public class LatencyAnalysisService {

	public AnalysisResult invoke(SystemInstance root) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch(root);
		return fla.invoke(root, null, true, true, true, true);
	}

	public AnalysisResult invoke(EndToEndFlowInstance etef) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch(etef.getSystemInstance());
		return fla.invoke(etef, null, true, true, true, true);
	}

	public AnalysisResult invoke(SystemInstance root, SystemOperationMode som) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch(root);
		return fla.invoke(root, som, true, true, true, true);
	}

	public AnalysisResult invoke(EndToEndFlowInstance etef, SystemOperationMode som) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch(etef.getSystemInstance());
		return fla.invoke(etef, som, true, true, true, true);
	}

}
