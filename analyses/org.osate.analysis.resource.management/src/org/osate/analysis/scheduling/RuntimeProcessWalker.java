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

package org.osate.analysis.scheduling;

import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.QuickSort;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.analysis.resource.management.handlers.Schedule;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

public class RuntimeProcessWalker {
	// to record the invariants visisted and put back to the system tree.
	private static EList runTimeComponents = new BasicEList();
	private static int ARCID = 0;

	// since the current timing schedulability analysis is based on per-processor.
	// I need to construct the runtimeComponents based on the identical processor
	// binding.
	private static ComponentInstance currentProcessor;

	final Schedule scheduleAction;

	private QuickSort quick = new QuickSort() {
		protected int compare(Object obj1, Object obj2) {
			int a = ((RuntimeProcess) obj1).getPeriod();
			int b = ((RuntimeProcess) obj2).getPeriod();
			if (a > b)
				return 1;
			if (a == b)
				return 0;
			return -1;
		}
	};

	/**
	 * Schedule Action is the action extended from AbstractAaxlAction.
	 * It makes the reporting methods available.
	 * @param scheduleAction
	 */
	public RuntimeProcessWalker(final Schedule scheduleAction) {
		this.scheduleAction = scheduleAction;
	}

	public void setCurrentProcessor(ComponentInstance processor) {
		currentProcessor = processor;
	}

	public ComponentInstance getCurrentProcessor() {
		return currentProcessor;
	}

	// since the run time component holder is a static vector, you have to clear it regularly
	// for every new processor analysis.
	public void cleanProcessHolder() {
		runTimeComponents.clear();
	}

	public EList getRunTimeComponents() {
		return runTimeComponents;
	};

	public void initWalker() {
		Element root = currentProcessor.getSystemInstance();
		TreeIterator ciit = EcoreUtil.getAllContents(Collections.singleton(root));
		while (ciit.hasNext()) {
			Object o = ciit.next();
			if (o instanceof ComponentInstance && ((ComponentInstance) o).getCategory() == ComponentCategory.THREAD) {
				addThread((ComponentInstance) o);
			}
		}
	}

	/**
	 * add thread if it is bound to the processor set in processorName
	 * @param elt
	 */
	public void addThread(ComponentInstance elt) {
		double exectimeval;
		try {
			exectimeval = GetProperties.getThreadExecutioninMilliSec(elt);
		} catch (PropertyNotPresentException e) {
			scheduleAction.error(elt, elt.getComponentInstancePath() + ": Execution time is not set");
			return;
		}
		if (!InstanceModelUtil.isBoundToProcessor(elt, currentProcessor)) {
			return;
		}

		double val;
		try {
			val = GetProperties.getPeriodinMS(elt);
		} catch (PropertyNotPresentException e) {
			scheduleAction.error(elt, elt.getComponentInstancePath() + ": Period is not set");
			return;
		}

		double deadlineval = GetProperties.getDeadlineinMilliSec(elt);
		RuntimeProcess curComponent = new RuntimeProcess();
		curComponent.setProcessorName(currentProcessor.getInstanceObjectPath());
		// convert time into MicroSeconds so it does not get rounded down
		curComponent.setPeriod((int) (val * 1000));
		curComponent.setDeadline((int) (deadlineval * 1000));
		curComponent.setExecutionTime((int) (exectimeval * 1000));

		curComponent.setPhaseOffset(0);

		/* There is no standard Priority property */
		long priority = GetProperties.getPriority(elt, 0);
		curComponent.setPriority((int) priority);

		curComponent.setComponentName(elt.getInstanceObjectPath());

		// up to this point, all timing properties are all set!
		curComponent.setAssociatedComponent(elt);
		runTimeComponents.add(curComponent);

		return;
	}

	public void componentsSortByPeriod() {
		if (runTimeComponents.size() == 0)
			return;
		quick.quickSort(runTimeComponents);
	}

