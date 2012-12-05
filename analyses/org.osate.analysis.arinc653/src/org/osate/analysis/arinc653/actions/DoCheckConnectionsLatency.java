package org.osate.analysis.arinc653.actions;


import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.arinc653.Activator;
import org.osate.analysis.arinc653.ConnectionLatencyAnalysis;
import org.osate.analysis.arinc653.ConnectionLatencyReport;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.ui.dialogs.Dialog;
import org.osgi.framework.Bundle;



public final class DoCheckConnectionsLatency extends AaxlReadOnlyActionAsJob {
	
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	protected String getMarkerType() {
		return "org.osate.analysis.arinc653.Arinc653ObjectMarker";
	}

	protected String getActionName() {
		return "ARINC653 inter-partitions communication latency analysis";
	}

		
	
	public void doAaxlAction(IProgressMonitor monitor, Element obj)
	{
		SystemInstance si;
		ConnectionLatencyAnalysis validator;
		String result;
		
		result = "";
		
		monitor.beginTask("Analyze inter-partitions latency", IProgressMonitor.UNKNOWN);
		
		validator = new ConnectionLatencyAnalysis (monitor,getErrorManager());
		
		if (obj instanceof InstanceObject)
		{
			si = ((InstanceObject)obj).getSystemInstance();
		}
		else
		{
			si = null;
		}

		validator.defaultTraversalAllDeclarativeModels();
		
		if (si != null) 
		{
			validator.defaultTraversal(si);
			if(validator.getReports().size() == 0)
			{
				result = "no inter-partition connection";
			}
			else
			{
				for (ConnectionLatencyReport clr : validator.getReports())
				{
					result += "Connection between " + clr.getPartitionSource().getName() + " and " + clr.getPartitionDestination().getName() + " worst-case latency: " + clr.getLatency();
				}
			}
			Dialog.showInfo("Analyze inter-partitions latency", result);
		}
		else
		{
			Dialog.showInfo("Analyze inter-partitions latency", "Please choose an instance model");	
		}
		monitor.done();


		
	}
}
