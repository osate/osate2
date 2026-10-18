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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Locale;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.persistence.SerializableResourceDescription;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.RecordType;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.ElementHolder;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ForStatement;
import org.osate.xtext.aadl2.ba.behaviorAnnex.HashPropertyReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.NamedPropertyField;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyIndexPropertyReference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.PropertyReferenceTail;
import org.osate.xtext.aadl2.ba.behaviorAnnex.Reference;
import org.osate.xtext.aadl2.ba.behaviorAnnex.ReferenceSegment;
import org.osate.xtext.aadl2.ba.behaviorAnnex.UnindexedReferenceSegment;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator;

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
		var index = EcoreUtil2.getAllContentsOfType(annex,
				UnindexedReferenceSegment.class).getFirst();
		assertSame(variable, target(index, "name"));
		for (var segment : EcoreUtil2.getAllContentsOfType(annex, ReferenceSegment.class)) {
			var name = NodeModelUtils.getTokenText(NodeModelUtils.getNode(segment));
			var declaration = target(segment, "name");
			switch (name.toLowerCase(Locale.ROOT)) {
				case "counter" -> assertSame(variable, declaration);
				case "item" -> assertSame(iterator, declaration);
				case "self" -> assertSame(owner, declaration);
				case "input", "storage" -> assertSame(owner.findNamedElement(name), declaration);
				case "field" -> assertTrue(declaration instanceof DataSubcomponent);
				default -> throw new AssertionError(name);
			}
		}
	}

	@Test
	public void nestedIteratorsShadowVariablesIgnoringCase() throws Exception {
		var annex = parse("Scopes.aadl");
		var loops = EcoreUtil2.getAllContentsOfType(annex, ForStatement.class);
		var variable = annex.getVariableGroups().getFirst().getVariables().getFirst();
		var uses = EcoreUtil2.getAllContentsOfType(annex, ReferenceSegment.class).stream()
				.filter(segment -> "item"
						.equalsIgnoreCase(NodeModelUtils.getTokenText(NodeModelUtils.getNode(segment))))
				.toList();
		assertEquals(5, uses.size());
		var expected = List.of(variable, loops.get(0), loops.get(1), loops.get(0), variable);
		for (var i = 0; i < uses.size(); i++) {
			assertSame(expected.get(i), target(uses.get(i), "name"));
		}
	}

	@Test
	public void unresolvedMembersHaveNativeLinkingDiagnostics() throws Exception {
		var annex = parse();
		var resource = (XtextResource) annex.eResource();
		var text = resource.getParseResult().getRootNode().getText();
		var offset = text.indexOf("storage.field") + "storage.".length();
		resource.update(offset, "field".length(), "missing");
		var errors = validation.validate(resource).stream()
				.filter(issue -> Diagnostic.LINKING_DIAGNOSTIC.equals(issue.getCode()))
				.toList();
		assertEquals(errors.toString(), 1, errors.size());
		assertEquals(offset, errors.getFirst().getOffset().intValue());
		assertEquals("missing".length(), errors.getFirst().getLength().intValue());
		assertTrue(errors.getFirst().getMessage(), errors.getFirst().getMessage().contains("missing"));
	}

	@Test
	public void duplicateLocalNamesDoNotChooseAnArbitraryDeclaration() throws Exception {
		var annex = parse("Scopes.aadl");
		var resource = (XtextResource) annex.eResource();
		var text = resource.getParseResult().getRootNode().getText();
		resource.update(text.indexOf("result:"), "result".length(), "ITEM");
		var updated = (BehaviorAnnex) AnnexUtil.getAllDefaultAnnexSubclauses(
				(AadlPackage) resource.getContents().getFirst()).getFirst().getParsedAnnexSubclause();
		var use = EcoreUtil2.getAllContentsOfType(updated, ReferenceSegment.class).stream()
				.filter(segment -> "item".equals(NodeModelUtils.getTokenText(NodeModelUtils.getNode(segment))))
				.findFirst().orElseThrow();
		assertTrue(use.getName() == null || use.getName().eIsProxy());
		assertTrue(validation.validate(resource).stream()
				.anyMatch(issue -> Diagnostic.LINKING_DIAGNOSTIC.equals(issue.getCode())));
	}

	@Test
	public void serializesRenamedDeclarationsAndReparsesTheirUses() throws Exception {
		var annex = parse();
		annex.getVariableGroups().getFirst().getVariables().getFirst().setName("renamed_counter");
		var serializer = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createURI("serialize.baxtext"))
				.get(ISerializer.class);
		var serialized = serializer.serialize(annex);
		assertTrue(serialized, serialized.contains("renamed_counter"));
		var resource = (XtextResource) annex.eResource();
		var text = resource.getParseResult().getRootNode().getText();
		resource.update(text.indexOf("{**") + 3, text.indexOf("**}") - text.indexOf("{**") - 3, serialized);
		validation.assertNoIssues(resource);
		var updated = (BehaviorAnnex) AnnexUtil.getAllDefaultAnnexSubclauses(
				(AadlPackage) resource.getContents().getFirst()).getFirst().getParsedAnnexSubclause();
		var renamed = updated.getVariableGroups().getFirst().getVariables().getFirst();
		assertEquals("renamed_counter", renamed.getName());
		for (var segment : EcoreUtil2.getAllContentsOfType(updated, ReferenceSegment.class)) {
			if ("renamed_counter".equals(NodeModelUtils.getTokenText(NodeModelUtils.getNode(segment)))) {
				assertSame(renamed, target(segment, "name"));
			}
		}
	}

	@Inject
	private IResourceDescription.Manager descriptions;

	@Test
	public void propertyUsesSurviveIndexSerializationAndSourceUnload() throws Exception {
		var annex = parse();
		var reference = EcoreUtil2.getAllContentsOfType(annex, PropertyIndexPropertyReference.class).getFirst();
		var propertyURI = EcoreUtil.getURI(target(reference, "property"));
		var resource = annex.eResource();
		var bytes = new ByteArrayOutputStream();
		try (var stream = new ObjectOutputStream(bytes)) {
			stream.writeObject(SerializableResourceDescription.createCopy(
					descriptions.getResourceDescription(resource)));
		}
		resource.unload();
		try (var stream = new ObjectInputStream(new ByteArrayInputStream(bytes.toByteArray()))) {
			var description = (IResourceDescription) stream.readObject();
			var matches = StreamSupport.stream(description.getReferenceDescriptions().spliterator(), false)
					.filter(candidate -> propertyURI.equals(candidate.getTargetEObjectUri())).toList();
			assertEquals(1, matches.size());
			assertEquals("property", matches.getFirst().getEReference().getName());
			assertFalse(resource.isLoaded());
		}
	}

	@Test
	public void ownerAssociationPrecedesClassifierAssociationForAnUnqualifiedName() throws Exception {
		var annex = parse("AssociationFallback.aadl");
		var owner = annex.getContainingClassifier();
		var input = owner.findNamedElement("input");
		var expected = input.getOwnedPropertyAssociations().getFirst().getProperty();
		var reference = EcoreUtil2.getAllContentsOfType(annex, PropertyReferenceTail.class).getFirst();
		assertSame(expected, target(reference, "property"));
	}

	@Test
	public void translatingLinkedSelfReferencesDoesNotRequireSourceNodes() throws Exception {
		var annex = parse();
		var references = EcoreUtil2.getAllContentsOfType(annex,
				Reference.class);
		var self = references.stream().filter(reference -> "self.storage.field".equals(
				NodeModelUtils.getTokenText(NodeModelUtils.getNode(reference)))).findFirst().orElseThrow();
		var translator = new DeclarativeToStrictTranslator();
		var owner = (ComponentClassifier) annex.getContainingClassifier();
		var expected = EcoreUtil2.getAllContentsOfType(translator.translate(annex, owner).getStrict(self),
				ElementHolder.class).stream().map(ElementHolder::getElement).toList();
		var copy = EcoreUtil.copy(annex);
		var copiedSelf = EcoreUtil2.getAllContentsOfType(copy,
				Reference.class).get(references.indexOf(self));
		var actual = EcoreUtil2.getAllContentsOfType(translator.translate(copy, owner).getStrict(copiedSelf),
				ElementHolder.class).stream().map(ElementHolder::getElement).toList();
		assertEquals(expected, actual);
	}

	private BehaviorAnnex parse() throws Exception {
		return parse("Issue3331.aadl");
	}

	private BehaviorAnnex parse(String file) throws Exception {
		var root = helper.parseFile("org.osate.xtext.aadl2.ba.tests/models/issue3331/" + file,
				"org.osate.xtext.aadl2.ba.tests/models/issue3331/Issue3331_Properties.aadl",
				"org.osate.xtext.aadl2.ba.tests/models/issue3331/Issue3331_Other.aadl");
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
