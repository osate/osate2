package org.osate.ge.internal.ui.util;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public class UiUtil {
	public static void openPropertiesView() {
		final IWorkbench wb = PlatformUI.getWorkbench();
		if (wb == null) {
			return;
		}

		final IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		if (win == null) {
			return;
		}

		final IWorkbenchPage page = win.getActivePage();
		if (page == null) {
			return;
		}

		try {
			page.showView(IPageLayout.ID_PROP_SHEET);
		} catch (final PartInitException e) {
			throw new RuntimeException(e);
		}
	}
}
