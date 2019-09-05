package org.osate.ge.internal.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.internal.ui.dialogs.ElementSelectionDialog;
import org.osate.ge.operations.OperationBuilder;
import org.osate.ge.operations.StepResult;

public class EditingUtil {
	public static final <ClassifierType extends Classifier> OperationBuilder<ClassifierType> selectClassifier(
			final OperationBuilder<?> operation, final List<ClassifierType> potentialClassifiers) {
		return operation.supply(() -> {
			// Determine which classifier should own the new element
			final ClassifierType selectedClassifier = (ClassifierType) EditingUtil
					.getBusinessObjectToModify(potentialClassifiers);
			if (selectedClassifier == null) {
				return StepResult.abort();
			}

			return StepResult.forValue(selectedClassifier);
		});
	}

	/**
	 * Returns a list of classifiers for editing based on a specified business object.
	 * If the specified object is of the specified type and passes the filter, only it is returned.
	 * @param bo
	 * @return
	 */
	public static <ClassifierType> List<ClassifierType> getPotentialClassifiersForEditing(
			final Object bo, final Class<ClassifierType> classifierClass, final Predicate<ClassifierType> filter,
			final boolean includeAllWhenBoIsMatch) {
		if (!includeAllWhenBoIsMatch) {
			if (matches(bo, classifierClass, filter)) {
				return Collections.singletonList(classifierClass.cast(bo));
			}
		}

		final List<ClassifierType> results = new ArrayList<>();

		if (bo instanceof ComponentType || bo instanceof FeatureGroupType) {
			addSelfAndExtended((Classifier) bo, classifierClass, results);
		} else if (bo instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation) bo;
			addSelfAndExtended(ci, classifierClass, results);
			addSelfAndExtended(ci.getType(), classifierClass, results);
		} else if (bo instanceof Subcomponent) {
			final ComponentClassifier subcomponentClassifier = ((Subcomponent) bo).getAllClassifier();
			addSelfAndExtended(subcomponentClassifier, classifierClass, results);
			if (subcomponentClassifier instanceof ComponentImplementation) {
				addSelfAndExtended(((ComponentImplementation) subcomponentClassifier).getType(), classifierClass,
						results);
			}
		} else if (bo instanceof FeatureGroup) {
			final FeatureGroupType fgType = ((FeatureGroup) bo).getAllFeatureGroupType();
			addSelfAndExtended(fgType, classifierClass, results);
		}

