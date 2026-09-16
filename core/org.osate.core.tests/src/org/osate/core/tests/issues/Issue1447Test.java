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
import static org.osate.core.tests.instantiation.InstanceLookup.onlyConnection;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Kind;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Message;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1447Test {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue1447/";

	private static final String TEST_PS = "TestPS.aadl";

	private static final String FEATURES = "features";
	private static final String FEATURE_GROUP = "fg";
	private static final String EXTENSION = ".aadl";

	private static final String A_I = "A.i";

	private static final String INSTANCE_NAME = "A_i_Instance";

	/*
	 * Ideally the value should be -200L, but because the declarative model is actually erroneous (by containing
	 * associations that try to replace constant associations) the behavior cannot be trusted. In this case, the
	 * instantiation process still picks up the contained association in C_i because it is in the same classifier that
	 * declares subcomponent s3.
	 */
	private static final long VALUE_FROM_ERRONEOUS_MODEL = 200L;

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testSubcomponents1() throws Exception {
		/* The first test should have no errors. */
		assertSubcomponents("subcomponents1", 400L);
	}

	@Test
	public void testSubcomponents2() throws Exception {
		assertSubcomponents("subcomponents2", VALUE_FROM_ERRONEOUS_MODEL, "C.i", "B.i", "A.i");
	}

	// basically the same as test2
	@Test
	public void testSubcomponents3() throws Exception {
		assertSubcomponents("subcomponents3", VALUE_FROM_ERRONEOUS_MODEL, "C.i", "B.i", "A.i");
	}

	// basically the same as test2
	@Test
	public void testSubcomponents4() throws Exception {
		assertSubcomponents("subcomponents4", VALUE_FROM_ERRONEOUS_MODEL, "C.i", "B.i", "A.i");
	}

	@Test
	public void testSubcomponents5() throws Exception {
		assertSubcomponents("subcomponents5", 200L, "B.i", "A.i");
	}

	@Test
	public void testSubcomponents6() throws Exception {
		assertSubcomponents("subcomponents6", 300L, "A.i");
	}

	@Test
	public void testFeatures1() throws Exception {
		assertFeatures(1, 90L);
	}

	@Test
	public void testFeatures2() throws Exception {
		assertFeatures(2, 0L, "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatures3() throws Exception {
		assertFeatures(3, 10L, "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatures4() throws Exception {
		assertFeatures(4, 20L, "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatures5() throws Exception {
		assertFeatures(5, 30L, "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatures6() throws Exception {
		assertFeatures(6, 40L, "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatures7() throws Exception {
		assertFeatures(7, 50L, "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatures8() throws Exception {
		assertFeatures(8, 60L, "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatures9() throws Exception {
		assertFeatures(9, 70L, "B.i", "A.i");
	}

	@Test
	public void testFeatures10() throws Exception {
		assertFeatures(10, 80L, "A.i");
	}

	@Test
	public void testFeatures11() throws Exception {
		assertFeatures(11, 90L);
	}

	@Test
	public void testFeatureGroups1() throws Exception {
		assertFeatureGroups(1, 90L);
	}

	@Test
	public void testFeatureGroups2() throws Exception {
		assertFeatureGroups(2, 0L, "D2.fg1", "D", "D2", "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatureGroups3() throws Exception {
		assertFeatureGroups(3, 10L, "D2.fg1", "D", "D2", "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatureGroups4() throws Exception {
		assertFeatureGroups(4, 20L, "D2.fg1", "D", "D2", "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatureGroups5() throws Exception {
		assertFeatureGroups(5, 30L, "D2.fg1", "D", "D2", "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatureGroups6() throws Exception {
		assertFeatureGroups(6, 32L, "D2.fg1", "D", "D2", "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatureGroups7() throws Exception {
		assertFeatureGroups(7, 35L, "D2.fg1", "D", "D2", "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatureGroups8() throws Exception {
		assertFeatureGroups(8, 90L);
	}

	@Test
	public void testFeatureGroups9() throws Exception {
		assertFeatureGroups(9, 45L, "D2", "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatureGroups10() throws Exception {
		assertFeatureGroups(10, 50L, "D", "D2", "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatureGroups11() throws Exception {
		assertFeatureGroups(11, 55L, "D2.i", "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatureGroups12() throws Exception {
		assertFeatureGroups(12, 60L, "C.i", "B.i", "A.i");
	}

	@Test
	public void testFeatureGroups13() throws Exception {
		assertFeatureGroups(13, 70L, "B.i", "A.i");
	}

	@Test
	public void testFeatureGroups14() throws Exception {
		assertFeatureGroups(14, 80L, "A.i");
	}

	@Test
	public void testFeatureGroups15() throws Exception {
		assertFeatureGroups(15, 90L);
	}

	@Test
	public void testSemanticConnection1() throws Exception {
		assertSemanticConnection("sc1", containedAssociationError("sc1::whole.i"));
	}

	@Test
	public void testSemanticConnection2() throws Exception {
		assertSemanticConnection("sc2", "Value for property TestPS::myProp not consistent along connection");
	}

	@Test
	public void testSemanticConnection3() throws Exception {
		assertSemanticConnection("sc3", "Value for property TestPS::myProp not consistent along connection");
	}

	/**
	 * Instantiates the model and checks the property value of the subcomponent s1.s2.s3 and the errors reported for it.
	 *
	 * @param packageName the name of both the AADL package and its file
	 * @param expectedValue the expected value of TestPS::myProp for s3
	 * @param errorClassifiers the classifiers, in order, whose contained associations are expected to be rejected
	 */
	private void assertSubcomponents(String packageName, long expectedValue, String... errorClassifiers)
			throws Exception {
		var result = instantiate(packageName + EXTENSION, A_I, INSTANCE_NAME);
		var s3 = subcomponentS3(result.instance());
		assertEquals("s3", s3.getName());
		assertErrors(result.messages(), s3, containedAssociationErrors(packageName, errorClassifiers));
		assertPropertyValue(s3, expectedValue);
	}

	private void assertFeatures(int index, long expectedValue, String... errorClassifiers) throws Exception {
		var packageName = FEATURES + index;
		var result = instantiate(packageName + EXTENSION, A_I, INSTANCE_NAME);
		var f1 = subcomponentS3(result.instance()).getFeatureInstances().get(0);
		assertEquals("f1", f1.getName());
		assertErrors(result.messages(), f1, containedAssociationErrors(packageName, errorClassifiers));
		assertPropertyValue(f1, expectedValue);
	}

	private void assertFeatureGroups(int index, long expectedValue, String... errorClassifiers) throws Exception {
		var packageName = FEATURE_GROUP + index;
		var result = instantiate(packageName + EXTENSION, A_I, INSTANCE_NAME);
		var fg1 = subcomponentS3(result.instance()).getFeatureInstances().get(0);
		assertEquals("fg1", fg1.getName());
		var f1 = fg1.getFeatureInstances().get(0);
		assertEquals("f1", f1.getName());
		assertErrors(result.messages(), f1, containedAssociationErrors(packageName, errorClassifiers));
		assertPropertyValue(f1, expectedValue);
	}

	private void assertSemanticConnection(String packageName, String expectedError) throws Exception {
		var result = instantiate(packageName + EXTENSION, "whole.i", "whole_i_Instance");

		// Find the semantic connection, which is the only one
		var connection = onlyConnection(result.instance());
		assertErrors(result.messages(), connection, expectedError);
		assertPropertyValue(connection, 10L);
	}

	/** The instantiated system implementation and the messages reported while instantiating it. */
	private record Instantiation(SystemInstance instance, List<Message> messages) {
	}

	private Instantiation instantiate(String fileName, String implementationName, String expectedInstanceName)
			throws Exception {
		var pkg = testHelper.parseFile(PROJECT_LOCATION + fileName, PROJECT_LOCATION + TEST_PS);
		var implementation = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> implementationName.equals(classifier.getName()))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		var instance = InstantiateModel.instantiate(implementation, errorManager);
		assertEquals(expectedInstanceName, instance.getName());
		var reporter = (QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource());
		return new Instantiation(instance, reporter.getErrors());
	}

	/** Finds s1.s2.s3. */
	private static ComponentInstance subcomponentS3(SystemInstance instance) {
		return instance.getComponentInstances()
				.get(0)
				.getComponentInstances()
				.get(0)
				.getComponentInstances()
				.get(0);
	}

	private static void assertErrors(List<Message> messages, EObject where, String... expectedMessages) {
		assertEquals(expectedMessages.length, messages.size());
		for (var i = 0; i < expectedMessages.length; i++) {
			var message = messages.get(i);
			assertEquals(where, message.where);
			assertEquals(Kind.ERROR, message.kind);
			assertEquals(expectedMessages[i], message.message);
		}
	}

	private static void assertPropertyValue(NamedElement element, long expectedValue) {
		var associations = element.getOwnedPropertyAssociations();
		assertEquals(1, associations.size());
		var values = associations.getFirst().getOwnedValues();
		assertEquals(1, values.size());
		var value = values.getFirst().getOwnedValue();
		assertTrue(value instanceof IntegerLiteral);
		assertEquals(expectedValue, ((IntegerLiteral) value).getValue());
	}

	private static String[] containedAssociationErrors(String packageName, String... classifiers) {
		return Arrays.stream(classifiers)
				.map(classifier -> containedAssociationError(packageName + "::" + classifier))
				.toArray(String[]::new);
	}

	private static String containedAssociationError(String classifier) {
		return "Property association for \"TestPS::myProp\" is constant.  A contained property association in "
				+ "classifier \"" + classifier + "\" tries to replace it.";
	}
}
