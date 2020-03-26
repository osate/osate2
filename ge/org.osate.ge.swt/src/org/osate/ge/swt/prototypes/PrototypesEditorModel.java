package org.osate.ge.swt.prototypes;

import java.util.stream.Stream;

import org.osate.ge.swt.ObservableModel;

/**
 * View Model interface for {@link PrototypesEditor}
 *
 * @param <P> the type of the prototypes being edited.
 * @param <C> the type used for the constraining classifier of the prototypse.
 */
public interface PrototypesEditorModel<P, C> extends ObservableModel {
	/**
	 * Returns a stream of prototypes. See {@link org.osate.ge.swt.selectors.ListEditorModel#getElements()}
	 * @return is a stream of prototypes.
	 */
	Stream<P> getPrototypes();

	/**
	 * Creates a new prototype. See {@link org.osate.ge.swt.selectors.ListEditorModel#addElement()}
	 */
	void addPrototype();

	/**
	 * Removes a prototype. See {@link org.osate.ge.swt.selectors.ListEditorModel#removeElement(Object)}
	 * @param prototype is the prototype to remove.
	 */
	void removePrototype(P prototype);

	/**
	 * Returns the currently selected prototype. See {@link org.osate.ge.swt.selectors.ListEditorModel#getSelectedElement()}
	 * @return is the currently selected prototype.
	 */
	P getSelectedPrototype();

	/**
	 * Sets the currently selected prototype. See {@link org.osate.ge.swt.selectors.ListEditorModel#setSelectedElement(Object)}
	 * @param value is the newly selected prototype.
	 */
	void setSelectedPrototype(P value);

	/**
	 * Get the name of the specified prototype.
	 * @param prototype is the prototype for which to return the name.
	 * @return the name of the specified prototype.
	 */
	String getPrototypeName(P prototype);

	/**
	 * Updates the name of the specified prototype to the specified value.
	 * @param prototype is the prototype for which to set the name.
	 * @param value is the new name for the prototype.
	 */
	void setPrototypeName(P prototype, String value);

	/**
	 * Validates a potential new name of the specified prototype. Should be called before calling {@link #setPrototypeName(Object, String)}.
	 * @param prototype is the name of the prototype for which to validate the name
	 * @param newName is the potential new name.
	 * @return null is the validation succeeds. Otherwise, a message for display to the user describing the problem with the provided value.
	 */
	String validatePrototypeName(P prototype, String newName);

	/**
	 * Get the direction of the specified prototype.
	 * @param prototype is the prototype for which to return the direction.
	 * @return the direction of the specified prototype. Returns null if the prototype does not have a direction value available.
	 */
	PrototypeDirection getPrototypeDirection(P prototype);

	/**
	 * Updates the direction of the specified prototype
	 * @param prototype is the prototype for which to set the direction.
	 * @param value is the new direction for the specified prototype.
	 */
	void setPrototypeDirection(P prototype, PrototypeDirection value);

	/**
	 * Get the type of the specified prototype.
	 * @param prototype is the prototype for which to return the type.
	 * @return the type of the specified prototype. Returns null if the prototype does not have a type value available.
	 */
	PrototypeType getPrototypeType(P prototype);

	/**
	 * Updates the direction of the specified prototype
	 * @param prototype is the prototype for which to set the type.
	 * @param value is the new type for the specified prototype.
	 */
	void setPrototypeType(P prototype, PrototypeType value);

	/**
	 * Returns a stream of classifiers based on the current prototype type.
	 * @param prototype is the prototype for which to get the options.
	 * @return a stream of potential classifiers based on the current prototype type
	 */
	Stream<C> getConstrainingClassifierOptions(P prototype);

	/**
	 * Returns the label for the specified classifier.
	 * @param classifier is the classifier for which to return the label.
	 * @return is the label for the specified classifier
	 */
	String getClassifierLabel(C classifier);

	/**
	 * Get the current set constraining classifier.
	 * @param prototype is the prototype for which to get the constraining classifier.
	 * @return the constraining classifier for the prototype.
	 */
	C getConstrainingClassifier(P prototype);

	/**
	 * Updates the constraining classifier.
	 * @param prototype is the prototype for which to set the constraining classifier.
	 * @param value the new constraining classifier.
	 */
	void setConstrainingClassifier(P prototype, C value);

	/**
	 * Returns whether the prototype is an array.
	 * @param prototype is the prototype for which to return whether it is an array.
	 * @return whether the prototype is an array. Returns null if is indeterminate.
	 */
	Boolean isArray(P prototype);

	/**
	 * Updates whether the prototype is an array.
	 * @param prototype is the prototype for which to set the whether it is an array.
	 * @param value whether the prototype is an array.
	 */
	void setArray(P prototype, boolean value);
}
