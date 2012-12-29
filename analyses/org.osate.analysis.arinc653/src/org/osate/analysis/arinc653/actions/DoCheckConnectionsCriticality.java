package org.osate.analysis.arinc653.actions;


import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.arinc653.Activator;
import org.osate.analysis.arinc653.ConnectionCriticalityValidation;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.ui.dialogs.Dialog;
import org.osgi.framework.Bundle;



public final class DoCheckConnectionsCriticality extends AaxlReadOnlyActionAsJob {
	
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	protected String getMarkerType() {
		return "org.osate.analysis.arinc653.Arinc653ObjectMarker";
	}

	protected String getActionName() {
		return "ARINC653 connection analysis";
	}

		
	
	public void doAaxlAction(IProgressMonitor monitor, Element obj)
	{
		SystemInstance si;
		String str;
		ConnectionCriticalityValidation connectionInspector;
		
		monitor.beginTask("Inspect architecture", IProgressMonitor.UNKNOWN);
		
		connectionInspector = new ConnectionCriticalityValidation (monitor,getErrorManager());
		
		if (obj instanceof InstanceObject)
		{
			si = ((InstanceObject)obj).getSystemInstance();
		}
		else
		{
			si = null;
		}

		connectionInspector.defaultTraversalAllDeclarativeModels();
		
		if (si != null) 
		{
			str = "Analysis complete\n";
			connectionInspector.defaultTraversal(si);
			if (connectionInspector.getMessages().size() == 0)
			{
				str = str + "nothing to report";
			}
			else
			{
				for (String s : connectionInspector.getMessages())
				{
					str = str + " * " + s + "\n";
				}
			}
			Dialog.showInfo("Inspect architecture", str);
		}
		else
		{
			Dialog.showInfo("Inspect architecture", "Please choose an instance model");	
		}
		monitor.done();


		
	}
}
