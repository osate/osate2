package org.osate.analysis.flows;

import java.util.List;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.analysis.flows.model.LatencyContributor.LatencyContributorMethod;
import org.osate.analysis.flows.model.LatencyContributorComponent;
import org.osate.analysis.flows.model.LatencyReportEntry;
import org.osate.analysis.flows.preferences.Values;
import org.osate.xtext.aadl2.properties.util.ARINC653ScheduleWindow;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

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
		boolean isAssignedDeadline = GetProperties.isAssignedDeadline(componentInstance);
		double executionTimeLower = GetProperties.getScaledMinComputeExecutionTimeinMilliSec(componentInstance);
		double executionTimeHigher = GetProperties.getScaledMaxComputeExecutionTimeinMilliSec(componentInstance);
		if (Values.doDataSetProcessing()) {
			FeatureInstance inport = FlowLatencyUtil.getIncomingFeatureInstance(etef, flowElementInstance);
			if (inport != null) {
				double dim = FlowLatencyUtil.getDimension(inport);
				if (dim > 1) {
					executionTimeHigher = executionTimeHigher * dim;
					executionTimeLower = executionTimeLower * dim;
				}
			}
		}

		/**
		 * The component is periodic. Therefore it will sample its input unless we have an immediate connection or delayed connection
		 */
		boolean checkLastImmediate = false;
		if (period > 0
				&& (InstanceModelUtil.isThread(componentInstance) || InstanceModelUtil.isDevice(componentInstance))
				? (!InstanceModelUtil.isSporadicComponent(componentInstance)
						&& !InstanceModelUtil.isTimedComponent(componentInstance))
						: true) {
			// period is set, and if thread or device needs to be dispatched as periodic
			LatencyContributorComponent samplingLatencyContributor = new LatencyContributorComponent(componentInstance);
			samplingLatencyContributor.setSamplingPeriod(period);
			if (FlowLatencyUtil.isPreviousConnectionDelayed(etef, flowElementInstance)) {
				samplingLatencyContributor.setBestCaseMethod(LatencyContributorMethod.DELAYED);
				samplingLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.DELAYED);
			} else if (FlowLatencyUtil.isPreviousConnectionImmediate(etef, flowElementInstance)) {
				// we include this contributor so we can check for consistency for LAST_IMMEDIATE, i.e.,
				// the cumulative does not exceed the deadline of the last.
				if (!FlowLatencyUtil.isNextConnectionImmediate(etef, flowElementInstance)) {
					checkLastImmediate = true;
				}
			} else {
				if (entry.getContributors().isEmpty()) {
					samplingLatencyContributor.reportInfo("Initial " + period + "ms sampling latency not added");
					samplingLatencyContributor.setBestCaseMethod(LatencyContributorMethod.FIRST_SAMPLED);
					samplingLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.FIRST_SAMPLED);
					// insert first partition sampling before task sampling. FOr other partitions it is inserted by connection processing
					ComponentInstance firstPartition = FlowLatencyUtil.getPartition(componentInstance);
					if (firstPartition != null) {
						double partitionLatency = FlowLatencyUtil.getPartitionPeriod(firstPartition);
						List<ARINC653ScheduleWindow> schedule = FlowLatencyUtil.getModuleSchedule(firstPartition);
						double partitionDuration = FlowLatencyUtil.getPartitionDuration(firstPartition, schedule);
						if (partitionDuration != -1) {
							LatencyContributorComponent partitionLatencyContributor = new LatencyContributorComponent(
									firstPartition);
							partitionLatencyContributor.setSamplingPeriod(partitionLatency);
							double frameOffset = FlowLatencyUtil.getPartitionFrameOffset(firstPartition, schedule);
							partitionLatencyContributor.setPartitionOffset(frameOffset);
							partitionLatencyContributor.setPartitionDuration(partitionDuration);
							partitionLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
							partitionLatencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
							entry.addContributor(partitionLatencyContributor);
						} else {
							LatencyContributorComponent partitionLatencyContributor = new LatencyContributorComponent(
									firstPartition);
							partitionLatencyContributor.setSamplingPeriod(partitionLatency);
							partitionLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
							partitionLatencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
							entry.addContributor(partitionLatencyContributor);
						}
					}
				} else {
					samplingLatencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED);
					samplingLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED);
					samplingLatencyContributor.setSamplingPeriod(period);
				}
			}
			entry.addContributor(samplingLatencyContributor);
		} else {
			// insert first partition sampling for the aperiodic case. For other partitions it is inserted by connection processing
			ComponentInstance firstPartition = FlowLatencyUtil.getPartition(componentInstance);
			if (firstPartition != null) {
				double partitionLatency = FlowLatencyUtil.getPartitionPeriod(firstPartition);
				List<ARINC653ScheduleWindow> schedule = FlowLatencyUtil.getModuleSchedule(firstPartition);
				double partitionDuration = FlowLatencyUtil.getPartitionDuration(firstPartition, schedule);
				if (partitionDuration != -1) {
					LatencyContributorComponent platencyContributor = new LatencyContributorComponent(firstPartition);
					platencyContributor.setSamplingPeriod(partitionLatency);
					double frameOffset = FlowLatencyUtil.getPartitionFrameOffset(firstPartition, schedule);
					platencyContributor.setPartitionOffset(frameOffset);
					platencyContributor.setPartitionDuration(partitionDuration);
					platencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
					platencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
					entry.addContributor(platencyContributor);
				} else {
					LatencyContributorComponent platencyContributor = new LatencyContributorComponent(firstPartition);
					platencyContributor.setSamplingPeriod(partitionLatency);
					platencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
					platencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
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
			// Use execution time for worst-case if preferences specify not deadline
			worstCaseValue = executionTimeHigher;
			worstmethod = LatencyContributorMethod.PROCESSING_TIME;
		}

		if ((worstCaseValue == 0.0) && isAssignedDeadline) {
			// use deadline if no execution time and deadline was explicitly assigned
			worstCaseValue = deadline;
			worstmethod = LatencyContributorMethod.DEADLINE;
		}

		if ((worstCaseValue == 0.0) && (expectedMax != 0.0)) {
			// use flow latency if neither deadline nor execution time
			worstCaseValue = expectedMax;
			worstmethod = LatencyContributorMethod.SPECIFIED;
		} else if (worstCaseValue == 0.0 && deadline != 0.0) {
			// if no flow spec value then use default deadline == period
			worstCaseValue = deadline;
			worstmethod = LatencyContributorMethod.DEADLINE;
		}

		/**
		 * Selection of the best case value, generic cases.
		 */
		bestmethod = LatencyContributorMethod.UNKNOWN;
		if (executionTimeLower != 0.0) {
			bestCaseValue = executionTimeLower;
			bestmethod = LatencyContributorMethod.PROCESSING_TIME;
		}
// For best case it does not make sense to use deadline
//		if ((bestCaseValue == 0.0) && isAssignedDeadline) {
//			bestCaseValue = deadline;
//			bestmethod = LatencyContributorMethod.DEADLINE;
//		}

		if ((bestCaseValue == 0.0) && (expectedMin != 0.0)) {
			bestCaseValue = expectedMin;
			bestmethod = LatencyContributorMethod.SPECIFIED;
		}

		// deal with queuing latency
		if (InstanceModelUtil.isThread(componentInstance) || InstanceModelUtil.isDevice(componentInstance)) {
			// take into account queuing delay
			FeatureInstance fi = FlowLatencyUtil.getIncomingFeatureInstance(etef, flowElementInstance);
			if (fi != null && (fi.getCategory() == FeatureCategory.EVENT_PORT
					|| fi.getCategory() == FeatureCategory.EVENT_DATA_PORT)) {
				LatencyContributorComponent ql = new LatencyContributorComponent(componentInstance);
				// take into account queuing delay on event and event data ports.
				double qs = GetProperties.getQueueSize(fi);
				double dl = 0.0;
				if (InstanceModelUtil.isSporadicComponent(componentInstance)
						|| InstanceModelUtil.isPeriodicComponent(componentInstance)) {
					dl = period;
					ql.reportInfo("Sporadic or periodic has period delay per queue element");
//					in some circumstances we may want to subtract one element
					// Example: Periodic or Sporadic thread samples, thus its sampling latency reflects the first element waiting
					if (qs > 0) {
						// subtract one since the arriving element becomes the last element
						qs = qs - 1;
						ql.reportInfo(
								"Sporadic or periodic has queue delay reduced by one. It is accounted for in the sampling delay");
					}
				} else {
					dl = worstCaseValue;
				}
				double queuingDelay = qs * dl;
				ql.setMaximum(queuingDelay);
				if (Values.doBestcaseEmptyQueue()) {
					ql.setMinimum(0.0);
					ql.reportInfo("Assume best case empty queue");
				} else {
					double mindl = (InstanceModelUtil.isSporadicComponent(componentInstance)
							|| InstanceModelUtil.isPeriodicComponent(componentInstance) ? period : bestCaseValue);
					ql.setMinimum(qs * mindl);
					ql.reportInfo("Assume best case full queue");
				}
				ql.setWorstCaseMethod(LatencyContributorMethod.QUEUED);
				ql.setBestCaseMethod(LatencyContributorMethod.QUEUED);
				entry.addContributor(ql);
			}
		}

		LatencyContributorComponent processingLatencyContributor = new LatencyContributorComponent(componentInstance);
		processingLatencyContributor.setWorstCaseMethod(worstmethod);
		processingLatencyContributor.setBestCaseMethod(bestmethod);
		processingLatencyContributor.setMaximum(worstCaseValue);
		processingLatencyContributor.setMinimum(bestCaseValue);
		processingLatencyContributor.setExpectedMaximum(expectedMax);
		processingLatencyContributor.setExpectedMinimum(expectedMin);
		if (checkLastImmediate && deadline > 0.0) {

			processingLatencyContributor.setImmediateDeadline(deadline);
		}
		processingLatencyContributor.checkConsistency();
		entry.addContributor(processingLatencyContributor);
	}
}
