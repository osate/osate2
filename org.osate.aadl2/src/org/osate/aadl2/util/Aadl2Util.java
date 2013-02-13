package org.osate.aadl2.util;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.CallSpecification;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.ThreadImplementation;

public class Aadl2Util {

	/**
	 * Xtext resolver leaves unresolved proxy when reference cannot be resolved.
	 * @param eo
	 * @return
	 */
	public static boolean isNull(EObject eo) {
		return eo == null || eo.eIsProxy();
	}

	/**
	 * Xtext resolver leaves unresolved proxy when reference cannot be resolved.
	 * @param eo
	 * @return
	 */
	public static boolean isUnresolved(EObject eo) {
		return  eo.eIsProxy();
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
		return sameName;
	}
	
	public static String getName(NamedElement ne){
		if (ne.hasName()) return ne.getName();
		return getRefinedName(ne, ne);
	}
	
	/**
	 * refined Elements do not have an assigned name, but they have a reference to the Element they refine.
	 * One of them is the original with an actually assigned name
	 * @param ne Element whose name we are trying to retrieve
	 * @param root The start of the search. Used to detect cycles
	 * @return
	 */
	public static String getRefinedName(NamedElement ne, NamedElement root){
		if (ne instanceof RefinableElement){
			RefinableElement re = (RefinableElement)ne;
			RefinableElement ref = re.getRefinedElement();
			if (ref == root) return null; // terminate on cycle
			if (ref != null) return getRefinedName(ref, root);
			// no additional reference pointer, return name
			return ne.getName();
		}
		return null;
	}
	
	/**
	 * Find owned named elements. In the case of a thread implementation or subprogram implementation
	 * also look up subprogram calls.
	 * @param owner Classifier in which the lookup is performed
	 * @param name name of Element to be found
	 * @return NamedElement or null
	 */
	public static NamedElement findOwnedNamedElement(Classifier owner, String name)
	{
		for (Element e : owner.getOwnedElements())
		{ 
			if (! (e instanceof NamedElement))
				continue;
			NamedElement ne = (NamedElement)e;
			String neName = Aadl2Util.getName(ne);
			if (neName != null && neName.equalsIgnoreCase(name))
				return ne;
		}
		if (owner instanceof ThreadImplementation)
		{
			ThreadImplementation ti = (ThreadImplementation) owner;
			for (CallSpecification cs : ti.getCallSpecifications())
			{
				if (cs.getName() != null && cs.getName().equalsIgnoreCase(name))
				{
					return cs;
				}
			}
		} else
		if (owner instanceof SubprogramImplementation)
		{
			SubprogramImplementation ti = (SubprogramImplementation) owner;
			for (CallSpecification cs : ti.getCallSpecifications())
			{
				if (cs.getName() != null && cs.getName().equalsIgnoreCase(name))
				{
					return cs;
				}
			}
		}
		
		if (owner instanceof SubprogramImplementation)
		{
			SubprogramImplementation si = (SubprogramImplementation) owner;
			for (CallSpecification cs : si.getCallSpecifications())
			{
				if (cs.getName() != null && cs.getName().equalsIgnoreCase(name))
				{
					return cs;
				}
			}
		}
		
		return null;
	}

}
