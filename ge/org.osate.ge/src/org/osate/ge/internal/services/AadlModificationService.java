/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Service providing a mechanism for making changes to the model
 *
 */
public interface AadlModificationService {
	/**
	 * Modifies an AADL model. Performs any necessary work to ensure it is done safely and appropriately regardless of the current state.
	 * The modification is considered to have failed if the model that results from the modification contains validation errors.
	 * @param element a named element that is contained in the model to be modified
	 * @param modifier the modifier that will perform the actual modification
	 * @returns the result of the modification or null if the modification failed
	 */
	<E extends EObject, R> R modify(E bo, Modifier<E, R> modifier);
	
	public static interface Modifier<E, R> {
		R modify(Resource resource, final E bo);
		
		/**
		 * Called after a modification but before the AADL text file has been updated and the diagram has been updated. It is not executed if the modification is aborted.
		 * Because of this, annexes will not have been relinked prior to beforeCommit() being executed.
		 */
		void beforeCommit(Resource resource, E bo, R modificationResult);
		
		/**
		 * Called after a modification has been made, the AADL text file has been updated, and the diagram has been updated. It is not executed if the modification is aborted.
		 */
		void afterCommit(Resource resource);
	}
	
	public static abstract class AbstractModifier<E, R> implements Modifier<E,R> {
		@Override
		public abstract R modify(Resource resource, E bo);		
		
		@Override
		public void beforeCommit(Resource resource, E bo, R modificationResult) {			
		}
		
		@Override
		public void afterCommit(Resource resource) {			
		}
	}
}
