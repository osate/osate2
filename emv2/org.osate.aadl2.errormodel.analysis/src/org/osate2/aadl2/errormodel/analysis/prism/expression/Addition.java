package org.osate2.aadl2.errormodel.analysis.prism.expression;

public class Addition implements Expression
{
	private Expression left;
	private Expression right;
	
	public Addition (Expression l, Expression r)
	{
		this.left = l;
		this.right = r;
	}
	
	public String toString ()
	{
		return this.left.toString() + "+" + right.toString();
	}
}
