package org.osate2.aadl2.errormodel.analysis.prism.expression;

public class Equal implements Expression
{
	private Expression left;
	private Expression right;
	
	public Equal (Expression l, Expression r)
	{
		this.left = l;
		this.right = r;
	}
	
	public String toString ()
	{
		return this.left.toString() + "=" + right.toString();
	}
	
	public Expression getLeft()
	{
		return this.left;
	}
	
	public Expression getRight ()
	{
		return this.right;
	}
	
	public boolean equalsTo (Expression e)
	{
		
		if (! (e instanceof Equal))
		{
			return false;
		}
		
		return (e.toString() == this.toString());
		
		
	}
}
