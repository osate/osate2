package org.osate.xtext.aadl2.ui.resource

import org.eclipse.core.resources.IStorage
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.PlatformObject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.URIConverter
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl
import org.eclipse.xtext.util.Tuples
import org.osate.pluginsupport.PluginSupportUtil

class Aadl2Storage2UriMapper extends Storage2UriMapperImpl {
	val CONTRIBUTED_AADL = PluginSupportUtil.contributedAadl.toInvertedMap[new ContributedAadlStorage(it)]
	
	override getStorages(URI uri) {
		if (CONTRIBUTED_AADL.containsKey(uri)) {
			#[Tuples.create(CONTRIBUTED_AADL.get(uri), workspaceRoot.projects.head)]
		} else {
			super.getStorages(uri)
		}
	}
	
	override getUri(IStorage storage) {
		if (storage instanceof ContributedAadlStorage) {
			storage.uri
		} else {
			super.getUri(storage)
		}
	}
	
	@FinalFieldsConstructor
	private static class ContributedAadlStorage extends PlatformObject implements IStorage {
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
	}
}