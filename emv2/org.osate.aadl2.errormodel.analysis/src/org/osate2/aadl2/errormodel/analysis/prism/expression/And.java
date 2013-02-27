package org.osate2.aadl2.errormodel.analysis.prism.expression;

public class And implements Expression
{
	private Expression left;
	private Expression right;
	
	public And (Expression l, Expression r)
	{
		this.left = l;
		this.right = r;
	}
	
	public String toString ()
	{
		return this.left.toString() + " & " + right.toString();
	}
}
