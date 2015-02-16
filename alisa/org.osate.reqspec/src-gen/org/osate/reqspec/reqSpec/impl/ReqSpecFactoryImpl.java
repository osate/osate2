/**
 */
package org.osate.reqspec.reqSpec.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.reqspec.reqSpec.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReqSpecFactoryImpl extends EFactoryImpl implements ReqSpecFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ReqSpecFactory init()
  {
    try
    {
      ReqSpecFactory theReqSpecFactory = (ReqSpecFactory)EPackage.Registry.INSTANCE.getEFactory(ReqSpecPackage.eNS_URI);
      if (theReqSpecFactory != null)
      {
        return theReqSpecFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ReqSpecFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecFactoryImpl()
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
      case ReqSpecPackage.REQ_SPEC: return createReqSpec();
      case ReqSpecPackage.REQ_SPEC_CONTAINER: return createReqSpecContainer();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT: return createContractualElement();
      case ReqSpecPackage.REQ_ROOT: return createReqRoot();
      case ReqSpecPackage.STAKEHOLDER_GOALS: return createStakeholderGoals();
      case ReqSpecPackage.REQ_DOCUMENT: return createReqDocument();
      case ReqSpecPackage.DOCUMENT_SECTION: return createDocumentSection();
      case ReqSpecPackage.REQ_SPECS: return createReqSpecs();
      case ReqSpecPackage.REQ_SPEC_FOLDER: return createReqSpecFolder();
      case ReqSpecPackage.GOAL_FOLDER: return createGoalFolder();
      case ReqSpecPackage.GOAL: return createGoal();
      case ReqSpecPackage.REQUIREMENT: return createRequirement();
      case ReqSpecPackage.REQ_PREDICATE: return createReqPredicate();
      case ReqSpecPackage.INFORMAL_PREDICATE: return createInformalPredicate();
      case ReqSpecPackage.XPREDICATE: return createXPredicate();
      case ReqSpecPackage.VALUE_ASSERTION: return createValueAssertion();
      case ReqSpecPackage.INPUT_ASSUMPTION: return createInputAssumption();
      case ReqSpecPackage.OUTPUT_GUARANTEE: return createOutputGuarantee();
      case ReqSpecPackage.BEHAVIOR_EQUATION: return createBehaviorEquation();
      case ReqSpecPackage.SPE_AR_PREDICATE: return createSPeARPredicate();
      case ReqSpecPackage.EXTERNAL_DOCUMENT: return createExternalDocument();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpec createReqSpec()
  {
    ReqSpecImpl reqSpec = new ReqSpecImpl();
    return reqSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecContainer createReqSpecContainer()
  {
    ReqSpecContainerImpl reqSpecContainer = new ReqSpecContainerImpl();
    return reqSpecContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContractualElement createContractualElement()
  {
    ContractualElementImpl contractualElement = new ContractualElementImpl();
    return contractualElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqRoot createReqRoot()
  {
    ReqRootImpl reqRoot = new ReqRootImpl();
    return reqRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StakeholderGoals createStakeholderGoals()
  {
    StakeholderGoalsImpl stakeholderGoals = new StakeholderGoalsImpl();
    return stakeholderGoals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqDocument createReqDocument()
  {
    ReqDocumentImpl reqDocument = new ReqDocumentImpl();
    return reqDocument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DocumentSection createDocumentSection()
  {
    DocumentSectionImpl documentSection = new DocumentSectionImpl();
    return documentSection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecs createReqSpecs()
  {
    ReqSpecsImpl reqSpecs = new ReqSpecsImpl();
    return reqSpecs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecFolder createReqSpecFolder()
  {
    ReqSpecFolderImpl reqSpecFolder = new ReqSpecFolderImpl();
    return reqSpecFolder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GoalFolder createGoalFolder()
  {
    GoalFolderImpl goalFolder = new GoalFolderImpl();
    return goalFolder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Goal createGoal()
  {
    GoalImpl goal = new GoalImpl();
    return goal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Requirement createRequirement()
  {
    RequirementImpl requirement = new RequirementImpl();
    return requirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqPredicate createReqPredicate()
  {
    ReqPredicateImpl reqPredicate = new ReqPredicateImpl();
    return reqPredicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InformalPredicate createInformalPredicate()
  {
    InformalPredicateImpl informalPredicate = new InformalPredicateImpl();
    return informalPredicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XPredicate createXPredicate()
  {
    XPredicateImpl xPredicate = new XPredicateImpl();
    return xPredicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueAssertion createValueAssertion()
  {
    ValueAssertionImpl valueAssertion = new ValueAssertionImpl();
    return valueAssertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InputAssumption createInputAssumption()
  {
    InputAssumptionImpl inputAssumption = new InputAssumptionImpl();
    return inputAssumption;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutputGuarantee createOutputGuarantee()
  {
    OutputGuaranteeImpl outputGuarantee = new OutputGuaranteeImpl();
    return outputGuarantee;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehaviorEquation createBehaviorEquation()
  {
    BehaviorEquationImpl behaviorEquation = new BehaviorEquationImpl();
    return behaviorEquation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SPeARPredicate createSPeARPredicate()
  {
    SPeARPredicateImpl sPeARPredicate = new SPeARPredicateImpl();
    return sPeARPredicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalDocument createExternalDocument()
  {
    ExternalDocumentImpl externalDocument = new ExternalDocumentImpl();
    return externalDocument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecPackage getReqSpecPackage()
  {
    return (ReqSpecPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ReqSpecPackage getPackage()
  {
    return ReqSpecPackage.eINSTANCE;
  }

} //ReqSpecFactoryImpl
