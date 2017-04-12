package org.osate.core.tests.issues

import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ProcessImplementation
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner2)
@InjectWith(Aadl2UiInjectorProvider)
class Issue794Test extends OsateTest {
	override getProjectName() {
		"issue794"
	}
	
	@Test
	def void issue794() {
		val pkg1FileName = "pkg1.aadl"
		createFiles(pkg1FileName -> '''
			package pkg1
			public
				process ps1
					features
						in1: in data port;
						in2: in data port;
						out1: out data port;
						out2: out data port;
						fg1: feature group fgt1;
						fg2: feature group fgt1;
					flows
						flow1: flow path in1 -> out1;
						flow2: flow path in1 -> out1;
						flow3: flow path fg1.fg_in1 -> fg1.fg_out1;
						flow4: flow path fg1.fg_in1 -> fg1.fg_out1;
						flow5: flow path fg1.fg_in1 -> fg1.fg_out1;
						flow6: flow path fg1 -> fg2;
						flow7: flow path fg1 -> fg2;
						flow8: flow path fg1 -> fg2;
				end ps1;
				
				process implementation ps1.i
					subcomponents
						sub1: thread t1;
					connections
						conn1: port in1 -> sub1.t_in;
						conn2: port sub1.t_out -> out1;
						conn3: port in2 -> sub1.t_in;
						conn4: port sub1.t_out -> out2;
						conn5: port fg1.fg_in1 -> sub1.t_in;
						conn6: port sub1.t_out -> fg1.fg_out1;
						conn7: port fg1.fg_in2 -> sub1.t_in;
						conn8: port sub1.t_out -> fg1.fg_out2;
						conn9: port fg2.fg_in1 -> sub1.t_in;
						conn10: port sub1.t_out -> fg2.fg_out1;
					flows
						flow1: flow path in1 -> conn1 -> sub1.t_flow -> conn2 -> out1;
						flow2: flow path in2 -> conn3 -> sub1.t_flow -> conn4 -> out2;
						flow3: flow path fg1.fg_in1 -> conn5 -> sub1.t_flow -> conn6 -> fg1.fg_out1;
						flow4: flow path fg1.fg_in2 -> conn7 -> sub1.t_flow -> conn8 -> fg1.fg_out2;
						flow5: flow path fg2.fg_in1 -> conn9 -> sub1.t_flow -> conn10 -> fg2.fg_out1;
						flow6: flow path fg1 -> conn5 -> sub1.t_flow -> conn10 -> fg2;
						flow7: flow path fg1.fg_in1 -> conn5 -> sub1.t_flow -> conn10 -> fg2.fg_out1;
						flow8: flow path fg2.fg_in1 -> conn9 -> sub1.t_flow -> conn6 -> fg1.fg_out1;
				end ps1.i;
				
				thread t1
					features
						t_in: in data port;
						t_out: out data port;
					flows
						t_flow: flow path t_in -> t_out;
				end t1;
				
				feature group fgt1
					features
						fg_in1: in data port;
						fg_in2: in data port;
						fg_out1: out data port;
						fg_out2: out data port;
				end fgt1;
			end pkg1;
		''')
		suppressSerialization
		val testFileResult = testFile(pkg1FileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.get(1) as ProcessImplementation => [
				"ps1.i".assertEquals(name)
				ownedFlowImplementations.get(1) => [
					"flow2".assertEquals(specification.name)
					assertError(testFileResult.issues, issueCollection,
						"'in2' does not match the in flow feature identifier 'in1' in the flow specification.",
						"'out2' does not match the out flow feature identifier 'out1' in the flow specification."
					)
				]
				ownedFlowImplementations.get(3) => [
					"flow4".assertEquals(specification.name)
					assertError(testFileResult.issues, issueCollection,
						"'fg1.fg_in2' does not match the in flow feature identifier 'fg1.fg_in1' in the flow specification.",
						"'fg1.fg_out2' does not match the out flow feature identifier 'fg1.fg_out1' in the flow specification."
					)
				]
				ownedFlowImplementations.get(4) => [
					"flow5".assertEquals(specification.name)
					assertError(testFileResult.issues, issueCollection,
						"'fg2.fg_in1' does not match the in flow feature identifier 'fg1.fg_in1' in the flow specification.",
						"'fg2.fg_out1' does not match the out flow feature identifier 'fg1.fg_out1' in the flow specification."
					)
				]
				ownedFlowImplementations.get(7) => [
					"flow8".assertEquals(specification.name)
					assertError(testFileResult.issues, issueCollection,
						"'fg2.fg_in1' does not match the in flow feature identifier 'fg1' in the flow specification.",
						"'fg1.fg_out1' does not match the out flow feature identifier 'fg2' in the flow specification."
					)
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}