package org.osate.core.tests.issues

import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.xtext.junit4.InjectWith
import org.eclipselabs.xtext.utils.unittesting.XtextRunner2
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentImplementation
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertTrue
import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile
import static extension org.osate.aadl2.modelsupport.resources.OsateResourceUtil.convertToIResource

@RunWith(XtextRunner2)
@InjectWith(Aadl2UiInjectorProvider)
class Issue666Test extends OsateTest {
	override getProjectName() {
		"issue666"
	}
	
	@Test
	def void issue666() {
		val fileName = "issue666.aadl"
		createFiles(fileName -> '''
			package pkg1
			public
				abstract inner
					modes
						m1: initial mode;
						m2: mode;
				end inner;
				
				abstract outer
				end outer;
				
				abstract implementation outer.ok
					subcomponents
						sub1: abstract inner[9];
				end outer.ok;
				
				abstract implementation outer.tooManySOMs
					subcomponents
						sub2: abstract inner[10];
				end outer.tooManySOMs;
			end pkg1;
		''')
		suppressSerialization
		testFile(fileName).resource.contents.head as AadlPackage => [
			"pkg1".assertEquals(name)
			publicSection.ownedClassifiers.get(2) as ComponentImplementation => [
				"outer.ok".assertEquals(name)
				buildInstanceModelFile => [
					"outer_ok_Instance".assertEquals(name)
					512.assertEquals(systemOperationModes.size)
					eResource.convertToIResource.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ONE).empty.assertTrue
				]
			]
			publicSection.ownedClassifiers.get(3) as ComponentImplementation => [
				"outer.tooManySOMs".assertEquals(name)
				buildInstanceModelFile => [
					"outer_tooManySOMs_Instance".assertEquals(name)
					1000.assertEquals(systemOperationModes.size)
					eResource.convertToIResource.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_ONE) => [
						1.assertEquals(size)
						head => [
							IMarker.SEVERITY_ERROR.assertEquals(attributes.get(IMarker.SEVERITY))
							"List of System Operation Modes is incomplete.".assertEquals(attributes.get(IMarker.MESSAGE))
						]
					]
				]
			]
		]
	}
}