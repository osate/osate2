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
class ListDefinitionTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testListDefinition() {
		val ps2 = '''
			property set ps2 is
				mass: type units (g, kg => g * 1000);
				mass_type: type aadlreal units ps2::mass;
				color: type enumeration (red, green, blue);
				basic_range: type range of aadlreal;
				basic_record: type record (field: aadlreal;);
			end ps2;
		'''
		val ps1 = '''
			property set ps1 is
				with ps2;
				
				time: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				integer_owned_units: type aadlinteger units (mm, cm => mm * 10, m => cm * 100);
				enum_type_1: type enumeration (one, two, three);
				range_of_integer_no_units: type range of aadlinteger;
				record_of_boolean: type record (field: aadlboolean;);
				
				list_1_boolean: list of aadlboolean applies to (all);
				list_2_boolean: list of list of aadlboolean applies to (all);
				list_3_boolean: list of list of list of aadlboolean applies to (all);
				list_4_boolean: list of list of list of list of aadlboolean applies to (all);
				list_5_boolean: list of list of list of list of list of aadlboolean applies to (all);
				
				list_1_string: list of aadlstring applies to (all);
				list_1_classifier: list of classifier applies to (all);
				list_1_integer_no_units: list of aadlinteger applies to (all);
				list_1_real_no_units: list of aadlreal applies to (all);
				list_1_reference: list of reference applies to (all);
				
				list_1_owned_enum: list of enumeration (mercury, venus, earth, mars) applies to (all);
				list_1_owned_units: list of units (cm, m => cm * 100) applies to (all);
				list_1_owned_integer_with_units: list of aadlinteger units ps1::time applies to (all);
				list_1_owned_range: list of range of aadlinteger applies to (all);
				list_1_owned_record: list of record (
					boolean_field: aadlboolean;
					string_field: aadlstring;
					record_field: record (
						integer_field: aadlinteger;
						real_field: aadlreal;
					);
				) applies to (all);
				
				list_1_referenced_enum_no_import: list of ps1::enum_type_1 applies to (all);
				list_1_referenced_enum_with_import: list of ps2::color applies to (all);
				list_1_referenced_units_no_import: list of ps1::time applies to (all);
				list_1_referenced_units_with_import: list of ps2::mass applies to (all);
				list_1_referenced_number_with_units_no_import: list of ps1::integer_owned_units applies to (all);
				list_1_referenced_number_with_units_with_import: list of ps2::mass_type applies to (all);
				list_1_referenced_range_no_import: list of ps1::range_of_integer_no_units applies to (all);
				list_1_referenced_range_with_import: list of ps2::basic_range applies to (all);
				list_1_referenced_record_no_import: list of ps1::record_of_boolean applies to (all);
				list_1_referenced_record_with_import: list of ps2::basic_record applies to (all);
				
				list_3_owned_enum: list of list of list of enumeration (north_america, south_america) applies to (all);
				list_5_owned_range: list of list of list of list of list of range of aadlreal applies to (all);
				list_3_referenced_enum_no_import: list of list of list of ps1::enum_type_1 applies to (all);
				list_5_referenced_range_with_import: list of list of list of list of list of ps2::basic_range applies to (all);
			end ps1;
		'''
		val ps1Class = '''
			package ps1;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.Classifier;
			import org.osate.aadl2.ClassifierValue;
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			import org.osate.aadl2.StringLiteral;
			import org.osate.aadl2.instance.InstanceObject;
			import org.osate.aadl2.instance.InstanceReferenceValue;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.IntegerRange;
			import org.osate.pluginsupport.properties.IntegerWithUnits;
			import org.osate.pluginsupport.properties.RealRange;
			import org.osate.pluginsupport.properties.RealWithUnits;
			
			import ps2.BasicRecord;
			import ps2.Color;
			import ps2.Mass;
			
			public class Ps1 {
				public static final String PS1__NAME = "ps1";
				
				public static final String LIST_1_BOOLEAN__NAME = "list_1_boolean";
				public static final String LIST_2_BOOLEAN__NAME = "list_2_boolean";
				public static final String LIST_3_BOOLEAN__NAME = "list_3_boolean";
				public static final String LIST_4_BOOLEAN__NAME = "list_4_boolean";
				public static final String LIST_5_BOOLEAN__NAME = "list_5_boolean";
				public static final String LIST_1_STRING__NAME = "list_1_string";
				public static final String LIST_1_CLASSIFIER__NAME = "list_1_classifier";
				public static final String LIST_1_INTEGER_NO_UNITS__NAME = "list_1_integer_no_units";
				public static final String LIST_1_REAL_NO_UNITS__NAME = "list_1_real_no_units";
				public static final String LIST_1_REFERENCE__NAME = "list_1_reference";
				public static final String LIST_1_OWNED_ENUM__NAME = "list_1_owned_enum";
				public static final String LIST_1_OWNED_UNITS__NAME = "list_1_owned_units";
				public static final String LIST_1_OWNED_INTEGER_WITH_UNITS__NAME = "list_1_owned_integer_with_units";
				public static final String LIST_1_OWNED_RANGE__NAME = "list_1_owned_range";
				public static final String LIST_1_OWNED_RECORD__NAME = "list_1_owned_record";
				public static final String LIST_1_REFERENCED_ENUM_NO_IMPORT__NAME = "list_1_referenced_enum_no_import";
				public static final String LIST_1_REFERENCED_ENUM_WITH_IMPORT__NAME = "list_1_referenced_enum_with_import";
				public static final String LIST_1_REFERENCED_UNITS_NO_IMPORT__NAME = "list_1_referenced_units_no_import";
				public static final String LIST_1_REFERENCED_UNITS_WITH_IMPORT__NAME = "list_1_referenced_units_with_import";
				public static final String LIST_1_REFERENCED_NUMBER_WITH_UNITS_NO_IMPORT__NAME = "list_1_referenced_number_with_units_no_import";
				public static final String LIST_1_REFERENCED_NUMBER_WITH_UNITS_WITH_IMPORT__NAME = "list_1_referenced_number_with_units_with_import";
				public static final String LIST_1_REFERENCED_RANGE_NO_IMPORT__NAME = "list_1_referenced_range_no_import";
				public static final String LIST_1_REFERENCED_RANGE_WITH_IMPORT__NAME = "list_1_referenced_range_with_import";
				public static final String LIST_1_REFERENCED_RECORD_NO_IMPORT__NAME = "list_1_referenced_record_no_import";
				public static final String LIST_1_REFERENCED_RECORD_WITH_IMPORT__NAME = "list_1_referenced_record_with_import";
				public static final String LIST_3_OWNED_ENUM__NAME = "list_3_owned_enum";
				public static final String LIST_5_OWNED_RANGE__NAME = "list_5_owned_range";
				public static final String LIST_3_REFERENCED_ENUM_NO_IMPORT__NAME = "list_3_referenced_enum_no_import";
				public static final String LIST_5_REFERENCED_RANGE_WITH_IMPORT__NAME = "list_5_referenced_range_with_import";
				
				public static Optional<List<Boolean>> getList1Boolean(NamedElement lookupContext) {
					return getList1Boolean(lookupContext, Optional.empty());
				}
				
				public static Optional<List<Boolean>> getList1Boolean(NamedElement lookupContext, Mode mode) {
					return getList1Boolean(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<Boolean>> getList1Boolean(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_boolean";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((BooleanLiteral) resolved1).getValue();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1Boolean_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_boolean";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<Boolean>>> getList2Boolean(NamedElement lookupContext) {
					return getList2Boolean(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<Boolean>>> getList2Boolean(NamedElement lookupContext, Mode mode) {
					return getList2Boolean(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<Boolean>>> getList2Boolean(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_2_boolean";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((BooleanLiteral) resolved2).getValue();
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList2Boolean_EObject(NamedElement lookupContext) {
					String name = "ps1::list_2_boolean";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<List<Boolean>>>> getList3Boolean(NamedElement lookupContext) {
					return getList3Boolean(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<Boolean>>>> getList3Boolean(NamedElement lookupContext, Mode mode) {
					return getList3Boolean(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<Boolean>>>> getList3Boolean(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_3_boolean";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
									PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
									return ((BooleanLiteral) resolved3).getValue();
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList3Boolean_EObject(NamedElement lookupContext) {
					String name = "ps1::list_3_boolean";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<List<List<Boolean>>>>> getList4Boolean(NamedElement lookupContext) {
					return getList4Boolean(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List<Boolean>>>>> getList4Boolean(NamedElement lookupContext, Mode mode) {
					return getList4Boolean(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List<Boolean>>>>> getList4Boolean(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_4_boolean";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
									PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
									return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
										PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
										return ((BooleanLiteral) resolved4).getValue();
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList4Boolean_EObject(NamedElement lookupContext) {
					String name = "ps1::list_4_boolean";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<List<List<List<Boolean>>>>>> getList5Boolean(NamedElement lookupContext) {
					return getList5Boolean(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List<List<Boolean>>>>>> getList5Boolean(NamedElement lookupContext, Mode mode) {
					return getList5Boolean(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List<List<Boolean>>>>>> getList5Boolean(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_5_boolean";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
									PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
									return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
										PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
										return ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
											PropertyExpression resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
											return ((BooleanLiteral) resolved5).getValue();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList5Boolean_EObject(NamedElement lookupContext) {
					String name = "ps1::list_5_boolean";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<String>> getList1String(NamedElement lookupContext) {
					return getList1String(lookupContext, Optional.empty());
				}
				
				public static Optional<List<String>> getList1String(NamedElement lookupContext, Mode mode) {
					return getList1String(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<String>> getList1String(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_string";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((StringLiteral) resolved1).getValue();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1String_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_string";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<Classifier>> getList1Classifier(NamedElement lookupContext) {
					return getList1Classifier(lookupContext, Optional.empty());
				}
				
				public static Optional<List<Classifier>> getList1Classifier(NamedElement lookupContext, Mode mode) {
					return getList1Classifier(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<Classifier>> getList1Classifier(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_classifier";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ClassifierValue) resolved1).getClassifier();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1Classifier_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_classifier";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<Long>> getList1IntegerNoUnits(NamedElement lookupContext) {
					return getList1IntegerNoUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<Long>> getList1IntegerNoUnits(NamedElement lookupContext, Mode mode) {
					return getList1IntegerNoUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<Long>> getList1IntegerNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_integer_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((IntegerLiteral) resolved1).getValue();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1IntegerNoUnits_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_integer_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<Double>> getList1RealNoUnits(NamedElement lookupContext) {
					return getList1RealNoUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<Double>> getList1RealNoUnits(NamedElement lookupContext, Mode mode) {
					return getList1RealNoUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<Double>> getList1RealNoUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_real_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((RealLiteral) resolved1).getValue();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1RealNoUnits_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_real_no_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<InstanceObject>> getList1Reference(NamedElement lookupContext) {
					return getList1Reference(lookupContext, Optional.empty());
				}
				
				public static Optional<List<InstanceObject>> getList1Reference(NamedElement lookupContext, Mode mode) {
					return getList1Reference(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<InstanceObject>> getList1Reference(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_reference";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((InstanceReferenceValue) resolved1).getReferencedInstanceObject();
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1Reference_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_reference";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List1OwnedEnum>> getList1OwnedEnum(NamedElement lookupContext) {
					return getList1OwnedEnum(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List1OwnedEnum>> getList1OwnedEnum(NamedElement lookupContext, Mode mode) {
					return getList1OwnedEnum(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List1OwnedEnum>> getList1OwnedEnum(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_owned_enum";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return List1OwnedEnum.valueOf(resolved1);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1OwnedEnum_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_owned_enum";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List1OwnedUnits>> getList1OwnedUnits(NamedElement lookupContext) {
					return getList1OwnedUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List1OwnedUnits>> getList1OwnedUnits(NamedElement lookupContext, Mode mode) {
					return getList1OwnedUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List1OwnedUnits>> getList1OwnedUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return List1OwnedUnits.valueOf(resolved1);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1OwnedUnits_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_owned_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<IntegerWithUnits<Time>>> getList1OwnedIntegerWithUnits(NamedElement lookupContext) {
					return getList1OwnedIntegerWithUnits(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerWithUnits<Time>>> getList1OwnedIntegerWithUnits(NamedElement lookupContext, Mode mode) {
					return getList1OwnedIntegerWithUnits(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerWithUnits<Time>>> getList1OwnedIntegerWithUnits(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_owned_integer_with_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerWithUnits<>(resolved1, Time.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1OwnedIntegerWithUnits_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_owned_integer_with_units";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<IntegerRange>> getList1OwnedRange(NamedElement lookupContext) {
					return getList1OwnedRange(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerRange>> getList1OwnedRange(NamedElement lookupContext, Mode mode) {
					return getList1OwnedRange(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerRange>> getList1OwnedRange(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_owned_range";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerRange(resolved1, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1OwnedRange_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_owned_range";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List1OwnedRecord>> getList1OwnedRecord(NamedElement lookupContext) {
					return getList1OwnedRecord(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List1OwnedRecord>> getList1OwnedRecord(NamedElement lookupContext, Mode mode) {
					return getList1OwnedRecord(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List1OwnedRecord>> getList1OwnedRecord(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_owned_record";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new List1OwnedRecord(resolved1, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1OwnedRecord_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_owned_record";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<EnumType1>> getList1ReferencedEnumNoImport(NamedElement lookupContext) {
					return getList1ReferencedEnumNoImport(lookupContext, Optional.empty());
				}
				
				public static Optional<List<EnumType1>> getList1ReferencedEnumNoImport(NamedElement lookupContext, Mode mode) {
					return getList1ReferencedEnumNoImport(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<EnumType1>> getList1ReferencedEnumNoImport(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_referenced_enum_no_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return EnumType1.valueOf(resolved1);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1ReferencedEnumNoImport_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_referenced_enum_no_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<Color>> getList1ReferencedEnumWithImport(NamedElement lookupContext) {
					return getList1ReferencedEnumWithImport(lookupContext, Optional.empty());
				}
				
				public static Optional<List<Color>> getList1ReferencedEnumWithImport(NamedElement lookupContext, Mode mode) {
					return getList1ReferencedEnumWithImport(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<Color>> getList1ReferencedEnumWithImport(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_referenced_enum_with_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return Color.valueOf(resolved1);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1ReferencedEnumWithImport_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_referenced_enum_with_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<Time>> getList1ReferencedUnitsNoImport(NamedElement lookupContext) {
					return getList1ReferencedUnitsNoImport(lookupContext, Optional.empty());
				}
				
				public static Optional<List<Time>> getList1ReferencedUnitsNoImport(NamedElement lookupContext, Mode mode) {
					return getList1ReferencedUnitsNoImport(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<Time>> getList1ReferencedUnitsNoImport(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_referenced_units_no_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return Time.valueOf(resolved1);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1ReferencedUnitsNoImport_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_referenced_units_no_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<Mass>> getList1ReferencedUnitsWithImport(NamedElement lookupContext) {
					return getList1ReferencedUnitsWithImport(lookupContext, Optional.empty());
				}
				
				public static Optional<List<Mass>> getList1ReferencedUnitsWithImport(NamedElement lookupContext, Mode mode) {
					return getList1ReferencedUnitsWithImport(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<Mass>> getList1ReferencedUnitsWithImport(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_referenced_units_with_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return Mass.valueOf(resolved1);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1ReferencedUnitsWithImport_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_referenced_units_with_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<IntegerWithUnits<IntegerOwnedUnits>>> getList1ReferencedNumberWithUnitsNoImport(NamedElement lookupContext) {
					return getList1ReferencedNumberWithUnitsNoImport(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerWithUnits<IntegerOwnedUnits>>> getList1ReferencedNumberWithUnitsNoImport(NamedElement lookupContext, Mode mode) {
					return getList1ReferencedNumberWithUnitsNoImport(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerWithUnits<IntegerOwnedUnits>>> getList1ReferencedNumberWithUnitsNoImport(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_referenced_number_with_units_no_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerWithUnits<>(resolved1, IntegerOwnedUnits.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1ReferencedNumberWithUnitsNoImport_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_referenced_number_with_units_no_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<RealWithUnits<Mass>>> getList1ReferencedNumberWithUnitsWithImport(NamedElement lookupContext) {
					return getList1ReferencedNumberWithUnitsWithImport(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RealWithUnits<Mass>>> getList1ReferencedNumberWithUnitsWithImport(NamedElement lookupContext, Mode mode) {
					return getList1ReferencedNumberWithUnitsWithImport(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RealWithUnits<Mass>>> getList1ReferencedNumberWithUnitsWithImport(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_referenced_number_with_units_with_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RealWithUnits<>(resolved1, Mass.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1ReferencedNumberWithUnitsWithImport_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_referenced_number_with_units_with_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<IntegerRange>> getList1ReferencedRangeNoImport(NamedElement lookupContext) {
					return getList1ReferencedRangeNoImport(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerRange>> getList1ReferencedRangeNoImport(NamedElement lookupContext, Mode mode) {
					return getList1ReferencedRangeNoImport(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerRange>> getList1ReferencedRangeNoImport(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_referenced_range_no_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerRange(resolved1, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1ReferencedRangeNoImport_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_referenced_range_no_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<RealRange>> getList1ReferencedRangeWithImport(NamedElement lookupContext) {
					return getList1ReferencedRangeWithImport(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RealRange>> getList1ReferencedRangeWithImport(NamedElement lookupContext, Mode mode) {
					return getList1ReferencedRangeWithImport(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RealRange>> getList1ReferencedRangeWithImport(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_referenced_range_with_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RealRange(resolved1, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1ReferencedRangeWithImport_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_referenced_range_with_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<RecordOfBoolean>> getList1ReferencedRecordNoImport(NamedElement lookupContext) {
					return getList1ReferencedRecordNoImport(lookupContext, Optional.empty());
				}
				
				public static Optional<List<RecordOfBoolean>> getList1ReferencedRecordNoImport(NamedElement lookupContext, Mode mode) {
					return getList1ReferencedRecordNoImport(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<RecordOfBoolean>> getList1ReferencedRecordNoImport(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_referenced_record_no_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new RecordOfBoolean(resolved1, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1ReferencedRecordNoImport_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_referenced_record_no_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<BasicRecord>> getList1ReferencedRecordWithImport(NamedElement lookupContext) {
					return getList1ReferencedRecordWithImport(lookupContext, Optional.empty());
				}
				
				public static Optional<List<BasicRecord>> getList1ReferencedRecordWithImport(NamedElement lookupContext, Mode mode) {
					return getList1ReferencedRecordWithImport(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<BasicRecord>> getList1ReferencedRecordWithImport(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_1_referenced_record_with_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new BasicRecord(resolved1, lookupContext, mode);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1ReferencedRecordWithImport_EObject(NamedElement lookupContext) {
					String name = "ps1::list_1_referenced_record_with_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<List<List3OwnedEnum>>>> getList3OwnedEnum(NamedElement lookupContext) {
					return getList3OwnedEnum(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List3OwnedEnum>>>> getList3OwnedEnum(NamedElement lookupContext, Mode mode) {
					return getList3OwnedEnum(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List3OwnedEnum>>>> getList3OwnedEnum(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_3_owned_enum";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
									PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
									return List3OwnedEnum.valueOf(resolved3);
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList3OwnedEnum_EObject(NamedElement lookupContext) {
					String name = "ps1::list_3_owned_enum";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<List<List<List<RealRange>>>>>> getList5OwnedRange(NamedElement lookupContext) {
					return getList5OwnedRange(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List<List<RealRange>>>>>> getList5OwnedRange(NamedElement lookupContext, Mode mode) {
					return getList5OwnedRange(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List<List<RealRange>>>>>> getList5OwnedRange(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_5_owned_range";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
									PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
									return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
										PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
										return ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
											PropertyExpression resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
											return new RealRange(resolved5, lookupContext, mode);
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList5OwnedRange_EObject(NamedElement lookupContext) {
					String name = "ps1::list_5_owned_range";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<List<EnumType1>>>> getList3ReferencedEnumNoImport(NamedElement lookupContext) {
					return getList3ReferencedEnumNoImport(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<EnumType1>>>> getList3ReferencedEnumNoImport(NamedElement lookupContext, Mode mode) {
					return getList3ReferencedEnumNoImport(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<EnumType1>>>> getList3ReferencedEnumNoImport(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_3_referenced_enum_no_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
									PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
									return EnumType1.valueOf(resolved3);
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList3ReferencedEnumNoImport_EObject(NamedElement lookupContext) {
					String name = "ps1::list_3_referenced_enum_no_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<List<List<List<RealRange>>>>>> getList5ReferencedRangeWithImport(NamedElement lookupContext) {
					return getList5ReferencedRangeWithImport(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List<List<RealRange>>>>>> getList5ReferencedRangeWithImport(NamedElement lookupContext, Mode mode) {
					return getList5ReferencedRangeWithImport(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List<List<RealRange>>>>>> getList5ReferencedRangeWithImport(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "ps1::list_5_referenced_range_with_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
									PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3, lookupContext, mode);
									return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
										PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4, lookupContext, mode);
										return ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
											PropertyExpression resolved5 = CodeGenUtil.resolveNamedValue(element5, lookupContext, mode);
											return new RealRange(resolved5, lookupContext, mode);
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList5ReferencedRangeWithImport_EObject(NamedElement lookupContext) {
					String name = "ps1::list_5_referenced_range_with_import";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val time = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum Time implements GeneratedUnits<Time> {
				SEC(1.0, "sec", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
				MIN(60.0, "min", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
				HR(3600.0, "hr", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
				DAY(86400.0, "day", "__synthetic1.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private Time(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static Time valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(Time target) {
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
		val integerOwnedUnits = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum IntegerOwnedUnits implements GeneratedUnits<IntegerOwnedUnits> {
				MM(1.0, "mm", "__synthetic1.aadl#/0/@ownedPropertyType.1/@ownedUnitsType/@ownedLiteral.0"),
				CM(10.0, "cm", "__synthetic1.aadl#/0/@ownedPropertyType.1/@ownedUnitsType/@ownedLiteral.1"),
				M(1000.0, "m", "__synthetic1.aadl#/0/@ownedPropertyType.1/@ownedUnitsType/@ownedLiteral.2");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private IntegerOwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static IntegerOwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(IntegerOwnedUnits target) {
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
		val enumType1 = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.pluginsupport.properties.GeneratedEnumeration;
			
			public enum EnumType1 implements GeneratedEnumeration {
				ONE("one", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedLiteral.0"),
				TWO("two", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedLiteral.1"),
				THREE("three", "__synthetic1.aadl#/0/@ownedPropertyType.2/@ownedLiteral.2");
				
				private final String originalName;
				private final URI uri;
				
				private EnumType1(String originalName, String uri) {
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static EnumType1 valueOf(PropertyExpression propertyExpression) {
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
		val recordOfBoolean = '''
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
			
