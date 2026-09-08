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
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Message;
import org.osate.core.tests.instantiation.InstanceLookup;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2009Test extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue2009/";

	private static final String E2E_FPATH_I = "Cannot create end to end flow 'e2e' because there are no semantic connections that connect to the start of the flow 'fpath' at feature 'i'";

	private static final String ETEF1_WRONG_SNK_I = "Cannot create end to end flow 'etef1_wrong' because there are no semantic connections that connect to the start of the flow 'snk' at feature 'i'";

	private static final String ETEF1_WRONG_SNK_FG = "Cannot create end to end flow 'etef1_wrong' because there are no semantic connections that connect to the start of the flow 'snk' at feature 'fg'";

	private static final String ETEF1F_WRONG_SNKF_I = "Cannot create end to end flow 'etef1F_wrong' because there are no semantic connections that connect to the start of the flow 'snkF' at feature 'i'";

	private static final String ETEF1F_WRONG1_SNKF_I = "Cannot create end to end flow 'etef1F_wrong1' because there are no semantic connections that connect to the start of the flow 'snkF' at feature 'i'";

	private static final String ETEF1F_WRONG2_SNKF_I = "Cannot create end to end flow 'etef1F_wrong2' because there are no semantic connections that connect to the start of the flow 'snkF' at feature 'i'";

	private static final String ETEF1_WRONG2_SNK_FG = "Cannot create end to end flow 'etef1_wrong2' because there are no semantic connections that connect to the start of the flow 'snk' at feature 'fg'";

	private static final String ETEF1F_WRONG1_SNK2F_I = "Cannot create end to end flow 'etef1F_wrong1' because there are no semantic connections that connect to the start of the flow 'snk2F' at feature 'i'";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private AnalysisErrorReporterManager errorManager;

	@Test
	public void wasGood() throws Exception {
		SystemInstance instance = instantiate("WasGood.aadl", "top.specific");
		List<Message> messages = errors(instance);

		// There should be 1 error
		assertTrue(messages.size() == 1);
		assertError(messages.get(0), E2E_FPATH_I);

		// There should be no end to end flow instance
		assertEquals(0, instance.getEndToEndFlows().size());
	}

	@Test
	public void wasBad() throws Exception {
		SystemInstance instance = instantiate("WasBad.aadl", "top.specific");
		List<Message> messages = errors(instance);

		assertTrue(messages.size() == 1);
		assertError(messages.get(0), E2E_FPATH_I);

		assertEquals(0, instance.getEndToEndFlows().size());
	}

	@Test
	public void typeOnly() throws Exception {
		SystemInstance instance = instantiate("test.aadl", "top.typeOnly");
		List<Message> messages = errors(instance);

		assertTrue(messages.size() == 1);
		assertError(messages.get(0), ETEF1_WRONG_SNK_I);

		assertEquals(List.of("etef1"), InstanceLookup.flowNames(instance));
	}

	@Test
	public void withImpl_implFlow() throws Exception {
		SystemInstance instance = instantiate("test.aadl", "top.withImpl_implFlow");
		assertTrue(errors(instance).size() == 0);
		assertEquals(List.of("etef1"), InstanceLookup.flowNames(instance));
	}

	@Test
	public void withImpl_implNoFlow() throws Exception {
		SystemInstance instance = instantiate("test.aadl", "top.withImpl_implNoFlow");
		assertEquals(2, errors(instance).size());
		assertEquals(0, instance.getEndToEndFlows().size());
	}

	@Test
	public void fgTypeOnly() throws Exception {
		SystemInstance instance = instantiate("test_fg.aadl", "top.typeOnly");
		List<Message> messages = errors(instance);

		assertTrue(messages.size() == 2);
		assertError(messages.get(0), ETEF1F_WRONG_SNKF_I);
		assertError(messages.get(1), ETEF1_WRONG_SNK_FG);

		assertEquals(List.of("etef1", "etef1F"), InstanceLookup.flowNames(instance));
	}

	@Test
	public void fg2TypeOnly() throws Exception {
		SystemInstance instance = instantiate("test_fg2.aadl", "top.typeOnly");
		List<Message> messages = errors(instance);

		assertTrue(messages.size() == 3);
		assertError(messages.get(0), ETEF1F_WRONG1_SNKF_I);
		assertError(messages.get(1), ETEF1F_WRONG2_SNKF_I);
		assertError(messages.get(2), ETEF1_WRONG2_SNK_FG);

		assertEquals(List.of("etef1", "etef1F", "etef1_wrong1"), InstanceLookup.flowNames(instance));
	}

	@Test
	public void fgWithImpl_implFlow() throws Exception {
		SystemInstance instance = instantiate("test_fg.aadl", "top.withImpl_implFlow");
		assertTrue(errors(instance).size() == 0);
		assertEquals(List.of("etef1", "etef1F"), InstanceLookup.flowNames(instance));
	}

	@Test
	public void fg2WithImpl_implFlow() throws Exception {
		SystemInstance instance = instantiate("test_fg2.aadl", "top.withImpl_implFlow");
		List<Message> messages = errors(instance);

		assertTrue(messages.size() == 1);
		assertError(messages.get(0), ETEF1F_WRONG1_SNK2F_I);

		assertEquals(List.of("etef1", "etef1F", "etef1_wrong1"), InstanceLookup.flowNames(instance));
	}

	@Test
	public void fgWithImpl_implNoFlow() throws Exception {
		SystemInstance instance = instantiate("test_fg.aadl", "top.typeOnly");
		List<Message> messages = errors(instance);

		assertTrue(messages.size() == 2);
		assertError(messages.get(0), ETEF1F_WRONG_SNKF_I);
		assertError(messages.get(1), ETEF1_WRONG_SNK_FG);

		assertEquals(List.of("etef1", "etef1F"), InstanceLookup.flowNames(instance));
	}

	@Test
	public void fg2WithImpl_implNoFlow() throws Exception {
		SystemInstance instance = instantiate("test_fg2.aadl", "top.typeOnly");
		List<Message> messages = errors(instance);

		assertTrue(messages.size() == 3);
		assertError(messages.get(0), ETEF1F_WRONG1_SNKF_I);
		assertError(messages.get(1), ETEF1F_WRONG2_SNKF_I);
		assertError(messages.get(2), ETEF1_WRONG2_SNK_FG);

		assertEquals(List.of("etef1", "etef1F", "etef1_wrong1"), InstanceLookup.flowNames(instance));
	}

	private SystemInstance instantiate(String file, String implName) throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT_LOCATION + file);
		ComponentImplementation impl = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> implName.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		return InstantiateModel.instantiate(impl, errorManager);
	}

	private List<Message> errors(SystemInstance instance) {
		return ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors();
	}

	private static void assertError(Message message, String expectedMessage) {
		assertEquals(QueuingAnalysisErrorReporter.Kind.ERROR, message.kind);
		assertEquals(expectedMessage, message.message);
	}
}
