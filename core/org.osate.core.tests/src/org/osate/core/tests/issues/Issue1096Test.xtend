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
class Issue1096Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue1096/"
	val static FILE = "Issue1096.aadl"

	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void test1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE)

		val system = getSystemInstance(pkg, "main.impl", "main_impl_Instance")
		val proc = system.componentInstances.findFirst[name == 'proc']
		assertNotNull('process \'proc\' not found', proc)
		
		val mt = proc.modeTransitionInstances.findFirst[true]
		assertNotNull('no mode transition instance found', mt)
		assertTrue('missing property association', mt.ownedPropertyAssociations.size == 1)
		
		assertTrue('wrong property set', mt.ownedPropertyAssociations.head.property.name.equalsIgnoreCase('Mode_Transition_Response'))
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
