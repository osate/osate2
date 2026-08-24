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

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3019Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3019/Issue3019.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void nestedInverseFeatureGroupsInBothDirections() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var impl = findImplementation(pkg, "Top.i");
		var connections = InstantiateModel.instantiate(impl).getAllConnectionInstances();

		// The two orientations, compared as a set: each chain is ordered, and which of the two
		// the traversal created first is not part of the model
		assertEquals(Set.of(List.of(
				"up|Top_i_Instance.producer_side.leaf_side.leaf.io|Top_i_Instance.producer_side.leaf_side.boundary.alpha|Top_i_Instance.producer_side.leaf_side|false",
				"nested_up|Top_i_Instance.producer_side.leaf_side.boundary.alpha|Top_i_Instance.producer_side.boundary.source_inner.alpha|Top_i_Instance.producer_side|false",
				"across|Top_i_Instance.producer_side.boundary.source_inner.alpha|Top_i_Instance.consumer_side.boundary.destination_inner.alpha|Top_i_Instance|false"),
				List.of(
				"across|Top_i_Instance.consumer_side.boundary.destination_inner.alpha|Top_i_Instance.producer_side.boundary.source_inner.alpha|Top_i_Instance|true",
				"nested_up|Top_i_Instance.producer_side.boundary.source_inner.alpha|Top_i_Instance.producer_side.leaf_side.boundary.alpha|Top_i_Instance.producer_side|true",
				"up|Top_i_Instance.producer_side.leaf_side.boundary.alpha|Top_i_Instance.producer_side.leaf_side.leaf.io|Top_i_Instance.producer_side.leaf_side|true")),
				connections.stream().map(Issue3019Test::describe).collect(Collectors.toSet()));
	}

	@Test
	public void subsetFeatureGroups() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var connections = InstantiateModel.instantiate(findImplementation(pkg, "SubsetTop.i"))
				.getAllConnectionInstances();

		assertEquals(1, connections.size());
		assertEquals(List.of(
				"across_subset|SubsetTop_i_Instance.producer.boundary.common|SubsetTop_i_Instance.consumer.boundary.common|SubsetTop_i_Instance|false"),
				describe(connections.get(0)));
	}

	private static ComponentImplementation findImplementation(AadlPackage pkg, String name) {
		return (ComponentImplementation) pkg.getOwnedPublicSection().getOwnedClassifiers().stream()
				.filter(classifier -> classifier.getName().equals(name))
				.findFirst()
				.orElseThrow();
	}

	private static List<String> describe(ConnectionInstance connection) {
		return connection.getConnectionReferences().stream()
				.map(reference -> reference.getConnection().getName() + "|"
						+ reference.getSource().getInstanceObjectPath() + "|"
						+ reference.getDestination().getInstanceObjectPath() + "|"
						+ reference.getContext().getInstanceObjectPath() + "|" + reference.isReverse())
				.toList();
	}
}
