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
import static extension org.osate.testsupport.AssertHelper.assertWarning

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue744Test extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void issue744() {
	
		val testFileResult = issues = testHelper.testString(aadlText)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		val pkg = testFileResult.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		
		pkg => [
			assertEquals("pkg1", name)
			cls.get(1) as AbstractImplementation => [
				assertEquals("a1.i", name)
				ownedPortConnections.head => [
					"conn1".assertEquals(name)
					source.assertWarning(testFileResult.issues, issueCollection, "Aggregate data ports not supported by instantiator.")
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
			p1: in data port d1.i;
	end a1;
	
	abstract implementation a1.i
		subcomponents
			asub1: abstract a2;
		connections
			conn1: port p1.dsub1 -> asub1.p2;
	end a1.i;
	
	data d1
	end d1;
	
	data implementation d1.i
		subcomponents
			dsub1: data;
	end d1.i;
	
	abstract a2
		features
			p2: in data port;
	end a2;
end pkg1;
'''
}