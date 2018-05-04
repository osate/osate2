package org.osate.ui.dialogs;

import java.util.HashSet;
import java.util.Set;

import org.osate.aadl2.ComponentType;

public class ComponentTypeMemberInputValidator extends AadlIdentifierInputValidator {
	private final ComponentType compType;

	public ComponentTypeMemberInputValidator(final ComponentType ct) {
		compType = ct;
	}

	@Override
	protected Set<String> getForbiddenNames() {
		final Set<String> names = new HashSet<String>();
		addNames(names, compType.getAllFeatures());
		addNames(names, compType.getAllFlowSpecifications());
		return names;
	}

	@Override
	protected String getForbiddenErrorMessage(final String newText) {
		return "Component type " + compType.getQualifiedName() + " already has a member \"" + newText + "\"";
	}
}
