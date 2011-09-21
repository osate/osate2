/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.sandbox.sandbox.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.xtext.aadl2.sandbox.sandbox.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SandboxFactoryImpl extends EFactoryImpl implements SandboxFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static SandboxFactory init()
  {
    try
    {
      SandboxFactory theSandboxFactory = (SandboxFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.osate.org/xtext/aadl2/sandbox/Sandbox"); 
      if (theSandboxFactory != null)
      {
        return theSandboxFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new SandboxFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SandboxFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case SandboxPackage.SANDBOX: return createSandbox();
      case SandboxPackage.SYSTEM_CONFIGURATION: return createSystemConfiguration();
      case SandboxPackage.SYSTEM_INSTANCE_PROXY: return createSystemInstanceProxy();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sandbox createSandbox()
  {
    SandboxImpl sandbox = new SandboxImpl();
    return sandbox;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SystemConfiguration createSystemConfiguration()
  {
    SystemConfigurationImpl systemConfiguration = new SystemConfigurationImpl();
    return systemConfiguration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SystemInstanceProxy createSystemInstanceProxy()
  {
    SystemInstanceProxyImpl systemInstanceProxy = new SystemInstanceProxyImpl();
    return systemInstanceProxy;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SandboxPackage getSandboxPackage()
  {
    return (SandboxPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static SandboxPackage getPackage()
  {
    return SandboxPackage.eINSTANCE;
  }

} //SandboxFactoryImpl
