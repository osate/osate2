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
			annex emv2 {**
				use types ErrorLibrary;
				error propagations
				socket: out propagation {ServiceOmission};
				end propagations;
			**};
	end battery;
	bus mybus
	
	end mybus;
	system power
		features
			line1: requires bus access mybus;
			line2: requires bus access mybus;
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
			publicSection.ownedClassifiers.head => [
				"battery".assertEquals(name)
			]
			publicSection.ownedClassifiers.get(1) => [
				"mybus".assertEquals(name)
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}