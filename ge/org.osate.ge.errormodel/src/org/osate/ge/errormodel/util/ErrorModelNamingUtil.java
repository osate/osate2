package org.osate.ge.errormodel.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.osate.aadl2.NamedElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

public class ErrorModelNamingUtil {
	private final static Set<String> reservedWords; // Set which compares entries base on a case-insensitive comparison
	static {
		reservedWords = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		reservedWords.addAll(Arrays.asList(new String[] { "true", "false", "error" }));
	}

	public static String buildUniqueIdentifier(final ErrorModelLibrary lib, final String baseIdentifier) {
		final Set<String> existingIdentifiers = buildNameSet(lib);
		return buildUniqueIdentifier(existingIdentifiers, baseIdentifier);
	}

	public static String buildUniqueIdentifier(final ErrorModelSubclause sc, final String baseIdentifier) {
		final Set<String> existingIdentifiers = buildNameSet(sc);
		return buildUniqueIdentifier(existingIdentifiers, baseIdentifier);
	}

	public static String buildUniqueIdentifier(final ErrorBehaviorStateMachine sm, final String baseIdentifier) {
		final Set<String> existingIdentifiers = buildNameSet(sm);
		return buildUniqueIdentifier(existingIdentifiers, baseIdentifier);
	}

	/**
	 * Returns null if validation succeeds. Otherwise, returns a reason the name is not valid.
	 * @param lib
	 * @param oldName
	 * @param newName
	 * @return
	 */
	public static String validateName(final ErrorModelLibrary lib, final String oldName, final String newName) {
		return validateName(buildNameSet(lib), oldName, newName);
	}

	public static String validateName(final ErrorBehaviorStateMachine sm, final String oldName, final String newName) {
		return validateName(buildNameSet(sm), oldName, newName);
	}

	public static String validateName(final Set<String> existingNames, final String oldName, final String newName) {
    	if(newName.equalsIgnoreCase(oldName)) {
    		// Name is unchanged
    		return null;
    	}

		final Set<String> existingIdentifiers = existingNames;
		if(existingIdentifiers.contains(newName.toLowerCase())) {
			return "The specified name conflicts with an existing element.";
		}

		if(!newName.matches("[a-zA-Z]([_]?[a-zA-Z0-9])*")) {
			return "The specified name is not a valid identifier";
		}

		if (reservedWords.contains(newName)) {
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
			if(existingIdentifiers.contains(newIdentifier.toLowerCase())) {
				num++;
				newIdentifier = baseIdentifier + num;
			} else {
				done = true;
			}
		} while(!done);

		return newIdentifier;
	}

	private static Set<String> buildNameSet(final ErrorModelLibrary lib) {
		final Set<String> names = new HashSet<String>();
		addToNameSet(names, lib.getBehaviors());
		addToNameSet(names, lib.getMappings());
		addToNameSet(names, lib.getTransformations());
		addToNameSet(names, lib.getTypes());
		addToNameSet(names, lib.getTypesets());
		return names;
	}

	private static Set<String> buildNameSet(final ErrorModelSubclause sc) {
		final Set<String> names = new HashSet<String>();
		addToNameSet(names, sc.getConnectionErrorSources());
		addToNameSet(names, sc.getErrorDetections());
		addToNameSet(names, sc.getEvents());
		addToNameSet(names, sc.getFlows());
		addToNameSet(names, sc.getOutgoingPropagationConditions());
		addToNameSet(names, sc.getPaths());
		addToNameSet(names, sc.getPoints());
		addToNameSet(names, sc.getPropagations());
		addToNameSet(names, sc.getStates());
		addToNameSet(names, sc.getTransitions());
		return names;
	}

	private static Set<String> buildNameSet(final ErrorBehaviorStateMachine sm) {
		final Set<String> names = new HashSet<String>();
		ErrorModelNamingUtil.addToNameSet(names, sm.getEvents());
		ErrorModelNamingUtil.addToNameSet(names, sm.getStates());
		ErrorModelNamingUtil.addToNameSet(names, sm.getTransitions());
		return names;
	}

	public static void addToNameSet(final Set<String> names, final Collection<? extends NamedElement> elements) {
		for(final NamedElement el : elements) {
			if(el.getName() != null) {
				names.add(el.getName().toLowerCase());
			}
		}
	}
}
