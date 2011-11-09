package org.osate.aadl2.util;

import org.eclipse.emf.ecore.EObject;

public class Aadl2Util {
	
	/**
	 * Xtext resolver leaves unresolved proxy when reference cannot be resolved.
	 * @param eo
	 * @return
	 */
	public static boolean isNull(EObject eo){
		return eo == null || eo.eIsProxy();
	}

}
