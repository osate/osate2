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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;
import org.osate.xtext.aadl2.scoping.Aadl2ReferenceScopeProvider;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/** Characterizes property references while retiring the custom properties linker. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3323Test extends XtextTest {
	private static final String PATH = "org.osate.core.tests/models/issue3323/";

	@Inject
	private TestHelper<AadlPackage> testHelper;
	@Inject
	private ValidationTestHelper validationHelper;
	@Inject
	private ISerializer serializer;
	@Inject
	private PropertiesLinkingService linkingService;
	@Inject
	private Aadl2ReferenceScopeProvider scopeProvider;

	@Test
	public void propertyTypesConstantsAndPredeclaredNamesResolve() throws Exception {
		var pkg = parse();
		var set = properties(pkg);
		var associations = system(pkg).getOwnedPropertyAssociations();
		assertSame(set.findNamedElement("Outer"), associations.get(0).getProperty().getPropertyType());
		assertSame(set.findNamedElement("Selected"),
				((NamedValue) associations.get(1).getOwnedValues().getFirst().getOwnedValue()).getNamedValue());
		assertSame(set.findNamedElement("Count"),
				((NamedValue) associations.get(3).getOwnedValues().getFirst().getOwnedValue()).getNamedValue());
		assertEquals("Timing_Properties::Period", associations.get(4).getProperty().getQualifiedName());
	}

	@Test
	public void literalsAndRecordFieldsUseTheirContainingType() throws Exception {
		var pkg = parse();
		var set = properties(pkg);
		var outer = (RecordType) set.findNamedElement("Outer");
		var inner = (RecordType) set.findNamedElement("Inner");
		var choice = (EnumerationType) set.findNamedElement("Choice");
		var value = (RecordValue) system(pkg).getOwnedPropertyAssociations().getFirst()
				.getOwnedValues().getFirst().getOwnedValue();
		var innerField = value.getOwnedFieldValues().getFirst();
		assertSame(outer.getOwnedFields().getFirst(), innerField.getProperty());
		var innerValue = (RecordValue) innerField.getOwnedValue();
		assertSame(inner.getOwnedFields().getFirst(), innerValue.getOwnedFieldValues().getFirst().getProperty());
		var literal = (NamedValue) innerValue.getOwnedFieldValues().getFirst().getOwnedValue();
		assertSame(choice.getOwnedLiterals().getFirst(), literal.getNamedValue());
	}

	@Test
	public void unitsResolveInBoundsRecordsListsRangesAndDefaults() throws Exception {
		var pkg = parse();
		var set = properties(pkg);
		var units = (UnitsType) set.findNamedElement("U");
		assertSame(units.getOwnedLiterals().getFirst(), ((UnitLiteral) units.getOwnedLiterals().get(1)).getBaseUnit());
		int count = 0;
		for (var root : List.of(pkg, set)) {
			for (var number : EcoreUtil2.getAllContentsOfType(root, NumberValue.class)) {
				if (number.getUnit() != null && !"ms".equals(number.getUnit().getName())) {
					assertSame(units, number.getUnit().getOwner());
					count++;
				}
			}
		}
		assertTrue("Exercise every numeric value context", count >= 12);
	}

	@Test
	public void propertiesLinkerAndReferenceScopesSelectTheSameTargets() throws Exception {
		var pkg = parse();
		linkingService.setScopeProvider(scopeProvider);
		int count = 0;
		for (var root : List.of(pkg, properties(pkg))) {
			for (var object : EcoreUtil2.getAllContentsOfType(root, EObject.class)) {
				for (var reference : object.eClass().getEAllReferences()) {
					if (reference.isContainment() || reference.isContainer() || reference.isMany()) {
						continue;
					}
					for (var node : NodeModelUtils.findNodesForFeature(object, reference)) {
						assertEquals(node.getText(), List.of(object.eGet(reference)),
								linkingService.getLinkedObjects(object, reference, node));
						count++;
					}
				}
			}
		}
		assertTrue("Exercise parsed property cross references", count >= 30);
	}

	@Test
	public void serializationPreservesPropertyTargets() throws Exception {
		var pkg = parse();
		var reparsed = testHelper.parseString(serializer.serialize(pkg), serializer.serialize(properties(pkg)));
		validationHelper.assertNoIssues(reparsed);
		validationHelper.assertNoIssues(properties(reparsed));
		assertSame(properties(reparsed).findNamedElement("Count"),
				((NamedValue) system(reparsed).getOwnedPropertyAssociations().get(3)
						.getOwnedValues().getFirst().getOwnedValue()).getNamedValue());
	}

	private AadlPackage parse() throws Exception {
		var pkg = testHelper.parseFile(PATH + "Client.aadl", PATH + "Issue3323.aadl");
		validationHelper.assertNoIssues(pkg);
		validationHelper.assertNoIssues(properties(pkg));
		return pkg;
	}

	private static SystemType system(AadlPackage pkg) {
		return (SystemType) pkg.getPublicSection().getOwnedClassifiers().getFirst();
	}

	private static PropertySet properties(AadlPackage pkg) {
		return pkg.getPublicSection().getImportedUnits().stream().filter(PropertySet.class::isInstance)
				.map(PropertySet.class::cast).filter(set -> "Issue3323".equals(set.getName())).findFirst().orElseThrow();
	}
}
