package org.osate.analysis.flows;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.analysis.flows.model.ConnectionType;
import org.osate.analysis.flows.model.LatencyContributor;
import org.osate.analysis.flows.model.LatencyContributor.LatencyContributorMethod;
import org.osate.analysis.flows.model.LatencyContributorComponent;
import org.osate.analysis.flows.model.LatencyContributorConnection;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class FlowLatencyLogicConnection {

	public static LatencyContributor mapConnectionInstance(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		LatencyContributor latencyContributor;
		LatencyContributor subContributor;
		ConnectionInstance connectionInstance;
		ComponentInstance boundBus;
		FlowElementInstance nextTaskOrDevice;
		Classifier relatedConnectionData;

		double maxBusTransferTime;
		double minBusTransferTime;
		double maxBusLatency;
		double minBusLatency;

		nextTaskOrDevice = FlowLatencyUtil.getNextTaskOrDevice(etef, flowElementInstance);

		connectionInstance = (ConnectionInstance) flowElementInstance;

		relatedConnectionData = FlowLatencyUtil.getConnectionData(connectionInstance);

		latencyContributor = new LatencyContributorConnection(connectionInstance);

//		OsateDebug.osateDebug("FlowLatencyUtil", "flowSpecification connection=" + connectionInstance);

		boundBus = GetProperties.getBoundBus(connectionInstance);

		if (boundBus != null&&relatedConnectionData!=null) {
//			OsateDebug.osateDebug("FlowLatencyUtil", "connection bound to bus=" + boundBus);
			maxBusLatency = GetProperties.getMaximumLatencyinMilliSec(boundBus);
			minBusLatency = GetProperties.getMinimumLatencyinMilliSec(boundBus);
			subContributor = new LatencyContributorComponent(boundBus);

			maxBusTransferTime = FlowLatencyUtil.getMaximumTimeToTransferData(boundBus, relatedConnectionData);
			minBusTransferTime = FlowLatencyUtil.getMinimumTimeToTransferData(boundBus, relatedConnectionData);

			subContributor.setMaximum(maxBusLatency);
			subContributor.setMinimum(minBusLatency);
			subContributor.setExpectedMaximum(maxBusLatency);
			subContributor.setExpectedMinimum(minBusLatency);

			if (maxBusLatency > 0) {
				subContributor.setWorstCaseMethod(LatencyContributorMethod.SPECIFIED);
				subContributor.setComments("Use the latency properties on the bus");
			} else {
				subContributor.setWorstCaseMethod(LatencyContributorMethod.UNKNOWN);
				subContributor.setComments("latency not specified on the bus");
			}

			if (minBusLatency > 0) {
				subContributor.setBestCaseMethod(LatencyContributorMethod.SPECIFIED);
				subContributor.setComments("Use the latency properties on the bus");
			} else {
				subContributor.setBestCaseMethod(LatencyContributorMethod.UNKNOWN);
				subContributor.setComments("latency not specified on the bus");
			}

			if (maxBusTransferTime > 0) {
				subContributor.setMaximum(maxBusTransferTime);
				subContributor.setComments("");
				subContributor.setWorstCaseMethod(LatencyContributorMethod.TRANSMISSION_TIME);
			}

			if (minBusTransferTime > 0) {
				subContributor.setMinimum(minBusTransferTime);
				subContributor.setComments("");
				subContributor.setBestCaseMethod(LatencyContributorMethod.TRANSMISSION_TIME);

			}

			latencyContributor.addSubContributor(subContributor);
		}

		if (FlowLatencyUtil.getConnectionType(connectionInstance) == ConnectionType.DELAYED) {
			/**
			 * We checked if the connection is local or not.
			 */
			if (FlowLatencyUtil.isLocal(connectionInstance)) {

				if (nextTaskOrDevice != null) {
					double period;
					period = GetProperties.getPeriodinMS(nextTaskOrDevice.getComponentInstance());
					latencyContributor.setWorstCaseMethod(LatencyContributorMethod.PERIOD);
					latencyContributor.setBestCaseMethod(LatencyContributorMethod.PERIOD);
					latencyContributor.setMaximum(period);
					latencyContributor.setMinimum(period);
					latencyContributor.setComments("The data will be available at the next task/device dispatch");
				}
			} else {
				if (nextTaskOrDevice != null) {
					double period;
					period = GetProperties.getPeriodinMS(nextTaskOrDevice.getComponentInstance());
					latencyContributor.setWorstCaseMethod(LatencyContributorMethod.PERIOD);
					latencyContributor.setBestCaseMethod(LatencyContributorMethod.PERIOD);
					latencyContributor.setMaximum(period);
					latencyContributor.setMinimum(0.0);
					latencyContributor.setComments("Data might arrive at dispatch time or next frame");
				}
			}

		}

		if (FlowLatencyUtil.getConnectionType(connectionInstance) == ConnectionType.SAMPLED) {
			/**
			 * We checked if the connection is local or not.
			 */
			if (FlowLatencyUtil.isLocal(connectionInstance)) {

				if (nextTaskOrDevice != null) {
					double period;
					period = GetProperties.getPeriodinMS(nextTaskOrDevice.getComponentInstance());
					latencyContributor.setWorstCaseMethod(LatencyContributorMethod.PERIOD);
					latencyContributor.setBestCaseMethod(LatencyContributorMethod.PERIOD);
					latencyContributor.setMaximum(period);
					latencyContributor.setMinimum(period);
					latencyContributor.setComments("The data will be available at the next task/device dispatch");
				}
			} else {
				if (nextTaskOrDevice != null) {
					double period;
					period = GetProperties.getPeriodinMS(nextTaskOrDevice.getComponentInstance());
					latencyContributor.setWorstCaseMethod(LatencyContributorMethod.PERIOD);
					latencyContributor.setBestCaseMethod(LatencyContributorMethod.PERIOD);
					latencyContributor.setMaximum(period);
					latencyContributor.setMinimum(0.0);
					latencyContributor.setComments("Data might arrive at dispatch time or next frame");
				}
			}
		}

		return latencyContributor;
	}
}
