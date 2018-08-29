package org.osate.core.tests.issues

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentCategory
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instance.SystemInstance
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class Issue961Test {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue961/"
	val static FILE1 = "abstractprocess.aadl"
	val static FILE2 = "package2.aadl"
	
	@Inject
	TestHelper<AadlPackage> testHelper

	@Test
	def void test1() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE1)
		
		val instance1 = getSystemInstance(pkg, "s.i", "s_i_Instance")
		testSubComponentCategory(instance1, "p", ComponentCategory.PROCESS)
		testSubComponentCategory(instance1, "b", ComponentCategory.BUS)
		
		val instance2 = getSystemInstance(pkg, "s.j", "s_j_Instance")
		testSubComponentCategory(instance2, "x", ComponentCategory.ABSTRACT)
		
		val instance3 = getSystemInstance(pkg, "s.k", "s_k_Instance")
		testSubComponentCategory(instance3, "x", ComponentCategory.PROCESS)
	}

	@Test
	def void test2() {
		val pkg = testHelper.parseFile(PROJECT_LOCATION + FILE2)

		val instance = getSystemInstance(pkg, "SSS.i", "SSS_i_Instance")		
		testSubSubComponentCategory(instance, "sub1", "s1", ComponentCategory.BUS)
		testSubSubComponentCategory(instance, "sub2", "s1", ComponentCategory.PROCESS)
	}
	
	private def static SystemInstance getSystemInstance(
		AadlPackage pkg, String systemImplName, String expectedInstanceName
	) {
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + systemImplName + '" not found', cls.exists[name == systemImplName])
		
		// Instantiate system
		val sysImpl = cls.findFirst[name == systemImplName] as SystemImplementation
		val instance = InstantiateModel.instantiate(sysImpl)
		assertEquals(expectedInstanceName, instance.name)
		return instance
		
	}
	
	private def static testSubComponentCategory(
		SystemInstance instance, String subName, ComponentCategory expectedCategory
	) {
		val sub = instance.componentInstances.findFirst[name == subName]
		val subCat = sub.category;
		assertTrue(subName + ' has category ' + subCat + '; expected "' + expectedCategory.getName + '"', subCat == expectedCategory)
	}
	
	private def static testSubSubComponentCategory(
		SystemInstance instance, String sub1Name, String sub2Name, ComponentCategory expectedCategory
	) {
		val sub = instance.componentInstances.findFirst[name == sub1Name]
		val subSub = sub.componentInstances.findFirst[name == sub2Name]
		val subSubCat = subSub.category;
		assertTrue(sub1Name + '.' + sub2Name + ' has category ' + subSubCat + '; expected "' + expectedCategory.getName + '"', subSubCat == expectedCategory)
	}
}
