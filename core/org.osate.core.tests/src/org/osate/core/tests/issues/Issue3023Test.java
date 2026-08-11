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
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3023Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3023/Issue3023.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void removedShortConnectionsAreAbsentFromEndpointInverses() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var instance = InstantiateModel.instantiate(findImplementation(pkg, "DemoTop.impl"));
		var accessPaths = instance.getAllConnectionInstances()
				.stream()
				.filter(connection -> connection.getKind() == ConnectionKind.ACCESS_CONNECTION)
				.map(Issue3023Test::describe)
				.toList();

		assertEquals(List.of(List.of("internal_supply|false", "across_link|false", "internal_demand|true")),
				accessPaths);

		Set<ConnectionInstance> containedConnections = Collections.newSetFromMap(new IdentityHashMap<>());
		containedConnections.addAll(instance.getAllConnectionInstances());
		assertInverseConnectionsAreContained(instance, containedConnections);
		instance.eAllContents().forEachRemaining(object -> {
			if (object instanceof ConnectionInstanceEnd end) {
				assertInverseConnectionsAreContained(end, containedConnections);
			}
		});
	}

	private static ComponentImplementation findImplementation(AadlPackage pkg, String name) {
		return (ComponentImplementation) pkg.getOwnedPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> classifier.getName().equals(name))
				.findFirst()
				.orElseThrow();
	}

	private static List<String> describe(ConnectionInstance connection) {
		return connection.getConnectionReferences().stream()
				.map(reference -> reference.getConnection().getName() + "|" + reference.isReverse())
				.toList();
	}

	private static void assertInverseConnectionsAreContained(ConnectionInstanceEnd end,
			Set<ConnectionInstance> containedConnections) {
		assertTrue(end.getInstanceObjectPath() + " has a detached source connection",
				containedConnections.containsAll(end.getSrcConnectionInstances()));
		assertTrue(end.getInstanceObjectPath() + " has a detached destination connection",
				containedConnections.containsAll(end.getDstConnectionInstances()));
	}
}
