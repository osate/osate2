/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, MERCHANTABILITY, EXCLUSIVITY,
 * RESULTS OBTAINED FROM USE OF THE MATERIAL, OR FITNESS FOR A PARTICULAR PURPOSE.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 */
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.osate.aadl2.instance.ConnectionKind.MODE_TRANSITION_CONNECTION;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ModeTransitionInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3025Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3025/Issue3025.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void modeTransitionTriggerIsAnOrdinaryTerminal() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var top = (ComponentImplementation) pkg.getOwnedPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> classifier.getName().equals("Top.i"))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		SystemInstance instance = InstantiateModel.instantiate(top, errorManager);
		var connections = instance.getAllConnectionInstances();
		// Sorted, because collection order is allowlist entry 1 of issue #3037 and says nothing here.
		assertEquals(List.of(
				"Top_i_Instance.bridge.producer.to_ordinary|Top_i_Instance.consumer.incoming|2",
				"Top_i_Instance.bridge.producer.to_trigger|Top_i_Instance.bridge.trigger_terminal|1"),
				connections.stream()
						.map(connection -> connection.getSource().getInstanceObjectPath() + "|"
								+ connection.getDestination().getInstanceObjectPath() + "|"
								+ connection.getConnectionReferences().size())
						.sorted()
						.toList());
		assertFalse(connections.stream().anyMatch(connection -> connection.getKind() == MODE_TRANSITION_CONNECTION
				|| connection.getSource() instanceof ModeTransitionInstance
				|| connection.getDestination() instanceof ModeTransitionInstance));

		ComponentInstance bridge = instance.getComponentInstances().stream()
				.filter(component -> component.getName().equals("bridge"))
				.findFirst()
				.orElseThrow();
		var transition = instance.getModeTransitionInstances().get(0);
		assertEquals(1, transition.getTriggers().size());
		var trigger = bridge.getFeatureInstances().stream()
				.filter(feature -> feature.getName().equals("trigger_terminal"))
				.findFirst()
				.orElseThrow();
		assertSame(trigger, transition.getTriggers().get(0));

		/*
		 * Allowlist entry 8 of issue #3037. Source-first warned "Could not continue connection from
		 * Top_i_Instance.bridge.producer.to_unresolved  through Top_i_Instance.bridge.unresolved_terminal.
		 * No connection instance created." because it was extending that path when it found the level
		 * above routes the feature nowhere. Across-first never enumerates the path: the declaration
		 * carrying it up out of the subcomponent is not across, so nothing seeds it and no leg reaches
		 * it. Neither strategy creates a connection instance for it, which is what the assertion on the
		 * two connections above pins.
		 */
		var messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors();
		assertEquals(List.of(), messages);
	}
}
