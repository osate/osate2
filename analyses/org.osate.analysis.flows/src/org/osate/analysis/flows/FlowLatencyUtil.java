/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.analysis.flows;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.VirtualBus;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.analysis.flows.model.ConnectionType;
import org.osate.contribution.sei.names.DataModel;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;
import org.osate.xtext.aadl2.properties.util.ARINC653ScheduleWindow;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

public class FlowLatencyUtil {
	//XXX: [Code Coverage] Dead code.
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

	//XXX: [Code Coverage] Dead code.
	public static boolean hasPreviousConnection(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		return etef.getFlowElements().indexOf(flowElementInstance) > 0;
	}

	public static FeatureInstance getIncomingConnectionFeatureInstance(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance previousElement = getPreviousConnection(etef, flowElementInstance);
		if ((previousElement != null)) {
			ConnectionInstanceEnd dst = previousElement.getDestination();
			if (dst instanceof FeatureInstance) {
				return (FeatureInstance) dst;
			}
		}

		return null;
	}

	public static boolean isPreviousConnectionImmediate(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance previousElement = getPreviousConnection(etef, flowElementInstance);
		//XXX: [Code Coverage] Only called if there is a previous connection.
		if ((previousElement != null)) {
			return (getConnectionType(previousElement) == ConnectionType.IMMEDIATE);
		}

		return false;
	}

	public static boolean isNextConnectionImmediate(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance nextElement = getNextConnection(etef, flowElementInstance);
		if ((nextElement != null)) {
			return (getConnectionType(nextElement) == ConnectionType.IMMEDIATE);
		}

		return false;
	}

	public static boolean isPreviousConnectionDelayed(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance nextElement = getPreviousConnection(etef, flowElementInstance);
		//XXX: [Code Coverage] Only called if there is a previous connection.
		if ((nextElement != null)) {
			return (getConnectionType(nextElement) == ConnectionType.DELAYED);
		}

		return false;
	}

	//XXX: [Code Coverage] Dead code.
	public static boolean isNextConnectionDelayed(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance nextElement = getNextConnection(etef, flowElementInstance);
		if ((nextElement != null)) {
			return (getConnectionType(nextElement) == ConnectionType.DELAYED);
		}

		return false;
	}

	//XXX: [Code Coverage] Dead code.
	public static boolean isPreviousConnectionSampled(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance nextElement = getPreviousConnection(etef, flowElementInstance);
		if ((nextElement != null)) {
			return (getConnectionType(nextElement) == ConnectionType.SAMPLED);
		}

		return false;
	}

	//XXX: [Code Coverage] Dead code.
	public static boolean isNextConnectionSampled(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance nextElement = getNextConnection(etef, flowElementInstance);
		if ((nextElement != null)) {
			return (getConnectionType(nextElement) == ConnectionType.SAMPLED);
		}

		return false;
	}

