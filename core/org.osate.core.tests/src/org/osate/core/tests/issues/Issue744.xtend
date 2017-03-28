package org.osate.core.tests.issues

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner2)
@InjectWith(Aadl2UiInjectorProvider)
class Issue744 extends OsateTest {
	override getProjectName() {
		"issue744"
	}
	
	@Test
	def void issue744() {
		val pkg1FileName = "pk1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				abstract a1
					features
						p1: in data port d1.i;
				end a1;
				
				abstract implementation a1.i
					subcomponents
						asub1: abstract a2;
					connections
						conn1: port p1.dsub1 -> asub1.p2;
				end a1.i;
				
				data d1
				end d1;
				
				data implementation d1.i
					subcomponents
						dsub1: data;
				end d1.i;
				
				abstract a2
					features
						p2: in data port;
				end a2;
			end pkg1;
		''')
		suppressSerialization
		val testFileResult = testFile(pkg1FileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				ownedPortConnections.head => [
					"conn1".assertEquals(name)
					source.assertWarning(testFileResult.issues, issueCollection, "Aggregate data ports not supported by instantiator.")
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}