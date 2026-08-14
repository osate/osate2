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
import org.osate.core.tests.instantiation.InstanceIntegrity;
import org.osate.core.tests.instantiation.InstanceReport;
import org.osate.core.tests.instantiation.InstanceSnapshot;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.core.tests.instantiation.StrategyDifference;
import org.osate.testsupport.Aadl2InjectorProvider;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Compares the instance models the two traversal strategies produce, for issue #3037.
 *
 * <p>
 * Each strategy runs in its own resource set, and the comparison is between normalized
 * descriptors keyed on structured identity, so nothing rests on EMF object identity or
 * on collection position. Names are part of the descriptor and are compared exactly.
 * </p>
 *
 * <p>
 * These fixtures contain no component arrays, {@code Connection_Pattern}, or
 * {@code Connection_Set}, so they exercise enumeration, expansion, and materialization
 * but not structural expansion.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037DifferentialTest extends XtextTest {
	private static final String DUPLICATE = "org.osate.core.tests/models/issue3037/Issue565DuplicateTraversal.aadl";
	private static final String INTERNAL = "org.osate.core.tests/models/issue3027/Issue3027.aadl";
	private static final String NESTED = "org.osate.core.tests/models/issue3019/Issue3019.aadl";
	private static final String BOUNDARY = "org.osate.core.tests/models/issue3038/Issue3038.aadl";
	private static final String FLAT_AND_NESTED = "org.osate.core.tests/models/issue3040/Issue3040.aadl";

	@Inject
	private IsolatedInstantiation isolated;

	@Test
	public void inverseFeatureGroupsAgree() throws Exception {
		assertSameModel(DUPLICATE, "Sys.Imp");
	}

	/**
	 * The connections agree, and the diagnostics differ by exactly the approved
	 * allowlist entry: source-first warns that the connection into the internal feature
	 * could not be instantiated, and across-first ignores the segment silently. The
	 * warning is redundant with the declarative error added by issue #3028 and is
	 * unreachable for a model that validates.
	 */
	@Test
	public void aConnectionIntoAnInternalFeatureAgreesApartFromTheApprovedWarning() throws Exception {
		CharacterizationRun sourceFirst = isolated.run(INTERNAL, "Top.i", "SOURCE_FIRST", false);
		CharacterizationRun acrossFirst = isolated.run(INTERNAL, "Top.i", "ACROSS_FIRST", false);

		InstanceSnapshot expected = InstanceSnapshot.of(sourceFirst.instance(), sourceFirst.errorManager());
		InstanceSnapshot actual = InstanceSnapshot.of(acrossFirst.instance(), acrossFirst.errorManager());

		assertEquals(InstanceReport.connectionLines(expected), InstanceReport.connectionLines(actual));
		assertEquals(List.of(), InstanceIntegrity.check(acrossFirst.instance()));

		assertEquals(List.of("Warning | Connection to Issue3027::Top.i.raised_event could not be instantiated."
				+ " | at Top_i_Instance|SystemInstance | in Issue3027_Top_i_Instance.aaxl2"),
				InstanceReport.diagnosticLines(expected));
		assertEquals("allowlist entry 3: the warning disappears", List.of(),
				InstanceReport.diagnosticLines(actual));
	}

	@Test
	public void nestedFeatureGroupsAgree() throws Exception {
		assertSameModel(NESTED, "Top.i");
	}

	@Test
	public void subsetMatchingAgrees() throws Exception {
		assertSameModel(NESTED, "SubsetTop.i");
	}

	@Test
	public void incompleteBoundaryConnectionsAgree() throws Exception {
		assertSameModel(BOUNDARY, "Producer.i");
	}

	@Test
	public void nestingDoesNotChangeAgreement() throws Exception {
		assertSameModel(FLAT_AND_NESTED, "Flat.i");
		assertSameModel(FLAT_AND_NESTED, "Nested.i");
	}

	private void assertSameModel(String model, String implementation) throws Exception {
		StrategyDifference.assertSameModel(isolated, model, implementation);
	}
}
