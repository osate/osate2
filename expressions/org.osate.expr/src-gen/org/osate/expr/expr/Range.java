/**
 */
package org.osate.expr.expr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.expr.expr.Range#getMinimum <em>Minimum</em>}</li>
 *   <li>{@link org.osate.expr.expr.Range#getMaximum <em>Maximum</em>}</li>
 *   <li>{@link org.osate.expr.expr.Range#getDelta <em>Delta</em>}</li>
 * </ul>
 *
 * @see org.osate.expr.expr.ExprPackage#getRange()
 * @model
 * @generated
 */
public interface Range extends Expression
{
  /**
   * Returns the value of the '<em><b>Minimum</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Minimum</em>' containment reference.
   * @see #setMinimum(Expression)
   * @see org.osate.expr.expr.ExprPackage#getRange_Minimum()
   * @model containment="true"
   * @generated
   */
  Expression getMinimum();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.Range#getMinimum <em>Minimum</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Minimum</em>' containment reference.
   * @see #getMinimum()
   * @generated
   */
  void setMinimum(Expression value);

  /**
   * Returns the value of the '<em><b>Maximum</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Maximum</em>' containment reference.
   * @see #setMaximum(Expression)
   * @see org.osate.expr.expr.ExprPackage#getRange_Maximum()
   * @model containment="true"
   * @generated
   */
  Expression getMaximum();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.Range#getMaximum <em>Maximum</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Maximum</em>' containment reference.
   * @see #getMaximum()
   * @generated
   */
  void setMaximum(Expression value);

  /**
   * Returns the value of the '<em><b>Delta</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Delta</em>' containment reference.
   * @see #setDelta(Expression)
   * @see org.osate.expr.expr.ExprPackage#getRange_Delta()
   * @model containment="true"
   * @generated
   */
  Expression getDelta();

  /**
   * Sets the value of the '{@link org.osate.expr.expr.Range#getDelta <em>Delta</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Delta</em>' containment reference.
   * @see #getDelta()
   * @generated
   */
  void setDelta(Expression value);

} // Range
