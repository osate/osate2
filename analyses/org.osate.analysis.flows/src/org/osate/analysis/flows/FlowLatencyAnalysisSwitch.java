/*
 * Created on July 7, 2004
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
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
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
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
 * @version $Id: FlowLatencyAnalysisSwitch.java,v 1.71.2.13 2011-07-01 16:39:24 relief Exp $
 */
package org.osate.analysis.flows;


import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

/**
 * @author phf
 *
 * This class provides for flow analysis
 *
 */
public class FlowLatencyAnalysisSwitch extends AadlProcessingSwitchWithProgress {
	
	private WriteToFile csvlog ;
	
	private boolean isSynchronous = true;
	
	public void setIsSynchronous(){
		isSynchronous = true;
	}
	
	public void setIsAsynchronous(){
		isSynchronous = false;
	}
	
	protected boolean isSynchronous(){
		return isSynchronous;
	}
	
    /**
     * the analysis method that is invoked on each visited model element
     */
    public FlowLatencyAnalysisSwitch( final IProgressMonitor monitor,
    		final AnalysisErrorReporterManager errMgr, WriteToFile log) {
    	super(monitor, PROCESS_BOTTOM_UP_COMPONENT_IMPL, errMgr);
    	csvlog = log;
    }
    
    protected final void initSwitches() {
		/* here we are creating the connection checking switches */


		instanceSwitch = new InstanceSwitch<String>() {
			/**
			 * check flow latency
			 */
			public String caseComponentInstance(final ComponentInstance ci)  {
				monitor.subTask("Checking flows in " + ci.getName());
				processEList(ci.getEndToEndFlows());
				monitor.worked(1);
				return DONE;
			}

			public String caseEndToEndFlowInstance(final EndToEndFlowInstance etef)  {
				if (etef.getFlowElements().isEmpty()) return DONE;
				logInfoOnly(etef, "End to End Latency report\n");
				final double totalLatency = doETEF(etef); 
				double val = 0;
					val = GetProperties.getLatencyinMicroSec(etef);
				if (val > 0)
				{
					if (totalLatency > val) {
						logError(etef, "End-to-end flow "+etef.getName()+" calculated latency "+isSynchronousLabel()
								+ convertUStoOutputUnit(totalLatency)
								+ " exceeds expected latency "
								+ convertUStoOutputUnit(val) );
					} else
					if (totalLatency < val) {
						logInfo(etef, "End-to-end flow "+etef.getName()+" calculated latency "+isSynchronousLabel()
								+ convertUStoOutputUnit(totalLatency)
								+ " is less than expected latency "
								+ convertUStoOutputUnit(val));
					} else {
						logInfo(etef,"End-to-end flow "+etef.getName()+" calculated latency "+isSynchronousLabel()
								+ convertUStoOutputUnit(totalLatency) + " matches expected latency");
					}
				} else {
					logInfo(etef,"Calculated latency"+isSynchronousLabel()+" for end-to-end flow "+etef.getName()+" is "
							+ convertUStoOutputUnit(totalLatency) );
				}
				if (monitor.isCanceled()) {
					cancelTraversal();
				}
				logInfoOnly("\n\n");
				return DONE;
			}
		};
	}

	/**
	 * convert us to ms if desired
	 * @param usval value in micro sec
	 * @return value in milli sec
	 */
	private static String convertUStoOutputUnit(final double usval){
		if (usval < 1000){
			return usval+" us";
		}
		return (usval/1000)+" ms";
	}
	
	private String isSynchronousLabel(){
		if (isSynchronous) return " (Synchronous)   ";
		return " (ASynchronous) ";
	}

	protected  double doETEF(final EndToEndFlowInstance etef){
		return doETEF(etef, 0.0);
	}

