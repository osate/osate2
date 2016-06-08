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

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.categories.categories.CategoryFilter;
import org.osate.verify.util.VerifyUtilExtension;

public class AssureResetHandler extends AlisaHandler {

	@Override
	protected WorkspaceJob getWorkspaceJob(String jobName, final XtextEditor xtextEditor, final URI uri) {
		WorkspaceJob job = new WorkspaceJob(getJobName()) {
			@Override
			public IStatus runInWorkspace(final IProgressMonitor monitor) {
				try {
					return xtextEditor.getDocument().readOnly(new IUnitOfWork<IStatus, XtextResource>() {
						@Override
						public IStatus exec(XtextResource resource) {
							EObject eobj = resource.getResourceSet().getEObject(uri, true);
							AssuranceCaseResult ae = AssureUtilExtension.getAssuranceCaseResult(eobj);
							if (ae != null) {
								return runJob(ae, null, monitor);
							} else {
								return Status.CANCEL_STATUS;
							}
						}
					});
				} catch (Exception e) {
					return Status.CANCEL_STATUS;
				}
			}
		};
		return job;
	}

	@Override
	protected String getJobName() {
		return "Reset assure states and counts";
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
		resetToTBD(rootCaseResult);
		recomputeAllCounts(rootCaseResult);
		VerifyUtilExtension.clearAllHasRunRecords();
		AssureUtilExtension.clearAllInstanceModels();
		try {
			rootCaseResult.eResource().save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long stop = System.currentTimeMillis();
		System.out.println("Evaluation time: " + (stop - start) / 1000.0 + "s");

		return Status.OK_STATUS;
	}

}
