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

package org.osate.imv.aadldiagram.visitors;

import org.eclipse.core.runtime.Assert;
import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;
import org.osate.imv.aadldiagram.adapters.AadlConnectionAdapter;
import org.osate.imv.aadldiagram.adapters.AadlFeatureAdapter;
import org.osate.imv.aadldiagram.viewer.IAadlAdapterRestorerDelegate;


public class RestoreStateVisitor extends AadlAdapterVisitor {

	private IAadlAdapterRestorerDelegate delegate;

	public RestoreStateVisitor(IAadlAdapterRestorerDelegate delegate) {
		Assert.isNotNull(delegate);
		this.delegate = delegate;
	}

	public void visitAadlComponentAdapter(AadlComponentAdapter adapter) {
		delegate.restoreAadlComponentAdapter(adapter);
	}

	public void visitAadlFeatureAdapter(AadlFeatureAdapter adapter) {
		delegate.restoreAadlFeatureAdapter(adapter);
	}

	public void visitAadlConnectionAdapter(AadlConnectionAdapter adapter) {
		delegate.restoreAadlConnectionAdapter(adapter);
	}

}
