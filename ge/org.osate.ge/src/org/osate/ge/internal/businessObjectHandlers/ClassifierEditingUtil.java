package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

public class ClassifierEditingUtil {
	public static final <ClassifierType extends Classifier> OperationBuilder<ClassifierType> selectClassifier(
			final OperationBuilder<?> operation, final List<ClassifierType> potentialClassifiers) {
		return operation.supply(() -> {
			// Determine which classifier should own the new element
			final ClassifierType selectedClassifier = (ClassifierType) ClassifierEditingUtil
					.getClassifierToModify(potentialClassifiers);
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
	public static <ClassifierType extends Classifier> List<ClassifierType> getPotentialClassifiersForEditing(
			final Object bo, final Class<ClassifierType> classifierClass, final Predicate<ClassifierType> filter,
			final boolean includeAllWhenBoIsMatch) {
		if (!includeAllWhenBoIsMatch) {
			if (classifierClass.isInstance(bo)) {
				final ClassifierType classifier = classifierClass.cast(bo);
				if (filter.test(classifier)) {
					return Collections.singletonList(classifier);
				}
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

	public static <ClassifierType extends Classifier> ClassifierType getClassifierToModify(
			final List<ClassifierType> potentialClassifiers) {
		return getClassifierToModify(potentialClassifiers, false);
	}

	/**
	 * Returns the classifier from the specified list which should be modified. If there are multiple classifiers in the specified list,
	 * the user will be prompted to select one. The first element will be the default. Must be called from the UI thread.
	 * @param potentialClassifiers must have at least one element. If empty, an exception will be thrown.
	 * @return the classifier to modify. Will return null if the user cancels the selection prompt.
	 */
	@SuppressWarnings("unchecked")
	public static <ClassifierType extends Classifier> ClassifierType getClassifierToModify(
			final List<ClassifierType> potentialClassifiers,
			final boolean forcePrompt) {
		if (potentialClassifiers.isEmpty()) {
			throw new RuntimeException("potentialClassifiers is empty");
		}

		// Determine which classifier should own the new element
		final ClassifierType selectedClassifier;
		if (forcePrompt || potentialClassifiers.size() > 1) {
			// Prompt the user for the classifier
			final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(),
					"Select a Classifier to Modify", "Select a classifier to modify.", potentialClassifiers);
			dlg.setInitialSelections(new Object[] { potentialClassifiers.get(0) });
			if (dlg.open() == Window.CANCEL) {
				return null;
			}

			selectedClassifier = (ClassifierType) dlg.getFirstSelectedElement();
		} else {
			selectedClassifier = potentialClassifiers.get(0);
		}

		return selectedClassifier;
	}

	public static boolean isSubcomponentWithoutClassifier(final Object bo) {
		if (bo instanceof Subcomponent) {
			return ((Subcomponent) bo).getAllClassifier() == null;
		}

		return false;
	}

	public static boolean isSubcomponentOrFeatureGroupWithoutClassifier(final Object bo) {
		if (bo instanceof Subcomponent) {
			return ((Subcomponent) bo).getAllClassifier() == null;
		} else if (bo instanceof FeatureGroup) {
			return ((FeatureGroup) bo).getAllFeatureGroupType() == null;
		}

		return false;
	}

	/**
	 * Returns true if the element was a subcomponent or feature group without classifier and the error was shown.
	 * @param bo
	 * @return
	 */
	public static boolean showMessageIfSubcomponentOrFeatureGroupWithoutClassifier(final Object bo,
			final String secondaryMsg) {
		final boolean showMsg = isSubcomponentOrFeatureGroupWithoutClassifier(bo);
		if (ClassifierEditingUtil.isSubcomponentOrFeatureGroupWithoutClassifier(bo)) {
			final String targetDescription = bo instanceof NamedElement
					? ("The element '" + ((NamedElement) bo).getQualifiedName() + "'")
							: "The target element";
					MessageDialog.openError(Display.getDefault().getActiveShell(), "Classifier Not Set",
							targetDescription + " does not have a classifier. " + secondaryMsg);
		}

		return showMsg;
	}
}
