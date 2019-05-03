package org.osate.xtext.aadl2.ui.resource

import org.eclipse.core.resources.IStorage
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.PlatformObject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class ContributedAadlStorage extends PlatformObject implements IStorage {

	val Object parent
	
	val URI uri
	
	
	override getContents() throws CoreException {
		URIConverter.INSTANCE.createInputStream(uri)
	}
	
	override getFullPath() {
		new Path(uri.segments.tail.join("/"))
	}
	
	override getName() {
		uri.segments.last
	}
	
	override isReadOnly() {
		true
	}
	
	override equals(Object obj) {
		if (obj instanceof ContributedAadlStorage) {
			uri == obj.uri
		} else {
			false
		}
	}
	
	override hashCode() {
		uri.hashCode
	}
}