			public class RecordOfBoolean extends GeneratedRecord {
				public static final String FIELD__NAME = "field";
				public static final URI FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedPropertyType.4/@ownedField.0");
				
				private final Optional<Boolean> field;
				
				public RecordOfBoolean(Optional<Boolean> field) {
					this.field = field;
				}
				
				public RecordOfBoolean(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
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
					if (!(obj instanceof RecordOfBoolean)) {
						return false;
					}
					RecordOfBoolean other = (RecordOfBoolean) obj;
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
		val list1OwnedEnum = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.pluginsupport.properties.GeneratedEnumeration;
			
			public enum List1OwnedEnum implements GeneratedEnumeration {
				MERCURY("mercury", "__synthetic1.aadl#/0/@ownedProperty.10/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
				VENUS("venus", "__synthetic1.aadl#/0/@ownedProperty.10/@ownedPropertyType/@ownedElementType/@ownedLiteral.1"),
				EARTH("earth", "__synthetic1.aadl#/0/@ownedProperty.10/@ownedPropertyType/@ownedElementType/@ownedLiteral.2"),
				MARS("mars", "__synthetic1.aadl#/0/@ownedProperty.10/@ownedPropertyType/@ownedElementType/@ownedLiteral.3");
				
				private final String originalName;
				private final URI uri;
				
				private List1OwnedEnum(String originalName, String uri) {
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static List1OwnedEnum valueOf(PropertyExpression propertyExpression) {
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
		val list1OwnedUnits = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum List1OwnedUnits implements GeneratedUnits<List1OwnedUnits> {
				CM(1.0, "cm", "__synthetic1.aadl#/0/@ownedProperty.11/@ownedPropertyType/@ownedElementType/@ownedLiteral.0"),
				M(100.0, "m", "__synthetic1.aadl#/0/@ownedProperty.11/@ownedPropertyType/@ownedElementType/@ownedLiteral.1");
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private List1OwnedUnits(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static List1OwnedUnits valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(List1OwnedUnits target) {
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
		val list1OwnedRecord = '''
			package ps1;
			
			import java.util.Objects;
			import java.util.Optional;
			import java.util.OptionalDouble;
			import java.util.OptionalLong;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.BasicPropertyAssociation;
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RealLiteral;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.StringLiteral;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.GeneratedRecord;
			
			public class List1OwnedRecord extends GeneratedRecord {
				public static final String BOOLEAN_FIELD__NAME = "boolean_field";
				public static final String STRING_FIELD__NAME = "string_field";
				public static final String RECORD_FIELD__NAME = "record_field";
				public static final URI BOOLEAN_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.14/@ownedPropertyType/@ownedElementType/@ownedField.0");
				public static final URI STRING_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.14/@ownedPropertyType/@ownedElementType/@ownedField.1");
				public static final URI RECORD_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.14/@ownedPropertyType/@ownedElementType/@ownedField.2");
				
				private final Optional<Boolean> booleanField;
				private final Optional<String> stringField;
				private final Optional<RecordField_FieldType> recordField;
				
				public List1OwnedRecord(
						Optional<Boolean> booleanField,
						Optional<String> stringField,
						Optional<RecordField_FieldType> recordField
				) {
					this.booleanField = booleanField;
					this.stringField = stringField;
					this.recordField = recordField;
				}
				
				public List1OwnedRecord(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<Boolean> booleanField_local;
					try {
						booleanField_local = findFieldValue(recordValue, BOOLEAN_FIELD__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((BooleanLiteral) resolved).getValue();
						});
					} catch (PropertyNotPresentException e) {
						booleanField_local = Optional.empty();
					}
					this.booleanField = booleanField_local;
					
					Optional<String> stringField_local;
					try {
						stringField_local = findFieldValue(recordValue, STRING_FIELD__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((StringLiteral) resolved).getValue();
						});
					} catch (PropertyNotPresentException e) {
						stringField_local = Optional.empty();
					}
					this.stringField = stringField_local;
					
					Optional<RecordField_FieldType> recordField_local;
					try {
						recordField_local = findFieldValue(recordValue, RECORD_FIELD__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return new RecordField_FieldType(resolved, lookupContext, mode);
						});
					} catch (PropertyNotPresentException e) {
						recordField_local = Optional.empty();
					}
					this.recordField = recordField_local;
				}
				
				public Optional<Boolean> getBooleanField() {
					return booleanField;
				}
				
				public Optional<String> getStringField() {
					return stringField;
				}
				
				public Optional<RecordField_FieldType> getRecordField() {
					return recordField;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!booleanField.isPresent()
							&& !stringField.isPresent()
							&& !recordField.isPresent()
					) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					booleanField.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, BOOLEAN_FIELD__URI, BOOLEAN_FIELD__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
					});
					stringField.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, STRING_FIELD__URI, STRING_FIELD__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
					});
					recordField.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, RECORD_FIELD__URI, RECORD_FIELD__NAME));
						fieldAssociation.setOwnedValue(field.toPropertyExpression(resourceSet));
					});
					return recordValue;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							booleanField,
							stringField,
							recordField
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof List1OwnedRecord)) {
						return false;
					}
					List1OwnedRecord other = (List1OwnedRecord) obj;
					return Objects.equals(this.booleanField, other.booleanField)
							&& Objects.equals(this.stringField, other.stringField)
							&& Objects.equals(this.recordField, other.recordField);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.booleanField.ifPresent(field -> {
						builder.append(BOOLEAN_FIELD__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					this.stringField.ifPresent(field -> {
						builder.append(STRING_FIELD__NAME);
						builder.append(" => \"");
						builder.append(field);
						builder.append("\";");
					});
					this.recordField.ifPresent(field -> {
						builder.append(RECORD_FIELD__NAME);
						builder.append(" => ");
						builder.append(field);
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public static class RecordField_FieldType extends GeneratedRecord {
					public static final String INTEGER_FIELD__NAME = "integer_field";
					public static final String REAL_FIELD__NAME = "real_field";
					public static final URI INTEGER_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.14/@ownedPropertyType/@ownedElementType/@ownedField.2/@ownedPropertyType/@ownedField.0");
					public static final URI REAL_FIELD__URI = URI.createURI("__synthetic1.aadl#/0/@ownedProperty.14/@ownedPropertyType/@ownedElementType/@ownedField.2/@ownedPropertyType/@ownedField.1");
					
					private final OptionalLong integerField;
					private final OptionalDouble realField;
					
					public RecordField_FieldType(
							OptionalLong integerField,
							OptionalDouble realField
					) {
						this.integerField = integerField;
						this.realField = realField;
					}
					
					public RecordField_FieldType(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
						RecordValue recordValue = (RecordValue) propertyExpression;
						
						OptionalLong integerField_local;
						try {
							integerField_local = findFieldValue(recordValue, INTEGER_FIELD__NAME).map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
								return ((IntegerLiteral) resolved).getValue();
							}).map(OptionalLong::of).orElse(OptionalLong.empty());
						} catch (PropertyNotPresentException e) {
							integerField_local = OptionalLong.empty();
						}
						this.integerField = integerField_local;
						
						OptionalDouble realField_local;
						try {
							realField_local = findFieldValue(recordValue, REAL_FIELD__NAME).map(field -> {
								PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
								return ((RealLiteral) resolved).getValue();
							}).map(OptionalDouble::of).orElse(OptionalDouble.empty());
						} catch (PropertyNotPresentException e) {
							realField_local = OptionalDouble.empty();
						}
						this.realField = realField_local;
					}
					
					public OptionalLong getIntegerField() {
						return integerField;
					}
					
					public OptionalDouble getRealField() {
						return realField;
					}
					
					@Override
					public RecordValue toPropertyExpression(ResourceSet resourceSet) {
						if (!integerField.isPresent()
								&& !realField.isPresent()
						) {
							throw new IllegalStateException("Record must have at least one field set.");
						}
						RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
						integerField.ifPresent(field -> {
							BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
							fieldAssociation.setProperty(loadField(resourceSet, INTEGER_FIELD__URI, INTEGER_FIELD__NAME));
							fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
						});
						realField.ifPresent(field -> {
							BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
							fieldAssociation.setProperty(loadField(resourceSet, REAL_FIELD__URI, REAL_FIELD__NAME));
							fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
						});
						return recordValue;
					}
					
					@Override
					public int hashCode() {
						return Objects.hash(
								integerField,
								realField
						);
					}
					
					@Override
					public boolean equals(Object obj) {
						if (this == obj) {
							return true;
						}
						if (!(obj instanceof RecordField_FieldType)) {
							return false;
						}
						RecordField_FieldType other = (RecordField_FieldType) obj;
						return Objects.equals(this.integerField, other.integerField)
								&& Objects.equals(this.realField, other.realField);
					}
					
					@Override
					public String toString() {
						StringBuilder builder = new StringBuilder();
						builder.append('[');
						this.integerField.ifPresent(field -> {
							builder.append(INTEGER_FIELD__NAME);
							builder.append(" => ");
							builder.append(field);
							builder.append(';');
						});
						this.realField.ifPresent(field -> {
							builder.append(REAL_FIELD__NAME);
							builder.append(" => ");
							builder.append(field);
							builder.append(';');
						});
						builder.append(']');
						return builder.toString();
					}
				}
			}
		'''
		val list3OwnedEnum = '''
			package ps1;
			
			import org.eclipse.emf.common.util.URI;
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.EnumerationLiteral;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.pluginsupport.properties.GeneratedEnumeration;
			
			public enum List3OwnedEnum implements GeneratedEnumeration {
				NORTH_AMERICA("north_america", "__synthetic1.aadl#/0/@ownedProperty.25/@ownedPropertyType/@ownedElementType/@ownedElementType/@ownedElementType/@ownedLiteral.0"),
				SOUTH_AMERICA("south_america", "__synthetic1.aadl#/0/@ownedProperty.25/@ownedPropertyType/@ownedElementType/@ownedElementType/@ownedElementType/@ownedLiteral.1");
				
				private final String originalName;
				private final URI uri;
				
				private List3OwnedEnum(String originalName, String uri) {
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static List3OwnedEnum valueOf(PropertyExpression propertyExpression) {
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
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(ps1, ps2))
		assertEquals("src-gen/ps1", results.packagePath)
		assertEquals(9, results.classes.size)
		
		assertEquals("Ps1.java", results.classes.get(0).fileName)
		assertEquals(ps1Class.toString, results.classes.get(0).contents)
		
		assertEquals("Time.java", results.classes.get(1).fileName)
		assertEquals(time.toString, results.classes.get(1).contents)
		
		assertEquals("IntegerOwnedUnits.java", results.classes.get(2).fileName)
		assertEquals(integerOwnedUnits.toString, results.classes.get(2).contents)
		
		assertEquals("EnumType1.java", results.classes.get(3).fileName)
		assertEquals(enumType1.toString, results.classes.get(3).contents)
		
		assertEquals("RecordOfBoolean.java", results.classes.get(4).fileName)
		assertEquals(recordOfBoolean.toString, results.classes.get(4).contents)
		
		assertEquals("List1OwnedEnum.java", results.classes.get(5).fileName)
		assertEquals(list1OwnedEnum.toString, results.classes.get(5).contents)
		
		assertEquals("List1OwnedUnits.java", results.classes.get(6).fileName)
		assertEquals(list1OwnedUnits.toString, results.classes.get(6).contents)
		
		assertEquals("List1OwnedRecord.java", results.classes.get(7).fileName)
		assertEquals(list1OwnedRecord.toString, results.classes.get(7).contents)
		
		assertEquals("List3OwnedEnum.java", results.classes.get(8).fileName)
		assertEquals(list3OwnedEnum.toString, results.classes.get(8).contents)
	}
}