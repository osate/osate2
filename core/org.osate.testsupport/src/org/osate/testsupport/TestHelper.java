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

/**
 * This class provides a couple of helper methods for writing junit tests.
 * It must be injected via guice.
 *
 * @param <T> The class of the objects returned by the (first) parsed file, usually AadlPackage.
 */
@Singleton
public class TestHelper<T extends EObject> {

	@Inject
	ParseHelper<T> parseHelper;

	@Inject
	TestResourceSetHelper rsHelper;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	/**
	 * Parse a set of strings containing AADL source text and return the FluentIssueCollection for the first string.
	 *
	 * @param aadlText the main AADL source to test
	 * @param referenced other AADL packages and property sets that may be referenced by the main AADL source
	 * @return the issue collection for the main AADL source
	 * @throws Exception if a resource for an AADL string cannot be created
	 */
	public FluentIssueCollection testString(String aadlText, String... referenced) throws Exception {
		EObject o = parseString(aadlText, referenced);
		return testResource(o.eResource());
	}

	/**
	 * Parse a set of AADL files and return the FluentIssueCollection for the first file.
	 *
	 * @param aadlText the main AADL file to test
	 * @param referenced other AADL package and property set files that may be referenced by the main AADL file
	 * @return the issue collection for the main AADL file
	 * @throws Exception if a resource for an AADL file cannot be created
	 */
	public FluentIssueCollection testFile(String filePath, String... referencedPaths) throws Exception {
		EObject o = parseFile(filePath, referencedPaths);
		return testResource(o.eResource());
	}

	protected FluentIssueCollection testResource(Resource r) throws OperationCanceledError {
		IResourceServiceProvider provider = serviceProviderRegistry.getResourceServiceProvider(r.getURI());
		List<Issue> issueList = provider.getResourceValidator().validate(r, CheckMode.ALL, null);
		return new FluentIssueCollection(r, issueList, new ArrayList<String>());
	}

	/**
	 * Parse a set of AADL source strings into the test resource set.
	 *
	 * @param aadlText the main AADL source to parse
	 * @param referenced other AADL packages and property sets that may be referenced by the main AADL source
	 * @return the root object (AadlPackage or AadlPropertyset) of the main AADL source string
	 * @throws Exception if a resource for an AADL string cannot be created
	 */
	public T parseString(String aadlText, String... referenced) throws Exception {
		ResourceSet rs = rsHelper.getResourceSet();
		for (String s : referenced) {
			parseHelper.parse(s, rs);
		}
		return parseHelper.parse(aadlText, rs);
	}

	/**
	 * Parse a set of AADL files into the test resource set.
	 *
	 * @param aadlText the main AADL file to parse
	 * @param referenced other AADL package and property set files that may be referenced by the main AADL file
	 * @return the root object (AadlPackage or AadlPropertyset) of the main AADL file
	 * @throws Exception if a resource for an AADL file cannot be created
	 */
	public T parseFile(String filePath, String... referencedPaths) throws Exception {
		ResourceSet rs = rsHelper.getResourceSet();
		for (String name : referencedPaths) {
			parseHelper.parse(readFile(name), rs);
		}
		return parseHelper.parse(readFile(filePath), rs);
	}

	/**
	 * Read a file into a string.
	 *
	 * @param path the file path starting with the test plugin name
	 * @return the file content with unix line endings
	 */
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
