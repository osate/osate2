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
package org.osate.core.tests.instantiation.flows;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Message;
import org.osate.testsupport.Aadl2InjectorProvider;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class InvalidEndToEndFlowInstantiationTest extends AbstractEndToEndFlowInstantiationTest {
	private static final String FILE = "InvalidFlows.aadl";
	private static final String SEMANTIC_CONNECTION_ERRORS_FILE = "SemanticConnectionErrors.aadl";

	@Test
	public void testInvalidBranchesAreDiscardedWithoutAffectingValidBranches() throws Exception {
		InstantiationResult result = instantiateWithErrors(FILE, "BranchFailureTop.i");

		assertEquals(List.of("valid_1", "valid_2"), flowNames(result.instance()));
		assertEquals(2, messagesStartingWith(result.messages(), "Invalid end-to-end flow instance invalid").size());
	}

	@Test
	public void testInvalidBranchDiagnosticsAreErrorsOnTheContainingInstance() throws Exception {
		InstantiationResult result = instantiateWithErrors(FILE, "BranchFailureTop.i");
		List<Message> messages = messagesStartingWith(result.messages(), "Invalid end-to-end flow instance invalid");

		assertEquals(2, messages.size());
		for (Message message : messages) {
			assertEquals(QueuingAnalysisErrorReporter.ERROR, message.kind);
			assertEquals(result.instance(), message.where);
			assertTrue(message.message.contains("continues into component"));
		}
	}

	@Test
	public void testMissingFlowImplementationRetainsCompletedFlowAndReportsFlowError() throws Exception {
		InstantiationResult result = instantiateWithErrors(FILE, "MissingImplementationTop.i");

		assertEquals(List.of("missing"), flowNames(result.instance()));
		List<Message> messages = messagesStartingWith(result.messages(),
				"Cannot create end to end flow 'missing'");
		assertEquals(1, messages.size());
		assertEquals("Cannot create end to end flow 'missing' because component 'composite' has subcomponents "
				+ "but no flow implementation for flow 'fpath'", messages.getFirst().message);
		assertEquals(result.instance(), messages.getFirst().where);
	}

	@Test(timeout = 30_000)
	public void testCyclicNestedFlowsTerminateAndAreDiscarded() throws Exception {
		InstantiationResult result = instantiateWithErrors(FILE, "CycleTop.i");

		assertTrue(result.instance().getEndToEndFlows().isEmpty());
		assertEquals(1, result.messages().size());
		assertTrue(result.messages().get(0).message.startsWith(
				"second could not be instantiated: Cyclic dependency between end to end flows involving "));
		assertEquals(QueuingAnalysisErrorReporter.ERROR, result.messages().get(0).kind);
		assertEquals(result.instance(), result.messages().get(0).where);
	}

	@Test
	public void testAllInstantiationDiagnosticsAreErrors() throws Exception {
		for (String implementation : List.of("BranchFailureTop.i", "MissingImplementationTop.i", "CycleTop.i",
				"NestedCompatibilityTop.i")) {
			InstantiationResult result = instantiateWithErrors(FILE, implementation);
			List<Message> flowMessages = result.messages()
					.stream()
					.filter(message -> message.message.toLowerCase().contains("end-to-end")
							|| message.message.toLowerCase().contains("end to end"))
					.toList();
			assertTrue(flowMessages.stream()
					.allMatch(message -> message.kind.equals(QueuingAnalysisErrorReporter.ERROR)));
		}
	}

	@Test
	public void testIncompatibleNestedConnectionPathDiscardsParent() throws Exception {
		InstantiationResult result = instantiateWithErrors(FILE, "NestedCompatibilityTop.i");

		assertEquals(List.of("nested"), flowNames(result.instance()));
		assertEquals(List.of("parent could not be instantiated: Incomplete end-to-end flow instance parent: "
				+ "No compatible nested end to end flow instance for nested"),
				result.messages().stream().map(message -> message.message).toList());
		assertEquals(QueuingAnalysisErrorReporter.ERROR, result.messages().get(0).kind);
		assertEquals(result.instance(), result.messages().get(0).where);
	}

	@Test
	public void testConnectionToWrongFlowInputDiscardsCandidateAndReportsError() throws Exception {
		InstantiationResult result = instantiateWithErrors(SEMANTIC_CONNECTION_ERRORS_FILE, "MismatchedSinkTop.i");

		assertTrue(result.instance().getEndToEndFlows().isEmpty());
		assertEquals(List.of("Cannot create end to end flow 'mismatched' because there are no semantic connections "
				+ "that connect to the start of the flow 'fsnk' at feature 'expected_input'"),
				result.messages().stream().map(message -> message.message).toList());
		assertEquals(QueuingAnalysisErrorReporter.ERROR, result.messages().get(0).kind);
		assertEquals(result.instance(), result.messages().get(0).where);
	}

	@Test
	public void testConnectionToWrongFlowImplementationInputDiscardsCandidateAndReportsError() throws Exception {
		InstantiationResult result = instantiateWithErrors(SEMANTIC_CONNECTION_ERRORS_FILE,
				"MismatchedImplementationInputTop.i");

		assertTrue(result.instance().getEndToEndFlows().isEmpty());
		assertEquals(List.of("Cannot create end to end flow 'mismatched' because there are no semantic connections "
				+ "that connect to the start of the flow 'fpath' at feature 'expected_input'"),
				result.messages().stream().map(message -> message.message).toList());
		assertEquals(QueuingAnalysisErrorReporter.ERROR, result.messages().get(0).kind);
		assertEquals(result.instance(), result.messages().get(0).where);
	}

	@Test
	public void testConnectionFromWrongFlowImplementationOutputDiscardsCandidateAndReportsError() throws Exception {
		InstantiationResult result = instantiateWithErrors(SEMANTIC_CONNECTION_ERRORS_FILE,
				"MismatchedImplementationOutputTop.i");

		assertTrue(result.instance().getEndToEndFlows().isEmpty());
		assertEquals(List.of("Cannot create end to end flow 'mismatched' because there are no semantic connections "
				+ "that continue the flow 'fpath' from feature 'output'"),
				result.messages().stream().map(message -> message.message).toList());
		assertEquals(QueuingAnalysisErrorReporter.ERROR, result.messages().get(0).kind);
		assertEquals(result.instance(), result.messages().get(0).where);
	}

	private static List<Message> messagesStartingWith(List<Message> messages, String prefix) {
		return messages.stream().filter(message -> message.message.startsWith(prefix)).toList();
	}
}
