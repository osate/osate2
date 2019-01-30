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
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.analysis.flows.model.LatencyCSVReport;
import org.osate.analysis.flows.model.LatencyContributor;
import org.osate.analysis.flows.model.LatencyContributor.LatencyContributorMethod;
import org.osate.analysis.flows.model.LatencyContributorComponent;
import org.osate.analysis.flows.model.LatencyContributorConnection;
import org.osate.analysis.flows.model.LatencyReport;
import org.osate.analysis.flows.model.LatencyReportEntry;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
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

	public FlowLatencyAnalysisSwitch() {
		super(new NullProgressMonitor(), PROCESS_PRE_ORDER_ALL);
	}

	public FlowLatencyAnalysisSwitch(SystemInstance si) {
		this(new NullProgressMonitor(), si, null);
	}

	public FlowLatencyAnalysisSwitch(final IProgressMonitor monitor, SystemInstance si) {
		this(monitor, si, null);
	}

	public FlowLatencyAnalysisSwitch(final IProgressMonitor monitor, SystemInstance si, LatencyReport latreport) {
		super(monitor, PROCESS_PRE_ORDER_ALL);
		if (latreport == null) {
			report = new LatencyReport();
			report.setRootinstance(si);
		} else {
			report = latreport;
		}
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

				//XXX: [Code Coverage] etef.getFlowElements() cannot be empty.
				if (etef.getFlowElements().isEmpty()) {
					return DONE;
				}
				entry = analyzeLatency(etef, etef.getSystemInstance().getCurrentSystemOperationMode(),
						report.isAsynchronousSystem());
				report.addEntry(entry);
				return DONE;
			}
		};
	}

	public LatencyReportEntry analyzeLatency(EndToEndFlowInstance etef, SystemOperationMode som,
			boolean asynchronousSystem) {
		LatencyReportEntry entry = new LatencyReportEntry(etef, som, asynchronousSystem, report.isMajorFrameDelay());
		for (FlowElementInstance fei : etef.getFlowElements()) {
			mapFlowElementInstance(etef, fei, entry);
		}
		entry.finalizeReportEntry();
		return entry;
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

		FeatureInstance incomingConnectionFI = FlowLatencyUtil.getIncomingConnectionFeatureInstance(etef,
				flowElementInstance);

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
			// we have a periodic component that samples
			if (incomingConnectionFI != null) {
				// it is not the first component in the ETEF. We need to add sampling latency
				if (incomingConnectionFI.getCategory() == FeatureCategory.DATA_PORT
						|| incomingConnectionFI.getCategory() == FeatureCategory.ABSTRACT_FEATURE) {
					// sampling incoming data
					// period is set, and if thread, abstract, or device needs to be dispatched as periodic
					// We sample only data ports. Event and event data ports have queuing latency
					LatencyContributorComponent samplingLatencyContributor = new LatencyContributorComponent(
							componentInstance, report.isMajorFrameDelay());
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
						samplingLatencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED);
						samplingLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED);
						samplingLatencyContributor.setSamplingPeriod(period);
					}
					entry.addContributor(samplingLatencyContributor);
				} else {
					// queuing latency handled later
					// do nothing here
				}
			} else {
				// The periodic component is the first component in the ETEF
				// record fact that first element is periodic so we can process synchronous behavior correctly
				LatencyContributorComponent samplingLatencyContributor = new LatencyContributorComponent(
						componentInstance, report.isMajorFrameDelay());
				samplingLatencyContributor.setBestCaseMethod(LatencyContributorMethod.FIRST_PERIODIC);
				samplingLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.FIRST_PERIODIC);
				entry.addContributor(samplingLatencyContributor);
			}
		} else {
			// the component is not executing periodically
			if (entry.getContributors().isEmpty()) {
				// insert first partition sampling for the aperiodic case. For other partitions it is inserted by connection processing
				ComponentInstance firstPartition = FlowLatencyUtil.getPartition(componentInstance);
				if (firstPartition != null) {
					double partitionLatency = FlowLatencyUtil.getPartitionPeriod(firstPartition);
					List<ARINC653ScheduleWindow> schedule = FlowLatencyUtil.getModuleSchedule(firstPartition);
					double partitionDuration = FlowLatencyUtil.getPartitionDuration(firstPartition, schedule);
					LatencyContributorComponent platencyContributor = new LatencyContributorComponent(firstPartition,
							report.isMajorFrameDelay());
					if (!FlowLatencyUtil.isInSchedule(firstPartition, schedule)) {
						platencyContributor.reportWarning("Partition not found in ARINC653 schedule of processor "
								+ FlowLatencyUtil.getModule(firstPartition).getName());
					}
					if (partitionDuration > 0) {
						platencyContributor.setSamplingPeriod(partitionLatency);
						double frameOffset = FlowLatencyUtil.getPartitionFrameOffset(firstPartition, schedule);
						platencyContributor.setPartitionOffset(frameOffset);
						platencyContributor.setPartitionDuration(partitionDuration);
						platencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
						platencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
						entry.addContributor(platencyContributor);
					} else {
						platencyContributor.setSamplingPeriod(partitionLatency);
						platencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
						platencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_FRAME);
						entry.addContributor(platencyContributor);
					}
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

		LatencyContributorComponent processingLatencyContributor = new LatencyContributorComponent(componentInstance,
				report.isMajorFrameDelay());

		if (executionTimeHigher != 0.0) {
			if (!report.isWorstCaseDeadline()) {
				// Use execution time for worst-case if preferences specify not deadline or no deadline is specified
				worstCaseValue = executionTimeHigher;
				worstmethod = LatencyContributorMethod.PROCESSING_TIME;
			} else if (!isAssignedDeadline) {
				worstCaseValue = executionTimeHigher;
				worstmethod = LatencyContributorMethod.PROCESSING_TIME;
				processingLatencyContributor.reportInfo("Using execution time as deadline was not set");
			}
		}

		if ((worstCaseValue == 0.0) && isAssignedDeadline && report.isWorstCaseDeadline()) {
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
		if (incomingConnectionFI != null) {
			double qs = 0;
			LatencyContributorComponent ql = new LatencyContributorComponent(componentInstance,
					report.isMajorFrameDelay());
			if (GetProperties.hasAssignedPropertyValue(incomingConnectionFI, CommunicationProperties.QUEUE_SIZE)) {
				qs = GetProperties.getQueueSize(incomingConnectionFI);
			} else if (incomingConnectionFI.getCategory() == FeatureCategory.DATA_PORT
					&& (InstanceModelUtil.isSporadicComponent(componentInstance)
							|| InstanceModelUtil.isTimedComponent(componentInstance)
							|| InstanceModelUtil.isAperiodicComponent(componentInstance))) {
				// treat data port as a port of queue size 1 when not a sampling thread
				qs = 1;
				ql.reportInfo("Data port as queue size 1 for sporadic, aperiodic, timed dispatch");
			}
			if (qs != 0) {
				// take into account queuing delay on event and event data ports.
				double dl = 0.0;
				if (InstanceModelUtil.isSporadicComponent(componentInstance)
						|| InstanceModelUtil.isPeriodicComponent(componentInstance)) {
					dl = period;
					ql.reportInfo("Sporadic or periodic has period delay per queue element");
				} else {
					dl = worstCaseValue;
				}
				double queuingDelay = qs * dl;
				ql.setMaximum(queuingDelay);
				if (report.isBestcaseEmptyQueue()) {
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
			if (partitionDuration > 0) {
				LatencyContributor ioLatencyContributor = new LatencyContributorComponent(srcPartition,
						report.isMajorFrameDelay());
				if (!FlowLatencyUtil.isInSchedule(srcPartition, schedule)) {
					ioLatencyContributor.reportWarning("Partition not found in ARINC653 schedule of processor "
							+ FlowLatencyUtil.getModule(srcPartition).getName());
				}
				ioLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_OUTPUT);
				ioLatencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_OUTPUT);
				if (partitionLatency == 0) {
					ioLatencyContributor.setSamplingPeriod(partitionDuration);
					ioLatencyContributor.reportInfo("No partition period/rate. Using partition duration");
				} else {
					ioLatencyContributor.setSamplingPeriod(partitionLatency);
				}
				double frameOffset = FlowLatencyUtil.getPartitionFrameOffset(srcPartition, schedule);
				ioLatencyContributor.setPartitionOffset(frameOffset);
				ioLatencyContributor.setPartitionDuration(partitionDuration);
				entry.addContributor(ioLatencyContributor);
			}
		}

		// now we deal with communication latency
		LatencyContributor latencyContributor = new LatencyContributorConnection(connectionInstance,
				report.isMajorFrameDelay());

		processActualConnectionBindingsSampling(connectionInstance, latencyContributor);
		processActualConnectionBindingsTransmission(connectionInstance,
				relatedConnectionData == null ? 0.0 : GetProperties.getDataSizeInBytes(relatedConnectionData),
				latencyContributor);
		/**
		 * handle the case when there is no binding to virtual bus or bus.
		 * In this case we use the latency from the connection itself
		 */
		// XXX we can add a check whether the latencies coming from the bindings exceeds the connection latency

		if (expectedMax > 0) {
			latencyContributor.setWorstCaseMethod(LatencyContributorMethod.SPECIFIED);
			latencyContributor.setExpectedMaximum(expectedMax);
		}
		if (expectedMin > 0) {
			latencyContributor.setBestCaseMethod(LatencyContributorMethod.SPECIFIED);
			latencyContributor.setExpectedMinimum(expectedMin);
		}
		if (latencyContributor.getSubContributors().isEmpty()) {
			if (expectedMax > 0) {
				latencyContributor.setMaximum(expectedMax);
			}
			if (expectedMin > 0) {
				latencyContributor.setMinimum(expectedMin);
			}
		} else {
			latencyContributor.reportInfo("Adding latency subtotal from protocols and hardware - shown with ()");
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
			List<ARINC653ScheduleWindow> schedule = FlowLatencyUtil.getModuleSchedule(dstPartition);
			double partitionDuration = FlowLatencyUtil.getPartitionDuration(dstPartition, schedule);
			LatencyContributorComponent platencyContributor = new LatencyContributorComponent(dstPartition,
					report.isMajorFrameDelay());
			if (!FlowLatencyUtil.isInSchedule(dstPartition, schedule)) {
				platencyContributor.reportWarning("Partition not found in ARINC653 schedule of processor "
						+ FlowLatencyUtil.getModule(dstPartition).getName());
			}
			if (partitionDuration > 0) {
				double frameOffset = FlowLatencyUtil.getPartitionFrameOffset(dstPartition, schedule);
				platencyContributor.setPartitionOffset(frameOffset);
				if (partitionLatency == 0) {
					platencyContributor.setSamplingPeriod(partitionDuration);
					platencyContributor.reportInfo("No partition period. Using partition duration");
				} else {
					platencyContributor.setSamplingPeriod(partitionLatency);
				}
				platencyContributor.setPartitionDuration(partitionDuration);
				platencyContributor.setWorstCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
				platencyContributor.setBestCaseMethod(LatencyContributorMethod.PARTITION_SCHEDULE);
				entry.addContributor(platencyContributor);
			} else {
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
		//XXX: [Code Coverage] targetMedium cannot be null.
		if (targetMedium != null) {

			double maxBusLatency = GetProperties.getMaximumLatencyinMilliSec(targetMedium);
			double minBusLatency = GetProperties.getMinimumLatencyinMilliSec(targetMedium);
			double maxBusTransferTime = GetProperties.getMaximumTimeToTransferData(targetMedium, datasizeinbyte);
			double minBusTransferTime = GetProperties.getMinimumTimeToTransferData(targetMedium, datasizeinbyte);
			if (maxBusLatency == 0 && maxBusTransferTime == 0) {
				// connection or protocol has nothing to contribute
				return;
			}
			LatencyContributor subContributor = new LatencyContributorComponent(targetMedium,
					report.isMajorFrameDelay());
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
				//XXX: [Code Coverage] Only executable if maxBusTransferTime or maxBusLatency is negative.
				subContributor.setWorstCaseMethod(LatencyContributorMethod.UNKNOWN);
			}

			if (minBusTransferTime > 0) {
				subContributor.setMinimum(minBusTransferTime);
				subContributor.setBestCaseMethod(LatencyContributorMethod.TRANSMISSION_TIME);

			} else if (minBusLatency > 0) {
				subContributor.setMinimum(minBusLatency);
				subContributor.setBestCaseMethod(LatencyContributorMethod.SPECIFIED);
			} else {
				//XXX: [Code Coverage] Only executable if minBusTransferTime or minBusLatency is negative.
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
			//XXX: [Code Coverage] protocols cannot be null.
			if ((protocols != null) && (protocols.size() > 0)) {
				//XXX: [Code Coverage] willDoBuses is always true if willDoVirtualBuses is false.
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

	//XXX: [Code Coverage] First parameter should be ConnectionInstance. Recursive call is a no-op.
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
				//XXX: [Code Coverage] protocols cannot be null.
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

		//XXX: [Code Coverage] boundBus cannot be null.
		if (boundBus != null) {
			double period = GetProperties.getPeriodinMS(boundBus);
			if (period > 0) {
				// add sampling latency due to the protocol or bus being periodic
				LatencyContributor samplingLatencyContributor = new LatencyContributorComponent(boundBus,
						report.isMajorFrameDelay());
				samplingLatencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED_PROTOCOL);
				samplingLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED_PROTOCOL);
				samplingLatencyContributor.setSamplingPeriod(period);

				latencyContributor.addSubContributor(samplingLatencyContributor);
			}
		}
	}

	/**
	 * Invoke the analysis on all ETEF in system instance and return Result collection
	 *
	 * @param root The root system instance
	 * @param som The mode to run the analysis in. If null then run all SOMs
	 * @param asynchronousSystem Whether the system is treated as synchronous by default
	 * @param majorFrameDelay Whether partition output is performed at a major frame (as opposed to the partition end)
	 * @param worstCaseDeadline Use deadline based processing (as opposed to max compute execution time)
	 * @param bestCaseEmptyQueue Assume empty queue (instead of full)
	 * @return A populated report in AnalysisResult format.
	 */
	public AnalysisResult invoke(SystemInstance root, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		EList<Result> results = new BasicEList<Result>();
		if (som == null) {
			if (root.getSystemOperationModes().isEmpty()
					|| root.getSystemOperationModes().get(0).getCurrentModes().isEmpty()) {
				// no SOM
				results = invokeOnSOM(root, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
						bestCaseEmptyQueue);
			} else {
				// we need to run it for every SOM
				for (SystemOperationMode eachsom : root.getSystemOperationModes()) {
					root.setCurrentSystemOperationMode(eachsom);
					results.addAll(invokeOnSOM(root, eachsom, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
							bestCaseEmptyQueue));
					root.clearCurrentSystemOperationMode();
				}
			}
		} else {
			results = invokeOnSOM(root, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
					bestCaseEmptyQueue);
		}
		return FlowLatencyUtil.recordAsAnalysisResult(results, root, asynchronousSystem, majorFrameDelay,
				worstCaseDeadline, bestCaseEmptyQueue);
	}

	/**
	 * Invoke the analysis on all ETEF in system instance and return Result collection
	 *
	 * @param ci The component instance that owns the end to end flow instances
	 * @param som The mode to run the analysis in.
	 * @param asynchronousSystem Whether the system is treated as asynchronous
	 * @param majorFrameDelay Whether partition output is performed at a major frame (as opposed to the partition end)
	 * @param worstCaseDeadline Use deadline based processing (as opposed to max compute execution time)
	 * @param bestCaseEmptyQueue Assume empty queue (instead of full)
	 * @return A populated report in AnalysisResult format.
	 */
	private EList<Result> invokeOnSOM(SystemInstance si, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		EList<Result> results = new BasicEList<Result>();
		List<EndToEndFlowInstance> alletef = EcoreUtil2.getAllContentsOfType(si, EndToEndFlowInstance.class);
		for (EndToEndFlowInstance etef : alletef) {
			results.addAll(
					invokeOnSOM(etef, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue));
		}
		return results;
	}

	/**
	 * Invoke the analysis on all ETEF owned by the given component instance and return Result collection
	 *
	 * @param ci The component instance that owns the end to end flow instances
	 * @param som The mode to run the analysis in. If null then run all SOMs
	 * @param asynchronousSystem Whether the system is treated as asynchronous
	 * @param majorFrameDelay Whether partition output is performed at a major frame (as opposed to the partition end)
	 * @param worstCaseDeadline Use deadline based processing (as opposed to max compute execution time)
	 * @param bestCaseEmptyQueue Assume empty queue (instead of full)
	 * @return A populated report in AnalysisResult format.
	 */
	public AnalysisResult invoke(ComponentInstance ci, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		SystemInstance root = ci.getSystemInstance();
		EList<Result> results = new BasicEList<Result>();
		if (som == null) {
			if (root.getSystemOperationModes().isEmpty()
					|| root.getSystemOperationModes().get(0).getCurrentModes().isEmpty()) {
				// no SOM
				results = invokeOnSOM(ci, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
						bestCaseEmptyQueue);
			} else {
				// we need to run it for every SOM
				for (SystemOperationMode eachsom : root.getSystemOperationModes()) {
					root.setCurrentSystemOperationMode(eachsom);
					results.addAll(invokeOnSOM(ci, eachsom, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
							bestCaseEmptyQueue));
					root.clearCurrentSystemOperationMode();
				}
			}
		} else {
			results = invokeOnSOM(ci, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue);
		}
		return FlowLatencyUtil.recordAsAnalysisResult(results, root, asynchronousSystem, majorFrameDelay,
				worstCaseDeadline, bestCaseEmptyQueue);
	}

	/**
	 * Invoke the analysis on all ETEF owned by the given component instance and return Result collection
	 *
	 * @param ci The component instance that owns the end to end flow instances
	 * @param som The mode to run the analysis in.
	 * @param asynchronousSystem Whether the system is treated as asynchronous
	 * @param majorFrameDelay Whether partition output is performed at a major frame (as opposed to the partition end)
	 * @param worstCaseDeadline Use deadline based processing (as opposed to max compute execution time)
	 * @param bestCaseEmptyQueue Assume empty queue (instead of full)
	 * @return A populated report in AnalysisResult format.
	 */
	private EList<Result> invokeOnSOM(ComponentInstance ci, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		EList<Result> results = new BasicEList<Result>();
		for (EndToEndFlowInstance etef : ci.getEndToEndFlows()) {
			results.addAll(
					invokeOnSOM(etef, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue));
		}
		return results;
	}

	/**
	 * Invoke the analysis on all ETEF owned by the given component instance and return Result collection
	 *
	 * @param etef The end to end flow instance
	 * @param som The mode to run the analysis in. If null then run all SOMs
	 * @param asynchronousSystem Whether the system is treated as asynchronous
	 * @param majorFrameDelay Whether partition output is performed at a major frame (as opposed to the partition end)
	 * @param worstCaseDeadline Use deadline based processing (as opposed to max compute execution time)
	 * @param bestCaseEmptyQueue Assume empty queue (instead of full)
	 * @return A populated report in AnalysisResult format.
	 */
	public AnalysisResult invoke(EndToEndFlowInstance etef, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		SystemInstance root = etef.getSystemInstance();
		EList<Result> results = new BasicEList<Result>();
		if (som == null) {
			SystemOperationMode som0 = root.getSystemOperationModes().get(0);
			if (root.getSystemOperationModes().isEmpty()
					|| root.getSystemOperationModes().get(0).getCurrentModes().isEmpty()) {
				// no SOM
				results = invokeOnSOM(etef, som0, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
						bestCaseEmptyQueue);
			} else {
				// we need to run it for every SOM
				for (SystemOperationMode eachsom : root.getSystemOperationModes()) {
					root.setCurrentSystemOperationMode(eachsom);
					results.addAll(invokeOnSOM(etef, eachsom, asynchronousSystem, majorFrameDelay,
							worstCaseDeadline, bestCaseEmptyQueue));
					root.clearCurrentSystemOperationMode();
				}
			}
		} else {
			results = invokeOnSOM(etef, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
					bestCaseEmptyQueue);
		}
		return FlowLatencyUtil.recordAsAnalysisResult(results, root, asynchronousSystem, majorFrameDelay,
				worstCaseDeadline, bestCaseEmptyQueue);
	}

	/**
	 * Invoke the analysis and return Result collection
	 *
	 * @param etef The end to end flow instance
	 * @param som The mode to run the analysis in. If the ETEF is not active it will not be run.
	 * @param asynchronousSystem Whether the system is treated as asynchronous
	 * @param majorFrameDelay Whether partition output is performed at a major frame (as opposed to the partition end)
	 * @param worstCaseDeadline Use deadline based processing (as opposed to max compute execution time)
	 * @param bestCaseEmptyQueue Assume empty queue (instead of full)
	 * @return Collection of Result. May be empty if ETEF is not active in SOM
	 */
	private EList<Result> invokeOnSOM(EndToEndFlowInstance etef, SystemOperationMode som,
			boolean asynchronousSystem, boolean majorFrameDelay, boolean worstCaseDeadline,
			boolean bestCaseEmptyQueue) {
		if (report == null) {
			report = new LatencyReport();
		}
		report.setRootinstance(etef.getSystemInstance());
		report.setLatencyAnalysisParameters(asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue);
		SystemInstance root = etef.getSystemInstance();
		EList<Result> results = new BasicEList<Result>();
		if (!Aadl2Util.isNoModes(som)) {
			root.setCurrentSystemOperationMode(som);
		}
		if (Aadl2Util.isNoModes(som) || etef.isActive(som)) {
			LatencyReportEntry latres = analyzeLatency(etef, som, asynchronousSystem);
			results.add(latres.genResult());
			root.clearCurrentSystemOperationMode();
			return results;
		} else {
			root.clearCurrentSystemOperationMode();
			return results;
		}
	}


	/**
	 * invoke latency analysis and save results in file system as .result, and as .csv files
	 * @param root
	 * @param som
	 * @param asynchronousSystem
	 * @param majorFrameDelay
	 * @param worstCaseDeadline
	 * @param bestCaseEmptyQueue
	 * @return
	 */
	public AnalysisResult invokeAndSaveResult(SystemInstance root, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		AnalysisResult ar = invoke(root, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
				bestCaseEmptyQueue);
		FlowLatencyUtil.saveAnalysisResult(ar);
		LatencyCSVReport.generateCSVReport(ar);
		return ar;
	}


}
