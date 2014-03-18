package org.osate.ge.ui.navigator;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.osate.ui.navigator.AadlNavigator;
import org.osate.ui.navigator.AadlNavigatorLabelProvider;

/**
 * Initializer that listens to part changes and overriding Osate AADL Navigator's label provider to show disagram names.
 * @author philip.alldredge
 *
 */
public class NavigatorInitializer implements IStartup {	
	private IPartListener partListener = new IPartListener() {
		@Override
		public void partActivated(IWorkbenchPart part) {
		}

		@Override
		public void partBroughtToTop(IWorkbenchPart part) {
		}

		@Override
		public void partClosed(IWorkbenchPart part) {
		}

		@Override
		public void partDeactivated(IWorkbenchPart part) {
		}

		@Override
		public void partOpened(IWorkbenchPart part) {
			if(part instanceof AadlNavigator) { 
				replaceLabelProvider((AadlNavigator)part);
			}
		}
	};
	
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
		page.addPartListener(partListener);
		final Object navView = page.findView("org.osate.ui.navigator.AadlNavigator");
		if(navView instanceof AadlNavigator) { 
			replaceLabelProvider((AadlNavigator)navView);
		}
	}
	
	private void replaceLabelProvider(AadlNavigator aadlNavigator) {
		final TreeViewer navViewer = aadlNavigator.getViewer();
		if(navViewer != null) {
			if(!(navViewer.getLabelProvider() instanceof org.osate.ge.ui.navigator.LabelProvider)) {
				navViewer.setLabelProvider(new org.osate.ge.ui.navigator.LabelProvider(new AadlNavigatorLabelProvider(
						new WorkbenchLabelProvider(), aadlNavigator.getPlugin().getWorkbench().getDecoratorManager().getLabelDecorator())));
			}
		}
	}
}
	