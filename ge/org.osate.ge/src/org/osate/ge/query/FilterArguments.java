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
 * Provides access to the arguments used to filter query results using {@link Query#filter(java.util.function.Predicate)}. 
 * @param <A> the type of the query argument
 * @noextend
 * @noimplement
 * @see Query#filter(java.util.function.Predicate)
 */
public interface FilterArguments {
	/**
	 * Returns the business object that is associated with the diagram element being filtered.
	 * @return the diagram element's business object
	 */
	Object getBusinessObject();
	
	/**
	 * Returns the query argument 
	 * @return the query argument
	 */
	Object getQueryArgument();
}
