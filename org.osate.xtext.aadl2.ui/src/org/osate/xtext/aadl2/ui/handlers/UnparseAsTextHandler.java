package org.osate.xtext.aadl2.ui.handlers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.resource.XtextResource;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.workspace.WorkspacePlugin;
import org.osate.xtext.aadl2.util.AadlUnparser;

import com.google.inject.Inject;

public class UnparseAsTextHandler extends AbstractHandler {


	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		ISelection selection= page.getSelection();;
		if (selection instanceof TreeSelection){
			for (Iterator iterator = ((TreeSelection)selection).iterator(); iterator.hasNext();) {
				Object f = (Object) iterator.next();
				if (f instanceof IResource){
					if (WorkspacePlugin.MODEL_FILE_EXT.equalsIgnoreCase(((IResource)f).getFileExtension())){
						// you could use the adapter:	ModelUnit target = (ModelUnit)Platform.getAdapterManager().getAdapter(f, ModelUnit.class);
						// instead of the next two statements
						Resource res = OsateResourceUtil.getResource((IResource)f);
						Element target = (Element)res.getContents().get(0);
						AadlUnparser.getAadlUnparser().doUnparseToFile(target);
						res.getResourceSet().getResources().remove(res);
					}
				}
			}
			return null;
		}
		return null;
	}

}
