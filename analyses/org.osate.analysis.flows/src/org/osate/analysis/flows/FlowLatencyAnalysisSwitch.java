/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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

import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.contrib.aadlproject.SizeUnits;
import org.osate.aadl2.contrib.aadlproject.TimeUnits;
import org.osate.aadl2.contrib.communication.CommunicationProperties;
import org.osate.aadl2.contrib.communication.TransmissionTime;
import org.osate.aadl2.contrib.deployment.DeploymentProperties;
import org.osate.aadl2.contrib.timing.TimingProperties;
import org.osate.aadl2.contrib.util.AadlContribUtils;
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
import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
import org.osate.aadl2.properties.PropertyAcc;
import org.osate.analysis.flows.internal.utils.AnalysisUtils;
import org.osate.analysis.flows.internal.utils.FlowLatencyUtil;
import org.osate.analysis.flows.model.LatencyCSVReport;
import org.osate.analysis.flows.model.LatencyContributor;
import org.osate.analysis.flows.model.LatencyContributor.LatencyContributorMethod;
import org.osate.analysis.flows.model.LatencyContributorComponent;
import org.osate.analysis.flows.model.LatencyContributorConnection;
import org.osate.analysis.flows.model.LatencyReport;
import org.osate.analysis.flows.model.LatencyReportEntry;
import org.osate.contribution.sei.arinc653.ScheduleWindow;
import org.osate.contribution.sei.sei.Sei;
import org.osate.pluginsupport.properties.IntegerRangeWithUnits;
import org.osate.pluginsupport.properties.PropertyUtils;
import org.osate.pluginsupport.properties.RealRange;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

/**
 * @author phf
 *
 * This class provides for flow analysis
 *
 */
public class FlowLatencyAnalysisSwitch extends AadlProcessingSwitchWithProgress {
	private LatencyReport report;

	/*
	 * Quick and dirty way to keep track of the order in which a bus component is added to the asyncBuses set. Used for the comparator.
	 */
	private final Map<ComponentInstance, Integer> busOrder = new HashMap<>();
	private int nextBusId = 0;

	/*
	 * Set of all the non-periodic buses we encounter.
	 */
	private final Set<ComponentInstance> asyncBuses = new TreeSet<>((o1, o2) -> {
		final int id1 = busOrder.get(o1);
		final int id2 = busOrder.get(o2);
		return id1 - id2;
	});

	/*
	 * Map from (bus component, connection instance) -> latency contributor. We need this because the queuing latency is computed at the end of process
	 * after all the transmission times are computed. So we add the queuing latency to this latency contributor for the connection instance
	 * bound to the given bus. This may contain entries that in the end are not interesting because virtual buses can be bound to
	 * other virtual buses that are eventually bound to real bus. We chases down all those layers.
	 */
	private final Map<Pair<ComponentInstance, ConnectionInstance>, LatencyContributor> connectionsToContributors = new HashMap<>();
	/*
	 * Map from (bus component, connection instance) -> maximum transmission time. When the max transmission time for
	 * the given connection bound to the given bus is computed, we store it here. This may contain entries that in the end are not interesting because virtual
	 * buses can be bound to
	 * other virtual buses that are eventually bound to real bus. We chases down all those layers.
	 */
	private final Map<Pair<ComponentInstance, ConnectionInstance>, Double> computedMaxTransmissionLatencies = new HashMap<>();

	public FlowLatencyAnalysisSwitch() {
		super(new NullProgressMonitor(), PROCESS_PRE_ORDER_ALL);
	}

	public FlowLatencyAnalysisSwitch(SystemInstance si) {
		this(new NullProgressMonitor(), si);
	}

	/**
	 * @since 5.0
	 */
	public FlowLatencyAnalysisSwitch(final IProgressMonitor monitor, SystemInstance si) {
		super(monitor, PROCESS_PRE_ORDER_ALL);
		report = new LatencyReport();
		report.setRootinstance(si);

	}

	/*
	 * Issue 1148: added this so that callers of invoke() and invokeOnSOM() can get the results. This used to to be done
	 * bit by bit during the analysis, but because I changed things to compute the queueing times last, I had to defer
	 * this process until the absolute end.
	 */
	/**
	 * @since org.osate.analysis.flows 3.0
	 */
	public final List<Result> finalizeResults() {
		// Issue 1148
		/* report might be null if we are being invoked from a unit test when there are no flows in the system */
		return report == null ? Collections.emptyList() : report.finalizeAllEntries();
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

				// XXX: [Code Coverage] etef.getFlowElements() cannot be empty.
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
// Issue 1148 moved this somewhere else
//		entry.finalizeReportEntry();
		return entry;
	}

