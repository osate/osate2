package org.osate.assure.ui.handlers;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.assure.assure.AssuranceCase;
import org.osate.assure.evaluator.IAssureProcessor;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.verify.util.VerifyUtilExtension;

import com.google.inject.Inject;

public class AssureUpdateHandler extends AlisaHandler {


	@Inject
	private IAssureProcessor assureProcessor;

	@Override
    protected WorkspaceJob getWorkspaceJob(String jobName, final XtextEditor xtextEditor, final URI uri){

		WorkspaceJob job = new WorkspaceJob(getJobName()) {
			@Override
			public IStatus runInWorkspace(final IProgressMonitor monitor) {
				return xtextEditor.getDocument().readOnly(new IUnitOfWork<IStatus, XtextResource>() {
					@Override
					public IStatus exec(XtextResource resource) throws Exception {
						EObject eobj = resource.getResourceSet().getEObject(uri, true);
						AssuranceCase ae = AssureUtilExtension.getRootAssuranceCase(eobj);
						if (ae != null) {
							return runJob(ae, monitor);
						} else {
							return Status.CANCEL_STATUS;
						}
					}
				});
			}
		};
        return job;
    }

	
	@Override
	protected String getJobName() {
		return "Assure update verification";
	}

	@Override
	protected IStatus runJob(EObject sel, IProgressMonitor monitor) {
		AssuranceCase rootCaseResult = null;
		try {
			rootCaseResult = (AssuranceCase)sel;
		} catch (Exception e) {
			e.printStackTrace();
			return Status.CANCEL_STATUS;
		}
		
		long start = System.currentTimeMillis();
		VerifyUtilExtension.clearAllHasRunRecords();
		AssureUtilExtension.clearAllInstanceModels();
		try {
			assureProcessor.processCase(rootCaseResult, monitor);
		} catch (Exception e) {
			if (e instanceof java.lang.NoSuchMethodException) {

				return Status.CANCEL_STATUS;
			}
			e.printStackTrace();
		}

		long stop = System.currentTimeMillis();
		System.out.println("Evaluation time: " + (stop - start) / 1000.0 + "s");

		return Status.OK_STATUS;
	}

}
