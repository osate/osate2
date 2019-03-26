package org.osate.ui.navigator;

import java.util.Objects;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class NavigatorEObjectNode implements IAdaptable {
	private final URI uri;
	private final EClass eClass;

	NavigatorEObjectNode(EObject eObject) {
		uri = EcoreUtil.getURI(eObject);
		eClass = eObject.eClass();
	}

	public URI getUri() {
		return uri;
	}
	
	public EClass getEClass() {
		return eClass;
	}
	
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		if (EObject.class.isAssignableFrom(adapter)) {
			EObject eObject = new ResourceSetImpl().getEObject(uri, true);
			if (adapter.isInstance(eObject)) {
				return adapter.cast(eObject);
			}
		}
		return null;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(uri);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof NavigatorEObjectNode && Objects.equals(uri, ((NavigatorEObjectNode) obj).uri);
	}
}