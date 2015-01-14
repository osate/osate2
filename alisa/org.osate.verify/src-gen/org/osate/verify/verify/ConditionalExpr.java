/**
 */
package org.osate.verify.verify;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Conditional Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.ConditionalExpr#getVerification <em>Verification</em>}</li>
 *   <li>{@link org.osate.verify.verify.ConditionalExpr#getOp <em>Op</em>}</li>
 *   <li>{@link org.osate.verify.verify.ConditionalExpr#getCondition <em>Condition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getConditionalExpr()
 * @model
 * @generated
 */
public interface ConditionalExpr extends ArgumentExpr
{
  /**
   * Returns the value of the '<em><b>Verification</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Verification</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Verification</em>' containment reference.
   * @see #setVerification(ArgumentExpr)
   * @see org.osate.verify.verify.VerifyPackage#getConditionalExpr_Verification()
   * @model containment="true"
   * @generated
   */
  ArgumentExpr getVerification();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ConditionalExpr#getVerification <em>Verification</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Verification</em>' containment reference.
   * @see #getVerification()
   * @generated
   */
  void setVerification(ArgumentExpr value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see org.osate.verify.verify.VerifyPackage#getConditionalExpr_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ConditionalExpr#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(ConditionExpr)
   * @see org.osate.verify.verify.VerifyPackage#getConditionalExpr_Condition()
   * @model containment="true"
   * @generated
   */
  ConditionExpr getCondition();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ConditionalExpr#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(ConditionExpr value);

} // ConditionalExpr
