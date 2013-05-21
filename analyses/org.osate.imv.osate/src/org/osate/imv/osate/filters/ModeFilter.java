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

package org.osate.imv.osate.filters;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.osate.aadl2.Connection;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Mode;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.imv.model.ModeManager;



public class ModeFilter extends ViewerFilter {

	/**
	 * The current mode used for filtering components.
	 */
	private Mode currentMode;

	public ModeFilter() {
		this.currentMode = ModeManager.ALL_MODES;
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {

		// All elements will be visible if no mode is set or mode is set to ALL_MODES.
		if(currentMode == null || currentMode.equals(ModeManager.ALL_MODES))
			return true;

		if(element instanceof Feature){
			return true;
		}

		if(element instanceof Subcomponent){
			// Get the mode that the subcomponent exists in.
			List<Mode> opModeList = ((Subcomponent)element).getInModes();
			if(opModeList.isEmpty()){
				// null indicates that the element exists in all modes.
				return true;
			}else if(opModeList.contains(currentMode)){
				return true;
			}
			return false;
		}

		if(element instanceof Connection){
			// Get the mode that the subcomponent exists in.
			List<Mode> opModeList = ((Connection)element).getInModes();
			if(opModeList.isEmpty()){
				// null indicates that the element exists in all modes.
				return true;
			}else if(opModeList.contains(currentMode)){
				return true;
			}
			return false;
		}

		if(element instanceof InstanceObject){
			// Get the mode that the instance object exists in.
			List<SystemOperationMode> opModeList = ((InstanceObject)element).getExistsInModes();
			if(opModeList == null){
				// null indicates that the element exists in all modes.
				return true;
			}else{
				// For each SOM, get the mode list and check if the current mode is present.
				for(Iterator<SystemOperationMode> it = opModeList.iterator(); it.hasNext(); ){
					// Current modes list will never be null.
					if(containsMode(it.next().getCurrentModes(),currentMode)){
						return true;
					}
				}
			}
			return false;
		}

		return false;
	}
	
	protected boolean containsMode(EList<ModeInstance> ml, Mode m){
		for (ModeInstance modeInstance : ml) {
			if (modeInstance.getMode() == m) return true;
		}
		return false;
	}

	public Mode getCurrentMode() {
		return currentMode;
	}

	public void setCurrentMode(Mode currentMode) {
		this.currentMode = currentMode;
	}

}
