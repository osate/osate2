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
public class Issue2807Test extends XtextTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/issue2807/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void repairEventRejectsInvalidInitiators() throws Exception {
		assertInvalidInitiators("Issue2807.aadl", "Repair");
	}

	@Test
	public void recoverEventReportsEachInvalidInitiatorOnce() throws Exception {
		assertInvalidInitiators("InvalidRecover.aadl", "Recover");
	}

	@Test
	public void validInitiatorsAndAbsentWhenClausesAreAccepted() {
		var pkg = testHelper.parseFile(PATH + "ValidInitiators.aadl");
		validationHelper.assertNoIssues(pkg);
	}

	private void assertInvalidInitiators(String fileName, String eventKind) throws Exception {
		var result = issues = testHelper.testFile(PATH + fileName);
		var expected = new FluentIssueCollection(result.getResource(), new ArrayList<>(), new ArrayList<>());
		var pkg = (AadlPackage) result.getResource().getContents().getFirst();
		var implementation = pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annex = (ErrorModelSubclause) ((DefaultAnnexSubclause) implementation.getOwnedAnnexSubclauses()
				.getFirst()).getParsedAnnexSubclause();
		AssertHelper.assertError(annex.getEvents().getFirst(), result.getIssues(), expected,
				eventKind + " event trigger reference 'm1' is not a port, component internal self event, or mode transition.",
				eventKind + " event trigger reference 'child' is not a port, component internal self event, or mode transition.");
		assertEquals("Each invalid initiator must produce exactly one diagnostic", 2, result.getIssues().size());
		expected.sizeIs(result.getIssues().size());
		assertConstraints(expected);
	}
}
