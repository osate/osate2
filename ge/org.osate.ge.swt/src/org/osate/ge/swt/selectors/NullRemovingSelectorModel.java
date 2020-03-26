package org.osate.ge.swt.selectors;

import java.util.stream.Stream;

/**
 * {@link SelectorModel} implementation that replaces null elements with an object representing null.
 * This class is intended to be used as an implementation detail when implementing selectors using JFace components which do not support null.
 *
 */
class NullRemovingSelectorModel extends SelectorModelDecorator<Object> {
	private static final Object nullObject = new Object();

	@SuppressWarnings("unchecked")
	public NullRemovingSelectorModel(final SelectorModel<?> inner) {
		super((SelectorModel<Object>) inner);
	}

	@Override
	public Stream<Object> getElements() {
		return super.getElements().map(NullRemovingSelectorModel::nullToObject);
	}

	@Override
	public Object getSelectedElement() {
		return nullToObject(super.getSelectedElement());
	}

	@Override
	public void setSelectedElement(final Object element) {
		super.setSelectedElement(objectToNull(element));
	}

	@Override
	public String getLabel(final Object element) {
		return super.getLabel(objectToNull(element));
	}

	private static Object nullToObject(Object value) {
		return value == null ? nullObject : value;
	}

	private static Object objectToNull(Object value) {
		return value == nullObject ? null : value;
	}
}
