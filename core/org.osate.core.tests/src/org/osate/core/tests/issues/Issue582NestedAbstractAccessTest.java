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
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Kind;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Message;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue582NestedAbstractAccessTest extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue582/";
	private static final String MODEL = PROJECT_LOCATION + "TestNestedAbstractAccess.aadl";
	private static final String CONNECTION = "srcSys.s.f0 -> destSys.f0";
	private static final String NO_VALID_DIRECTION = "Connection has no valid direction";
	private static final String MAPPING_UP_OR_DOWN = "Source and destination must both be provides or requires for a connection mapping features up or down the containment hierarchy.";
	private static final String BOTH_PROVIDES = "Source and destination of access connections between sibling components cannot both be 'provides'.";
	private static final String BOTH_REQUIRES = "Source and destination of access connections between sibling components cannot both be 'requires'.";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void testDeclarative() throws Exception {
		testFileResult = issues = testHelper.testFile(MODEL);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(), new ArrayList<>());

		var pkg = (AadlPackage) testFileResult.getResource().getContents().getFirst();

		var srcSys = implementation(pkg, "SrcSys.allExplicit");
		assertSourceWarning(srcSys, "blank_to_provides", "blank_feature");
		assertSourceWarning(srcSys, "blank_to_requires", "blank_feature");
		assertDestinationWarning(srcSys, "provides_to_blank", "provides_to_blank_feature");
		assertAccessConnectionError(srcSys, "provides_to_requires", MAPPING_UP_OR_DOWN);
		assertDestinationWarning(srcSys, "requires_to_blank", "requires_to_blank_feature");
		assertAccessConnectionError(srcSys, "requires_to_provides", MAPPING_UP_OR_DOWN);

		var top = implementation(pkg, "Top.allExplicit");
		assertSourceWarning(top, "blank_to_blank_to_provides", "blank_to_blank_feature");
		assertSourceWarning(top, "blank_to_blank_to_requires", "blank_to_blank_feature");
		assertDestinationWarning(top, "blank_to_provides_to_blank", "blank_feature");
		assertAccessConnectionError(top, "blank_to_provides_to_provides", BOTH_PROVIDES);
		assertDestinationWarning(top, "blank_to_requires_to_blank", "blank_feature");
		assertAccessConnectionError(top, "blank_to_requires_to_requires", BOTH_REQUIRES);
		assertSourceWarning(top, "provides_to_blank_to_provides", "provides_to_blank_feature");
		assertSourceWarning(top, "provides_to_blank_to_requires", "provides_to_blank_feature");
		assertDestinationWarning(top, "provides_to_provides_to_blank", "blank_feature");
		assertAccessConnectionError(top, "provides_to_provides_to_provides", BOTH_PROVIDES);
		assertDestinationWarning(top, "provides_to_requires_to_blank", "blank_feature");
		assertAccessConnectionError(top, "provides_to_requires_to_requires", BOTH_REQUIRES);
		assertSourceWarning(top, "requires_to_blank_to_provides", "requires_to_blank_feature");
		assertSourceWarning(top, "requires_to_blank_to_requires", "requires_to_blank_feature");
		assertDestinationWarning(top, "requires_to_provides_to_blank", "blank_feature");
		assertAccessConnectionError(top, "requires_to_provides_to_provides", BOTH_PROVIDES);
		assertDestinationWarning(top, "requires_to_requires_to_blank", "blank_feature");
		assertAccessConnectionError(top, "requires_to_requires_to_requires", BOTH_REQUIRES);

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	@Test
	public void testAllExplicit() throws Exception {
		var result = instantiate("Top.allExplicit");

		assertEquals(10, result.messages().size());
		assertEquals(
				List.of("srcSys.s.blank_feature -> destSys.provides_feature",
						"srcSys.s.blank_feature -> destSys.requires_feature",
						"srcSys.s.provides_feature -> destSys.blank_feature",
						"srcSys.s.provides_feature -> destSys.provides_feature",
						"srcSys.s.provides_feature -> destSys.provides_feature",
						"srcSys.s.provides_feature -> destSys.requires_feature",
						"srcSys.s.requires_feature -> destSys.blank_feature",
						"srcSys.s.requires_feature -> destSys.provides_feature",
						"srcSys.s.requires_feature -> destSys.requires_feature",
						"srcSys.s.requires_feature -> destSys.requires_feature"),
				result.messages()
						.stream()
						.filter(message -> NO_VALID_DIRECTION.equals(message.message))
						.map(message -> ((ConnectionInstance) message.where).getName())
						.sorted()
						.toList());

		assertEquals(27, result.instance().getConnectionInstances().size());
	}

	@Test
	public void test_blank_to_blank_to_blank() throws Exception {
		assertValidConnection("Top.blank_to_blank_to_blank");
	}

	@Test
	public void test_blank_to_blank_to_provides() throws Exception {
		assertValidConnection("Top.blank_to_blank_to_provides");
	}

	@Test
	public void test_blank_to_blank_to_requires() throws Exception {
		assertValidConnection("Top.blank_to_blank_to_requires");
	}

	@Test
	public void test_blank_to_provides_to_blank() throws Exception {
		assertValidConnection("Top.blank_to_provides_to_blank");
	}

	@Test
	public void test_blank_to_provides_to_provides() throws Exception {
		assertInvalidDirection("Top.blank_to_provides_to_provides");
	}

	@Test
	public void test_blank_to_provides_to_requires() throws Exception {
		assertValidConnection("Top.blank_to_provides_to_requires");
	}

	@Test
	public void test_blank_to_requires_to_blank() throws Exception {
		assertValidConnection("Top.blank_to_requires_to_blank");
	}

	@Test
	public void test_blank_to_requires_to_provides() throws Exception {
		assertValidConnection("Top.blank_to_requires_to_provides");
	}

	@Test
	public void test_blank_to_requires_to_requires() throws Exception {
		assertInvalidDirection("Top.blank_to_requires_to_requires");
	}

	@Test
	public void test_provides_to_blank_to_blank() throws Exception {
		assertValidConnection("Top.provides_to_blank_to_blank");
	}

	@Test
	public void test_provides_to_blank_to_provides() throws Exception {
		assertValidConnection("Top.provides_to_blank_to_provides");
	}

	@Test
	public void test_provides_to_blank_to_requires() throws Exception {
		assertValidConnection("Top.provides_to_blank_to_requires");
	}

	@Test
	public void test_provides_to_provides_to_blank() throws Exception {
		assertValidConnection("Top.provides_to_provides_to_blank");
	}

	@Test
	public void test_provides_to_provides_to_provides() throws Exception {
		assertInvalidDirection("Top.provides_to_provides_to_provides");
	}

	@Test
	public void test_provides_to_provides_to_requires() throws Exception {
		assertValidConnection("Top.provides_to_provides_to_requires");
	}

	@Test
	public void test_provides_to_requires_to_blank() throws Exception {
		assertInvalidDirection("Top.provides_to_requires_to_blank");
	}

	@Test
	public void test_provides_to_requires_to_provides() throws Exception {
		assertInvalidDirection("Top.provides_to_requires_to_provides");
	}

	@Test
	public void test_provides_to_requires_to_requires() throws Exception {
		assertInvalidDirection("Top.provides_to_requires_to_requires");
	}

	@Test
	public void test_requires_to_blank_to_blank() throws Exception {
		assertValidConnection("Top.requires_to_blank_to_blank");
	}

	@Test
	public void test_requires_to_blank_to_provides() throws Exception {
		assertValidConnection("Top.requires_to_blank_to_provides");
	}

	@Test
	public void test_requires_to_blank_to_requires() throws Exception {
		assertValidConnection("Top.requires_to_blank_to_requires");
	}

	@Test
	public void test_requires_to_provides_to_blank() throws Exception {
		assertInvalidDirection("Top.requires_to_provides_to_blank");
	}

	@Test
	public void test_requires_to_provides_to_provides() throws Exception {
		assertInvalidDirection("Top.requires_to_provides_to_provides");
	}

	@Test
	public void test_requires_to_provides_to_requires() throws Exception {
		assertInvalidDirection("Top.requires_to_provides_to_requires");
	}

	@Test
	public void test_requires_to_requires_to_blank() throws Exception {
		assertValidConnection("Top.requires_to_requires_to_blank");
	}

	@Test
	public void test_requires_to_requires_to_provides() throws Exception {
		assertValidConnection("Top.requires_to_requires_to_provides");
	}

	@Test
	public void test_requires_to_requires_to_requires() throws Exception {
		assertInvalidDirection("Top.requires_to_requires_to_requires");
	}

	/** The instantiated system implementation and the messages reported while instantiating it. */
	private record Instantiation(ComponentInstance instance, List<Message> messages) {
	}

	private Instantiation instantiate(String implementationName) throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		var instance = InstantiateModel.instantiate(implementation(pkg, implementationName), errorManager);
		var reporter = (QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource());
		return new Instantiation(instance, reporter.getErrors());
	}

	/** The connection is instantiated and the instantiation reports nothing. */
	private void assertValidConnection(String implementationName) throws Exception {
		var result = instantiate(implementationName);
		assertNotNull(connectionInstance(result.instance()));
		assertTrue(result.messages().isEmpty());
	}

	/** The connection is instantiated, but the instantiation reports that it has no valid direction. */
	private void assertInvalidDirection(String implementationName) throws Exception {
		var result = instantiate(implementationName);
		assertNotNull(connectionInstance(result.instance()));
		assertEquals(1, result.messages().size());
		var message = result.messages().getFirst();
		assertEquals(Kind.ERROR, message.kind);
		assertEquals(NO_VALID_DIRECTION, message.message);
		assertEquals(CONNECTION, ((ConnectionInstance) message.where).getName());
	}

	private static ConnectionInstance connectionInstance(ComponentInstance instance) {
		return instance.getConnectionInstances()
				.stream()
				.filter(connection -> CONNECTION.equals(connection.getName()))
				.findFirst()
				.orElse(null);
	}

	private static SystemImplementation implementation(AadlPackage pkg, String name) {
		return (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> name.equals(classifier.getName()))
				.findFirst()
				.orElseThrow();
	}

	private void assertSourceWarning(SystemImplementation implementation, String connectionName, String feature) {
		var connection = implementation.getOwnedFeatureConnections()
				.stream()
				.filter(featureConnection -> connectionName.equals(featureConnection.getName()))
				.findFirst()
				.orElseThrow();
		AssertHelper.assertWarning(connection.getSource(), testFileResult.getIssues(), issueCollection,
				classifierWarning(feature));
	}

	private void assertDestinationWarning(SystemImplementation implementation, String connectionName, String feature) {
		var connection = implementation.getOwnedFeatureConnections()
				.stream()
				.filter(featureConnection -> connectionName.equals(featureConnection.getName()))
				.findFirst()
				.orElseThrow();
		AssertHelper.assertWarning(connection.getDestination(), testFileResult.getIssues(), issueCollection,
				classifierWarning(feature));
	}

	private void assertAccessConnectionError(SystemImplementation implementation, String connectionName,
			String message) {
		var connection = implementation.getOwnedAccessConnections()
				.stream()
				.filter(accessConnection -> connectionName.equals(accessConnection.getName()))
				.findFirst()
				.orElseThrow();
		AssertHelper.assertError(connection, testFileResult.getIssues(), issueCollection, message);
	}

	private static String classifierWarning(String feature) {
		return "Expected feature '" + feature + "' to have classifier 'TestNestedAbstractAccess::D'";
	}
}
