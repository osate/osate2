/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Carnegie Mellon University - adapted for use in OSATE
 *******************************************************************************/
package org.osate.workspace;

/**
 * Common protocol for Java elements that contain other Java elements.
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 */
public interface IParent {
	/**
	 * Returns the immediate children of this element. Unless otherwise
	 * specified by the implementing element, the children are in no particular
	 * order.
	 * 
	 * @exception AadlModelException if this element does not exist or if an
	 *                exception occurs while accessing its corresponding
	 *                resource
	 * @return the immediate children of this element
	 */
	IAadlElement[] getChildren() throws AadlModelException;

	/**
	 * Returns whether this element has one or more immediate children. This is
	 * a convenience method, and may be more efficient than testing whether
	 * <code>getChildren</code> is an empty array.
	 * 
	 * @exception AadlModelException if this element does not exist or if an
	 *                exception occurs while accessing its corresponding
	 *                resource
	 * @return true if the immediate children of this element, false otherwise
	 */
	boolean hasChildren() throws AadlModelException;
}