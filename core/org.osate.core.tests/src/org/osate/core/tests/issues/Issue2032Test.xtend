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
class Issue2032Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue2032/"
	val static JUST_BUS = "JustBus.aadl"
	val static JUST_DATA = "JustData.aadl"
	val static JUST_SUBPROGRAM = "JustSubprogram.aadl"
	val static JUST_SUBPROGRAM_GROUP = "JustSubprogramGroup.aadl"
	val static ROOT_IMPL = "Root.impl"
	val static ROOT_INSTANCE = "Root_impl_Instance"
		
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void testJustBus() {
		test(JUST_BUS)
	}

	@Test
	def void testJustData() {
		test(JUST_DATA)
	}

	@Test
	def void testJustSubprogram() {
		test(JUST_SUBPROGRAM)
	}

	@Test
	def void testJustSubprogramGroup() {
		test(JUST_SUBPROGRAM_GROUP)
	}

	private def void test(String aadlFile) {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + aadlFile)

		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + ROOT_IMPL + '" not found', cls.exists[name == ROOT_IMPL])

		// Instantiate system
		val sysImpl = cls.findFirst[name == ROOT_IMPL] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(ROOT_INSTANCE, instance.name)
		
		// There should be exactly 2 connection instances
		val myS = instance.componentInstances.get(0)
		assertEquals(2, myS.connectionInstances.size)
		
		val ci1 = myS.connectionInstances.get(0)
		val ci2 = myS.connectionInstances.get(1)

		// Each connection instance should have 2 connection references
		val connRefs1 = ci1.connectionReferences
		val connRefs2 = ci2.connectionReferences
		assertEquals(2, connRefs1.size)
		assertEquals(2, connRefs2.size)
		
		// The two connection instances should follow opposite paths
		assertEquals(connRefs1.get(0).connection, connRefs2.get(1).connection)
		assertEquals(connRefs1.get(1).connection, connRefs2.get(0).connection)
	}
}
