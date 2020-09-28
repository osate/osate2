package org.osate.propertiescodegen

import org.osate.aadl2.AadlBoolean
import org.osate.aadl2.AadlInteger
import org.osate.aadl2.AadlReal
import org.osate.aadl2.AadlString
import org.osate.aadl2.BasicProperty
import org.osate.aadl2.ClassifierType
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.ListType
import org.osate.aadl2.NumberType
import org.osate.aadl2.PropertyType
import org.osate.aadl2.RangeType
import org.osate.aadl2.RecordType
import org.osate.aadl2.ReferenceType
import org.osate.aadl2.UnitsType

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.eclipse.emf.ecore.util.EcoreUtil.isAncestor
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.getBasePropertyType
import static extension org.osate.propertiescodegen.PropertiesCodeGen.toCamelCase

package class RecordGenerator extends AbstractPropertyGenerator {
	val RecordType recordType
	val String typeName
	val boolean topLevel
	
	new(RecordType recordType, String packageName, String typeName) {
		super(packageName)
		this.recordType = recordType
		this.typeName = typeName
		topLevel = true
	}
	
	private new(RecordType recordType, String packageName, String typeName, ImportCollector imports) {
		super(packageName, imports)
		this.recordType = recordType
		this.typeName = typeName
		topLevel = false
	}
	
	override generate() {
		imports.add("org.osate.pluginsupport.properties.GeneratedRecord")
		'''
			public«IF !topLevel» static«ENDIF» class «typeName» extends GeneratedRecord {
				«generateConstants»
				
				«generateFields»
				
				«generateFieldByFieldConstructor»
				
				«generateExtractionConstructor»
				«generateGetters»
				
				«generateToPropertyExpression»
				
				«generateHashCode»
				
				«generateEquals»
				
				«generateToString»
				«FOR fieldType : recordType.ownedFields.map[generateFieldType(it)].filterNull»
				
				«fieldType»
				«ENDFOR»
			}
		'''
	}
	
	def private String generateConstants() {
		imports.add("org.eclipse.emf.common.util.URI")
		'''
			«FOR field : recordType.ownedFields»
			public static final String «field.name.toUpperCase»__NAME = "«field.name»";
			«ENDFOR»
			«FOR field : recordType.ownedFields»
			public static final URI «field.name.toUpperCase»__URI = URI.createURI("«field.URI»");
			«ENDFOR»
		'''
	}
	
	def private String generateFields() {
		'''
			«FOR field : recordType.ownedFields»
			private final «getGenericOptionalType(field.propertyType)» «field.name.toCamelCase.toFirstLower»;
			«ENDFOR»
		'''
	}
	
	def private String generateFieldByFieldConstructor() {
		'''
			«IF recordType.ownedFields.size == 1»
			«val field = recordType.ownedFields.head»
			public «typeName»(«getGenericOptionalType(field.propertyType)» «field.name.toCamelCase.toFirstLower») {
			«ELSE»
			«val fields = recordType.ownedFields»
			public «typeName»(
					«fields.join(",\n")[getGenericOptionalType(it.propertyType) + " " + it.name.toCamelCase.toFirstLower]»
			) {
			«ENDIF»
				«FOR field : recordType.ownedFields»
				«val fieldName = field.name.toCamelCase.toFirstLower»
				this.«fieldName» = «fieldName»;
				«ENDFOR»
			}
		'''
	}
	
	def private String generateExtractionConstructor() {
		imports.add(
			"java.util.Optional",
			"org.osate.aadl2.Mode",
			"org.osate.aadl2.NamedElement",
			"org.osate.aadl2.PropertyExpression",
			"org.osate.aadl2.RecordValue",
			"org.osate.aadl2.properties.PropertyNotPresentException",
			"org.osate.pluginsupport.properties.CodeGenUtil"
		)
		'''
			public «typeName»(PropertyExpression propertyExpression, NamedElement lookupContext, Optional<Mode> mode) {
				RecordValue recordValue = (RecordValue) propertyExpression;
				«FOR field : recordType.ownedFields»
				
				«val fieldName = field.name.toCamelCase.toFirstLower»
				«val fieldType = field.propertyType»
				«getGenericOptionalType(fieldType)» «fieldName»_local;
				try {
					«fieldName»_local = findFieldValue(recordValue, «field.name.toUpperCase»__NAME).map(field -> {
						PropertyExpression resolved = CodeGenUtil.resolveNamedValue(field.getOwnedValue(), lookupContext, mode);
						return «getValueExtractor(fieldType, "resolved", 1)»;
					«getPrimitiveConversion(fieldType)»
				} catch (PropertyNotPresentException e) {
					«fieldName»_local = «getBaseOptionalType(fieldType)».empty();
				}
				this.«fieldName» = «fieldName»_local;
				«ENDFOR»
			}
		'''
	}
	
	def private String getPrimitiveConversion(PropertyType type) {
		switch type {
			AadlInteger case type.unitsType === null: {
				imports.add("java.util.OptionalLong")
				"}).map(OptionalLong::of).orElse(OptionalLong.empty());"
			}
			AadlReal case type.unitsType === null: {
				imports.add("java.util.OptionalDouble")
				"}).map(OptionalDouble::of).orElse(OptionalDouble.empty());"
			}
			default: "});"
		}
	}
	
	def private String generateGetters() {
		'''
			«FOR field : recordType.ownedFields»
			
			public «getGenericOptionalType(field.propertyType)» get«field.name.toCamelCase»() {
				return «field.name.toCamelCase.toFirstLower»;
			}
			«ENDFOR»
		'''
	}
	
	def private String generateToPropertyExpression() {
		imports.add(
			"org.eclipse.emf.ecore.resource.ResourceSet",
			"org.osate.aadl2.Aadl2Factory",
			"org.osate.aadl2.BasicPropertyAssociation",
			"org.osate.aadl2.RecordValue"
		)
		'''
			@Override
			public RecordValue toPropertyExpression(ResourceSet resourceSet) {
				«IF recordType.ownedFields.size == 1»
				if (!«recordType.ownedFields.head.name.toCamelCase.toFirstLower».isPresent()) {
				«ELSE»
				if (!«recordType.ownedFields.head.name.toCamelCase.toFirstLower».isPresent()
						«FOR field : recordType.ownedFields.tail»
						&& !«field.name.toCamelCase.toFirstLower».isPresent()
						«ENDFOR»
				) {
				«ENDIF»
					throw new IllegalStateException("Record must have at least one field set.");
				}
				RecordValue recordValue = Aadl2Factory.eINSTANCE.createRecordValue();
				«FOR field : recordType.ownedFields»
				«val capitalized = field.name.toUpperCase»
				«field.name.toCamelCase.toFirstLower».ifPresent(field -> {
					BasicPropertyAssociation fieldAssociation = recordValue.createOwnedFieldValue();
					fieldAssociation.setProperty(loadField(resourceSet, «capitalized»__URI, «capitalized»__NAME));
					fieldAssociation.setOwnedValue(«getValueCreator(field.propertyType, "field", 1)»);
				});
				«ENDFOR»
				return recordValue;
			}
		'''
	}
	
	def private String getValueCreator(PropertyType type, String parameterName, int listDepth) {
		switch type {
			ListType: {
				imports.add("org.osate.pluginsupport.properties.CodeGenUtil")
				val nextParameterName = "element" + listDepth
				'''
					CodeGenUtil.toPropertyExpression(«parameterName», «nextParameterName» -> {
						return «getValueCreator(type.elementType, nextParameterName, listDepth + 1)»;
					})'''
			}
			AadlBoolean,
			AadlString,
			ClassifierType,
			NumberType case type.unitsType === null,
			ReferenceType: {
				imports.add("org.osate.pluginsupport.properties.CodeGenUtil")
				'''CodeGenUtil.toPropertyExpression(«parameterName»)'''
			}
			RangeType case type.numberType.unitsType === null: parameterName + ".toPropertyExpression()"
			EnumerationType,
			NumberType,
			RangeType,
			RecordType: parameterName + ".toPropertyExpression(resourceSet)"
		}
	}
	
	def private String generateHashCode() {
		imports.add("java.util.Objects")
		'''
			@Override
			public int hashCode() {
				«IF recordType.ownedFields.size == 1»
				return Objects.hash(«recordType.ownedFields.head.name.toCamelCase.toFirstLower»);
				«ELSE»
				return Objects.hash(
						«recordType.ownedFields.join(",\n")[it.name.toCamelCase.toFirstLower]»
				);
				«ENDIF»
			}
		'''
	}
	
	def private String generateEquals() {
		imports.add("java.util.Objects")
		'''
			@Override
			public boolean equals(Object obj) {
				if (this == obj) {
					return true;
				}
				if (!(obj instanceof «typeName»)) {
					return false;
				}
				«typeName» other = («typeName») obj;
				«IF recordType.ownedFields.size == 1»
				«val fieldName = recordType.ownedFields.head.name.toCamelCase.toFirstLower»
				return Objects.equals(this.«fieldName», other.«fieldName»);
				«ELSE»
				«val firstFieldName = recordType.ownedFields.head.name.toCamelCase.toFirstLower»
				return Objects.equals(this.«firstFieldName», other.«firstFieldName»)
						«FOR field : recordType.ownedFields.take(recordType.ownedFields.size - 1).tail»
						«val fieldName = field.name.toCamelCase.toFirstLower»
						&& Objects.equals(this.«fieldName», other.«fieldName»)
						«ENDFOR»
						«val lastFieldName = recordType.ownedFields.last.name.toCamelCase.toFirstLower»
						&& Objects.equals(this.«lastFieldName», other.«lastFieldName»);
				«ENDIF»
			}
		'''
	}
	
	def private String generateToString() {
		'''
			@Override
			public String toString() {
				StringBuilder builder = new StringBuilder();
				builder.append('[');
				«FOR field : recordType.ownedFields»
				this.«field.name.toCamelCase.toFirstLower».ifPresent(field -> {
					builder.append(«field.name.toUpperCase»__NAME);
					builder.append(" => «getStringPrefix(field.propertyType)»");
					builder.append(«getStringBody(field.propertyType)»);
					builder.append(«getStringPostfix(field.propertyType)»);
				});
				«ENDFOR»
				builder.append(']');
				return builder.toString();
			}
		'''
	}
	
	def private static String getStringPrefix(PropertyType type) {
		switch type {
			AadlString: '''\"'''
			ClassifierType: "classifier ("
			ReferenceType: "reference ("
			default: ""
		}
	}
	
	def private String getStringBody(PropertyType type) {
		switch type {
			ListType: {
				imports.add("java.util.stream.Collectors")
				val transform = getStringTransform(type.elementType, 1)
				'''field.stream().map(«transform»).collect(Collectors.joining(", ", "(", ")"))'''
			}
			ClassifierType: "field.getQualifiedName()"
			ReferenceType: "field.getName()"
			default: "field"
		}
	}
	
	def private String getStringTransform(PropertyType type, int listDepth) {
		switch type {
			ListType: {
				imports.add("java.util.stream.Collectors")
				val transform = getStringTransform(type.elementType, listDepth + 1)
				'''
					element«listDepth» -> {
						return element«listDepth».stream().map(«transform»).collect(Collectors.joining(", ", "(", ")"));
					}'''
			}
			AadlString: '''
				element«listDepth» -> {
					return '\"' + element«listDepth» + '\"';
				}'''
			ClassifierType: '''
				element«listDepth» -> {
					return "classifier (" + element«listDepth».getQualifiedName() + ")";
				}'''
			ReferenceType: '''
				element«listDepth» -> {
					return "reference (" + element«listDepth».getName() + ")";
				}'''
			default: "Object::toString"
		}
	}
	
	def private static String getStringPostfix(PropertyType type) {
		switch type {
			AadlString: '''"\";"'''
			ClassifierType,
			ReferenceType: '");"'
			default: "';'"
		}
	}
	
	def private String generateFieldType(BasicProperty field) {
		val baseType = field.propertyType.basePropertyType
		if (field.isAncestor(baseType)) {
			val name = field.name.toCamelCase + "_FieldType"
			val generator = switch baseType {
				UnitsType: new UnitsGenerator(baseType, packageName, name, imports)
				EnumerationType: new EnumerationGenerator(baseType, packageName, name, imports)
				NumberType case baseType.ownedUnitsType !== null: {
					new UnitsGenerator(baseType.unitsType, packageName, name, imports)
				}
				RangeType case baseType.ownedNumberType?.ownedUnitsType !== null: {
					new UnitsGenerator(baseType.numberType.unitsType, packageName, name, imports)
				}
				RecordType: new RecordGenerator(baseType, packageName, name, imports)
				default: null
			}
			generator?.generate
		} else {
			null
		}
	}
}