/*
 * Created on July 7, 2004
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * @version $Id: FlowLatencyAnalysisSwitch.java,v 1.71.2.13 2011-07-01 16:39:24 relief Exp $
 */
package org.osate.analysis.flows;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.analysis.flows.model.LatencyContributor;
import org.osate.analysis.flows.model.LatencyContributor.LatencyContributorMethod;
import org.osate.analysis.flows.model.LatencyContributorComponent;
import org.osate.analysis.flows.model.LatencyContributorConnection;
import org.osate.analysis.flows.model.LatencyReport;
import org.osate.analysis.flows.model.LatencyReportEntry;
import org.osate.analysis.flows.preferences.Values;
import org.osate.xtext.aadl2.properties.util.ARINC653ScheduleWindow;
import org.osate.xtext.aadl2.properties.util.CommunicationProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

/**
 * @author phf
 *
 * This class provides for flow analysis
 *
 */
public class FlowLatencyAnalysisSwitch extends AadlProcessingSwitchWithProgress {
	LatencyReport report;
	SystemOperationMode som;

	public FlowLatencyAnalysisSwitch(final IProgressMonitor monitor,SystemInstance si, LatencyReport r,
			SystemOperationMode som) {
		super(monitor, PROCESS_PRE_ORDER_ALL);
		this.report = r; // new LatencyReport(si)
		this.som = som;
	}


	@Override
	protected final void initSwitches() {
		/* here we are creating the connection checking switches */

		instanceSwitch = new InstanceSwitch<String>() {
			/**
			 * check flow latency
			 */
			@Override
			public String caseComponentInstance(final ComponentInstance ci) {
				return DONE;
			}

			@Override
			public String caseEndToEndFlowInstance(final EndToEndFlowInstance etef) {
				LatencyReportEntry entry;

				if (etef.getFlowElements().isEmpty()) {
					return DONE;
				}
				entry = new LatencyReportEntry(etef, som);

				for (FlowElementInstance fei : etef.getFlowElements()) {
					mapFlowElementInstance(etef, fei, entry);
				}
				entry.finalizeReportEntry();
				report.addEntry(entry);
				return DONE;
			}
		};
	}

	public void mapFlowElementInstance(final EndToEndFlowInstance etef, final FlowElementInstance flowElementInstance,
			LatencyReportEntry entry) {

		if (flowElementInstance instanceof FlowSpecificationInstance
				|| flowElementInstance instanceof ComponentInstance) {

			mapComponentInstance(etef, flowElementInstance, entry);
		}

		if (flowElementInstance instanceof ConnectionInstance) {
			mapConnectionInstance(etef, flowElementInstance, entry);
		}

		if (flowElementInstance instanceof EndToEndFlowInstance) {

			for (FlowElementInstance fei : ((EndToEndFlowInstance) flowElementInstance).getFlowElements()) {
				mapFlowElementInstance(etef, fei, entry);
			}
		}
	}