	public void assignPriority() {
		if (runTimeComponents.size() == 0)
			return;
		int prior = runTimeComponents.size();
		for (Iterator it = runTimeComponents.iterator(); it.hasNext();) {
			RuntimeProcess curComponent = (RuntimeProcess) it.next();
			if (curComponent.getPriority() == 0) {
				curComponent.setPriority(prior--);
			}
		}
	}

	private int getARCID(RuntimeProcess comp) {
		int result = -1;
		for (int i = 0; i < runTimeComponents.size(); i++) {
			RuntimeProcess curComponent = (RuntimeProcess) runTimeComponents.get(i);
			if (curComponent.getARCName() != null && comp.getARCName() != null) {
				if (curComponent.getARCName().equals(comp.getARCName())) {
					if (curComponent.getARCID() >= 0) {
						result = curComponent.getARCID();
						break;
					}
				}
			}
		}
		return result;

	}

	/**generate the analysis result. and at the same time, report the analysis result
	 * into a file.
	 */
	public boolean timingSchedualabilityAnalysis() {
		// no process bounded to this process, so it is true. Of course.
		if (runTimeComponents.size() == 0)
			return true;

		// numbering the ARC ID for all the schedulable component in the system.
		for (int i = 0; i < runTimeComponents.size(); i++) {
			RuntimeProcess curComponent = (RuntimeProcess) runTimeComponents.get(i);
			// construct ARCID.
			if (curComponent.getARCName() == null) {
				// no ARC name associated, it is a normal component.
				curComponent.setARCID(ARCID++);
			} else {
				// it is associated with ARC component
				int id = getARCID(curComponent);
				if (id >= 0)
					curComponent.setARCID(id);
				else
					curComponent.setARCID(ARCID++);
			}
		}

		// the timing analysis is resided in SimplexTiming class
		SimplexTiming analysis = new SimplexTiming();
		// only the tractable analysis is useful in terms of computation complexity.
		analysis.setExactOrTractable(true);

		for (int i = 0; i < runTimeComponents.size(); i++) {
			RuntimeProcess curComponent = (RuntimeProcess) runTimeComponents.get(i);
			analysis.addProcessToList(curComponent, curComponent.getARCID());
		}

		boolean result = analysis.schedulabilityAnalysis();

		double totaltime = 0;
		for (int i = 0; i < runTimeComponents.size(); i++) {
			RuntimeProcess curComponent = (RuntimeProcess) runTimeComponents.get(i);
			totaltime += curComponent.getExecutionTime() * 1000 / curComponent.getPeriod();
		}

		scheduleAction.logInfo("Schedulability Results");
		if (result) {
			scheduleAction.info(getCurrentProcessor(), "Processor " + getCurrentProcessor().getInstanceObjectPath()
					+ " is schedulable with utilization " + totaltime / 10 + "%");
		} else {
			scheduleAction.error(getCurrentProcessor(), "Processor " + getCurrentProcessor().getInstanceObjectPath()
					+ " is not schedulable with utilization " + totaltime / 10 + "%");
		}
		scheduleAction.logInfo(
				"thread name, period, deadline, execution time, phase offset, priority, max response time, schedulability ");

		for (int i = 0; i < runTimeComponents.size(); i++) {
			RuntimeProcess curComponent = (RuntimeProcess) runTimeComponents.get(i);
			scheduleAction.logInfo(curComponent.getComponentName() + ", " + curComponent.getPeriod() + ", "
					+ curComponent.getDeadline() + ", " + curComponent.getExecutionTime() + ", "
					+ curComponent.getPhaseOffset() + ", " + curComponent.getPriority() + ", "
					+ curComponent.getMaxResponseTime() + ", " + curComponent.getSchedulability());
		}
		scheduleAction.logInfo("");
		scheduleAction.logInfo("");

		// clean the ARC vector holder.
		analysis.cleanARCList();

		return result;

	}

}