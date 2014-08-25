package org.osate.analysis.flows;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
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
import org.osate.analysis.flows.preferences.Constants.PartitioningPolicy;
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
		destinationEnd = connectionInstance.getDestination();

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

	/**
	 * Get the bus for a connection. If the bus is not found, we try
	 * to get the bus by inspecting the component bound (processor)
	 * to each part of the connection (thread/process/device).
	 * 
	 * If the connection is directly bound to a bus through the property
	 * mechanism, we automatically return it.
	 * 
	 * @param connectionInstance - the connection instance
	 * @return the bus bound to the connection.
	 */
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
		processorSource = FlowLatencyUtil.getProcessorForProcessOrThread(getRelatedComponentSource(connectionInstance),
				ComponentCategory.PROCESSOR);
		processorDestination = FlowLatencyUtil.getProcessorForProcessOrThread(
				getRelatedComponentDestination(connectionInstance), ComponentCategory.PROCESSOR);

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
		ConnectionInstance connectionInstance;
		ComponentInstance componentInstanceSource;
		ComponentInstance componentInstanceDestination;
		ComponentInstance partitionSource;
		ComponentInstance partitionDestination;
		FlowElementInstance nextTaskOrDevice;
		ComponentInstance boundBus;
		Classifier relatedConnectionData;

		double maxBusTransferTime;
		double minBusTransferTime;
		double maxBusLatency;
		double minBusLatency;
		double partitionLatency;

		nextTaskOrDevice = FlowLatencyUtil.getNextTaskOrDevice(etef, flowElementInstance);
		connectionInstance = (ConnectionInstance) flowElementInstance;
		relatedConnectionData = FlowLatencyUtil.getConnectionData(connectionInstance);
		latencyContributor = new LatencyContributorConnection(connectionInstance);
		componentInstanceSource = getRelatedComponentSource(connectionInstance);
		componentInstanceDestination = getRelatedComponentDestination(connectionInstance);
