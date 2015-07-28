package org.osate.assure.ui.dcase.handlers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import net.dependableos.dcase.Argument;
import net.dependableos.dcase.BasicNode;
import net.dependableos.dcase.DcaseFactory;
import net.dependableos.dcase.DcaseLink001;
import net.dependableos.dcase.DcaseLink003;
import net.dependableos.dcase.Evidence;
import net.dependableos.dcase.Goal;
import net.dependableos.dcase.Strategy;
import net.dependableos.dcase.diagram.edit.parts.ArgumentEditPart;
import net.dependableos.dcase.diagram.part.DcaseDiagramEditorPlugin;
import net.dependableos.dcase.diagram.part.Messages;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.util.OsateDebug;
import org.osate.assure.assure.AssuranceEvidence;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.Metrics;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExpr;
import org.osate.assure.assure.VerificationResultState;
import org.osate.assure.assure.impl.AssuranceEvidenceImpl;
import org.osate.assure.evaluator.IAssureProcessor;
import org.osate.organization.organization.Stakeholder;
import org.osate.reqspec.reqSpec.Requirement;

import com.google.inject.Inject;

public class AssureExportHandler extends AbstractHandler {

	private IWorkbenchWindow window;
	private ExecutionEvent executionEvent;

	@Inject
	private IAssureProcessor assureProcessor;

	protected ExecutionEvent getExecutionEvent() {
		return this.executionEvent;
	}

	@Override
	public Object execute(ExecutionEvent event) {
		EObjectNode node = getEObjectNode(HandlerUtil.getCurrentSelection(event));
		this.executionEvent = event;
		if (node == null) {
			return null;
		}
		final URI uri = node.getEObjectURI();

		window = HandlerUtil.getActiveWorkbenchWindow(event);
		if (window == null) {
			return null;
		}

		return executeURI(uri);
	}

	public Object executeURI(final URI uri) {
		final XtextEditor xtextEditor = EditorUtils.getActiveXtextEditor();
		if (xtextEditor == null) {
			return null;
		}

		if (!saveChanges(window.getActivePage().getDirtyEditors())) {
			return null;
		}

		WorkspaceJob job = new WorkspaceJob(getJobName()) {
			@Override
			public IStatus runInWorkspace(final IProgressMonitor monitor) {
				return xtextEditor.getDocument().readOnly(new IUnitOfWork<IStatus, XtextResource>() {
					@Override
					public IStatus exec(XtextResource resource) throws Exception {
						EObject eobj = resource.getResourceSet().getEObject(uri, true);
						if (eobj instanceof AssuranceEvidenceImpl) {
							return runJob((AssuranceEvidenceImpl) eobj, monitor);
						} else {
							return Status.CANCEL_STATUS;
						}
					}
				});
			}
		};

		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.schedule();
		return null;
	}

	private boolean saveChanges(IEditorPart[] dirtyEditors) {
		if (dirtyEditors.length == 0) {
			return true;
		}

		if (MessageDialog.openConfirm(window.getShell(), "Save editors", "Save editors and continue?")) {
			NullProgressMonitor monitor = new NullProgressMonitor();
			for (IEditorPart e : dirtyEditors) {
				e.doSave(monitor);
			}
			return true;
		} else {
			return false;
		}
	}

