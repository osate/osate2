package org.osate.analysis.flows;

import java.util.Collection;
import java.util.List;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.analysis.flows.model.ConnectionType;
import org.osate.contribution.sei.names.DataModel;
import org.osate.xtext.aadl2.properties.util.ARINC653ScheduleWindow;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

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

	public static boolean hasPreviousConnection(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		return etef.getFlowElements().indexOf(flowElementInstance) > 0;
	}

	public static FeatureInstance getIncomingFeatureInstance(final EndToEndFlowInstance etef,
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
		if ((nextElement != null)) {
			return (getConnectionType(nextElement) == ConnectionType.DELAYED);
		}

		return false;
	}

	public static boolean isNextConnectionDelayed(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance nextElement = getNextConnection(etef, flowElementInstance);
		if ((nextElement != null)) {
			return (getConnectionType(nextElement) == ConnectionType.DELAYED);
		}

		return false;
	}

	public static boolean isPreviousConnectionSampled(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance nextElement = getPreviousConnection(etef, flowElementInstance);
		if ((nextElement != null)) {
			return (getConnectionType(nextElement) == ConnectionType.SAMPLED);
		}

		return false;
	}

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

		if ((el != null) && (el.getName().equalsIgnoreCase("immediate"))) {
			return ConnectionType.IMMEDIATE;
		}
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
	 * Get the next thread/device period within an end to end flow after the flow element
	 * given as attribute.
	 * @param etef - the end to end flow
	 * @param flowElementInstance - the element to search from
	 * @return - the flow element period that is a thread and is after flowElementInstance
	 */
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
	 * find component tagged with isPartition and return its partition latency (period)
	 * @param ci
	 * @return
	 */
	public static double getSEIPartitionPeriod(ComponentInstance ci) {
		while (ci != null) {
			if (GetProperties.getIsPartition(ci)) {
				double res = GetProperties.getPartitionLatencyInMilliSec(ci, 0.0);
				return res;
			}
			ci = ci.getContainingComponentInstance();
		}
		return 0.0;
	}

	/**
	 * find component tagged with isPartition and has Partition Latency value, either the component itself or an enclosing component (enclosing process for a thread)
	 * @param ci
	 * @return
	 */
	public static ComponentInstance getSEIPartition(ComponentInstance ci) {
		while (ci != null) {
			if (GetProperties.getIsPartition(ci)) {
				double res = GetProperties.getPartitionLatencyInMilliSec(ci, 0.0);
				if (res > 0) {
					return ci;
				}
			}
			ci = ci.getContainingComponentInstance();
		}
		return null;
	}

	/**
	 * find virtual processor representing SEI tagged or ARINC653 partition (bound to processor with ARINC653 major frame)
	 * @param componentInstance system, process, thread or other entity bound to a processor and running inside a partition.
	 * @return partition
	 */
	public static ComponentInstance getVirtualProcessorPartition(ComponentInstance componentInstance) {
		double res = 0.0;
		Collection<ComponentInstance> vprocessors = InstanceModelUtil.getBoundVirtualProcessors(componentInstance);
		for (ComponentInstance vproc : vprocessors) {
			Collection<ComponentInstance> procs = InstanceModelUtil.getBoundPhysicalProcessors(vproc);
			for (ComponentInstance proc : procs) {
				res = GetProperties.getARINC653ModuleMajorFrame(proc);
				if (res == 0.0) {
					res = FlowLatencyUtil.getARINC653ProcessorMajorFrameFromSchedule(proc);
				}
				if (res > 0.0) {
					return vproc;
				}
			}
			res = GetProperties.getPartitionLatencyInMilliSec(vproc, 0.0);
			if (res > 0.0) {
				return vproc;
			}
		}
		return null;
	}

	/**
	 * Get the major frame from the processor supporting ARINC653 partitions, or form bound virtual processor tagged with SEI partition properties
	 * @param componentInstance system, process, thread or other entity whose partition we try to identify
	 * @return partition period supported by virtual processor
	 */
	public static double getVirtualProcessorPartitionPeriod(ComponentInstance componentInstance) {
		double res = 0.0;
		Collection<ComponentInstance> vprocessors = InstanceModelUtil.getBoundVirtualProcessors(componentInstance);
		for (ComponentInstance vproc : vprocessors) {
			res = GetProperties.getARINC653ModuleMajorFrame(vproc);
			if (res > 0.0) {
				return res;
			}
			res = GetProperties.getPartitionLatencyInMilliSec(vproc, 0.0);
			if (res > 0.0) {
				return res;
			}
		}
		return res;
	}

	/**
	 * Get the the processor supporting ARINC653 partitions
	 * @param componentInstance system, process, thread or other entity bound to a processor and running inside a partition.
	 * @return processor supporting ARINC653
	 */
	public static ComponentInstance getARINC653PartitionProcessor(ComponentInstance componentInstance) {
		double res = 0.0;
		Collection<ComponentInstance> processors = InstanceModelUtil.getBoundPhysicalProcessors(componentInstance);
		for (ComponentInstance proc : processors) {
			res = GetProperties.getARINC653ModuleMajorFrame(proc);
			if (res > 0.0) {
				return proc;
			}
		}
		return null;
	}

	/**
	 * Get the major frame from the processor supporting ARINC653 partitions
	 * @param componentInstance system, process, thread or other entity bound to a processor and running inside a partition.
	 * @return partition period supported by processor
	 */
	public static double getARINC653ProcessorMajorFrame(ComponentInstance componentInstance) {
		double res = 0.0;
		Collection<ComponentInstance> processors = InstanceModelUtil.getBoundPhysicalProcessors(componentInstance);
		for (ComponentInstance proc : processors) {
			res = GetProperties.getARINC653ModuleMajorFrame(proc);
			if (res > 0.0) {
				return res;
			}
		}
		return res;
	}

	/**
	 * Get the major frame from the processor supporting ARINC653 partitions from its schedule
	 * @param componentInstance system, process, thread or other entity bound to a processor and running inside a partition.
	 * @return partition period supported by processor
	 */
	public static double getARINC653ProcessorMajorFrameFromSchedule(ComponentInstance componentInstance) {
		double res = 0.0;
		if (InstanceModelUtil.isProcessor(componentInstance)) {
			List<ARINC653ScheduleWindow> schedule = GetProperties.getModuleSchedule(componentInstance);
			if ((schedule != null) && (schedule.size() > 0)) {
				for (ARINC653ScheduleWindow window : schedule) {
					res = res + window.getTime();
				}
				return res;
			}
		} else {
			Collection<ComponentInstance> processors = InstanceModelUtil.getBoundPhysicalProcessors(componentInstance);
			for (ComponentInstance proc : processors) {
				List<ARINC653ScheduleWindow> schedule = GetProperties.getModuleSchedule(proc);
				if ((schedule != null) && (schedule.size() > 0)) {
					for (ARINC653ScheduleWindow window : schedule) {
						res = res + window.getTime();
					}
					return res;
				}
			}
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

		if ((module != null) && (module.getCategory() == ComponentCategory.PROCESSOR)) {
			return module;
		}
		return null;
	}

	/**
	 * return the offset of the partition start time relative to the major frame
	 * utilizes the window schedule of the module for the partition
	 * @param partition This can be a virtual processor representing a partition or a component instance tagged with SEI properties
	 * @return offset or -1 if no schedule, no virtual processor as ARINC653 partition, or no processor.
	 */
	public static double getPartitionFrameOffset(ComponentInstance partition) {
		ComponentInstance module;
		List<ARINC653ScheduleWindow> schedule;
		double res;
		if (partition == null) {
			return -1;
		}

		res = 0;
		module = getModule(partition);
		if (module == null) {
			return -1;
		}
		schedule = GetProperties.getModuleSchedule(module);

		if ((schedule == null) || (schedule.size() == 0)) {
			return -1;
		}
		for (ARINC653ScheduleWindow window : schedule) {
			if (window.getPartition() == partition) {
				return res;
			}

			res = res + window.getTime();
		}
		return 0;
	}

	/**
	 * return the duration of the partition i.e., its window size.
	 * utilizes the window schedule of the module for the partition
	 * @param partition This can be a virtual processor representing a partition or a component instance tagged with SEI properties
	 * @return window size (duration),  or -1 if no schedule, no virtual processor as ARINC653 partition, or no processor.
	 */
	public static double getPartitionDuration(ComponentInstance partition) {
		ComponentInstance module;
		List<ARINC653ScheduleWindow> schedule;
		if (partition == null) {
			return -1;
		}
		module = getModule(partition);
		if (module == null) {
			return -1;
		}
		schedule = GetProperties.getModuleSchedule(module);

		if ((schedule == null) || (schedule.size() == 0)) {
			return -1;
		}
		for (ARINC653ScheduleWindow window : schedule) {
			if (window.getPartition() == partition) {
				return window.getTime();
			}
		}
		return -1;
	}

	public static double getPartitionReceiverLatencyWithSchedule(ComponentInstance partition) {
		return getPartitionFrameOffset(partition);
	}

	public static double getPartitionSenderLatencyWithSchedule(ComponentInstance partition) {
		ComponentInstance module;
		List<ARINC653ScheduleWindow> schedule;
		double res;
		boolean found = false;

		if (partition == null) {
			return 0;
		}

		res = 0;
		module = getModule(partition);
		schedule = GetProperties.getModuleSchedule(module);

		if ((schedule == null) || (schedule.size() == 0)) {
			return 0;
		}

		found = false;

		for (ARINC653ScheduleWindow window : schedule) {
			if (found == true) {
				res = res + window.getTime();
			}

			if (window.getPartition() == partition) {
				found = true;
			}

		}
		return res;
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

	/**
	 * return the component tagged with SEI partition or with ARINC653 major frame properties, or bound to a processor with ARINC653 properties
	 * @param ci Component Instance
	 * @return Component Instance
	 */
	public static ComponentInstance getPartition(ComponentInstance ci) {
		ComponentInstance partition = FlowLatencyUtil.getVirtualProcessorPartition(ci);
		if (partition == null) {
			partition = FlowLatencyUtil.getSEIPartition(ci);
		}
		return partition;
	}

	/**
	 * get the partition latency, either from the virtual processor representing the partition, or from the SEI partition properties on the component instance itself
	 * @param ci Component Instance (process, thread, system, etc.
	 * @return partition period as latency contributor
	 */
	public static double getPartitionLatency(ComponentInstance ci) {
		double res = FlowLatencyUtil.getARINC653ProcessorMajorFrame(ci);
		if (res == 0.0) {
			res = FlowLatencyUtil.getARINC653ProcessorMajorFrameFromSchedule(ci);
		}
		if (res == 0.0) {
			res = FlowLatencyUtil.getVirtualProcessorPartitionPeriod(ci);
		}
		if (res == 0.0) {
			res = FlowLatencyUtil.getSEIPartitionPeriod(ci);
		}
		return res;
	}

	public static String getMinMaxLabel(boolean doMax) {
		if (doMax) {
			return "Max: ";
		} else {
			return "Min: ";
		}
	}

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

}
