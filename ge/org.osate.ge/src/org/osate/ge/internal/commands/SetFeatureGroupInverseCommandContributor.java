package org.osate.ge.internal.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.osate.ge.di.Activate;

public class SetFeatureGroupInverseCommandContributor {
	@Activate
	public Collection<Object> activate() {
		final Collection<Object> contributedCommands = new ArrayList<>();
		contributedCommands.add(new SetFeatureGroupInverseCommand(true));
		contributedCommands.add(new SetFeatureGroupInverseCommand(false));
		return contributedCommands;
	}
}
