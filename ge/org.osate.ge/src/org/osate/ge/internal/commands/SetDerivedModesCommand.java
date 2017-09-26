package org.osate.ge.internal.commands;

import javax.inject.Named;

import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.ge.di.Activate;
import org.osate.ge.di.CanActivate;
import org.osate.ge.di.GetLabel;
import org.osate.ge.di.IsAvailable;
import org.osate.ge.di.Names;
import org.osate.ge.internal.di.GetBusinessObjectToModify;

public class SetDerivedModesCommand {
	private final boolean derivedModes;

	public SetDerivedModesCommand(final boolean derivedModes) {
		this.derivedModes = derivedModes;
	}

	@GetLabel
	public String getLabel() {
		return derivedModes ? "Change to Derived Modes" : "Change to Non-derived Modes";
	}

	@IsAvailable
	public boolean isAvailable(@Named(Names.BUSINESS_OBJECT) final ComponentType cc) {
		// Only allow setting the value if the new value would be different, the classifier contains nodes, and the classifier has not inherited any modes or mode transitions
		return cc.isDerivedModes() != derivedModes && (cc.getOwnedModes().size() > 0 || cc.getOwnedModeTransitions().size() > 0) && cc.getAllModes().size() == cc.getOwnedModes().size() && cc.getAllModeTransitions().size() == cc.getOwnedModeTransitions().size();
	}

	@CanActivate
	public boolean canActivate(@Named(Names.BUSINESS_OBJECT) final ComponentClassifier cc) {
		// Only allow changing whether the modes are derived if it is being set to false or if there are no mode transitions. Mode transitions are not allowed
		// in requires mode clauses
		return !derivedModes || cc.getOwnedModeTransitions().size() == 0;
	}

	@GetBusinessObjectToModify
	public Object getBusinessObjectToModify(@Named(Names.BUSINESS_OBJECT) final Object bo) {
		return bo;
	}

	@Activate
	public boolean activate(@Named(Names.BUSINESS_OBJECT) final ComponentClassifier cc) {
		cc.setDerivedModes(derivedModes);
		return true;
	}
}
