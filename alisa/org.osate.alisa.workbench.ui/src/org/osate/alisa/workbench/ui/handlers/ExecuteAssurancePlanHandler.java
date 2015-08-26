package org.osate.alisa.workbench.ui.handlers;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.alisa.workbench.alisa.AssurancePlan;
import org.osate.alisa.workbench.util.AlisaWorkbenchUtilExtension;
import org.osate.assure.assure.AssuranceCase;

public class ExecuteAssurancePlanHandler extends EditorObjectHandler {
//
//	@Inject
//	private IGlobalScopeProvider scopeProvider;

//
//	@Inject
//	private IAssureProcessor assureProcessor;

	@Override
	protected IStatus runJob(EObject sel, IProgressMonitor monitor) {
		AssurancePlan plan = AlisaWorkbenchUtilExtension.getEnclosingAssurancePlan(sel);
		if (plan == null)
			return Status.CANCEL_STATUS;
		Resource res = plan.eResource();
		res.setModified(true);
		try {
			res.save(null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		AssuranceCase ae = null;// (AssuranceEvidence) ((CommonGlobalScopeProvider) scopeProvider).getGlobalEObject(plan,
//				AssurePackage.eINSTANCE.getAssuranceEvidence(), plan.getName());
		if (ae == null)
			return Status.CANCEL_STATUS;
		long start = System.currentTimeMillis();
//		resetToTBD(ae);
//		recomputeAllCounts(ae);
//		VerifyUtilExtension.clearAllHasRunRecords();
//		clearAllInstanceModels();
//		try {
////			assureProcessor.process(ae);
//		} catch (Exception e) {
//			if (e instanceof java.lang.NoSuchMethodException) {
//
//				return Status.CANCEL_STATUS;
//			}
//			e.printStackTrace();
//		}
		long stop = System.currentTimeMillis();
		System.out.println("Evaluation time: " + (stop - start) / 1000.0 + "s");

		return Status.OK_STATUS;
	}

	@Override
	protected String getJobName() {
		return "Execute Assurance Plan";
	}

}