//		OsateDebug.osateDebug("FlowLatencyUtil", "flowSpecification connection=" + connectionInstance);

		boundBus = getBus(connectionInstance);
		partitionLatency = 0;

		/**
		 * Check if the connection is bound to a bus. If yes, then, we add
		 * the bus transmission time as a contributor.
		 */
		if (boundBus != null && relatedConnectionData != null) {
//			OsateDebug.osateDebug("FlowLatencyUtil", "connection bound to bus=" + boundBus);
			LatencyContributor subContributor;
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

		/**
		 * 
		 */
		List<ComponentClassifier> protocols = GetProperties.getRequiredVirtualBusClass(connectionInstance);
		if ((protocols != null) && (protocols.size() > 0)) {
			double protocolLatencyMinimum;
			double protocolLatencyMaximum;

			for (ComponentClassifier cc : protocols) {

				protocolLatencyMinimum = GetProperties.getMinimumLatencyinMilliSec(cc);
				protocolLatencyMaximum = GetProperties.getMaximumLatencyinMilliSec(cc);

				LatencyContributor subContributor = new LatencyContributorComponent(cc);
				subContributor.setBestCaseMethod(LatencyContributorMethod.SPECIFIED);
				subContributor.setWorstCaseMethod(LatencyContributorMethod.SPECIFIED);
				subContributor.setMaximum(protocolLatencyMaximum);
				subContributor.setMinimum(protocolLatencyMinimum);
				subContributor.setComments("Time required by the protocol stack");
				latencyContributor.addSubContributor(subContributor);
			}
		}

		/**
		 * If the sender is on a partitioned architecture, then, we might need to add
		 * We do that only if the preferences selected an major frame delayed flush policy.
		 */
		if (org.osate.analysis.flows.preferences.Values.getPartitioningPolicy() == PartitioningPolicy.DELAYED) {
			/**
			 * Additional time to send/receive data. Here, we handle the case of the partition source.
			 */
			partitionSource = FlowLatencyUtil.getProcessorForProcessOrThread(componentInstanceSource,
					ComponentCategory.VIRTUAL_PROCESSOR);
			if (partitionSource != null) {
				/**
				 * First, we try to find the latency based on the partition schedule declared
				 * in the module.
				 */
				partitionLatency = FlowLatencyUtil.getPartitionSenderLatencyWithSchedule(partitionSource);
				if (partitionLatency > 0) {
					LatencyContributor subContributor = new LatencyContributorComponent(partitionSource);
					subContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
					subContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
					subContributor.setMaximum(partitionLatency);
					subContributor.setMinimum(partitionLatency);
					subContributor
							.setComments("Time to send the data and wait for the major frame flush based on the module schedule");
					latencyContributor.addSubContributor(subContributor);
				} else {
					/**
					 * if there is no partition schedule declared, we fall back on the major frame value.
					 */
					partitionLatency = GetProperties.getARINC653ModuleMajorFrame(FlowLatencyUtil
							.getProcessorForProcessOrThread(componentInstanceSource, ComponentCategory.PROCESSOR));
					if (partitionLatency > 0) {
						LatencyContributor subContributor = new LatencyContributorComponent(partitionSource);
						subContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
						subContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
						subContributor.setMaximum(partitionLatency);
						subContributor.setMinimum(partitionLatency);
						subContributor
								.setComments("Time to receive the data once data ports are flushed based on the module schedule");
						latencyContributor.addSubContributor(subContributor);
					}
				}
			}

			/**
			 * Additional time to send/receive data. Here, we handle the case of the partition destination.
			 */
			partitionDestination = FlowLatencyUtil.getProcessorForProcessOrThread(componentInstanceDestination,
					ComponentCategory.VIRTUAL_PROCESSOR);
			if (partitionDestination != null) {
				/**
				 * First, we try to find the latency based on the partition schedule declared
				 * in the module.
				 */
				partitionLatency = FlowLatencyUtil.getPartitionReceiverLatencyWithSchedule(partitionDestination);
				if (partitionLatency > 0) {
					LatencyContributor subContributor = new LatencyContributorComponent(partitionDestination);
					subContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
					subContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
					subContributor.setMaximum(partitionLatency);
					subContributor.setMinimum(partitionLatency);
					subContributor.setComments("Time to receive the data based on the module schedule");
					latencyContributor.addSubContributor(subContributor);
				} else {
					/**
					 * if there is no partition schedule declared, we fall back on the major frame value.
					 */
					partitionLatency = GetProperties.getARINC653ModuleMajorFrame(FlowLatencyUtil
							.getProcessorForProcessOrThread(componentInstanceSource, ComponentCategory.PROCESSOR));
					if (partitionLatency > 0) {
						LatencyContributor subContributor = new LatencyContributorComponent(partitionDestination);
						subContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
						subContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
						subContributor.setMaximum(partitionLatency);
						subContributor.setMinimum(partitionLatency);
						subContributor
								.setComments("Time to receive the data once data ports are flushed based on the module schedule");
						latencyContributor.addSubContributor(subContributor);
					}
				}
			}
		}

		/**
		 * Compute the main latency of the connection according to its type: delayed, sampled or immediate.
		 */
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
					latencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED);
					latencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED);
					latencyContributor.setMaximum(period);
					latencyContributor.setMinimum(period);
					latencyContributor.setComments("The data will be available at the next task/device dispatch");
				}
			} else {
				if (nextTaskOrDevice != null) {
					double period;
					period = GetProperties.getPeriodinMS(nextTaskOrDevice.getComponentInstance());
					latencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED);
					latencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED);
					latencyContributor.setMaximum(period);
					latencyContributor.setMinimum(0.0);
					latencyContributor.setComments("Data might arrive at dispatch time or next frame");
				}
			}
		}

		return latencyContributor;
	}

}
