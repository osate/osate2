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
package org.osate.aadl2.errormodel.tests.issues;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorStateToModeMapping;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class Issue2832Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/issue2832/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void rejectModesOutsideTheModalSubclause() throws Exception {
		var result = issues = testHelper.testFile(PROJECT_LOCATION + "Issue2832.aadl");
		var expected = new FluentIssueCollection(result.getResource(), new ArrayList<>(), new ArrayList<>());
		var pkg = (AadlPackage) result.getResource().getContents().getFirst();
		var classifiers = pkg.getPublicSection().getOwnedClassifiers();
		AssertHelper.assertError(mapping(classifiers.get(0)), result.getIssues(), expected,
				"Mapped mode m1 must be listed in the enclosing EMV2 subclause's in modes");
		AssertHelper.assertError(mapping(classifiers.get(1)), result.getIssues(), expected,
				"Mapped mode m1 must be listed in the enclosing EMV2 subclause's in modes",
				"Mapped mode m3 must be listed in the enclosing EMV2 subclause's in modes");
		expected.sizeIs(3);
		assertConstraints(expected);

		var source = ((XtextResource) result.getResource()).getParseResult().getRootNode().getText();
		var markedModes = result.getIssues().stream()
				.map(issue -> source.substring(issue.getOffset(), issue.getOffset() + issue.getLength())).sorted()
				.toList();
		assertEquals(List.of("m1", "m1", "m3"), markedModes);
	}

	@Test
	public void acceptNonmodalSubclausesAndAllowedInheritedModes() {
		validationHelper.assertNoIssues(testHelper.parseFile(PROJECT_LOCATION + "ValidModeMappings.aadl"));
	}

	@Test
	public void unresolvedModesOnlyReportTheLinkingError() throws Exception {
		var result = issues = testHelper.testFile(PROJECT_LOCATION + "UnresolvedMode.aadl");
		var expected = new FluentIssueCollection(result.getResource(), new ArrayList<>(), new ArrayList<>());
		var pkg = (AadlPackage) result.getResource().getContents().getFirst();
		AssertHelper.assertError(mapping(pkg.getPublicSection().getOwnedClassifiers().getFirst()), result.getIssues(),
				expected, "Couldn't resolve reference to mode 'missing'.");
		expected.sizeIs(1);
		assertConstraints(expected);
	}

	private ErrorStateToModeMapping mapping(Classifier classifier) {
		var annex = (ErrorModelSubclause) ((DefaultAnnexSubclause) classifier.getOwnedAnnexSubclauses().getFirst())
				.getParsedAnnexSubclause();
		return annex.getErrorStateToModeMappings().getFirst();
	}
}
