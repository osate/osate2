package edu.uah.rsesc.aadl.age.xtext;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.model.IXtextModelListener;

public class AgeXtextUtil {
	
	public static class Initializer  implements IStartup {
		private static final DelegatingXtextModelListener modelListener = new DelegatingXtextModelListener();
		
		public void earlyStartup() {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					System.out.println("START");
					
					// TODO: This only works for the active page?
					final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					activePage.addPartListener(new EditorListener(activePage, modelListener));
				}
			});
		}
		
		public static void addModeListener(IXtextModelListener listener) {
			modelListener.addListener(listener);
		}
		
		public static void removeModeListener(IXtextModelListener listener) {
			modelListener.removeListener(listener);
		}
	}
}