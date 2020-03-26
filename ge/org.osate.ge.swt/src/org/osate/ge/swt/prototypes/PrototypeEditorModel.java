package org.osate.ge.swt.prototypes;

import java.util.stream.Stream;

import org.osate.ge.swt.ObservableModel;

/**
 * View Model used by {@link PrototypeEditor}
 *
 * @param <C> the type used for the constraining classifier of the prototype.
 */
interface PrototypeEditorModel<C> extends ObservableModel {
	/**
	 * Returns whether the view should be enabled.
	 * @return true is the view should be enabled.
	 */
	boolean isEnabled();

	/**
	 * See {@link org.osate.ge.swt.name.NameEditorModel#getName()}
	 * @return the name of the prototype.
	 */
	String getName();

	/**
	 * See {@link org.osate.ge.swt.name.NameEditorModel#validateName(String)}
	 * @param value is the potential new name of the prototype to be validated.
	 * @return null is the validation succeeds. Otherwise, a message for display to the user describing the problem with the provided value.
	 */
	String validateName(String value);

	/**
	 * See {@link org.osate.ge.swt.name.NameEditorModel#setName(String)}
	 * @param value the new name for the prototype.
	 */
	void setName(String value);

	/**
	 * Gets the prototype's direction
	 * @return the direction of the prototype. Returns null if the prototype does not have a direction value available.
	 */
	PrototypeDirection getDirection();

	/**
	 * Updates the prototype's direction
	 * @param value is the new direction for the prototype.
	 */
	void setDirection(final PrototypeDirection value);

	/**
	 * Returns the current value for type.
	 * @return the type to display in the editor.
	 */
	PrototypeType getType();

	/**
	 * Updates the value for the type.
	 * @param value is the new value for type.
	 */
	void setType(final PrototypeType value);

	/**
	 * Returns a stream of classifiers based on the current prototype type.
	 * @return a stream of potential classifiers based on the current prototype type
	 */
	Stream<C> getConstrainingClassifierOptions();

	/**
	 * Returns the label for the specified classifier.
	 * @param classifier is the classifier for which to return the label.
	 * @return is the label for the specified classifier
	 */
	String getClassifierLabel(C classifier);

	/**
	 * Get the current set constraining classifier.
	 * @return the constraining classifier for the prototype.
	 */
	C getConstrainingClassifier();

	/**
	 * Updates the constraining classifier.
	 * @param value the new constraining classifier.
	 */
	void setConstrainingClassifier(C value);

	/**
	 * Returns whether the prototype is an array.
	 * @return whether the prototype is an array. Returns null if it is indeterminate.
	 */
	Boolean isArray();

	/**
	 * Updates whether the prototype is an array.
	 * @param value whether the prototype is an array.
	 */
	void setArray(boolean value);
}
