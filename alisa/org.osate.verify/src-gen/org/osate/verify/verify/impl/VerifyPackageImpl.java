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

import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.alisa.common.common.CommonPackage;

import org.osate.categories.categories.CategoriesPackage;

import org.osate.reqspec.reqSpec.ReqSpecPackage;

import org.osate.verify.verify.AllExpr;
import org.osate.verify.verify.ArgumentExpr;
import org.osate.verify.verify.Claim;
import org.osate.verify.verify.ElseExpr;
import org.osate.verify.verify.FormalParameter;
import org.osate.verify.verify.JavaMethod;
import org.osate.verify.verify.ManualMethod;
import org.osate.verify.verify.MethodKind;
import org.osate.verify.verify.PluginMethod;
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
    VerifyPackageImpl theVerifyPackage = (VerifyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof VerifyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new VerifyPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    ResolutePackage.eINSTANCE.eClass();
    ReqSpecPackage.eINSTANCE.eClass();

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
  public EClass getVerification()
  {
    return verificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerification_Contents()
  {
    return (EReference)verificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationPlan()
  {
    return verificationPlanEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationPlan_Name()
  {
    return (EAttribute)verificationPlanEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationPlan_Title()
  {
    return (EAttribute)verificationPlanEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationPlan_Requirements()
  {
    return (EReference)verificationPlanEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationPlan_Description()
  {
    return (EReference)verificationPlanEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationPlan_Claim()
  {
    return (EReference)verificationPlanEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationPlan_Rationale()
  {
    return (EReference)verificationPlanEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationPlan_Issues()
  {
    return (EAttribute)verificationPlanEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClaim()
  {
    return claimEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaim_Requirement()
  {
    return (EReference)claimEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClaim_Title()
  {
    return (EAttribute)claimEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClaim_Weight()
  {
    return (EAttribute)claimEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaim_Activities()
  {
    return (EReference)claimEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaim_Assert()
  {
    return (EReference)claimEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaim_Rationale()
  {
    return (EReference)claimEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaim_Subclaim()
  {
    return (EReference)claimEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClaim_Issues()
  {
    return (EAttribute)claimEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArgumentExpr()
  {
    return argumentExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationActivity()
  {
    return verificationActivityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationActivity_Name()
  {
    return (EAttribute)verificationActivityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationActivity_Title()
  {
    return (EAttribute)verificationActivityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivity_DevelopmentPhase()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivity_UserSelection()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivity_Result()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivity_Method()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivity_Parameters()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivity_PropertyValues()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationActivity_Timeout()
  {
    return (EAttribute)verificationActivityEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationCondition()
  {
    return verificationConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationCondition_Method()
  {
    return (EReference)verificationConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationCondition_Parameters()
  {
    return (EReference)verificationConditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationMethodRegistry()
  {
    return verificationMethodRegistryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationMethodRegistry_Name()
  {
    return (EAttribute)verificationMethodRegistryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationMethodRegistry_Title()
  {
    return (EAttribute)verificationMethodRegistryEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethodRegistry_Description()
  {
    return (EReference)verificationMethodRegistryEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethodRegistry_Methods()
  {
    return (EReference)verificationMethodRegistryEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFormalParameter()
  {
    return formalParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFormalParameter_ParameterType()
  {
    return (EAttribute)formalParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFormalParameter_Name()
  {
    return (EAttribute)formalParameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFormalParameter_Unit()
  {
    return (EReference)formalParameterEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationMethod()
  {
    return verificationMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationMethod_Name()
  {
    return (EAttribute)verificationMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethod_Params()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethod_Properties()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationMethod_IsPredicate()
  {
    return (EAttribute)verificationMethodEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationMethod_IsResultReport()
  {
    return (EAttribute)verificationMethodEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationMethod_Title()
  {
    return (EAttribute)verificationMethodEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethod_MethodKind()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethod_Description()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethod_Precondition()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethod_Validation()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethod_MethodType()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethod_QualityAttribute()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethod_UserSelection()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMethodKind()
  {
    return methodKindEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResoluteMethod()
  {
    return resoluteMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResoluteMethod_MethodReference()
  {
    return (EReference)resoluteMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJavaMethod()
  {
    return javaMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getJavaMethod_MethodPath()
  {
    return (EAttribute)javaMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getManualMethod()
  {
    return manualMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getManualMethod_DialogID()
  {
    return (EAttribute)manualMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPluginMethod()
  {
    return pluginMethodEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPluginMethod_MethodID()
  {
    return (EAttribute)pluginMethodEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getThenExpr()
  {
    return thenExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThenExpr_Left()
  {
    return (EReference)thenExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getThenExpr_Successor()
  {
    return (EReference)thenExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElseExpr()
  {
    return elseExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElseExpr_Left()
  {
    return (EReference)elseExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElseExpr_Error()
  {
    return (EReference)elseExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElseExpr_Fail()
  {
    return (EReference)elseExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElseExpr_Timeout()
  {
    return (EReference)elseExprEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAllExpr()
  {
    return allExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAllExpr_Elements()
  {
    return (EReference)allExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRefExpr()
  {
    return refExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRefExpr_Verification()
  {
    return (EReference)refExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRefExpr_Weight()
  {
    return (EAttribute)refExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationValidation()
  {
    return verificationValidationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationPrecondition()
  {
    return verificationPreconditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
    createEReference(verificationPlanEClass, VERIFICATION_PLAN__REQUIREMENTS);
    createEReference(verificationPlanEClass, VERIFICATION_PLAN__DESCRIPTION);
    createEReference(verificationPlanEClass, VERIFICATION_PLAN__CLAIM);
    createEReference(verificationPlanEClass, VERIFICATION_PLAN__RATIONALE);
    createEAttribute(verificationPlanEClass, VERIFICATION_PLAN__ISSUES);

    claimEClass = createEClass(CLAIM);
    createEReference(claimEClass, CLAIM__REQUIREMENT);
    createEAttribute(claimEClass, CLAIM__TITLE);
    createEAttribute(claimEClass, CLAIM__WEIGHT);
    createEReference(claimEClass, CLAIM__ACTIVITIES);
    createEReference(claimEClass, CLAIM__ASSERT);
    createEReference(claimEClass, CLAIM__RATIONALE);
    createEReference(claimEClass, CLAIM__SUBCLAIM);
    createEAttribute(claimEClass, CLAIM__ISSUES);

    argumentExprEClass = createEClass(ARGUMENT_EXPR);

    verificationActivityEClass = createEClass(VERIFICATION_ACTIVITY);
    createEAttribute(verificationActivityEClass, VERIFICATION_ACTIVITY__NAME);
    createEAttribute(verificationActivityEClass, VERIFICATION_ACTIVITY__TITLE);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__DEVELOPMENT_PHASE);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__USER_SELECTION);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__RESULT);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__METHOD);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__PARAMETERS);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__PROPERTY_VALUES);
    createEAttribute(verificationActivityEClass, VERIFICATION_ACTIVITY__TIMEOUT);

    verificationConditionEClass = createEClass(VERIFICATION_CONDITION);
    createEReference(verificationConditionEClass, VERIFICATION_CONDITION__METHOD);
    createEReference(verificationConditionEClass, VERIFICATION_CONDITION__PARAMETERS);

    verificationMethodRegistryEClass = createEClass(VERIFICATION_METHOD_REGISTRY);
    createEAttribute(verificationMethodRegistryEClass, VERIFICATION_METHOD_REGISTRY__NAME);
    createEAttribute(verificationMethodRegistryEClass, VERIFICATION_METHOD_REGISTRY__TITLE);
    createEReference(verificationMethodRegistryEClass, VERIFICATION_METHOD_REGISTRY__DESCRIPTION);
    createEReference(verificationMethodRegistryEClass, VERIFICATION_METHOD_REGISTRY__METHODS);

    formalParameterEClass = createEClass(FORMAL_PARAMETER);
    createEAttribute(formalParameterEClass, FORMAL_PARAMETER__PARAMETER_TYPE);
    createEAttribute(formalParameterEClass, FORMAL_PARAMETER__NAME);
    createEReference(formalParameterEClass, FORMAL_PARAMETER__UNIT);

    verificationMethodEClass = createEClass(VERIFICATION_METHOD);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__NAME);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__PARAMS);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__PROPERTIES);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__IS_PREDICATE);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__IS_RESULT_REPORT);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__TITLE);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__METHOD_KIND);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__DESCRIPTION);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__PRECONDITION);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__VALIDATION);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__METHOD_TYPE);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__QUALITY_ATTRIBUTE);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__USER_SELECTION);

    methodKindEClass = createEClass(METHOD_KIND);

    resoluteMethodEClass = createEClass(RESOLUTE_METHOD);
    createEReference(resoluteMethodEClass, RESOLUTE_METHOD__METHOD_REFERENCE);

    javaMethodEClass = createEClass(JAVA_METHOD);
    createEAttribute(javaMethodEClass, JAVA_METHOD__METHOD_PATH);

    manualMethodEClass = createEClass(MANUAL_METHOD);
    createEAttribute(manualMethodEClass, MANUAL_METHOD__DIALOG_ID);

    pluginMethodEClass = createEClass(PLUGIN_METHOD);
    createEAttribute(pluginMethodEClass, PLUGIN_METHOD__METHOD_ID);

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
    createEAttribute(refExprEClass, REF_EXPR__WEIGHT);

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
    CategoriesPackage theCategoriesPackage = (CategoriesPackage)EPackage.Registry.INSTANCE.getEPackage(CategoriesPackage.eNS_URI);
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);
    ResolutePackage theResolutePackage = (ResolutePackage)EPackage.Registry.INSTANCE.getEPackage(ResolutePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    resoluteMethodEClass.getESuperTypes().add(this.getMethodKind());
    javaMethodEClass.getESuperTypes().add(this.getMethodKind());
    manualMethodEClass.getESuperTypes().add(this.getMethodKind());
    pluginMethodEClass.getESuperTypes().add(this.getMethodKind());
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
    initEReference(getVerificationPlan_Requirements(), theReqSpecPackage.getSystemRequirements(), null, "requirements", null, 0, 1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationPlan_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationPlan_Claim(), this.getClaim(), null, "claim", null, 0, -1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationPlan_Rationale(), theCommonPackage.getRationale(), null, "rationale", null, 0, 1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationPlan_Issues(), theEcorePackage.getEString(), "issues", null, 0, -1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(claimEClass, Claim.class, "Claim", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getClaim_Requirement(), theReqSpecPackage.getRequirement(), null, "requirement", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClaim_Title(), theEcorePackage.getEString(), "title", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClaim_Weight(), theEcorePackage.getEString(), "weight", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaim_Activities(), this.getVerificationActivity(), null, "activities", null, 0, -1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaim_Assert(), this.getArgumentExpr(), null, "assert", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaim_Rationale(), theCommonPackage.getRationale(), null, "rationale", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaim_Subclaim(), this.getClaim(), null, "subclaim", null, 0, -1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClaim_Issues(), theEcorePackage.getEString(), "issues", null, 0, -1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(argumentExprEClass, ArgumentExpr.class, "ArgumentExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(verificationActivityEClass, VerificationActivity.class, "VerificationActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationActivity_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationActivity_Title(), theEcorePackage.getEString(), "title", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_DevelopmentPhase(), theCategoriesPackage.getDevelopmentPhase(), null, "developmentPhase", null, 0, -1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_UserSelection(), theCategoriesPackage.getUserSelection(), null, "userSelection", null, 0, -1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_Result(), theCommonPackage.getComputeDeclaration(), null, "result", null, 0, -1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_Method(), this.getVerificationMethod(), null, "method", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_Parameters(), theCommonPackage.getValDeclaration(), null, "parameters", null, 0, -1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_PropertyValues(), theCommonPackage.getValDeclaration(), null, "propertyValues", null, 0, -1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationActivity_Timeout(), theEcorePackage.getEInt(), "timeout", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationConditionEClass, VerificationCondition.class, "VerificationCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVerificationCondition_Method(), this.getVerificationMethod(), null, "method", null, 0, 1, VerificationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationCondition_Parameters(), this.getFormalParameter(), null, "parameters", null, 0, -1, VerificationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationMethodRegistryEClass, VerificationMethodRegistry.class, "VerificationMethodRegistry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationMethodRegistry_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VerificationMethodRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationMethodRegistry_Title(), theEcorePackage.getEString(), "title", null, 0, 1, VerificationMethodRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethodRegistry_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, VerificationMethodRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethodRegistry_Methods(), this.getVerificationMethod(), null, "methods", null, 0, -1, VerificationMethodRegistry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(formalParameterEClass, FormalParameter.class, "FormalParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFormalParameter_ParameterType(), theEcorePackage.getEString(), "parameterType", null, 0, 1, FormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFormalParameter_Name(), theEcorePackage.getEString(), "name", null, 0, 1, FormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFormalParameter_Unit(), theAadl2Package.getUnitLiteral(), null, "unit", null, 0, 1, FormalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationMethodEClass, VerificationMethod.class, "VerificationMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationMethod_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Params(), this.getFormalParameter(), null, "params", null, 0, -1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Properties(), theAadl2Package.getProperty(), null, "properties", null, 0, -1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationMethod_IsPredicate(), theEcorePackage.getEBoolean(), "isPredicate", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationMethod_IsResultReport(), theEcorePackage.getEBoolean(), "isResultReport", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationMethod_Title(), theEcorePackage.getEString(), "title", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_MethodKind(), this.getMethodKind(), null, "methodKind", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Precondition(), this.getVerificationCondition(), null, "precondition", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Validation(), this.getVerificationCondition(), null, "validation", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_MethodType(), theCategoriesPackage.getMethodType(), null, "methodType", null, 0, -1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_QualityAttribute(), theCategoriesPackage.getQualityAttribute(), null, "qualityAttribute", null, 0, -1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_UserSelection(), theCategoriesPackage.getUserSelection(), null, "userSelection", null, 0, -1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(methodKindEClass, MethodKind.class, "MethodKind", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(resoluteMethodEClass, ResoluteMethod.class, "ResoluteMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResoluteMethod_MethodReference(), theResolutePackage.getFunctionDefinition(), null, "methodReference", null, 0, 1, ResoluteMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(javaMethodEClass, JavaMethod.class, "JavaMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getJavaMethod_MethodPath(), theEcorePackage.getEString(), "methodPath", null, 0, 1, JavaMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(manualMethodEClass, ManualMethod.class, "ManualMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getManualMethod_DialogID(), theEcorePackage.getEString(), "dialogID", null, 0, 1, ManualMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pluginMethodEClass, PluginMethod.class, "PluginMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPluginMethod_MethodID(), theEcorePackage.getEString(), "methodID", null, 0, 1, PluginMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
    initEAttribute(getRefExpr_Weight(), theEcorePackage.getEInt(), "weight", null, 0, 1, RefExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationValidationEClass, VerificationValidation.class, "VerificationValidation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(verificationPreconditionEClass, VerificationPrecondition.class, "VerificationPrecondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //VerifyPackageImpl
