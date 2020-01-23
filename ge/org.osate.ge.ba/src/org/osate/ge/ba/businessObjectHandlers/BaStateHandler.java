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
package org.osate.ge.ba.businessObjectHandlers;

import javax.inject.Named;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Classifier;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.ba.BaCategories;
import org.osate.ge.ba.util.BaNamingUtil;
import org.osate.ge.ba.util.BaUtil;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetBusinessObjectToModify;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;

public class BaStateHandler {
	private static final Graphic graphic = EllipseBuilder.create().build();

	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) BehaviorState state) {
		return true;
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration() {
		return GraphicalConfigurationBuilder.create().
				graphic(graphic).
				build();
	}

	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) BehaviorState state) {
		return state.getFullName();
	}

	// Creation
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries() {
		return new PaletteEntry[] {
				PaletteEntryBuilder.create().label("State").category(BaCategories.BEHAVIOR_ANNEX).build()
		};
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) Classifier c) {
		return true;
	}

	@GetBusinessObjectToModify
	public Object getBusinessObjectToModify(final @Named(Names.TARGET_BO) Classifier c) {
		final BehaviorAnnex ba = BaUtil.getBehaviorAnnex(c);
		return ba == null ? c : ba;
	}

	// TODO: AADL model is not being updated after creation of state.

	@Create
	public BehaviorState createBusinessObject(final @Named(Names.MODIFY_BO) Object modifyBo) {
		final BehaviorAnnex ba;
		if (modifyBo instanceof Classifier) {
			ba = BaUtil.getOrCreateBehaviorAnnex((Classifier) modifyBo);
		} else if (modifyBo instanceof BehaviorAnnex) {
			ba = (BehaviorAnnex) modifyBo;
		} else {
			throw new RuntimeException("Modify business object is not of expected type. BO: " + modifyBo);
		}

		// Create the state
		final BehaviorState newState = (BehaviorState)EcoreUtil.create(AadlBaPackage.eINSTANCE.getBehaviorState());
		final String newName = BaNamingUtil.buildUniqueIdentifier(ba, "new_state");
		newState.setName(newName);

		// Set as initial state if the behavior annex does not have an initial state.
		if (ba.getInitialState() == null) {
			newState.setInitial(true);
		}

		// Add the new state to the behavior annex
		ba.getStates().add(newState);

		return newState;
	}
}
