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
class RealWithUnitsTest {
	@Inject
	TestHelper<PropertySet> testHelper
	
	@Test
	def void testRealWithUnits() {
		val otherPs = '''
			property set other_ps is
				mass: type units (g, kg => g * 1000);
			end other_ps;
		'''
		val realWithUnitsTest = '''
			property set real_with_units_test is
				with other_ps;
				
				time: type units (sec, min => sec * 60, hr => min * 60, day => hr * 24);
				
				owned: aadlreal units (B, KiB => B * 1024) applies to (all);
				same_file: aadlreal units real_with_units_test::time applies to (all);
				other_file: aadlreal units other_ps::mass applies to (all);
				
				list_1_owned: list of aadlreal units (mg, g => mg * 1000) applies to (all);
				list_1_same_file: list of aadlreal units real_with_units_test::time applies to (all);
				list_1_other_file: list of aadlreal units other_ps::mass applies to (all);
				
				record_property: record (
					owned: aadlreal units (hour, day => hour * 24);
					same_file: aadlreal units real_with_units_test::time;
					other_file: aadlreal units other_ps::mass;
					
					list_1_owned: list of aadlreal units (ml, l => ml * 1000);
					list_1_same_file: list of aadlreal units real_with_units_test::time;
					list_1_other_file: list of aadlreal units other_ps::mass;
				) applies to (all);
			end real_with_units_test;
		'''
		val realWithUnitsTestClass = '''
			package real_with_units_test;
			
			import java.util.List;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.Aadl2Package;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.NamedElement;
			import org.osate.aadl2.Property;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.modelsupport.scoping.Aadl2GlobalScopeUtil;
			import org.osate.aadl2.properties.PropertyNotPresentException;
			import org.osate.pluginsupport.properties.RealWithUnits;
			
			import other_ps.Mass;
			
			public class RealWithUnitsTest {
				public static Optional<RealWithUnits<Owned>> getOwned(NamedElement namedElement) {
					String name = "real_with_units_test::owned";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(new RealWithUnits<>(propertyExpression, Owned.class));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getOwned_EObject(NamedElement namedElement) {
					String name = "real_with_units_test::owned";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static Optional<RealWithUnits<Time>> getSameFile(NamedElement namedElement) {
					String name = "real_with_units_test::same_file";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(new RealWithUnits<>(propertyExpression, Time.class));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getSameFile_EObject(NamedElement namedElement) {
					String name = "real_with_units_test::same_file";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static Optional<RealWithUnits<Mass>> getOtherFile(NamedElement namedElement) {
					String name = "real_with_units_test::other_file";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(new RealWithUnits<>(propertyExpression, Mass.class));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getOtherFile_EObject(NamedElement namedElement) {
					String name = "real_with_units_test::other_file";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<RealWithUnits<List1Owned>>> getList1Owned(NamedElement namedElement) {
					String name = "real_with_units_test::list_1_owned";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return new RealWithUnits<>(element1, List1Owned.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1Owned_EObject(NamedElement namedElement) {
					String name = "real_with_units_test::list_1_owned";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<RealWithUnits<Time>>> getList1SameFile(NamedElement namedElement) {
					String name = "real_with_units_test::list_1_same_file";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return new RealWithUnits<>(element1, Time.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1SameFile_EObject(NamedElement namedElement) {
					String name = "real_with_units_test::list_1_same_file";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static Optional<List<RealWithUnits<Mass>>> getList1OtherFile(NamedElement namedElement) {
					String name = "real_with_units_test::list_1_other_file";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(((ListValue) propertyExpression).getOwnedListElements().stream().map(element1 -> {
							return new RealWithUnits<>(element1, Mass.class);
						}).collect(Collectors.toList()));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getList1OtherFile_EObject(NamedElement namedElement) {
					String name = "real_with_units_test::list_1_other_file";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
				
				public static Optional<RecordProperty> getRecordProperty(NamedElement namedElement) {
					String name = "real_with_units_test::record_property";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					try {
						PropertyExpression propertyExpression = namedElement.getNonModalPropertyValue(property);
						return Optional.of(new RecordProperty(propertyExpression));
					} catch (PropertyNotPresentException e) {
						return Optional.empty();
					}
				}
				
				public static PropertyExpression getRecordProperty_EObject(NamedElement namedElement) {
					String name = "real_with_units_test::record_property";
					Property property = Aadl2GlobalScopeUtil.get(namedElement, Aadl2Package.eINSTANCE.getProperty(), name);
					return namedElement.getNonModalPropertyValue(property);
				}
			}
		'''
		val time = '''
			package real_with_units_test;
			
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
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val owned = '''
			package real_with_units_test;
			
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
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val list1Owned = '''
			package real_with_units_test;
			
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
				
				@Override
				public String toString() {
					return originalName;
				}
			}
		'''
		val recordProperty = '''
			package real_with_units_test;
			
			import java.util.List;
			import java.util.Objects;
			import java.util.Optional;
			import java.util.stream.Collectors;
			
			import org.osate.aadl2.AbstractNamedValue;
			import org.osate.aadl2.ListValue;
			import org.osate.aadl2.NamedValue;
			import org.osate.aadl2.PropertyExpression;
			import org.osate.aadl2.RecordValue;
			import org.osate.aadl2.UnitLiteral;
			import org.osate.pluginsupport.properties.GeneratedUnits;
			import org.osate.pluginsupport.properties.RealWithUnits;
			
			import other_ps.Mass;
			
			public class RecordProperty {
				private final Optional<RealWithUnits<Owned_FieldType>> owned;
				private final Optional<RealWithUnits<Time>> sameFile;
				private final Optional<RealWithUnits<Mass>> otherFile;
				private final Optional<List<RealWithUnits<List1Owned_FieldType>>> list1Owned;
				private final Optional<List<RealWithUnits<Time>>> list1SameFile;
				private final Optional<List<RealWithUnits<Mass>>> list1OtherFile;
				
				public RecordProperty(PropertyExpression propertyExpression) {
					RecordValue recordValue = (RecordValue) propertyExpression;
					this.owned = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("owned"))
							.map(field -> new RealWithUnits<>(field.getOwnedValue(), Owned_FieldType.class))
							.findAny();
					this.sameFile = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("same_file"))
							.map(field -> new RealWithUnits<>(field.getOwnedValue(), Time.class))
							.findAny();
					this.otherFile = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("other_file"))
							.map(field -> new RealWithUnits<>(field.getOwnedValue(), Mass.class))
							.findAny();
					this.list1Owned = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("list_1_owned"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new RealWithUnits<>(element1, List1Owned_FieldType.class);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.list1SameFile = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("list_1_same_file"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new RealWithUnits<>(element1, Time.class);
								}).collect(Collectors.toList());
							})
							.findAny();
					this.list1OtherFile = recordValue.getOwnedFieldValues()
							.stream()
							.filter(field -> field.getProperty().getName().equals("list_1_other_file"))
							.map(field -> {
								return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
									return new RealWithUnits<>(element1, Mass.class);
								}).collect(Collectors.toList());
							})
							.findAny();
				}
				
				public Optional<RealWithUnits<Owned_FieldType>> getOwned() {
					return owned;
				}
				
				public Optional<RealWithUnits<Time>> getSameFile() {
					return sameFile;
				}
				
				public Optional<RealWithUnits<Mass>> getOtherFile() {
					return otherFile;
				}
				
				public Optional<List<RealWithUnits<List1Owned_FieldType>>> getList1Owned() {
					return list1Owned;
				}
				
				public Optional<List<RealWithUnits<Time>>> getList1SameFile() {
					return list1SameFile;
				}
				
				public Optional<List<RealWithUnits<Mass>>> getList1OtherFile() {
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
					
					@Override
					public String toString() {
						return originalName;
					}
				}
			}
		'''
		val results = PropertiesCodeGen.generateJava(testHelper.parseString(realWithUnitsTest, otherPs))
		assertEquals(5, results.size)
		
		assertEquals("RealWithUnitsTest.java", results.get(0).fileName)
		assertEquals(realWithUnitsTestClass.toString, results.get(0).contents)
		
		assertEquals("Time.java", results.get(1).fileName)
		assertEquals(time.toString, results.get(1).contents)
		
		assertEquals("Owned.java", results.get(2).fileName)
		assertEquals(owned.toString, results.get(2).contents)
		
		assertEquals("List1Owned.java", results.get(3).fileName)
		assertEquals(list1Owned.toString, results.get(3).contents)
		
		assertEquals("RecordProperty.java", results.get(4).fileName)
		assertEquals(recordProperty.toString, results.get(4).contents)
	}
}