/** to invoke the schedulability analysis
 * created by Jun Li, Mar. 22, 1999.
 */

package org.osate.analysis.scheduling;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;



public class TimingAnalysisInvocation {
	
	/**
	 * This method drives scheduling analysis for a particular processor
	 * The RuntimeProcessWalker remembers the name and does analysis
	 * @param processor
	 */
	public static boolean timingSchedulabilityAnalysis(
			final AnalysisErrorReporterManager errMgr, WriteToFile csvlog,
			final ComponentInstance processor) {
		String protocol = GetProperties.getSchedulingProtocol(processor);
		if (protocol == null || protocol.equalsIgnoreCase("EDF")){
			return doUtilization(errMgr, csvlog, processor);
		}

		if (processor.getCategory() != ComponentCategory.PROCESSOR)
			return false;
		RuntimeProcessWalker walker = new RuntimeProcessWalker( errMgr,csvlog);
		walker.cleanProcessHolder() ;
		walker.setCurrentProcessor(processor);
		walker.initWalker();
		walker.componentsSortByPeriod();
		walker.assignPriority();
		boolean result = walker.timingSchedualabilityAnalysis();
		return result;
	}
	
	public static boolean doUtilization(
			final AnalysisErrorReporterManager errMgr, WriteToFile csvlog,
			final ComponentInstance processor){
		EList<Element> boundThreads = new ForAllElement() {
			@Override
			protected boolean suchThat(Element obj) {
				if (!InstanceModelUtil.isPeriodicThread((ComponentInstance)obj)) return false;
				List<ComponentInstance> boundProcessor;
				return InstanceModelUtil.isBoundToProcessor((ComponentInstance)obj, processor);
			}
		}.processPreOrderComponentInstance(processor.getSystemInstance(),
				ComponentCategory.THREAD);
		double cpuMips = GetProperties.getMIPSCapacityInMIPS(processor, 0);
		csvlog.addOutputNewline( "EDF Schedulability Result");
		double utilization = 0;
		if (cpuMips == 0 ){
			if( !boundThreads.isEmpty()){
				errMgr.error(processor, "Processor "+processor.getInstanceObjectPath()+" has threads and is not schedulable because it has no MIPS capacity");
				csvlog.addOutputNewline( "Processor "+processor.getInstanceObjectPath()+" has threads and is not schedulable because it has no MIPS capacity");
				return false;
			} else {
				errMgr.error(processor, "Processor "+processor.getInstanceObjectPath()+" is not used and has no MIPS capacity");
				csvlog.addOutputNewline( "Processor "+processor.getInstanceObjectPath()+" is not used and has no MIPS capacity");
				return false;
			}
		}
		double demandMips = 0;
		if( !boundThreads.isEmpty()){
			errMgr.error(processor, "Processor "+processor.getInstanceObjectPath()+" is schedulable but has no bound threads");
			csvlog.addOutputNewline( "Processor "+processor.getInstanceObjectPath()+" is schedulable but has no bound threads");
		return false;
		} else {
			for (Element element : boundThreads) {
				demandMips =demandMips+ GetProperties.getThreadExecutioninMIPS((ComponentInstance) element);
				utilization = (demandMips / cpuMips)*100;
				if (utilization > 100){
					errMgr.error(processor, "Processor "+processor.getInstanceObjectPath()+" is not schedulable with utilization "+utilization+"%");
					csvlog.addOutputNewline( "Processor "+processor.getInstanceObjectPath()+" is not schedulable with utilization "+utilization+"%");
					return false;
				} else {
					errMgr.info(processor, "Processor "+processor.getInstanceObjectPath()+" is schedulable with utilization "+utilization+"%");
					csvlog.addOutputNewline("Processor "+processor.getInstanceObjectPath()+" is schedulable with utilization "+utilization+"%");
					return true;
				}
			}
			return false;
		}
	}
	
	
}