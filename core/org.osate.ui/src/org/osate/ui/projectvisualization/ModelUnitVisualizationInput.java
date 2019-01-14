package org.osate.ui.projectvisualization;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.osate.aadl2.Aadl2Package;

import com.google.common.collect.Lists;
import com.google.inject.Injector;

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

	static ModelUnitVisualizationInput create(IProject project) {
		List<IEObjectDescription> scopedModelUnits = new ArrayList<>();
		Map<IEObjectDescription, Set<IEObjectDescription>> referencingModelUnits = new HashMap<>();
		Map<IEObjectDescription, Set<IEObjectDescription>> referencedModelUnits = new HashMap<>();
		IResourceDescriptions resourceDescriptions = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("dummy.aadl")).get(Injector.class)
				.getInstance(IResourceDescriptions.class);
		Map<URI, IEObjectDescription> eObjectDescriptions = StreamSupport
				.stream(resourceDescriptions.getExportedObjectsByType(Aadl2Package.eINSTANCE.getModelUnit())
						.spliterator(), false)
				.collect(Collectors.toMap(IEObjectDescription::getEObjectURI, Function.identity()));
		for (IResourceDescription resourceDescription : resourceDescriptions.getAllResourceDescriptions()) {
			URI resourceURI = resourceDescription.getURI();
			if (resourceURI.fileExtension().equalsIgnoreCase("aadl")
					&& resourceURI.toString().startsWith("platform:/resource/" + project.getName() + "/")) {
				List<IEObjectDescription> modelUnits = Lists.newArrayList(
						resourceDescription.getExportedObjectsByType(Aadl2Package.eINSTANCE.getModelUnit()));
				if (modelUnits.size() == 1) {
					IEObjectDescription sourceModelUnit = modelUnits.get(0);
					scopedModelUnits.add(sourceModelUnit);
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
	Object[] getGraphElements() {
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
	Object[] getConnectedTo(Object entity) {
		return referencedModelUnits.getOrDefault(entity, Collections.emptySet()).toArray();
	}

	@Override
	String getText(Object element) {
		if (element instanceof IEObjectDescription) {
			return ((IEObjectDescription) element).getName().toString("::");
		} else {
			return null;
		}
	}
}