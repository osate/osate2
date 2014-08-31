package org.osate.analysis.flows;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.analysis.flows.model.ConnectionType;
import org.osate.xtext.aadl2.properties.util.ARINC653ScheduleWindow;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

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

	public static boolean isPreviousConnectionImmediate(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance nextElement = getPreviousConnection(etef, flowElementInstance);
		if ((nextElement != null)) {
			return (getConnectionType(nextElement) == ConnectionType.IMMEDIATE);
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
			return (getConnectionType((ConnectionInstance) nextElement) == ConnectionType.DELAYED);
		}

		return false;
	}

	public static boolean isNextConnectionDelayed(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance nextElement = getNextConnection(etef, flowElementInstance);
		if ((nextElement != null)) {
			return (getConnectionType((ConnectionInstance) nextElement) == ConnectionType.DELAYED);
		}

		return false;
	}

	public static boolean isPreviousConnectionSampled(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance nextElement = getPreviousConnection(etef, flowElementInstance);
		if ((nextElement != null)) {
			return (getConnectionType((ConnectionInstance) nextElement) == ConnectionType.SAMPLED);
		}

		return false;
	}

	public static boolean isNextConnectionSampled(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance nextElement = getNextConnection(etef, flowElementInstance);
		if ((nextElement != null)) {
			return (getConnectionType((ConnectionInstance) nextElement) == ConnectionType.SAMPLED);
		}

		return false;
	}

	public static boolean isNextConnectionLocal(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		ConnectionInstance nextElement = getNextConnection(etef, flowElementInstance);
		if ((nextElement != null)) {
			return (isLocal((ConnectionInstance) nextElement));
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
		if (n + 1 < etef.getFlowElements().size()) {
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
	 * @return a connectioninstance object that is the previous connection in the flow. null otherwise.
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
	 * Get the processor for a thread or process. the category argument specifies if we want
	 * a processor or virtual processor.
	 * @param componentInstance - the thread/process that is supposed to be bound
	 * @param category - the category of the component to be returned. It can be a processor or virtual processor
	 * @return - the first processor or virtual processor bound. Null if nothing is found
	 */
	public static ComponentInstance getProcessorForProcessOrThread(ComponentInstance componentInstance,
			ComponentCategory category) {
		ComponentInstance processor;

		processor = null;

		if (componentInstance.getCategory() == ComponentCategory.THREAD) {
			processor = GetProperties.getBoundProcessor(componentInstance);

			if (processor == null) {
				/**
				 * if the thread is not bound to a processor, we try to get 
				 * the processor of the related process.
				 */
				return getProcessorForProcessOrThread(getEnclosingProcess(componentInstance), category);
			}
		}

		if ((componentInstance.getCategory() == ComponentCategory.DEVICE)
				|| (componentInstance.getCategory() == ComponentCategory.PROCESS)) {
			processor = GetProperties.getBoundProcessor(componentInstance);
		}

		if ((processor != null) && (processor.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
				&& (category == ComponentCategory.PROCESSOR)) {
			processor = processor.getContainingComponentInstance();
		}

		return ((processor != null) && (processor.getCategory()) == category) ? processor : null;
	}

	/**
	 * get hardware of connection end.
	 * @param ci
	 * @return
	 */
	public static ComponentInstance getHardwareComponent(ComponentInstance ci) {
		ComponentInstance p;
		if (ci.getCategory() == ComponentCategory.DEVICE) {
			return ci;
		}
		List<ComponentInstance> cil = GetProperties.getActualProcessorBinding(ci);
		if (cil.isEmpty())
			return null;
		p = (ComponentInstance) cil.get(0);
		if (p.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR) {
			ComponentInstance res = getHardwareComponent(p);
			if (res == null) {
				res = getEnclosingProcessor(p);
			}
			return res;
		}

		return p;
	}

	public static ComponentInstance getEnclosingProcessor(ComponentInstance vpi) {
		ComponentInstance ci = vpi;
		while (ci != null) {
			ci = ci.getContainingComponentInstance();
			if (ci.getCategory().equals(ComponentCategory.PROCESSOR)) {
				return ci;
			}
		}
		return null;
	}

	/**
	 * Get the component that is connected at the source side of the connection.
	 * @param connectionInstance - the connection to process
	 * @return - the component that is the source
	 */
	public static ComponentInstance getRelatedComponentSource(ConnectionInstance connectionInstance) {
		ConnectionInstanceEnd sourceEnd;
		ComponentInstance source;

		source = null;
		sourceEnd = connectionInstance.getSource();

		if (!(sourceEnd instanceof ComponentInstance)) {
			source = sourceEnd.getContainingComponentInstance();
		} else {
			source = (ComponentInstance) sourceEnd;
		}
		return source;
	}

	/**
	 * Get the component that is connected at the destination side of the connection.
	 * @param connectionInstance - the connection to be processed
	 * @return - the component that is the connection destination (and not its feature)
	 */
	public static ComponentInstance getRelatedComponentDestination(ConnectionInstance connectionInstance) {
		ConnectionInstanceEnd destinationEnd;
		ComponentInstance destination = null;
		destinationEnd = connectionInstance.getDestination();

		if (!(destinationEnd instanceof ComponentInstance)) {
			destination = destinationEnd.getContainingComponentInstance();
		} else {
			destination = (ComponentInstance) destinationEnd;
		}
		return destination;
	}

	/**
	 * returns list of buses connecting to HW components. Can be empty list (if same component), or null (no connection).
	 * @param source HW component
	 * @param destination HW component
	 * @return list of buses involved in the physical connection
	 */
	public static EList<ComponentInstance> connectedByBus(ComponentInstance srcHW, ComponentInstance dstHW) {
		EList<ComponentInstance> visitedBuses = new UniqueEList<ComponentInstance>();
		return doConnectedByBus(srcHW, dstHW, visitedBuses);
	}

	/**
	 * returns list of buses connecting to HW components. Can be empty list (if same component), or null (no connection).
	 * @param source HW component
	 * @param destination HW component
	 * @return list of buses involved in the physical connection
	 */
	protected static EList<ComponentInstance> doConnectedByBus(ComponentInstance srcHW, ComponentInstance dstHW,
			EList<ComponentInstance> visitedBuses) {
		if (srcHW == null || dstHW == null)
			return null;
		if (srcHW == dstHW)
			return null;
		EList<FeatureInstance> busaccesslist = srcHW.getFeatureInstances();
		for (FeatureInstance fi : busaccesslist) {
			if (fi.getCategory() == FeatureCategory.BUS_ACCESS) {
				EList<ConnectionInstance> acl = fi.getDstConnectionInstances();
				boolean opposite = false;
				if (acl.isEmpty()) {
					acl = fi.getSrcConnectionInstances();
					opposite = true;
				}
				for (ConnectionInstance aci : acl) {
					ComponentInstance curBus = opposite ? (ComponentInstance) aci.getDestination()
							: (ComponentInstance) aci.getSource();
					if (!visitedBuses.contains(curBus)) {
						if (connectedToBus(dstHW, curBus)) {
							BasicEList<ComponentInstance> res = new BasicEList<ComponentInstance>();
							res.add(curBus);
							return res;
						} else {
							// first check if there is a bus this bus is connected to
							visitedBuses.add(curBus);
							EList<ComponentInstance> res = doConnectedByBus(curBus, dstHW, visitedBuses);
							if (res != null) {
								res.add(0, curBus);
								return res;
							} else {
								// check for buses that are connected to this bus
								EList<ConnectionInstance> bcl = curBus.getSrcConnectionInstances();
								boolean cbOpposite = false;
								if (bcl.isEmpty()) {
									bcl = curBus.getDstConnectionInstances();
									cbOpposite = true;
								}
								for (ConnectionInstance srcaci : bcl) {
									ComponentInstance bi = cbOpposite ? srcaci.getSource()
											.getContainingComponentInstance() : srcaci.getDestination()
											.getContainingComponentInstance();
									if (bi.getCategory() == ComponentCategory.BUS) {
										if (connectedToBus(dstHW, bi)) {
											res = new BasicEList<ComponentInstance>();
											res.add(bi);
											return res;
										} else {
											visitedBuses.add(bi);
											res = doConnectedByBus(bi, dstHW, visitedBuses);
											if (res != null) {
												res.add(0, curBus);
												return res;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * is hardware component connected (directly) to the given bus
	 * @param HWcomp ComponentInstance hardware component
	 * @param bus ComponentInstance bus component
	 * @return true if they are connected by bus access connection
	 */
	public static boolean connectedToBus(ComponentInstance HWcomp, ComponentInstance bus) {
		EList<ConnectionInstance> acl = bus.getSrcConnectionInstances();
		for (ConnectionInstance srcaci : acl) {
			if (srcaci.getDestination().getContainingComponentInstance() == HWcomp) {
				return true;
			}
		}
		return false;
	}

	/**
	 * is hardware component connected (directly) to the given bus, incl. bus to bus
	 * @param HWcomp ComponentInstance hardware component
	 * @param bus ComponentInstance bus component
	 * @return access connection instance if they are connected by bus access connection
	 */
	public static ConnectionInstance getBusAccessConnection(ComponentInstance HWcomp, ComponentInstance bus) {
		EList<ConnectionInstance> acl = bus.getSrcConnectionInstances();
		for (ConnectionInstance srcaci : acl) {
			if (srcaci.getDestination().getContainingComponentInstance() == HWcomp) {
				return srcaci;
			}
		}
		if (HWcomp.getCategory() == ComponentCategory.BUS) {
			// check the other way
			acl = HWcomp.getSrcConnectionInstances();
			for (ConnectionInstance srcaci : acl) {
				if (srcaci.getDestination().getContainingComponentInstance() == bus) {
					return srcaci;
				}
			}
		}
		return null;
	}

	/**
	 * Get the list of all the buses a process can access through its required
	 * bus access features.
	 * @param processor - the processor that has bus access features
	 * @return - the list of all bus components that can be access by the processor.
	 */
	public static List<ComponentInstance> getAccessedBuses(ComponentInstance processor) {
		List<ComponentInstance> buses;
		List<ConnectionInstance> connections;
		ConnectionInstanceEnd cie;

		buses = new ArrayList<ComponentInstance>();
		connections = new ArrayList<ConnectionInstance>();

		for (FeatureInstance fi : processor.getFeatureInstances()) {
			if (fi.getCategory() == FeatureCategory.BUS_ACCESS) {
				connections.addAll(fi.getSrcConnectionInstances());
				connections.addAll(fi.getDstConnectionInstances());

				for (ConnectionInstance ci : connections) {
					cie = ci.getSource();
//					OsateDebug.osateDebug("FlowLatencyLogicConnection", "cie=" + cie);

					cie = ci.getDestination();
					if (cie instanceof ComponentInstance) {
						if (((ComponentInstance) cie).getCategory() == ComponentCategory.BUS) {
							buses.add((ComponentInstance) cie);
						}
					}
//					OsateDebug.osateDebug("FlowLatencyLogicConnection", "cie=" + cie);
				}
			}
		}
		return buses;
	}

	/**
	 * Get the bus for a connection. If the bus is not found, we try
	 * to get the bus by inspecting the component bound (processor)
	 * to each part of the connection (thread/process/device).
	 * 
	 * If the connection is directly bound to a bus through the property
	 * mechanism, we automatically return it.
	 * 
	 * @param connectionInstance - the connection instance
	 * @return the bus bound to the connection.
	 */
	public static EList<ComponentInstance> deriveBoundBuses(ConnectionInstance connectionInstance) {
		ComponentInstance connectionSource = FlowLatencyUtil.getRelatedComponentSource(connectionInstance);
		ComponentInstance conenctionDestination = FlowLatencyUtil.getRelatedComponentDestination(connectionInstance);
		ComponentInstance srcHW = FlowLatencyUtil.getHardwareComponent(connectionSource);
		ComponentInstance dstHW = FlowLatencyUtil.getHardwareComponent(conenctionDestination);
		EList<ComponentInstance> res = FlowLatencyUtil.connectedByBus(srcHW, dstHW);
		return res;
	}

	/**
	 * Indicate if a connection is between two tasks located on the same processor.
	 * @param connection - the connection
	 * @return true if both connection ends are on the same processor
	 */
	// XXX: this one needs some work.
	public static boolean isLocal(ConnectionInstance connection) {
		ComponentInstance componentSource = FlowLatencyUtil.getRelatedComponentSource(connection);
		ComponentInstance componentDestination = FlowLatencyUtil.getRelatedComponentDestination(connection);

		ComponentInstance processorFromSource;
		ComponentInstance processorFromDestination;

		if ((componentSource.getCategory() == ComponentCategory.THREAD)
				&& (componentDestination.getCategory() == ComponentCategory.THREAD)) {
			processorFromSource = GetProperties.getBoundProcessor(componentSource);
			processorFromDestination = GetProperties.getBoundProcessor(componentDestination);

			if ((processorFromSource == null) || (processorFromDestination == null)) {
				return false;
			}

			/**
			 * If the processor is bound to a virtual processor, we have a partitioned
			 * system. In that case, we need to get the main processor to see
			 * if the connection is local (or not).
			 */
			if (processorFromSource.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR) {
				processorFromSource = processorFromSource.getContainingComponentInstance();
			}

			if (processorFromDestination.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR) {
				processorFromDestination = processorFromDestination.getContainingComponentInstance();
			}

			if (processorFromSource == processorFromDestination) {
				return true;
			}

		}
		return false;
	}

	/**
	 * return the process component that contains the thread
	 * @param component - the thread component
	 * @return - the process that contains the thread
	 */
	public static ComponentInstance getEnclosingProcess(ComponentInstance component) {
		ComponentInstance result;

		result = component.getContainingComponentInstance();

		return result;
	}

	public static Classifier getConnectionData(ConnectionInstance connectionInstance) {
		Classifier data;
		ConnectionInstanceEnd cei;
		FeatureInstance fi;

		data = null;

		cei = connectionInstance.getSource();

		if (cei instanceof FeatureInstance) {
			fi = (FeatureInstance) cei;
			if (fi.getFeature() instanceof DataPort) {
				DataPort dp = (DataPort) fi.getFeature();
				if (dp.getDataFeatureClassifier() != null) {
					data = dp.getDataFeatureClassifier().getContainingClassifier();
				}
			}

			if (fi.getFeature() instanceof EventDataPort) {
				EventDataPort edp = (EventDataPort) fi.getFeature();
				if (edp.getDataFeatureClassifier() != null) {
					data = edp.getDataFeatureClassifier().getContainingClassifier();
				}
			}
		}

		return data;
	}

	private static double getMaximumTransmissionTimePerByte(final ComponentInstance bus) {
		RecordValue rv;
		RangeValue bpa;
		NumberValue nv;
		rv = GetProperties.getTransmissionTime(bus);
		if (rv == null) {
			return 0;
		}
		bpa = (RangeValue) PropertyUtils.getRecordFieldValue(rv, "PerByte");
		if (bpa != null) {
			nv = bpa.getMaximumValue();
			return nv.getScaledValue(GetProperties.getMSUnitLiteral(bus));
		}
		return 0;
	}

	private static double getMaximumTransmissionTimeFixed(final ComponentInstance bus) {
		RecordValue rv;
		RangeValue bpa;
		NumberValue nv;
		rv = GetProperties.getTransmissionTime(bus);
		if (rv == null) {
			return 0;
		}
		bpa = (RangeValue) PropertyUtils.getRecordFieldValue(rv, "Fixed");
		if (bpa != null) {
			nv = bpa.getMaximumValue();
			return nv.getScaledValue(GetProperties.getMSUnitLiteral(bus));
		}
		return 0;
	}

	private static double getMinimumTransmissionTimePerByte(final ComponentInstance bus) {
		RecordValue rv;
		RangeValue bpa;
		NumberValue nv;
		rv = GetProperties.getTransmissionTime(bus);
		if (rv == null) {
			return 0;
		}
		bpa = (RangeValue) PropertyUtils.getRecordFieldValue(rv, "PerByte");
		if (bpa != null) {
			nv = bpa.getMinimumValue();
			return nv.getScaledValue(GetProperties.getMSUnitLiteral(bus));
		}
		return 0;
	}

	private static double getMinimumTransmissionTimeFixed(final ComponentInstance bus) {
		RecordValue rv;
		RangeValue bpa;
		NumberValue nv;
		rv = GetProperties.getTransmissionTime(bus);
		if (rv == null) {
			return 0;
		}
		bpa = (RangeValue) PropertyUtils.getRecordFieldValue(rv, "Fixed");
		if (bpa != null) {
			nv = bpa.getMinimumValue();
			return nv.getScaledValue(GetProperties.getMSUnitLiteral(bus));
		}
		return 0;
	}

	public static double getMaximumTimeToTransferData(final ComponentInstance bus, Classifier dataClassifier) {
		double dataSize;
		double speed;
		double dataTransferTime;
		double acquisitionTime;

		dataSize = GetProperties.getSourceDataSizeInBytes(dataClassifier);
		speed = getMaximumTransmissionTimePerByte(bus);
		dataTransferTime = speed * dataSize;

		acquisitionTime = getMaximumTransmissionTimeFixed(bus);

		return dataTransferTime + acquisitionTime;
	}

	public static double getMinimumTimeToTransferData(final ComponentInstance bus, Classifier dataClassifier) {
		double dataSize;
		double speed;
		double dataTransferTime;
		double acquisitionTime;

		dataSize = GetProperties.getSourceDataSizeInBytes(dataClassifier);
		speed = getMinimumTransmissionTimePerByte(bus);
		dataTransferTime = speed * dataSize;

		acquisitionTime = getMinimumTransmissionTimeFixed(bus);

		return dataTransferTime + acquisitionTime;
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

	public static double getPartitionReceiverLatencyWithSchedule(ComponentInstance partition) {
		return getPartitionFrameOffset(partition);
	}

	/**
	 * return the offset of the partition start time relative to the major frame
	 * utilizes the window schedule of the module for the partition
	 * @param partition
	 * @return
	 */
	public static double getPartitionFrameOffset(ComponentInstance partition) {
		ComponentInstance module;
		List<ARINC653ScheduleWindow> schedule;
		double res;
		if (partition == null) {
			return 0;
		}

		res = 0;
		module = getModule(partition);
		schedule = GetProperties.getModuleSchedule(module);

		if ((schedule == null) || (schedule.size() == 0)) {
			return 0;
		}
		for (ARINC653ScheduleWindow window : schedule) {
			if (window.getPartition() == partition) {
				return res;
			}

			res = res + window.getTime();
		}
		return 0;
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
		} else
			return 0;
	}

}
