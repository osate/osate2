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
package org.osate.ba.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Comparator;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Verifies that a Behavior Annex assignment target cannot write a port its owner can only read. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3268Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3268/";
	private static final String ASSIGNMENT_TARGET_DIRECTION = "org.osate.xtext.aadl2.ba.assignmentTargetDirection";
	private static final String ADMITTED_TARGETS = ": an assignment writes its target, and the AS5506/3 Rev. A D.6"
			+ " target production admits an outgoing port, an internal port, an outgoing parameter, or a data component";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void incomingPortsAreRejectedAsAssignmentTargets() throws Exception {
		var root = testHelper.parseFile(PATH + "Issue3268.aadl");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = new ArrayList<>(validationHelper.validate(root));
		issues.sort(Comparator.comparingInt(Issue::getOffset));
		assertEquals(issues.toString(), 3, issues.size());
		assertTarget(issues.get(0), source, "incoming", "'incoming' is an incoming port" + ADMITTED_TARGETS);
		assertTarget(issues.get(1), source, "queued_in", "'queued_in' is an incoming port" + ADMITTED_TARGETS);
		assertTarget(issues.get(2), source, "channel",
				"'channel' is an incoming port in an inverse feature group" + ADMITTED_TARGETS);
	}

	@Test
	public void outgoingBidirectionalAndDataTargetsRemainValid() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "ConformingTargets.aadl"));
	}

	private static void assertTarget(Issue issue, String source, String written, String message) {
		assertEquals(issue.toString(), Severity.ERROR, issue.getSeverity());
		assertEquals(issue.toString(), ASSIGNMENT_TARGET_DIRECTION, issue.getCode());
		assertEquals(message, issue.getMessage());
		assertEquals(written, source.substring(issue.getOffset(), issue.getOffset() + issue.getLength()));
	}
}
