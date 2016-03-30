/**
 * <copyright>
 *
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: MovedSynchRequest.java,v 1.3 2007/11/14 18:14:08 cdamus Exp $
 */
package org.osate.emf.workspace.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Concrete synchronization request for resource moves.
 *
 * @author Christian W. Damus (cdamus)
 */
class MovedSynchRequest extends SynchRequest {
	private final URI newURI;

	/**
	 * Initializes me with the synchronizer on whose behalf I perform a
	 * synchronization and the resource whose workspace partner is moved.
	 * 
	 * @param synch the workspace synchronizer
	 * @param resource the resource that has moved
	 * @param newURI the resource's new URI
	 */
	MovedSynchRequest(WorkspaceSynchronizer synch, Resource resource, URI newURI) {
		super(synch, resource);

		this.newURI = newURI;
	}

	@Override
	protected void doPerform() {
		if (!synch.getDelegate().handleResourceMoved(resource, newURI)) {
			// note that if our delegate is the default, it
			// will always return true
			WorkspaceSynchronizer.defaultDelegate.handleResourceMoved(resource, newURI);
		}
	}
}
