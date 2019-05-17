/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.verify.verify.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.alisa.common.common.CommonPackage;

import org.osate.categories.categories.CategoriesPackage;

import org.osate.organization.organization.OrganizationPackage;

import org.osate.reqspec.reqSpec.ReqSpecPackage;

import org.osate.verify.verify.AgreeMethod;
import org.osate.verify.verify.AllExpr;
import org.osate.verify.verify.ArgumentExpr;
import org.osate.verify.verify.Claim;
import org.osate.verify.verify.ComputeRef;
import org.osate.verify.verify.ElseExpr;
import org.osate.verify.verify.FormalParameter;
import org.osate.verify.verify.JUnit4Method;
import org.osate.verify.verify.JavaMethod;
import org.osate.verify.verify.JavaParameter;
import org.osate.verify.verify.ManualMethod;
import org.osate.verify.verify.MethodKind;
import org.osate.verify.verify.PluginMethod;
import org.osate.verify.verify.PythonMethod;
import org.osate.verify.verify.RefExpr;
import org.osate.verify.verify.ResoluteMethod;
import org.osate.verify.verify.ThenExpr;
import org.osate.verify.verify.Verification;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationCondition;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerificationMethodRegistry;
import org.osate.verify.verify.VerificationPlan;
import org.osate.verify.verify.VerificationPrecondition;
import org.osate.verify.verify.VerificationValidation;
import org.osate.verify.verify.VerifyFactory;
import org.osate.verify.verify.VerifyPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class VerifyPackageImpl extends EPackageImpl implements VerifyPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationPlanEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass claimEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass argumentExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass computeRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationActivityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationConditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationMethodRegistryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass formalParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationMethodEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methodKindEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resoluteMethodEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass javaMethodEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pythonMethodEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass manualMethodEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pluginMethodEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass agreeMethodEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass jUnit4MethodEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass javaParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass thenExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elseExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass allExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass refExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationValidationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationPreconditionEClass = null;

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
   * @see org.osate.verify.verify.VerifyPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private VerifyPackageImpl()
  {
    super(eNS_URI, VerifyFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link VerifyPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static VerifyPackage init()
  {
    if (isInited) return (VerifyPackage)EPackage.Registry.INSTANCE.getEPackage(VerifyPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredVerifyPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    VerifyPackageImpl theVerifyPackage = registeredVerifyPackage instanceof VerifyPackageImpl ? (VerifyPackageImpl)registeredVerifyPackage : new VerifyPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();
    Aadl2Package.eINSTANCE.eClass();
    CommonPackage.eINSTANCE.eClass();
    CategoriesPackage.eINSTANCE.eClass();
    ReqSpecPackage.eINSTANCE.eClass();
    OrganizationPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theVerifyPackage.createPackageContents();

    // Initialize created meta-data
    theVerifyPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theVerifyPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(VerifyPackage.eNS_URI, theVerifyPackage);
    return theVerifyPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getVerification()
  {
    return verificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerification_Contents()
  {
    return (EReference)verificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getVerificationPlan()
  {
    return verificationPlanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationPlan_Name()
  {
    return (EAttribute)verificationPlanEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationPlan_Title()
  {
    return (EAttribute)verificationPlanEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationPlan_RequirementSet()
  {
    return (EReference)verificationPlanEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationPlan_Description()
  {
    return (EReference)verificationPlanEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationPlan_Claim()
  {
    return (EReference)verificationPlanEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationPlan_Rationale()
  {
    return (EReference)verificationPlanEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationPlan_Issues()
  {
    return (EAttribute)verificationPlanEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getClaim()
  {
    return claimEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClaim_Requirement()
  {
    return (EReference)claimEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getClaim_Title()
  {
    return (EAttribute)claimEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClaim_Activities()
  {
    return (EReference)claimEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClaim_Assert()
  {
    return (EReference)claimEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClaim_Rationale()
  {
    return (EReference)claimEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getClaim_Weight()
  {
    return (EAttribute)claimEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getClaim_Subclaim()
  {
    return (EReference)claimEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getClaim_Issues()
  {
    return (EAttribute)claimEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getArgumentExpr()
  {
    return argumentExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getComputeRef()
  {
    return computeRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getComputeRef_Compute()
  {
    return (EReference)computeRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getVerificationActivity()
  {
    return verificationActivityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationActivity_Name()
  {
    return (EAttribute)verificationActivityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationActivity_Title()
  {
    return (EAttribute)verificationActivityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationActivity_Computes()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationActivity_Method()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationActivity_Actuals()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationActivity_PropertyValues()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationActivity_Category()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationActivity_Timeout()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationActivity_Weight()
  {
    return (EAttribute)verificationActivityEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getVerificationCondition()
  {
    return verificationConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationCondition_Method()
  {
    return (EReference)verificationConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationCondition_Parameters()
  {
    return (EReference)verificationConditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getVerificationMethodRegistry()
  {
    return verificationMethodRegistryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationMethodRegistry_Name()
  {
    return (EAttribute)verificationMethodRegistryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationMethodRegistry_Title()
  {
    return (EAttribute)verificationMethodRegistryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationMethodRegistry_Description()
  {
    return (EReference)verificationMethodRegistryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationMethodRegistry_Methods()
  {
    return (EReference)verificationMethodRegistryEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getFormalParameter()
  {
    return formalParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getFormalParameter_Name()
  {
    return (EAttribute)formalParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFormalParameter_Type()
  {
    return (EReference)formalParameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getFormalParameter_Unit()
  {
    return (EReference)formalParameterEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getVerificationMethod()
  {
    return verificationMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationMethod_Name()
  {
    return (EAttribute)verificationMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationMethod_TargetType()
  {
    return (EAttribute)verificationMethodEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationMethod_Formals()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationMethod_Properties()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationMethod_Results()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationMethod_IsPredicate()
  {
    return (EAttribute)verificationMethodEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationMethod_IsResultReport()
  {
    return (EAttribute)verificationMethodEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationMethod_Title()
  {
    return (EAttribute)verificationMethodEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationMethod_Target()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getVerificationMethod_ComponentCategory()
  {
    return (EAttribute)verificationMethodEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationMethod_MethodKind()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationMethod_Description()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationMethod_Precondition()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationMethod_Validation()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getVerificationMethod_Category()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getMethodKind()
  {
    return methodKindEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getResoluteMethod()
  {
    return resoluteMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getResoluteMethod_MethodReference()
  {
    return (EReference)resoluteMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getJavaMethod()
  {
    return javaMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getJavaMethod_MethodPath()
  {
    return (EAttribute)javaMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getJavaMethod_Params()
  {
    return (EReference)javaMethodEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPythonMethod()
  {
    return pythonMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getPythonMethod_MethodPath()
  {
    return (EAttribute)pythonMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getManualMethod()
  {
    return manualMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getManualMethod_DialogID()
  {
    return (EAttribute)manualMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getPluginMethod()
  {
    return pluginMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getPluginMethod_MethodID()
  {
    return (EAttribute)pluginMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAgreeMethod()
  {
    return agreeMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAgreeMethod_SingleLayer()
  {
    return (EAttribute)agreeMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getAgreeMethod_All()
  {
    return (EAttribute)agreeMethodEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getJUnit4Method()
  {
    return jUnit4MethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getJUnit4Method_ClassPath()
  {
    return (EAttribute)jUnit4MethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getJavaParameter()
  {
    return javaParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getJavaParameter_ParameterType()
  {
    return (EAttribute)javaParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getJavaParameter_Name()
  {
    return (EAttribute)javaParameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getThenExpr()
  {
    return thenExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getThenExpr_Left()
  {
    return (EReference)thenExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getThenExpr_Successor()
  {
    return (EReference)thenExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getElseExpr()
  {
    return elseExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getElseExpr_Left()
  {
    return (EReference)elseExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getElseExpr_Error()
  {
    return (EReference)elseExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getElseExpr_Fail()
  {
    return (EReference)elseExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getElseExpr_Timeout()
  {
    return (EReference)elseExprEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getAllExpr()
  {
    return allExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getAllExpr_Elements()
  {
    return (EReference)allExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getRefExpr()
  {
    return refExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRefExpr_Verification()
  {
    return (EReference)refExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getVerificationValidation()
  {
    return verificationValidationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getVerificationPrecondition()
  {
    return verificationPreconditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VerifyFactory getVerifyFactory()
  {
    return (VerifyFactory)getEFactoryInstance();
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
    verificationEClass = createEClass(VERIFICATION);
    createEReference(verificationEClass, VERIFICATION__CONTENTS);

    verificationPlanEClass = createEClass(VERIFICATION_PLAN);
    createEAttribute(verificationPlanEClass, VERIFICATION_PLAN__NAME);
    createEAttribute(verificationPlanEClass, VERIFICATION_PLAN__TITLE);
    createEReference(verificationPlanEClass, VERIFICATION_PLAN__REQUIREMENT_SET);
    createEReference(verificationPlanEClass, VERIFICATION_PLAN__DESCRIPTION);
    createEReference(verificationPlanEClass, VERIFICATION_PLAN__CLAIM);
    createEReference(verificationPlanEClass, VERIFICATION_PLAN__RATIONALE);
    createEAttribute(verificationPlanEClass, VERIFICATION_PLAN__ISSUES);

    claimEClass = createEClass(CLAIM);
    createEReference(claimEClass, CLAIM__REQUIREMENT);
    createEAttribute(claimEClass, CLAIM__TITLE);
    createEReference(claimEClass, CLAIM__ACTIVITIES);
    createEReference(claimEClass, CLAIM__ASSERT);
    createEReference(claimEClass, CLAIM__RATIONALE);
    createEAttribute(claimEClass, CLAIM__WEIGHT);
    createEReference(claimEClass, CLAIM__SUBCLAIM);
    createEAttribute(claimEClass, CLAIM__ISSUES);

    argumentExprEClass = createEClass(ARGUMENT_EXPR);

    computeRefEClass = createEClass(COMPUTE_REF);
    createEReference(computeRefEClass, COMPUTE_REF__COMPUTE);

    verificationActivityEClass = createEClass(VERIFICATION_ACTIVITY);
    createEAttribute(verificationActivityEClass, VERIFICATION_ACTIVITY__NAME);
    createEAttribute(verificationActivityEClass, VERIFICATION_ACTIVITY__TITLE);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__COMPUTES);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__METHOD);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__ACTUALS);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__PROPERTY_VALUES);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__CATEGORY);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__TIMEOUT);
    createEAttribute(verificationActivityEClass, VERIFICATION_ACTIVITY__WEIGHT);

    verificationConditionEClass = createEClass(VERIFICATION_CONDITION);
    createEReference(verificationConditionEClass, VERIFICATION_CONDITION__METHOD);
    createEReference(verificationConditionEClass, VERIFICATION_CONDITION__PARAMETERS);

    verificationMethodRegistryEClass = createEClass(VERIFICATION_METHOD_REGISTRY);
    createEAttribute(verificationMethodRegistryEClass, VERIFICATION_METHOD_REGISTRY__NAME);
    createEAttribute(verificationMethodRegistryEClass, VERIFICATION_METHOD_REGISTRY__TITLE);
    createEReference(verificationMethodRegistryEClass, VERIFICATION_METHOD_REGISTRY__DESCRIPTION);
    createEReference(verificationMethodRegistryEClass, VERIFICATION_METHOD_REGISTRY__METHODS);

    formalParameterEClass = createEClass(FORMAL_PARAMETER);
    createEAttribute(formalParameterEClass, FORMAL_PARAMETER__NAME);
    createEReference(formalParameterEClass, FORMAL_PARAMETER__TYPE);
    createEReference(formalParameterEClass, FORMAL_PARAMETER__UNIT);

    verificationMethodEClass = createEClass(VERIFICATION_METHOD);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__NAME);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__TARGET_TYPE);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__FORMALS);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__PROPERTIES);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__RESULTS);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__IS_PREDICATE);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__IS_RESULT_REPORT);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__TITLE);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__TARGET);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__COMPONENT_CATEGORY);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__METHOD_KIND);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__DESCRIPTION);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__PRECONDITION);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__VALIDATION);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__CATEGORY);

    methodKindEClass = createEClass(METHOD_KIND);

    resoluteMethodEClass = createEClass(RESOLUTE_METHOD);
    createEReference(resoluteMethodEClass, RESOLUTE_METHOD__METHOD_REFERENCE);

    javaMethodEClass = createEClass(JAVA_METHOD);
    createEAttribute(javaMethodEClass, JAVA_METHOD__METHOD_PATH);
    createEReference(javaMethodEClass, JAVA_METHOD__PARAMS);

    pythonMethodEClass = createEClass(PYTHON_METHOD);
    createEAttribute(pythonMethodEClass, PYTHON_METHOD__METHOD_PATH);

    manualMethodEClass = createEClass(MANUAL_METHOD);
    createEAttribute(manualMethodEClass, MANUAL_METHOD__DIALOG_ID);

    pluginMethodEClass = createEClass(PLUGIN_METHOD);
    createEAttribute(pluginMethodEClass, PLUGIN_METHOD__METHOD_ID);

    agreeMethodEClass = createEClass(AGREE_METHOD);
    createEAttribute(agreeMethodEClass, AGREE_METHOD__SINGLE_LAYER);
    createEAttribute(agreeMethodEClass, AGREE_METHOD__ALL);

    jUnit4MethodEClass = createEClass(JUNIT4_METHOD);
    createEAttribute(jUnit4MethodEClass, JUNIT4_METHOD__CLASS_PATH);

    javaParameterEClass = createEClass(JAVA_PARAMETER);
    createEAttribute(javaParameterEClass, JAVA_PARAMETER__PARAMETER_TYPE);
    createEAttribute(javaParameterEClass, JAVA_PARAMETER__NAME);

    thenExprEClass = createEClass(THEN_EXPR);
    createEReference(thenExprEClass, THEN_EXPR__LEFT);
    createEReference(thenExprEClass, THEN_EXPR__SUCCESSOR);

    elseExprEClass = createEClass(ELSE_EXPR);
    createEReference(elseExprEClass, ELSE_EXPR__LEFT);
    createEReference(elseExprEClass, ELSE_EXPR__ERROR);
    createEReference(elseExprEClass, ELSE_EXPR__FAIL);
    createEReference(elseExprEClass, ELSE_EXPR__TIMEOUT);

    allExprEClass = createEClass(ALL_EXPR);
    createEReference(allExprEClass, ALL_EXPR__ELEMENTS);

    refExprEClass = createEClass(REF_EXPR);
    createEReference(refExprEClass, REF_EXPR__VERIFICATION);

    verificationValidationEClass = createEClass(VERIFICATION_VALIDATION);

    verificationPreconditionEClass = createEClass(VERIFICATION_PRECONDITION);
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

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
    ReqSpecPackage theReqSpecPackage = (ReqSpecPackage)EPackage.Registry.INSTANCE.getEPackage(ReqSpecPackage.eNS_URI);
    CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);
    CategoriesPackage theCategoriesPackage = (CategoriesPackage)EPackage.Registry.INSTANCE.getEPackage(CategoriesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    resoluteMethodEClass.getESuperTypes().add(this.getMethodKind());
    javaMethodEClass.getESuperTypes().add(this.getMethodKind());
    pythonMethodEClass.getESuperTypes().add(this.getMethodKind());
    manualMethodEClass.getESuperTypes().add(this.getMethodKind());
    pluginMethodEClass.getESuperTypes().add(this.getMethodKind());
    agreeMethodEClass.getESuperTypes().add(this.getMethodKind());
    jUnit4MethodEClass.getESuperTypes().add(this.getMethodKind());
    thenExprEClass.getESuperTypes().add(this.getArgumentExpr());
    elseExprEClass.getESuperTypes().add(this.getArgumentExpr());
    allExprEClass.getESuperTypes().add(this.getArgumentExpr());
    refExprEClass.getESuperTypes().add(this.getArgumentExpr());
    verificationValidationEClass.getESuperTypes().add(this.getVerificationCondition());
    verificationPreconditionEClass.getESuperTypes().add(this.getVerificationCondition());

    // Initialize classes and features; add operations and parameters
    initEClass(verificationEClass, Verification.class, "Verification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVerification_Contents(), theEcorePackage.getEObject(), null, "contents", null, 0, -1, Verification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationPlanEClass, VerificationPlan.class, "VerificationPlan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationPlan_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationPlan_Title(), theEcorePackage.getEString(), "title", null, 0, 1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationPlan_RequirementSet(), theReqSpecPackage.getRequirementSet(), null, "requirementSet", null, 0, 1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationPlan_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationPlan_Claim(), this.getClaim(), null, "claim", null, 0, -1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationPlan_Rationale(), theCommonPackage.getRationale(), null, "rationale", null, 0, 1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationPlan_Issues(), theEcorePackage.getEString(), "issues", null, 0, -1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(claimEClass, Claim.class, "Claim", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClaim_Requirement(), theReqSpecPackage.getRequirement(), null, "requirement", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClaim_Title(), theEcorePackage.getEString(), "title", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaim_Activities(), this.getVerificationActivity(), null, "activities", null, 0, -1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaim_Assert(), this.getArgumentExpr(), null, "assert", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaim_Rationale(), theCommonPackage.getRationale(), null, "rationale", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClaim_Weight(), theEcorePackage.getEInt(), "weight", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaim_Subclaim(), this.getClaim(), null, "subclaim", null, 0, -1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClaim_Issues(), theEcorePackage.getEString(), "issues", null, 0, -1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(argumentExprEClass, ArgumentExpr.class, "ArgumentExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(computeRefEClass, ComputeRef.class, "ComputeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getComputeRef_Compute(), theCommonPackage.getComputeDeclaration(), null, "compute", null, 0, 1, ComputeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationActivityEClass, VerificationActivity.class, "VerificationActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationActivity_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationActivity_Title(), theEcorePackage.getEString(), "title", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_Computes(), this.getComputeRef(), null, "computes", null, 0, -1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_Method(), this.getVerificationMethod(), null, "method", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_Actuals(), theAadl2Package.getPropertyExpression(), null, "actuals", null, 0, -1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_PropertyValues(), theAadl2Package.getPropertyExpression(), null, "propertyValues", null, 0, -1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_Category(), theCategoriesPackage.getCategory(), null, "category", null, 0, -1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_Timeout(), theAadl2Package.getIntegerLiteral(), null, "timeout", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationActivity_Weight(), theEcorePackage.getEInt(), "weight", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationConditionEClass, VerificationCondition.class, "VerificationCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVerificationCondition_Method(), this.getVerificationMethod(), null, "method", null, 0, 1, VerificationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationCondition_Parameters(), this.getFormalParameter(), null, "parameters", null, 0, -1, VerificationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationMethodRegistryEClass, VerificationMethodRegistry.class, "VerificationMethodRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationMethodRegistry_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VerificationMethodRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationMethodRegistry_Title(), theEcorePackage.getEString(), "title", null, 0, 1, VerificationMethodRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethodRegistry_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, VerificationMethodRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethodRegistry_Methods(), this.getVerificationMethod(), null, "methods", null, 0, -1, VerificationMethodRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(formalParameterEClass, FormalParameter.class, "FormalParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFormalParameter_Name(), theEcorePackage.getEString(), "name", null, 0, 1, FormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFormalParameter_Type(), theAadl2Package.getPropertyType(), null, "type", null, 0, 1, FormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFormalParameter_Unit(), theAadl2Package.getUnitLiteral(), null, "unit", null, 0, 1, FormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationMethodEClass, VerificationMethod.class, "VerificationMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationMethod_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationMethod_TargetType(), theCommonPackage.getTargetType(), "targetType", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Formals(), this.getFormalParameter(), null, "formals", null, 0, -1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Properties(), theAadl2Package.getProperty(), null, "properties", null, 0, -1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Results(), this.getFormalParameter(), null, "results", null, 0, -1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationMethod_IsPredicate(), theEcorePackage.getEBoolean(), "isPredicate", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationMethod_IsResultReport(), theEcorePackage.getEBoolean(), "isResultReport", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationMethod_Title(), theEcorePackage.getEString(), "title", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Target(), theAadl2Package.getComponentClassifier(), null, "target", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationMethod_ComponentCategory(), theAadl2Package.getComponentCategory(), "componentCategory", null, 0, -1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_MethodKind(), this.getMethodKind(), null, "methodKind", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Precondition(), this.getVerificationCondition(), null, "precondition", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Validation(), this.getVerificationCondition(), null, "validation", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Category(), theCategoriesPackage.getCategory(), null, "category", null, 0, -1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(methodKindEClass, MethodKind.class, "MethodKind", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(resoluteMethodEClass, ResoluteMethod.class, "ResoluteMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResoluteMethod_MethodReference(), theEcorePackage.getEObject(), null, "methodReference", null, 0, 1, ResoluteMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(javaMethodEClass, JavaMethod.class, "JavaMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJavaMethod_MethodPath(), theEcorePackage.getEString(), "methodPath", null, 0, 1, JavaMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJavaMethod_Params(), this.getJavaParameter(), null, "params", null, 0, -1, JavaMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pythonMethodEClass, PythonMethod.class, "PythonMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPythonMethod_MethodPath(), theEcorePackage.getEString(), "methodPath", null, 0, 1, PythonMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(manualMethodEClass, ManualMethod.class, "ManualMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getManualMethod_DialogID(), theEcorePackage.getEString(), "dialogID", null, 0, 1, ManualMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pluginMethodEClass, PluginMethod.class, "PluginMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPluginMethod_MethodID(), theEcorePackage.getEString(), "methodID", null, 0, 1, PluginMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(agreeMethodEClass, AgreeMethod.class, "AgreeMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAgreeMethod_SingleLayer(), theEcorePackage.getEBoolean(), "singleLayer", null, 0, 1, AgreeMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAgreeMethod_All(), theEcorePackage.getEBoolean(), "all", null, 0, 1, AgreeMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(jUnit4MethodEClass, JUnit4Method.class, "JUnit4Method", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJUnit4Method_ClassPath(), theEcorePackage.getEString(), "classPath", null, 0, 1, JUnit4Method.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(javaParameterEClass, JavaParameter.class, "JavaParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJavaParameter_ParameterType(), theEcorePackage.getEString(), "parameterType", null, 0, 1, JavaParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getJavaParameter_Name(), theEcorePackage.getEString(), "name", null, 0, 1, JavaParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(thenExprEClass, ThenExpr.class, "ThenExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getThenExpr_Left(), this.getArgumentExpr(), null, "left", null, 0, 1, ThenExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getThenExpr_Successor(), this.getArgumentExpr(), null, "successor", null, 0, 1, ThenExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elseExprEClass, ElseExpr.class, "ElseExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getElseExpr_Left(), this.getArgumentExpr(), null, "left", null, 0, 1, ElseExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getElseExpr_Error(), this.getArgumentExpr(), null, "error", null, 0, 1, ElseExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getElseExpr_Fail(), this.getArgumentExpr(), null, "fail", null, 0, 1, ElseExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getElseExpr_Timeout(), this.getArgumentExpr(), null, "timeout", null, 0, 1, ElseExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(allExprEClass, AllExpr.class, "AllExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAllExpr_Elements(), this.getArgumentExpr(), null, "elements", null, 0, -1, AllExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(refExprEClass, RefExpr.class, "RefExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRefExpr_Verification(), this.getVerificationActivity(), null, "verification", null, 0, 1, RefExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationValidationEClass, VerificationValidation.class, "VerificationValidation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(verificationPreconditionEClass, VerificationPrecondition.class, "VerificationPrecondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //VerifyPackageImpl
