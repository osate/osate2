package org.osate.core.tests.issues

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static org.junit.Assert.*
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.aadl2.ComponentCategory
import org.osate.aadl2.instance.SystemInstance

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class Issue961Test extends OsateTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue961/"
	val static FILE1 = "abstractprocess.aadl"
	val static FILE2 = "package2.aadl"

	@Test
	def void test1() {
		val pkg = getPackage(FILE1, PROJECT_LOCATION + FILE1)
		
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
		val pkg = getPackage(FILE2, PROJECT_LOCATION + FILE2)

		val instance = getSystemInstance(pkg, "SSS.i", "SSS_i_Instance")		
		testSubSubComponentCategory(instance, "sub1", "s1", ComponentCategory.BUS)
		testSubSubComponentCategory(instance, "sub2", "s1", ComponentCategory.PROCESS)
	}
	
	private def AadlPackage getPackage(String fname, String path) {
		createFiles(fname -> readFile(path))
		ignoreSerializationDifferences
		testFile(fname).resource.contents.head as AadlPackage
	}
	
	private def static SystemInstance getSystemInstance(
		AadlPackage pkg, String systemImplName, String expectedInstanceName
	) {
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation "' + systemImplName + '" not found', cls.exists[name == systemImplName])
		
		// Instantiate system
		val sysImpl = cls.findFirst[name == systemImplName] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
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
