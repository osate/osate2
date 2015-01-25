/**
 */
package org.osate.reqspec.reqSpec;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
   * The feature id for the '<em><b>Contents</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC__CONTENTS = 0;

  /**
   * The number of structural features of the '<em>Req Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ReqSpecContainerImpl <em>Container</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecContainerImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqSpecContainer()
   * @generated
   */
  int REQ_SPEC_CONTAINER = 1;

  /**
   * The number of structural features of the '<em>Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_CONTAINER_FEATURE_COUNT = 0;

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
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__TARGET = 2;

  /**
   * The feature id for the '<em><b>Target Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION = 3;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__CATEGORY = 4;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__RATIONALE = 5;

  /**
   * The feature id for the '<em><b>Document Requirement</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__DOCUMENT_REQUIREMENT = 6;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__DOC_REFERENCE = 7;

  /**
   * The number of structural features of the '<em>Contractual Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT_FEATURE_COUNT = 8;

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
   * The number of structural features of the '<em>Req Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_ROOT_FEATURE_COUNT = 0;

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
  int STAKEHOLDER_GOALS__NAME = REQ_SPEC_CONTAINER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__TITLE = REQ_SPEC_CONTAINER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__TARGET = REQ_SPEC_CONTAINER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Target Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__TARGET_DESCRIPTION = REQ_SPEC_CONTAINER_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__DESCRIPTION = REQ_SPEC_CONTAINER_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Consists Of</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__CONSISTS_OF = REQ_SPEC_CONTAINER_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Stakeholder Goals</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS_FEATURE_COUNT = REQ_SPEC_CONTAINER_FEATURE_COUNT + 6;

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
  int REQ_DOCUMENT__NAME = REQ_SPEC_CONTAINER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT__TITLE = REQ_SPEC_CONTAINER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT__DESCRIPTION = REQ_SPEC_CONTAINER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT__CONTENT = REQ_SPEC_CONTAINER_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Req Document</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT_FEATURE_COUNT = REQ_SPEC_CONTAINER_FEATURE_COUNT + 4;

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
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ReqSpecsImpl <em>Req Specs</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecsImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqSpecs()
   * @generated
   */
  int REQ_SPECS = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPECS__NAME = REQ_SPEC_CONTAINER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPECS__TITLE = REQ_SPEC_CONTAINER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPECS__TARGET = REQ_SPEC_CONTAINER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Target Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPECS__TARGET_DESCRIPTION = REQ_SPEC_CONTAINER_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPECS__CONSTANTS = REQ_SPEC_CONTAINER_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPECS__CONTENT = REQ_SPEC_CONTAINER_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Req Specs</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPECS_FEATURE_COUNT = REQ_SPEC_CONTAINER_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ReqSpecFolderImpl <em>Folder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecFolderImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqSpecFolder()
   * @generated
   */
  int REQ_SPEC_FOLDER = 8;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_FOLDER__LABEL = REQ_SPEC_CONTAINER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_FOLDER__TITLE = REQ_SPEC_CONTAINER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_FOLDER__CONTENT = REQ_SPEC_CONTAINER_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Folder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_FOLDER_FEATURE_COUNT = REQ_SPEC_CONTAINER_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.GoalFolderImpl <em>Goal Folder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.GoalFolderImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGoalFolder()
   * @generated
   */
  int GOAL_FOLDER = 9;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_FOLDER__LABEL = REQ_SPEC_CONTAINER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_FOLDER__TITLE = REQ_SPEC_CONTAINER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_FOLDER__CONTENT = REQ_SPEC_CONTAINER_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Goal Folder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_FOLDER_FEATURE_COUNT = REQ_SPEC_CONTAINER_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.GoalImpl <em>Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.GoalImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGoal()
   * @generated
   */
  int GOAL = 10;

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
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__TARGET = CONTRACTUAL_ELEMENT__TARGET;

  /**
   * The feature id for the '<em><b>Target Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__TARGET_DESCRIPTION = CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__CATEGORY = CONTRACTUAL_ELEMENT__CATEGORY;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__RATIONALE = CONTRACTUAL_ELEMENT__RATIONALE;

  /**
   * The feature id for the '<em><b>Document Requirement</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DOCUMENT_REQUIREMENT = CONTRACTUAL_ELEMENT__DOCUMENT_REQUIREMENT;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DOC_REFERENCE = CONTRACTUAL_ELEMENT__DOC_REFERENCE;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DESCRIPTION = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Refines Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__REFINES_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Conflicts Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__CONFLICTS_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Stakeholder Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__STAKEHOLDER_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_FEATURE_COUNT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RequirementImpl <em>Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RequirementImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRequirement()
   * @generated
   */
  int REQUIREMENT = 11;

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
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__TARGET = CONTRACTUAL_ELEMENT__TARGET;

  /**
   * The feature id for the '<em><b>Target Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__TARGET_DESCRIPTION = CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__CATEGORY = CONTRACTUAL_ELEMENT__CATEGORY;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__RATIONALE = CONTRACTUAL_ELEMENT__RATIONALE;

  /**
   * The feature id for the '<em><b>Document Requirement</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__DOCUMENT_REQUIREMENT = CONTRACTUAL_ELEMENT__DOCUMENT_REQUIREMENT;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__DOC_REFERENCE = CONTRACTUAL_ELEMENT__DOC_REFERENCE;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__DESCRIPTION = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__CONSTANTS = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Assert</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__ASSERT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Goal Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__GOAL_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Exception</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__EXCEPTION = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Exception Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__EXCEPTION_TEXT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Refined Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__REFINED_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Refines Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__REFINES_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Stakeholder Requirement Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__STAKEHOLDER_REQUIREMENT_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The number of structural features of the '<em>Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_FEATURE_COUNT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 9;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ExternalDocumentImpl <em>External Document</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ExternalDocumentImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getExternalDocument()
   * @generated
   */
  int EXTERNAL_DOCUMENT = 12;

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
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ReqSpec <em>Req Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Req Spec</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpec
   * @generated
   */
  EClass getReqSpec();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.ReqSpec#getContents <em>Contents</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Contents</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpec#getContents()
   * @see #getReqSpec()
   * @generated
   */
  EReference getReqSpec_Contents();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ReqSpecContainer <em>Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Container</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecContainer
   * @generated
   */
  EClass getReqSpecContainer();

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
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.ContractualElement#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Category</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getCategory()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_Category();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ContractualElement#getRationale <em>Rationale</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rationale</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getRationale()
   * @see #getContractualElement()
   * @generated
   */
  EAttribute getContractualElement_Rationale();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.ContractualElement#getDocumentRequirement <em>Document Requirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Document Requirement</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getDocumentRequirement()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_DocumentRequirement();

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
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ReqRoot <em>Req Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Req Root</em>'.
   * @see org.osate.reqspec.reqSpec.ReqRoot
   * @generated
   */
  EClass getReqRoot();

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
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.reqspec.reqSpec.StakeholderGoals#getName()
   * @see #getStakeholderGoals()
   * @generated
   */
  EAttribute getStakeholderGoals_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.reqspec.reqSpec.StakeholderGoals#getTitle()
   * @see #getStakeholderGoals()
   * @generated
   */
  EAttribute getStakeholderGoals_Title();

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
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getTargetDescription <em>Target Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Description</em>'.
   * @see org.osate.reqspec.reqSpec.StakeholderGoals#getTargetDescription()
   * @see #getStakeholderGoals()
   * @generated
   */
  EAttribute getStakeholderGoals_TargetDescription();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.reqspec.reqSpec.StakeholderGoals#getDescription()
   * @see #getStakeholderGoals()
   * @generated
   */
  EReference getStakeholderGoals_Description();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getConsistsOf <em>Consists Of</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Consists Of</em>'.
   * @see org.osate.reqspec.reqSpec.StakeholderGoals#getConsistsOf()
   * @see #getStakeholderGoals()
   * @generated
   */
  EReference getStakeholderGoals_ConsistsOf();

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
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ReqDocument#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.reqspec.reqSpec.ReqDocument#getName()
   * @see #getReqDocument()
   * @generated
   */
  EAttribute getReqDocument_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ReqDocument#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.reqspec.reqSpec.ReqDocument#getTitle()
   * @see #getReqDocument()
   * @generated
   */
  EAttribute getReqDocument_Title();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ReqDocument#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.reqspec.reqSpec.ReqDocument#getDescription()
   * @see #getReqDocument()
   * @generated
   */
  EReference getReqDocument_Description();

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
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ReqSpecs <em>Req Specs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Req Specs</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecs
   * @generated
   */
  EClass getReqSpecs();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ReqSpecs#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecs#getName()
   * @see #getReqSpecs()
   * @generated
   */
  EAttribute getReqSpecs_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ReqSpecs#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecs#getTitle()
   * @see #getReqSpecs()
   * @generated
   */
  EAttribute getReqSpecs_Title();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.ReqSpecs#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecs#getTarget()
   * @see #getReqSpecs()
   * @generated
   */
  EReference getReqSpecs_Target();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ReqSpecs#getTargetDescription <em>Target Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Description</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecs#getTargetDescription()
   * @see #getReqSpecs()
   * @generated
   */
  EAttribute getReqSpecs_TargetDescription();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.ReqSpecs#getConstants <em>Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constants</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecs#getConstants()
   * @see #getReqSpecs()
   * @generated
   */
  EReference getReqSpecs_Constants();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.ReqSpecs#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecs#getContent()
   * @see #getReqSpecs()
   * @generated
   */
  EReference getReqSpecs_Content();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ReqSpecFolder <em>Folder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Folder</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecFolder
   * @generated
   */
  EClass getReqSpecFolder();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ReqSpecFolder#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecFolder#getLabel()
   * @see #getReqSpecFolder()
   * @generated
   */
  EAttribute getReqSpecFolder_Label();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ReqSpecFolder#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecFolder#getTitle()
   * @see #getReqSpecFolder()
   * @generated
   */
  EAttribute getReqSpecFolder_Title();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.ReqSpecFolder#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecFolder#getContent()
   * @see #getReqSpecFolder()
   * @generated
   */
  EReference getReqSpecFolder_Content();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.GoalFolder <em>Goal Folder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Goal Folder</em>'.
   * @see org.osate.reqspec.reqSpec.GoalFolder
   * @generated
   */
  EClass getGoalFolder();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.GoalFolder#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see org.osate.reqspec.reqSpec.GoalFolder#getLabel()
   * @see #getGoalFolder()
   * @generated
   */
  EAttribute getGoalFolder_Label();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.GoalFolder#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.reqspec.reqSpec.GoalFolder#getTitle()
   * @see #getGoalFolder()
   * @generated
   */
  EAttribute getGoalFolder_Title();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.GoalFolder#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see org.osate.reqspec.reqSpec.GoalFolder#getContent()
   * @see #getGoalFolder()
   * @generated
   */
  EReference getGoalFolder_Content();

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
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.Goal#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.reqspec.reqSpec.Goal#getDescription()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_Description();

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
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.Requirement#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getDescription()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_Description();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.Requirement#getConstants <em>Constants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constants</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getConstants()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_Constants();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.Requirement#getAssert <em>Assert</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Assert</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getAssert()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_Assert();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Requirement#getGoalReference <em>Goal Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Goal Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getGoalReference()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_GoalReference();

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
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Requirement#getRefinedReference <em>Refined Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Refined Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getRefinedReference()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_RefinedReference();

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
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Requirement#getStakeholderRequirementReference <em>Stakeholder Requirement Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Stakeholder Requirement Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getStakeholderRequirementReference()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_StakeholderRequirementReference();

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
     * The meta object literal for the '<em><b>Contents</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_SPEC__CONTENTS = eINSTANCE.getReqSpec_Contents();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ReqSpecContainerImpl <em>Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecContainerImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqSpecContainer()
     * @generated
     */
    EClass REQ_SPEC_CONTAINER = eINSTANCE.getReqSpecContainer();

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
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__TARGET = eINSTANCE.getContractualElement_Target();

    /**
     * The meta object literal for the '<em><b>Target Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACTUAL_ELEMENT__TARGET_DESCRIPTION = eINSTANCE.getContractualElement_TargetDescription();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__CATEGORY = eINSTANCE.getContractualElement_Category();

    /**
     * The meta object literal for the '<em><b>Rationale</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACTUAL_ELEMENT__RATIONALE = eINSTANCE.getContractualElement_Rationale();

    /**
     * The meta object literal for the '<em><b>Document Requirement</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__DOCUMENT_REQUIREMENT = eINSTANCE.getContractualElement_DocumentRequirement();

    /**
     * The meta object literal for the '<em><b>Doc Reference</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__DOC_REFERENCE = eINSTANCE.getContractualElement_DocReference();

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
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl <em>Stakeholder Goals</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.StakeholderGoalsImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getStakeholderGoals()
     * @generated
     */
    EClass STAKEHOLDER_GOALS = eINSTANCE.getStakeholderGoals();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STAKEHOLDER_GOALS__NAME = eINSTANCE.getStakeholderGoals_Name();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STAKEHOLDER_GOALS__TITLE = eINSTANCE.getStakeholderGoals_Title();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STAKEHOLDER_GOALS__TARGET = eINSTANCE.getStakeholderGoals_Target();

    /**
     * The meta object literal for the '<em><b>Target Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STAKEHOLDER_GOALS__TARGET_DESCRIPTION = eINSTANCE.getStakeholderGoals_TargetDescription();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STAKEHOLDER_GOALS__DESCRIPTION = eINSTANCE.getStakeholderGoals_Description();

    /**
     * The meta object literal for the '<em><b>Consists Of</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STAKEHOLDER_GOALS__CONSISTS_OF = eINSTANCE.getStakeholderGoals_ConsistsOf();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQ_DOCUMENT__NAME = eINSTANCE.getReqDocument_Name();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQ_DOCUMENT__TITLE = eINSTANCE.getReqDocument_Title();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_DOCUMENT__DESCRIPTION = eINSTANCE.getReqDocument_Description();

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
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ReqSpecsImpl <em>Req Specs</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecsImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqSpecs()
     * @generated
     */
    EClass REQ_SPECS = eINSTANCE.getReqSpecs();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQ_SPECS__NAME = eINSTANCE.getReqSpecs_Name();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQ_SPECS__TITLE = eINSTANCE.getReqSpecs_Title();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_SPECS__TARGET = eINSTANCE.getReqSpecs_Target();

    /**
     * The meta object literal for the '<em><b>Target Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQ_SPECS__TARGET_DESCRIPTION = eINSTANCE.getReqSpecs_TargetDescription();

    /**
     * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_SPECS__CONSTANTS = eINSTANCE.getReqSpecs_Constants();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_SPECS__CONTENT = eINSTANCE.getReqSpecs_Content();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ReqSpecFolderImpl <em>Folder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecFolderImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqSpecFolder()
     * @generated
     */
    EClass REQ_SPEC_FOLDER = eINSTANCE.getReqSpecFolder();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQ_SPEC_FOLDER__LABEL = eINSTANCE.getReqSpecFolder_Label();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQ_SPEC_FOLDER__TITLE = eINSTANCE.getReqSpecFolder_Title();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_SPEC_FOLDER__CONTENT = eINSTANCE.getReqSpecFolder_Content();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.GoalFolderImpl <em>Goal Folder</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.GoalFolderImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGoalFolder()
     * @generated
     */
    EClass GOAL_FOLDER = eINSTANCE.getGoalFolder();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GOAL_FOLDER__LABEL = eINSTANCE.getGoalFolder_Label();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GOAL_FOLDER__TITLE = eINSTANCE.getGoalFolder_Title();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL_FOLDER__CONTENT = eINSTANCE.getGoalFolder_Content();

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
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__DESCRIPTION = eINSTANCE.getGoal_Description();

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
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__DESCRIPTION = eINSTANCE.getRequirement_Description();

    /**
     * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__CONSTANTS = eINSTANCE.getRequirement_Constants();

    /**
     * The meta object literal for the '<em><b>Assert</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__ASSERT = eINSTANCE.getRequirement_Assert();

    /**
     * The meta object literal for the '<em><b>Goal Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__GOAL_REFERENCE = eINSTANCE.getRequirement_GoalReference();

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
     * The meta object literal for the '<em><b>Refined Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__REFINED_REFERENCE = eINSTANCE.getRequirement_RefinedReference();

    /**
     * The meta object literal for the '<em><b>Refines Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__REFINES_REFERENCE = eINSTANCE.getRequirement_RefinesReference();

    /**
     * The meta object literal for the '<em><b>Stakeholder Requirement Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__STAKEHOLDER_REQUIREMENT_REFERENCE = eINSTANCE.getRequirement_StakeholderRequirementReference();

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

  }

} //ReqSpecPackage
