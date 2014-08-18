package org.osate.analysis.flows;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.analysis.flows.model.ConnectionType;
import org.osate.analysis.flows.model.LatencyContributor;
import org.osate.analysis.flows.model.LatencyContributor.LatencyContributorMethod;
import org.osate.analysis.flows.model.LatencyContributorComponent;
import org.osate.analysis.flows.model.LatencyContributorConnection;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class FlowLatencyLogicConnection {

	/**
	 * Get the component that is connected at the source side of the connection.
	 * @param connectionInstance - the connection to process
	 * @return - the component that is the source
	 */
	public static ComponentInstance getRelatedComponentSource(ConnectionInstance connectionInstance) {
		ConnectionInstanceEnd sourceEnd;
		ComponentInstance source;

		source = null;
		sourceEnd = connectionInstance.getSource();

		if ((sourceEnd.getContainingComponentInstance() != null)
				&& (sourceEnd.getContainingComponentInstance() != null)) {
			source = sourceEnd.getContainingComponentInstance();
		}
		return source;
	}

	/**
	 * Get the component that is connected at the destination side of the connection.
	 * @param connectionInstance - the connection to be processed
	 * @return - the component that is the connection destination (and not its feature)
	 */
	public static ComponentInstance getRelatedComponentDestination(ConnectionInstance connectionInstance) {
		ConnectionInstanceEnd destinationEnd;
		ComponentInstance destination;

		destination = null;
		destinationEnd = connectionInstance.getSource();

		if ((destinationEnd.getContainingComponentInstance() != null)
				&& (destinationEnd.getContainingComponentInstance() != null)) {
			destination = destinationEnd.getContainingComponentInstance();
		}
		return destination;
	}

	/**
	 * Get the list of all the buses a process can access through its required
	 * bus access features.
	 * @param processor - the processor that has bus access features
	 * @return - the list of all bus components that can be access by the processor.
	 */
	public static List<ComponentInstance> getAccessedBuses(ComponentInstance processor) {
		List<ComponentInstance> buses;
		List<ConnectionInstance> connections;
		ConnectionInstanceEnd cie;

		buses = new ArrayList<ComponentInstance>();
		connections = new ArrayList<ConnectionInstance>();

		for (FeatureInstance fi : processor.getFeatureInstances()) {
			if (fi.getCategory() == FeatureCategory.BUS_ACCESS) {
				connections.addAll(fi.getSrcConnectionInstances());
				connections.addAll(fi.getDstConnectionInstances());

				for (ConnectionInstance ci : connections) {
					cie = ci.getSource();
//					OsateDebug.osateDebug("FlowLatencyLogicConnection", "cie=" + cie);

					cie = ci.getDestination();
					if (cie instanceof ComponentInstance) {
						if (((ComponentInstance) cie).getCategory() == ComponentCategory.BUS) {
							buses.add((ComponentInstance) cie);
						}
					}
//					OsateDebug.osateDebug("FlowLatencyLogicConnection", "cie=" + cie);
				}
			}
		}
		return buses;
	}

	public static ComponentInstance getBus(ConnectionInstance connectionInstance) {
		ComponentInstance boundBus;
		ComponentInstance processorSource;
		ComponentInstance processorDestination;
		List<ComponentInstance> accessedBusesSource;
		List<ComponentInstance> accessedBusesDestination;

		if (FlowLatencyUtil.isLocal(connectionInstance)) {
			return null;
		}

		boundBus = GetProperties.getBoundBus(connectionInstance);

		/**
		 * if boundBus == null and the connection is NOT local, we try to find the
		 * bus by browsing the processor bus access features. If we find a bus
		 * we use it.
		 */
		processorSource = FlowLatencyUtil.getProcessorForProcessOrThread(getRelatedComponentSource(connectionInstance));
		processorDestination = FlowLatencyUtil
				.getProcessorForProcessOrThread(getRelatedComponentDestination(connectionInstance));

		if ((processorSource != null) && (processorDestination != null)) {
			accessedBusesSource = getAccessedBuses(processorSource);
			accessedBusesDestination = getAccessedBuses(processorDestination);

			for (ComponentInstance busSource : accessedBusesSource) {
				for (ComponentInstance busDestination : accessedBusesDestination) {
					if (busSource == busDestination) {
						boundBus = busSource;
					}
				}
			}
		}

		return (boundBus);
	}

	/**
	 * Main function, transform the connection instance into a latency contributor
	 * object. 
	 * @param etef - the end to end flow being analyzed
	 * @param flowElementInstance - the flow element that represents the connection to be processed.
	 * @return - the latency contributor object that maps the connection
	 */
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

		boundBus = getBus(connectionInstance);

		if (boundBus != null && relatedConnectionData != null) {
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
