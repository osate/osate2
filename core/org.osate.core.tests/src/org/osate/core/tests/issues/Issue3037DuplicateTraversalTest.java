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
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.core.tests.instantiation.InstanceIntegrity;
import org.osate.core.tests.instantiation.InstanceReport;
import org.osate.core.tests.instantiation.InstanceSnapshot;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterization of the issue #565 duplicate-enumeration model for the
 * across-first connection traversal enhancement (issue #3037).
 *
 * <p>
 * Source-first traversal enumerates the semantic connection through the pair of
 * inverse feature groups more than once, and the reverse-order duplicate check in
 * {@code CreateConnectionsSwitch} suppresses the redundant candidates. This test
 * pins what actually survives, so that across-first traversal can be held to the
 * same materialized result.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3037DuplicateTraversalTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3037/Issue565DuplicateTraversal.aadl";

	/** {@code c1} in {@code Sys.Imp}, the across declaration between the two peers. */
	private static final String C1 = "Issue565DuplicateTraversal.aadl"
			+ "#/0/@ownedPublicSection/@ownedClassifier.7/@ownedFeatureGroupConnection.0";

	/** {@code c2} in {@code sub.i}, the declaration that descends into {@code iproc}. */
	private static final String C2 = "Issue565DuplicateTraversal.aadl"
			+ "#/0/@ownedPublicSection/@ownedClassifier.5/@ownedFeatureGroupConnection.0";

	private static final String PROC_PORT = "Sys_Imp_Instance.proc.fgPorts.inPort|FeatureInstance|dataPort|0";
	private static final String IPROC_PORT = "Sys_Imp_Instance.sub.iproc.fgPorts.inPort|FeatureInstance|dataPort|0";
	private static final String TOP = "Sys_Imp_Instance|SystemInstance";
	private static final String SUB = "Sys_Imp_Instance.sub|ComponentInstance";

	/**
	 * The two connection instances the baseline materializes, one per legal
	 * endpoint orientation. Both are complete, both report
	 * {@code bidirectional == false}, and the two differ in every
	 * orientation-bearing field: endpoint pair, declaration order, context order,
	 * and per-reference reverse flag. Neither is a suppressed duplicate of the
	 * other.
	 */
	private static final List<String> BASELINE_CONNECTIONS = List.of(
			"name='proc.fgPorts.inPort -> sub.iproc.fgPorts.inPort' kind=portConnection complete=true"
					+ " bidirectional=false container=" + TOP + " src=" + PROC_PORT + " dst=" + IPROC_PORT
					+ " declarations=[" + C1 + ", " + C2 + "] contexts=[" + TOP + ", " + SUB
					+ "] reverse=[false, false] soms=[] properties=[]",
			"name='sub.iproc.fgPorts.inPort -> proc.fgPorts.inPort' kind=portConnection complete=true"
					+ " bidirectional=false container=" + TOP + " src=" + IPROC_PORT + " dst=" + PROC_PORT
					+ " declarations=[" + C2 + ", " + C1 + "] contexts=[" + SUB + ", " + TOP
					+ "] reverse=[true, true] soms=[] properties=[]");

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void inverseFeatureGroupTraversalIsCharacterized() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var top = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Sys.Imp"))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		SystemInstance instance = InstantiateModel.instantiate(top, errorManager);
		InstanceSnapshot snapshot = InstanceSnapshot.of(instance, errorManager);

		assertEquals(List.of(), InstanceIntegrity.check(instance));
		assertEquals(List.of(), InstanceReport.diagnosticLines(snapshot));
		assertEquals(BASELINE_CONNECTIONS, InstanceReport.connectionLines(snapshot));
		assertEquals(List.of(), InstanceReport.flowLines(snapshot));

		var connections = snapshot.allConnections();
		assertTrue("no connection instance may report bidirectional == true",
				connections.stream().noneMatch(connection -> connection.bidirectional()));
		assertEquals("every connection descriptor must have a distinct structured identity", connections.size(),
				snapshot.connectionsByKey().size());
	}

	/**
	 * The two legal orientations are the <em>only</em> connections in the model, and
	 * both live in the system instance rather than in {@code sub}. This is recorded
	 * separately from the semantic comparison above because collection order is an
	 * approved intended difference for across-first traversal, so this is the one
	 * assertion that is expected to be revisited when the strategy changes.
	 */
	@Test
	public void baselineCollectionOrderIsRecorded() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var top = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Sys.Imp"))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		InstanceSnapshot snapshot = InstanceSnapshot.of(InstantiateModel.instantiate(top, errorManager), errorManager);

		assertEquals(List.of("Sys_Imp_Instance.proc|ComponentInstance => ",
				"Sys_Imp_Instance.sub.iproc|ComponentInstance => ", "Sys_Imp_Instance.sub|ComponentInstance => ",
				"Sys_Imp_Instance|SystemInstance => proc.fgPorts.inPort -> sub.iproc.fgPorts.inPort,"
						+ " sub.iproc.fgPorts.inPort -> proc.fgPorts.inPort"),
				InstanceReport.connectionOrderLines(snapshot));
	}
}
