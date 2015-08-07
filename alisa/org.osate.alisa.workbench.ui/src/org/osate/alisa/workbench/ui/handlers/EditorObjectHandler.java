package org.osate.alisa.workbench.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.inject.Inject;

public abstract class EditorObjectHandler extends AbstractHandler {
	private IWorkbenchWindow window;
	private ExecutionEvent executionEvent;

	abstract protected IStatus runJob(EObject sel, IProgressMonitor monitor);

	abstract protected String getJobName();

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	protected ExecutionEvent getExecutionEvent() {
		return this.executionEvent;
	}

	@Override
	public Object execute(ExecutionEvent event) {
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		this.executionEvent = event;
		if (selection == null) {
			return null;
		}

		window = HandlerUtil.getActiveWorkbenchWindow(event);
		if (window == null) {
			return null;
		}
//
//		return executeURI(uri);
//	}
//
//	public Object executeURI(final URI uri) {
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
						EObject eobj = null;
						if (selection instanceof ITextSelection) {
							eobj = eObjectAtOffsetHelper.resolveElementAt(resource,
									((ITextSelection) selection).getOffset());
						} else if (selection instanceof IStructuredSelection) {
							IStructuredSelection iss = (IStructuredSelection) selection;
							if (iss.size() == 1) {
								EObjectNode node = (EObjectNode) iss.getFirstElement();
								URI uri = node.getEObjectURI();
								eobj = resource.getResourceSet().getEObject(uri, true);
							}
						}
						if (eobj != null && !eobj.eIsProxy()) {
							return runJob(eobj, monitor);
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

}