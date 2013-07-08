package edu.uah.rsesc.aadl.age.xtext;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public class AgeXtextUtil {
	private static final ModelListener modelListener = new ModelListener();
	
	/**
	 * Registers listeners to listen to model changes from all Xtext editors and to be notified of newly opened xtext editors.
	 * @author philip.alldredge
	 *
	 */
	public static class Initializer  implements IStartup {		
		public void earlyStartup() {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					// Listen for the opening of new windows
					PlatformUI.getWorkbench().addWindowListener(new IWindowListener() {
						@Override
						public void windowActivated(IWorkbenchWindow window) {
						}

						@Override
						public void windowDeactivated(IWorkbenchWindow window) {
						}

						@Override
						public void windowClosed(IWorkbenchWindow window) {
						}

						@Override
						public void windowOpened(IWorkbenchWindow window) {
							registerListenersForWindow(window);
						}						
					});
					
					// Register existing windows
					for(final IWorkbenchWindow window : PlatformUI.getWorkbench().getWorkbenchWindows()) {
						registerListenersForWindow(window);		
					}
				}
			});
		}
		
		/**
		 * Register listeners for the window
		 * @param window
		 */
		private void registerListenersForWindow(final IWorkbenchWindow window) {
			window.addPageListener(new IPageListener() {
				@Override
				public void pageActivated(IWorkbenchPage page) {
				}

				@Override
				public void pageClosed(IWorkbenchPage page) {
				}

				@Override
				public void pageOpened(IWorkbenchPage page) {
					registerListenerForPage(page);
				}				
			});
			
			for(final IWorkbenchPage page : window.getPages()) {
				registerListenerForPage(page);
			}
		}
		
		/**
		 * Register part listeners for a page
		 * @param page
		 */
		private void registerListenerForPage(final IWorkbenchPage page) {
			page.addPartListener(new EditorListener(page, modelListener));	
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
	
	/**
	 * Returns the resource set that contains the resource with the package of the element with the specified qualified name
	 * @param qualifiedName
	 * @return the last document updated for the qualified name or null if one does not exist
	 */
	public static IXtextDocument getDocumentByQualifiedName(final String qualifiedName) {
		final String packageName = qualifiedName.split("::")[0];		
		return modelListener.getDocument(packageName);
	}
	
	public static void addModelListener(final IXtextModelListener listener) {
		modelListener.addListener(listener);
	}
	
	public static void removeModelListener(final IXtextModelListener listener) {
		modelListener.removeListener(listener);
	}
}