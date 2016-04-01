/**
 * <copyright>
 *
 * Copyright (c) 2005, 2008 IBM Corporation, Zeligsoft Inc. and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - Initial API and implementation
 *   Zeligsoft - Bug 233004
 *
 * </copyright>
 *
 * $Id: SynchRequest.java,v 1.3 2008/08/13 13:24:44 cdamus Exp $
 */
package org.osate.emf.workspace.util;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Abstract definition of a single request to synchronize a workspace
 * resource change with the EMF resource representation in the editing
 * domain.
 *
 * @author Christian W. Damus (cdamus)
 */
abstract class SynchRequest {
	protected final WorkspaceSynchronizer synch;
	protected final Resource resource;

	/**
	 * Initializes me with the synchronizer on whose behalf I perform a
	 * synchronization and the resource whose workspace partner is changed.
	 * 
	 * @param synch the workspace synchronizer
	 * @param resource the resource that has changed
	 */
	SynchRequest(WorkspaceSynchronizer synch, Resource resource) {
		this.synch = synch;
		this.resource = resource;
	}

	/**
	 * Performs the synchronization on the synchronizer's behalf.
	 * Clients must hold my {@linkplain #getLock() synchronization lock} when
	 * calling this method.
	 * 
	 * @throws InterruptedException if the job thread is interrupted while
	 *     attempting to start a read-only transaction in the editing domain
	 * 
	 * @see #getLock()
	 */
	public final void perform() throws InterruptedException {
		synch.getEditingDomain().runExclusive(new Runnable() {
			public void run() {
				doPerform();
			}
		});
	}

	/**
	 * Implemented by subclasses to actually perform their synchronization
	 * by delegation to the synchronizer's delegate.
	 */
	protected abstract void doPerform();

	/**
	 * Queries whether I am disposed.  If I am disposed, then I should not
	 * be performed.  Clients must hold my
	 * {@linkplain #getLock() synchronization lock} when calling this method.
	 * 
	 * @return whether I am disposed
	 * 
	 * @see #getLock()
	 * @since 1.2.1
	 */
	protected final boolean isDisposed() {
		return synch.isDisposed();
	}

	/**
	 * My synchronization lock, for external synchronization of calls to
	 * such methods as {@link #isDisposed()} and {@link #perform()}.
	 * Note that this lock is held while the request is being performed, but
	 * that this still allows the delegate (if any) to dispose its synchronizer
	 * during its invocation.
	 * 
	 * @return my external lock object
	 */
	final Object getLock() {
		return synch;
	}
}