		protected  double doETEF(final EndToEndFlowInstance etef, double incomingAdditiveLatency){
		final EList<FlowElementInstance> fel = etef.getFlowElements();
		if (fel.isEmpty()) return 0;
		
		// do all computation in microseconds
		// convert to MilliSec for reporting.
		
		ComponentInstance ci = null;
		ConnectionInstance conn = null;
		
		/* Values to track across flow elements */
		// Remember the identity of the previous partition (the last sampling partition)
		ComponentInstance previousPartition = null;
		// The actual latency along the flow so far
		double totalLatency = 0; 
		// The amount of latency in a processing chain since the last sampling point
		double additiveLatency = incomingAdditiveLatency; 
		// remember period of immediate predecessor that samples (periodic)
		// used to determine whether we have harmonic threads talking to each other.
		double previousSamplingPeriod = 0;
		// Iterate over the flow elements.
		final Iterator<FlowElementInstance> it = fel.iterator();
		FlowElementInstance fe; // Either a FlowElement or a FlowElementInstance
		
		double myLatencyETE =  GetProperties.getLatencyinMicroSec(etef);
		if (myLatencyETE == 0){
			logWarning(etef, "End to end flow has no latency requirement specified.");
		}

		fe = it.next();
		ci = fe.getContainingComponentInstance();
		// init the previous partition
		previousPartition = enclosingPartition(ci);
		double flowSpecificationLatency = 0;
		double deadline = 0.0;
		if (fe instanceof FlowSpecificationInstance){
			// Get the latency from the flow specification
			FlowSpecificationInstance fefs = (FlowSpecificationInstance)fe;
			flowSpecificationLatency = GetProperties.getLatencyinMicroSec(fefs);
			if (flowSpecificationLatency == 0){
				logWarning(fefs, "Flow specification has no latency requirement specified.");
			}
			// Use deadline as latency if available, unless the specified latency is greater

			additiveLatency = additiveLatency+adjustforDeadlineLatency(ci, flowSpecificationLatency);
		} else if (fe instanceof ComponentInstance){
			// we have a component instance
			ComponentInstance feci = (ComponentInstance)fe;
			logWarning(etef, feci.getCategory().getName()+" "+feci.getComponentInstancePath()+" has no flow specifcation.");
			double lat = adjustforDeadlineLatency(feci, 0.0);
			additiveLatency = additiveLatency+lat;
		} else if (fe instanceof EndToEndFlowInstance){
			EndToEndFlowInstance etefi = (EndToEndFlowInstance)fe;
			double etefLatency = doETEF(etefi,additiveLatency);
			if (etefLatency == additiveLatency){
				logWarning(etefi, "End to end subflow has zero latency.");
			} else {
				additiveLatency = etefLatency;

			}
		}
		if (InstanceModelUtil.isPeriodicThread(ci) || InstanceModelUtil.isPeriodicDevice(ci)){
			// TODO a device may sample external state (e.g., temperature) which results in no sampling delay
			// or it may observe an external event or state change by sampling the environment (e.g., switch up/down) which results in sampling delay
			previousSamplingPeriod = GetProperties.getPeriodinMicroSec(ci);
		}
		// the partition period here is ignored
		logLatencyinMicroSec(etef.getComponentInstancePath(),ci.getCategory().getName(),ci.getComponentInstancePath(),totalLatency+additiveLatency,additiveLatency,flowSpecificationLatency,previousSamplingPeriod,0.0,deadline,myLatencyETE) ;

		// remembers the deadline/conn latency added in. To be removed if immediate connection.
		double previouslyAddedDelay = 0;

		// Loop over the rest of the flow elements
		while (it.hasNext()){
			fe = it.next();
			if (fe instanceof ConnectionInstance) {
				/* For a connection, accumulate its latency in the
				 * additiveLatency since the last sampling point.  
				 */
				conn = (ConnectionInstance)fe;
				if (conn != null) {
					double conlat = getConnectionLatencyinMicroSec(conn);
					additiveLatency = additiveLatency + conlat;
					previouslyAddedDelay = previouslyAddedDelay + conlat;
					logLatencyinMicroSec(etef.getComponentInstancePath(),"Connection",conn.getName(),totalLatency+additiveLatency,additiveLatency,0.0,0.0,0.0,conlat,myLatencyETE);
				}
			} else if (fe instanceof EndToEndFlowInstance){
				additiveLatency =  doETEF((EndToEndFlowInstance)fe, additiveLatency );
			} else if (fe instanceof FlowSpecificationInstance||fe instanceof ComponentInstance){
				// we are dealing with a component or flow spec
				boolean previousPeriodic = ci==null?false:
					InstanceModelUtil.isPeriodicComponent(ci);
				// get component of current flow spec instance
				if (fe instanceof ComponentInstance){
					ci = (ComponentInstance)fe;
				} else {
					ci = ((FlowSpecificationInstance)fe).getContainingComponentInstance();
				}
				double samplingLatency = 0; // The amount of latency due to the most recent sampling point (partition or periodic thread)
				double periodLatency = 0; // period of periodic thread or device
				double queuingDelay = 0;  // delay due to port queue
				double processingDelay = 0; // processing delay - either from flow spec or from deadline delay
				double deadlineDelay = 0; // thread/device processing delay - WC is deadline
				double partitionLatency = 0; // latency due to partition sampling
				boolean crossPartition = false;
				if ((InstanceModelUtil.isSystem(ci) || InstanceModelUtil.isProcess(ci)) && GetProperties.getIsPartition(ci)) {
					// system or process is tagged as partition
					// must be a new partition
					samplingLatency = GetProperties.getPartitionLatencyInMicroSec(ci, 0.0);
					partitionLatency = samplingLatency;
					logInfoOnly(etef, "Crossing "+(previousPartition!=null?" from "+previousPartition.getComponentInstancePath():"")+ " to partition "+ ci.getComponentInstancePath()+" with latency "+convertUStoOutputUnit(partitionLatency));
					previousPartition = ci;
					crossPartition = true;
				} else {
					/* The current component is not a partition, but we check
					 * to see if we crossed a partition boundary.  If so,
					 * that introduces a sampling point with the new partition's
					 * latency.
					 * We check whether source and target are in the same partition or not
					 */
					ComponentInstance partition = enclosingPartition(ci);
					if (partition != null && partition != previousPartition){
						crossPartition = true;
						samplingLatency = GetProperties.getPartitionLatencyInMicroSec(partition,0.0);
						if (samplingLatency == 0){
							samplingLatency = GetProperties.getPeriodinMicroSec(partition);
						}
						partitionLatency = samplingLatency;
						logInfoOnly(etef, "Crossing "+(previousPartition!=null?" from "+previousPartition.getComponentInstancePath():"")+ " to partition "+ partition.getComponentInstancePath()+" with latency "+convertUStoOutputUnit(partitionLatency));
					}
					previousPartition = partition;
				}
				// accounted for partitions

				if (InstanceModelUtil.isThread(ci) || InstanceModelUtil.isDevice(ci)) {
					// take into account queuing delay
					if (InstanceModelUtil.isEventConnection(conn)||InstanceModelUtil.isEventDataConnection(conn)){
						// take into account queuing delay on event and event data ports. for port groups assume worst case
						queuingDelay = getQueueDelayinMicroSec(conn.getDestination(),ci,InstanceModelUtil.isPeriodicComponent(ci));

					}
					/* If the current component is a thread, we need to 
					 * get its deadline to account for it's computational
					 * time.
					 */
					deadlineDelay = GetProperties.getDeadlineinMicroSec(ci);

					/* If the thread is periodic and reading from a delayed
					 * connection or sampling connection, then we also have a sampling point.
					 * There are several cases worth commenting on:
					 * (1) We did not cross a partition boundary, in which
					 * case we have a new sampling point; samplingLatency
					 * will be set to the period.
					 * (2) We did cross a partition boundary, but the
					 * thread's period is less frequent than the partition,
					 * e.g., the thread runs every other time the partition
					 * runs, in which case we use the thread's period for
					 * the sampling latency.
					 */
					boolean isSampling = InstanceModelUtil.isPeriodicComponent(ci) &&
							( !InstanceModelUtil.isPortConnection(conn) || !InstanceModelUtil.isImmediatePortConnection(conn) // delayed or sampling
									||(InstanceModelUtil.isPeriodicDevice(ci)&& InstanceModelUtil.isImmediatePortConnection(conn)&& !isSynchronous) //devices are assumed to be in a separate partition/time domain (should do warning)
									// while threads with an immediate connection are assumed to be on the same processor
									|| (InstanceModelUtil.isImmediatePortConnection(conn)&&crossPartition)// deal with immediate going across partition boundary (should do warning)
									|| !previousPeriodic);
					if (isSampling) {
						periodLatency = GetProperties.getPeriodinMicroSec(ci);
						if (periodLatency > samplingLatency){
							// overwrite partition sampling latency if the thread latency is larger. Otherwise, the larger partition latency matters
							samplingLatency = periodLatency;
						}
						if (periodLatency == 0) {
							logInfo(ci,"Periodic subcomponent "+ci.getName()+" has no period. Handled as non-sampling.");
						}
					} 
				}

				/* If we have a sequence of periodic threads with immediate
				 * connections, then only the deadline of the last thread 
				 * matters because all the threads are dispatched in
				 * alignment.  So, if the thread is periodic and the connection
				 * is not delayed, we remove the previous deadline/connection delay from the 
				 * accumulated latency to correct the situation.
				 */
				boolean doRoundUp = false;
				if (InstanceModelUtil.isPeriodicComponent(ci)
						&& InstanceModelUtil.isImmediatePortConnection(conn) && previousPeriodic) {
					if ((InstanceModelUtil.isPeriodicThread(ci))){  // &&isSynchronous for threads we always assume immediate
						// we only remove it if it is an immediate thread connection and the thread is synchronous with the predecesssor
						additiveLatency = additiveLatency - previouslyAddedDelay;
						doRoundUp = true;
					}
				}

				/* If the computational latency is larger than the partition
				 * latency then we round up to the next frame of the partition
				 */
				if (samplingLatency > 0) {
					/* We are sampling.  */
					// is there harmonic sampling going on. If yes, we'll be able to limit the sampling latency to the rounded up figure
					if (doRoundUp&& samplingLatency > 0 && previousSamplingPeriod > 0 && (previousSamplingPeriod % samplingLatency == 0 || samplingLatency % previousSamplingPeriod == 0)){
						// We assume that threads with immediate connections are on the same processor
						/* Look at the accumulated latency and 
						 * see if that pushes the execution into the next (or even
						 * later) frame.  We want to "round" the sampling time
						 * up to the least multiple that is greater than the
						 * accumulated latency.
						 */
						int frames = (int)(additiveLatency / samplingLatency);
						if ( (additiveLatency % samplingLatency) > 0 ){
							frames = frames + 1;
						} else if (additiveLatency == 0){
							frames = 1;
						}
						totalLatency = totalLatency
								+ (frames * samplingLatency);
						additiveLatency = 0;
					} else {
						// asynchronous case as well as synchronous case where we do not do the sampling round up optimization
						totalLatency = totalLatency + additiveLatency +samplingLatency;
						additiveLatency = 0;
					}
					previousSamplingPeriod = samplingLatency;
				}
				double fsLatency = 0;
				if (fe instanceof FlowSpecificationInstance){
					/* Now we look at the declared flow latency of the 
					 * subcomponent.  We use it as the current latency only if
					 * it is greater than the thread's deadline, or if the deadline 
					 * is 0 (i.e., we are looking at an incomplete model).
					 */
					FlowSpecificationInstance fefs = (FlowSpecificationInstance)fe;
					fsLatency = GetProperties.getLatencyinMicroSec(fefs);
					if (fsLatency == 0 && deadlineDelay == 0){
						logWarning(fefs,"Flow spec "+fefs.getName()+" has no latency. ");
					} else if (fsLatency>0 && deadlineDelay == 0){
						processingDelay = fsLatency;
					} else if (fsLatency==0 && deadlineDelay > 0){
						processingDelay = deadlineDelay;
					} else 	if (deadlineDelay > 0 && fsLatency > 0){
						if (fsLatency > deadlineDelay){
							logWarning(fefs,"Flow spec "+fefs.getName()+" latency "+convertUStoOutputUnit(fsLatency)+" exceeds deadline "+convertUStoOutputUnit(deadlineDelay)+" Using flow latency.");
							processingDelay = fsLatency;
						} else if (deadlineDelay > fsLatency){
							logInfo(fefs,"Flow spec "+fefs.getName()+" latency "+convertUStoOutputUnit(fsLatency)+" less than deadline "+convertUStoOutputUnit(deadlineDelay)+" Using deadline.");
							processingDelay = deadlineDelay;
						}
					} 
				} else {
					// we have a component without flow spec
					logWarning(ci,ci.getCategory().getName()+" "+ci.getComponentInstancePath()+" has no flow spec. Using deadline latency of "+convertUStoOutputUnit(deadlineDelay));
				}

				/* Update the accumulated latency and record the most 
				 * recently added deadline so that we can remove it later
				 * if we have to (see above).
				 */
				additiveLatency = additiveLatency + processingDelay+queuingDelay;
				previouslyAddedDelay = processingDelay+queuingDelay;
				logLatencyinMicroSec( etef.getComponentInstancePath(),ci.getCategory().getName(),ci.getComponentInstancePath()+((fe instanceof FlowSpecificationInstance)?(":"+fe.getName()):""),totalLatency,additiveLatency,fsLatency,samplingLatency,partitionLatency,processingDelay,myLatencyETE);
			} else if (fe instanceof EndToEndFlowInstance){
				// process recursively
				double eteflatency = doETEF((EndToEndFlowInstance)fe);
				// TODO walk the etef recursively, pass in the existing additive latency
				additiveLatency = additiveLatency + eteflatency;
			} else if (fe instanceof ComponentInstance){

			}
		}

		/* account for the last additive flow latency */
		totalLatency = totalLatency + additiveLatency;
		logLatencyinMicroSec( etef.getComponentInstancePath(),"Total","",totalLatency,0,0,0,0,0,myLatencyETE);
		csvlog.addOutputNewline("");
		return totalLatency;
		}

