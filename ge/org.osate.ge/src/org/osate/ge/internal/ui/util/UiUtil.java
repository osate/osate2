package org.osate.ge.internal.ui.util;

import java.util.List;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;

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

	public static AgeDiagram getDiagram(final List<DiagramElement> elements) {
		if (elements.size() == 0) {
			return null;
		}
	
		final AgeDiagram firstDiagram = UiUtil.getDiagram(elements.get(0));
		if (!elements.stream().allMatch(e -> UiUtil.getDiagram(e) == firstDiagram)) {
			return null;
		}
	
		return firstDiagram;
	}

	public static AgeDiagram getDiagram(final DiagramElement de) {
		for (DiagramNode dn = de; dn != null; dn = dn.getParent()) {
			if (dn instanceof AgeDiagram) {
				return (AgeDiagram) dn;
			}
		}
		return null;
	}
}
