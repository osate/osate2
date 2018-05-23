package org.osate.testsupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class TestResourceSet {

	private static List<URI> contributed = new ArrayList<>();

	{
		contributed.add(URI.createFileURI(
				"../org.osate.workspace/resources/properties/Predeclared_Property_Sets/AADL_Project.aadl"));
		contributed.add(URI.createFileURI(
				"../org.osate.workspace/resources/properties/Predeclared_Property_Sets/Communication_Properties.aadl"));
		contributed.add(URI.createFileURI(
				"../org.osate.workspace/resources/properties/Predeclared_Property_Sets/Deployment_Properties.aadl"));
		contributed.add(URI.createFileURI(
				"../org.osate.workspace/resources/properties/Predeclared_Property_Sets/Memory_Properties.aadl"));
		contributed.add(URI.createFileURI(
				"../org.osate.workspace/resources/properties/Predeclared_Property_Sets/Modeling_Properties.aadl"));
		contributed.add(URI.createFileURI(
				"../org.osate.workspace/resources/properties/Predeclared_Property_Sets/Programming_Properties.aadl"));
		contributed.add(URI.createFileURI(
				"../org.osate.workspace/resources/properties/Predeclared_Property_Sets/Thread_Properties.aadl"));
		contributed.add(URI.createFileURI(
				"../org.osate.workspace/resources/properties/Predeclared_Property_Sets/Timing_Properties.aadl"));
	}

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
		Map<URI, URI> uriMap = set.getURIConverter().getURIMap();

		for (URI uri : contributed) {
			set.getResource(uri, true);
			uriMap.put(URI.createPlatformPluginURI(uri.path().substring(2), true), uri);
		}
	}

	protected void clean() {
		set.getResources().stream().skip(contributed.size()).forEach(Resource::unload);
	}
}
