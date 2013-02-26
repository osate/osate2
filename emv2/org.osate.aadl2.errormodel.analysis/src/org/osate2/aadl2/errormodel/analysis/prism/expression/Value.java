package org.osate2.aadl2.errormodel.analysis.prism.expression;

public class Value implements Expression
{
	private double value;
	
	public Value (double d)
	{
		this.value = d;
	}
	

	public String toString ()
	{
		return Double.toString(this.value);
	}
}
