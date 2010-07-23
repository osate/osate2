package fr.tpt.aadl.annex.behavior.utils;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import edu.cmu.sei.aadl.aadl2.NamedElement;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier;

public class AadlBaUtils {

	/**
	 * Constructs a string with the identifier of elements
	 * in a list.
	 * 
	 * @param l the given list of elements
	 * @return the string composed of all element identifiers
	 */
	public static String ListToString(EList<Identifier> l) {

		String result = "";

		for (Identifier i : l) {
			result += i.getId() + ":" + i.getLocationReference().getLine() + " ";
		}
		return result;
	}
	
	
	// Import frome AadlUtil modelsupport
	/**
	 * find (first) Named Element matching name in the Elist; any elements that
	 * are not NamedElements are skipped.
	 * 
	 * @param el Elist of NamedElements
	 * @param name String
	 * @return NamedElement
	 */
	public static NamedElement findNamedElementInList(List<?> el, String name) {
		if (el != null) {
			Iterator<?> it = el.iterator();

			while (it.hasNext()) {
				Object o = it.next();

				if (o instanceof NamedElement) {
					String n = ((NamedElement) o).getName();

					if (n != null && n.length() > 0 && name.equalsIgnoreCase(n)) {
						return (NamedElement) o;
					}
				}
			}
		}
		return null;
	}

	/**
	 * find all Named Elements matching name in the Elist; any elements that are
	 * not NamedElements are skipped.
	 * 
	 * @param el Elist of NamedElements
	 * @param name String
	 * @return EList of NamedElements that match the name
	 */
	public static EList<NamedElement> findNamedElementsInList(List<?> el, String name) {
		EList<NamedElement> result = new BasicEList<NamedElement>();

		if (el != null) {
			Iterator<?> it = el.iterator();
			while (it.hasNext()) {
				Object o = it.next();

				if (o instanceof NamedElement) {
					String n = ((NamedElement) o).getName();
					if (n != null && name.length() > 0 && name.equalsIgnoreCase(n)) {
						result.add((NamedElement) o);
					}
				}
			}
		}
		return result;
	}
}
