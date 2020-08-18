package org.osate.ge.ba.businessobjecthandlers;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.ge.businessobjecthandling.RenameContext;

public class AadlNamingUtil {
	private final static Set<String> reservedWords; // Set which compares entries base on a case-insensitive comparison
	static {
		reservedWords = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		reservedWords.addAll(Arrays.asList(new String[] { "aadlboolean", "aadlinteger", "aadlreal", "aadlstring",
				"abstract", "access", "all", "and", "annex", "applies", "binding", "bus", "calls", "classifier",
				"compute", "connections", "constant", "data", "delta", "device", "end", "enumeration", "event",
				"extends", "false", "feature", "features", "flow", "flows", "group", "implementation", "in", "inherit",
				"initial", "inverse", "is", "list", "memory", "mode", "modes", "none", "not", "of", "or", "out",
				"package", "parameter", "path", "port", "private", "process", "processor", "properties", "property",
				"prototypes", "provides", "public", "range", "record", "reference", "refined", "renames", "requires",
				"self", "set", "sink", "source", "subcomponents", "subprogram", "system", "thread", "to", "true",
				"type", "units", "virtual", "with" }));
	}

	private AadlNamingUtil() {
	}

	/**
	 * Builds an identifier using the specified base that doesn't conflict with identifiers in the specified namespace
	 * @param namespace
	 * @param baseIdentifier
	 * @return an identifier that is unique in the specified namespace
	 */
	public static String buildUniqueIdentifier(final Namespace namespace, String baseIdentifier) {
		// If namespace is a classifier, prepend the classifier name into the identifier to help avoid conflicting with classifiers which extend the classifier.
		if (namespace instanceof Classifier) {
			baseIdentifier = namespace.getName().replace('.', '_') + "_" + baseIdentifier;
		}

		final Set<String> existingIdentifiers = buildNameSet(namespace.getMembers());

		// Resolve naming conflicts
		String newIdentifier = baseIdentifier;
		boolean done = false;
		int num = 1;
		do {
			if (existingIdentifiers.contains(newIdentifier)) {
				num++;
				newIdentifier = baseIdentifier + num;
			} else {
				done = true;
			}
		} while (!done);

		return newIdentifier;
	}

	/**
	 * Builds a set containing the names of a list of elements
	 * @param element
	 * @return a set which uses a case insensitive comparison rather than using hashCode() and equals().
	 */
	private static Set<String> buildNameSet(final Collection<? extends NamedElement> elements) {
		final Set<String> names = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		for (final NamedElement el : elements) {
			if (el.getName() != null) {
				names.add(el.getName());
			}
		}
		return names;
	}

	/**
	 * Determines whether a specified string is a valid AADL identifier
	 * @param value
	 * @return
	 */
	public static boolean isValidIdentifier(final String value) {
		if (reservedWords.contains(value)) {
			return false;
		}

		return value.matches("[a-zA-Z]([_]?[a-zA-Z0-9])*");
	}

	/**
	 * Returns whether an element with a specified name exists
	 * @param namespace
	 * @param name
	 * @return
	 */
	public static boolean isNameInUse(final Namespace namespace, final String name) {
		for (final NamedElement el : namespace.getMembers()) {
			if (name.equalsIgnoreCase(el.getName())) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Helper function for checking if a name is valid for a specified named element. Essentially a generic implementation of checkValueValid.
	 * @param ne
	 * @param name
	 * @return null is the name is valid. Otherwise a text string explaining why it is not.
	 */
	public static Optional<String> checkNameValidity(final RenameContext ctx) {
		final NamedElement ne = ctx.getBusinessObject(NamedElement.class).get();
		final String newName = ctx.getNewName();
		if (newName.equalsIgnoreCase(ne.getName())) {
			return Optional.empty();
		}

		if (!AadlNamingUtil.isValidIdentifier(newName)) {
			return Optional.of("The specified name is not a valid AADL identifier");
		}

		// Check for conflicts in the owning behavior annex
		final Element owner = ne.getOwner();
		if (AadlNamingUtil.isNameInUseInOwner(owner, newName)) {
			return Optional.of("The specified name conflicts with an existing member of the behavior annex.");
		}

		// Check for name conflicts in namespace
		if (AadlNamingUtil.isNameInUse(owner.getContainingClassifier().getNamespace(), newName)) {
			return Optional.of("The specified name conflicts with an existing member of the namespace.");
		}

		return Optional.empty();
	}

	public static boolean isNameInUseInOwner(final Element owner, final String newName) {
		return owner.getChildren().stream().filter(child -> {
			if (child instanceof NamedElement) {
				final NamedElement ne = (NamedElement) child;
				return newName.equalsIgnoreCase(ne.getName());
			}

			return false;
		}).findAny().isPresent();
	}
}
