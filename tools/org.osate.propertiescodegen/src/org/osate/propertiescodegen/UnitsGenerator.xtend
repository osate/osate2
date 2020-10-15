package org.osate.propertiescodegen

import org.osate.aadl2.UnitLiteral
import org.osate.aadl2.UnitsType

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI

package class UnitsGenerator extends AbstractPropertyGenerator {
	val UnitsType unitsType
	val String typeName
	
	new(UnitsType unitsType, String packageName, String typeName, ImportCollector imports) {
		super(packageName, imports)
		this.unitsType = unitsType
		this.typeName = typeName
	}
	
	new(UnitsType unitsType, String packageName, String typeName) {
		super(packageName)
		this.unitsType = unitsType
		this.typeName = typeName
	}
	
	override generate() {
		imports.add(
			"org.eclipse.emf.common.util.URI",
			"org.osate.aadl2.AbstractNamedValue",
			"org.osate.aadl2.NamedValue",
			"org.osate.aadl2.PropertyExpression",
			"org.osate.aadl2.UnitLiteral",
			"org.osate.pluginsupport.properties.GeneratedUnits"
		)
		val literals = unitsType.ownedLiterals.filter(UnitLiteral).sortBy[it.absoluteFactor]
		val literalsString = literals.join(",\n")['''«it.name.toUpperCase»(«it.absoluteFactor», "«it.name»", "«it.URI»")''']
		'''
			public enum «typeName» implements GeneratedUnits<«typeName»> {
				«literalsString»;
				
				private final double factorToBase;
				private final String originalName;
				private final URI uri;
				
				private «typeName»(double factorToBase, String originalName, String uri) {
					this.factorToBase = factorToBase;
					this.originalName = originalName;
					this.uri = URI.createURI(uri);
				}
				
				public static «typeName» valueOf(PropertyExpression propertyExpression) {
					AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
					return valueOf(((UnitLiteral) abstractNamedValue).getName().toUpperCase());
				}
				
				@Override
				public double getFactorToBase() {
					return factorToBase;
				}
				
				@Override
				public double getFactorTo(«typeName» target) {
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
	}
}