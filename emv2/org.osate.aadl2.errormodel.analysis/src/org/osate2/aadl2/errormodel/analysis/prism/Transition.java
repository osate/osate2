package org.osate2.aadl2.errormodel.analysis.prism;

import org.osate2.aadl2.errormodel.analysis.prism.expression.*;

public class Transition {
	private double probability;
	private Expression expression;
	
	public Transition ()
	{
		this.probability = 0.0;
		this.expression = new Terminal ("unknown_expression");
	}
	
	public Transition (double d, Expression e)
	{
		this.probability = d;
		this.expression = e;
	}
	
	public double getProbability ()
	{
		return this.probability;
	}
	
	public Expression getExpression ()
	{
		return this.expression;
	}
	
	public void setExpression (Expression e)
	{
		this.expression = e;
	}
	
	public void setProbability (double d)
	{
		this.probability = d;
	}
}
