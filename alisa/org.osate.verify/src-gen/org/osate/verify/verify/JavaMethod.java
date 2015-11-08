/**
 */
package org.osate.verify.verify;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.JavaMethod#getMethodPath <em>Method Path</em>}</li>
 * </ul>
 *
 * @see org.osate.verify.verify.VerifyPackage#getJavaMethod()
 * @model
 * @generated
 */
public interface JavaMethod extends MethodType
{
  /**
   * Returns the value of the '<em><b>Method Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Method Path</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Method Path</em>' attribute.
   * @see #setMethodPath(String)
   * @see org.osate.verify.verify.VerifyPackage#getJavaMethod_MethodPath()
   * @model
   * @generated
   */
  String getMethodPath();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.JavaMethod#getMethodPath <em>Method Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Method Path</em>' attribute.
   * @see #getMethodPath()
   * @generated
   */
  void setMethodPath(String value);

} // JavaMethod