		protected double adjustforDeadlineLatency(ComponentInstance ci, double flowSpecificationLatency){
			// Use deadline as latency if available, unless the specified latency is greater
			if (InstanceModelUtil.isThread(ci) || InstanceModelUtil.isDevice(ci)) {
				double deadline = GetProperties.getDeadlineinMilliSec(ci);
				if (flowSpecificationLatency == 0 && deadline == 0){
					logWarning(ci,ci.getCategory().getName()+" "+ci.getComponentInstancePath()+" latency used in flow latency calculation is zero");
					return 0.0;
				} else 
					if (flowSpecificationLatency > deadline){
						if ( deadline > 0){
							logWarning(ci,ci.getCategory().getName()+" "+ci.getComponentInstancePath()+" flow spec latency "+convertUStoOutputUnit(flowSpecificationLatency)+" exceeds deadline "+convertUStoOutputUnit(deadline));
						}
						return flowSpecificationLatency;
					} else {
						return deadline;
					}
			}
			return flowSpecificationLatency;
		}

	
	
	/**
	 * This method determines the latency of a connection.  The default implementation
	 * determines it by looking a the latency property.
	 * This method can be overwritten to calculate the latency from the bus the connection is bound to.
	 * @param conn Connection declaration or connection instance
	 * @return double latency value
	 */
	protected double getConnectionLatencyinMicroSec(ConnectionInstance conn){
		double res = FlowLatencyUtil.eInstance.computeConnectionLatencyinMicroSec(conn);
		if (res == 0.0){
			res = GetProperties.getLatencyinMicroSec(conn);
		}
		return res;
	}



