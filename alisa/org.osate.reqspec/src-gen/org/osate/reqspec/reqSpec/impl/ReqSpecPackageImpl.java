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
package org.osate.reqspec.reqSpec.impl;

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

import org.osate.reqspec.reqSpec.ContractualElement;
import org.osate.reqspec.reqSpec.DesiredValue;
import org.osate.reqspec.reqSpec.DocumentSection;
import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.GlobalConstants;
import org.osate.reqspec.reqSpec.GlobalRequirementSet;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.IncludeGlobalRequirement;
import org.osate.reqspec.reqSpec.InformalPredicate;
import org.osate.reqspec.reqSpec.ReqDocument;
import org.osate.reqspec.reqSpec.ReqPredicate;
import org.osate.reqspec.reqSpec.ReqRoot;
import org.osate.reqspec.reqSpec.ReqSpec;
import org.osate.reqspec.reqSpec.ReqSpecFactory;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.ReqValDeclaration;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.RequirementSet;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.reqSpec.SystemRequirementSet;
import org.osate.reqspec.reqSpec.ValuePredicate;
import org.osate.reqspec.reqSpec.WhenCondition;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReqSpecPackageImpl extends EPackageImpl implements ReqSpecPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reqSpecEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass globalConstantsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contractualElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reqRootEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stakeholderGoalsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reqDocumentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass documentSectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requirementSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass goalEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass includeGlobalRequirementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass whenConditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reqPredicateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass informalPredicateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valuePredicateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass desiredValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass externalDocumentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass systemRequirementSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass globalRequirementSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reqValDeclarationEClass = null;

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
   * @see org.osate.reqspec.reqSpec.ReqSpecPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private ReqSpecPackageImpl()
  {
    super(eNS_URI, ReqSpecFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link ReqSpecPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static ReqSpecPackage init()
  {
    if (isInited) return (ReqSpecPackage)EPackage.Registry.INSTANCE.getEPackage(ReqSpecPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredReqSpecPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    ReqSpecPackageImpl theReqSpecPackage = registeredReqSpecPackage instanceof ReqSpecPackageImpl ? (ReqSpecPackageImpl)registeredReqSpecPackage : new ReqSpecPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();
    Aadl2Package.eINSTANCE.eClass();
    CommonPackage.eINSTANCE.eClass();
    CategoriesPackage.eINSTANCE.eClass();
    OrganizationPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theReqSpecPackage.createPackageContents();

    // Initialize created meta-data
    theReqSpecPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theReqSpecPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(ReqSpecPackage.eNS_URI, theReqSpecPackage);
    return theReqSpecPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getReqSpec()
  {
    return reqSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReqSpec_Parts()
  {
    return (EReference)reqSpecEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getGlobalConstants()
  {
    return globalConstantsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getGlobalConstants_Name()
  {
    return (EAttribute)globalConstantsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getGlobalConstants_Constants()
  {
    return (EReference)globalConstantsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getContractualElement()
  {
    return contractualElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getContractualElement_Name()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getContractualElement_Title()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getContractualElement_TargetDescription()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContractualElement_Target()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContractualElement_TargetElement()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContractualElement_Category()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContractualElement_Description()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContractualElement_Constants()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContractualElement_Whencondition()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContractualElement_Rationale()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContractualElement_ChangeUncertainty()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContractualElement_EvolvesReference()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(11);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getContractualElement_Dropped()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(12);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getContractualElement_DropRationale()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(13);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContractualElement_DocReference()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(14);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getContractualElement_Issues()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(15);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getContractualElement_GoalReference()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(16);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getReqRoot()
  {
    return reqRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getReqRoot_Name()
  {
    return (EAttribute)reqRootEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getReqRoot_Title()
  {
    return (EAttribute)reqRootEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReqRoot_Description()
  {
    return (EReference)reqRootEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReqRoot_DocReference()
  {
    return (EReference)reqRootEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getReqRoot_Issues()
  {
    return (EAttribute)reqRootEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getStakeholderGoals()
  {
    return stakeholderGoalsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getStakeholderGoals_Target()
  {
    return (EReference)stakeholderGoalsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getStakeholderGoals_ComponentCategory()
  {
    return (EAttribute)stakeholderGoalsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getStakeholderGoals_ImportConstants()
  {
    return (EReference)stakeholderGoalsEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getStakeholderGoals_Constants()
  {
    return (EReference)stakeholderGoalsEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getStakeholderGoals_Goals()
  {
    return (EReference)stakeholderGoalsEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getReqDocument()
  {
    return reqDocumentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReqDocument_Content()
  {
    return (EReference)reqDocumentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDocumentSection()
  {
    return documentSectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getDocumentSection_Label()
  {
    return (EAttribute)documentSectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getDocumentSection_Title()
  {
    return (EAttribute)documentSectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDocumentSection_Description()
  {
    return (EReference)documentSectionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDocumentSection_Content()
  {
    return (EReference)documentSectionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getRequirementSet()
  {
    return requirementSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRequirementSet_ImportConstants()
  {
    return (EReference)requirementSetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRequirementSet_Constants()
  {
    return (EReference)requirementSetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRequirementSet_Computes()
  {
    return (EReference)requirementSetEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRequirementSet_Requirements()
  {
    return (EReference)requirementSetEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRequirementSet_StakeholderGoals()
  {
    return (EReference)requirementSetEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getGoal()
  {
    return goalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getGoal_RefinesReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getGoal_ConflictsReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getGoal_StakeholderReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getRequirement()
  {
    return requirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRequirement_Predicate()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRequirement_Exception()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRequirement_ExceptionText()
  {
    return (EAttribute)requirementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRequirement_InheritsReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRequirement_Computes()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRequirement_RefinesReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRequirement_DecomposesReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRequirement_DevelopmentStakeholder()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getRequirement_RequirementReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRequirement_ComponentCategory()
  {
    return (EAttribute)requirementEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getRequirement_TargetType()
  {
    return (EAttribute)requirementEClass.getEStructuralFeatures().get(10);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getIncludeGlobalRequirement()
  {
    return includeGlobalRequirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getIncludeGlobalRequirement_Include()
  {
    return (EReference)includeGlobalRequirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getIncludeGlobalRequirement_Local()
  {
    return (EAttribute)includeGlobalRequirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getIncludeGlobalRequirement_TargetElement()
  {
    return (EReference)includeGlobalRequirementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getWhenCondition()
  {
    return whenConditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getWhenCondition_InMode()
  {
    return (EReference)whenConditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getWhenCondition_InErrorState()
  {
    return (EReference)whenConditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getWhenCondition_Condition()
  {
    return (EAttribute)whenConditionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getReqPredicate()
  {
    return reqPredicateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getInformalPredicate()
  {
    return informalPredicateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getInformalPredicate_Description()
  {
    return (EAttribute)informalPredicateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getValuePredicate()
  {
    return valuePredicateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getValuePredicate_Xpression()
  {
    return (EReference)valuePredicateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getValuePredicate_DesiredValue()
  {
    return (EReference)valuePredicateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getDesiredValue()
  {
    return desiredValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDesiredValue_Desired()
  {
    return (EReference)desiredValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getDesiredValue_Upto()
  {
    return (EAttribute)desiredValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getDesiredValue_Value()
  {
    return (EReference)desiredValueEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getExternalDocument()
  {
    return externalDocumentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getExternalDocument_DocReference()
  {
    return (EAttribute)externalDocumentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EAttribute getExternalDocument_DocFragment()
  {
    return (EAttribute)externalDocumentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getSystemRequirementSet()
  {
    return systemRequirementSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSystemRequirementSet_Target()
  {
    return (EReference)systemRequirementSetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getSystemRequirementSet_Include()
  {
    return (EReference)systemRequirementSetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getGlobalRequirementSet()
  {
    return globalRequirementSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EClass getReqValDeclaration()
  {
    return reqValDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReference getReqValDeclaration_Property()
  {
    return (EReference)reqValDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ReqSpecFactory getReqSpecFactory()
  {
    return (ReqSpecFactory)getEFactoryInstance();
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
    reqSpecEClass = createEClass(REQ_SPEC);
    createEReference(reqSpecEClass, REQ_SPEC__PARTS);

    globalConstantsEClass = createEClass(GLOBAL_CONSTANTS);
    createEAttribute(globalConstantsEClass, GLOBAL_CONSTANTS__NAME);
    createEReference(globalConstantsEClass, GLOBAL_CONSTANTS__CONSTANTS);

    contractualElementEClass = createEClass(CONTRACTUAL_ELEMENT);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__NAME);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__TITLE);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__TARGET);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__TARGET_ELEMENT);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__CATEGORY);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__DESCRIPTION);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__CONSTANTS);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__WHENCONDITION);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__RATIONALE);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__EVOLVES_REFERENCE);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__DROPPED);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__DROP_RATIONALE);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__DOC_REFERENCE);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__ISSUES);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__GOAL_REFERENCE);

    reqRootEClass = createEClass(REQ_ROOT);
    createEAttribute(reqRootEClass, REQ_ROOT__NAME);
    createEAttribute(reqRootEClass, REQ_ROOT__TITLE);
    createEReference(reqRootEClass, REQ_ROOT__DESCRIPTION);
    createEReference(reqRootEClass, REQ_ROOT__DOC_REFERENCE);
    createEAttribute(reqRootEClass, REQ_ROOT__ISSUES);

    stakeholderGoalsEClass = createEClass(STAKEHOLDER_GOALS);
    createEReference(stakeholderGoalsEClass, STAKEHOLDER_GOALS__TARGET);
    createEAttribute(stakeholderGoalsEClass, STAKEHOLDER_GOALS__COMPONENT_CATEGORY);
    createEReference(stakeholderGoalsEClass, STAKEHOLDER_GOALS__IMPORT_CONSTANTS);
    createEReference(stakeholderGoalsEClass, STAKEHOLDER_GOALS__CONSTANTS);
    createEReference(stakeholderGoalsEClass, STAKEHOLDER_GOALS__GOALS);

    reqDocumentEClass = createEClass(REQ_DOCUMENT);
    createEReference(reqDocumentEClass, REQ_DOCUMENT__CONTENT);

    documentSectionEClass = createEClass(DOCUMENT_SECTION);
    createEAttribute(documentSectionEClass, DOCUMENT_SECTION__LABEL);
    createEAttribute(documentSectionEClass, DOCUMENT_SECTION__TITLE);
    createEReference(documentSectionEClass, DOCUMENT_SECTION__DESCRIPTION);
    createEReference(documentSectionEClass, DOCUMENT_SECTION__CONTENT);

    requirementSetEClass = createEClass(REQUIREMENT_SET);
    createEReference(requirementSetEClass, REQUIREMENT_SET__IMPORT_CONSTANTS);
    createEReference(requirementSetEClass, REQUIREMENT_SET__CONSTANTS);
    createEReference(requirementSetEClass, REQUIREMENT_SET__COMPUTES);
    createEReference(requirementSetEClass, REQUIREMENT_SET__REQUIREMENTS);
    createEReference(requirementSetEClass, REQUIREMENT_SET__STAKEHOLDER_GOALS);

    goalEClass = createEClass(GOAL);
    createEReference(goalEClass, GOAL__REFINES_REFERENCE);
    createEReference(goalEClass, GOAL__CONFLICTS_REFERENCE);
    createEReference(goalEClass, GOAL__STAKEHOLDER_REFERENCE);

    requirementEClass = createEClass(REQUIREMENT);
    createEReference(requirementEClass, REQUIREMENT__PREDICATE);
    createEReference(requirementEClass, REQUIREMENT__EXCEPTION);
    createEAttribute(requirementEClass, REQUIREMENT__EXCEPTION_TEXT);
    createEReference(requirementEClass, REQUIREMENT__INHERITS_REFERENCE);
    createEReference(requirementEClass, REQUIREMENT__COMPUTES);
    createEReference(requirementEClass, REQUIREMENT__REFINES_REFERENCE);
    createEReference(requirementEClass, REQUIREMENT__DECOMPOSES_REFERENCE);
    createEReference(requirementEClass, REQUIREMENT__DEVELOPMENT_STAKEHOLDER);
    createEReference(requirementEClass, REQUIREMENT__REQUIREMENT_REFERENCE);
    createEAttribute(requirementEClass, REQUIREMENT__COMPONENT_CATEGORY);
    createEAttribute(requirementEClass, REQUIREMENT__TARGET_TYPE);

    includeGlobalRequirementEClass = createEClass(INCLUDE_GLOBAL_REQUIREMENT);
    createEReference(includeGlobalRequirementEClass, INCLUDE_GLOBAL_REQUIREMENT__INCLUDE);
    createEAttribute(includeGlobalRequirementEClass, INCLUDE_GLOBAL_REQUIREMENT__LOCAL);
    createEReference(includeGlobalRequirementEClass, INCLUDE_GLOBAL_REQUIREMENT__TARGET_ELEMENT);

    whenConditionEClass = createEClass(WHEN_CONDITION);
    createEReference(whenConditionEClass, WHEN_CONDITION__IN_MODE);
    createEReference(whenConditionEClass, WHEN_CONDITION__IN_ERROR_STATE);
    createEAttribute(whenConditionEClass, WHEN_CONDITION__CONDITION);

    reqPredicateEClass = createEClass(REQ_PREDICATE);

    informalPredicateEClass = createEClass(INFORMAL_PREDICATE);
    createEAttribute(informalPredicateEClass, INFORMAL_PREDICATE__DESCRIPTION);

    valuePredicateEClass = createEClass(VALUE_PREDICATE);
    createEReference(valuePredicateEClass, VALUE_PREDICATE__XPRESSION);
    createEReference(valuePredicateEClass, VALUE_PREDICATE__DESIRED_VALUE);

    desiredValueEClass = createEClass(DESIRED_VALUE);
    createEReference(desiredValueEClass, DESIRED_VALUE__DESIRED);
    createEAttribute(desiredValueEClass, DESIRED_VALUE__UPTO);
    createEReference(desiredValueEClass, DESIRED_VALUE__VALUE);

    externalDocumentEClass = createEClass(EXTERNAL_DOCUMENT);
    createEAttribute(externalDocumentEClass, EXTERNAL_DOCUMENT__DOC_REFERENCE);
    createEAttribute(externalDocumentEClass, EXTERNAL_DOCUMENT__DOC_FRAGMENT);

    systemRequirementSetEClass = createEClass(SYSTEM_REQUIREMENT_SET);
    createEReference(systemRequirementSetEClass, SYSTEM_REQUIREMENT_SET__TARGET);
    createEReference(systemRequirementSetEClass, SYSTEM_REQUIREMENT_SET__INCLUDE);

    globalRequirementSetEClass = createEClass(GLOBAL_REQUIREMENT_SET);

    reqValDeclarationEClass = createEClass(REQ_VAL_DECLARATION);
    createEReference(reqValDeclarationEClass, REQ_VAL_DECLARATION__PROPERTY);
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
    CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);
    CategoriesPackage theCategoriesPackage = (CategoriesPackage)EPackage.Registry.INSTANCE.getEPackage(CategoriesPackage.eNS_URI);
    OrganizationPackage theOrganizationPackage = (OrganizationPackage)EPackage.Registry.INSTANCE.getEPackage(OrganizationPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    stakeholderGoalsEClass.getESuperTypes().add(this.getReqRoot());
    reqDocumentEClass.getESuperTypes().add(this.getReqRoot());
    requirementSetEClass.getESuperTypes().add(this.getReqRoot());
    goalEClass.getESuperTypes().add(this.getContractualElement());
    requirementEClass.getESuperTypes().add(this.getContractualElement());
    informalPredicateEClass.getESuperTypes().add(this.getReqPredicate());
    valuePredicateEClass.getESuperTypes().add(this.getReqPredicate());
    systemRequirementSetEClass.getESuperTypes().add(this.getRequirementSet());
    globalRequirementSetEClass.getESuperTypes().add(this.getRequirementSet());
    reqValDeclarationEClass.getESuperTypes().add(theCommonPackage.getValDeclaration());

    // Initialize classes and features; add operations and parameters
    initEClass(reqSpecEClass, ReqSpec.class, "ReqSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReqSpec_Parts(), theEcorePackage.getEObject(), null, "parts", null, 0, -1, ReqSpec.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(globalConstantsEClass, GlobalConstants.class, "GlobalConstants", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGlobalConstants_Name(), theEcorePackage.getEString(), "name", null, 0, 1, GlobalConstants.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGlobalConstants_Constants(), theCommonPackage.getValDeclaration(), null, "constants", null, 0, -1, GlobalConstants.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(contractualElementEClass, ContractualElement.class, "ContractualElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getContractualElement_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContractualElement_Title(), theEcorePackage.getEString(), "title", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContractualElement_TargetDescription(), theEcorePackage.getEString(), "targetDescription", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_Target(), theAadl2Package.getComponentClassifier(), null, "target", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_TargetElement(), theAadl2Package.getNamedElement(), null, "targetElement", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_Category(), theCategoriesPackage.getCategory(), null, "category", null, 0, -1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_Constants(), theCommonPackage.getValDeclaration(), null, "constants", null, 0, -1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_Whencondition(), this.getWhenCondition(), null, "whencondition", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_Rationale(), theCommonPackage.getRationale(), null, "rationale", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_ChangeUncertainty(), theCommonPackage.getUncertainty(), null, "changeUncertainty", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_EvolvesReference(), this.getRequirement(), null, "evolvesReference", null, 0, -1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContractualElement_Dropped(), theEcorePackage.getEBoolean(), "dropped", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContractualElement_DropRationale(), theEcorePackage.getEString(), "dropRationale", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_DocReference(), this.getExternalDocument(), null, "docReference", null, 0, -1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContractualElement_Issues(), theEcorePackage.getEString(), "issues", null, 0, -1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_GoalReference(), this.getGoal(), null, "goalReference", null, 0, -1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reqRootEClass, ReqRoot.class, "ReqRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReqRoot_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ReqRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReqRoot_Title(), theEcorePackage.getEString(), "title", null, 0, 1, ReqRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReqRoot_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, ReqRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReqRoot_DocReference(), this.getExternalDocument(), null, "docReference", null, 0, -1, ReqRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReqRoot_Issues(), theEcorePackage.getEString(), "issues", null, 0, -1, ReqRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stakeholderGoalsEClass, StakeholderGoals.class, "StakeholderGoals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStakeholderGoals_Target(), theAadl2Package.getComponentClassifier(), null, "target", null, 0, 1, StakeholderGoals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStakeholderGoals_ComponentCategory(), theAadl2Package.getComponentCategory(), "componentCategory", null, 0, -1, StakeholderGoals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStakeholderGoals_ImportConstants(), this.getGlobalConstants(), null, "importConstants", null, 0, -1, StakeholderGoals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStakeholderGoals_Constants(), theCommonPackage.getValDeclaration(), null, "constants", null, 0, -1, StakeholderGoals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStakeholderGoals_Goals(), this.getGoal(), null, "goals", null, 0, -1, StakeholderGoals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reqDocumentEClass, ReqDocument.class, "ReqDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReqDocument_Content(), theEcorePackage.getEObject(), null, "content", null, 0, -1, ReqDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(documentSectionEClass, DocumentSection.class, "DocumentSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDocumentSection_Label(), theEcorePackage.getEString(), "label", null, 0, 1, DocumentSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDocumentSection_Title(), theEcorePackage.getEString(), "title", null, 0, 1, DocumentSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentSection_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, DocumentSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentSection_Content(), theEcorePackage.getEObject(), null, "content", null, 0, -1, DocumentSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requirementSetEClass, RequirementSet.class, "RequirementSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRequirementSet_ImportConstants(), this.getGlobalConstants(), null, "importConstants", null, 0, -1, RequirementSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirementSet_Constants(), theCommonPackage.getValDeclaration(), null, "constants", null, 0, -1, RequirementSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirementSet_Computes(), theCommonPackage.getAVariableDeclaration(), null, "computes", null, 0, -1, RequirementSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirementSet_Requirements(), this.getRequirement(), null, "requirements", null, 0, -1, RequirementSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirementSet_StakeholderGoals(), this.getReqRoot(), null, "stakeholderGoals", null, 0, -1, RequirementSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(goalEClass, Goal.class, "Goal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGoal_RefinesReference(), this.getGoal(), null, "refinesReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_ConflictsReference(), this.getGoal(), null, "conflictsReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_StakeholderReference(), theOrganizationPackage.getStakeholder(), null, "stakeholderReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requirementEClass, Requirement.class, "Requirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRequirement_Predicate(), this.getReqPredicate(), null, "predicate", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_Exception(), theEcorePackage.getEObject(), null, "exception", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRequirement_ExceptionText(), theEcorePackage.getEString(), "exceptionText", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_InheritsReference(), this.getRequirement(), null, "inheritsReference", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_Computes(), theCommonPackage.getAVariableDeclaration(), null, "computes", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_RefinesReference(), this.getRequirement(), null, "refinesReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_DecomposesReference(), this.getRequirement(), null, "decomposesReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_DevelopmentStakeholder(), theOrganizationPackage.getStakeholder(), null, "developmentStakeholder", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_RequirementReference(), this.getRequirement(), null, "requirementReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRequirement_ComponentCategory(), theAadl2Package.getComponentCategory(), "componentCategory", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRequirement_TargetType(), theCommonPackage.getTargetType(), "targetType", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(includeGlobalRequirementEClass, IncludeGlobalRequirement.class, "IncludeGlobalRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIncludeGlobalRequirement_Include(), theEcorePackage.getEObject(), null, "include", null, 0, 1, IncludeGlobalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIncludeGlobalRequirement_Local(), theEcorePackage.getEBoolean(), "local", null, 0, 1, IncludeGlobalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIncludeGlobalRequirement_TargetElement(), theAadl2Package.getNamedElement(), null, "targetElement", null, 0, 1, IncludeGlobalRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(whenConditionEClass, WhenCondition.class, "WhenCondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWhenCondition_InMode(), theAadl2Package.getMode(), null, "inMode", null, 0, -1, WhenCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWhenCondition_InErrorState(), theEcorePackage.getEObject(), null, "inErrorState", null, 0, -1, WhenCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getWhenCondition_Condition(), theEcorePackage.getEString(), "condition", null, 0, 1, WhenCondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reqPredicateEClass, ReqPredicate.class, "ReqPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(informalPredicateEClass, InformalPredicate.class, "InformalPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInformalPredicate_Description(), theEcorePackage.getEString(), "description", null, 0, 1, InformalPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valuePredicateEClass, ValuePredicate.class, "ValuePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValuePredicate_Xpression(), theAadl2Package.getPropertyExpression(), null, "xpression", null, 0, 1, ValuePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValuePredicate_DesiredValue(), this.getDesiredValue(), null, "desiredValue", null, 0, -1, ValuePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(desiredValueEClass, DesiredValue.class, "DesiredValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDesiredValue_Desired(), theCommonPackage.getAExpression(), null, "desired", null, 0, 1, DesiredValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDesiredValue_Upto(), theEcorePackage.getEBoolean(), "upto", null, 0, 1, DesiredValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDesiredValue_Value(), theAadl2Package.getPropertyExpression(), null, "value", null, 0, 1, DesiredValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(externalDocumentEClass, ExternalDocument.class, "ExternalDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExternalDocument_DocReference(), theEcorePackage.getEString(), "docReference", null, 0, 1, ExternalDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExternalDocument_DocFragment(), theEcorePackage.getEString(), "docFragment", null, 0, 1, ExternalDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(systemRequirementSetEClass, SystemRequirementSet.class, "SystemRequirementSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSystemRequirementSet_Target(), theAadl2Package.getComponentClassifier(), null, "target", null, 0, 1, SystemRequirementSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSystemRequirementSet_Include(), this.getIncludeGlobalRequirement(), null, "include", null, 0, -1, SystemRequirementSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(globalRequirementSetEClass, GlobalRequirementSet.class, "GlobalRequirementSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(reqValDeclarationEClass, ReqValDeclaration.class, "ReqValDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getReqValDeclaration_Property(), theAadl2Package.getPropertyType(), null, "property", null, 0, 1, ReqValDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ReqSpecPackageImpl
