package org.osate.ge.internal.ui.xtext;

import java.util.concurrent.atomic.AtomicBoolean;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.osate.aadl2.NamedElement;

public class AgeXtextUtil {
	private static final OpenAadlResources openAadlResources = new OpenAadlResources();
	private static final AtomicBoolean initialized = new AtomicBoolean(false);

	/**
	 * Registers listeners to listen to model changes from all Xtext editors and to be notified of newly opened xtext editors.
	 *
	 */
	private static void ensureInitialized() {
		if (!initialized.getAndSet(true)) {
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
				for (final IWorkbenchWindow window : PlatformUI.getWorkbench().getWorkbenchWindows()) {
					registerListenersForWindow(window);
				}
			});
		}
	}

	/**
	 * Register listeners for the window
	 * @param window
	 */
	private static void registerListenersForWindow(final IWorkbenchWindow window) {
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
	private static void registerListenerForPage(final IWorkbenchPage page) {
		page.addPartListener(new EditorListener(page, openAadlResources));
	}

	/**
	 * Returns the Xtext document with a root element which has a qualified name and resource that matches the specified element
	 * @return the last document updated for the qualified name and resource or null if one does not exist
	 */
	public static IXtextDocument getDocumentByRootElement(final NamedElement element) {
		ensureInitialized();
		return openAadlResources.getDocument(element.getQualifiedName(), element.eResource());
	}

	public static void addModelListener(final XtextDocumentChangeListener listener) {
		ensureInitialized();
		openAadlResources.addModelListener(listener);
	}

	public static void removeModelListener(final XtextDocumentChangeListener listener) {
		ensureInitialized();
		openAadlResources.removeModelListener(listener);
	}
}