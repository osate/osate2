/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
import java.util.Collections;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.elk.graph.ElkNode;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osate.ge.internal.GraphicalEditorException;

/**
 * Utility class for debugging layout issues. Functions are no-op unless the enabled flag is true.
 * The flag is intended to be enabled while debugging layout issues and then disabled before being committed.
 */
final class LayoutDebugUtil {
	private LayoutDebugUtil() {
	}

	private static final boolean SAVE_GRAPH_ENABLED = false;
	private static final String MAGIC_PROJECT_NAME = "__osate_ge_debug";

	/**
	 * When {@link #SAVE_GRAPH_ENABLED} is true, saves the ELK graph to a file in the {@link #MAGIC_PROJECT_NAME} project.
	 * @param g the graph to safe
	 * @param suffix an identifier to add to the name of the file.
	 */
	public static void saveElkGraphToDebugProject(final ElkNode g, final String suffix) {
		if (SAVE_GRAPH_ENABLED) {
			final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(MAGIC_PROJECT_NAME);
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
					throw new GraphicalEditorException(e);
				}
			}
		}
	}
}
