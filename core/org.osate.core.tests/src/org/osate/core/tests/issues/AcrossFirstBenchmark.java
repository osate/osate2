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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instantiation.testing.CharacterizationRun;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Wall-clock evidence for the issue #3037 performance budget, run on demand and never by the
 * suite.
 *
 * <p>
 * The class name does not end in {@code Test}, so the default surefire selection skips it. Run
 * it explicitly, on an otherwise idle machine:
 * </p>
 *
 * <pre>
 * mvn -o -s releng/osate.releng/settings.xml -Plocal -pl :org.osate.core.tests \
 *   -Dtycho.localArtifacts=default -Dpr.build=true -Dtest=AcrossFirstBenchmark \
 *   -DfailIfNoTests=false clean verify
 * </pre>
 *
 * <p>
 * Ratio budgets are reviewer-enforced release criteria rather than assertions: a 1.25 or 1.50
 * wall-clock ratio is not decidable on a shared machine or inside a parallel reactor build, so
 * this prints medians and spreads and asserts nothing about them. The deterministic half of the
 * budget, the traversal state counts, is asserted by
 * {@link Issue3037BranchingStressTest} instead.
 * </p>
 *
 * <p>
 * Allocation is deliberately not measured here. {@code com.sun.management.ThreadMXBean} is not
 * exported by the Eclipse system bundle, so reaching it needs an
 * {@code org.osgi.framework.system.packages.extra} change to the test launch; the plan records
 * that as a blocked gate rather than something to work around, and the timings below are what
 * the reviewer can act on today.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class AcrossFirstBenchmark extends XtextTest {
	private static final String BRANCHING = "org.osate.core.tests/models/issue3037/AcrossFirstBranchingStress.aadl";
	private static final String DEPTH = "org.osate.core.tests/models/issue3037/AcrossFirstDepthWidthStress.aadl";
	private static final String DECLARATIVE = "org.osate.core.tests/models/Issue2362/DeclarativeTests.aadl";

	/** Two warmup runs and five measured runs, as the plan specifies. */
	private static final int WARMUP = 2;
	private static final int MEASURED = 5;

	/**
	 * The plan's noise floor: a measured run has to last at least this long for a ratio to mean
	 * anything, so instantiation is repeated inside one measured run until it does and the total
	 * is divided by the repetitions.
	 */
	private static final long NOISE_FLOOR_NANOS = 50_000_000L;

	@Inject
	private IsolatedInstantiation isolated;

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void report() throws Exception {
		System.out.println("fixture | implementation | strategy | connection phase ms (median, min..max)"
				+ " | traversal ms (median, min..max) | connections | inner repetitions");
		measure(BRANCHING, "Top.width8");
		measure(DEPTH, "Top.depthAndWidth");
		measureWholeFile(DECLARATIVE);
	}

	private void measure(String model, String implementation) throws Exception {
		for (String strategy : new String[] { "SOURCE_FIRST", "ACROSS_FIRST" }) {
			long probe = 0;
			for (int run = 0; run < WARMUP; run++) {
				probe = isolated.runTimed(model, implementation, strategy).connectionPhaseNanos();
			}
			int inner = repetitionsFor(probe);
			List<Long> phase = new ArrayList<>();
			List<Long> traversal = new ArrayList<>();
			int connections = 0;
			for (int run = 0; run < MEASURED; run++) {
				long phaseTotal = 0, traversalTotal = 0;
				for (int repetition = 0; repetition < inner; repetition++) {
					CharacterizationRun measured = isolated.runTimed(model, implementation, strategy);
					phaseTotal += measured.connectionPhaseNanos();
					traversalTotal += measured.traversalNanos();
					connections = measured.instance().getAllConnectionInstances().size();
				}
				phase.add(phaseTotal / inner);
				traversal.add(traversalTotal / inner);
			}
			System.out.println(model.substring(model.lastIndexOf('/') + 1) + " | " + implementation + " | " + strategy
					+ " | " + summary(phase) + " | " + summary(traversal) + " | " + connections + " | x" + inner);
		}
	}

	/** How many instantiations one measured run needs to clear the noise floor. */
	private static int repetitionsFor(long oneRunNanos) {
		return oneRunNanos <= 0 ? 1 : (int) Math.max(1, Math.min(64, NOISE_FLOOR_NANOS / oneRunNanos + 1));
	}

	/**
	 * The existing large core fixture, measured as the sum over every implementation it
	 * declares. It has no single large implementation, so one of them says nothing; what a
	 * model of its size costs is the whole file.
	 */
	private void measureWholeFile(String model) throws Exception {
		AadlPackage pkg = testHelper.parseFile(model);
		List<String> implementations = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(ComponentImplementation.class::isInstance)
				.map(NamedElement::getName)
				.toList();
		for (String strategy : new String[] { "SOURCE_FIRST", "ACROSS_FIRST" }) {
			List<Long> phase = new ArrayList<>();
			List<Long> traversal = new ArrayList<>();
			int connections = 0;
			for (int run = 0; run < WARMUP + MEASURED; run++) {
				long phaseTotal = 0, traversalTotal = 0;
				int total = 0;
				for (String implementation : implementations) {
					try {
						CharacterizationRun measured = isolated.runTimed(model, implementation, strategy);
						phaseTotal += measured.connectionPhaseNanos();
						traversalTotal += measured.traversalNanos();
						total += measured.instance().getAllConnectionInstances().size();
					} catch (Exception | AssertionError e) {
						// An implementation the baseline cannot instantiate is not what is measured here.
					}
				}
				if (run >= WARMUP) {
					phase.add(phaseTotal);
					traversal.add(traversalTotal);
					connections = total;
				}
			}
			System.out.println(model.substring(model.lastIndexOf('/') + 1) + " | all " + implementations.size()
					+ " implementations | " + strategy + " | " + summary(phase) + " | " + summary(traversal) + " | "
					+ connections + " | x1");
		}
	}

	private static String summary(List<Long> nanos) {
		List<Long> sorted = nanos.stream().sorted().toList();
		return millis(sorted.get(sorted.size() / 2)) + " (" + millis(sorted.get(0)) + ".."
				+ millis(sorted.get(sorted.size() - 1)) + ")";
	}

	private static String millis(long nanos) {
		return String.format("%.2f", nanos / 1_000_000.0);
	}
}
