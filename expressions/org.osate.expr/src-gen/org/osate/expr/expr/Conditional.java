/**
 */
package org.osate.expr.expr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.Conditional#getIf <em>If</em>}</li>
 *   <li>{@link org.osate.expr.expr.Conditional#getThen <em>Then</em>}</li>
 *   <li>{@link org.osate.expr.expr.Conditional#getElse <em>Else</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getConditional()
 * @model
 * @generated
 */
public interface Conditional extends Expression
{
  /**
   * Returns the value of the '<em><b>If</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>If</em>' containment reference.
   * @see #setIf(Expression)
   * @see org.osate.expr.expr.ExprPackage#getConditional_If()
   * @model containment="true"
   * @generated
   */
  Expression getIf();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.Conditional#getIf <em>If</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>If</em>' containment reference.
   * @see #getIf()
   * @generated
   */
  void setIf(Expression value);

  /**
   * Returns the value of the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then</em>' containment reference.
   * @see #setThen(Expression)
   * @see org.osate.expr.expr.ExprPackage#getConditional_Then()
   * @model containment="true"
   * @generated
   */
  Expression getThen();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.Conditional#getThen <em>Then</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then</em>' containment reference.
   * @see #getThen()
   * @generated
   */
  void setThen(Expression value);

  /**
   * Returns the value of the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else</em>' containment reference.
   * @see #setElse(Expression)
   * @see org.osate.expr.expr.ExprPackage#getConditional_Else()
   * @model containment="true"
   * @generated
   */
  Expression getElse();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.Conditional#getElse <em>Else</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else</em>' containment reference.
   * @see #getElse()
   * @generated
   */
  void setElse(Expression value);

} // Conditional
