package org.osate.core.tests.issues

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import org.osate.aadl2.SystemImplementation
import com.itemis.xtext.testing.FluentIssueCollection

import static extension org.junit.Assert.*

import org.osate.aadl2.instantiation.InstantiateModel
import static extension org.osate.aadl2.modelsupport.resources.OsateResourceUtil.convertToIResource
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.emf.ecore.util.EcoreUtil

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class Issue923Test extends OsateTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/Issue923/"
	val static FILE1 = "FeatureGroupTest.aadl"

	val static MAIN_IMPL = "Main.impl"

	val static INSTANCE_NAME = "Main_impl_Instance"
	
	@Test
	def void test1() {
		val testFileResult = loadFile(FILE1, PROJECT_LOCATION + FILE1)	
		val pkg = testFileResult.resource.contents.head as AadlPackage
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == MAIN_IMPL] as SystemImplementation
		
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
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

	private def FluentIssueCollection loadFile(String fname, String path) {
		createFiles(fname -> readFile(path))
		ignoreSerializationDifferences
		testFile(fname)
	}
}
