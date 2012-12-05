package org.osate.analysis.arinc653;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.impl.ContainmentPathElementImpl;
import org.osate.aadl2.instance.*;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.analysis.arinc653.helpers.CriticalityHelper;
import org.osate.analysis.arinc653.helpers.DeploymentHelper;
import org.osate.analysis.arinc653.helpers.SchedulingSlotsHelper;


public class RefactoringAnalyzer extends AadlProcessingSwitchWithProgress
{
	private boolean validationSuccess;
	
	private List<RefactorSuggestion> suggestions;
	

	public RefactoringAnalyzer(final IProgressMonitor monitor) 
	{
		super(monitor, PROCESS_PRE_ORDER_ALL);
		suggestions = new ArrayList<RefactorSuggestion>();
	}

	public RefactoringAnalyzer(final IProgressMonitor monitor, AnalysisErrorReporterManager errmgr) 
	{
		super(monitor, PROCESS_PRE_ORDER_ALL, errmgr);
		suggestions = new ArrayList<RefactorSuggestion>();
	}

	public List<RefactorSuggestion> getSuggestions ()
	{
		return this.suggestions;
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


		
		instanceSwitch = new InstanceSwitch<String>() 
		{
			public String caseComponentInstance(ComponentInstance componentInstance) 
			{
				RefactorSuggestion suggestion;

				suggestion = new RefactorSuggestion ();
				
				switch (componentInstance.getCategory()) 
				{
					case THREAD:
						return DONE;
					case PROCESS:
						ComponentInstance localProcessor;
						Map <ComponentInstance,Integer> connections;
						int nbConnectionsLocal;
						int tmp;
						ComponentInstance suggestedProcessor;
						
						suggestedProcessor = null;
						connections = DeploymentHelper.getConnectionsPerProcessor (componentInstance);
						nbConnectionsLocal = connections.get (DeploymentHelper.getModule (componentInstance));
						
						for (ComponentInstance remoteProcessor : connections.keySet())
						{
							tmp = connections.get(remoteProcessor);
							if (tmp > nbConnectionsLocal)
							{
								suggestedProcessor = remoteProcessor;
							}
						}
						
						if (suggestedProcessor != null)
						{
							suggestion.setAssociatedComponent(componentInstance);
							suggestion.setMessage("this partition has more connection with processor " + suggestedProcessor.getName() + ", moving the partition would improve performance and avoid network usage.");
							suggestions.add(suggestion);
						}
						
						return DONE;
						
					case PROCESSOR:
						int nbPartitionsForLevelA;
						int nbPartitionsForLevelB;
						int nbPartitionsForLevelC;
						int nbPartitionsForLevelD;
						int nbPartitionsForLevelE;
						
						nbPartitionsForLevelA = CriticalityHelper.getNbPartitionsForCriticalityLevel(componentInstance, CriticalityHelper.LEVEL_A);		
						nbPartitionsForLevelB = CriticalityHelper.getNbPartitionsForCriticalityLevel(componentInstance, CriticalityHelper.LEVEL_B);
						nbPartitionsForLevelC = CriticalityHelper.getNbPartitionsForCriticalityLevel(componentInstance, CriticalityHelper.LEVEL_C);
						nbPartitionsForLevelD = CriticalityHelper.getNbPartitionsForCriticalityLevel(componentInstance, CriticalityHelper.LEVEL_D);;
						nbPartitionsForLevelE = CriticalityHelper.getNbPartitionsForCriticalityLevel(componentInstance, CriticalityHelper.LEVEL_E);;
						
						if (nbPartitionsForLevelA > 1)
						{
							suggestion.setAssociatedComponent(componentInstance);
							suggestion.setMessage("processor has more than one partition at criticality A, they might be grouped");
							suggestions.add(suggestion);
						}
						
						if (nbPartitionsForLevelB > 1)
						{
							suggestion.setAssociatedComponent(componentInstance);
							suggestion.setMessage("processor has more than one partition at criticality B, they might be grouped");
							suggestions.add(suggestion);
						}
						
						if (nbPartitionsForLevelC > 1)
						{
							suggestion.setAssociatedComponent(componentInstance);
							suggestion.setMessage("processor has more than one partition at criticality C, they might be grouped");
							suggestions.add(suggestion);
						}
						
						if (nbPartitionsForLevelD > 1)
						{
							suggestion.setAssociatedComponent(componentInstance);
							suggestion.setMessage("processor has more than one partition at criticality D, they might be grouped");
							suggestions.add(suggestion);
						}
						
						if (nbPartitionsForLevelE > 1)
						{
							suggestion.setAssociatedComponent(componentInstance);
							suggestion.setMessage("processor has more than one partition at criticality E, they might be grouped");
							suggestions.add(suggestion);
						}
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
				
				
				return DONE;
			}

			public String caseEndToEndFlowInstance(EndToEndFlowInstance ci) {
				return DONE;
			}
		};

	}
	
	
	
}
