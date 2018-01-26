package org.osate.ge.internal.businessObjectHandlers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
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

public class ClassifierEditingUtil {
	/**
	 * Returns a list of component types and feature group types for editing based on a specified business object.
	 * If the specified object is a component type, only it is returned.
	 * @param bo
	 * @return
	 */
	public static List<Classifier> getPotentialClassifierTypesForEditing(final EObject bo) {
		final List<Classifier> results = new ArrayList<>();

		// Retrieve relevant component types
		if (bo instanceof ComponentType || bo instanceof FeatureGroupType) {
			// If the bo is a classifier type, just return it.
			results.add((Classifier) bo);
		} else if (bo instanceof ComponentImplementation) {
			final ComponentType ct = ((ComponentImplementation) bo).getType();
			addSelfAndExtendedClassifierTypes(ct, results);
		} else if (bo instanceof Subcomponent) {
			final ComponentType subcomponentClassifier = ((Subcomponent) bo).getComponentType();
			addSelfAndExtendedClassifierTypes(subcomponentClassifier, results);
		} else if (bo instanceof FeatureGroup) {
			final FeatureGroupType fgType = ((FeatureGroup) bo).getFeatureGroupType();
			addSelfAndExtendedClassifierTypes(fgType, results);
		}

		return results;
	}

	private static void addSelfAndExtendedClassifierTypes(final Classifier c,
			final List<Classifier> results) {
		if (c != null) {
			for (final Classifier tmpClassifier : c.getSelfPlusAllExtended()) {
				if (tmpClassifier instanceof ComponentType || tmpClassifier instanceof FeatureGroupType) {
					results.add((Classifier) tmpClassifier);
				}
			}
		}
	}

	/**
	 * Returns a list of component classifiers for editing based on a specified business object.
	 * If the specified object is a component classifier, only it is returned.
	 * @param bo
	 * @return
	 */
	public static List<ComponentClassifier> getPotentialComponentClassifiersForEditing(final EObject bo) {
		final List<ComponentClassifier> results = new ArrayList<>();

		// Retrieve relevant component types
		if (bo instanceof ComponentType || bo instanceof ComponentImplementation) {
			// If the bo is a classifier type or implementation, just return it.
			results.add((ComponentClassifier) bo);
		} else if (bo instanceof Subcomponent) {
			final ComponentClassifier subcomponentClassifier = ((Subcomponent) bo).getClassifier();
			addComponentClassifierAndExtended(subcomponentClassifier, results);
			if (subcomponentClassifier instanceof ComponentImplementation) {
				addComponentClassifierAndExtended(
						((ComponentImplementation) subcomponentClassifier).getType(), results);
			}
		}

		return results;
	}

	private static void addComponentClassifierAndExtended(final ComponentClassifier c,
			final List<ComponentClassifier> results) {
		if (c != null) {
			for (final Classifier tmpClassifier : c.getSelfPlusAllExtended()) {
				if (tmpClassifier instanceof ComponentClassifier) {
					results.add((ComponentClassifier) tmpClassifier);
				}
			}
		}
	}

	public static Classifier getClassifierToModify(final List<? extends Classifier> potentialClassifiers) {
		return getClassifierToModify(potentialClassifiers, false);
	}

	/**
	 * Returns the classifier from the specified list which should be modified. If there are multiple classifiers in the specified list,
	 * the user will be prompted to select one. The first element will be the default. Must be called from the UI thread.
	 * @param potentialClassifiers must have at least one element. If empty, an exception will be thrown.
	 * @return the classifier to modify. Will return null if the user cancels the selection prompt.
	 */
	public static Classifier getClassifierToModify(final List<? extends Classifier> potentialClassifiers,
			final boolean forcePrompt) {
		if (potentialClassifiers.isEmpty()) {
			throw new RuntimeException("potentialClassifiers is empty");
		}

		// Determine which classifier should own the new element
		final Classifier selectedClassifier;
		if (forcePrompt || potentialClassifiers.size() > 1) {
			// Prompt the user for the classifier
			final ElementSelectionDialog dlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(),
					"Select a Classifier to Modify", "Select a classifier to modify.", potentialClassifiers);
			dlg.setInitialSelections(new Object[] { potentialClassifiers.get(0) });
			if (dlg.open() == Window.CANCEL) {
				return null;
			}

			selectedClassifier = (Classifier) dlg.getFirstSelectedElement();
		} else {
			selectedClassifier = potentialClassifiers.get(0);
		}

		return selectedClassifier;
	}

	public static boolean isSubcomponentOrFeatureGroupWithoutClassifier(final Object bo) {
		if (bo instanceof Subcomponent) {
			return ((Subcomponent) bo).getClassifier() == null;
		} else if (bo instanceof FeatureGroup) {
			return ((FeatureGroup) bo).getFeatureGroupType() == null;
		}

		return false;
	}

	/**
	 * Returns true if the element was a subcomponent or feature group without classifier and the error was showing.
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
					MessageDialog.openError(Display.getDefault().getActiveShell(), "Classifier Not Set", targetDescription
							+ " does not have a classifier. " + secondaryMsg);
		}

		return showMsg;
	}
}
