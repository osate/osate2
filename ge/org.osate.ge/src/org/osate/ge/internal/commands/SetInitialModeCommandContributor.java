package org.osate.ge.internal.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.osate.ge.di.Activate;

public class SetInitialModeCommandContributor {
	@Activate
	public Collection<Object> activate() {
		final Collection<Object> contributedCommands = new ArrayList<>();
		contributedCommands.add(new SetInitialModeCommand(true));
		contributedCommands.add(new SetInitialModeCommand(false)); 
		return contributedCommands;
	}
}
