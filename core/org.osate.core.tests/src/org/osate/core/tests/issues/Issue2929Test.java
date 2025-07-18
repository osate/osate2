/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
import java.util.Optional;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ListValue;
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
public class Issue2929Test extends XtextTest {

	private static final String PATH = "org.osate.core.tests/models/issue2929/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testInstantiation1() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PATH + "Issue2929.aadl");
		Optional<Classifier> impl = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("top.impl"))
				.findFirst();

		AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		SystemInstance instance = InstantiateModel.instantiate((ComponentImplementation) impl.get(), errorManager);
		Assert.assertEquals("top_impl_Instance", instance.getName());

		List<Message> messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource()))
				.getErrors();
		assertTrue(messages.isEmpty());
	}

	@Test
	public void testInstantiation2() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PATH + "Issue2929.aadl");
		Optional<Classifier> impl = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("top.refined_platform_error"))
				.findFirst();

		AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		SystemInstance instance = InstantiateModel.instantiate((ComponentImplementation) impl.get(), errorManager);
		Assert.assertEquals("top_refined_platform_error_Instance", instance.getName());
		var proc = instance.getComponentInstances()
				.stream()
				.filter(ci -> ci.getName().equals("proc"))
				.findFirst()
				.orElseThrow();
		var pas = proc.getOwnedPropertyAssociations();
		assertTrue(pas.size() == 1);

		List<Message> messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource()))
				.getErrors();
		assertTrue(messages.size() == 1);
		Message msg = messages.get(0);
		assertEquals(
				((ListValue) pas.get(0).getOwnedValues().get(0).getOwnedValue()).getOwnedListElements().get(0),
				msg.where);
		assertEquals(QueuingAnalysisErrorReporter.ERROR, msg.kind);
		assertEquals("Referenced element does not exist in the instance model", msg.message);
	}

	@Test
	public void testInstantiation3() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PATH + "Issue2929.aadl");
		Optional<Classifier> impl = pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("top.refined_platform_ok"))
				.findFirst();

		AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		SystemInstance instance = InstantiateModel.instantiate((ComponentImplementation) impl.get(), errorManager);
		Assert.assertEquals("top_refined_platform_ok_Instance", instance.getName());

		List<Message> messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource()))
				.getErrors();
		assertTrue(messages.isEmpty());
	}

}
