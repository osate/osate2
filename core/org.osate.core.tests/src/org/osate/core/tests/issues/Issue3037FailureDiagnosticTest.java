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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.instantiation.testing.CharacterizationRun;
import org.osate.core.tests.instantiation.InstanceReport;
import org.osate.core.tests.instantiation.InstanceSnapshot;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Compares what the two traversal strategies report about a declaration that cannot
 * become a connection instance, for issue #3037.
 *
 * <p>
 * These models are invalid on purpose, so none of them is validated first. They are the
 * corpus's whole supply of endpoints a declaration names and the instance model does not
 * have, and of a declaration naming a subcomponent at both ends, which is why they are
 * the fixtures for the failure paths rather than models written for this enhancement.
 * </p>
 *
 * <p>
 * Across-first resolves an endpoint before any path exists, so it says which feature of
 * which component is missing and reports both ends of the declaration rather than the one
 * a partial path happened to reach. That wording is an approved intended difference,
 * allowlist entries 6 and 7, and both sides are recorded exactly here.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037FailureDiagnosticTest extends XtextTest {
	private static final String BAD_PARAMETER = "org.osate.core.tests/models/issue911/BadParameterConnection.aadl";
	private static final String BAD_ACCESS = "org.osate.core.tests/models/issue911/BadAccessConnections.aadl";
	private static final String MISSING_FEATURE = "org.osate.core.tests/models/issue2533/flow_order_test.aadl";
	private static final String MISSING_SUBCOMPONENT = "org.osate.core.tests/models/issue3030/Issue3030.aadl";
	private static final String UNCONTINUED_UPWARD = "org.osate.core.tests/models/Issue2318/findTests/findConnectionInstance.aadl";
	private static final String NESTED_UPWARD = "org.osate.core.tests/models/issue2872/Issue2872.aadl";
	private static final String UNRESOLVED_UPWARD = "org.osate.core.tests/models/issue3025/Issue3025.aadl";

	@Inject
	private IsolatedInstantiation isolated;

	/**
	 * A declaration naming a subcomponent at both ends connects a component to a component,
	 * which no connection instance can express. Both strategies report it identically and
	 * create nothing for it.
	 *
	 * <p>
	 * Across-first reaches that conclusion elsewhere: the declaration is not across, so no
	 * seed and no leg ever touches it, and the check stands on its own over every
	 * declaration. Source-first reports it when a path arrives with components at both ends.
	 * </p>
	 */
	@Test
	public void componentsAtBothEndsAreReportedIdentically() throws Exception {
		assertSameDiagnostics(BAD_PARAMETER, "T1.impl");
		assertSameDiagnostics(BAD_PARAMETER, "P1.impl");
		assertSameDiagnostics(BAD_ACCESS, "Sys1.impl");
		assertSameDiagnostics(BAD_ACCESS, "Sys3.impl");

		CharacterizationRun run = isolated.run(BAD_PARAMETER, "T1.impl", "ACROSS_FIRST", false);
		assertEquals(List.of("Error | Connection source and destination are components:"
				+ " T1_impl_Instance.Data2 => T1_impl_Instance.Data1 | at T1_impl_Instance|SystemInstance"
				+ " | in BadParameterConnection_T1_impl_Instance.aaxl2"),
				errors(InstanceSnapshot.of(run.instance(), run.errorManager())));
	}

	/**
	 * Allowlist entry 6. A feature a declaration names and the destination component does
	 * not have.
	 *
	 * <p>
	 * The connection instances are the same. Source-first reports the destination end only,
	 * because that is the end its traversal was resolving, and attaches the report to the
	 * component. Across-first resolves both ends of the declaration before it can be a
	 * segment at all, so it names both missing features and attaches them to the system
	 * instance.
	 * </p>
	 */
	@Test
	public void aMissingFeatureIsReportedForBothEndsOfTheDeclaration() throws Exception {
		CharacterizationRun sourceFirst = isolated.run(MISSING_FEATURE, "s.impl3", "SOURCE_FIRST", false);
		CharacterizationRun acrossFirst = isolated.run(MISSING_FEATURE, "s.impl3", "ACROSS_FIRST", false);
		InstanceSnapshot expected = InstanceSnapshot.of(sourceFirst.instance(), sourceFirst.errorManager());
		InstanceSnapshot actual = InstanceSnapshot.of(acrossFirst.instance(), acrossFirst.errorManager());

		assertEquals(InstanceReport.connectionLines(expected), InstanceReport.connectionLines(actual));
		assertEquals(List.of("Error | Destination feature f_in not found. No connection created."
				+ " | at s_impl3_Instance.f_pa|ComponentInstance"
				+ " | in flow_order_test_s_impl3_Instance.aaxl2"), errors(expected));
		assertEquals("allowlist entry 6: the resolver's own wording, for both ends",
				List.of("Error | Feature f_in not found in s_impl3_Instance.f_pa"
						+ " | at s_impl3_Instance|SystemInstance | in flow_order_test_s_impl3_Instance.aaxl2",
						"Error | Feature f_out not found in s_impl3_Instance.f_pa"
								+ " | at s_impl3_Instance|SystemInstance | in flow_order_test_s_impl3_Instance.aaxl2"),
				errors(actual));
	}

	/**
	 * Allowlist entry 7. A subcomponent a declaration names and the instance model does not
	 * have, which is the shape issue #3030 fixed the crash for.
	 *
	 * <p>
	 * One report either way, on the same target, differing only in the phrase source-first
	 * prefixes it with.
	 * </p>
	 */
	@Test
	public void aMissingSubcomponentInstanceIsReportedWithoutThePrefix() throws Exception {
		CharacterizationRun sourceFirst = isolated.run(MISSING_SUBCOMPONENT, "Top.i", "SOURCE_FIRST", false);
		CharacterizationRun acrossFirst = isolated.run(MISSING_SUBCOMPONENT, "Top.i", "ACROSS_FIRST", false);
		InstanceSnapshot expected = InstanceSnapshot.of(sourceFirst.instance(), sourceFirst.errorManager());
		InstanceSnapshot actual = InstanceSnapshot.of(acrossFirst.instance(), acrossFirst.errorManager());

		assertEquals(InstanceReport.connectionLines(expected), InstanceReport.connectionLines(actual));
		assertEquals(List.of("Error | Instantiation error: no component instance for subcomponent monitors"
				+ " | at Top_i_Instance|SystemInstance | in Issue3030_Top_i_Instance.aaxl2"), errors(expected));
		assertEquals("allowlist entry 7: the resolver's own wording",
				List.of("Error | No component instance for subcomponent monitors"
						+ " | at Top_i_Instance|SystemInstance | in Issue3030_Top_i_Instance.aaxl2"),
				errors(actual));
	}

	/**
	 * Allowlist entry 8. A path that travels up out of a subcomponent to a feature the level
	 * above routes nowhere.
	 *
	 * <p>
	 * The connection instances are the same, and neither strategy creates one for the path
	 * in question. Source-first is extending that path when it finds the level above has
	 * nothing to continue it with, so it has a candidate to report; across-first never
	 * enumerates it, because the declaration carrying it up is not across, nothing seeds it,
	 * and no leg reaches it.
	 * </p>
	 *
	 * <p>
	 * All three implementations the corpus has of this shape are here: a port, a nested
	 * feature group, and a port whose name resolves to nothing above.
	 * </p>
	 */
	@Test
	public void anUpwardPathTheLevelAboveDoesNotContinueLosesOnlyTheSourceFirstWarning() throws Exception {
		assertOnlySourceFirstWarns(UNCONTINUED_UPWARD, "X.root",
				"Warning | Could not continue connection from X_root_Instance.sub.th.th_p"
						+ "  through X_root_Instance.sub.ss_p. No connection instance created."
						+ " | at X_root_Instance.sub.ss_p|FeatureInstance|eventPort|0"
						+ " | in findConnectionInstance_X_root_Instance.aaxl2");
		assertOnlySourceFirstWarns(NESTED_UPWARD, "integration.impl",
				"Warning | Could not continue connection from integration_impl_Instance.b.a.outy"
						+ "  through integration_impl_Instance.b.outy. No connection instance created."
						+ " | at integration_impl_Instance.b.outy|FeatureInstance|featureGroup|0"
						+ " | in Issue2872_integration_impl_Instance.aaxl2");
		assertOnlySourceFirstWarns(UNRESOLVED_UPWARD, "Top.i",
				"Warning | Could not continue connection from Top_i_Instance.bridge.producer.to_unresolved"
						+ "  through Top_i_Instance.bridge.unresolved_terminal. No connection instance created."
						+ " | at Top_i_Instance.bridge.unresolved_terminal|FeatureInstance|eventPort|0"
						+ " | in Issue3025_Top_i_Instance.aaxl2");
	}

	/**
	 * The two runs agree on their connection instances and on every diagnostic except
	 * {@code warning}, which source-first reports and across-first does not.
	 */
	private void assertOnlySourceFirstWarns(String model, String implementation, String warning) throws Exception {
		CharacterizationRun sourceFirst = isolated.run(model, implementation, "SOURCE_FIRST", false);
		CharacterizationRun acrossFirst = isolated.run(model, implementation, "ACROSS_FIRST", false);
		InstanceSnapshot expected = InstanceSnapshot.of(sourceFirst.instance(), sourceFirst.errorManager());
		InstanceSnapshot actual = InstanceSnapshot.of(acrossFirst.instance(), acrossFirst.errorManager());

		assertEquals(implementation, InstanceReport.connectionLines(expected),
				InstanceReport.connectionLines(actual));
		assertEquals(implementation, true, InstanceReport.diagnosticSet(expected).contains(warning));
		assertEquals("allowlist entry 8: the warning disappears",
				InstanceReport.diagnosticSet(expected).stream().filter(line -> !line.equals(warning)).toList(),
				InstanceReport.diagnosticSet(actual));
	}

	private void assertSameDiagnostics(String model, String implementation) throws Exception {
		CharacterizationRun sourceFirst = isolated.run(model, implementation, "SOURCE_FIRST", false);
		CharacterizationRun acrossFirst = isolated.run(model, implementation, "ACROSS_FIRST", false);
		InstanceSnapshot expected = InstanceSnapshot.of(sourceFirst.instance(), sourceFirst.errorManager());
		InstanceSnapshot actual = InstanceSnapshot.of(acrossFirst.instance(), acrossFirst.errorManager());

		assertEquals(implementation, InstanceReport.connectionLines(expected),
				InstanceReport.connectionLines(actual));
		assertEquals(implementation, InstanceReport.diagnosticSet(expected), InstanceReport.diagnosticSet(actual));
	}

	/** The error reports of a run, which is what these models are about. */
	private static List<String> errors(InstanceSnapshot snapshot) {
		return InstanceReport.diagnosticSet(snapshot).stream().filter(line -> line.startsWith("Error")).toList();
	}
}
