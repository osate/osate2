package org.osate.core.tests.issues

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue709Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void testConnections() {
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testHelper.parseString(aadlText)
		val cls = pkg.ownedPublicSection.ownedClassifiers
		
		pkg => [
			"pkg1".assertEquals(name)
			cls.get(1) as AbstractImplementation => [
				"a1.i".assertEquals(name)
				ownedFeatureGroupConnections.get(2) => [
					"conn3".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "The feature groups 'fg1' and 'fg1' are not inverses of each other.")
				]
				ownedFeatureGroupConnections.get(3) => [
					"conn4".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "The feature groups 'fg2' and 'fg2' are not inverses of each other.")
				]
				ownedFeatureGroupConnections.get(4) => [
					"conn5".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "The feature groups 'fg3' and 'fg3' are not inverses of each other.")
				]
				ownedFeatureGroupConnections.get(5) => [
					"conn6".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "The feature groups 'fg1' and 'fg4' are not inverses of each other.")
				]
				ownedFeatureGroupConnections.get(6) => [
					"conn7".assertEquals(name)
					assertError(testFileResult.issues, issueCollection, "The feature groups 'fg1' and 'fg5' are not inverses of each other.")
				]
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
	
	val aadlText = '''
package pkg1
public
	abstract a1
		features
			fg1: feature group fgt1;
			fg2: feature group inverse of fgt1;
			fg3: feature group fgt2;
			fg4: feature group inverse of fgt3;
			fg5: feature group fgt4;
	end a1;
	
	abstract implementation a1.i
		subcomponents
			sub1: abstract a1;
			sub2: abstract a1;
		connections
			--Correct
			conn1: feature group sub1.fg1 -> sub2.fg2;
			conn2: feature group sub1.fg1 -> sub2.fg3;
			
			--Same classifier, not inverse
			conn3: feature group sub1.fg1 -> sub2.fg1;
			conn4: feature group sub1.fg2 -> sub2.fg2;
			conn5: feature group sub1.fg3 -> sub2.fg3;
			
			--Inverses, but not same classifier
			conn6: feature group sub1.fg1 -> sub2.fg4;
			conn7: feature group sub1.fg1 -> sub2.fg5;
	end a1.i;
	
	feature group fgt1
	end fgt1;
	
	feature group fgt2
		inverse of fgt1
	end fgt2;
	
	feature group fgt3
	end fgt3;
	
	feature group fgt4
		inverse of fgt3
	end fgt4;
end pkg1;
'''
}