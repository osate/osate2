package org.osate.ge.internal.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EClass;
import org.osate.ge.di.Activate;
import org.osate.ge.internal.util.AadlFeatureUtil;

public class ChangeFeatureTypeCommandContributor {
	@Activate
	public Collection<Object> activate() {
		final Collection<Object> contributedCommands = new ArrayList<>();
		for(final EClass featureType : AadlFeatureUtil.getFeatureTypes()) {
			contributedCommands.add(new ChangeFeatureTypeCommand(featureType));
		}
		return contributedCommands;
	}
}
