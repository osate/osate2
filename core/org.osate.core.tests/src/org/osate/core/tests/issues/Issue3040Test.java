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
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Regression test for issue #3040.
 *
 * <p>
 * Nesting a feature group must not change which semantic connections exist, only how
 * deep their endpoints sit. {@code Flat.i} and {@code Nested.i} differ only in that
 * respect, so both must produce the same two connections, one level apart.
 * </p>
 *
 * <p>
 * {@code Nested.i} used to produce only the outward connection. The traversal seeded
 * at the contained boundary member was abandoned during feature group narrowing,
 * because the level stack counts from the outermost boundary feature and its leading
 * entry names the level the seed already stands at. Before issue #3038 that
 * dereferenced null and crashed; that issue stopped the crash, and this one restores
 * the connection.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3040Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3040/Issue3040.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void aFlatBoundaryFeatureGroupConnectsBothWays() throws Exception {
		assertEquals(List.of("Flat_i_Instance.boundary.alpha -> Flat_i_Instance.leaf_side.leaf.io",
				"Flat_i_Instance.leaf_side.leaf.io -> Flat_i_Instance.boundary.alpha"), connections("Flat.i"));
	}

	@Test
	public void aNestedBoundaryFeatureGroupConnectsBothWays() throws Exception {
		assertEquals(List.of("Nested_i_Instance.boundary.inner.alpha -> Nested_i_Instance.leaf_side.leaf.io",
				"Nested_i_Instance.leaf_side.leaf.io -> Nested_i_Instance.boundary.inner.alpha"),
				connections("Nested.i"));
	}

	/** The connections of one implementation, sorted, with no diagnostics reported. */
	private List<String> connections(String implementationName) throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var implementation = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals(implementationName))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		SystemInstance instance = InstantiateModel.instantiate(implementation, errorManager);

		assertEquals(List.of(),
				((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors()
						.stream()
						.map(message -> message.kind + ": " + message.message)
						.toList());
		return instance.getAllConnectionInstances()
				.stream()
				.map(connection -> connection.getSource().getInstanceObjectPath() + " -> "
						+ connection.getDestination().getInstanceObjectPath())
				.sorted()
				.toList();
	}
}
