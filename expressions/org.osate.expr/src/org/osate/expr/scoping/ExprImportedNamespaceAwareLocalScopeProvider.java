package org.osate.expr.scoping;

import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.ImportNormalizer;
import org.eclipse.xtext.scoping.impl.ImportedNamespaceAwareLocalScopeProvider;
import org.osate.aadl2.modelsupport.util.AadlUtil;

public class ExprImportedNamespaceAwareLocalScopeProvider extends ImportedNamespaceAwareLocalScopeProvider {
	@Override
	protected List<ImportNormalizer> getImplicitImports(boolean ignoreCase) {
		return AadlUtil.getPredeclaredPropertySetNames().stream()
				.map(name -> new ImportNormalizer(QualifiedName.create(name), true, ignoreCase))
				.collect(Collectors.toList());
	}
}