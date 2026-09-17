/*******************************************************************************
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
package org.osate.propertiescodegen.tests;

import static org.junit.Assert.assertEquals;
import static org.osate.propertiescodegen.tests.GeneratedJavaCompiler.generateAndCompile;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.PropertySet;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

/** Verifies exact generated Java for enumeration. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class EnumerationTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testEnumeration() throws Exception {
		var otherPs = """
				property set other_ps is
				\tother_enumeration_type: type enumeration (one, two, three);
				end other_ps;
				""";
		var enumerationTest = """
				property set enumeration_test is
				\twith other_ps;
				\t
				\tlocal_enumeration_type: type enumeration (a, b, c);
				\t
				\towned_enumeration: enumeration (x, y, z) applies to (all);
				\treferenced_enumeration_local: enumeration_test::local_enumeration_type applies to (all);
				\treferenced_enumeration_other: other_ps::other_enumeration_type applies to (all);
				\t
				\tlist_1_enumeration: list of enumeration (red, green, blue) applies to (all);
				\tlist_3_enumeration: list of list of list of enumeration_test::local_enumeration_type applies to (all);
				\tlist_5_enumeration: list of list of list of list of list of other_ps::other_enumeration_type applies to (all);
				\t
				\towned_constant: constant enumeration (canada, usa, mexico) => canada;
				\treferenced_local_constant: constant enumeration_test::local_enumeration_type => a;
				\treferenced_other_constant: constant other_ps::other_enumeration_type => one;
				\t
				\tlist_1_constant: constant list of enumeration (mac, linux, windows) => (mac, linux);
				\tlist_3_constant: constant list of list of list of enumeration_test::local_enumeration_type => (((a, b), ()));
				\tlist_5_constant: constant list of list of list of list of list of other_ps::other_enumeration_type => ((((
				\t\t(one, two),
				\t\t(three),
				\t\t()
				\t))));
				end enumeration_test;
				""";
		var enumerationTestClass = """
				package enumerationtest;

				import java.util.List;
				import java.util.Optional;

				import org.eclipse.emf.ecore.EObject;
				import org.osate.aadl2.Aadl2Package;
				import org.osate.aadl2.ListValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.Property;
				import org.osate.aadl2.PropertyConstant;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
				import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;

				import otherps.OtherEnumerationType;

				public final class EnumerationTest {
				\tpublic static final String ENUMERATION_TEST__NAME = "enumeration_test";

				\tprivate EnumerationTest() {}

				\t// Lookup methods for enumeration_test::owned_enumeration

				\tpublic static final String OWNED_ENUMERATION__NAME = "owned_enumeration";

				\tpublic static boolean acceptsOwnedEnumeration(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getOwnedEnumeration_Property(lookupContext));
				\t}

				\tpublic static Optional<OwnedEnumeration> getOwnedEnumeration(NamedElement lookupContext) {
				\t\treturn getOwnedEnumeration(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<OwnedEnumeration> getOwnedEnumeration(NamedElement lookupContext, Mode mode) {
				\t\treturn getOwnedEnumeration(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<OwnedEnumeration> getOwnedEnumeration(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getOwnedEnumeration_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(OwnedEnumeration.valueOf(resolved));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getOwnedEnumeration_Property(EObject lookupContext) {
				\t\tvar name = ENUMERATION_TEST__NAME + "::" + OWNED_ENUMERATION__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getOwnedEnumeration_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getOwnedEnumeration_Property(lookupContext));
				\t}

				\t// Lookup methods for enumeration_test::referenced_enumeration_local

				\tpublic static final String REFERENCED_ENUMERATION_LOCAL__NAME = "referenced_enumeration_local";

				\tpublic static boolean acceptsReferencedEnumerationLocal(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedEnumerationLocal_Property(lookupContext));
				\t}

				\tpublic static Optional<LocalEnumerationType> getReferencedEnumerationLocal(NamedElement lookupContext) {
				\t\treturn getReferencedEnumerationLocal(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<LocalEnumerationType> getReferencedEnumerationLocal(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedEnumerationLocal(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<LocalEnumerationType> getReferencedEnumerationLocal(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedEnumerationLocal_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(LocalEnumerationType.valueOf(resolved));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedEnumerationLocal_Property(EObject lookupContext) {
				\t\tvar name = ENUMERATION_TEST__NAME + "::" + REFERENCED_ENUMERATION_LOCAL__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedEnumerationLocal_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedEnumerationLocal_Property(lookupContext));
				\t}

				\t// Lookup methods for enumeration_test::referenced_enumeration_other

				\tpublic static final String REFERENCED_ENUMERATION_OTHER__NAME = "referenced_enumeration_other";

				\tpublic static boolean acceptsReferencedEnumerationOther(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedEnumerationOther_Property(lookupContext));
				\t}

				\tpublic static Optional<OtherEnumerationType> getReferencedEnumerationOther(NamedElement lookupContext) {
				\t\treturn getReferencedEnumerationOther(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<OtherEnumerationType> getReferencedEnumerationOther(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedEnumerationOther(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<OtherEnumerationType> getReferencedEnumerationOther(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedEnumerationOther_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(OtherEnumerationType.valueOf(resolved));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedEnumerationOther_Property(EObject lookupContext) {
				\t\tvar name = ENUMERATION_TEST__NAME + "::" + REFERENCED_ENUMERATION_OTHER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedEnumerationOther_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedEnumerationOther_Property(lookupContext));
				\t}

				\t// Lookup methods for enumeration_test::list_1_enumeration

				\tpublic static final String LIST_1_ENUMERATION__NAME = "list_1_enumeration";

				\tpublic static boolean acceptsList1Enumeration(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1Enumeration_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List1Enumeration>> getList1Enumeration(NamedElement lookupContext) {
				\t\treturn getList1Enumeration(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List1Enumeration>> getList1Enumeration(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1Enumeration(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List1Enumeration>> getList1Enumeration(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1Enumeration_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn List1Enumeration.valueOf(resolved1);
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1Enumeration_Property(EObject lookupContext) {
				\t\tvar name = ENUMERATION_TEST__NAME + "::" + LIST_1_ENUMERATION__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1Enumeration_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1Enumeration_Property(lookupContext));
				\t}

				\t// Lookup methods for enumeration_test::list_3_enumeration

				\tpublic static final String LIST_3_ENUMERATION__NAME = "list_3_enumeration";

				\tpublic static boolean acceptsList3Enumeration(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList3Enumeration_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<LocalEnumerationType>>>> getList3Enumeration(NamedElement lookupContext) {
				\t\treturn getList3Enumeration(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<LocalEnumerationType>>>> getList3Enumeration(NamedElement lookupContext, Mode mode) {
				\t\treturn getList3Enumeration(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<LocalEnumerationType>>>> getList3Enumeration(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList3Enumeration_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\treturn LocalEnumerationType.valueOf(resolved3);
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList3Enumeration_Property(EObject lookupContext) {
				\t\tvar name = ENUMERATION_TEST__NAME + "::" + LIST_3_ENUMERATION__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList3Enumeration_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList3Enumeration_Property(lookupContext));
				\t}

				\t// Lookup methods for enumeration_test::list_5_enumeration

				\tpublic static final String LIST_5_ENUMERATION__NAME = "list_5_enumeration";

				\tpublic static boolean acceptsList5Enumeration(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList5Enumeration_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<List<List<OtherEnumerationType>>>>>> getList5Enumeration(NamedElement lookupContext) {
				\t\treturn getList5Enumeration(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<List<List<OtherEnumerationType>>>>>> getList5Enumeration(NamedElement lookupContext, Mode mode) {
				\t\treturn getList5Enumeration(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<List<List<OtherEnumerationType>>>>>> getList5Enumeration(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList5Enumeration_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
				\t\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
				\t\t\t\t\t\t\treturn ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
				\t\t\t\t\t\t\t\tvar resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
				\t\t\t\t\t\t\t\treturn OtherEnumerationType.valueOf(resolved5);
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList5Enumeration_Property(EObject lookupContext) {
				\t\tvar name = ENUMERATION_TEST__NAME + "::" + LIST_5_ENUMERATION__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList5Enumeration_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList5Enumeration_Property(lookupContext));
				\t}

				\t// Lookup methods for enumeration_test::owned_constant

				\tpublic static final String OWNED_CONSTANT__NAME = "owned_constant";

				\tpublic static OwnedConstant getOwnedConstant(EObject lookupContext) {
				\t\tvar constant = getOwnedConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn OwnedConstant.valueOf(resolved);
				\t}

				\tpublic static PropertyConstant getOwnedConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = ENUMERATION_TEST__NAME + "::" + OWNED_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for enumeration_test::referenced_local_constant

				\tpublic static final String REFERENCED_LOCAL_CONSTANT__NAME = "referenced_local_constant";

				\tpublic static LocalEnumerationType getReferencedLocalConstant(EObject lookupContext) {
				\t\tvar constant = getReferencedLocalConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn LocalEnumerationType.valueOf(resolved);
				\t}

				\tpublic static PropertyConstant getReferencedLocalConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = ENUMERATION_TEST__NAME + "::" + REFERENCED_LOCAL_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for enumeration_test::referenced_other_constant

				\tpublic static final String REFERENCED_OTHER_CONSTANT__NAME = "referenced_other_constant";

				\tpublic static OtherEnumerationType getReferencedOtherConstant(EObject lookupContext) {
				\t\tvar constant = getReferencedOtherConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn OtherEnumerationType.valueOf(resolved);
				\t}

				\tpublic static PropertyConstant getReferencedOtherConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = ENUMERATION_TEST__NAME + "::" + REFERENCED_OTHER_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for enumeration_test::list_1_constant

				\tpublic static final String LIST_1_CONSTANT__NAME = "list_1_constant";

				\tpublic static List<List1Constant> getList1Constant(EObject lookupContext) {
				\t\tvar constant = getList1Constant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn List1Constant.valueOf(resolved1);
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1Constant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = ENUMERATION_TEST__NAME + "::" + LIST_1_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for enumeration_test::list_3_constant

				\tpublic static final String LIST_3_CONSTANT__NAME = "list_3_constant";

				\tpublic static List<List<List<LocalEnumerationType>>> getList3Constant(EObject lookupContext) {
				\t\tvar constant = getList3Constant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3);
				\t\t\t\t\treturn LocalEnumerationType.valueOf(resolved3);
				\t\t\t\t}).toList();
				\t\t\t}).toList();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList3Constant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = ENUMERATION_TEST__NAME + "::" + LIST_3_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for enumeration_test::list_5_constant

				\tpublic static final String LIST_5_CONSTANT__NAME = "list_5_constant";

				\tpublic static List<List<List<List<List<OtherEnumerationType>>>>> getList5Constant(EObject lookupContext) {
				\t\tvar constant = getList5Constant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\treturn ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
				\t\t\t\t\tvar resolved3 = CodeGenUtil.resolveNamedValue(element3);
				\t\t\t\t\treturn ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
				\t\t\t\t\t\tvar resolved4 = CodeGenUtil.resolveNamedValue(element4);
				\t\t\t\t\t\treturn ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
				\t\t\t\t\t\t\tvar resolved5 = CodeGenUtil.resolveNamedValue(element5);
				\t\t\t\t\t\t\treturn OtherEnumerationType.valueOf(resolved5);
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList5Constant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = ENUMERATION_TEST__NAME + "::" + LIST_5_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}
				}
				""";
		var localEnumerationType = """
				package enumerationtest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.pluginsupport.properties.GeneratedEnumeration;

				public enum LocalEnumerationType implements GeneratedEnumeration {
				\tA("a", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				\tB("b", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				\tC("c", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2");

				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate LocalEnumerationType(String originalName, String uri) {
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static LocalEnumerationType valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var ownedEnumeration = """
				package enumerationtest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.pluginsupport.properties.GeneratedEnumeration;

				public enum OwnedEnumeration implements GeneratedEnumeration {
				\tX("x", "__synthetic1.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedLiteral.0"),
				\tY("y", "__synthetic1.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedLiteral.1"),
				\tZ("z", "__synthetic1.aadl#/0/@ownedProperty.0/@ownedPropertyType/@ownedLiteral.2");

				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate OwnedEnumeration(String originalName, String uri) {
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static OwnedEnumeration valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var list1Enumeration = """
				package enumerationtest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.pluginsupport.properties.GeneratedEnumeration;

				public enum List1Enumeration implements GeneratedEnumeration {
				\tRED("red", "__synthetic1.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
				\tGREEN("green", "__synthetic1.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedElementType/@ownedLiteral.1"),
				\tBLUE("blue", "__synthetic1.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedElementType/@ownedLiteral.2");

				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate List1Enumeration(String originalName, String uri) {
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static List1Enumeration valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var ownedConstant = """
				package enumerationtest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.pluginsupport.properties.GeneratedEnumeration;

				public enum OwnedConstant implements GeneratedEnumeration {
				\tCANADA("canada", "__synthetic1.aadl#/0/@ownedPropertyConstant.0/@ownedPropertyType/@ownedLiteral.0"),
				\tUSA("usa", "__synthetic1.aadl#/0/@ownedPropertyConstant.0/@ownedPropertyType/@ownedLiteral.1"),
				\tMEXICO("mexico", "__synthetic1.aadl#/0/@ownedPropertyConstant.0/@ownedPropertyType/@ownedLiteral.2");

				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate OwnedConstant(String originalName, String uri) {
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static OwnedConstant valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var list1Constant = """
				package enumerationtest;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.pluginsupport.properties.GeneratedEnumeration;

				public enum List1Constant implements GeneratedEnumeration {
				\tMAC("mac", "__synthetic1.aadl#/0/@ownedPropertyConstant.3/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
				\tLINUX("linux", "__synthetic1.aadl#/0/@ownedPropertyConstant.3/@ownedPropertyType/@ownedElementType/@ownedLiteral.1"),
				\tWINDOWS("windows", "__synthetic1.aadl#/0/@ownedPropertyConstant.3/@ownedPropertyType/@ownedElementType/@ownedLiteral.2");

				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate List1Constant(String originalName, String uri) {
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static List1Constant valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic URI getURI() {
				\t\treturn uri;
				\t}

				\t@Override
				\tpublic String toString() {
				\t\treturn originalName;
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(enumerationTest, otherPs));
		assertEquals("src-gen/enumerationtest", results.getPackagePath());
		assertEquals(6, results.getClasses().size());

		assertEquals("EnumerationTest.java", results.getClasses().get(0).getFileName());
		assertEquals(enumerationTestClass, results.getClasses().get(0).getContents());

		assertEquals("LocalEnumerationType.java", results.getClasses().get(1).getFileName());
		assertEquals(localEnumerationType, results.getClasses().get(1).getContents());

		assertEquals("OwnedEnumeration.java", results.getClasses().get(2).getFileName());
		assertEquals(ownedEnumeration, results.getClasses().get(2).getContents());

		assertEquals("List1Enumeration.java", results.getClasses().get(3).getFileName());
		assertEquals(list1Enumeration, results.getClasses().get(3).getContents());

		assertEquals("OwnedConstant.java", results.getClasses().get(4).getFileName());
		assertEquals(ownedConstant, results.getClasses().get(4).getContents());

		assertEquals("List1Constant.java", results.getClasses().get(5).getFileName());
		assertEquals(list1Constant, results.getClasses().get(5).getContents());
	}
}
