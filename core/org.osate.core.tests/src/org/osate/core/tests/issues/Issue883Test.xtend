package org.osate.core.tests.issues

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.Aadl2Factory
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.ComponentType
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class Issue883Test extends OsateTest {
	@Inject
	extension ISerializer
	@Inject
	Provider<XtextResourceSet> resourceSetProvider
	
	@Test
	def void issue883() {
		val expected = '''
			package pkg1
			public
				abstract a1
					features
						f1: feature;
				end a1;
			end pkg1;'''
		val pkg1 = Aadl2Factory.eINSTANCE.createAadlPackage => [
			name = "pkg1"
			createOwnedPublicSection => [
				createOwnedClassifier(Aadl2Package.eINSTANCE.abstractType) as ComponentType => [
					name = "a1"
					createOwnedAbstractFeature => [
						name = "f1"
					]
				]
			]
		]
		resourceSetProvider.get.createResource(URI.createURI("pkg1.aadl")).contents += pkg1
		expected.assertEquals(pkg1.serialize(SaveOptions.newBuilder.format.options))
	}
}