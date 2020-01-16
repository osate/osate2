/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.osate.alisa.common.common.CommonPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.osate.reqspec.reqSpec.ReqSpecFactory
 * @model kind="package"
 * @generated
 */
public interface ReqSpecPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "reqSpec";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/reqspec/ReqSpec";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "reqSpec";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ReqSpecPackage eINSTANCE = org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ReqSpecImpl <em>Req Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqSpec()
   * @generated
   */
  int REQ_SPEC = 0;

  /**
   * The feature id for the '<em><b>Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC__PARTS = 0;

  /**
   * The number of structural features of the '<em>Req Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.GlobalConstantsImpl <em>Global Constants</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.GlobalConstantsImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGlobalConstants()
   * @generated
   */
  int GLOBAL_CONSTANTS = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_CONSTANTS__NAME = 0;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_CONSTANTS__CONSTANTS = 1;

  /**
   * The number of structural features of the '<em>Global Constants</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_CONSTANTS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl <em>Contractual Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ContractualElementImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getContractualElement()
   * @generated
   */
  int CONTRACTUAL_ELEMENT = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__NAME = 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__TITLE = 1;

  /**
   * The feature id for the '<em><b>Target Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__TARGET = 3;

  /**
   * The feature id for the '<em><b>Target Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__TARGET_ELEMENT = 4;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__CATEGORY = 5;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__DESCRIPTION = 6;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__CONSTANTS = 7;

  /**
   * The feature id for the '<em><b>Whencondition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__WHENCONDITION = 8;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__RATIONALE = 9;

  /**
   * The feature id for the '<em><b>Change Uncertainty</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY = 10;

  /**
   * The feature id for the '<em><b>Evolves Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__EVOLVES_REFERENCE = 11;

  /**
   * The feature id for the '<em><b>Dropped</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__DROPPED = 12;

  /**
   * The feature id for the '<em><b>Drop Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__DROP_RATIONALE = 13;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__DOC_REFERENCE = 14;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__ISSUES = 15;

  /**
   * The feature id for the '<em><b>Goal Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__GOAL_REFERENCE = 16;

  /**
   * The number of structural features of the '<em>Contractual Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT_FEATURE_COUNT = 17;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ReqRootImpl <em>Req Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ReqRootImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqRoot()
   * @generated
   */
  int REQ_ROOT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_ROOT__NAME = 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_ROOT__TITLE = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_ROOT__DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_ROOT__DOC_REFERENCE = 3;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_ROOT__ISSUES = 4;

  /**
   * The number of structural features of the '<em>Req Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_ROOT_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl <em>Stakeholder Goals</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getStakeholderGoals()
   * @generated
   */
  int STAKEHOLDER_GOALS = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__NAME = REQ_ROOT__NAME;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__TITLE = REQ_ROOT__TITLE;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__DESCRIPTION = REQ_ROOT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__DOC_REFERENCE = REQ_ROOT__DOC_REFERENCE;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__ISSUES = REQ_ROOT__ISSUES;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__TARGET = REQ_ROOT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Component Category</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__COMPONENT_CATEGORY = REQ_ROOT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Import Constants</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__IMPORT_CONSTANTS = REQ_ROOT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__CONSTANTS = REQ_ROOT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Goals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__GOALS = REQ_ROOT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Stakeholder Goals</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS_FEATURE_COUNT = REQ_ROOT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ReqDocumentImpl <em>Req Document</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ReqDocumentImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqDocument()
   * @generated
   */
  int REQ_DOCUMENT = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT__NAME = REQ_ROOT__NAME;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT__TITLE = REQ_ROOT__TITLE;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT__DESCRIPTION = REQ_ROOT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT__DOC_REFERENCE = REQ_ROOT__DOC_REFERENCE;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT__ISSUES = REQ_ROOT__ISSUES;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT__CONTENT = REQ_ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Req Document</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT_FEATURE_COUNT = REQ_ROOT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.DocumentSectionImpl <em>Document Section</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.DocumentSectionImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getDocumentSection()
   * @generated
   */
  int DOCUMENT_SECTION = 6;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_SECTION__LABEL = 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_SECTION__TITLE = 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_SECTION__DESCRIPTION = 2;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_SECTION__CONTENT = 3;

  /**
   * The number of structural features of the '<em>Document Section</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENT_SECTION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RequirementSetImpl <em>Requirement Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RequirementSetImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRequirementSet()
   * @generated
   */
  int REQUIREMENT_SET = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_SET__NAME = REQ_ROOT__NAME;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_SET__TITLE = REQ_ROOT__TITLE;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_SET__DESCRIPTION = REQ_ROOT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_SET__DOC_REFERENCE = REQ_ROOT__DOC_REFERENCE;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_SET__ISSUES = REQ_ROOT__ISSUES;

  /**
   * The feature id for the '<em><b>Import Constants</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_SET__IMPORT_CONSTANTS = REQ_ROOT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_SET__CONSTANTS = REQ_ROOT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Computes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_SET__COMPUTES = REQ_ROOT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_SET__REQUIREMENTS = REQ_ROOT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Stakeholder Goals</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_SET__STAKEHOLDER_GOALS = REQ_ROOT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Requirement Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_SET_FEATURE_COUNT = REQ_ROOT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.GoalImpl <em>Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.GoalImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGoal()
   * @generated
   */
  int GOAL = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__NAME = CONTRACTUAL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__TITLE = CONTRACTUAL_ELEMENT__TITLE;

  /**
   * The feature id for the '<em><b>Target Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__TARGET_DESCRIPTION = CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__TARGET = CONTRACTUAL_ELEMENT__TARGET;

  /**
   * The feature id for the '<em><b>Target Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__TARGET_ELEMENT = CONTRACTUAL_ELEMENT__TARGET_ELEMENT;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__CATEGORY = CONTRACTUAL_ELEMENT__CATEGORY;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DESCRIPTION = CONTRACTUAL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__CONSTANTS = CONTRACTUAL_ELEMENT__CONSTANTS;

  /**
   * The feature id for the '<em><b>Whencondition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__WHENCONDITION = CONTRACTUAL_ELEMENT__WHENCONDITION;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__RATIONALE = CONTRACTUAL_ELEMENT__RATIONALE;

  /**
   * The feature id for the '<em><b>Change Uncertainty</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__CHANGE_UNCERTAINTY = CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY;

  /**
   * The feature id for the '<em><b>Evolves Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__EVOLVES_REFERENCE = CONTRACTUAL_ELEMENT__EVOLVES_REFERENCE;

  /**
   * The feature id for the '<em><b>Dropped</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DROPPED = CONTRACTUAL_ELEMENT__DROPPED;

  /**
   * The feature id for the '<em><b>Drop Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DROP_RATIONALE = CONTRACTUAL_ELEMENT__DROP_RATIONALE;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DOC_REFERENCE = CONTRACTUAL_ELEMENT__DOC_REFERENCE;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__ISSUES = CONTRACTUAL_ELEMENT__ISSUES;

  /**
   * The feature id for the '<em><b>Goal Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__GOAL_REFERENCE = CONTRACTUAL_ELEMENT__GOAL_REFERENCE;

  /**
   * The feature id for the '<em><b>Refines Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__REFINES_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Conflicts Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__CONFLICTS_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Stakeholder Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__STAKEHOLDER_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_FEATURE_COUNT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RequirementImpl <em>Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RequirementImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRequirement()
   * @generated
   */
  int REQUIREMENT = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__NAME = CONTRACTUAL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__TITLE = CONTRACTUAL_ELEMENT__TITLE;

  /**
   * The feature id for the '<em><b>Target Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__TARGET_DESCRIPTION = CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__TARGET = CONTRACTUAL_ELEMENT__TARGET;

  /**
   * The feature id for the '<em><b>Target Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__TARGET_ELEMENT = CONTRACTUAL_ELEMENT__TARGET_ELEMENT;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__CATEGORY = CONTRACTUAL_ELEMENT__CATEGORY;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__DESCRIPTION = CONTRACTUAL_ELEMENT__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__CONSTANTS = CONTRACTUAL_ELEMENT__CONSTANTS;

  /**
   * The feature id for the '<em><b>Whencondition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__WHENCONDITION = CONTRACTUAL_ELEMENT__WHENCONDITION;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__RATIONALE = CONTRACTUAL_ELEMENT__RATIONALE;

  /**
   * The feature id for the '<em><b>Change Uncertainty</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__CHANGE_UNCERTAINTY = CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY;

  /**
   * The feature id for the '<em><b>Evolves Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__EVOLVES_REFERENCE = CONTRACTUAL_ELEMENT__EVOLVES_REFERENCE;

  /**
   * The feature id for the '<em><b>Dropped</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__DROPPED = CONTRACTUAL_ELEMENT__DROPPED;

  /**
   * The feature id for the '<em><b>Drop Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__DROP_RATIONALE = CONTRACTUAL_ELEMENT__DROP_RATIONALE;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__DOC_REFERENCE = CONTRACTUAL_ELEMENT__DOC_REFERENCE;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__ISSUES = CONTRACTUAL_ELEMENT__ISSUES;

  /**
   * The feature id for the '<em><b>Goal Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__GOAL_REFERENCE = CONTRACTUAL_ELEMENT__GOAL_REFERENCE;

  /**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__PREDICATE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Exception</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__EXCEPTION = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Exception Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__EXCEPTION_TEXT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Inherits Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__INHERITS_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Computes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__COMPUTES = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Refines Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__REFINES_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Decomposes Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__DECOMPOSES_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Development Stakeholder</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__DEVELOPMENT_STAKEHOLDER = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Requirement Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__REQUIREMENT_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Component Category</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__COMPONENT_CATEGORY = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Target Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__TARGET_TYPE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 10;

  /**
   * The number of structural features of the '<em>Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_FEATURE_COUNT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 11;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.IncludeGlobalRequirementImpl <em>Include Global Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.IncludeGlobalRequirementImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getIncludeGlobalRequirement()
   * @generated
   */
  int INCLUDE_GLOBAL_REQUIREMENT = 10;

  /**
   * The feature id for the '<em><b>Include</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_GLOBAL_REQUIREMENT__INCLUDE = 0;

  /**
   * The feature id for the '<em><b>Local</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_GLOBAL_REQUIREMENT__LOCAL = 1;

  /**
   * The feature id for the '<em><b>Target Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_GLOBAL_REQUIREMENT__TARGET_ELEMENT = 2;

  /**
   * The number of structural features of the '<em>Include Global Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INCLUDE_GLOBAL_REQUIREMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.WhenConditionImpl <em>When Condition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.WhenConditionImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getWhenCondition()
   * @generated
   */
  int WHEN_CONDITION = 11;

  /**
   * The feature id for the '<em><b>In Mode</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHEN_CONDITION__IN_MODE = 0;

  /**
   * The feature id for the '<em><b>In Error State</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHEN_CONDITION__IN_ERROR_STATE = 1;

  /**
   * The feature id for the '<em><b>Condition</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHEN_CONDITION__CONDITION = 2;

  /**
   * The number of structural features of the '<em>When Condition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHEN_CONDITION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ReqPredicateImpl <em>Req Predicate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ReqPredicateImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqPredicate()
   * @generated
   */
  int REQ_PREDICATE = 12;

  /**
   * The number of structural features of the '<em>Req Predicate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_PREDICATE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.InformalPredicateImpl <em>Informal Predicate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.InformalPredicateImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getInformalPredicate()
   * @generated
   */
  int INFORMAL_PREDICATE = 13;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMAL_PREDICATE__DESCRIPTION = REQ_PREDICATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Informal Predicate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INFORMAL_PREDICATE_FEATURE_COUNT = REQ_PREDICATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ValuePredicateImpl <em>Value Predicate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ValuePredicateImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getValuePredicate()
   * @generated
   */
  int VALUE_PREDICATE = 14;

  /**
   * The feature id for the '<em><b>Xpression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_PREDICATE__XPRESSION = REQ_PREDICATE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Desired Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_PREDICATE__DESIRED_VALUE = REQ_PREDICATE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Value Predicate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_PREDICATE_FEATURE_COUNT = REQ_PREDICATE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.DesiredValueImpl <em>Desired Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.DesiredValueImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getDesiredValue()
   * @generated
   */
  int DESIRED_VALUE = 15;

  /**
   * The feature id for the '<em><b>Desired</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESIRED_VALUE__DESIRED = 0;

  /**
   * The feature id for the '<em><b>Upto</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESIRED_VALUE__UPTO = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESIRED_VALUE__VALUE = 2;

  /**
   * The number of structural features of the '<em>Desired Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESIRED_VALUE_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ExternalDocumentImpl <em>External Document</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ExternalDocumentImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getExternalDocument()
   * @generated
   */
  int EXTERNAL_DOCUMENT = 16;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DOCUMENT__DOC_REFERENCE = 0;

  /**
   * The feature id for the '<em><b>Doc Fragment</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DOCUMENT__DOC_FRAGMENT = 1;

  /**
   * The number of structural features of the '<em>External Document</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_DOCUMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.SystemRequirementSetImpl <em>System Requirement Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.SystemRequirementSetImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getSystemRequirementSet()
   * @generated
   */
  int SYSTEM_REQUIREMENT_SET = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_REQUIREMENT_SET__NAME = REQUIREMENT_SET__NAME;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_REQUIREMENT_SET__TITLE = REQUIREMENT_SET__TITLE;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_REQUIREMENT_SET__DESCRIPTION = REQUIREMENT_SET__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_REQUIREMENT_SET__DOC_REFERENCE = REQUIREMENT_SET__DOC_REFERENCE;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_REQUIREMENT_SET__ISSUES = REQUIREMENT_SET__ISSUES;

  /**
   * The feature id for the '<em><b>Import Constants</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_REQUIREMENT_SET__IMPORT_CONSTANTS = REQUIREMENT_SET__IMPORT_CONSTANTS;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_REQUIREMENT_SET__CONSTANTS = REQUIREMENT_SET__CONSTANTS;

  /**
   * The feature id for the '<em><b>Computes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_REQUIREMENT_SET__COMPUTES = REQUIREMENT_SET__COMPUTES;

  /**
   * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_REQUIREMENT_SET__REQUIREMENTS = REQUIREMENT_SET__REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Stakeholder Goals</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_REQUIREMENT_SET__STAKEHOLDER_GOALS = REQUIREMENT_SET__STAKEHOLDER_GOALS;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_REQUIREMENT_SET__TARGET = REQUIREMENT_SET_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Include</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_REQUIREMENT_SET__INCLUDE = REQUIREMENT_SET_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>System Requirement Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYSTEM_REQUIREMENT_SET_FEATURE_COUNT = REQUIREMENT_SET_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.GlobalRequirementSetImpl <em>Global Requirement Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.GlobalRequirementSetImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGlobalRequirementSet()
   * @generated
   */
  int GLOBAL_REQUIREMENT_SET = 18;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_REQUIREMENT_SET__NAME = REQUIREMENT_SET__NAME;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_REQUIREMENT_SET__TITLE = REQUIREMENT_SET__TITLE;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_REQUIREMENT_SET__DESCRIPTION = REQUIREMENT_SET__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_REQUIREMENT_SET__DOC_REFERENCE = REQUIREMENT_SET__DOC_REFERENCE;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_REQUIREMENT_SET__ISSUES = REQUIREMENT_SET__ISSUES;

  /**
   * The feature id for the '<em><b>Import Constants</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_REQUIREMENT_SET__IMPORT_CONSTANTS = REQUIREMENT_SET__IMPORT_CONSTANTS;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_REQUIREMENT_SET__CONSTANTS = REQUIREMENT_SET__CONSTANTS;

  /**
   * The feature id for the '<em><b>Computes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_REQUIREMENT_SET__COMPUTES = REQUIREMENT_SET__COMPUTES;

  /**
   * The feature id for the '<em><b>Requirements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_REQUIREMENT_SET__REQUIREMENTS = REQUIREMENT_SET__REQUIREMENTS;

  /**
   * The feature id for the '<em><b>Stakeholder Goals</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_REQUIREMENT_SET__STAKEHOLDER_GOALS = REQUIREMENT_SET__STAKEHOLDER_GOALS;

  /**
   * The number of structural features of the '<em>Global Requirement Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GLOBAL_REQUIREMENT_SET_FEATURE_COUNT = REQUIREMENT_SET_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ReqValDeclarationImpl <em>Req Val Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ReqValDeclarationImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqValDeclaration()
   * @generated
   */
  int REQ_VAL_DECLARATION = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_VAL_DECLARATION__NAME = CommonPackage.VAL_DECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_VAL_DECLARATION__TYPE = CommonPackage.VAL_DECLARATION__TYPE;

  /**
   * The feature id for the '<em><b>Range</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_VAL_DECLARATION__RANGE = CommonPackage.VAL_DECLARATION__RANGE;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_VAL_DECLARATION__VALUE = CommonPackage.VAL_DECLARATION__VALUE;

  /**
   * The feature id for the '<em><b>Property</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_VAL_DECLARATION__PROPERTY = CommonPackage.VAL_DECLARATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Req Val Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_VAL_DECLARATION_FEATURE_COUNT = CommonPackage.VAL_DECLARATION_FEATURE_COUNT + 1;


  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ReqSpec <em>Req Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Req Spec</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpec
   * @generated
   */
  EClass getReqSpec();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.ReqSpec#getParts <em>Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parts</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpec#getParts()
   * @see #getReqSpec()
   * @generated
   */
  EReference getReqSpec_Parts();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.GlobalConstants <em>Global Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Global Constants</em>'.
   * @see org.osate.reqspec.reqSpec.GlobalConstants
   * @generated
   */
  EClass getGlobalConstants();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.GlobalConstants#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.reqspec.reqSpec.GlobalConstants#getName()
   * @see #getGlobalConstants()
   * @generated
   */
  EAttribute getGlobalConstants_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.GlobalConstants#getConstants <em>Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constants</em>'.
   * @see org.osate.reqspec.reqSpec.GlobalConstants#getConstants()
   * @see #getGlobalConstants()
   * @generated
   */
  EReference getGlobalConstants_Constants();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ContractualElement <em>Contractual Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Contractual Element</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement
   * @generated
   */
  EClass getContractualElement();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ContractualElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getName()
   * @see #getContractualElement()
   * @generated
   */
  EAttribute getContractualElement_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ContractualElement#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getTitle()
   * @see #getContractualElement()
   * @generated
   */
  EAttribute getContractualElement_Title();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ContractualElement#getTargetDescription <em>Target Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Description</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getTargetDescription()
   * @see #getContractualElement()
   * @generated
   */
  EAttribute getContractualElement_TargetDescription();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.ContractualElement#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getTarget()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_Target();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.ContractualElement#getTargetElement <em>Target Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Element</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getTargetElement()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_TargetElement();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.ContractualElement#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Category</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getCategory()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_Category();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ContractualElement#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getDescription()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_Description();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.ContractualElement#getConstants <em>Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constants</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getConstants()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_Constants();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ContractualElement#getWhencondition <em>Whencondition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Whencondition</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getWhencondition()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_Whencondition();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ContractualElement#getRationale <em>Rationale</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Rationale</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getRationale()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_Rationale();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ContractualElement#getChangeUncertainty <em>Change Uncertainty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Change Uncertainty</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getChangeUncertainty()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_ChangeUncertainty();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.ContractualElement#getEvolvesReference <em>Evolves Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Evolves Reference</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getEvolvesReference()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_EvolvesReference();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ContractualElement#isDropped <em>Dropped</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Dropped</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#isDropped()
   * @see #getContractualElement()
   * @generated
   */
  EAttribute getContractualElement_Dropped();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ContractualElement#getDropRationale <em>Drop Rationale</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Drop Rationale</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getDropRationale()
   * @see #getContractualElement()
   * @generated
   */
  EAttribute getContractualElement_DropRationale();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.ContractualElement#getDocReference <em>Doc Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Doc Reference</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getDocReference()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_DocReference();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.reqspec.reqSpec.ContractualElement#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Issues</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getIssues()
   * @see #getContractualElement()
   * @generated
   */
  EAttribute getContractualElement_Issues();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.ContractualElement#getGoalReference <em>Goal Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Goal Reference</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getGoalReference()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_GoalReference();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ReqRoot <em>Req Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Req Root</em>'.
   * @see org.osate.reqspec.reqSpec.ReqRoot
   * @generated
   */
  EClass getReqRoot();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ReqRoot#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.reqspec.reqSpec.ReqRoot#getName()
   * @see #getReqRoot()
   * @generated
   */
  EAttribute getReqRoot_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ReqRoot#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.reqspec.reqSpec.ReqRoot#getTitle()
   * @see #getReqRoot()
   * @generated
   */
  EAttribute getReqRoot_Title();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ReqRoot#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.reqspec.reqSpec.ReqRoot#getDescription()
   * @see #getReqRoot()
   * @generated
   */
  EReference getReqRoot_Description();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.ReqRoot#getDocReference <em>Doc Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Doc Reference</em>'.
   * @see org.osate.reqspec.reqSpec.ReqRoot#getDocReference()
   * @see #getReqRoot()
   * @generated
   */
  EReference getReqRoot_DocReference();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.reqspec.reqSpec.ReqRoot#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Issues</em>'.
   * @see org.osate.reqspec.reqSpec.ReqRoot#getIssues()
   * @see #getReqRoot()
   * @generated
   */
  EAttribute getReqRoot_Issues();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.StakeholderGoals <em>Stakeholder Goals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Stakeholder Goals</em>'.
   * @see org.osate.reqspec.reqSpec.StakeholderGoals
   * @generated
   */
  EClass getStakeholderGoals();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.reqspec.reqSpec.StakeholderGoals#getTarget()
   * @see #getStakeholderGoals()
   * @generated
   */
  EReference getStakeholderGoals_Target();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getComponentCategory <em>Component Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Component Category</em>'.
   * @see org.osate.reqspec.reqSpec.StakeholderGoals#getComponentCategory()
   * @see #getStakeholderGoals()
   * @generated
   */
  EAttribute getStakeholderGoals_ComponentCategory();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getImportConstants <em>Import Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Import Constants</em>'.
   * @see org.osate.reqspec.reqSpec.StakeholderGoals#getImportConstants()
   * @see #getStakeholderGoals()
   * @generated
   */
  EReference getStakeholderGoals_ImportConstants();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getConstants <em>Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constants</em>'.
   * @see org.osate.reqspec.reqSpec.StakeholderGoals#getConstants()
   * @see #getStakeholderGoals()
   * @generated
   */
  EReference getStakeholderGoals_Constants();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getGoals <em>Goals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Goals</em>'.
   * @see org.osate.reqspec.reqSpec.StakeholderGoals#getGoals()
   * @see #getStakeholderGoals()
   * @generated
   */
  EReference getStakeholderGoals_Goals();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ReqDocument <em>Req Document</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Req Document</em>'.
   * @see org.osate.reqspec.reqSpec.ReqDocument
   * @generated
   */
  EClass getReqDocument();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.ReqDocument#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see org.osate.reqspec.reqSpec.ReqDocument#getContent()
   * @see #getReqDocument()
   * @generated
   */
  EReference getReqDocument_Content();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.DocumentSection <em>Document Section</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Document Section</em>'.
   * @see org.osate.reqspec.reqSpec.DocumentSection
   * @generated
   */
  EClass getDocumentSection();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.DocumentSection#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see org.osate.reqspec.reqSpec.DocumentSection#getLabel()
   * @see #getDocumentSection()
   * @generated
   */
  EAttribute getDocumentSection_Label();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.DocumentSection#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.reqspec.reqSpec.DocumentSection#getTitle()
   * @see #getDocumentSection()
   * @generated
   */
  EAttribute getDocumentSection_Title();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.DocumentSection#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.reqspec.reqSpec.DocumentSection#getDescription()
   * @see #getDocumentSection()
   * @generated
   */
  EReference getDocumentSection_Description();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.DocumentSection#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see org.osate.reqspec.reqSpec.DocumentSection#getContent()
   * @see #getDocumentSection()
   * @generated
   */
  EReference getDocumentSection_Content();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.RequirementSet <em>Requirement Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requirement Set</em>'.
   * @see org.osate.reqspec.reqSpec.RequirementSet
   * @generated
   */
  EClass getRequirementSet();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.RequirementSet#getImportConstants <em>Import Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Import Constants</em>'.
   * @see org.osate.reqspec.reqSpec.RequirementSet#getImportConstants()
   * @see #getRequirementSet()
   * @generated
   */
  EReference getRequirementSet_ImportConstants();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.RequirementSet#getConstants <em>Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constants</em>'.
   * @see org.osate.reqspec.reqSpec.RequirementSet#getConstants()
   * @see #getRequirementSet()
   * @generated
   */
  EReference getRequirementSet_Constants();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.RequirementSet#getComputes <em>Computes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Computes</em>'.
   * @see org.osate.reqspec.reqSpec.RequirementSet#getComputes()
   * @see #getRequirementSet()
   * @generated
   */
  EReference getRequirementSet_Computes();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.RequirementSet#getRequirements <em>Requirements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Requirements</em>'.
   * @see org.osate.reqspec.reqSpec.RequirementSet#getRequirements()
   * @see #getRequirementSet()
   * @generated
   */
  EReference getRequirementSet_Requirements();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.RequirementSet#getStakeholderGoals <em>Stakeholder Goals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Stakeholder Goals</em>'.
   * @see org.osate.reqspec.reqSpec.RequirementSet#getStakeholderGoals()
   * @see #getRequirementSet()
   * @generated
   */
  EReference getRequirementSet_StakeholderGoals();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Goal <em>Goal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal</em>'.
   * @see org.osate.reqspec.reqSpec.Goal
   * @generated
   */
  EClass getGoal();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Goal#getRefinesReference <em>Refines Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Refines Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Goal#getRefinesReference()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_RefinesReference();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Goal#getConflictsReference <em>Conflicts Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Conflicts Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Goal#getConflictsReference()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_ConflictsReference();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Goal#getStakeholderReference <em>Stakeholder Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Stakeholder Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Goal#getStakeholderReference()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_StakeholderReference();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Requirement <em>Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Requirement</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement
   * @generated
   */
  EClass getRequirement();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.Requirement#getPredicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Predicate</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getPredicate()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_Predicate();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.Requirement#getException <em>Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Exception</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getException()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_Exception();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.Requirement#getExceptionText <em>Exception Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exception Text</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getExceptionText()
   * @see #getRequirement()
   * @generated
   */
  EAttribute getRequirement_ExceptionText();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.Requirement#getInheritsReference <em>Inherits Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Inherits Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getInheritsReference()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_InheritsReference();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.Requirement#getComputes <em>Computes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Computes</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getComputes()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_Computes();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Requirement#getRefinesReference <em>Refines Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Refines Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getRefinesReference()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_RefinesReference();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Requirement#getDecomposesReference <em>Decomposes Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Decomposes Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getDecomposesReference()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_DecomposesReference();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Requirement#getDevelopmentStakeholder <em>Development Stakeholder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Development Stakeholder</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getDevelopmentStakeholder()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_DevelopmentStakeholder();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Requirement#getRequirementReference <em>Requirement Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Requirement Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getRequirementReference()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_RequirementReference();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.reqspec.reqSpec.Requirement#getComponentCategory <em>Component Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Component Category</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getComponentCategory()
   * @see #getRequirement()
   * @generated
   */
  EAttribute getRequirement_ComponentCategory();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.Requirement#getTargetType <em>Target Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Type</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getTargetType()
   * @see #getRequirement()
   * @generated
   */
  EAttribute getRequirement_TargetType();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.IncludeGlobalRequirement <em>Include Global Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Include Global Requirement</em>'.
   * @see org.osate.reqspec.reqSpec.IncludeGlobalRequirement
   * @generated
   */
  EClass getIncludeGlobalRequirement();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.IncludeGlobalRequirement#getInclude <em>Include</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Include</em>'.
   * @see org.osate.reqspec.reqSpec.IncludeGlobalRequirement#getInclude()
   * @see #getIncludeGlobalRequirement()
   * @generated
   */
  EReference getIncludeGlobalRequirement_Include();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.IncludeGlobalRequirement#isLocal <em>Local</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Local</em>'.
   * @see org.osate.reqspec.reqSpec.IncludeGlobalRequirement#isLocal()
   * @see #getIncludeGlobalRequirement()
   * @generated
   */
  EAttribute getIncludeGlobalRequirement_Local();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.IncludeGlobalRequirement#getTargetElement <em>Target Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Element</em>'.
   * @see org.osate.reqspec.reqSpec.IncludeGlobalRequirement#getTargetElement()
   * @see #getIncludeGlobalRequirement()
   * @generated
   */
  EReference getIncludeGlobalRequirement_TargetElement();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.WhenCondition <em>When Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>When Condition</em>'.
   * @see org.osate.reqspec.reqSpec.WhenCondition
   * @generated
   */
  EClass getWhenCondition();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.WhenCondition#getInMode <em>In Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>In Mode</em>'.
   * @see org.osate.reqspec.reqSpec.WhenCondition#getInMode()
   * @see #getWhenCondition()
   * @generated
   */
  EReference getWhenCondition_InMode();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.WhenCondition#getInErrorState <em>In Error State</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>In Error State</em>'.
   * @see org.osate.reqspec.reqSpec.WhenCondition#getInErrorState()
   * @see #getWhenCondition()
   * @generated
   */
  EReference getWhenCondition_InErrorState();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.WhenCondition#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Condition</em>'.
   * @see org.osate.reqspec.reqSpec.WhenCondition#getCondition()
   * @see #getWhenCondition()
   * @generated
   */
  EAttribute getWhenCondition_Condition();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ReqPredicate <em>Req Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Req Predicate</em>'.
   * @see org.osate.reqspec.reqSpec.ReqPredicate
   * @generated
   */
  EClass getReqPredicate();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.InformalPredicate <em>Informal Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Informal Predicate</em>'.
   * @see org.osate.reqspec.reqSpec.InformalPredicate
   * @generated
   */
  EClass getInformalPredicate();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.InformalPredicate#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.osate.reqspec.reqSpec.InformalPredicate#getDescription()
   * @see #getInformalPredicate()
   * @generated
   */
  EAttribute getInformalPredicate_Description();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ValuePredicate <em>Value Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Predicate</em>'.
   * @see org.osate.reqspec.reqSpec.ValuePredicate
   * @generated
   */
  EClass getValuePredicate();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ValuePredicate#getXpression <em>Xpression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Xpression</em>'.
   * @see org.osate.reqspec.reqSpec.ValuePredicate#getXpression()
   * @see #getValuePredicate()
   * @generated
   */
  EReference getValuePredicate_Xpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.ValuePredicate#getDesiredValue <em>Desired Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Desired Value</em>'.
   * @see org.osate.reqspec.reqSpec.ValuePredicate#getDesiredValue()
   * @see #getValuePredicate()
   * @generated
   */
  EReference getValuePredicate_DesiredValue();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.DesiredValue <em>Desired Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Desired Value</em>'.
   * @see org.osate.reqspec.reqSpec.DesiredValue
   * @generated
   */
  EClass getDesiredValue();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.DesiredValue#getDesired <em>Desired</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Desired</em>'.
   * @see org.osate.reqspec.reqSpec.DesiredValue#getDesired()
   * @see #getDesiredValue()
   * @generated
   */
  EReference getDesiredValue_Desired();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.DesiredValue#isUpto <em>Upto</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upto</em>'.
   * @see org.osate.reqspec.reqSpec.DesiredValue#isUpto()
   * @see #getDesiredValue()
   * @generated
   */
  EAttribute getDesiredValue_Upto();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.DesiredValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.reqspec.reqSpec.DesiredValue#getValue()
   * @see #getDesiredValue()
   * @generated
   */
  EReference getDesiredValue_Value();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ExternalDocument <em>External Document</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>External Document</em>'.
   * @see org.osate.reqspec.reqSpec.ExternalDocument
   * @generated
   */
  EClass getExternalDocument();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ExternalDocument#getDocReference <em>Doc Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Doc Reference</em>'.
   * @see org.osate.reqspec.reqSpec.ExternalDocument#getDocReference()
   * @see #getExternalDocument()
   * @generated
   */
  EAttribute getExternalDocument_DocReference();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ExternalDocument#getDocFragment <em>Doc Fragment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Doc Fragment</em>'.
   * @see org.osate.reqspec.reqSpec.ExternalDocument#getDocFragment()
   * @see #getExternalDocument()
   * @generated
   */
  EAttribute getExternalDocument_DocFragment();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.SystemRequirementSet <em>System Requirement Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>System Requirement Set</em>'.
   * @see org.osate.reqspec.reqSpec.SystemRequirementSet
   * @generated
   */
  EClass getSystemRequirementSet();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.SystemRequirementSet#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.reqspec.reqSpec.SystemRequirementSet#getTarget()
   * @see #getSystemRequirementSet()
   * @generated
   */
  EReference getSystemRequirementSet_Target();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.SystemRequirementSet#getInclude <em>Include</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Include</em>'.
   * @see org.osate.reqspec.reqSpec.SystemRequirementSet#getInclude()
   * @see #getSystemRequirementSet()
   * @generated
   */
  EReference getSystemRequirementSet_Include();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.GlobalRequirementSet <em>Global Requirement Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Global Requirement Set</em>'.
   * @see org.osate.reqspec.reqSpec.GlobalRequirementSet
   * @generated
   */
  EClass getGlobalRequirementSet();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ReqValDeclaration <em>Req Val Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Req Val Declaration</em>'.
   * @see org.osate.reqspec.reqSpec.ReqValDeclaration
   * @generated
   */
  EClass getReqValDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ReqValDeclaration#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Property</em>'.
   * @see org.osate.reqspec.reqSpec.ReqValDeclaration#getProperty()
   * @see #getReqValDeclaration()
   * @generated
   */
  EReference getReqValDeclaration_Property();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ReqSpecFactory getReqSpecFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ReqSpecImpl <em>Req Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqSpec()
     * @generated
     */
    EClass REQ_SPEC = eINSTANCE.getReqSpec();

    /**
     * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_SPEC__PARTS = eINSTANCE.getReqSpec_Parts();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.GlobalConstantsImpl <em>Global Constants</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.GlobalConstantsImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGlobalConstants()
     * @generated
     */
    EClass GLOBAL_CONSTANTS = eINSTANCE.getGlobalConstants();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GLOBAL_CONSTANTS__NAME = eINSTANCE.getGlobalConstants_Name();

    /**
     * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GLOBAL_CONSTANTS__CONSTANTS = eINSTANCE.getGlobalConstants_Constants();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ContractualElementImpl <em>Contractual Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ContractualElementImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getContractualElement()
     * @generated
     */
    EClass CONTRACTUAL_ELEMENT = eINSTANCE.getContractualElement();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACTUAL_ELEMENT__NAME = eINSTANCE.getContractualElement_Name();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACTUAL_ELEMENT__TITLE = eINSTANCE.getContractualElement_Title();

    /**
     * The meta object literal for the '<em><b>Target Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION = eINSTANCE.getContractualElement_TargetDescription();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__TARGET = eINSTANCE.getContractualElement_Target();

    /**
     * The meta object literal for the '<em><b>Target Element</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__TARGET_ELEMENT = eINSTANCE.getContractualElement_TargetElement();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__CATEGORY = eINSTANCE.getContractualElement_Category();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__DESCRIPTION = eINSTANCE.getContractualElement_Description();

    /**
     * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__CONSTANTS = eINSTANCE.getContractualElement_Constants();

    /**
     * The meta object literal for the '<em><b>Whencondition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__WHENCONDITION = eINSTANCE.getContractualElement_Whencondition();

    /**
     * The meta object literal for the '<em><b>Rationale</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__RATIONALE = eINSTANCE.getContractualElement_Rationale();

    /**
     * The meta object literal for the '<em><b>Change Uncertainty</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__CHANGE_UNCERTAINTY = eINSTANCE.getContractualElement_ChangeUncertainty();

    /**
     * The meta object literal for the '<em><b>Evolves Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__EVOLVES_REFERENCE = eINSTANCE.getContractualElement_EvolvesReference();

    /**
     * The meta object literal for the '<em><b>Dropped</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACTUAL_ELEMENT__DROPPED = eINSTANCE.getContractualElement_Dropped();

    /**
     * The meta object literal for the '<em><b>Drop Rationale</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACTUAL_ELEMENT__DROP_RATIONALE = eINSTANCE.getContractualElement_DropRationale();

    /**
     * The meta object literal for the '<em><b>Doc Reference</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__DOC_REFERENCE = eINSTANCE.getContractualElement_DocReference();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACTUAL_ELEMENT__ISSUES = eINSTANCE.getContractualElement_Issues();

    /**
     * The meta object literal for the '<em><b>Goal Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__GOAL_REFERENCE = eINSTANCE.getContractualElement_GoalReference();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ReqRootImpl <em>Req Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ReqRootImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqRoot()
     * @generated
     */
    EClass REQ_ROOT = eINSTANCE.getReqRoot();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQ_ROOT__NAME = eINSTANCE.getReqRoot_Name();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQ_ROOT__TITLE = eINSTANCE.getReqRoot_Title();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_ROOT__DESCRIPTION = eINSTANCE.getReqRoot_Description();

    /**
     * The meta object literal for the '<em><b>Doc Reference</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_ROOT__DOC_REFERENCE = eINSTANCE.getReqRoot_DocReference();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQ_ROOT__ISSUES = eINSTANCE.getReqRoot_Issues();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl <em>Stakeholder Goals</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getStakeholderGoals()
     * @generated
     */
    EClass STAKEHOLDER_GOALS = eINSTANCE.getStakeholderGoals();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STAKEHOLDER_GOALS__TARGET = eINSTANCE.getStakeholderGoals_Target();

    /**
     * The meta object literal for the '<em><b>Component Category</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STAKEHOLDER_GOALS__COMPONENT_CATEGORY = eINSTANCE.getStakeholderGoals_ComponentCategory();

    /**
     * The meta object literal for the '<em><b>Import Constants</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STAKEHOLDER_GOALS__IMPORT_CONSTANTS = eINSTANCE.getStakeholderGoals_ImportConstants();

    /**
     * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STAKEHOLDER_GOALS__CONSTANTS = eINSTANCE.getStakeholderGoals_Constants();

    /**
     * The meta object literal for the '<em><b>Goals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STAKEHOLDER_GOALS__GOALS = eINSTANCE.getStakeholderGoals_Goals();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ReqDocumentImpl <em>Req Document</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ReqDocumentImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqDocument()
     * @generated
     */
    EClass REQ_DOCUMENT = eINSTANCE.getReqDocument();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_DOCUMENT__CONTENT = eINSTANCE.getReqDocument_Content();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.DocumentSectionImpl <em>Document Section</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.DocumentSectionImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getDocumentSection()
     * @generated
     */
    EClass DOCUMENT_SECTION = eINSTANCE.getDocumentSection();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOCUMENT_SECTION__LABEL = eINSTANCE.getDocumentSection_Label();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DOCUMENT_SECTION__TITLE = eINSTANCE.getDocumentSection_Title();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_SECTION__DESCRIPTION = eINSTANCE.getDocumentSection_Description();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENT_SECTION__CONTENT = eINSTANCE.getDocumentSection_Content();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.RequirementSetImpl <em>Requirement Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.RequirementSetImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRequirementSet()
     * @generated
     */
    EClass REQUIREMENT_SET = eINSTANCE.getRequirementSet();

    /**
     * The meta object literal for the '<em><b>Import Constants</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT_SET__IMPORT_CONSTANTS = eINSTANCE.getRequirementSet_ImportConstants();

    /**
     * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT_SET__CONSTANTS = eINSTANCE.getRequirementSet_Constants();

    /**
     * The meta object literal for the '<em><b>Computes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT_SET__COMPUTES = eINSTANCE.getRequirementSet_Computes();

    /**
     * The meta object literal for the '<em><b>Requirements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT_SET__REQUIREMENTS = eINSTANCE.getRequirementSet_Requirements();

    /**
     * The meta object literal for the '<em><b>Stakeholder Goals</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT_SET__STAKEHOLDER_GOALS = eINSTANCE.getRequirementSet_StakeholderGoals();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.GoalImpl <em>Goal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.GoalImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGoal()
     * @generated
     */
    EClass GOAL = eINSTANCE.getGoal();

    /**
     * The meta object literal for the '<em><b>Refines Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__REFINES_REFERENCE = eINSTANCE.getGoal_RefinesReference();

    /**
     * The meta object literal for the '<em><b>Conflicts Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__CONFLICTS_REFERENCE = eINSTANCE.getGoal_ConflictsReference();

    /**
     * The meta object literal for the '<em><b>Stakeholder Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__STAKEHOLDER_REFERENCE = eINSTANCE.getGoal_StakeholderReference();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.RequirementImpl <em>Requirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.RequirementImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRequirement()
     * @generated
     */
    EClass REQUIREMENT = eINSTANCE.getRequirement();

    /**
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__PREDICATE = eINSTANCE.getRequirement_Predicate();

    /**
     * The meta object literal for the '<em><b>Exception</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__EXCEPTION = eINSTANCE.getRequirement_Exception();

    /**
     * The meta object literal for the '<em><b>Exception Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQUIREMENT__EXCEPTION_TEXT = eINSTANCE.getRequirement_ExceptionText();

    /**
     * The meta object literal for the '<em><b>Inherits Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__INHERITS_REFERENCE = eINSTANCE.getRequirement_InheritsReference();

    /**
     * The meta object literal for the '<em><b>Computes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__COMPUTES = eINSTANCE.getRequirement_Computes();

    /**
     * The meta object literal for the '<em><b>Refines Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__REFINES_REFERENCE = eINSTANCE.getRequirement_RefinesReference();

    /**
     * The meta object literal for the '<em><b>Decomposes Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__DECOMPOSES_REFERENCE = eINSTANCE.getRequirement_DecomposesReference();

    /**
     * The meta object literal for the '<em><b>Development Stakeholder</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__DEVELOPMENT_STAKEHOLDER = eINSTANCE.getRequirement_DevelopmentStakeholder();

    /**
     * The meta object literal for the '<em><b>Requirement Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__REQUIREMENT_REFERENCE = eINSTANCE.getRequirement_RequirementReference();

    /**
     * The meta object literal for the '<em><b>Component Category</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQUIREMENT__COMPONENT_CATEGORY = eINSTANCE.getRequirement_ComponentCategory();

    /**
     * The meta object literal for the '<em><b>Target Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQUIREMENT__TARGET_TYPE = eINSTANCE.getRequirement_TargetType();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.IncludeGlobalRequirementImpl <em>Include Global Requirement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.IncludeGlobalRequirementImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getIncludeGlobalRequirement()
     * @generated
     */
    EClass INCLUDE_GLOBAL_REQUIREMENT = eINSTANCE.getIncludeGlobalRequirement();

    /**
     * The meta object literal for the '<em><b>Include</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INCLUDE_GLOBAL_REQUIREMENT__INCLUDE = eINSTANCE.getIncludeGlobalRequirement_Include();

    /**
     * The meta object literal for the '<em><b>Local</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INCLUDE_GLOBAL_REQUIREMENT__LOCAL = eINSTANCE.getIncludeGlobalRequirement_Local();

    /**
     * The meta object literal for the '<em><b>Target Element</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INCLUDE_GLOBAL_REQUIREMENT__TARGET_ELEMENT = eINSTANCE.getIncludeGlobalRequirement_TargetElement();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.WhenConditionImpl <em>When Condition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.WhenConditionImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getWhenCondition()
     * @generated
     */
    EClass WHEN_CONDITION = eINSTANCE.getWhenCondition();

    /**
     * The meta object literal for the '<em><b>In Mode</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHEN_CONDITION__IN_MODE = eINSTANCE.getWhenCondition_InMode();

    /**
     * The meta object literal for the '<em><b>In Error State</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHEN_CONDITION__IN_ERROR_STATE = eINSTANCE.getWhenCondition_InErrorState();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WHEN_CONDITION__CONDITION = eINSTANCE.getWhenCondition_Condition();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ReqPredicateImpl <em>Req Predicate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ReqPredicateImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqPredicate()
     * @generated
     */
    EClass REQ_PREDICATE = eINSTANCE.getReqPredicate();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.InformalPredicateImpl <em>Informal Predicate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.InformalPredicateImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getInformalPredicate()
     * @generated
     */
    EClass INFORMAL_PREDICATE = eINSTANCE.getInformalPredicate();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INFORMAL_PREDICATE__DESCRIPTION = eINSTANCE.getInformalPredicate_Description();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ValuePredicateImpl <em>Value Predicate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ValuePredicateImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getValuePredicate()
     * @generated
     */
    EClass VALUE_PREDICATE = eINSTANCE.getValuePredicate();

    /**
     * The meta object literal for the '<em><b>Xpression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_PREDICATE__XPRESSION = eINSTANCE.getValuePredicate_Xpression();

    /**
     * The meta object literal for the '<em><b>Desired Value</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_PREDICATE__DESIRED_VALUE = eINSTANCE.getValuePredicate_DesiredValue();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.DesiredValueImpl <em>Desired Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.DesiredValueImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getDesiredValue()
     * @generated
     */
    EClass DESIRED_VALUE = eINSTANCE.getDesiredValue();

    /**
     * The meta object literal for the '<em><b>Desired</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DESIRED_VALUE__DESIRED = eINSTANCE.getDesiredValue_Desired();

    /**
     * The meta object literal for the '<em><b>Upto</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DESIRED_VALUE__UPTO = eINSTANCE.getDesiredValue_Upto();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DESIRED_VALUE__VALUE = eINSTANCE.getDesiredValue_Value();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ExternalDocumentImpl <em>External Document</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ExternalDocumentImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getExternalDocument()
     * @generated
     */
    EClass EXTERNAL_DOCUMENT = eINSTANCE.getExternalDocument();

    /**
     * The meta object literal for the '<em><b>Doc Reference</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXTERNAL_DOCUMENT__DOC_REFERENCE = eINSTANCE.getExternalDocument_DocReference();

    /**
     * The meta object literal for the '<em><b>Doc Fragment</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXTERNAL_DOCUMENT__DOC_FRAGMENT = eINSTANCE.getExternalDocument_DocFragment();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.SystemRequirementSetImpl <em>System Requirement Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.SystemRequirementSetImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getSystemRequirementSet()
     * @generated
     */
    EClass SYSTEM_REQUIREMENT_SET = eINSTANCE.getSystemRequirementSet();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SYSTEM_REQUIREMENT_SET__TARGET = eINSTANCE.getSystemRequirementSet_Target();

    /**
     * The meta object literal for the '<em><b>Include</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SYSTEM_REQUIREMENT_SET__INCLUDE = eINSTANCE.getSystemRequirementSet_Include();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.GlobalRequirementSetImpl <em>Global Requirement Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.GlobalRequirementSetImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGlobalRequirementSet()
     * @generated
     */
    EClass GLOBAL_REQUIREMENT_SET = eINSTANCE.getGlobalRequirementSet();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ReqValDeclarationImpl <em>Req Val Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ReqValDeclarationImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqValDeclaration()
     * @generated
     */
    EClass REQ_VAL_DECLARATION = eINSTANCE.getReqValDeclaration();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_VAL_DECLARATION__PROPERTY = eINSTANCE.getReqValDeclaration_Property();

  }

} //ReqSpecPackage
