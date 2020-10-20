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
package org.osate.ge.errormodel.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.ge.businessobjecthandling.BusinessObjectHandler;
import org.osate.ge.businessobjecthandling.RenameContext;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

import com.google.common.base.Strings;

public class ErrorModelNamingUtil {
	private final static Set<String> reservedWords; // Set which compares entries base on a case-insensitive comparison
	static {
		reservedWords = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		reservedWords.addAll(Arrays.asList(new String[] { "true", "false", "error" }));
	}

	// All methods are static
	private ErrorModelNamingUtil() {
	}

	public static String buildUniqueIdentifier(final ErrorModelLibrary lib, final String baseIdentifier) {
		final Set<String> existingIdentifiers = buildNameSet(lib);
		return buildUniqueIdentifier(existingIdentifiers, baseIdentifier);
	}

	public static String buildUniqueIdentifier(final ErrorBehaviorStateMachine sm, final String baseIdentifier) {
		final Set<String> existingIdentifiers = buildNameSet(sm);
		return buildUniqueIdentifier(existingIdentifiers, baseIdentifier);
	}

	public static String buildUniqueIdentifier(final Classifier c, final String baseIdentifier) {
		final Set<String> existingIdentifiers = buildNameSet(c);
		final String prefix = c.getName() == null ? "" : c.getName().replace('.', '_') + "_";
		return buildUniqueIdentifier(existingIdentifiers, prefix + baseIdentifier);
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

	/**
	 * Validates a rename operation for a named element that is contained in a {@link ErrorModelSubclause}
	 * Checks the name against the names of the containing classifier's members and members of the error model subclause.
	 * @param ctx is the context passed to the {@link BusinessObjectHandler}
	 * @return an error message is the name is not valid or an empty optional if it is valid.
	 */
	public static Optional<String> validateSubclauseChildName(final RenameContext ctx) {
		return ctx.getBusinessObject(NamedElement.class).map(ne -> {
			final ErrorModelSubclause containingSubclause = (ErrorModelSubclause) ne.eContainer();
			final Set<String> names = new HashSet<String>();
			final Classifier classifier = containingSubclause.getContainingClassifier();
			ErrorModelNamingUtil.addToNameSet(names, classifier.getMembers());
			ErrorModelGeUtil.getAllErrorModelSubclauses(classifier).forEachOrdered(subclause -> {
				ErrorModelNamingUtil.addToNameSet(names, subclause.getPoints());
				ErrorModelNamingUtil.addToNameSet(names, subclause.getFlows());
				ErrorModelNamingUtil.addToNameSet(names, subclause.getPaths());
			});

			return ErrorModelNamingUtil.validateName(names, ne.getName(), ctx.getNewName());
		});
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
			if (existingIdentifiers.contains(newIdentifier.toLowerCase())) {
				num++;
				newIdentifier = baseIdentifier + num;
			} else {
				done = true;
			}
		} while (!done);

		return newIdentifier;
	}

	private static Set<String> buildNameSet(final Classifier classifier) {
		final Set<String> names = new HashSet<String>();

		ErrorModelGeUtil.getAllErrorModelSubclauses(classifier).forEachOrdered(subclause -> {
			addToNameSet(names, subclause.getErrorDetections());
			addToNameSet(names, subclause.getEvents());
			addToNameSet(names, subclause.getFlows());
			addToNameSet(names, subclause.getPaths());
			addToNameSet(names, subclause.getPoints());
			addToNameSet(names, subclause.getStates());
		});

		for (final Classifier tmp : classifier.getSelfPlusAllExtended()) {
			if (tmp == null) {
				continue;
			}

			for (final Element e : tmp.getOwnedElements()) {
				if (e instanceof NamedElement) {
					names.add(Strings.nullToEmpty(((NamedElement) e).getName()).toLowerCase());
				}
			}
		}

		return names;
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

	private static Set<String> buildNameSet(final ErrorBehaviorStateMachine sm) {
		final Set<String> names = new HashSet<String>();
		ErrorModelNamingUtil.addToNameSet(names, sm.getEvents());
		ErrorModelNamingUtil.addToNameSet(names, sm.getStates());
		ErrorModelNamingUtil.addToNameSet(names, sm.getTransitions());
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
