package org.osate.ge.internal.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.osate.ge.di.Activate;

public class SetDerivedModesCommandContributor {
	@Activate
	public Collection<Object> activate() {
		final Collection<Object> contributedCommands = new ArrayList<>();
		contributedCommands.add(new SetDerivedModesCommand(true));
		contributedCommands.add(new SetDerivedModesCommand(false));
		return contributedCommands;
	}
}
