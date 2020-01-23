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
package org.osate.testsupport

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import java.util.Comparator
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding
import org.eclipse.xtext.validation.Issue
import org.junit.ComparisonFailure
import org.osate.aadl2.modelsupport.util.AadlUtil
import org.osate.pluginsupport.PluginSupportUtil

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.isPredeclaredPropertySet

class AssertHelper {
	@Inject
	IScopeProvider scopeProvider

	@Inject
	@SerializerScopeProviderBinding
	IScopeProvider serializerScopeProvider

	def public static assertError(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection,
		String... expectedMessages) {
		assertIssue(eObject, allIssues, issueCollection, Severity.ERROR, expectedMessages)
	}

	def public static assertWarning(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection,
		String... expectedMessages) {
		assertIssue(eObject, allIssues, issueCollection, Severity.WARNING, expectedMessages)
	}

	def protected static assertIssue(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection,
		Severity severity, String... expectedMessages) {
		val issuesForEObject = allIssues.filter[it.severity == severity && uriToProblem == eObject.URI]
		val messagesForEObject = issuesForEObject.map[message]
		if (messagesForEObject.toSet != expectedMessages.toSet) {
			throw new ComparisonFailure("", expectedMessages.join("\n"), messagesForEObject.join("\n"))
		}
		issuesForEObject.forEach[issueCollection.addIssue(it)]
	}

	def public assertScope(EObject context, EReference reference, Iterable<String> expected) {
		assertScope(scopeProvider, context, reference, expected)
	}

	def public assertSerializerScope(EObject context, EReference reference, Iterable<String> expected) {
		assertScope(serializerScopeProvider, context, reference, expected)
	}

	def private assertScope(IScopeProvider scopeProvider, EObject context, EReference reference,
		Iterable<String> expected) {
		val expectedNames = expected.sortWith(CUSTOM_NAME_COMPARATOR).join(", ")
		val actual = scopeProvider.getScope(context, reference).allElements.filter [ eObjectDescription |
			val resourceURI = eObjectDescription.EObjectURI.trimFragment
			val fileName = resourceURI.trimFileExtension.segments.last
			!PluginSupportUtil.contributedAadl.contains(resourceURI) || fileName.predeclaredPropertySet
		]
		val actualNames = actual.map[name.toString("::")].sortWith(CUSTOM_NAME_COMPARATOR).join(", ")
		expectedNames.assertEquals(actualNames)
	}

	/*
	 * Compares two aadl names such that simple names are less than qualified names.
	 * If the name is qualified then names in predeclared property sets are greater than names in other packages or property sets.
	 * 
	 * Example: "id" < "ps::id" < "Memory_Properties::Heap_Size"
	 */
	val static CUSTOM_NAME_COMPARATOR = new Comparator<String>() {
		override compare(String o1, String o2) {
			val o1SeparatorIndex = o1.indexOf("::")
			val o2SeparatorIndex = o2.indexOf("::")
			if (o1SeparatorIndex == -1 && o2SeparatorIndex == -1) {
				o1.compareTo(o2)
			} else if (o1SeparatorIndex == -1) {
				-1
			} else if (o2SeparatorIndex == -1) {
				1
			} else {
				val o1PsIsPredeclared = AadlUtil::isPredeclaredPropertySet(o1.substring(0, o1SeparatorIndex))
				val o2PsIsPredeclared = AadlUtil::isPredeclaredPropertySet(o2.substring(0, o2SeparatorIndex))
				if (o1PsIsPredeclared == o2PsIsPredeclared) {
					o1.compareTo(o2)
				} else if (o2PsIsPredeclared) {
					-1
				} else {
					1
				}
			}
		}

		// Xtend requires this method to be overriden.  I should file a bug with Xtend
		override equals(Object obj) {
			class == obj.class
		}
	}

}
