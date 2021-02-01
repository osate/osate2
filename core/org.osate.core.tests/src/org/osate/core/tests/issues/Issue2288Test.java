package org.osate.core.tests.issues;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.core.OsateCorePlugin;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2288Test {
	private static final String PATH = "org.osate.core.tests/models/issue2288/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void testModeResolution() {
		final IPreferenceStore store = OsateCorePlugin.getDefault().getPreferenceStore();
		store.setDefault("behavior_specification", true);
		store.setValue("behavior_specification", false); // annex is turned off

		AadlPackage pkg = testHelper.parseFile(PATH + "Issue2288.aadl");
		if (pkg != null && pkg.getPublicSection() != null) {
			for (Classifier cl : pkg.getPublicSection().getOwnedClassifiers()) {
				for (AnnexSubclause ac : cl.getOwnedAnnexSubclauses()) {
					if (ac.getName().equalsIgnoreCase("behavior_specification")) {
						if (!ac.getClass().getTypeName().contains("DefaultAnnexSubclause")) {
							Assert.fail(
									"behavior_specification annex is still being used to parse the file. Expected behavior_specification annex to be turned off per preference test");
						}
					}
				}
			}
		}

		validationHelper.assertNoIssues(pkg);
	}
}