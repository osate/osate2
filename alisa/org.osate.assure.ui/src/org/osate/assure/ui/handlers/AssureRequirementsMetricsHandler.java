package org.osate.assure.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
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
import org.osate.assure.evaluator.IAssureRequirementMetricsProcessor;
import org.osate.assure.ui.views.AssureRequirementsCoverageView;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.categories.categories.CategoryFilter;
import org.osate.verify.util.VerifyUtilExtension;

import com.google.inject.Inject;

public class AssureRequirementsMetricsHandler extends AlisaHandler {
	private static final String ASSURE_REQUIREMENTS_COVERAGE_VIEW_ID = "org.osate.assure.commands.OpenAssureRequirementCoverageView";
	private IHandlerActivation openAssureRequirementsCoverageViewerActivation;

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
		return "Assure requirements coverage metrics";
	}

	@Override
	protected IStatus runJob(EObject sel, CategoryFilter filter, IProgressMonitor monitor) {
		clearProofs();
		disableRerunHandler();

		AssuranceCaseResult rootCaseResult = null;
		try {
			if (sel instanceof AssuranceCaseResult) {
				rootCaseResult = (AssuranceCaseResult) sel;
			} else {
				rootCaseResult = EcoreUtil2.getContainerOfType(sel, AssuranceCaseResult.class);
			}

		} catch (Exception e) {
			e.printStackTrace();
			enableRerunHandler(sel);
			return Status.CANCEL_STATUS;
		}

		long start = System.currentTimeMillis();
		VerifyUtilExtension.clearAllHasRunRecords();
		AssureUtilExtension.clearAllInstanceModels();
		try {
			assureRequirementsMetricsProcessor.processCase(rootCaseResult, monitor);
			drawProofs(rootCaseResult);
		} catch (Exception e) {
			if (e instanceof java.lang.NoSuchMethodException) {
				enableRerunHandler(sel);
				return Status.CANCEL_STATUS;
			}
			e.printStackTrace();
		}

//		long stop = System.currentTimeMillis();
//		System.out.println("Evaluation time: " + (stop - start) / 1000.0 + "s");

		enableRerunHandler(sel);
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
			// TODO: change below to new view name
			AssureRequirementsCoverageView view = (AssureRequirementsCoverageView) page
					.showView(AssureRequirementsCoverageView.ID);
			view.setProofs(ac);
			view.setFocus();
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	protected void clearProofs() {
		drawProofs(null);
	}

	private IHandlerService getHandlerService() {
		return (IHandlerService) getWindow().getService(IHandlerService.class);
	}

	private void disableRerunHandler() {
		if (openAssureRequirementsCoverageViewerActivation != null) {
			getWindow().getShell().getDisplay().syncExec(new Runnable() {
				@Override
				public void run() {
					IHandlerService handlerService = getHandlerService();
					handlerService.deactivateHandler(openAssureRequirementsCoverageViewerActivation);
					openAssureRequirementsCoverageViewerActivation = null;
				}
			});
		}
	}

	private void enableRerunHandler(final EObject root) {
		getWindow().getShell().getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				IHandlerService handlerService = getHandlerService();
//					rerunActivation = handlerService
//							.activateHandler(ASSURE_VIEW_ID, new OpenAssureViewHandler(root, OpenAssureViewHandler.this));
				openAssureRequirementsCoverageViewerActivation = handlerService
						.activateHandler(ASSURE_REQUIREMENTS_COVERAGE_VIEW_ID, new AssureRequirementsMetricsHandler());
			}
		});
	}

}
