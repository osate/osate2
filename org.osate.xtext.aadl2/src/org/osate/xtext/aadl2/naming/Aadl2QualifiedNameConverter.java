package org.osate.xtext.aadl2.naming;

import java.util.List;

import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.util.Strings;

public class Aadl2QualifiedNameConverter extends IQualifiedNameConverter.DefaultImpl {

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
		List<String> segs = Strings.split(qualifiedNameAsString, getDelimiter());
		return QualifiedName.create(segs);
	}

	@Override
	public String getDelimiter() {
		return "::";
	}

}
