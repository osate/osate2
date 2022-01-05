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
class BooleanTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testBoolean() {
		val otherPs = '''
			property set other_ps is
				other_boolean_type: type aadlboolean;
			end other_ps;
		'''
		val booleanTest = '''
			property set boolean_test is
				with other_ps;
				
				local_boolean_type: type aadlboolean;
				
				owned_boolean: aadlboolean applies to (all);
				referenced_boolean_local: boolean_test::local_boolean_type applies to (all);
				referenced_boolean_other: other_ps::other_boolean_type applies to (all);
				
				list_1_boolean: list of other_ps::other_boolean_type applies to (all);
				list_5_boolean: list of list of list of list of list of other_ps::other_boolean_type applies to (all);
				
				boolean_constant: constant aadlboolean => true;
				
				list_1_boolean_constant: constant list of aadlboolean => (boolean_test::boolean_constant, false);
				list_5_boolean_constant: constant list of list of list of list of list of aadlboolean => ((((
					(true, false, true),
					()
				))));
			end boolean_test;
		'''
		val booleanTestClass = '''
			package booleantest;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.eclipse.emf.ecore.EObject;
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.BooleanLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyConstant;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public final class BooleanTest {
				public static final String BOOLEAN_TEST__NAME = "boolean_test";
				
				private BooleanTest() {}
				
				// Lookup methods for boolean_test::owned_boolean
				
				public static final String OWNED_BOOLEAN__NAME = "owned_boolean";
				
				public static boolean acceptsOwnedBoolean(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getOwnedBoolean_Property(lookupContext));
				}
				
				public static Optional<Boolean> getOwnedBoolean(NamedElement lookupContext) {
					return getOwnedBoolean(lookupContext, Optional.empty());
				}
				
				public static Optional<Boolean> getOwnedBoolean(NamedElement lookupContext, Mode mode) {
					return getOwnedBoolean(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Boolean> getOwnedBoolean(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getOwnedBoolean_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((BooleanLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Property getOwnedBoolean_Property(EObject lookupContext) {
					String name = BOOLEAN_TEST__NAME + "::" + OWNED_BOOLEAN__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getOwnedBoolean_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getOwnedBoolean_Property(lookupContext));
				}
				
				// Lookup methods for boolean_test::referenced_boolean_local
				
				public static final String REFERENCED_BOOLEAN_LOCAL__NAME = "referenced_boolean_local";
				
				public static boolean acceptsReferencedBooleanLocal(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedBooleanLocal_Property(lookupContext));
				}
				
				public static Optional<Boolean> getReferencedBooleanLocal(NamedElement lookupContext) {
					return getReferencedBooleanLocal(lookupContext, Optional.empty());
				}
				
				public static Optional<Boolean> getReferencedBooleanLocal(NamedElement lookupContext, Mode mode) {
					return getReferencedBooleanLocal(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Boolean> getReferencedBooleanLocal(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedBooleanLocal_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((BooleanLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Property getReferencedBooleanLocal_Property(EObject lookupContext) {
					String name = BOOLEAN_TEST__NAME + "::" + REFERENCED_BOOLEAN_LOCAL__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedBooleanLocal_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedBooleanLocal_Property(lookupContext));
				}
				
				// Lookup methods for boolean_test::referenced_boolean_other
				
				public static final String REFERENCED_BOOLEAN_OTHER__NAME = "referenced_boolean_other";
				
				public static boolean acceptsReferencedBooleanOther(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedBooleanOther_Property(lookupContext));
				}
				
				public static Optional<Boolean> getReferencedBooleanOther(NamedElement lookupContext) {
					return getReferencedBooleanOther(lookupContext, Optional.empty());
				}
				
				public static Optional<Boolean> getReferencedBooleanOther(NamedElement lookupContext, Mode mode) {
					return getReferencedBooleanOther(lookupContext, Optional.of(mode));
				}
				
				public static Optional<Boolean> getReferencedBooleanOther(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedBooleanOther_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((BooleanLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Property getReferencedBooleanOther_Property(EObject lookupContext) {
					String name = BOOLEAN_TEST__NAME + "::" + REFERENCED_BOOLEAN_OTHER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedBooleanOther_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedBooleanOther_Property(lookupContext));
				}
				
				// Lookup methods for boolean_test::list_1_boolean
				
				public static final String LIST_1_BOOLEAN__NAME = "list_1_boolean";
				
				public static boolean acceptsList1Boolean(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1Boolean_Property(lookupContext));
				}
				
				public static Optional<List<Boolean>> getList1Boolean(NamedElement lookupContext) {
					return getList1Boolean(lookupContext, Optional.empty());
				}
				
				public static Optional<List<Boolean>> getList1Boolean(NamedElement lookupContext, Mode mode) {
					return getList1Boolean(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<Boolean>> getList1Boolean(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1Boolean_Property(lookupContext);
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
				
				public static Property getList1Boolean_Property(EObject lookupContext) {
					String name = BOOLEAN_TEST__NAME + "::" + LIST_1_BOOLEAN__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1Boolean_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1Boolean_Property(lookupContext));
				}
				
				// Lookup methods for boolean_test::list_5_boolean
				
				public static final String LIST_5_BOOLEAN__NAME = "list_5_boolean";
				
				public static boolean acceptsList5Boolean(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList5Boolean_Property(lookupContext));
				}
				
				public static Optional<List<List<List<List<List<Boolean>>>>>> getList5Boolean(NamedElement lookupContext) {
					return getList5Boolean(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List<List<Boolean>>>>>> getList5Boolean(NamedElement lookupContext, Mode mode) {
					return getList5Boolean(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List<List<Boolean>>>>>> getList5Boolean(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList5Boolean_Property(lookupContext);
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
				
				public static Property getList5Boolean_Property(EObject lookupContext) {
					String name = BOOLEAN_TEST__NAME + "::" + LIST_5_BOOLEAN__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList5Boolean_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList5Boolean_Property(lookupContext));
				}
				
				// Lookup methods for boolean_test::boolean_constant
				
				public static final String BOOLEAN_CONSTANT__NAME = "boolean_constant";
				
				public static boolean getBooleanConstant(EObject lookupContext) {
					PropertyConstant constant = getBooleanConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((BooleanLiteral) resolved).getValue();
				}
				
				public static PropertyConstant getBooleanConstant_PropertyConstant(EObject lookupContext) {
					String name = BOOLEAN_TEST__NAME + "::" + BOOLEAN_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for boolean_test::list_1_boolean_constant
				
				public static final String LIST_1_BOOLEAN_CONSTANT__NAME = "list_1_boolean_constant";
				
				public static List<Boolean> getList1BooleanConstant(EObject lookupContext) {
					PropertyConstant constant = getList1BooleanConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return ((BooleanLiteral) resolved1).getValue();
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList1BooleanConstant_PropertyConstant(EObject lookupContext) {
					String name = BOOLEAN_TEST__NAME + "::" + LIST_1_BOOLEAN_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
				
				// Lookup methods for boolean_test::list_5_boolean_constant
				
				public static final String LIST_5_BOOLEAN_CONSTANT__NAME = "list_5_boolean_constant";
				
				public static List<List<List<List<List<Boolean>>>>> getList5BooleanConstant(EObject lookupContext) {
					PropertyConstant constant = getList5BooleanConstant_PropertyConstant(lookupContext);
					PropertyExpression resolved = CodeGenUtil.resolveNamedValue(constant.getConstantValue());
					return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
						PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1);
						return ((ListValue) resolved1).getOwnedListElements().stream().map(element2 -> {
							PropertyExpression resolved2 = CodeGenUtil.resolveNamedValue(element2);
							return ((ListValue) resolved2).getOwnedListElements().stream().map(element3 -> {
								PropertyExpression resolved3 = CodeGenUtil.resolveNamedValue(element3);
								return ((ListValue) resolved3).getOwnedListElements().stream().map(element4 -> {
									PropertyExpression resolved4 = CodeGenUtil.resolveNamedValue(element4);
									return ((ListValue) resolved4).getOwnedListElements().stream().map(element5 -> {
										PropertyExpression resolved5 = CodeGenUtil.resolveNamedValue(element5);
										return ((BooleanLiteral) resolved5).getValue();
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList());
					}).collect(Collectors.toList());
				}
				
				public static PropertyConstant getList5BooleanConstant_PropertyConstant(EObject lookupContext) {
					String name = BOOLEAN_TEST__NAME + "::" + LIST_5_BOOLEAN_CONSTANT__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getPropertyConstant(), name);
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(booleanTest, otherPs))
		assertEquals("src-gen/booleantest", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("BooleanTest.java", results.classes.head.fileName)
		assertEquals(booleanTestClass.toString, results.classes.head.contents)
	}
}