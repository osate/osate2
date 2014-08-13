package org.osate.analysis.flows;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.util.OsateDebug;
import org.osate.analysis.flows.model.ConnectionType;
import org.osate.analysis.flows.model.LatencyContributor;
import org.osate.analysis.flows.model.LatencyContributor.LatencyContributorMethod;
import org.osate.analysis.flows.model.LatencyContributorComponent;
import org.osate.analysis.flows.model.LatencyContributorConnection;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class FlowLatencyUtil {

	public static String getEndToEndFlowString(EndToEndFlowInstance etef) {
		StringBuffer ret;
		boolean firstPassed = false;

		ret = new StringBuffer();
		ret.append(etef.getName() + " : ");

		for (FlowElementInstance fei : etef.getFlowElements()) {
			if (firstPassed == true) {
				ret.append("->");
			}
			ret.append(fei.getName());
			firstPassed = true;
		}

		return ret.toString();
	}

	public static LatencyContributor mapFlowElementInstance(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {

//		OsateDebug.osateDebug("FlowLatencyUtil", "fei = " + flowElementInstance);
//		OsateDebug.osateDebug("FlowLatencyUtil", "fei= name" + flowElementInstance.getName());

		if (flowElementInstance instanceof FlowSpecificationInstance) {

			return mapComponentInstance(etef, flowElementInstance);
		}

		if (flowElementInstance instanceof ConnectionInstance) {
			return mapConnectionInstance(etef, flowElementInstance);
		}

		return null;
	}

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

		nextFlowElement = getNextFlowElement(etef, flowElementInstance);

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
		if (isNextConnectionImmediate(etef, flowElementInstance)) {
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
		if (isNextConnectionDelayed(etef, flowElementInstance)) {
			FlowElementInstance nextTask;
			double nextTaskPeriod;
			nextTask = getNextTaskOrDevice(etef, flowElementInstance);

			latencyContributor.setWorstCaseMethod(LatencyContributorMethod.DELAYED);
			latencyContributor.setBestCaseMethod(LatencyContributorMethod.DELAYED);

			if (nextTask != null) {

				nextTaskPeriod = GetProperties.getPeriodinMS(nextTask.getComponentInstance());
				bestCaseValue = 0.0;
				worstCaseValue = 0.0;
				latencyContributor
						.setComments("Delayed connection, the time will then be taken using the period of the next task and added to the connection");

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
		if (isNextConnectionSampled(etef, flowElementInstance)) {
			FlowElementInstance nextTask;
			double nextTaskPeriod;
			nextTask = getNextTaskOrDevice(etef, flowElementInstance);

			latencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED);
			latencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED);
			if (nextTask != null) {

				nextTaskPeriod = GetProperties.getPeriodinMS(nextTask.getComponentInstance());
				bestCaseValue = 0.0;
				worstCaseValue = 0.0;
				latencyContributor
						.setComments("Delayed connection, the time will then be taken using the period of the next task and added to the connection");

			} else {
				bestCaseValue = 0.0;
				worstCaseValue = 0.0;
				OsateDebug.osateDebug("FlowLatencyUtils", "cannot find the next task");
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

	public static LatencyContributor mapConnectionInstance(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		LatencyContributor latencyContributor;
		ConnectionInstance connectionInstance;
		ComponentInstance boundBus;

		connectionInstance = (ConnectionInstance) flowElementInstance;
		latencyContributor = new LatencyContributorConnection(connectionInstance);

//		OsateDebug.osateDebug("FlowLatencyUtil", "flowSpecification connection=" + connectionInstance);

		boundBus = GetProperties.getBoundBus(connectionInstance);

		if (boundBus != null) {
//			OsateDebug.osateDebug("FlowLatencyUtil", "connection bound to bus=" + boundBus);
		}

		if (getConnectionType(connectionInstance) == ConnectionType.DELAYED) {
			FlowElementInstance fei = getNextTaskOrDevice(etef, flowElementInstance);

			if (fei != null) {
				double period;
				period = GetProperties.getPeriodinMS(fei.getComponentInstance());
				latencyContributor.setWorstCaseMethod(LatencyContributorMethod.PERIOD);
				latencyContributor.setBestCaseMethod(LatencyContributorMethod.PERIOD);
				latencyContributor.setMaximum(period);
				latencyContributor.setMinimum(period);
				latencyContributor.setComments("The data will be available at the next task/device dispatch");
			}
		}

		if (getConnectionType(connectionInstance) == ConnectionType.SAMPLED) {
			FlowElementInstance fei = getNextTaskOrDevice(etef, flowElementInstance);

			if (fei != null) {
				double period;
				period = GetProperties.getPeriodinMS(fei.getComponentInstance());
				latencyContributor.setWorstCaseMethod(LatencyContributorMethod.PERIOD);
				latencyContributor.setBestCaseMethod(LatencyContributorMethod.PERIOD);
				latencyContributor.setMaximum(period);
				latencyContributor.setMinimum(period);
				latencyContributor.setComments("The data will be available at the next task/device dispatch");
			}
		}

		return latencyContributor;
	}

	public static boolean isNextConnectionImmediate(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		FlowElementInstance nextElement;
		nextElement = getNextFlowElement(etef, flowElementInstance);

		if ((nextElement != null) && (nextElement instanceof ConnectionInstance)) {
			return (getConnectionType((ConnectionInstance) nextElement) == ConnectionType.IMMEDIATE);
		}

		return false;
	}

	public static boolean isNextConnectionDelayed(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		FlowElementInstance nextElement;
		nextElement = getNextFlowElement(etef, flowElementInstance);

		if ((nextElement != null) && (nextElement instanceof ConnectionInstance)) {
			return (getConnectionType((ConnectionInstance) nextElement) == ConnectionType.DELAYED);
		}

		return false;
	}

	public static boolean isNextConnectionSampled(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		FlowElementInstance nextElement;
		nextElement = getNextFlowElement(etef, flowElementInstance);

		if ((nextElement != null) && (nextElement instanceof ConnectionInstance)) {
			return (getConnectionType((ConnectionInstance) nextElement) == ConnectionType.SAMPLED);
		}

		return false;
	}

	public static ConnectionType getConnectionType(final ConnectionInstance conn) {
		EnumerationLiteral el = GetProperties.getConnectionTiming(conn);
		if (el.getName().equalsIgnoreCase("immediate")) {
			return ConnectionType.IMMEDIATE;
		}
		if (el.getName().equalsIgnoreCase("delayed")) {
			return ConnectionType.DELAYED;
		}
		return ConnectionType.SAMPLED;
	}

	/**
	 * get the next element in an end to end flow
	 * @param etef - the end to end flow that contains all the elements
	 * @param flowElementInstance - the element where we start the search
	 * @return - a FlowElementInstance that is after flowElementInstance in etef. null if there is nothing after
	 */
	public static FlowElementInstance getNextFlowElement(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {

		int n;
		int res;
		for (n = 0; n < etef.getFlowElements().size(); n++) {
			if (etef.getFlowElements().get(n) == flowElementInstance) {
				res = n + 1;
				if (res < etef.getFlowElements().size()) {
					return etef.getFlowElements().get(res);
				}
			}
		}

		return null;
	}

	/**
	 * Get the next task within an end to end flow after the flow element
	 * given as attribute.
	 * @param etef - the end to end flow
	 * @param flowElementInstance - the element to search from
	 * @return - the flow element that is a task and is after flowElementInstance
	 */
	public static FlowElementInstance getNextTaskOrDevice(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		boolean found;
		int n;

		found = false;

		for (n = 0; n < etef.getFlowElements().size(); n++) {
			if (found) {
				FlowElementInstance fei = etef.getFlowElements().get(n);
				if ((fei.getComponentInstance() != null)
						&& ((fei.getComponentInstance().getCategory() == ComponentCategory.THREAD) || (fei
								.getComponentInstance().getCategory() == ComponentCategory.DEVICE))) {
					return fei;
				}
			}

			if (etef.getFlowElements().get(n) == flowElementInstance) {
				found = true;

			}
		}

		return null;
	}
}
