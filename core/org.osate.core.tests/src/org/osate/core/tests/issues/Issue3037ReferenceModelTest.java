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
import org.osate.core.tests.instantiation.InstanceCharacterization;
import org.osate.core.tests.instantiation.InstanceIntegrity;
import org.osate.core.tests.instantiation.InstanceReport;
import org.osate.core.tests.instantiation.InstanceRun;
import org.osate.core.tests.instantiation.InstanceSnapshot;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes the connection set of five reference models, for issue #3037.
 *
 * <p>
 * These are the models the traversal was developed against, kept together because between them
 * they cover inverse feature groups, nested feature groups, subset matching, an incomplete
 * boundary connection, and the same shape flat and nested. Each runs in its own resource set,
 * and what is asserted is the container-relative connection names, so nothing rests on EMF
 * object identity or on collection position.
 * </p>
 *
 * <p>
 * None of them contains a component array, {@code Connection_Pattern}, or
 * {@code Connection_Set}, so they exercise enumeration, expansion, and materialization but not
 * structural expansion.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037ReferenceModelTest extends XtextTest {
	private static final String DUPLICATE = "org.osate.core.tests/models/issue3037/Issue565DuplicateTraversal.aadl";
	private static final String INTERNAL = "org.osate.core.tests/models/issue3027/Issue3027.aadl";
	private static final String NESTED = "org.osate.core.tests/models/issue3019/Issue3019.aadl";
	private static final String BOUNDARY = "org.osate.core.tests/models/issue3038/Issue3038.aadl";
	private static final String FLAT_AND_NESTED = "org.osate.core.tests/models/issue3040/Issue3040.aadl";

	@Inject
	private IsolatedInstantiation isolated;

	@Test
	public void inverseFeatureGroupsAreInstantiatedInBothDirections() throws Exception {
		InstanceCharacterization.assertConnections(isolated, DUPLICATE, "Sys.Imp",
				"proc.fgPorts.inPort -> sub.iproc.fgPorts.inPort", "sub.iproc.fgPorts.inPort -> proc.fgPorts.inPort");
	}

	/**
	 * The one connection the model has, and no diagnostic from the traversal. A segment whose
	 * end is an internal feature is ignored silently, which is allowlist entry 3 of issue
	 * #3037: the warning that used to accompany it is redundant with the declarative error
	 * added by issue #3028 and is unreachable for a model that validates.
	 */
	@Test
	public void aConnectionIntoAnInternalFeatureIsIgnoredSilently() throws Exception {
		InstanceRun run = InstanceCharacterization.assertConnections(isolated, INTERNAL, "Top.i",
				"sensor.alarm -> monitor.incoming");

		/*
		 * Allowlist entry 3. Before issue #3037 this warned "Connection to
		 * Issue3027::Top.i.raised_event could not be instantiated." against the system instance. An
		 * internal feature has no instance object for a connection to end at, so the segment is
		 * ignored, and the declarative error issue #3028 added is the report that remains.
		 */
		assertEquals("allowlist entry 3: the warning is gone", List.of(),
				InstanceReport.diagnosticLines(InstanceSnapshot.of(run.instance(), run.errorManager())));
	}

	@Test
	public void nestedFeatureGroupsAreInstantiated() throws Exception {
		InstanceCharacterization.assertConnections(isolated, NESTED, "Top.i",
				"consumer_side.boundary.destination_inner.alpha -> producer_side.leaf_side.leaf.io",
				"producer_side.leaf_side.leaf.io -> consumer_side.boundary.destination_inner.alpha");
	}

	@Test
	public void subsetMatchingPairsMembersByName() throws Exception {
		InstanceCharacterization.assertConnections(isolated, NESTED, "SubsetTop.i",
				"producer.boundary.common -> consumer.boundary.common");
	}

	@Test
	public void incompleteBoundaryConnectionsAreInstantiated() throws Exception {
		InstanceCharacterization.assertConnections(isolated, BOUNDARY, "Producer.i",
				"boundary.inner.alpha -> leaf_side.leaf.io", "leaf_side.leaf.io -> boundary.inner.alpha");
	}

	@Test
	public void nestingDoesNotChangeTheConnectionSet() throws Exception {
		InstanceCharacterization.assertConnections(isolated, FLAT_AND_NESTED, "Flat.i",
				"boundary.alpha -> leaf_side.leaf.io", "leaf_side.leaf.io -> boundary.alpha");
		InstanceCharacterization.assertConnections(isolated, FLAT_AND_NESTED, "Nested.i",
				"boundary.inner.alpha -> leaf_side.leaf.io", "leaf_side.leaf.io -> boundary.inner.alpha");
	}

}
