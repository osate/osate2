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
package edu.cmu.sei.aadl.flowanalysis;


import java.util.Iterator;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.internal.impl.ComponentImpl;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionTiming;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.impl.FlowImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FlowElementInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.OsateLogger;
import org.osate.aadl2.modelsupport.UnparseText;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.parsesupport.AObject;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;

import edu.cmu.sei.aadl.flowanalysis.actions.FlowLatencyProperties;

/**
 * @author phf
 *
 * This class provides for flow analysis
 *
 */
public class FlowLatencyAnalysisSwitch extends AadlProcessingSwitchWithProgress {
	private final FlowLatencyProperties properties;
	
	private boolean DEBUG = true;
	
	private boolean isSynchronous = true;
	
	private UnparseText csvlog ;
	
	public void setIsSynchronous(){
		isSynchronous = true;
	}
	
	public void setIsAsynchronous(){
		isSynchronous = false;
	}
	
	protected boolean isSynchronous(){
		return isSynchronous;
	}
	
	public String getCSVContent(){
		return csvlog.getParseOutput();
	}
	
    /**
     * the analysis method that is invoked on each visited model element
     */
    public FlowLatencyAnalysisSwitch(final FlowLatencyProperties properties, final IProgressMonitor monitor,
    		final AnalysisErrorReporterManager errMgr) {
    	super(monitor, PROCESS_BOTTOM_UP_COMPONENT_IMPL, errMgr);
    	this.properties = properties;
    	csvlog = new UnparseText();
		String header = "owner,flow,model element,name,deadline or conn delay,sampling delay,partition delay,flow spec,additional, total (ms), expected (ms)\n\r";
    	csvlog(header);
    }
    
