/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.sandbox.sandbox;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.xtext.aadl2.sandbox.sandbox.SandboxFactory
 * @model kind="package"
 * @generated
 */
public interface SandboxPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "sandbox";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/xtext/aadl2/sandbox/Sandbox";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "sandbox";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  SandboxPackage eINSTANCE = org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxPackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxImpl <em>Sandbox</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxImpl
   * @see org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxPackageImpl#getSandbox()
   * @generated
   */
  int SANDBOX = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SANDBOX__NAME = 0;

  /**
   * The feature id for the '<em><b>System Instance</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SANDBOX__SYSTEM_INSTANCE = 1;

  /**
   * The number of structural features of the '<em>Sandbox</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SANDBOX_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.sandbox.sandbox.impl.SystemConfigurationImpl <em>System Configuration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.sandbox.sandbox.impl.SystemConfigurationImpl
   * @see org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxPackageImpl#getSystemConfiguration()
   * @generated
   */
  int SYSTEM_CONFIGURATION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_CONFIGURATION__NAME = 0;

  /**
   * The feature id for the '<em><b>System Implementation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_CONFIGURATION__SYSTEM_IMPLEMENTATION = 1;

  /**
   * The feature id for the '<em><b>System Instance Proxy</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_CONFIGURATION__SYSTEM_INSTANCE_PROXY = 2;

  /**
   * The number of structural features of the '<em>System Configuration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_CONFIGURATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.xtext.aadl2.sandbox.sandbox.impl.SystemInstanceProxyImpl <em>System Instance Proxy</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.xtext.aadl2.sandbox.sandbox.impl.SystemInstanceProxyImpl
   * @see org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxPackageImpl#getSystemInstanceProxy()
   * @generated
   */
  int SYSTEM_INSTANCE_PROXY = 2;

  /**
   * The feature id for the '<em><b>Instance Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_INSTANCE_PROXY__INSTANCE_REF = 0;

  /**
   * The number of structural features of the '<em>System Instance Proxy</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_INSTANCE_PROXY_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.sandbox.sandbox.Sandbox <em>Sandbox</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sandbox</em>'.
   * @see org.osate.xtext.aadl2.sandbox.sandbox.Sandbox
   * @generated
   */
  EClass getSandbox();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.sandbox.sandbox.Sandbox#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.sandbox.sandbox.Sandbox#getName()
   * @see #getSandbox()
   * @generated
   */
  EAttribute getSandbox_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.xtext.aadl2.sandbox.sandbox.Sandbox#getSystemInstance <em>System Instance</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>System Instance</em>'.
   * @see org.osate.xtext.aadl2.sandbox.sandbox.Sandbox#getSystemInstance()
   * @see #getSandbox()
   * @generated
   */
  EReference getSandbox_SystemInstance();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration <em>System Configuration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>System Configuration</em>'.
   * @see org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration
   * @generated
   */
  EClass getSystemConfiguration();

  /**
   * Returns the meta object for the attribute '{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration#getName()
   * @see #getSystemConfiguration()
   * @generated
   */
  EAttribute getSystemConfiguration_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration#getSystemImplementation <em>System Implementation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>System Implementation</em>'.
   * @see org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration#getSystemImplementation()
   * @see #getSystemConfiguration()
   * @generated
   */
  EReference getSystemConfiguration_SystemImplementation();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration#getSystemInstanceProxy <em>System Instance Proxy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>System Instance Proxy</em>'.
   * @see org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration#getSystemInstanceProxy()
   * @see #getSystemConfiguration()
   * @generated
   */
  EReference getSystemConfiguration_SystemInstanceProxy();

  /**
   * Returns the meta object for class '{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemInstanceProxy <em>System Instance Proxy</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>System Instance Proxy</em>'.
   * @see org.osate.xtext.aadl2.sandbox.sandbox.SystemInstanceProxy
   * @generated
   */
  EClass getSystemInstanceProxy();

  /**
   * Returns the meta object for the reference '{@link org.osate.xtext.aadl2.sandbox.sandbox.SystemInstanceProxy#getInstanceRef <em>Instance Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Instance Ref</em>'.
   * @see org.osate.xtext.aadl2.sandbox.sandbox.SystemInstanceProxy#getInstanceRef()
   * @see #getSystemInstanceProxy()
   * @generated
   */
  EReference getSystemInstanceProxy_InstanceRef();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  SandboxFactory getSandboxFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxImpl <em>Sandbox</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxImpl
     * @see org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxPackageImpl#getSandbox()
     * @generated
     */
    EClass SANDBOX = eINSTANCE.getSandbox();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SANDBOX__NAME = eINSTANCE.getSandbox_Name();

    /**
     * The meta object literal for the '<em><b>System Instance</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SANDBOX__SYSTEM_INSTANCE = eINSTANCE.getSandbox_SystemInstance();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.sandbox.sandbox.impl.SystemConfigurationImpl <em>System Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.sandbox.sandbox.impl.SystemConfigurationImpl
     * @see org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxPackageImpl#getSystemConfiguration()
     * @generated
     */
    EClass SYSTEM_CONFIGURATION = eINSTANCE.getSystemConfiguration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SYSTEM_CONFIGURATION__NAME = eINSTANCE.getSystemConfiguration_Name();

    /**
     * The meta object literal for the '<em><b>System Implementation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SYSTEM_CONFIGURATION__SYSTEM_IMPLEMENTATION = eINSTANCE.getSystemConfiguration_SystemImplementation();

    /**
     * The meta object literal for the '<em><b>System Instance Proxy</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SYSTEM_CONFIGURATION__SYSTEM_INSTANCE_PROXY = eINSTANCE.getSystemConfiguration_SystemInstanceProxy();

    /**
     * The meta object literal for the '{@link org.osate.xtext.aadl2.sandbox.sandbox.impl.SystemInstanceProxyImpl <em>System Instance Proxy</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.xtext.aadl2.sandbox.sandbox.impl.SystemInstanceProxyImpl
     * @see org.osate.xtext.aadl2.sandbox.sandbox.impl.SandboxPackageImpl#getSystemInstanceProxy()
     * @generated
     */
    EClass SYSTEM_INSTANCE_PROXY = eINSTANCE.getSystemInstanceProxy();

    /**
     * The meta object literal for the '<em><b>Instance Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SYSTEM_INSTANCE_PROXY__INSTANCE_REF = eINSTANCE.getSystemInstanceProxy_InstanceRef();

  }

} //SandboxPackage
