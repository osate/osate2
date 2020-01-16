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
package org.osate.analysis.resource.management.handlers;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessorClassifier;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.SystemClassifier;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceUtil;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.ui.handlers.AbstractInstanceOrDeclarativeModelReadOnlyHandler;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

import EAnalysis.BinPacking.AssignmentResult;
import EAnalysis.BinPacking.BFCPBinPacker;
import EAnalysis.BinPacking.BandwidthComparator;
import EAnalysis.BinPacking.CapacityComparator;
import EAnalysis.BinPacking.CompositeSoftNode;
import EAnalysis.BinPacking.DFBPBinPacker;
import EAnalysis.BinPacking.DFCPBinPacker;
import EAnalysis.BinPacking.Disjoint;
import EAnalysis.BinPacking.Expansor;
import EAnalysis.BinPacking.HardwareNode;
import EAnalysis.BinPacking.LowLevelBinPacker;
import EAnalysis.BinPacking.Message;
import EAnalysis.BinPacking.NFCHoBinPacker;
import EAnalysis.BinPacking.NoExpansionExpansor;
import EAnalysis.BinPacking.OutDegreeAssignmentProblem;
import EAnalysis.BinPacking.OutDegreeComparator;
import EAnalysis.BinPacking.SetConstraint;
import EAnalysis.BinPacking.Site;
import EAnalysis.BinPacking.SiteArchitecture;
import EAnalysis.BinPacking.SiteGuest;
import EAnalysis.BinPacking.SoftwareNode;

/**
 * Handler performs a binpacking on all the threads in a given system.  Tries
 * to map them to the processors based on their allowed processor bindings
 * and not_collocated property values.
 *
 * <p>This used to extend AaxlModifyAction, but (1) that class seems to be
 * broken right now, and (2) we don't want to automatically save the resource
 * because we are going to change it using an command via the core editor.
 */
public class Binpack extends AbstractInstanceOrDeclarativeModelReadOnlyHandler {
	private static final int IMMEDIATE_PARTITION = 0;
	private static final int DEFER_EXEC_TIME = 1;
	private static final int DEFER_BANDWIDTH = 2;

	public static double defaultMIPS = 1000.0;

	private int partitionChoice = 2;

	@Override
	public String getMarkerType() {
		return "org.osate.analysis.resource.management.BinpackObjectMarker";
	}

	@Override
	protected String getActionName() {
		return "Bind threads to processors";
	}

	// Don't allow analysis in all modes.
	@Override
	protected boolean analyzeInSingleModeOnly() {
		return true;
	}

	@Override
	protected boolean initializeAction(NamedElement obj) {
		setCSVLog("Binpacking", obj);

		// Select the bin packing strategy
		partitionChoice = org.osate.ui.dialogs.Dialog.askQuestion("Choose partitioning algorithm",
				"This bin packing algorithm groups threads that "
						+ "communicate with each other in groups and try to fit them "
						+ "together. If it is not possible it will partition the groups.\n\n"
						+ "Two main partitioning strategies exist: \n"
						+ "(1) Partition group as soon as they are discovered not to fit.\n"
						+ "(2) Put them aside and continue packing all groups that fit and after "
						+ "partition those that did not fit. Additionally it can select the "
						+ "group to partition based on the amount of data being communicated or "
						+ "the amount of computing cycles required by the group.",
				new String[] { "Immediate Partition of Groups", "Defer Partition of Groups Based on Exec. Time",
						"Defer Partition of Groups Based on Comm. Bandwidth" },
				IMMEDIATE_PARTITION);
		return partitionChoice != -1;
	}

	@Override
	protected boolean canAnalyzeDeclarativeModels() {
		return false;
	}

