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

/** Verifies exact generated Java for string. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class StringTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testString() throws Exception {
		var otherPs = """
				property set other_ps is
				\tother_string_type: type aadlstring;
				end other_ps;
				""";
		var stringTest = """
				property set string_test is
				\twith other_ps;
				\t
				\tlocal_string_type: type aadlstring;
				\t
				\towned_string: aadlstring applies to (all);
				\treferenced_string_local: string_test::local_string_type applies to (all);
				\treferenced_string_other: other_ps::other_string_type applies to (all);
				\t
				\tlist_1_string: list of other_ps::other_string_type applies to (all);
				\tlist_5_string: list of list of list of list of list of other_ps::other_string_type applies to (all);
				\t
				\tstring_constant: constant aadlstring => "constant value";
				\t
				\tlist_1_string_constant: constant list of aadlstring => (string_test::string_constant, "abc");
				\tlist_5_string_constant: constant list of list of list of list of list of aadlstring => ((((
				\t\t("one", "two", "three"),
				\t\t()
				\t))));
				end string_test;
				""";
		var stringTestClass = """
				package stringtest;

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
				import org.osate.aadl2.StringLiteral;
				import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
				import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;

				public final class StringTest {
				\tpublic static final String STRING_TEST__NAME = "string_test";

				\tprivate StringTest() {}

				\t// Lookup methods for string_test::owned_string

				\tpublic static final String OWNED_STRING__NAME = "owned_string";

				\tpublic static boolean acceptsOwnedString(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getOwnedString_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getOwnedString(NamedElement lookupContext) {
				\t\treturn getOwnedString(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getOwnedString(NamedElement lookupContext, Mode mode) {
				\t\treturn getOwnedString(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getOwnedString(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getOwnedString_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getOwnedString_Property(EObject lookupContext) {
				\t\tvar name = STRING_TEST__NAME + "::" + OWNED_STRING__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getOwnedString_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getOwnedString_Property(lookupContext));
				\t}

				\t// Lookup methods for string_test::referenced_string_local

				\tpublic static final String REFERENCED_STRING_LOCAL__NAME = "referenced_string_local";

				\tpublic static boolean acceptsReferencedStringLocal(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedStringLocal_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getReferencedStringLocal(NamedElement lookupContext) {
				\t\treturn getReferencedStringLocal(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getReferencedStringLocal(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedStringLocal(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getReferencedStringLocal(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedStringLocal_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedStringLocal_Property(EObject lookupContext) {
				\t\tvar name = STRING_TEST__NAME + "::" + REFERENCED_STRING_LOCAL__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedStringLocal_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedStringLocal_Property(lookupContext));
				\t}

				\t// Lookup methods for string_test::referenced_string_other

				\tpublic static final String REFERENCED_STRING_OTHER__NAME = "referenced_string_other";

				\tpublic static boolean acceptsReferencedStringOther(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferencedStringOther_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getReferencedStringOther(NamedElement lookupContext) {
				\t\treturn getReferencedStringOther(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getReferencedStringOther(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferencedStringOther(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getReferencedStringOther(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferencedStringOther_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getReferencedStringOther_Property(EObject lookupContext) {
				\t\tvar name = STRING_TEST__NAME + "::" + REFERENCED_STRING_OTHER__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferencedStringOther_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferencedStringOther_Property(lookupContext));
				\t}

				\t// Lookup methods for string_test::list_1_string

				\tpublic static final String LIST_1_STRING__NAME = "list_1_string";

				\tpublic static boolean acceptsList1String(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList1String_Property(lookupContext));
				\t}

				\tpublic static Optional<List<String>> getList1String(NamedElement lookupContext) {
				\t\treturn getList1String(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<String>> getList1String(NamedElement lookupContext, Mode mode) {
				\t\treturn getList1String(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<String>> getList1String(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList1String_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((StringLiteral) resolved1).getValue();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList1String_Property(EObject lookupContext) {
				\t\tvar name = STRING_TEST__NAME + "::" + LIST_1_STRING__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList1String_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList1String_Property(lookupContext));
				\t}

				\t// Lookup methods for string_test::list_5_string

				\tpublic static final String LIST_5_STRING__NAME = "list_5_string";

				\tpublic static boolean acceptsList5String(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getList5String_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<List<List<List<String>>>>>> getList5String(NamedElement lookupContext) {
				\t\treturn getList5String(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<List<List<List<String>>>>>> getList5String(NamedElement lookupContext, Mode mode) {
				\t\treturn getList5String(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<List<List<List<String>>>>>> getList5String(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getList5String_Property(lookupContext);
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
				\t\t\t\t\t\t\t\treturn ((StringLiteral) resolved5).getValue();
				\t\t\t\t\t\t\t}).toList();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getList5String_Property(EObject lookupContext) {
				\t\tvar name = STRING_TEST__NAME + "::" + LIST_5_STRING__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getList5String_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getList5String_Property(lookupContext));
				\t}

				\t// Lookup methods for string_test::string_constant

				\tpublic static final String STRING_CONSTANT__NAME = "string_constant";

				\tpublic static String getStringConstant(EObject lookupContext) {
				\t\tvar constant = getStringConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((StringLiteral) resolved).getValue();
				\t}

				\tpublic static PropertyConstant getStringConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = STRING_TEST__NAME + "::" + STRING_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for string_test::list_1_string_constant

				\tpublic static final String LIST_1_STRING_CONSTANT__NAME = "list_1_string_constant";

				\tpublic static List<String> getList1StringConstant(EObject lookupContext) {
				\t\tvar constant = getList1StringConstant_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\treturn ((StringLiteral) resolved1).getValue();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList1StringConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = STRING_TEST__NAME + "::" + LIST_1_STRING_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for string_test::list_5_string_constant

				\tpublic static final String LIST_5_STRING_CONSTANT__NAME = "list_5_string_constant";

				\tpublic static List<List<List<List<List<String>>>>> getList5StringConstant(EObject lookupContext) {
				\t\tvar constant = getList5StringConstant_PropertyConstant(lookupContext);
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
				\t\t\t\t\t\t\treturn ((StringLiteral) resolved5).getValue();
				\t\t\t\t\t\t}).toList();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t}).toList();
				\t\t}).toList();
				\t}

				\tpublic static PropertyConstant getList5StringConstant_PropertyConstant(EObject lookupContext) {
				\t\tvar name = STRING_TEST__NAME + "::" + LIST_5_STRING_CONSTANT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(stringTest, otherPs));
		assertEquals("src-gen/stringtest", results.getPackagePath());
		assertEquals(1, results.getClasses().size());

		assertEquals("StringTest.java", results.getClasses().getFirst().getFileName());
		assertEquals(stringTestClass, results.getClasses().getFirst().getContents());
	}
}
