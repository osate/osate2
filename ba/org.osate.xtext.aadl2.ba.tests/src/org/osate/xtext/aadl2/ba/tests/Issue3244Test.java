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
package org.osate.xtext.aadl2.ba.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.validation.BehaviorAnnexValidator;

import com.google.inject.Inject;

/** Characterizes independent diagnostics and annex isolation while consolidating validator traversals. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexEmbeddedInjectorProvider.class)
public class Issue3244Test {
	private static final String MODEL_DIRECTORY = "org.osate.xtext.aadl2.ba.tests/models/issue3244/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void reportsIndependentChecksInNestedActionsAfterAnInvalidArraySize() throws Exception {
		var result = testHelper.testFile(MODEL_DIRECTORY + "Issue3244.aadl",
				MODEL_DIRECTORY + "Issue3244Properties.aadl");
		var source = NodeModelUtils.getNode(result.getResource().getContents().getFirst()).getRootNode().getText();
		// The invalid dimension gates the strict analyzers, but all source checks and both property checks must run.
		// A second, valid annex in the same file must not inherit the first annex's pending checks.
		var expected = List.of(BehaviorAnnexValidator.ARRAY_SIZE + ": amount",
				BehaviorAnnexValidator.ITERATIVE_VARIABLE_TARGET + ": i",
				BehaviorAnnexValidator.ITERATIVE_VARIABLE_TARGET + ": j",
				BehaviorAnnexValidator.PORT_STATUS_DIRECTION + ": outgoing'fresh",
				BehaviorAnnexValidator.PROPERTY_REFERENCE_VALUE + ": #Issue3244Properties::Size",
				BehaviorAnnexValidator.PROPERTY_REFERENCE_UNITS + ": #Issue3244Properties::Size");
		assertEquals(expected.stream().sorted().toList(), result.getIssues().stream().map(issue -> {
			assertEquals(result.getSummary(), Severity.ERROR, issue.getSeverity());
			return issue.getCode() + ": " + source.substring(issue.getOffset(), issue.getOffset() + issue.getLength());
		}).sorted().toList());
	}
}
