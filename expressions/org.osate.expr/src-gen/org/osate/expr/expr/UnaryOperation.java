/**
 */
package org.osate.expr.expr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.UnaryOperation#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.osate.expr.expr.UnaryOperation#getOperand <em>Operand</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getUnaryOperation()
 * @model
 * @generated
 */
public interface UnaryOperation extends Expression
{
  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.expr.expr.Operation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.osate.expr.expr.Operation
   * @see #setOperator(Operation)
   * @see org.osate.expr.expr.ExprPackage#getUnaryOperation_Operator()
   * @model
   * @generated
   */
  Operation getOperator();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.UnaryOperation#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.osate.expr.expr.Operation
   * @see #getOperator()
   * @generated
   */
  void setOperator(Operation value);

  /**
   * Returns the value of the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operand</em>' containment reference.
   * @see #setOperand(Expression)
   * @see org.osate.expr.expr.ExprPackage#getUnaryOperation_Operand()
   * @model containment="true"
   * @generated
   */
  Expression getOperand();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.UnaryOperation#getOperand <em>Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operand</em>' containment reference.
   * @see #getOperand()
   * @generated
   */
  void setOperand(Expression value);

} // UnaryOperation
