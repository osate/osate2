package org.osate.analysis.arinc653.actions;


import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.arinc653.Activator;
import org.osate.analysis.arinc653.ConfigurationValidation;
import org.osate.analysis.arinc653.ConnectionInspector;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.ui.dialogs.Dialog;
import org.osgi.framework.Bundle;



public final class DoCheckConfiguration extends AaxlReadOnlyActionAsJob {
	
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	protected String getMarkerType() {
		return "org.osate.analysis.arinc653.Arinc653ObjectMarker";
	}

	protected String getActionName() {
		return "ARINC653 configuration analysis";
	}

		
	
	public void doAaxlAction(IProgressMonitor monitor, Element obj)
	{
		SystemInstance si;
		ConfigurationValidation validator;
		
		monitor.beginTask("Check ARINC653 configuration compliance", IProgressMonitor.UNKNOWN);
		
		validator = new ConfigurationValidation (monitor,getErrorManager());
		
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
			if (!validator.isSuccessful())
			{
				getErrorManager().error(validator.getErrorElement(), validator.getErrorMessage());
			    Dialog.showError(validator.getErrorTitle(), validator.getErrorMessage());
			}
			else
			{
				Dialog.showInfo("Configuration compliance checking", "Done");
			}
		}
		else
		{
			Dialog.showInfo("Configuration compliance checking", "Please choose an instance model");	
		}
		monitor.done();


		
	}
}
