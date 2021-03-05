/**
 * AADL-Utils
 *
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package org.osate.utils.internal;

/**
 * Exception thrown when a mandatory property is not found in the
 * input AADL model.
 * @since 2.0
 */
public class PropertyNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/*
	 * public PropertyNotFound(Throwable cause) {
	 * super(cause);
	 * }
	 */
	public PropertyNotFound(String msg) {
		super(msg);
	}
}