		return results.stream().filter(c -> classifierClass.isInstance(c)).map(classifierClass::cast).filter(filter)
				.collect(Collectors.toList());
	}

	public static <ClassifierType extends Classifier> List<ClassifierType> getPotentialClassifiersForEditing(
			final Object bo, final Class<ClassifierType> classifierClass, final Predicate<ClassifierType> filter) {
		return getPotentialClassifiersForEditing(bo, classifierClass, filter, false);
	}

	/**
	 * Returns a list of component types and feature group types for editing based on a specified business object.
	 * If the specified object is a classifier type, only it is returned.
	 * @param bo
	 * @return
	 */
	public static List<Classifier> getPotentialClassifierTypesForEditing(final Object bo,
			final Predicate<Classifier> filter) {
		if (bo instanceof ComponentType || bo instanceof FeatureGroupType && filter.test((Classifier) bo)) {
			return Collections.singletonList((Classifier) bo);
		}

		final Predicate<Classifier> classifierTypeFilter = c -> c instanceof ComponentType
				|| c instanceof FeatureGroupType;
		return getPotentialClassifiersForEditing(bo, Classifier.class, classifierTypeFilter.and(filter));
	}

	public static List<Classifier> getPotentialClassifierTypesForEditing(final Object bo) {
		return getPotentialClassifierTypesForEditing(bo, c -> true);
	}

	private static <ClassifierType> void addSelfAndExtended(final Classifier c,
			final Class<ClassifierType> classifierClass, final List<ClassifierType> results) {
		if (c != null) {
			for (final Classifier tmpClassifier : c.getSelfPlusAllExtended()) {
				if (classifierClass.isInstance(tmpClassifier)) {
					results.add(classifierClass.cast(tmpClassifier));
				}
			}
		}
	}

	public static List<ComponentClassifier> getPotentialComponentClassifiers(final Object bo,
			final Predicate<ComponentClassifier> filter) {
		return getPotentialClassifiersForEditing(bo, ComponentClassifier.class, filter);
	}

	public static List<ComponentClassifier> getPotentialComponentClassifiers(final Object bo) {
		return getPotentialComponentClassifiers(bo, cc -> true);
	}

	public static <BusinessObjectType> BusinessObjectType getBusinessObjectToModify(
			final List<BusinessObjectType> potentialBusinessObjects) {
		return getBusinessObjectToModify(potentialBusinessObjects, false);
	}

	/**
	 * Returns the business object from the specified list which should be modified. If there are multiple objects in the specified list,
	 * the user will be prompted to select one. The first element will be the default. Must be called from the UI thread.
	 * @param potentialBusinessObjects must have at least one element. If empty, an exception will be thrown.
	 * @return the object to modify. Will return null if the user cancels the selection prompt.
	 */
	@SuppressWarnings("unchecked")
	public static <BusinessObjectType> BusinessObjectType getBusinessObjectToModify(
			final List<BusinessObjectType> potentialBusinessObjects,
			final boolean forcePrompt) {
		if (potentialBusinessObjects.isEmpty()) {
			throw new RuntimeException("potentialBusinessObjects is empty");
		}

		// Determine which business object should be modified
		final BusinessObjectType selectedBo;
		if (forcePrompt || potentialBusinessObjects.size() > 1) {
			// Prompt the user for the classifier
			final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(),
					"Select an Element to Modify", "Select an element to modify.", potentialBusinessObjects);
			dlg.setInitialSelections(new Object[] { potentialBusinessObjects.get(0) });
			if (dlg.open() == Window.CANCEL) {
				return null;
			}

			selectedBo = (BusinessObjectType) dlg.getFirstSelectedElement();
		} else {
			selectedBo = potentialBusinessObjects.get(0);
		}

		return selectedBo;
	}

	public static <ClassifierType> boolean isSubcomponentWithoutClassifier(final Object bo) {
		if (bo instanceof Subcomponent) {
			return ((Subcomponent) bo).getAllClassifier() == null;
		}

		return false;
	}

	public static <ClassifierType> boolean isFeatureGroupWithoutClassifier(final Object bo) {
		if (bo instanceof FeatureGroup) {
			return ((FeatureGroup) bo).getAllClassifier() == null;
		}

		return false;
	}

	public static <ClassifierType> boolean isSubcomponentOrFeatureGroupWithoutClassifier(final Object bo) {
		return isSubcomponentWithoutClassifier(bo) || isFeatureGroupWithoutClassifier(bo);
	}

	/**
	 * Returns true if the element was a subcomponent or feature group without classifier and the error was shown.
	 * @param bo
	 * @return
	 */
	public static boolean showMessageIfSubcomponentOrFeatureGroupWithoutClassifier(final Object bo,
			final String secondaryMsg) {
		final boolean showMsg = isSubcomponentOrFeatureGroupWithoutClassifier(bo);
		if (showMsg) {
			final String targetDescription = bo instanceof NamedElement
					? ("The element '" + ((NamedElement) bo).getQualifiedName() + "'")
							: "The target element";
					MessageDialog.openError(Display.getDefault().getActiveShell(), "Classifier Not Set",
							targetDescription + " does not have a classifier. " + secondaryMsg);
		}

		return showMsg;
	}

	/**
	 * Returns true if the specified object is of the specified class and passes the specified filter.
	 * @param bo
	 * @param targetClass
	 * @param filter
	 * @return
	 */
	public static <BusinessObjectType> boolean matches(final Object bo, final Class<BusinessObjectType> targetClass,
			final Predicate<BusinessObjectType> filter) {
		if (!targetClass.isInstance(bo)) {
			return false;
		}

		final BusinessObjectType targetBo = targetClass.cast(bo);
		return filter.test(targetBo);
	}

	/**
	 * Returning an optional describing the resource set in which the object's resource is contained. Returns empty optional if the object, the resource, or the resource set is null.
	 */
	private static Optional<ResourceSet> getResourceSet(final EObject obj) {
		return Optional.ofNullable(obj).flatMap(eobj -> Optional.ofNullable(eobj.eResource()))
				.flatMap(r -> Optional.ofNullable(r.getResourceSet()));
	}

	/**
	 * Returns true if and only if the specified list contains at least one business object and all business objects are contained in the the same valid resource set.
	 */
	public static boolean allHaveSameValidResourceSet(final List<? extends EObject> bos) {
		if(bos.size() == 0) {
			return false;
		}

		final Optional<ResourceSet> firstResourceSet = getResourceSet(bos.get(0));
		if (!firstResourceSet.isPresent()) {
			return false;
		}

		return bos.stream().allMatch(bo -> EditingUtil.getResourceSet(bo).equals(firstResourceSet));
	}

	/**
	 * Attempts to return a resolved version of the specified EObject.
	 * If the specified EObject is not a proxy, it returns the EObject. If the specified EObject is a proxy,
	 * it attempts to resolve the proxy using a live resource set for the specified project and returns the result.
	 */
	public static EObject resolveWithLiveResourceSetIfProject(final EObject obj, final IProject project) {
		if (obj.eIsProxy()) {
			final ResourceSet liveResourceSet = ProjectUtil.getLiveResourceSet(project);
			return EcoreUtil.resolve(obj, liveResourceSet);
		} else {
			return obj;
		}
	}
}
