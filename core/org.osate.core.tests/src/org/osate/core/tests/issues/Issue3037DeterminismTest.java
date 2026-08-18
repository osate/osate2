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
import static org.junit.Assert.assertNotSame;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.core.tests.instantiation.InstanceIntegrity;
import org.osate.core.tests.instantiation.InstanceReport;
import org.osate.core.tests.instantiation.InstanceRun;
import org.osate.core.tests.instantiation.InstanceSnapshot;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Establishes that two instantiations of one model share nothing and produce the
 * same result, which is the harness the across-first differential gate depends on.
 *
 * <p>
 * Two things have to hold before any strategy comparison means anything. The runs
 * must be genuinely isolated, otherwise the second run's result is contaminated by
 * the first, and EMF object identity would leak into comparisons that are supposed
 * to rest on stable keys. And a single strategy must be deterministic, including its
 * collection order, otherwise a difference between two strategies cannot be
 * distinguished from a difference between two runs of either one.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037DeterminismTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/Issue565DuplicateTraversal.aadl";

	@Inject
	private IsolatedInstantiation isolated;

	/**
	 * Two runs of the same model produce the same instance model, including the collection order
	 * of its connections, which allowlist entry 1 of issue #3037 releases from the baseline's
	 * order and therefore has to pin to something.
	 */
	@Test
	public void repeatedRunsAreIsolatedAndIdentical() throws Exception {
		InstanceRun first = isolated.run(MODEL, "Sys.Imp");
		InstanceRun second = isolated.run(MODEL, "Sys.Imp");

		// Isolation: nothing is shared, so no comparison can rest on object identity.
		assertNotSame(first.instance(), second.instance());
		assertNotSame(first.instance().eResource().getResourceSet(), second.instance().eResource().getResourceSet());
		assertNotSame(first.instance().getComponentImplementation(), second.instance().getComponentImplementation());

		InstanceSnapshot firstSnapshot = InstanceSnapshot.of(first.instance(), first.errorManager());
		InstanceSnapshot secondSnapshot = InstanceSnapshot.of(second.instance(), second.errorManager());

		assertEquals(InstanceReport.full(firstSnapshot), InstanceReport.full(secondSnapshot));
		assertEquals(InstanceReport.connectionOrderLines(firstSnapshot),
				InstanceReport.connectionOrderLines(secondSnapshot));

		assertEquals(List.of(), InstanceIntegrity.check(first.instance()));
		assertEquals(List.of(), InstanceIntegrity.check(second.instance()));
		assertEquals("the two legal orientations of the issue #565 model", 2,
				InstanceReport.connectionLines(firstSnapshot).size());
	}
}
