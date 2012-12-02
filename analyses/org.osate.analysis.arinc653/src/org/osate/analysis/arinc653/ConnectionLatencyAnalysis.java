package org.osate.analysis.arinc653;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.instance.*;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.analysis.arinc653.helpers.CriticalityHelper;
import org.osate.analysis.arinc653.helpers.DeploymentHelper;
import org.osate.analysis.arinc653.helpers.SchedulingSlotsHelper;


public class ConnectionLatencyAnalysis extends AadlProcessingSwitchWithProgress {


	public ConnectionLatencyAnalysis(final IProgressMonitor monitor) 
	{
		super(monitor, PROCESS_PRE_ORDER_ALL);

	}

	public ConnectionLatencyAnalysis(final IProgressMonitor monitor, AnalysisErrorReporterManager errmgr) 
	{
		super(monitor, PROCESS_PRE_ORDER_ALL, errmgr);

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

			public String caseConnectionInstance(ConnectionInstance ci) 
			{
				
				List<ConnectionReference> refs;
				ComponentInstance compSource;
				ComponentInstance compDest;
				ComponentInstance processorSource;
				ComponentInstance processorDest;
				ComponentInstance partitionSource;
				ComponentInstance partitionDest;
				boolean partitionsOnSameProcessor;
				ListValue slots;
				ListValue slotsAllocation;
				int schedulingSourceIndex;
				int schedulingDestIndex;
				long latency;
				
				
				latency = 0;
				schedulingSourceIndex = 0;
				schedulingDestIndex = 0;
				processorSource = null;
				processorDest = null;
				refs = ci.getConnectionReferences();
				
				for (ConnectionReference ref : refs)
				{
					compSource 	= ref.getSource().getContainingComponentInstance();
					compDest 	= ref.getDestination().getContainingComponentInstance();
					
					if ((compSource == null) || (compDest == null))
					{
						continue;
					}
					
					if ((compSource.getCategory() != ComponentCategory.PROCESS) || (compDest.getCategory() != ComponentCategory.PROCESS))
					{
						continue;
					}
					partitionSource = compSource;
					partitionDest = compDest;
					
					System.out.println ("[ConnectionLatency] connection between " + compSource + " and " + compDest);
					partitionsOnSameProcessor = DeploymentHelper.sameProcessor(compSource, compDest);
					
					System.out.println ("[ConnectionLatency] local inter-partition= " + partitionsOnSameProcessor);
					if (partitionsOnSameProcessor)
					{
						processorSource = DeploymentHelper.getModule (partitionSource);
						slots = SchedulingSlotsHelper.getSlots(processorSource);
						slotsAllocation = SchedulingSlotsHelper.getSlots(processorSource);
						schedulingSourceIndex = DeploymentHelper.schedulingOrder(processorSource, partitionSource);
						schedulingDestIndex = DeploymentHelper.schedulingOrder(processorSource, partitionDest);

						if (schedulingSourceIndex < schedulingDestIndex)
						{
							for (int tmp = schedulingSourceIndex ; tmp < schedulingDestIndex ; tmp++)
							{
								Element e = slots.getChildren().get(tmp);
								
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
								Element e = slots.getChildren().get(tmp);
								
								if (e instanceof IntegerLiteral)
								{
									IntegerLiteral il = (IntegerLiteral) e;
									latency = latency + il.getValue();
								}					
							}
							for (int tmp = 0 ; tmp < schedulingDestIndex ; tmp++)
							{
								Element e = slots.getChildren().get(tmp);
								
								if (e instanceof IntegerLiteral)
								{
									IntegerLiteral il = (IntegerLiteral) e;
									latency = latency + il.getValue();
								}					
							}
						}
					}
					System.out.println ("[ConnectionLatency] latency= " + latency);

				}
				
				return DONE;
			}

			public String caseEndToEndFlowInstance(EndToEndFlowInstance ci) {
				return DONE;
			}
		};

	}
	
	
	
}
