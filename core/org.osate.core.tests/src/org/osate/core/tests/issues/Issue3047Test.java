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
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Regression test for issue #3047. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3047Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3047/Issue3047.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * A connection that starts or ends at an uncontinued boundary feature is materialized,
	 * but connection validation reports why that end stops there. A destination event port
	 * that triggers a mode transition is a deliberate terminal and is not reported.
	 */
	@Test
	public void uncontinuedBoundaryEndsAreReportedExceptForAModeTransitionTrigger() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var manager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		var instance = InstantiateModel.instantiate(findImplementation(pkg, "Top.impl"), manager);

		assertEquals(List.of(
				"Top_impl_Instance.data_producer.outp -> Top_impl_Instance.destination.inp",
				"Top_impl_Instance.event_producer.outp -> Top_impl_Instance.trigger_destination.trigger",
				"Top_impl_Instance.source_boundary.outp -> Top_impl_Instance.data_consumer.inp"),
				instance.getAllConnectionInstances().stream().map(Issue3047Test::describe).sorted().toList());

		assertEquals(List.of(
				"Warning|Top_impl_Instance.data_producer.outp -> Top_impl_Instance.destination.inp"
						+ "|Connection ends at destination because feature inp has no continuing connection declaration.",
				"Warning|Top_impl_Instance.source_boundary.outp -> Top_impl_Instance.data_consumer.inp"
						+ "|Connection starts at source_boundary because feature outp has no continuing connection declaration."),
				warnings(instance, manager));
	}

	private static List<String> warnings(SystemInstance instance, AnalysisErrorReporterManager manager) {
		return ((QueuingAnalysisErrorReporter) manager.getReporter(instance.eResource())).getErrors()
				.stream()
				.map(message -> message.kind + "|" + describe((ConnectionInstance) message.where) + "|" + message.message)
				.sorted()
				.toList();
	}

	private static String describe(ConnectionInstance connection) {
		return connection.getSource().getInstanceObjectPath() + " -> "
				+ connection.getDestination().getInstanceObjectPath();
	}

	private static ComponentImplementation findImplementation(AadlPackage pkg, String name) {
		return (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals(name))
				.findFirst()
				.orElseThrow();
	}
}
