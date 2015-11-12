package org.osate.assure.ui.views;

	import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtext.ui.editor.GlobalURIEditorOpener;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.Metrics;
import org.osate.assure.util.AssureUtilExtension;

import com.google.inject.Inject;

	public class AssureView extends ViewPart {
	    public static final String ID = "org.osate.assure.ui.views.assureView";
	    private TreeViewer treeViewer;

	    @Inject
	    GlobalURIEditorOpener globalURIEditorOpener;
	    
	    @Inject
	    ILabelProvider labelProvider;

	    @Override
	    public void createPartControl(Composite parent) {
	        treeViewer = new TreeViewer(parent, SWT.SINGLE);
	        treeViewer.setContentProvider(new AssureContentProvider());
	        treeViewer.setLabelProvider(labelProvider);//new AssureLabelProvider(null));
	        AssureTooltipListener.createAndRegister(treeViewer);
	        treeViewer.addFilter(new NoMetricsFilter());

	        MenuManager manager = new MenuManager();
	        manager.setRemoveAllWhenShown(true);

	        manager.addMenuListener(new IMenuListener() {
	            @Override
	            public void menuAboutToShow(IMenuManager manager) {
	                IStructuredSelection selection = (IStructuredSelection) treeViewer.getSelection();
	                if (!selection.isEmpty()) {
	                    final AssureResult ar = (AssureResult) selection.getFirstElement();

	                    if (ar instanceof ClaimResult){
	                    final ClaimResult claim = (ClaimResult) ar;
	                    EObject location = claim.getTarget();
//	                    if (claim instanceof FailResult) {
//	                        manager.add(createHyperlinkAction("Open Failure Location", location));
//	                    } else if (location instanceof ProveStatement) {
//	                        manager.add(createHyperlinkAction("Open Prove Statement", location));
//	                        manager.add(createExportSubmenu(claim));
//	                    } else {
	                        manager.add(createHyperlinkAction("Open Requirement", location));
//	                    }

//	                    Map<String, EObject> references = claim.getReferences();
//	                    for (String name : new TreeSet<String>(references.keySet())) {
//	                        manager.add(createHyperlinkAction("Go to '" + name + "'",
//	                                references.get(name)));
//	                    }

	                    manager.add(new Action("Copy Claim Text") {
	                        @Override
	                        public void run() {
	                            Transferable text = new StringSelection(AssureUtilExtension.constructDescription(claim));
	                            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	                            clipboard.setContents(text, null);
	                        }
	                    });
	                }
	                }
	            }
	        });
	        treeViewer.getControl().setMenu(manager.createContextMenu(treeViewer.getTree()));
	    }

	    private MenuManager createExportSubmenu(ClaimResult claim) {
	        MenuManager manager = new MenuManager("Export");

	        manager.add(createLogClaimAction(claim));
	        manager.add(createExportCAZAction(claim));
	        return manager;
	    }
	 
	    private IAction createHyperlinkAction(String text, final EObject eObject) {
	        return new Action(text) {
	            @Override
	            public void run() {
	                globalURIEditorOpener.open(EcoreUtil.getURI(eObject), true);
	            }
	        };
	    }
	    
	    private static boolean CERTWARE_INSTALLED;
	    static {
	        try {
//	            CertWareExport.tryLoad();
	            CERTWARE_INSTALLED = true;
	        } catch (NoClassDefFoundError e) {
	            CERTWARE_INSTALLED = false;
	        }
	    }
	    
	   

	    private IAction createExportCAZAction(final ClaimResult claim) {
	        String name = "Export to CertWare";
	        if (!CERTWARE_INSTALLED) {
	            name += " [CertWare plug-ins not installed]";
	        }
	        
	        return new Action(name) {
	            @Override
	            public void run() {
	                try {
//	                    CertWareExport.export(claim);
	                } catch (Throwable t) {
	                    MessageDialog.openError(treeViewer.getControl().getShell(),
	                            "Error during export to CertWare", t.getMessage());
	                    t.printStackTrace();
	                }
	            }
	            
	            @Override
	            public boolean isEnabled() {
	                return CERTWARE_INSTALLED;
	            }
	        };
	    }

	  
	    private Action createLogClaimAction(final ClaimResult claim) {
	        return new Action("Show claim description in Console") {
	            @Override
	            public void run() {
	                MessageConsole console = findConsole("Claim Description");
	                showConsole(console);
	                console.clearConsole();
	                console.newMessageStream().println(claim.toString());
	            }
	        };
	    }

	    private static MessageConsole findConsole(String name) {
	        ConsolePlugin plugin = ConsolePlugin.getDefault();
	        IConsoleManager conMan = plugin.getConsoleManager();
	        IConsole[] existing = conMan.getConsoles();
	        for (int i = 0; i < existing.length; i++) {
	            if (name.equals(existing[i].getName())) {
	                return (MessageConsole) existing[i];
	            }
	        }
	        // no console found, so create a new one
	        MessageConsole myConsole = new MessageConsole(name, null);
	        conMan.addConsoles(new IConsole[] { myConsole });
	        return myConsole;
	    }

	    private void showConsole(IConsole console) {
	        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
	        try {
	            IConsoleView view = (IConsoleView) page.showView(IConsoleConstants.ID_CONSOLE_VIEW);
	            view.display(console);
	            view.setScrollLock(true);
	        } catch (PartInitException e) {
	        }
	    }

	    public void setProofs(List<AssureResult> proofTrees) {
	        Object[] expandedElements = treeViewer.getExpandedElements();
	        TreePath[] expandedTreePaths = treeViewer.getExpandedTreePaths();
	        treeViewer.setInput(proofTrees);
	        treeViewer.setExpandedElements(expandedElements);
	        treeViewer.setExpandedTreePaths(expandedTreePaths);
	    }

	    @Override
	    public void setFocus() {
	        treeViewer.getControl().setFocus();
	    }
	    
	    /**
	     * Viewer Filter class.
	     */
	    private class NoMetricsFilter extends ViewerFilter {

	        /**
	         * @param viewer the viewer
	         * @param parentElement the parent element
	         * @param element the element
	         * @return if the element is to display: true
	         * @see org.eclipse.jface.viewers.ViewerFilter
	         *      #select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	         */
	        @Override
	        public boolean select(Viewer viewer, Object parentElement, Object element) {
	        	if (element instanceof Metrics){
	        		return false;
	        	}
	            return true;
	        }
	    }

	}