	public void mapComponentInstance(final EndToEndFlowInstance etef, final FlowElementInstance flowElementInstance,
			LatencyReportEntry entry) {
		ComponentInstance componentInstance;
		double expectedMin = GetProperties.getMinimumLatencyinMilliSec(flowElementInstance);
		double expectedMax = GetProperties.getMaximumLatencyinMilliSec(flowElementInstance);

		if (flowElementInstance instanceof FlowSpecificationInstance) {
			componentInstance = flowElementInstance.getComponentInstance();
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

		/**
		 * The component is periodic. Therefore it will sample its input unless we have an immediate connection or delayed connection
		 */
		boolean checkLastImmediate = false;
		if (period > 0 && ((InstanceModelUtil.isThread(componentInstance)
				|| InstanceModelUtil.isDevice(componentInstance) || InstanceModelUtil.isAbstract(componentInstance))
						? (!InstanceModelUtil.isSporadicComponent(componentInstance)
								&& !InstanceModelUtil.isTimedComponent(componentInstance)
								&& !InstanceModelUtil.isAperiodicComponent(componentInstance))
						: true)) {
			// period is set, and if thread, abstract, or device needs to be dispatched as periodic
			LatencyContributorComponent samplingLatencyContributor = new LatencyContributorComponent(componentInstance);
			samplingLatencyContributor.setSamplingPeriod(period);
			if ((InstanceModelUtil.isThread(componentInstance) || InstanceModelUtil.isDevice(componentInstance))
					&& !GetProperties.hasAssignedPropertyValue(componentInstance, "Dispatch_Protocol")) {
				samplingLatencyContributor.reportInfo("Assume Periodic dispatch because period is set");
			}
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

		LatencyContributorComponent processingLatencyContributor = new LatencyContributorComponent(componentInstance);

		if (executionTimeHigher != 0.0) {
			if (!Values.doWorstCaseDeadline()) {
				// Use execution time for worst-case if preferences specify not deadline or no deadline is specified
				worstCaseValue = executionTimeHigher;
				worstmethod = LatencyContributorMethod.PROCESSING_TIME;
			} else if (!isAssignedDeadline) {
				worstCaseValue = executionTimeHigher;
				worstmethod = LatencyContributorMethod.PROCESSING_TIME;
				processingLatencyContributor.reportInfo("Using execution time as deadline was not set");
			}
		}

		if ((worstCaseValue == 0.0) && isAssignedDeadline && Values.doWorstCaseDeadline()) {
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
			processingLatencyContributor.reportInfo("Using deadline as execution time was not set");
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

		if ((bestCaseValue == 0.0) && (expectedMin != 0.0)) {
			bestCaseValue = expectedMin;
			bestmethod = LatencyContributorMethod.SPECIFIED;
		}

		// deal with queuing latency
		// take into account queuing delay
		FeatureInstance fi = FlowLatencyUtil.getIncomingFeatureInstance(etef, flowElementInstance);
		if (fi != null) {
			double qs = GetProperties.getQueueSize(fi);
			boolean hasAssignedQueueSize = GetProperties.hasAssignedPropertyValue(fi,
					CommunicationProperties.QUEUE_SIZE);
			if (hasAssignedQueueSize && qs != 0) {
				LatencyContributorComponent ql = new LatencyContributorComponent(componentInstance);
				// take into account queuing delay on event and event data ports.
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

	public void mapConnectionInstance(final EndToEndFlowInstance etef, final FlowElementInstance flowElementInstance,
			LatencyReportEntry entry) {
		ConnectionInstance connectionInstance = (ConnectionInstance) flowElementInstance;

		double expectedMin = GetProperties.getMinimumLatencyinMilliSec(flowElementInstance);
		double expectedMax = GetProperties.getMaximumLatencyinMilliSec(flowElementInstance);

		Classifier relatedConnectionData = FlowLatencyUtil.getConnectionData(connectionInstance);
		ComponentInstance componentInstanceSource = InstanceModelUtil.getRelatedComponentSource(connectionInstance);
		ComponentInstance componentInstanceDestination = InstanceModelUtil
				.getRelatedComponentDestination(connectionInstance);

		ComponentInstance srcHW = InstanceModelUtil.getHardwareComponent(componentInstanceSource);
		ComponentInstance dstHW = InstanceModelUtil.getHardwareComponent(componentInstanceDestination);
		ComponentInstance srcPartition = FlowLatencyUtil.getPartition(componentInstanceSource);
		ComponentInstance dstPartition = FlowLatencyUtil.getPartition(componentInstanceDestination);

		// if we exit a partition then we may have I/O Delay until the end of the partition window or the end of the major frame
		if (srcPartition != null && srcPartition != dstPartition) {
			double partitionLatency = FlowLatencyUtil.getPartitionPeriod(srcPartition);
			List<ARINC653ScheduleWindow> schedule = FlowLatencyUtil.getModuleSchedule(srcPartition);
			double partitionDuration = FlowLatencyUtil.getPartitionDuration(srcPartition, schedule);
			if (partitionDuration != -1) {
				LatencyContributor ioLatencyContributor = new LatencyContributorComponent(srcPartition);
				ioLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_OUTPUT);
				ioLatencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_OUTPUT);
				ioLatencyContributor.setSamplingPeriod(partitionLatency);
				double frameOffset = FlowLatencyUtil.getPartitionFrameOffset(srcPartition, schedule);
				ioLatencyContributor.setPartitionOffset(frameOffset);
				ioLatencyContributor.setPartitionDuration(partitionDuration);
				entry.addContributor(ioLatencyContributor);
			}
		}

		// now we deal with communication latency
		LatencyContributor latencyContributor = new LatencyContributorConnection(connectionInstance);

		processActualConnectionBindingsSampling(connectionInstance, latencyContributor);
		processActualConnectionBindingsTransmission(connectionInstance,
				relatedConnectionData == null ? 0.0 : GetProperties.getDataSizeInBytes(relatedConnectionData),
				latencyContributor);
		/**
		 * handle the case when there is no binding to virtual bus or bus.
		 * In this case we use the latency from the connection itself
		 */
		// XXX we can add a check whether the latencies coming from the bindings exceeds the connection latency

		if (latencyContributor.getSubContributors().isEmpty()) {
			if (expectedMax > 0) {
				latencyContributor.setWorstCaseMethod(LatencyContributorMethod.SPECIFIED);
				latencyContributor.setExpectedMaximum(expectedMax);
			}
			if (expectedMin > 0) {
				latencyContributor.setBestCaseMethod(LatencyContributorMethod.SPECIFIED);
				latencyContributor.setExpectedMinimum(expectedMin);
			}
		} else {
			latencyContributor.reportInfo("Adding latency subtotal from protocols and bus - shown with ()");
		}
		// set synchronous if on same processor
		if (srcHW != null && dstHW != null) {
			// we have two hardware components. One or both could be a device
			ComponentInstance srcTime = GetProperties.getReferenceTime(srcHW);
			ComponentInstance dstTime = GetProperties.getReferenceTime(dstHW);
			if (srcHW == dstHW) {
				latencyContributor.setSynchronous();
			} else if (srcTime != null && dstTime != null) {
				if (srcTime == dstTime) {
					latencyContributor.setSynchronous();
				} else {
					latencyContributor.setAsynchronous();
				}
			} else {
				latencyContributor.setSyncUnknown();
			}
		} else {
			// at least one end is not bound to a hardware component
			// set synchronous if in same partition. This may be the case if the partitions are not bound yet to a processor
			if (dstPartition != null && srcPartition != null) {
				if (srcPartition == dstPartition) {
					latencyContributor.setSynchronous();
				} else {
					// no else part: partitions are unbound so we want to have both a sync and async analysis
					latencyContributor.setSyncUnknown();
				}
			}
		}
		entry.addContributor(latencyContributor);

		// now deal with cross partition sampling latency
		// We add a separate latency contributor

		if (dstPartition != null && srcPartition != dstPartition) {
			// add partition latency if the destination is a partition and it is different from the source partition (or null)
			double partitionLatency = FlowLatencyUtil.getPartitionPeriod(dstPartition);
			List<ARINC653ScheduleWindow> schedule = FlowLatencyUtil.getModuleSchedule(srcPartition);
			double partitionDuration = FlowLatencyUtil.getPartitionDuration(dstPartition, schedule);
			if (partitionDuration != -1) {
				LatencyContributorComponent platencyContributor = new LatencyContributorComponent(dstPartition);
				platencyContributor.setSamplingPeriod(partitionLatency);
				double frameOffset = FlowLatencyUtil.getPartitionFrameOffset(dstPartition, schedule);
				platencyContributor.setPartitionOffset(frameOffset);
				platencyContributor.setPartitionDuration(partitionDuration);
				platencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
				platencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
				entry.addContributor(platencyContributor);
			} else {
				LatencyContributorComponent platencyContributor = new LatencyContributorComponent(dstPartition);
				platencyContributor.setSamplingPeriod(partitionLatency);
				platencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
				platencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
				entry.addContributor(platencyContributor);
			}
		}
	}

	/**
	 * add latency sub-contribution due to transmission by bus (or virtual bus)
	 * works for an instance object and for a classifier.
	 * We determine the transmission latency from the data size and transmission time property.
	 * If not present we get it from the latency property.
	 * If neither is present and we are a connection or virtual bus we do not add a latency.
	 * If we are HW component, we add unknown latency.
	 * targetMedium: a connection instance, or the binding target (virtual bus or bus)
	 * transmissionDataSize: the size of data to be transmitted.
	 * latencyContributor: the place where we add a subcontributor.
	 */
	public void processTransmissionTime(NamedElement targetMedium, double datasizeinbyte,
			LatencyContributor latencyContributor) {

		if (targetMedium != null) {

			double maxBusLatency = GetProperties.getMaximumLatencyinMilliSec(targetMedium);
			double minBusLatency = GetProperties.getMinimumLatencyinMilliSec(targetMedium);
			double maxBusTransferTime = GetProperties.getMaximumTimeToTransferData(targetMedium, datasizeinbyte);
			double minBusTransferTime = GetProperties.getMinimumTimeToTransferData(targetMedium, datasizeinbyte);
			if (maxBusLatency == 0 && maxBusTransferTime == 0 && targetMedium instanceof ConnectionInstance
					|| (targetMedium instanceof ComponentInstance && ((ComponentInstance) targetMedium).getCategory()
							.equals(ComponentCategory.VIRTUAL_BUS))) {
				// connection or protocol has nothing to contribute
				return;
			}
			LatencyContributor subContributor = new LatencyContributorComponent(targetMedium);
			subContributor.setExpectedMaximum(maxBusLatency);
			subContributor.setExpectedMinimum(minBusLatency);
			if (maxBusTransferTime > 0) {
				subContributor.setMaximum(maxBusTransferTime);
				subContributor.reportInfo("Using data transfer time");
				if (datasizeinbyte == 0.0) {
					subContributor.reportInfo("Data size = 0. Possibly data type on port missing");
				}
				subContributor.setWorstCaseMethod(LatencyContributorMethod.TRANSMISSION_TIME);
			} else if (maxBusLatency > 0) {
				subContributor.setMaximum(maxBusLatency);
				subContributor.setWorstCaseMethod(LatencyContributorMethod.SPECIFIED);
				subContributor.reportInfo("Using specified bus latency");
			} else {
				subContributor.setWorstCaseMethod(LatencyContributorMethod.UNKNOWN);
			}

			if (minBusTransferTime > 0) {
				subContributor.setMinimum(minBusTransferTime);
				subContributor.setBestCaseMethod(LatencyContributorMethod.TRANSMISSION_TIME);

			} else if (minBusLatency > 0) {
				subContributor.setMinimum(minBusLatency);
				subContributor.setBestCaseMethod(LatencyContributorMethod.SPECIFIED);
			} else {
				subContributor.setBestCaseMethod(LatencyContributorMethod.UNKNOWN);
			}
			latencyContributor.addSubContributor(subContributor);
		}
	}

	public void processActualConnectionBindingsTransmission(InstanceObject connorvb, double transmissionDataSize,
			LatencyContributor latencyContributor) {
		boolean willDoVirtualBuses = false;
		boolean willDoBuses = false;
		// look for actual binding if we have a connection instance or virtual bus instance
		List<ComponentInstance> bindings = GetProperties.getActualConnectionBinding(connorvb);
		if (bindings.isEmpty()) {
			// add specified latency if present
			processTransmissionTime(connorvb, 0, latencyContributor);
			return;
		}
		for (ComponentInstance componentInstance : bindings) {
			if (componentInstance.getCategory().equals(ComponentCategory.VIRTUAL_BUS)) {
				willDoVirtualBuses = true;
			} else {
				willDoBuses = true;
			}
		}
		if (!willDoVirtualBuses) {
			/**
			 * required virtual bus class indicates protocols the connection intends to use.
			 * We also can have an actual connection binding to a virtual bus
			 * If we have that we want to use that virtual bus overhead
			 */
			List<ComponentClassifier> protocols = GetProperties.getRequiredVirtualBusClass(connorvb);
			if ((protocols != null) && (protocols.size() > 0)) {
				if (willDoBuses) {
					latencyContributor.reportInfo("Adding required virtual bus contributions to bound bus");
				}
				transmissionDataSize = computeTotalDataSize(protocols, transmissionDataSize, latencyContributor);
			}

		}

		for (ComponentInstance componentInstance : bindings) {
			double wrappedDataSize = transmissionDataSize + GetProperties.getDataSizeInBytes(componentInstance);
			processTransmissionTime(componentInstance, wrappedDataSize, latencyContributor);
			if (componentInstance.getCategory().equals(ComponentCategory.VIRTUAL_BUS)) {
				processActualConnectionBindingsTransmission(componentInstance, wrappedDataSize, latencyContributor);
			}
		}
	}

	/**
	 * calculate the protocol data size contributions.
	 * Do so for any RequiredVirtualBusClass of each protocol recursively.
	 * @param protocols
	 * @return
	 */
	public double computeTotalDataSize(List<ComponentClassifier> protocols, double transmissionDataSize,
			LatencyContributor latencyContributor) {
		double total = transmissionDataSize;
		for (ComponentClassifier cc : protocols) {
			double contribution = GetProperties.getDataSizeInBytes(cc);
			double wrapped = transmissionDataSize + contribution;
			processTransmissionTime(cc, wrapped, latencyContributor);
			total = total + contribution;
			List<ComponentClassifier> reqprotocols = GetProperties.getRequiredVirtualBusClass(cc);
			if (!reqprotocols.isEmpty()) {
				total = total + computeTotalDataSize(reqprotocols, wrapped, latencyContributor);
			}
		}
		return total;

	}

	public void processActualConnectionBindingsSampling(NamedElement connorvb, LatencyContributor latencyContributor) {
		boolean willDoVirtualBuses = false;
		boolean willDoBuses = false;
		if (connorvb instanceof InstanceObject) {
			// look for actual binding if we have a connection instance or virtual bus instance
			List<ComponentInstance> bindings = GetProperties.getActualConnectionBinding((InstanceObject) connorvb);
			for (ComponentInstance componentInstance : bindings) {
				if (componentInstance.getCategory().equals(ComponentCategory.VIRTUAL_BUS)) {
					willDoVirtualBuses = true;
				} else {
					willDoBuses = true;
				}
			}
			/**
			 * required virtual bus class indicates protocols the connection intends to use.
			 * We also can have an actual connection binding to a virtual bus
			 * If we have that we want to use that virtual bus overhead
			 */
			if (!willDoVirtualBuses) {
				List<ComponentClassifier> protocols = GetProperties.getRequiredVirtualBusClass(connorvb);
				if ((protocols != null) && (protocols.size() > 0)) {
					if (willDoBuses) {
						latencyContributor.reportInfo("Adding required virtual bus contributions to bound bus");
					}
					for (ComponentClassifier cc : protocols) {
						processSamplingTime(cc, latencyContributor);
						processActualConnectionBindingsSampling(cc, latencyContributor);
					}
				}
			}

			for (ComponentInstance componentInstance : bindings) {
				processSamplingTime(componentInstance, latencyContributor);
				if (componentInstance.getCategory().equals(ComponentCategory.VIRTUAL_BUS)) {
					processActualConnectionBindingsSampling(componentInstance, latencyContributor);
				}
			}
		}

	}

	public void processSamplingTime(NamedElement boundBus, LatencyContributor latencyContributor) {
		/**
		 * we add the bus/VB sampling time as a subcontributor.
		 */

		if (boundBus != null) {
			double period = GetProperties.getPeriodinMS(boundBus);
			if (period > 0) {
				// add sampling latency due to the protocol or bus being periodic
				LatencyContributor samplingLatencyContributor = new LatencyContributorComponent(boundBus);
				samplingLatencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED_PROTOCOL);
				samplingLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED_PROTOCOL);
				samplingLatencyContributor.setSamplingPeriod(period);

				latencyContributor.addSubContributor(samplingLatencyContributor);
			}
		}
	}


}