	public static ConnectionType getConnectionType(final ConnectionInstance conn) {
		EnumerationLiteral el = GetProperties.getConnectionTiming(conn);

		//XXX: [Code Coverage] el cannot be null.
		if ((el != null) && (el.getName().equalsIgnoreCase("immediate"))) {
			return ConnectionType.IMMEDIATE;
		}
		//XXX: [Code Coverage] el cannot be null.
		if ((el != null) && (el.getName().equalsIgnoreCase("delayed"))) {
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
		int n = etef.getFlowElements().indexOf(flowElementInstance);
		int size = etef.getFlowElements().size();
		if (n + 1 < size) {
			return etef.getFlowElements().get(n + 1);
		}

		return null;
	}

	/**
	 * get the previous element in an end to end flow
	 * @param etef - the end to end flow that contains all the elements
	 * @param flowElementInstance - the element where we start the search
	 * @return - a FlowElementInstance that is before flowElementInstance in etef. null if there is nothing before
	 */
	public static FlowElementInstance getPreviousFlowElement(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		int n = etef.getFlowElements().indexOf(flowElementInstance);
		if (n > 0) {
			return etef.getFlowElements().get(n - 1);
		}

		return null;
	}

	/**
	 * get previous component instance in flow
	 * @param etef
	 * @param flowElementInstance
	 * @return
	 */
	public static ComponentInstance getPreviousComponent(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		FlowElementInstance prevConn = getPreviousFlowElement(etef, flowElementInstance);
		if (prevConn != null) {
			FlowElementInstance prevEl = getPreviousFlowElement(etef, prevConn);
			if (prevEl != null) {
				if (prevEl instanceof FlowSpecificationInstance) {
					return prevEl.getContainingComponentInstance();
				}
				if (prevEl instanceof ComponentInstance) {
					return (ComponentInstance) prevEl;
				}
			}
		}
		return null;
	}

	/**
	 * Get the next thread/device period within an end to end flow after the flow element
	 * given as attribute.
	 * @param etef - the end to end flow
	 * @param flowElementInstance - the element to search from
	 * @return - the flow element period that is a thread and is after flowElementInstance
	 */
	//XXX: [Code Coverage] Dead code.
	public static double getNextThreadOrDevicePeriod(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ComponentInstance ci = getNextFlowElement(etef, flowElementInstance).getComponentInstance();
		if ((ci != null)
				&& ((ci.getCategory() == ComponentCategory.THREAD) || (ci.getCategory() == ComponentCategory.DEVICE))) {
			return GetProperties.getPeriodinMS(ci);
		}
		return 0;
	}

	/**
	 * Get the next task within an end to end flow after the flow element
	 * given as attribute.
	 * @param etef - the end to end flow
	 * @param flowElementInstance - the element to search from
	 * @return - the flow element that is a task and is after flowElementInstance
	 */
	//XXX: [Code Coverage] Dead code.
	public static double getNextSamplingComponentPeriod(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ComponentInstance ci = getNextFlowElement(etef, flowElementInstance).getComponentInstance();
		if (ci != null) {
			return GetProperties.getPeriodinMS(ci);
		}
		return 0;
	}

	/**
	 * find the next connection within an end to end flow
	 * @param etef - the end to end flow where to search
	 * @param flowElementInstance - the element from where we start the search
	 * @return a connectioninstance object that is the next connection in the flow. null otherwise.
	 */
	public static ConnectionInstance getNextConnection(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		FlowElementInstance fei = getNextFlowElement(etef, flowElementInstance);
		if (fei instanceof ConnectionInstance) {
			return (ConnectionInstance) fei;
		}
		return null;
	}

	/**
	 * find the previous connection within an end to end flow
	 * @param etef - the end to end flow where to search
	 * @param flowElementInstance - the element from where we start the search
	 * @return a connection instance object that is the previous connection in the flow. null otherwise.
	 */
	public static ConnectionInstance getPreviousConnection(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		FlowElementInstance fei = getPreviousFlowElement(etef, flowElementInstance);
		if (fei instanceof ConnectionInstance) {
			return (ConnectionInstance) fei;
		}
		return null;
	}


	/**
	 * Return first virtual processor. Usually processes are only assigned to one VP.
	 * @param componentInstance system, process, thread or other entity bound to a processor and running inside a partition.
	 * @return partition
	 */
	public static ComponentInstance getPartition(ComponentInstance componentInstance) {
		Collection<ComponentInstance> vprocessors = InstanceModelUtil.getBoundVirtualProcessors(componentInstance);
		for (ComponentInstance vproc : vprocessors) {
			return vproc;
		}
		return null;
	}

	/**
	 * get the partition period, either from the virtual processor representing the partition, or from the major frame of the ARINC653 specification of a processor
	 * @return partition period as latency contributor
	 */
	public static double getPartitionPeriod(ComponentInstance part) {
		// first look for major frame value on processor
		ComponentInstance module = getModule(part);
		double res = GetProperties.getARINC653ModuleMajorFrame(module);
		if (res == 0.0) {
			// look for period on partition
			res = GetProperties.getPeriodinMS(part);
		}
		if (res == 0.0) {
			// look for major frame value on virtual processor (partition)
			res = GetProperties.getARINC653ModuleMajorFrame(part);
		}
		return res;
	}

	/**
	 * Get the major frame from the processor supporting ARINC653 partitions from its schedule
	 * @param componentInstance system, process, thread or other entity bound to a processor and running inside a partition.
	 * @return partition period supported by processor
	 */
	//XXX: [Code Coverage] Dead code.
	public static double getARINC653ProcessorMajorFrameFromSchedule(ComponentInstance processorInstance) {
		double res = 0.0;
		List<ARINC653ScheduleWindow> schedule = GetProperties.getModuleSchedule(processorInstance);
		if ((schedule != null) && (schedule.size() > 0)) {
			for (ARINC653ScheduleWindow window : schedule) {
				res = res + window.getTime();
			}
			return res;
		}
		return res;
	}

	public static Classifier getConnectionData(ConnectionInstance connectionInstance) {
		ConnectionInstanceEnd cei;
		FeatureInstance fi;
		cei = connectionInstance.getSource();

		if (cei instanceof FeatureInstance) {
			fi = (FeatureInstance) cei;
			return fi.getFeature().getAllClassifier();
		}

		return null;
	}

	public static ComponentInstance getModule(ComponentInstance partition) {
		ComponentInstance module;

		/**
		 * The partition must be a virtual processor component.
		 */
		//XXX: [Code Coverage] partition is always a virtual processor.
		if (partition.getCategory() != ComponentCategory.VIRTUAL_PROCESSOR) {
			return null;
		}
		/**
		 * Try to get the module from the virtual processor partition.
		 */
		module = GetProperties.getBoundProcessor(partition);
		if (module == null) {
			module = partition.getContainingComponentInstance();
		}
		//XXX: [Code Coverage] module cannot be null.
		if ((module != null) && (module.getCategory() != ComponentCategory.VIRTUAL_PROCESSOR)) {
			return module;
		}
		return null;
	}

	/**
	 * return the offset of the partition start time relative to the major frame
	 * utilizes the window schedule of the module for the partition
	 * @param partition This can be a virtual processor representing a partition or a component instance tagged with SEI properties
	 * @return offset, no virtual processor as ARINC653 partition, or no processor.
	 */
	public static double getPartitionFrameOffset(ComponentInstance partition, List<ARINC653ScheduleWindow> schedule) {
		double res = 0.0;
		//XXX: [Code Coverage] schedule is never null.
		if ((schedule == null) || (schedule.size() == 0)) {
			return res;
		}
		for (ARINC653ScheduleWindow window : schedule) {
			if (window.getPartition() == partition) {
				return res;
			}

			res = res + window.getTime();
		}
		//XXX: [Code Coverage] partition is always in schedule.
		return 0.0;
	}

	public static boolean isInSchedule(ComponentInstance partition, List<ARINC653ScheduleWindow> schedule) {
		if (schedule == null) {
			return true;
		}
		for (ARINC653ScheduleWindow window : schedule) {
			if (window.getPartition() == partition) {
				return true;
			}
		}
		return false;
	}

	/**
	 * return the duration of the partition i.e., its window size.
	 * utilizes the window schedule of the module for the partition
	 * If no schedule: interpret WC execution time on partition as duration
	 * @param partition This is a virtual processor representing a partition
	 * @param schedule ARINC653 schedule
	 * @return window size (duration),  or 0 if no schedule.
	 */
	public static double getPartitionDuration(ComponentInstance partition, List<ARINC653ScheduleWindow> schedule) {
		if ((schedule == null) || (schedule.size() == 0)) {
			double wcet = GetProperties.getExecutionTimeInMS(partition);
			return wcet;
		}
		for (ARINC653ScheduleWindow window : schedule) {
			if (window.getPartition() == partition) {
				return window.getTime();
			}
		}
		return 0;
	}

	public static List<ARINC653ScheduleWindow> getModuleSchedule(ComponentInstance partition) {
		ComponentInstance module;
		List<ARINC653ScheduleWindow> schedule = null;
		//XXX: [Code Coverage] partition cannot be null.
		if (partition == null) {
			return schedule;
		}
		module = getModule(partition);
		if (module != null) {
			schedule = GetProperties.getModuleSchedule(module);

		}
		return schedule;
	}

	/**
	 * round up to the next sampling frame.
	 * If processing latency is zero then go to the next frame.
	 * If processing latency is already a multiple of a frame then use that boundary.
	 * Otherwise use the next multiple of the samplingLatency
	 * Parameters are assumed to have the same unit
	 * @param processingLatency double Can be larger than the sampling latency
	 * @param samplingLatency double Assumed to be non-zero
	 * @return double
	 */
	public static double roundUp(double processingLatency, double samplingLatency) {
		int frames = (int) (processingLatency / samplingLatency);
		if ((processingLatency % samplingLatency) > 0) {
			frames = frames + 1;
		} else if (processingLatency == 0) {
			frames = 1;
		}
		return (frames * samplingLatency);
	}

	/**
	 * Determine the amount needed to round up to the next frame
	 * It is the difference been the result of roundUp and processing latency
	 * @param processingLatency double
	 * @param samplingLatency double
	 * @return double
	 */
	public static double roundUpDiff(double processingLatency, double samplingLatency) {
		double diff = processingLatency % samplingLatency;
		if ((diff) > 0) {
			return samplingLatency - diff;
		} else if (processingLatency == 0) {
			return samplingLatency;
		} else {
			return 0;
		}
	}

	/**
	 * Determine the amount needed to round up to the target latency.
	 * If processing latency is larger than window then it flows into the next frame
	 * It is the difference been the result of roundUp and processing latency
	 * @param processingLatency double
	 * @param samplingLatency double
	 * @param targetLatency double
	 * @return double
	 */
	public static double roundUpDiff(double processingLatency, double samplingLatency, double targetLatency) {
		if (targetLatency == 0 || targetLatency == -1) {
			return 0;
		}
		double diff = targetLatency - (processingLatency % targetLatency);
		// deal with overflow into next frame.
		int extraslots = targetLatency == 0 ? 0 : (int) (processingLatency / targetLatency);
		return diff + (extraslots * samplingLatency);
	}


	public static String getMinMaxLabel(boolean doMax) {
		if (doMax) {
			return "Max: ";
		} else {
			return "Min: ";
		}
	}

	//XXX: [Code Coverage] Dead code.
	public static double getDimension(final NamedElement ne) {
		Property dimension = GetProperties.lookupPropertyDefinition(ne, DataModel._NAME, DataModel.Dimension);
		List<? extends PropertyExpression> propertyValues;
		try {
			propertyValues = ne.getPropertyValueList(dimension);
		} catch (Exception e) {
			return 1.0;
		}
		double res = 1.0;
		for (PropertyExpression propertyExpression : propertyValues) {
			res = res * ((NumberValue) propertyExpression).getScaledValue();
		}
		return res;
	}

	// -------------
	// Results
	// -------------

	@Deprecated
	public static AnalysisResult recordAsAnalysisResult(Collection<Result> results, EObject root,
			boolean asynchronousSystem, boolean majorFrameDelay, boolean worstCaseDeadline,
			boolean bestCaseEmptyQueue) {
		return recordAsAnalysisResult(results, root, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
				bestCaseEmptyQueue, false);
	}

	/**
	 * @since org.osate.analysis.flows 3.0
	 */
	public static AnalysisResult recordAsAnalysisResult(Collection<Result> results, EObject root,
			boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue,
			boolean disableQueuingLatency) {
		AnalysisResult latencyResults = createLatencyAnalysisResult(root, asynchronousSystem, majorFrameDelay,
				worstCaseDeadline, bestCaseEmptyQueue, disableQueuingLatency);
		if (!results.isEmpty()) {
			latencyResults.getResults().addAll(results);
		} else {
			Result err = ResultUtil.createErrorResult("No latency analysis result", root);
			latencyResults.getResults().add(err);
		}
		return latencyResults;
	}

	@Deprecated
	public static AnalysisResult createLatencyAnalysisResult(EObject root, boolean asynchronousSystem,
			boolean majorFrameDelay,
			boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		return createLatencyAnalysisResult(root, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
				bestCaseEmptyQueue, false);
	}

	/**
	 * @since org.osate.analysis.flows 3.0
	 */
	public static AnalysisResult createLatencyAnalysisResult(EObject root, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue,
			boolean disableQueuingLatency) {
		AnalysisResult latencyResults = ResultUtil.createAnalysisResult(FlowLatencyUtil.LatencyAnalysisName, root);
		ResultUtil.addParameter(latencyResults, asynchronousSystem);
		ResultUtil.addParameter(latencyResults, majorFrameDelay);
		ResultUtil.addParameter(latencyResults, worstCaseDeadline);
		ResultUtil.addParameter(latencyResults, bestCaseEmptyQueue);
		ResultUtil.addParameter(latencyResults, disableQueuingLatency);
		latencyResults.setMessage(FlowLatencyUtil.getParametersAsLabels(asynchronousSystem, majorFrameDelay,
				worstCaseDeadline, bestCaseEmptyQueue, disableQueuingLatency));
		latencyResults.setModelElement(root);
		return latencyResults;
	}

	public static String LatencyAnalysisName = "latency";

	public static URI getLantencyAnalysisResultURI(AnalysisResult results) {
		EObject root = results.getModelElement();
		URI rootURI = EcoreUtil.getURI(root).trimFragment().trimFileExtension();
		String rootname = rootURI.lastSegment();
		String postfix = getParametersAsLabels(results);
		return rootURI.trimFragment().trimFileExtension().trimSegments(1).appendSegment("reports")
				.appendSegment(LatencyAnalysisName).appendSegment(rootname + "__latency_" + postfix)
				.appendFileExtension("result");
	}

	public static void saveAnalysisResult(AnalysisResult results) {
		URI latencyURI = getLantencyAnalysisResultURI(results);
		Resource res = results.getModelElement().eResource().getResourceSet().createResource(latencyURI);
		res.getContents().add(results);
		try {
			res.save(null);
		} catch (IOException e) {
			StatusManager.getManager().handle(new Status(IStatus.ERROR, "org.osate.analysis.flows", e.getMessage(), e));
		}
	}

	public static String getParametersAsLabels(AnalysisResult results) {
		String labels = results.getMessage();
		if (results.getParameters().size() == 4) {
			labels = FlowLatencyUtil.getParametersAsLabels((boolean) results.getParameters().get(0).getValue(),
					(boolean) results.getParameters().get(1).getValue(),
					(boolean) results.getParameters().get(2).getValue(),
					(boolean) results.getParameters().get(3).getValue(),
					(boolean) results.getParameters().get(4).getValue());
		}
		return labels;
	}

	@Deprecated
	public static String getParametersAsLabels(boolean asynchronousSystem, boolean majorFrameDelay,
			boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		return getParametersAsLabels(asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue, false);
	}

	/**
	 * @since org.osate.analysis.flows 3.0
	 */
	public static String getParametersAsLabels(boolean asynchronousSystem, boolean majorFrameDelay,
			boolean worstCaseDeadline, boolean bestCaseEmptyQueue, boolean disableQueuingLatency) {
		return getAsynchronousSystemLabel(asynchronousSystem) + "-" + getMajorFrameDelayLabel(majorFrameDelay) + "-"
				+ getWorstCaseDeadlineLabel(worstCaseDeadline) + "-" + getBestcaseEmptyQueueLabel(bestCaseEmptyQueue)
				+ "-" + getDisableQueuingLatencyLabel(disableQueuingLatency);
	}

	public static String getAsynchronousSystemLabel(boolean isAsynchronous) {
		return isAsynchronous ? "AS" : "SS";
	}

	public static String getMajorFrameDelayLabel(boolean isMajorFrameDelay) {
		return isMajorFrameDelay ? "MF" : "PE";
	}

	public static String getWorstCaseDeadlineLabel(boolean isWorstCaseDeadline) {
		return isWorstCaseDeadline ? "DL" : "ET";
	}

	public static String getBestcaseEmptyQueueLabel(boolean isBestcaseEmptyQueue) {
		return isBestcaseEmptyQueue ? "EQ" : "FQ";
	}

	/**
	 * @since org.osate.analysis.flows 3.0
	 */
	public static String getDisableQueuingLatencyLabel(boolean disableQueuingLatency) {
		return disableQueuingLatency ? "DQL" : "EQL";
	}


	public static String getAsynchronousSystemDescription(boolean isAsynchronous) {
		return isAsynchronous ? "asynchronous system" : "synchronous system";
	}

	public static String getMajorFrameDelayDescription(boolean isMajorFrameDelay) {
		return isMajorFrameDelay ? "major partition frame" : "partition end";
	}

	public static String getWorstCaseDeadlineDescription(boolean worstCaseDeadline) {
		return worstCaseDeadline ? "worst case as deadline" : "worst case as max compute execution time";
	}

	public static String getBestcaseEmptyQueueDescription(boolean bestCaseEmptyQueue) {
		return bestCaseEmptyQueue ? "best case as empty queue"
				: "best case as full queue min compute execution time";
	}

	/**
	 * @since org.osate.analysis.flows 3.0
	 */
	public static String getDisableQueuingLatencyDescription(boolean disableQueuingLatency) {
		return disableQueuingLatency ? "queuing latency disabled" : "queuing latency enabled";
	}

	public static String getParametersAsDescriptions(AnalysisResult results) {
		String labels = results.getMessage();
		if (results.getParameters().size() == 4) {
			labels = FlowLatencyUtil.getParametersAsDescriptions((boolean) results.getParameters().get(0).getValue(),
					(boolean) results.getParameters().get(1).getValue(),
					(boolean) results.getParameters().get(2).getValue(),
					(boolean) results.getParameters().get(3).getValue(),
					(boolean) results.getParameters().get(4).getValue());
		}
		return labels;
	}

	@Deprecated
	public static String getParametersAsDescriptions(boolean asynchronousSystem, boolean majorFrameDelay,
			boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		return getParametersAsDescriptions(asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue,
				false);
	}

	/**
	 * @since org.osate.analysis.flows 3.0
	 */
	public static String getParametersAsDescriptions(boolean asynchronousSystem, boolean majorFrameDelay,
			boolean worstCaseDeadline, boolean bestCaseEmptyQueue, boolean disableQueuingLatency) {
		return getAsynchronousSystemDescription(asynchronousSystem) + "/"
				+ getMajorFrameDelayDescription(majorFrameDelay) + "/"
				+ getWorstCaseDeadlineDescription(worstCaseDeadline) + "/"
				+ getBestcaseEmptyQueueDescription(bestCaseEmptyQueue) + "/"
				+ getDisableQueuingLatencyDescription(disableQueuingLatency);
	}

	public static String getContributorType(EObject relatedElement) {
		if (relatedElement instanceof ComponentInstance) {
			ComponentInstance relatedComponentInstance = (ComponentInstance) relatedElement;
			if (relatedComponentInstance.getCategory() == ComponentCategory.VIRTUAL_BUS) {
				return "protocol";
			}
			if (relatedComponentInstance.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR) {
				return "partition";
			}
			return relatedComponentInstance.getCategory().getName();
		}
		if (relatedElement instanceof VirtualBus) {
			return "protocol";
		}
		if (relatedElement instanceof ComponentClassifier) {
			ComponentType relatedComponentType = (ComponentType) relatedElement;
			return relatedComponentType.getCategory().getName();
		}
		if (relatedElement instanceof ConnectionInstance) {
			if (FlowLatencyUtil.getConnectionType((ConnectionInstance) relatedElement) == ConnectionType.DELAYED) {
				return "delayed connection";
			}
			if (FlowLatencyUtil.getConnectionType((ConnectionInstance) relatedElement) == ConnectionType.IMMEDIATE) {
				return "immediate connection";
			}
			if (FlowLatencyUtil.getConnectionType((ConnectionInstance) relatedElement) == ConnectionType.SAMPLED) {
				return "connection";
			}
			return "connection";
		}
		return "component";
	}

	public static String getFullComponentContributorName(EObject relatedElement) {
		if (relatedElement instanceof ConnectionInstance) {
			return ((ConnectionInstance) relatedElement).getName();
		} else if (relatedElement instanceof InstanceObject) {
			return ((InstanceObject) relatedElement).getComponentInstancePath();
		}
		return "";
	}


}
