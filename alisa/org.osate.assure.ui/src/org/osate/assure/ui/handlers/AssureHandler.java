/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.assure.ui.handlers;

import static org.osate.assure.util.AssureUtilExtension.recomputeAllCounts;
import static org.osate.assure.util.AssureUtilExtension.resetToTBD;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.evaluator.AssureProcessor;
import org.osate.assure.evaluator.IAssureProcessor;
import org.osate.assure.ui.views.AssureProgressView;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.categories.categories.CategoryFilter;
import org.osate.verify.util.VerifyUtilExtension;

import com.google.inject.Inject;

public class AssureHandler extends AlisaHandler {

	@Inject
	private IAssureProcessor assureProcessor;
//		
//	@Override
//    protected WorkspaceJob getWorkspaceJob(String jobName, final XtextEditor xtextEditor, final URI uri){
//		WorkspaceJob job = new WorkspaceJob(getJobName()) {
//			@Override
//			public IStatus runInWorkspace(final IProgressMonitor monitor) {
//				try {
//					return xtextEditor.getDocument().readOnly(new IUnitOfWork<IStatus, XtextResource>() {
//						@Override
//						public IStatus exec(XtextResource resource) {
//							EObject eobj = resource.getResourceSet().getEObject(uri, true);
//							AssuranceCaseResult ae = AssureUtilExtension.getRootAssuranceCase(eobj);
//							if (ae != null) {
//								return runJob(ae, monitor);
//							} else {
//								return Status.CANCEL_STATUS;
//							}
//						}
//					});
//				} catch (Exception e) {
//					return Status.CANCEL_STATUS;
//				}
//			}
//		};
//        return job;
//    }
//
//	@Override
//    protected Object scheduleJob(WorkspaceJob job){
//		try {
//			job.wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		if ((job.getResult() == null) || (job.getResult() == Status.CANCEL_STATUS)) {
//			MessageBox dialog = new MessageBox(window.getShell(), SWT.ICON_ERROR | SWT.OK);
//			dialog.setText("Error when running");
//			dialog.setMessage("Error when running the verification activity");
//			dialog.open();
//
//		}
//        return null;
//    }

	@Override
	protected String getJobName() {
		return "ASSURE verification";
	}

	@Override
	protected IStatus runJob(EObject sel, CategoryFilter filter, IProgressMonitor monitor) {

		AssuranceCaseResult rootCaseResult = null;
		try {
			rootCaseResult = (AssuranceCaseResult) sel;
		} catch (Exception e) {
			e.printStackTrace();
			return Status.CANCEL_STATUS;
		}
		long start = System.currentTimeMillis();
		resetToTBD(rootCaseResult, filter);
		recomputeAllCounts(rootCaseResult, filter);
		try {
			rootCaseResult.eResource().save(null);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		VerifyUtilExtension.clearAllHasRunRecords();
		AssureUtilExtension.clearAllInstanceModels();

		// Opens Assure Progress View
		drawProofs(rootCaseResult);

		try {
			if (assureProcessor == null) {
				assureProcessor = new AssureProcessor();
			}
			assureProcessor.processCase(rootCaseResult, filter, monitor);
		} catch (Exception e) {
			if (e instanceof java.lang.NoSuchMethodException) {

				return Status.CANCEL_STATUS;
			}
			e.printStackTrace();
		}
		long stop = System.currentTimeMillis();
		System.out.println("Assure evaluation time: " + (stop - start) / 1000.0 + "s");

		return Status.OK_STATUS;
	}

	private void drawProofs(final AssuranceCaseResult ac) {
		final IWorkbenchPage page = getWindow().getActivePage();

		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				displayView(ac, page);
			}
		});
	}

	private void displayView(final AssuranceCaseResult ac, final IWorkbenchPage page) {
		try {
			AssureProgressView view = (AssureProgressView) page.showView(AssureProgressView.ID);
			view.setProofs(ac, filter);
			view.setFocus();
			assureProcessor.setProgressTreeViewer(view.getTreeViewer());
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
}
