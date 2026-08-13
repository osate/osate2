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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Regression test for issue #3038.
 *
 * <p>
 * {@code Producer.i} declares a boundary feature group whose single member is
 * itself a feature group, and connects a subcomponent's feature group to that
 * nested member rather than to the boundary feature group. Instantiating it as the
 * top-level system used to throw {@code NullPointerException} from
 * {@code CreateConnectionsSwitch.balanceFeatureGroupEnds}, because the boundary
 * segment's source end is null and was dereferenced without a check.
 * </p>
 *
 * <p>
 * The assertion is deliberately independent of which repair is chosen. Either the
 * boundary connection is instantiated with both endpoints resolved, or a
 * diagnostic explains why it was not. What may never happen is an unhandled
 * exception, a connection instance with a null endpoint, or the connection being
 * dropped silently.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3038Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3038/Issue3038.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void nestedBoundaryFeatureGroupMemberDoesNotCrashInstantiation() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var producer = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Producer.i"))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		SystemInstance instance = InstantiateModel.instantiate(producer, errorManager);

		var connections = instance.getAllConnectionInstances();
		for (ConnectionInstance connection : connections) {
			assertNotNull("connection '" + connection.getName() + "' has no source", connection.getSource());
			assertNotNull("connection '" + connection.getName() + "' has no destination", connection.getDestination());
		}

		var messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors();
		assertTrue("the boundary connection must either be instantiated or be explained by a diagnostic",
				!connections.isEmpty() || !messages.isEmpty());

		/*
		 * The path crosses the system boundary in both directions, so both connections are
		 * incomplete and each traverses both declarations: up inside LeafSide.i and
		 * nested_up inside Producer.i.
		 *
		 * Only the outward connection was created when this test was first written. That
		 * was the defect reported as issue #3040: the traversal seeded at the contained
		 * boundary member was abandoned during feature group narrowing, so nesting a
		 * feature group silently changed which semantic connections existed. The guard
		 * added here for issue #3038 stopped the crash but kept the connection missing.
		 */
		assertEquals(List.of("Producer_i_Instance.boundary.inner.alpha -> Producer_i_Instance.leaf_side.leaf.io|2",
				"Producer_i_Instance.leaf_side.leaf.io -> Producer_i_Instance.boundary.inner.alpha|2"),
				connections.stream()
						.map(connection -> connection.getSource().getInstanceObjectPath() + " -> "
								+ connection.getDestination().getInstanceObjectPath() + "|"
								+ connection.getConnectionReferences().size())
						.sorted()
						.toList());
		assertFalse("both connections leave the system, so neither is complete",
				connections.stream().anyMatch(ConnectionInstance::isComplete));
		assertEquals(List.of(), messages);
	}
}
