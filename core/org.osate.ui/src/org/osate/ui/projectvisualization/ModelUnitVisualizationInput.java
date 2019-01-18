package org.osate.ui.projectvisualization;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Adapters;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.osate.aadl2.Aadl2Package;
import org.osate.ui.OsateUiPlugin;

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

	static ModelUnitVisualizationInput create(Shell shell) {
		return create(shell, (resourceURI, modelUnit) -> resourceURI.isPlatformResource());
	}

	static ModelUnitVisualizationInput create(Shell shell, IWorkingSet workingSet) {
		List<String> projectLocations = Arrays.stream(workingSet.getElements())
				.map(adaptable -> Adapters.adapt(adaptable, IProject.class))
				.filter(project -> project != null && project.isOpen())
				.map(project -> project.getLocation().toString() + "/").collect(Collectors.toList());
		return create(shell, (resourceURI, modelUnit) -> {
			if (resourceURI.isPlatformResource()) {
				String resourceLoaction = ResourcesPlugin.getWorkspace().getRoot()
						.findMember(resourceURI.toPlatformString(true)).getLocation().toString();
				return projectLocations.stream()
						.anyMatch(projectLocation -> resourceLoaction.startsWith(projectLocation));
			} else {
				return false;
			}
		});
	}

	static ModelUnitVisualizationInput create(Shell shell, IProject project) {
		String projectLocation = project.getLocation().toString() + "/";
		return create(shell, (resourceURI, modelUnit) -> {
			if (resourceURI.isPlatformResource()) {
				String resourceLocation = ResourcesPlugin.getWorkspace().getRoot()
						.findMember(resourceURI.toPlatformString(true)).getLocation().toString();
				return resourceLocation.startsWith(projectLocation);
			} else {
				return false;
			}
		});
	}

	static ModelUnitVisualizationInput create(Shell shell, URI focusedModelUnit) {
		return create(shell, (resourceURI, modelUnit) -> modelUnit.getEObjectURI().equals(focusedModelUnit));
	}

	private static ModelUnitVisualizationInput create(Shell shell, BiPredicate<URI, IEObjectDescription> isInScope) {
		AtomicReference<ModelUnitVisualizationInput> input = new AtomicReference<>();
		try {
			new ProgressMonitorDialog(shell).run(true, false, monitor -> {
				SubMonitor subMonitor = SubMonitor.convert(monitor, "Computing Dependencies", 0);
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
				List<IResourceDescription> allResourceDescriptions = Lists
						.newArrayList(resourceDescriptions.getAllResourceDescriptions());
				subMonitor.setWorkRemaining(allResourceDescriptions.size());
				for (IResourceDescription resourceDescription : allResourceDescriptions) {
					subMonitor.split(1);
					URI resourceURI = resourceDescription.getURI();
					if (resourceURI.fileExtension().equals("aadl")) {
						for (IEObjectDescription sourceModelUnit : resourceDescription
								.getExportedObjectsByType(Aadl2Package.eINSTANCE.getModelUnit())) {
							if (isInScope.test(resourceURI, sourceModelUnit)) {
								scopedModelUnits.add(sourceModelUnit);
							}
							for (IReferenceDescription referenceDescription : resourceDescription
									.getReferenceDescriptions()) {
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
				input.set(
						new ModelUnitVisualizationInput(scopedModelUnits, referencingModelUnits, referencedModelUnits));
			});
		} catch (InvocationTargetException | InterruptedException e) {
			StatusManager.getManager()
					.handle(new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID, e.getLocalizedMessage(), e));
		}
		return input.get();
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
	Stream<IEObjectDescription> getConnectedToBothDirections(Object entity) {
		Set<IEObjectDescription> referencing = referencingModelUnits.getOrDefault(entity, Collections.emptySet());
		Set<IEObjectDescription> referenced = referencedModelUnits.getOrDefault(entity, Collections.emptySet());
		return Stream.concat(referencing.stream(), referenced.stream());
	}

	@Override
	String getText(Object element) {
		if (element instanceof IEObjectDescription) {
			return ((IEObjectDescription) element).getName().toString("::");
		} else {
			return null;
		}
	}

	@Override
	String getImagePath(Object element) {
		if (element instanceof IEObjectDescription) {
			EClass eClass = ((IEObjectDescription) element).getEClass();
			if (eClass.equals(Aadl2Package.eINSTANCE.getAadlPackage())) {
				return "icons/package.gif";
			} else if (eClass.equals(Aadl2Package.eINSTANCE.getPropertySet())) {
				return "icons/properties.gif";
			}
		}
		return null;
	}
}