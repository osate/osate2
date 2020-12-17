package org.osate.ge;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.PlatformUI;
import org.osate.ge.internal.services.DiagramService;
import org.osate.ge.internal.ui.util.EditorUtil;

/**
 * @since 2.1
 */
public class DiagramCreationUtil {
	/**
	 * Create a diagram for the business object
	 * @param contextBo	the business object for which to create the diagram
	 */
	public static void createDiagram(final Object contextBo) {
		final DiagramService diagramService = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getService(DiagramService.class);
		final IFile file = diagramService.createDiagram(contextBo);
		if (file != null) {
			EditorUtil.openEditor(file, false);
		}
	}

	/**
	 * Open or create a diagram for the business object
	 * @param bo the business object for which to open/create the diagram
	 */
	public static void openOrCreateDiagram(final Object contextBo) {
		final DiagramService diagramService = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getService(DiagramService.class);
		diagramService.openOrCreateDiagramForBusinessObject(contextBo);
		return;
	}
}
