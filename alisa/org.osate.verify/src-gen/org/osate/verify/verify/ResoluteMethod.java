/**
 */
package org.osate.verify.verify;

import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resolute Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.ResoluteMethod#getMethodReference <em>Method Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getResoluteMethod()
 * @model
 * @generated
 */
public interface ResoluteMethod extends MethodType
{
  /**
   * Returns the value of the '<em><b>Method Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method Reference</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Reference</em>' reference.
   * @see #setMethodReference(FunctionDefinition)
   * @see org.osate.verify.verify.VerifyPackage#getResoluteMethod_MethodReference()
   * @model
   * @generated
   */
  FunctionDefinition getMethodReference();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ResoluteMethod#getMethodReference <em>Method Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method Reference</em>' reference.
   * @see #getMethodReference()
   * @generated
   */
  void setMethodReference(FunctionDefinition value);

} // ResoluteMethod
