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

import org.eclipse.draw2d.IFigure;
import org.osate.imv.aadldiagram.adapters.AadlConnectionAdapter;


public class ConnectionFilterVisitor extends AadlAdapterVisitor {

	public void visitAadlConnectionAdapter(AadlConnectionAdapter adapter) {
		IFigure srcFigure = adapter.getSourceAdapter().getFigure();
		IFigure dstFigure = adapter.getDestinationAdapter().getFigure();

		adapter.getFigure().setVisible(srcFigure.isVisible() && dstFigure.isVisible());
	}

}
