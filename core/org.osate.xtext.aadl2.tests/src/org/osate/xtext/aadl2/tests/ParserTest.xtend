package org.osate.xtext.aadl2.tests

import com.google.inject.Inject
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ModelUnit
import org.osate.aadl2.SystemType
import org.osate.xtext.aadl2.Aadl2UiInjectorProvider

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class ParserTest {

	@Inject extension ParseHelper<ModelUnit>

	@Before
	def setUp() {
		val workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		val project = workspaceRoot.getProject("Plugin_Resources");
		Assert.assertTrue(project.exists());
		try {
			project.build(IncrementalProjectBuilder.CLEAN_BUILD, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Test
	def void testParsing() {
		val model = '''
			package example
			public
			  system sys
			    subcomponents
			      none;
			    properties
			      none;
			end example;
		'''.parse

		val pack = model as AadlPackage
		Assert::assertEquals("example", pack.name)

		val sys = pack.publicSection.ownedClassifiers.get(0) as SystemType
		Assert::assertEquals("sys", sys.name)
	}
}
