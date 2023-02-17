/*******************************************************************************
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.propertiescodegen.tests

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.PropertySet
import org.osate.propertiescodegen.PropertiesCodeGen
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class PropertyDefinitionTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testPropertyDefinition() {
		val enumTest = '''
			property set enum_test is
				language_type: type enumeration (english, french, german, spanish);
			end enum_test;
		'''
		val ps2 = '''
			property set ps2 is
				mass: type units (g, kg => g * 1000);
				color: type enumeration (red, green, blue);
			end ps2;
		'''
		val ps1 = '''
			property set ps1 is
				with enum_test;
				with ps2;
				
				boolean_type_1: type aadlboolean;
				
				boolean_definition: aadlboolean applies to (all);
				string_definition: aadlstring applies to (all);
				classifier_definition: classifier applies to (all);
				units_definition: units (m, km => m * 1000) applies to (all);
				enum_definition: enumeration (washington, lincoln) applies to (all);
				integer_definition_no_units: aadlinteger applies to (all);
				integer_definition_with_units: aadlinteger units ps2::mass applies to (all);
				real_definition_no_units: aadlreal applies to (all);
				range_definition: range of aadlinteger applies to (all);
				record_definition: record (field: aadlboolean;) applies to (all);
				reference_definition: reference applies to (all);
				
				definition_with_referenced_type_local: ps1::boolean_type_1 applies to (all);
				definition_with_referenced_type_other_file: ps2::color applies to (all);
				definition_with_underscore_import: enum_test::language_type applies to (all);
			end ps1;
		'''
		val ps1Class = '''
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
				public static final String PS1__NAME = "ps1";
				
				private Ps1() {}
				
				// Lookup methods for ps1::boolean_definition
				
				public static final String BOOLEAN_DEFINITION__NAME = "boolean_definition";
				
				public static boolean acceptsBooleanDefinition(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getBooleanDefinition_Property(lookupContext));
				}
				
				public static Optional<Boolean> getBooleanDefinition(NamedElement lookupContext) {
					return getBooleanDefinition(lookupContext, Optional.empty());
				}
				
				public static Optional<Boolean> getBooleanDefinition(NamedElement lookupContext, Mode mode) {
					return getBooleanDefinition(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Boolean> getBooleanDefinition(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getBooleanDefinition_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((BooleanLiteral) resolved).getValue());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getBooleanDefinition_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + BOOLEAN_DEFINITION__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getBooleanDefinition_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getBooleanDefinition_Property(lookupContext));
				}
				
				// Lookup methods for ps1::string_definition
				
				public static final String STRING_DEFINITION__NAME = "string_definition";
				
				public static boolean acceptsStringDefinition(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getStringDefinition_Property(lookupContext));
				}
				
				public static Optional<String> getStringDefinition(NamedElement lookupContext) {
					return getStringDefinition(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDefinition(NamedElement lookupContext, Mode mode) {
					return getStringDefinition(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDefinition(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getStringDefinition_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getStringDefinition_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + STRING_DEFINITION__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getStringDefinition_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getStringDefinition_Property(lookupContext));
				}
				
				// Lookup methods for ps1::classifier_definition
				
				public static final String CLASSIFIER_DEFINITION__NAME = "classifier_definition";
				
				public static boolean acceptsClassifierDefinition(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getClassifierDefinition_Property(lookupContext));
				}
				
				public static Optional<Classifier> getClassifierDefinition(NamedElement lookupContext) {
					return getClassifierDefinition(lookupContext, Optional.empty());
				}
				
				public static Optional<Classifier> getClassifierDefinition(NamedElement lookupContext, Mode mode) {
					return getClassifierDefinition(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Classifier> getClassifierDefinition(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getClassifierDefinition_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ClassifierValue) resolved).getClassifier());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getClassifierDefinition_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + CLASSIFIER_DEFINITION__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getClassifierDefinition_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getClassifierDefinition_Property(lookupContext));
				}
				
				// Lookup methods for ps1::units_definition
				
				public static final String UNITS_DEFINITION__NAME = "units_definition";
				
				public static boolean acceptsUnitsDefinition(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getUnitsDefinition_Property(lookupContext));
				}
				
				public static Optional<UnitsDefinition> getUnitsDefinition(NamedElement lookupContext) {
					return getUnitsDefinition(lookupContext, Optional.empty());
				}
				
				public static Optional<UnitsDefinition> getUnitsDefinition(NamedElement lookupContext, Mode mode) {
					return getUnitsDefinition(lookupContext, Optional.of(mode));
				}
				
				public static Optional<UnitsDefinition> getUnitsDefinition(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getUnitsDefinition_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(UnitsDefinition.valueOf(resolved));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getUnitsDefinition_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + UNITS_DEFINITION__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getUnitsDefinition_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getUnitsDefinition_Property(lookupContext));
				}
				
				// Lookup methods for ps1::enum_definition
				
				public static final String ENUM_DEFINITION__NAME = "enum_definition";
				
				public static boolean acceptsEnumDefinition(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getEnumDefinition_Property(lookupContext));
				}
				
				public static Optional<EnumDefinition> getEnumDefinition(NamedElement lookupContext) {
					return getEnumDefinition(lookupContext, Optional.empty());
				}
				
				public static Optional<EnumDefinition> getEnumDefinition(NamedElement lookupContext, Mode mode) {
					return getEnumDefinition(lookupContext, Optional.of(mode));
				}
				
				public static Optional<EnumDefinition> getEnumDefinition(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getEnumDefinition_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(EnumDefinition.valueOf(resolved));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getEnumDefinition_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + ENUM_DEFINITION__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getEnumDefinition_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getEnumDefinition_Property(lookupContext));
				}
				
				// Lookup methods for ps1::integer_definition_no_units
				
				public static final String INTEGER_DEFINITION_NO_UNITS__NAME = "integer_definition_no_units";
				
				public static boolean acceptsIntegerDefinitionNoUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getIntegerDefinitionNoUnits_Property(lookupContext));
				}
				
				public static OptionalLong getIntegerDefinitionNoUnits(NamedElement lookupContext) {
					return getIntegerDefinitionNoUnits(lookupContext, Optional.empty());
				}
				
				public static OptionalLong getIntegerDefinitionNoUnits(NamedElement lookupContext, Mode mode) {
					return getIntegerDefinitionNoUnits(lookupContext, Optional.of(mode));
				}
				
				public static OptionalLong getIntegerDefinitionNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getIntegerDefinitionNoUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return OptionalLong.of(((IntegerLiteral) resolved).getValue());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return OptionalLong.empty();
					}
				}
				
				public static Property getIntegerDefinitionNoUnits_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + INTEGER_DEFINITION_NO_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getIntegerDefinitionNoUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getIntegerDefinitionNoUnits_Property(lookupContext));
				}
				
				// Lookup methods for ps1::integer_definition_with_units
				
				public static final String INTEGER_DEFINITION_WITH_UNITS__NAME = "integer_definition_with_units";
				
				public static boolean acceptsIntegerDefinitionWithUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getIntegerDefinitionWithUnits_Property(lookupContext));
				}
				
				public static Optional<IntegerWithUnits<Mass>> getIntegerDefinitionWithUnits(NamedElement lookupContext) {
					return getIntegerDefinitionWithUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerWithUnits<Mass>> getIntegerDefinitionWithUnits(NamedElement lookupContext, Mode mode) {
					return getIntegerDefinitionWithUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerWithUnits<Mass>> getIntegerDefinitionWithUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getIntegerDefinitionWithUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerWithUnits<>(resolved, Mass.class));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getIntegerDefinitionWithUnits_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + INTEGER_DEFINITION_WITH_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getIntegerDefinitionWithUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getIntegerDefinitionWithUnits_Property(lookupContext));
				}
				
				// Lookup methods for ps1::real_definition_no_units
				
				public static final String REAL_DEFINITION_NO_UNITS__NAME = "real_definition_no_units";
				
				public static boolean acceptsRealDefinitionNoUnits(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getRealDefinitionNoUnits_Property(lookupContext));
				}
				
				public static OptionalDouble getRealDefinitionNoUnits(NamedElement lookupContext) {
					return getRealDefinitionNoUnits(lookupContext, Optional.empty());
				}
				
				public static OptionalDouble getRealDefinitionNoUnits(NamedElement lookupContext, Mode mode) {
					return getRealDefinitionNoUnits(lookupContext, Optional.of(mode));
				}
				
				public static OptionalDouble getRealDefinitionNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getRealDefinitionNoUnits_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return OptionalDouble.of(((RealLiteral) resolved).getValue());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return OptionalDouble.empty();
					}
				}
				
				public static Property getRealDefinitionNoUnits_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + REAL_DEFINITION_NO_UNITS__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getRealDefinitionNoUnits_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getRealDefinitionNoUnits_Property(lookupContext));
				}
				
				// Lookup methods for ps1::range_definition
				
				public static final String RANGE_DEFINITION__NAME = "range_definition";
				
				public static boolean acceptsRangeDefinition(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getRangeDefinition_Property(lookupContext));
				}
				
				public static Optional<IntegerRange> getRangeDefinition(NamedElement lookupContext) {
					return getRangeDefinition(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerRange> getRangeDefinition(NamedElement lookupContext, Mode mode) {
					return getRangeDefinition(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerRange> getRangeDefinition(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getRangeDefinition_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerRange(resolved, lookupContext, mode));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getRangeDefinition_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + RANGE_DEFINITION__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getRangeDefinition_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getRangeDefinition_Property(lookupContext));
				}
				
				// Lookup methods for ps1::record_definition
				
				public static final String RECORD_DEFINITION__NAME = "record_definition";
				
				public static boolean acceptsRecordDefinition(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getRecordDefinition_Property(lookupContext));
				}
				
				public static Optional<RecordDefinition> getRecordDefinition(NamedElement lookupContext) {
					return getRecordDefinition(lookupContext, Optional.empty());
				}
				
				public static Optional<RecordDefinition> getRecordDefinition(NamedElement lookupContext, Mode mode) {
					return getRecordDefinition(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RecordDefinition> getRecordDefinition(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getRecordDefinition_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RecordDefinition(resolved, lookupContext, mode));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getRecordDefinition_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + RECORD_DEFINITION__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getRecordDefinition_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getRecordDefinition_Property(lookupContext));
				}
				
				// Lookup methods for ps1::reference_definition
				
				public static final String REFERENCE_DEFINITION__NAME = "reference_definition";
				
				public static boolean acceptsReferenceDefinition(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferenceDefinition_Property(lookupContext));
				}
				
				public static Optional<InstanceObject> getReferenceDefinition(NamedElement lookupContext) {
					return getReferenceDefinition(lookupContext, Optional.empty());
				}
				
				public static Optional<InstanceObject> getReferenceDefinition(NamedElement lookupContext, Mode mode) {
					return getReferenceDefinition(lookupContext, Optional.of(mode));
				}
				
				public static Optional<InstanceObject> getReferenceDefinition(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferenceDefinition_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((InstanceReferenceValue) resolved).getReferencedInstanceObject());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getReferenceDefinition_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + REFERENCE_DEFINITION__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferenceDefinition_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferenceDefinition_Property(lookupContext));
				}
				
				// Lookup methods for ps1::definition_with_referenced_type_local
				
				public static final String DEFINITION_WITH_REFERENCED_TYPE_LOCAL__NAME = "definition_with_referenced_type_local";
				
				public static boolean acceptsDefinitionWithReferencedTypeLocal(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getDefinitionWithReferencedTypeLocal_Property(lookupContext));
				}
				
				public static Optional<Boolean> getDefinitionWithReferencedTypeLocal(NamedElement lookupContext) {
					return getDefinitionWithReferencedTypeLocal(lookupContext, Optional.empty());
				}
				
				public static Optional<Boolean> getDefinitionWithReferencedTypeLocal(NamedElement lookupContext, Mode mode) {
					return getDefinitionWithReferencedTypeLocal(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Boolean> getDefinitionWithReferencedTypeLocal(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getDefinitionWithReferencedTypeLocal_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((BooleanLiteral) resolved).getValue());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getDefinitionWithReferencedTypeLocal_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + DEFINITION_WITH_REFERENCED_TYPE_LOCAL__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getDefinitionWithReferencedTypeLocal_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getDefinitionWithReferencedTypeLocal_Property(lookupContext));
				}
				
				// Lookup methods for ps1::definition_with_referenced_type_other_file
				
				public static final String DEFINITION_WITH_REFERENCED_TYPE_OTHER_FILE__NAME = "definition_with_referenced_type_other_file";
				
				public static boolean acceptsDefinitionWithReferencedTypeOtherFile(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getDefinitionWithReferencedTypeOtherFile_Property(lookupContext));
				}
				
				public static Optional<Color> getDefinitionWithReferencedTypeOtherFile(NamedElement lookupContext) {
					return getDefinitionWithReferencedTypeOtherFile(lookupContext, Optional.empty());
				}
				
				public static Optional<Color> getDefinitionWithReferencedTypeOtherFile(NamedElement lookupContext, Mode mode) {
					return getDefinitionWithReferencedTypeOtherFile(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Color> getDefinitionWithReferencedTypeOtherFile(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getDefinitionWithReferencedTypeOtherFile_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(Color.valueOf(resolved));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getDefinitionWithReferencedTypeOtherFile_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + DEFINITION_WITH_REFERENCED_TYPE_OTHER_FILE__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getDefinitionWithReferencedTypeOtherFile_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getDefinitionWithReferencedTypeOtherFile_Property(lookupContext));
				}
				
				// Lookup methods for ps1::definition_with_underscore_import
				
				public static final String DEFINITION_WITH_UNDERSCORE_IMPORT__NAME = "definition_with_underscore_import";
				
				public static boolean acceptsDefinitionWithUnderscoreImport(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getDefinitionWithUnderscoreImport_Property(lookupContext));
				}
				
				public static Optional<LanguageType> getDefinitionWithUnderscoreImport(NamedElement lookupContext) {
					return getDefinitionWithUnderscoreImport(lookupContext, Optional.empty());
				}
				
				public static Optional<LanguageType> getDefinitionWithUnderscoreImport(NamedElement lookupContext, Mode mode) {
					return getDefinitionWithUnderscoreImport(lookupContext, Optional.of(mode));
				}
				
				public static Optional<LanguageType> getDefinitionWithUnderscoreImport(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getDefinitionWithUnderscoreImport_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(LanguageType.valueOf(resolved));
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getDefinitionWithUnderscoreImport_Property(EObject lookupContext) {
					String name = PS1__NAME + "::" + DEFINITION_WITH_UNDERSCORE_IMPORT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getDefinitionWithUnderscoreImport_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getDefinitionWithUnderscoreImport_Property(lookupContext));
				}
			}
		'''
		val unitsDefinition = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum UnitsDefinition implements GeneratedUnits<UnitsDefinition> {
				M(1.0, "m", "__synthetic2.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedLiteral.0"),
				KM(1000.0, "km", "__synthetic2.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private UnitsDefinition(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static UnitsDefinition valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(UnitsDefinition target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val enumDefinition = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.pluginsupport.properties.GeneratedEnumeration;
			
			public enum EnumDefinition implements GeneratedEnumeration {
				WASHINGTON("washington", "__synthetic2.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.0"),
				LINCOLN("lincoln", "__synthetic2.aadl#/0/@ownedProperty.4/@ownedPropertyType/@ownedLiteral.1");
				
				private final String originalName;
				private final URI uri;
				
				private EnumDefinition(String originalName, String uri) {
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static EnumDefinition valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public URI getURI() {
					return uri;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val recordDefinition = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.BasicPropertyAssociation;
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.GeneratedRecord;
			
			public class RecordDefinition extends GeneratedRecord {
				public static final String FIELD__NAME = "field";
				public static final URI FIELD__URI = URI.createURI("__synthetic2.aadl#/0/@ownedProperty.9/@ownedPropertyType/@ownedField.0");
				
				private final Optional<Boolean> field;
				
				public RecordDefinition(Optional<Boolean> field) {
					this.field = field;
				}
				
				public RecordDefinition(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<Boolean> field_local;
					try {
						field_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((BooleanLiteral) resolved).getValue();
						});
					} catch (PropertyNotPresentException e) {
						field_local = Optional.empty();
					}
					this.field = field_local;
				}
				
				public RecordDefinition(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<Boolean> field_local;
					try {
						field_local = findFieldValue(recordValue, FIELD__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue());
							return ((BooleanLiteral) resolved).getValue();
						});
					} catch (PropertyNotPresentException e) {
						field_local = Optional.empty();
					}
					this.field = field_local;
				}
				
				public Optional<Boolean> getField() {
					return field;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!field.isPresent()) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					field.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD__URI, FIELD__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
					});
					return recordValue;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(field);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordDefinition)) {
						return false;
					}
					RecordDefinition other = (RecordDefinition) obj;
					return Objects.equals(this.field, other.field);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field.ifPresent(field -> {
						builder.append(FIELD__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(ps1, enumTest, ps2))
		assertEquals("src-gen/ps1", results.packagePath)
		assertEquals(4, results.classes.size)
		
		assertEquals("Ps1.java", results.classes.get(0).fileName)
		assertEquals(ps1Class.toString, results.classes.get(0).contents)
		
		assertEquals("UnitsDefinition.java", results.classes.get(1).fileName)
		assertEquals(unitsDefinition.toString, results.classes.get(1).contents)
		
		assertEquals("EnumDefinition.java", results.classes.get(2).fileName)
		assertEquals(enumDefinition.toString, results.classes.get(2).contents)
		
		assertEquals("RecordDefinition.java", results.classes.get(3).fileName)
		assertEquals(recordDefinition.toString, results.classes.get(3).contents)
	}
	
	@Test
	def void testEmptyPropertySet() {
		val emptyPs = '''
			property set empty_ps is
			end empty_ps;
		'''
		val emptyPsClass = '''
			package emptyps;
			
			public final class EmptyPs {
				public static final String EMPTY_PS__NAME = "empty_ps";
				
				private EmptyPs() {}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(emptyPs))
		assertEquals("src-gen/emptyps", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("EmptyPs.java", results.classes.head.fileName)
		assertEquals(emptyPsClass.toString, results.classes.head.contents)
	}
	
	@Test
	def void testSingleDefinition() {
		val singleDefinitionPs = '''
			property set single_definition_ps is
				sole_definition: aadlboolean applies to (all);
			end single_definition_ps;
		'''
		val singleDefinitionPsClass = '''
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
				public static final String SINGLE_DEFINITION_PS__NAME = "single_definition_ps";
				
				private SingleDefinitionPs() {}
				
				// Lookup methods for single_definition_ps::sole_definition
				
				public static final String SOLE_DEFINITION__NAME = "sole_definition";
				
				public static boolean acceptsSoleDefinition(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getSoleDefinition_Property(lookupContext));
				}
				
				public static Optional<Boolean> getSoleDefinition(NamedElement lookupContext) {
					return getSoleDefinition(lookupContext, Optional.empty());
				}
				
				public static Optional<Boolean> getSoleDefinition(NamedElement lookupContext, Mode mode) {
					return getSoleDefinition(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Boolean> getSoleDefinition(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getSoleDefinition_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((BooleanLiteral) resolved).getValue());
					} catch (PropertyNotPresentException | PropertyDoesNotApplyToHolderException e) {
						return Optional.empty();
					}
				}
				
				public static Property getSoleDefinition_Property(EObject lookupContext) {
					String name = SINGLE_DEFINITION_PS__NAME + "::" + SOLE_DEFINITION__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getSoleDefinition_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getSoleDefinition_Property(lookupContext));
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(singleDefinitionPs))
		assertEquals("src-gen/singledefinitionps", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("SingleDefinitionPs.java", results.classes.head.fileName)
		assertEquals(singleDefinitionPsClass.toString, results.classes.head.contents)
	}
}