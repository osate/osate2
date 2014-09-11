package org.osate.analysis.flows;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.analysis.flows.model.LatencyContributor.LatencyContributorMethod;
import org.osate.analysis.flows.model.LatencyContributorComponent;
import org.osate.analysis.flows.model.LatencyReportEntry;
import org.osate.analysis.flows.preferences.Values;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class FlowLatencyLogicComponent {

	public static void mapComponentInstance(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance, LatencyReportEntry entry) {
		ComponentInstance componentInstance;
		double expectedMin = 0.0;
		double expectedMax = 0.0;

		if (flowElementInstance instanceof FlowSpecificationInstance) {
			componentInstance = flowElementInstance.getComponentInstance();
			expectedMin = GetProperties.getMinimumLatencyinMilliSec(flowElementInstance);
			expectedMax = GetProperties.getMaximumLatencyinMilliSec(flowElementInstance);
		} else {
			componentInstance = (ComponentInstance) flowElementInstance;
		}

		/**
		 * Get all the relevant properties.
		 */
		double period = GetProperties.getPeriodinMS(componentInstance);
		double deadline = GetProperties.getDeadlineinMilliSec(componentInstance);
		boolean isAssignedDeadline = GetProperties.isAsignedDeadline(componentInstance);
		double executionTimeLower = GetProperties.getMinimumComputeExecutionTimeinMs(componentInstance);
		double executionTimeHigher = GetProperties.getMaximumComputeExecutionTimeinMs(componentInstance);

		/**
		 * The component is periodic. Therefore it will sample its input unless we have an immediate connection or delayed connection
		 */

		if (period > 0) {
			LatencyContributorComponent latencyContributor = new LatencyContributorComponent(componentInstance);
			latencyContributor.setSamplingPeriod(period);
			if (FlowLatencyUtil.isPreviousConnectionDelayed(etef, flowElementInstance)) {
				latencyContributor.setBestCaseMethod(LatencyContributorMethod.DELAYED);
				latencyContributor.setWorstCaseMethod(LatencyContributorMethod.DELAYED);
			} else if (FlowLatencyUtil.isPreviousConnectionImmediate(etef, flowElementInstance)) {
				if (FlowLatencyUtil.isNextConnectionImmediate(etef, flowElementInstance)) {
					latencyContributor.setBestCaseMethod(LatencyContributorMethod.IMMEDIATE);
					latencyContributor.setWorstCaseMethod(LatencyContributorMethod.IMMEDIATE);
				} else {
					latencyContributor.setBestCaseMethod(LatencyContributorMethod.LAST_IMMEDIATE);
					latencyContributor.setWorstCaseMethod(LatencyContributorMethod.LAST_IMMEDIATE);
					if (deadline > 0) {
						latencyContributor.setDeadline(deadline);
					}
				}
			} else {
				if (entry.getContributors().isEmpty()) {
					latencyContributor.reportInfo("Initial " + period + "ms sampling latency not added");
					latencyContributor.setBestCaseMethod(LatencyContributorMethod.FIRST_SAMPLED);
					latencyContributor.setWorstCaseMethod(LatencyContributorMethod.FIRST_SAMPLED);
					// insert first partition sampling before task sampling. FOr other partitions it is inserted by connection processing
					ComponentInstance firstPartition = FlowLatencyUtil.getPartition(componentInstance);
					if (firstPartition != null) {
						double partitionLatency = FlowLatencyUtil.getPartitionLatency(firstPartition);
						double frameOffset = FlowLatencyUtil.getPartitionFrameOffset(firstPartition);
						if (frameOffset != -1) {
							LatencyContributorComponent platencyContributor = new LatencyContributorComponent(
									firstPartition);
							platencyContributor.setSamplingPeriod(partitionLatency);
							platencyContributor.setPartitionOffset(frameOffset);
							double partitionDuration = FlowLatencyUtil.getPartitionDuration(firstPartition);
							platencyContributor.setPartitionDuration(partitionDuration);
							platencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
							platencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
							platencyContributor.reportInfo("Initial " + period + "ms partition latency not added");
							entry.addContributor(platencyContributor);
						} else {
							LatencyContributorComponent platencyContributor = new LatencyContributorComponent(
									firstPartition);
							platencyContributor.setSamplingPeriod(partitionLatency);
							platencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
							platencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
							platencyContributor.reportInfo("Initial " + period + "ms partition latency not added");
							entry.addContributor(platencyContributor);
						}
					}
				} else {
					latencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED);
					latencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED);
				}
			}
			entry.addContributor(latencyContributor);
		} else {
			// insert first partition sampling for the aperiodic case. For other partitions it is inserted by connection processing
			ComponentInstance firstPartition = FlowLatencyUtil.getPartition(componentInstance);
			if (firstPartition != null) {
				double partitionLatency = FlowLatencyUtil.getPartitionLatency(firstPartition);
				double frameOffset = FlowLatencyUtil.getPartitionFrameOffset(firstPartition);
				if (frameOffset != -1) {
					LatencyContributorComponent platencyContributor = new LatencyContributorComponent(firstPartition);
					platencyContributor.setSamplingPeriod(partitionLatency);
					platencyContributor.setPartitionOffset(frameOffset);
					platencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
					platencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
					platencyContributor.reportInfo("Initial " + period + "ms partition latency not added");
					entry.addContributor(platencyContributor);
				} else {
					LatencyContributorComponent platencyContributor = new LatencyContributorComponent(firstPartition);
					platencyContributor.setSamplingPeriod(partitionLatency);
					platencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
					platencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
					platencyContributor.reportInfo("Initial " + period + "ms partition latency not added");
					entry.addContributor(platencyContributor);
				}
			}
		}

		/**
		 * Selection of the worst case value, generic case.
		 */
		LatencyContributorMethod bestmethod;
		LatencyContributorMethod worstmethod;

		double worstCaseValue = 0.0;
		double bestCaseValue = 0.0;
		worstmethod = LatencyContributorMethod.UNKNOWN;

		if (executionTimeHigher != 0.0 && !Values.doWorstCaseDeadline()) {
			// Use deadline for worst-case if specified in preferences
			worstCaseValue = executionTimeHigher;
			worstmethod = LatencyContributorMethod.PROCESSING_TIME;
		}

		if ((worstCaseValue == 0.0) && isAssignedDeadline) {
			// filter out if deadline was not explicitly assigned
			worstCaseValue = deadline;
			worstmethod = LatencyContributorMethod.DEADLINE;
		}

		if ((worstCaseValue == 0.0) && (expectedMax != 0.0)) {
			worstCaseValue = expectedMax;
			worstmethod = LatencyContributorMethod.SPECIFIED;
		}

		/**
		 * Selection of the best case value, generic cases.
		 */
		bestmethod = LatencyContributorMethod.UNKNOWN;
		if (executionTimeLower != 0.0) {
			bestCaseValue = executionTimeLower;
			bestmethod = LatencyContributorMethod.PROCESSING_TIME;
		}
//
//		if ((bestCaseValue == 0.0) && isAssignedDeadline) {
//			bestCaseValue = deadline;
//			bestmethod = LatencyContributorMethod.DEADLINE;
//		}

		if ((bestCaseValue == 0.0) && (expectedMin != 0.0)) {
			bestCaseValue = expectedMin;
			bestmethod = LatencyContributorMethod.SPECIFIED;
		}

		LatencyContributorComponent platencyContributor = new LatencyContributorComponent(componentInstance);
		platencyContributor.setWorstCaseMethod(worstmethod);
		platencyContributor.setBestCaseMethod(bestmethod);
		platencyContributor.setMaximum(worstCaseValue);
		platencyContributor.setMinimum(bestCaseValue);
		platencyContributor.setExpectedMaximum(expectedMax);
		platencyContributor.setExpectedMinimum(expectedMin);
		platencyContributor.checkConsistency();
		entry.addContributor(platencyContributor);
	}
}
