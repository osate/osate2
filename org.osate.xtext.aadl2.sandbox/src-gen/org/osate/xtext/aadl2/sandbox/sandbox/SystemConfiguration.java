/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.sandbox.sandbox;

import org.eclipse.emf.ecore.EObject;

import org.osate.aadl2.AadlPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration#getName <em>Name</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration#getSystemImplementation <em>System Implementation</em>}</li>
 *   <li>{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration#getSystemInstanceProxy <em>System Instance Proxy</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage#getSystemConfiguration()
 * @model
 * @generated
 */
public interface SystemConfiguration extends EObject
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
   * @see org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage#getSystemConfiguration_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>System Implementation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>System Implementation</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>System Implementation</em>' containment reference.
   * @see #setSystemImplementation(AadlPackage)
   * @see org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage#getSystemConfiguration_SystemImplementation()
   * @model containment="true"
   * @generated
   */
  AadlPackage getSystemImplementation();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration#getSystemImplementation <em>System Implementation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>System Implementation</em>' containment reference.
   * @see #getSystemImplementation()
   * @generated
   */
  void setSystemImplementation(AadlPackage value);

  /**
   * Returns the value of the '<em><b>System Instance Proxy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>System Instance Proxy</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>System Instance Proxy</em>' containment reference.
   * @see #setSystemInstanceProxy(SystemInstanceProxy)
   * @see org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage#getSystemConfiguration_SystemInstanceProxy()
   * @model containment="true"
   * @generated
   */
  SystemInstanceProxy getSystemInstanceProxy();

  /**
   * Sets the value of the '{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration#getSystemInstanceProxy <em>System Instance Proxy</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>System Instance Proxy</em>' containment reference.
   * @see #getSystemInstanceProxy()
   * @generated
   */
  void setSystemInstanceProxy(SystemInstanceProxy value);

} // SystemConfiguration
