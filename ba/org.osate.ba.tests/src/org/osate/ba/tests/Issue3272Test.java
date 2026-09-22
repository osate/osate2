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

@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3272Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3272/";
	private static final String LOCAL_CONFLICT = "The same local variable must not be "
			+ "assigned to in different actions of an action set"
			+ ": Behavior Annex D.6.(L3) legality rules failed.";
	private static final String PORT_CONFLICT = "The same port variable must not be assigned to "
			+ "in different actions of an action set: Behavior Annex D.6.(L4) legality rules failed.";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void implicitWritesConflictAcrossActionSetMembers() throws Exception {
		var root = testHelper.parseFile(PATH + "Issue3272.aadl");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		var expected = List.of(
				new Expected("send_send", PORT_CONFLICT, List.of("output", "output")),
				new Expected("send_assign", PORT_CONFLICT, List.of("output", "output")),
				new Expected("dequeue_assign", LOCAL_CONFLICT, List.of("value", "value")),
				new Expected("dequeue_dequeue", LOCAL_CONFLICT, List.of("value", "value")),
				new Expected("out_assign", LOCAL_CONFLICT, List.of("value", "value")),
				new Expected("inout_dequeue", LOCAL_CONFLICT, List.of("value", "value")),
				new Expected("call_call", LOCAL_CONFLICT, List.of("value", "value")),
				new Expected("access_assign", LOCAL_CONFLICT, List.of("value", "value")),
				new Expected("subcomponent_assign", LOCAL_CONFLICT, List.of("value", "value")),
				new Expected("port_formal_send", PORT_CONFLICT, List.of("output", "output")),
				new Expected("nested_send", PORT_CONFLICT, List.of("output", "output", "output")),
				new Expected("nested_calls", LOCAL_CONFLICT, List.of("value", "value", "value")),
				new Expected("nested_set", LOCAL_CONFLICT, List.of("value", "value")),
				new Expected("explicit_assign", LOCAL_CONFLICT, List.of("value", "value")));
		assertEquals(issues.toString(), expected.stream().mapToInt(entry -> entry.targets().size()).sum(), issues.size());
		for (var entry : expected) {
			var start = source.indexOf(entry.transition() + " :");
			var end = source.indexOf('\n', start);
			var transitionIssues = issues.stream()
					.filter(issue -> issue.getOffset() >= start && issue.getOffset() < end).toList();
			assertEquals(entry.transition(), entry.targets(), transitionIssues.stream().map(issue -> {
				assertEquals(Severity.ERROR, issue.getSeverity());
				assertEquals(entry.message(), issue.getMessage());
				return source.substring(issue.getOffset(), issue.getOffset() + issue.getLength());
			}).toList());
		}
	}

	@Test
	public void sequentialWritesIndependentTargetsAndReadOnlyActionsAreAccepted() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "ValidActionSets.aadl"));
	}

	private record Expected(String transition, String message, List<String> targets) {
	}
}
