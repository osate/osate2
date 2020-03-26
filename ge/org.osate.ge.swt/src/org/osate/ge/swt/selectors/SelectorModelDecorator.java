package org.osate.ge.swt.selectors;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.ChangeEvent;

public class SelectorModelDecorator<T> extends BaseObservableModel implements SelectorModel<T> {
	private final SelectorModel<T> inner;
	private final Consumer<ChangeEvent> changeListener = e -> triggerChangeEvent();

	public SelectorModelDecorator(final SelectorModel<T> inner) {
		this.inner = Objects.requireNonNull(inner);
		this.inner.changed().addListener(changeListener);
	}

	@Override
	public boolean isEnabled() {
		return inner.isEnabled();
	}

	@Override
	public Stream<T> getElements() {
		return inner.getElements();
	}

	@Override
	public T getSelectedElement() {
		return inner.getSelectedElement();
	}

	@Override
	public void setSelectedElement(T element) {
		inner.setSelectedElement(element);
	}

	@Override
	public String getLabel(final T element) {
		return inner.getLabel(element);
	}
}
