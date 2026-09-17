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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.ActualPortHolder;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.ModeSwitchTriggerLogicalExpression;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Exercises external-condition trigger validation and preservation through ordinary embedded AADL models. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3232Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3232/";
	private static final String EXTERNAL_CONDITION_TRIGGER = "org.osate.xtext.aadl2.ba.externalConditionTrigger";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void incomingOwnerPortsRemainTriggersInNestedExpressions() throws Exception {
		var root = testHelper.parseFile(PATH + "Issue3232.aadl");
		validationHelper.assertNoIssues(root);
		var ports = triggers(root);
		assertEquals(List.of("incoming", "incoming_data", "bidirectional", "bidirectional_data"),
				ports.stream().map(port -> port.getPort().getName()).toList());
		for (var port : ports) {
			assertNull(port.getContext());
		}
	}

	@Test
	public void outgoingSubcomponentPortsRetainTheirContexts() throws Exception {
		var root = testHelper.parseFile(PATH + "SubcomponentTriggers.aadl");
		validationHelper.assertNoIssues(root);
		var annex = AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
		var owner = (ComponentImplementation) annex.getContainingClassifier();
		var first = owner.getAllSubcomponents().stream().filter(s -> "first".equals(s.getName())).findFirst().orElseThrow();
		var second = owner.getAllSubcomponents().stream().filter(s -> "second".equals(s.getName())).findFirst().orElseThrow();
		var ports = triggers(root);
		assertEquals(List.of("outgoing", "outgoing", "outgoing_data", "outgoing_data", "bidirectional",
				"bidirectional_data"), ports.stream().map(port -> port.getPort().getName()).toList());
		assertSame(ports.get(0).getPort(), ports.get(1).getPort());
		for (var i = 0; i < ports.size(); i++) {
			assertSame(i % 2 == 0 ? first : second, ports.get(i).getContext());
		}
	}

	@Test
	public void strictSerializationPreservesSubcomponentContexts() throws Exception {
		var root = testHelper.parseFile(PATH + "SubcomponentTriggers.aadl");
		validationHelper.assertNoIssues(root);
		var strict = BehaviorAnnexUtil.getStrictModel(AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst());
		var original = triggers(strict);
		root.eResource().setURI(URI.createURI("memory:/issue3232.aadl"));
		var resource = new XMIResourceImpl(URI.createURI("memory:/issue3232.aadlba"));
		root.eResource().getResourceSet().getPackageRegistry().put(AadlBaPackage.eNS_URI, AadlBaPackage.eINSTANCE);
		root.eResource().getResourceSet().getResources().add(resource);
		try {
			resource.getContents().add(EcoreUtil.copy(strict));
			var bytes = new ByteArrayOutputStream();
			resource.save(bytes, Map.of());
			resource.unload();
			resource.load(new ByteArrayInputStream(bytes.toByteArray()), Map.of());
			EcoreUtil.resolveAll(resource);
			var reloaded = triggers((BehaviorAnnex) resource.getContents().getFirst());
			assertEquals(original.size(), reloaded.size());
			for (var i = 0; i < original.size(); i++) {
				assertSame(original.get(i).getPort(), reloaded.get(i).getPort());
				assertSame(original.get(i).getContext(), reloaded.get(i).getContext());
			}
		} finally {
			root.eResource().getResourceSet().getResources().remove(resource);
		}
	}

	@Test
	public void featureGroupsAndThreadGroupContextsRemainDistinct() throws Exception {
		var root = testHelper.parseFile(PATH + "GroupedTriggers.aadl");
		validationHelper.assertNoIssues(root);
		var ports = triggers(root);
		assertEquals(3, ports.size());
		assertNull(ports.get(0).getContext());
		assertEquals("child", ports.get(1).getContext().getName());
		assertEquals("grouped", ports.get(2).getContext().getName());
		assertEquals(List.of(List.of("input_group"), List.of("output_group"), List.of()),
				ports.stream().map(port -> port.getGroupHolders().stream()
						.map(group -> group.getElement().getName()).toList()).toList());
	}

	@Test
	public void invalidKindsDirectionsAndNamesAreReportedOnEveryWrittenTrigger() throws Exception {
		var root = testHelper.parseFile(PATH + "InvalidTriggers.aadl");
		var names = List.of("value", "stored", "local_value", "outgoing", "outgoing_data", "child.incoming",
				"child.incoming_data", "child.value", "unknown");
		assertDiagnostics(root, names.stream().map(name -> new Expected(name, EXTERNAL_CONDITION_TRIGGER,
				"'" + name + "' is not an external-condition trigger: expected an incoming event or event data port"
						+ " of the component, or an outgoing event or event data port of a subcomponent")).toList());
	}

	@Test
	public void modeRefinementDistinguishesSubcomponentsOfTheSameClassifier() throws Exception {
		var root = testHelper.parseFile(PATH + "ModeTriggers.aadl");
		assertDiagnostics(root, List.of(new Expected("on second.outgoing", "org.osate.xtext.aadl2.ba.checker",
				"The behavior transition tries to refine a transition mode but it is not consisting with any "
						+ "transition mode of ModeTriggers::controller.mismatching component: Behavior Annex D.3.(C4) "
						+ "consistency rule failed.")));
	}

	private static List<ActualPortHolder> triggers(AadlPackage root) {
		var annex = AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst();
		return triggers(BehaviorAnnexUtil.getStrictModel(annex));
	}

	private static List<ActualPortHolder> triggers(BehaviorAnnex strict) {
		var result = new ArrayList<ActualPortHolder>();
		collectTriggers((ModeSwitchTriggerLogicalExpression) strict.getTransitions().getFirst().getCondition(), result);
		return result;
	}

	private static void collectTriggers(ModeSwitchTriggerLogicalExpression expression, List<ActualPortHolder> result) {
		for (var conjunction : expression.getModeSwitchConjunctions()) {
			for (var trigger : conjunction.getModeSwitchTriggers()) {
				if (trigger instanceof ModeSwitchTriggerLogicalExpression group) {
					collectTriggers(group, result);
				} else {
					assertTrue(trigger instanceof ActualPortHolder);
					result.add((ActualPortHolder) trigger);
				}
			}
		}
	}

	private void assertDiagnostics(AadlPackage root, List<Expected> expected) {
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		assertEquals(issues.toString(), expected.size(), issues.size());
		assertEquals(expected, issues.stream().map(issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			var target = source.substring(issue.getOffset(), issue.getOffset() + issue.getLength());
			return new Expected(target, issue.getCode(), issue.getMessage());
		}).toList());
	}

	private record Expected(String target, String code, String message) {
	}
}
