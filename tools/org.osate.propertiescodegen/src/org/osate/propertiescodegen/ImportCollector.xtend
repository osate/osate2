package org.osate.propertiescodegen

import java.util.Set

package class ImportCollector {
	val Set<String> imports = newHashSet
	
	def void add(String... importsToAdd) {
		imports += importsToAdd
	}
	
	def String generate() {
		val javaImports = imports.filter[it.startsWith("java.")].sort
		val orgImports = imports.filter[it.startsWith("org.")].sort
		val otherImports = imports.filter[!it.startsWith("java.") && !it.startsWith("org.")].sort
		'''
			«IF !javaImports.empty»
			
			«FOR javaImport : javaImports»
			import «javaImport»;
			«ENDFOR»
			«ENDIF»
			«IF !orgImports.empty»
			
			«FOR orgImport : orgImports»
			import «orgImport»;
			«ENDFOR»
			«ENDIF»
			«IF !otherImports.empty»
			
			«FOR otherImport : otherImports»
			import «otherImport»;
			«ENDFOR»
			«ENDIF»
		'''
	}
}