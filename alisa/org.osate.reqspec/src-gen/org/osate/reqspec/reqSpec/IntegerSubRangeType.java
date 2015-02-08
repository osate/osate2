/**
 */
package org.osate.reqspec.reqSpec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Sub Range Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.reqspec.reqSpec.IntegerSubRangeType#getLow <em>Low</em>}</li>
 *   <li>{@link org.osate.reqspec.reqSpec.IntegerSubRangeType#getHigh <em>High</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getIntegerSubRangeType()
 * @model
 * @generated
 */
public interface IntegerSubRangeType extends Type, FiniteSetType
{
  /**
   * Returns the value of the '<em><b>Low</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Low</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Low</em>' containment reference.
   * @see #setLow(Expr)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getIntegerSubRangeType_Low()
   * @model containment="true"
   * @generated
   */
  Expr getLow();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.IntegerSubRangeType#getLow <em>Low</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Low</em>' containment reference.
   * @see #getLow()
   * @generated
   */
  void setLow(Expr value);

  /**
   * Returns the value of the '<em><b>High</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>High</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>High</em>' containment reference.
   * @see #setHigh(Expr)
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#getIntegerSubRangeType_High()
   * @model containment="true"
   * @generated
   */
  Expr getHigh();

  /**
   * Sets the value of the '{@link org.osate.reqspec.reqSpec.IntegerSubRangeType#getHigh <em>High</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>High</em>' containment reference.
   * @see #getHigh()
   * @generated
   */
  void setHigh(Expr value);

} // IntegerSubRangeType
