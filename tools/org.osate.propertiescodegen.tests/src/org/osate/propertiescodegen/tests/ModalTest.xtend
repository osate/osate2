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
class ModalTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testModal() {
		val modalTest = '''
			property set modal_test is
				string_const_1: constant aadlstring => "First Constant Value";
				string_const_2: constant aadlstring => "Second Constant Value";
				string_const_3: constant aadlstring => modal_test::string_def_1;
				string_const_4: constant aadlstring => modal_test::string_def_11;
				
				string_def_1: aadlstring applies to (all);
				string_def_2: aadlstring applies to (all);
				string_def_3: aadlstring => "string_def_3 has a default value" applies to (all);
				string_def_4: aadlstring applies to (all);
				string_def_5: aadlstring applies to (all);
				string_def_6: aadlstring applies to (all);
				string_def_7: aadlstring applies to (all);
				string_def_8: aadlstring applies to (all);
				string_def_9: aadlstring applies to (all);
				string_def_10: aadlstring applies to (all);
				string_def_11: aadlstring applies to (all);
				string_def_12: aadlstring applies to (all);
				string_def_13: aadlstring => "string_def_13 has a default value" applies to (all);
				string_def_14: aadlstring applies to (all);
				string_def_15: aadlstring applies to (all);
				string_def_16: aadlstring applies to (all);
				string_def_17: aadlstring applies to (all);
				string_def_18: aadlstring applies to (all);
				string_def_19: aadlstring applies to (all);
				
				string_list_def_1: list of aadlstring applies to (all);
				string_list_def_2: list of list of aadlstring applies to (all);
				string_list_def_3: list of aadlstring applies to (all);
				string_list_def_4: list of list of aadlstring applies to (all);
				
				record_def_1: record (
					field_1: aadlstring;
					field_2: aadlstring;
					list_field_1: list of aadlstring;
					list_field_2: list of list of aadlstring;
				)applies to (all);
			end modal_test;
		'''
		val modalTestClass = '''
			package modaltest;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.StringLiteral;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public class ModalTest {
				public static final String MODAL_TEST__NAME = "modal_test";
				
				public static final String STRING_DEF_1__NAME = "string_def_1";
				public static final String STRING_DEF_2__NAME = "string_def_2";
				public static final String STRING_DEF_3__NAME = "string_def_3";
				public static final String STRING_DEF_4__NAME = "string_def_4";
				public static final String STRING_DEF_5__NAME = "string_def_5";
				public static final String STRING_DEF_6__NAME = "string_def_6";
				public static final String STRING_DEF_7__NAME = "string_def_7";
				public static final String STRING_DEF_8__NAME = "string_def_8";
				public static final String STRING_DEF_9__NAME = "string_def_9";
				public static final String STRING_DEF_10__NAME = "string_def_10";
				public static final String STRING_DEF_11__NAME = "string_def_11";
				public static final String STRING_DEF_12__NAME = "string_def_12";
				public static final String STRING_DEF_13__NAME = "string_def_13";
				public static final String STRING_DEF_14__NAME = "string_def_14";
				public static final String STRING_DEF_15__NAME = "string_def_15";
				public static final String STRING_DEF_16__NAME = "string_def_16";
				public static final String STRING_DEF_17__NAME = "string_def_17";
				public static final String STRING_DEF_18__NAME = "string_def_18";
				public static final String STRING_DEF_19__NAME = "string_def_19";
				public static final String STRING_LIST_DEF_1__NAME = "string_list_def_1";
				public static final String STRING_LIST_DEF_2__NAME = "string_list_def_2";
				public static final String STRING_LIST_DEF_3__NAME = "string_list_def_3";
				public static final String STRING_LIST_DEF_4__NAME = "string_list_def_4";
				public static final String RECORD_DEF_1__NAME = "record_def_1";
				
				public static Optional<String> getStringDef1(NamedElement lookupContext) {
					return getStringDef1(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef1(NamedElement lookupContext, Mode mode) {
					return getStringDef1(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef1(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_1";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef1_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_1";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef2(NamedElement lookupContext) {
					return getStringDef2(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef2(NamedElement lookupContext, Mode mode) {
					return getStringDef2(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef2(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_2";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef2_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_2";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef3(NamedElement lookupContext) {
					return getStringDef3(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef3(NamedElement lookupContext, Mode mode) {
					return getStringDef3(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef3(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_3";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef3_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_3";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef4(NamedElement lookupContext) {
					return getStringDef4(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef4(NamedElement lookupContext, Mode mode) {
					return getStringDef4(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef4(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_4";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef4_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_4";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef5(NamedElement lookupContext) {
					return getStringDef5(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef5(NamedElement lookupContext, Mode mode) {
					return getStringDef5(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef5(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_5";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef5_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_5";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef6(NamedElement lookupContext) {
					return getStringDef6(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef6(NamedElement lookupContext, Mode mode) {
					return getStringDef6(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef6(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_6";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef6_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_6";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef7(NamedElement lookupContext) {
					return getStringDef7(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef7(NamedElement lookupContext, Mode mode) {
					return getStringDef7(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef7(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_7";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef7_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_7";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef8(NamedElement lookupContext) {
					return getStringDef8(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef8(NamedElement lookupContext, Mode mode) {
					return getStringDef8(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef8(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_8";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef8_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_8";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef9(NamedElement lookupContext) {
					return getStringDef9(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef9(NamedElement lookupContext, Mode mode) {
					return getStringDef9(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef9(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_9";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef9_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_9";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef10(NamedElement lookupContext) {
					return getStringDef10(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef10(NamedElement lookupContext, Mode mode) {
					return getStringDef10(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef10(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_10";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef10_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_10";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef11(NamedElement lookupContext) {
					return getStringDef11(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef11(NamedElement lookupContext, Mode mode) {
					return getStringDef11(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef11(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_11";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef11_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_11";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef12(NamedElement lookupContext) {
					return getStringDef12(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef12(NamedElement lookupContext, Mode mode) {
					return getStringDef12(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef12(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_12";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef12_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_12";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef13(NamedElement lookupContext) {
					return getStringDef13(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef13(NamedElement lookupContext, Mode mode) {
					return getStringDef13(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef13(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_13";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef13_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_13";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef14(NamedElement lookupContext) {
					return getStringDef14(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef14(NamedElement lookupContext, Mode mode) {
					return getStringDef14(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef14(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_14";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef14_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_14";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef15(NamedElement lookupContext) {
					return getStringDef15(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef15(NamedElement lookupContext, Mode mode) {
					return getStringDef15(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef15(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_15";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef15_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_15";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef16(NamedElement lookupContext) {
					return getStringDef16(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef16(NamedElement lookupContext, Mode mode) {
					return getStringDef16(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef16(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_16";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef16_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_16";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef17(NamedElement lookupContext) {
					return getStringDef17(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef17(NamedElement lookupContext, Mode mode) {
					return getStringDef17(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef17(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_17";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef17_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_17";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef18(NamedElement lookupContext) {
					return getStringDef18(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef18(NamedElement lookupContext, Mode mode) {
					return getStringDef18(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef18(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_18";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef18_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_18";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<String> getStringDef19(NamedElement lookupContext) {
					return getStringDef19(lookupContext, Optional.empty());
				}
				
				public static Optional<String> getStringDef19(NamedElement lookupContext, Mode mode) {
					return getStringDef19(lookupContext, Optional.of(mode));
				}
				
				public static Optional<String> getStringDef19(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_def_19";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((StringLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringDef19_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_def_19";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<String>> getStringListDef1(NamedElement lookupContext) {
					return getStringListDef1(lookupContext, Optional.empty());
				}
				
				public static Optional<List<String>> getStringListDef1(NamedElement lookupContext, Mode mode) {
					return getStringListDef1(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<String>> getStringListDef1(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_list_def_1";
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
				
				public static PropertyExpression getStringListDef1_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_list_def_1";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<String>>> getStringListDef2(NamedElement lookupContext) {
					return getStringListDef2(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<String>>> getStringListDef2(NamedElement lookupContext, Mode mode) {
					return getStringListDef2(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<String>>> getStringListDef2(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_list_def_2";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((StringLiteral) resolved2).getValue();
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringListDef2_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_list_def_2";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<String>> getStringListDef3(NamedElement lookupContext) {
					return getStringListDef3(lookupContext, Optional.empty());
				}
				
				public static Optional<List<String>> getStringListDef3(NamedElement lookupContext, Mode mode) {
					return getStringListDef3(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<String>> getStringListDef3(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_list_def_3";
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
				
				public static PropertyExpression getStringListDef3_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_list_def_3";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<List<String>>> getStringListDef4(NamedElement lookupContext) {
					return getStringListDef4(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<String>>> getStringListDef4(NamedElement lookupContext, Mode mode) {
					return getStringListDef4(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<String>>> getStringListDef4(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::string_list_def_4";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
								PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
								return ((StringLiteral) resolved2).getValue();
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getStringListDef4_EObject(NamedElement lookupContext) {
					String name = "modal_test::string_list_def_4";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<RecordDef1> getRecordDef1(NamedElement lookupContext) {
					return getRecordDef1(lookupContext, Optional.empty());
				}
				
				public static Optional<RecordDef1> getRecordDef1(NamedElement lookupContext, Mode mode) {
					return getRecordDef1(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RecordDef1> getRecordDef1(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "modal_test::record_def_1";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RecordDef1(resolved, lookupContext, mode));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRecordDef1_EObject(NamedElement lookupContext) {
					String name = "modal_test::record_def_1";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val recordDef1 = '''
			package modaltest;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.eclipse.emf.common.util.URI;
			import org.eclipse.emf.ecore.resource.ResourceSet;
			import org.osate.aadl2.Aadl2Factory;
			import org.osate.aadl2.BasicPropertyAssociation;
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
				public static final String FIELD_1__NAME = "field_1";
				public static final String FIELD_2__NAME = "field_2";
				public static final String LIST_FIELD_1__NAME = "list_field_1";
				public static final String LIST_FIELD_2__NAME = "list_field_2";
				public static final URI FIELD_1__URI = URI.createURI("__synthetic0.aadl#/0/@ownedProperty.23/@ownedPropertyType/@ownedField.0");
				public static final URI FIELD_2__URI = URI.createURI("__synthetic0.aadl#/0/@ownedProperty.23/@ownedPropertyType/@ownedField.1");
				public static final URI LIST_FIELD_1__URI = URI.createURI("__synthetic0.aadl#/0/@ownedProperty.23/@ownedPropertyType/@ownedField.2");
				public static final URI LIST_FIELD_2__URI = URI.createURI("__synthetic0.aadl#/0/@ownedProperty.23/@ownedPropertyType/@ownedField.3");
				
