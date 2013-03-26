/**
 * <copyright>
 * Copyright  2013 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 * 
 * NO WARRANTY
 * 
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
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
 * </copyright>
 * 
 */
package org.osate.analysis.arinc653;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.BusSubcomponent;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.impl.ReferenceValueImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.aadl2.util.OsateDebug;
import org.osate.analysis.arinc653.helpers.DeploymentHelper;
import org.osate.analysis.arinc653.helpers.SchedulingSlotsHelper;
import org.osate.analysis.arinc653.utils.Preferences;
import org.osate.xtext.aadl2.properties.util.GetProperties;


public class ConnectionLatencyAnalysis extends AadlProcessingSwitchWithProgress {

	List<ConnectionLatencyReport> reports;
	
	public ConnectionLatencyAnalysis(final IProgressMonitor monitor) 
	{
		super(monitor, PROCESS_PRE_ORDER_ALL);
		reports = new ArrayList<ConnectionLatencyReport> ();
	}

	public ConnectionLatencyAnalysis(final IProgressMonitor monitor, AnalysisErrorReporterManager errmgr) 
	{
		super(monitor, PROCESS_PRE_ORDER_ALL, errmgr);
		reports = new ArrayList<ConnectionLatencyReport> ();
	}

	
	public List<ConnectionLatencyReport> getReports ()
	{
		return this.reports;
	}

	
	
