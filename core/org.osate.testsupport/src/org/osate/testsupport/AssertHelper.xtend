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
