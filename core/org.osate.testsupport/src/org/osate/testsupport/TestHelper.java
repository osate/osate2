package org.osate.testsupport;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
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
	 * Parse a set of source strings into the test resource set and return the FluentIssueCollection for the first string.
	 * The source strings are assumed to be written in the language supported by the InjectorProvider injected into the JUnit test class
	 *
	 * @param sourceText the main source to parse
	 * @param referenced other sources (e.g., Aadl packages) that may be referenced by the main (e.g., Aadl package) source
	 * @return the issue collection for the main source
	 * @throws Exception if a resource for a source string cannot be created
	 */
	public FluentIssueCollection testString(String sourceText, String... referenced) throws Exception {
		EObject o = parseString(sourceText, referenced);
		return testResource(o.eResource());
	}

	/**
	 * Parse a set of files and return the FluentIssueCollection for the first file.
	 * The files can be of any extension supported by the InjectorProvider injected into the JUnit test class
	 * The first file is assumed to have a root object of type T
	 *
	 * @param filePath the main AADL file to test
	 * @param referencedPaths other files that may be referenced by the main file and must be included in the resource set
	 * @return the issue collection for the main file
	 * @throws Exception if the operation is canceled
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
	 * Parse a set of source strings into the test resource set.
	 * The source strings are assumed to be written in the language supported by the InjectorProvider injected into the JUnit test class
	 *
	 * @param sourceText the main source to parse
	 * @param referenced other sources (e.g., Aadl packages) that may be referenced by the main (e.g., Aadl package) source
	 * @return the root object of type T (e.g.,AadlPackage or AadlPropertyset) of the main source string
	 * @throws Exception if a resource for an AADL string cannot be created
	 */
	public T parseString(String sourceText, String... referenced) throws Exception {
		ResourceSet rs = rsHelper.getResourceSet();
		for (String s : referenced) {
			parseHelper.parse(s, rs);
		}
		return parseHelper.parse(sourceText, rs);
	}

	/**
	 * Parse a set of files into the test resource set.
	 * They can be of any extension supported by the InjectorProvider injected into the JUnit test class
	 * The first file is assumed to have a root object of type T
	 *
	 * @param filePath the main file to parse
	 * @param referenced other files that may be referenced by the main file
	 * @return the root object of the main file
	 */
	public T parseFile(String filePath, String... referencedPaths) {
		ResourceSet rs = rsHelper.getResourceSet();
		for (String name : referencedPaths) {
			loadFile(name, rs);
		}
		Resource res = loadFile(filePath, rs);
		if (res != null) {
			@SuppressWarnings("unchecked")
			final T root = (T) (res.getContents().isEmpty() ? null : res.getContents().get(0));
			return root;
		}
		return null;
	}


	/**
	 * load file as Xtext resource into resource set
	 * @param filePath String
	 * @param rs ResourceSet
	 * @return
	 */
	public Resource loadFile(String filePath, ResourceSet rs) {
		try {
			// This way of constructing the URL works in JUnit plug-in and standalone tests
			URL url = new URL("file:" + System.getProperty("user.dir") + "/../" + filePath);
			InputStream stream = url.openConnection().getInputStream();
			Resource res = rs.createResource(URI.createURI(filePath));
			if (res != null) {
				res.load(stream, Collections.EMPTY_MAP);
			}
			return res;
		} catch (IOException e) {
			return null;
		}
	}

}
