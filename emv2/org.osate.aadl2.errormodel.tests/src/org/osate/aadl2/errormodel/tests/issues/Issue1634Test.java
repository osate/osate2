package org.osate.aadl2.errormodel.tests.issues;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1634Test {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/Issue1634/pkg1.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testErrorTypeQualifiedName() {
		AadlPackage pkg1 = testHelper.parseFile(PATH);
		ErrorModelLibrary errorModel = (ErrorModelLibrary) ((DefaultAnnexLibrary) pkg1.getPublicSection()
				.getOwnedAnnexLibraries().get(0))
				.getParsedAnnexLibrary();
		ErrorType e1 = errorModel.getTypes().get(0);
		Assert.assertEquals("pkg1::e1", e1.getQualifiedName());

	}
}
