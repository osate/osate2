package org.osate.analysis.arinc653;

import java.util.ArrayList;
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
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.impl.ContainmentPathElementImpl;
import org.osate.aadl2.instance.*;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.util.Aadl2Switch;
import org.osate.analysis.arinc653.helpers.CriticalityHelper;
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
				switch (componentInstance.getCategory()) 
				{
					case THREAD:
						return DONE;
					case PROCESS:
						return DONE;
					case PROCESSOR:
						RefactorSuggestion suggestion;
						int nbPartitionsForLevelA;
						int nbPartitionsForLevelB;
						int nbPartitionsForLevelC;
						int nbPartitionsForLevelD;
						int nbPartitionsForLevelE;
						ComponentInstance subcomponent;
						
						nbPartitionsForLevelA = 0;
						nbPartitionsForLevelB = 0;
						nbPartitionsForLevelC = 0;
						nbPartitionsForLevelD = 0;
						nbPartitionsForLevelE = 0;
						
						for (Element sub : componentInstance.getChildren())
						{
							if (sub instanceof ComponentInstance)
							{
								subcomponent = (ComponentInstance) sub;

								if (subcomponent.getCategory() == ComponentCategory.VIRTUAL_PROCESSOR)
								{
									System.out.println ("subc=" + subcomponent);

									switch (CriticalityHelper.getCriticality(subcomponent.getSubcomponent()))
									{
										case CriticalityHelper.LEVEL_A:
										{
											nbPartitionsForLevelA++;
											break;
										}
										case CriticalityHelper.LEVEL_B:
										{
											nbPartitionsForLevelB++;
											System.out.println ("One more partition at level B");
											break;
										}
										case CriticalityHelper.LEVEL_C:
										{
											nbPartitionsForLevelC++;
											break;
										}
										case CriticalityHelper.LEVEL_D:
										{
											nbPartitionsForLevelD++;
											break;
										}
										case CriticalityHelper.LEVEL_E:
										{
											nbPartitionsForLevelE++;
											break;
										}
									}
								}
							}
						}
						
						
						if (nbPartitionsForLevelA > 1)
						{
							suggestion = new RefactorSuggestion ();
							suggestion.setAssociatedComponent(componentInstance);
							suggestion.setMessage("processor has more than one partition at criticality A, they might be grouped");
							suggestions.add(suggestion);
						}
						
						if (nbPartitionsForLevelB > 1)
						{
							suggestion = new RefactorSuggestion ();
							suggestion.setAssociatedComponent(componentInstance);
							suggestion.setMessage("processor has more than one partition at criticality B, they might be grouped");
							suggestions.add(suggestion);
						}
						
						if (nbPartitionsForLevelC > 1)
						{
							suggestion = new RefactorSuggestion ();
							suggestion.setAssociatedComponent(componentInstance);
							suggestion.setMessage("processor has more than one partition at criticality C, they might be grouped");
							suggestions.add(suggestion);
						}
						
						if (nbPartitionsForLevelD > 1)
						{
							suggestion = new RefactorSuggestion ();
							suggestion.setAssociatedComponent(componentInstance);
							suggestion.setMessage("processor has more than one partition at criticality D, they might be grouped");
							suggestions.add(suggestion);
						}
						
						if (nbPartitionsForLevelE > 1)
						{
							suggestion = new RefactorSuggestion ();
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
