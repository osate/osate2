/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.sandbox.sandbox;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sandbox</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.sandbox.sandbox.Sandbox#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.sandbox.sandbox.Sandbox#getSystemInstance <em>System Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage#getSandbox()
 * @model
 * @generated
 */
public interface Sandbox extends EObject
{
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
   * @see org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage#getSandbox_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.sandbox.sandbox.Sandbox#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>System Instance</b></em>' containment reference list.
   * The list contents are of type {@link org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>System Instance</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>System Instance</em>' containment reference list.
   * @see org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage#getSandbox_SystemInstance()
   * @model containment="true"
   * @generated
   */
  EList<SystemConfiguration> getSystemInstance();

} // Sandbox
