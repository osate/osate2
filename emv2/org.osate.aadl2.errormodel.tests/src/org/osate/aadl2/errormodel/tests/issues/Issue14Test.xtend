package org.osate.aadl2.errormodel.tests.issues

import com.itemis.xtext.testing.FluentIssueCollection
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.errormodel.tests.ErrorModelUiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(ErrorModelUiInjectorProvider)
class Issue14Test extends OsateTest {
	@Test
	def void issue14() {
		val fileName = "issue14.aadl"
		createFiles(fileName -> '''
package issue14
public
	device battery
		features
			socket: requires bus access mybus;
			annex emv2 {**
				use types ErrorLibrary;
				error propagations
				socket: out propagation {ServiceOmission};
				socket: in propagation {ItemOmission};
				end propagations;
			**};
	end battery;
	bus mybus
	
	end mybus;
	system power
		features
			line1: requires bus access mybus;
			line2: requires bus access mybus;
			annex emv2 {**
				use types ErrorLibrary;
				error propagations
				line1: out propagation {ValueError};
				line1: in propagation {TimingError};
				line2: out propagation {ValueError};
				end propagations;
			**};
	end power;
	system implementation power.generic
		subcomponents
			battery1: device battery;
			battery2: device battery;
		connections
			pwr1: bus access line1 <-> battery1.socket;
			pwr2: bus access  battery2.socket <-> line2;
	end power.generic;
end issue14;
		''')
		suppressSerialization
		val testFileResult = testFile(fileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"issue14".assertEquals(name)
			publicSection.ownedClassifiers.get(3) as ComponentImplementation=> [
				"power.generic".assertEquals(name)
				allConnections.get(0) => [
					"pwr1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Reverse direction: Destination propagation  socket{ServiceOmission} has error types not handled by source propagation line1{ValueError}", "Source propagation  line1{TimingError} has error types not handled by destination propagation socket{ItemOmission}")
				]
				allConnections.get(1) => [
					"pwr2".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Source propagation  socket{ServiceOmission} has error types not handled by destination propagation line2{ValueError}")
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
	@Test
	def void issue14_1() {
		val fileName = "issue14_1.aadl"
		createFiles(fileName -> '''
package issue14_1
public
	abstract sender
		features
			outp: in out data port;
			annex emv2 {**
				use types ErrorLibrary;
				error propagations
				outp: out propagation {ServiceOmission};
				end propagations;
			**};
	end sender;
	abstract receiver
		features
			inp: in out data port;
			annex emv2 {**
				use types ErrorLibrary;
				error propagations
				inp: in propagation {ValueError};
				inp: out propagation {ValueError};
				end propagations;
			**};
	end receiver;
	system processing
	end processing;
	system implementation processing.generic
		subcomponents
			send: abstract sender;
			receive: abstract receiver;
		connections
			conn1: port send.outp <-> receive.inp; 
	end processing.generic;
end issue14_1;
		''')
		suppressSerialization
		val testFileResult = testFile(fileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"issue14_1".assertEquals(name)
			publicSection.ownedClassifiers.get(3) as ComponentImplementation=> [
				"processing.generic".assertEquals(name)
				allConnections.get(0) => [
					"conn1".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "Source propagation  outp{ServiceOmission} has error types not handled by destination propagation inp{ValueError}")
					assertWarning(testFileResult.issues, issueCollection, "No incoming error propagation for outgoing propagation inp{ValueError}")
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}