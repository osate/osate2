/**
 */
package org.osate.verify.verify;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Formal Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.osate.verify.verify.FormalParameter#getParameterType <em>Parameter Type</em>}</li>
 *   <li>{@link org.osate.verify.verify.FormalParameter#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.osate.verify.verify.VerifyPackage#getFormalParameter()
 * @model
 * @generated
 */
public interface FormalParameter extends EObject
{
  /**
   * Returns the value of the '<em><b>Parameter Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameter Type</em>' attribute.
   * @see #setParameterType(String)
   * @see org.osate.verify.verify.VerifyPackage#getFormalParameter_ParameterType()
   * @model
   * @generated
   */
  String getParameterType();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.FormalParameter#getParameterType <em>Parameter Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameter Type</em>' attribute.
   * @see #getParameterType()
   * @generated
   */
  void setParameterType(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.osate.verify.verify.VerifyPackage#getFormalParameter_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.verify.verify.FormalParameter#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // FormalParameter
