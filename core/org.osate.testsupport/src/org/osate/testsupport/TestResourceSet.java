package org.osate.testsupport;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.osate.pluginsupport.PluginSupportUtil;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class TestResourceSet extends XtextResourceSet {

	private static List<URI> contributed = PluginSupportUtil.getContributedAadl();

	protected static XtextResourceSet set;

	@Inject
	protected Provider<XtextResourceSet> rsp;

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
		contributed.stream().forEach(uri -> set.getResource(uri, true));
	}

	protected void clean() {
		set.getResources().stream().skip(contributed.size()).forEach(Resource::unload);
	}
}
