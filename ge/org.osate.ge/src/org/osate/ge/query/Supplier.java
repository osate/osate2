/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.query;

/**
 * A generic interface for a supplier which accepts a single argument.
 * @param <A> the type of the argument
 * @param <R> the type of the result
 */
@FunctionalInterface
public interface Supplier<A, R> {
	/**
	 * Gets a result. The result must always be the same given the same argument.
	 * @param arg the argument to the supplier. 
	 * @return a result
	 */
	R get(final A arg);
}