	protected final void initSwitches() {


		aadl2Switch = new Aadl2Switch<String>() {

			public String caseComponentType(ComponentType obj) {

				return DONE;
			}

			public String caseComponentImplementation(ComponentImplementation ci) {

				return DONE;
			}
			
			public String caseFlowSpecification(FlowSpecification obj) {

				return DONE;
			}

			public String caseEndToEndFlow(EndToEndFlow obj) {

				return DONE;
			}
		};


		
		instanceSwitch = new InstanceSwitch<String>() {
			public String caseComponentInstance(ComponentInstance obj) {
			
				
				switch (obj.getCategory()) 
				{
				case THREAD:
					return DONE;
				case PROCESS:
					return DONE;
				case PROCESSOR:
					return DONE;
				case VIRTUAL_PROCESSOR:
					return DONE;
				case MEMORY:
					return DONE;
				case BUS:
					return DONE;
				case VIRTUAL_BUS:
					return DONE;
				case DEVICE:
					return DONE;
				}
				return DONE;
			}

			public String caseConnectionInstance(ConnectionInstance ci) throws UnsupportedOperationException
			{
				
				List<ConnectionReference> 	refs;
				ComponentInstance 			compSource;
				ComponentInstance 			compDest;
				ComponentInstance 			processorSource;
				ComponentInstance 			processorDest;
				ComponentInstance 			partitionSource;
				ComponentInstance 			partitionDest;
				ConnectionLatencyReport 	report;
				ComponentInstance 			deviceSource;
				ComponentInstance 			deviceDestination;
				String						connectionBusName;
				ComponentInstance			connectionBus;
				
				boolean partitionsOnSameProcessor;
				List<PropertyExpression> slots;
				int schedulingSourceIndex;
				int schedulingDestIndex;
				long latency;
				double busLatency;
				long senderLatency;
				long receiverLatency;
				
				
				busLatency 				= 0;
				latency 				= 0;
				schedulingSourceIndex 	= 0;
				schedulingDestIndex 	= 0;
				processorSource 		= null;
				processorDest 			= null;
				deviceSource 			= null;
				deviceDestination 		= null;
				partitionSource 		= null;
				partitionDest			= null;
				senderLatency 			= 0;
				receiverLatency			= 0;
				latency     			= 0;

				OsateDebug.osateDebug ("[ConnectionLatency] connection detected" + ci + "|" + ci.getSource().getContainingComponentInstance() + "|" + ci.getDestination().getContainingComponentInstance());

				if (ci.getKind() != ConnectionKind.PORT_CONNECTION)
				{
					OsateDebug.osateDebug ("[ConnectionLatency] connection not a port");

					return DONE;
				}
				
				refs = ci.getConnectionReferences();
				
				for (ConnectionReference ref : refs)
				{
					compSource 	= ref.getSource().getContainingComponentInstance();
					compDest 	= ref.getDestination().getContainingComponentInstance();
 
					//OsateDebug.osateDebug ("[ConnectionLatency] source=" + compSource);
					//OsateDebug.osateDebug ("[ConnectionLatency] dest  =" + compDest);

					if ((compSource == null) || (compDest == null))
					{
						continue;
					}
					if ((compSource == null) || (compDest == null))
					{
						continue;
					}
					
					
					if (((compSource.getCategory() != ComponentCategory.PROCESS) ||
						(compDest.getCategory() != ComponentCategory.PROCESS) 	) &&
						((compSource.getCategory() != ComponentCategory.SYSTEM) ||
						 (compDest.getCategory() != ComponentCategory.SYSTEM) 	)) 
					{
						continue;
					}
					
					partitionSource = compSource;
						partitionDest = compDest;

					
				}
	
				
				if ( (partitionSource == null) || (partitionDest == null))
				{
					OsateDebug.osateDebug ("[ConnectionLatency] connection " + ci + " : source and/or destination partitions not found");

					return DONE;
				}

				OsateDebug.osateDebug ("[ConnectionLatency] connection between " + partitionSource + " and " + partitionDest);
				try
				{
					partitionsOnSameProcessor = DeploymentHelper.sameProcessor(partitionSource, partitionDest);
				}
				catch (Exception e)
				{
					throw new UnsupportedOperationException ("partition must be bound to one virtual processor");
				}


				//					System.out.println ("[ConnectionLatency] local inter-partition= " + partitionsOnSameProcessor);
				if (partitionsOnSameProcessor)
				{
					System.out.println ("[ConnectionLatency] Partitions are on the same processor");

					processorSource = DeploymentHelper.getModule (partitionSource);
					slots = SchedulingSlotsHelper.getSlots(processorSource);
					schedulingSourceIndex = DeploymentHelper.schedulingOrder(processorSource, partitionSource);
					schedulingDestIndex = DeploymentHelper.schedulingOrder(processorSource, partitionDest);


					if (! Preferences.getInstance().useMajorFrameDelayedCommunication())
					{
						/*
						 * Here, in the preferences, the user specified that communications
						 * are flushed only at the major frame.
						 */
						if (schedulingSourceIndex < schedulingDestIndex)
						{
							for (int tmp = schedulingSourceIndex ; tmp < schedulingDestIndex ; tmp++)
							{
								Element e = slots.get(tmp);

								if (e instanceof IntegerLiteral)
								{
									IntegerLiteral il = (IntegerLiteral) e;
									latency = latency + il.getValue();
								}					
							}
						}
						else
						{
							for (int tmp = schedulingSourceIndex ; tmp < DeploymentHelper.schedulingListSize (processorSource) ; tmp++)
							{
								Element e = slots.get(tmp);

								if (e instanceof IntegerLiteral)
								{
									IntegerLiteral il = (IntegerLiteral) e;
									latency = latency + il.getValue();
								}					
							}
							for (int tmp = 0 ; tmp < schedulingDestIndex ; tmp++)
							{
								Element e = slots.get(tmp);

								if (e instanceof IntegerLiteral)
								{
									IntegerLiteral il = (IntegerLiteral) e;
									latency = latency + il.getValue();
								}					
							}
						}
					}
					else
					{
						/*
						 * Here, in the preferences, the user specified that communications
						 * are flushed as soon as they are sent. We do not care
						 * about the major frame at all.
						 */
						for (int tmp = schedulingSourceIndex ; tmp < DeploymentHelper.schedulingListSize (processorSource) ; tmp++)
						{
							Element e = slots.get(tmp);

							if (e instanceof IntegerLiteral)
							{
								IntegerLiteral il = (IntegerLiteral) e;
								latency = latency + il.getValue();
								//System.out.println ("Add value" + il.getValue ());

							}					
						}
						for (int tmp = 0 ; tmp <= schedulingDestIndex ; tmp++)
						{
							Element e = slots.get(tmp);

							if (e instanceof IntegerLiteral)
							{
								IntegerLiteral il = (IntegerLiteral) e;
								latency = latency + il.getValue();
								//				System.out.println ("Add value" + il.getValue ());
							}					
						}
					}
				}
				else
				{
					OsateDebug.osateDebug ("[ConnectionLatency] Partitions are on a different processor");

					/*
					 * Suite of the if/else : connection is separated
					 * on different processor. We have to check which device is sending
					 * the data, on which bus and if the devices
					 * get the data only when the major frame is flushed.
					 */
					processorSource = DeploymentHelper.getModule (partitionSource);
					processorDest   = DeploymentHelper.getModule (partitionDest);

					if (processorSource.getCategory() != ComponentCategory.VIRTUAL_PROCESSOR)
					{
						OsateDebug.osateDebug ("[ConnectionLatency] Processor source is not a virtual processor");
						return DONE;
					}
					
					if (processorDest.getCategory() != ComponentCategory.VIRTUAL_PROCESSOR)
					{
						OsateDebug.osateDebug ("[ConnectionLatency] Processor dest is not a virtual processor");
						return DONE;
					}
					
					try
					{
						//	System.out.println ("get="+ GetProperties.getActualConnectionBinding (ci).get(0));
						ReferenceValueImpl busref = (ReferenceValueImpl)GetProperties.getActualConnectionBinding (ci).get(0);

						if (busref.getContainmentPathElements().get(0).getNamedElement() instanceof BusSubcomponent)
						{
							BusSubcomponent busSub = (BusSubcomponent) busref.getContainmentPathElements().get(0).getNamedElement();
							//		System.out.println ("bussub=" + busSub.getImplementationReferences());
							connectionBusName = busSub.getName();
						}
						else
						{
							connectionBusName = "invalid bus";
						}
						
						
						OsateDebug.osateDebug ("[ConnectionLatency] Bus name " + connectionBusName);
						OsateDebug.osateDebug ("[ConnectionLatency] PART src " + partitionSource);
						OsateDebug.osateDebug ("[ConnectionLatency] PART dst " + partitionDest);
						OsateDebug.osateDebug ("[ConnectionLatency] CPU src " + processorSource);
						OsateDebug.osateDebug ("[ConnectionLatency] CPU dst " + processorDest);
						deviceSource = DeploymentHelper.getDeviceConnected (processorSource, connectionBusName);
						deviceDestination = DeploymentHelper.getDeviceConnected (processorDest, connectionBusName);
						
							OsateDebug.osateDebug ("[ConnectionLatency] Device source " + deviceSource);
							OsateDebug.osateDebug ("[ConnectionLatency] Device dest " + deviceDestination);

						connectionBus = DeploymentHelper.getConnectedBus (deviceSource);
						busLatency = GetProperties.getLatencyinMilliSec (connectionBus);
					}
					catch (Exception e)
					{
						deviceSource = null;
						deviceDestination = null;
						busLatency = 0;
						OsateDebug.osateDebug ("[ConnectionLatency] Exception while trying to get informations about devices/buses" );
						e.printStackTrace();

					}
					if (! Preferences.getInstance().useMajorFrameDelayedCommunication())
					{
						/*
						 * Case when we are in a distributed system and the connections
						 * are immediate : passed directly to the device. In that
						 * case, we must wait the first activation slot of the device
						 */



						/*
						 * First, compute the sender latency
						 */
						schedulingSourceIndex = DeploymentHelper.schedulingOrder(processorSource, partitionSource);
						schedulingDestIndex = DeploymentHelper.schedulingOrder(processorSource, deviceSource);
						if (schedulingSourceIndex < schedulingDestIndex)
						{
							for (int tmp = schedulingSourceIndex ; tmp < schedulingDestIndex ; tmp++)
							{
								Element e = SchedulingSlotsHelper.getSlots(processorSource).get(tmp);

								if (e instanceof IntegerLiteral)
								{
									IntegerLiteral il = (IntegerLiteral) e;
									senderLatency = senderLatency + il.getValue();
								}					
							}
						}
						else
						{
							for (int tmp = schedulingSourceIndex ; tmp < DeploymentHelper.schedulingListSize (processorSource) ; tmp++)
							{
								Element e = SchedulingSlotsHelper.getSlots(processorSource).get(tmp);

								if (e instanceof IntegerLiteral)
								{
									IntegerLiteral il = (IntegerLiteral) e;
									senderLatency = senderLatency + il.getValue();
								}					
							}
							for (int tmp = 0 ; tmp < schedulingDestIndex ; tmp++)
							{
								Element e = SchedulingSlotsHelper.getSlots(processorSource).get(tmp);

								if (e instanceof IntegerLiteral)
								{
									IntegerLiteral il = (IntegerLiteral) e;
									senderLatency = senderLatency + il.getValue();
								}					
							}
						}



						/*
						 * And then, the receiver latency
						 */
						schedulingSourceIndex = DeploymentHelper.schedulingOrder(processorDest, partitionDest);
						schedulingDestIndex = DeploymentHelper.schedulingOrder(processorDest, deviceDestination);
						if (schedulingSourceIndex < schedulingDestIndex)
						{
							for (int tmp = schedulingSourceIndex ; tmp <= schedulingDestIndex ; tmp++)
							{
								Element e = SchedulingSlotsHelper.getSlots(processorDest).get(tmp);

								if (e instanceof IntegerLiteral)
								{
									IntegerLiteral il = (IntegerLiteral) e;
									senderLatency = senderLatency + il.getValue();
								}					
							}
						}
						else
						{
							for (int tmp = schedulingSourceIndex ; tmp < DeploymentHelper.schedulingListSize (processorDest) ; tmp++)
							{
								Element e = SchedulingSlotsHelper.getSlots(processorDest).get(tmp);

								if (e instanceof IntegerLiteral)
								{
									IntegerLiteral il = (IntegerLiteral) e;
									receiverLatency = receiverLatency + il.getValue();
								}					
							}
							for (int tmp = 0 ; tmp <= schedulingDestIndex ; tmp++)
							{
								Element e = SchedulingSlotsHelper.getSlots(processorDest).get(tmp);

								if (e instanceof IntegerLiteral)
								{
									IntegerLiteral il = (IntegerLiteral) e;
									receiverLatency = receiverLatency + il.getValue();
								}					
							}
						}


					}
					else
					{
						/*
						 * Case when we are in a distributed system and the connections
						 * are delayed by the major frame. In that case, we have to wait
						 * for the major frame at sending and receiving time.
						 */


						/*
						 * First, sender side
						 */
						schedulingSourceIndex = DeploymentHelper.schedulingOrder(processorSource, partitionSource);
						schedulingDestIndex = DeploymentHelper.schedulingOrder(processorSource, deviceSource);
						for (int tmp = schedulingSourceIndex ; tmp < DeploymentHelper.schedulingListSize (processorSource) ; tmp++)
						{
							Element e = SchedulingSlotsHelper.getSlots(processorSource).get(tmp);

							if (e instanceof IntegerLiteral)
							{
								IntegerLiteral il = (IntegerLiteral) e;
								senderLatency = senderLatency + il.getValue();
								//	System.out.println ("Add value" + il.getValue ());

							}					
						}
						for (int tmp = 0 ; tmp < schedulingDestIndex ; tmp++)
						{
							Element e = SchedulingSlotsHelper.getSlots(processorSource).get(tmp);

							if (e instanceof IntegerLiteral)
							{
								IntegerLiteral il = (IntegerLiteral) e;
								senderLatency = senderLatency + il.getValue();
								//		System.out.println ("Add value" + il.getValue ());
							}					
						}



						/*
						 * Then, receiver side
						 */
						schedulingSourceIndex = DeploymentHelper.schedulingOrder(processorDest, partitionDest);
						schedulingDestIndex = DeploymentHelper.schedulingOrder(processorDest, deviceDestination);
						for (int tmp = schedulingSourceIndex ; tmp < DeploymentHelper.schedulingListSize (processorDest) ; tmp++)
						{
							Element e = SchedulingSlotsHelper.getSlots(processorDest).get(tmp);

							if (e instanceof IntegerLiteral)
							{
								IntegerLiteral il = (IntegerLiteral) e;
								receiverLatency = receiverLatency + il.getValue();
								//			System.out.println ("Add value" + il.getValue ());

							}					
						}
						for (int tmp = 0 ; tmp < schedulingDestIndex ; tmp++)
						{
							Element e = SchedulingSlotsHelper.getSlots(processorDest).get(tmp);

							if (e instanceof IntegerLiteral)
							{
								IntegerLiteral il = (IntegerLiteral) e;
								receiverLatency = receiverLatency + il.getValue();
								//System.out.println ("Add value" + il.getValue ());
							}					
						}

					}


					latency = (long)busLatency + senderLatency + receiverLatency;
				}
				report = new ConnectionLatencyReport (partitionSource, partitionDest, latency);
				reports.add(report);
				//System.out.println ("[ConnectionLatency] latency= " + latency);
				//System.out.println ("[ConnectionLatency] buslatency= " + busLatency);




				return DONE;
			}

			public String caseEndToEndFlowInstance(EndToEndFlowInstance ci) {
				return DONE;
			}
		};

	}
	
	
	
}
