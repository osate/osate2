package org.osate.assure.ui.handlers;


	import org.eclipse.core.commands.AbstractHandler;
	import org.eclipse.core.commands.ExecutionEvent;
	import org.eclipse.core.resources.ResourcesPlugin;
	import org.eclipse.core.resources.WorkspaceJob;
	import org.eclipse.core.runtime.IProgressMonitor;
	import org.eclipse.core.runtime.IStatus;
	import org.eclipse.core.runtime.NullProgressMonitor;
	import org.eclipse.core.runtime.Status;
	import org.eclipse.core.runtime.jobs.IJobChangeEvent;
	import org.eclipse.core.runtime.jobs.JobChangeAdapter;
	import org.eclipse.emf.common.util.URI;
	import org.eclipse.emf.ecore.EObject;
	import org.eclipse.jface.dialogs.MessageDialog;
	import org.eclipse.jface.viewers.ISelection;
	import org.eclipse.jface.viewers.IStructuredSelection;
	import org.eclipse.ui.IEditorPart;
	import org.eclipse.ui.IWorkbenchWindow;
	import org.eclipse.ui.handlers.HandlerUtil;
	import org.eclipse.ui.handlers.IHandlerActivation;
	import org.eclipse.ui.handlers.IHandlerService;
	import org.eclipse.xtext.resource.XtextResource;
	import org.eclipse.xtext.ui.editor.XtextEditor;
	import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
	import org.eclipse.xtext.ui.editor.utils.EditorUtils;
	import org.eclipse.xtext.util.concurrent.IUnitOfWork;
	import org.osate.aadl2.Element;

	public abstract class AlisaHandler extends AbstractHandler {
	    protected static final String TERMINATE_ID = "org.osate.alisa.commands.terminate";
	    protected static final String TERMINATE_ALL_ID =
	            "org.osate.alisa.commands.terminateAll";
	    private IWorkbenchWindow window;

	    abstract protected IStatus runJob(Element sel, IProgressMonitor monitor);

	    abstract protected String getJobName();

	    @Override
	    public Object execute(ExecutionEvent event) {
	        EObjectNode node = getEObjectNode(HandlerUtil.getCurrentSelection(event));
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

	        final IHandlerService handlerService = (IHandlerService) window.getService(IHandlerService.class);
	        WorkspaceJob job = new WorkspaceJob(getJobName()) {
	            private IHandlerActivation terminateActivation;

	            @Override
	            public IStatus runInWorkspace(final IProgressMonitor monitor) {

	                return xtextEditor.getDocument().readOnly(new IUnitOfWork<IStatus, XtextResource>() {
	                    @Override
	                    public IStatus exec(XtextResource resource) throws Exception {
	                        EObject eobj = resource.getResourceSet().getEObject(uri, true);
	                        if (eobj instanceof Element) {
	                            return runJob((Element) eobj, monitor);
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
