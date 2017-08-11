package org.osate.ge.ba.businessObjectHandlers;

import javax.inject.Named;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorState;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.ba.BaCategories;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.Create;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.EllipseBuilder;
import org.osate.ge.graphics.Graphic;

public class StateHandler {
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
	public boolean canCreate(final @Named(Names.TARGET_BO) BehaviorAnnex ba) {
		return true;
	}
	
	// TODO: AADL model is not being updated after creation of state.
	
	@Create
	public BehaviorState createBusinessObject(final @Named(Names.OWNER_BO) BehaviorAnnex ba) {
		// Create the state
		final BehaviorState newState = (BehaviorState)EcoreUtil.create(AadlBaPackage.eINSTANCE.getBehaviorState());
		final String newStateName = "new_state"; // TODO: Need to build unique identifier
		newState.setName(newStateName);
		
		// Add the new state to the behavior annex
		ba.getStates().add(newState);
		
		return newState;
	}
}
