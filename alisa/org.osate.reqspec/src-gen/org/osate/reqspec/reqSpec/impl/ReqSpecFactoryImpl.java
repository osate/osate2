/**
 * *
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
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
      case ReqSpecPackage.GLOBAL_CONSTANTS: return createGlobalConstants();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT: return createContractualElement();
      case ReqSpecPackage.REQ_ROOT: return createReqRoot();
      case ReqSpecPackage.STAKEHOLDER_GOALS: return createStakeholderGoals();
      case ReqSpecPackage.REQ_DOCUMENT: return createReqDocument();
      case ReqSpecPackage.DOCUMENT_SECTION: return createDocumentSection();
      case ReqSpecPackage.REQUIREMENT_SET: return createRequirementSet();
      case ReqSpecPackage.GOAL: return createGoal();
      case ReqSpecPackage.REQUIREMENT: return createRequirement();
      case ReqSpecPackage.INCLUDE_GLOBAL_REQUIREMENT: return createIncludeGlobalRequirement();
      case ReqSpecPackage.WHEN_CONDITION: return createWhenCondition();
      case ReqSpecPackage.REQ_PREDICATE: return createReqPredicate();
      case ReqSpecPackage.INFORMAL_PREDICATE: return createInformalPredicate();
      case ReqSpecPackage.VALUE_PREDICATE: return createValuePredicate();
      case ReqSpecPackage.DESIRED_VALUE: return createDesiredValue();
      case ReqSpecPackage.EXTERNAL_DOCUMENT: return createExternalDocument();
      case ReqSpecPackage.SYSTEM_REQUIREMENT_SET: return createSystemRequirementSet();
      case ReqSpecPackage.GLOBAL_REQUIREMENT_SET: return createGlobalRequirementSet();
      case ReqSpecPackage.REQ_VAL_DECLARATION: return createReqValDeclaration();
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
  public RequirementSet createRequirementSet()
  {
    RequirementSetImpl requirementSet = new RequirementSetImpl();
    return requirementSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
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
  @Override
  public SystemRequirementSet createSystemRequirementSet()
  {
    SystemRequirementSetImpl systemRequirementSet = new SystemRequirementSetImpl();
    return systemRequirementSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public GlobalRequirementSet createGlobalRequirementSet()
  {
    GlobalRequirementSetImpl globalRequirementSet = new GlobalRequirementSetImpl();
    return globalRequirementSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ReqValDeclaration createReqValDeclaration()
  {
    ReqValDeclarationImpl reqValDeclaration = new ReqValDeclarationImpl();
    return reqValDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
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
