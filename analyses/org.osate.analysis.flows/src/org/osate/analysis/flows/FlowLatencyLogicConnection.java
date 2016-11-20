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
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

public class FlowLatencyLogicConnection {

	/**
	 * Main function, transform the connection instance into a latency contributor
	 * object. 
	 * @param etef - the end to end flow being analyzed
	 * @param flowElementInstance - the flow element that represents the connection to be processed.
	 * @param entry LatencyReportEntry to be added to
	 */
	public static void mapConnectionInstance(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance, LatencyReportEntry entry) {
		ConnectionInstance connectionInstance = (ConnectionInstance) flowElementInstance;

		double expectedMin = GetProperties.getMinimumLatencyinMilliSec(flowElementInstance);
		double expectedMax = GetProperties.getMaximumLatencyinMilliSec(flowElementInstance);

		Classifier relatedConnectionData = FlowLatencyUtil.getConnectionData(connectionInstance);
		ComponentInstance componentInstanceSource = InstanceModelUtil.getRelatedComponentSource(connectionInstance);
		ComponentInstance componentInstanceDestination = InstanceModelUtil
				.getRelatedComponentDestination(connectionInstance);

		ComponentInstance srcHW = InstanceModelUtil.getHardwareComponent(componentInstanceSource);
		ComponentInstance dstHW = InstanceModelUtil.getHardwareComponent(componentInstanceDestination);
		ComponentInstance srcPartition = FlowLatencyUtil.getPartition(componentInstanceSource);
		ComponentInstance dstPartition = FlowLatencyUtil.getPartition(componentInstanceDestination);

		// if we exit a partition then we may have I/O Delay until the end of the partition window or the end of the major frame
		if (srcPartition != null && srcPartition != dstPartition) {
			LatencyContributor ioLatencyContributor = new LatencyContributorComponent(srcPartition);
			ioLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_OUTPUT);
			ioLatencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_OUTPUT);
			double partitionLatency = FlowLatencyUtil.getPartitionLatency(srcPartition);
			double frameOffset = FlowLatencyUtil.getPartitionFrameOffset(srcPartition);
			double partitionDuration = FlowLatencyUtil.getPartitionDuration(srcPartition);
			ioLatencyContributor.setSamplingPeriod(partitionLatency);
			ioLatencyContributor.setPartitionOffset(frameOffset);
			ioLatencyContributor.setPartitionDuration(partitionDuration);
			entry.addContributor(ioLatencyContributor);
		}

		// now we deal with communication latency
		LatencyContributor latencyContributor = new LatencyContributorConnection(connectionInstance);

		processActualConnectionBindingsSampling(connectionInstance, relatedConnectionData, latencyContributor);
		processActualConnectionBindingsTransmission(connectionInstance, relatedConnectionData, latencyContributor);
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
		} else {
			latencyContributor.reportInfo("Adding latency subtotal from protocols and bus - shown with ()");
		}
		// set synchronous if on same processor
		if (srcHW != null && dstHW != null) {
			// we have two hardware components. One or both could be a device
			ComponentInstance srcTime = GetProperties.getReferenceTime(srcHW);
			ComponentInstance dstTime = GetProperties.getReferenceTime(dstHW);
			if (srcHW == dstHW) {
				latencyContributor.setSynchronous();
			} else if (srcTime != null && dstTime != null) {
				if (srcTime == dstTime) {
					latencyContributor.setSynchronous();
				} else {
					latencyContributor.setAsynchronous();
				}
			} else {
				latencyContributor.setSyncUnknown();
			}
		} else {
			// at least one end is not bound to a hardware component
			// set synchronous if in same partition. This may be the case if the partitions are not bound yet to a processor
			if (dstPartition != null && srcPartition != null) {
				if (srcPartition == dstPartition) {
					latencyContributor.setSynchronous();
				} else {
					// no else part: partitions are unbound so we want to have both a sync and async analysis
					latencyContributor.setSyncUnknown();
				}
			}
		}
		entry.addContributor(latencyContributor);

		// now deal with cross partition sampling latency
		// We add a separate latency contributor

		if (dstPartition != null && srcPartition != dstPartition) {
			// add partition latency if the destination is a partition and it is different from the source partition (or null)
			double partitionLatency = FlowLatencyUtil.getPartitionLatency(dstPartition);
			double frameOffset = FlowLatencyUtil.getPartitionFrameOffset(dstPartition);
			if (frameOffset != -1) {
				LatencyContributorComponent platencyContributor = new LatencyContributorComponent(dstPartition);
				platencyContributor.setSamplingPeriod(partitionLatency);
				platencyContributor.setPartitionOffset(frameOffset);
				double partitionDuration = FlowLatencyUtil.getPartitionDuration(dstPartition);
				platencyContributor.setPartitionDuration(partitionDuration);
				platencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
				platencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
				entry.addContributor(platencyContributor);
			} else {
				LatencyContributorComponent platencyContributor = new LatencyContributorComponent(dstPartition);
				platencyContributor.setSamplingPeriod(partitionLatency);
				platencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
				platencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
				entry.addContributor(platencyContributor);
			}
		}
	}

	public static void checkPartitionLatencyConsistency(ComponentInstance ci) {
		double res = 0.0;
		if (GetProperties.getIsPartition(ci)) {
			res = GetProperties.getPartitionLatencyInMilliSec(ci, 0.0);
		}
		double VPres = FlowLatencyUtil.getVirtualProcessorPartitionPeriod(ci);
		double ARINC653res = FlowLatencyUtil.getARINC653ProcessorMajorFrame(ci);
		if (res > 0.0 && VPres > 0.0) {
			// TODO they should be the same
		}
		if (res > 0.0 && ARINC653res > 0.0) {
			// TODO they should be the same
		}
		if (VPres > 0.0 && ARINC653res > 0.0) {
			// TODO they should be the same
		}
		// TODO also compare major frame from schedule against major frame from property of processor
	}

	public static void processTransmissionTime(NamedElement boundBus, Classifier relatedConnectionData,
			LatencyContributor latencyContributor) {
		/**
		 * we add the bus/VB transmission time as a subcontributor.
		 */

		if (boundBus != null) {

			LatencyContributor subContributor = new LatencyContributorComponent(boundBus);

			double maxBusLatency = GetProperties.getMaximumLatencyinMilliSec(boundBus);
			double minBusLatency = GetProperties.getMinimumLatencyinMilliSec(boundBus);
			subContributor.setExpectedMaximum(maxBusLatency);
			subContributor.setExpectedMinimum(minBusLatency);
			double maxBusTransferTime = 0.0;
			double minBusTransferTime = 0.0;
			if (relatedConnectionData != null) {
				maxBusTransferTime = GetProperties.getMaximumTimeToTransferData(boundBus, relatedConnectionData);
				minBusTransferTime = GetProperties.getMinimumTimeToTransferData(boundBus, relatedConnectionData);
			}
			if (maxBusTransferTime > 0) {
				subContributor.setMaximum(maxBusTransferTime);
				subContributor.reportInfo("Using data transfer time");
				subContributor.setWorstCaseMethod(LatencyContributorMethod.TRANSMISSION_TIME);
			} else if (maxBusLatency > 0) {
				subContributor.setMaximum(maxBusLatency);
				subContributor.setWorstCaseMethod(LatencyContributorMethod.SPECIFIED);
				subContributor.reportInfo("Using specified bus latency");
			} else {
				subContributor.setWorstCaseMethod(LatencyContributorMethod.UNKNOWN);
			}

			if (minBusTransferTime > 0) {
				subContributor.setMinimum(minBusTransferTime);
				subContributor.setBestCaseMethod(LatencyContributorMethod.TRANSMISSION_TIME);

			} else if (minBusLatency > 0) {
				subContributor.setMinimum(minBusLatency);
				subContributor.setBestCaseMethod(LatencyContributorMethod.SPECIFIED);
			} else {
				subContributor.setBestCaseMethod(LatencyContributorMethod.UNKNOWN);
			}

			latencyContributor.addSubContributor(subContributor);
		}
	}

	public static void processActualConnectionBindingsTransmission(NamedElement connorvb,
			Classifier relatedConnectionData, LatencyContributor latencyContributor) {
		boolean willDoVirtualBuses = false;
		boolean willDoBuses = false;
		if (connorvb instanceof InstanceObject) {
			// look for actual binding if we have a connection instance or virtual bus instance
			List<ComponentInstance> bindings = GetProperties.getActualConnectionBinding((InstanceObject) connorvb);
			for (ComponentInstance componentInstance : bindings) {
				if (componentInstance.getCategory().equals(ComponentCategory.VIRTUAL_BUS)) {
					willDoVirtualBuses = true;
				} else {
					willDoBuses = true;
				}
			}
			/**
			 * required virtual bus class indicates protocols the connection intends to use.
			 * We also can have an actual connection binding to a virtual bus
			 * If we have that we want to use that virtual bus overhead
			 */
			if (!willDoVirtualBuses) {
				List<ComponentClassifier> protocols = GetProperties.getRequiredVirtualBusClass(connorvb);
				if ((protocols != null) && (protocols.size() > 0)) {
					if (willDoBuses) {
						latencyContributor.reportInfo("Adding required virtual bus contributions to bound bus");
					}
					for (ComponentClassifier cc : protocols) {
						processTransmissionTime(cc, relatedConnectionData, latencyContributor);
						processActualConnectionBindingsTransmission(cc, relatedConnectionData, latencyContributor);
					}
				}
			}

			for (ComponentInstance componentInstance : bindings) {
				processTransmissionTime(componentInstance, relatedConnectionData, latencyContributor);
				if (componentInstance.getCategory().equals(ComponentCategory.VIRTUAL_BUS)) {
					processActualConnectionBindingsTransmission(componentInstance, relatedConnectionData,
							latencyContributor);
				}
			}
		}

//		/**
//		 * required virtual bus class indicates protocols the connection intends to use.
//		 * We also can have an actual connection binding to a virtual bus
//		 * If we have that we want to use that virtual bus overhead
//		 */
//		if (!didVirtualBuses) {
//			List<ComponentClassifier> protocols = GetProperties.getRequiredVirtualBusClass(connorvb);
//			if ((protocols != null) && (protocols.size() > 0)) {
//				for (ComponentClassifier cc : protocols) {
//					processTransmissionTime(cc, relatedConnectionData, latencyContributor);
//					processActualConnectionBindingsTransmission(cc, relatedConnectionData, latencyContributor);
//				}
//			}
//		}
	}

	public static void processActualConnectionBindingsSampling(NamedElement connorvb, Classifier relatedConnectionData,
			LatencyContributor latencyContributor) {
		boolean willDoVirtualBuses = false;
		boolean willDoBuses = false;
		if (connorvb instanceof InstanceObject) {
			// look for actual binding if we have a connection instance or virtual bus instance
			List<ComponentInstance> bindings = GetProperties.getActualConnectionBinding((InstanceObject) connorvb);
			for (ComponentInstance componentInstance : bindings) {
				if (componentInstance.getCategory().equals(ComponentCategory.VIRTUAL_BUS)) {
					willDoVirtualBuses = true;
				} else {
					willDoBuses = true;
				}
			}
			/**
			 * required virtual bus class indicates protocols the connection intends to use.
			 * We also can have an actual connection binding to a virtual bus
			 * If we have that we want to use that virtual bus overhead
			 */
			if (!willDoVirtualBuses) {
				List<ComponentClassifier> protocols = GetProperties.getRequiredVirtualBusClass(connorvb);
				if ((protocols != null) && (protocols.size() > 0)) {
					if (willDoBuses) {
						latencyContributor.reportInfo("Adding required virtual bus contributions to bound bus");
					}
					for (ComponentClassifier cc : protocols) {
						processSamplingTime(cc, relatedConnectionData, latencyContributor);
						processActualConnectionBindingsSampling(cc, relatedConnectionData, latencyContributor);
					}
				}
			}

			for (ComponentInstance componentInstance : bindings) {
				processSamplingTime(componentInstance, relatedConnectionData, latencyContributor);
				if (componentInstance.getCategory().equals(ComponentCategory.VIRTUAL_BUS)) {
					processActualConnectionBindingsSampling(componentInstance, relatedConnectionData,
							latencyContributor);
				}
			}
		}

	}

	public static void processSamplingTime(NamedElement boundBus, Classifier relatedConnectionData,
			LatencyContributor latencyContributor) {
		/**
		 * we add the bus/VB sampling time as a subcontributor.
		 */

		if (boundBus != null) {
			double period = GetProperties.getPeriodinMS(boundBus);
			if (period > 0) {
				// add sampling latency due to the protocol or bus being periodic
				LatencyContributor samplingLatencyContributor = new LatencyContributorComponent(boundBus);
				samplingLatencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED_PROTOCOL);
				samplingLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED_PROTOCOL);
				samplingLatencyContributor.setSamplingPeriod(period);

				latencyContributor.addSubContributor(samplingLatencyContributor);
			}
		}
	}

}
