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

/** Verifies exact generated Java for property definition. */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class PropertyDefinitionTest {
	@Inject
	private TestHelper<PropertySet> testHelper;

	@Test
	public void testPropertyDefinition() throws Exception {
		var enumTest = """
				property set enum_test is
				\tlanguage_type: type enumeration (english, french, german, spanish);
				end enum_test;
				""";
		var ps2 = """
				property set ps2 is
				\tmass: type units (g, kg => g * 1000);
				\tcolor: type enumeration (red, green, blue);
				end ps2;
				""";
		var ps1 = """
				property set ps1 is
				\twith enum_test;
				\twith ps2;
				\t
				\tboolean_type_1: type aadlboolean;
				\t
				\tboolean_definition: aadlboolean applies to (all);
				\tstring_definition: aadlstring applies to (all);
				\tclassifier_definition: classifier applies to (all);
				\tunits_definition: units (m, km => m * 1000) applies to (all);
				\tenum_definition: enumeration (washington, lincoln) applies to (all);
				\tinteger_definition_no_units: aadlinteger applies to (all);
				\tinteger_definition_with_units: aadlinteger units ps2::mass applies to (all);
				\treal_definition_no_units: aadlreal applies to (all);
				\trange_definition: range of aadlinteger applies to (all);
				\trecord_definition: record (field: aadlboolean;) applies to (all);
				\treference_definition: reference applies to (all);
				\t
				\tdefinition_with_referenced_type_local: ps1::boolean_type_1 applies to (all);
				\tdefinition_with_referenced_type_other_file: ps2::color applies to (all);
				\tdefinition_with_underscore_import: enum_test::language_type applies to (all);
				end ps1;
				""";
		var ps1Class = """
				package ps1;

				import java.util.Optional;
				import java.util.OptionalDouble;
				import java.util.OptionalLong;

				import org.eclipse.emf.ecore.EObject;
				import org.osate.aadl2.Aadl2Package;
				import org.osate.aadl2.BooleanLiteral;
				import org.osate.aadl2.Classifier;
				import org.osate.aadl2.ClassifierValue;
				import org.osate.aadl2.IntegerLiteral;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.Property;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RealLiteral;
				import org.osate.aadl2.StringLiteral;
				import org.osate.aadl2.instance.InstanceObject;
				import org.osate.aadl2.instance.InstanceReferenceValue;
				import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
				import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.IntegerRange;
				import org.osate.pluginsupport.properties.IntegerWithUnits;

				import enumtest.LanguageType;
				import ps2.Color;
				import ps2.Mass;

				public final class Ps1 {
				\tpublic static final String PS1__NAME = "ps1";

				\tprivate Ps1() {}

				\t// Lookup methods for ps1::boolean_definition

				\tpublic static final String BOOLEAN_DEFINITION__NAME = "boolean_definition";

				\tpublic static boolean acceptsBooleanDefinition(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getBooleanDefinition_Property(lookupContext));
				\t}

				\tpublic static Optional<Boolean> getBooleanDefinition(NamedElement lookupContext) {
				\t\treturn getBooleanDefinition(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<Boolean> getBooleanDefinition(NamedElement lookupContext, Mode mode) {
				\t\treturn getBooleanDefinition(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<Boolean> getBooleanDefinition(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getBooleanDefinition_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((BooleanLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getBooleanDefinition_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + BOOLEAN_DEFINITION__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getBooleanDefinition_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getBooleanDefinition_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::string_definition

				\tpublic static final String STRING_DEFINITION__NAME = "string_definition";

				\tpublic static boolean acceptsStringDefinition(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getStringDefinition_Property(lookupContext));
				\t}

				\tpublic static Optional<String> getStringDefinition(NamedElement lookupContext) {
				\t\treturn getStringDefinition(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<String> getStringDefinition(NamedElement lookupContext, Mode mode) {
				\t\treturn getStringDefinition(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<String> getStringDefinition(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getStringDefinition_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((StringLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getStringDefinition_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + STRING_DEFINITION__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getStringDefinition_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getStringDefinition_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::classifier_definition

				\tpublic static final String CLASSIFIER_DEFINITION__NAME = "classifier_definition";

				\tpublic static boolean acceptsClassifierDefinition(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getClassifierDefinition_Property(lookupContext));
				\t}

				\tpublic static Optional<Classifier> getClassifierDefinition(NamedElement lookupContext) {
				\t\treturn getClassifierDefinition(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<Classifier> getClassifierDefinition(NamedElement lookupContext, Mode mode) {
				\t\treturn getClassifierDefinition(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<Classifier> getClassifierDefinition(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getClassifierDefinition_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((ClassifierValue) resolved).getClassifier());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getClassifierDefinition_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + CLASSIFIER_DEFINITION__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getClassifierDefinition_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getClassifierDefinition_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::units_definition

				\tpublic static final String UNITS_DEFINITION__NAME = "units_definition";

				\tpublic static boolean acceptsUnitsDefinition(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getUnitsDefinition_Property(lookupContext));
				\t}

				\tpublic static Optional<UnitsDefinition> getUnitsDefinition(NamedElement lookupContext) {
				\t\treturn getUnitsDefinition(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<UnitsDefinition> getUnitsDefinition(NamedElement lookupContext, Mode mode) {
				\t\treturn getUnitsDefinition(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<UnitsDefinition> getUnitsDefinition(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getUnitsDefinition_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(UnitsDefinition.valueOf(resolved));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getUnitsDefinition_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + UNITS_DEFINITION__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getUnitsDefinition_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getUnitsDefinition_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::enum_definition

				\tpublic static final String ENUM_DEFINITION__NAME = "enum_definition";

				\tpublic static boolean acceptsEnumDefinition(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getEnumDefinition_Property(lookupContext));
				\t}

				\tpublic static Optional<EnumDefinition> getEnumDefinition(NamedElement lookupContext) {
				\t\treturn getEnumDefinition(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<EnumDefinition> getEnumDefinition(NamedElement lookupContext, Mode mode) {
				\t\treturn getEnumDefinition(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<EnumDefinition> getEnumDefinition(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getEnumDefinition_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(EnumDefinition.valueOf(resolved));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getEnumDefinition_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + ENUM_DEFINITION__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getEnumDefinition_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getEnumDefinition_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::integer_definition_no_units

				\tpublic static final String INTEGER_DEFINITION_NO_UNITS__NAME = "integer_definition_no_units";

				\tpublic static boolean acceptsIntegerDefinitionNoUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getIntegerDefinitionNoUnits_Property(lookupContext));
				\t}

				\tpublic static OptionalLong getIntegerDefinitionNoUnits(NamedElement lookupContext) {
				\t\treturn getIntegerDefinitionNoUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static OptionalLong getIntegerDefinitionNoUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getIntegerDefinitionNoUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static OptionalLong getIntegerDefinitionNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getIntegerDefinitionNoUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn OptionalLong.of(((IntegerLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn OptionalLong.empty();
				\t\t}
				\t}

				\tpublic static Property getIntegerDefinitionNoUnits_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + INTEGER_DEFINITION_NO_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getIntegerDefinitionNoUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getIntegerDefinitionNoUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::integer_definition_with_units

				\tpublic static final String INTEGER_DEFINITION_WITH_UNITS__NAME = "integer_definition_with_units";

				\tpublic static boolean acceptsIntegerDefinitionWithUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getIntegerDefinitionWithUnits_Property(lookupContext));
				\t}

				\tpublic static Optional<IntegerWithUnits<Mass>> getIntegerDefinitionWithUnits(NamedElement lookupContext) {
				\t\treturn getIntegerDefinitionWithUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<IntegerWithUnits<Mass>> getIntegerDefinitionWithUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getIntegerDefinitionWithUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<IntegerWithUnits<Mass>> getIntegerDefinitionWithUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getIntegerDefinitionWithUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new IntegerWithUnits<>(resolved, Mass.class));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getIntegerDefinitionWithUnits_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + INTEGER_DEFINITION_WITH_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getIntegerDefinitionWithUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getIntegerDefinitionWithUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::real_definition_no_units

				\tpublic static final String REAL_DEFINITION_NO_UNITS__NAME = "real_definition_no_units";

				\tpublic static boolean acceptsRealDefinitionNoUnits(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRealDefinitionNoUnits_Property(lookupContext));
				\t}

				\tpublic static OptionalDouble getRealDefinitionNoUnits(NamedElement lookupContext) {
				\t\treturn getRealDefinitionNoUnits(lookupContext, Optional.empty());
				\t}

				\tpublic static OptionalDouble getRealDefinitionNoUnits(NamedElement lookupContext, Mode mode) {
				\t\treturn getRealDefinitionNoUnits(lookupContext, Optional.of(mode));
				\t}

				\tpublic static OptionalDouble getRealDefinitionNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRealDefinitionNoUnits_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn OptionalDouble.of(((RealLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn OptionalDouble.empty();
				\t\t}
				\t}

				\tpublic static Property getRealDefinitionNoUnits_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + REAL_DEFINITION_NO_UNITS__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRealDefinitionNoUnits_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRealDefinitionNoUnits_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::range_definition

				\tpublic static final String RANGE_DEFINITION__NAME = "range_definition";

				\tpublic static boolean acceptsRangeDefinition(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRangeDefinition_Property(lookupContext));
				\t}

				\tpublic static Optional<IntegerRange> getRangeDefinition(NamedElement lookupContext) {
				\t\treturn getRangeDefinition(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<IntegerRange> getRangeDefinition(NamedElement lookupContext, Mode mode) {
				\t\treturn getRangeDefinition(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<IntegerRange> getRangeDefinition(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRangeDefinition_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new IntegerRange(resolved, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRangeDefinition_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + RANGE_DEFINITION__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRangeDefinition_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRangeDefinition_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::record_definition

				\tpublic static final String RECORD_DEFINITION__NAME = "record_definition";

				\tpublic static boolean acceptsRecordDefinition(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getRecordDefinition_Property(lookupContext));
				\t}

				\tpublic static Optional<RecordDefinition> getRecordDefinition(NamedElement lookupContext) {
				\t\treturn getRecordDefinition(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<RecordDefinition> getRecordDefinition(NamedElement lookupContext, Mode mode) {
				\t\treturn getRecordDefinition(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<RecordDefinition> getRecordDefinition(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getRecordDefinition_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(new RecordDefinition(resolved, lookupContext, mode));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getRecordDefinition_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + RECORD_DEFINITION__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getRecordDefinition_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getRecordDefinition_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::reference_definition

				\tpublic static final String REFERENCE_DEFINITION__NAME = "reference_definition";

				\tpublic static boolean acceptsReferenceDefinition(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getReferenceDefinition_Property(lookupContext));
				\t}

				\tpublic static Optional<InstanceObject> getReferenceDefinition(NamedElement lookupContext) {
				\t\treturn getReferenceDefinition(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<InstanceObject> getReferenceDefinition(NamedElement lookupContext, Mode mode) {
				\t\treturn getReferenceDefinition(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<InstanceObject> getReferenceDefinition(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getReferenceDefinition_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getReferenceDefinition_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + REFERENCE_DEFINITION__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getReferenceDefinition_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getReferenceDefinition_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::definition_with_referenced_type_local

				\tpublic static final String DEFINITION_WITH_REFERENCED_TYPE_LOCAL__NAME = "definition_with_referenced_type_local";

				\tpublic static boolean acceptsDefinitionWithReferencedTypeLocal(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getDefinitionWithReferencedTypeLocal_Property(lookupContext));
				\t}

				\tpublic static Optional<Boolean> getDefinitionWithReferencedTypeLocal(NamedElement lookupContext) {
				\t\treturn getDefinitionWithReferencedTypeLocal(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<Boolean> getDefinitionWithReferencedTypeLocal(NamedElement lookupContext, Mode mode) {
				\t\treturn getDefinitionWithReferencedTypeLocal(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<Boolean> getDefinitionWithReferencedTypeLocal(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getDefinitionWithReferencedTypeLocal_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((BooleanLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getDefinitionWithReferencedTypeLocal_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + DEFINITION_WITH_REFERENCED_TYPE_LOCAL__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getDefinitionWithReferencedTypeLocal_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getDefinitionWithReferencedTypeLocal_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::definition_with_referenced_type_other_file

				\tpublic static final String DEFINITION_WITH_REFERENCED_TYPE_OTHER_FILE__NAME = "definition_with_referenced_type_other_file";

				\tpublic static boolean acceptsDefinitionWithReferencedTypeOtherFile(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getDefinitionWithReferencedTypeOtherFile_Property(lookupContext));
				\t}

				\tpublic static Optional<Color> getDefinitionWithReferencedTypeOtherFile(NamedElement lookupContext) {
				\t\treturn getDefinitionWithReferencedTypeOtherFile(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<Color> getDefinitionWithReferencedTypeOtherFile(NamedElement lookupContext, Mode mode) {
				\t\treturn getDefinitionWithReferencedTypeOtherFile(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<Color> getDefinitionWithReferencedTypeOtherFile(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getDefinitionWithReferencedTypeOtherFile_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(Color.valueOf(resolved));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getDefinitionWithReferencedTypeOtherFile_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + DEFINITION_WITH_REFERENCED_TYPE_OTHER_FILE__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getDefinitionWithReferencedTypeOtherFile_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getDefinitionWithReferencedTypeOtherFile_Property(lookupContext));
				\t}

				\t// Lookup methods for ps1::definition_with_underscore_import

				\tpublic static final String DEFINITION_WITH_UNDERSCORE_IMPORT__NAME = "definition_with_underscore_import";

				\tpublic static boolean acceptsDefinitionWithUnderscoreImport(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getDefinitionWithUnderscoreImport_Property(lookupContext));
				\t}

				\tpublic static Optional<LanguageType> getDefinitionWithUnderscoreImport(NamedElement lookupContext) {
				\t\treturn getDefinitionWithUnderscoreImport(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<LanguageType> getDefinitionWithUnderscoreImport(NamedElement lookupContext, Mode mode) {
				\t\treturn getDefinitionWithUnderscoreImport(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<LanguageType> getDefinitionWithUnderscoreImport(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getDefinitionWithUnderscoreImport_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(LanguageType.valueOf(resolved));
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getDefinitionWithUnderscoreImport_Property(EObject lookupContext) {
				\t\tvar name = PS1__NAME + "::" + DEFINITION_WITH_UNDERSCORE_IMPORT__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getDefinitionWithUnderscoreImport_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getDefinitionWithUnderscoreImport_Property(lookupContext));
				\t}
				}
				""";
		var unitsDefinition = """
				package ps1;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.UnitLiteral;
				import org.osate.pluginsupport.properties.GeneratedUnits;

				public enum UnitsDefinition implements GeneratedUnits<UnitsDefinition> {
				\tM(1.0, "m", "__synthetic2.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedLiteral.0"),
				\tKM(1000.0, "km", "__synthetic2.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedLiteral.1");

				\tprivate final double factorToBase;
				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate UnitsDefinition(double factorToBase, String originalName, String uri) {
				\t\tthis.factorToBase = factorToBase;
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static UnitsDefinition valueOf(PropertyExpression propertyExpression) {
				\t\tvar abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
				\t\treturn valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				\t}

				\t@Override
				\tpublic double getFactorToBase() {
				\t\treturn factorToBase;
				\t}

				\t@Override
				\tpublic double getFactorTo(UnitsDefinition target) {
				\t\treturn factorToBase / target.factorToBase;
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
		var enumDefinition = """
				package ps1;

				import org.eclipse.emf.common.util.URI;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.pluginsupport.properties.GeneratedEnumeration;

				public enum EnumDefinition implements GeneratedEnumeration {
				\tWASHINGTON("washington", "__synthetic2.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.0"),
				\tLINCOLN("lincoln", "__synthetic2.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.1");

				\tprivate final String originalName;
				\tprivate final URI uri;

				\tprivate EnumDefinition(String originalName, String uri) {
				\t\tthis.originalName = originalName;
				\t\tthis.uri = URI.createURI(uri);
				\t}

				\tpublic static EnumDefinition valueOf(PropertyExpression propertyExpression) {
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
		var recordDefinition = """
				package ps1;

				import java.util.Objects;
				import java.util.Optional;

				import org.eclipse.emf.common.util.URI;
				import org.eclipse.emf.ecore.resource.ResourceSet;
				import org.osate.aadl2.Aadl2Factory;
				import org.osate.aadl2.BooleanLiteral;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.RecordValue;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;
				import org.osate.pluginsupport.properties.GeneratedRecord;

				public class RecordDefinition extends GeneratedRecord {
				\tpublic static final String FIELD__NAME = "field";
				\tpublic static final URI FIELD__URI = URI.createURI("__synthetic2.aadl#/0/@ownedProperty.9/@ownedPropertyType/@ownedField.0");

				\tprivate final Optional<Boolean> field;

				\tpublic RecordDefinition(Optional<Boolean> field) {
				\t\tthis.field = field;
				\t}

				\tpublic RecordDefinition(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Boolean> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic RecordDefinition(PropertyExpression propertyExpression) {
				\t\tvar recordValue = (RecordValue) propertyExpression;

				\t\tOptional<Boolean> field_local;
				\t\ttry {
				\t\t\tfield_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
				\t\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
				\t\t\t\treturn ((BooleanLiteral) resolved).getValue();
				\t\t\t});
				\t\t} catch (PropertyNotPresentException e) {
				\t\t\tfield_local = Optional.empty();
				\t\t}
				\t\tthis.field = field_local;
				\t}

				\tpublic Optional<Boolean> getField() {
				\t\treturn field;
				\t}

				\t@Override
				\tpublic RecordValue toPropertyExpression(ResourceSet resourceSet) {
				\t\tif (field.isEmpty()) {
				\t\t\tthrow new IllegalStateException("Record must have at least one field set.");
				\t\t}
				\t\tvar recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				\t\tfield.ifPresent(field -> {
				\t\t\tvar fieldAssociation = recordValue.createOwnedFieldValue();
				\t\t\tfieldAssociation.setProperty(loadField(resourceSet, FIELD__URI, FIELD__NAME));
				\t\t\tfieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
				\t\t});
				\t\treturn recordValue;
				\t}

				\t@Override
				\tpublic int hashCode() {
				\t\treturn Objects.hash(field);
				\t}

				\t@Override
				\tpublic boolean equals(Object obj) {
				\t\tif (this == obj) {
				\t\t\treturn true;
				\t\t}
				\t\tif (!(obj instanceof RecordDefinition other)) {
				\t\t\treturn false;
				\t\t}
				\t\treturn Objects.equals(this.field, other.field);
				\t}

				\t@Override
				\tpublic String toString() {
				\t\tvar builder = new StringBuilder();
				\t\tbuilder.append('[');
				\t\tthis.field.ifPresent(field -> {
				\t\t\tbuilder.append(FIELD__NAME);
				\t\t\tbuilder.append(" => ");
				\t\t\tbuilder.append(field);
				\t\t\tbuilder.append(';');
				\t\t});
				\t\tbuilder.append(']');
				\t\treturn builder.toString();
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(ps1, enumTest, ps2));
		assertEquals("src-gen/ps1", results.getPackagePath());
		assertEquals(4, results.getClasses().size());

		assertEquals("Ps1.java", results.getClasses().get(0).getFileName());
		assertEquals(ps1Class, results.getClasses().get(0).getContents());

		assertEquals("UnitsDefinition.java", results.getClasses().get(1).getFileName());
		assertEquals(unitsDefinition, results.getClasses().get(1).getContents());

		assertEquals("EnumDefinition.java", results.getClasses().get(2).getFileName());
		assertEquals(enumDefinition, results.getClasses().get(2).getContents());

		assertEquals("RecordDefinition.java", results.getClasses().get(3).getFileName());
		assertEquals(recordDefinition, results.getClasses().get(3).getContents());
	}

	@Test
	public void testEmptyPropertySet() throws Exception {
		var emptyPs = """
				property set empty_ps is
				end empty_ps;
				""";
		var emptyPsClass = """
				package emptyps;

				public final class EmptyPs {
				\tpublic static final String EMPTY_PS__NAME = "empty_ps";

				\tprivate EmptyPs() {}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(emptyPs));
		assertEquals("src-gen/emptyps", results.getPackagePath());
		assertEquals(1, results.getClasses().size());

		assertEquals("EmptyPs.java", results.getClasses().getFirst().getFileName());
		assertEquals(emptyPsClass, results.getClasses().getFirst().getContents());
	}

	@Test
	public void testSingleDefinition() throws Exception {
		var singleDefinitionPs = """
				property set single_definition_ps is
				\tsole_definition: aadlboolean applies to (all);
				end single_definition_ps;
				""";
		var singleDefinitionPsClass = """
				package singledefinitionps;

				import java.util.Optional;

				import org.eclipse.emf.ecore.EObject;
				import org.osate.aadl2.Aadl2Package;
				import org.osate.aadl2.BooleanLiteral;
				import org.osate.aadl2.Mode;
				import org.osate.aadl2.NamedElement;
				import org.osate.aadl2.Property;
				import org.osate.aadl2.PropertyExpression;
				import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
				import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
				import org.osate.aadl2.properties.PropertyNotPresentException;
				import org.osate.pluginsupport.properties.CodeGenUtil;

				public final class SingleDefinitionPs {
				\tpublic static final String SINGLE_DEFINITION_PS__NAME = "single_definition_ps";

				\tprivate SingleDefinitionPs() {}

				\t// Lookup methods for single_definition_ps::sole_definition

				\tpublic static final String SOLE_DEFINITION__NAME = "sole_definition";

				\tpublic static boolean acceptsSoleDefinition(NamedElement lookupContext) {
				\t\treturn lookupContext.acceptsProperty(getSoleDefinition_Property(lookupContext));
				\t}

				\tpublic static Optional<Boolean> getSoleDefinition(NamedElement lookupContext) {
				\t\treturn getSoleDefinition(lookupContext, Optional.empty());
				\t}

				\tpublic static Optional<Boolean> getSoleDefinition(NamedElement lookupContext, Mode mode) {
				\t\treturn getSoleDefinition(lookupContext, Optional.of(mode));
				\t}

				\tpublic static Optional<Boolean> getSoleDefinition(NamedElement lookupContext, Optional<Mode> mode) {
				\t\tvar property = getSoleDefinition_Property(lookupContext);
				\t\ttry {
				\t\t\tvar value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
				\t\t\tvar resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
				\t\t\treturn Optional.of(((BooleanLiteral) resolved).getValue());
				\t\t} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
				\t\t\treturn Optional.empty();
				\t\t}
				\t}

				\tpublic static Property getSoleDefinition_Property(EObject lookupContext) {
				\t\tvar name = SINGLE_DEFINITION_PS__NAME + "::" + SOLE_DEFINITION__NAME;
				\t\treturn Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				\t}

				\tpublic static PropertyExpression getSoleDefinition_EObject(NamedElement lookupContext) {
				\t\treturn lookupContext.getNonModalPropertyValue(getSoleDefinition_Property(lookupContext));
				\t}
				}
				""";
		var results = generateAndCompile(testHelper.parseString(singleDefinitionPs));
		assertEquals("src-gen/singledefinitionps", results.getPackagePath());
		assertEquals(1, results.getClasses().size());

		assertEquals("SingleDefinitionPs.java", results.getClasses().getFirst().getFileName());
		assertEquals(singleDefinitionPsClass, results.getClasses().getFirst().getContents());
	}
}
