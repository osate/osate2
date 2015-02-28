package org.osate2.aadl2.errormodel.analysis.prism.expression;

public class Addition implements Expression {
	private Expression left;
	private Expression right;

	public Addition(Expression l, Expression r) {
		left = l;
		right = r;
	}

	@Override
	public String toString() {
		return left.toString() + "+" + right.toString();
	}
}
