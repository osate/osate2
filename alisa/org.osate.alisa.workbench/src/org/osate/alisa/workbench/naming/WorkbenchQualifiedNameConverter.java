package org.osate.alisa.workbench.naming;

import java.util.List;

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;

public class WorkbenchQualifiedNameConverter extends IQualifiedNameConverter.DefaultImpl {
	@Override
	public QualifiedName toQualifiedName(String qualifiedNameAsString) {
		if (qualifiedNameAsString == null) {
			throw new IllegalArgumentException("Qualified name cannot be null");
		}
		if (qualifiedNameAsString.equals("")) {
			throw new IllegalArgumentException("Qualified name cannot be empty");
		}
		if (Strings.isEmpty(getDelimiter())) {
			return QualifiedName.create(qualifiedNameAsString);
		}
		if (qualifiedNameAsString.contains("::")) {
			List<String> segs = Strings.split(qualifiedNameAsString, "::");
			return QualifiedName.create(segs);
		}
		List<String> segs = Strings.split(qualifiedNameAsString, getDelimiter());
		return QualifiedName.create(segs);
	}

	@Override
	public String toString(QualifiedName qualifiedName) {
		if (qualifiedName == null)
			throw new IllegalArgumentException("Qualified name cannot be null");
		return qualifiedName.toString(getDelimiter());
	}
}
