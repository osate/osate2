package edu.uah.rsesc.aadl.age.diagrams.common;

import org.osate.aadl2.Element;

/**
 * Class that wraps and Aadl model element. The purpose of this class is to hide the EMF underpinnings from graphiti. Grpahiti handles EMF objects specially and in some cases it does not work
 * as intended for Aadl objects and using the live objects created by xtext.
 * @author philip.alldredge
 *
 */
public class AadlElementWrapper {
	private final Element element;
	
	public AadlElementWrapper(final Element element) {
		this.element = element;
	}
	
	public final Element getElement() {
		return this.element;
	}
	
	public final boolean isValid() {
		return this.element != null;
	}
	
	/**
	 * Retrieves the aadl model element from a wrapper object. if the object is an aadl element, null is returned. Otherwise, the object itself is returned.  
	 * @param obj the object to unwrap
	 * @return the Aadl model element, the passed in object, or null
	 */
	public final static Object unwrap(final Object obj) {
		if(obj instanceof AadlElementWrapper) {
			return ((AadlElementWrapper)obj).getElement();
		} else if(obj instanceof Element) {
			return null;
		}
		return obj;
	}
}
