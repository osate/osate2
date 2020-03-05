/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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
