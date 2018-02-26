/*******************************************************************************
 * Copyright (C) 2013 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0073.
 *******************************************************************************/
package org.osate.ge.internal.services.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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

	@Override
	public String buildUniqueIdentifier(final Namespace namespace, String baseIdentifier) {
		// If namespace is a classifier, prepend the classifier name into the identifier to help avoid conflicting with classifiers which extend the classifier.
		if(namespace instanceof Classifier) {
			baseIdentifier = namespace.getName().replace('.', '_') + "_" + baseIdentifier;
		}

		final Set<String> existingIdentifiers = buildNameSet(namespace.getMembers());

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

	/**
	 * Builds a set containing the names of a list of elements
	 * @param elements
	 * @param namedElements
	 * @return
	 */
	private Set<String> buildNameSet(final Collection<? extends NamedElement> elements) {
		final Set<String> names = new HashSet<String>();
		for(final NamedElement el : elements) {
			if(el.getName() != null) {
				names.add(el.getName().toLowerCase());
			}
		}
		return names;
	}

	@Override
	public boolean isValidIdentifier(final String value) {
		if(reservedWords.contains(value.toLowerCase())) {
			return false;
		}

		return value.matches("[a-zA-Z]([_]?[a-zA-Z0-9])*");
	}

	@Override
	public boolean isNameInUse(final Namespace namespace, final String name) {
		for(final NamedElement el : namespace.getMembers()) {
			if(name.equalsIgnoreCase(el.getName())) {
				return true;
			}
		}

		return false;
	}

	@Override
	public String checkNameValidity(final NamedElement ne, final String name) {
		// If the name hasn't changed or has only changed case
		if(name.equalsIgnoreCase(ne.getName())) {
			return null;
		}

		if(!isValidIdentifier(name)) {
			return "The specified name is not a valid AADL identifier";
		}

		// Check for conflicts in the namespace
		if(isNameInUse(ne.getNamespace(), name)) {
			return "The specified name conflicts with an existing member of the namespace.";
		}

		// The value is valid
		return null;
	}


	final static HashSet<String> reservedWords = new HashSet<String>(Arrays.asList(new String[] {
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
