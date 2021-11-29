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
class IntegerNoUnitsTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testIntegerNoUnits() {
		val otherPs = '''
			property set other_ps is
				other_integer_no_units_type: type aadlinteger;
			end other_ps;
		'''
		val integerNoUnitsTest = '''
			property set integer_no_units_test is
				with other_ps;
				
				local_integer_type: type aadlinteger;
				
				owned_integer: aadlinteger applies to (all);
				referenced_integer_local: integer_no_units_test::local_integer_type applies to (all);
				referenced_integer_other: other_ps::other_integer_no_units_type applies to (all);
				
				list_1_integer: list of other_ps::other_integer_no_units_type applies to (all);
				list_5_integer: list of list of list of list of list of other_ps::other_integer_no_units_type applies to (all);
			end integer_no_units_test;
		'''
		val integerNoUnitsTestClass = '''
			package integernounitstest;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.OptionalLong;
			import java.util.stream.Collectors;
			
			import org.eclipse.emf.ecore.EObject;
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.IntegerLiteral;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			
			public final class IntegerNoUnitsTest {
				public static final String INTEGER_NO_UNITS_TEST__NAME = "integer_no_units_test";
				
				private IntegerNoUnitsTest() {}
				
				// Lookup methods for integer_no_units_test::owned_integer
				
				public static final String OWNED_INTEGER__NAME = "owned_integer";
				
				public static boolean acceptsOwnedInteger(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getOwnedInteger_Property(lookupContext));
				}
				
				public static OptionalLong getOwnedInteger(NamedElement lookupContext) {
					return getOwnedInteger(lookupContext, Optional.empty());
				}
				
				public static OptionalLong getOwnedInteger(NamedElement lookupContext, Mode mode) {
					return getOwnedInteger(lookupContext, Optional.of(mode));
				}
				
				public static OptionalLong getOwnedInteger(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getOwnedInteger_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return OptionalLong.of(((IntegerLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalLong.empty();
					}
				}
				
				public static Property getOwnedInteger_Property(EObject lookupContext) {
					String name = INTEGER_NO_UNITS_TEST__NAME + "::" + OWNED_INTEGER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getOwnedInteger_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getOwnedInteger_Property(lookupContext));
				}
				
				// Lookup methods for integer_no_units_test::referenced_integer_local
				
				public static final String REFERENCED_INTEGER_LOCAL__NAME = "referenced_integer_local";
				
				public static boolean acceptsReferencedIntegerLocal(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedIntegerLocal_Property(lookupContext));
				}
				
				public static OptionalLong getReferencedIntegerLocal(NamedElement lookupContext) {
					return getReferencedIntegerLocal(lookupContext, Optional.empty());
				}
				
				public static OptionalLong getReferencedIntegerLocal(NamedElement lookupContext, Mode mode) {
					return getReferencedIntegerLocal(lookupContext, Optional.of(mode));
				}
				
				public static OptionalLong getReferencedIntegerLocal(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedIntegerLocal_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return OptionalLong.of(((IntegerLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalLong.empty();
					}
				}
				
				public static Property getReferencedIntegerLocal_Property(EObject lookupContext) {
					String name = INTEGER_NO_UNITS_TEST__NAME + "::" + REFERENCED_INTEGER_LOCAL__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedIntegerLocal_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedIntegerLocal_Property(lookupContext));
				}
				
				// Lookup methods for integer_no_units_test::referenced_integer_other
				
				public static final String REFERENCED_INTEGER_OTHER__NAME = "referenced_integer_other";
				
				public static boolean acceptsReferencedIntegerOther(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getReferencedIntegerOther_Property(lookupContext));
				}
				
				public static OptionalLong getReferencedIntegerOther(NamedElement lookupContext) {
					return getReferencedIntegerOther(lookupContext, Optional.empty());
				}
				
				public static OptionalLong getReferencedIntegerOther(NamedElement lookupContext, Mode mode) {
					return getReferencedIntegerOther(lookupContext, Optional.of(mode));
				}
				
				public static OptionalLong getReferencedIntegerOther(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getReferencedIntegerOther_Property(lookupContext);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return OptionalLong.of(((IntegerLiteral) resolved).getValue());
					} catch (PropertyNotPresentException e) {
						return OptionalLong.empty();
					}
				}
				
				public static Property getReferencedIntegerOther_Property(EObject lookupContext) {
					String name = INTEGER_NO_UNITS_TEST__NAME + "::" + REFERENCED_INTEGER_OTHER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getReferencedIntegerOther_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getReferencedIntegerOther_Property(lookupContext));
				}
				
				// Lookup methods for integer_no_units_test::list_1_integer
				
				public static final String LIST_1_INTEGER__NAME = "list_1_integer";
				
				public static boolean acceptsList1Integer(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList1Integer_Property(lookupContext));
				}
				
				public static Optional<List<Long>> getList1Integer(NamedElement lookupContext) {
					return getList1Integer(lookupContext, Optional.empty());
				}
				
				public static Optional<List<Long>> getList1Integer(NamedElement lookupContext, Mode mode) {
					return getList1Integer(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<Long>> getList1Integer(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList1Integer_Property(lookupContext);
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
				
				public static Property getList1Integer_Property(EObject lookupContext) {
					String name = INTEGER_NO_UNITS_TEST__NAME + "::" + LIST_1_INTEGER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList1Integer_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList1Integer_Property(lookupContext));
				}
				
				// Lookup methods for integer_no_units_test::list_5_integer
				
				public static final String LIST_5_INTEGER__NAME = "list_5_integer";
				
				public static boolean acceptsList5Integer(NamedElement lookupContext) {
					return lookupContext.acceptsProperty(getList5Integer_Property(lookupContext));
				}
				
				public static Optional<List<List<List<List<List<Long>>>>>> getList5Integer(NamedElement lookupContext) {
					return getList5Integer(lookupContext, Optional.empty());
				}
				
				public static Optional<List<List<List<List<List<Long>>>>>> getList5Integer(NamedElement lookupContext, Mode mode) {
					return getList5Integer(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<List<List<List<List<Long>>>>>> getList5Integer(NamedElement lookupContext, Optional<Mode> mode) {
					Property property = getList5Integer_Property(lookupContext);
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
											return ((IntegerLiteral) resolved5).getValue();
										}).collect(Collectors.toList());
									}).collect(Collectors.toList());
								}).collect(Collectors.toList());
							}).collect(Collectors.toList());
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static Property getList5Integer_Property(EObject lookupContext) {
					String name = INTEGER_NO_UNITS_TEST__NAME + "::" + LIST_5_INTEGER__NAME;
					return Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
				}
				
				public static PropertyExpression getList5Integer_EObject(NamedElement lookupContext) {
					return lookupContext.getNonModalPropertyValue(getList5Integer_Property(lookupContext));
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(integerNoUnitsTest, otherPs))
		assertEquals("src-gen/integernounitstest", results.packagePath)
		assertEquals(1, results.classes.size)
		
		assertEquals("IntegerNoUnitsTest.java", results.classes.head.fileName)
		assertEquals(integerNoUnitsTestClass.toString, results.classes.head.contents)
	}
}