package org.osate.ge.swt.prototypeBindings;

import java.util.stream.Stream;

/**
 * View Model interface for {@link PrototypeBindingsEditor}
 *
 * @param <B> the type of the prototype bindings being edited.
 * @param <C> the type used for the constraining classifier of the prototypes.
 */
public interface PrototypeBindingsEditorModel<B, C> {
	/**
	 * Returns a stream of prototype bindings.
	 * @return is a stream of prototype bindings.
	 */
	Stream<B> getBindings();

	/**
	 * Get a string that can be shown to the user to identify the prototype binding. It is expected to be the name of the prototype.
	 * @param binding is the prototype binding for which to return the label.
	 * @return the label of the specified prototype binding.
	 */
	String getBindingLabel(B binding);

	/**
	 * Get a string that can be shown to the user to identify the prototype binding's actual.
	 * @param binding is the prototype binding for which to return the label.
	 * @return the label of the specified prototype binding actual.
	 */
	String getBindingActualLabel(B binding);

	// TODO: Consider using the concrete types defined in this package... Also consider whether they help or hurt...

	// TODO: More info is needed to allow editing
	// Function to set actual(s) for a binding.
	// Actual: Classifier, bindings, port spec, access spec. Bindings are recursive.
	// TODO: Have function that can get new model object recursively or just use the same model?

	// getBindingActualPotentialClassifiers(binding)
	// getBindingActualBindings(binding)

}
