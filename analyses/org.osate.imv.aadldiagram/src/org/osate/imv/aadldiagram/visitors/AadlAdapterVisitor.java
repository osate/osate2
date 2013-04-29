/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil.                                               *
 * Contributions by Peter Feiler and Julien Delange                                 *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.aadldiagram.visitors;

import org.osate.imv.aadldiagram.adapters.AadlBindingAdapter;
import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;
import org.osate.imv.aadldiagram.adapters.AadlConnectionAdapter;
import org.osate.imv.aadldiagram.adapters.AadlFeatureAdapter;
import org.osate.imv.aadldiagram.adapters.AadlFlowPathAdapter;

public class AadlAdapterVisitor {

	/**
	 * Constructor can only be invoked by a subclass.
	 */
	protected AadlAdapterVisitor() {
		// Explicitly do nothing.
	}

	public void visitAadlComponentAdapter(AadlComponentAdapter adapter) {
		// Explicitly do nothing - this is a default implementation.
	}

	public void visitAadlFeatureAdapter(AadlFeatureAdapter adapter) {
		// Explicitly do nothing - this is a default implementation.
	}

	public void visitAadlConnectionAdapter(AadlConnectionAdapter adapter) {
		// Explicitly do nothing - this is a default implementation.
	}

	public void visitAadlFlowPathAdapter(AadlFlowPathAdapter adapter) {
		// Explicitly do nothing - this is a default implementation.
	}
	
	public void visitAadlBindingAdapter(AadlBindingAdapter adapter) {
		// Explicitly do nothing - this is a default implementation.
	}
}
