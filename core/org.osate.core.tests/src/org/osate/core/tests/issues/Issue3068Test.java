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
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3068Test extends XtextTest {
	private static final String PATH = "org.osate.core.tests/models/issue3068/";
	private static final String MODEL = PATH + "Issue3068.aadl";
	private static final String EXTRA_PATTERNS = PATH + "ExtraPatterns.aadl";

	private static final String UNSUPPORTED_PATTERN = "Even_To_Odd";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * A {@code Connection_Pattern} literal that the instantiator does not know must be reported. Today
	 * {@code InstantiateModel.interpretConnectionPatterns()} compares the literal name against fourteen
	 * hard-coded names; when none matches it falls off the end of the chain and returns its initial
	 * {@code true}, which the caller reads as "the connection was expanded". The provisional connection
	 * instance is then deleted while nothing was created in its place, and no diagnostic is produced.
	 * <p>
	 * The literal comes from a separate property set rather than from
	 * {@code AADL_Project::Supported_Connection_Patterns}, and it is put in place after validation. Both
	 * are deliberate. All fourteen predeclared literals are handled, so the only way to reach this path
	 * is a project that extends that enumeration, and the test harness loads the plugin-contributed
	 * predeclared property sets, which a test model project cannot override. Substituting the literal on
	 * the parsed model reproduces exactly what such a project would hand to instantiation: a
	 * {@code NamedValue} whose {@code EnumerationLiteral} has a name the chain does not match.
	 */
	@Test
	public void unsupportedConnectionPatternIsReported() throws Exception {
		var pkg = testHelper.parseFile(MODEL, EXTRA_PATTERNS);
		validationHelper.assertNoIssues(pkg);
		var top = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Top.i"))
				.findFirst()
				.orElseThrow();
		substitutePatternLiteral(top, unsupportedLiteral(pkg));
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		var instance = InstantiateModel.instantiate(top, errorManager);

		var messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors()
				.stream()
				.map(message -> message.message)
				.toList();
		assertTrue("Instantiation reported nothing about the unsupported connection pattern: " + messages,
				messages.stream().anyMatch(message -> message.contains(UNSUPPORTED_PATTERN)));
	}

	/**
	 * Returns the literal of {@code ExtraPatterns}, which stands in for a literal added to
	 * {@code AADL_Project::Supported_Connection_Patterns} by a project.
	 */
	private EnumerationLiteral unsupportedLiteral(AadlPackage pkg) {
		var extraPatterns = pkg.eResource()
				.getResourceSet()
				.getResources()
				.stream()
				.flatMap(resource -> resource.getContents().stream())
				.filter(PropertySet.class::isInstance)
				.map(PropertySet.class::cast)
				.filter(propertySet -> propertySet.getName().equals("ExtraPatterns"))
				.findFirst()
				.orElseThrow();
		var literal = ((EnumerationType) extraPatterns.getOwnedPropertyTypes().get(0)).getOwnedLiterals().get(0);
		assertEquals("The fixture no longer supplies the unsupported literal", UNSUPPORTED_PATTERN, literal.getName());
		return literal;
	}

	/**
	 * Replaces the enumeration literal of the connection's {@code Connection_Pattern} value, leaving the
	 * property association, its value structure and its property reference as they were parsed.
	 */
	private void substitutePatternLiteral(ComponentImplementation top, EnumerationLiteral literal) {
		var connection = top.getOwnedConnections()
				.stream()
				.filter(owned -> owned.getName().equals("c"))
				.findFirst()
				.orElseThrow();
		var pattern = (ListValue) connection.getOwnedPropertyAssociations()
				.get(0)
				.getOwnedValues()
				.get(0)
				.getOwnedValue();
		var dimension = (ListValue) pattern.getOwnedListElements().get(0);
		((NamedValue) dimension.getOwnedListElements().get(0)).setNamedValue(literal);
	}
}