	private  double getQueueDelayinMicroSec(final ConnectionInstanceEnd conniEnd, final ComponentInstance comp, boolean periodic){
		if (conniEnd == null||conniEnd instanceof ComponentInstance) return 0;
		FeatureInstance port = (FeatureInstance)conniEnd;
		if (port == null || comp == null){
			return 0;
		}
		double qs = GetProperties.getQueueSize(port);
		double dl = periodic?GetProperties.getPeriodinMicroSec(comp):GetProperties.getDeadlineinMicroSec(comp);
		return qs*dl;
	}
	
	
	private  ComponentInstance enclosingPartition(final ComponentInstance component) {
		ComponentInstance ci = component;
		while (ci.eContainer() != null && ci.eContainer() instanceof ComponentInstance) {
			ci = (ComponentInstance)ci.eContainer();
			try {
				if (GetProperties.getIsPartition(ci))
					return ci;
			} catch (PropertyDoesNotApplyToHolderException e) {
				//Do nothing.
			}
		}
		if (component.getCategory().equals(ComponentCategory.THREAD)||component.getCategory().equals(ComponentCategory.THREAD_GROUP)||component.getCategory().equals(ComponentCategory.PROCESS)){
			// lets find who the thread is bound to
			List<ComponentInstance> res = GetProperties.getActualProcessorBinding(ci);
			for (ComponentInstance componentInstance : res) {
				if (componentInstance.getCategory().equals(ComponentCategory.VIRTUAL_PROCESSOR)){
					return componentInstance;
				}
			}
		}
		return null;
	}
	
