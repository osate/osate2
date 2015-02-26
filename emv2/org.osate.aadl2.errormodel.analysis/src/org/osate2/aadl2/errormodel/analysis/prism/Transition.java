package org.osate2.aadl2.errormodel.analysis.prism;

import java.util.ArrayList;
import java.util.List;

import org.osate2.aadl2.errormodel.analysis.prism.expression.Expression;

public class Transition {
	private double probability;
	private List<Expression> expressions;
	private boolean useProbability;

	public Transition() {
		probability = 0.0;
		useProbability = true;
		expressions = new ArrayList<Expression>();
	}

	public Transition(double d, Expression e) {
		this();
		useProbability = true;
		probability = d;
		expressions.add(e);
	}

	public Transition(Expression e) {
		this();
		useProbability = false;
		expressions.add(e);
	}

	public double getProbability() {
		return probability;
	}

	public List<Expression> getExpressions() {
		return expressions;
	}

	public void addExpression(Expression e) {
		expressions.add(e);
	}

	public void setProbability(double d) {
		probability = d;
	}

	public boolean useProbability() {
		return useProbability;
	}
}
