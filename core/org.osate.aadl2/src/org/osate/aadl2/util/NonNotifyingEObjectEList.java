package org.osate.aadl2.util;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectEList;

public class NonNotifyingEObjectEList<E> extends EObjectEList<E> {

	private static final long serialVersionUID = 7326976595806462429L;

	public NonNotifyingEObjectEList(final Class<?> dataClass, final InternalEObject owner, final int featureID) {
		super(dataClass, owner, featureID);
	}

	@Override
	protected boolean isNotificationRequired() {
		return false;
	}
}
