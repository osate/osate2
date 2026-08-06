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
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Message;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2872Test extends XtextTest {
	private static final String FILE = "org.osate.core.tests/models/issue2872/Issue2872.aadl";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testMissingFlowImplementationIsReported() throws Exception {
		AadlPackage pkg = testHelper.parseFile(FILE);
		SystemImplementation integration = (SystemImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("integration.impl"))
				.findFirst()
				.orElseThrow();
		AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);

		SystemInstance instance = InstantiateModel.instantiate(integration, errorManager);

		assertTrue(instance.getEndToEndFlows().isEmpty());
		List<Message> messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource()))
				.getErrors()
				.stream()
				.filter(message -> message.message.startsWith("Cannot create end to end flow 'fab'"))
				.toList();
		assertEquals(1, messages.size());
		assertEquals(QueuingAnalysisErrorReporter.ERROR, messages.get(0).kind);
		assertEquals("Cannot create end to end flow 'fab' because component 'b' has subcomponents but no flow "
				+ "implementation for flow 'finny'", messages.get(0).message);
	}
}
