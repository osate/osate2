package org.osate.expr.naming;

import org.eclipse.xtext.naming.IQualifiedNameConverter;

public class ExprQualifiedNameConverter extends IQualifiedNameConverter.DefaultImpl {

	@Override
	public String getDelimiter() {
		return "::";
	}

}
