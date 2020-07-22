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
class IntegerWithUnitsTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testIntegerWithUnits() {
		val otherPs = '''
			property set other_ps is
				mass: type units (g, kg => g * 1000);
			end other_ps;
		'''
		val integerWithUnitsTest = '''
			property set integer_with_units_test is
				with other_ps;
				
				time: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				
				owned: aadlinteger units (B, KiB => B * 1024) applies to (all);
				same_file: aadlinteger units integer_with_units_test::time applies to (all);
				other_file: aadlinteger units other_ps::mass applies to (all);
				
				list_1_owned: list of aadlinteger units (mg, g => mg * 1000) applies to (all);
				list_1_same_file: list of aadlinteger units integer_with_units_test::time applies to (all);
				list_1_other_file: list of aadlinteger units other_ps::mass applies to (all);
				
				record_property: record (
					owned: aadlinteger units (hour, day => hour * 24);
					same_file: aadlinteger units integer_with_units_test::time;
					other_file: aadlinteger units other_ps::mass;
					
					list_1_owned: list of aadlinteger units (ml, l => ml * 1000);
					list_1_same_file: list of aadlinteger units integer_with_units_test::time;
					list_1_other_file: list of aadlinteger units other_ps::mass;
				) applies to (all);
			end integer_with_units_test;
		'''
		val integerWithUnitsTestClass = '''
			package integerwithunitstest;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.IntegerWithUnits;
			
			import otherps.Mass;
			
			public class IntegerWithUnitsTest {
				public static Optional<IntegerWithUnits<Owned>> getOwned(NamedElement lookupContext) {
					return getOwned(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerWithUnits<Owned>> getOwned(NamedElement lookupContext, Mode mode) {
					return getOwned(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerWithUnits<Owned>> getOwned(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "integer_with_units_test::owned";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerWithUnits<>(resolved, Owned.class));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getOwned_EObject(NamedElement lookupContext) {
					String name = "integer_with_units_test::owned";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<IntegerWithUnits<Time>> getSameFile(NamedElement lookupContext) {
					return getSameFile(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerWithUnits<Time>> getSameFile(NamedElement lookupContext, Mode mode) {
					return getSameFile(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerWithUnits<Time>> getSameFile(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "integer_with_units_test::same_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerWithUnits<>(resolved, Time.class));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getSameFile_EObject(NamedElement lookupContext) {
					String name = "integer_with_units_test::same_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<IntegerWithUnits<Mass>> getOtherFile(NamedElement lookupContext) {
					return getOtherFile(lookupContext, Optional.empty());
				}
				
				public static Optional<IntegerWithUnits<Mass>> getOtherFile(NamedElement lookupContext, Mode mode) {
					return getOtherFile(lookupContext, Optional.of(mode));
				}
				
				public static Optional<IntegerWithUnits<Mass>> getOtherFile(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "integer_with_units_test::other_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new IntegerWithUnits<>(resolved, Mass.class));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getOtherFile_EObject(NamedElement lookupContext) {
					String name = "integer_with_units_test::other_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<IntegerWithUnits<List1Owned>>> getList1Owned(NamedElement lookupContext) {
					return getList1Owned(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerWithUnits<List1Owned>>> getList1Owned(NamedElement lookupContext, Mode mode) {
					return getList1Owned(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerWithUnits<List1Owned>>> getList1Owned(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "integer_with_units_test::list_1_owned";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerWithUnits<>(resolved1, List1Owned.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1Owned_EObject(NamedElement lookupContext) {
					String name = "integer_with_units_test::list_1_owned";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<IntegerWithUnits<Time>>> getList1SameFile(NamedElement lookupContext) {
					return getList1SameFile(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerWithUnits<Time>>> getList1SameFile(NamedElement lookupContext, Mode mode) {
					return getList1SameFile(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerWithUnits<Time>>> getList1SameFile(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "integer_with_units_test::list_1_same_file";
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
				
				public static PropertyExpression getList1SameFile_EObject(NamedElement lookupContext) {
					String name = "integer_with_units_test::list_1_same_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<IntegerWithUnits<Mass>>> getList1OtherFile(NamedElement lookupContext) {
					return getList1OtherFile(lookupContext, Optional.empty());
				}
				
				public static Optional<List<IntegerWithUnits<Mass>>> getList1OtherFile(NamedElement lookupContext, Mode mode) {
					return getList1OtherFile(lookupContext, Optional.of(mode));
				}
				
				public static Optional<List<IntegerWithUnits<Mass>>> getList1OtherFile(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "integer_with_units_test::list_1_other_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
							PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
							return new IntegerWithUnits<>(resolved1, Mass.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1OtherFile_EObject(NamedElement lookupContext) {
					String name = "integer_with_units_test::list_1_other_file";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
				
				public static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext) {
					return getRecordProperty(lookupContext, Optional.empty());
				}
				
				public static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext, Mode mode) {
					return getRecordProperty(lookupContext, Optional.of(mode));
				}
				
				public static Optional<RecordProperty> getRecordProperty(NamedElement lookupContext, Optional<Mode> mode) {
					String name = "integer_with_units_test::record_property";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression value = CodeGenUtil.lookupProperty(property, lookupContext, mode);
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(value, lookupContext, mode);
						return Optional.of(new RecordProperty(resolved, lookupContext, mode));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRecordProperty_EObject(NamedElement lookupContext) {
					String name = "integer_with_units_test::record_property";
					Property property = Aadl2GlobalScopeUtil.get(lookupContext, Aadl2Package.eINSTANCE.getProperty(), name);
					return lookupContext.getNonModalPropertyValue(property);
				}
			}
		'''
		val time = '''
			package integerwithunitstest;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum Time implements GeneratedUnits {
				SEC(1.0, "sec"),
				MIN(60.0, "min"),
				HR(3600.0, "hr"),
				DAY(86400.0, "day");
				
				private final double factorToBase;
				private final String originalName;
				
				private Time(double factorToBase, String originalName) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
				}
				
				public static Time valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				public double getFactorTo(Time target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val owned = '''
			package integerwithunitstest;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum Owned implements GeneratedUnits {
				B(1.0, "B"),
				KIB(1024.0, "KiB");
				
				private final double factorToBase;
				private final String originalName;
				
				private Owned(double factorToBase, String originalName) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
				}
				
