/**
 */
package org.osate.verify.verify;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plugin Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.verify.verify.PluginMethod#getMethodID <em>Method ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.verify.verify.VerifyPackage#getPluginMethod()
 * @model
 * @generated
 */
public interface PluginMethod extends MethodType
{
  /**
   * Returns the value of the '<em><b>Method ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method ID</em>' attribute.
   * @see #setMethodID(String)
   * @see org.osate.verify.verify.VerifyPackage#getPluginMethod_MethodID()
   * @model
   * @generated
   */
  String getMethodID();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.PluginMethod#getMethodID <em>Method ID</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method ID</em>' attribute.
   * @see #getMethodID()
   * @generated
   */
  void setMethodID(String value);

} // PluginMethod