	private EObjectNode getEObjectNode(ISelection currentSelection) {
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection iss = (IStructuredSelection) currentSelection;
			if (iss.size() == 1) {
				return (EObjectNode) iss.getFirstElement();
			}
		}
		return null;
	}

	protected IWorkbenchWindow getWindow() {
		return window;
	}

	protected String getJobName() {
		return "ASSURE verification";
	}

	protected IStatus runJob(AssuranceEvidence rootCaseResult, IProgressMonitor monitor) {

//		long start = System.currentTimeMillis();
//		resetToTBD(rootCaseResult);
//		recomputeAllCounts(rootCaseResult);
//		VerifyUtilExtension.clearAllHasRunRecords();
//		AssureUtilExtension.initializeResoluteContext(getInstanceModel(rootCaseResult));

//		AssureProcessing.processCaseResult(rootCaseResult);
//		assureProcessor.process(rootCaseResult);

//		long stop = System.currentTimeMillis();
//		System.out.println("Evaluation time: " + (stop - start) / 1000.0 + "s");
		System.out.println("export2");
		model = createInitialModel();

		Goal goal = DcaseFactory.eINSTANCE.createGoal();
		goal.setDesc("Assurance Plan " + rootCaseResult.getName() + " validated");
		goal.setMessage(rootCaseResult.getMessage());
		OsateDebug.osateDebug("Goal name=" + rootCaseResult.getName());
		OsateDebug.osateDebug("Goal msg=" + rootCaseResult.getMessage());
		model.getRootBasicNode().add(goal);

		for (ClaimResult cr : rootCaseResult.getClaimResult()) {
			export(goal, cr);
		}

		URI diagramURI;
		URI modelURI;

		diagramURI = getDiagramURI(rootCaseResult);
		modelURI = getModelURI(rootCaseResult);
		Resource diagram = createDiagram(model, diagramURI, modelURI);
		System.out.println("diagram = " + diagram);
		return Status.OK_STATUS;
	}

	public static void export(BasicNode parent, ClaimResult cr) {
		Requirement requirement = cr.getTarget();

		Goal subgoal = DcaseFactory.eINSTANCE.createGoal();
		subgoal.setMessage(requirement.getTitle());
		subgoal.setDesc(cr.getTarget().getName());

		model.getRootBasicNode().add(subgoal);

		DcaseLink001 link = DcaseFactory.eINSTANCE.createDcaseLink001();
		link.setTarget(subgoal);
		link.setSource(parent);

		model.getRootBasicLink().add(link);

		for (ClaimResult subCR : cr.getSubClaimResult()) {
			export(subgoal, subCR);
		}

		for (VerificationExpr ve : cr.getVerificationActivityResult()) {
			export(subgoal, ve);

		}

		for (org.osate.reqspec.reqSpec.Goal initialGoal : requirement.getGoalReference()) {
			Goal dcaseInitialGoal = DcaseFactory.eINSTANCE.createGoal();
			dcaseInitialGoal.setMessage(initialGoal.getTitle());
			dcaseInitialGoal.setDesc(initialGoal.getName());

			model.getRootBasicNode().add(dcaseInitialGoal);

			DcaseLink001 link2 = DcaseFactory.eINSTANCE.createDcaseLink001();
			link2.setTarget(subgoal);
			link2.setSource(dcaseInitialGoal);

			model.getRootBasicLink().add(link2);

			List<Stakeholder> stakeholders = initialGoal.getStakeholderReference();
			for (Stakeholder stakeholder : stakeholders) {
				net.dependableos.dcase.Monitor dcaseMonitor = DcaseFactory.eINSTANCE.createMonitor();
				dcaseMonitor.setMessage(stakeholder.getName());
				dcaseMonitor.setDesc(stakeholder.getFullname());

				model.getRootBasicNode().add(dcaseMonitor);

				DcaseLink003 link3 = DcaseFactory.eINSTANCE.createDcaseLink003();
				link3.setTarget(dcaseInitialGoal);
				link3.setSource(dcaseMonitor);

				model.getRootBasicLink().add(link3);

			}
		}
	}

	public static void export(BasicNode parent, VerificationExpr ve) {
		Evidence evidence;
		DcaseLink001 link;
		String nodeName;
		String nodeDescription;

		System.out.println("Verification expr = " + ve);
		VerificationActivityResult result = (VerificationActivityResult) ve;
		Strategy strategy = DcaseFactory.eINSTANCE.createStrategy();
		strategy.setMessage(result.getTarget().getMethod().getTitle());
		strategy.setDesc(result.getTarget().getName());
//		justification.setMessage(ve.);
//		justification.setDesc(ve.getName());

		model.getRootBasicNode().add(strategy);
		nodeName = "";
		nodeDescription = "";

		link = DcaseFactory.eINSTANCE.createDcaseLink001();
		link.setTarget(strategy);
		link.setSource(parent);
		model.getRootBasicLink().add(link);

		switch (result.getResultState().getValue()) {
		case VerificationResultState.FAIL_VALUE: {
			nodeName = "FAIL";
			break;
		}

		case VerificationResultState.SUCCESS_VALUE: {
			nodeName = "SUCCESS";
			break;
		}

		case VerificationResultState.TBD_VALUE: {
			nodeName = "TBD";
			break;
		}

		case VerificationResultState.OTHER_VALUE: {
			nodeName = "OTHER";
			break;
		}

		case VerificationResultState.TIMEOUT_VALUE: {
			nodeName = "TIMEOUT";
			break;
		}
		}
		Metrics counts = ((AssureResult) ve).getMetrics();
		nodeDescription += "(";
		if (counts.getTbdCount() > 0) {
			nodeDescription += "TDB " + counts.getTbdCount() + " time(s)";
		}

		if (counts.getSuccessCount() > 0) {
			nodeDescription += " success " + counts.getSuccessCount() + " time(s)";
		}

		if (counts.getFailCount() > 0) {
			nodeDescription += " failed " + counts.getFailCount() + " time(s)";
		}

		if (counts.getTimeoutCount() > 0) {
			nodeDescription += " timeout " + counts.getTimeoutCount() + " time(s)";
		}

		if (counts.getOtherCount() > 0) {
			nodeDescription += " nocompletion " + counts.getOtherCount() + " time(s)";
		}
		nodeDescription += ")";

		evidence = DcaseFactory.eINSTANCE.createEvidence();
		evidence.setName(nodeName);
		evidence.setDesc(nodeDescription);

		model.getRootBasicNode().add(evidence);

		link = DcaseFactory.eINSTANCE.createDcaseLink001();
		link.setTarget(evidence);
		link.setSource(strategy);
		model.getRootBasicLink().add(link);

	}

	private static URI getModelURI(AssuranceEvidence rootCaseResult) {
		IFile file = ResourceUtil.getFile(rootCaseResult.eResource());
		IPath path = file.getFullPath();
		return URI.createPlatformResourceURI(path.addFileExtension("dcase_model").toString(), true);
	}

	private static URI getDiagramURI(AssuranceEvidence rootCaseResult) {
//		EObject obj = cr.getLocation();
		Resource res = rootCaseResult.eResource();
		IFile file = ResourceUtil.getFile(res);
		IPath path = file.getFullPath();
		return URI.createPlatformResourceURI(path.addFileExtension("dcase_diagram").toString(), true);
	}

	public static Resource createDiagram(final Argument arg, URI diagramURI, URI modelURI) {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();

		final Resource diagramResource = editingDomain.getResourceSet().createResource(diagramURI);
		final Resource modelResource = editingDomain.getResourceSet().createResource(modelURI);
		final String diagramName = diagramURI.lastSegment();
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain,
				Messages.DcaseDiagramEditorUtil_CreateDiagramCommandLabel, Collections.EMPTY_LIST) {
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				attachModelToResource(arg, modelResource);

				Diagram diagram = ViewService.createDiagram(arg, ArgumentEditPart.MODEL_ID,
						DcaseDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				if (diagram != null) {
					diagramResource.getContents().add(diagram);
					diagram.setName(diagramName);
					diagram.setElement(arg);
				}

				try {
					modelResource.save(net.dependableos.dcase.diagram.part.DcaseDiagramEditorUtil.getSaveOptions());
					diagramResource.save(net.dependableos.dcase.diagram.part.DcaseDiagramEditorUtil.getSaveOptions());
				} catch (IOException e) {

					DcaseDiagramEditorPlugin.getInstance().logError("Unable to store model and diagram resources", e); //$NON-NLS-1$
				}
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, null, null);
		} catch (ExecutionException e) {
			DcaseDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
		}
		setCharset(WorkspaceSynchronizer.getFile(modelResource));
		setCharset(WorkspaceSynchronizer.getFile(diagramResource));
		return diagramResource;
	}

	public static void setCharset(IFile file) {
		if (file == null) {
			return;
		}
		try {
			file.setCharset("UTF-8", new NullProgressMonitor()); //$NON-NLS-1$
		} catch (CoreException e) {
			DcaseDiagramEditorPlugin.getInstance().logError("Unable to set charset for file " + file.getFullPath(), e); //$NON-NLS-1$
		}
	}

	private static void attachModelToResource(Argument model, Resource resource) {
		resource.getContents().add(model);
	}

	private static Argument model;

	private static Argument createInitialModel() {
		return DcaseFactory.eINSTANCE.createArgument();
	}
}
