package org.osate.xtext.aadl2.ui.resource

import org.eclipse.core.resources.IStorage
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl
import org.eclipse.xtext.util.Tuples
import org.osate.pluginsupport.PluginSupportUtil

class Aadl2Storage2UriMapper extends Storage2UriMapperImpl {
	/* Here we still use PluginSupportUtil.getContributedAadl() and not PredeclaredProperties.getVisibleContributedResources().
	 * We are just determining which items need a special Storage object, and it's only going to be those are 
	 * contributed by a plug-in.  Items that are contributed by the workspace are already resources in the workspace 
	 * and should open just fine.
	 */
	val CONTRIBUTED_AADL = PluginSupportUtil.contributedAadl.toInvertedMap[new ContributedAadlStorage(null, it)]
	
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
}