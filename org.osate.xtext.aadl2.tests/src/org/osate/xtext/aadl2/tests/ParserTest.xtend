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
			project.build(IncrementalProjectBuilder.CLEAN_BUILD,
					new NullProgressMonitor());
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
		
//		val property = entity.getFeatures().get(0) as Property
//		Assert::assertEquals("property", property.getName());
//		Assert::assertEquals("java.lang.String", property.getType().getIdentifier());
	}
	
//	@Test
//	def void testParsingAndLinking() {
//		'''
//			package example {
//			  entity MyEntity {
//			    property : String
//			    op foo(String s) : String {
//			    	this.property = s
//			    	return s.toUpperCase
//			    }
//			  }
//			}
//		'''.parse.assertNoErrors
//	}
//	
//	@Test
//	def void testParsingAndLinkingWithImports() {
//		'''
//			import java.util.List
//			package example {
//			  entity MyEntity {
//			    p : List<String>
//			  }
//			}
//		'''.parse.assertNoErrors
//	}
//	
//	@Test
//	def void testReturnTypeInference() {
//		val model = '''
//			package example {
//			  entity MyEntity {
//			    property : String
//			    op foo(String s) {
//			    	return property.toUpperCase + s
//			    }
//			  }
//			}
//		'''.parse
//		val pack = model.elements.head as PackageDeclaration
//		val entity = pack.elements.head as Entity
//		val op = entity.features.last as Operation
//		val method = op.jvmElements.head as JvmOperation
//		Assert::assertEquals("String", method.returnType.simpleName)
//	}
}