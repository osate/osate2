/** to invoke the schedulability analysis
 * created by Jun Li, Mar. 22, 1999.
 */

package edu.cmu.sei.aadl.scheduling;

import edu.cmu.sei.aadl.aadl2.ComponentCategory;
import edu.cmu.sei.aadl.aadl2.instance.ComponentInstance;
import edu.cmu.sei.aadl.modelsupport.errorreporting.AnalysisErrorReporterManager;
import edu.cmu.sei.aadl.resourcemanagement.actions.ScheduleProperties;


public class TimingAnalysisInvocation {
	public static boolean conducted = false;
	
	/**
	 * This method drives scheduling analysis for a particular processor
	 * The RuntimeProcessWalker remembers the name and does analysis
	 * @param processor
	 */
	public static boolean timingSchedulabilityAnalysis(
			final ScheduleProperties properties,
			final AnalysisErrorReporterManager errMgr, 
			final ComponentInstance processor) {
		if (processor.getCategory() != ComponentCategory.PROCESSOR)
			return false;
		RuntimeProcessWalker walker = new RuntimeProcessWalker(properties, errMgr);
		walker.cleanProcessHolder() ;
		walker.setCurrentProcessor(processor);
		walker.initWalker();
		walker.componentsSortByPeriod();
		walker.assignPriority();
		boolean result = walker.timingSchedualabilityAnalysis();
		return result;
	}
}