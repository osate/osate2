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

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.core.tests.instantiation.InstanceCharacterization;
import org.osate.core.tests.instantiation.InstanceReport;
import org.osate.core.tests.instantiation.InstanceSnapshot;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes a structural expansion that cannot apply the declared property, and a crossed
 * {@code Connection_Set} through a feature group, for issue #3037.
 *
 * <p>
 * Expansion runs after enumeration, on provisional connection instances. What matters here is
 * what it is fed where it fails, and that a failed expansion leaves a whole model behind rather
 * than a partly replicated one.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037StructuralFailureTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/StructuralFailures.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private IsolatedInstantiation isolated;

	@Test
	public void theFixtureIsValid() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(MODEL));
	}

	/** Crossed index pairs through a whole feature group, which the corpus never had. */
	@Test
	public void aCrossedConnectionSetThroughAFeatureGroupAgrees() throws Exception {
		assertConnections("CrossedGroupSet.i", "producers[1].bundle.signal --> consumers[2].bundle.signal",
				"producers[2].bundle.signal --> consumers[1].bundle.signal");
		assertConnections("Top.crossedGroupSet", "producers[1].bundle.signal --> consumers[2].bundle.signal",
				"producers[2].bundle.signal --> consumers[1].bundle.signal");

	}

	/**
	 * A pattern with fewer dimensions than the arrays it has to replicate over.
	 *
	 * <p>
	 * Expansion neither replicates nor gives up: it reports the mismatch, falls back to the
	 * first array element for each end, and leaves two connection instances that are identical
	 * in name and endpoints, which validation then reports as more than one connection ending
	 * at the same data port. Thirteen of the sixteen element pairs the arrays could have are
	 * absent. This is what 2.18.0 produced too, so it is structural expansion's behavior and
	 * not the traversal's; it is recorded here so that a change to it shows up as a failure,
	 * and fixing it is separate work.
	 * </p>
	 */
	@Test
	public void aPatternWithTooFewIndicesAgrees() throws Exception {
		assertConnections("TooFewIndices.i", "producers[1][1].outp --> consumers[1][1].inp",
				"producers[1][1].outp --> consumers[1][1].inp");
		assertConnections("Top.tooFewIndices", "producers[1][1].outp --> consumers[1][1].inp",
				"producers[1][1].outp --> consumers[1][1].inp");

		assertEquals(List.of(
				"Error | For c : producers[1][1].outp -> consumers[1][1].inp,"
						+ " destination indices [1] do not match destination dimension 2",
				"Error | For c : producers[1][1].outp -> consumers[1][1].inp,"
						+ " destination indices [2] do not match destination dimension 2",
				"Error | More than one connection instance ends at data port",
				"Error | More than one connection instance ends at data port"
						+ " TooFewIndices_i_Instance.consumers[1][1].inp",
				"Error | Source indices [1] do not match source dimension 2",
				"Error | Source indices [2] do not match source dimension 2",
				"Warning | There is already another connection between the same endpoints",
				"Warning | Too few indices for connection end, using first array element"),
				messages("TooFewIndices.i"));
	}

	/**
	 * A Connection_Set naming an element the array does not have. The provisional connection is
	 * replaced by nothing at all, with one error and no attached partial object, which is the
	 * failure behavior the plan's matrix asks for: expansion may delete what it cannot expand,
	 * but it may not leave half of it behind.
	 */
	@Test
	public void aConnectionSetOutOfRangeAgrees() throws Exception {
		assertConnections("OutOfRangeSet.i");
		assertConnections("Top.outOfRangeSet");

		assertEquals(List.of("Error | Connection destination not found"), messages("OutOfRangeSet.i"));
	}

	private void assertConnections(String implementation, String... expected) throws Exception {
		InstanceCharacterization.assertConnections(isolated, MODEL, implementation, expected);
	}

	/**
	 * The distinct severities and message texts a run reports, without their targets. The
	 * complete diagnostics are compared between the strategies by
	 * {@link StrategyDifference}; what is asserted here is which failures expansion reports at
	 * all, which is the part worth reading.
	 */
	private List<String> messages(String implementation) throws Exception {
		var run = isolated.run(MODEL, implementation);
		return InstanceReport.diagnosticSet(InstanceSnapshot.of(run.instance(), run.errorManager()))
				.stream()
				.map(line -> line.substring(0, line.indexOf(" | at ")))
				.distinct()
				.sorted()
				.toList();
	}
}
