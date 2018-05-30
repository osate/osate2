package org.osate.aadl2.errormodel.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.IResourceServiceProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.validation.CheckMode
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexSubclause
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestResourceSet
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue53Test extends XtextTest {

	@Inject
	ParseHelper<AadlPackage> parseHelper;

	@Inject
	TestResourceSet resourceSet;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	@Test
	def void issue53() {
		// Can't use loadModel() because we have a string...
		val pkg = parseHelper.parse(aadlText, URI.createFileURI('Issue53Test.aadl'), resourceSet.get())

		// Get the list of syntax, name resolution, and validation issues from the resource.
		// If we read files instead of processing a string, this would be part of loadModel().
		val r = pkg.eResource()
		val provider = serviceProviderRegistry.getResourceServiceProvider(r.URI)
		val issueList = provider.resourceValidator.validate(r, CheckMode.ALL, null)
		// Variable issues must be initialized for call to assertConstraints()
		issues = new FluentIssueCollection(pkg.eResource(), issueList, newArrayList)
		
		val issueCollection = new FluentIssueCollection(issues.resource, newArrayList, newArrayList)
		pkg => [
			"issue53".assertEquals(name)
			publicSection.ownedClassifiers.head => [
				"pedals".assertEquals(name)
				((ownedAnnexSubclauses.head as DefaultAnnexSubclause).parsedAnnexSubclause as ErrorModelSubclause).
					properties.head => [
					assertError(issues.issues, issueCollection,
						"Property EMV2::Likelihood applies to refers to type ServiceOmission not contained in type set of error propagation pedal_position")
				]
			]
		]
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}

	val aadlText = '''
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
	'''
}
