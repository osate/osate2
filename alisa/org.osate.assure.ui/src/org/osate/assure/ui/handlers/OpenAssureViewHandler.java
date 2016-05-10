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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.assure.assure.AssuranceCaseResult;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.ui.views.AssureView;
import org.osate.assure.util.AssureUtilExtension;

public class OpenAssureViewHandler extends AlisaHandler {
	private static final String ASSURE_VIEW_ID = "org.osate.assure.commands.OpenAssureView";
	private IHandlerActivation openAssureViewerActivation;
//	    private final URI uri;
//	    private final OpenAssureViewHandler assureHandler;

//	    public OpenAssureViewHandler(EObject root, OpenAssureViewHandler assureHandler) {
//	        this.uri = EcoreUtil.getURI(root);
//	        this.assureHandler = assureHandler;
//	    }

	@Override
	protected String getJobName() {
		return "Assure Verification";
	}

	@Override
	protected IStatus runJob(EObject root, IProgressMonitor monitor) {
		clearProofs();
		disableRerunHandler();

		long start = System.currentTimeMillis();

		if (root instanceof AssureResult) {
			AssuranceCaseResult ac = AssureUtilExtension.getAssuranceCaseResult(root);
			drawProofs(ac);
		}

		long stop = System.currentTimeMillis();
		System.out.println("Evaluation time: " + (stop - start) / 1000.0 + "s");

		enableRerunHandler(root);
		System.out.println(EcoreUtil2.getURI(root));

		return Status.OK_STATUS;
	}

	private void enableRerunHandler(final EObject root) {
		getWindow().getShell().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				IHandlerService handlerService = getHandlerService();
//					rerunActivation = handlerService
//							.activateHandler(ASSURE_VIEW_ID, new OpenAssureViewHandler(root, OpenAssureViewHandler.this));
				openAssureViewerActivation = handlerService.activateHandler(ASSURE_VIEW_ID,
						new OpenAssureViewHandler());
			}
		});
	}

	private void disableRerunHandler() {
		if (openAssureViewerActivation != null) {
			getWindow().getShell().getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					IHandlerService handlerService = getHandlerService();
					handlerService.deactivateHandler(openAssureViewerActivation);
					openAssureViewerActivation = null;
				}
			});
		}
	}

	private IHandlerService getHandlerService() {
		return (IHandlerService) getWindow().getService(IHandlerService.class);
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
			AssureView view = (AssureView) page.showView(AssureView.ID);
			view.setProofs(ac);
			view.setFocus();
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	protected void clearProofs() {
		drawProofs(null);
	}
}
