package org.osate.propertiescodegen

import java.util.List
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.PropertySet
import org.osate.aadl2.UnitsType

class PropertiesCodeGen {
	def static List<GeneratedJava> generateJava(PropertySet propertySet) {
		propertySet.ownedPropertyTypes.filter(EnumerationType).filter[!(it instanceof UnitsType)].map [ enumType |
			val typeName = enumType.name.split("_").map[it.toLowerCase.toFirstUpper].join
			val literals = enumType.ownedLiterals.map[it.name.toUpperCase].join(",\n")
			val contents = '''
				package «propertySet.name.toLowerCase»;
				
				import org.osate.aadl2.AbstractNamedValue;
				import org.osate.aadl2.EnumerationLiteral;
				import org.osate.aadl2.NamedValue;
				import org.osate.aadl2.Property;
				import org.osate.aadl2.PropertyConstant;
				import org.osate.aadl2.PropertyExpression;
				
				public enum «typeName» {
					«literals»;
					
					public static «typeName» valueOf(PropertyExpression propertyExpression) {
						AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
						if (abstractNamedValue instanceof EnumerationLiteral) {
							return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
						} else if (abstractNamedValue instanceof Property) {
							throw new IllegalArgumentException("Reference to property not supported");
						} else if (abstractNamedValue instanceof PropertyConstant) {
							throw new IllegalArgumentException("Reference to property constant not supported");
						} else {
							throw new AssertionError("Unexpected type: " + abstractNamedValue.getClass().getName());
						}
					}
				}'''
			new GeneratedJava(typeName + ".java", contents)
		].toList
	}
}
