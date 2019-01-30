package org.osate.analysis.flows;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.result.AnalysisResult;

@Deprecated
public class LatencyAnalysisService {
	// use methods defined in FlowLatencyAnalysisSwitch

	public AnalysisResult invoke(ComponentInstance ci) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		return fla.invoke(ci, null, true, true, true, true);
	}

	public AnalysisResult invoke(SystemInstance si) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		return fla.invoke(si, null, true, true, true, true);
	}

	public AnalysisResult invoke(EndToEndFlowInstance etef) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		return fla.invoke(etef, null, true, true, true, true);
	}

	public AnalysisResult invoke(ComponentInstance ci, SystemOperationMode som) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		return fla.invoke(ci, som, true, true, true, true);
	}

	public AnalysisResult invoke(SystemInstance si, SystemOperationMode som) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		return fla.invoke(si, som, true, true, true, true);
	}

	public AnalysisResult invoke(EndToEndFlowInstance etef, SystemOperationMode som) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		return fla.invoke(etef, som, true, true, true, true);
	}

	public AnalysisResult invoke(SystemInstance si, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		return fla.invoke(si, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
				bestCaseEmptyQueue);
	}

	public AnalysisResult invoke(ComponentInstance ci, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		return fla.invoke(ci, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
				bestCaseEmptyQueue);
	}

	public AnalysisResult invoke(EndToEndFlowInstance etei, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		FlowLatencyAnalysisSwitch fla = new FlowLatencyAnalysisSwitch();
		return fla.invoke(etei, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
				bestCaseEmptyQueue);
	}

}
