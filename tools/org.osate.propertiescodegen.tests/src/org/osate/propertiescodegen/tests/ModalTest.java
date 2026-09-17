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

/** Verifies exact generated Java for modal. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ModalTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testModal() throws Exception {
		var modalTest = """
				property set modal_test is
				\tstring_const_1: constant aadlstring => "First Constant Value";
				\tstring_const_2: constant aadlstring => "Second Constant Value";
				\tstring_const_3: constant aadlstring => modal_test::string_def_1;
				\tstring_const_4: constant aadlstring => modal_test::string_def_11;
				\t
				\tstring_def_1: aadlstring applies to (all);
				\tstring_def_2: aadlstring applies to (all);
				\tstring_def_3: aadlstring => "string_def_3 has a default value" applies to (all);
				\tstring_def_4: aadlstring applies to (all);
				\tstring_def_5: aadlstring applies to (all);
				\tstring_def_6: aadlstring applies to (all);
				\tstring_def_7: aadlstring applies to (all);
				\tstring_def_8: aadlstring applies to (all);
				\tstring_def_9: aadlstring applies to (all);
				\tstring_def_10: aadlstring applies to (all);
				\tstring_def_11: aadlstring applies to (all);
				\tstring_def_12: aadlstring applies to (all);
				\tstring_def_13: aadlstring => "string_def_13 has a default value" applies to (all);
				\tstring_def_14: aadlstring applies to (all);
				\tstring_def_15: aadlstring applies to (all);
				\tstring_def_16: aadlstring applies to (all);
				\tstring_def_17: aadlstring applies to (all);
				\tstring_def_18: aadlstring applies to (all);
				\tstring_def_19: aadlstring applies to (all);
				\t
				\tstring_list_def_1: list of aadlstring applies to (all);
				\tstring_list_def_2: list of list of aadlstring applies to (all);
				\tstring_list_def_3: list of aadlstring applies to (all);
				\tstring_list_def_4: list of list of aadlstring applies to (all);
				\t
				\trecord_def_1: record (
				\t\tfield_1: aadlstring;
				\t\tfield_2: aadlstring;
				\t\tlist_field_1: list of aadlstring;
				\t\tlist_field_2: list of list of aadlstring;
				\t)applies to (all);
				end modal_test;
				""";
		var modalTestClass = """
				package modaltest;

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

				public final class ModalTest {
				\tpublic static final String MODAL_TEST__NAME = "modal_test";

				\tprivate ModalTest() {}

				\t// Lookup methods for modal_test::string_def_1

				\tpublic static final String STRING_DEF_1__NAME = "string_def_1";

				\tpublic static boolean acceptsStringDef1(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef1_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef1(NamedElement lookupContext) {
				\t\treturn getStringDef1(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef1(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef1(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef1(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef1_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef1_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_1__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef1_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef1_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_2

				\tpublic static final String STRING_DEF_2__NAME = "string_def_2";

				\tpublic static boolean acceptsStringDef2(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef2_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef2(NamedElement lookupContext) {
				\t\treturn getStringDef2(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef2(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef2(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef2(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef2_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef2_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_2__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef2_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef2_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_3

				\tpublic static final String STRING_DEF_3__NAME = "string_def_3";

				\tpublic static boolean acceptsStringDef3(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef3_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef3(NamedElement lookupContext) {
				\t\treturn getStringDef3(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef3(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef3(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef3(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef3_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef3_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_3__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef3_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef3_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_4

				\tpublic static final String STRING_DEF_4__NAME = "string_def_4";

				\tpublic static boolean acceptsStringDef4(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef4_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef4(NamedElement lookupContext) {
				\t\treturn getStringDef4(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef4(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef4(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef4(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef4_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef4_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_4__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef4_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef4_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_5

				\tpublic static final String STRING_DEF_5__NAME = "string_def_5";

				\tpublic static boolean acceptsStringDef5(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef5_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef5(NamedElement lookupContext) {
				\t\treturn getStringDef5(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef5(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef5(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef5(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef5_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef5_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_5__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef5_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef5_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_6

				\tpublic static final String STRING_DEF_6__NAME = "string_def_6";

				\tpublic static boolean acceptsStringDef6(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef6_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef6(NamedElement lookupContext) {
				\t\treturn getStringDef6(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef6(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef6(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef6(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef6_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef6_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_6__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef6_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef6_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_7

				\tpublic static final String STRING_DEF_7__NAME = "string_def_7";

				\tpublic static boolean acceptsStringDef7(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef7_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef7(NamedElement lookupContext) {
				\t\treturn getStringDef7(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef7(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef7(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef7(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef7_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef7_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_7__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef7_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef7_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_8

				\tpublic static final String STRING_DEF_8__NAME = "string_def_8";

				\tpublic static boolean acceptsStringDef8(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef8_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef8(NamedElement lookupContext) {
				\t\treturn getStringDef8(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef8(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef8(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef8(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef8_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef8_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_8__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef8_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef8_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_9

				\tpublic static final String STRING_DEF_9__NAME = "string_def_9";

				\tpublic static boolean acceptsStringDef9(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef9_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef9(NamedElement lookupContext) {
				\t\treturn getStringDef9(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef9(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef9(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef9(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef9_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef9_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_9__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef9_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef9_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_10

				\tpublic static final String STRING_DEF_10__NAME = "string_def_10";

				\tpublic static boolean acceptsStringDef10(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef10_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef10(NamedElement lookupContext) {
				\t\treturn getStringDef10(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef10(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef10(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef10(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef10_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef10_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_10__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef10_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef10_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_11

				\tpublic static final String STRING_DEF_11__NAME = "string_def_11";

				\tpublic static boolean acceptsStringDef11(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef11_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef11(NamedElement lookupContext) {
				\t\treturn getStringDef11(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef11(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef11(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef11(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef11_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef11_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_11__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef11_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef11_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_12

				\tpublic static final String STRING_DEF_12__NAME = "string_def_12";

				\tpublic static boolean acceptsStringDef12(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef12_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef12(NamedElement lookupContext) {
				\t\treturn getStringDef12(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef12(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef12(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef12(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef12_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef12_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_12__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef12_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef12_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_13

				\tpublic static final String STRING_DEF_13__NAME = "string_def_13";

				\tpublic static boolean acceptsStringDef13(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef13_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef13(NamedElement lookupContext) {
				\t\treturn getStringDef13(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef13(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef13(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef13(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef13_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef13_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_13__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef13_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef13_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_14

				\tpublic static final String STRING_DEF_14__NAME = "string_def_14";

				\tpublic static boolean acceptsStringDef14(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef14_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef14(NamedElement lookupContext) {
				\t\treturn getStringDef14(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef14(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef14(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef14(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef14_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef14_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_14__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef14_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef14_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_15

				\tpublic static final String STRING_DEF_15__NAME = "string_def_15";

				\tpublic static boolean acceptsStringDef15(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef15_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef15(NamedElement lookupContext) {
				\t\treturn getStringDef15(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef15(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef15(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef15(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef15_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef15_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_15__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef15_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef15_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_16

				\tpublic static final String STRING_DEF_16__NAME = "string_def_16";

				\tpublic static boolean acceptsStringDef16(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef16_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef16(NamedElement lookupContext) {
				\t\treturn getStringDef16(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef16(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef16(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef16(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef16_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef16_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_16__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef16_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef16_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_17

				\tpublic static final String STRING_DEF_17__NAME = "string_def_17";

				\tpublic static boolean acceptsStringDef17(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef17_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef17(NamedElement lookupContext) {
				\t\treturn getStringDef17(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef17(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef17(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef17(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef17_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef17_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_17__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef17_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef17_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_18

				\tpublic static final String STRING_DEF_18__NAME = "string_def_18";

				\tpublic static boolean acceptsStringDef18(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef18_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef18(NamedElement lookupContext) {
				\t\treturn getStringDef18(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef18(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef18(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef18(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef18_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef18_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_18__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef18_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef18_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_def_19

				\tpublic static final String STRING_DEF_19__NAME = "string_def_19";

				\tpublic static boolean acceptsStringDef19(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDef19_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDef19(NamedElement lookupContext) {
				\t\treturn getStringDef19(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDef19(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDef19(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDef19(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDef19_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDef19_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_DEF_19__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDef19_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDef19_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_list_def_1

				\tpublic static final String STRING_LIST_DEF_1__NAME = "string_list_def_1";

				\tpublic static boolean acceptsStringListDef1(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringListDef1_Property(lookupContext));
				\t}

				\tpublic static Optional<List<String>> getStringListDef1(NamedElement lookupContext) {
				\t\treturn getStringListDef1(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<String>> getStringListDef1(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringListDef1(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<String>> getStringListDef1(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringListDef1_Property(lookupContext);
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

				\tpublic static Property getStringListDef1_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_LIST_DEF_1__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringListDef1_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringListDef1_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_list_def_2

				\tpublic static final String STRING_LIST_DEF_2__NAME = "string_list_def_2";

				\tpublic static boolean acceptsStringListDef2(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringListDef2_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<String>>> getStringListDef2(NamedElement lookupContext) {
				\t\treturn getStringListDef2(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<String>>> getStringListDef2(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringListDef2(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<String>>> getStringListDef2(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringListDef2_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\treturn ((StringLiteral) resolved2).getValue();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringListDef2_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_LIST_DEF_2__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringListDef2_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringListDef2_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_list_def_3

				\tpublic static final String STRING_LIST_DEF_3__NAME = "string_list_def_3";

				\tpublic static boolean acceptsStringListDef3(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringListDef3_Property(lookupContext));
				\t}

				\tpublic static Optional<List<String>> getStringListDef3(NamedElement lookupContext) {
				\t\treturn getStringListDef3(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<String>> getStringListDef3(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringListDef3(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<String>> getStringListDef3(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringListDef3_Property(lookupContext);
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

				\tpublic static Property getStringListDef3_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_LIST_DEF_3__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringListDef3_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringListDef3_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_list_def_4

				\tpublic static final String STRING_LIST_DEF_4__NAME = "string_list_def_4";

				\tpublic static boolean acceptsStringListDef4(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringListDef4_Property(lookupContext));
				\t}

				\tpublic static Optional<List<List<String>>> getStringListDef4(NamedElement lookupContext) {
				\t\treturn getStringListDef4(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<List<List<String>>> getStringListDef4(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringListDef4(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<List<List<String>>> getStringListDef4(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringListDef4_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\treturn ((StringLiteral) resolved2).getValue();
				\t\t\t\t}).toList();
				\t\t\t}).toList());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringListDef4_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_LIST_DEF_4__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringListDef4_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringListDef4_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::record_def_1

				\tpublic static final String RECORD_DEF_1__NAME = "record_def_1";

				\tpublic static boolean acceptsRecordDef1(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRecordDef1_Property(lookupContext));
				\t}

				\tpublic static Optional<RecordDef1> getRecordDef1(NamedElement lookupContext) {
				\t\treturn getRecordDef1(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RecordDef1> getRecordDef1(NamedElement lookupContext, Mode mode) {
				\t\treturn getRecordDef1(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RecordDef1> getRecordDef1(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRecordDef1_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RecordDef1(resolved, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRecordDef1_Property(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + RECORD_DEF_1__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRecordDef1_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRecordDef1_Property(lookupContext));
				\t}

				\t// Lookup methods for modal_test::string_const_1

				\tpublic static final String STRING_CONST_1__NAME = "string_const_1";

				\tpublic static String getStringConst1(EObject lookupContext) {
				\t\tvar constant = getStringConst1_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((StringLiteral) resolved).getValue();
				\t}

				\tpublic static PropertyConstant getStringConst1_PropertyConstant(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_CONST_1__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for modal_test::string_const_2

				\tpublic static final String STRING_CONST_2__NAME = "string_const_2";

				\tpublic static String getStringConst2(EObject lookupContext) {
				\t\tvar constant = getStringConst2_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((StringLiteral) resolved).getValue();
				\t}

				\tpublic static PropertyConstant getStringConst2_PropertyConstant(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_CONST_2__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for modal_test::string_const_3

				\tpublic static final String STRING_CONST_3__NAME = "string_const_3";

				\tpublic static String getStringConst3(EObject lookupContext) {
				\t\tvar constant = getStringConst3_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((StringLiteral) resolved).getValue();
				\t}

				\tpublic static PropertyConstant getStringConst3_PropertyConstant(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_CONST_3__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}

				\t// Lookup methods for modal_test::string_const_4

				\tpublic static final String STRING_CONST_4__NAME = "string_const_4";

				\tpublic static String getStringConst4(EObject lookupContext) {
				\t\tvar constant = getStringConst4_PropertyConstant(lookupContext);
				\t\tvar resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
				\t\treturn ((StringLiteral) resolved).getValue();
				\t}

				\tpublic static PropertyConstant getStringConst4_PropertyConstant(EObject lookupContext) {
				\t\tvar name = MODAL_TEST__NAME + "::" + STRING_CONST_4__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				\t}
				}
				""";
		var recordDef1 = """
				package modaltest;

				import java.util.List;
				import java.util.Objects;
				import java.util.Optional;
				import java.util.stream.Collectors;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.ListValue;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.StringLiteral;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordDef1 extends GeneratedRecord {
				\tpublic static final String FIELD_1__NAME = "field_1";
				\tpublic static final String FIELD_2__NAME = "field_2";
				\tpublic static final String LIST_FIELD_1__NAME = "list_field_1";
				\tpublic static final String LIST_FIELD_2__NAME = "list_field_2";
				\tpublic static final URI FIELD_1__URI = URI.createURI("__synthetic0.aadl#/0/@ownedProperty.23/@ownedPropertyType/@ownedField.0");
				\tpublic static final URI FIELD_2__URI = URI.createURI("__synthetic0.aadl#/0/@ownedProperty.23/@ownedPropertyType/@ownedField.1");
				\tpublic static final URI LIST_FIELD_1__URI = URI.createURI("__synthetic0.aadl#/0/@ownedProperty.23/@ownedPropertyType/@ownedField.2");
				\tpublic static final URI LIST_FIELD_2__URI = URI.createURI("__synthetic0.aadl#/0/@ownedProperty.23/@ownedPropertyType/@ownedField.3");

				\tprivate final Optional<String> field1;
				\tprivate final Optional<String> field2;
				\tprivate final Optional<List<String>> listField1;
				\tprivate final Optional<List<List<String>>> listField2;

				\tpublic RecordDef1(
				\t\t\tOptional<String> field1,
				\t\t\tOptional<String> field2,
				\t\t\tOptional<List<String>> listField1,
				\t\t\tOptional<List<List<String>>> listField2
				\t) {
				\t\tthis.field1 = field1;
				\t\tthis.field2 = field2;
				\t\tthis.listField1 = listField1;
				\t\tthis.listField2 = listField2;
				\t}

				\tpublic RecordDef1(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<String> field1_local;
				\t\ttry {
				\t\t\tfield1_local = findFieldValue(recordValue, FIELD_1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield1_local = Optional.empty();
				\t\t}
				\t\tthis.field1 = field1_local;

				\t\tOptional<String> field2_local;
				\t\ttry {
				\t\t\tfield2_local = findFieldValue(recordValue, FIELD_2__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield2_local = Optional.empty();
				\t\t}
				\t\tthis.field2 = field2_local;

				\t\tOptional<List<String>> listField1_local;
				\t\ttry {
				\t\t\tlistField1_local = findFieldValue(recordValue, LIST_FIELD_1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((StringLiteral) resolved1).getValue();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlistField1_local = Optional.empty();
				\t\t}
				\t\tthis.listField1 = listField1_local;

				\t\tOptional<List<List<String>>> listField2_local;
				\t\ttry {
				\t\t\tlistField2_local = findFieldValue(recordValue, LIST_FIELD_2__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
				\t\t\t\t\t\treturn ((StringLiteral) resolved2).getValue();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlistField2_local = Optional.empty();
				\t\t}
				\t\tthis.listField2 = listField2_local;
				\t}

				\tpublic RecordDef1(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<String> field1_local;
				\t\ttry {
				\t\t\tfield1_local = findFieldValue(recordValue, FIELD_1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield1_local = Optional.empty();
				\t\t}
				\t\tthis.field1 = field1_local;

				\t\tOptional<String> field2_local;
				\t\ttry {
				\t\t\tfield2_local = findFieldValue(recordValue, FIELD_2__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((StringLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield2_local = Optional.empty();
				\t\t}
				\t\tthis.field2 = field2_local;

				\t\tOptional<List<String>> listField1_local;
				\t\ttry {
				\t\t\tlistField1_local = findFieldValue(recordValue, LIST_FIELD_1__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((StringLiteral) resolved1).getValue();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlistField1_local = Optional.empty();
				\t\t}
				\t\tthis.listField1 = listField1_local;

				\t\tOptional<List<List<String>>> listField2_local;
				\t\ttry {
				\t\t\tlistField2_local = findFieldValue(recordValue, LIST_FIELD_2__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
				\t\t\t\t\tvar resolved1 = CodeGenUtil.resolveNamedValue(element1);
				\t\t\t\t\treturn ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
				\t\t\t\t\t\tvar resolved2 = CodeGenUtil.resolveNamedValue(element2);
				\t\t\t\t\t\treturn ((StringLiteral) resolved2).getValue();
				\t\t\t\t\t}).toList();
				\t\t\t\t}).toList();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tlistField2_local = Optional.empty();
				\t\t}
				\t\tthis.listField2 = listField2_local;
				\t}

				\tpublic Optional<String> getField1() {
				\t\treturn field1;
				\t}

				\tpublic Optional<String> getField2() {
				\t\treturn field2;
				\t}

				\tpublic Optional<List<String>> getListField1() {
				\t\treturn listField1;
				\t}

				\tpublic Optional<List<List<String>>> getListField2() {
				\t\treturn listField2;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (field1.isEmpty()
				\t\t\t\t&& field2.isEmpty()
				\t\t\t\t&& listField1.isEmpty()
				\t\t\t\t&& listField2.isEmpty()
				\t\t) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\tfield1.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD_1__URI, FIELD_1__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\tfield2.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD_2__URI, FIELD_2__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\tlistField1.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_FIELD_1__URI, LIST_FIELD_1__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1)));
				\t\t});
				\t\tlistField2.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, LIST_FIELD_2__URI, LIST_FIELD_2__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> CodeGenUtil.toPropertyExpression(element1, element2 -> CodeGenUtil.toPropertyExpression(element2))));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(
				\t\t\t\tfield1,
				\t\t\t\tfield2,
				\t\t\t\tlistField1,
				\t\t\t\tlistField2
				\t\t);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordDef1 other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.field1, other.field1)
				\t\t\t\t&& Objects.equals(this.field2, other.field2)
				\t\t\t\t&& Objects.equals(this.listField1, other.listField1)
				\t\t\t\t&& Objects.equals(this.listField2, other.listField2);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.field1.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD_1__NAME);
				\t\t\tbuilder.append(" => \\"");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append("\\";");
				\t\t});
				\t\tthis.field2.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD_2__NAME);
				\t\t\tbuilder.append(" => \\"");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append("\\";");
				\t\t});
				\t\tthis.listField1.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_FIELD_1__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(element1 -> '\\"' + element1 + '\\"').collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tthis.listField2.ifPresent(field -> {
				\t\t\tbuilder.append(LIST_FIELD_2__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field.stream().map(element1 -> element1.stream().map(element2 -> '\\"' + element2 + '\\"').collect(Collectors.joining(", ", "(", ")"))).collect(Collectors.joining(", ", "(", ")")));
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(modalTest));
		assertEquals("src-gen/modaltest", results.getPackagePath());
		assertEquals(2, results.getClasses().size());

		assertEquals("ModalTest.java", results.getClasses().get(0).getFileName());
		assertEquals(modalTestClass, results.getClasses().get(0).getContents());

		assertEquals("RecordDef1.java", results.getClasses().get(1).getFileName());
		assertEquals(recordDef1, results.getClasses().get(1).getContents());
	}
}
