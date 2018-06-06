package org.osate.xtext.aadl2.resource.persistence

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import org.apache.log4j.Logger
import org.eclipse.xtext.generator.IFileSystemAccessExtension3
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.osate.xtext.aadl2.generator.Aadl2OutputConfigurationProvider

class Aadl2ResourceStorageFacade extends ResourceStorageFacade {

	static val Logger LOG = Logger.getLogger(ResourceStorageFacade)

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
		try {
			outStream.writeResource(resource)
		} catch(IOException e) {
			// something went wrong when writing the resource - stream's content is bogus and not written to disk
			LOG.warn("Cannot write storage for " + resource.URI, e)
			return;
		}
		fsa.generateFile(path, Aadl2OutputConfigurationProvider.AADLBIN_OUTPUT, new ByteArrayInputStream(bout.toByteArray, 0, bout.length))
	}
	
	private static class MyByteArrayOutputStream extends ByteArrayOutputStream {
		override toByteArray() { buf }
		def int length() { count }
	}
}