	private void mapFlowElementInstance(final EndToEndFlowInstance etef, final FlowElementInstance flowElementInstance,
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

	private final Set<ComponentCategory> latencyCats = EnumSet.of(ComponentCategory.BUS, ComponentCategory.VIRTUAL_BUS,
			ComponentCategory.DEVICE, ComponentCategory.PROCESSOR, ComponentCategory.VIRTUAL_PROCESSOR,
			ComponentCategory.SYSTEM, ComponentCategory.MEMORY, ComponentCategory.ABSTRACT);

	private final Set<ComponentCategory> periodCats = EnumSet.of(ComponentCategory.THREAD,
			ComponentCategory.THREAD_GROUP, ComponentCategory.PROCESS, ComponentCategory.SYSTEM,
			ComponentCategory.DEVICE, ComponentCategory.VIRTUAL_PROCESSOR, ComponentCategory.VIRTUAL_BUS,
			ComponentCategory.ABSTRACT);

	private final Set<ComponentCategory> deadlineCats = EnumSet.of(ComponentCategory.THREAD,
			ComponentCategory.THREAD_GROUP, ComponentCategory.PROCESS, ComponentCategory.SYSTEM,
			ComponentCategory.DEVICE, ComponentCategory.VIRTUAL_PROCESSOR,
			ComponentCategory.ABSTRACT);

	private void mapComponentInstance(final EndToEndFlowInstance etef, final FlowElementInstance flowElementInstance,
			LatencyReportEntry entry) {
		ComponentInstance componentInstance;
		final boolean hasLatency = flowElementInstance instanceof FlowSpecificationInstance
				|| flowElementInstance instanceof ConnectionInstance
				|| flowElementInstance instanceof EndToEndFlowInstance
				|| latencyCats.contains(((ComponentInstance) flowElementInstance).getCategory());
		final RealRange expected = hasLatency ? PropertyUtils.getScaledRange(
				org.osate.aadl2.contrib.communication.CommunicationProperties::getLatency, flowElementInstance,
				TimeUnits.MS).orElse(RealRange.ZEROED) : RealRange.ZEROED;

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
		double period = periodCats.contains(componentInstance.getCategory()) ? PropertyUtils.getScaled(TimingProperties::getPeriod, componentInstance, TimeUnits.MS)
				.orElse(0.0) : 0.0;
		double deadline = deadlineCats.contains(componentInstance.getCategory()) ? PropertyUtils.getScaled(TimingProperties::getDeadline, componentInstance, TimeUnits.MS)
				.orElse(0.0) : 0.0;
		boolean isAssignedDeadline = isAssignedDeadline(componentInstance);

		final boolean isThreadOrDevice = InstanceModelUtil.isThread(componentInstance)
				|| InstanceModelUtil.isDevice(componentInstance) || InstanceModelUtil.isAbstract(componentInstance);
		final boolean isPeriodic = period > 0 && (isThreadOrDevice
						? (!InstanceModelUtil.isSporadicComponent(componentInstance)
								&& !InstanceModelUtil.isTimedComponent(componentInstance)
								&& !InstanceModelUtil.isAperiodicComponent(componentInstance))
						: true);

		final RealRange responseTime = getResponseTimeInMilliSec(flowElementInstance, componentInstance,
				isPeriodic);
		final RealRange executionTime = getExecutionTimeInMilliSec(flowElementInstance, componentInstance,
				isPeriodic);

		/**
		 * The component is periodic. Therefore it will sample its input unless we have an immediate connection or delayed connection
		 */
		boolean checkLastImmediate = false;
		if (isPeriodic) {
			// we have a periodic component that samples
			if (incomingConnectionFI != null) {
				// it is not the first component in the ETEF. We need to add sampling latency
				if (incomingConnectionFI.getCategory() == FeatureCategory.DATA_PORT
						|| incomingConnectionFI.getCategory() == FeatureCategory.ABSTRACT_FEATURE) {
					// sampling incoming data
					// period is set, and if thread, abstract, or device needs to be dispatched as periodic
					// We sample only data ports. Event and event data ports have queuing latency
					LatencyContributorComponent samplingLatencyContributor = new LatencyContributorComponent(
							componentInstance, flowElementInstance, report.isMajorFrameDelay());
					samplingLatencyContributor.setSamplingPeriod(period);
					if ((InstanceModelUtil.isThread(componentInstance) || InstanceModelUtil.isDevice(componentInstance))
							&& !hasAssignedPropertyValue(componentInstance, "Dispatch_Protocol")) {
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
						// sampled. We may under sample
						ComponentInstance prevComp = FlowLatencyUtil.getPreviousComponent(etef, flowElementInstance);
						double prevPeriod = prevComp != null ? PropertyUtils.getScaled(TimingProperties::getPeriod, prevComp, TimeUnits.MS).orElse(0.0)
								: 0;
						if (period > 0 && prevPeriod > 0 && period % prevPeriod == 0.0) {
							samplingLatencyContributor.setSamplingPeriod(prevPeriod);
						} else {
							samplingLatencyContributor.setSamplingPeriod(period);
						}
						samplingLatencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED);
						samplingLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED);
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
						componentInstance, flowElementInstance, report.isMajorFrameDelay());
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
					List<ScheduleWindow> schedule = FlowLatencyUtil.getModuleSchedule(firstPartition);
					double partitionDuration = FlowLatencyUtil.getPartitionDuration(firstPartition, schedule);
					LatencyContributorComponent platencyContributor = new LatencyContributorComponent(firstPartition,
							flowElementInstance,
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
				flowElementInstance,
				report.isMajorFrameDelay());

		if (responseTime.getMaximum() != 0.0) {
			worstCaseValue = responseTime.getMaximum();
			worstmethod = LatencyContributorMethod.RESPONSE_TIME;
		} else if (executionTime.getMaximum() != 0.0) {
			if (!report.isWorstCaseDeadline()) {
				// Use execution time for worst-case if preferences specify not deadline or no deadline is specified
				worstCaseValue = executionTime.getMaximum();
				worstmethod = LatencyContributorMethod.PROCESSING_TIME;
			} else if (!isAssignedDeadline) {
				worstCaseValue = executionTime.getMaximum();
				worstmethod = LatencyContributorMethod.PROCESSING_TIME;
				processingLatencyContributor.reportInfo("Using execution time as deadline was not set");
			}
		}

		if ((worstCaseValue == 0.0) && isAssignedDeadline && report.isWorstCaseDeadline()) {
			// use deadline if no execution time and deadline was explicitly assigned
			worstCaseValue = deadline;
			worstmethod = LatencyContributorMethod.DEADLINE;
		}

		if ((worstCaseValue == 0.0) && (expected.getMaximum() != 0.0)) {
			// use flow latency if neither deadline nor execution time
			worstCaseValue = expected.getMaximum();
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
		if (responseTime.getMinimum() != 0.0) {
			bestCaseValue = responseTime.getMinimum();
			bestmethod = LatencyContributorMethod.RESPONSE_TIME;
		} else if (executionTime.getMinimum() != 0.0) {
			bestCaseValue = executionTime.getMinimum();
			bestmethod = LatencyContributorMethod.PROCESSING_TIME;
		}

		// For best case it does not make sense to use deadline

		if ((bestCaseValue == 0.0) && (expected.getMinimum() != 0.0)) {
			bestCaseValue = expected.getMinimum();
			bestmethod = LatencyContributorMethod.SPECIFIED;
		}

		// XXX: Fix all the use of the isSporadic/isTimed etc. Get the value once and check against it.

		// deal with queuing latency
		// take into account queuing delay
		if (incomingConnectionFI != null) {
			double qs = 0;
			LatencyContributorComponent ql = new LatencyContributorComponent(componentInstance, flowElementInstance,
					report.isMajorFrameDelay());

			if (hasAssignedPropertyValue(incomingConnectionFI,
					org.osate.xtext.aadl2.properties.util.CommunicationProperties.QUEUE_SIZE)) {
				qs = CommunicationProperties.getQueueSize(incomingConnectionFI).orElse(0);
			} else if (incomingConnectionFI.getCategory() == FeatureCategory.DATA_PORT
					&& isThreadOrDevice && (InstanceModelUtil.isSporadicComponent(componentInstance)
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
		processingLatencyContributor.setExpectedMaximum(expected.getMaximum());
		processingLatencyContributor.setExpectedMinimum(expected.getMinimum());
		if (checkLastImmediate && deadline > 0.0) {

			processingLatencyContributor.setImmediateDeadline(deadline);
		}
		processingLatencyContributor.checkConsistency();
		entry.addContributor(processingLatencyContributor);
	}

	private void mapConnectionInstance(final EndToEndFlowInstance etef, final FlowElementInstance flowElementInstance,
			LatencyReportEntry entry) {
		ConnectionInstance connectionInstance = (ConnectionInstance) flowElementInstance;

		final RealRange expected = PropertyUtils
				.getScaledRange(org.osate.aadl2.contrib.communication.CommunicationProperties::getLatency,
						flowElementInstance, TimeUnits.MS)
				.orElse(RealRange.ZEROED);

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
			List<ScheduleWindow> schedule = FlowLatencyUtil.getModuleSchedule(srcPartition);
			double partitionDuration = FlowLatencyUtil.getPartitionDuration(srcPartition, schedule);
			if (partitionDuration > 0) {
				LatencyContributor ioLatencyContributor = new LatencyContributorComponent(srcPartition,
						flowElementInstance,
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
		ComponentClassifier relatedConnectionData = FlowLatencyUtil.getConnectionData(connectionInstance);
		processActualConnectionBindingsTransmission(connectionInstance,
				relatedConnectionData == null ? 0.0
						: AadlContribUtils.getDataSize(relatedConnectionData, SizeUnits.BYTES),
				latencyContributor);
		/**
		 * handle the case when there is no binding to virtual bus or bus.
		 * In this case we use the latency from the connection itself
		 */
		// XXX we can add a check whether the latencies coming from the bindings exceeds the connection latency

		if (expected.getMaximum() > 0) {
			latencyContributor.setWorstCaseMethod(LatencyContributorMethod.SPECIFIED);
			latencyContributor.setExpectedMaximum(expected.getMaximum());
		}
		if (expected.getMinimum() > 0) {
			latencyContributor.setBestCaseMethod(LatencyContributorMethod.SPECIFIED);
			latencyContributor.setExpectedMinimum(expected.getMinimum());
		}
		if (latencyContributor.getSubContributors().isEmpty()) {
			if (expected.getMaximum() > 0) {
				latencyContributor.setMaximum(expected.getMaximum());
			}
			if (expected.getMinimum() > 0) {
				latencyContributor.setMinimum(expected.getMinimum());
			}
		} else {
			latencyContributor.reportInfo("Adding latency subtotal from protocols and hardware - shown with ()");
		}
		// set synchronous if on same processor
		if (srcHW != null && dstHW != null) {
			// we have two hardware components. One or both could be a device
			ComponentInstance srcTime = (ComponentInstance) TimingProperties.getReferenceTime(srcHW).orElse(null);
			ComponentInstance dstTime = (ComponentInstance) TimingProperties.getReferenceTime(dstHW).orElse(null);
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
			List<ScheduleWindow> schedule = FlowLatencyUtil.getModuleSchedule(dstPartition);
			double partitionDuration = FlowLatencyUtil.getPartitionDuration(dstPartition, schedule);
			LatencyContributorComponent platencyContributor = new LatencyContributorComponent(dstPartition,
					flowElementInstance,
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

	private static RealRange getTimeToTransferData(final NamedElement bus, double datasizeinbyte) {
		final Optional<TransmissionTime> tt_o = org.osate.aadl2.contrib.communication.CommunicationProperties
				.getTransmissionTime(bus);
		if (tt_o.isPresent()) {
			final TransmissionTime tt = tt_o.get();
			final RealRange fixedRange = PropertyUtils.scaleRange(tt.getFixed(), TimeUnits.MS).orElse(RealRange.ZEROED);
			final RealRange perByteRange = PropertyUtils.scaleRange(tt.getPerbyte(), TimeUnits.MS)
					.orElse(RealRange.ZEROED);
			final double min = fixedRange.getMinimum() + (datasizeinbyte * perByteRange.getMinimum());
			final double max = fixedRange.getMaximum() + (datasizeinbyte * perByteRange.getMaximum());
			return new RealRange(min, max);
		} else {
			return new RealRange(0.0, 0.0);
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
	private void processTransmissionTime(NamedElement targetMedium, double datasizeinbyte,
			LatencyContributor latencyContributor, final ConnectionInstance onBehalfOfConnection) {
		// XXX: [Code Coverage] targetMedium cannot be null.
		if (targetMedium != null) {
			final RealRange busLatency = PropertyUtils
					.getScaledRange(org.osate.aadl2.contrib.communication.CommunicationProperties::getLatency,
							targetMedium, TimeUnits.MS)
					.orElse(RealRange.ZEROED);
			final RealRange busTransferTime = getTimeToTransferData(targetMedium, datasizeinbyte);
			if (busLatency.getMaximum() == 0 && busTransferTime.getMaximum() == 0) {
				// connection or protocol has nothing to contribute
				return;
			}
			LatencyContributor subContributor = new LatencyContributorComponent(targetMedium,
					report.isMajorFrameDelay());
			subContributor.setExpectedMaximum(busLatency.getMaximum());
			subContributor.setExpectedMinimum(busLatency.getMinimum());
			if (busTransferTime.getMaximum() > 0) {
				subContributor.setMaximum(busTransferTime.getMaximum());
				subContributor.reportInfo("Using data transfer time");
				if (datasizeinbyte == 0.0) {
					subContributor.reportInfo("Data size = 0. Possibly data type on port missing");
				}
				subContributor.setWorstCaseMethod(LatencyContributorMethod.TRANSMISSION_TIME);

				// Record the latency for use by asynchronous bus waiting times
				if (targetMedium instanceof ComponentInstance) {
					computedMaxTransmissionLatencies.put(
							new Pair<>((ComponentInstance) targetMedium, onBehalfOfConnection),
							busTransferTime.getMaximum());
				}
			} else if (busLatency.getMaximum() > 0) {
				subContributor.setMaximum(busLatency.getMaximum());
				subContributor.setWorstCaseMethod(LatencyContributorMethod.SPECIFIED);
				subContributor.reportInfo("Using specified bus latency");

				// Record the latency for use by asynchronous bus waiting times
				if (targetMedium instanceof ComponentInstance) {
					computedMaxTransmissionLatencies.put(
							new Pair<>((ComponentInstance) targetMedium, onBehalfOfConnection),
							busTransferTime.getMaximum());
				}
			} else {
				// XXX: [Code Coverage] Only executable if maxBusTransferTime or maxBusLatency is negative.
				subContributor.setWorstCaseMethod(LatencyContributorMethod.UNKNOWN);
			}

			if (busTransferTime.getMinimum() > 0) {
				subContributor.setMinimum(busTransferTime.getMinimum());
				subContributor.setBestCaseMethod(LatencyContributorMethod.TRANSMISSION_TIME);

			} else if (busLatency.getMinimum() > 0) {
				subContributor.setMinimum(busLatency.getMinimum());
				subContributor.setBestCaseMethod(LatencyContributorMethod.SPECIFIED);
			} else {
				// XXX: [Code Coverage] Only executable if minBusTransferTime or minBusLatency is negative.
				subContributor.setBestCaseMethod(LatencyContributorMethod.UNKNOWN);
			}
			latencyContributor.addSubContributor(subContributor);
		}
	}

	private void processActualConnectionBindingsTransmission(final ConnectionInstance connectionInstance,
			final double transmissionDataSize, final LatencyContributor latencyContributor) {
		processActualConnectionBindingsTransmission(connectionInstance, transmissionDataSize, latencyContributor,
				connectionInstance);
	}

	/*
	 * connOrVB - Can be a ConnectionInstance (initial call), ComponentInstance (bus or virtual bus bound to a connection or virtual bus)
	 *
	 * onBehalfOfConnection - The connection instance that is bound to this mess. When connOrVB is a connection instance then
	 * it must be that connOrVB == onBehalfOfConnection
	 */
	private void processActualConnectionBindingsTransmission(final InstanceObject connOrVB,
			double transmissionDataSize, final LatencyContributor latencyContributor,
			final ConnectionInstance onBehalfOfConnection) {
		boolean willDoVirtualBuses = false;
		boolean willDoBuses = false;
		// look for actual binding if we have a connection instance or virtual bus instance
		final List<InstanceObject> bindings = DeploymentProperties.getActualConnectionBinding(connOrVB)
				.orElse(Collections.emptyList());

		if (bindings.isEmpty()) {
			return;
		}
		for (InstanceObject componentInstance : bindings) {
			if (((ComponentInstance) componentInstance).getCategory().equals(ComponentCategory.VIRTUAL_BUS)) {
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
			List<Classifier> protocols = DeploymentProperties.getRequiredVirtualBusClass(connOrVB)
					.orElse(Collections.emptyList());
			// XXX: [Code Coverage] protocols cannot be null.
			if ((protocols != null) && (protocols.size() > 0)) {
				// XXX: [Code Coverage] willDoBuses is always true if willDoVirtualBuses is false.
				if (willDoBuses) {
					latencyContributor.reportInfo("Adding required virtual bus contributions to bound bus");
				}
				transmissionDataSize = computeTotalDataSize(protocols, transmissionDataSize, latencyContributor,
						onBehalfOfConnection);
			}

		}

		for (InstanceObject componentInstance : bindings) {
			double wrappedDataSize = transmissionDataSize
					+ AadlContribUtils.getDataSize((ComponentInstance) componentInstance, SizeUnits.BYTES);
			processTransmissionTime(componentInstance, wrappedDataSize, latencyContributor, onBehalfOfConnection);
			if (((ComponentInstance) componentInstance).getCategory().equals(ComponentCategory.VIRTUAL_BUS)) {
				processActualConnectionBindingsTransmission(componentInstance, wrappedDataSize, latencyContributor,
						onBehalfOfConnection);
			}
		}
	}

	/**
	 * calculate the protocol data size contributions.
	 * Do so for any RequiredVirtualBusClass of each protocol recursively.
	 * @param protocols
	 * @return
	 */
	private double computeTotalDataSize(List<Classifier> protocols,
			double transmissionDataSize,
			LatencyContributor latencyContributor, final ConnectionInstance onBehalfOfConnection) {
		double total = transmissionDataSize;
		for (Classifier cc : protocols) {
			double contribution = AadlContribUtils.getDataSize((ComponentClassifier) cc, SizeUnits.BYTES);
			double wrapped = transmissionDataSize + contribution;
			processTransmissionTime(cc, wrapped, latencyContributor, onBehalfOfConnection);
			total = total + contribution;
			List<Classifier> reqprotocols = DeploymentProperties.getRequiredVirtualBusClass(cc)
					.orElse(Collections.emptyList());
			if (!reqprotocols.isEmpty()) {
				total = total + computeTotalDataSize(reqprotocols, wrapped, latencyContributor, onBehalfOfConnection);
			}
		}
		return total;

	}

	private void processActualConnectionBindingsSampling(final ConnectionInstance connectionInstance,
			final LatencyContributor latencyContributor) {
		processActualConnectionBindingsSampling(connectionInstance, latencyContributor, connectionInstance);
	}

	/*
	 * connOrVB - Can be a ConnectionInstance (initial call), ComponentInstance (bus or virtual bus bound to a connection or virtual bus), or a
	 * ComponentClassifier (required by a connection or virtual bus).
	 *
	 * onBehalfOfConnection - The connection instance that is bound to this mess. When connOrVB is a connection instance then
	 * it must be that connOrVB == onBehalfOfConnection
	 */
	private void processActualConnectionBindingsSampling(final NamedElement connOrVB,
			final LatencyContributor latencyContributor, final ConnectionInstance onBehalfOfConnection) {
		boolean willDoVirtualBuses = false;
		boolean willDoBuses = false;
		if (connOrVB instanceof InstanceObject) {
			// look for actual binding if we have a connection instance or virtual bus instance
			List<InstanceObject> bindings = DeploymentProperties.getActualConnectionBinding(connOrVB)
					.orElse(Collections.emptyList());
			for (InstanceObject componentInstance : bindings) {
				if (((ComponentInstance) componentInstance).getCategory().equals(ComponentCategory.VIRTUAL_BUS)) {
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
				List<Classifier> protocols = DeploymentProperties.getRequiredVirtualBusClass(connOrVB)
						.orElse(Collections.emptyList());
				// XXX: [Code Coverage] protocols cannot be null.
				if ((protocols != null) && (protocols.size() > 0)) {
					if (willDoBuses) {
						latencyContributor.reportInfo("Adding required virtual bus contributions to bound bus");
					}
					for (Classifier cc : protocols) {
						processSamplingAndQueuingTimes(cc, null, latencyContributor);
						processActualConnectionBindingsSampling(cc, latencyContributor, onBehalfOfConnection);
					}
				}
			}

			for (InstanceObject componentInstance : bindings) {
				processSamplingAndQueuingTimes(componentInstance, onBehalfOfConnection, latencyContributor);
				if (((ComponentInstance) componentInstance).getCategory().equals(ComponentCategory.VIRTUAL_BUS)) {
					processActualConnectionBindingsSampling(componentInstance, latencyContributor,
							onBehalfOfConnection);
				}
			}
		}

	}

	private final static Set<ComponentCategory> hasPeriod = EnumSet.of(ComponentCategory.THREAD,
			ComponentCategory.THREAD_GROUP, ComponentCategory.PROCESS, ComponentCategory.SYSTEM,
			ComponentCategory.DEVICE, ComponentCategory.VIRTUAL_PROCESSOR, ComponentCategory.VIRTUAL_BUS,
			ComponentCategory.BUS, ComponentCategory.ABSTRACT);

	/*
	 * boundBusOrRequiredClassifier is a ComponentInstance if it is a bus bound to connection instance, or a
	 * ComponentClassifier if it is a virtual bus required by a connection connnection or vb.
	 *
	 * bindingConnection is the ConnectionInstance that boundBusOrRequiredClassifier is bound to if
	 * boundBusOrRequiredClassifier is a componentInstance. Otherwise it is null.
	 */
	private void processSamplingAndQueuingTimes(final NamedElement boundBusOrRequiredClassifier,
			final ConnectionInstance bindingConnection, final LatencyContributor latencyContributor) {
		/**
		 * we add the bus/VB sampling time as a subcontributor.
		 */

		// XXX: [Code Coverage] boundBus cannot be null.
		if (boundBusOrRequiredClassifier != null) {
			final ComponentCategory cc = boundBusOrRequiredClassifier instanceof ComponentInstance
					? ((ComponentInstance) boundBusOrRequiredClassifier).getCategory()
					: ((ComponentClassifier) boundBusOrRequiredClassifier).getCategory();
			double period = hasPeriod.contains(
					cc) ? PropertyUtils
					.getScaled(TimingProperties::getPeriod, boundBusOrRequiredClassifier, TimeUnits.MS).orElse(0.0)
					: 0.0;
			if (period > 0) {
				// add sampling latency due to the protocol or bus being periodic
				LatencyContributor samplingLatencyContributor = new LatencyContributorComponent(
						boundBusOrRequiredClassifier, report.isMajorFrameDelay());
				samplingLatencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED_PROTOCOL);
				samplingLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED_PROTOCOL);
				samplingLatencyContributor.setSamplingPeriod(period);
				latencyContributor.addSubContributor(samplingLatencyContributor);

				// add queuing latency: always zero in this case
				LatencyContributor queuingLatencyContributor = new LatencyContributorComponent(
						boundBusOrRequiredClassifier, report.isMajorFrameDelay());
				queuingLatencyContributor.setBestCaseMethod(LatencyContributorMethod.QUEUED);
				queuingLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.QUEUED);
				queuingLatencyContributor.setMinimum(0.0);
				queuingLatencyContributor.setMaximum(0.0);
				latencyContributor.addSubContributor(queuingLatencyContributor);
			} else {
				/*
				 * Issue 1148
				 *
				 * if "boundBus" is really a bound component instance, and not a required component classifier,
				 * then we remember the bus as asynchronous. Later in fillInQueuingTimes() we go through this list,
				 * and then find all the connection instances bound to this bus. For each connection,
				 * we compute the sum of the max transmission times of the OTHER connections bound to the bus. This
				 * we set as the worse case queuing time. (Best case is 0.)
				 *
				 * We also remember the bus--connection pair that needs the queuing latency by storing its latency contributor.
				 */
				if (bindingConnection != null) {
					final ComponentInstance boundBus = (ComponentInstance) boundBusOrRequiredClassifier;

					/* Set the bus order and then add it to the ordered set */
					if (!busOrder.containsKey(boundBus)) {
						busOrder.put(boundBus, nextBusId++);
						asyncBuses.add(boundBus);
					}
					connectionsToContributors.put(new Pair<>(boundBus, bindingConnection), latencyContributor);
				}
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
	 *
	 * @deprecated Use {@link #invoke(SystemInstance, SystemOperationMode, boolean, boolean, boolean, boolean, boolean)}
	 */
	@Deprecated
	public AnalysisResult invoke(SystemInstance root, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		return invoke(root, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue, false);
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
	 * @param disableQueuingLatency <code>true</code> if queuing latency should always be reported as zero
	 * @return A populated report in AnalysisResult format.
	 * @since org.osate.analysis.flows 3.0
	 */
	// NB. This method is used to invoke the analysis from unit tests
	public AnalysisResult invoke(SystemInstance root, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue,
			boolean disableQueuingLatency) {
		if (som == null) {
			if (root.getSystemOperationModes().isEmpty()
					|| root.getSystemOperationModes().get(0).getCurrentModes().isEmpty()) {
				// no SOM
				invokeOnSOM(root, root.getSystemOperationModes().get(0), asynchronousSystem, majorFrameDelay,
						worstCaseDeadline,
						bestCaseEmptyQueue, disableQueuingLatency);
			} else {
				// we need to run it for every SOM
				for (SystemOperationMode eachsom : root.getSystemOperationModes()) {
					root.setCurrentSystemOperationMode(eachsom);
					invokeOnSOM(root, eachsom, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
							bestCaseEmptyQueue, disableQueuingLatency);
					root.clearCurrentSystemOperationMode();
				}
			}
		} else {
			invokeOnSOM(root, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
					bestCaseEmptyQueue, disableQueuingLatency);
		}

		// Issue 1148
		final List<Result> finalizedResults = finalizeResults();

		return FlowLatencyUtil.recordAsAnalysisResult(finalizedResults, root, asynchronousSystem, majorFrameDelay,
				worstCaseDeadline, bestCaseEmptyQueue, disableQueuingLatency);
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
	 *
	 * @since org.osate.analysis.flows 3.0
	 *
	 * @deprecated Use {@link #invokeOnSOM(SystemInstance, SystemOperationMode, boolean, boolean, boolean, boolean, boolean)}.
	 */
	@Deprecated
	public void invokeOnSOM(SystemInstance si, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		invokeOnSOM(si, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue, false);
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
	 *
	 * @since org.osate.analysis.flows 3.0
	 */
	// NB. Called by CheckFlowLatency
	public void invokeOnSOM(SystemInstance si, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue,
			boolean disableQueuingLatency) {
		List<EndToEndFlowInstance> alletef = EcoreUtil2.getAllContentsOfType(si, EndToEndFlowInstance.class);
		for (EndToEndFlowInstance etef : alletef) {
			invokeOnSOM(etef, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue,
					disableQueuingLatency);
		}

		// Issue 1148
		fillInQueuingTimes(si);
	}

	public AnalysisResult invoke(ComponentInstance ci) {
		return invoke(ci, null, true, true, true, true, false);
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
	 *
	 * @deprecated use {@link #invoke(ComponentInstance, SystemOperationMode, boolean, boolean, boolean, boolean, boolean)}
	 */
	// Called by ???
	@Deprecated
	public AnalysisResult invoke(ComponentInstance ci, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		return invoke(ci, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue, false);
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
	 * @param disableQueuingLatency <code>true</code> if queuing latency should always be reported as zero
	 * @return A populated report in AnalysisResult format.
	 *
	 * @since org.osate.analysis.flows 3.0
	 */
	public AnalysisResult invoke(ComponentInstance ci, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue,
			boolean disableQueuingLatency) {
		SystemInstance root = ci.getSystemInstance();
		if (som == null) {
			if (root.getSystemOperationModes().isEmpty()
					|| root.getSystemOperationModes().get(0).getCurrentModes().isEmpty()) {
				// no SOM
				invokeOnSOM(ci, root.getSystemOperationModes().get(0), asynchronousSystem, majorFrameDelay,
						worstCaseDeadline, bestCaseEmptyQueue, disableQueuingLatency);
			} else {
				// we need to run it for every SOM
				for (SystemOperationMode eachsom : root.getSystemOperationModes()) {
					root.setCurrentSystemOperationMode(eachsom);
					invokeOnSOM(ci, eachsom, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
							bestCaseEmptyQueue, disableQueuingLatency);
					root.clearCurrentSystemOperationMode();
				}
			}
		} else {
			invokeOnSOM(ci, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue,
					disableQueuingLatency);
		}

		// Issue 1148
		fillInQueuingTimes(ci.getSystemInstance());
		final List<Result> finalizedResults = report.finalizeAllEntries();

		return FlowLatencyUtil.recordAsAnalysisResult(finalizedResults, ci, asynchronousSystem, majorFrameDelay,
				worstCaseDeadline, bestCaseEmptyQueue, disableQueuingLatency);
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
	 * @param disableQueuingLatency <code>true</code> if queuing latency should always be reported as zero
	 *
	 * @since org.osate.analysis.flows 3.0
	 */
	private void invokeOnSOM(ComponentInstance ci, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue,
			boolean disableQueuingLatency) {
		for (EndToEndFlowInstance etef : ci.getEndToEndFlows()) {
			invokeOnSOM(etef, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue,
					disableQueuingLatency);
		}
	}

	// N.B. Called by Alisa
	public AnalysisResult invoke(EndToEndFlowInstance etef) {
		return invoke(etef, null, true, true, true, true, false);
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
	 *
	 * @deprecated Use {@link #invoke(EndToEndFlowInstance, SystemOperationMode, boolean, boolean, boolean, boolean, boolean)}
	 */
	@Deprecated
	public AnalysisResult invoke(EndToEndFlowInstance etef, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		return invoke(etef, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue, false);
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
	 * @param disableQueuingLatency <code>true</code> if queuing latency should always be reported as zero
	 * @return A populated report in AnalysisResult format.
	 * @since org.osate.analysis.flows 3.0
	 */
	public AnalysisResult invoke(EndToEndFlowInstance etef, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue,
			boolean disableQueuingLatency) {
		SystemInstance root = etef.getSystemInstance();
		if (som == null) {
			// we need to run it for every SOM
			for (SystemOperationMode eachsom : root.getSystemOperationModes()) {
				root.setCurrentSystemOperationMode(eachsom);
				invokeOnSOM(etef, eachsom, asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue,
						disableQueuingLatency);
				root.clearCurrentSystemOperationMode();
			}
		} else {
			invokeOnSOM(etef, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue,
					disableQueuingLatency);
		}

		// Issue 1148
		fillInQueuingTimes(etef.getSystemInstance());
		final List<Result> finalizedResults = finalizeResults();

		return FlowLatencyUtil.recordAsAnalysisResult(finalizedResults, etef, asynchronousSystem, majorFrameDelay,
				worstCaseDeadline, bestCaseEmptyQueue, disableQueuingLatency);
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
	 * @param disableQueuingLatency <code>true</code> if queuing latency should always be reported as zero
	 *
	 * @since org.osate.analysis.flows 3.0
	 */
	private void invokeOnSOM(EndToEndFlowInstance etef, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue,
			boolean disableQueuingLatency) {
		if (report == null) {
			report = new LatencyReport();
		}
		report.setRootinstance(etef.getSystemInstance());
		report.setLatencyAnalysisParameters(asynchronousSystem, majorFrameDelay, worstCaseDeadline, bestCaseEmptyQueue,
				disableQueuingLatency);
		SystemInstance root = etef.getSystemInstance();
		if (etef.isActive(som)) {
			root.setCurrentSystemOperationMode(som);
			LatencyReportEntry latres = analyzeLatency(etef, som, asynchronousSystem);

			// Issue 1148
			report.addEntry(latres);

			root.clearCurrentSystemOperationMode();
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
	 *
	 * @return
	 *
	 * @deprecated {@link #invokeAndSaveResult(SystemInstance, SystemOperationMode, boolean, boolean, boolean, boolean, boolean)}.
	 */
	@Deprecated
	public AnalysisResult invokeAndSaveResult(SystemInstance root, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue) {
		return invokeAndSaveResult(root, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
				bestCaseEmptyQueue, false);
	}

	/**
	 * @since org.osate.analysis.flows 3.0
	 */
	public AnalysisResult invokeAndSaveResult(SystemInstance root, SystemOperationMode som, boolean asynchronousSystem,
			boolean majorFrameDelay, boolean worstCaseDeadline, boolean bestCaseEmptyQueue,
			boolean disableQueuingLatency) {
		AnalysisResult ar = invoke(root, som, asynchronousSystem, majorFrameDelay, worstCaseDeadline,
				bestCaseEmptyQueue, disableQueuingLatency);
		FlowLatencyUtil.saveAnalysisResult(ar);
		LatencyCSVReport.generateCSVReport(ar);
		return ar;
	}

	private RealRange getTimeInMilliSec2(final FlowElementInstance fei, final ComponentInstance ci,
			final boolean isPeriodic,
			final Function<NamedElement, Optional<IntegerRangeWithUnits<TimeUnits>>> getExecTime) {
		/*
		 * If the flow element is a component instance or if the thread is periodic, we use the thread's
		 * computation time. Otherwise we try to use the compute execution time from the flow's input feature.
		 */
		if (!(isPeriodic || fei == ci)) { // the flow element is a FlowSpecificationInstance (It is not periodic or a component instance)
			final FlowSpecificationInstance fsi = (FlowSpecificationInstance) fei;
			FeatureInstance fi = fsi.getSource();
			if (fi != null) { // we have an input feature
				final FeatureCategory featureCategory = fi.getCategory();
				if (featureCategory == FeatureCategory.EVENT_PORT
						|| featureCategory == FeatureCategory.EVENT_DATA_PORT) {
					final Optional<IntegerRangeWithUnits<TimeUnits>> fromFeature = getExecTime.apply(fi);
					if (fromFeature.isPresent()) {
						return AnalysisUtils.scaleTimeRange(PropertyUtils.scaleRange(fromFeature.get(), TimeUnits.MS), fi);
					} // otherwise fall through and get from component
				} // otherwise fall through and get from component
			}
		}
		final ComponentCategory componentCategory = ci.getCategory();
		if (componentCategory == ComponentCategory.THREAD || componentCategory == ComponentCategory.DEVICE
				|| componentCategory == ComponentCategory.SUBPROGRAM
				|| componentCategory == ComponentCategory.ABSTRACT) {
			return AnalysisUtils.scaleTimeRange(PropertyUtils.scaleRange(getExecTime.apply(ci), TimeUnits.MS).orElse(RealRange.ZEROED), ci);
		} else {
			return RealRange.ZEROED;
		}
	}

	private RealRange getResponseTimeInMilliSec(final FlowElementInstance fei, final ComponentInstance ci,
			final boolean isPeriodic) {
		return getTimeInMilliSec2(fei, ci, isPeriodic, Sei::getResponseTime);
	}

	private RealRange getExecutionTimeInMilliSec(final FlowElementInstance fei, final ComponentInstance ci,
			final boolean isPeriodic) {
		return getTimeInMilliSec2(fei, ci, isPeriodic, TimingProperties::getComputeExecutionTime);
	}

	private static final void sortBoundConnectionsHelper(final ComponentInstance compInstance,
			final Map<ComponentInstance, Set<ConnectionInstance>> map) {
		for (final ConnectionInstance ci : compInstance.getConnectionInstances()) {
			final List<InstanceObject> bindings = DeploymentProperties.getActualConnectionBinding(ci)
					.orElse(Collections.emptyList());
			for (final InstanceObject io : bindings) {
				final ComponentInstance componentInstance = (ComponentInstance) io;
				addToHashedSet(map, componentInstance, ci);
				processComponentBindings(map, ci, componentInstance);
			}
		}

		for (final ComponentInstance child : compInstance.getComponentInstances()) {
			sortBoundConnectionsHelper(child, map);
		}
	}

	private static final Map<ComponentInstance, Set<ConnectionInstance>> sortBoundConnections(
			final SystemInstance system) {
		final Map<ComponentInstance, Set<ConnectionInstance>> map = new HashMap<>();
		sortBoundConnectionsHelper(system, map);
		return map;
	}

	private static final Set<ComponentCategory> hasConnBindings = EnumSet.of(ComponentCategory.THREAD,
			ComponentCategory.THREAD_GROUP, ComponentCategory.PROCESS, ComponentCategory.SYSTEM,
			ComponentCategory.VIRTUAL_BUS, ComponentCategory.ABSTRACT);

	private static final void processComponentBindings(final Map<ComponentInstance, Set<ConnectionInstance>> map,
			final ConnectionInstance ci, final ComponentInstance componentInstance) {
		final List<InstanceObject> componentBindings = hasConnBindings.contains(componentInstance.getCategory())
				? DeploymentProperties.getActualConnectionBinding(componentInstance).orElse(Collections.emptyList())
				: Collections.emptyList();
		for (final InstanceObject io : componentBindings) {
			final ComponentInstance componentBinding = (ComponentInstance) io;
			addToHashedSet(map, componentBinding, ci);
			processComponentBindings(map, ci, componentBinding);
		}
	}

	private static final <K, V> void addToHashedSet(final Map<K, Set<V>> map, final K key, final V value) {
		Set<V> valueSet = map.get(key);
		if (valueSet == null) {
			valueSet = new HashSet<V>();
			map.put(key, valueSet);
		}
		valueSet.add(value);
	}

	private static final class Pair<A, B> {
		private final A first;
		private final B second;

		public Pair(final A a, final B b) {
			first  = a;
			second = b;
		}

		@Override
		public boolean equals(final Object other) {
			if (other == this) {
				return true;
			} else if (other instanceof Pair) {
				@SuppressWarnings("rawtypes")
				final Pair otherPair = (Pair) other;
				return first.equals(otherPair.first) && second.equals(otherPair.second);
			} else {
				return false;
			}
		}

		@Override
		public int hashCode() {
			int hashCode = 17;
			hashCode = 31 * hashCode + first.hashCode();
			hashCode = 31 * hashCode + second.hashCode();
			return hashCode;
		}

		@Override
		public String toString() {
			return "(" + first + ", " + second + ")";
		}

		@SuppressWarnings("unused")
		public A getFirst() {
			return first;
		}

		@SuppressWarnings("unused")
		public B getSecond() {
			return second;
		}
	}

	private void fillInQueuingTimes(final SystemInstance system) {
		// Nothing to do if there are no asynchronous buses
		if (!asyncBuses.isEmpty()) {
			// Get all the connections bound to a bus and group them together by the bus they are bound to
			final Map<ComponentInstance, Set<ConnectionInstance>> sortedConnections = sortBoundConnections(system);
			/*
			 * Go through the list of all the asynchronous buses
			 */
			for (final NamedElement ne : asyncBuses) {
				// only proceed if it is a bus instance and not a classifier (from Required_Virtual_Bus_Class)
				if (ne instanceof ComponentInstance) {
					final ComponentInstance bus = (ComponentInstance) ne;

					// Get all the connections bound to that bus
					final Set<ConnectionInstance> boundConnections = sortedConnections.getOrDefault(bus,
							Collections.emptySet());
					// Get all the transmission times and compute the total
					double totalTime = 0.0;
					final Map<ConnectionInstance, Double> transmissionTimes = new HashMap<>();
					for (final ConnectionInstance ci : boundConnections) {
						final Double time = computedMaxTransmissionLatencies
								.getOrDefault(new Pair<ComponentInstance, ConnectionInstance>(bus, ci), 0.0);
						transmissionTimes.put(ci, time);
						totalTime += time;
					}

					/*
					 * Go through the list of connections again, and subtract the time associated
					 * with the current connection to find the max waiting time for each connection.
					 * (That each for each connection ci, we will have the sum of all the times
					 * for the _other_ connections bound to same bus. This gives us the max
					 * time that connection ci may have to wait to use the bus.)
					 */
					for (final ConnectionInstance ci : boundConnections) {
						final Double ciTime = transmissionTimes.get(ci);
						final double maxWaitingTime = totalTime - ciTime;

						// Finally we can stick this into the latency contributor
						final LatencyContributor latencyContributor = connectionsToContributors
								.get(new Pair<>(bus, ci));
						if (latencyContributor != null) {
							final LatencyContributor queuingLatencyContributor = new LatencyContributorComponent(bus,
									report.isMajorFrameDelay());
							queuingLatencyContributor.setBestCaseMethod(LatencyContributorMethod.QUEUED);
							queuingLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.QUEUED);
							queuingLatencyContributor.setMinimum(0.0);
							if (report.isDisableQueuingLatency()) {
								// Hide the queuing time
								queuingLatencyContributor.setMaximum(0.0);
								queuingLatencyContributor
										.reportInfo("Ignoring queuing time of " + maxWaitingTime + "ms");
							} else {
								// Report the queuing time
								queuingLatencyContributor.setMaximum(maxWaitingTime);
							}
							latencyContributor.addSubContributor(queuingLatencyContributor);

							// add the sampling latency
							LatencyContributor samplingLatencyContributor = new LatencyContributorComponent(bus,
									report.isMajorFrameDelay());
							samplingLatencyContributor.setBestCaseMethod(LatencyContributorMethod.SAMPLED_PROTOCOL);
							samplingLatencyContributor.setWorstCaseMethod(LatencyContributorMethod.SAMPLED_PROTOCOL);
							samplingLatencyContributor.setSamplingPeriod(0.0);
							latencyContributor.addSubContributor(samplingLatencyContributor);
						}
					}
				}
			}
		}
	}

	// *****************************
	// *** These horrible methods are left over from GetProperties, and check that a property has a value.
	// *** They are hard to emulate with the property methods.
	// *****************************

	private static boolean isAssignedDeadline(final NamedElement ne) {
		Property deadline = lookupPropertyDefinition(ne, org.osate.xtext.aadl2.properties.util.TimingProperties._NAME,
				org.osate.xtext.aadl2.properties.util.TimingProperties.DEADLINE);
		return isAssignedPropertyValue(ne, deadline);
	}

	private static Property lookupPropertyDefinition(EObject context, String ps, String name) {
		return Aadl2GlobalScopeUtil.get(context, Aadl2Package.eINSTANCE.getProperty(),
				((ps != null && !ps.isEmpty()) ? (ps + "::" + name) : name));
	}

	private static boolean isAssignedPropertyValue(NamedElement element, Property pn) {
		try {
			final PropertyAcc propertyAccumulator = element.getPropertyValue(pn);
			PropertyAssociation firstAssociation = propertyAccumulator.first();
			return firstAssociation != null;
		} catch (org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException exception) {
			return false;
		}
	}

	private static Property lookupPropertyDefinition(EObject context, String qpname) {
		return Aadl2GlobalScopeUtil.get(context, Aadl2Package.eINSTANCE.getProperty(), qpname);
	}

	private static boolean hasAssignedPropertyValue(NamedElement element, String pname) {
		Property pn = lookupPropertyDefinition(element, pname);
		return isAssignedPropertyValue(element, pn);
	}

}
