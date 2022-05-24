package org.osate.examples.tests;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.itemis.xtext.testing.FluentIssueCollection;

@Singleton
public class TestHelper<T extends EObject> {
	@Inject
	private org.osate.testsupport.TestHelper<AadlPackage> testHelper;

	@Test
	public void ValidationAndInstantiationTest(ExampleConfig config) throws Exception {
		for (ExampleEntry entry : config.entries) {
			AadlPackage pkg = testHelper.parseFile(config.bundle + "/" + entry.entry,
					entry.references.toArray(new String[] {}));
			final EList<Classifier> cls = pkg.getOwnedPublicSection().getOwnedClassifiers();
			for (Classifier classifier : cls) {
				if (classifier instanceof SystemImplementation) {
					SystemImplementation impl = (SystemImplementation) classifier;
					if (entry.components.contains(impl.getName())) {
						SystemInstance si = InstantiateModel.instantiate(impl);
						FluentIssueCollection issues = testHelper.testResource(pkg.eResource());
						if (issues.getIssues().size() > 0) {
							System.out.println(issues.getIssues().size() + " Error(s) found in " + config.bundle + "/"
									+ entry.entry);
							// TODO remove println
							for (Issue issue : issues.getIssues()) {
								System.out.println(issue.getMessage());
							}
							throw new Exception(issues.getIssues().size() + " Error(s) found in " + config.bundle + "/"
									+ entry.entry);
						}
					}
				}
			}
		}
	}
}