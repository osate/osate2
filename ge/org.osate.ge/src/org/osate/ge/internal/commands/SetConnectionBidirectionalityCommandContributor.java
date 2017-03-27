package org.osate.ge.internal.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.osate.ge.di.Activate;

public class SetConnectionBidirectionalityCommandContributor {
	@Activate
	public Collection<Object> activate() {
		final Collection<Object> contributedCommands = new ArrayList<>();
		contributedCommands.add(new SetConnectionBidirectionalityCommand(true));
		contributedCommands.add(new SetConnectionBidirectionalityCommand(false));
		return contributedCommands;
	}
}
