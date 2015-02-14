package org.osate2.aadl2.errormodel.analysis.prism;

import org.osate2.aadl2.errormodel.analysis.prism.expression.Expression;

/**
 * The formula class implements a basic formula associated
 * with a module of a Model.
 *
 * @author jdelange
 *
 */
public class Formula {
	private String name;
	private Expression expression;

	/**
	 * Create a formula with a name and a simple expression
	 * @param n	Name of the formula in PRISM.
	 * @param e Expression associated with the formula.
	 */
	public Formula(String n, Expression e) {
		name = n;
		expression = e;
	}

	/**
	 * Produce the PRISM code that maps this formula.
	 * Create PRISM code using this pattern:
	 * 		formula FORMULA_NAME FORMULA_EXPRESSION
	 * For example:
	 *		 formula gps_operational = sensor1_state = 0 & sensor2_state = 0 & processing_state = 0;
	 * @return
	 */
	public String getPRISMCode() {
		StringBuffer sb = new StringBuffer();
		sb.append("formula ");
		sb.append(name);
		sb.append(" = ");
		sb.append(expression.toString());
		sb.append(";");
		return sb.toString();
	}

}
