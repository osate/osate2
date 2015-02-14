/**
 */
package org.osate.reqspec.reqSpec.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.xbase.XbasePackage;

import org.osate.aadl2.Aadl2Package;

import org.osate.alisa.common.common.CommonPackage;

import org.osate.categories.categories.CategoriesPackage;

import org.osate.organization.organization.OrganizationPackage;

import org.osate.reqspec.reqSpec.BehaviorEquation;
import org.osate.reqspec.reqSpec.ContractualElement;
import org.osate.reqspec.reqSpec.DocumentSection;
import org.osate.reqspec.reqSpec.ExternalDocument;
import org.osate.reqspec.reqSpec.Goal;
import org.osate.reqspec.reqSpec.GoalFolder;
import org.osate.reqspec.reqSpec.InformalPredicate;
import org.osate.reqspec.reqSpec.InputAssumption;
import org.osate.reqspec.reqSpec.OutputGuarantee;
import org.osate.reqspec.reqSpec.ReqDocument;
import org.osate.reqspec.reqSpec.ReqPredicate;
import org.osate.reqspec.reqSpec.ReqRoot;
import org.osate.reqspec.reqSpec.ReqSpec;
import org.osate.reqspec.reqSpec.ReqSpecContainer;
import org.osate.reqspec.reqSpec.ReqSpecFactory;
import org.osate.reqspec.reqSpec.ReqSpecFolder;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.ReqSpecs;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.reqspec.reqSpec.SPeARPredicate;
import org.osate.reqspec.reqSpec.StakeholderGoals;
import org.osate.reqspec.reqSpec.ValToPropertyMapping;
import org.osate.reqspec.reqSpec.ValueAssertion;
import org.osate.reqspec.reqSpec.XPredicate;

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
  private EClass reqSpecContainerEClass = null;

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
  private EClass reqSpecsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass reqSpecFolderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass goalFolderEClass = null;

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
  private EClass xPredicateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueAssertionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inputAssumptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outputGuaranteeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass behaviorEquationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass sPeARPredicateEClass = null;

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
  private EClass valToPropertyMappingEClass = null;

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
    ReqSpecPackageImpl theReqSpecPackage = (ReqSpecPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ReqSpecPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ReqSpecPackageImpl());

    isInited = true;

    // Initialize simple dependencies
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
  public EClass getReqSpec()
  {
    return reqSpecEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReqSpecContainer()
  {
    return reqSpecContainerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContractualElement()
  {
    return contractualElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractualElement_Name()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractualElement_Title()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractualElement_Target()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractualElement_TargetDescription()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractualElement_Category()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractualElement_Description()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getContractualElement_Rationale()
  {
    return (EAttribute)contractualElementEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractualElement_DocumentRequirement()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContractualElement_DocReference()
  {
    return (EReference)contractualElementEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReqRoot()
  {
    return reqRootEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStakeholderGoals()
  {
    return stakeholderGoalsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStakeholderGoals_Name()
  {
    return (EAttribute)stakeholderGoalsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStakeholderGoals_Title()
  {
    return (EAttribute)stakeholderGoalsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStakeholderGoals_Target()
  {
    return (EReference)stakeholderGoalsEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStakeholderGoals_TargetDescription()
  {
    return (EAttribute)stakeholderGoalsEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStakeholderGoals_Description()
  {
    return (EReference)stakeholderGoalsEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStakeholderGoals_Content()
  {
    return (EReference)stakeholderGoalsEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReqDocument()
  {
    return reqDocumentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReqDocument_Name()
  {
    return (EAttribute)reqDocumentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReqDocument_Title()
  {
    return (EAttribute)reqDocumentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReqDocument_Description()
  {
    return (EReference)reqDocumentEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReqDocument_Content()
  {
    return (EReference)reqDocumentEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDocumentSection()
  {
    return documentSectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDocumentSection_Label()
  {
    return (EAttribute)documentSectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDocumentSection_Title()
  {
    return (EAttribute)documentSectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentSection_Description()
  {
    return (EReference)documentSectionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDocumentSection_Content()
  {
    return (EReference)documentSectionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReqSpecs()
  {
    return reqSpecsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReqSpecs_Name()
  {
    return (EAttribute)reqSpecsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReqSpecs_Title()
  {
    return (EAttribute)reqSpecsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReqSpecs_Target()
  {
    return (EReference)reqSpecsEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReqSpecs_Otherreqspecs()
  {
    return (EReference)reqSpecsEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReqSpecs_Constants()
  {
    return (EReference)reqSpecsEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReqSpecs_Computes()
  {
    return (EReference)reqSpecsEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReqSpecs_Content()
  {
    return (EReference)reqSpecsEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReqSpecFolder()
  {
    return reqSpecFolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReqSpecFolder_Label()
  {
    return (EAttribute)reqSpecFolderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getReqSpecFolder_Title()
  {
    return (EAttribute)reqSpecFolderEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getReqSpecFolder_Content()
  {
    return (EReference)reqSpecFolderEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGoalFolder()
  {
    return goalFolderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGoalFolder_Label()
  {
    return (EAttribute)goalFolderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getGoalFolder_Title()
  {
    return (EAttribute)goalFolderEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoalFolder_Content()
  {
    return (EReference)goalFolderEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGoal()
  {
    return goalEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_RefinesReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_ConflictsReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGoal_StakeholderReference()
  {
    return (EReference)goalEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRequirement()
  {
    return requirementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_Constants()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_Computes()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_Predicate()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_Exception()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRequirement_ExceptionText()
  {
    return (EAttribute)requirementEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_RefinedReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_GoalReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRequirement_StakeholderRequirementReference()
  {
    return (EReference)requirementEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReqPredicate()
  {
    return reqPredicateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInformalPredicate()
  {
    return informalPredicateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInformalPredicate_Description()
  {
    return (EAttribute)informalPredicateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getXPredicate()
  {
    return xPredicateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getXPredicate_Xpression()
  {
    return (EReference)xPredicateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValueAssertion()
  {
    return valueAssertionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueAssertion_Xpression()
  {
    return (EReference)valueAssertionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueAssertion_ValToPropertyMappings()
  {
    return (EReference)valueAssertionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInputAssumption()
  {
    return inputAssumptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInputAssumption_Xpression()
  {
    return (EReference)inputAssumptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInputAssumption_Reference()
  {
    return (EReference)inputAssumptionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutputGuarantee()
  {
    return outputGuaranteeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutputGuarantee_Xpression()
  {
    return (EReference)outputGuaranteeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutputGuarantee_Reference()
  {
    return (EReference)outputGuaranteeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBehaviorEquation()
  {
    return behaviorEquationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBehaviorEquation_Xpression()
  {
    return (EReference)behaviorEquationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBehaviorEquation_Reference()
  {
    return (EReference)behaviorEquationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSPeARPredicate()
  {
    return sPeARPredicateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSPeARPredicate_Predicate()
  {
    return (EAttribute)sPeARPredicateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExternalDocument()
  {
    return externalDocumentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExternalDocument_DocReference()
  {
    return (EAttribute)externalDocumentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExternalDocument_DocFragment()
  {
    return (EAttribute)externalDocumentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValToPropertyMapping()
  {
    return valToPropertyMappingEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValToPropertyMapping_Constant()
  {
    return (EReference)valToPropertyMappingEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValToPropertyMapping_Property()
  {
    return (EReference)valToPropertyMappingEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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

    reqSpecContainerEClass = createEClass(REQ_SPEC_CONTAINER);

    contractualElementEClass = createEClass(CONTRACTUAL_ELEMENT);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__NAME);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__TITLE);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__TARGET);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__CATEGORY);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__DESCRIPTION);
    createEAttribute(contractualElementEClass, CONTRACTUAL_ELEMENT__RATIONALE);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__DOCUMENT_REQUIREMENT);
    createEReference(contractualElementEClass, CONTRACTUAL_ELEMENT__DOC_REFERENCE);

    reqRootEClass = createEClass(REQ_ROOT);

    stakeholderGoalsEClass = createEClass(STAKEHOLDER_GOALS);
    createEAttribute(stakeholderGoalsEClass, STAKEHOLDER_GOALS__NAME);
    createEAttribute(stakeholderGoalsEClass, STAKEHOLDER_GOALS__TITLE);
    createEReference(stakeholderGoalsEClass, STAKEHOLDER_GOALS__TARGET);
    createEAttribute(stakeholderGoalsEClass, STAKEHOLDER_GOALS__TARGET_DESCRIPTION);
    createEReference(stakeholderGoalsEClass, STAKEHOLDER_GOALS__DESCRIPTION);
    createEReference(stakeholderGoalsEClass, STAKEHOLDER_GOALS__CONTENT);

    reqDocumentEClass = createEClass(REQ_DOCUMENT);
    createEAttribute(reqDocumentEClass, REQ_DOCUMENT__NAME);
    createEAttribute(reqDocumentEClass, REQ_DOCUMENT__TITLE);
    createEReference(reqDocumentEClass, REQ_DOCUMENT__DESCRIPTION);
    createEReference(reqDocumentEClass, REQ_DOCUMENT__CONTENT);

    documentSectionEClass = createEClass(DOCUMENT_SECTION);
    createEAttribute(documentSectionEClass, DOCUMENT_SECTION__LABEL);
    createEAttribute(documentSectionEClass, DOCUMENT_SECTION__TITLE);
    createEReference(documentSectionEClass, DOCUMENT_SECTION__DESCRIPTION);
    createEReference(documentSectionEClass, DOCUMENT_SECTION__CONTENT);

    reqSpecsEClass = createEClass(REQ_SPECS);
    createEAttribute(reqSpecsEClass, REQ_SPECS__NAME);
    createEAttribute(reqSpecsEClass, REQ_SPECS__TITLE);
    createEReference(reqSpecsEClass, REQ_SPECS__TARGET);
    createEReference(reqSpecsEClass, REQ_SPECS__OTHERREQSPECS);
    createEReference(reqSpecsEClass, REQ_SPECS__CONSTANTS);
    createEReference(reqSpecsEClass, REQ_SPECS__COMPUTES);
    createEReference(reqSpecsEClass, REQ_SPECS__CONTENT);

    reqSpecFolderEClass = createEClass(REQ_SPEC_FOLDER);
    createEAttribute(reqSpecFolderEClass, REQ_SPEC_FOLDER__LABEL);
    createEAttribute(reqSpecFolderEClass, REQ_SPEC_FOLDER__TITLE);
    createEReference(reqSpecFolderEClass, REQ_SPEC_FOLDER__CONTENT);

    goalFolderEClass = createEClass(GOAL_FOLDER);
    createEAttribute(goalFolderEClass, GOAL_FOLDER__LABEL);
    createEAttribute(goalFolderEClass, GOAL_FOLDER__TITLE);
    createEReference(goalFolderEClass, GOAL_FOLDER__CONTENT);

    goalEClass = createEClass(GOAL);
    createEReference(goalEClass, GOAL__REFINES_REFERENCE);
    createEReference(goalEClass, GOAL__CONFLICTS_REFERENCE);
    createEReference(goalEClass, GOAL__STAKEHOLDER_REFERENCE);

    requirementEClass = createEClass(REQUIREMENT);
    createEReference(requirementEClass, REQUIREMENT__CONSTANTS);
    createEReference(requirementEClass, REQUIREMENT__COMPUTES);
    createEReference(requirementEClass, REQUIREMENT__PREDICATE);
    createEReference(requirementEClass, REQUIREMENT__EXCEPTION);
    createEAttribute(requirementEClass, REQUIREMENT__EXCEPTION_TEXT);
    createEReference(requirementEClass, REQUIREMENT__REFINED_REFERENCE);
    createEReference(requirementEClass, REQUIREMENT__GOAL_REFERENCE);
    createEReference(requirementEClass, REQUIREMENT__STAKEHOLDER_REQUIREMENT_REFERENCE);

    reqPredicateEClass = createEClass(REQ_PREDICATE);

    informalPredicateEClass = createEClass(INFORMAL_PREDICATE);
    createEAttribute(informalPredicateEClass, INFORMAL_PREDICATE__DESCRIPTION);

    xPredicateEClass = createEClass(XPREDICATE);
    createEReference(xPredicateEClass, XPREDICATE__XPRESSION);

    valueAssertionEClass = createEClass(VALUE_ASSERTION);
    createEReference(valueAssertionEClass, VALUE_ASSERTION__XPRESSION);
    createEReference(valueAssertionEClass, VALUE_ASSERTION__VAL_TO_PROPERTY_MAPPINGS);

    inputAssumptionEClass = createEClass(INPUT_ASSUMPTION);
    createEReference(inputAssumptionEClass, INPUT_ASSUMPTION__XPRESSION);
    createEReference(inputAssumptionEClass, INPUT_ASSUMPTION__REFERENCE);

    outputGuaranteeEClass = createEClass(OUTPUT_GUARANTEE);
    createEReference(outputGuaranteeEClass, OUTPUT_GUARANTEE__XPRESSION);
    createEReference(outputGuaranteeEClass, OUTPUT_GUARANTEE__REFERENCE);

    behaviorEquationEClass = createEClass(BEHAVIOR_EQUATION);
    createEReference(behaviorEquationEClass, BEHAVIOR_EQUATION__XPRESSION);
    createEReference(behaviorEquationEClass, BEHAVIOR_EQUATION__REFERENCE);

    sPeARPredicateEClass = createEClass(SPE_AR_PREDICATE);
    createEAttribute(sPeARPredicateEClass, SPE_AR_PREDICATE__PREDICATE);

    externalDocumentEClass = createEClass(EXTERNAL_DOCUMENT);
    createEAttribute(externalDocumentEClass, EXTERNAL_DOCUMENT__DOC_REFERENCE);
    createEAttribute(externalDocumentEClass, EXTERNAL_DOCUMENT__DOC_FRAGMENT);

    valToPropertyMappingEClass = createEClass(VAL_TO_PROPERTY_MAPPING);
    createEReference(valToPropertyMappingEClass, VAL_TO_PROPERTY_MAPPING__CONSTANT);
    createEReference(valToPropertyMappingEClass, VAL_TO_PROPERTY_MAPPING__PROPERTY);
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
    CategoriesPackage theCategoriesPackage = (CategoriesPackage)EPackage.Registry.INSTANCE.getEPackage(CategoriesPackage.eNS_URI);
    CommonPackage theCommonPackage = (CommonPackage)EPackage.Registry.INSTANCE.getEPackage(CommonPackage.eNS_URI);
    XbasePackage theXbasePackage = (XbasePackage)EPackage.Registry.INSTANCE.getEPackage(XbasePackage.eNS_URI);
    OrganizationPackage theOrganizationPackage = (OrganizationPackage)EPackage.Registry.INSTANCE.getEPackage(OrganizationPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    stakeholderGoalsEClass.getESuperTypes().add(this.getReqSpec());
    stakeholderGoalsEClass.getESuperTypes().add(this.getReqSpecContainer());
    stakeholderGoalsEClass.getESuperTypes().add(this.getReqRoot());
    reqDocumentEClass.getESuperTypes().add(this.getReqSpec());
    reqDocumentEClass.getESuperTypes().add(this.getReqSpecContainer());
    reqDocumentEClass.getESuperTypes().add(this.getReqRoot());
    reqSpecsEClass.getESuperTypes().add(this.getReqSpec());
    reqSpecsEClass.getESuperTypes().add(this.getReqSpecContainer());
    reqSpecsEClass.getESuperTypes().add(this.getReqRoot());
    reqSpecFolderEClass.getESuperTypes().add(this.getReqSpecContainer());
    goalFolderEClass.getESuperTypes().add(this.getReqSpecContainer());
    goalEClass.getESuperTypes().add(this.getContractualElement());
    requirementEClass.getESuperTypes().add(this.getContractualElement());
    informalPredicateEClass.getESuperTypes().add(this.getReqPredicate());
    xPredicateEClass.getESuperTypes().add(this.getReqPredicate());
    valueAssertionEClass.getESuperTypes().add(this.getReqPredicate());
    inputAssumptionEClass.getESuperTypes().add(this.getReqPredicate());
    outputGuaranteeEClass.getESuperTypes().add(this.getReqPredicate());
    behaviorEquationEClass.getESuperTypes().add(this.getReqPredicate());
    sPeARPredicateEClass.getESuperTypes().add(this.getReqPredicate());

    // Initialize classes and features; add operations and parameters
    initEClass(reqSpecEClass, ReqSpec.class, "ReqSpec", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(reqSpecContainerEClass, ReqSpecContainer.class, "ReqSpecContainer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(contractualElementEClass, ContractualElement.class, "ContractualElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getContractualElement_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContractualElement_Title(), theEcorePackage.getEString(), "title", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_Target(), theAadl2Package.getNamedElement(), null, "target", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContractualElement_TargetDescription(), theEcorePackage.getEString(), "targetDescription", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_Category(), theCategoriesPackage.getRequirementCategory(), null, "category", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getContractualElement_Rationale(), theEcorePackage.getEString(), "rationale", null, 0, 1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_DocumentRequirement(), this.getContractualElement(), null, "documentRequirement", null, 0, -1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContractualElement_DocReference(), this.getExternalDocument(), null, "docReference", null, 0, -1, ContractualElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reqRootEClass, ReqRoot.class, "ReqRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stakeholderGoalsEClass, StakeholderGoals.class, "StakeholderGoals", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStakeholderGoals_Name(), theEcorePackage.getEString(), "name", null, 0, 1, StakeholderGoals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStakeholderGoals_Title(), theEcorePackage.getEString(), "title", null, 0, 1, StakeholderGoals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStakeholderGoals_Target(), theAadl2Package.getClassifier(), null, "target", null, 0, 1, StakeholderGoals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStakeholderGoals_TargetDescription(), theEcorePackage.getEString(), "targetDescription", null, 0, 1, StakeholderGoals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStakeholderGoals_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, StakeholderGoals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStakeholderGoals_Content(), theEcorePackage.getEObject(), null, "content", null, 0, -1, StakeholderGoals.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reqDocumentEClass, ReqDocument.class, "ReqDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReqDocument_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ReqDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReqDocument_Title(), theEcorePackage.getEString(), "title", null, 0, 1, ReqDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReqDocument_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, ReqDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReqDocument_Content(), this.getDocumentSection(), null, "content", null, 0, -1, ReqDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(documentSectionEClass, DocumentSection.class, "DocumentSection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDocumentSection_Label(), theEcorePackage.getEString(), "label", null, 0, 1, DocumentSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDocumentSection_Title(), theEcorePackage.getEString(), "title", null, 0, 1, DocumentSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentSection_Description(), theCommonPackage.getDescription(), null, "description", null, 0, 1, DocumentSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDocumentSection_Content(), theEcorePackage.getEObject(), null, "content", null, 0, -1, DocumentSection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reqSpecsEClass, ReqSpecs.class, "ReqSpecs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReqSpecs_Name(), theEcorePackage.getEString(), "name", null, 0, 1, ReqSpecs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReqSpecs_Title(), theEcorePackage.getEString(), "title", null, 0, 1, ReqSpecs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReqSpecs_Target(), theAadl2Package.getClassifier(), null, "target", null, 0, 1, ReqSpecs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReqSpecs_Otherreqspecs(), this.getReqSpecs(), null, "otherreqspecs", null, 0, -1, ReqSpecs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReqSpecs_Constants(), theXbasePackage.getXExpression(), null, "constants", null, 0, -1, ReqSpecs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReqSpecs_Computes(), theCommonPackage.getComputeDeclaration(), null, "computes", null, 0, -1, ReqSpecs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReqSpecs_Content(), theEcorePackage.getEObject(), null, "content", null, 0, -1, ReqSpecs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reqSpecFolderEClass, ReqSpecFolder.class, "ReqSpecFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getReqSpecFolder_Label(), theEcorePackage.getEString(), "label", null, 0, 1, ReqSpecFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getReqSpecFolder_Title(), theEcorePackage.getEString(), "title", null, 0, 1, ReqSpecFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getReqSpecFolder_Content(), theEcorePackage.getEObject(), null, "content", null, 0, -1, ReqSpecFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(goalFolderEClass, GoalFolder.class, "GoalFolder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getGoalFolder_Label(), theEcorePackage.getEString(), "label", null, 0, 1, GoalFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getGoalFolder_Title(), theEcorePackage.getEString(), "title", null, 0, 1, GoalFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoalFolder_Content(), theEcorePackage.getEObject(), null, "content", null, 0, -1, GoalFolder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(goalEClass, Goal.class, "Goal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGoal_RefinesReference(), this.getGoal(), null, "refinesReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_ConflictsReference(), this.getGoal(), null, "conflictsReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGoal_StakeholderReference(), theOrganizationPackage.getStakeholder(), null, "stakeholderReference", null, 0, -1, Goal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requirementEClass, Requirement.class, "Requirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRequirement_Constants(), theXbasePackage.getXExpression(), null, "constants", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_Computes(), theCommonPackage.getComputeDeclaration(), null, "computes", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_Predicate(), this.getReqPredicate(), null, "predicate", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_Exception(), theEcorePackage.getEObject(), null, "exception", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRequirement_ExceptionText(), theEcorePackage.getEString(), "exceptionText", null, 0, 1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_RefinedReference(), this.getRequirement(), null, "refinedReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_GoalReference(), this.getGoal(), null, "goalReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRequirement_StakeholderRequirementReference(), this.getGoal(), null, "stakeholderRequirementReference", null, 0, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(reqPredicateEClass, ReqPredicate.class, "ReqPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(informalPredicateEClass, InformalPredicate.class, "InformalPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getInformalPredicate_Description(), theEcorePackage.getEString(), "description", null, 0, 1, InformalPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(xPredicateEClass, XPredicate.class, "XPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getXPredicate_Xpression(), theXbasePackage.getXExpression(), null, "xpression", null, 0, 1, XPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueAssertionEClass, ValueAssertion.class, "ValueAssertion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValueAssertion_Xpression(), theXbasePackage.getXExpression(), null, "xpression", null, 0, 1, ValueAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueAssertion_ValToPropertyMappings(), this.getValToPropertyMapping(), null, "valToPropertyMappings", null, 0, -1, ValueAssertion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inputAssumptionEClass, InputAssumption.class, "InputAssumption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInputAssumption_Xpression(), theXbasePackage.getXExpression(), null, "xpression", null, 0, 1, InputAssumption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInputAssumption_Reference(), theEcorePackage.getEObject(), null, "reference", null, 0, 1, InputAssumption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(outputGuaranteeEClass, OutputGuarantee.class, "OutputGuarantee", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOutputGuarantee_Xpression(), theXbasePackage.getXExpression(), null, "xpression", null, 0, 1, OutputGuarantee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOutputGuarantee_Reference(), theEcorePackage.getEObject(), null, "reference", null, 0, 1, OutputGuarantee.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(behaviorEquationEClass, BehaviorEquation.class, "BehaviorEquation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBehaviorEquation_Xpression(), theXbasePackage.getXExpression(), null, "xpression", null, 0, 1, BehaviorEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBehaviorEquation_Reference(), theEcorePackage.getEObject(), null, "reference", null, 0, 1, BehaviorEquation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(sPeARPredicateEClass, SPeARPredicate.class, "SPeARPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSPeARPredicate_Predicate(), theEcorePackage.getEString(), "predicate", null, 0, 1, SPeARPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(externalDocumentEClass, ExternalDocument.class, "ExternalDocument", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExternalDocument_DocReference(), theEcorePackage.getEString(), "docReference", null, 0, 1, ExternalDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getExternalDocument_DocFragment(), theEcorePackage.getEString(), "docFragment", null, 0, 1, ExternalDocument.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valToPropertyMappingEClass, ValToPropertyMapping.class, "ValToPropertyMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValToPropertyMapping_Constant(), theXbasePackage.getXVariableDeclaration(), null, "constant", null, 0, 1, ValToPropertyMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValToPropertyMapping_Property(), theAadl2Package.getProperty(), null, "property", null, 0, 1, ValToPropertyMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //ReqSpecPackageImpl
