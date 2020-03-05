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
	protected boolean canAnalyzeDeclarativeModels() {
		return false;
	}

	@Override
	protected void analyzeDeclarativeModel(final IProgressMonitor monitor,
			final AnalysisErrorReporterManager errManager, final Element declarativeObject) {
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
		if (processor.getCategory() != ComponentCategory.PROCESSOR) {
			return false;
		}
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
				if (!InstanceModelUtil.isPeriodicThread((ComponentInstance) obj)) {
					return false;
				}
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