				public static Owned valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				public double getFactorTo(Owned target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val list1Owned = '''
			package integerwithunitstest;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			
			public enum List1Owned implements GeneratedUnits {
				MG(1.0, "mg"),
				G(1000.0, "g");
				
				private final double factorToBase;
				private final String originalName;
				
				private List1Owned(double factorToBase, String originalName) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
				}
				
				public static List1Owned valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				public double getFactorTo(List1Owned target) {
					return factorToBase / target.factorToBase;
				}
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val recordProperty = '''
			package integerwithunitstest;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.Mode;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.CodeGenUtil;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			import org.osate.pluginsupport.properties.IntegerWithUnits;
			
			import otherps.Mass;
			
			public class RecordProperty {
				private final Optional<IntegerWithUnits<Owned_FieldType>> owned;
				private final Optional<IntegerWithUnits<Time>> sameFile;
				private final Optional<IntegerWithUnits<Mass>> otherFile;
				private final Optional<List<IntegerWithUnits<List1Owned_FieldType>>> list1Owned;
				private final Optional<List<IntegerWithUnits<Time>>> list1SameFile;
				private final Optional<List<IntegerWithUnits<Mass>>> list1OtherFile;
				
				public RecordProperty(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					
					Optional<IntegerWithUnits<Owned_FieldType>> owned_local;
					try {
						owned_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("owned"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new IntegerWithUnits<>(resolved, Owned_FieldType.class);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						owned_local = Optional.empty();
					}
					this.owned = owned_local;
					
					Optional<IntegerWithUnits<Time>> sameFile_local;
					try {
						sameFile_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("same_file"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new IntegerWithUnits<>(resolved, Time.class);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						sameFile_local = Optional.empty();
					}
					this.sameFile = sameFile_local;
					
					Optional<IntegerWithUnits<Mass>> otherFile_local;
					try {
						otherFile_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("other_file"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return new IntegerWithUnits<>(resolved, Mass.class);
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						otherFile_local = Optional.empty();
					}
					this.otherFile = otherFile_local;
					
					Optional<List<IntegerWithUnits<List1Owned_FieldType>>> list1Owned_local;
					try {
						list1Owned_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("list_1_owned"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
										PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
										return new IntegerWithUnits<>(resolved1, List1Owned_FieldType.class);
									}).collect(Collectors.toList());
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						list1Owned_local = Optional.empty();
					}
					this.list1Owned = list1Owned_local;
					
					Optional<List<IntegerWithUnits<Time>>> list1SameFile_local;
					try {
						list1SameFile_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("list_1_same_file"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
										PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
										return new IntegerWithUnits<>(resolved1, Time.class);
									}).collect(Collectors.toList());
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						list1SameFile_local = Optional.empty();
					}
					this.list1SameFile = list1SameFile_local;
					
					Optional<List<IntegerWithUnits<Mass>>> list1OtherFile_local;
					try {
						list1OtherFile_local = recordValue.getOwnedFieldValues()
								.stream()
								.filter(field -> field.getProperty().getName().equals("list_1_other_file"))
								.map(field -> {
									PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
									return ((ListValue) resolved).getOwnedListElements().stream().map(element1 -> {
										PropertyExpression resolved1 = CodeGenUtil.resolveNamedValue(element1, lookupContext, mode);
										return new IntegerWithUnits<>(resolved1, Mass.class);
									}).collect(Collectors.toList());
								})
								.findAny();
					} catch (PropertyNotPresentException e) {
						list1OtherFile_local = Optional.empty();
					}
					this.list1OtherFile = list1OtherFile_local;
				}
				
				public Optional<IntegerWithUnits<Owned_FieldType>> getOwned() {
					return owned;
				}
				
				public Optional<IntegerWithUnits<Time>> getSameFile() {
					return sameFile;
				}
				
				public Optional<IntegerWithUnits<Mass>> getOtherFile() {
					return otherFile;
				}
				
				public Optional<List<IntegerWithUnits<List1Owned_FieldType>>> getList1Owned() {
					return list1Owned;
				}
				
				public Optional<List<IntegerWithUnits<Time>>> getList1SameFile() {
					return list1SameFile;
				}
				
				public Optional<List<IntegerWithUnits<Mass>>> getList1OtherFile() {
					return list1OtherFile;
				}
				
				@Override
				public int hashCode() {
					return Objects.hash(
							owned,
							sameFile,
							otherFile,
							list1Owned,
							list1SameFile,
							list1OtherFile
					);
				}
				
				@Override
				public boolean equals(Object obj) {
					if (this == obj) {
						return true;
					}
					if (!(obj instanceof RecordProperty)) {
						return false;
					}
					RecordProperty other = (RecordProperty) obj;
					return Objects.equals(this.owned, other.owned)
							&& Objects.equals(this.sameFile, other.sameFile)
							&& Objects.equals(this.otherFile, other.otherFile)
							&& Objects.equals(this.list1Owned, other.list1Owned)
							&& Objects.equals(this.list1SameFile, other.list1SameFile)
							&& Objects.equals(this.list1OtherFile, other.list1OtherFile);
				}
				
				@Override
				public String toString() {
					StringBuilder builder = new StringBuilder();
					builder.append('[');
					this.owned.ifPresent(field -> {
						builder.append("owned => ");
						builder.append(field);
						builder.append(';');
					});
					this.sameFile.ifPresent(field -> {
						builder.append("same_file => ");
						builder.append(field);
						builder.append(';');
					});
					this.otherFile.ifPresent(field -> {
						builder.append("other_file => ");
						builder.append(field);
						builder.append(';');
					});
					this.list1Owned.ifPresent(field -> {
						builder.append("list_1_owned => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1SameFile.ifPresent(field -> {
						builder.append("list_1_same_file => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					this.list1OtherFile.ifPresent(field -> {
						builder.append("list_1_other_file => ");
						builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
						builder.append(';');
					});
					builder.append(']');
					return builder.toString();
				}
				
				public enum Owned_FieldType implements GeneratedUnits {
					HOUR(1.0, "hour"),
					DAY(24.0, "day");
					
					private final double factorToBase;
					private final String originalName;
					
					private Owned_FieldType(double factorToBase, String originalName) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
					}
					
					public static Owned_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					public double getFactorTo(Owned_FieldType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
				
				public enum List1Owned_FieldType implements GeneratedUnits {
					ML(1.0, "ml"),
					L(1000.0, "l");
					
					private final double factorToBase;
					private final String originalName;
					
					private List1Owned_FieldType(double factorToBase, String originalName) {
						this.factorToBase = factorToBase;
						this.originalName = originalName;
					}
					
					public static List1Owned_FieldType valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
					}
					
					@Override
					public double getFactorToBase() {
						return factorToBase;
					}
					
					public double getFactorTo(List1Owned_FieldType target) {
						return factorToBase / target.factorToBase;
					}
					
					@Override
					public String toString() {
						return originalName;
					}
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(integerWithUnitsTest, otherPs))
		assertEquals("src-gen/integerwithunitstest", results.packagePath)
		assertEquals(5, results.classes.size)
		
		assertEquals("IntegerWithUnitsTest.java", results.classes.get(0).fileName)
		assertEquals(integerWithUnitsTestClass.toString, results.classes.get(0).contents)
		
		assertEquals("Time.java", results.classes.get(1).fileName)
		assertEquals(time.toString, results.classes.get(1).contents)
		
		assertEquals("Owned.java", results.classes.get(2).fileName)
		assertEquals(owned.toString, results.classes.get(2).contents)
		
		assertEquals("List1Owned.java", results.classes.get(3).fileName)
		assertEquals(list1Owned.toString, results.classes.get(3).contents)
		
		assertEquals("RecordProperty.java", results.classes.get(4).fileName)
		assertEquals(recordProperty.toString, results.classes.get(4).contents)
	}
}