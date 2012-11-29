/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.aadldiagram.adapters;

import java.util.Iterator;
import java.util.Stack;

/**
 * Provides depth-first preorder traversal of the adapter hierarchy.
 */
public class AadlAdapterIterator {

	private Stack<IAadlElementAdapter> adapterStack;

	public AadlAdapterIterator(IAadlElementAdapter rootAdapter) {
		this.adapterStack = new Stack<IAadlElementAdapter>();
		// Add root adapter to stack.
		this.adapterStack.push(rootAdapter);
	}

	public boolean hasNext() {
		return !this.adapterStack.isEmpty();
	}

	public IAadlElementAdapter next() {
		// The next adapter on the stack will be returned.
		IAadlElementAdapter retAdapter = this.adapterStack.pop();
		// Push the adapters children onto the stack.
		for(Iterator<IAadlElementAdapter> it = retAdapter.getAllChildren(); it.hasNext();)
			this.adapterStack.push(it.next());

		return retAdapter;
	}

}
