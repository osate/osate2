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
class Issue986Test extends OsateTest {
	val static PROJECT_LOCATION = "org.osate.core.tests/models/issue986/"
	val static FILE1 = "package1.aadl"

	val static WARNING_NO_CLASSIFIER = "Instantiated subcomponent doesn't have a component classifier"
	
	val static S_I = "S.i"

	val static INSTANCE_NAME = "S_i_Instance"
	
	val static SUB_B = "b"
	val static SUB_B1 = "b1"
	
	@Test
	def void test1() {
		val testFileResult = loadFile(FILE1, PROJECT_LOCATION + FILE1)	
		val pkg = testFileResult.resource.contents.head as AadlPackage;
		val sysImpl = pkg.ownedPublicSection.ownedClassifiers.findFirst[name == S_I] as SystemImplementation
		
		/* Original problem was that instantiation would crash.  So simply completing this step 
		 * indicates success.
		 */
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals(INSTANCE_NAME, instance.name)

		val markers = instance.eResource.convertToIResource.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ONE)
		assertTrue(markers.length == 2)

		val sub_b = EcoreUtil.getURI(instance.componentInstances.findFirst[name == SUB_B]).toString()
		markers.findFirst[getAttribute("uri").equals(sub_b)] => [
			IMarker.SEVERITY_WARNING.assertEquals(attributes.get(IMarker.SEVERITY))
			WARNING_NO_CLASSIFIER.assertEquals(attributes.get(IMarker.MESSAGE))			
		]

		val sub_b1 = EcoreUtil.getURI(instance.componentInstances.findFirst[name == SUB_B1]).toString()
		markers.findFirst[getAttribute("uri").equals(sub_b1)] => [
			IMarker.SEVERITY_WARNING.assertEquals(attributes.get(IMarker.SEVERITY))
			WARNING_NO_CLASSIFIER.assertEquals(attributes.get(IMarker.MESSAGE))			
		]
	}

	private def FluentIssueCollection loadFile(String fname, String path) {
		createFiles(fname -> readFile(path))
		ignoreSerializationDifferences
		testFile(fname)
	}
}
