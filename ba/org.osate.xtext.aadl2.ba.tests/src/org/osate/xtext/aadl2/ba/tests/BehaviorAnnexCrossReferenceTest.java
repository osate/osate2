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
package org.osate.xtext.aadl2.ba.tests;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.SystemImplementation;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement;

import com.google.inject.Inject;

/**
 * Verifies the shared embedded-annex offset contract used by Eclipse hyperlinks and Xtext LSP definitions. Every
 * symbolic segment must resolve to its declaration, including nested paths, iterative variables, property-index
 * references, and {@code self}; ordinary Xtext cross-references must continue to resolve through the same helper.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexEmbeddedInjectorProvider.class)
public class BehaviorAnnexCrossReferenceTest {
	private static final String MODEL =
			"org.osate.xtext.aadl2.ba.tests/models/crossReferences/CrossReferences.aadl";
	private static final String PROPERTIES =
			"org.osate.xtext.aadl2.ba.tests/models/crossReferences/CrossReferenceProperties.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private EObjectAtOffsetHelper offsetHelper;

	@Test
	public void resolvesAllReferenceSegmentsForEclipseAndLsp() {
		var aadlPackage = testHelper.parseFile(MODEL, PROPERTIES);
		var implementation = aadlPackage.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(SystemImplementation.class::isInstance)
				.map(SystemImplementation.class::cast)
				.findFirst()
				.orElseThrow();
		var defaultAnnex = (DefaultAnnexSubclause) implementation.getOwnedAnnexSubclauses().get(0);
		var annex = (BehaviorAnnex) defaultAnnex.getParsedAnnexSubclause();
		var resource = (XtextResource) aadlPackage.eResource();
		var text = resource.getParseResult().getRootNode().getText();

		var variable = annex.getVariableGroups().get(0).getVariables().get(0);
		var states = annex.getStateGroups().stream().flatMap(group -> group.getStates().stream()).toList();
		var input = implementation.findNamedElement("input");
		var output = implementation.findNamedElement("output");
		var storage = (DataSubcomponent) implementation.findNamedElement("storage");
		var field = ((DataImplementation) storage.getDataSubcomponentType()).findNamedElement("field");
		var loop = EcoreUtil2.getAllContentsOfType(annex, ForStatement.class).get(0);

		assertReference(resource, text, "start: idle", "idle", states.get(0));
		assertReference(resource, text, "-> running", "running", states.get(1));
		assertReference(resource, text, "counter = input", "counter", variable);
		assertReference(resource, text, "counter = input", "input", input);
		assertReference(resource, text, "counter := storage.field", "counter", variable);
		assertReference(resource, text, "storage.field", "storage", storage);
		assertReference(resource, text, "storage.field", "field", field);
		assertReference(resource, text, "output!(counter)", "output", output);
		assertReference(resource, text, "output!(counter)", "counter", variable);
		assertReference(resource, text, "counter := item", "item", loop);
		assertReference(resource, text, "#CrossReferenceProperties::Values[counter]", "counter", variable);
		assertReference(resource, text, "self.input", "self", implementation);
		assertReference(resource, text, "self.input", "input", input);
	}

	private void assertReference(final XtextResource resource, final String text, final String marker,
			final String token, final EObject expected) {
		var markerOffset = text.indexOf(marker);
		assertTrue("Expected marker in the parsed resource: " + marker, markerOffset >= 0);
		var tokenOffset = text.indexOf(token, markerOffset);
		assertTrue("Expected token after marker: " + token, tokenOffset >= markerOffset);
		for (var offset = tokenOffset; offset < tokenOffset + token.length(); offset++) {
			assertSame("Eclipse hyperlink target for " + marker, expected,
					offsetHelper.resolveCrossReferencedElementAt(resource, offset));
			assertSame("LSP definition target for " + marker, expected, offsetHelper.getElementWithNameAt(resource, offset));
		}
	}
}
