package org.osate.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.builder.IXtextBuilderParticipant;

public class AadlProjectBuilderParticipant implements IXtextBuilderParticipant {
	private final static String MARKER_ID = "org.osate.core.cyclicreferencemarker";
	
	@Override
	public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
		IProject project = context.getBuiltProject();
		project.deleteMarkers(MARKER_ID, false, IResource.DEPTH_ZERO);
		if (context.getBuildType() != BuildType.CLEAN) {
			List<IProject> cycle = getCyclicReference(project, new HashSet<>());
			if (!cycle.isEmpty() && cycle.get(0).equals(project)) {
				Collections.reverse(cycle);
				String cycleString = cycle.stream().map(IResource::getName).collect(Collectors.joining(" -> "));
				IMarker marker = project.createMarker(MARKER_ID);
				marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
				marker.setAttribute(IMarker.MESSAGE, "Cycle found in project references: " + cycleString);
			}
		}
	}
	
	private List<IProject> getCyclicReference(IProject current, Set<IProject> visited) throws CoreException {
		if (visited.contains(current)) {
			List<IProject> path = new ArrayList<>();
			path.add(current);
			return path;
		}
		visited.add(current);
		for (IProject next : current.getReferencedProjects()) {
			if (next.isAccessible()) {
				List<IProject> path = getCyclicReference(next, visited);
				if (!path.isEmpty()) {
					path.add(current);
					return path;
				}
			}
		}
		visited.remove(current);
		return Collections.emptyList();
	}
}