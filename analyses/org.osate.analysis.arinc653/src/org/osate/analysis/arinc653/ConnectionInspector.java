package org.osate.analysis.arinc653;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.util.Aadl2Switch;


public class ConnectionInspector extends AadlProcessingSwitchWithProgress {


	public ConnectionInspector(final IProgressMonitor monitor) 
	{
		super(monitor, PROCESS_PRE_ORDER_ALL);

	}

	public ConnectionInspector(final IProgressMonitor monitor, AnalysisErrorReporterManager errmgr) 
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
			
				
				switch (obj.getCategory()) {
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
				
				return DONE;
			}

			public String caseEndToEndFlowInstance(EndToEndFlowInstance ci) {
				return DONE;
			}
		};

	}
	
	
	
}
