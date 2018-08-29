package org.osate.aadl2.errormodel.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue53Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper;
	
	@Test
	def void issue53() {
		val issue53 = '''
package issue53
public
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
		'''
		val testFileResult = issues = testHelper.testString(issue53)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"issue53".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"pedals".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).properties.head => [
					assertError(testFileResult.issues, issueCollection, "Property EMV2::Likelihood applies to refers to type ServiceOmission not contained in type set of error propagation pedal_position")
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}