				private final Optional<String> field1;
				private final Optional<String> field2;
				private final Optional<List<String>> listField1;
				private final Optional<List<List<String>>> listField2;
				
				public RecordDef1(
						Optional<String> field1,
						Optional<String> field2,
						Optional<List<String>> listField1,
						Optional<List<List<String>>> listField2
				) {
					this.field1 = field1;
					this.field2 = field2;
					this.listField1 = listField1;
					this.listField2 = listField2;
				}
				
				public RecordDef1(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<String> field1_local;
					try {
						field1_local = findFieldValue(recordValue, FIELD_1__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((StringLiteral) resolved).getValue();
						});
					} catch (PropertyNotPresentException e) {
						field1_local = Optional.empty();
					}
					this.field1 = field1_local;
					
					Optional<String> field2_local;
					try {
						field2_local = findFieldValue(recordValue, FIELD_2__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((StringLiteral) resolved).getValue();
						});
					} catch (PropertyNotPresentException e) {
						field2_local = Optional.empty();
					}
					this.field2 = field2_local;
					
					Optional<List<String>> listField1_local;
					try {
						listField1_local = findFieldValue(recordValue, LIST_FIELD_1__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((StringLiteral) resolved1).getValue();
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						listField1_local = Optional.empty();
					}
					this.listField1 = listField1_local;
					
					Optional<List<List<String>>> listField2_local;
					try {
						listField2_local = findFieldValue(recordValue, LIST_FIELD_2__NAME).map(field -> {
							PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
							return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
								PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
								return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
									PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2, lookupContext, mode);
									return ((StringLiteral) resolved2).getValue();
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						});
					} catch (PropertyNotPresentException e) {
						listField2_local = Optional.empty();
					}
					this.listField2 = listField2_local;
				}
				
				public Optional<String> getField1() {
					return field1;
				}
				
				public Optional<String> getField2() {
					return field2;
				}
				
				public Optional<List<String>> getListField1() {
					return listField1;
				}
				
				public Optional<List<List<String>>> getListField2() {
					return listField2;
				}
				
				@Override
				public RecordValue toPropertyExpression(ResourceSet resourceSet) {
					if (!field1.isPresent()
							&& !field2.isPresent()
							&& !listField1.isPresent()
							&& !listField2.isPresent()
					) {
						throw new IllegalStateException("Record must have at least one field set.");
					}
					RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
					field1.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD_1__URI, FIELD_1__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
					});
					field2.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, FIELD_2__URI, FIELD_2__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field));
					});
					listField1.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_FIELD_1__URI, LIST_FIELD_1__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1);
						}));
					});
					listField2.ifPresent(field -> {
						BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
						fieldAssociation.setProperty(loadField(resourceSet, LIST_FIELD_2__URI, LIST_FIELD_2__NAME));
						fieldAssociation.setOwnedValue(CodeGenUtil.toPropertyExpression(field, element1 -> {
							return CodeGenUtil.toPropertyExpression(element1, element2 -> {
								return CodeGenUtil.toPropertyExpression(element2);
							});
						}));
					});
					return recordValue;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							field1,
							field2,
							listField1,
							listField2
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordDef1)) {
						return false;
					}
					RecordDef1 other = (RecordDef1) obj;
					return Objects.equals(this.field1, other.field1)
							&& Objects.equals(this.field2, other.field2)
							&& Objects.equals(this.listField1, other.listField1)
							&& Objects.equals(this.listField2, other.listField2);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.field1.ifPresent(field -> {
						builder.append(FIELD_1__NAME);
						builder.append(" => \"");
						builder.append(field);
						builder.append("\";");
					});
					this.field2.ifPresent(field -> {
						builder.append(FIELD_2__NAME);
						builder.append(" => \"");
						builder.append(field);
						builder.append("\";");
					});
					this.listField1.ifPresent(field -> {
						builder.append(LIST_FIELD_1__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(element1 -> {
							return '\"' + element1 + '\"';
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.listField2.ifPresent(field -> {
						builder.append(LIST_FIELD_2__NAME);
						builder.append(" => ");
						builder.append(field.stream().map(element1 -> {
							return element1.stream().map(element2 -> {
								return '\"' + element2 + '\"';
							}).collect(Collectors.joining(", ", "(", ")"));
						}).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(modalTest))
		assertEquals("src-gen/modaltest", results.packagePath)
		assertEquals(2, results.classes.size)
		
		assertEquals("ModalTest.java", results.classes.get(0).fileName)
		assertEquals(modalTestClass.toString, results.classes.get(0).contents)
		
		assertEquals("RecordDef1.java", results.classes.get(1).fileName)
		assertEquals(recordDef1.toString, results.classes.get(1).contents)
	}
}