package org.osate2.aadl2.errormodel.analysis.prism.expression;

public class Equal implements Expression {
	private Expression left;
	private Expression right;

	public Equal(Expression l, Expression r) {
		left = l;
		right = r;
	}

	@Override
	public String toString() {
		return left.toString() + "=" + right.toString();
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

	public boolean equalsTo(Expression e) {

		if (!(e instanceof Equal)) {
			return false;
		}

		return (e.toString() == toString());

	}
}
