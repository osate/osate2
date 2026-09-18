/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2021 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.ba.analyzers;

import org.eclipse.emf.common.util.Enumerator;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ba.aadlba.BehaviorElement;
import org.osate.ba.aadlba.BehaviorPropertyConstant;
import org.osate.ba.aadlba.BinaryAddingOperator;
import org.osate.ba.aadlba.BinaryNumericOperator;
import org.osate.ba.aadlba.DataRepresentation;
import org.osate.ba.aadlba.Factor;
import org.osate.ba.aadlba.LogicalOperator;
import org.osate.ba.aadlba.MultiplyingOperator;
import org.osate.ba.aadlba.PropertyReference;
import org.osate.ba.aadlba.RelationalOperator;
import org.osate.ba.aadlba.UnaryAddingOperator;
import org.osate.ba.aadlba.UnaryBooleanOperator;
import org.osate.ba.aadlba.UnaryNumericOperator;
import org.osate.utils.internal.Aadl2Utils;
import org.osate.utils.internal.PropertyUtils;
import org.osate.utils.internal.names.DataModelProperties;

public class AdaLikeDataTypeChecker implements DataTypeChecker {
	private AnalysisErrorReporterManager _errManager;

	// Expected data representation for numerics in value expression checking,
	// excepted for operator **
	private final static DataRepresentation[] _numTypes = { DataRepresentation.INTEGER,
			DataRepresentation.FLOAT, DataRepresentation.FIXED };

	// Expected data representation for numerics in operator **
	// expression checking.
	private final static DataRepresentation[] _numTypesWithoutFixed = {
			DataRepresentation.INTEGER, DataRepresentation.FLOAT };

	// Expected data representation for alphanumerics in value expression
	// checking.
	private final static DataRepresentation[] _alphaNumTypes = { DataRepresentation.INTEGER,
			DataRepresentation.FLOAT, DataRepresentation.FIXED, DataRepresentation.CHARACTER,
			DataRepresentation.STRING };

	public AdaLikeDataTypeChecker(AnalysisErrorReporterManager errManager) {
		_errManager = errManager;
	}

	@Override
	public boolean conformsTo(TypeHolder type1, TypeHolder type2, boolean hasToCheckDimension) {
		if (type1 == null || type2 == null || type1.getDataRep() == null || type2.getDataRep() == null) {
			return false;
		}
		if (hasToCheckDimension) {
			// A symbolic extent is unknown, not zero. Compare rank and each extent only when both are known.
			if (type1.getDimension() >= 0 && type2.getDimension() >= 0
					&& type1.getDimension() != type2.getDimension()) {
				return false;
			}
			var sizes1 = type1.getDimensionSizes();
			var sizes2 = type2.getDimensionSizes();
			if (sizes1 != null && sizes2 != null) {
				for (var i = 0; i < Math.min(sizes1.length, sizes2.length); i++) {
					if (sizes1[i] > 0 && sizes2[i] > 0 && sizes1[i] != sizes2[i]) {
						return false;
					}
				}
			}
		}
		// Untyped features and unresolved references do not establish a mismatch. Let resolution diagnostics stand
		// on their own instead of adding errors that claim an unknown type disagrees with a known one.
		if (type1.getDataRep() == DataRepresentation.UNKNOWN && type1.getKlass() == null
				|| type2.getDataRep() == DataRepresentation.UNKNOWN && type2.getKlass() == null) {
			return true;
		}
		if (type1.getKlass() != null && type2.getKlass() != null) {
			// Annex D does not define classifier substitutability. OSATE uses nominal equality, including for
			// classifiers without a Data_Representation; extension and type/implementation pairs are distinct.
			if (!type1.getKlass().getQualifiedName().equalsIgnoreCase(type2.getKlass().getQualifiedName())) {
				return false;
			}
		}
		if (type1.getDataRep() == DataRepresentation.UNKNOWN || type2.getDataRep() == DataRepresentation.UNKNOWN) {
			return type1.getKlass() != null && type2.getKlass() != null;
		}
		// Ada universal real literals may initialize either floating or fixed-point values. This does not permit
		// implicit conversions between classifier-typed numerics or between integer and real literals.
		return type1.getDataRep() == type2.getDataRep()
				|| isUniversalReal(type1) && type2.getDataRep() == DataRepresentation.FIXED
				|| isUniversalReal(type2) && type1.getDataRep() == DataRepresentation.FIXED;
	}

