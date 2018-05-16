package org.osate.ge.internal.selection;

import org.eclipse.core.expressions.ICountable;
import org.eclipse.core.expressions.IIterable;
import org.eclipse.core.runtime.IAdapterFactory;
import org.osate.ge.BusinessObjectSelection;

/**
 * Adapter factory that allows BusinessObjectSelection objects to be adapted to interfaces which will allow counting and iterating in the Eclipse expressions.
 *
 */
public class BusinessObjectSelectionExpressionAdapterFactory implements IAdapterFactory {
	@Override
	public <T> T getAdapter(final Object adaptableObject, final Class<T> adapterType) {
		final BusinessObjectSelection bos = (BusinessObjectSelection) adaptableObject;

		if (ICountable.class.equals(adapterType)) {
			return adapterType.cast((ICountable) () -> (int)bos.bocStream().count());
		} else if (IIterable.class.equals(adapterType)) {
			return adapterType.cast((IIterable<?>) () -> bos.boStream(Object.class).iterator());
		}

		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return new Class[] { ICountable.class, IIterable.class };
	}

}
