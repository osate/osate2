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
package org.osate.ba.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.BehaviorIntegerLiteral;
import org.osate.ba.aadlba.BehaviorStringLiteral;
import org.osate.ba.aadlba.BehaviorTransition;
import org.osate.ba.aadlba.ElementHolder;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;

/**
 * An internal event or internal event data feature is neither a port nor a data component, so translating one into a
 * data-subcomponent holder or a subprogram call misnames what the user wrote. Verifies that the strict model uses the
 * internal feature category of each action, that a data-less internal event carries no value, that a sent or assigned
 * value matches the internal event data classifier, and that an internal port is rejected everywhere the standard
 * admits only an incoming port.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3174Test {
	private static final String MODELS = "org.osate.ba.tests/models/issue3174/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void internalPortActionsNameTheirInternalFeatureCategory() throws Exception {
		assertEquals(List.of("assign_data -> AssignmentAction(target=EventDataSourceHolder:raised_data, "
				+ "valueExpression=1)",
				"send_data_with_value -> InternalPortSendAction(internalPort=EventDataSourceHolder:raised_data, "
						+ "valueExpression=2)",
				"send_data -> InternalPortSendAction(internalPort=EventDataSourceHolder:raised_data)",
				"send_event -> InternalPortSendAction(internalPort=EventSourceHolder:raised_event)"),
				strictAnnex().getTransitions().stream().map(Issue3174Test::describe).toList());
	}

	/**
	 * The wrong-typed assignment and send in the same model are not listed: they reach
	 * {@code AdaLikeDataTypeChecker.conformsTo}, which the implementation disables for every assignment and send alike.
	 * An internal port send compares its value against the internal event data classifier by that same path as a port
	 * send, so re-enabling that comparison covers this model without further work.
	 */
	@Test
	public void internalEventWithoutDataCarriesNoValue() throws Exception {
		assertEquals(List.of(
				"ERROR: internal event 'raised_event' has no data: it cannot be an assignment target",
				"ERROR: internal event 'raised_event' has no data: its send action cannot carry a value"),
				issues("InternalPortTypes.aadl"));
	}

	@Test
	public void internalPortsAreNotIncomingPorts() throws Exception {
		var expected = "'raised_data' is an internal port: it can only be an assignment or dequeue target,"
				+ " the port of a send action, or a port of an internal condition";
		assertEquals(List.of("ERROR: " + expected, "ERROR: " + expected, "ERROR: " + expected,
				"ERROR: " + expected.replace("raised_data", "raised_event")), issues("InternalPortMisuse.aadl"));
	}

	private BehaviorAnnex strictAnnex() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3174.aadl");
		validationHelper.assertNoIssues(root);
		return BehaviorAnnexUtil.getStrictModel(AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst());
	}

	private List<String> issues(final String model) throws Exception {
		return testHelper.testFile(MODELS + model)
				.getIssues()
				.stream()
				.map(issue -> issue.getSeverity() + ": " + issue.getMessage())
				.toList();
	}

	/**
	 * Describes the single action of a transition by metaclass name, so that a run against a model without the
	 * internal-feature holders reports the representation it did build instead of failing to compile.
	 */
	private static String describe(final BehaviorTransition transition) {
		var action = transition.getActionBlock().getContent();
		var children = new StringJoiner(", ", action.eClass().getName() + "(", ")");
		children.setEmptyValue(action.eClass().getName());
		for (var child : action.eContents()) {
			children.add(child.eContainingFeature().getName() + "=" + describe(child));
		}
		return transition.getName() + " -> " + children;
	}

	private static String describe(final EObject child) {
		if (child instanceof ElementHolder holder) {
			return child.eClass().getName() + ":" + name(holder.getElement());
		}
		var literals = new ArrayList<String>();
		child.eAllContents().forEachRemaining(object -> {
			if (object instanceof BehaviorIntegerLiteral literal) {
				literals.add(Long.toString(literal.getValue()));
			} else if (object instanceof BehaviorStringLiteral literal) {
				literals.add('"' + literal.getValue() + '"');
			}
		});
		return literals.isEmpty() ? child.eClass().getName() : String.join(" ", literals);
	}

	private static String name(final NamedElement element) {
		return element == null ? "<null>" : element.getName();
	}
}
