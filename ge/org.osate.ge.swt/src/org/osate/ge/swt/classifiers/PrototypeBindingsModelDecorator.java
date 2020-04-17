package org.osate.ge.swt.classifiers;

import java.util.Objects;
import java.util.stream.Stream;

import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;

/**
 * Abstract decorator for {@link PrototypeBindingsModel}
 */
public abstract class PrototypeBindingsModelDecorator<N, D, T, C> implements PrototypeBindingsModel<N, D, T, C> {
	private final PrototypeBindingsModel<N, D, T, C> inner;

	/**
	 * Creates a new instance
	 * @param inner the model to decorate.
	 */
	public PrototypeBindingsModelDecorator(final PrototypeBindingsModel<N, D, T, C> inner) {
		this.inner = Objects.requireNonNull(inner, "inner must not be null");
	}

	@Override
	public EventSource<ChangeEvent> changed() {
		return inner.changed();
	}

	@Override
	public Stream<N> getChildren(final N parent) {
		return inner.getChildren(parent);
	}

	@Override
	public String getLabel(final N node) {
		return inner.getLabel(node);
	}

	@Override
	public Stream<D> getDirectionOptions(final N node) {
		return inner.getDirectionOptions(node);
	}

	@Override
	public String getDirectionLabel(final D direction) {
		return inner.getDirectionLabel(direction);
	}

	@Override
	public D getDirection(final N node) {
		return inner.getDirection(node);
	}

	@Override
	public void setDirection(final N node, final D value) {
		inner.setDirection(node, value);
	}

	@Override
	public Stream<T> getTypeOptions(final N node) {
		return inner.getTypeOptions(node);
	}

	@Override
	public String getTypeLabel(final T type) {
		return inner.getTypeLabel(type);
	}

	@Override
	public T getType(final N node) {
		return inner.getType(node);
	}

	@Override
	public void setType(final N node, final T value) {
		inner.setType(node, value);
	}

	@Override
	public Stream<C> getClassifierOptions(final N node) {
		return inner.getClassifierOptions(node);
	}

	@Override
	public String getClassifierLabel(final C classifier) {
		return inner.getClassifierLabel(classifier);
	}

	@Override
	public C getClassifier(final N node) {
		return inner.getClassifier(node);
	}

	@Override
	public void setClassifier(final N node, final C value) {
		inner.setClassifier(node, value);
	}

	@Override
	public void flush() {
		inner.flush();
	}
}