	private void logLatencyinMicroSec(final String flowStr, String elementType, String nameStr, double totalLatency, double additiveLatency, double flowLatency, double smpldelay, double partdelay, double deadline, double expected) {
		if (csvlog != null)
		csvlog.addOutputNewline(flowStr+isSynchronousLabel()+","+elementType+","+nameStr+","+convertUStoOutputUnit(deadline)+","+convertUStoOutputUnit(smpldelay)+","+convertUStoOutputUnit(partdelay)+","+convertUStoOutputUnit(flowLatency)+","+convertUStoOutputUnit(additiveLatency)+","+convertUStoOutputUnit(totalLatency)+","+convertUStoOutputUnit(expected)) ;
	}
	
	private void logInfo(final InstanceObject ci, String report) {
		info(ci, report);
		if (csvlog != null)
		csvlog.addOutputNewline(ci.getComponentInstancePath()+": "+report) ;
	}
	
	private void logInfoOnly(final InstanceObject ci, String report) {
		if (csvlog != null)
		csvlog.addOutputNewline(ci.getComponentInstancePath()+": "+report) ;
	}
	
	private void logInfoOnly(String report) {
		if (csvlog != null)
		csvlog.addOutputNewline(report) ;
	}
	
	private void logWarning(final InstanceObject ci, String report) {
		warning(ci, report);
		if (csvlog != null)
		csvlog.addOutputNewline("Warning: "+ci.getComponentInstancePath()+": "+report) ;
	}
	
	private void logError(final InstanceObject ci, String report) {
		error(ci, report);
		if (csvlog != null)
		csvlog.addOutputNewline("ERROR: "+ci.getComponentInstancePath()+": "+report) ;
	}
}
