/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.diagrams.common;

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
