/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.alisa.common.ui.builder;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.clustering.CopiedResourceDescription;
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution;
import org.eclipse.xtext.builder.impl.ToBeBuilt;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;

import com.google.inject.Inject;

@SuppressWarnings("restriction")
public class AlisaToBeBuiltComputer implements IToBeBuiltComputerContribution {
	@Inject
	protected IBuilderState builderState;
	@Inject
	protected IStorage2UriMapper mapper;

	@Override
	public void removeProject(final ToBeBuilt toBeBuilt, final IProject project, final IProgressMonitor monitor) {
	}

	@Override
	public void updateProject(final ToBeBuilt toBeBuilt, final IProject project, final IProgressMonitor monitor)
			throws CoreException {
	}

	@Override
	public boolean removeStorage(final ToBeBuilt toBeBuilt, final IStorage storage, final IProgressMonitor monitor) {
		if (!isAlisaResource(storage)) {
			return false;
		}
		toBeBuilt.getToBeUpdated().addAll(dependencies(storage));
		toBeBuilt.getToBeDeleted().add(mapper.getUri(storage));
		return true;
	}

	@Override
	public boolean updateStorage(final ToBeBuilt toBeBuilt, final IStorage storage, final IProgressMonitor monitor) {
		if (!isAlisaResource(storage)) {
			return false;
		}
		toBeBuilt.getToBeUpdated().addAll(dependencies(storage));
		toBeBuilt.getToBeUpdated().add(mapper.getUri(storage));
		return true;
	}

	@Override
	public boolean isPossiblyHandled(final IStorage storage) {
		return this.isAlisaResource(storage);
	}

	@Override
	public boolean isRejected(final IFolder folder) {
		return false;
	}

	private HashSet<URI> dependencies(final IStorage storage) {
		var dependencyCache = new HashMap<URI, HashSet<URI>>();
		// Direct dependencies.
		for (var description : builderState.getAllResourceDescriptions()) {
			// Avoid IllegalStateException from CopiedResourceDescription.getReferenceDescriptions().
			if (isAlisaResource(description.getURI()) && !(description instanceof CopiedResourceDescription)) {
				var sourceUri = description.getURI();
				for (var reference : description.getReferenceDescriptions()) {
					var targetUri = reference.getTargetEObjectUri().trimFragment();
					if (isAlisaResource(targetUri)) {
						var dependencies = dependencyCache.get(targetUri);
						if (dependencies == null) {
							dependencies = new HashSet<>();
							dependencyCache.put(targetUri, dependencies);
						}
						dependencies.add(sourceUri);
					}
				}
			}
		}

		var dependencies = new HashSet<URI>();
		var uri = mapper.getUri(storage);
		if (uri != null) {
			dependencies.addAll(dependencyCache.getOrDefault(uri, new HashSet<>()));
			var changed = !dependencies.isEmpty();
			while (changed) {
				var newDependencies = new HashSet<URI>();
				for (var dependency : dependencies) {
					newDependencies.addAll(dependencyCache.getOrDefault(dependency, new HashSet<>()));
				}
				changed = dependencies.addAll(newDependencies);
			}
		}
		return dependencies;
	}

	private boolean isAlisaResource(final IStorage storage) {
		var uri = mapper.getUri(storage);
		return uri != null && isAlisaResource(uri);
	}

	private boolean isAlisaResource(final URI uri) {
		return this.isAlisaResource(uri.fileExtension());
	}

	public boolean isAlisaResource(final String ext) {
		return Set
				.of("cat", "filter", "org", "verify", "methodregistry", "constants", "goals", "goaldoc", "reqspec",
						"reqdoc", "alisa", "aadl")
				.contains(ext);
	}
}
