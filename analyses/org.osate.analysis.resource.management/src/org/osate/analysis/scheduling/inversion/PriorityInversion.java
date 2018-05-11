/*
 * Created on Oct 3, 2004
 *
 */
package org.osate.analysis.scheduling.inversion;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.QuickSort;
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

	// Only meant to be used with a list of Threads.
	private QuickSort periodSort = new QuickSort() {
		protected int compare(Object obj1, Object obj2) {
			final double a = GetProperties.getPeriodinMS((ComponentInstance) obj1);
			final double b = GetProperties.getPeriodinMS((ComponentInstance) obj2);
			if (a > b)
				return 1;
			if (a == b)
				return 0;
			return -1;
		}
	};

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
	 * check for priority inversion of trhead bound to the given processor
	 * @param curProcessor Component Instance of processor
	 */
	public void checkPriorityInversion(ComponentInstance curProcessor) {
		SystemInstance root = curProcessor.getSystemInstance();
		final ComponentInstance currentProcessor = curProcessor;
		EList boundThreads = new ForAllElement() {
			@Override
			protected boolean suchThat(Element obj) {
				if (!InstanceModelUtil.isPeriodicThread((ComponentInstance) obj))
					return false;
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
		periodSort.quickSort(boundThreads);
		checkIncreasingMonotonicity(boundThreads);
	}

	public void checkIncreasingMonotonicity(EList threadList) {
		if (threadList.isEmpty())
			return;
		Iterator it = threadList.iterator();
		ComponentInstance curThread = (ComponentInstance) it.next();
		double currentPeriod = GetProperties.getPeriodinMS(curThread);
		long periodMaxPriority = GetProperties.getPriority(curThread, 0);
		double prevRateGroupMaxPriority = periodMaxPriority;
		while (it.hasNext()) {
			ComponentInstance nextThread = (ComponentInstance) it.next();
			double nextPeriod = GetProperties.getPeriodinMS(nextThread);
			long nextPriority = GetProperties.getPriority(nextThread, -1);
			if (nextPeriod == currentPeriod) {
				// update max priority within period
				if (nextPriority != -1 && nextPriority > periodMaxPriority) {
					periodMaxPriority = nextPriority;
				}
			} else {
				// we have reached the next rate group
				prevRateGroupMaxPriority = periodMaxPriority;
				periodMaxPriority = nextPriority;
				if (nextPriority != -1) {
					if (nextPriority < prevRateGroupMaxPriority) {
						// priority inversion
						errManager.error(nextThread, "Thread '" + nextThread.getName() + "' with priority "
								+ nextPriority + " causes priority inversion");
					}
				}
			}
			nextPeriod = currentPeriod;
		}
	}
}
