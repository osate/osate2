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

package org.osate.imv.model;

import java.util.HashMap;
import java.util.Map;

import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.impl.Aadl2FactoryImpl;

public class ModeManager {


	public static final Mode ALL_MODES = Aadl2FactoryImpl.init().createMode();
	public static final Mode NO_MODES = Aadl2FactoryImpl.init().createMode();

	static {
		ALL_MODES.setName("all modes");
		NO_MODES.setName("no modes");
	}

	private Map<NamedElement, Mode> modeCache;

	public ModeManager() {
		this.modeCache = new HashMap<NamedElement, Mode>();
	}

	public void clearCache() {
		this.modeCache.clear();
	}

	public Mode getCurrentMode(NamedElement comp) {
		// Check if we have seen this component before, if so, return the cached mode.
		Mode mode = this.modeCache.get(comp);
		if(mode == null) {
			// This is the first time we've seen this component; therefore, the mode will be set to ALL_MODES.
			mode = ALL_MODES;
		}
		return mode;
	}

	public void setCurrentMode(Mode currentMode, NamedElement comp) {
//		ComponentImplementation containerInstance = (ComponentImplementation) currentMode.getContainingComponentImpl();
//		if(containerInstance != null && currentMode != ALL_MODES)
//			containerInstance.setCurrentMode(currentMode); // Set the new mode.
		// Cache the new mode.
		this.modeCache.put(comp, currentMode);
	}

}
