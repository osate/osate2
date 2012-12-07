package org.osate.validation;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.Element;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

abstract public class AadlAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	private Object currentSelection;

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection iss = (IStructuredSelection) selection;
			if (iss.size() == 1) {
				currentSelection = iss.getFirstElement();
			}
		}
	}
	
	abstract protected IStatus runJob(Element sel, IProgressMonitor monitor, Logger log);
	
	@Override
	public void run(IAction action) {
		final Logger log = new Logger(Logger.WARN, "META", getWindow());

		WorkspaceJob job = new WorkspaceJob("AADL Job") {
			@Override
			public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException {
				IEditorPart activeEditor = window.getActivePage().getActiveEditor();
				if (activeEditor == null) return Status.CANCEL_STATUS;
				final XtextEditor xtextEditor = (XtextEditor) activeEditor.getAdapter(XtextEditor.class);
				if (xtextEditor == null)return Status.CANCEL_STATUS;
				
				if (!(currentSelection instanceof EObjectNode)) return Status.CANCEL_STATUS;
				EObjectNode node = (EObjectNode) currentSelection;
				final URI uri = node.getEObjectURI();
				
				xtextEditor.getDocument().readOnly(
					new IUnitOfWork<IStatus, XtextResource>() {
						public IStatus exec(XtextResource resource) throws Exception {
							EObject eobj = resource.getResourceSet().getEObject(uri, true);
							if (eobj instanceof Element) {
								return runJob((Element) eobj, monitor, log);
							}
								
							return Status.CANCEL_STATUS;
						}
					});
				
				return Status.OK_STATUS;
			}
		};
		
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.setUser(true);
		job.schedule();
	}
	
	@Override
	public void dispose() {
	}

	@Override
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
	
	protected IWorkbenchWindow getWindow() {
		return window;
	}

	protected Shell getShell() {
		return window.getShell();
	}

	protected AnalysisErrorReporterManager getErrorManager() {
		return AnalysisErrorReporterManager.NULL_ERROR_MANANGER;
	}
}
