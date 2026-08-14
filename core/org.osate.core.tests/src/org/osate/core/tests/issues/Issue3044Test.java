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
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * A port that shares a feature group with a connected access feature must still get its
 * own connection instance.
 *
 * <p>
 * {@code ServiceGroup} carries an access feature and an out data port, and connects two
 * threads. The access feature continues inside the requester thread, into its subprogram;
 * the port continues nowhere, so the connection between the two ports is maximal and
 * complete. Both connections belong in the instance model.
 * </p>
 *
 * <p>
 * The traversal decides whether to create a connection instance that stops at the
 * destination thread by looking at that thread's internal connections as a whole. An
 * access connection is never ignored, so nothing records that the port member had no
 * continuation, no path stops at the feature group, and the port connection is silently
 * absent. Nothing is reported and the declarative model is valid, so any analysis over
 * port connections simply sees no flow between the two ports.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3044Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3044/Issue3044.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void aPortBesideAConnectedAccessFeatureIsStillInstantiated() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var instance = InstantiateModel.instantiate(findImplementation(pkg, "DemoTop.impl"));

		assertEquals(List.of(
				"DemoTop_impl_Instance.provider_side.service_bundle.signal_line"
						+ " -> DemoTop_impl_Instance.requester_side.service_bundle.signal_line",
				"DemoTop_impl_Instance.provider_side.worker_unit"
						+ " -> DemoTop_impl_Instance.requester_side.worker_unit.requested_call"),
				instance.getAllConnectionInstances().stream().map(Issue3044Test::describe).sorted().toList());
	}

	private static ComponentImplementation findImplementation(AadlPackage pkg, String name) {
		return (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals(name))
				.findFirst()
				.orElseThrow();
	}

	private static String describe(ConnectionInstance connection) {
		return connection.getSource().getInstanceObjectPath() + " -> "
				+ connection.getDestination().getInstanceObjectPath();
	}
}
