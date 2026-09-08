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
import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
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
import org.osate.core.tests.instantiation.InstanceLookup;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2356InstanceTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue2356/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private AnalysisErrorReporterManager errorManager;

	@Test
	public void noModes_good() throws Exception {
		SystemInstance instance = instantiate("P2.aadl", "S.no_modes_good");
		assertEquals(0, errors(instance).size());
	}

	@Test
	public void noModes_bad() throws Exception {
		SystemInstance instance = instantiate("P2.aadl", "S.no_modes_bad");
		List<Message> messages = errors(instance);
		assertEquals(3, messages.size());

		assertMessageFor(messages, instance.getComponentInstances().get(2).getFeatureInstances().get(0),
				"More than one connection instance ends at data port");

		// Both connection instances are reported, whichever order they were created in
		assertEquals(2, instance.getConnectionInstances().size());
		instance.getConnectionInstances()
				.forEach(conni -> assertMessageFor(messages, conni,
						"More than one connection instance ends at data port S_no_modes_bad_Instance.b.bin"));
	}

	@Test
	public void simple_modes_bad() throws Exception {
		SystemInstance instance = instantiate("P2.aadl", "SS.simple_modes_bad");
		assertEquals(3, instance.getSystemOperationModes().size());

		List<Message> messages = errors(instance);
		assertEquals(3, messages.size());

		assertMessageFor(messages, instance.getComponentInstances().get(2).getFeatureInstances().get(0),
				"More than one connection instance ends at data port in system operation mode som_2");

		// Both connection instances are reported, whichever order they were created in
		assertEquals(2, instance.getConnectionInstances().size());
		instance.getConnectionInstances()
				.forEach(conni -> assertMessageFor(messages, conni,
						"More than one connection instance ends at data port SS_simple_modes_bad_Instance.b.bin"
								+ " in system operation mode som_2"));
	}

	@Test
	public void modal_subcomponent_bad() throws Exception {
		SystemInstance instance = instantiate("P3.aadl", "S.i");
		assertEquals(3, instance.getSystemOperationModes().size());

		List<Message> messages = errors(instance);
		assertEquals(3, messages.size());

		assertMessageFor(messages, instance.getComponentInstances().get(0).getFeatureInstances().get(0),
				"More than one connection instance ends at data port in system operation mode som_2");

		// Both connection instances are reported, whichever order they were created in
		assertEquals(2, instance.getConnectionInstances().size());
		instance.getConnectionInstances()
				.forEach(conni -> assertMessageFor(messages, conni,
						"More than one connection instance ends at data port S_i_Instance.b.bin in system operation"
								+ " mode som_2"));
	}

	@Test
	public void connections_in_different_components_bad() throws Exception {
		SystemInstance instance = instantiate("P4.aadl", "S.i");
		List<Message> messages = errors(instance);
		assertEquals(3, messages.size());

		assertMessageFor(messages,
				instance.getComponentInstances().get(1).getComponentInstances().get(1).getFeatureInstances().get(0),
				"More than one connection instance ends at data port");
		assertMessageFor(messages, InstanceLookup.onlyConnection(instance),
				"More than one connection instance ends at data port S_i_Instance.m.b.bin");
		assertMessageFor(messages, InstanceLookup.onlyConnection(instance.getComponentInstances().get(1)),
				"More than one connection instance ends at data port S_i_Instance.m.b.bin");
	}

	private SystemInstance instantiate(String file, String systemImplName) throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT_LOCATION + file);
		SystemImplementation sysImpl = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> systemImplName.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		return InstantiateModel.instantiate(sysImpl, errorManager);
	}

	private List<Message> errors(SystemInstance instance) {
		return ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors();
	}

	private static void assertMessageFor(List<Message> messages, EObject where, String expectedMessage) {
		Message message = messages.stream()
				.filter(candidate -> Objects.equals(candidate.where, where))
				.findFirst()
				.orElse(null);
		assertEquals(QueuingAnalysisErrorReporter.Kind.ERROR, message.kind);
		assertEquals(expectedMessage, message.message);
	}
}
