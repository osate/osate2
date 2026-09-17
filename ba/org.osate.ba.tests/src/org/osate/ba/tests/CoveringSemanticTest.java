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

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

/**
 * Exercises the Behavior Annex legality, consistency, semantic, and type checkers through validation of embedded
 * annexes. The models intentionally violate named standard rules, so their diagnostics must remain user-visible.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class CoveringSemanticTest {
	private static final String PATH = "org.osate.ba.tests/models/covering_semantic/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void test_cr_D3_C4() throws Exception {
		assertEquals(1, issues("cr_D3_C4.aadl").size());
	}

	@Test
	public void test_lr_D3_L1_L2() throws Exception {
		// D.3.(L1) and D.3.(L2) mark every state their message names: two initial states, one complete state, the
		// missing final state, and two final states.
		assertEquals(6, issues("lr_D3_L1_L2.aadl").size());
	}

	@Test
	public void test_lr_D3_L3_L4() throws Exception {
		// D.3.(L3) marks both initial states it names, and the missing complete state marks the subclause.
		assertEquals(3, issues("lr_D3_L3_L4.aadl").size());
	}

	@Test
	public void test_lr_D3_L5() throws Exception {
		assertEquals(2, issues("lr_D3_L5.aadl").size());
	}

	@Test
	public void test_lr_D3_L6_L7_L8() throws Exception {
		// The unqualified execution state also violates D.3.(C3) because it has no outgoing transition.
		assertEquals(5, issues("lr_D3_L6_L7_L8.aadl").size());
	}

	@Test
	public void test_lr_D4_L1_L2() throws Exception {
		var issues = issues("lr_D4_L1_L2.aadl");
		// Both multi-source timeout transitions retain their condition on the second complete state.
		assertEquals(6, issues.size());
		assertEquals(List.of(),
				issues.stream().map(Issue::getMessage).filter(message -> message.contains("D.3.(L7)")).toList());
	}

	@Test
	public void test_lr_D6_L2_nr_D6_N1() throws Exception {
		var issues = issues("lr_D6_L2_nr_D6_N1.aadl");
		assertEquals(1, issues.size());
		assertEquals("Iterative variable 'i' cannot be an assignment target: Behavior Annex D.6.(L2) legality rule"
				+ " failed.", issues.getFirst().getMessage());
	}

	@Test
	public void test_lr_D6_L3_L4() throws Exception {
		assertEquals(2, issues("lr_D6_L3_L4.aadl").size());
	}

	@Test
	public void test_lr_D6_L8() throws Exception {
		assertEquals(1, issues("lr_D6_L8.aadl").size());
	}

	@Test
	public void test_sr_D3_18() throws Exception {
		assertEquals(1, issues("sr_D3_18.aadl").size());
	}

	@Test
	public void test_sr_D4_6() throws Exception {
		// Both unqualified execution states also violate D.3.(C3) because they have no outgoing transitions.
		assertEquals(5, issues("sr_D4_6.aadl").size());
	}

	private List<Issue> issues(String fileName) throws Exception {
		return testHelper.testFile(PATH + fileName).getIssues();
	}
}
