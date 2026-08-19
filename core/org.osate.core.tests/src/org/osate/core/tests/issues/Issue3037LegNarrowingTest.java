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
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.core.tests.instantiation.InstanceCharacterization;
import org.osate.core.tests.instantiation.InstanceReport;
import org.osate.core.tests.instantiation.InstanceRun;
import org.osate.core.tests.instantiation.InstanceSnapshot;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes a leg that descends through a declaration naming a different level of a
 * feature group than the leg stands at, for issue #3037.
 *
 * <p>
 * These are the rules that switching the production strategy found missing on 2026-08-18. Each
 * was a materialized difference, and the pairing one was on a shape the corpus sweep never saw,
 * because {@code Issue500Test} builds its model as an Xtend string rather than as a fixture
 * under {@code models}.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037LegNarrowingTest extends XtextTest {
	private static final String NARROWING = "org.osate.core.tests/models/issue3037/LegNarrowing.aadl";
	private static final String ROUTED_INSIDE = "org.osate.core.tests/models/issue2780/P.aadl";

	@Inject
	private IsolatedInstantiation isolated;

	/**
	 * Both sides of the pivot route both members of an inner feature group onwards, so the legs
	 * diverge one level below the member they all attach at.
	 *
	 * <p>
	 * Two source legs and two destination legs join four ways and only two of them are semantic
	 * connections. Pairing legs by where they attach to the pivot accepts all four here, because
	 * all four attach at the same member; pairing them by the whole member chain each covers,
	 * mapped back through the segments it traversed, accepts two.
	 * </p>
	 */
	@Test
	public void legsPairByTheWholeMemberChainTheyCover() throws Exception {
		InstanceCharacterization.assertConnections(isolated, NARROWING, "Top.branching",
				"sender.mid.firstSource.p -> receiver.mid.firstSink.p",
				"sender.mid.secondSource.p -> receiver.mid.secondSink.p");

	}

	/**
	 * A source leg that finds nothing to descend into is not always the ultimate source.
	 *
	 * <p>
	 * The pivot {@code cl1} is bidirectional and {@code m} routes the feature it arrives at
	 * inwards with {@code c1: feature group fl -> mm.fgl}, so a path may not start at
	 * {@code m}'s own feature: it would start deeper. Nothing inside can reach it either,
	 * because {@code c1} is directional, so no connection instance exists in that direction at
	 * all. This is {@code LegResolver.mayBeUltimateSource}, and it is required behavior: 2.18.0
	 * created no connection here either.
	 * </p>
	 *
	 * <p>
	 * The one difference from 2.18.0 on this model is allowlist entry 5, the warning that no
	 * declaration carries the connection further into {@code m}, which was reported while
	 * descending and followed by that connection being created from the other direction anyway.
	 * </p>
	 */
	@Test
	public void aFeatureRoutedInsideItsComponentIsNotTheUltimateSource() throws Exception {
		var run = isolated.run(ROUTED_INSIDE, "S1.i");

		/*
		 * The three duplicates of each complete connection are the three declarations that carry it:
		 * cl, cl1 and cl2 on the left, cr, cr1 and cr2 on the right. The connection the rule refuses,
		 * m.fl.fg.fo to l.fl.fg.fo, is absent, and so is any report about it.
		 */
		assertEquals(List.of("l.fl.fg.fi -> m.mm.fgl.fg.fi", "l.fl.fg.fi -> m.mm.fgl.fg.fi",
				"l.fl.fg.fi -> m.mm.fgl.fg.fi", "m.mm.fgr.fg.fo -> r.fr.fg.fo", "m.mm.fgr.fg.fo -> r.fr.fg.fo",
				"m.mm.fgr.fg.fo -> r.fr.fg.fo", "r.fr.fg.fi -> m.fr.fg.fi"), names(run));

		/*
		 * Allowlist entry 5, on one implementation more than the entry lists: "No connection
		 * declaration from feature fr of component m to subcomponents. Connection instance ends at m"
		 * was also reported here before issue #3037, while descending into m, and that connection was
		 * then created from the other direction anyway. What remains is the model's flow errors.
		 */
		assertEquals(List.of(), InstanceReport.diagnosticSet(InstanceSnapshot.of(run.instance(), run.errorManager()))
				.stream()
				.filter(line -> line.contains("No connection declaration from feature"))
				.toList());
	}

	private static List<String> names(InstanceRun run) {
		return run.instance()
				.getAllConnectionInstances()
				.stream()
				.map(ConnectionInstance::getName)
				.sorted()
				.toList();
	}
}
