/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.testsupport;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding;
import org.eclipse.xtext.validation.Issue;
import org.junit.ComparisonFailure;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.pluginsupport.PluginSupportUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;

public class AssertHelper {
	/*
	 * Compares two aadl names such that simple names are less than qualified names.
	 * If the name is qualified then names in predeclared property sets are greater than names in other packages or
	 * property sets.
	 *
	 * Example: "id" < "ps::id" < "Memory_Properties::Heap_Size"
	 */
	private static final Comparator<String> CUSTOM_NAME_COMPARATOR = AssertHelper::compareAadlNames;

	@Inject
	private IScopeProvider scopeProvider;

	@Inject
	@SerializerScopeProviderBinding
	private IScopeProvider serializerScopeProvider;

	public static void assertError(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection,
			String... expectedMessages) {
		assertIssue(eObject, allIssues, issueCollection, Severity.ERROR, expectedMessages);
	}

	public static void assertWarning(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection,
			String... expectedMessages) {
		assertIssue(eObject, allIssues, issueCollection, Severity.WARNING, expectedMessages);
	}

	protected static void assertIssue(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection,
			Severity severity, String... expectedMessages) {
		var eObjectURI = EcoreUtil.getURI(eObject);
		var issuesForEObject = new ArrayList<Issue>();
		for (var issue : allIssues) {
			if (issue.getSeverity() == severity && Objects.equals(issue.getUriToProblem(), eObjectURI)) {
				issuesForEObject.add(issue);
			}
		}
		var messagesForEObject = issuesForEObject.stream().map(Issue::getMessage).toList();

		/* Compare as sets so that order does not matter and duplicate messages collapse. */
		if (!new LinkedHashSet<>(messagesForEObject).equals(new LinkedHashSet<>(Arrays.asList(expectedMessages)))) {
			throw new ComparisonFailure("", String.join("\n", expectedMessages),
					String.join("\n", messagesForEObject));
		}
		issuesForEObject.forEach(issueCollection::addIssue);
	}

	public void assertScope(EObject context, EReference reference, Iterable<String> expected) {
		assertScope(scopeProvider, context, reference, expected);
	}

	public void assertSerializerScope(EObject context, EReference reference, Iterable<String> expected) {
		assertScope(serializerScopeProvider, context, reference, expected);
	}

	private void assertScope(IScopeProvider scopeProvider, EObject context, EReference reference,
			Iterable<String> expected) {
		var expectedNames = sortedAndJoined(expected);
		var actualNames = new ArrayList<String>();
		for (var eObjectDescription : scopeProvider.getScope(context, reference).getAllElements()) {
			var resourceURI = eObjectDescription.getEObjectURI().trimFragment();
			var segments = resourceURI.trimFileExtension().segments();
			var fileName = segments[segments.length - 1];
			if (!PluginSupportUtil.getContributedAadl().contains(resourceURI)
					|| AadlUtil.isPredeclaredPropertySet(fileName)) {
				actualNames.add(eObjectDescription.getName().toString("::"));
			}
		}
		assertEquals(expectedNames, sortedAndJoined(actualNames));
	}

	private static String sortedAndJoined(Iterable<String> names) {
		var sorted = new ArrayList<String>();
		for (var name : names) {
			sorted.add(name);
		}
		sorted.sort(CUSTOM_NAME_COMPARATOR);
		return String.join(", ", sorted);
	}

	private static int compareAadlNames(String o1, String o2) {
		var o1SeparatorIndex = o1.indexOf("::");
		var o2SeparatorIndex = o2.indexOf("::");
		if (o1SeparatorIndex == -1 && o2SeparatorIndex == -1) {
			return o1.compareTo(o2);
		}
		if (o1SeparatorIndex == -1) {
			return -1;
		}
		if (o2SeparatorIndex == -1) {
			return 1;
		}
		var o1PsIsPredeclared = AadlUtil.isPredeclaredPropertySet(o1.substring(0, o1SeparatorIndex));
		var o2PsIsPredeclared = AadlUtil.isPredeclaredPropertySet(o2.substring(0, o2SeparatorIndex));
		if (o1PsIsPredeclared == o2PsIsPredeclared) {
			return o1.compareTo(o2);
		}
		return o2PsIsPredeclared ? -1 : 1;
	}
}