    protected final void initSwitches() {
		/* here we are creating the connection checking switches */

   		flowSwitch = new FlowSwitch() {
			/**
			 * check for flow latency match
			 */
			public Object caseFlowImpl(final FlowImpl fi) {
				final FlowSpec fs = fi.getXAllImplement();
				final EList fel = fi.getAllFlowElement();
				if (fel.isEmpty())
					return DONE;
				double totalLatency = doETEF(fi);
				// now we compare the result to the latency in the flow spec
				final double fslv = properties.getMyLatency(fs);
				if (fslv == 0){
					info(fi,"Calculated latency for flow implementation "+fi.getName()+" is "
							+ convertUStoOutputUnit(totalLatency) );
//					// set the flow impl actual latency
//					if (totalLatency > 0) {
//						properties.setActualLatency(fi, (long)totalLatency);
//						info(fs, "Actual latency value set for flow implementation value");
//					}
				} else
					if (totalLatency > fslv) {
						error(fi, "Flow implementation latency "
								+ convertUStoOutputUnit(totalLatency) + " exceeds flow spec "+fs.getName()+" latency "
								+ convertUStoOutputUnit(fslv) );
					} else if (totalLatency < fslv) {
						info(fi, "Flow implementation latency "
								+ convertUStoOutputUnit(totalLatency) + " is less than flow spec "+fs.getName()+" latency "
								+ convertUStoOutputUnit(fslv) );
					} else {
						info(fi,"Flow implementation "+fi.getName()+" latency "
								+ convertUStoOutputUnit(totalLatency) + " matches flow spec latency");
					}
				if (monitor.isCanceled()) {
					cancelTraversal();
				}
				return DONE;
			}

			/**
			 * check for flow latency match
			 */
			// we don't check it because it provides a conservative result
			public Object caseEndToEndFlow(final EndToEndFlow etef)  {
				final EList fel = etef.getAllFlowElement();
				if (fel.isEmpty()) return DONE;
				final double totalLatency = doETEF(etef); 
				double val = 0;
					val = GetProperties.getLatencyinMS(etef);
					if (val == 0 ){
						val = GetProperties.getExpectedLatencyinMS(etef);
					}
				if (val > 0)
				{
					info(etef, "Expected end-to-end flow "+etef.getName()+" latency based on subcomponent flow specs is "
							+ convertUStoOutputUnit(val) + " ms");
					info(etef, "Note: perform end-to-end flow analysis on instance model. The declarative model results for end-to-end are based on immediate subcomponent flow spec latency");
					if (totalLatency > val) {
						error(etef, "End-to-end flow "+etef.getName()+" latency "
								+ convertUStoOutputUnit(totalLatency)
								+ " exceeds specified latency "
								+ convertUStoOutputUnit(val));
					} else
					if (totalLatency < val) {
						info(etef, "End-to-end flow "+etef.getName()+" latency "
								+ convertUStoOutputUnit(totalLatency)
								+ " is less than specified latency "
								+ convertUStoOutputUnit(val) );
					} else {
						info(etef,"End-to-end flow "+etef.getName()+" latency "
								+ convertUStoOutputUnit(totalLatency) + " matches specified latency");
					}
				} else {
					info(etef,"Calculated latency for end-to-end flow "+etef.getName()+" is "
							+ convertUStoOutputUnit(totalLatency));
				}
				if (monitor.isCanceled()) {
					cancelTraversal();
				}
				monitor.worked(1);
				return DONE;
//				info(etef,"Please analyze end-to-end flows on instance models");
//				return DONE;
			}
		};
		
		coreSwitch = new CoreSwitch() {
			/**
			 * check flow latency
			 */
			public Object caseComponentImpl(final ComponentImpl ci)  {
				monitor.subTask("Checking flows in " + ci.getQualifiedName());
				self.processEList(ci.getAllFlowSequence());
				monitor.done();
				return DONE;
			}
		};

		instanceSwitch = new InstanceSwitch() {
			/**
			 * check flow latency
			 */
			public Object caseComponentInstance(final ComponentInstance ci)  {
				monitor.subTask("Checking flows in " + ci.getName());
				self.processEList(ci.getEndToEndFlowInstance());
				monitor.worked(1);
				return DONE;
			}

			public Object caseEndToEndFlowInstance(final EndToEndFlowInstance etef)  {
				final EList fel = etef.getFlowElementInstance();
				if (fel.isEmpty()) return DONE;
				
				final double totalLatency = doETEF(etef); 
				double val = 0;
					val = properties.getMyLatency(etef);
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
//		final int i = (int) (usval/1000);
//		if (i*1000 < usval) return i + 1;
//		return i+" ms";
	}
	
	private String isSynchronousLabel(){
		if (isSynchronous) return " (Synchronous)";
		return " (ASynchronous)";
	}

	protected  double doETEF(final PropertyHolder etef){
		final EList fel = getFlowElementList(etef);
		if (fel.isEmpty()) return 0;
		
		log("Calculating latency "+etef.getName() );
		
		PropertyHolder subcomponent = null;
		PropertyHolder conn = null;
		
		/* Values to track across flow elements */
		// Remember the identity of the previous partition
		PropertyHolder previousPartition = null;
		// The actual latency along the flow so far
		double totalLatency = 0; 
		// The amount of latency in a processing chain since the last sampling point
		double additiveLatency = 0; 
		// remember period of immediate predecessor that samples (periodic)
		// used to determine whether we have harmonic threads talking to each other.
		double previousSamplingPeriod = 0;
		// Iterate over the flow elements.
		final Iterator it = fel.iterator();
		AObject fe; // Either a FlowElement or a FlowElementInstance
		
		String FlowType;
		double myLatencyETE = 0.0;

		// If we are analyzing an end to end flow, then we treat the first
		// subcomponent-flow pair specially to prime the latency computation.
		if (etef instanceof EndToEndFlow || etef instanceof EndToEndFlowInstance) {

			if (etef instanceof EndToEndFlow) {
				FlowType = "Decl. End2End";
			} else {
				FlowType = "Inst. End2End";
			}
			myLatencyETE = properties.getMyLatency(etef);

			fe = (AObject) it.next();
			subcomponent = getFlowContext(fe);
			// init the previous partition
			previousPartition = enclosingPartition(subcomponent, properties);
			
			// Get the latency from the flow specification
			final PropertyHolder fefs = getFlowSpec(fe);
			double flowSpecLatency;
			flowSpecLatency = properties.getMyLatency(fefs);
			double dv = 0.0;


			// Use deadline as latency if available, unless the specified latency is greater
			if (isThread(subcomponent) || isDevice(subcomponent)) {
					dv = GetProperties.getDeadlineinMS(subcomponent);
				if (flowSpecLatency > dv){
					if ( dv > 0){
						warning(fefs,"Flow spec latency "+convertUStoOutputUnit(flowSpecLatency)+" exceeds deadline "+convertUStoOutputUnit(dv));
					}
					additiveLatency = flowSpecLatency;
				} else {
					additiveLatency = dv;
					if (flowSpecLatency == 0 && dv == 0){
						warning(fefs,"Flow spec latency used in flow latency calculation is zero");
					}
				}
				if (isPeriodicThread(subcomponent,properties) || isPeriodicDevice(subcomponent,properties)){
					// TODO a device may sample external state (e.g., temperature) which results in no sampling delay
					// or it may observe an external event or state change by sampling the environment (e.g., switch up/down) which results in sampling delay
					previousSamplingPeriod = GetProperties.getPeriodinMS(subcomponent);
				}
			} else {
				additiveLatency = flowSpecLatency;
			}
			// the partition period here is ignored
			logLatency(FlowType, etef.getName(),"Subcomponent",subcomponent.getName(),totalLatency+additiveLatency,additiveLatency,flowSpecLatency,previousSamplingPeriod,0.0,dv,myLatencyETE) ;
			log("flow step1: additive latency: "+additiveLatency+" prev sampling period: "+previousSamplingPeriod);
		} else {
			// this must be a flow implementation

			final FlowSpec fefs = ((FlowImpl)etef).getXAllImplement();
			myLatencyETE = properties.getMyLatency(fefs);

			FlowType = "Flow Impl "+((PropertyHolder)(etef.eContainer().eContainer())).getName();
		}

		// remembers the deadline added in. To be removed if immediate connection.
		double previouslyAddedDeadline = 0;
		
		// Loop over the rest of the flow elements
		while (it.hasNext()){
			fe = (AObject)it.next();
			if (isConnection(fe)) {
				/* For a connection, accumulate its latency in the
				 * additiveLatency since the last sampling point.  Also,
				 * remember if the connection is delayed.
				 */
				conn = getConnection(fe);
				if (conn != null) {
					double conlat = getConnectionLatency(conn);
					additiveLatency = additiveLatency + conlat;
					log("flow connection "+conn.getName()+": additive latency: "+additiveLatency+ " added connection latency: "+conlat);
					logLatency(FlowType, etef.getName(),"Connection",conn.getName(),totalLatency+additiveLatency,additiveLatency,0.0,0.0,0.0,getConnectionLatency(conn),myLatencyETE);
				}
			} else {
				// we are dealing with a component flow spec
				boolean previousPeriodic = subcomponent==null?false:
					isPeriodicComponent(subcomponent, properties);
				subcomponent = getFlowContext(fe);
				double samplingLatency = 0; // The amount of latency due to the most recent sampling point
				double periodLatency = 0; // period of periodic thread or device
				double delayToAdd = 0;
				double savedPartitionLatency = 0;
				boolean crossPartition = false;
				if ((isSystem(subcomponent) || isProcess(subcomponent)) &&
						GetProperties.getIsPartition(subcomponent)) {
					samplingLatency = GetProperties.getPartitionLatencyinMS(subcomponent, 0.0);
					savedPartitionLatency = samplingLatency;
					previousPartition = subcomponent;
				} else {
					/* The current component is not a parition, but we check
					 * to see if we crossed a partition boundary.  If so,
					 * that introduces a sampling point with the new partition's
					 * latency.
					 */
					PropertyHolder partition = enclosingPartition(subcomponent, properties);
					if (partition != null && partition != previousPartition){
						crossPartition = true;
						samplingLatency = getPartitionLatency(partition, properties);
					}
					previousPartition = partition;
					
					if (isThread(subcomponent) || isDevice(subcomponent)) {
						/* If the current component is a thread, we need to 
						 * get its deadline to account for it's computational
						 * time.
						 */
						delayToAdd = GetProperties.getDeadlineinMS(subcomponent);

						/* If the thread is periodic and reading from a delayed
						 * connection, then we also have a sampling point.
						 * There are several cases worth commenting on:
						 * (1) We did not cross a partition boundary, in which
						 * case we have a new sampling point; samplingLatency
						 * will be 0, so below we set it to the period.
						 * (2) We did cross a partition boundary, but the
						 * thread's period is less frequent than the partition,
						 * e.g., the thread runs every other time the partition
						 * runs, in which case we use the thread's period for
						 * the sampling latency.
						 */
						boolean isSampling = isPeriodicComponent(subcomponent, properties) &&
								( !isDataConnection(conn) || isDelayedDataConnection(conn) 
										||(isPeriodicDevice(subcomponent, properties)&& isImmediateDataConnection(conn)&& !isSynchronous) //devices are assumed to be in a separate partition/time domain
										|| (isImmediateDataConnection(conn)&&crossPartition)// deal with immediate going across partition boundary
										|| !previousPeriodic);
						// TODO aperiodic not triggered by flow port is sampling 
						if (isSampling) {
							periodLatency = GetProperties.getPeriodinMS(subcomponent);
							if (periodLatency > samplingLatency){
								samplingLatency = periodLatency;
							}
							if (periodLatency == 0) {
								info(subcomponent,"Periodic subcomponent has no period. Handled as non-sampling.");
							}
						} 
						if (isEventConnection(conn)||isEventDataConnection(conn)){
							// take into account queuing delay on event and event data ports. for port groups assume worst case
							delayToAdd = delayToAdd + getQueueDelay(fe,isPeriodicComponent(subcomponent, properties));
							
						}
					}
				}
				
				/* If we have a sequence of periodic threads with immediate
				 * connections, then only the deadline of the last thread 
				 * matters because all the threads are dispatched in
				 * alignment.  So, if the thread is periodic and the connection
				 * is not delayed, we remove the previous deadline from the 
				 * accumulated latency to correct the situation.
				 */
				if ((isPeriodicThread(subcomponent, properties) || isPeriodicDevice(subcomponent, properties))
						&& isImmediateDataConnection(conn) && previousPeriodic) {
					if (!crossPartition || !(isPeriodicDevice(subcomponent, properties)&&!isSynchronous)){
						additiveLatency = additiveLatency - previouslyAddedDeadline;
					}
				}
				
				/* If the computational latency is larger than the partition
				 * latency then we round up to the next frame of the partition
				 */
				if (samplingLatency > 0) {
					/* We are sampling.  */
					// is there harmonic sampling going on
					if (isSynchronous()&& samplingLatency > 0 && previousSamplingPeriod > 0 && (previousSamplingPeriod % samplingLatency == 0 || samplingLatency % previousSamplingPeriod == 0)){
						// TODO here we can check for whether we are globally asynchronous
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
						// independent sampling
						totalLatency = totalLatency + additiveLatency +samplingLatency;
						additiveLatency = 0;
					}
					previousSamplingPeriod = samplingLatency;
				}
				
				/* Now we look at the declared flow latency of the 
				 * subcomponent.  We use it as the current compute time only if
				 * it is greater than the thread's deadline, or if the deadline 
				 * is 0 (i.e., we are looking at an incomplete model).
				 */
				final PropertyHolder fefs = getFlowSpec(fe);
				double fsLatency;
				fsLatency = properties.getMyLatency(fefs);
				if (fsLatency == 0 ){
					warning(fefs,"Flow spec latency used in flow latency calculation is zero");
				}
				if (delayToAdd == 0) {
					delayToAdd = fsLatency;
				} else if (fsLatency > delayToAdd){
					warning(fefs,"Flow spec "+fefs.getName()+" latency "+convertUStoOutputUnit(fsLatency)+" exceeds deadline "+convertUStoOutputUnit(delayToAdd));
					delayToAdd = fsLatency;
				}
				
				/* Update the accumulated latency and record the most 
				 * recently added deadline so that we can remove it later
				 * if we have to (see above).
				 */
				additiveLatency = additiveLatency + delayToAdd;
				previouslyAddedDeadline = delayToAdd;
				log("flow spec "+fefs.getName()+": total latency: "+totalLatency+" additive latency: "+additiveLatency+" including delay to add: "+delayToAdd);
				logLatency(FlowType, etef.getName(),"Subcomponent",subcomponent.getName()+":"+fefs.getName(),totalLatency+additiveLatency,additiveLatency,fsLatency,samplingLatency,savedPartitionLatency,GetProperties.getDeadlineinMS(subcomponent),myLatencyETE);
			}
		}
		
		/* account for the last additive flow latency */
		totalLatency = totalLatency + additiveLatency;
		
		log("flow final: total latency: "+totalLatency);
		log("");
		return totalLatency;
	}
	
	
	/**
	 * This method determines the latency of a connection.  The default implementation
	 * determines it by looking a the latency property.
	 * This method can be overwritten to calculate the latency from the bus the connection is bound to.
	 * @param conn Connection declaration or connection instance
	 * @return double latency value
	 */
	protected double getConnectionLatency(PropertyHolder conn){
		return properties.getMyLatency(conn);
	}
	
	private  EList getFlowElementList(final AObject etef){
		if (etef instanceof EndToEndFlow ){
			return ((EndToEndFlow) etef).getAllFlowElement();
		} else if (etef instanceof FlowImpl ){
			return ((FlowImpl) etef).getAllFlowElement();
		} else {
			return ((EndToEndFlowInstance) etef).getFlowElementInstance();
		}
	}

	private  PropertyHolder getFlowContext(final AObject fe){
		if (fe instanceof FlowElement){
			return ((FlowElement) fe).getFlowContext();
		} else {
			return ((FlowElementInstance) fe).getContainingComponentInstance();
		}
	}

	private  PropertyHolder getFlowSpec(final AObject fe){
		if (fe instanceof FlowElement){
			return ((FlowElement) fe).getFlowSpec();
		} else {
			return (FlowSpecInstance) fe;
		}
	}


	private  PropertyHolder getSourcePort(final AObject fs){
		if (fs instanceof FlowSpec){
			return (PropertyHolder)((FlowSpec) fs).getXAllSrc();
		} else if (fs instanceof FlowSpecInstance){
			return ((FlowSpecInstance) fs).getSrc();
		} else 
			return null;
	}


	private  double getQueueDelay(final AObject fe, boolean periodic){
		PropertyHolder comp = getFlowContext(fe);
		PropertyHolder fs = getFlowSpec(fe);
		if (fs == null) return 0;
		PropertyHolder port = getSourcePort(fs);
		if (port == null || comp == null){
			return 0;
		}
		double qs = GetProperties.getQueueSize(port);
		double dl = periodic?GetProperties.getPeriodinMS(comp):GetProperties.getDeadlineinMS(comp);
		return qs*dl;
	}
	
	private static boolean isConnection(final AObject conn){
		if (conn instanceof FlowElement){
			return ((FlowElement) conn).isConnectionReference();
		} else {
			return conn instanceof ConnectionInstance;
		}
	}

	private  PropertyHolder getConnection(final AObject conn){
		if (conn instanceof FlowElement){
			return ((FlowElement) conn).getConnection();
		} else {
			return (ConnectionInstance) conn;
		}
	}
	
	private  boolean isDataConnection(final AObject conn){
		if (conn instanceof Connection){
			return conn instanceof DataConnection;
		} else {
			return conn instanceof PortConnectionInstance && ((PortConnectionInstance) conn).getSrc().getCategory() == FeatureCategory.DATA_LITERAL;
		}
	}

	private  boolean isEventDataConnection(final AObject conn){
		if (conn instanceof Connection){
			return conn instanceof EventDataConnection;
		} else {
			return conn instanceof PortConnectionInstance && ((PortConnectionInstance) conn).getSrc().getCategory() == FeatureCategory.EVENTDATA_LITERAL;
		}
	}

	private  boolean isEventConnection(final AObject conn){
		if (conn instanceof Connection){
			return conn instanceof EventConnection;
		} else {
			return conn instanceof PortConnectionInstance && ((PortConnectionInstance) conn).getSrc().getCategory() == FeatureCategory.EVENT_LITERAL;
		}
	}

	
	private boolean isDelayedDataConnection(final AObject conn){
		if (conn instanceof Connection){
			return (conn instanceof DataConnection)
					&& (((DataConnection) conn).getTiming() == ConnectionTiming.DELAYED_LITERAL);
		} else {
			if (isDataConnection(conn)) {
				return ((PortConnectionInstance) conn).isDelayed();		
			}
		}
		return false;
	}

	
	private boolean isImmediateDataConnection(final AObject conn){
		if (conn instanceof Connection){
			return (conn instanceof DataConnection)
					&& (((DataConnection) conn).getTiming() == ConnectionTiming.IMMEDIATE_LITERAL);
		} else {
			if (isDataConnection(conn)) {
				return !((PortConnectionInstance) conn).isDelayed();		
			}
		}
		return false;
	}

	private  boolean isThread(final AObject thread){
		return (thread instanceof ThreadSubcomponent)
				|| ((thread instanceof ComponentInstance)
						&& (((ComponentInstance) thread).getCategory() == ComponentCategory.THREAD_LITERAL));
	}

	private  boolean isDevice(final AObject thread){
		return (thread instanceof DeviceSubcomponent)
				|| ((thread instanceof ComponentInstance)
						&& (((ComponentInstance) thread).getCategory() == ComponentCategory.DEVICE_LITERAL));
	}
	
	private  boolean isSystem(final AObject system)
	{
		return (system instanceof SystemSubcomponent)
				|| ((system instanceof ComponentInstance)
						&& (((ComponentInstance)system).getCategory() == ComponentCategory.SYSTEM_LITERAL));
	}
	
	private  boolean isProcess(final AObject process)
	{
		return (process instanceof ProcessSubcomponent)
				|| ((process instanceof ComponentInstance)
						&& (((ComponentInstance)process).getCategory() == ComponentCategory.PROCESS_LITERAL));
	}
	
	private  boolean isPeriodicComponent(final AObject subcomponent, final FlowLatencyProperties properties){
		return isPeriodicThread(subcomponent, properties) || isPeriodicDevice(subcomponent, properties);
	}

	private  boolean isPeriodicThread(final AObject thread, final FlowLatencyProperties properties){
		if (!isThread(thread)) return false;
		final EnumLiteral dp = GetProperties.getDispatchProtocol((PropertyHolder)thread);
		if (dp == null) return false;
		return  dp.getName().equalsIgnoreCase(AadlProject.PERIODIC_LITERAL);
	}
	
	private  boolean isPeriodicDevice(final AObject device, final FlowLatencyProperties properties){
		final EnumLiteral dp = GetProperties.getDeviceDispatchProtocol((PropertyHolder)device);
		if (dp == null) return false;
		return  dp.getName().equalsIgnoreCase(AadlProject.PERIODIC_LITERAL);
	}
	
	private  PropertyHolder enclosingPartition(final AObject component, final FlowLatencyProperties properties) {
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
			ComponentImpl cimpl = ((Subcomponent)component).getContainingComponentImpl();
			try {
				if (GetProperties.getIsPartition(cimpl))
					return cimpl;
			} catch (PropertyDoesNotApplyToHolderException e) {
				//Do nothing;
			}
		}
		return null;
	}
	
	private  double getPartitionLatency(final PropertyHolder component, FlowLatencyProperties properties){
		if (GetProperties.getIsPartition(component)) {
			return GetProperties.getPartitionLatencyinMS(component, 0);
		} else {
			return 0;
		}
	}
	
	private void csvlog(String s){
		csvlog.addOutputNewline(s);
	}
	
	private void logLatency(String ownerStr, final String flowStr, String elementType, String nameStr, double totalLatency, double additiveLatency, double flowLatency, double smpldelay, double partdelay, double deadline, double expected) {
	
		csvlog( ownerStr+isSynchronousLabel() +","+ flowStr+","+elementType+","+nameStr+","+convertUStoOutputUnit(deadline)+","+convertUStoOutputUnit(smpldelay)+","+convertUStoOutputUnit(partdelay)+","+convertUStoOutputUnit(flowLatency)+","+convertUStoOutputUnit(additiveLatency)+","+convertUStoOutputUnit(totalLatency)+","+convertUStoOutputUnit(expected)) ;
	}
	
	private static int usValueToMS(final double usval){
		final int i = (int) (usval/1000);
		if (i*1000 < usval) return i + 1;
		return i;
	}
	
	private void log(String str){
		if (DEBUG)
			OsateLogger.log(str+isSynchronousLabel());
	}
}
