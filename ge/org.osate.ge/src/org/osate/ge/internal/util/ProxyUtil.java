package org.osate.ge.internal.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;

public class ProxyUtil {
	@SuppressWarnings("unchecked")
	public static <T extends EObject> T resolveOrNull(final Object value, final Class<T> type, final ResourceSet rs) {
		if (type.isInstance(value)) {
			T obj = type.cast(value);
			if (obj.eIsProxy()) {
				obj = (T)EcoreUtil.resolve(obj, rs);
			}

			return obj.eIsProxy() ? null : obj;
		} else if (value instanceof IEObjectDescription) {
			return resolveOrNull(((IEObjectDescription) value).getEObjectOrProxy(), type, rs);
		} else {
			return null;
		}
	}
}
