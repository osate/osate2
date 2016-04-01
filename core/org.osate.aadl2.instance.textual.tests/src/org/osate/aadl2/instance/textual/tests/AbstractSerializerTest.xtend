package org.osate.aadl2.instance.textual.tests

import com.google.inject.Inject
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.serializer.ISerializer
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.ComponentImplementation
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals
import static extension org.junit.Assert.assertNotNull
import static extension org.osate.aadl2.instantiation.InstantiateModel.buildInstanceModelFile

abstract class AbstractSerializerTest extends OsateTest {
	@Inject
	extension ISerializer
	@Inject
	FileExtensionProvider extensionProvider
	
	def protected void assertSerialize(AadlPackage aadlPackage, String implName, String expected) {
		val impl = aadlPackage.publicSection.ownedClassifiers.filter(ComponentImplementation).findFirst[implName == name]
		impl.assertNotNull
		expected.assertEquals(impl.buildInstanceModelFile.serialize)
		val instanceFileName = implName.replace(".", "_") + "." + extensionProvider.primaryFileExtension
		createFiles(instanceFileName -> expected)
		testFile(instanceFileName)
	}
}