package org.osate.analysis.flows;

import java.util.List;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.analysis.flows.model.LatencyContributor;
import org.osate.analysis.flows.model.LatencyContributor.LatencyContributorMethod;
import org.osate.analysis.flows.model.LatencyContributorComponent;
import org.osate.analysis.flows.model.LatencyContributorConnection;
import org.osate.analysis.flows.model.LatencyReportEntry;
import org.osate.analysis.flows.preferences.Constants.PartitioningPolicy;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class FlowLatencyLogicConnection {

	/**
	 * Main function, transform the connection instance into a latency contributor
	 * object. 
	 * @param etef - the end to end flow being analyzed
	 * @param flowElementInstance - the flow element that represents the connection to be processed.
	 * @return - the latency contributor object that maps the connection
	 */
	public static void mapConnectionInstance(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance, LatencyReportEntry entry) {
		LatencyContributor latencyContributor;
		ConnectionInstance connectionInstance;
		ComponentInstance componentInstanceSource;
		ComponentInstance componentInstanceDestination;
		ComponentInstance partitionSource;
		ComponentInstance partitionDestination;
		Classifier relatedConnectionData;
		double partitionLatency;

//		nextTaskOrDevice = FlowLatencyUtil.getNextTaskOrDevice(etef, flowElementInstance);
		connectionInstance = (ConnectionInstance) flowElementInstance;

		double expectedMin = GetProperties.getMinimumLatencyinMilliSec(flowElementInstance);
		double expectedMax = GetProperties.getMaximumLatencyinMilliSec(flowElementInstance);

		relatedConnectionData = FlowLatencyUtil.getConnectionData(connectionInstance);
		componentInstanceSource = FlowLatencyUtil.getRelatedComponentSource(connectionInstance);
		componentInstanceDestination = FlowLatencyUtil.getRelatedComponentDestination(connectionInstance);

		partitionLatency = 0;

		latencyContributor = new LatencyContributorConnection(connectionInstance);

		processActualConnectionBindings(connectionInstance, relatedConnectionData, latencyContributor);

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
		 * handle the case when there is no binding to virtual bus or bus.
		 * In this case we use the latency from the connection itself
		 */
		// XXX we can add a check whether the latencies coming from the bindings exceeds the connection latency

		if (latencyContributor.getSubContributors().isEmpty()) {
			if (expectedMax > 0) {
				latencyContributor.setWorstCaseMethod(LatencyContributorMethod.SPECIFIED);
				latencyContributor.setExpectedMaximum(expectedMax);
			}
			if (expectedMin > 0) {
				latencyContributor.setBestCaseMethod(LatencyContributorMethod.SPECIFIED);
				latencyContributor.setExpectedMinimum(expectedMin);
			}
		}

		entry.addContributor(latencyContributor);
	}

	public static void processBoundBus(ComponentInstance boundBus, Classifier relatedConnectionData,
			LatencyContributor latencyContributor) {
		/**
		 * we add the bus transmission time as a contributor.
		 */

		// XXX: dealing with a periodic bus that samples or bus queuing delay
		// a bus has a period value when operating periodically.
		// we then add sampling latency for the bus
		// need to do that before the transmission latency
		if (boundBus != null && relatedConnectionData != null) {
//			OsateDebug.osateDebug("FlowLatencyUtil", "connection bound to bus=" + boundBus);
			LatencyContributor subContributor = new LatencyContributorComponent(boundBus);

			double maxBusLatency = GetProperties.getMaximumLatencyinMilliSec(boundBus);
			double minBusLatency = GetProperties.getMinimumLatencyinMilliSec(boundBus);

			double maxBusTransferTime = FlowLatencyUtil.getMaximumTimeToTransferData(boundBus, relatedConnectionData);
			double minBusTransferTime = FlowLatencyUtil.getMinimumTimeToTransferData(boundBus, relatedConnectionData);
			subContributor.setExpectedMaximum(maxBusLatency);
			subContributor.setExpectedMinimum(minBusLatency);

			if (maxBusTransferTime > 0) {
				subContributor.setMaximum(maxBusTransferTime);
				subContributor.setComments("Data transfer time");
				subContributor.setWorstCaseMethod(LatencyContributorMethod.TRANSMISSION_TIME);
			} else if (maxBusLatency > 0) {
				subContributor.setMaximum(maxBusLatency);
				subContributor.setWorstCaseMethod(LatencyContributorMethod.SPECIFIED);
				subContributor.setComments("Use the latency properties on the bus");
			} else {
				subContributor.setWorstCaseMethod(LatencyContributorMethod.UNKNOWN);
				subContributor.setComments("latency not specified on the bus");
			}

			if (minBusTransferTime > 0) {
				subContributor.setMinimum(minBusTransferTime);
				subContributor.setComments("Data transfer time");
				subContributor.setBestCaseMethod(LatencyContributorMethod.TRANSMISSION_TIME);

			} else if (minBusLatency > 0) {
				subContributor.setMinimum(minBusLatency);
				subContributor.setBestCaseMethod(LatencyContributorMethod.SPECIFIED);
				subContributor.setComments("Use the latency properties on the bus");
			} else {
				subContributor.setBestCaseMethod(LatencyContributorMethod.UNKNOWN);
				subContributor.setComments("latency not specified on the bus");
			}

			latencyContributor.addSubContributor(subContributor);
		}

	}

	public static void processVirtualBus(NamedElement vb, Classifier relatedConnectionData,
			LatencyContributor latencyContributor) {
		double protocolLatencyMinimum = GetProperties.getMinimumLatencyinMilliSec(vb);
		double protocolLatencyMaximum = GetProperties.getMaximumLatencyinMilliSec(vb);

		LatencyContributor subContributor = new LatencyContributorComponent(vb);
		subContributor.setBestCaseMethod(LatencyContributorMethod.SPECIFIED);
		subContributor.setWorstCaseMethod(LatencyContributorMethod.SPECIFIED);
		subContributor.setMaximum(protocolLatencyMaximum);
		subContributor.setMinimum(protocolLatencyMinimum);
		subContributor.setExpectedMaximum(protocolLatencyMaximum);
		subContributor.setExpectedMinimum(protocolLatencyMinimum);
		subContributor.setComments("Time required by the protocol stack");
		latencyContributor.addSubContributor(subContributor);
		processActualConnectionBindings(vb, relatedConnectionData, latencyContributor);
	}

	public static void processActualConnectionBindings(NamedElement connorvb, Classifier relatedConnectionData,
			LatencyContributor latencyContributor) {
		boolean didVirtualBuses = false;

		if (connorvb instanceof InstanceObject) {
			// look for actual binding if we have a connection instance or virtual bus instance
			List<ComponentInstance> bindings = GetProperties.getActualConnectionBinding((InstanceObject) connorvb);
			for (ComponentInstance componentInstance : bindings) {
				ComponentCategory cat = componentInstance.getCategory();
				if (cat.equals(ComponentCategory.BUS) || cat.equals(ComponentCategory.SYSTEM)
						|| cat.equals(ComponentCategory.ABSTRACT)) {
					/**
					 * Check if the connection is bound to a bus. If yes, then, we add
					 * the bus transmission time as a contributor.
					 */
					// XXX we can add knowledge about protocol overhead to be added to the data size
					processBoundBus(componentInstance, relatedConnectionData, latencyContributor);
				}
				if (componentInstance.getCategory().equals(ComponentCategory.VIRTUAL_BUS)) {
					didVirtualBuses = true;
					processVirtualBus(componentInstance, relatedConnectionData, latencyContributor);
				}
			}
		}

		/**
		 * required virtual bus class indicates protocols the connection intends to use.
		 * We also can have an actual connection binding to a virtual bus
		 * If we have that we want to use that virtual bus overhead
		 */
		if (!didVirtualBuses) {
			List<ComponentClassifier> protocols = GetProperties.getRequiredVirtualBusClass(connorvb);
			if ((protocols != null) && (protocols.size() > 0)) {
				for (ComponentClassifier cc : protocols) {
					processVirtualBus(cc, relatedConnectionData, latencyContributor);
				}
			}
		}
	}

}
