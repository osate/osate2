package org.osate.ge.internal.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.osate.aadl2.AccessType;
import org.osate.ge.di.Activate;

public class SetFeatureKindCommandContributor {
	@Activate
	public Collection<Object> activate() {
		final Collection<Object> contributedCommands = new ArrayList<>();
		contributedCommands.add(new SetFeatureKindCommand(AccessType.PROVIDES));
		contributedCommands.add(new SetFeatureKindCommand(AccessType.REQUIRES));
		return contributedCommands;
	}
}
