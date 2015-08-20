package org.osate.xtext.aadl2.resource.persistence

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import org.eclipse.xtext.generator.IFileSystemAccessExtension3
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.osate.xtext.aadl2.generator.Aadl2OutputConfigurationProvider

class Aadl2ResourceStorageFacade extends ResourceStorageFacade {

	new() {
		storeNodeModel = false
	}
	
	protected override getSourceContainerURI(StorageAwareResource resource) {
		resource.URI.trimSegments(resource.URI.segmentCount - 2).appendSegment("")
	}
	
	override void saveResource(StorageAwareResource resource, IFileSystemAccessExtension3 fsa) {
		val path = computeOutputPath(resource)
		val bout = new MyByteArrayOutputStream()
		val outStream = createResourceStorageWritable(bout)
		outStream.writeResource(resource)
		fsa.generateFile(path, Aadl2OutputConfigurationProvider.AADLBIN_OUTPUT, new ByteArrayInputStream(bout.toByteArray, 0, bout.length))
	}
	
	private static class MyByteArrayOutputStream extends ByteArrayOutputStream {
		override toByteArray() { buf }
		def int length() { count }
	}
}