package org.osate.analysis.flows;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.analysis.flows.model.LatencyContributor.LatencyContributorMethod;
import org.osate.analysis.flows.model.LatencyContributorComponent;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class FlowLatencyLogicComponent {
	public static LatencyContributorComponent mapComponentInstance(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		LatencyContributorComponent latencyContributor;
		FlowSpecificationInstance flowSpecification;
		ComponentInstance componentInstance;
		LatencyContributorMethod method;
		FlowElementInstance nextFlowElement;

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

		flowSpecification = (FlowSpecificationInstance) flowElementInstance;
		componentInstance = (ComponentInstance) flowElementInstance.getComponentInstance();

		nextFlowElement = FlowLatencyUtil.getNextFlowElement(etef, flowElementInstance);

		latencyContributor = new LatencyContributorComponent(componentInstance);

		expectedMin = GetProperties.getMinimumLatencyinMilliSec(flowElementInstance);
		expectedMax = GetProperties.getMaximumLatencyinMilliSec(flowElementInstance);

		/**
		 * Get all the relevant properties.
		 */
		period = GetProperties.getPeriodinMS(componentInstance);
		deadline = GetProperties.getDeadlineinMilliSec(componentInstance);
		executionTimeLower = GetProperties.getMinimumComputeExecutionTimeinMs(componentInstance);
		executionTimeHigher = GetProperties.getMaximumComputeExecutionTimeinMs(componentInstance);

		/**
		 * Selection of the worst case value, generic case.
		 */
		method = LatencyContributorMethod.UNKNOWN;

		if (executionTimeHigher != 0.0) {
			worstCaseValue = executionTimeHigher;
			method = LatencyContributorMethod.WCET;
		}

		if ((worstCaseValue == 0.0) && (deadline != 0.0)) {
			worstCaseValue = deadline;
			method = LatencyContributorMethod.DEADLINE;
		}

		if ((worstCaseValue == 0.0) && (period != 0.0)) {
			worstCaseValue = period;
			method = LatencyContributorMethod.PERIOD;
		}

		latencyContributor.setWorstCaseMethod(method);

		/**
		 * Selection of the best case value, generic cases.
		 */
		method = LatencyContributorMethod.UNKNOWN;
		if (executionTimeLower != 0.0) {
			bestCaseValue = executionTimeLower;
			method = LatencyContributorMethod.WCET;
		}

		if ((bestCaseValue == 0.0) && (deadline != 0.0)) {
			bestCaseValue = deadline;
			method = LatencyContributorMethod.DEADLINE;
		}

		if ((bestCaseValue == 0.0) && (period != 0.0)) {
			bestCaseValue = period;
			method = LatencyContributorMethod.PERIOD;
		}

		latencyContributor.setBestCaseMethod(method);

		/**
		 * If the next connection is immediate, then, the data is sent
		 * as soon as possible. In other words, if both tasks are synchronized,
		 * the data is send just after it was produced. We use the worst case
		 * execution time to deduce the time required to produce the data.
		 * Otherwise, we assume that the time to produce the data is negligible.
		 */
		if (FlowLatencyUtil.isNextConnectionImmediate(etef, flowElementInstance)) {
			if (executionTimeLower != 0.0) {
				latencyContributor.setBestCaseMethod(LatencyContributorMethod.WCET);
				bestCaseValue = executionTimeLower;
			} else {
				latencyContributor.setBestCaseMethod(LatencyContributorMethod.IMMEDIATE);
				bestCaseValue = 0.0;
			}

			if (executionTimeLower != 0.0) {
				latencyContributor.setWorstCaseMethod(LatencyContributorMethod.WCET);
				worstCaseValue = executionTimeLower;
			} else {
				latencyContributor.setWorstCaseMethod(LatencyContributorMethod.IMMEDIATE);
				worstCaseValue = 0.0;
			}

			latencyContributor
					.setComments("The connection is immediate and both parts are synchronized. Using either the min/max execution or assume execution time is negligible");
		}

		/**
		 * If the next connection is delayed, then, the data is available
		 * at the next task dispatch. So, the time the data will be available
		 * is equal to the period of the next task.
		 */
		if (FlowLatencyUtil.isNextConnectionDelayed(etef, flowElementInstance)) {
			FlowElementInstance nextTaskOrDevice;
			double nextTaskOrDevicePeriod;

			nextTaskOrDevicePeriod = 0.0;
			nextTaskOrDevice = FlowLatencyUtil.getNextTaskOrDevice(etef, flowElementInstance);

			if (nextTaskOrDevice != null) {

				nextTaskOrDevicePeriod = GetProperties.getPeriodinMS(nextTaskOrDevice.getComponentInstance());

				if (FlowLatencyUtil.isNextConnectionLocal(etef, flowElementInstance)) {

					/**
					 * Local connections
					 */
					latencyContributor.setWorstCaseMethod(LatencyContributorMethod.DELAYED);
					latencyContributor.setBestCaseMethod(LatencyContributorMethod.DELAYED);

					bestCaseValue = 0.0;
					worstCaseValue = 0.0;
					latencyContributor
							.setComments("The time will then be taken using the period of the next task and added to the connection");
				} else {
					/**
					 * Distributed systems
					 */
					latencyContributor.setComments("Time to take to send the data over the network");
				}

			} else {
				bestCaseValue = 0.0;
				worstCaseValue = 0.0;
				OsateDebug.osateDebug("FlowLatencyUtils", "cannot find the next task");
				latencyContributor.setComments("Delayed connection but cannot find the next task");

			}

		}

		/**
		 * If the next connection is sampled, then, the data is available
		 * at the next task dispatch. So, the time the data will be available
		 * is equal to the period of the next task.
		 */
		if (FlowLatencyUtil.isNextConnectionSampled(etef, flowElementInstance)) {
			FlowElementInstance nextTaskOrDevice;
			double nextTaskOrDevicePeriod;

			nextTaskOrDevicePeriod = 0.0;

			nextTaskOrDevice = FlowLatencyUtil.getNextTaskOrDevice(etef, flowElementInstance);

			if (nextTaskOrDevice != null) {
				if (FlowLatencyUtil.isNextConnectionLocal(etef, flowElementInstance)) {

					/**
					 * Local connections
					 */
					nextTaskOrDevicePeriod = GetProperties.getPeriodinMS(nextTaskOrDevice.getComponentInstance());

					latencyContributor.setComments("Local connection - use default method");
				} else {
					/**
					 * Distributed systems
					 */
					latencyContributor.setComments("Time to take to send the data over the network");
				}

			} else {

				latencyContributor.setComments("Delayed connection but cannot find the next task");

			}

		}

		latencyContributor.setMaximum(worstCaseValue);
		latencyContributor.setMinimum(bestCaseValue);
		latencyContributor.setExpectedMaximum(expectedMax);
		latencyContributor.setExpectedMinimum(expectedMin);

//		OsateDebug.osateDebug("FlowLatencyUtil", "flowSpecification component=" + componentInstance.getName());

		return latencyContributor;
	}
}