	@Override
	protected void analyzeDeclarativeModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			Element declarativeObject) {
	}

	protected void checkBuses(ComponentInstance obj) {
		final RecordValue transTime = GetProperties.getTransmissionTime(obj);
		if (transTime == null) {
			logWarning("Bus " + obj.getComponentInstancePath()
					+ " is missing Transmission Time property. Using default of " + AADLBus.DEFAULT_TRANSMISSION_TIME);
		}

	}

	public void invoke(IProgressMonitor monitor, SystemInstance root, SystemOperationMode som) {
		invoke(monitor, AnalysisErrorReporterManager.NULL_ERROR_MANANGER, root, som);
	}

	public void invoke(final IProgressMonitor monitor, final AnalysisErrorReporterManager errManager,
			final SystemInstance root, final SystemOperationMode som) {
		this.errManager = errManager != null ? errManager
				: new AnalysisErrorReporterManager(getAnalysisErrorReporterFactory());
		analyzeInstanceModel(monitor, this.errManager, root, som);
	}

	@Override
	protected void analyzeInstanceModel(final IProgressMonitor monitor, final AnalysisErrorReporterManager errManager,
			final SystemInstance root, final SystemOperationMode som) {
		try {
			monitor.beginTask("Binding threads to processors in " + root.getName(), IProgressMonitor.UNKNOWN);

			logInfo("Binpacker Analysis Report\n");
			/*
			 * Verify that all the busses have a transmission time
			 */
			final ForAllElement addBuses = new ForAllElement(errManager) {
				@Override
				public void process(Element obj) {
					checkBuses((ComponentInstance) obj);
				}
			};
			addBuses.processPreOrderComponentInstance(root, ComponentCategory.BUS);

			/*
			 * Find and report all thread and device instances that don't have a
			 * period specified.
			 */
			EList<Element> incompletethreads = new ForAllElement() {
				@Override
				protected boolean suchThat(Element obj) {
					final ComponentCategory cat = ((ComponentInstance) obj).getCategory();
					if (cat == ComponentCategory.THREAD || cat == ComponentCategory.DEVICE) {
						return GetProperties.getPeriodinMS((ComponentInstance) obj) == 0.0;
					} else {
						return false;
					}
				}
			}.processPreOrderComponentInstance(root);
			for (final Iterator<Element> i = incompletethreads.iterator(); i.hasNext();) {
				final ComponentInstance o = (ComponentInstance) i.next();
				logWarning((InstanceModelUtil.isThread(o) ? "Thread " : "Device ") + o.getComponentInstancePath()
						+ " is missing period property. Using default of 1 ns");
			}

			/*
			 * Find and report all thread instances that don't have a
			 * compute execution time specified.
			 */
			incompletethreads = new ForAllElement() {
				@Override
				protected boolean suchThat(Element obj) {
					return GetProperties.getThreadExecutioninMilliSec((ComponentInstance) obj) == 0.0;
				}
			}.processPreOrderComponentInstance(root, ComponentCategory.THREAD);
			for (final Iterator<Element> i = incompletethreads.iterator(); i.hasNext();) {
				final ComponentInstance o = (ComponentInstance) i.next();
				logWarning("Thread " + o.getComponentInstancePath()
						+ " is missing compute_execution_time or InstructionsPerDispatch property. Using default of 0 ns");
			}

			/*
			 * Find if all the port connections have data size
			 */
			final ForAllElement addThreadConnections = new ForAllElement(errManager) {
				@Override
				public void process(Element obj) {
					if (obj instanceof ConnectionInstance) {
						final ConnectionInstance connInst = (ConnectionInstance) obj;
						if (connInst.getKind() == ConnectionKind.PORT_CONNECTION) {
							final FeatureInstance src = (FeatureInstance) connInst.getSource();

							Feature srcAP = src.getFeature();
							Classifier cl = srcAP.getClassifier();
							if (cl instanceof DataClassifier) {
								DataClassifier srcDC = (DataClassifier) cl;
								if (GetProperties.getSourceDataSizeInBytes(srcDC) == 0) {
									logWarning("Data size of connection source port " + src.getComponentInstancePath()
											+ " not specified");
								}
							}
						}
					}
				}
			};
			addThreadConnections.processPreOrderAll(root);

			/* The partitionChoice is set in initializeANalysis() */
			NoExpansionExpansor expansor = new NoExpansionExpansor();
			LowLevelBinPacker packer = null;
			if (partitionChoice == IMMEDIATE_PARTITION) {
				packer = new BFCPBinPacker(expansor);
			} else if (partitionChoice == DEFER_EXEC_TIME) {
				packer = new DFCPBinPacker(expansor);
			} else if (partitionChoice == DEFER_BANDWIDTH) {
				packer = new DFBPBinPacker(expansor);
			}

			AssignmentResult result = binPackSystem(root, expansor, packer, errManager, som);

			reportResults(som, result);

			if (result.success) {
				showResults(som, root, result);
			} else {
				showNoResults(som);
			}
		} catch (InvalidModelException e) {
			error(e.getElement(), e.getMessage());
		}
	}

	protected EList<Element> getExecutionUnits(SystemInstance root) {
		return new ForAllElement().processPreOrderComponentInstance(root, ComponentCategory.THREAD);
	}

	boolean existsProcessorWithMIPS = false;
	boolean existsProcessorWithoutMIPS = false;
	boolean existsThreadWithReferenceProcessor = false;
	boolean existsThreadWithoutReferenceProcessor = false;

	protected AssignmentResult binPackSystem(final SystemInstance root, Expansor expansor, LowLevelBinPacker packer,
			final AnalysisErrorReporterManager errManager, final SystemOperationMode som) {

		existsProcessorWithMIPS = false;
		existsProcessorWithoutMIPS = false;
		existsThreadWithReferenceProcessor = false;
		existsThreadWithoutReferenceProcessor = false;

		/*
		 * Map from AADL ComponentInstances representing threads to
		 * the bin packing SoftwareNode that models the thread.
		 */
		final Map<ComponentInstance, AADLThread> threadToSoftwareNode = new HashMap<>();
		/*
		 * Set of thread components. This is is the keySet of
		 * threadToSoftwareNode.
		 */
		final Set<ComponentInstance> threads = threadToSoftwareNode.keySet();
		/*
		 * Map from AADL ComponentInstances representing threads to
		 * the set of AADL ComponentInstances that cannot be collocated
		 * with it.
		 */
		final Map<ComponentInstance, Set<ComponentInstance>> notCollocated = new HashMap<>();

		/*
		 * Map from AADL ComponentInstance representing processors to
		 * the bin packing Processor that models them.
		 */
		final Map<ComponentInstance, AADLProcessor> procToHardware = new HashMap<>();

		/*
		 * Map from AADL BusInstance representing Buses to
		 * The bin packing Link that models them.
		 */
		final Map<ComponentInstance, AADLBus> busToHardware = new HashMap<>();

		/*
		 * One site to rule them all! We don't care about the site
		 * architecture, so just create one site to hold everything.
		 * We aren't worried about power or space issues either, so
		 * we just set them to 100.0 because those are nice values.
		 * The site accepts AADL processors.
		 */
		final SiteArchitecture siteArchitecture = new SiteArchitecture();
		AADLProcessor ap = AADLProcessor.PROTOTYPE;
		final Site theSite = new Site(100.0, 100.0, new SiteGuest[] { ap });
		siteArchitecture.addSite(theSite);

		/*
		 * The hardware is fixed based on the AADL specification, so we
		 * use the NoExpansionExpansor to keep the hardware from being
		 * generated for us.
		 */

		expansor.setSiteArchitecture(siteArchitecture);

		/*
		 * Populate the problem space based on the AADL specification. First
		 * we walk the instance model and add all the processors. Then we
		 * walk the instance model again to add all the threads.
		 */
		OutDegreeAssignmentProblem problem1 = new OutDegreeAssignmentProblem(new OutDegreeComparator(),
				new BandwidthComparator(), new CapacityComparator());
		problem1.setErrorReporter(new BinPackErrorReporter());
		final OutDegreeAssignmentProblem problem = problem1;
		// Add procs
		final ForAllElement addProcessors = new ForAllElement(errManager) {
			@Override
			public void process(Element obj) {
				ComponentInstance ci = (ComponentInstance) obj;
				// the createInstance method already assigns a default MIPS if none exists
				double mips = GetProperties.getProcessorMIPS(ci);
				// checking consistency;
				existsProcessorWithMIPS |= (mips != 0);
				existsProcessorWithoutMIPS |= (mips == 0);

				final AADLProcessor proc = AADLProcessor.createInstance(ci);
				if (proc != null) {
					System.out.println("Processor cycles Per sec:" + proc.getCyclesPerSecond());
					siteArchitecture.addSiteGuest(proc, theSite);
					problem.hardwareGraph.add(proc);
					// add reverse mapping
					procToHardware.put(ci, proc);
				}
			}
		};
		addProcessors.processPreOrderComponentInstance(root, ComponentCategory.PROCESSOR);

		/*
		 * Get all the links
		 */

		final ForAllElement addBuses = new ForAllElement(errManager) {
			@Override
			public void process(Element obj) {
				ComponentInstance bi = (ComponentInstance) obj;

				final AADLBus bus = AADLBus.createInstance(bi);
				busToHardware.put(bi, bus);
			}
		};

		addBuses.processPreOrderComponentInstance(root, ComponentCategory.BUS);

		/*
		 * create the links between processors and busses
		 * (i.e., process connections)
		 */
		for (final Iterator<ConnectionInstance> i = root.getAllConnectionInstances().iterator(); i.hasNext();) {
			final ConnectionInstance connInst = i.next();
			if (connInst.getKind() == ConnectionKind.ACCESS_CONNECTION) {
				InstanceObject src = connInst.getSource();
				InstanceObject dst = connInst.getDestination();

				AADLBus bus = null;
				AADLProcessor processor = null;

				// swap if i got them in the opposite order
				if (src instanceof FeatureInstance) {
					InstanceObject tmp = dst;
					dst = src;
					src = tmp;
				}

				bus = busToHardware.get(src);
				FeatureInstance fi = (FeatureInstance) dst;

				processor = procToHardware.get(fi.getContainingComponentInstance());

				if (bus != null && processor != null) {
					bus.add(processor);
					processor.attachToLink(bus);
				}
			}
		}

		// Now add all the links so the connectivity matrix in the problem is
		// updated correctly

		for (Iterator<AADLBus> iBus = busToHardware.values().iterator(); iBus.hasNext();) {
			AADLBus bus = iBus.next();
			problem.addLink(bus);
			siteArchitecture.addSiteGuest(bus, theSite);
		}

		// Add threads
		final ForAllElement addThreads = new ForAllElement(errManager) {
			@Override
			public void process(Element obj) {
				final ComponentInstance ci = (ComponentInstance) obj;

				/**
				 * JD - check the modes according to what was
				 * suggested by Dave.
				 */
				boolean selected = true;

				if (som.getCurrentModes().size() > 0) {
					selected = false;
					for (ModeInstance mi : ci.getInModes()) {
						if (mi == som.getCurrentModes().get(0)) {
							selected = true;
						}
					}
				}

				if (!selected) {
					return;
				}

				final AADLThread thread = AADLThread.createInstance(ci);
				double refmips = GetProperties.getReferenceMIPS(ci);

				// validate consistency
				existsThreadWithReferenceProcessor |= (refmips != 0);
				existsThreadWithoutReferenceProcessor |= (refmips == 0);

				problem.softwareGraph.add(thread);
//				logInfo(thread.getReport());
				// add reverse mapping
				threadToSoftwareNode.put(ci, thread);

				// Process NOT_COLLOCATED property.
				RecordValue disjunctFrom = GetProperties.getNotCollocated(ci);
				if (disjunctFrom == null) {
					return;
				}
				final Set<ComponentInstance> disjunctSet = new HashSet<>();
				ListValue tvl = (ListValue) PropertyUtils.getRecordFieldValue(disjunctFrom, "Targets");
				for (PropertyExpression ref : tvl.getOwnedListElements()) {
					/*
					 * Add all the instances rooted at the named instance.
					 * For example, the thread may be declared to be disjunct
					 * from another process, so we really want to be disjunct
					 * from the other threads contained in that process.
					 */
					final InstanceReferenceValue rv = (InstanceReferenceValue) ref;
					final ComponentInstance refCI = (ComponentInstance) rv.getReferencedInstanceObject();
					disjunctSet.addAll(refCI.getAllComponentInstances());
				}
				if (!disjunctSet.isEmpty()) {
					notCollocated.put(ci, disjunctSet);
				}
			}
		};
		addThreads.processPreOrderComponentInstance(root, ComponentCategory.THREAD);

		/*
		 * MIPS consistency rules:
		 *
		 * Either all threads have reference processor with mips and all processors have mips spec or
		 * None of the threads and processors have any mips specification and we can use the default mips
		 */

		// only some processors have mips
		if (existsProcessorWithMIPS && existsProcessorWithoutMIPS) {
			errManager.error(root, "Not all processors have MIPSCapacity");
			return null;
		}
		// only some threads with reference processor
		if (existsThreadWithReferenceProcessor && existsThreadWithoutReferenceProcessor) {
			errManager.error(root, "Not all threads have execution time reference processor");
			return null;
		}

		// threads and processors mips spec not consistent
		if (existsProcessorWithMIPS && existsThreadWithoutReferenceProcessor) {
			errManager.error(root,
					"There are some processors with MIPSCapacity but some threads without execution time reference processors");
			return null;
		}

		if (existsProcessorWithoutMIPS && existsThreadWithReferenceProcessor) {
			errManager.error(root,
					"There are some threads with execution time reference processors but not all processors have MIPSCapacity");
			return null;
		}

		// Add thread connections (Messages)
		for (final Iterator<ConnectionInstance> i = root.getAllConnectionInstances().iterator(); i.hasNext();) {
			final ConnectionInstance connInst = i.next();
			if (connInst.getKind() == ConnectionKind.PORT_CONNECTION) {
				if (!(connInst.getSource() instanceof FeatureInstance
						&& connInst.getDestination() instanceof FeatureInstance)) {
					continue;
				}
				final FeatureInstance src = (FeatureInstance) connInst.getSource();
				final FeatureInstance dst = (FeatureInstance) connInst.getDestination();

				final ComponentInstance ci = src.getContainingComponentInstance();
				AADLThread t1 = threadToSoftwareNode.get(ci);
				AADLThread t2 = threadToSoftwareNode.get(dst.getContainingComponentInstance());
				if (t1 != null && t2 != null) {
					Feature srcAP = src.getFeature();
					// TODO: get the property directly
					Classifier cl = srcAP.getClassifier();
					if (cl instanceof DataClassifier) {
						DataClassifier srcDC = (DataClassifier) cl;
						double dataSize = 0.0;
						double threadPeriod = 0.0;
						try {
							dataSize = GetProperties.getSourceDataSizeInBytes(srcDC);
						} catch (Exception e) {
							errManager.warning(connInst, "No Data Size for connection");
						}
						try {
							threadPeriod = GetProperties.getPeriodinNS(ci);
						} catch (Exception e) {
							errManager.warning(connInst, "No Period for connection");
						}

						// Now I can create the Message

						Message msg = new Message((long) dataSize, (long) threadPeriod, (long) threadPeriod, t1, t2);
						System.out.println(">>>>>>>>>> Adding message (" + Long.toString((long) dataSize) + "/"
								+ Long.toString((long) threadPeriod) + ") between " + t1.getName() + " and "
								+ t2.getName() + " based on connection " + connInst.getName());
						problem.addMessage(msg);
					} else {
						errManager.warning(connInst, "No Data Classifier for connection");
					}
				}
			}
		}

		// Add collocation constraints
		for (final Iterator<ComponentInstance> constrained = notCollocated.keySet().iterator(); constrained.hasNext();) {
			final ComponentInstance ci = constrained.next();
			final SoftwareNode sn = threadToSoftwareNode.get(ci);
			final Set<ComponentInstance> disjunctFrom = notCollocated.get(ci);
			for (final Iterator<ComponentInstance> dfIter = disjunctFrom.iterator(); dfIter.hasNext();) {
				/*
				 * Items in the disjunctFrom set do not have to be thread
				 * instances because of the way we add items to it (see above).
				 * We are only interested in the thread instances here, in
				 * particular because we only create SoftwareNodes for the
				 * thread instances, and we don't want to get null return
				 * values from the threadToSoftwareNode map.
				 */
				final ComponentInstance ci2 = dfIter.next();
				if (ci2.getCategory() == ComponentCategory.THREAD) {
					final SoftwareNode sn2 = threadToSoftwareNode.get(ci2);
					final SoftwareNode[] disjunction = new SoftwareNode[] { sn, sn2 };
					problem.addConstraint(new Disjoint(disjunction));
				}
			}
		}

		/*
		 * Add Allowed_Processor_Binding and
		 * Allowed_Processor_Binding_Class constraints
		 */
		for (final Iterator<ComponentInstance> i = threads.iterator(); i.hasNext();) {
			final ComponentInstance thr = i.next();
			final SoftwareNode thrSN = threadToSoftwareNode.get(thr);
			Collection<ComponentInstance> allowed = getActualProcessorBindings(thr);
			if (allowed.size() == 0) {
				allowed = getAllowedProcessorBindings(thr);
			}
			if (allowed.size() > 0) {
				final Object[] allowedProcs = new Object[allowed.size()];
				int idx = 0;
				for (Iterator<ComponentInstance> j = allowed.iterator(); j.hasNext(); idx++) {
					final ComponentInstance proc = j.next();
					allowedProcs[idx] = procToHardware.get(proc);
				}
				problem.addConstraint(new SetConstraint(new SoftwareNode[] { thrSN }, allowedProcs));
			}
		}

		// Try to bin pack
		final NFCHoBinPacker highPacker = new NFCHoBinPacker(packer);
		final boolean res = highPacker.solve(problem);
		return new AssignmentResult(problem, res);
	}

	private abstract static class ShowDialog implements Runnable {
		public volatile int result;
	}

	String getBindingText(final Map threadsToProc) {
		String bindings = "";
		for (Iterator iter = threadsToProc.keySet().iterator(); iter.hasNext();) {
			final ComponentInstance thread = (ComponentInstance) iter.next();
			final ComponentInstance proc = (ComponentInstance) threadsToProc.get(thread);
			bindings += "Actual_Processor_Binding => reference (" + proc.getInstanceObjectPath() + ") applies to "
					+ thread.getInstanceObjectPath() + ";\n";
		}

		return bindings;
	}

	public void showResults(final SystemOperationMode som, final SystemInstance root, final AssignmentResult result) {
		final Map threadsToProc = getThreadBindings(result.problem.hardwareGraph);

		final String propText = getBindingText(threadsToProc);
		boolean done = false;
		final Shell sh = getShell();
		while (sh != null && !done) {
			final Dialog d = new PackingSuccessfulDialog(getShell(), som, root.getComponentImplementation().getName(),
					threadsToProc, result.problem.hardwareGraph, propText);
			final ShowDialog sd = new ShowDialog() {
				@Override
				public void run() {
					this.result = d.open();
				}
			};
			Display.getDefault().syncExec(sd);

			if (sd.result == PackingSuccessfulDialog.INSTANCE_ID) {
				setInstanceModelBindings(root, threadsToProc);
			}
			// XXX: Don't set properties in the declarative model any more?
//				else if (button == PackingSuccessfulDialog.DECLARATIVE_ID) {
//					setDeclarativeBindings(root, threadsToProc);
//				}
			else {
				done = true;
			}
		}
	}

	public void showNoResults(final SystemOperationMode som) {
		org.osate.ui.dialogs.Dialog.showError("Application Binding Results",
				"In system operation mode " + som.getName() + "the application system is not schedulable");
	}

	private Map getThreadBindings(final Set hardware) {
		final Map threadsToProc = new HashMap();
		for (Iterator iter = hardware.iterator(); iter.hasNext();) {
			HardwareNode n = (HardwareNode) iter.next();
			for (Iterator taskSet = n.getTaskSet().iterator(); taskSet.hasNext();) {
				SoftwareNode m = (SoftwareNode) taskSet.next();
				if (m instanceof CompositeSoftNode) {
					final Set set = ((CompositeSoftNode) m).getBasicComponents();
					for (Iterator software = set.iterator(); software.hasNext();) {
						final SoftwareNode sn = (SoftwareNode) software.next();
						threadsToProc.put(sn.getSemanticObject(), n.getSemanticObject());
					}
				} else {
					if (!(m instanceof Message)) {
						threadsToProc.put(m.getSemanticObject(), n.getSemanticObject());
					}
				}
			}
		}
		return threadsToProc;
	}

	public void reportResults(SystemOperationMode som, final AssignmentResult result) {
		final Map threadsToProc = getThreadBindings(result.problem.hardwareGraph);

		logInfo("\nBinpacking results"
				+ (!som.getName().equalsIgnoreCase("No Modes") ? " for SOM " + som.getName() : "") + ": "
				+ (result.success ? "Success" : "FAILED"));
		for (final Iterator i = result.problem.hardwareGraph.iterator(); i.hasNext();) {
			final HardwareNode hn = (HardwareNode) i.next();
			final ComponentInstance proc = (ComponentInstance) hn.getSemanticObject();
			double load = hn.cyclesPerSecond - hn.getAvailableCapacity();
			load /= hn.cyclesPerSecond;
			load *= 100.0;
			long longLoad = (long) Math.ceil(load);
			double overload = (hn.cyclesPerSecond - hn.getAvailableCapacity()) - (hn.cyclesPerSecond);
			overload /= hn.cyclesPerSecond;
			overload *= 100.0;
			long longOverload = (long) Math.ceil(overload);
			long available = longOverload * -1;
			logInfo("Processor " + proc.getInstanceObjectPath() + " (" + hn.cyclesPerSecond / 1000000 + " MIPS) Load: "
					+ Long.toString(longLoad) + "%" + " Available: " + Long.toString(available) + "%");
		}
		logInfo("\nThread to Processor Bindings");
		for (Iterator iter = threadsToProc.keySet().iterator(); iter.hasNext();) {
			final ComponentInstance thread = (ComponentInstance) iter.next();
			final ComponentInstance proc = (ComponentInstance) threadsToProc.get(thread);
			double threadMips = GetProperties.getThreadExecutioninMIPS(thread);
			double cpumips = GetProperties.getMIPSCapacityInMIPS(proc, 0);

			logInfo("Thread " + thread.getInstanceObjectPath() + " ==> Processor " + proc.getInstanceObjectPath()
					+ (cpumips > 0 ? (" Utilization " + threadMips / cpumips * 100 + "%") : " No CPU capacity"));
		}
	}

	private void setInstanceModelBindings(final SystemInstance root, final Map threadsToProc) {
		final EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(root);
		if (editingDomain != null) {
			final CommandStack cmdStack = editingDomain.getCommandStack();
			final Command setBindings = new SetInstanceModelBindings(threadsToProc);
			cmdStack.execute(setBindings);
		} else {
			internalError("Couldn't get editing domain");
		}

		/*
		 * XXX: Keep this around for now. May want to keep the ability to
		 * modify the model directly so that we can use this action without
		 * using an editor.
		 */
//		for (Iterator iter = threadsToProc.keySet().iterator(); iter.hasNext(); ) {
//			final ComponentInstance thread = (ComponentInstance) iter.next();
//			final ComponentInstance proc = (ComponentInstance) threadsToProc.get(thread);
//			final InstanceReferenceValue val = InstanceFactory.eINSTANCE.createInstanceReferenceValue();
//			val.setReferencedInstanceObject(proc);
//			thread.setPropertyValue(Binpack.actualProcessorBinding, val);
//		}
	}

	/*
	 * We don't want to do this anymore? Keep the code around for the moment
	 * though.
	 */
