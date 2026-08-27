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
 * aries to this license with respect to the terms applicable to the Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Message;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * A contained property association with an unresolvable reference must report the problem whether
 * the association applies to a component or to a connection.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3106Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3106/Issue3106.aadl";
	private static final String ERROR = "Referenced element does not exist in the instance model";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void aMissingReferenceIsReportedForBothComponentAndConnectionAssociations() throws Exception {
		var result = instantiate("top.refined_platform");
		var sender = result.instance().getComponentInstances()
				.stream()
				.filter(component -> component.getName().equals("snd"))
				.findFirst()
				.orElseThrow();
		var connection = result.instance().getConnectionInstances().getFirst();

		assertEquals(List.of("platform", "core"), declarativeReferencePath(sender.getOwnedPropertyAssociations()
				.stream()
				.filter(association -> association.getProperty().getName().equals("Actual_Processor_Binding"))
				.findFirst()
				.orElseThrow()));
		assertEquals(List.of("platform", "core"), declarativeReferencePath(connection.getOwnedPropertyAssociations()
				.stream()
				.filter(association -> association.getProperty().getName().equals("Actual_Connection_Binding"))
				.findFirst()
				.orElseThrow()));
		assertEquals(2, result.errors().size());
		assertTrue(result.errors().stream().allMatch(message -> message.kind == QueuingAnalysisErrorReporter.Kind.ERROR));
		assertEquals(List.of(ERROR, ERROR), result.errors().stream().map(message -> message.message).toList());
	}

	@Test
	public void resolvableReferencesProduceNoInstantiationErrors() throws Exception {
		assertEquals(List.of(), instantiate("top.impl").errors());
	}

	private Result instantiate(String implementationName) throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var implementation = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals(implementationName))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		var instance = InstantiateModel.instantiate(implementation, errorManager);
		var reporter = (QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource());

		return new Result(instance, reporter.getErrors());
	}

	private static List<String> declarativeReferencePath(PropertyAssociation association) {
		var list = (ListValue) association.getOwnedValues().getFirst().getOwnedValue();
		var reference = (ReferenceValue) list.getOwnedListElements().getFirst();

		return reference.getContainmentPathElements()
				.stream()
				.map(element -> element.getNamedElement().getName())
				.toList();
	}

	private record Result(SystemInstance instance, List<Message> errors) {
	}
}
