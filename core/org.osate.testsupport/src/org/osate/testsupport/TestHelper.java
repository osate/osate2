package org.osate.testsupport;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.itemis.xtext.testing.FluentIssueCollection;

@Singleton
public class TestHelper {

	@Inject
	ParseHelper<EObject> parseHelper;

	@Inject
	TestResourceSetHelper rsHelper;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	public FluentIssueCollection testString(String aadlText, String... referenced) throws Exception {
		EObject o = parseString(aadlText, referenced);
		Resource r = o.eResource();
		IResourceServiceProvider provider = serviceProviderRegistry.getResourceServiceProvider(r.getURI());
		List<Issue> issueList = provider.getResourceValidator().validate(r, CheckMode.ALL, null);
		return new FluentIssueCollection(r, issueList, new ArrayList<String>());
	}

	public EObject parseString(String aadlText, String... referenced) throws Exception {
		ResourceSet rs = rsHelper.getResourceSet();
		for (String s : referenced) {
			parseHelper.parse(s, rs);
		}
		return parseHelper.parse(aadlText, rs);
	}
}
