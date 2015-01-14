/**
 */
package org.osate.verify.verify.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.alisa.common.common.CommonPackage;

import org.osate.categories.categories.CategoriesPackage;

import org.osate.reqspec.reqSpec.ReqSpecPackage;

import org.osate.verify.verify.AllExpr;
import org.osate.verify.verify.AndThenExpr;
import org.osate.verify.verify.ArgumentExpr;
import org.osate.verify.verify.AtomicConditionExpr;
import org.osate.verify.verify.Claim;
import org.osate.verify.verify.ConditionExpr;
import org.osate.verify.verify.ConditionalExpr;
import org.osate.verify.verify.FailThenExpr;
import org.osate.verify.verify.RefExpr;
import org.osate.verify.verify.SupportedTypes;
import org.osate.verify.verify.Verification;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationAssumption;
import org.osate.verify.verify.VerificationCondition;
import org.osate.verify.verify.VerificationContainer;
import org.osate.verify.verify.VerificationFolder;
import org.osate.verify.verify.VerificationLibrary;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerificationPlan;
import org.osate.verify.verify.VerificationPrecondition;
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
  private EClass verificationLibraryEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationFolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationContainerEClass = null;

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
  private EClass argumentExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass atomicConditionExprEClass = null;

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
  private EClass verificationAssumptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass verificationPreconditionEClass = null;

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
  private EClass andThenExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass failThenExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conditionalExprEClass = null;

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
  private EEnum supportedTypesEEnum = null;

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
  public EReference getVerificationPlan_Target()
  {
    return (EReference)verificationPlanEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationPlan_Description()
  {
    return (EAttribute)verificationPlanEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationPlan_Claims()
  {
    return (EReference)verificationPlanEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationLibrary()
  {
    return verificationLibraryEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationLibrary_Name()
  {
    return (EAttribute)verificationLibraryEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationFolder()
  {
    return verificationFolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationFolder_Label()
  {
    return (EAttribute)verificationFolderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationContainer()
  {
    return verificationContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationContainer_Target()
  {
    return (EReference)verificationContainerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationContainer_Content()
  {
    return (EReference)verificationContainerEClass.getEStructuralFeatures().get(1);
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
  public EAttribute getClaim_Name()
  {
    return (EAttribute)claimEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaim_Requirement()
  {
    return (EReference)claimEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaim_Assert()
  {
    return (EReference)claimEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClaim_Rationale()
  {
    return (EAttribute)claimEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClaim_Subclaims()
  {
    return (EReference)claimEClass.getEStructuralFeatures().get(4);
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
  public EReference getVerificationActivity_Target()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationActivity_Title()
  {
    return (EAttribute)verificationActivityEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivity_Description()
  {
    return (EReference)verificationActivityEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationActivity_Category()
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
  public EClass getVerificationCondition()
  {
    return verificationConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationCondition_Name()
  {
    return (EAttribute)verificationConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationCondition_Title()
  {
    return (EAttribute)verificationConditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationCondition_Description()
  {
    return (EReference)verificationConditionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationCondition_Assert()
  {
    return (EReference)verificationConditionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationCondition_MetBy()
  {
    return (EReference)verificationConditionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationCondition_Rationale()
  {
    return (EAttribute)verificationConditionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationCondition_Issue()
  {
    return (EAttribute)verificationConditionEClass.getEStructuralFeatures().get(6);
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
  public EClass getConditionExpr()
  {
    return conditionExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionExpr_Left()
  {
    return (EReference)conditionExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConditionExpr_Op()
  {
    return (EAttribute)conditionExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionExpr_Right()
  {
    return (EReference)conditionExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAtomicConditionExpr()
  {
    return atomicConditionExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAtomicConditionExpr_Cat()
  {
    return (EReference)atomicConditionExprEClass.getEStructuralFeatures().get(0);
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
  public EAttribute getVerificationMethod_Title()
  {
    return (EAttribute)verificationMethodEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationMethod_MethodType()
  {
    return (EAttribute)verificationMethodEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVerificationMethod_Method()
  {
    return (EAttribute)verificationMethodEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethod_Description()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethod_Category()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVerificationMethod_Conditions()
  {
    return (EReference)verificationMethodEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVerificationAssumption()
  {
    return verificationAssumptionEClass;
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
  public EClass getAllExpr()
  {
    return allExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAllExpr_All()
  {
    return (EReference)allExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAndThenExpr()
  {
    return andThenExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndThenExpr_Left()
  {
    return (EReference)andThenExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAndThenExpr_Op()
  {
    return (EAttribute)andThenExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAndThenExpr_Right()
  {
    return (EReference)andThenExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFailThenExpr()
  {
    return failThenExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFailThenExpr_Left()
  {
    return (EReference)failThenExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFailThenExpr_Op()
  {
    return (EAttribute)failThenExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFailThenExpr_Right()
  {
    return (EReference)failThenExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConditionalExpr()
  {
    return conditionalExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpr_Verification()
  {
    return (EReference)conditionalExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConditionalExpr_Op()
  {
    return (EAttribute)conditionalExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConditionalExpr_Condition()
  {
    return (EReference)conditionalExprEClass.getEStructuralFeatures().get(2);
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
  public EEnum getSupportedTypes()
  {
    return supportedTypesEEnum;
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
    createEReference(verificationPlanEClass, VERIFICATION_PLAN__TARGET);
    createEAttribute(verificationPlanEClass, VERIFICATION_PLAN__DESCRIPTION);
    createEReference(verificationPlanEClass, VERIFICATION_PLAN__CLAIMS);

    verificationLibraryEClass = createEClass(VERIFICATION_LIBRARY);
    createEAttribute(verificationLibraryEClass, VERIFICATION_LIBRARY__NAME);

    verificationFolderEClass = createEClass(VERIFICATION_FOLDER);
    createEAttribute(verificationFolderEClass, VERIFICATION_FOLDER__LABEL);

    verificationContainerEClass = createEClass(VERIFICATION_CONTAINER);
    createEReference(verificationContainerEClass, VERIFICATION_CONTAINER__TARGET);
    createEReference(verificationContainerEClass, VERIFICATION_CONTAINER__CONTENT);

    claimEClass = createEClass(CLAIM);
    createEAttribute(claimEClass, CLAIM__NAME);
    createEReference(claimEClass, CLAIM__REQUIREMENT);
    createEReference(claimEClass, CLAIM__ASSERT);
    createEAttribute(claimEClass, CLAIM__RATIONALE);
    createEReference(claimEClass, CLAIM__SUBCLAIMS);

    verificationActivityEClass = createEClass(VERIFICATION_ACTIVITY);
    createEAttribute(verificationActivityEClass, VERIFICATION_ACTIVITY__NAME);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__TARGET);
    createEAttribute(verificationActivityEClass, VERIFICATION_ACTIVITY__TITLE);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__DESCRIPTION);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__CATEGORY);
    createEReference(verificationActivityEClass, VERIFICATION_ACTIVITY__METHOD);

    verificationConditionEClass = createEClass(VERIFICATION_CONDITION);
    createEAttribute(verificationConditionEClass, VERIFICATION_CONDITION__NAME);
    createEAttribute(verificationConditionEClass, VERIFICATION_CONDITION__TITLE);
    createEReference(verificationConditionEClass, VERIFICATION_CONDITION__DESCRIPTION);
    createEReference(verificationConditionEClass, VERIFICATION_CONDITION__ASSERT);
    createEReference(verificationConditionEClass, VERIFICATION_CONDITION__MET_BY);
    createEAttribute(verificationConditionEClass, VERIFICATION_CONDITION__RATIONALE);
    createEAttribute(verificationConditionEClass, VERIFICATION_CONDITION__ISSUE);

    argumentExprEClass = createEClass(ARGUMENT_EXPR);

    conditionExprEClass = createEClass(CONDITION_EXPR);
    createEReference(conditionExprEClass, CONDITION_EXPR__LEFT);
    createEAttribute(conditionExprEClass, CONDITION_EXPR__OP);
    createEReference(conditionExprEClass, CONDITION_EXPR__RIGHT);

    atomicConditionExprEClass = createEClass(ATOMIC_CONDITION_EXPR);
    createEReference(atomicConditionExprEClass, ATOMIC_CONDITION_EXPR__CAT);

    verificationMethodEClass = createEClass(VERIFICATION_METHOD);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__NAME);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__TITLE);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__METHOD_TYPE);
    createEAttribute(verificationMethodEClass, VERIFICATION_METHOD__METHOD);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__DESCRIPTION);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__CATEGORY);
    createEReference(verificationMethodEClass, VERIFICATION_METHOD__CONDITIONS);

    verificationAssumptionEClass = createEClass(VERIFICATION_ASSUMPTION);

    verificationPreconditionEClass = createEClass(VERIFICATION_PRECONDITION);

    allExprEClass = createEClass(ALL_EXPR);
    createEReference(allExprEClass, ALL_EXPR__ALL);

    andThenExprEClass = createEClass(AND_THEN_EXPR);
    createEReference(andThenExprEClass, AND_THEN_EXPR__LEFT);
    createEAttribute(andThenExprEClass, AND_THEN_EXPR__OP);
    createEReference(andThenExprEClass, AND_THEN_EXPR__RIGHT);

    failThenExprEClass = createEClass(FAIL_THEN_EXPR);
    createEReference(failThenExprEClass, FAIL_THEN_EXPR__LEFT);
    createEAttribute(failThenExprEClass, FAIL_THEN_EXPR__OP);
    createEReference(failThenExprEClass, FAIL_THEN_EXPR__RIGHT);

    conditionalExprEClass = createEClass(CONDITIONAL_EXPR);
    createEReference(conditionalExprEClass, CONDITIONAL_EXPR__VERIFICATION);
    createEAttribute(conditionalExprEClass, CONDITIONAL_EXPR__OP);
    createEReference(conditionalExprEClass, CONDITIONAL_EXPR__CONDITION);

    refExprEClass = createEClass(REF_EXPR);
    createEReference(refExprEClass, REF_EXPR__VERIFICATION);
    createEAttribute(refExprEClass, REF_EXPR__WEIGHT);

    // Create enums
    supportedTypesEEnum = createEEnum(SUPPORTED_TYPES);
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
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);
    ReqSpecPackage theReqSpecPackage = (ReqSpecPackage)EPackage.Registry.INSTANCE.getEPackage(ReqSpecPackage.eNS_URI);
    CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
    CategoriesPackage theCategoriesPackage = (CategoriesPackage)EPackage.Registry.INSTANCE.getEPackage(CategoriesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    verificationLibraryEClass.getESuperTypes().add(this.getVerificationContainer());
    verificationFolderEClass.getESuperTypes().add(this.getVerificationContainer());
    atomicConditionExprEClass.getESuperTypes().add(this.getConditionExpr());
    verificationAssumptionEClass.getESuperTypes().add(this.getVerificationCondition());
    verificationPreconditionEClass.getESuperTypes().add(this.getVerificationCondition());
    allExprEClass.getESuperTypes().add(this.getArgumentExpr());
    andThenExprEClass.getESuperTypes().add(this.getArgumentExpr());
    failThenExprEClass.getESuperTypes().add(this.getArgumentExpr());
    conditionalExprEClass.getESuperTypes().add(this.getArgumentExpr());
    refExprEClass.getESuperTypes().add(this.getArgumentExpr());

    // Initialize classes and features; add operations and parameters
    initEClass(verificationEClass, Verification.class, "Verification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVerification_Contents(), theEcorePackage.getEObject(), null, "contents", null, 0, -1, Verification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationPlanEClass, VerificationPlan.class, "VerificationPlan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationPlan_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationPlan_Target(), theAadl2Package.getComponentClassifier(), null, "target", null, 0, 1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationPlan_Description(), theEcorePackage.getEString(), "description", null, 0, 1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationPlan_Claims(), this.getClaim(), null, "claims", null, 0, -1, VerificationPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationLibraryEClass, VerificationLibrary.class, "VerificationLibrary", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationLibrary_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VerificationLibrary.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationFolderEClass, VerificationFolder.class, "VerificationFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationFolder_Label(), theEcorePackage.getEString(), "label", null, 0, 1, VerificationFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationContainerEClass, VerificationContainer.class, "VerificationContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVerificationContainer_Target(), theReqSpecPackage.getRequirement(), null, "target", null, 0, 1, VerificationContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationContainer_Content(), theEcorePackage.getEObject(), null, "content", null, 0, -1, VerificationContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(claimEClass, Claim.class, "Claim", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getClaim_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaim_Requirement(), theReqSpecPackage.getRequirement(), null, "requirement", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaim_Assert(), this.getArgumentExpr(), null, "assert", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getClaim_Rationale(), theEcorePackage.getEString(), "rationale", null, 0, 1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClaim_Subclaims(), this.getClaim(), null, "subclaims", null, 0, -1, Claim.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationActivityEClass, VerificationActivity.class, "VerificationActivity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationActivity_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_Target(), theAadl2Package.getComponentClassifier(), null, "target", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationActivity_Title(), theEcorePackage.getEString(), "title", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_Category(), theCategoriesPackage.getSelectionCategory(), null, "category", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationActivity_Method(), this.getVerificationMethod(), null, "method", null, 0, 1, VerificationActivity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationConditionEClass, VerificationCondition.class, "VerificationCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationCondition_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VerificationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationCondition_Title(), theEcorePackage.getEString(), "title", null, 0, 1, VerificationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationCondition_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, VerificationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationCondition_Assert(), this.getArgumentExpr(), null, "assert", null, 0, 1, VerificationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationCondition_MetBy(), theReqSpecPackage.getRequirement(), null, "metBy", null, 0, 1, VerificationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationCondition_Rationale(), theEcorePackage.getEString(), "rationale", null, 0, 1, VerificationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationCondition_Issue(), theEcorePackage.getEString(), "issue", null, 0, -1, VerificationCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(argumentExprEClass, ArgumentExpr.class, "ArgumentExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(conditionExprEClass, ConditionExpr.class, "ConditionExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionExpr_Left(), this.getConditionExpr(), null, "left", null, 0, 1, ConditionExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConditionExpr_Op(), theEcorePackage.getEString(), "op", null, 0, 1, ConditionExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionExpr_Right(), this.getConditionExpr(), null, "right", null, 0, 1, ConditionExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(atomicConditionExprEClass, AtomicConditionExpr.class, "AtomicConditionExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAtomicConditionExpr_Cat(), theCategoriesPackage.getVerificationCategory(), null, "cat", null, 0, 1, AtomicConditionExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationMethodEClass, VerificationMethod.class, "VerificationMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVerificationMethod_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationMethod_Title(), theEcorePackage.getEString(), "title", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationMethod_MethodType(), this.getSupportedTypes(), "methodType", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVerificationMethod_Method(), theEcorePackage.getEString(), "method", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Category(), theCategoriesPackage.getVerificationCategory(), null, "category", null, 0, 1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVerificationMethod_Conditions(), this.getVerificationCondition(), null, "conditions", null, 0, -1, VerificationMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(verificationAssumptionEClass, VerificationAssumption.class, "VerificationAssumption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(verificationPreconditionEClass, VerificationPrecondition.class, "VerificationPrecondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(allExprEClass, AllExpr.class, "AllExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAllExpr_All(), this.getArgumentExpr(), null, "all", null, 0, -1, AllExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(andThenExprEClass, AndThenExpr.class, "AndThenExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAndThenExpr_Left(), this.getArgumentExpr(), null, "left", null, 0, 1, AndThenExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAndThenExpr_Op(), theEcorePackage.getEString(), "op", null, 0, 1, AndThenExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAndThenExpr_Right(), this.getArgumentExpr(), null, "right", null, 0, 1, AndThenExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(failThenExprEClass, FailThenExpr.class, "FailThenExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFailThenExpr_Left(), this.getArgumentExpr(), null, "left", null, 0, 1, FailThenExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFailThenExpr_Op(), theEcorePackage.getEString(), "op", null, 0, 1, FailThenExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFailThenExpr_Right(), this.getArgumentExpr(), null, "right", null, 0, 1, FailThenExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conditionalExprEClass, ConditionalExpr.class, "ConditionalExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConditionalExpr_Verification(), this.getArgumentExpr(), null, "verification", null, 0, 1, ConditionalExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConditionalExpr_Op(), theEcorePackage.getEString(), "op", null, 0, 1, ConditionalExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConditionalExpr_Condition(), this.getConditionExpr(), null, "condition", null, 0, 1, ConditionalExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(refExprEClass, RefExpr.class, "RefExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRefExpr_Verification(), this.getVerificationActivity(), null, "verification", null, 0, 1, RefExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRefExpr_Weight(), theEcorePackage.getEInt(), "weight", null, 0, 1, RefExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(supportedTypesEEnum, SupportedTypes.class, "SupportedTypes");
    addEEnumLiteral(supportedTypesEEnum, SupportedTypes.SINGLEPREDICATE);
    addEEnumLiteral(supportedTypesEEnum, SupportedTypes.SINGLEANALYSIS);
    addEEnumLiteral(supportedTypesEEnum, SupportedTypes.MULTIPREDICATE);
    addEEnumLiteral(supportedTypesEEnum, SupportedTypes.MULTIANALYSIS);

    // Create resource
    createResource(eNS_URI);
  }

} //VerifyPackageImpl
