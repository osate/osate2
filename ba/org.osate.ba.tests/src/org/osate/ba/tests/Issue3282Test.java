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
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Property;
import org.osate.aadl2.StringLiteral;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.PropertyReference;
import org.osate.ba.utils.AadlBaUtils;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Exercises naming a Data Model Annex enumeration literal from a Behavior Annex expression. An enumerator is a string
 * literal inside a {@code Data_Model::Enumerators} association rather than a declared AADL enumeration literal, and
 * AS5506/3 Rev A D.7 leaves a prefixed property reference as the only form that can name one.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3282Test extends XtextTest {
	private static final String PATH = "org.osate.ba.tests/models/issue3282/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void enumeratorReferencesAreAccepted() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(PATH + "Issue3282.aadl"));
	}

	/**
	 * Absence of diagnostics alone does not show that the enumerator was understood, because an aborted checker also
	 * reports nothing. Assert the resolved element and the computed type directly. The first holder must still carry the
	 * {@code Enumerators} property definition rather than the association selected while translating, preserving #3222.
	 */
	@Test
	public void enumeratorReferencesResolveToTheirLiteralAndType() throws Exception {
		var pkg = testHelper.parseFile(PATH + "Issue3282.aadl");
		var subclause = AnnexUtil.getAllDefaultAnnexSubclauses(pkg)
				.stream()
				.filter(annex -> annex.getContainingClassifier().getName().equals("host.impl"))
				.findFirst()
				.orElseThrow();
		var owner = (ComponentClassifier) subclause.getContainingClassifier();
		var annex = BehaviorAnnexUtil.getStrictModel(subclause);

		var resolved = new ArrayList<String>();
		for (var contents = EcoreUtil.getAllContents(annex, true); contents.hasNext();) {
			if (contents.next() instanceof PropertyReference reference) {
				var holders = reference.getProperties();
				assertEquals(reference.toString(), 2, holders.size());
				var property = holders.getFirst().getProperty().getElement();
				assertTrue(String.valueOf(property), property instanceof Property);
				assertEquals("Data_Model::Enumerators", ((Property) property).getQualifiedName());
				var element = holders.getLast().getProperty().getElement();
				assertTrue(String.valueOf(element), element instanceof StringLiteral);
				resolved.add(((StringLiteral) element).getValue() + " : "
						+ AadlBaUtils.getTypeHolder(reference, owner));
			}
		}

		// Containment order follows the strict metamodel's features rather than the source, so compare as a sorted bag.
		// An anonymous data subcomponent declares the enumeration on itself, so those two enumerators have no
		// classifier and carry the enumeration representation alone.
		resolved.sort(null);
		assertEquals(List.of("Closing : Issue3282::direction_type", "Closing : Issue3282::direction_type",
				"Closing : Issue3282::direction_type", "Falling : enumeration", "Opening : Issue3282::direction_type",
				"Opening : Issue3282::direction_type", "Rising : enumeration"), resolved);
	}

	/**
	 * An unresolvable enumerator must be reported rather than abort the checkers, so the three diagnostics after it are
	 * the evidence that validation continues.
	 */
	@Test
	public void invalidEnumeratorReferencesAreReported() throws Exception {
		assertDiagnostics("InvalidEnumerators", List.of(
				new Expected(".NotAnEnumerator",
						"'NotAnEnumerator' is not an enumerator of 'InvalidEnumerators::direction_type'"),
				new Expected("signal_type#Data_Model::Enumerators.Rising",
						"type error for 'assignment', 'InvalidEnumerators::direction_type' expected, found 'InvalidEnumerators::signal_type'."),
				new Expected("direction_type#Data_Model::Enumerators.Opening + 1",
						"Invalid operand types for operator \"+\": left operand has type InvalidEnumerators::direction_type, right operand has type universal integer"),
				new Expected("other_value",
						"type error for 'assignment', 'InvalidEnumerators::int_type' expected, found 'InvalidEnumerators::signal_type'.")));
	}

	private void assertDiagnostics(String model, List<Expected> expected) throws Exception {
		var root = testHelper.parseFile(PATH + model + ".aadl");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		assertEquals(issues.toString(), expected.size(), issues.size());
		assertEquals(expected, issues.stream().map(issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			return new Expected(source.substring(issue.getOffset(), issue.getOffset() + issue.getLength()),
					issue.getMessage());
		}).toList());
	}

	private record Expected(String target, String message) {
	}
}
