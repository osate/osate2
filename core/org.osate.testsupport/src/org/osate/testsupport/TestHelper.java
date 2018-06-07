package org.osate.testsupport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.service.OperationCanceledError;
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
		return testResource(o.eResource());
	}

	public FluentIssueCollection testFile(String filePath, String... referencedPaths) throws Exception {
		EObject o = parseFile(filePath, referencedPaths);
		return testResource(o.eResource());
	}

	protected FluentIssueCollection testResource(Resource r) throws OperationCanceledError {
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

	public EObject parseFile(String filePath, String... referencedPaths) throws Exception {
		ResourceSet rs = rsHelper.getResourceSet();
		for (String name : referencedPaths) {
			parseHelper.parse(readFile(name), rs);
		}
		return parseHelper.parse(readFile(filePath), rs);
	}

	public static String readFile(String path) {
		String result = "";
		try {
			URL url = new URL("platform:/plugin/" + path);
			InputStream inputStream = url.openConnection().getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				result += inputLine + '\n';
			}

			in.close();
		} catch (IOException e) {
			result = "";
		}
		return result;
	}

}
