package org.osate.analysis.resource.scheduling.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.analysis.resource.management.actions.AADLProcessor;
import org.osate.analysis.resource.management.actions.AADLThread;
import org.osate.analysis.resource.scheduling.Activator;
import org.osate.ui.actions.AbstractInstanceOrDeclarativeModelReadOnlyAction;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osgi.framework.Bundle;

public class ScheduleResource extends AbstractInstanceOrDeclarativeModelReadOnlyAction {

	@Override
	protected void analyzeDeclarativeModel(IProgressMonitor monitor, AnalysisErrorReporterManager errManager,
			Element declarativeObject) {
		// TODO Auto-generated method stub

	}

	boolean existsProcessorWithMIPS = false;
	boolean existsProcessorWithoutMIPS = false;
	boolean existsThreadWithReferenceProcessor = false;
	boolean existsThreadWithoutReferenceProcessor = false;
	boolean existsThreadBoundToMoreThanOneProcessor = false;
	boolean existsThreadNotBoundToAnyProcessor = false;

	ArrayList<AADLProcessor> processors = new ArrayList<AADLProcessor>();
	HashMap<AADLProcessor, ArrayList<AADLThread>> proc2Taskset = new HashMap<AADLProcessor, ArrayList<AADLThread>>();
	HashMap<ComponentInstance, AADLProcessor> ci2AadlProcessor = new HashMap<ComponentInstance, AADLProcessor>();
	ArrayList<AADLProcessor> unschedulableProcessors = new ArrayList<AADLProcessor>();

	protected void analyzeInstanceModel(final IProgressMonitor monitor, final AnalysisErrorReporterManager errManager,
			final SystemInstance root, final SystemOperationMode som) {

		existsProcessorWithMIPS = false;
		existsProcessorWithoutMIPS = false;
		existsThreadWithReferenceProcessor = false;
		existsThreadWithoutReferenceProcessor = false;
		existsThreadBoundToMoreThanOneProcessor = false;
		existsThreadNotBoundToAnyProcessor = false;

		processors.clear();
		proc2Taskset.clear();
		ci2AadlProcessor.clear();
		unschedulableProcessors.clear();

		try {
			monitor.beginTask("Binding threads to processors in " + root.getName(), IProgressMonitor.UNKNOWN);
			logInfo("Binpacker Analysis Report\n");

			final ForAllElement addProcessors = new ForAllElement(errManager) {
				public void process(Element obj) {
					ComponentInstance ci = (ComponentInstance) obj;
					// the createInstance method already assigns a default MIPS if none exists
					double mips = GetProperties.getProcessorMIPS(ci);
					// checking consistency;
					existsProcessorWithMIPS |= (mips != 0);
					existsProcessorWithoutMIPS |= (mips == 0);

					if (mips != 0) {
						mips = mips + 0.0;
					}

					final AADLProcessor proc = AADLProcessor.createInstance(ci);
					if (proc != null) {
						ci2AadlProcessor.put(ci, proc);
					}
				}
			};

			addProcessors.processPreOrderComponentInstance(root, ComponentCategory.PROCESSOR);

			final ForAllElement addThreads = new ForAllElement(errManager) {
				public void process(Element obj) {
					final ComponentInstance ci = (ComponentInstance) obj;

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
					List<ComponentInstance> pciList = GetProperties.getActualProcessorBinding(ci);

					if (pciList.size() == 1) {
						AADLProcessor proc = ci2AadlProcessor.get(pciList.get(0));
						if (proc != null) {
							ArrayList<AADLThread> taskset = proc2Taskset.get(proc);
							if (taskset == null) {
								taskset = new ArrayList<AADLThread>();
								proc2Taskset.put(proc, taskset);
							}
							taskset.add(thread);
						}
					}

					existsThreadBoundToMoreThanOneProcessor |= pciList.size() > 1;
					existsThreadNotBoundToAnyProcessor |= pciList.size() == 0;

					double refmips = GetProperties.getReferenceMIPS(ci);

					// validate consistency
					existsThreadWithReferenceProcessor |= (refmips != 0);
					existsThreadWithoutReferenceProcessor |= (refmips == 0);

				}
			};
			addThreads.processPreOrderComponentInstance(root, ComponentCategory.THREAD);

			// check consistency

			// only some processors have mips
			if (existsProcessorWithMIPS && existsProcessorWithoutMIPS) {
				errManager.error(root, "Not all processors have MIPSCapacity");
				return;
			}
			// only some threads with reference processor
			if (existsThreadWithReferenceProcessor && existsThreadWithoutReferenceProcessor) {
				errManager.error(root, "Not all threads have execution time reference processor");
				return;
			}

			// threads and processors mips spec not consistent
			if (existsProcessorWithMIPS && existsThreadWithoutReferenceProcessor) {
				errManager
						.error(root,
								"There are some processors with MIPSCapacity but some threads without execution time reference processors");
				return;
			}

			if (existsProcessorWithoutMIPS && existsThreadWithReferenceProcessor) {
				errManager
						.error(root,
								"There are some threads with execution time reference processors but not all processors have MIPSCapacity");
				return;
			}

			if (existsThreadBoundToMoreThanOneProcessor) {
				errManager
						.error(root,
								"There are threads bound to more than one processor. This analysis does not support global scheduling");
				return;
			}

			if (existsThreadNotBoundToAnyProcessor) {
				errManager.error(root,
						"There are threads not bound to a processor. This analysis relies on manual binding");
				return;
			}

			// schedule

			boolean allFeasible = true;
			for (Map.Entry<AADLProcessor, ArrayList<AADLThread>> entry : proc2Taskset.entrySet()) {
				AADLProcessor proc = entry.getKey();
				ArrayList<AADLThread> taskset = entry.getValue();
				boolean feasible = true;
				for (AADLThread thread : taskset) {
					feasible = feasible && proc.addIfFeasible(thread);
					if (!feasible) {
						unschedulableProcessors.add(proc);
						break;
					}
				}
				allFeasible = allFeasible && feasible;
			}

			if (!allFeasible) {
				for (AADLProcessor proc : unschedulableProcessors) {
					errManager.error((ComponentInstance) proc.getSemanticObject(), "Not schedulable");
				}
			} else {
				errManager.info(root, "Schedulable");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	public String getMarkerType() {
		return "org.osate.analysis.resource.scheduling.ResourceScheduleObjectMarker";
	}

	protected String getActionName() {
		return "Schedule threads already bound to processors";
	}

	// Don't allow analysis in all modes.
	protected boolean analyzeInSingleModeOnly() {
		return true;
	}

	public void invoke(final IProgressMonitor monitor, final AnalysisErrorReporterManager errManager,
			final SystemInstance root, final SystemOperationMode som) {
		analyzeInstanceModel(monitor, errManager, root, som);
	}

}
