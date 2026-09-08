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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ConnectionInstance;
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
public class Issue582AbstractDirectionTest extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue582/";

	private static final String MODEL = "TestAbstractDirection.aadl";

	private static final String BAD_DIRECTION = "Source must be outgoing and destination incoming.";

	private static final String SRC_TO_DEST_F0 = "srcSys.f0 -> destSys.f0";

	private static final String NO_VALID_DIRECTION = "Connection has no valid direction";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private AnalysisErrorReporterManager errorManager;

	@Test
	public void testDeclarative() throws Exception {
		FluentIssueCollection testFileResult = issues = testHelper.testFile(PROJECT_LOCATION + MODEL);
		FluentIssueCollection issueCollection = new FluentIssueCollection(testFileResult.getResource(),
				new ArrayList<>(), new ArrayList<>());

		AadlPackage pkg = (AadlPackage) testFileResult.getResource().getContents().get(0);
		SystemImplementation allExplicit = (SystemImplementation) pkg.getPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> "Top.allExplicit".equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		for (String name : List.of("out_to_out", "in_to_blank", "in_to_in", "in_to_out", "blank_to_out")) {
			var connection = allExplicit.getOwnedFeatureConnections()
					.stream()
					.filter(candidate -> name.equals(candidate.getName()))
					.findFirst()
					.orElse(null);
			AssertHelper.assertError(connection, testFileResult.getIssues(), issueCollection, BAD_DIRECTION);
		}

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	@Test
	public void testAllExplicit() throws Exception {
		SystemInstance instance = instantiate("Top.allExplicit");

		assertNotNull(connection(instance, "srcSys.blank_feature -> destSys.blank_feature"));
		assertNotNull(connection(instance, "srcSys.blank_feature -> destSys.in_feature"));
		assertNotNull(connection(instance, "srcSys.blank_feature -> destSys.out_feature"));
		assertNull(connection(instance, "srcSys.in_feature -> destSys.blank_feature"));
		assertNull(connection(instance, "srcSys.in_feature -> destSys.in_feature"));
		assertNull(connection(instance, "srcSys.in_feature -> destSys.out_feature"));
		assertNotNull(connection(instance, "srcSys.out_feature -> destSys.blank_feature"));
		assertNotNull(connection(instance, "srcSys.out_feature -> destSys.in_feature"));
		assertNotNull(connection(instance, "srcSys.out_feature -> destSys.out_feature"));

		assertEquals(
				List.of("srcSys.blank_feature -> destSys.out_feature: " + NO_VALID_DIRECTION,
						"srcSys.out_feature -> destSys.out_feature: " + NO_VALID_DIRECTION).stream().sorted().toList(),
				errors(instance).stream()
						.map(message -> ((ConnectionInstance) message.where).getName() + ": " + message.message)
						.sorted()
						.toList());
	}

	@Test
	public void testBlank_to_Blank() throws Exception {
		assertConnectedWithoutErrors("Top.blank_to_blank");
	}

	@Test
	public void testBlank_to_In() throws Exception {
		assertConnectedWithoutErrors("Top.blank_to_in");
	}

	@Test
	public void testBlank_to_Out() throws Exception {
		assertConnectedWithNoValidDirection("Top.blank_to_out");
	}

	@Test
	public void testIn_to_Blankk() throws Exception {
		assertNotConnectedWithoutErrors("Top.in_to_blank");
	}

	@Test
	public void testIn_to_In() throws Exception {
		assertNotConnectedWithoutErrors("Top.in_to_in");
	}

	@Test
	public void testIn_to_out() throws Exception {
		assertNotConnectedWithoutErrors("Top.in_to_out");
	}

	@Test
	public void testOut_to_Blank() throws Exception {
		assertConnectedWithoutErrors("Top.out_to_blank");
	}

	@Test
	public void testOut_to_In() throws Exception {
		assertConnectedWithoutErrors("Top.out_to_in");
	}

	@Test
	public void testOut_to_Out() throws Exception {
		assertConnectedWithNoValidDirection("Top.out_to_out");
	}

	private void assertConnectedWithoutErrors(String systemImplName) throws Exception {
		SystemInstance instance = instantiate(systemImplName);
		assertNotNull(connection(instance, SRC_TO_DEST_F0));
		assertTrue(errors(instance).size() == 0);
	}

	private void assertNotConnectedWithoutErrors(String systemImplName) throws Exception {
		SystemInstance instance = instantiate(systemImplName);
		assertNull(connection(instance, SRC_TO_DEST_F0));
		assertTrue(errors(instance).size() == 0);
	}

	private void assertConnectedWithNoValidDirection(String systemImplName) throws Exception {
		SystemInstance instance = instantiate(systemImplName);
		assertNotNull(connection(instance, SRC_TO_DEST_F0));
		List<Message> messages = errors(instance);
		assertTrue(messages.size() == 1);
		assertEquals(QueuingAnalysisErrorReporter.Kind.ERROR, messages.get(0).kind);
		assertEquals(NO_VALID_DIRECTION, messages.get(0).message);
		assertEquals(SRC_TO_DEST_F0, ((ConnectionInstance) messages.get(0).where).getName());
	}

	private SystemInstance instantiate(String systemImplName) throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT_LOCATION + MODEL);
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

	private static ConnectionInstance connection(SystemInstance instance, String name) {
		return instance.getConnectionInstances()
				.stream()
				.filter(candidate -> name.equals(candidate.getName()))
				.findFirst()
				.orElse(null);
	}
}
