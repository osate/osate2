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
package org.osate.analysis.scheduling.inversion;

import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

/**
 * @author phf
 *
 */
public class PriorityInversion {
	private AnalysisErrorReporterManager errManager;

	public PriorityInversion(AnalysisErrorReporterManager errMgr) {
		errManager = errMgr;
	}

	public void checkSystemPriorityInversion(SystemInstance si) {
		ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(Element obj) {
				checkPriorityInversion((ComponentInstance) obj);
			}
		};
		mal.processPreOrderComponentInstance(si, ComponentCategory.PROCESSOR);
	}

	/**
	 * check for priority inversion of threads bound to the given processor
	 * @param curProcessor Component Instance of processor
	 */
	public void checkPriorityInversion(ComponentInstance curProcessor) {
		SystemInstance root = curProcessor.getSystemInstance();
		final ComponentInstance currentProcessor = curProcessor;
		EList<Element> boundThreads = new ForAllElement() {
			@Override
			protected boolean suchThat(Element obj) {
				if (!InstanceModelUtil.isPeriodicThread((ComponentInstance) obj)) {
					return false;
				}
				List<ComponentInstance> boundProcessor;
				try {
					boundProcessor = GetProperties.getActualProcessorBinding((ComponentInstance) obj);
				} catch (PropertyNotPresentException e) {
					return false;
				}
				return boundProcessor.contains(currentProcessor);
			}
		}.processPreOrderComponentInstance(root, ComponentCategory.THREAD);
		// we will sort the thread list by period and
		// check to make sure the assigned priority is monotonically decreasing
		ECollections.sort(boundThreads, (obj1, obj2) -> {
			final double a = GetProperties.getPeriodinMS((ComponentInstance) obj1);
			final double b = GetProperties.getPeriodinMS((ComponentInstance) obj2);
			if (a > b) {
				return 1;
			}
			if (a == b) {
				return 0;
			}
			return -1;
		});
		checkDecreasingPriority(boundThreads);
	}

	/**
	 * Check if explicitly assigned priorities in a thread list (sorted in increasing period order)
	 * violate rate monotic priorities
	 *
	 * Checking is done by rate group. Inside a group all threads must have priority lower than the
	 * lowest priority in any previous rate group.
	 *
	 * Threads without priority assignment are reported as a warning
	 *
	 * @since 2.0
	 */
	public void checkDecreasingPriority(List<Element> threadList) {
		// thread list is ordered in increasing period order
		// => priorities should decrease
		if (threadList.isEmpty()) {
			return;
		}
		/** The period of the current rate group */
		double groupPeriod = -1.0;
		/** The lowest priority (so far) in the current rate group */
		long groupLowestPriority = Long.MAX_VALUE;
		/** The lowest priority encountered before the current rate group */
		long lowestPriority = Long.MAX_VALUE;

		for (Element e : threadList) {
			ComponentInstance thread = (ComponentInstance) e;
			double period = GetProperties.getPeriodinMS(thread);
			long priority = GetProperties.getPriority(thread, Long.MIN_VALUE);

			if (priority == Long.MIN_VALUE) {
				errManager.warning(thread, "Thread '" + thread.getName() + "' has no priority assigned");
			} else {
				if (period == groupPeriod) {
					// just record the lowest priority in the current rate group
					if (priority < groupLowestPriority) {
						groupLowestPriority = priority;
					}
				} else {
					// switch to next group
					groupPeriod = period;
					if (groupLowestPriority < lowestPriority) {
						lowestPriority = groupLowestPriority;
					}
					groupLowestPriority = priority;
				}

				if (priority >= lowestPriority) {
					// priority inversion
					errManager.error(thread, "Thread '" + thread.getName() + "' with priority " + priority
							+ " causes priority inversion");
				}
			}
		}
	}

}
