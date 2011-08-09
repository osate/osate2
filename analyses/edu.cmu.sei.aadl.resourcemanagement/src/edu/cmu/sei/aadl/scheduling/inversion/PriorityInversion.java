/*
 * Created on Oct 3, 2004
 *
 */
package edu.cmu.sei.aadl.scheduling.inversion;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;

import edu.cmu.sei.aadl.aadl2.ComponentCategory;
import edu.cmu.sei.aadl.aadl2.Element;
import edu.cmu.sei.aadl.aadl2.EnumerationLiteral;
import edu.cmu.sei.aadl.aadl2.NamedElement;
import edu.cmu.sei.aadl.aadl2.ThreadSubcomponent;
import edu.cmu.sei.aadl.aadl2.instance.ComponentInstance;
import edu.cmu.sei.aadl.aadl2.instance.SystemInstance;
import edu.cmu.sei.aadl.aadl2.properties.PropertyNotPresentException;
import edu.cmu.sei.aadl.modelsupport.QuickSort;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager;
import edu.cmu.sei.aadl.modelsupport.modeltraversal.ForAllElement;
import edu.cmu.sei.osate.workspace.names.standard.AadlProject;

/**
 * @author phf
 *
 */
public class PriorityInversion {
	private AnalysisErrorReporterManager errManager;
	private final PriorityInversionProperties properties;
	
	//Only meant to be used with a list of Threads.
	private QuickSort periodSort = new QuickSort() {
		protected int compare(Object obj1, Object obj2) {
			final double a = properties.getPeriod((ComponentInstance)obj1, 0.0);
			final double b = properties.getPeriod((ComponentInstance)obj2, 0.0);
			if (a > b)
				return 1;
			if (a == b)
				return 0;
			return -1;
		}
	};

	public PriorityInversion(final PriorityInversionProperties properties, AnalysisErrorReporterManager errMgr) {
		this.properties = properties;
		errManager = errMgr;
	}

	public void checkSystemPriorityInversion(SystemInstance si) {
		ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(Element obj) {
				checkPriorityInversion((ComponentInstance) obj);
			}
		};
		mal.processPreOrderComponentInstance(si,
				ComponentCategory.PROCESSOR);
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
				if (!isPeriodicThread(obj)) return false;
				ComponentInstance boundProcessor;
				try
				{
					boundProcessor = properties.getActualProcessorBinding((ComponentInstance)obj);
				}
				catch (PropertyNotPresentException e)
				{
					return false;
				}
				return boundProcessor == currentProcessor;
			}
		}.processPreOrderComponentInstance(root,
				ComponentCategory.THREAD);
		// we will sort the thread list by period and
		// check to make sure the assigned priority is monotonically decreasing
		periodSort.quickSort(boundThreads);
		checkIncreasingMonotonicity(boundThreads);
	}

	
	private boolean isThread(Element thread){
		return (thread instanceof ThreadSubcomponent) || (thread instanceof ComponentInstance && ((ComponentInstance)thread).getCategory() == ComponentCategory.THREAD);
	}
	
	private boolean isPeriodicThread(Element thread){
		if (!isThread(thread)) return false;
		
		final EnumerationLiteral dp = properties.getDispatchProtocol((NamedElement) thread);
		if (dp != null) {
			return dp.getName().equalsIgnoreCase(AadlProject.PERIODIC_LITERAL);
		} else { 
			return false;
		}
	}

	public void checkIncreasingMonotonicity(EList threadList) {
		if (threadList.isEmpty())
			return;
		Iterator it = threadList.iterator();
		ComponentInstance curThread = (ComponentInstance) it.next();
		double currentPeriod = properties.getPeriod(curThread, 0.0);
		long periodMaxPriority = properties.getPriority(curThread, 0);
		double prevRateGroupMaxPriority = periodMaxPriority;
		while (it.hasNext()) {
			ComponentInstance nextThread = (ComponentInstance) it.next();
			double nextPeriod = properties.getPeriod(nextThread, 0.0);
			long nextPriority = properties.getPriority(nextThread, -1);
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
						errManager.error(nextThread,
								"Thread '" + nextThread.getName() +
								"' with priority " +nextPriority +
								" causes priority inversion");
					}
				}
			}
			nextPeriod = currentPeriod;
		}
	}
}
