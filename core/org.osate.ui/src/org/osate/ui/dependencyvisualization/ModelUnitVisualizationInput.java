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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.osate.aadl2.Aadl2Package;

class ModelUnitVisualizationInput extends AbstractVisualizationInput<IEObjectDescription> {
	private final Map<IEObjectDescription, Set<IEObjectDescription>> referencingModelUnits;
	private final Map<IEObjectDescription, Set<IEObjectDescription>> referencedModelUnits;

	private ModelUnitVisualizationInput(List<IEObjectDescription> scopedModelUnits,
			Map<IEObjectDescription, Set<IEObjectDescription>> referencingModelUnits,
			Map<IEObjectDescription, Set<IEObjectDescription>> referencedModelUnits) {
		super(scopedModelUnits);
		this.referencingModelUnits = referencingModelUnits;
		this.referencedModelUnits = referencedModelUnits;
	}

	static ModelUnitVisualizationInput create(IResourceDescriptions resourceDescriptions) {
		return create(resourceDescriptions, (resourceURI, modelUnit) -> resourceURI.isPlatformResource());
	}

	static ModelUnitVisualizationInput create(IResourceDescriptions resourceDescriptions, IWorkingSet workingSet) {
		List<String> projectLocations = Arrays.stream(workingSet.getElements())
				.map(adaptable -> Adapters.adapt(adaptable, IProject.class))
				.filter(project -> project != null && project.isOpen())
				.map(project -> project.getLocation().toString() + "/").collect(Collectors.toList());
		return create(resourceDescriptions, (resourceURI, modelUnit) -> {
			if (resourceURI.isPlatformResource()) {
				String resourceLocation = ResourcesPlugin.getWorkspace().getRoot()
						.findMember(resourceURI.toPlatformString(true)).getLocation().toString();
				return projectLocations.stream()
						.anyMatch(projectLocation -> resourceLocation.startsWith(projectLocation));
			} else {
				return false;
			}
		});
	}

	static ModelUnitVisualizationInput create(IResourceDescriptions resourceDescriptions, IProject project) {
		String projectLocation = project.getLocation().toString() + "/";
		return create(resourceDescriptions, (resourceURI, modelUnit) -> {
			if (resourceURI.isPlatformResource()) {
				String resourceLocation = ResourcesPlugin.getWorkspace().getRoot()
						.findMember(resourceURI.toPlatformString(true)).getLocation().toString();
				return resourceLocation.startsWith(projectLocation);
			} else {
				return false;
			}
		});
	}

	static ModelUnitVisualizationInput create(IResourceDescriptions resourceDescriptions, URI focusedModelUnit) {
		return create(resourceDescriptions,
				(resourceURI, modelUnit) -> modelUnit.getEObjectURI().equals(focusedModelUnit));
	}

	private static ModelUnitVisualizationInput create(IResourceDescriptions resourceDescriptions,
			BiPredicate<URI, IEObjectDescription> isInScope) {
		List<IEObjectDescription> scopedModelUnits = new ArrayList<>();
		Map<IEObjectDescription, Set<IEObjectDescription>> referencingModelUnits = new HashMap<>();
		Map<IEObjectDescription, Set<IEObjectDescription>> referencedModelUnits = new HashMap<>();
		Map<URI, IEObjectDescription> eObjectDescriptions = StreamSupport
				.stream(resourceDescriptions.getExportedObjectsByType(Aadl2Package.eINSTANCE.getModelUnit())
						.spliterator(), false)
				.collect(Collectors.toMap(IEObjectDescription::getEObjectURI, Function.identity()));
		for (IResourceDescription resourceDescription : resourceDescriptions.getAllResourceDescriptions()) {
			URI resourceURI = resourceDescription.getURI();
			if (resourceURI.fileExtension().equals("aadl")) {
				for (IEObjectDescription sourceModelUnit : resourceDescription
						.getExportedObjectsByType(Aadl2Package.eINSTANCE.getModelUnit())) {
					if (isInScope.test(resourceURI, sourceModelUnit)) {
						scopedModelUnits.add(sourceModelUnit);
					}
					for (IReferenceDescription referenceDescription : resourceDescription.getReferenceDescriptions()) {
						EReference eReference = referenceDescription.getEReference();
						if (eReference.equals(Aadl2Package.eINSTANCE.getPackageSection_ImportedUnit())
								|| eReference.equals(Aadl2Package.eINSTANCE.getPropertySet_ImportedUnit())) {
							IEObjectDescription targetModelUnit = eObjectDescriptions
									.get(referenceDescription.getTargetEObjectUri());
							addToSet(referencingModelUnits, targetModelUnit, sourceModelUnit);
							addToSet(referencedModelUnits, sourceModelUnit, targetModelUnit);
						}
					}
				}
			}
		}
		return new ModelUnitVisualizationInput(scopedModelUnits, referencingModelUnits, referencedModelUnits);
	}

	private static <K, V> void addToSet(Map<K, Set<V>> map, K key, V value) {
		Set<V> set = map.get(key);
		if (set == null) {
			set = new LinkedHashSet<>();
			map.put(key, set);
		}
		set.add(value);
	}

	@Override
	public Object[] getGraphElements() {
		Set<IEObjectDescription> allModelUnits = new LinkedHashSet<>();
		for (IEObjectDescription modelUnit : scopedElements) {
			allModelUnits.add(modelUnit);
			traverseDependencies(modelUnit, allModelUnits, dependency -> true,
					dependency -> referencingModelUnits.getOrDefault(dependency, Collections.emptySet()));
			traverseDependencies(modelUnit, allModelUnits, dependency -> true,
					dependency -> referencedModelUnits.getOrDefault(dependency, Collections.emptySet()));
		}
		return allModelUnits.toArray();
	}

	@Override
	public Object[] getConnectedTo(Object entity) {
		return referencedModelUnits.getOrDefault(entity, Collections.emptySet()).toArray();
	}

	@Override
	public Stream<IEObjectDescription> getConnectedToBothDirections(Object entity) {
		Set<IEObjectDescription> referencing = referencingModelUnits.getOrDefault(entity, Collections.emptySet());
		Set<IEObjectDescription> referenced = referencedModelUnits.getOrDefault(entity, Collections.emptySet());
		return Stream.concat(referencing.stream(), referenced.stream());
	}
}