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

import java.util.Comparator;
import java.util.List;

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

/**
 * Verifies that D.6 loop variables are read-only for the dequeue action too, through embedded AADL validation. The
 * assignment action and the dequeue action share the D.6 target production, so an iterator name is as invalid in
 * 'p?(i)' as in 'i := ...'.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3205Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3205/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void ordinaryDequeueTargetsAndIteratorReadsAreAccepted() throws Exception {
		var root = testHelper.parseFile(PATH + "Issue3205.aadl");
		// The behavior variable i is a dequeue target before, between, and after the loops that shadow it, and a
		// dequeue with no target at all stays legal inside one.
		validationHelper.assertNoIssues(root);
	}

	@Test
	public void forDequeuesRejectCurrentAndEnclosingIterators() throws Exception {
		assertIteratorDequeues("ForDequeues", List.of("i", "j", "i", "i"));
	}

	@Test
	public void forallDequeuesRejectCurrentAndEnclosingIterators() throws Exception {
		assertIteratorDequeues("ForallDequeues", List.of("i", "j", "i", "i"));
	}

	/**
	 * Dequeuing into a data element of an iterator writes part of the iterator, and unlike a dequeue into the iterator
	 * itself the strict model carries it as an ordinary data component reference. The second implementation in the same
	 * file is the positive control: the same elements of a behavior variable stay dequeue targets and the iterator's
	 * elements stay readable, so exactly the two element dequeues into an iterator are reported.
	 */
	@Test
	public void fieldDequeuesRejectWritesIntoIteratorElements() throws Exception {
		assertIteratorDequeues("FieldDequeues", List.of("p", "p"));
	}

	private void assertIteratorDequeues(String model, List<String> expectedTargets) throws Exception {
		var root = testHelper.parseFile(PATH + model + ".aadl");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		assertEquals(issues.toString(), expectedTargets.size(), issues.size());
		assertEquals(expectedTargets, issues.stream().map(issue -> {
			var target = source.substring(issue.getOffset(), issue.getOffset() + issue.getLength());
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Iterative variable '" + target
					+ "' cannot be an assignment target: Behavior Annex D.6.(L2) legality rule failed.",
					issue.getMessage());
			return target;
		}).toList());
	}
}
