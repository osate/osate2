package org.osate.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

public class Startup implements IStartup {

	@Override
	public void earlyStartup() {
		final IWorkbench workbench = PlatformUI.getWorkbench();
		workbench.getDisplay().asyncExec(new Runnable() {
			public void run() {
				IDecoratorManager mgr = workbench.getDecoratorManager();
				try {
					mgr.setEnabled("org.eclipse.xtext.builder.nature.overlay", false);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		});
	}

}
