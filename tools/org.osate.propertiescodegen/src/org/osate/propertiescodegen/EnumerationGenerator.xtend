package org.osate.propertiescodegen

import org.osate.aadl2.EnumerationType

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI

package class EnumerationGenerator extends AbstractPropertyGenerator {
	val EnumerationType enumType
	val String typeName
	
	new(EnumerationType enumType, String packageName, String typeName, ImportCollector imports) {
		super(packageName, imports)
		this.enumType = enumType
		this.typeName = typeName
	}
	
	new(EnumerationType enumType, String packageName, String typeName) {
		super(packageName)
		this.enumType = enumType
		this.typeName = typeName
	}
	
	override generate() {
		imports.add(
			"org.eclipse.emf.common.util.URI",
			"org.osate.aadl2.AbstractNamedValue",
			"org.osate.aadl2.EnumerationLiteral",
			"org.osate.aadl2.NamedValue",
			"org.osate.aadl2.PropertyExpression",
			"org.osate.pluginsupport.properties.GeneratedEnumeration"
		)
		val literals = enumType.ownedLiterals.join(",\n")['''«it.name.toUpperCase»("«it.name»", "«it.URI»")''']
		'''
			public enum «typeName» implements GeneratedEnumeration {
				«literals»;
				
				private final String originalName;
				private final URI uri;
				
				private «typeName»(String originalName, String uri) {
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static «typeName» valueOf(PropertyExpression propertyExpression) {
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
	}
}