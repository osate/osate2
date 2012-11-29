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

import org.osate.imv.aadldiagram.adapters.AadlConnectionAdapter;
import org.osate.imv.aadldiagram.adapters.AadlFeatureAdapter;
import org.osate.imv.aadldiagram.providers.FlowHighlighterDelegate;


public class FlowHighlighterVisitor extends AadlAdapterVisitor {

	private FlowHighlighterDelegate delegate;
	private Object containerElement;

	public FlowHighlighterVisitor(FlowHighlighterDelegate delegate, Object containerElement) {
		this.delegate = delegate;
		this.containerElement = containerElement;
	}

	public void visitAadlFeatureAdapter(AadlFeatureAdapter adapter) {
		delegate.highlightFigure(adapter, containerElement);
	}

	public void visitAadlConnectionAdapter(AadlConnectionAdapter adapter) {
		delegate.highlightFigure(adapter, containerElement);
	}

}
