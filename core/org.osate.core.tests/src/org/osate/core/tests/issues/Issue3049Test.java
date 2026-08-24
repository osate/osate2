/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK OR COPYRIGHT INFRINGEMENT.
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
 * conditions contained in any such Third Party Software or separate license file distributed with this program. The
 * parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries of this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.core.tests.instantiation.InstanceCharacterization;
import org.osate.core.tests.instantiation.IsolatedInstantiation;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Regression for issue #3049: replicated connection references must name their own array element. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3049Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3049/Issue3049.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Inject
	private IsolatedInstantiation isolated;

	@Test
	public void replicatedReferencesUseTheirConnectionEndpoints() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(MODEL));

		var run = isolated.run(MODEL, "Pair.i");

		assertEquals(List.of("consumers[1].nest.inner.ack --> producers[1].nest.inner.ack",
				"consumers[2].nest.inner.ack --> producers[2].nest.inner.ack",
				"producers[1].nest.inner.signal --> consumers[1].nest.inner.signal",
				"producers[2].nest.inner.signal --> consumers[2].nest.inner.signal"),
				InstanceCharacterization.names(run));
		assertEquals(List.of(
				"consumers[1].nest.inner.ack --> producers[1].nest.inner.ack"
						+ " = consumers[1].nest.inner.ack --> producers[1].nest.inner.ack",
				"consumers[2].nest.inner.ack --> producers[2].nest.inner.ack"
						+ " = consumers[2].nest.inner.ack --> producers[2].nest.inner.ack",
				"producers[1].nest.inner.signal --> consumers[1].nest.inner.signal"
						+ " = producers[1].nest.inner.signal --> consumers[1].nest.inner.signal",
				"producers[2].nest.inner.signal --> consumers[2].nest.inner.signal"
						+ " = producers[2].nest.inner.signal --> consumers[2].nest.inner.signal"),
				referenceEndpoints(run.instance().getAllConnectionInstances()));
	}

	private static List<String> referenceEndpoints(List<ConnectionInstance> connections) {
		return connections.stream().map(connection -> {
			var references = connection.getConnectionReferences();
			return connection.getName() + " = " + relativePath(connection, references.get(0).getSource()) + " --> "
					+ relativePath(connection, references.get(references.size() - 1).getDestination());
		}).sorted().toList();
	}

	private static String relativePath(ConnectionInstance connection, InstanceObject end) {
		var containerPath = connection.getContainingComponentInstance().getInstanceObjectPath() + ".";
		var endPath = end.getInstanceObjectPath();
		return endPath.startsWith(containerPath) ? endPath.substring(containerPath.length()) : endPath;
	}
}
