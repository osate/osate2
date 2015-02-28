package org.osate2.aadl2.errormodel.analysis.prism.expression;

public class Value implements Expression {
	private double value;

	public Value(double d) {
		value = d;
	}

	@Override
	public String toString() {
		return Double.toString(value);
	}
}
