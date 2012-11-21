package org.osate.analysis.arinc653.actions;


import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.arinc653.Activator;
import org.osate.analysis.arinc653.ConnectionInspector;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.ui.dialogs.Dialog;
import org.osgi.framework.Bundle;



public final class DoCheckConnections extends AaxlReadOnlyActionAsJob {
	
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
		ConnectionInspector connectionInspector;
		
		monitor.beginTask("Inspect architecture", IProgressMonitor.UNKNOWN);
		
		connectionInspector = new ConnectionInspector (monitor,getErrorManager());
		
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
			connectionInspector.defaultTraversal(si);
			Dialog.showInfo("Inspect architecture", "Done");
		}
		else
		{
			Dialog.showInfo("Inspect architecture", "Please choose an instance model");	
		}
		monitor.done();


		
	}
}
