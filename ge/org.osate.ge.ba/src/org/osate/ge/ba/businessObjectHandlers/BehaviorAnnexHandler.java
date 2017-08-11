package org.osate.ge.ba.businessObjectHandlers;

import javax.inject.Named;

import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorAnnex;
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
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;

public class BehaviorAnnexHandler {
	private static final String ANNEX_NAME = "behavior_specification";
	private static final Graphic graphic = RectangleBuilder.create().build();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) BehaviorAnnex ba) {
		return true;
	}
	
	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration() {
		return GraphicalConfigurationBuilder.create().
			graphic(graphic).
			build();
	}
	
	@GetName
	public String getName() {
		return "Behavior Specification";
	}
	
	// Creation
	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries() {
		return new PaletteEntry[] { 
			PaletteEntryBuilder.create().label("Behavior Specification").category(BaCategories.BEHAVIOR_ANNEX).build()
		};
	}
	
	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BO) ComponentClassifier cc) {
		return !hasBehaviorAnnex(cc);
	}
	
	@Create
	public Object createBusinessObject(final @Named(Names.OWNER_BO) ComponentClassifier cc) {				
		// Must create new annex
		final DefaultAnnexSubclause defaultSubclause = (DefaultAnnexSubclause)cc.createOwnedAnnexSubclause(Aadl2Package.eINSTANCE.getDefaultAnnexSubclause());
		defaultSubclause.setName(ANNEX_NAME);
		defaultSubclause.setSourceText("{**\n states initial_state : initial state;\n **}");
		
		// Create the BehaviorAnnex
		final BehaviorAnnex behaviorAnnex = (BehaviorAnnex)defaultSubclause.createParsedAnnexSubclause(AadlBaPackage.eINSTANCE.getBehaviorAnnex());
		behaviorAnnex.setName(ANNEX_NAME);
		
		return behaviorAnnex;
	}
	
	private static boolean hasBehaviorAnnex(final ComponentClassifier cc) {
		for(final AnnexSubclause subclause : cc.getOwnedAnnexSubclauses()) {
			if(subclause.getName().equals(ANNEX_NAME)) {
				return true;
			}
		}
		
		return false;
	}
}
