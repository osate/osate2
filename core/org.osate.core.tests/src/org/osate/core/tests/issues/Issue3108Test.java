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

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Feature;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Declarative property lookup uses distinct behavior for component implementations, subcomponents,
 * features, and port connections. This test reaches every case through instance-model property caching
 * and pins both the declarative dispatch target and the value that the lookup contributes.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3108Test extends XtextTest {
	private static final String PATH = "org.osate.core.tests/models/issue3108/";
	private static final String MODEL = PATH + "Issue3108.aadl";
	private static final String PROPERTIES = PATH + "Issue3108Properties.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void declarativeLookupDispatchesThroughEachNamedElementKind() throws Exception {
		var pkg = testHelper.parseFile(MODEL, PROPERTIES);
		validationHelper.assertNoIssues(pkg);
		var implementation = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Top.i"))
				.findFirst()
				.orElseThrow();

		var instance = InstantiateModel.instantiate(implementation);
		var source = component(instance, "src");
		var output = source.getFeatureInstances()
				.stream()
				.filter(feature -> feature.getName().equals("output"))
				.findFirst()
				.orElseThrow();
		var connection = instance.getConnectionInstances().getFirst();

		assertTrue(instance.getInstantiatedObjects().getFirst() instanceof ComponentImplementation);
		assertEquals(1, value(instance, "Root_Value"));

		assertTrue(source.getInstantiatedObjects().getFirst() instanceof Subcomponent);
		assertEquals(2, value(source, "Subcomponent_Value"));

		assertTrue(output.getInstantiatedObjects().getFirst() instanceof Feature);
		assertEquals(3, value(output, "Feature_Value"));

		assertTrue(connection.getConnectionReferences().getFirst().getConnection() instanceof PortConnection);
		assertEquals(4, value(connection, "Connection_Value"));
	}

	private static ComponentInstance component(ComponentInstance container, String name) {
		return container.getComponentInstances()
				.stream()
				.filter(component -> component.getName().equals(name))
				.findFirst()
				.orElseThrow();
	}

	private static long value(InstanceObject instanceObject, String propertyName) {
		var associations = instanceObject.getOwnedPropertyAssociations()
				.stream()
				.filter(association -> association.getProperty().getName().equals(propertyName))
				.toList();
		assertEquals(instanceObject.getInstanceObjectPath(), 1, associations.size());
		var expression = associations.getFirst().getOwnedValues().getFirst().getOwnedValue();
		return (long) ((IntegerLiteral) expression).getValue();
	}
}
