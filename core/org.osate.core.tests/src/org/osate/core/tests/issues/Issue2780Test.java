/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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

import static org.eclipse.xtext.xbase.lib.CollectionLiterals.newArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Message;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2780Test extends XtextTest {

	private static final String PATH = "org.osate.core.tests/models/issue2780/";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void test1() throws Exception {
		FluentIssueCollection testFileResult = issues = testHelper.testFile(PATH + "P.aadl");
		FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(), newArrayList(),
				newArrayList());

		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("P", pkg.getName());
		SystemImplementation s_i = (SystemImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("S1.i"))
				.findFirst()
				.get();
		List<EndToEndFlow> etes = s_i.getOwnedEndToEndFlows();
		EndToEndFlow ete = etes.get(0);
		assertEquals("e2e", ete.getName());
		AssertHelper.assertError(ete.getOwnedEndToEndFlowSegments().get(2), testFileResult.getIssues(), issueCollection,
				"Connection 'cl' continues inside subcomponent 'm'",
				"Connection 'cr' continues inside subcomponent 'm'");
		ete = etes.get(1);
		assertEquals("e2e1", ete.getName());
		AssertHelper.assertError(ete.getOwnedEndToEndFlowSegments().get(2), testFileResult.getIssues(), issueCollection,
				"Connection 'cl1' continues inside subcomponent 'm'",
				"Connection 'cr1' continues inside subcomponent 'm'");
		ete = etes.get(2);
		assertEquals("e2e2", ete.getName());
		AssertHelper.assertError(ete.getOwnedEndToEndFlowSegments().get(2), testFileResult.getIssues(), issueCollection,
				"Connection 'cl2' continues inside subcomponent 'm'",
				"Connection 'cr2' continues inside subcomponent 'm'");
		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);

		AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		SystemInstance instance = InstantiateModel.instantiate(s_i, errorManager);
		assertEquals("S1_i_Instance", instance.getName());
		assertEquals(6, instance.getEndToEndFlows().size());

		List<Message> messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource()))
				.getErrors();
		assertTrue(messages.size() == 4);
		Message msg = messages.get(0);
		assertEquals(QueuingAnalysisErrorReporter.WARNING, msg.kind);
		msg = messages.get(1);
		assertEquals(QueuingAnalysisErrorReporter.ERROR, msg.kind);
		assertEquals(
				"Invalid end-to-end flow instance e2e: Connection l.fl.fg.fi -> m.mm.fgl.fg.fi continues into component S1_i_Instance.m",
				msg.message);
		msg = messages.get(2);
		assertEquals(QueuingAnalysisErrorReporter.ERROR, msg.kind);
		assertEquals(
				"Invalid end-to-end flow instance e2e1: Connection l.fl.fg.fi -> m.mm.fgl.fg.fi continues into component S1_i_Instance.m",
				msg.message);
		msg = messages.get(3);
		assertEquals(QueuingAnalysisErrorReporter.ERROR, msg.kind);
		assertEquals(
				"Invalid end-to-end flow instance e2e2: Connection l.fl.fg.fi -> m.mm.fgl.fg.fi continues into component S1_i_Instance.m",
				msg.message);
	}

	@Test
	public void test2() throws Exception {
		FluentIssueCollection testFileResult = issues = testHelper.testFile(PATH + "Q.aadl");
		FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(), newArrayList(),
				newArrayList());

		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		assertEquals("Q", pkg.getName());
		SystemImplementation s_i = (SystemImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(c -> c.getName().equals("S1.i"))
				.findFirst()
				.get();
		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);

		AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		SystemInstance instance = InstantiateModel.instantiate(s_i, errorManager);
		assertEquals("S1_i_Instance", instance.getName());
		assertEquals(6, instance.getEndToEndFlows().size());

		List<Message> messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource()))
				.getErrors();
		assertTrue(messages.size() == 0);
	}

}
