package org.osate.ge.internal.ui.xtext;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.osate.aadl2.NamedElement;

public class AgeXtextUtil {
	private static final OpenAadlResources openAadlResources = new OpenAadlResources();

	/**
	 * Registers listeners to listen to model changes from all Xtext editors and to be notified of newly opened xtext editors.
	 *
	 */
	public static class Initializer implements IStartup {
		@Override
		public void earlyStartup() {
			Display.getDefault().asyncExec(() -> {
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
			page.addPartListener(new EditorListener(page, openAadlResources));
		}
	}

	/**
	 * Returns the Xtext document with a root element which has a qualified name and resource that matches the specified element
	 * @return the last document updated for the qualified name and resource or null if one does not exist
	 */
	public static IXtextDocument getDocumentByRootElement(final NamedElement element) {
		return openAadlResources.getDocument(element.getQualifiedName(), element.eResource());
	}

	public static void addModelListener(final XtextDocumentChangeListener listener) {
		openAadlResources.addModelListener(listener);
	}

	public static void removeModelListener(final XtextDocumentChangeListener listener) {
		openAadlResources.removeModelListener(listener);
	}
}