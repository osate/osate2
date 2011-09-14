package org.osate.xtext.aadl2.sandbox.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.InternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.LogInternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.MarkerAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.util.Aadl2ResourceFactoryImpl;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.core.OsateCorePlugin;
import org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration;

import com.google.inject.Inject;

public class InstantiateHandler extends AbstractHandler {


	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;


	protected static final InternalErrorReporter internalErrorLogger = new LogInternalErrorReporter(OsateCorePlugin
			.getDefault().getBundle());

	
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IWorkbenchPart part = page.getActivePart();
		IEditorPart activeEditor = page.getActiveEditor();
		if (activeEditor == null)
			return null;
		XtextEditor xtextEditor = (XtextEditor) activeEditor.getAdapter(XtextEditor.class);
		final ISelection selection;
		if (xtextEditor != null) {
			if (part instanceof ContentOutline) {
				selection = ((ContentOutline) part).getSelection();
			} else {
				selection = (ITextSelection) xtextEditor.getSelectionProvider().getSelection();
			}

			xtextEditor.getDocument().readOnly(
					new IUnitOfWork<EObject, XtextResource>() {
						public EObject exec(XtextResource resource) throws Exception {
							EObject targetElement = null;
							if (selection instanceof IStructuredSelection) {
								IStructuredSelection ss = (IStructuredSelection) selection;
								Object eon = ss.getFirstElement();
								if (eon instanceof EObjectNode) {
									targetElement = ((EObjectNode)eon).getEObject(resource);
								}
							} else {
								targetElement = eObjectAtOffsetHelper.resolveElementAt(resource,
										((ITextSelection)selection).getOffset());
							}
							
							if (targetElement != null
									&& targetElement instanceof SystemConfiguration) {
								SystemConfiguration sc = (SystemConfiguration) targetElement;
								SystemImplementation si = (SystemImplementation) ((SystemConfiguration) targetElement)
										.getSystemImplementation();
								if (si != null) {
									URI instanceURI = OsateResourceUtil
											.getInstanceModelURI(si);
									Aadl2ResourceFactoryImpl resFactory = new Aadl2ResourceFactoryImpl();
									Aadl2ResourceImpl aadlResource = (Aadl2ResourceImpl) resFactory
											.createResource(instanceURI);

									// now instantiate the rest of the model
									final InstantiateModel instantiateModel = new InstantiateModel(
											new NullProgressMonitor(),
											new AnalysisErrorReporterManager(
													internalErrorLogger,
													new MarkerAnalysisErrorReporter.Factory(
															AadlConstants.INSTANTIATION_OBJECT_MARKER)));
									SystemInstance root = instantiateModel
											.createSystemInstanceInt(si,
													aadlResource);
									sc.getSystemInstanceProxy().setInstanceRef(root);
								}
							} else {
								System.out.println("instantiate "
										+ targetElement.toString());
							}
							return null;
						}
					});
		}
		return null;
	}
	

}
