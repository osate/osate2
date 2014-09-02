package org.osate.analysis.flows;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.analysis.flows.model.LatencyContributor.LatencyContributorMethod;
import org.osate.analysis.flows.model.LatencyContributorComponent;
import org.osate.analysis.flows.model.LatencyReportEntry;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class FlowLatencyLogicComponent {

	public static void mapComponentInstance(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance, LatencyReportEntry entry) {
		LatencyContributorComponent latencyContributor;
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
			latencyContributor = new LatencyContributorComponent(componentInstance);
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
					latencyContributor.setComments("Initial " + period + "ms sampling latency not added");
					latencyContributor.setBestCaseMethod(LatencyContributorMethod.FIRST_SAMPLED);
					latencyContributor.setWorstCaseMethod(LatencyContributorMethod.FIRST_SAMPLED);
				} else {
					latencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED);
					latencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED);
				}
			}
			entry.addContributor(latencyContributor);
		}

		/**
		 * Selection of the worst case value, generic case.
		 */
		LatencyContributorMethod bestmethod;
		LatencyContributorMethod worstmethod;

		double worstCaseValue = 0.0;
		double bestCaseValue = 0.0;
		worstmethod = LatencyContributorMethod.UNKNOWN;

		if (executionTimeHigher != 0.0) {
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

		latencyContributor = new LatencyContributorComponent(componentInstance);
		latencyContributor.setWorstCaseMethod(worstmethod);
		latencyContributor.setBestCaseMethod(bestmethod);
		latencyContributor.setMaximum(worstCaseValue);
		latencyContributor.setMinimum(bestCaseValue);
		latencyContributor.setExpectedMaximum(expectedMax);
		latencyContributor.setExpectedMinimum(expectedMin);
		latencyContributor.checkConsistency();
		entry.addContributor(latencyContributor);
	}
}
