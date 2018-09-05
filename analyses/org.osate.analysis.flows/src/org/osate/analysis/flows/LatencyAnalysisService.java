package org.osate.analysis.flows;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;

public class LatencyAnalysisService {

	public AnalysisResult invoke(ComponentInstance ci) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		EList<Result> results = fla.invoke(ci, null, true, true, true, true);
		return FlowLatencyUtil.recordAsAnalysisResult(results, ci, true, true, true, true);
	}

	public AnalysisResult invoke(SystemInstance si) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		EList<Result> results = fla.invoke(si, null, true, true, true, true);
		return FlowLatencyUtil.recordAsAnalysisResult(results, si, true, true, true, true);
	}

	public AnalysisResult invoke(EndToEndFlowInstance etef) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		EList<Result> results = fla.invoke(etef, null, true, true, true, true);
		return FlowLatencyUtil.recordAsAnalysisResult(results, etef, true, true, true, true);
	}

	public AnalysisResult invoke(ComponentInstance ci, SystemOperationMode som) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		EList<Result> results = fla.invoke(ci, som, true, true, true, true);
		return FlowLatencyUtil.recordAsAnalysisResult(results, ci, true, true, true, true);
	}

	public AnalysisResult invoke(SystemInstance si, SystemOperationMode som) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		EList<Result> results = fla.invoke(si, som, true, true, true, true);
		return FlowLatencyUtil.recordAsAnalysisResult(results, si, true, true, true, true);
	}

	public AnalysisResult invoke(EndToEndFlowInstance etef, SystemOperationMode som) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		EList<Result> results = fla.invoke(etef, som, true, true, true, true);
		return FlowLatencyUtil.recordAsAnalysisResult(results, etef, true, true, true, true);
	}

}
