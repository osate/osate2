package org.osate.propertiescodegen

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class GeneratedPackage {
	val String packagePath
	val List<GeneratedClass> classes
}