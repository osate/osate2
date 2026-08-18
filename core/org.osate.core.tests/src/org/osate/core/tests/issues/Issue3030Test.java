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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3030Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3030/Issue3030.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * The destination subcomponent of the connection is an array with no elements, so it has no component
	 * instance. Instantiation must report the missing subcomponent instance instead of dereferencing it.
	 */
	@Test
	public void missingSubcomponentInstanceIsReportedNotDereferenced() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var top = (ComponentImplementation) pkg.getOwnedPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> classifier.getName().equals("Top.i"))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		var instance = InstantiateModel.instantiate(top, errorManager);

		assertNotNull(instance);
		assertEquals(1, instance.getComponentInstances().size());
		assertEquals("sensor", instance.getComponentInstances().get(0).getName());
		assertTrue(instance.getAllConnectionInstances().isEmpty());

		var messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors();
		assertEquals(1, messages.size());
		assertEquals(QueuingAnalysisErrorReporter.ERROR, messages.get(0).kind);
		/*
		 * Allowlist entry 7 of issue #3037: the same fact, on the same target, reported by the resolver
		 * that establishes it rather than prefixed with "Instantiation error:".
		 */
		assertEquals("No component instance for subcomponent monitors", messages.get(0).message);
	}
}
