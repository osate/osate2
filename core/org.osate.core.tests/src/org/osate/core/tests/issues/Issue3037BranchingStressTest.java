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

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * What the stress fixtures of issue #3037 must produce, whatever machine runs them.
 *
 * <p>
 * These shapes are where depth, feature group width and branching could multiply, and the
 * assertion is the number of connection instances each one has, computed from the shape rather
 * than copied from a run. A traversal that starts multiplying fails here.
 * </p>
 *
 * <p>
 * The traversal state counts that used to be asserted alongside them are gone with the
 * instrumentation they read. They were the gated part of the performance budget: across-first
 * spends 2w + 2 traversal states at branch width w where source-first spends w<sup>2</sup> + 4w,
 * and its joins are exactly w<sup>2</sup>, the number of connections the shape has. Those
 * numbers, and the wall-clock measurements that were never gateable in a reactor build, are
 * recorded as evidence on issue #3037 rather than asserted here.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037BranchingStressTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/AcrossFirstBranchingStress.aadl";
	private static final String DEPTH = "org.osate.core.tests/models/issue3037/AcrossFirstDepthWidthStress.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private IsolatedInstantiation isolated;

	@Test
	public void theFixturesAreValid() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(MODEL));
		validationHelper.assertNoIssues(testHelper.parseFile(DEPTH));
	}

	/**
	 * Depth, feature group width and branching at once, which is where the three could multiply.
	 * Four source legs and four destination legs join into 16 paths, each expanding to the 64
	 * leaves of a group nested three levels deep with a width of four: 1024 connection instances.
	 */
	@Test
	public void depthWidthAndBranchingDoNotMultiplyTheTraversal() throws Exception {
		int leaves = 4 * 4 * 4;
		int paths = 4 * 4;
		assertEquals(paths * leaves,
				isolated.run(DEPTH, "Top.depthAndWidth").instance().getAllConnectionInstances().size());
	}

	/** The shape produces one connection instance per pair of branches, at every width. */
	@Test
	public void everyBranchPairBecomesOneConnection() throws Exception {
		for (int width : new int[] { 2, 4, 8 }) {
			var implementation = "Top.width" + width;
			assertEquals(implementation, width * width,
					isolated.run(MODEL, implementation).instance().getAllConnectionInstances().size());
		}
	}
}
