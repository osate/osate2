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

import java.util.Comparator;
import java.util.List;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

/** Verifies that D.5 port-status values apply only to ports that are frozen on input. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3217Test {
	private static final String MODEL = "org.osate.ba.tests/models/issue3217/Issue3217.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void portStatusValuesRequireAPortFrozenOnInput() throws Exception {
		var root = testHelper.parseFile(MODEL);
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		var values = List.of("outgoing'count", "outgoing'fresh", "outgoing'updated");
		assertEquals(issues.toString(), values.size(), issues.size());
		assertEquals(values, issues.stream().map(issue -> {
			var value = source.substring(issue.getOffset(), issue.getOffset() + issue.getLength());
			assertEquals(Severity.ERROR, issue.getSeverity());
			assertEquals("Port status value '" + value + "' is defined only for a port that is frozen on input, but"
					+ " 'outgoing' is an outgoing port. AS5506/3 Rev. A states no corresponding legality rule.",
					issue.getMessage());
			return value;
		}).toList());
	}
}
