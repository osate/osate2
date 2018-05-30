package org.osate.testsupport;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.pluginsupport.PluginSupportUtil;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class TestResourceSet {

	@Inject
	protected Provider<XtextResourceSet> rsp;

	protected static XtextResourceSet set;

	private static List<URI> contributed = PluginSupportUtil.getContributedAadl();

	public XtextResourceSet get() {
		if (set == null) {
			set = rsp.get();
			initialize();
		} else {
			clean();
		}
		return set;
	}

	protected void initialize() {
		Map<URI, URI> uriMap = set.getURIConverter().getURIMap();

		for (URI uri : contributed) {
			set.getResource(uri, true);
			uriMap.put(uri, URI.createPlatformResourceURI(uri.path().substring(7), false));
		}
	}

	protected void clean() {
		EList<Resource> resources = set.getResources();
		set.getResources().stream().skip(contributed.size()).forEach(Resource::unload);
		for (int i = resources.size(); i < contributed.size(); i--) {
			resources.remove(i);
		}
	}
}
