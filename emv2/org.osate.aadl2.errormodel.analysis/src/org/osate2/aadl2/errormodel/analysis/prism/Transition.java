package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.List;

import org.osate2.aadl2.errormodel.analysis.prism.expression.Expression;

public class Transition {
	private double probability;
	private List<Expression> expressions;
	private boolean useProbability;
	
	public Transition ()
	{
		this.probability = 0.0;
		this.useProbability = true;
		this.expressions = new ArrayList<Expression>();
	}
	
	public Transition (double d, Expression e)
	{
		this();
		this.useProbability = true;
		this.probability = d;
		this.expressions.add (e);
	}
	
	public Transition (Expression e)
	{
		this();
		this.useProbability = false;
		this.expressions.add (e);
	}
	
	public double getProbability ()
	{
		return this.probability;
	}
	
	public List<Expression> getExpressions ()
	{
		return this.expressions;
	}
	
	public void addExpression (Expression e)
	{
		this.expressions.add (e);
	}
	
	public void setProbability (double d)
	{
		this.probability = d;
	}
	
	public boolean useProbability ()
	{
		return this.useProbability;
	}
}
