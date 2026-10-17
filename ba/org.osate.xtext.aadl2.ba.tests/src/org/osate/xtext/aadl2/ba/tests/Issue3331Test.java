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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.RecordType;
import org.osate.annexsupport.AnnexUtil;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexPropertyReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Declaration uses must be linked in the declarative annex, independently of strict-model translation. */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexEmbeddedInjectorProvider.class)
public class Issue3331Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> helper;
	@Inject
	private ValidationTestHelper validation;

	@Test
	public void linksPropertyDeclarationsAndConstants() throws Exception {
		var annex = parse();
		var properties = EcoreUtil2.getAllContentsOfType(annex, HashPropertyReference.class);
		assertTrue(target(properties.getFirst(), "property") instanceof Property);
		var index = EcoreUtil2.getAllContentsOfType(annex, PropertyIndexPropertyReference.class).getFirst();
		assertTrue(target(index, "property") instanceof PropertyConstant);
		var tail = EcoreUtil2.getAllContentsOfType(annex, PropertyReferenceTail.class).getFirst();
		assertTrue(target(tail, "property") instanceof Property);
		var record = (Property) target(properties.getLast(), "property");
		var field = EcoreUtil2.getAllContentsOfType(annex, NamedPropertyField.class).getFirst();
		assertSame(((RecordType) record.getPropertyType()).getOwnedFields().getFirst(), target(field, "name"));
	}

	@Test
	public void linksVariablesIteratorsAndMemberPaths() throws Exception {
		var annex = parse();
		var variable = annex.getVariableGroups().getFirst().getVariables().getFirst();
		var owner = annex.getContainingClassifier();
		var iterator = EcoreUtil2.getAllContentsOfType(annex, ForStatement.class).getFirst();
		for (var segment : EcoreUtil2.getAllContentsOfType(annex, ReferenceSegment.class)) {
			var name = NodeModelUtils.getTokenText(NodeModelUtils.getNode(segment));
			var declaration = target(segment, "name");
			switch (name.toLowerCase(java.util.Locale.ROOT)) {
				case "counter" -> assertSame(variable, declaration);
				case "item" -> assertSame(iterator, declaration);
				case "self" -> assertSame(owner, declaration);
				case "input", "storage" -> assertSame(owner.findNamedElement(name), declaration);
				case "field" -> assertTrue(declaration instanceof org.osate.aadl2.DataSubcomponent);
				default -> throw new AssertionError(name);
			}
		}
	}

	private BehaviorAnnex parse() throws Exception {
		var root = helper.parseFile("org.osate.xtext.aadl2.ba.tests/models/issue3331/Issue3331.aadl",
				"org.osate.xtext.aadl2.ba.tests/models/issue3331/Issue3331_Properties.aadl");
		validation.assertNoIssues(root);
		return (BehaviorAnnex) AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst().getParsedAnnexSubclause();
	}

	private static EObject target(EObject source, String name) {
		var feature = source.eClass().getEStructuralFeature(name);
		assertTrue(source.eClass().getName() + "." + name + " must be a cross-reference", feature instanceof EReference);
		assertFalse(((EReference) feature).isContainment());
		assertTrue(source.eGet(feature) instanceof EObject);
		var target = (EObject) source.eGet(feature);
		assertFalse("Unresolved " + source.eClass().getName() + "." + name, target.eIsProxy());
		return target;
	}
}
