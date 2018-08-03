package org.osate.ui.dialogs;

import java.util.HashSet;
import java.util.Set;

import org.osate.aadl2.ComponentImplementation;

public class ComponentImplMemberInputValidator extends AadlIdentifierInputValidator {
	private final ComponentImplementation compImpl;

	public ComponentImplMemberInputValidator(final ComponentImplementation ci) {
		compImpl = ci;
	}

	@Override
	protected Set<String> getForbiddenNames() {
		final Set<String> names = new HashSet<String>();
		addNames(names, compImpl.getAllFeatures());
		addNames(names, compImpl.getAllSubcomponents());
		addNames(names, compImpl.getAllConnections());
		addNames(names, compImpl.getAllModes());
		addNames(names, compImpl.getAllFlowImplementations());
		addNames(names, compImpl.getAllEndToEndFlows());
		return names;
	}

	@Override
	protected String getForbiddenErrorMessage(final String newText) {
		return "Component implementation " + compImpl.getQualifiedName() + " already has a member \"" + newText + "\"";
	}
}
