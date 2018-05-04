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
class Issue761Test extends OsateTest {
	@Test
	def void issue761() {
		val aadlFile = "issue761.aadl"
		createFiles(aadlFile -> aadlText)
		suppressSerialization
		val result = testFile(aadlFile)

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
		assertEquals(problems.head.getAttribute("message"), "Cyclic containment dependency: Feature 'f' has already been instantiated as enclosing feature group.")
	}

	val aadlText = '''
		package issue761
		public
			feature group F
				features
					f: feature group F;
			end F;
			
			system S
				features
					f: feature group F;
			end S;
		
			system implementation S.i
			end S.i;
		
		end issue761;
	'''
}
