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
import java.util.Map;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instantiation.testing.CharacterizationRun;
import org.osate.aadl2.instantiation.testing.DuplicateCandidateObservation;
import org.osate.aadl2.instantiation.testing.InstantiationCharacterization;
import org.osate.core.tests.instantiation.ConnectionDescriptor;
import org.osate.core.tests.instantiation.InstanceSnapshot;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Captures the candidates that source-first traversal offers to the reverse-order
 * duplicate check on the issue #565 model, for the across-first traversal
 * enhancement (issue #3037).
 *
 * <p>
 * Suppressed candidates are never attached to the instance model, so an
 * observation recorded at the decision point is the only way to see them.
 * </p>
 *
 * <p>
 * The result is that this model suppresses nothing. Source-first traversal offers
 * exactly two candidates and the duplicate check accepts both: they are the two
 * legal endpoint orientations, not a semantic connection enumerated twice.
 * Whatever the reverse-order comparison was written for, this model does not
 * exercise it, so this fixture cannot answer whether across-first traversal needs
 * a survivor-orientation rule. That question needs a fixture in which the check
 * actually fires. The in-code comment above the check points at component arrays.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037CandidateCaptureTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/Issue565DuplicateTraversal.aadl";

	private static final String C1 = "Issue565DuplicateTraversal.aadl"
			+ "#/0/@ownedPublicSection/@ownedClassifier.7/@ownedFeatureGroupConnection.0";
	private static final String C2 = "Issue565DuplicateTraversal.aadl"
			+ "#/0/@ownedPublicSection/@ownedClassifier.5/@ownedFeatureGroupConnection.0";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void everyCandidateIsAcceptedAndMaterialized() throws Exception {
		CharacterizationRun run = InstantiationCharacterization.run(implementation(), "SOURCE_FIRST", true);

		assertEquals("SOURCE_FIRST", run.strategy());
		assertEquals("the duplicate check must see every candidate", 2, run.duplicateCandidates().size());
		assertEquals("this model suppresses no candidate at all", List.of(), run.suppressedCandidates());

		// Both accepted candidates reach the model, and each one's endpoints,
		// declarations, contexts, and reverse flags survive materialization unchanged.
		InstanceSnapshot snapshot = InstanceSnapshot.of(run.instance(), run.errorManager());
		assertEquals(materializedKeys(snapshot), run.acceptedCandidates().stream().map(this::candidateKey).sorted().toList());
	}

	/**
	 * The traversal counters for this model, recorded as calibration data. The state
	 * count is what across-first traversal has to be compared against, so it is
	 * asserted rather than merely printed.
	 */
	@Test
	public void traversalCountersAreRecorded() throws Exception {
		CharacterizationRun run = InstantiationCharacterization.run(implementation(), "SOURCE_FIRST");

		assertEquals(Map.of("DECLARATIONS_EXAMINED", 3L, "TRAVERSAL_STATES", 4L, "JOIN_CANDIDATES", 0L, "FINAL_PATHS",
				2L, "DUPLICATE_CANDIDATES", 2L, "SEEDS_DISCOVERED", 2L, "LEGS_RESOLVED", 4L, "PATHS_ASSEMBLED", 2L), run.counters());
	}

	/**
	 * The two orientations, rendered from the candidate observation, in the same
	 * shape as {@link #materializedKeys}.
	 */
	@Test
	public void candidateOrientationsAreDistinct() throws Exception {
		CharacterizationRun run = InstantiationCharacterization.run(implementation(), "SOURCE_FIRST", true);

		assertEquals(List.of(
				"Sys_Imp_Instance.proc.fgPorts.inPort -> Sys_Imp_Instance.sub.iproc.fgPorts.inPort"
						+ " declarations=[" + C1 + ", " + C2 + "]"
						+ " contexts=[Sys_Imp_Instance, Sys_Imp_Instance.sub] reverse=[false, false]",
				"Sys_Imp_Instance.sub.iproc.fgPorts.inPort -> Sys_Imp_Instance.proc.fgPorts.inPort"
						+ " declarations=[" + C2 + ", " + C1 + "]"
						+ " contexts=[Sys_Imp_Instance.sub, Sys_Imp_Instance] reverse=[true, true]"),
				run.duplicateCandidates().stream().map(this::candidateKey).sorted().toList());
	}

	private ComponentImplementation implementation() {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		return (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Sys.Imp"))
				.findFirst()
				.orElseThrow();
	}

	/**
	 * Render a candidate observation with the same fields, in the same order, as
	 * {@link #materializedKeys} renders a materialized descriptor. Comparing the two
	 * renderings is what links an accepted candidate to the connection it became.
	 */
	private String candidateKey(DuplicateCandidateObservation candidate) {
		return candidate.sourcePath() + " -> " + candidate.destinationPath() + " declarations="
				+ candidate.declarationUris().stream().map(Issue3037CandidateCaptureTest::shorten).toList()
				+ " contexts=" + candidate.contextPaths() + " reverse=" + candidate.reverseFlags();
	}

	private List<String> materializedKeys(InstanceSnapshot snapshot) {
		return snapshot.allConnections().stream().map(descriptor -> {
			ConnectionDescriptor.Key key = descriptor.key();
			return stripMetaclass(key.sourceKey()) + " -> " + stripMetaclass(key.destinationKey()) + " declarations="
					+ key.declarationKeys() + " contexts="
					+ key.contextKeys().stream().map(Issue3037CandidateCaptureTest::stripMetaclass).toList()
					+ " reverse=" + key.reverseFlags();
		}).sorted().toList();
	}

	/**
	 * Candidate observations carry whole element URIs, while descriptor keys carry
	 * only the file name and fragment, because that is what stays stable across
	 * resource sets.
	 */
	private static String shorten(String uri) {
		int fragment = uri.indexOf('#');
		String path = fragment < 0 ? uri : uri.substring(0, fragment);
		int slash = path.lastIndexOf('/');
		return (slash < 0 ? path : path.substring(slash + 1)) + (fragment < 0 ? "" : uri.substring(fragment));
	}

	/** Drop the metaclass and category suffix an instance key carries. */
	private static String stripMetaclass(String key) {
		int bar = key.indexOf('|');
		return bar < 0 ? key : key.substring(0, bar);
	}
}
