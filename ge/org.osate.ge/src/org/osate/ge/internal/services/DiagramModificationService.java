/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.osate.aadl2.Classifier;

/**
 * Includes methods for modifying diagrams.
 *
 */
public interface DiagramModificationService {
	public interface Modification
	{				
		/**
		 * Marks all open diagrams that could be effected by a change to the specified classifier as dirty.
		 * @param c
		 */
		void markOpenRelatedDiagramsAsDirty(Classifier c);
		
		/**
		 * Marks linkages in all diagrams to the specified element as dirty. This method is likely to have a significant performance impact because it marks linkages as dirty
		 * in both open and closed diagrams.
		 * @param el
		 */
		void markLinkagesAsDirty(Object bo);		
		
		/**
		 * The same as markLinkagesAsDirty but only affects open diagrams.
		 * @param c
		 */
		void markOpenLinkagesAsDirty(Object bo);
		
		/**
    	 * Makes the actual changes to the diagrams.
    	 */
		void commit();
	}
	
	/**
	 * Starts a modification. Returns a modification object that can be used to make modifications. Modifications are made with commit() is called.
	 * @return
	 */
	Modification startModification();
}