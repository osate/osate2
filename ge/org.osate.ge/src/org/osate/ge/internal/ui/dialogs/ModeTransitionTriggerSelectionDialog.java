/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Context;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.ProcessorFeature;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.TriggerPort;
import org.osate.ge.internal.util.AadlHelper;

public abstract class ModeTransitionTriggerSelectionDialog {
	
	/**
	 * Prompts the user to select triggers. Uses the passed in component classifier and mode transition to determine potential and selected choices
	 * @param cc
	 * @param mt
	 * @return an array containing the user's selection or null if the dialog was canceled.
	 */
	public static ModeTransitionTriggerInfo[] promptForTriggers(final ComponentClassifier cc, final ModeTransition mt) {
		final List<ModeTransitionTriggerInfo> ports = getPossibleModeTransitionTriggerPorts(cc);
		final ElementSelectionDialog triggerSelectionDlg = new ElementSelectionDialog(Display.getCurrent().getActiveShell(), "Select Trigger Ports", "Select mode transition triggers", ports);
		triggerSelectionDlg.setMultipleSelection(true);

		// Set initial selections
		if(mt != null) {
			final List<ModeTransitionTriggerInfo> currentTriggerPorts = new ArrayList<ModeTransitionTriggerInfo>();
			for(final ModeTransitionTrigger mtt : mt.getOwnedTriggers()) {
				currentTriggerPorts.add(new ModeTransitionTriggerInfo(mtt.getTriggerPort(), mtt.getContext()));
			}
			triggerSelectionDlg.setInitialSelections(currentTriggerPorts.toArray());
		}
		
		if(triggerSelectionDlg.open() == Window.CANCEL) {
			return null;
		}		

		final ModeTransitionTriggerInfo[] selectedPorts = triggerSelectionDlg.getAllSelectedElements(ModeTransitionTriggerInfo.class);
		if(selectedPorts.length == 0) {
			return null;
		}
		
		return selectedPorts;
	}
	
	/**
	 * Returns a list of ModeTransitionTriggerInfo objects that contains information about the valid options for configuring a mode transition trigger
	 * @param cc
	 * @return
	 */
	private static List<ModeTransitionTriggerInfo> getPossibleModeTransitionTriggerPorts(final ComponentClassifier cc) {
		final List<ModeTransitionTriggerInfo> ports = new ArrayList<ModeTransitionTriggerInfo>();
		
		// Get ports from the classifier and it's feature groups
		for(final Feature f : cc.getAllFeatures()) {
			if(f instanceof TriggerPort) {
				ports.add(new ModeTransitionTriggerInfo((TriggerPort)f, null));
			} else if(f instanceof FeatureGroup) {
				final FeatureGroup fg = (FeatureGroup)f;
				final FeatureGroupType fgt = fg.getAllFeatureGroupType();
				if(fgt != null) {
					for(final Feature fgFeature : fgt.getAllFeatures()) {
						if(fgFeature instanceof TriggerPort) {
							ports.add(new ModeTransitionTriggerInfo((TriggerPort)fgFeature, fg));
						}
					}
				}
			}
		}		

		if(cc instanceof ComponentImplementation) {
			final ComponentImplementation ci = (ComponentImplementation)cc;
			
			// Get Internal Features
			for(final InternalFeature f : AadlHelper.getAllInternalFeatures(ci)) {
				ports.add(new ModeTransitionTriggerInfo(f, null));
			}
			
			// Get Port Proxies
			for(final ProcessorFeature f : AadlHelper.getAllProcessorFeatures(ci)) {
				if(f instanceof TriggerPort) {
					ports.add(new ModeTransitionTriggerInfo((TriggerPort)f, null));
				}				
			}
			
			// Gets ports from the subcomponents
			for(final Subcomponent sc : ci.getAllSubcomponents()) {
				for(final Feature f : sc.getAllFeatures()) {
					if(f instanceof TriggerPort) {
						ports.add(new ModeTransitionTriggerInfo((TriggerPort)f, sc));
					}
				}
			}	
		}

		return ports;
	}
	
	// Class for storing info about possible triggers
	public static class ModeTransitionTriggerInfo {
		public final TriggerPort port;
		public final Context context;
		
		public ModeTransitionTriggerInfo(final TriggerPort port, final Context context) {
			this.port = port;
			this.context = context;
		}
		
		@Override
		public String toString() {
			if(context == null) {
				return port.getName();
			} else {
				return context.getName() + "." + port.getName();
			}
		}
		
		@Override
		public int hashCode() {
			return port.hashCode() + (context == null ? 0 : context.hashCode());
		}
		
		@Override
		public boolean equals(final Object obj) {
			if(!(obj instanceof ModeTransitionTriggerInfo)) {
				return false;
			}
			
			final ModeTransitionTriggerInfo p2 = (ModeTransitionTriggerInfo)obj;
			return port.equals(p2.port) && ((context == null && p2.context == null) || (context != null) && context.equals(p2.context));
		}
	}	
}
