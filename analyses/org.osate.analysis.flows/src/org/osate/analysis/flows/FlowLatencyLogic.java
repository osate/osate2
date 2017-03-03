package org.osate.analysis.flows;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.analysis.flows.model.LatencyReportEntry;

public class FlowLatencyLogic {

	public static void mapFlowElementInstance(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance, LatencyReportEntry entry) {

		if (flowElementInstance instanceof FlowSpecificationInstance
				|| flowElementInstance instanceof ComponentInstance) {

			FlowLatencyLogicComponent.mapComponentInstance(etef, flowElementInstance, entry);
		}

		if (flowElementInstance instanceof ConnectionInstance) {
			FlowLatencyLogicConnection.mapConnectionInstance(etef, flowElementInstance, entry);
		}

		if (flowElementInstance instanceof EndToEndFlowInstance) {

			for (FlowElementInstance fei : ((EndToEndFlowInstance) flowElementInstance).getFlowElements()) {
				FlowLatencyLogic.mapFlowElementInstance(etef, fei, entry);
			}
		}

	}

}
