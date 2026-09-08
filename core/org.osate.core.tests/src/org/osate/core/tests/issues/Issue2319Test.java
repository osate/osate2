/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.issues;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.SystemType;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2319Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue2319/";

	private static final String REMOVES_D = "Refinement removes classifier D";

	private static final String D_TO_E = "Classifier D refined to E does not satisfy 'Type Extension'";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	private PublicPackageSection section;

	@Test
	public void testSubcomponent() throws Exception {
		load("TestSubcomponentRefinement.aadl");

		assertSubcomponentWarning("Top.i1", "s", "Refinement removes classifier S");
		assertSubcomponentWarning("Top.i3", "s", "Classifier S refined to Other does not satisfy 'Type Extension'");
		assertSubcomponentWarning("Top.i4", "s", "Refinement removes classifier S1");
		assertSubcomponentWarning("Top.i5", "s", "Classifier S1 refined to S does not satisfy 'Type Extension'");
		assertSubcomponentWarning("Top.i7", "s", "Classifier S1 refined to Other does not satisfy 'Type Extension'");

		finish();
	}

	@Test
	public void testPortRefinement() throws Exception {
		load("TestPortRefinement.aadl");

		assertFeatureWarning("SrcSys2", "f0", D_TO_E);
		assertFeatureWarning("SrcSys7", "f0", REMOVES_D);
		assertFeatureWarning("x1", "f0", "Refinement removes classifier D2");
		assertFeatureWarning("x2", "f0", "Classifier D2 refined to D does not satisfy 'Type Extension'");
		assertFeatureWarning("x5", "f0", "Classifier D2 refined to E does not satisfy 'Type Extension'");

		finish();
	}

	@Test
	public void testAbstractFeatures() throws Exception {
		load("TestAbstractFeatureRefinement.aadl");

		assertFeatureWarning("SrcSys2", "f0", D_TO_E);
		assertFeatureWarning("SrcSys5", "f0", D_TO_E);
		assertFeatureWarning("SrcSys7", "f0", REMOVES_D);
		assertFeatureWarning("SrcSys8", "f0", REMOVES_D);
		assertFeatureWarning("SrcSys9", "f0", REMOVES_D);
		assertFeatureWarning("SrcSys12", "f0", D_TO_E);
		assertFeatureWarning("SrcSys13", "f0", REMOVES_D);
		assertFeatureWarning("SrcSys15", "f0", "Classifier D refined to B does not satisfy 'Type Extension'");

		finish();
	}

	private void load(String file) throws Exception {
		testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + file);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(),
				new ArrayList<>());
		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		section = pkg.getOwnedPublicSection();
	}

	private void finish() {
		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void assertSubcomponentWarning(String implName, String subcomponentName, String expectedMessage) {
		ComponentImplementation impl = (ComponentImplementation) classifierNamed(implName);
		var subcomponent = impl.getOwnedSubcomponents()
				.stream()
				.filter(candidate -> subcomponentName.equals(candidate.getName()))
				.findFirst()
				.orElse(null);
		AssertHelper.assertWarning(subcomponent, testFileResult.getIssues(), issueCollection, expectedMessage);
	}

	private void assertFeatureWarning(String typeName, String featureName, String expectedMessage) {
		SystemType type = (SystemType) classifierNamed(typeName);
		var feature = type.getOwnedFeatures()
				.stream()
				.filter(candidate -> featureName.equals(candidate.getName()))
				.findFirst()
				.orElse(null);
		AssertHelper.assertWarning(feature, testFileResult.getIssues(), issueCollection, expectedMessage);
	}

	private EObject classifierNamed(String name) {
		return section.getOwnedClassifiers()
				.stream()
				.filter(classifier -> name.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
	}
}
