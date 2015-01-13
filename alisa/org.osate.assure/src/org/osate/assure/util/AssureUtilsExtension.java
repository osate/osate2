package org.osate.assure.util;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.osate.assure.assure.AssuranceResult;

public class AssureUtilsExtension {

	public static String getText(AssuranceResult ar) {
		return "hi";
	}

	public static boolean isValid(AssuranceResult ar) {
		return true;
	}

	public static List<AssuranceResult> getResultChildren(AssuranceResult ar) {
		return null;
	}

	public static EObject getLocation(AssuranceResult ar) {
		return null;
	}

	public static Map<String, EObject> getReferences(AssuranceResult ar) {
		return null;
	}

}
