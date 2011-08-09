/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.sandbox.sandbox;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Instance Proxy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemInstanceProxy#getInstanceRef <em>Instance Ref</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage#getSystemInstanceProxy()
 * @model
 * @generated
 */
public interface SystemInstanceProxy extends EObject
{
  /**
   * Returns the value of the '<em><b>Instance Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Instance Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Instance Ref</em>' reference.
   * @see #setInstanceRef(EObject)
   * @see org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage#getSystemInstanceProxy_InstanceRef()
   * @model
   * @generated
   */
  EObject getInstanceRef();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemInstanceProxy#getInstanceRef <em>Instance Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Instance Ref</em>' reference.
   * @see #getInstanceRef()
   * @generated
   */
  void setInstanceRef(EObject value);

} // SystemInstanceProxy
