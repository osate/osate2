package org.osate.analysis.flows;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.analysis.flows.model.LatencyContributor;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class FlowLatencyUtil {

	public static String getEndToEndFlowString(EndToEndFlowInstance etef) {
		StringBuffer ret;
		boolean firstPassed = false;

		ret = new StringBuffer();
		ret.append(etef.getName() + " : ");

		for (FlowElementInstance fei : etef.getFlowElements()) {
			if (firstPassed == true) {
				ret.append("->");
			}
			ret.append(fei.getName());
			firstPassed = true;
		}

		return ret.toString();
	}

	public static LatencyContributor mapFlowElementInstance(FlowElementInstance flowElementInstance) {
		LatencyContributor latencyContributor;
		latencyContributor = new LatencyContributor();
		OsateDebug.osateDebug("FlowLatencyUtil", "fei = " + flowElementInstance);
		OsateDebug.osateDebug("FlowLatencyUtil", "fei= name" + flowElementInstance.getName());

		if (flowElementInstance instanceof FlowSpecificationInstance) {
			FlowSpecificationInstance flowSpecification;
			ComponentInstance componentInstance;

			flowSpecification = (FlowSpecificationInstance) flowElementInstance;
			componentInstance = (ComponentInstance) flowElementInstance.getComponentInstance();
			return mapComponentInstance(flowElementInstance);
		}

		if (flowElementInstance instanceof ConnectionInstance) {
			return mapConnectionInstance(flowElementInstance);
		}

		return latencyContributor;
	}

	public static LatencyContributor mapComponentInstance(FlowElementInstance flowElementInstance) {
		LatencyContributor latencyContributor;
		FlowSpecificationInstance flowSpecification;

		ComponentInstance componentInstance;

		latencyContributor = new LatencyContributor();
		flowSpecification = (FlowSpecificationInstance) flowElementInstance;
		componentInstance = (ComponentInstance) flowElementInstance.getComponentInstance();

		OsateDebug.osateDebug("FlowLatencyUtil", "flowSpecification component=" + componentInstance.getName());

		return latencyContributor;
	}

	public static LatencyContributor mapConnectionInstance(FlowElementInstance flowElementInstance) {
		LatencyContributor latencyContributor;
		ConnectionInstance connectionInstance;
		ComponentInstance boundBus;

		latencyContributor = new LatencyContributor();

		connectionInstance = (ConnectionInstance) flowElementInstance;

		OsateDebug.osateDebug("FlowLatencyUtil", "flowSpecification connection=" + connectionInstance);

		boundBus = GetProperties.getBoundBus(connectionInstance);

		if (boundBus != null) {
			OsateDebug.osateDebug("FlowLatencyUtil", "connection bound to bus=" + boundBus);
		}

		return latencyContributor;
	}
}
