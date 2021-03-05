/**
 * AADL-BA-FrontEnd
 *
 * Copyright © 2013 TELECOM ParisTech and CNRS
 *
 * TELECOM ParisTech/LTCI
 *
 * Authors: see AUTHORS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.utils;

import org.osate.aadl2.Element;

/**
 * Represents an exception raised when out of array dimension accessing.
 */
public class DimensionException extends Exception {
	/**
	*
	*/
	private static final long serialVersionUID = -7962508017913234922L;

	public Element element;

	private final boolean isWarning;

	public DimensionException(Element element, String message, boolean isWarning) {
		super(message);
		this.element = element;
		this.isWarning = isWarning;
	}

	public boolean isWarning() {
		return isWarning;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public Element getElement() {
		return element;
	}
}
