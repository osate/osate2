package edu.uah.rsesc.aadl.age.xtext;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public class AgeXtextUtil {
	private static final AgeXtextModelListener modelListener = new AgeXtextModelListener();
	
	public static class Initializer  implements IStartup {		
		public void earlyStartup() {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					// TODO: This only works for the active page?
					final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					activePage.addPartListener(new EditorListener(activePage, modelListener));
				}
			});
		}
	}
	
	// TODO: Handle private vs public sections
	/**
	 * Returns the resource set that contains the resource with the package of the element with the specified qualified name
	 * @param qualifiedName
	 * @return
	 */
	public static XtextResourceSet getResourceSetByQualifiedName(final String qualifiedName) {
		final String packageName = qualifiedName.split("::")[0];		
		final XtextResourceSet rs = modelListener.getResourceSet(packageName);
		return rs == null ? OsateResourceUtil.getResourceSet() : rs;
	}
	
	public static void addModelListener(final ModelChangeListener listener) {
		modelListener.addListener(listener);
	}
	
	public static void removeModelListener(final ModelChangeListener listener) {
		modelListener.removeListener(listener);
	}
}