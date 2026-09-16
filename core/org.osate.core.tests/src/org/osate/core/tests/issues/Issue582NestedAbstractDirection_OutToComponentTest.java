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
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue582NestedAbstractDirection_OutToComponentTest extends XtextTest {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue582/";
	private static final String MODEL = PROJECT_LOCATION + "TestNestedAbstractDirection_OutOfComponent.aadl";
	private static final String CONNECTION = "srcSys.s.f0 -> destSys.f0";
	private static final String NO_VALID_DIRECTION = "Connection has no valid direction";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testAllExplicit() throws Exception {
		var result = instantiate("Top.allExplicit");

		assertEquals(10, result.messages().size());
		assertEquals(
				List.of("srcSys.s.blank_feature -> destSys.blank_feature",
						"srcSys.s.blank_feature -> destSys.in_feature",
						"srcSys.s.blank_feature -> destSys.out_feature",
						"srcSys.s.blank_feature -> destSys.out_feature",
						"srcSys.s.blank_feature -> destSys.out_feature",
						"srcSys.s.out_feature -> destSys.blank_feature",
						"srcSys.s.out_feature -> destSys.in_feature",
						"srcSys.s.out_feature -> destSys.out_feature",
						"srcSys.s.out_feature -> destSys.out_feature",
						"srcSys.s.out_feature -> destSys.out_feature"),
				result.messages()
						.stream()
						.filter(message -> NO_VALID_DIRECTION.equals(message.message))
						.map(message -> ((ConnectionInstance) message.where).getName())
						.sorted()
						.toList());

		assertEquals(18, result.instance().getConnectionInstances().size());
	}

	@Test
	public void test_blank_to_blank_to_blank() throws Exception {
		assertValidConnection("Top.blank_to_blank_to_blank");
	}

	@Test
	public void test_blank_to_blank_to_in() throws Exception {
		assertValidConnection("Top.blank_to_blank_to_in");
	}

	@Test
	public void test_blank_to_blank_to_out() throws Exception {
		assertInvalidDirection("Top.blank_to_blank_to_out");
	}

	@Test
	public void test_blank_to_in_to_blank() throws Exception {
		assertInvalidDirection("Top.blank_to_in_to_blank");
	}

	@Test
	public void test_blank_to_in_to_in() throws Exception {
		assertValidConnection("Top.blank_to_in_to_in");
	}

	@Test
	public void test_blank_to_in_to_out() throws Exception {
		assertInvalidDirection("Top.blank_to_in_to_out");
	}

	@Test
	public void test_blank_to_out_to_blank() throws Exception {
		assertValidConnection("Top.blank_to_out_to_blank");
	}

	@Test
	public void test_blank_to_out_to_in() throws Exception {
		assertValidConnection("Top.blank_to_out_to_in");
	}

	@Test
	public void test_blank_to_out_to_out() throws Exception {
		assertInvalidDirection("Top.blank_to_out_to_out");
	}

	@Test
	public void test_in_to_blank_to_blank() throws Exception {
		assertNoConnection("Top.in_to_blank_to_blank");
	}

	@Test
	public void test_in_to_blank_to_in() throws Exception {
		assertNoConnection("Top.in_to_blank_to_in");
	}

	@Test
	public void test_in_to_blank_to_out() throws Exception {
		assertNoConnection("Top.in_to_blank_to_out");
	}

	@Test
	public void test_in_to_in_to_blank() throws Exception {
		assertNoConnection("Top.in_to_in_to_blank");
	}

	@Test
	public void test_in_to_in_to_in() throws Exception {
		assertNoConnection("Top.in_to_in_to_in");
	}

	@Test
	public void test_in_to_in_to_out() throws Exception {
		assertNoConnection("Top.in_to_in_to_out");
	}

	@Test
	public void test_in_to_out_to_blank() throws Exception {
		assertNoConnection("Top.in_to_out_to_blank");
	}

	@Test
	public void test_in_to_out_to_in() throws Exception {
		assertNoConnection("Top.in_to_out_to_in");
	}

	@Test
	public void test_in_to_out_to_out() throws Exception {
		assertNoConnection("Top.in_to_out_to_out");
	}

	@Test
	public void test_out_to_blank_to_blank() throws Exception {
		assertValidConnection("Top.out_to_blank_to_blank");
	}

	@Test
	public void test_out_to_blank_to_in() throws Exception {
		assertValidConnection("Top.out_to_blank_to_in");
	}

	@Test
	public void test_out_to_blank_to_out() throws Exception {
		assertInvalidDirection("Top.out_to_blank_to_out");
	}

	@Test
	public void test_out_to_in_to_blank() throws Exception {
		assertInvalidDirection("Top.out_to_in_to_blank");
	}

	@Test
	public void test_out_to_in_to_in() throws Exception {
		assertInvalidDirection("Top.out_to_in_to_in");
	}

	@Test
	public void test_out_to_in_to_out() throws Exception {
		assertInvalidDirection("Top.out_to_in_to_out");
	}

	@Test
	public void test_out_to_out_to_blank() throws Exception {
		assertValidConnection("Top.out_to_out_to_blank");
	}

	@Test
	public void test_out_to_out_to_in() throws Exception {
		assertValidConnection("Top.out_to_out_to_in");
	}

	@Test
	public void test_out_to_out_to_out() throws Exception {
		assertInvalidDirection("Top.out_to_out_to_out");
	}

	/*
	 * The Xtend version of this test also carried a commented-out test for Top.in_nt_to_in_nt of
	 * TestAbstractToDataAccessClassifier.aadl. That case is still uncovered.
	 */

	/** The instantiated system implementation and the messages reported while instantiating it. */
	private record Instantiation(ComponentInstance instance, List<Message> messages) {
	}

	private Instantiation instantiate(String implementationName) throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		var implementation = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> implementationName.equals(classifier.getName()))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		var instance = InstantiateModel.instantiate(implementation, errorManager);
		var reporter = (QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource());
		return new Instantiation(instance, reporter.getErrors());
	}

	/** The connection is instantiated and the instantiation reports nothing. */
	private void assertValidConnection(String implementationName) throws Exception {
		var result = instantiate(implementationName);
		assertNotNull(connectionInstance(result.instance()));
		assertTrue(result.messages().isEmpty());
	}

	/** The connection is not instantiated at all and the instantiation reports nothing. */
	private void assertNoConnection(String implementationName) throws Exception {
		var result = instantiate(implementationName);
		assertNull(connectionInstance(result.instance()));
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
}
