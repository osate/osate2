package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue1998Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue1998/"

	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void test1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "Issue1998_1.aadl")

		val system = getSystemInstance(pkg, "s.impl", "s_impl_Instance")
		val conns = system.connectionInstances
		assertTrue('There should be exactly one connection instance', conns.size == 1)
	}

	@Test
	def void test2() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + "Issue1998_2.aadl")

		val system = getSystemInstance(pkg, "s.impl", "s_impl_Instance")
		val conns = system.connectionInstances
		assertTrue('There should be exactly one connection instance', conns.size == 1)
	}

	private def static SystemInstance getSystemInstance(AadlPackage pkg, String systemImplName,
		String expectedInstanceName) {
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + systemImplName + '" not found', cls.exists[name == systemImplName])

		// Instantiate system
		val sysImpl = cls.findFirst[name == systemImplName] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(expectedInstanceName, instance.name)
		instance
	}
}
