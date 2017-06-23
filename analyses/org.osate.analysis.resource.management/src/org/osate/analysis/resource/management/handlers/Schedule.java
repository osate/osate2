/*
 *
 * <copyright>
 * Copyright � 2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE �DELIVERABLES�) ARE ON AN �AS-IS� BASIS.
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
 * attorney�s fees) arising out of, or relating to Licensee�s and/or its sub licensees� negligent use or willful
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
 * %W%
 * @version %I% %H%
 */
package org.osate.analysis.resource.management.handlers;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.analysis.scheduling.RuntimeProcessWalker;
import org.osate.ui.UiUtil;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.handlers.AbstractInstanceOrDeclarativeModelModifyHandler;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

public final class Schedule extends AbstractInstanceOrDeclarativeModelModifyHandler {
	@Override
	protected String getActionName() {
		return "Test scheduability";
	}

	@Override
	public String getMarkerType() {
		return "org.osate.analysis.resource.management.ScheduleObjectMarker";
	}

	@Override
	protected boolean initializeAction(NamedElement obj) {
		setCSVLog("SchedulingAnalysis", obj);
		return true;
	}

	@Override
	protected void analyzeDeclarativeModel(final IProgressMonitor monitor,
			final AnalysisErrorReporterManager errManager, final Element declarativeObject) {
		Dialog.showError("Schedule Error", "Can only schedule system instances");
	}

	@Override
	protected void analyzeInstanceModel(final IProgressMonitor monitor, final AnalysisErrorReporterManager errManager,
			final SystemInstance root, final SystemOperationMode som) {
		monitor.beginTask(getActionName(), IProgressMonitor.UNKNOWN);
		logInfo("Processor Utilization/Scheduling Results");
		try {
			ForAllElement processProcessor = new ForAllElement(errManager) {
				@Override
				public void process(Element obj) {
					ComponentInstance processor = (ComponentInstance) obj;
					String protocol = GetProperties.getSchedulingProtocol(processor);
					if (protocol == null || protocol.equalsIgnoreCase("EDF")) {
						doUtilization(processor);
					} else {
						timingSchedulabilityAnalysis(processor);
					}
				}
			};
			processProcessor.processPreOrderComponentInstance(root, ComponentCategory.PROCESSOR);
		} catch (InvalidModelException e) {
			error(e.getElement(), e.getMessage());
		}
		// now report thread bindings
		logInfo("\nThread binding report");
		ForAllElement processThread = new ForAllElement(errManager) {
			@Override
			public void process(Element obj) {
				reportProcessorBinding((ComponentInstance) obj);
				return;
			}
		};
		processThread.processPreOrderComponentInstance(root, ComponentCategory.THREAD);
		monitor.done();
	}

	/**
	 * This method drives scheduling analysis for a particular processor
	 * The RuntimeProcessWalker remembers the name and does analysis
	 * @param processor
	 */
	public boolean timingSchedulabilityAnalysis(final ComponentInstance processor) {
		if (processor.getCategory() != ComponentCategory.PROCESSOR)
			return false;
		RuntimeProcessWalker walker = new RuntimeProcessWalker(this);
		walker.cleanProcessHolder();
		walker.setCurrentProcessor(processor);
		walker.initWalker();
		walker.componentsSortByPeriod();
		walker.assignPriority();
		boolean result = walker.timingSchedualabilityAnalysis();
		return result;
	}

	public boolean doUtilization(final ComponentInstance processor) {
		EList<Element> boundThreads = new ForAllElement() {
			@Override
			protected boolean suchThat(Element obj) {
				if (!InstanceModelUtil.isPeriodicThread((ComponentInstance) obj))
					return false;
				return InstanceModelUtil.isBoundToProcessor((ComponentInstance) obj, processor);
			}
		}.processPreOrderComponentInstance(processor.getSystemInstance(), ComponentCategory.THREAD);
		double cpuMips = GetProperties.getMIPSCapacityInMIPS(processor, 0);
		double utilization = 0.0;
		if (cpuMips == 0) {
			if (!boundThreads.isEmpty()) {
				error(processor, "Processor " + processor.getInstanceObjectPath()
						+ " has threads and is not schedulable because it has no MIPS capacity");
				return false;
			} else {
				warning(processor,
						"Processor " + processor.getInstanceObjectPath() + " is not used and has no MIPS capacity");
				return false;
			}
		}
		double demandMips = 0;
		if (boundThreads.isEmpty()) {
			warning(processor,
					"Processor " + processor.getInstanceObjectPath() + " has capacity, but has no bound threads");
			return false;
		} else {
			for (Element element : boundThreads) {
				demandMips = demandMips + GetProperties.getThreadExecutioninMIPS((ComponentInstance) element);
			}
			utilization = (demandMips / cpuMips) * 100;
			if (utilization > 100) {
				error(processor, "Processor " + processor.getInstanceObjectPath()
						+ " is not schedulable with utilization " + UiUtil.OneDecPoint(utilization) + "%");
				return false;
			} else {
				info(processor, "Processor " + processor.getInstanceObjectPath() + " is schedulable with utilization "
						+ UiUtil.OneDecPoint(utilization) + "%");
				return true;
			}
		}
	}

	public void reportProcessorBinding(ComponentInstance elt) {
		double threadMips = GetProperties.getThreadExecutioninMIPS(elt);
		reportProcessorBinding(elt, threadMips, "");
	}

	public void reportProcessorBinding(ComponentInstance elt, double threadMips, String prefix) {
		List<ComponentInstance> bindinglist;
		// report binding of threads to VP and processor
		String threadText = prefix + elt.getCategory().getName() + " " + elt.getComponentInstancePath()
				+ (InstanceModelUtil.isThread(elt) ? "(" + UiUtil.BestDecPoint(threadMips) + " MIPS)" : "") + " ==> ";
		bindinglist = GetProperties.getActualProcessorBinding(elt);
		if (bindinglist.isEmpty()) {
			logInfo(threadText + " NOTHING");

		} else {
			for (ComponentInstance componentInstance : bindinglist) {
				if (componentInstance.getCategory().equals(ComponentCategory.VIRTUAL_PROCESSOR)) {
					reportProcessorBinding(componentInstance, threadMips, threadText);
				} else {
					// we have a processor
					double cpumips = GetProperties.getMIPSCapacityInMIPS(componentInstance, 0);
					logInfo(threadText + componentInstance.getCategory().getName() + " "
							+ componentInstance.getComponentInstancePath() + "(" + UiUtil.BestDecPoint(cpumips)
							+ "MIPS)"
							+ (cpumips > 0 ? (" Utilization " + UiUtil.OneDecPoint(threadMips / cpumips * 100) + "%")
									: " No CPU capacity"));
				}
			}
		}
	}

	public void invoke(IProgressMonitor monitor, SystemInstance root) {
		actionBody(monitor, root);
	}
}