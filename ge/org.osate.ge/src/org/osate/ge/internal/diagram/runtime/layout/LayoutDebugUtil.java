/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
	private static final boolean enabled = false;
	private static final String magicProjectName = "__osate_ge_debug";

	static void saveElkGraphToDebugProject(final ElkNode g, final String suffix) {
		if (enabled) {
			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(magicProjectName);
			if (project != null && project.exists()) {
				final URI uri = URI
						.createPlatformResourceURI(
								project.getFile("layout_graph_" + suffix + ".elkg").getFullPath().toString(), true);

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
