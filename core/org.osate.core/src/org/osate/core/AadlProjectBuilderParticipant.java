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