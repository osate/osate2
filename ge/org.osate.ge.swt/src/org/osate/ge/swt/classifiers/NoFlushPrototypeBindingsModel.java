package org.osate.ge.swt.classifiers;

/**
 * Model decorator which is passed to the binding editor to prevent flushing.
 *
 * @param <N>
 * @param <D>
 * @param <T>
 * @param <C>
 */
class NoFlushPrototypeBindingsModel<N, D, T, C>
		extends PrototypeBindingsModelDecorator<N, D, T, C> {
	public NoFlushPrototypeBindingsModel(final PrototypeBindingsModel<N, D, T, C> inner) {
		super(inner);
	}

	@Override
	public void flush() {
		// Avoid flushing until the top-level dialog has closed to allow batching changes.
	}
}