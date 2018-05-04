package org.osate.ge.ba.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.osate.aadl2.NamedElement;
import org.osate.ba.aadlba.BehaviorAnnex;

public class BaNamingUtil {
	public static String buildUniqueIdentifier(final BehaviorAnnex ba, final String baseIdentifier) {
		final Set<String> existingIdentifiers = buildNameSet(ba);
		final String prefix = ba.getContainingClassifier() == null ? ""
				: (ba.getContainingClassifier().getName().replace('.', '_') + "_");
		return buildUniqueIdentifier(existingIdentifiers, prefix + baseIdentifier);
	}

	/**
	 * Returns null if validation succeeds. Otherwise, returns a reason the name is not valid.
	 * @param ba
	 * @param oldName
	 * @param newName
	 * @return
	 */
	public static String validateName(final BehaviorAnnex ba, final String oldName, final String newName) {
		return validateName(buildNameSet(ba), oldName, newName);
	}

	public static String validateName(final Set<String> existingNames, final String oldName, final String newName) {
		if (newName.equalsIgnoreCase(oldName)) {
			// Name is unchanged
			return null;
		}

		final Set<String> existingIdentifiers = existingNames;
		if (existingIdentifiers.contains(newName.toLowerCase())) {
			return "The specified name conflicts with an existing element.";
		}

		if (!newName.matches("[a-zA-Z]([_]?[a-zA-Z0-9])*")) {
			return "The specified name is not a valid identifier";
		}

		return null;
	}

	private static String buildUniqueIdentifier(final Set<String> existingIdentifiers, final String baseIdentifier) {
		// Resolve naming conflicts
		String newIdentifier = baseIdentifier;
		boolean done = false;
		int num = 1;
		do {
			if (existingIdentifiers.contains(newIdentifier.toLowerCase())) {
				num++;
				newIdentifier = baseIdentifier + num;
			} else {
				done = true;
			}
		} while (!done);

		return newIdentifier;
	}

	private static Set<String> buildNameSet(final BehaviorAnnex ba) {
		final Set<String> names = new HashSet<String>();
		addToNameSet(names, ba.getStates());
		addToNameSet(names, ba.getVariables());
		addToNameSet(names, ba.getTransitions());
		return names;
	}

	public static void addToNameSet(final Set<String> names, final Collection<? extends NamedElement> elements) {
		for (final NamedElement el : elements) {
			if (el.getName() != null) {
				names.add(el.getName().toLowerCase());
			}
		}
	}
}
