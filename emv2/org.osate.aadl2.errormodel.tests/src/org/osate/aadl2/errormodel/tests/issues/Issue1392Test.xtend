package org.osate.aadl2.errormodel.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.DefaultAnnexLibrary
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider
import org.osate.testsupport.TestHelper
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary

@RunWith(XtextRunner)
@InjectWith(ErrorModelInjectorProvider)
class Issue1392Test {
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue1392() {
		testHelper.parseString('''
			package MyEL
			public
				annex EMV2 {**
					error types extends MyEL with
						t: type extends ErrorLibrary::AboveRange;
						ts renames type set ErrorLibrary::TimingRelatedError;
					end types;
				**};
			end MyEL;
		''') => [
			publicSection.ownedAnnexLibraries.head as DefaultAnnexLibrary => [
				parsedAnnexLibrary as ErrorModelLibrary => [
					//Call getters to invoke linking and prove that there is no stack overflow.
					types.head.superType
					typesets.head.aliasedType
				]
			]
		]
	}
}