//	/** @deprecated */
//	private void setDeclarativeBindings(
//			final SystemInstance root, final Map threadsToProc) {
//		final SystemImpl system = root.getSystemImpl();
//		for (Iterator iter = threadsToProc.keySet().iterator(); iter.hasNext(); ) {
//			final ComponentInstance thread = (ComponentInstance) iter.next();
//			final ComponentInstance proc = (ComponentInstance) threadsToProc.get(thread);
//			final ReferenceValue procRef = proc.getReferenceTo();
//			final List threadPath = thread.getReferencePathTo();
//			system.setContainedPropertyValue(
//					Binpack.actualProcessorBinding,
//					threadPath, procRef);
//		}
//	}

//	private Properties constructDeclarativeBindings(final Map threadsToProc) {
//		final Properties props = PropertyFactory.eINSTANCE.createProperties();
//		for (Iterator iter = threadsToProc.keySet().iterator(); iter.hasNext(); ) {
//			final ComponentInstance thread = (ComponentInstance) iter.next();
//			final ComponentInstance proc = (ComponentInstance) threadsToProc.get(thread);
//			final ReferenceValue procRef = proc.getReferenceTo();
//			final List threadPath = thread.getReferencePathTo();
//
//			// create the Property Association
//			final PropertyAssociation pa =
//				PropertyFactory.eINSTANCE.createPropertyAssociation();
//			properties.setActualProcessorBindingDefinitionToAssociation(pa);
//			for (final Iterator i = threadPath.iterator(); i.hasNext(); ) {
//				pa.addAppliesTo((PropertyHolder) i.next());
//			}
//			pa.addPropertyValue(procRef);
//			props.addPropertyAssociation(pa);
//		}
//		return props;
//	}

	/**
	 * Get the processor components that a given thread is allowed to be bound to
	 * based on the thread's ACTUAL_PROCESSOR_BINDING property value. The processors are
	 * search for in the same system instance that the given thread component is
	 * a part of.
	 *
	 * @param thread
	 *                 The thread.
	 * @return An unmodifiable set of processor ComponentInstances.
	 * @exception IllegalArgumentException
	 *                      Thrown if the category of the component instance
	 *                      referenced by <code>thread</code> is not
	 *                      {@link ComponentCategory#THREAD_LITERAL}.
	 */
	public Collection<ComponentInstance> getActualProcessorBindings(final ComponentInstance thread) {
		if (thread.getCategory() != ComponentCategory.THREAD) {
			throw new IllegalArgumentException("Component \"" + thread.getName() + "\" is not a thread.");
		}
		return InstanceModelUtil.getBoundPhysicalProcessors(thread);
	}

	/**
	 * Get the processor components that a given thread is allowed to be bound to
	 * based on the thread's ALLOWED_PROCESSOR_BINDING and
	 * ALLOWED_PROCESSOR_BINDING_CLASS property values. The processors are
	 * search for in the same system instance that the given thread component is
	 * a part of.
	 *
	 * @param thread
	 *                 The thread.
	 * @return An unmodifiable set of processor ComponentInstances.
	 * @exception IllegalArgumentException
	 *                      Thrown if the category of the component instance
	 *                      referenced by <code>thread</code> is not
	 *                      {@link ComponentCategory#THREAD_LITERAL}.
	 */
	public Set<ComponentInstance> getAllowedProcessorBindings(final ComponentInstance thread) {
		if (thread.getCategory() != ComponentCategory.THREAD) {
			throw new IllegalArgumentException("Component \"" + thread.getName() + "\" is not a thread.");
		}
		List<ComponentInstance> allowedBindingsVals;
		try {
			allowedBindingsVals = GetProperties.getAllowedProcessorBinding(thread);
		} catch (PropertyNotPresentException e) {
			// Ignore this situation and move on.
			allowedBindingsVals = Collections.emptyList();
		}
		List<Classifier> allowedClassVals;
		try {
			allowedClassVals = GetProperties.getAllowedProcessorBindingClass(thread);
		} catch (PropertyNotPresentException e) {
			// Ignore this situation and move on.
			allowedClassVals = Collections.emptyList();
		}
		final Set<ComponentInstance> searchRoots = new HashSet<>();
		if (allowedBindingsVals.isEmpty()) {
			searchRoots.add(thread.getSystemInstance());
		} else {
			for (final Iterator<ComponentInstance> i = allowedBindingsVals.iterator(); i.hasNext();) {
				final ComponentInstance rv = i.next();
				searchRoots.add(rv);
			}
		}
		final Set<SystemClassifier> allowedSystemClassifiers = new HashSet<>();
		final Set<ProcessorClassifier> allowedProcClassifiers = new HashSet<>();
		for (final Iterator<Classifier> i = allowedClassVals.iterator(); i.hasNext();) {
			final Classifier cc = i.next();
			if (cc instanceof ProcessorClassifier) { // ComponentCategory.PROCESSOR) {
				allowedProcClassifiers.add((ProcessorClassifier) cc);
			} else if (cc instanceof SystemClassifier) {// cv.getValue() == ComponentCategory.SYSTEM_LITERAL) {
				allowedSystemClassifiers.add((SystemClassifier) cc);
			} else {
				internalError(
						"Ill-formed allowed_processor_binding_class value: got a non-system non-processor component classifier");
			}
		}
		final Set<ComponentInstance> allowedProcs = new HashSet<>();
		for (final Iterator<ComponentInstance> i = searchRoots.iterator(); i.hasNext();) {
			final ComponentInstance ci = i.next();
			getAllowedProcessorBindings(ci, allowedProcs, allowedProcClassifiers, allowedSystemClassifiers);
		}
		return Collections.unmodifiableSet(allowedProcs);
	}

	/**
	 * Search the instance model structure rooted at the given component
	 * instance and add allowed processors to the given set of processors. A
	 * processor is added if it's component classifier matches the given set of
	 * processor classifiers (where the empty set means all processors). A
	 * system component instance is explored if it's component classifier
	 * matches the given set of system classifiers (where the empty set means
	 * all systems). This method does nothing if given a non-system,
	 * non-processor component instance.
	 *
	 * @param searchRoot
	 *                 The component instance to consider.
	 * @param allowedProcs
	 *                 The set of processors. This set is added to by this method.
	 * @param allowedProcClassifiers
	 *                 The set of component classifiers describing allowable
	 *                 processors.
	 * @param allowedSystemClassifiers
	 *                 The of component classifiers describing allowable systems.
	 */
	private void getAllowedProcessorBindings(final ComponentInstance searchRoot, final Set<ComponentInstance> allowedProcs,
			final Set<ProcessorClassifier> allowedProcClassifiers, final Set<SystemClassifier> allowedSystemClassifiers) {
		if (searchRoot.getCategory() == ComponentCategory.PROCESSOR) {
			/* If it's a processor, only add it if the classifier is okay. */
			if (testClassifier(searchRoot, allowedProcClassifiers)) {
				allowedProcs.add(searchRoot);
			}
		} else if (searchRoot.getCategory() == ComponentCategory.SYSTEM) {
			/*
			 * If it's a system then we look inside it for processors and other
			 * systems. But only look if the classifiers match.
			 */
			if (testClassifier(searchRoot, allowedSystemClassifiers)) {
				for (final Iterator<ComponentInstance> i = searchRoot.getComponentInstances().iterator(); i.hasNext();) {
					getAllowedProcessorBindings(i.next(), allowedProcs, allowedProcClassifiers,
							allowedSystemClassifiers);
				}
			}
		} else {
			// Do nothing, not interested in non-processor, non-system instance
		}
	}

	/**
	 * Test a component against a set of classifiers.
	 *
	 * @return Whether the component's classifier type is a descendent of any of
	 *         the given component classifiers. <em>Returns <code>true</code>
	 *         if the given set is empty!</em>
	 */
	public boolean testClassifier(ComponentInstance ci, final Set<? extends ComponentClassifier> classifiers) {
		if (classifiers.isEmpty()) {
			return true;
		}
		boolean match = false;
		ComponentClassifier cicc = InstanceUtil.getComponentClassifier(ci, 0, null);
		if (cicc == null) {
			return true;
		}
		for (final Iterator<? extends ComponentClassifier> i = classifiers.iterator(); i.hasNext() && !match;) {
			final ComponentClassifier cc = i.next();
			match = cicc.isDescendentOf(cc);
		}
		return match;
	}
}