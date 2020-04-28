package org.osate.ge.swt.classifiers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Model decorator used by the dialog which tracks changes and allows reverting.
 *
 * @param <N>
 * @param <D>
 * @param <T>
 * @param <C>
 */
class PrototypeBindingsEditorDialogModel<N, D, T, C>
		extends PrototypeBindingsModelDecorator<N, D, T, C> {
	private final Map<N, D> originalDirections = new HashMap<>();
	private final Map<N, T> originalTypes = new HashMap<>();
	private final Map<N, C> originalClassifiers = new HashMap<>();

	public PrototypeBindingsEditorDialogModel(final PrototypeBindingsModel<N, D, T, C> inner) {
		super(inner);
	}

	@Override
	public void setDirection(final N node, final D value) {
		// Store original value to allow reverting
		if (!originalDirections.containsKey(node)) {
			originalDirections.put(node, super.getDirection(node));
		}

		super.setDirection(node, value);
	}

	@Override
	public void setType(final N node, final T value) {
		// Store original value to allow reverting
		if (!originalTypes.containsKey(node)) {
			originalTypes.put(node, super.getType(node));
		}

		super.setType(node, value);
	}

	@Override
	public void setClassifier(final N node, final C value) {
		// Store original value to allow reverting
		if (!originalClassifiers.containsKey(node)) {
			originalClassifiers.put(node, super.getClassifier(node));
		}

		super.setClassifier(node, value);
	}

	public void revert() {
		// Revert classifier changes
		for (final Entry<N, C> e : originalClassifiers.entrySet()) {
			super.setClassifier(e.getKey(), e.getValue());
		}
		originalClassifiers.clear();

		// Revert type changes
		for (final Entry<N, T> e : originalTypes.entrySet()) {
			super.setType(e.getKey(), e.getValue());
		}
		originalTypes.clear();

		// Revert direction changes
		for (final Entry<N, D> e : originalDirections.entrySet()) {
			super.setDirection(e.getKey(), e.getValue());
		}
		originalDirections.clear();
	}
}