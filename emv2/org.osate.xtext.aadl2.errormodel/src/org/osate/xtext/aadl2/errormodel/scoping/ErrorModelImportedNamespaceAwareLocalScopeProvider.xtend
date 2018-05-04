package org.osate.xtext.aadl2.errormodel.scoping

import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.impl.ImportNormalizer
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider
import org.osate.aadl2.modelsupport.util.AadlUtil

class ErrorModelImportedNamespaceAwareLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
	override protected getImplicitImports(boolean ignoreCase) {
		AadlUtil.predeclaredPropertySetNames.map[new ImportNormalizer(QualifiedName.create(it), true, ignoreCase)].toList
	}
}