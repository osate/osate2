/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, MERCHANTABILITY, EXCLUSIVITY,
 * RESULTS OBTAINED FROM USE OF THE MATERIAL, OR FITNESS FOR A PARTICULAR PURPOSE.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
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
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes the symmetric treatment chosen for issue #3050. An upward declaration from a
 * subcomponent to its unconnected boundary and a downward declaration from an unconnected boundary
 * to a subcomponent are both only path fragments: neither has an across segment or a root-boundary
 * seed, so neither forms a semantic connection. Neither declaration is materialized or reported. A
 * second upward declaration with an across continuation is the positive control.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3050Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3050/Issue3050.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void seedlessUpwardAndDownwardDeclarationsRemainSilent() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var top = (ComponentImplementation) pkg.getOwnedPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> classifier.getName().equals("Top.impl"))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		var instance = InstantiateModel.instantiate(top, errorManager);
		assertEquals(List.of("Top_impl_Instance.continued.producer.outp|Top_impl_Instance.consumer.inp|2"),
				instance.getAllConnectionInstances()
						.stream()
						.map(connection -> connection.getSource().getInstanceObjectPath() + "|"
								+ connection.getDestination().getInstanceObjectPath() + "|"
								+ connection.getConnectionReferences().size())
						.toList());

		var reporter = (QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource());
		assertEquals(List.of(), reporter.getErrors());
	}
}
