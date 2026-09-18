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

import java.util.ArrayList;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class Issue2820Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.aadl2.errormodel.tests/models/issue2820/";
	private static final String PROPERTIES = PROJECT_LOCATION + "ProbabilityProperties.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void preserveExactDecimalPropertyProbabilities() {
		validationHelper.assertNoIssues(testHelper.parseFile(PROJECT_LOCATION + "Issue2820.aadl", PROPERTIES));
	}

	@Test
	public void rejectIncorrectSumsWithoutRoundingThemToOne() throws Exception {
		var result = issues = testHelper.testFile(PROJECT_LOCATION + "InvalidSums.aadl", PROPERTIES,
				PROJECT_LOCATION + "Issue2820.aadl");
		var expected = new FluentIssueCollection(result.getResource(), new ArrayList<>(), new ArrayList<>());
		var pkg = (AadlPackage) result.getResource().getContents().getFirst();
		for (var classifier : pkg.getPublicSection().getOwnedClassifiers()) {
			var annex = (ErrorModelSubclause) ((DefaultAnnexSubclause) classifier.getOwnedAnnexSubclauses().getFirst())
					.getParsedAnnexSubclause();
			var message = classifier.getName().equals("exhausted_remainder")
					? "Sum of branch probabilities must be less than 1 due to 'others'"
					: "Sum of branch probabilities must be 1";
			AssertHelper.assertError(annex.getTransitions().getFirst(), result.getIssues(), expected, message);
		}
		expected.sizeIs(4);
		assertConstraints(expected);
	}
}
