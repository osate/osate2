/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package edu.uah.rsesc.aadl.age.services;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;

/**
 * Includes methods for modifying diagrams.
 * @author philip.alldredge
 *
 */
public interface DiagramModificationService {
	public interface Modification
	{
		/**
		 * Returns the list of all diagrams of which the modification service/modification is aware.
		 * @return
		 */
		List<Diagram> getDiagrams();
		
		/**
		 * Mark diagram as dirty.
		 */
		void markDiagramAsDirty(Diagram diagram);
		
		/**
		 * Marks all diagrams that could be effected by a change to the specified classifier as dirty.
		 * @param c
		 */
		void markRelatedDiagramsAsDirty(Classifier c);
		
		/**
		 * Marks linkages in all diagrams to the specified element as dirty.
		 * @param el
		 */
		void markLinkagesAsDirty(NamedElement el);		
		
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
