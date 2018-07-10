package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue923Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue923/"
	val static FILE1 = "FeatureGroupTest.aadl"

	val static MAIN_IMPL = "Main.impl"

	val static INSTANCE_NAME = "Main_impl_Instance"
	
	@Inject
	TestHelper<AadlPackage> testHelper
	
	@Test
	def void test1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE1)
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == MAIN_IMPL] as SystemImplementation
		
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(INSTANCE_NAME, instance.name)

		// first connection was already correct, but let's make sure it stays that way
		val c1_src = instance.componentInstances.get(0).featureInstances.get(0).featureInstances.get(0).featureInstances.get(0)
		val c1_dst = instance.componentInstances.get(1).featureInstances.get(0).featureInstances.get(0).featureInstances.get(0)
		assertTrue(instance.connectionInstances.get(0).connectionReferences.get(0).source == c1_src)
		assertTrue(instance.connectionInstances.get(0).connectionReferences.get(0).destination == c1_dst)

		// second connection was wrong, but that's make sure it stays that way
		val c2_src = instance.componentInstances.get(0).featureInstances.get(0).featureInstances.get(0).featureInstances.get(0)
		val c2_dst = instance.componentInstances.get(1).featureInstances.get(1).featureInstances.get(0)
		assertTrue(instance.connectionInstances.get(1).connectionReferences.get(0).source == c2_src)
		assertTrue(instance.connectionInstances.get(1).connectionReferences.get(0).destination == c2_dst)
	}
}
