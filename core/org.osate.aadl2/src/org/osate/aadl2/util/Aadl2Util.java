package org.osate.aadl2.util;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Property;

public class Aadl2Util {
	
	/**
	 * Xtext resolver leaves unresolved proxy when reference cannot be resolved.
	 * @param eo
	 * @return
	 */
	public static boolean isNull(EObject eo){
		return eo == null || eo.eIsProxy();
	}

	/**
	 * Check to see if the Property definitions are the same
	 * The methods compensates for the possible problem that the objects are different.
	 * 
	 * @param p1 Property
	 * @param p2 Property
	 * @return true if they have the same name
	 */
	public static boolean sameProperty(Property p1, Property p2) {
		String p1Name = p1.getQualifiedName();
		String p2Name = p2.getQualifiedName();
		boolean sameName = p1Name.equalsIgnoreCase(p2Name);
// XXX to track down possible multiple loads of property definitions
		//		if ( p1 != p2 && sameName){
//			System.out.println("Two objects for the same property definition "+p1.getQualifiedName());
//		}
		return sameName;
	}

}
