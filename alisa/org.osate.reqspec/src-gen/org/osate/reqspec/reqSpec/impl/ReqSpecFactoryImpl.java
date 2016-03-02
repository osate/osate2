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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
      case ReqSpecPackage.GLOBAL_CONSTANTS: return createGlobalConstants();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT: return createContractualElement();
      case ReqSpecPackage.REQ_ROOT: return createReqRoot();
      case ReqSpecPackage.STAKEHOLDER_GOALS: return createStakeholderGoals();
      case ReqSpecPackage.REQ_DOCUMENT: return createReqDocument();
      case ReqSpecPackage.DOCUMENT_SECTION: return createDocumentSection();
      case ReqSpecPackage.REQUIREMENTS: return createRequirements();
      case ReqSpecPackage.GOAL: return createGoal();
      case ReqSpecPackage.REQUIREMENT: return createRequirement();
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT: return createIncludeGlobalRequirement();
      case ReqSpecPackage.WHEN_CONDITION: return createWhenCondition();
      case ReqSpecPackage.REQ_PREDICATE: return createReqPredicate();
      case ReqSpecPackage.INFORMAL_PREDICATE: return createInformalPredicate();
      case ReqSpecPackage.PREDICATE: return createPredicate();
      case ReqSpecPackage.VALUE_PREDICATE: return createValuePredicate();
      case ReqSpecPackage.DESIRED_VALUE: return createDesiredValue();
      case ReqSpecPackage.EXTERNAL_DOCUMENT: return createExternalDocument();
      case ReqSpecPackage.SYSTEM_REQUIREMENTS: return createSystemRequirements();
      case ReqSpecPackage.GLOBAL_REQUIREMENTS: return createGlobalRequirements();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ReqSpecPackage.REQ_KIND:
        return createReqKindFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ReqSpecPackage.REQ_KIND:
        return convertReqKindToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
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
  public GlobalConstants createGlobalConstants()
  {
    GlobalConstantsImpl globalConstants = new GlobalConstantsImpl();
    return globalConstants;
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
  public Requirements createRequirements()
  {
    RequirementsImpl requirements = new RequirementsImpl();
    return requirements;
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
  public IncludeGlobalRequirement createIncludeGlobalRequirement()
  {
    IncludeGlobalRequirementImpl includeGlobalRequirement = new IncludeGlobalRequirementImpl();
    return includeGlobalRequirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhenCondition createWhenCondition()
  {
    WhenConditionImpl whenCondition = new WhenConditionImpl();
    return whenCondition;
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
  public Predicate createPredicate()
  {
    PredicateImpl predicate = new PredicateImpl();
    return predicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValuePredicate createValuePredicate()
  {
    ValuePredicateImpl valuePredicate = new ValuePredicateImpl();
    return valuePredicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DesiredValue createDesiredValue()
  {
    DesiredValueImpl desiredValue = new DesiredValueImpl();
    return desiredValue;
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
  public SystemRequirements createSystemRequirements()
  {
    SystemRequirementsImpl systemRequirements = new SystemRequirementsImpl();
    return systemRequirements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GlobalRequirements createGlobalRequirements()
  {
    GlobalRequirementsImpl globalRequirements = new GlobalRequirementsImpl();
    return globalRequirements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqKind createReqKindFromString(EDataType eDataType, String initialValue)
  {
    ReqKind result = ReqKind.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertReqKindToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
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
