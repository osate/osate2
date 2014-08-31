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
		LatencyContributorMethod bestmethod;
		LatencyContributorMethod worstmethod;

		double period;
		double deadline;
		double executionTimeLower;
		double executionTimeHigher;
		double worstCaseValue;
		double bestCaseValue;
		double expectedMin;
		double expectedMax;

		period = 0.0;
		deadline = 0.0;
		executionTimeHigher = 0.0;
		executionTimeLower = 0.0;
		worstCaseValue = 0.0;
		bestCaseValue = 0.0;
		expectedMax = 0.0;
		expectedMin = 0.0;

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
		period = GetProperties.getPeriodinMS(componentInstance);
		deadline = GetProperties.getDeadlineinMilliSec(componentInstance);
		executionTimeLower = GetProperties.getMinimumComputeExecutionTimeinMs(componentInstance);
		executionTimeHigher = GetProperties.getMaximumComputeExecutionTimeinMs(componentInstance);

		double cummax = entry.getMaximumCumLatency();
		double cummin = entry.getMinimumCumLatency();

		/**
		 * The component is periodic. Therefore it will sample its input unless we have an immediate connection or delayed connection
		 */

		// XXX: for down sampling we can distinguish between the sender period (seeing the most recent sample) and the receiver period (seeing an event)

		if (period > 0 && FlowLatencyUtil.isPreviousConnectionSampled(etef, flowElementInstance)) {
			latencyContributor = new LatencyContributorComponent(componentInstance);
			if (entry.isSynchronous() && entry.wasSampled()) {
				// there was a previous sampling component. We can to the roundup game.
				latencyContributor.setMaximum(FlowLatencyUtil.roundUpDiff(cummax, period));
				latencyContributor.setMinimum(FlowLatencyUtil.roundUpDiff(cummin, period));
				latencyContributor.setComments("Recipient period difference as sampling latency");
			} else {
				latencyContributor.setMinimum(period);
				latencyContributor.setMaximum(period);
				latencyContributor.setComments("Recipient period as sampling latency");
			}
			latencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED);
			latencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED);
			entry.addContributor(latencyContributor);
		}

		if (period > 0 && FlowLatencyUtil.isPreviousConnectionDelayed(etef, flowElementInstance)) {
			latencyContributor = new LatencyContributorComponent(componentInstance);
			if (entry.isSynchronous() && entry.wasSampled()) {
				// cummin and cummax should be less than the period.
				// If cummin and cummax are in different frames, we make sure they both align to the larger number of frames
				double framediff = FlowLatencyUtil.roundUp(cummax, period) - FlowLatencyUtil.roundUp(cummin, period);
				latencyContributor.setMaximum(FlowLatencyUtil.roundUpDiff(cummax, period));
				latencyContributor.setMinimum(FlowLatencyUtil.roundUpDiff(cummin, period) + framediff);
				latencyContributor
						.setComments("Recipient period difference as sampling latency. Min frames aligned with max frames.");
			} else {
				latencyContributor.setMinimum(period);
				latencyContributor.setMaximum(period);
				latencyContributor.setComments("Recipient period as sampling latency");
			}
			latencyContributor.setBestCaseMethod(LatencyContributorMethod.DELAYED);
			latencyContributor.setWorstCaseMethod(LatencyContributorMethod.DELAYED);
			entry.addContributor(latencyContributor);
		}

		/**
		 * Selection of the worst case value, generic case.
		 */
		worstmethod = LatencyContributorMethod.UNKNOWN;

		if (executionTimeHigher != 0.0) {
			worstCaseValue = executionTimeHigher;
			worstmethod = LatencyContributorMethod.PROCESSING_TIME;
		}

		if ((worstCaseValue == 0.0) && (deadline != 0.0) && (deadline != period)) {
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

		if ((bestCaseValue == 0.0) && (deadline != 0.0) && (deadline != period)) {
			bestCaseValue = deadline;
			bestmethod = LatencyContributorMethod.DEADLINE;
		}

		if ((bestCaseValue == 0.0) && (expectedMin != 0.0)) {
			bestCaseValue = expectedMin;
			bestmethod = LatencyContributorMethod.SPECIFIED;
		}

		latencyContributor = new LatencyContributorComponent(componentInstance);
		// we had an immediate connection
		if (FlowLatencyUtil.isPreviousConnectionImmediate(etef, flowElementInstance)
				&& !FlowLatencyUtil.isNextConnectionImmediate(etef, flowElementInstance)) {
			// the end of an immediate connection sequence
			if (deadline > 0) {
				if (cummax + executionTimeHigher > deadline) {
					// XXX: warning cumulative immediate sequence should not exceed deadline of last component.
				} else {
					worstCaseValue = FlowLatencyUtil.roundUpDiff(cummax, deadline);
					bestCaseValue = FlowLatencyUtil.roundUpDiff(cummin, deadline);
					latencyContributor.setComments("Add latency increment to reach component deadline");
				}
			} // if deadline is zero, then we have a non-periodic task as target of immediate connection
				// we treat it like a regular connection
		}

		/**
		 * If the next connection is immediate, then, the data is sent
		 * as soon as possible. In other words, if both tasks are synchronized,
		 * the data is send just after it was produced. We use the worst case
		 * execution time to deduce the time required to produce the data.
		 * Otherwise, we assume that the time to produce the data is negligible.
		 */
		if (FlowLatencyUtil.isNextConnectionImmediate(etef, flowElementInstance)) {
			if (bestmethod == LatencyContributorMethod.DEADLINE) {
				bestmethod = LatencyContributorMethod.IMMEDIATE;
				bestCaseValue = 0.0;
			}

			if (worstmethod == LatencyContributorMethod.DEADLINE) {
				worstmethod = LatencyContributorMethod.IMMEDIATE;
				worstCaseValue = 0.0;
			}

			latencyContributor
					.setComments("Component with deadline latecny and next connection is immediate. Next component deadline accounts for contribution.");
		}
		latencyContributor.setWorstCaseMethod(worstmethod);
		latencyContributor.setBestCaseMethod(bestmethod);
		latencyContributor.setMaximum(worstCaseValue);
		latencyContributor.setMinimum(bestCaseValue);
		latencyContributor.setExpectedMaximum(expectedMax);
		latencyContributor.setExpectedMinimum(expectedMin);
		if (entry.getContributors().isEmpty() && period != 0) {
			// first entry and it is periodic
			// The others are set when latency contributor is added and set to be SAMPLED or DELAYED
			entry.setLastSampled(latencyContributor);
		}

		entry.addContributor(latencyContributor);
	}
}
