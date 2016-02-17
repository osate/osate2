package org.osate.assure.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.evaluator.IAssureRequirementMetricsProcessor;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.verify.util.VerifyUtilExtension;

import com.google.inject.Inject;

public class AssureRequirementsMetricsHandler extends AlisaHandler {

	@Inject
	private IAssureRequirementMetricsProcessor assureRequirementsMetricsProcessor;

	public AssureRequirementsMetricsHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object execute(ExecutionEvent event) {
		return super.execute(event);
	}
	
	@Override
	protected String getJobName() {
		return "Assure requirements metrics";
	}

	@Override
	protected IStatus runJob(EObject sel, IProgressMonitor monitor) {
		AssuranceCaseResult rootCaseResult = null;
		try {
			if (sel instanceof AssuranceCaseResult){
				rootCaseResult = (AssuranceCaseResult)sel;
			} else {
				rootCaseResult = EcoreUtil2.getContainerOfType(sel, AssuranceCaseResult.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Status.CANCEL_STATUS;
		}
		
		long start = System.currentTimeMillis();
		VerifyUtilExtension.clearAllHasRunRecords();
		AssureUtilExtension.clearAllInstanceModels();
		try {
			assureRequirementsMetricsProcessor.processCase(rootCaseResult, monitor);
		} catch (Exception e) {
			if (e instanceof java.lang.NoSuchMethodException) {

				return Status.CANCEL_STATUS;
			}
			e.printStackTrace();
		}

//		long stop = System.currentTimeMillis();
//		System.out.println("Evaluation time: " + (stop - start) / 1000.0 + "s");

		return Status.OK_STATUS;
	}

	
	
}
