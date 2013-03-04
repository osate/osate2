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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.OsateLogger;
import org.osate.aadl2.modelsupport.UnparseText;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.parsesupport.AObject;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.xtext.aadl2.properties.util.AadlProject;
import org.osate.xtext.aadl2.properties.util.GetProperties;

/**
 * @author phf
 *
 * This class provides for flow analysis
 *
 */
public class FlowLatencyAnalysisSwitch extends AadlProcessingSwitchWithProgress {
	
	private boolean DEBUG = true;
	
	private boolean isSynchronous = true;
	
	private WriteToFile csvlog ;
	
	public void setIsSynchronous(){
		isSynchronous = true;
	}
	
	public void setIsAsynchronous(){
		isSynchronous = false;
	}
	
	protected boolean isSynchronous(){
		return isSynchronous;
	}
	
	public void saveCSVContent(){
		csvlog.saveToFile();
	}
	
    /**
     * the analysis method that is invoked on each visited model element
     */
    public FlowLatencyAnalysisSwitch( final IProgressMonitor monitor,
    		final AnalysisErrorReporterManager errMgr, EObject root) {
    	super(monitor, PROCESS_BOTTOM_UP_COMPONENT_IMPL, errMgr);
    	csvlog = new WriteToFile("FlowLatency", root);
		String header = "flow,model element,name,deadline or conn delay,sampling delay,partition delay,flow spec,additional, total, expected\n\r";
		csvlog.addOutputNewline(header);
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
				
				final double totalLatency = doETEF(etef); 
				double val = 0;
					val = FlowLatencyUtil.eInstance.getLatencyinMicroSec(etef);
				if (val > 0)
				{
					if (totalLatency > val) {
						error(etef, "End-to-end flow "+etef.getName()+" calculated latency "+isSynchronousLabel()
								+ convertUStoOutputUnit(totalLatency)
								+ " exceeds expected latency "
								+ convertUStoOutputUnit(val) );
					} else
					if (totalLatency < val) {
						info(etef, "End-to-end flow "+etef.getName()+" calculated latency "+isSynchronousLabel()
								+ convertUStoOutputUnit(totalLatency)
								+ " is less than expected latency "
								+ convertUStoOutputUnit(val));
					} else {
						info(etef,"End-to-end flow "+etef.getName()+" calculated latency "+isSynchronousLabel()
								+ convertUStoOutputUnit(totalLatency) + " matches expected latency");
					}
				} else {
					info(etef,"Calculated latency"+isSynchronousLabel()+" for end-to-end flow "+etef.getName()+" is "
							+ convertUStoOutputUnit(totalLatency) );
				}
				if (monitor.isCanceled()) {
					cancelTraversal();
				}
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
		if (usval < 5000){
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
		NamedElement previousPartition = null;
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
		
		double myLatencyETE = 0.0;

		// If we are analyzing an end to end flow, then we treat the first
		// subcomponent-flow pair specially to prime the latency computation.
			myLatencyETE = FlowLatencyUtil.eInstance.getLatencyinMicroSec(etef);

			fe = it.next();
			ci = fe.getContainingComponentInstance();
			// init the previous partition
			previousPartition = enclosingPartition(ci);
			
			// Get the latency from the flow specification
			FlowSpecificationInstance fefs = (FlowSpecificationInstance)fe;
			double FlowSpecificationLatency;
			FlowSpecificationLatency = FlowLatencyUtil.eInstance.getLatencyinMicroSec(fefs);
			double dv = 0.0;


			// Use deadline as latency if available, unless the specified latency is greater
			if (isThread(ci) || isDevice(ci)) {
					dv = GetProperties.getDeadlineinMilliSec(ci);
				if (FlowSpecificationLatency > dv){
					if ( dv > 0){
						warning(fefs,"Flow spec latency "+convertUStoOutputUnit(FlowSpecificationLatency)+" exceeds deadline "+convertUStoOutputUnit(dv));
					}
					additiveLatency = FlowSpecificationLatency;
				} else {
					additiveLatency = dv;
					if (FlowSpecificationLatency == 0 && dv == 0){
						warning(fefs,"Flow spec "+fefs.getName()+" latency used in flow latency calculation is zero");
					}
				}
				if (isPeriodicThread(ci) || isPeriodicDevice(ci)){
					// TODO a device may sample external state (e.g., temperature) which results in no sampling delay
					// or it may observe an external event or state change by sampling the environment (e.g., switch up/down) which results in sampling delay
					previousSamplingPeriod = GetProperties.getPeriodinMicroSec(ci);
				}
			} else {
				additiveLatency = FlowSpecificationLatency;
			}
			// the partition period here is ignored
			logLatencyinMicroSec(etef.getName(),"Subcomponent",ci.getName(),totalLatency+additiveLatency,additiveLatency,FlowSpecificationLatency,previousSamplingPeriod,0.0,dv,myLatencyETE) ;

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
					logLatencyinMicroSec(etef.getName(),"Connection",conn.getName(),totalLatency+additiveLatency,additiveLatency,0.0,0.0,0.0,conlat,myLatencyETE);
				}
			} else if (fe instanceof FlowSpecificationInstance){
				// we are dealing with a component flow spec
				fefs = (FlowSpecificationInstance)fe;
				boolean previousPeriodic = ci==null?false:
					isPeriodicComponent(ci);
				// get component of current flow spec instance
				ci = fefs.getContainingComponentInstance();
				double samplingLatency = 0; // The amount of latency due to the most recent sampling point (partition or periodic thread)
				double periodLatency = 0; // period of periodic thread or device
				double queuingDelay = 0;  // delay due to port queue
				double processingDelay = 0; // processing delay - either from flow spec or from deadline delay
				double deadlineDelay = 0; // thread/device processing delay - WC is deadline
				double partitionLatency = 0; // latency due to partition sampling
				boolean crossPartition = false;
				if ((isSystem(ci) || isProcess(ci)) && GetProperties.getIsPartition(ci)) {
					// system or process is tagged as partition
					// must be a new partition
					samplingLatency = GetProperties.getPartitionLatencyInMicroSec(ci, 0.0);
					partitionLatency = samplingLatency;
					previousPartition = ci;
					crossPartition = true;
				} else {
					/* The current component is not a partition, but we check
					 * to see if we crossed a partition boundary.  If so,
					 * that introduces a sampling point with the new partition's
					 * latency.
					 * We check whether source and target are in the same partition or not
					 */
					NamedElement partition = enclosingPartition(ci);
					if (partition != null && partition != previousPartition){
						crossPartition = true;
						samplingLatency = GetProperties.getPartitionLatencyInMicroSec(partition,0.0);
					}
					previousPartition = partition;
					
					if (isThread(ci) || isDevice(ci)) {
						// take into account queuing delay
						if (isEventConnection(conn)||isEventPortConnection(conn)){
							// take into account queuing delay on event and event data ports. for port groups assume worst case
							queuingDelay = getQueueDelayinMicroSec(fefs,isPeriodicComponent(ci));
							
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
						boolean isSampling = isPeriodicComponent(ci) &&
								( !isPortConnection(conn) || !isImmediatePortConnection(conn) // delayed or sampling
										||(isPeriodicDevice(ci)&& isImmediatePortConnection(conn)&& !isSynchronous) //devices are assumed to be in a separate partition/time domain (should do warning)
										// while threads with an immediate connection are assumed to be on the same processor
										|| (isImmediatePortConnection(conn)&&crossPartition)// deal with immediate going across partition boundary (should do warning)
										|| !previousPeriodic);
						if (isSampling) {
							periodLatency = GetProperties.getPeriodinMicroSec(ci);
							if (periodLatency > samplingLatency){
								// overwrite partition sampling latency if the thread latency is larger. Otherwise, the larger partition latency matters
								samplingLatency = periodLatency;
							}
							if (periodLatency == 0) {
								info(ci,"Periodic subcomponent has no period. Handled as non-sampling.");
							}
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
				if (isPeriodicComponent(ci)
						&& isImmediatePortConnection(conn) && previousPeriodic) {
					if ((isPeriodicThread(ci))){  // &&isSynchronous for threads we always assume immediate
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
				
				/* Now we look at the declared flow latency of the 
				 * subcomponent.  We use it as the current latency only if
				 * it is greater than the thread's deadline, or if the deadline 
				 * is 0 (i.e., we are looking at an incomplete model).
				 */
				double fsLatency = FlowLatencyUtil.eInstance.getLatencyinMicroSec(fefs);
				if (fsLatency == 0 && deadlineDelay == 0){
					warning(fefs,"Flow spec "+fefs.getName()+" has no latency. ");
				} else if (fsLatency>0 && deadlineDelay == 0){
					processingDelay = fsLatency;
				} else if (fsLatency==0 && deadlineDelay > 0){
					processingDelay = deadlineDelay;
				} else 	if (deadlineDelay > 0 && fsLatency > 0){
					if (fsLatency > deadlineDelay){
						warning(fefs,"Flow spec "+fefs.getName()+" latency "+convertUStoOutputUnit(fsLatency)+" exceeds deadline "+convertUStoOutputUnit(deadlineDelay)+" Using flow latency.");
						processingDelay = fsLatency;
					} else if (deadlineDelay > fsLatency){
						info(fefs,"Flow spec "+fefs.getName()+" latency "+convertUStoOutputUnit(fsLatency)+" less than deadline "+convertUStoOutputUnit(deadlineDelay)+" Using deadline.");
						processingDelay = deadlineDelay;
					}
				} 
				
				/* Update the accumulated latency and record the most 
				 * recently added deadline so that we can remove it later
				 * if we have to (see above).
				 */
				additiveLatency = additiveLatency + processingDelay+queuingDelay;
				previouslyAddedDelay = processingDelay+queuingDelay;
				logLatencyinMicroSec( etef.getName(),ci.getCategory().getName(),ci.getName()+":"+fefs.getName(),totalLatency,additiveLatency,fsLatency,samplingLatency,partitionLatency,processingDelay,myLatencyETE);
			} else if (fe instanceof EndToEndFlowInstance){
				// process recursively
				double eteflatency = doETEF((EndToEndFlowInstance)fe);
				// TODO walk the etef recursively, pass in the existing additive latency
				additiveLatency = additiveLatency + eteflatency;
			}
		}
		
		/* account for the last additive flow latency */
		totalLatency = totalLatency + additiveLatency;
		logLatencyinMicroSec( etef.getName(),"Total","",totalLatency,additiveLatency,0,0,0,0,myLatencyETE);
		return totalLatency;
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
			FlowLatencyUtil.eInstance.getLatencyinMicroSec(conn);
		}
		return res;
	}



	private  FeatureInstance getSourcePort(final FlowSpecificationInstance fs){
			return fs.getSource();
	}


	private  double getQueueDelayinMicroSec(final FlowSpecificationInstance fefs, boolean periodic){
		if (fefs == null) return 0;
		ComponentInstance comp = fefs.getContainingComponentInstance();
		FeatureInstance port = getSourcePort(fefs);
		if (port == null || comp == null){
			return 0;
		}
		double qs = GetProperties.getQueueSize(port);
		double dl = periodic?GetProperties.getPeriodinMicroSec(comp):GetProperties.getDeadlineinMicroSec(comp);
		return qs*dl;
	}
	

	
	private  boolean isPortConnection(final ConnectionInstance conn){
		return conn.getKind() == ConnectionKind.PORT_CONNECTION;
	}

	private  boolean isEventPortConnection(final ConnectionInstance conn){
		ConnectionInstanceEnd cie = conn.getSource();
		if (cie instanceof FeatureInstance){
			return   ((FeatureInstance)cie).getCategory() == FeatureCategory.EVENT_DATA_PORT;
		}
		return false;
	}

	private  boolean isEventConnection(final ConnectionInstance conn){
		ConnectionInstanceEnd cie = conn.getSource();
		if (cie instanceof FeatureInstance){
			return   ((FeatureInstance)cie).getCategory() == FeatureCategory.EVENT_PORT;
		}
		return false;
	}

	
	private boolean isDelayedPortConnection(final ConnectionInstance conn){
		if (isPortConnection(conn)) {
			EList<ConnectionReference> cl = conn.getConnectionReferences();
			for (ConnectionReference cr : cl){
				Connection c = cr.getConnection();
				if ( c instanceof PortConnection){
					PortConnection pc =(PortConnection)c;
					EnumerationLiteral el = GetProperties.getConnectionTiming(pc);
					return el == GetProperties.getDelayedUnitLiteral(pc);
				}
			}
		}
		return false;
	}
	
	private boolean isSampledPortConnection(final ConnectionInstance conn){
		if (isPortConnection(conn)) {
			EList<ConnectionReference> cl = conn.getConnectionReferences();
			for (ConnectionReference cr : cl){
				Connection c = cr.getConnection();
				if ( c instanceof PortConnection){
					PortConnection pc =(PortConnection)c;
					EnumerationLiteral el = GetProperties.getConnectionTiming(pc);
					return el == GetProperties.getSampledUnitLiteral(pc);
				}
			}
		}
		return false;
	}
	
	private boolean isImmediatePortConnection(final ConnectionInstance conn){
		if (isPortConnection(conn)) {
			EList<ConnectionReference> cl = conn.getConnectionReferences();
			for (ConnectionReference cr : cl){
				Connection c = cr.getConnection();
				if ( c instanceof PortConnection){
					PortConnection pc =(PortConnection)c;
					EnumerationLiteral el = GetProperties.getConnectionTiming(pc);
					return el == GetProperties.getImmediateUnitLiteral(pc);
				}
			}
		}
		return false;
	}

	private  boolean isThread(final NamedElement thread){
		return (thread instanceof ThreadSubcomponent)
				|| ((thread instanceof ComponentInstance)
						&& (((ComponentInstance) thread).getCategory() == ComponentCategory.THREAD));
	}

	private  boolean isDevice(final NamedElement thread){
		return (thread instanceof DeviceSubcomponent)
				|| ((thread instanceof ComponentInstance)
						&& (((ComponentInstance) thread).getCategory() == ComponentCategory.DEVICE));
	}
	
	private  boolean isSystem(final NamedElement system)
	{
		return (system instanceof SystemSubcomponent)
				|| ((system instanceof ComponentInstance)
						&& (((ComponentInstance)system).getCategory() == ComponentCategory.SYSTEM));
	}
	
	private  boolean isProcess(final NamedElement process)
	{
		return (process instanceof ProcessSubcomponent)
				|| ((process instanceof ComponentInstance)
						&& (((ComponentInstance)process).getCategory() == ComponentCategory.PROCESS));
	}
	
	private  boolean isPeriodicComponent(final NamedElement subcomponent){
		return isPeriodicThread(subcomponent) || isPeriodicDevice(subcomponent);
	}

	private  boolean isPeriodicThread(final NamedElement thread){
		if (!isThread(thread)) return false;
		final EnumerationLiteral dp = GetProperties.getDispatchProtocol(thread);
		if (dp == null) return false;
		return  dp.getName().equalsIgnoreCase(AadlProject.PERIODIC_LITERAL);
	}
	
	private  boolean isPeriodicDevice(final NamedElement device){
		if (device instanceof ComponentInstance && ((ComponentInstance)device).getCategory().equals(ComponentCategory.DEVICE)){
		final EnumerationLiteral dp = GetProperties.getDispatchProtocol(device);
		if (dp == null) return false;
		return  dp.getName().equalsIgnoreCase(AadlProject.PERIODIC_LITERAL);
		}
		return false;
	}
	
	private  NamedElement enclosingPartition(final NamedElement component) {
		if (component instanceof ComponentInstance) {
			ComponentInstance ci = (ComponentInstance) component;
			while (ci.eContainer() != null && ci.eContainer() instanceof ComponentInstance) {
				ci = (ComponentInstance)ci.eContainer();
				try {
					if (GetProperties.getIsPartition(ci))
						return ci;
				} catch (PropertyDoesNotApplyToHolderException e) {
					//Do nothing.
				}
			}
		} else {
			// we have a subcomponent; lets try the enclosing component implementation
			ComponentImplementation cimpl = ((Subcomponent)component).getContainingComponentImpl();
			try {
				if (GetProperties.getIsPartition(cimpl))
					return cimpl;
			} catch (PropertyDoesNotApplyToHolderException e) {
				//Do nothing;
			}
		}
		return null;
	}
	
	private void logLatencyinMicroSec(final String flowStr, String elementType, String nameStr, double totalLatency, double additiveLatency, double flowLatency, double smpldelay, double partdelay, double deadline, double expected) {
	
		csvlog.addOutputNewline(flowStr+isSynchronousLabel()+","+elementType+","+nameStr+","+convertUStoOutputUnit(deadline)+","+convertUStoOutputUnit(smpldelay)+","+convertUStoOutputUnit(partdelay)+","+convertUStoOutputUnit(flowLatency)+","+convertUStoOutputUnit(additiveLatency)+","+convertUStoOutputUnit(totalLatency)+","+convertUStoOutputUnit(expected)) ;
	}
}
