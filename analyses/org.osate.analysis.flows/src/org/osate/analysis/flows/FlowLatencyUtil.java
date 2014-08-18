package org.osate.analysis.flows;

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
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.analysis.flows.model.ConnectionType;
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

	public static boolean isNextConnectionLocal(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		FlowElementInstance nextElement;
		nextElement = getNextFlowElement(etef, flowElementInstance);

		if ((nextElement != null) && (nextElement instanceof ConnectionInstance)) {
			return (isLocal((ConnectionInstance) nextElement));
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
		int n = etef.getFlowElements().indexOf(flowElementInstance);
		if (n + 1 < etef.getFlowElements().size()) {
			return etef.getFlowElements().get(n + 1);
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

	/**
	 * find the next connection within an end to end flow
	 * @param etef - the end to end flow where to search
	 * @param flowElementInstance - the element from where we start the search
	 * @return a connectioninstance object that is the next connection in the flow. null otherwise.
	 */
	public static FlowElementInstance getNextConnection(final EndToEndFlowInstance etef,
			final FlowElementInstance flowElementInstance) {
		boolean found;
		int n;

		found = false;

		for (n = 0; n < etef.getFlowElements().size(); n++) {
			if (found) {
				FlowElementInstance fei = etef.getFlowElements().get(n);
				if (fei instanceof ConnectionInstance) {
					return fei;
				}
			}

			if (etef.getFlowElements().get(n) == flowElementInstance) {
				found = true;

			}
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
		ComponentInstance process;

		processor = null;
		process = componentInstance;

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
	 * Indicate if a connection is between two tasks located on the same processor.
	 * @param connection - the connection
	 * @return true if both connection ends are on the same processor
	 */
	public static boolean isLocal(ConnectionInstance connection) {
		ConnectionInstanceEnd connSource;
		ConnectionInstanceEnd connDest;
		ComponentInstance componentSource;
		ComponentInstance componentDestination;

		ComponentInstance processorFromSource;
		ComponentInstance processorFromDestination;

		connSource = connection.getSource();
		connDest = connection.getDestination();

		if (connSource instanceof FeatureInstance) {
			connSource = connSource.getContainingComponentInstance();
		}

		if (connDest instanceof FeatureInstance) {
			connDest = connDest.getContainingComponentInstance();
		}

		componentSource = connSource.getComponentInstance();
		componentDestination = connDest.getComponentInstance();

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
		ComponentInstance module;

		module = getModule(partition);
		GetProperties.getModuleSchedule(module);
		/**
		 * FIXME- wait for bug #413 to be solved to continue
		 */
		return 0;
	}

	public static double getPartitionSenderLatencyWithSchedule(ComponentInstance partition) {
		ComponentInstance module;

		module = getModule(partition);
		GetProperties.getModuleSchedule(module);
		/**
		 * FIXME- wait for bug #413 to be solved to continue
		 */
		return 0;
	}

}
