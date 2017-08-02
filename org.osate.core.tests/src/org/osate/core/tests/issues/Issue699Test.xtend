package org.osate.core.tests.issues

import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.Path
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SystemImplementation
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static org.junit.Assert.*

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class Issue699Test extends OsateTest {
	override getProjectName() {
		"issue699"
	}

	@Test
	def void issue699() {
		val aadlFile = "issue699.aadl"
		val psFile = "ps699.aadl"
		createFiles(psFile -> psText, aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile, psFile)

		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('System implementation S.i not found', cls.exists[name == 'S.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'S.i'] as SystemImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals('S_i_Instance', instance.name)

		// check for cyclicity error
		val IResource resource = ResourcesPlugin.workspace.root.getFile(new Path(instance.eResource.URI.toPlatformString(true)));
		var IMarker[] problems = null
		val depth = IResource.DEPTH_INFINITE
		try {
			problems = resource.findMarkers(IMarker.MARKER, true, depth)
		} catch (CoreException e) { // something went wrong
			e.printStackTrace
		}
		assertEquals(problems.length, 1)
		assertEquals(problems.head.getAttribute("message"), "Property ps699::p has cyclic value")
	}

	val aadlText = '''
		package issue699
		public
			with ps699;
			system S
			end S;
			
			system implementation S.i
				properties
					ps699::p => ps699::q;
					ps699::q => ps699::p;
			end S.i;
		
		end issue699;
	'''
	val psText = '''
		property set ps699 is
			p: aadlinteger applies to (all);
			q: aadlinteger applies to (all);
		end ps699;
	'''
}
