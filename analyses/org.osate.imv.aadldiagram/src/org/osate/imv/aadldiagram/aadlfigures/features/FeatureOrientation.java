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

public enum FeatureOrientation {

	NORTH(0),

	EAST(1),

	SOUTH(2),

	WEST(3);

	public static final int NORTH_VALUE = 0;
	public static final int EAST_VALUE = 1;
	public static final int SOUTH_VALUE = 2;
	public static final int WEST_VALUE = 3;

	private final int value;

	private FeatureOrientation(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public static FeatureOrientation get(int value) {
		switch(value) {
		case NORTH_VALUE:
			return NORTH;
		case EAST_VALUE:
			return EAST;
		case SOUTH_VALUE:
			return SOUTH;
		case WEST_VALUE:
			return WEST;
		}
		return null;
	}
}
