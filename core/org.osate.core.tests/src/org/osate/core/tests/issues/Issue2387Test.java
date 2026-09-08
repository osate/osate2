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

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue2387Test {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue2387/";

	private static final String FILE1 = "instance_bug.aadl";

	private static final String PS = "ps.aadl";

	private static final String S_I = "s.i";

	private static final String X_I = "X.i";

	private static final String INSTANCE_NAME1 = "s_i_Instance";

	private static final String INSTANCE_NAME2 = "X_i_Instance";

	private static final String STRING_PROPERTY = "string_property";

	private static final String STRING_WITH_DEFAULT = "string_with_default";

	private static final String DEFAULT_VALUE = "default value";

	private static final String BOB = "bob";

	private static final String XXX = "XXX";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void test_instantiation_of_property_reference_with_default_value() throws Exception {
		SystemInstance instance = instantiate(S_I, INSTANCE_NAME1);

		// property association for property `string_property` of root s.i should be "default value"
		assertEquals(1, instance.getOwnedPropertyAssociations().size());
		assertSingleStringValue(instance.getOwnedPropertyAssociations().get(0), STRING_PROPERTY, DEFAULT_VALUE);

		// property association for property `string_property` of feature f should be "bob"
		assertEquals(1, instance.getFeatureInstances().size());
		var feature = instance.getFeatureInstances().get(0);
		assertEquals(1, feature.getOwnedPropertyAssociations().size());
		assertSingleStringValue(feature.getOwnedPropertyAssociations().get(0), STRING_PROPERTY, BOB);
	}

	@Test
	public void test_default_values_do_not_bleed_through() throws Exception {
		SystemInstance instance = instantiate(X_I, INSTANCE_NAME2);

		assertEquals(0, instance.getOwnedPropertyAssociations().size());
		assertEquals(2, instance.getComponentInstances().size());

		var first = instance.getComponentInstances().get(0);
		assertEquals(1, first.getOwnedPropertyAssociations().size());
		assertSingleStringValue(first.getOwnedPropertyAssociations().get(0), STRING_WITH_DEFAULT, XXX);

		var second = instance.getComponentInstances().get(1);
		assertEquals(0, second.getOwnedPropertyAssociations().size());
		assertEquals(2, second.getFeatureInstances().size());
		assertEquals(0, second.getFeatureInstances().get(0).getOwnedPropertyAssociations().size());
		assertEquals(0, second.getFeatureInstances().get(1).getOwnedPropertyAssociations().size());

		assertEquals(2, instance.getSystemOperationModes().size());
		assertEquals(0, instance.getSystemOperationModes().get(0).getOwnedPropertyAssociations().size());
		assertEquals(0, instance.getSystemOperationModes().get(1).getOwnedPropertyAssociations().size());
	}

	private SystemInstance instantiate(String systemImplName, String expectedInstanceName) throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT_LOCATION + FILE1, PROJECT_LOCATION + PS);
		SystemImplementation sysImpl = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> systemImplName.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		SystemInstance instance = InstantiateModel.instantiate(sysImpl, errorManager);
		assertEquals(expectedInstanceName, instance.getName());

		List<QueuingAnalysisErrorReporter.Message> messages = ((QueuingAnalysisErrorReporter) errorManager
				.getReporter(instance.eResource())).getErrors();
		// No errors or warnings
		assertTrue(messages.size() == 0);
		return instance;
	}

	private static void assertSingleStringValue(PropertyAssociation association, String expectedPropertyName,
			String expectedValue) {
		assertEquals(expectedPropertyName, association.getProperty().getName());
		assertEquals(1, association.getOwnedValues().size());
		var ownedValue = association.getOwnedValues().get(0).getOwnedValue();
		assertTrue(ownedValue instanceof StringLiteral);
		assertEquals(expectedValue, ((StringLiteral) ownedValue).getValue());
	}
}