	private static boolean isUniversalReal(TypeHolder type) {
		return type.getKlass() == null && type.getDataRep() == DataRepresentation.FLOAT;
	}

	public TypeHolder getTopLevelType(TypeHolder type1, TypeHolder type2) {
		if (conformsTo(type1, type2, true))
			return getTopLevelTypeWithoutConsistencyChecking(type1, type2);
		else
			return null;
	}

	private TypeHolder getTopLevelTypeWithoutConsistencyChecking(TypeHolder type1, TypeHolder type2) {
		// A universal literal adopts the other operand's declared type, including fixed-point representation.
		var source = type1.getKlass() != null || type2.getKlass() == null ? type1 : type2;
		var result = new TypeHolder(source.getDataRep(), source.getKlass());
		result.setDimension(source.getDimension());
		var sizes = source.getDimensionSizes();
		result.setDimensionSizes(sizes == null ? null : sizes.clone());
		return result;
	}

	@Override
	public TypeHolder checkDefinition(BehaviorElement e, Enumerator operator, TypeHolder operand1,
			TypeHolder operand2) {
		// Operator ** has special consistency checking.
		if (operator != BinaryNumericOperator.MULTIPLY_MULTIPLY && !conformsTo(operand1, operand2, true)) {
			reportErrorConsystency(e, operator, operand1, operand2);
			return null;
		}

		if (operator instanceof LogicalOperator) {
			if (operand1.getDataRep() == DataRepresentation.BOOLEAN) {
				return getTopLevelTypeWithoutConsistencyChecking(operand1, operand2);
			} else {
				reportErrorBinaryOperator(e, operator, operand1);
				return null;
			}
		} else if (operator instanceof RelationalOperator relationalOperator) {

			// Operators = and != are defined for all coherent types.
			if (relationalOperator == RelationalOperator.EQUAL
					|| relationalOperator == RelationalOperator.NOT_EQUAL) {
				return new TypeHolder(DataRepresentation.BOOLEAN, null);
			}

			if (Aadl2Utils.contains(operand1.getDataRep(), _alphaNumTypes)) {
				return new TypeHolder(DataRepresentation.BOOLEAN, null);
			} else {
				reportErrorBinaryOperator(e, operator, operand1);
				return null;
			}
		} else if (operator instanceof BinaryAddingOperator) {
			if (Aadl2Utils.contains(operand1.getDataRep(), _numTypes)) {
				return getTopLevelTypeWithoutConsistencyChecking(operand1, operand2);
			} else {
				reportErrorBinaryOperator(e, operator, operand1);
				return null;
			}
		} else if (operator instanceof MultiplyingOperator multiplyingOperator) {
			switch (multiplyingOperator) {
			case MULTIPLY, DIVIDE -> {
				if (Aadl2Utils.contains(operand1.getDataRep(), _numTypes)) {
					return getTopLevelTypeWithoutConsistencyChecking(operand1, operand2);
				}
				reportErrorBinaryOperator(e, operator, operand1);
				return null;
			}

			case MOD, REM -> {
				if (operand1.getDataRep() == DataRepresentation.INTEGER) {
					return getTopLevelTypeWithoutConsistencyChecking(operand1, operand2);
				}
				reportErrorBinaryOperator(e, operator, operand1);
				return null;
			}

			default -> {
				return null;
			}
			}
		} else if (operator instanceof BinaryNumericOperator) {
			// Checks operands consistency:
			if (Aadl2Utils.contains(operand1.getDataRep(), _numTypesWithoutFixed)) {
				var reportError = false;

				if (operand2.getDataRep() == DataRepresentation.INTEGER) {
					// Datatyped operand case : checks if operand2 is a natural.
					if (operand2.getKlass() != null) {
						var values = PropertyUtils
								.findPropertyExpression(operand2.getKlass(), DataModelProperties.INTEGER_RANGE);
						if (!values.isEmpty()) {
							var range = (RangeValue) values.getLast();
							if (range.getMinimumValue().getScaledValue() < 0) {
								reportError = true;
							}
						} else {
							reportError = true;
						}
					} else // constant data case : checks if the constant value is not
							// negative.
					{
						if (e instanceof Factor factor) {
							var value = factor.getSecondValue();

							// IntegerLiteral cannot be negative (otherwise parse
							// error) so it only checks
							// PropertyConstants and warns PropertyValues.
							if (value instanceof BehaviorPropertyConstant constant) {
								var property = constant.getProperty();
								var integer = (org.osate.aadl2.IntegerLiteral) property
										.getConstantValue();
								if (integer.getValue() < 0) {
									reportError = true;
								}
							} else if (value instanceof PropertyReference)
							// PropertyValue case : its value can only be evaluated at
							// runtime so raises a warning.
							{
								_errManager.warning(e, "Cannot evaluate if the exponent" + " is a natural");
							}
						}
					}
				} else {
					reportError = true;
				}

				if (reportError) {
					_errManager.error(e, "exponent must be of type natural, found " + operand2.toString());
					return null;
				} else {
					return operand1;
				}
			} else {
				reportErrorConsystency(e, operator, operand1, operand2);
				return null;
			}
		} else {
			var errorMsg = "operator : " + operator.getName() + " is not supported.";
			System.err.println(errorMsg);
			throw new UnsupportedOperationException(errorMsg);
		}
	}

