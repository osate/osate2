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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
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
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.ThreadImplementation;
import org.osate.ba.aadlba.BehaviorVariableHolder;
import org.osate.ba.aadlba.ForOrForAllStatement;
import org.osate.ba.aadlba.IterativeVariableHolder;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * AS5506/3 Rev A D.6 gives the iterator of a {@code for} or {@code forall} the name scope of the construct, where it
 * acts as a local variable, and admits an array data component reference as the iterated values. A nested loop over an
 * array of arrays therefore iterates the iterator of the enclosing loop, and the inner iterator takes the element type
 * of the outer one. Verifies that such a loop is accepted and translated, and that the iterated values the strict model
 * cannot carry at all are reported instead of throwing out of translation.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3226Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3226/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void iteratingAnEnclosingIteratorIsAccepted() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "Issue3226.aadl"));
	}

	/**
	 * The inner loop must reach the checkers with the outer iterator as its iterated values: an inner loop with no
	 * iterated values at all would also validate, and would say nothing about what the loop iterates.
	 */
	@Test
	public void theInnerLoopIteratesTheOuterIterator() throws Exception {
		var strict = BehaviorAnnexUtil.getStrictModel(defaultAnnex(testHelper.parseFile(PATH + "Issue3226.aadl")));
		var loops = new ArrayList<ForOrForAllStatement>();
		for (var contents = strict.eAllContents(); contents.hasNext();) {
			if (contents.next() instanceof ForOrForAllStatement loop) {
				loops.add(loop);
			}
		}
		assertEquals(loops.toString(), 2, loops.size());
		var outer = loops.get(0);
		var inner = loops.get(1);
		assertEquals("row", outer.getIterativeVariable().getName());
		assertEquals("cell", inner.getIterativeVariable().getName());
		assertTrue(String.valueOf(outer.getIteratedValues()),
				outer.getIteratedValues() instanceof BehaviorVariableHolder);
		assertEquals("m", ((BehaviorVariableHolder) outer.getIteratedValues()).getBehaviorVariable().getName());
		assertTrue(String.valueOf(inner.getIteratedValues()),
				inner.getIteratedValues() instanceof IterativeVariableHolder);
		assertSame(outer.getIterativeVariable(),
				((IterativeVariableHolder) inner.getIteratedValues()).getIterativeVariable());
	}

	/**
	 * An integer literal and a data port are the two shapes the shared grammar accepts here and no strict
	 * {@code ElementValues} can represent, so each must be reported on the values as written. The loops are otherwise
	 * well formed, which is what makes the two reports the only ones.
	 */
	@Test
	public void valuesThatAreNotIterableAreReported() throws Exception {
		var root = testHelper.parseFile(PATH + "NonIterableValues.aadl");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		// Xtext does not hand back the issues of one resource in the order the checkers report them.
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		assertEquals(issues.toString(), List.of("5", "reading"), issues.stream().map(issue -> {
			var written = source.substring(issue.getOffset(), issue.getOffset() + issue.getLength());
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("'" + written + "' cannot be iterated: a for or forall iterates an integer range, an event"
					+ " data port, a parameter, or an array data component reference", issue.getMessage());
			return written;
		}).toList());
	}

	private static DefaultAnnexSubclause defaultAnnex(AadlPackage pkg) {
		var implementation = (ThreadImplementation) pkg.getOwnedPublicSection().getOwnedClassifiers().stream()
				.filter(ThreadImplementation.class::isInstance).findFirst().orElseThrow();
		return (DefaultAnnexSubclause) implementation.getOwnedAnnexSubclauses().getFirst();
	}
}
