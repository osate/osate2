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
package org.osate.ui.dependencyvisualization;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.ui.OsateUiPlugin;

class ProjectVisualizationInput extends AbstractVisualizationInput<IProject> {
	ProjectVisualizationInput() {
		super(Arrays.stream(ResourcesPlugin.getWorkspace().getRoot().getProjects()).filter(IProject::isOpen)
				.collect(Collectors.toList()));
	}

	ProjectVisualizationInput(IWorkingSet workingSet) {
		super(Arrays.stream(workingSet.getElements()).map(adaptable -> Adapters.adapt(adaptable, IProject.class))
				.filter(project -> project != null && project.isOpen()).collect(Collectors.toList()));
	}

	ProjectVisualizationInput(IProject project) {
		super(Collections.singletonList(project));
	}

	@Override
	public Object[] getGraphElements() {
		Set<IProject> allProjects = new LinkedHashSet<>();
		for (IProject project : scopedElements) {
			if (project.isOpen()) {
				allProjects.add(project);
				traverseDependencies(project, allProjects, IProject::isOpen, dependency -> {
					try {
						return Arrays.asList(dependency.getReferencedProjects());
					} catch (CoreException e) {
						StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
						return Collections.emptySet();
					}
				});
				traverseDependencies(project, allProjects, IProject::isOpen,
						dependency -> Arrays.asList(dependency.getReferencingProjects()));
			}
		}
		return allProjects.toArray();
	}

	@Override
	public Object[] getConnectedTo(Object entity) {
		try {
			return Arrays.stream(((IProject) entity).getReferencedProjects()).filter(IProject::isOpen).toArray();
		} catch (CoreException e) {
			StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
			return new Object[0];
		}
	}

	@Override
	public Stream<IProject> getConnectedToBothDirections(Object entity) {
		if (entity instanceof IProject) {
			IProject project = (IProject) entity;
			Stream<IProject> referenced;
			try {
				referenced = Arrays.stream(project.getReferencedProjects());
			} catch (CoreException e) {
				StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
				referenced = Stream.empty();
			}
			return Stream.concat(referenced, Arrays.stream(project.getReferencingProjects()));
		} else {
			return Stream.empty();
		}
	}
}