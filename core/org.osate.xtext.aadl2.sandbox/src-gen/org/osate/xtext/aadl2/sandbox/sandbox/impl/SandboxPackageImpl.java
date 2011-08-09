/**
 * <copyright>
 * </copyright>
 *

 */
package org.osate.xtext.aadl2.sandbox.sandbox.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.xtext.aadl2.sandbox.sandbox.Sandbox;
import org.osate.xtext.aadl2.sandbox.sandbox.SandboxFactory;
import org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage;
import org.osate.xtext.aadl2.sandbox.sandbox.SystemConfiguration;
import org.osate.xtext.aadl2.sandbox.sandbox.SystemInstanceProxy;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SandboxPackageImpl extends EPackageImpl implements SandboxPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sandboxEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass systemConfigurationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass systemInstanceProxyEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see org.osate.xtext.aadl2.sandbox.sandbox.SandboxPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private SandboxPackageImpl()
  {
    super(eNS_URI, SandboxFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link SandboxPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static SandboxPackage init()
  {
    if (isInited) return (SandboxPackage)EPackage.Registry.INSTANCE.getEPackage(SandboxPackage.eNS_URI);

    // Obtain or create and register package
    SandboxPackageImpl theSandboxPackage = (SandboxPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SandboxPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SandboxPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theSandboxPackage.createPackageContents();

    // Initialize created meta-data
    theSandboxPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSandboxPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(SandboxPackage.eNS_URI, theSandboxPackage);
    return theSandboxPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSandbox()
  {
    return sandboxEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSandbox_Name()
  {
    return (EAttribute)sandboxEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSandbox_SystemInstance()
  {
    return (EReference)sandboxEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSystemConfiguration()
  {
    return systemConfigurationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSystemConfiguration_Name()
  {
    return (EAttribute)systemConfigurationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSystemConfiguration_SystemImplementation()
  {
    return (EReference)systemConfigurationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSystemConfiguration_SystemInstanceProxy()
  {
    return (EReference)systemConfigurationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSystemInstanceProxy()
  {
    return systemInstanceProxyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSystemInstanceProxy_InstanceRef()
  {
    return (EReference)systemInstanceProxyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SandboxFactory getSandboxFactory()
  {
    return (SandboxFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    sandboxEClass = createEClass(SANDBOX);
    createEAttribute(sandboxEClass, SANDBOX__NAME);
    createEReference(sandboxEClass, SANDBOX__SYSTEM_INSTANCE);

    systemConfigurationEClass = createEClass(SYSTEM_CONFIGURATION);
    createEAttribute(systemConfigurationEClass, SYSTEM_CONFIGURATION__NAME);
    createEReference(systemConfigurationEClass, SYSTEM_CONFIGURATION__SYSTEM_IMPLEMENTATION);
    createEReference(systemConfigurationEClass, SYSTEM_CONFIGURATION__SYSTEM_INSTANCE_PROXY);

    systemInstanceProxyEClass = createEClass(SYSTEM_INSTANCE_PROXY);
    createEReference(systemInstanceProxyEClass, SYSTEM_INSTANCE_PROXY__INSTANCE_REF);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(sandboxEClass, Sandbox.class, "Sandbox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSandbox_Name(), ecorePackage.getEString(), "name", null, 0, 1, Sandbox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSandbox_SystemInstance(), this.getSystemConfiguration(), null, "systemInstance", null, 0, -1, Sandbox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(systemConfigurationEClass, SystemConfiguration.class, "SystemConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSystemConfiguration_Name(), ecorePackage.getEString(), "name", null, 0, 1, SystemConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSystemConfiguration_SystemImplementation(), ecorePackage.getEObject(), null, "systemImplementation", null, 0, 1, SystemConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSystemConfiguration_SystemInstanceProxy(), this.getSystemInstanceProxy(), null, "systemInstanceProxy", null, 0, 1, SystemConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(systemInstanceProxyEClass, SystemInstanceProxy.class, "SystemInstanceProxy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSystemInstanceProxy_InstanceRef(), ecorePackage.getEObject(), null, "instanceRef", null, 0, 1, SystemInstanceProxy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //SandboxPackageImpl
