package org.osate.ui.dialogs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.dialogs.IInputValidator;
import org.osate.aadl2.NamedElement;

public class AadlIdentifierInputValidator implements IInputValidator {
	private static final char UNDERSCORE = '_';

	private static final String[] keywords = new String[] { "aadlboolean", "aadlinteger", "aadlreal", "aadlstring",
			"access", "all", "and", "annex", "applies", "binding", "bus", "calls", "classifier", "connections",
			"constant", "data", "delta", "device", "end", "enumeration", "event", "extends", "false", "features",
			"flow", "flows", "group", "implementation", "in", "inherit", "initial", "inverse", "is", "list", "memory",
			"mode", "modes", "none", "not", "of", "or", "out", "package", "parameter", "path", "port", "private",
			"process", "processor", "properties", "property", "provides", "public", "range", "reference", "refined",
			"refines", "requires", "server", "set", "sink", "source", "subcomponents", "subprogram", "system", "thread",
			"to", "true", "type", "units", "value" };

	private static final Set<String> keywordsSet = new HashSet<String>();

	/**
	 * Singleton reference to a validator that does not check the input against
	 * a list of forbidden names.
	 */
	public static final AadlIdentifierInputValidator DEFAULT = new AadlIdentifierInputValidator();

	/**
	 * A set of names that are forbidden.  That is, {@link #isValid}
	 * will return <code>false</code> if the input is a member of this set.
	 */
	private Set forbiddenNames = null;

	/*
	 * Static initializer to copy the keywords into the set.
	 */
	static {
		for (int i = 0; i < keywords.length; i++) {
			keywordsSet.add(keywords[i]);
		}
	}

	/**
	 * Private constructor to enforce singleton pattern for {@link #DEFAULT}.
	 */
	protected AadlIdentifierInputValidator() {
		super();
	}

	/**
	 * This method should be overridden by subclasses to return the set
	 * of names that are forbidden.  This method must not return <code>null</code>.
	 * If there are no names to be forbidden, it must return the empty set.
	 */
	protected Set<String> getForbiddenNames() {
		return Collections.EMPTY_SET;
	}

	/**
	 * Check that the given string is a legal AADL identifier.  The
	 * current implementation is not completely correct because the specification
	 * only allows letters from Row 00 of the ISO 10646 BMP.
	 */
	@Override
	public String isValid(final String newText) {
		if (forbiddenNames == null) {
			forbiddenNames = getForbiddenNames();
		}

		if (newText.length() == 0) {
			return "Name is empty";
		}
		if (!Character.isLetter(newText.charAt(0))) {
			return "First character must be a letter";
		}
		for (int i = 1; i < newText.length(); i++) {
			final char c = newText.charAt(i);
			if (!Character.isLetter(c) && !Character.isDigit(c) && c != UNDERSCORE) {
				return "Cannot contain '" + c + "'; only letters, numbers, and '_' are allowed";
			}
		}

		if (keywordsSet.contains(newText.toLowerCase())) {
			return "Identifier cannot be a keyword";
		} else if (forbiddenNames.contains(newText)) {
			return getForbiddenErrorMessage(newText);
		}
		// If we get here, the input is okay
		return null;
	}

	protected String getForbiddenErrorMessage(final String newText) {
		return "Identifier \"" + newText + "\" is already in use";
	}

	protected static void addNames(final Set<String> set, final List namedElements) {
		for (final Iterator i = namedElements.iterator(); i.hasNext();) {
			final NamedElement ne = (NamedElement) i.next();
			set.add(ne.getName());
		}
	}
}
