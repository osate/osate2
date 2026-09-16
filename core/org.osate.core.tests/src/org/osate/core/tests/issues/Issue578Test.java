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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemType;
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
public class Issue578Test extends XtextTest {
	private static final String SELF_EXTENSION = """
			package issue578A
			public
				system a
				end a;

				system implementation a.impl extends a.impl
				end a.impl;
			end issue578A;
			""";

	private static final String MUTUAL_EXTENSION = """
			package issue578B
			public
				system b extends c
				end b;
				system implementation b.impl extends c.impl
				end b.impl;

				system c extends b
				end c;
				system implementation c.impl extends b.impl
				end c.impl;

			end issue578B;
			""";

	private static final String MUTUAL_TYPE_EXTENSION = """
			package issue578c
			public
				system d extends e
				end d;

				system e extends d
				end e;

				system implementation d.impl
				end d.impl;

			end issue578c;
			""";

	@Inject
	TestHelper<AadlPackage> testHelper;

	private FluentIssueCollection testFileResult;

	private FluentIssueCollection issueCollection;

	@Test
	public void issue578TestA() throws Exception {
		var pkg = parse(SELF_EXTENSION);
		assertEquals("issue578A", pkg.getName());
		var classifiers = pkg.getPublicSection().getOwnedClassifiers();
		assertExtensionCycleError((SystemImplementation) classifiers.get(1), "a.impl",
				"The extends hierarchy of a.impl has a cycle.");
		assertAllIssuesReported();

		var messages = instantiationErrors(pkg, "a.impl");
		assertEquals(1, messages.size());
		assertEquals(Kind.ERROR, messages.getFirst().kind);
		assertEquals("Circular extension: Component 'a.impl' directly or indirectly extends itself.",
				messages.getFirst().message);
	}

	@Test
	public void issue578TestB() throws Exception {
		var pkg = parse(MUTUAL_EXTENSION);
		assertEquals("issue578B", pkg.getName());
		var classifiers = pkg.getPublicSection().getOwnedClassifiers();
		assertExtensionCycleError((SystemType) classifiers.get(0), "b", "The extends hierarchy of b has a cycle.");
		assertExtensionCycleError((SystemImplementation) classifiers.get(1), "b.impl",
				"The extends hierarchy of b.impl has a cycle.");
		assertExtensionCycleError((SystemType) classifiers.get(2), "c", "The extends hierarchy of c has a cycle.");
		assertExtensionCycleError((SystemImplementation) classifiers.get(3), "c.impl",
				"The extends hierarchy of c.impl has a cycle.");
		assertAllIssuesReported();

		var messagesB = instantiationErrors(pkg, "b.impl");
		assertEquals(2, messagesB.size());
		for (var message : messagesB) {
			assertCircularExtension(message, "Classifier",
					"Circular extension: Classifier 'b' directly or indirectly extends itself.",
					"Circular extension: Component 'b.impl' directly or indirectly extends itself.");
		}

		var messagesC = instantiationErrors(pkg, "c.impl");
		assertEquals(2, messagesC.size());
		for (var message : messagesC) {
			assertCircularExtension(message, "Classifier",
					"Circular extension: Classifier 'c' directly or indirectly extends itself.",
					"Circular extension: Component 'c.impl' directly or indirectly extends itself.");
		}
	}

	@Test
	public void issue578TestC() throws Exception {
		var pkg = parse(MUTUAL_TYPE_EXTENSION);
		assertEquals("issue578c", pkg.getName());
		var classifiers = pkg.getPublicSection().getOwnedClassifiers();
		assertExtensionCycleError((SystemType) classifiers.get(0), "d", "The extends hierarchy of d has a cycle.");
		assertExtensionCycleError((SystemType) classifiers.get(1), "e", "The extends hierarchy of e has a cycle.");
		assertAllIssuesReported();

		var messages = instantiationErrors(pkg, "d.impl");
		assertEquals(1, messages.size());
		assertCircularExtension(messages.getFirst(), "Classifier 'd'",
				"Circular extension: Classifier 'd' directly or indirectly extends itself.",
				"Circular extension: Classifier 'e' directly or indirectly extends itself.");
	}

	private AadlPackage parse(String source) throws Exception {
		testFileResult = issues = testHelper.testString(source);
		issueCollection = new FluentIssueCollection(testFileResult.getResource(), new ArrayList<>(), new ArrayList<>());
		return (AadlPackage) testFileResult.getResource().getContents().getFirst();
	}

	private void assertAllIssuesReported() {
		issueCollection.sizeIs(testFileResult.getIssues().size());
		assertConstraints(issueCollection);
	}

	private void assertExtensionCycleError(ComponentType type, String name, String message) {
		assertEquals(name, type.getName());
		assertError(type.getOwnedExtension(), message);
	}

	private void assertExtensionCycleError(ComponentImplementation implementation, String name, String message) {
		assertEquals(name, implementation.getName());
		assertError(implementation.getOwnedExtension(), message);
	}

	private void assertError(EObject object, String message) {
		AssertHelper.assertError(object, testFileResult.getIssues(), issueCollection, message);
	}

	private static List<Message> instantiationErrors(AadlPackage pkg, String implementationName) throws Exception {
		var implementation = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> implementationName.equals(classifier.getName()))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		var instance = InstantiateModel.instantiate(implementation, errorManager);
		var reporter = (QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource());
		return reporter.getErrors();
	}

	/*
	 * The instantiator reports the cycle either on the implementation or on the type, depending on which classifier it
	 * reaches first, so the expected message is selected by looking for the marker in the reported message.
	 */
	private static void assertCircularExtension(Message error, String marker, String expectedWithMarker,
			String expectedWithoutMarker) {
		assertEquals(Kind.ERROR, error.kind);
		assertEquals(error.message.contains(marker) ? expectedWithMarker : expectedWithoutMarker, error.message);
	}
}
