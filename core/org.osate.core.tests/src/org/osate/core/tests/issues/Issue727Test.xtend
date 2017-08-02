package org.osate.core.tests.issues

import com.itemis.xtext.testing.FluentIssueCollection
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.SubprogramImplementation
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class Issue727Test extends OsateTest {
	override getProjectName() {
		"Issue_727_Test"
	}
	
	@Test
	def void testConnections() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				abstract a
					features
						p1: in data port;
						p2: out data port;
						af1: feature;
						af2: feature;
						fg1: feature group;
						fg2: feature group;
						da1: provides data access;
						da2: requires data access;
				end a;
				
				abstract implementation a.i
					connections
						conn1: port p1 -> p2;
						conn2: feature af1 -> af2;
						conn3: feature group fg1 -> fg2;
						conn4: data access da1 -> da2;
				end a.i;
				
				subprogram subp
					features
						param1: in parameter;
						param2: out parameter;
				end subp;
				
				subprogram implementation subp.i
					connections
						conn5: parameter param1 -> param2;
				end subp.i;
			end pkg1;
		''')
		suppressSerialization
		val testFileResult = testFile(pkg1FileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection => [
				ownedClassifiers.get(1) as AbstractImplementation => [
					"a.i".assertEquals(name)
					ownedPortConnections.head => [
						"conn1".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Illegal connection: Cannot directly connect two features of the containing component.")
					]
					ownedFeatureConnections.head => [
						"conn2".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Illegal connection: Cannot directly connect two features of the containing component.")
					]
					ownedFeatureGroupConnections.head => [
						"conn3".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Illegal connection: Cannot directly connect two features of the containing component.")
					]
					ownedAccessConnections.head => [
						"conn4".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Illegal connection: Cannot directly connect two features of the containing component.")
					]
				]
				ownedClassifiers.get(3) as SubprogramImplementation => [
					"subp.i".assertEquals(name)
					ownedParameterConnections.head => [
						"conn5".assertEquals(name)
						assertError(testFileResult.issues, issueCollection, "Illegal connection: Cannot directly connect two features of the containing component.")
					]
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}