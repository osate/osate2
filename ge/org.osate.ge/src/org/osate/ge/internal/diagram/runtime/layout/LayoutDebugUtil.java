package org.osate.ge.internal.diagram.runtime.layout;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PlatformUI;

/**
 * Helper class for debugging layout issues. Functions are no-op unless the enabled flag is true.
 * If this is used regularly, this should likely be switched to use a preference.
 */
class LayoutDebugUtil {
	private static final boolean enabled = true;// false;
	private static final String magicProjectName = "__osate_ge_debug";

	static void saveElkGraphToDebugProject(final ElkNode g) {
		if (enabled) {
			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(magicProjectName);
			if (project != null && project.exists()) {
				final URI uri = URI
						.createPlatformResourceURI(project.getFile("layout_graph.elkg").getFullPath().toString(), true);

				// Save the resource
				final ResourceSet rs = new ResourceSetImpl();
				final Resource resource = rs.createResource(uri);
				resource.getContents().add(g);
				try {
					resource.save(Collections.emptyMap());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	static void showGraphInLayoutGraphView(final ElkNode n) {
		if (enabled) {
			Display.getCurrent().syncExec(() -> {
				try {
					final IViewPart viewPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
							.showView("org.eclipse.elk.debug.graphView");
					if (viewPart != null) {
						final Method updateWithGraphMethod = viewPart.getClass().getMethod("updateWithGraph",
								ElkNode.class);
						updateWithGraphMethod.invoke(null, n);
					}
				} catch (final Exception e) {
					e.printStackTrace();
				}
			});
		}
	}
}
