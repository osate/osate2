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

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3027Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3027/Issue3027.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void connectionToInternalFeatureIsReportedNotDereferenced() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		/*
		 * The connection into the internal feature is rejected by the declarative validator since issue #3028. The
		 * instantiator must still handle it without dereferencing the missing destination feature instance.
		 */
		var validationIssues = validationHelper.validate(pkg);
		assertEquals(1, validationIssues.size());
		assertEquals("Internal feature 'raised_event' is allowed only at the source end of a connection.",
				validationIssues.get(0).getMessage());
		var top = (ComponentImplementation) pkg.getOwnedPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> classifier.getName().equals("Top.i"))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		var instance = InstantiateModel.instantiate(top, errorManager);

		assertNotNull(instance);
		assertEquals(List.of("Top_i_Instance.sensor.alarm|Top_i_Instance.monitor.incoming"),
				instance.getAllConnectionInstances()
						.stream()
						.map(connection -> connection.getSource().getInstanceObjectPath() + "|"
								+ connection.getDestination().getInstanceObjectPath())
						.toList());

		var messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors();
		assertEquals(1, messages.size());
		assertEquals(QueuingAnalysisErrorReporter.WARNING, messages.get(0).kind);
		assertEquals("Connection to Issue3027::Top.i.raised_event could not be instantiated.",
				messages.get(0).message);
	}
}
