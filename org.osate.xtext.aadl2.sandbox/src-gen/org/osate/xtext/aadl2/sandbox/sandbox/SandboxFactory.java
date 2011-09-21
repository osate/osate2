/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.sandbox.sandbox;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage
 * @generated
 */
public interface SandboxFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SandboxFactory eINSTANCE = org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Sandbox</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sandbox</em>'.
   * @generated
   */
  Sandbox createSandbox();

  /**
   * Returns a new object of class '<em>System Configuration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>System Configuration</em>'.
   * @generated
   */
  SystemConfiguration createSystemConfiguration();

  /**
   * Returns a new object of class '<em>System Instance Proxy</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>System Instance Proxy</em>'.
   * @generated
   */
  SystemInstanceProxy createSystemInstanceProxy();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  SandboxPackage getSandboxPackage();

} //SandboxFactory
