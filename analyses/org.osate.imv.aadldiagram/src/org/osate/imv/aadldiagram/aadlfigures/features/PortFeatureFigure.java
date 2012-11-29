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

package org.osate.imv.aadldiagram.aadlfigures.features;

import org.osate.imv.aadldiagram.adapters.FeatureDirectionType;

public abstract class PortFeatureFigure extends DirectedFeatureFigure {

	public static final int V_EXTENT = 15; // Must be odd #
	public static final int H_EXTENT = 15; // Must be odd #


	public PortFeatureFigure(String label, FeatureDirectionType direction, FeatureLabelStyle labelStyle) {
		super(label, direction, labelStyle);
	}

	protected int getSymbolHorizontalExtent() {
		return H_EXTENT;
	}

	protected int getSymbolVerticalExtent() {
		return V_EXTENT;
	}

}
