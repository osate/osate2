package org.osate.analysis.arinc653.actions;


import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.analysis.arinc653.Activator;
import org.osate.analysis.arinc653.ConfigurationValidation;
import org.osate.analysis.arinc653.RefactorSuggestion;
import org.osate.analysis.arinc653.RefactoringAnalyzer;
import org.osate.ui.actions.AaxlReadOnlyActionAsJob;
import org.osate.ui.dialogs.Dialog;
import org.osgi.framework.Bundle;



public final class DoRefactor extends AaxlReadOnlyActionAsJob {
	
	protected Bundle getBundle() {
		return Activator.getDefault().getBundle();
	}

	protected String getMarkerType() {
		return "org.osate.analysis.arinc653.Arinc653ObjectMarker";
	}

	protected String getActionName() {
		return "ARINC653 refactor";
	}

		
	
	public void doAaxlAction(IProgressMonitor monitor, Element obj)
	{
		SystemInstance si;
		StringBuffer result;
		RefactoringAnalyzer refactor;
		int tmp;
		
		monitor.beginTask("Check system for refactoring", IProgressMonitor.UNKNOWN);
		result = new StringBuffer ();
		refactor = new RefactoringAnalyzer (monitor,getErrorManager());
		
		if (obj instanceof InstanceObject)
		{
			si = ((InstanceObject)obj).getSystemInstance();
		}
		else
		{
			si = null;
		}

		refactor.defaultTraversalAllDeclarativeModels();
		
		if (si != null) 
		{
			refactor.defaultTraversal(si);
			
			if (refactor.getSuggestions().size() == 0)
			{
				result.append ("No suggestion has been proposed regarding your architecture");
			}
			else
			{
				tmp = 0;
				for (RefactorSuggestion rs : refactor.getSuggestions())
				{
					tmp++;
					result.append (tmp + " " + rs.getAssociatedComponent().getName() +": " + rs.getMessage() + "\n");
				}
			}
			
			Dialog.showInfo("Check system for refactoring", result.toString());
			
		}
		else
		{
			Dialog.showInfo("Check system for refactoring", "Please choose an instance model");	
		}
		monitor.done();


		
	}
}
