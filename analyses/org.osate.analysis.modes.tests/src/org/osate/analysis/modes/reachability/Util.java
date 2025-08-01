/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.analysis.modes.reachability;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.List;

import org.osate.analysis.modes.modemodel.SOMGraph;
import org.osate.analysis.modes.modemodel.SOMLevel;

public final class Util {

	private Util() {
	}

	public static void assertCounts(SOMLevel level, int nodes, int transitions) {
		assertAll(() -> assertSomCount(level, nodes), () -> assertTransitionCount(level, transitions));
	}

	@SuppressWarnings("unchecked")
	public static void assertCounts(ReachabilityAnalyzer ra, List<Integer> somCounts, List<Integer> triggerCounts,
			List<Integer> transitionCounts) throws Exception {
		var scIter = somCounts.iterator();
		var tgcIter = triggerCounts.iterator();
		var tncIter = transitionCounts.iterator();

		// domain list is protected
		Field domains = ModeDomain.class.getDeclaredField("domains");
		domains.setAccessible(true);

		for (var md : (List<ModeDomain>) domains.get(null)) {
			assertAll(() -> assertSomCount(md, scIter.next()), () -> assertTriggerCount(md, tgcIter.next()),
					() -> assertTransitionCount(md, tncIter.next()));
		}
	}

	private static void assertSomCount(SOMLevel level, int expected) {
		var actual = level.getNodes().size();
		assertEquals(expected, actual, "number of soms");
	}

	private static void assertTransitionCount(SOMLevel level, int expected) {
		var actual = level.getTransitions().size();
		assertEquals(expected, actual, "number of transitions");
	}

	private static void assertSomCount(ModeDomain md, int expected) {
		var level = md.getAnalyzer().getLastLevel();
		var actual = level.getNodes().size();
		assertEquals(expected, actual, "number of soms");
	}

	private static void assertTriggerCount(ModeDomain md, int expected) throws Exception {
		// graph is protected
		Field graph = ModeDomain.class.getDeclaredField("graph");
		graph.setAccessible(true);

		int actual = 0;
		for (var tg : ((SOMGraph) graph.get(md)).getTriggers().values()) {
			if (!tg.getTransitions().isEmpty()) {
				actual++;
			}
		}
		assertEquals(expected, actual, "number of triggers");
	}

	private static void assertTransitionCount(ModeDomain md, int expected) {
		var level = md.getAnalyzer().getLastLevel();
		var actual = level.getTransitions().size();
		assertEquals(expected, actual, "number of transitions");
	}

}
