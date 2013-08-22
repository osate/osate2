package edu.uah.rsesc.aadl.age.diagrams.common.util;

import java.util.List;
import org.osate.aadl2.NamedElement;

/**
 * Contains miscellaneous methods for dealing with AADL elements/named elements
 * @author philip.alldredge
 *
 */
public class ElementHelper {
	public static boolean listContainsElementWithName(final List<? extends NamedElement> elements, final String name) {
		for(final NamedElement el : elements) {
			if(name.equalsIgnoreCase(el.getName())) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean areNamesEqual(final NamedElement e1, final NamedElement e2) {
		if(e1 == null || e1.getFullName() == null || e2 == null || e2.getFullName() == null)
			return false;
		
		return e1.getFullName().equalsIgnoreCase(e2.getFullName());
	}
}
