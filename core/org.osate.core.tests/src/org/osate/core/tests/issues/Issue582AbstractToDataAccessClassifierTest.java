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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.Classifier;
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
public class Issue582AbstractToDataAccessClassifierTest extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue582/";
	private static final String MODEL = PROJECT_LOCATION + "TestAbstractToDataAccessClassifier.aadl";
	private static final String CONNECTION = "srcSys.f0 -> destSys.f0";
	private static final String NO_VALID_DIRECTION = "Connection has no valid direction";
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
		var implementation = (SystemImplementation) classifier(pkg, "Top.allExplicit");

		for (var name : List.of("c11", "c12", "c21", "c22")) {
			assertError(accessConnection(implementation, name), BOTH_PROVIDES);
		}
		for (var name : List.of("c33", "c34", "c43", "c44")) {
			assertError(accessConnection(implementation, name), BOTH_REQUIRES);
		}

		assertWarning(accessConnection(implementation, "c23").getSource(), classifierWarning("p_notype"));
		assertWarning(accessConnection(implementation, "c32").getDestination(), classifierWarning("p_notype"));

		assertWarning(accessConnection(implementation, "c14").getDestination(), classifierWarning("r_notype"));
		assertWarning(accessConnection(implementation, "c41").getSource(), classifierWarning("r_notype"));

		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	@Test
	public void testAllExplicit() throws Exception {
		var result = instantiate("Top.allExplicit");

		for (var name : List.of("srcSys.p_type -> destSys.p_type", "srcSys.p_type -> destSys.p_notype",
				"srcSys.p_type -> destSys.r_type", "srcSys.p_type -> destSys.r_notype",
				"srcSys.p_notype -> destSys.p_type", "srcSys.p_notype -> destSys.p_notype",
				"srcSys.p_notype -> destSys.r_type", "srcSys.p_notype -> destSys.r_notype",
				"srcSys.r_notype -> destSys.p_type", "srcSys.r_type -> destSys.p_notype",
				"srcSys.r_type -> destSys.r_type", "srcSys.r_type -> destSys.r_notype",
				"srcSys.r_notype -> destSys.p_type", "srcSys.r_notype -> destSys.p_notype",
				"srcSys.r_notype -> destSys.r_type", "srcSys.r_notype -> destSys.r_notype")) {
			assertNotNull(name, connectionInstance(result.instance(), name));
		}

		var messages = result.messages();
		assertEquals(16, messages.size());
		assertEquals(
				List.of("srcSys.p_notype -> destSys.p_notype", "srcSys.p_notype -> destSys.p_type",
						"srcSys.p_type -> destSys.p_notype", "srcSys.p_type -> destSys.p_type",
						"srcSys.r_notype -> destSys.r_notype", "srcSys.r_notype -> destSys.r_type",
						"srcSys.r_type -> destSys.r_notype", "srcSys.r_type -> destSys.r_type"),
				messages.stream()
						.filter(message -> NO_VALID_DIRECTION.equals(message.message))
						.map(message -> ((ConnectionInstance) message.where).getName())
						.sorted()
						.toList());

		assertClassifierWarningOn(result, "srcSys.p_type -> destSys.r_notype", "destSys.r_notype");
		assertClassifierWarningOn(result, "srcSys.r_type -> destSys.p_notype", "destSys.p_notype");
		assertClassifierWarningOn(result, "srcSys.p_notype -> destSys.r_type", "srcSys.p_notype");
		assertClassifierWarningOn(result, "srcSys.r_notype -> destSys.p_type", "srcSys.r_notype");
	}

	@Test
	public void test_notype_to_notype() throws Exception {
		assertNoMessages("Top.notype_to_notype");
	}

	@Test
	public void test_provides_nt_to_provides_nt() throws Exception {
		assertNoValidDirection("Top.provides_nt_to_provides_nt", 1);
	}

	@Test
	public void test_provides_nt_to_provides_t() throws Exception {
		assertNoValidDirection("Top.provides_nt_to_provides_t", 2);
	}

	@Test
	public void test_provides_nt_to_requires_nt() throws Exception {
		assertNoMessages("Top.provides_nt_to_requires_nt");
	}

	@Test
	public void test_provides_nt_to_requires_t() throws Exception {
		assertClassifierWarning("Top.provides_nt_to_requires_t", "srcSys.f0");
	}

	@Test
	public void test_provides_t_to_provides_nt() throws Exception {
		assertNoValidDirection("Top.provides_t_to_provides_nt", 2);
	}

	@Test
	public void test_provides_t_to_provides_t() throws Exception {
		assertNoValidDirection("Top.provides_t_to_provides_t", 1);
	}

	@Test
	public void test_provides_t_to_requires_nt() throws Exception {
		assertClassifierWarning("Top.provides_t_to_requires_nt", "destSys.f0");
	}

	@Test
	public void test_provides_t_to_requires_t() throws Exception {
		assertNoMessages("Top.provides_t_to_requires_t");
	}

	@Test
	public void test_requires_nt_to_provides_nt() throws Exception {
		assertNoMessages("Top.requires_nt_to_provides_nt");
	}

	@Test
	public void test_requires_nt_to_provides_t() throws Exception {
		assertClassifierWarning("Top.requires_nt_to_provides_t", "srcSys.f0");
	}

	@Test
	public void test_requires_nt_to_requires_nt() throws Exception {
		assertNoValidDirection("Top.requires_nt_to_requires_nt", 1);
	}

	@Test
	public void test_requires_nt_to_requires_t() throws Exception {
		assertNoValidDirection("Top.requires_nt_to_requires_t", 2);
	}

	@Test
	public void test_requires_t_to_provides_nt() throws Exception {
		assertClassifierWarning("Top.requires_t_to_provides_nt", "destSys.f0");
	}

	@Test
	public void test_requires_t_to_provides_t() throws Exception {
		assertNoMessages("Top.requires_t_to_provides_t");
	}

	@Test
	public void test_requires_t_to_requires_nt() throws Exception {
		assertNoValidDirection("Top.requires_t_to_requires_nt", 2);
	}

	@Test
	public void test_requires_t_to_requires_t() throws Exception {
		assertNoValidDirection("Top.requires_t_to_requires_t", 1);
	}

	/** The instantiated system implementation and the messages reported while instantiating it. */
	private record Instantiation(ComponentInstance instance, List<Message> messages) {
	}

	private Instantiation instantiate(String implementationName) throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		var implementation = (SystemImplementation) classifier(pkg, implementationName);
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		var instance = InstantiateModel.instantiate(implementation, errorManager);
		var reporter = (QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource());
		return new Instantiation(instance, reporter.getErrors());
	}

	private void assertNoMessages(String implementationName) throws Exception {
		var result = instantiate(implementationName);
		assertNotNull(connectionInstance(result.instance(), CONNECTION));
		assertEquals(0, result.messages().size());
	}

	private void assertNoValidDirection(String implementationName, int expectedMessageCount) throws Exception {
		var result = instantiate(implementationName);
		assertNotNull(connectionInstance(result.instance(), CONNECTION));
		assertEquals(expectedMessageCount, result.messages().size());
		assertTrue(NO_VALID_DIRECTION,
				result.messages()
						.stream()
						.anyMatch(message -> message.kind == Kind.ERROR && NO_VALID_DIRECTION.equals(message.message)
								&& message.where instanceof ConnectionInstance connection
								&& CONNECTION.equals(connection.getName())));
	}

	private void assertClassifierWarning(String implementationName, String feature) throws Exception {
		var result = instantiate(implementationName);
		assertNotNull(connectionInstance(result.instance(), CONNECTION));
		assertEquals(1, result.messages().size());
		var message = result.messages().getFirst();
		assertEquals(Kind.WARNING, message.kind);
		assertEquals(classifierWarning(feature), message.message);
	}

	private static void assertClassifierWarningOn(Instantiation result, String connectionName, String feature) {
		var connection = connectionInstance(result.instance(), connectionName);
		assertTrue(classifierWarning(feature),
				result.messages()
						.stream()
						.anyMatch(message -> message.where == connection && message.kind == Kind.WARNING
								&& classifierWarning(feature).equals(message.message)));
	}

	private static String classifierWarning(String feature) {
		return "Expected feature '" + feature + "' to have classifier 'TestAbstractToDataAccessClassifier::D'";
	}

	private static ConnectionInstance connectionInstance(ComponentInstance instance, String name) {
		return instance.getConnectionInstances()
				.stream()
				.filter(connection -> name.equals(connection.getName()))
				.findFirst()
				.orElse(null);
	}

	private static Classifier classifier(AadlPackage pkg, String name) {
		return pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> name.equals(classifier.getName()))
				.findFirst()
				.orElseThrow();
	}

	private static AccessConnection accessConnection(SystemImplementation implementation, String name) {
		return implementation.getOwnedAccessConnections()
				.stream()
				.filter(connection -> name.equals(connection.getName()))
				.findFirst()
				.orElseThrow();
	}

	private void assertError(EObject object, String message) {
		AssertHelper.assertError(object, testFileResult.getIssues(), issueCollection, message);
	}

	private void assertWarning(EObject object, String message) {
		AssertHelper.assertWarning(object, testFileResult.getIssues(), issueCollection, message);
	}
}
