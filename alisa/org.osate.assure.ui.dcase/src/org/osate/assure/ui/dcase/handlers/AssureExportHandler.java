package org.osate.assure.ui.dcase.handlers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import net.dependableos.dcase.Argument;
import net.dependableos.dcase.BasicNode;
import net.dependableos.dcase.DcaseFactory;
import net.dependableos.dcase.DcaseLink001;
import net.dependableos.dcase.DcaseLink002;
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
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.assure.assure.AssuranceCase;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.ElseResult;
import org.osate.assure.assure.Metrics;
import org.osate.assure.assure.ThenResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExpr;
import org.osate.assure.assure.impl.AssuranceCaseImpl;
import org.osate.assure.evaluator.IAssureProcessor;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.organization.organization.Stakeholder;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.util.ReqSpecUtilExtension;
import org.osate.verify.util.VerifyUtilExtension;
import org.osate.verify.verify.Claim;

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
						if (eobj instanceof AssuranceCaseImpl) {
							return runJob((AssuranceCaseImpl) eobj, monitor);
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

	protected IStatus runJob(AssuranceCase rootCaseResult, IProgressMonitor monitor) {

//		long start = System.currentTimeMillis();
//		resetToTBD(rootCaseResult);
//		recomputeAllCounts(rootCaseResult);
//		VerifyUtilExtension.clearAllHasRunRecords();
//		AssureUtilExtension.initializeResoluteContext(getInstanceModel(rootCaseResult));

//		AssureProcessing.processCaseResult(rootCaseResult);
//		assureProcessor.process(rootCaseResult);

//		long stop = System.currentTimeMillis();
//		System.out.println("Evaluation time: " + (stop - start) / 1000.0 + "s");
		model = createInitialModel();

		Goal goal = DcaseFactory.eINSTANCE.createGoal();
		goal.setName("Assurance Case " + rootCaseResult.getName() + " for "
				+ rootCaseResult.getTarget().getTarget().getQualifiedName());
		goal.setDesc(AssureUtilExtension.constructDescription(rootCaseResult));
		goal.setMessage(getMetricsAsText(rootCaseResult));
		model.getRootBasicNode().add(goal);

		for (ClaimResult cr : rootCaseResult.getClaimResult()) {
			exportClaim(goal, cr);
		}
		exportCases(goal, rootCaseResult.getSubAssuranceCase());

		URI diagramURI;
		URI modelURI;

		diagramURI = getDiagramURI(rootCaseResult);
		modelURI = getModelURI(rootCaseResult);
		Resource diagram = createDiagram(model, diagramURI, modelURI);
		return Status.OK_STATUS;
	}

	private void exportClaim(BasicNode parent, ClaimResult cr) {
		Requirement requirement = cr.getTarget();

		Goal subgoal = DcaseFactory.eINSTANCE.createGoal();
		subgoal.setName("Requirement " + AssureUtilExtension.getName(cr));
		subgoal.setMessage(getMetricsAsText(cr));
		String msg = AssureUtilExtension.constructDescription(cr);
		if (!msg.isEmpty()) {
			subgoal.setDesc(msg);
		}

		model.getRootBasicNode().add(subgoal);

		DcaseLink001 link = DcaseFactory.eINSTANCE.createDcaseLink001();
		link.setTarget(subgoal);
		link.setSource(parent);

		model.getRootBasicLink().add(link);

		for (ClaimResult subCR : cr.getSubClaimResult()) {
			exportClaim(subgoal, subCR);
		}
		exportEvidence(subgoal, cr);

		for (org.osate.reqspec.reqSpec.Goal initialGoal : requirement.getGoalReference()) {
			Goal dcaseInitialGoal = DcaseFactory.eINSTANCE.createGoal();
			dcaseInitialGoal.setName("Goal " + initialGoal.getName());
			dcaseInitialGoal.setDesc(ReqSpecUtilExtension.constructDescription(initialGoal));

			model.getRootBasicNode().add(dcaseInitialGoal);

			DcaseLink002 link2 = DcaseFactory.eINSTANCE.createDcaseLink002();
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

	private void exportCases(BasicNode parent, Iterable<AssuranceCase> aclist) {
		Strategy strategy = DcaseFactory.eINSTANCE.createStrategy();
		model.getRootBasicNode().add(strategy);
		DcaseLink001 link = DcaseFactory.eINSTANCE.createDcaseLink001();
		link.setTarget(strategy);
		link.setSource(parent);
		model.getRootBasicLink().add(link);
		strategy.setDesc("Assurance case for the following subsystems");
		for (AssuranceCase ac : aclist) {
			exportCase(strategy, ac);
		}
	}

	private void exportCase(BasicNode parent, AssuranceCase ac) {
		Goal goal = DcaseFactory.eINSTANCE.createGoal();
		if (ac.getTarget() != null) {
			goal.setName("Assurance Case for " + ac.getTarget().getTarget().getQualifiedName());
		} else {
			goal.setName("Assurance Case for subsystem " + ac.getTargetSystem());
		}
		goal.setDesc(AssureUtilExtension.constructDescription(ac));
		goal.setMessage(getMetricsAsText(ac));
		model.getRootBasicNode().add(goal);
		DcaseLink001 link = DcaseFactory.eINSTANCE.createDcaseLink001();
		link.setTarget(goal);
		link.setSource(parent);
		model.getRootBasicLink().add(link);

		for (ClaimResult cr : ac.getClaimResult()) {
			exportClaim(goal, cr);
		}
		exportCases(goal, ac.getSubAssuranceCase());
	}

	private boolean isAllVAResults(Iterable<VerificationExpr> velist) {
		for (VerificationExpr verificationExpr : velist) {
			if (!(verificationExpr instanceof VerificationActivityResult)) {
				return false;
			}
		}
		return true;
	}

	private Claim getClaim(ClaimResult cr) {
		for (VerificationExpr verificationExpr : cr.getVerificationActivityResult()) {
			if (verificationExpr instanceof VerificationActivityResult) {
				return VerifyUtilExtension.getContainingClaim(((VerificationActivityResult) verificationExpr)
						.getTarget());
			}
		}
		return null;
	}

	private String getArgument(Claim claim) {
		IResourceServiceProvider rsp = IResourceServiceProvider.Registry.INSTANCE.getResourceServiceProvider(URI
				.createURI("fake.verify"));
		ISerializer serializer = rsp.get(ISerializer.class);
		String s = serializer.serialize(claim.getAssert());
		return s;
	}

	private void exportEvidence(BasicNode parent, ClaimResult cr) {
		EList<VerificationExpr> velist = cr.getVerificationActivityResult();
		if (isAllVAResults(velist)) {
			for (VerificationExpr verificationExpr : velist) {
				exportVerificationActivityResult(parent, (VerificationActivityResult) verificationExpr);
			}
		} else {
			Claim claim = getClaim(cr);
			Strategy strategy = DcaseFactory.eINSTANCE.createStrategy();
			model.getRootBasicNode().add(strategy);
			DcaseLink001 link = DcaseFactory.eINSTANCE.createDcaseLink001();
			link.setTarget(strategy);
			link.setSource(parent);
			model.getRootBasicLink().add(link);
			strategy.setName("Argument for " + AssureUtilExtension.getName(cr));
			strategy.setMessage(claim.getRationale().getText());
			strategy.setDesc(getArgument(claim));
			process(parent, velist);
		}
	}

	private void process(BasicNode parent, Iterable<VerificationExpr> velist) {
		for (VerificationExpr var : velist) {

			if (var instanceof VerificationActivityResult) {
				exportVerificationActivityResult(parent, (VerificationActivityResult) var);
			} else if (var instanceof ThenResult) {
				process(parent, ((ThenResult) var).getFirst());
				process(parent, ((ThenResult) var).getSecond());
			} else if (var instanceof ElseResult) {
				process(parent, ((ElseResult) var).getFirst());
			}
		}
	}

	private String getMetricsAsText(AssureResult ar) {
		String result = "";
		Metrics counts = ar.getMetrics();
		result += "(";
		if (counts.getTbdCount() > 0) {
			result += " tbd " + counts.getTbdCount() + " time(s)";
		}

		if (counts.getSuccessCount() > 0) {
			result += " success " + counts.getSuccessCount() + " time(s)";
		}

		if (counts.getFailCount() > 0) {
			result += " failed " + counts.getFailCount() + " time(s)";
		}

		if (counts.getTimeoutCount() > 0) {
			result += " timeout " + counts.getTimeoutCount() + " time(s)";
		}

		if (counts.getOtherCount() > 0) {
			result += " nocompletion " + counts.getOtherCount() + " time(s)";
		}
		result += " )";
		return result;
	}

	public void exportVerificationActivityResult(BasicNode parent, VerificationActivityResult var) {
		Evidence evidence;
		DcaseLink001 link;

		evidence = DcaseFactory.eINSTANCE.createEvidence();
		evidence.setName(var.getTarget().getName());
		evidence.setDesc(var.getTarget().getMethod().getName() + ": " + var.getResultState().getLiteral());
		evidence.setStatus("[" + var.getResultState().getLiteral() + "]");
		evidence.setMessage(var.getMessage());
		model.getRootBasicNode().add(evidence);

		link = DcaseFactory.eINSTANCE.createDcaseLink001();
		link.setTarget(evidence);
		link.setSource(parent);
		model.getRootBasicLink().add(link);

	}

	private static URI getModelURI(AssuranceCase rootCaseResult) {
		IFile file = ResourceUtil.getFile(rootCaseResult.eResource());
		IPath path = file.getFullPath();
		return URI.createPlatformResourceURI(path.addFileExtension("dcase_model").toString(), true);
	}

	private static URI getDiagramURI(AssuranceCase rootCaseResult) {
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
