package org.osate.aadl2.errormodel.tests.issues

import com.itemis.xtext.testing.FluentIssueCollection
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.errormodel.tests.ErrorModelUiInjectorProvider
import org.osate.core.test.OsateTest
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause

import static extension org.junit.Assert.assertEquals
import org.osate.aadl2.ComponentImplementation

@RunWith(XtextRunner)
@InjectWith(ErrorModelUiInjectorProvider)
class Issue14 extends OsateTest {
	@Test
	def void issue117() {
		val fileName = "issue14.aadl"
		createFiles(fileName -> '''
package issue14
public
	device battery
		features
			socket: requires bus access mybus;
			inp: in data port;
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
}