	@Override
	public TypeHolder checkDefinition(BehaviorElement e, Enumerator operator, TypeHolder operand) {
		if (operator == null || operator.getValue() == 0 || operand == null || operand.getDataRep() == null
				|| operand.getDataRep() == DataRepresentation.UNKNOWN && operand.getKlass() == null) {
			reportErrorUnaryOperator(e, operator, operand);
			return null;
		}

		if (operator instanceof UnaryAddingOperator || operator instanceof UnaryNumericOperator) {
			if (Aadl2Utils.contains(operand.getDataRep(), _numTypes)) {
				return operand;
			} else {
				reportErrorUnaryOperator(e, operator, operand);
				return null;
			}
		} else if (operator instanceof UnaryBooleanOperator) {
			if (operand.getDataRep() == DataRepresentation.BOOLEAN) {
				return operand;
			} else {
				reportErrorUnaryOperator(e, operator, operand);
				return null;
			}
		} else {
			var errorMsg = "operator : " + operator.getName() + " is not supported.";
			System.err.println(errorMsg);
			throw new UnsupportedOperationException(errorMsg);
		}
	}

	private void reportErrorBinaryOperator(BehaviorElement e, Enumerator operator, TypeHolder operand1) {
		_errManager.error(e,
				"There is no applicable operator \"" + operator.getLiteral() + "\" for type " + operand1.toString());
	}

	private void reportErrorConsystency(BehaviorElement e, Enumerator operator, TypeHolder operand1,
			TypeHolder operand2) {
		_errManager.error(e,
				"Invalid operand types for operator \"" + operator.getLiteral() + "\": left operand has type "
						+ operand1.toString() + ", right operand has type " + operand2.toString());
	}

	private void reportErrorUnaryOperator(BehaviorElement e, Enumerator operator, TypeHolder operand) {
		_errManager.error(e, "Operator \"" + operator.getLiteral() + "\" not defined for type " + operand.toString());
	}
}
