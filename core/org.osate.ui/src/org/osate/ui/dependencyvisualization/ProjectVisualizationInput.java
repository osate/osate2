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