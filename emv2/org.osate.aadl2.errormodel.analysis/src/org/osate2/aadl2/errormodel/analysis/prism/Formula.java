package org.osate2.aadl2.errormodel.analysis.prism;

import org.osate2.aadl2.errormodel.analysis.prism.expression.Expression;

/**
 * The formula class implements a basic formula associated
 * with a module of a Model.
 * 
 * @author jdelange
 *
 */
public class Formula {
	private String name;
	private Expression expression;

	public Formula (String n, Expression e)
	{
		this.name 		= n;
		this.expression = e;
	}
}
