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
 * A dispatch trigger is represented only as an event port holder or an event data port holder, so the translator kept
 * a trigger reference only when it resolved to one of those and discarded every other reference without a diagnostic.
 * A name that denotes nothing, a data port, and a data subcomponent were all accepted in silence, and a conjunction
 * kept the operands it could represent and dispatched on those alone.
 * <p>
 * Each such reference is now reported, and the references that are triggers stay clean: an event port, an event data
 * port, one reached through a feature group, every operand of a conjunction and of a disjunction, and a subprogram
 * access named as the whole condition, which the translator installs as the dispatch trigger condition itself.
 * <p>
 * Direction and {@code Dispatch_Protocol} compatibility are not checked here; those are the D.4 matrix tracked by
 * issue #3187. This is about a reference that cannot be a trigger at all.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3290Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3290/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void portsAndASubprogramAccessAreDispatchTriggers() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "Issue3290.aadl"));
	}

	/**
	 * The three sole triggers may name a subprogram access instead, which is why their diagnostic offers it; the
	 * operand of a conjunction may not, so its diagnostic does not.
	 */
	@Test
	public void aReferenceThatCannotBeATriggerIsReported() throws Exception {
		assertDiagnostics("InvalidTriggers",
				List.of(new Expected(Severity.ERROR, "signals.step_done", sole("signals.step_done")),
						new Expected(Severity.ERROR, "reading", sole("reading")),
						new Expected(Severity.ERROR, "state_value", sole("state_value")),
						new Expected(Severity.ERROR, "signals.step_done",
								"'signals.step_done' is not a dispatch trigger: expected an event or event data"
										+ " port")));
	}

	private static String sole(final String reference) {
		return "'" + reference + "' is not a dispatch trigger: expected an event or event data port, or a subprogram"
				+ " access";
	}

	private void assertDiagnostics(String model, List<Expected> expected) throws Exception {
		var root = testHelper.parseFile(PATH + model + ".aadl");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		assertEquals(issues.toString(), expected.size(), issues.size());
		assertEquals(expected, issues.stream()
				.map(issue -> new Expected(issue.getSeverity(),
						source.substring(issue.getOffset(), issue.getOffset() + issue.getLength()),
						issue.getMessage()))
				.toList());
	}

	private record Expected(Severity severity, String target, String message) {
	}
}
