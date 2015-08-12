/**
 */
package org.osate.verify.verify;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manual Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.ManualMethod#getDialogID <em>Dialog ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getManualMethod()
 * @model
 * @generated
 */
public interface ManualMethod extends MethodType
{
  /**
   * Returns the value of the '<em><b>Dialog ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dialog ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dialog ID</em>' attribute.
   * @see #setDialogID(String)
   * @see org.osate.verify.verify.VerifyPackage#getManualMethod_DialogID()
   * @model
   * @generated
   */
  String getDialogID();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.ManualMethod#getDialogID <em>Dialog ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dialog ID</em>' attribute.
   * @see #getDialogID()
   * @generated
   */
  void setDialogID(String value);

} // ManualMethod
