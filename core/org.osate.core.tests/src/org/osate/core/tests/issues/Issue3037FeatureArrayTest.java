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
import org.osate.core.tests.instantiation.InstanceRun;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Compares the two traversal strategies over feature arrays, with no feature group
 * involved, for issue #3037.
 *
 * <p>
 * The other feature array model in the corpus, {@code issue2786/FeatureArrays.aadl},
 * connects nothing: it declares one array feature in every category to check where a
 * feature array is allowed. These are therefore the first connections over a feature array
 * that either strategy is held to, which is what the plan's matrix was missing.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037FeatureArrayTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/FeatureArrays.aadl";

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

	/**
	 * A component array feeding a feature array, and a feature array feeding one. Element by
	 * element in both directions, with the array index part of the connection name.
	 */
	@Test
	public void arrayFeaturesAtABoundaryAgree() throws Exception {
		assertConnections("ArrayFeeder.i", "boxes[1].worker.outp --> outs[1]", "boxes[2].worker.outp --> outs[2]");
		assertConnections("ArrayDrain.i", "ins[1] --> boxes[1].worker.inp", "ins[2] --> boxes[2].worker.inp");

	}

	/** Feature arrays at both ends of the pivot, each side descending into a component array. */
	@Test
	public void featureArraysAcrossAPivotAgree() throws Exception {
		assertConnections("Top.arrayToArray", "feeder.boxes[1].worker.outp --> drain.boxes[1].worker.inp",
				"feeder.boxes[2].worker.outp --> drain.boxes[2].worker.inp");

	}

	/**
	 * The same pivot with a structural pattern, so expansion and the feature array meet.
	 *
	 * <p>
	 * {@code One_To_All} pairs the first source element with every destination element, so
	 * the second producer has no connection instance at all where the default pairing above
	 * gives it one. That is what both strategies produce, and it is recorded rather than
	 * judged: whether a pattern over a feature array should consume every source element is a
	 * question about expansion, which is shared pipeline and outside this enhancement.
	 * </p>
	 */
	@Test
	public void aPatternOverFeatureArraysAgrees() throws Exception {
		assertConnections("Top.patternedArrayToArray", "feeder.boxes[1].worker.outp --> drain.boxes[1].worker.inp",
				"feeder.boxes[1].worker.outp --> drain.boxes[2].worker.inp");

	}

	private void assertConnections(String implementation, String... expected) throws Exception {
		InstanceCharacterization.assertConnections(isolated, MODEL, implementation, expected);
	}

	/** The across-first connection instance names, sorted, so a count cannot pass vacuously. */
	private List<String> connectionNames(String implementation) throws Exception {
		InstanceRun run = isolated.run(MODEL, implementation);
		return run.instance()
				.getAllConnectionInstances()
				.stream()
				.map(connection -> connection.getName())
				.sorted()
				.toList();
	}
}
