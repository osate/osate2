/**
 */
package org.osate.expr.expr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Binary Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.BinaryOperation#getLeft <em>Left</em>}</li>
 *   <li>{@link org.osate.expr.expr.BinaryOperation#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.osate.expr.expr.BinaryOperation#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getBinaryOperation()
 * @model
 * @generated
 */
public interface BinaryOperation extends Expression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expression)
   * @see org.osate.expr.expr.ExprPackage#getBinaryOperation_Left()
   * @model containment="true"
   * @generated
   */
  Expression getLeft();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.BinaryOperation#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expression value);

  /**
   * Returns the value of the '<em><b>Operator</b></em>' attribute.
   * The literals are from the enumeration {@link org.osate.expr.expr.Operation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operator</em>' attribute.
   * @see org.osate.expr.expr.Operation
   * @see #setOperator(Operation)
   * @see org.osate.expr.expr.ExprPackage#getBinaryOperation_Operator()
   * @model
   * @generated
   */
  Operation getOperator();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.BinaryOperation#getOperator <em>Operator</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operator</em>' attribute.
   * @see org.osate.expr.expr.Operation
   * @see #getOperator()
   * @generated
   */
  void setOperator(Operation value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference.
   * @see #setRight(Expression)
   * @see org.osate.expr.expr.ExprPackage#getBinaryOperation_Right()
   * @model containment="true"
   * @generated
   */
  Expression getRight();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.BinaryOperation#getRight <em>Right</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Right</em>' containment reference.
   * @see #getRight()
   * @generated
   */
  void setRight(Expression value);

} // BinaryOperation
