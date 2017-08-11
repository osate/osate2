package org.osate.ge.internal.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.osate.aadl2.DirectionType;
import org.osate.ge.di.Activate;

public class SetFeatureDirectionCommandContributor {
	@Activate
	public Collection<Object> activate() {
		final Collection<Object> contributedCommands = new ArrayList<>();
		contributedCommands.add(new SetFeatureDirectionCommand(DirectionType.IN));
		contributedCommands.add(new SetFeatureDirectionCommand(DirectionType.OUT));
		contributedCommands.add(new SetFeatureDirectionCommand(DirectionType.IN_OUT));
		return contributedCommands;
	}

}
