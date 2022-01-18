package org.osate.core.tests.issues;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2741Test {
	private static final String FILE = "org.osate.core.tests/models/Issue2741/Issue2741.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testIssue2741() throws Exception {
		AadlPackage pkg = testHelper.parseFile(FILE);
		SystemImplementation impl = (SystemImplementation) pkg.getOwnedPublicSection().getOwnedClassifiers().get(1);
		Assert.assertEquals("s.i", impl.getName());
		SystemInstance instance = InstantiateModel.instantiate(impl);
		Assert.assertEquals("s.i", instance.getClassifier().getName());
		Assert.assertEquals("s.i", instance.getComponentClassifier().getName());
		Assert.assertEquals("s.i", instance.getComponentImplementation().getName());
	}
}