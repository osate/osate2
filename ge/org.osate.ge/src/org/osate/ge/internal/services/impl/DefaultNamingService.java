/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.services.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.ge.internal.services.NamingService;

public class DefaultNamingService implements NamingService {
	public static class ContextFunction extends SimpleServiceContextFunction<NamingService> {
		@Override
		public NamingService createService(final IEclipseContext context) {
			return new DefaultNamingService();
		}
	}


	private final static Set<String> reservedWords; // Set which compares entries base on a case-insensitive comparison
	static {
		reservedWords = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		reservedWords.addAll(Arrays.asList(new String[] {
				"aadlboolean",
				"aadlinteger",
				"aadlreal",
				"aadlstring",
				"abstract",
				"access",
				"all",
				"and",
				"annex",
				"applies",
				"binding",
				"bus",
				"calls",
				"classifier",
				"compute",
				"connections",
				"constant",
				"data",
				"delta",
				"device",
				"end",
				"enumeration",
				"event",
				"extends",
				"false",
				"feature",
				"features",
				"flow",
				"flows",
				"group",
				"implementation",
				"in",
				"inherit",
				"initial",
				"inverse",
				"is",
				"list",
				"memory",
				"mode",
				"modes",
				"none",
				"not",
				"of",
				"or",
				"out",
				"package",
				"parameter",
				"path",
				"port",
				"private",
				"process",
				"processor",
				"properties",
				"property",
				"prototypes",
				"provides",
				"public",
				"range",
				"record",
				"reference",
				"refined",
				"renames",
				"requires",
				"self",
				"set",
				"sink",
				"source",
				"subcomponents",
				"subprogram",
				"system",
				"thread",
				"to",
				"true",
				"type",
				"units",
				"virtual",
				"with"
		}));
	}

	@Override
	public String buildUniqueIdentifier(final Namespace namespace, String baseIdentifier) {
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
	private Set<String> buildNameSet(final Collection<? extends NamedElement> elements) {
		final Set<String> names = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		for (final NamedElement el : elements) {
			if (el.getName() != null) {
				names.add(el.getName());
			}
		}
		return names;
	}

	@Override
	public boolean isValidIdentifier(final String value) {
		if (reservedWords.contains(value)) {
			return false;
		}

		return value.matches("[a-zA-Z]([_]?[a-zA-Z0-9])*");
	}

	@Override
	public boolean isNameInUse(final Namespace namespace, final String name) {
		for (final NamedElement el : namespace.getMembers()) {
			if (name.equalsIgnoreCase(el.getName())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String checkNameValidity(final NamedElement ne, final String name) {
		// If the name hasn't changed or has only changed case
		if (name.equalsIgnoreCase(ne.getName())) {
			return null;
		}

		if (!isValidIdentifier(name)) {
			return "The specified name is not a valid AADL identifier";
		}

		// Check for conflicts in the namespace
		if (isNameInUse(ne.getNamespace(), name)) {
			return "The specified name conflicts with an existing member of the namespace.";
		}

		// The value is valid
		return null;
	}
}
