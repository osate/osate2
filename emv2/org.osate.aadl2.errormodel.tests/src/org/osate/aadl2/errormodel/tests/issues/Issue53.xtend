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
class Issue53 extends OsateTest {
	@Test
	def void issue53() {
		val fileName = "issue53.aadl"
		createFiles(fileName -> '''
package issue53
public
	with EMV2;
system pedals
features
pedal_position : out data port ;
annex EMV2 {**                                                                                                   
use types errorlibrary;
use behavior ErrorLibrary::FailStop;

error propagations
    pedal_position : out propagation {badvalue};
end propagations;

properties
    EMV2::Likelihood    => ARP4761::Probable applies to pedal_position.serviceomission;
    EMV2::Severity     => ARP4761::Major applies to pedal_position.badvalue;
    **};
end pedals;

end issue53;
		''')
		suppressSerialization
		val testFileResult = testFile(fileName)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"issue53".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"pedals".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).properties.head => [
					assertError(testFileResult.issues, issueCollection, "Property EMV2::Likelihood applies to refers to type ServiceOmission not conained in type set of error propagation pedal_position")
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}