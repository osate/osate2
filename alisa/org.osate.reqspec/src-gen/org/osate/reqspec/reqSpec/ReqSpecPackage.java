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
   * The number of structural features of the '<em>Req Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_FEATURE_COUNT = 0;

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
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__DESCRIPTION = 5;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__RATIONALE = 6;

  /**
   * The feature id for the '<em><b>Document Requirement</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__DOCUMENT_REQUIREMENT = 7;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__DOC_REFERENCE = 8;

  /**
   * The number of structural features of the '<em>Contractual Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT_FEATURE_COUNT = 9;

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
  int STAKEHOLDER_GOALS__NAME = REQ_SPEC_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__TITLE = REQ_SPEC_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__TARGET = REQ_SPEC_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Target Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__TARGET_DESCRIPTION = REQ_SPEC_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__DESCRIPTION = REQ_SPEC_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS__CONTENT = REQ_SPEC_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Stakeholder Goals</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STAKEHOLDER_GOALS_FEATURE_COUNT = REQ_SPEC_FEATURE_COUNT + 6;

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
  int REQ_DOCUMENT__NAME = REQ_SPEC_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT__TITLE = REQ_SPEC_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT__DESCRIPTION = REQ_SPEC_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT__CONTENT = REQ_SPEC_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Req Document</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_DOCUMENT_FEATURE_COUNT = REQ_SPEC_FEATURE_COUNT + 4;

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
  int REQ_SPECS__NAME = REQ_SPEC_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPECS__TITLE = REQ_SPEC_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPECS__TARGET = REQ_SPEC_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Otherreqspecs</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPECS__OTHERREQSPECS = REQ_SPEC_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPECS__CONTENT = REQ_SPEC_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Req Specs</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPECS_FEATURE_COUNT = REQ_SPEC_FEATURE_COUNT + 5;

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
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DESCRIPTION = CONTRACTUAL_ELEMENT__DESCRIPTION;

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
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__DESCRIPTION = CONTRACTUAL_ELEMENT__DESCRIPTION;

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
   * The feature id for the '<em><b>Constants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__CONSTANTS = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__PREDICATE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Goal Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__GOAL_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Exception</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__EXCEPTION = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Exception Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__EXCEPTION_TEXT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Refined Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__REFINED_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Stakeholder Requirement Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__STAKEHOLDER_REQUIREMENT_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_FEATURE_COUNT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 7;

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
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.XPredicateImpl <em>XPredicate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.XPredicateImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getXPredicate()
   * @generated
   */
  int XPREDICATE = 14;

  /**
   * The feature id for the '<em><b>Xlambda</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XPREDICATE__XLAMBDA = REQ_PREDICATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>XPredicate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XPREDICATE_FEATURE_COUNT = REQ_PREDICATE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.SPeARPredicateImpl <em>SPe AR Predicate</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.SPeARPredicateImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getSPeARPredicate()
   * @generated
   */
  int SPE_AR_PREDICATE = 15;

  /**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPE_AR_PREDICATE__PREDICATE = REQ_PREDICATE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>SPe AR Predicate</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPE_AR_PREDICATE_FEATURE_COUNT = REQ_PREDICATE_FEATURE_COUNT + 1;

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
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ExprImpl <em>Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getExpr()
   * @generated
   */
  int EXPR = 23;

  /**
   * The number of structural features of the '<em>Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.QuantificationExprImpl <em>Quantification Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.QuantificationExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getQuantificationExpr()
   * @generated
   */
  int QUANTIFICATION_EXPR = 17;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTIFICATION_EXPR__VARIABLE = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTIFICATION_EXPR__DOMAIN = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTIFICATION_EXPR__EXPR = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Quantification Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTIFICATION_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.DomainImpl <em>Domain</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.DomainImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getDomain()
   * @generated
   */
  int DOMAIN = 18;

  /**
   * The number of structural features of the '<em>Domain</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.VariableRefImpl <em>Variable Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.VariableRefImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getVariableRef()
   * @generated
   */
  int VARIABLE_REF = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REF__NAME = 0;

  /**
   * The number of structural features of the '<em>Variable Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_REF_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.QuantifiedVariableImpl <em>Quantified Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.QuantifiedVariableImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getQuantifiedVariable()
   * @generated
   */
  int QUANTIFIED_VARIABLE = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTIFIED_VARIABLE__NAME = VARIABLE_REF__NAME;

  /**
   * The number of structural features of the '<em>Quantified Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTIFIED_VARIABLE_FEATURE_COUNT = VARIABLE_REF_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ForallExprImpl <em>Forall Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ForallExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getForallExpr()
   * @generated
   */
  int FORALL_EXPR = 20;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORALL_EXPR__VARIABLE = QUANTIFICATION_EXPR__VARIABLE;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORALL_EXPR__DOMAIN = QUANTIFICATION_EXPR__DOMAIN;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORALL_EXPR__EXPR = QUANTIFICATION_EXPR__EXPR;

  /**
   * The number of structural features of the '<em>Forall Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORALL_EXPR_FEATURE_COUNT = QUANTIFICATION_EXPR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ExistsExprImpl <em>Exists Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ExistsExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getExistsExpr()
   * @generated
   */
  int EXISTS_EXPR = 21;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXISTS_EXPR__VARIABLE = QUANTIFICATION_EXPR__VARIABLE;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXISTS_EXPR__DOMAIN = QUANTIFICATION_EXPR__DOMAIN;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXISTS_EXPR__EXPR = QUANTIFICATION_EXPR__EXPR;

  /**
   * The number of structural features of the '<em>Exists Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXISTS_EXPR_FEATURE_COUNT = QUANTIFICATION_EXPR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.SumExprImpl <em>Sum Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.SumExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getSumExpr()
   * @generated
   */
  int SUM_EXPR = 22;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_EXPR__VARIABLE = QUANTIFICATION_EXPR__VARIABLE;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_EXPR__DOMAIN = QUANTIFICATION_EXPR__DOMAIN;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_EXPR__EXPR = QUANTIFICATION_EXPR__EXPR;

  /**
   * The number of structural features of the '<em>Sum Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUM_EXPR_FEATURE_COUNT = QUANTIFICATION_EXPR_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.CallRefImpl <em>Call Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.CallRefImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getCallRef()
   * @generated
   */
  int CALL_REF = 26;

  /**
   * The number of structural features of the '<em>Call Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_REF_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.FunctionImpl <em>Function</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.FunctionImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getFunction()
   * @generated
   */
  int FUNCTION = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION__NAME = CALL_REF_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Function</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_FEATURE_COUNT = CALL_REF_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RecordFieldExprImpl <em>Record Field Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RecordFieldExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRecordFieldExpr()
   * @generated
   */
  int RECORD_FIELD_EXPR = 27;

  /**
   * The feature id for the '<em><b>Field</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_EXPR__FIELD = 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_EXPR__EXPR = 1;

  /**
   * The number of structural features of the '<em>Record Field Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_EXPR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RecordFieldImpl <em>Record Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RecordFieldImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRecordField()
   * @generated
   */
  int RECORD_FIELD = 28;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD__TYPE = 1;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD__UNIT = 2;

  /**
   * The number of structural features of the '<em>Record Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.TypeImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getType()
   * @generated
   */
  int TYPE = 29;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.FiniteSetTypeImpl <em>Finite Set Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.FiniteSetTypeImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getFiniteSetType()
   * @generated
   */
  int FINITE_SET_TYPE = 30;

  /**
   * The number of structural features of the '<em>Finite Set Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FINITE_SET_TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ArrayTypeImpl <em>Array Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ArrayTypeImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getArrayType()
   * @generated
   */
  int ARRAY_TYPE = 31;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE__TYPE = TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Length</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE__LENGTH = TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Array Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.IntegerSubRangeTypeImpl <em>Integer Sub Range Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.IntegerSubRangeTypeImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getIntegerSubRangeType()
   * @generated
   */
  int INTEGER_SUB_RANGE_TYPE = 32;

  /**
   * The feature id for the '<em><b>Low</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_SUB_RANGE_TYPE__LOW = TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>High</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_SUB_RANGE_TYPE__HIGH = TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Integer Sub Range Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_SUB_RANGE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.EnumerationTypeImpl <em>Enumeration Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.EnumerationTypeImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getEnumerationType()
   * @generated
   */
  int ENUMERATION_TYPE = 33;

  /**
   * The feature id for the '<em><b>Enumerators</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_TYPE__ENUMERATORS = FINITE_SET_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enumeration Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_TYPE_FEATURE_COUNT = FINITE_SET_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.EnumeratorImpl <em>Enumerator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.EnumeratorImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getEnumerator()
   * @generated
   */
  int ENUMERATOR = 34;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATOR__NAME = VARIABLE_REF__NAME;

  /**
   * The number of structural features of the '<em>Enumerator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATOR_FEATURE_COUNT = VARIABLE_REF_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.TypeDefImpl <em>Type Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.TypeDefImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getTypeDef()
   * @generated
   */
  int TYPE_DEF = 35;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEF__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEF__TYPE = 1;

  /**
   * The number of structural features of the '<em>Type Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RecordTypeImpl <em>Record Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RecordTypeImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRecordType()
   * @generated
   */
  int RECORD_TYPE = 36;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE__FIELDS = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Record Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.UnitImpl <em>Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.UnitImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getUnit()
   * @generated
   */
  int UNIT = 37;

  /**
   * The number of structural features of the '<em>Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ScalarImpl <em>Scalar</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ScalarImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getScalar()
   * @generated
   */
  int SCALAR = 38;

  /**
   * The number of structural features of the '<em>Scalar</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCALAR_FEATURE_COUNT = UNIT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.NamedUnitImpl <em>Named Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.NamedUnitImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getNamedUnit()
   * @generated
   */
  int NAMED_UNIT = 39;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_UNIT__ID = UNIT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Named Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_UNIT_FEATURE_COUNT = UNIT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.UnitDefImpl <em>Unit Def</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.UnitDefImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getUnitDef()
   * @generated
   */
  int UNIT_DEF = 40;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_DEF__NAME = 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_DEF__UNIT = 1;

  /**
   * The number of structural features of the '<em>Unit Def</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_DEF_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.FormulaOpsImpl <em>Formula Ops</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.FormulaOpsImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getFormulaOps()
   * @generated
   */
  int FORMULA_OPS = 41;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMULA_OPS__STRING = 0;

  /**
   * The number of structural features of the '<em>Formula Ops</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMULA_OPS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.BinaryOpImpl <em>Binary Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.BinaryOpImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getBinaryOp()
   * @generated
   */
  int BINARY_OP = 42;

  /**
   * The number of structural features of the '<em>Binary Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_OP_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.MultiplyImpl <em>Multiply</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.MultiplyImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getMultiply()
   * @generated
   */
  int MULTIPLY = 43;

  /**
   * The number of structural features of the '<em>Multiply</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY_FEATURE_COUNT = BINARY_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ExponentiationImpl <em>Exponentiation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ExponentiationImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getExponentiation()
   * @generated
   */
  int EXPONENTIATION = 44;

  /**
   * The number of structural features of the '<em>Exponentiation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPONENTIATION_FEATURE_COUNT = BINARY_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.DivideImpl <em>Divide</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.DivideImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getDivide()
   * @generated
   */
  int DIVIDE = 45;

  /**
   * The number of structural features of the '<em>Divide</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIVIDE_FEATURE_COUNT = BINARY_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.PlusImpl <em>Plus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.PlusImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getPlus()
   * @generated
   */
  int PLUS = 46;

  /**
   * The number of structural features of the '<em>Plus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUS_FEATURE_COUNT = BINARY_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.MinusImpl <em>Minus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.MinusImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getMinus()
   * @generated
   */
  int MINUS = 47;

  /**
   * The number of structural features of the '<em>Minus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MINUS_FEATURE_COUNT = BINARY_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ModulusImpl <em>Modulus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ModulusImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getModulus()
   * @generated
   */
  int MODULUS = 48;

  /**
   * The number of structural features of the '<em>Modulus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULUS_FEATURE_COUNT = BINARY_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RelationalOpImpl <em>Relational Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RelationalOpImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRelationalOp()
   * @generated
   */
  int RELATIONAL_OP = 49;

  /**
   * The number of structural features of the '<em>Relational Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_OP_FEATURE_COUNT = BINARY_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.LogicalOpImpl <em>Logical Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.LogicalOpImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getLogicalOp()
   * @generated
   */
  int LOGICAL_OP = 50;

  /**
   * The number of structural features of the '<em>Logical Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OP_FEATURE_COUNT = BINARY_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.UnaryOpImpl <em>Unary Op</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.UnaryOpImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getUnaryOp()
   * @generated
   */
  int UNARY_OP = 51;

  /**
   * The number of structural features of the '<em>Unary Op</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OP_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.DomainExprImpl <em>Domain Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.DomainExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getDomainExpr()
   * @generated
   */
  int DOMAIN_EXPR = 52;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_EXPR__DOMAIN = DOMAIN_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Domain Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOMAIN_EXPR_FEATURE_COUNT = DOMAIN_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.IfThenElseExprImpl <em>If Then Else Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.IfThenElseExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getIfThenElseExpr()
   * @generated
   */
  int IF_THEN_ELSE_EXPR = 53;

  /**
   * The feature id for the '<em><b>If Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__IF_EXPR = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__THEN_EXPR = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__ELSE_EXPR = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Then Else Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.BinaryExprImpl <em>Binary Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.BinaryExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getBinaryExpr()
   * @generated
   */
  int BINARY_EXPR = 54;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__OP = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Binary Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.UnaryExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getUnaryExpr()
   * @generated
   */
  int UNARY_EXPR = 55;

  /**
   * The feature id for the '<em><b>Op</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__OP = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__EXPR = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.PreExprImpl <em>Pre Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.PreExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getPreExpr()
   * @generated
   */
  int PRE_EXPR = 56;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_EXPR__EXPR = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Pre Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RecordAccessExprImpl <em>Record Access Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RecordAccessExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRecordAccessExpr()
   * @generated
   */
  int RECORD_ACCESS_EXPR = 57;

  /**
   * The feature id for the '<em><b>Record</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ACCESS_EXPR__RECORD = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Field</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ACCESS_EXPR__FIELD = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ACCESS_EXPR__EXPR = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Record Access Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_ACCESS_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ArrayAccessExprImpl <em>Array Access Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ArrayAccessExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getArrayAccessExpr()
   * @generated
   */
  int ARRAY_ACCESS_EXPR = 58;

  /**
   * The feature id for the '<em><b>Array</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESS_EXPR__ARRAY = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESS_EXPR__INDEX = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESS_EXPR__EXPR = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Array Access Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ACCESS_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.IdExprImpl <em>Id Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.IdExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getIdExpr()
   * @generated
   */
  int ID_EXPR = 59;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_EXPR__ID = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Id Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RecordExprImpl <em>Record Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RecordExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRecordExpr()
   * @generated
   */
  int RECORD_EXPR = 60;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__TYPE = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Record Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR__RECORD_FIELDS = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Record Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ArrayExprImpl <em>Array Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ArrayExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getArrayExpr()
   * @generated
   */
  int ARRAY_EXPR = 61;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_EXPR__EXPRS = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Array Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.FnCallExprImpl <em>Fn Call Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.FnCallExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getFnCallExpr()
   * @generated
   */
  int FN_CALL_EXPR = 62;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_CALL_EXPR__ID = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_CALL_EXPR__ARGS = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Fn Call Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_CALL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.BoolExprImpl <em>Bool Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.BoolExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getBoolExpr()
   * @generated
   */
  int BOOL_EXPR = 63;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR__VALUE = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bool Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.IntExprImpl <em>Int Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.IntExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getIntExpr()
   * @generated
   */
  int INT_EXPR = 64;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_EXPR__VALUE = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_EXPR__UNIT = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Int Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RealExprImpl <em>Real Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RealExprImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRealExpr()
   * @generated
   */
  int REAL_EXPR = 65;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_EXPR__VALUE = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_EXPR__UNIT = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Real Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RealTypeImpl <em>Real Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RealTypeImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRealType()
   * @generated
   */
  int REAL_TYPE = 66;

  /**
   * The number of structural features of the '<em>Real Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.IntegerTypeImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getIntegerType()
   * @generated
   */
  int INTEGER_TYPE = 67;

  /**
   * The number of structural features of the '<em>Integer Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.BooleanTypeImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getBooleanType()
   * @generated
   */
  int BOOLEAN_TYPE = 68;

  /**
   * The number of structural features of the '<em>Boolean Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.NamedTypeImpl <em>Named Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.NamedTypeImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getNamedType()
   * @generated
   */
  int NAMED_TYPE = 69;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE__ID = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Named Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.QuotUnitImpl <em>Quot Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.QuotUnitImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getQuotUnit()
   * @generated
   */
  int QUOT_UNIT = 70;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUOT_UNIT__LEFT = UNIT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUOT_UNIT__RIGHT = UNIT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Quot Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUOT_UNIT_FEATURE_COUNT = UNIT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ProdUnitImpl <em>Prod Unit</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ProdUnitImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getProdUnit()
   * @generated
   */
  int PROD_UNIT = 71;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROD_UNIT__LEFT = UNIT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROD_UNIT__RIGHT = UNIT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Prod Unit</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROD_UNIT_FEATURE_COUNT = UNIT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.AlwaysImpl <em>Always</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.AlwaysImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getAlways()
   * @generated
   */
  int ALWAYS = 72;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALWAYS__STRING = FORMULA_OPS__STRING;

  /**
   * The number of structural features of the '<em>Always</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALWAYS_FEATURE_COUNT = FORMULA_OPS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ExistsImpl <em>Exists</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ExistsImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getExists()
   * @generated
   */
  int EXISTS = 73;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXISTS__STRING = FORMULA_OPS__STRING;

  /**
   * The number of structural features of the '<em>Exists</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXISTS_FEATURE_COUNT = FORMULA_OPS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RespondsImpl <em>Responds</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RespondsImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getResponds()
   * @generated
   */
  int RESPONDS = 74;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESPONDS__STRING = FORMULA_OPS__STRING;

  /**
   * The number of structural features of the '<em>Responds</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESPONDS_FEATURE_COUNT = FORMULA_OPS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.PrecedesImpl <em>Precedes</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.PrecedesImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getPrecedes()
   * @generated
   */
  int PRECEDES = 75;

  /**
   * The feature id for the '<em><b>String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECEDES__STRING = FORMULA_OPS__STRING;

  /**
   * The number of structural features of the '<em>Precedes</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRECEDES_FEATURE_COUNT = FORMULA_OPS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.EqualToImpl <em>Equal To</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.EqualToImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getEqualTo()
   * @generated
   */
  int EQUAL_TO = 76;

  /**
   * The number of structural features of the '<em>Equal To</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUAL_TO_FEATURE_COUNT = RELATIONAL_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.NotEqualImpl <em>Not Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.NotEqualImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getNotEqual()
   * @generated
   */
  int NOT_EQUAL = 77;

  /**
   * The number of structural features of the '<em>Not Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_EQUAL_FEATURE_COUNT = RELATIONAL_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.LessThanImpl <em>Less Than</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.LessThanImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getLessThan()
   * @generated
   */
  int LESS_THAN = 78;

  /**
   * The number of structural features of the '<em>Less Than</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESS_THAN_FEATURE_COUNT = RELATIONAL_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.GreaterThanImpl <em>Greater Than</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.GreaterThanImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGreaterThan()
   * @generated
   */
  int GREATER_THAN = 79;

  /**
   * The number of structural features of the '<em>Greater Than</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_THAN_FEATURE_COUNT = RELATIONAL_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.LessThanEqualImpl <em>Less Than Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.LessThanEqualImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getLessThanEqual()
   * @generated
   */
  int LESS_THAN_EQUAL = 80;

  /**
   * The number of structural features of the '<em>Less Than Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LESS_THAN_EQUAL_FEATURE_COUNT = RELATIONAL_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.GreaterThanEqualImpl <em>Greater Than Equal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.GreaterThanEqualImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGreaterThanEqual()
   * @generated
   */
  int GREATER_THAN_EQUAL = 81;

  /**
   * The number of structural features of the '<em>Greater Than Equal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GREATER_THAN_EQUAL_FEATURE_COUNT = RELATIONAL_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.AndImpl <em>And</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.AndImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getAnd()
   * @generated
   */
  int AND = 82;

  /**
   * The number of structural features of the '<em>And</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_FEATURE_COUNT = LOGICAL_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.OrImpl <em>Or</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.OrImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getOr()
   * @generated
   */
  int OR = 83;

  /**
   * The number of structural features of the '<em>Or</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OR_FEATURE_COUNT = LOGICAL_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.XorImpl <em>Xor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.XorImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getXor()
   * @generated
   */
  int XOR = 84;

  /**
   * The number of structural features of the '<em>Xor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XOR_FEATURE_COUNT = LOGICAL_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ImpliesImpl <em>Implies</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ImpliesImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getImplies()
   * @generated
   */
  int IMPLIES = 85;

  /**
   * The number of structural features of the '<em>Implies</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLIES_FEATURE_COUNT = LOGICAL_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.UnaryMinusImpl <em>Unary Minus</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.UnaryMinusImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getUnaryMinus()
   * @generated
   */
  int UNARY_MINUS = 86;

  /**
   * The number of structural features of the '<em>Unary Minus</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_MINUS_FEATURE_COUNT = UNARY_OP_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.NotImpl <em>Not</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.NotImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getNot()
   * @generated
   */
  int NOT = 87;

  /**
   * The number of structural features of the '<em>Not</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NOT_FEATURE_COUNT = UNARY_OP_FEATURE_COUNT + 0;


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
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.StakeholderGoals#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see org.osate.reqspec.reqSpec.StakeholderGoals#getContent()
   * @see #getStakeholderGoals()
   * @generated
   */
  EReference getStakeholderGoals_Content();

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
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.ReqSpecs#getOtherreqspecs <em>Otherreqspecs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Otherreqspecs</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecs#getOtherreqspecs()
   * @see #getReqSpecs()
   * @generated
   */
  EReference getReqSpecs_Otherreqspecs();

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
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.XPredicate <em>XPredicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XPredicate</em>'.
   * @see org.osate.reqspec.reqSpec.XPredicate
   * @generated
   */
  EClass getXPredicate();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.XPredicate#getXlambda <em>Xlambda</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Xlambda</em>'.
   * @see org.osate.reqspec.reqSpec.XPredicate#getXlambda()
   * @see #getXPredicate()
   * @generated
   */
  EReference getXPredicate_Xlambda();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.SPeARPredicate <em>SPe AR Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>SPe AR Predicate</em>'.
   * @see org.osate.reqspec.reqSpec.SPeARPredicate
   * @generated
   */
  EClass getSPeARPredicate();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.SPeARPredicate#getPredicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Predicate</em>'.
   * @see org.osate.reqspec.reqSpec.SPeARPredicate#getPredicate()
   * @see #getSPeARPredicate()
   * @generated
   */
  EReference getSPeARPredicate_Predicate();

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
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.QuantificationExpr <em>Quantification Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quantification Expr</em>'.
   * @see org.osate.reqspec.reqSpec.QuantificationExpr
   * @generated
   */
  EClass getQuantificationExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.QuantificationExpr#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see org.osate.reqspec.reqSpec.QuantificationExpr#getVariable()
   * @see #getQuantificationExpr()
   * @generated
   */
  EReference getQuantificationExpr_Variable();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.QuantificationExpr#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Domain</em>'.
   * @see org.osate.reqspec.reqSpec.QuantificationExpr#getDomain()
   * @see #getQuantificationExpr()
   * @generated
   */
  EReference getQuantificationExpr_Domain();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.QuantificationExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see org.osate.reqspec.reqSpec.QuantificationExpr#getExpr()
   * @see #getQuantificationExpr()
   * @generated
   */
  EReference getQuantificationExpr_Expr();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Domain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain</em>'.
   * @see org.osate.reqspec.reqSpec.Domain
   * @generated
   */
  EClass getDomain();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.QuantifiedVariable <em>Quantified Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quantified Variable</em>'.
   * @see org.osate.reqspec.reqSpec.QuantifiedVariable
   * @generated
   */
  EClass getQuantifiedVariable();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ForallExpr <em>Forall Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Forall Expr</em>'.
   * @see org.osate.reqspec.reqSpec.ForallExpr
   * @generated
   */
  EClass getForallExpr();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ExistsExpr <em>Exists Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exists Expr</em>'.
   * @see org.osate.reqspec.reqSpec.ExistsExpr
   * @generated
   */
  EClass getExistsExpr();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.SumExpr <em>Sum Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Sum Expr</em>'.
   * @see org.osate.reqspec.reqSpec.SumExpr
   * @generated
   */
  EClass getSumExpr();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr</em>'.
   * @see org.osate.reqspec.reqSpec.Expr
   * @generated
   */
  EClass getExpr();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.VariableRef <em>Variable Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Ref</em>'.
   * @see org.osate.reqspec.reqSpec.VariableRef
   * @generated
   */
  EClass getVariableRef();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.VariableRef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.reqspec.reqSpec.VariableRef#getName()
   * @see #getVariableRef()
   * @generated
   */
  EAttribute getVariableRef_Name();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Function <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function</em>'.
   * @see org.osate.reqspec.reqSpec.Function
   * @generated
   */
  EClass getFunction();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.Function#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.reqspec.reqSpec.Function#getName()
   * @see #getFunction()
   * @generated
   */
  EAttribute getFunction_Name();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.CallRef <em>Call Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Call Ref</em>'.
   * @see org.osate.reqspec.reqSpec.CallRef
   * @generated
   */
  EClass getCallRef();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.RecordFieldExpr <em>Record Field Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Field Expr</em>'.
   * @see org.osate.reqspec.reqSpec.RecordFieldExpr
   * @generated
   */
  EClass getRecordFieldExpr();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.RecordFieldExpr#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Field</em>'.
   * @see org.osate.reqspec.reqSpec.RecordFieldExpr#getField()
   * @see #getRecordFieldExpr()
   * @generated
   */
  EReference getRecordFieldExpr_Field();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.RecordFieldExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see org.osate.reqspec.reqSpec.RecordFieldExpr#getExpr()
   * @see #getRecordFieldExpr()
   * @generated
   */
  EReference getRecordFieldExpr_Expr();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.RecordField <em>Record Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Field</em>'.
   * @see org.osate.reqspec.reqSpec.RecordField
   * @generated
   */
  EClass getRecordField();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.RecordField#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.reqspec.reqSpec.RecordField#getName()
   * @see #getRecordField()
   * @generated
   */
  EAttribute getRecordField_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.RecordField#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.osate.reqspec.reqSpec.RecordField#getType()
   * @see #getRecordField()
   * @generated
   */
  EReference getRecordField_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.RecordField#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unit</em>'.
   * @see org.osate.reqspec.reqSpec.RecordField#getUnit()
   * @see #getRecordField()
   * @generated
   */
  EReference getRecordField_Unit();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see org.osate.reqspec.reqSpec.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.FiniteSetType <em>Finite Set Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Finite Set Type</em>'.
   * @see org.osate.reqspec.reqSpec.FiniteSetType
   * @generated
   */
  EClass getFiniteSetType();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ArrayType <em>Array Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Type</em>'.
   * @see org.osate.reqspec.reqSpec.ArrayType
   * @generated
   */
  EClass getArrayType();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ArrayType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.osate.reqspec.reqSpec.ArrayType#getType()
   * @see #getArrayType()
   * @generated
   */
  EReference getArrayType_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ArrayType#getLength <em>Length</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Length</em>'.
   * @see org.osate.reqspec.reqSpec.ArrayType#getLength()
   * @see #getArrayType()
   * @generated
   */
  EReference getArrayType_Length();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.IntegerSubRangeType <em>Integer Sub Range Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Sub Range Type</em>'.
   * @see org.osate.reqspec.reqSpec.IntegerSubRangeType
   * @generated
   */
  EClass getIntegerSubRangeType();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.IntegerSubRangeType#getLow <em>Low</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Low</em>'.
   * @see org.osate.reqspec.reqSpec.IntegerSubRangeType#getLow()
   * @see #getIntegerSubRangeType()
   * @generated
   */
  EReference getIntegerSubRangeType_Low();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.IntegerSubRangeType#getHigh <em>High</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>High</em>'.
   * @see org.osate.reqspec.reqSpec.IntegerSubRangeType#getHigh()
   * @see #getIntegerSubRangeType()
   * @generated
   */
  EReference getIntegerSubRangeType_High();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.EnumerationType <em>Enumeration Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enumeration Type</em>'.
   * @see org.osate.reqspec.reqSpec.EnumerationType
   * @generated
   */
  EClass getEnumerationType();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.EnumerationType#getEnumerators <em>Enumerators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Enumerators</em>'.
   * @see org.osate.reqspec.reqSpec.EnumerationType#getEnumerators()
   * @see #getEnumerationType()
   * @generated
   */
  EReference getEnumerationType_Enumerators();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Enumerator <em>Enumerator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enumerator</em>'.
   * @see org.osate.reqspec.reqSpec.Enumerator
   * @generated
   */
  EClass getEnumerator();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.TypeDef <em>Type Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Def</em>'.
   * @see org.osate.reqspec.reqSpec.TypeDef
   * @generated
   */
  EClass getTypeDef();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.TypeDef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.reqspec.reqSpec.TypeDef#getName()
   * @see #getTypeDef()
   * @generated
   */
  EAttribute getTypeDef_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.TypeDef#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.osate.reqspec.reqSpec.TypeDef#getType()
   * @see #getTypeDef()
   * @generated
   */
  EReference getTypeDef_Type();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.RecordType <em>Record Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Type</em>'.
   * @see org.osate.reqspec.reqSpec.RecordType
   * @generated
   */
  EClass getRecordType();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.RecordType#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.osate.reqspec.reqSpec.RecordType#getFields()
   * @see #getRecordType()
   * @generated
   */
  EReference getRecordType_Fields();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Unit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit</em>'.
   * @see org.osate.reqspec.reqSpec.Unit
   * @generated
   */
  EClass getUnit();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Scalar <em>Scalar</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scalar</em>'.
   * @see org.osate.reqspec.reqSpec.Scalar
   * @generated
   */
  EClass getScalar();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.NamedUnit <em>Named Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Unit</em>'.
   * @see org.osate.reqspec.reqSpec.NamedUnit
   * @generated
   */
  EClass getNamedUnit();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.NamedUnit#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see org.osate.reqspec.reqSpec.NamedUnit#getId()
   * @see #getNamedUnit()
   * @generated
   */
  EReference getNamedUnit_Id();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.UnitDef <em>Unit Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Def</em>'.
   * @see org.osate.reqspec.reqSpec.UnitDef
   * @generated
   */
  EClass getUnitDef();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.UnitDef#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.reqspec.reqSpec.UnitDef#getName()
   * @see #getUnitDef()
   * @generated
   */
  EAttribute getUnitDef_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.UnitDef#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unit</em>'.
   * @see org.osate.reqspec.reqSpec.UnitDef#getUnit()
   * @see #getUnitDef()
   * @generated
   */
  EReference getUnitDef_Unit();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.FormulaOps <em>Formula Ops</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Formula Ops</em>'.
   * @see org.osate.reqspec.reqSpec.FormulaOps
   * @generated
   */
  EClass getFormulaOps();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.FormulaOps#getString <em>String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String</em>'.
   * @see org.osate.reqspec.reqSpec.FormulaOps#getString()
   * @see #getFormulaOps()
   * @generated
   */
  EAttribute getFormulaOps_String();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.BinaryOp <em>Binary Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Op</em>'.
   * @see org.osate.reqspec.reqSpec.BinaryOp
   * @generated
   */
  EClass getBinaryOp();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Multiply <em>Multiply</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiply</em>'.
   * @see org.osate.reqspec.reqSpec.Multiply
   * @generated
   */
  EClass getMultiply();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Exponentiation <em>Exponentiation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exponentiation</em>'.
   * @see org.osate.reqspec.reqSpec.Exponentiation
   * @generated
   */
  EClass getExponentiation();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Divide <em>Divide</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Divide</em>'.
   * @see org.osate.reqspec.reqSpec.Divide
   * @generated
   */
  EClass getDivide();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Plus <em>Plus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Plus</em>'.
   * @see org.osate.reqspec.reqSpec.Plus
   * @generated
   */
  EClass getPlus();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Minus <em>Minus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Minus</em>'.
   * @see org.osate.reqspec.reqSpec.Minus
   * @generated
   */
  EClass getMinus();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Modulus <em>Modulus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modulus</em>'.
   * @see org.osate.reqspec.reqSpec.Modulus
   * @generated
   */
  EClass getModulus();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.RelationalOp <em>Relational Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Op</em>'.
   * @see org.osate.reqspec.reqSpec.RelationalOp
   * @generated
   */
  EClass getRelationalOp();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.LogicalOp <em>Logical Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Op</em>'.
   * @see org.osate.reqspec.reqSpec.LogicalOp
   * @generated
   */
  EClass getLogicalOp();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.UnaryOp <em>Unary Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Op</em>'.
   * @see org.osate.reqspec.reqSpec.UnaryOp
   * @generated
   */
  EClass getUnaryOp();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.DomainExpr <em>Domain Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Domain Expr</em>'.
   * @see org.osate.reqspec.reqSpec.DomainExpr
   * @generated
   */
  EClass getDomainExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.DomainExpr#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Domain</em>'.
   * @see org.osate.reqspec.reqSpec.DomainExpr#getDomain()
   * @see #getDomainExpr()
   * @generated
   */
  EReference getDomainExpr_Domain();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.IfThenElseExpr <em>If Then Else Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Then Else Expr</em>'.
   * @see org.osate.reqspec.reqSpec.IfThenElseExpr
   * @generated
   */
  EClass getIfThenElseExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.IfThenElseExpr#getIfExpr <em>If Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If Expr</em>'.
   * @see org.osate.reqspec.reqSpec.IfThenElseExpr#getIfExpr()
   * @see #getIfThenElseExpr()
   * @generated
   */
  EReference getIfThenElseExpr_IfExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.IfThenElseExpr#getThenExpr <em>Then Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then Expr</em>'.
   * @see org.osate.reqspec.reqSpec.IfThenElseExpr#getThenExpr()
   * @see #getIfThenElseExpr()
   * @generated
   */
  EReference getIfThenElseExpr_ThenExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.IfThenElseExpr#getElseExpr <em>Else Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Expr</em>'.
   * @see org.osate.reqspec.reqSpec.IfThenElseExpr#getElseExpr()
   * @see #getIfThenElseExpr()
   * @generated
   */
  EReference getIfThenElseExpr_ElseExpr();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.BinaryExpr <em>Binary Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Expr</em>'.
   * @see org.osate.reqspec.reqSpec.BinaryExpr
   * @generated
   */
  EClass getBinaryExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.BinaryExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.osate.reqspec.reqSpec.BinaryExpr#getLeft()
   * @see #getBinaryExpr()
   * @generated
   */
  EReference getBinaryExpr_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.BinaryExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see org.osate.reqspec.reqSpec.BinaryExpr#getOp()
   * @see #getBinaryExpr()
   * @generated
   */
  EReference getBinaryExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.BinaryExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.osate.reqspec.reqSpec.BinaryExpr#getRight()
   * @see #getBinaryExpr()
   * @generated
   */
  EReference getBinaryExpr_Right();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.UnaryExpr <em>Unary Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expr</em>'.
   * @see org.osate.reqspec.reqSpec.UnaryExpr
   * @generated
   */
  EClass getUnaryExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.UnaryExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Op</em>'.
   * @see org.osate.reqspec.reqSpec.UnaryExpr#getOp()
   * @see #getUnaryExpr()
   * @generated
   */
  EReference getUnaryExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.UnaryExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see org.osate.reqspec.reqSpec.UnaryExpr#getExpr()
   * @see #getUnaryExpr()
   * @generated
   */
  EReference getUnaryExpr_Expr();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.PreExpr <em>Pre Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Pre Expr</em>'.
   * @see org.osate.reqspec.reqSpec.PreExpr
   * @generated
   */
  EClass getPreExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.PreExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see org.osate.reqspec.reqSpec.PreExpr#getExpr()
   * @see #getPreExpr()
   * @generated
   */
  EReference getPreExpr_Expr();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.RecordAccessExpr <em>Record Access Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Access Expr</em>'.
   * @see org.osate.reqspec.reqSpec.RecordAccessExpr
   * @generated
   */
  EClass getRecordAccessExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.RecordAccessExpr#getRecord <em>Record</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Record</em>'.
   * @see org.osate.reqspec.reqSpec.RecordAccessExpr#getRecord()
   * @see #getRecordAccessExpr()
   * @generated
   */
  EReference getRecordAccessExpr_Record();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.RecordAccessExpr#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Field</em>'.
   * @see org.osate.reqspec.reqSpec.RecordAccessExpr#getField()
   * @see #getRecordAccessExpr()
   * @generated
   */
  EReference getRecordAccessExpr_Field();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.RecordAccessExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see org.osate.reqspec.reqSpec.RecordAccessExpr#getExpr()
   * @see #getRecordAccessExpr()
   * @generated
   */
  EReference getRecordAccessExpr_Expr();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ArrayAccessExpr <em>Array Access Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Access Expr</em>'.
   * @see org.osate.reqspec.reqSpec.ArrayAccessExpr
   * @generated
   */
  EClass getArrayAccessExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ArrayAccessExpr#getArray <em>Array</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Array</em>'.
   * @see org.osate.reqspec.reqSpec.ArrayAccessExpr#getArray()
   * @see #getArrayAccessExpr()
   * @generated
   */
  EReference getArrayAccessExpr_Array();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ArrayAccessExpr#getIndex <em>Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Index</em>'.
   * @see org.osate.reqspec.reqSpec.ArrayAccessExpr#getIndex()
   * @see #getArrayAccessExpr()
   * @generated
   */
  EReference getArrayAccessExpr_Index();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ArrayAccessExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see org.osate.reqspec.reqSpec.ArrayAccessExpr#getExpr()
   * @see #getArrayAccessExpr()
   * @generated
   */
  EReference getArrayAccessExpr_Expr();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.IdExpr <em>Id Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Id Expr</em>'.
   * @see org.osate.reqspec.reqSpec.IdExpr
   * @generated
   */
  EClass getIdExpr();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.IdExpr#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see org.osate.reqspec.reqSpec.IdExpr#getId()
   * @see #getIdExpr()
   * @generated
   */
  EReference getIdExpr_Id();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.RecordExpr <em>Record Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Expr</em>'.
   * @see org.osate.reqspec.reqSpec.RecordExpr
   * @generated
   */
  EClass getRecordExpr();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.RecordExpr#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see org.osate.reqspec.reqSpec.RecordExpr#getType()
   * @see #getRecordExpr()
   * @generated
   */
  EReference getRecordExpr_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.RecordExpr#getRecordFields <em>Record Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Record Fields</em>'.
   * @see org.osate.reqspec.reqSpec.RecordExpr#getRecordFields()
   * @see #getRecordExpr()
   * @generated
   */
  EReference getRecordExpr_RecordFields();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ArrayExpr <em>Array Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Expr</em>'.
   * @see org.osate.reqspec.reqSpec.ArrayExpr
   * @generated
   */
  EClass getArrayExpr();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.ArrayExpr#getExprs <em>Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exprs</em>'.
   * @see org.osate.reqspec.reqSpec.ArrayExpr#getExprs()
   * @see #getArrayExpr()
   * @generated
   */
  EReference getArrayExpr_Exprs();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.FnCallExpr <em>Fn Call Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fn Call Expr</em>'.
   * @see org.osate.reqspec.reqSpec.FnCallExpr
   * @generated
   */
  EClass getFnCallExpr();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.FnCallExpr#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see org.osate.reqspec.reqSpec.FnCallExpr#getId()
   * @see #getFnCallExpr()
   * @generated
   */
  EReference getFnCallExpr_Id();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.FnCallExpr#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.osate.reqspec.reqSpec.FnCallExpr#getArgs()
   * @see #getFnCallExpr()
   * @generated
   */
  EReference getFnCallExpr_Args();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.BoolExpr <em>Bool Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Expr</em>'.
   * @see org.osate.reqspec.reqSpec.BoolExpr
   * @generated
   */
  EClass getBoolExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.BoolExpr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.reqspec.reqSpec.BoolExpr#getValue()
   * @see #getBoolExpr()
   * @generated
   */
  EReference getBoolExpr_Value();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.IntExpr <em>Int Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Expr</em>'.
   * @see org.osate.reqspec.reqSpec.IntExpr
   * @generated
   */
  EClass getIntExpr();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.IntExpr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.reqspec.reqSpec.IntExpr#getValue()
   * @see #getIntExpr()
   * @generated
   */
  EAttribute getIntExpr_Value();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.IntExpr#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unit</em>'.
   * @see org.osate.reqspec.reqSpec.IntExpr#getUnit()
   * @see #getIntExpr()
   * @generated
   */
  EReference getIntExpr_Unit();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.RealExpr <em>Real Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Expr</em>'.
   * @see org.osate.reqspec.reqSpec.RealExpr
   * @generated
   */
  EClass getRealExpr();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.RealExpr#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.reqspec.reqSpec.RealExpr#getValue()
   * @see #getRealExpr()
   * @generated
   */
  EAttribute getRealExpr_Value();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.RealExpr#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unit</em>'.
   * @see org.osate.reqspec.reqSpec.RealExpr#getUnit()
   * @see #getRealExpr()
   * @generated
   */
  EReference getRealExpr_Unit();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.RealType <em>Real Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Type</em>'.
   * @see org.osate.reqspec.reqSpec.RealType
   * @generated
   */
  EClass getRealType();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.IntegerType <em>Integer Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Type</em>'.
   * @see org.osate.reqspec.reqSpec.IntegerType
   * @generated
   */
  EClass getIntegerType();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.BooleanType <em>Boolean Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Type</em>'.
   * @see org.osate.reqspec.reqSpec.BooleanType
   * @generated
   */
  EClass getBooleanType();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.NamedType <em>Named Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Type</em>'.
   * @see org.osate.reqspec.reqSpec.NamedType
   * @generated
   */
  EClass getNamedType();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.NamedType#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see org.osate.reqspec.reqSpec.NamedType#getId()
   * @see #getNamedType()
   * @generated
   */
  EReference getNamedType_Id();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.QuotUnit <em>Quot Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quot Unit</em>'.
   * @see org.osate.reqspec.reqSpec.QuotUnit
   * @generated
   */
  EClass getQuotUnit();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.QuotUnit#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.osate.reqspec.reqSpec.QuotUnit#getLeft()
   * @see #getQuotUnit()
   * @generated
   */
  EReference getQuotUnit_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.QuotUnit#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.osate.reqspec.reqSpec.QuotUnit#getRight()
   * @see #getQuotUnit()
   * @generated
   */
  EReference getQuotUnit_Right();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ProdUnit <em>Prod Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Prod Unit</em>'.
   * @see org.osate.reqspec.reqSpec.ProdUnit
   * @generated
   */
  EClass getProdUnit();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ProdUnit#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.osate.reqspec.reqSpec.ProdUnit#getLeft()
   * @see #getProdUnit()
   * @generated
   */
  EReference getProdUnit_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.reqspec.reqSpec.ProdUnit#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.osate.reqspec.reqSpec.ProdUnit#getRight()
   * @see #getProdUnit()
   * @generated
   */
  EReference getProdUnit_Right();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Always <em>Always</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Always</em>'.
   * @see org.osate.reqspec.reqSpec.Always
   * @generated
   */
  EClass getAlways();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Exists <em>Exists</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exists</em>'.
   * @see org.osate.reqspec.reqSpec.Exists
   * @generated
   */
  EClass getExists();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Responds <em>Responds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Responds</em>'.
   * @see org.osate.reqspec.reqSpec.Responds
   * @generated
   */
  EClass getResponds();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Precedes <em>Precedes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Precedes</em>'.
   * @see org.osate.reqspec.reqSpec.Precedes
   * @generated
   */
  EClass getPrecedes();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.EqualTo <em>Equal To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Equal To</em>'.
   * @see org.osate.reqspec.reqSpec.EqualTo
   * @generated
   */
  EClass getEqualTo();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.NotEqual <em>Not Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Not Equal</em>'.
   * @see org.osate.reqspec.reqSpec.NotEqual
   * @generated
   */
  EClass getNotEqual();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.LessThan <em>Less Than</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Less Than</em>'.
   * @see org.osate.reqspec.reqSpec.LessThan
   * @generated
   */
  EClass getLessThan();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.GreaterThan <em>Greater Than</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Greater Than</em>'.
   * @see org.osate.reqspec.reqSpec.GreaterThan
   * @generated
   */
  EClass getGreaterThan();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.LessThanEqual <em>Less Than Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Less Than Equal</em>'.
   * @see org.osate.reqspec.reqSpec.LessThanEqual
   * @generated
   */
  EClass getLessThanEqual();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.GreaterThanEqual <em>Greater Than Equal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Greater Than Equal</em>'.
   * @see org.osate.reqspec.reqSpec.GreaterThanEqual
   * @generated
   */
  EClass getGreaterThanEqual();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.And <em>And</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And</em>'.
   * @see org.osate.reqspec.reqSpec.And
   * @generated
   */
  EClass getAnd();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Or <em>Or</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Or</em>'.
   * @see org.osate.reqspec.reqSpec.Or
   * @generated
   */
  EClass getOr();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Xor <em>Xor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Xor</em>'.
   * @see org.osate.reqspec.reqSpec.Xor
   * @generated
   */
  EClass getXor();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Implies <em>Implies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Implies</em>'.
   * @see org.osate.reqspec.reqSpec.Implies
   * @generated
   */
  EClass getImplies();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.UnaryMinus <em>Unary Minus</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Minus</em>'.
   * @see org.osate.reqspec.reqSpec.UnaryMinus
   * @generated
   */
  EClass getUnaryMinus();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Not <em>Not</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Not</em>'.
   * @see org.osate.reqspec.reqSpec.Not
   * @generated
   */
  EClass getNot();

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
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__DESCRIPTION = eINSTANCE.getContractualElement_Description();

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
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STAKEHOLDER_GOALS__CONTENT = eINSTANCE.getStakeholderGoals_Content();

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
     * The meta object literal for the '<em><b>Otherreqspecs</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_SPECS__OTHERREQSPECS = eINSTANCE.getReqSpecs_Otherreqspecs();

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
     * The meta object literal for the '<em><b>Constants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__CONSTANTS = eINSTANCE.getRequirement_Constants();

    /**
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__PREDICATE = eINSTANCE.getRequirement_Predicate();

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
     * The meta object literal for the '<em><b>Stakeholder Requirement Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__STAKEHOLDER_REQUIREMENT_REFERENCE = eINSTANCE.getRequirement_StakeholderRequirementReference();

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
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.XPredicateImpl <em>XPredicate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.XPredicateImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getXPredicate()
     * @generated
     */
    EClass XPREDICATE = eINSTANCE.getXPredicate();

    /**
     * The meta object literal for the '<em><b>Xlambda</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XPREDICATE__XLAMBDA = eINSTANCE.getXPredicate_Xlambda();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.SPeARPredicateImpl <em>SPe AR Predicate</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.SPeARPredicateImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getSPeARPredicate()
     * @generated
     */
    EClass SPE_AR_PREDICATE = eINSTANCE.getSPeARPredicate();

    /**
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPE_AR_PREDICATE__PREDICATE = eINSTANCE.getSPeARPredicate_Predicate();

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
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.QuantificationExprImpl <em>Quantification Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.QuantificationExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getQuantificationExpr()
     * @generated
     */
    EClass QUANTIFICATION_EXPR = eINSTANCE.getQuantificationExpr();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUANTIFICATION_EXPR__VARIABLE = eINSTANCE.getQuantificationExpr_Variable();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUANTIFICATION_EXPR__DOMAIN = eINSTANCE.getQuantificationExpr_Domain();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUANTIFICATION_EXPR__EXPR = eINSTANCE.getQuantificationExpr_Expr();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.DomainImpl <em>Domain</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.DomainImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getDomain()
     * @generated
     */
    EClass DOMAIN = eINSTANCE.getDomain();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.QuantifiedVariableImpl <em>Quantified Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.QuantifiedVariableImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getQuantifiedVariable()
     * @generated
     */
    EClass QUANTIFIED_VARIABLE = eINSTANCE.getQuantifiedVariable();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ForallExprImpl <em>Forall Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ForallExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getForallExpr()
     * @generated
     */
    EClass FORALL_EXPR = eINSTANCE.getForallExpr();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ExistsExprImpl <em>Exists Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ExistsExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getExistsExpr()
     * @generated
     */
    EClass EXISTS_EXPR = eINSTANCE.getExistsExpr();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.SumExprImpl <em>Sum Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.SumExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getSumExpr()
     * @generated
     */
    EClass SUM_EXPR = eINSTANCE.getSumExpr();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ExprImpl <em>Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getExpr()
     * @generated
     */
    EClass EXPR = eINSTANCE.getExpr();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.VariableRefImpl <em>Variable Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.VariableRefImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getVariableRef()
     * @generated
     */
    EClass VARIABLE_REF = eINSTANCE.getVariableRef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_REF__NAME = eINSTANCE.getVariableRef_Name();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.FunctionImpl <em>Function</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.FunctionImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getFunction()
     * @generated
     */
    EClass FUNCTION = eINSTANCE.getFunction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.CallRefImpl <em>Call Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.CallRefImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getCallRef()
     * @generated
     */
    EClass CALL_REF = eINSTANCE.getCallRef();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.RecordFieldExprImpl <em>Record Field Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.RecordFieldExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRecordFieldExpr()
     * @generated
     */
    EClass RECORD_FIELD_EXPR = eINSTANCE.getRecordFieldExpr();

    /**
     * The meta object literal for the '<em><b>Field</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_FIELD_EXPR__FIELD = eINSTANCE.getRecordFieldExpr_Field();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_FIELD_EXPR__EXPR = eINSTANCE.getRecordFieldExpr_Expr();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.RecordFieldImpl <em>Record Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.RecordFieldImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRecordField()
     * @generated
     */
    EClass RECORD_FIELD = eINSTANCE.getRecordField();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD_FIELD__NAME = eINSTANCE.getRecordField_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_FIELD__TYPE = eINSTANCE.getRecordField_Type();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_FIELD__UNIT = eINSTANCE.getRecordField_Unit();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.TypeImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.FiniteSetTypeImpl <em>Finite Set Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.FiniteSetTypeImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getFiniteSetType()
     * @generated
     */
    EClass FINITE_SET_TYPE = eINSTANCE.getFiniteSetType();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ArrayTypeImpl <em>Array Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ArrayTypeImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getArrayType()
     * @generated
     */
    EClass ARRAY_TYPE = eINSTANCE.getArrayType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_TYPE__TYPE = eINSTANCE.getArrayType_Type();

    /**
     * The meta object literal for the '<em><b>Length</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_TYPE__LENGTH = eINSTANCE.getArrayType_Length();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.IntegerSubRangeTypeImpl <em>Integer Sub Range Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.IntegerSubRangeTypeImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getIntegerSubRangeType()
     * @generated
     */
    EClass INTEGER_SUB_RANGE_TYPE = eINSTANCE.getIntegerSubRangeType();

    /**
     * The meta object literal for the '<em><b>Low</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTEGER_SUB_RANGE_TYPE__LOW = eINSTANCE.getIntegerSubRangeType_Low();

    /**
     * The meta object literal for the '<em><b>High</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INTEGER_SUB_RANGE_TYPE__HIGH = eINSTANCE.getIntegerSubRangeType_High();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.EnumerationTypeImpl <em>Enumeration Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.EnumerationTypeImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getEnumerationType()
     * @generated
     */
    EClass ENUMERATION_TYPE = eINSTANCE.getEnumerationType();

    /**
     * The meta object literal for the '<em><b>Enumerators</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUMERATION_TYPE__ENUMERATORS = eINSTANCE.getEnumerationType_Enumerators();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.EnumeratorImpl <em>Enumerator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.EnumeratorImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getEnumerator()
     * @generated
     */
    EClass ENUMERATOR = eINSTANCE.getEnumerator();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.TypeDefImpl <em>Type Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.TypeDefImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getTypeDef()
     * @generated
     */
    EClass TYPE_DEF = eINSTANCE.getTypeDef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_DEF__NAME = eINSTANCE.getTypeDef_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DEF__TYPE = eINSTANCE.getTypeDef_Type();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.RecordTypeImpl <em>Record Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.RecordTypeImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRecordType()
     * @generated
     */
    EClass RECORD_TYPE = eINSTANCE.getRecordType();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_TYPE__FIELDS = eINSTANCE.getRecordType_Fields();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.UnitImpl <em>Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.UnitImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getUnit()
     * @generated
     */
    EClass UNIT = eINSTANCE.getUnit();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ScalarImpl <em>Scalar</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ScalarImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getScalar()
     * @generated
     */
    EClass SCALAR = eINSTANCE.getScalar();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.NamedUnitImpl <em>Named Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.NamedUnitImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getNamedUnit()
     * @generated
     */
    EClass NAMED_UNIT = eINSTANCE.getNamedUnit();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_UNIT__ID = eINSTANCE.getNamedUnit_Id();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.UnitDefImpl <em>Unit Def</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.UnitDefImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getUnitDef()
     * @generated
     */
    EClass UNIT_DEF = eINSTANCE.getUnitDef();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNIT_DEF__NAME = eINSTANCE.getUnitDef_Name();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNIT_DEF__UNIT = eINSTANCE.getUnitDef_Unit();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.FormulaOpsImpl <em>Formula Ops</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.FormulaOpsImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getFormulaOps()
     * @generated
     */
    EClass FORMULA_OPS = eINSTANCE.getFormulaOps();

    /**
     * The meta object literal for the '<em><b>String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FORMULA_OPS__STRING = eINSTANCE.getFormulaOps_String();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.BinaryOpImpl <em>Binary Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.BinaryOpImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getBinaryOp()
     * @generated
     */
    EClass BINARY_OP = eINSTANCE.getBinaryOp();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.MultiplyImpl <em>Multiply</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.MultiplyImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getMultiply()
     * @generated
     */
    EClass MULTIPLY = eINSTANCE.getMultiply();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ExponentiationImpl <em>Exponentiation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ExponentiationImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getExponentiation()
     * @generated
     */
    EClass EXPONENTIATION = eINSTANCE.getExponentiation();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.DivideImpl <em>Divide</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.DivideImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getDivide()
     * @generated
     */
    EClass DIVIDE = eINSTANCE.getDivide();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.PlusImpl <em>Plus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.PlusImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getPlus()
     * @generated
     */
    EClass PLUS = eINSTANCE.getPlus();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.MinusImpl <em>Minus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.MinusImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getMinus()
     * @generated
     */
    EClass MINUS = eINSTANCE.getMinus();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ModulusImpl <em>Modulus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ModulusImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getModulus()
     * @generated
     */
    EClass MODULUS = eINSTANCE.getModulus();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.RelationalOpImpl <em>Relational Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.RelationalOpImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRelationalOp()
     * @generated
     */
    EClass RELATIONAL_OP = eINSTANCE.getRelationalOp();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.LogicalOpImpl <em>Logical Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.LogicalOpImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getLogicalOp()
     * @generated
     */
    EClass LOGICAL_OP = eINSTANCE.getLogicalOp();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.UnaryOpImpl <em>Unary Op</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.UnaryOpImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getUnaryOp()
     * @generated
     */
    EClass UNARY_OP = eINSTANCE.getUnaryOp();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.DomainExprImpl <em>Domain Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.DomainExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getDomainExpr()
     * @generated
     */
    EClass DOMAIN_EXPR = eINSTANCE.getDomainExpr();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOMAIN_EXPR__DOMAIN = eINSTANCE.getDomainExpr_Domain();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.IfThenElseExprImpl <em>If Then Else Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.IfThenElseExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getIfThenElseExpr()
     * @generated
     */
    EClass IF_THEN_ELSE_EXPR = eINSTANCE.getIfThenElseExpr();

    /**
     * The meta object literal for the '<em><b>If Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_EXPR__IF_EXPR = eINSTANCE.getIfThenElseExpr_IfExpr();

    /**
     * The meta object literal for the '<em><b>Then Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_EXPR__THEN_EXPR = eINSTANCE.getIfThenElseExpr_ThenExpr();

    /**
     * The meta object literal for the '<em><b>Else Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_EXPR__ELSE_EXPR = eINSTANCE.getIfThenElseExpr_ElseExpr();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.BinaryExprImpl <em>Binary Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.BinaryExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getBinaryExpr()
     * @generated
     */
    EClass BINARY_EXPR = eINSTANCE.getBinaryExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_EXPR__LEFT = eINSTANCE.getBinaryExpr_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_EXPR__OP = eINSTANCE.getBinaryExpr_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_EXPR__RIGHT = eINSTANCE.getBinaryExpr_Right();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.UnaryExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getUnaryExpr()
     * @generated
     */
    EClass UNARY_EXPR = eINSTANCE.getUnaryExpr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPR__OP = eINSTANCE.getUnaryExpr_Op();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPR__EXPR = eINSTANCE.getUnaryExpr_Expr();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.PreExprImpl <em>Pre Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.PreExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getPreExpr()
     * @generated
     */
    EClass PRE_EXPR = eINSTANCE.getPreExpr();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRE_EXPR__EXPR = eINSTANCE.getPreExpr_Expr();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.RecordAccessExprImpl <em>Record Access Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.RecordAccessExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRecordAccessExpr()
     * @generated
     */
    EClass RECORD_ACCESS_EXPR = eINSTANCE.getRecordAccessExpr();

    /**
     * The meta object literal for the '<em><b>Record</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_ACCESS_EXPR__RECORD = eINSTANCE.getRecordAccessExpr_Record();

    /**
     * The meta object literal for the '<em><b>Field</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_ACCESS_EXPR__FIELD = eINSTANCE.getRecordAccessExpr_Field();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_ACCESS_EXPR__EXPR = eINSTANCE.getRecordAccessExpr_Expr();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ArrayAccessExprImpl <em>Array Access Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ArrayAccessExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getArrayAccessExpr()
     * @generated
     */
    EClass ARRAY_ACCESS_EXPR = eINSTANCE.getArrayAccessExpr();

    /**
     * The meta object literal for the '<em><b>Array</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_ACCESS_EXPR__ARRAY = eINSTANCE.getArrayAccessExpr_Array();

    /**
     * The meta object literal for the '<em><b>Index</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_ACCESS_EXPR__INDEX = eINSTANCE.getArrayAccessExpr_Index();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_ACCESS_EXPR__EXPR = eINSTANCE.getArrayAccessExpr_Expr();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.IdExprImpl <em>Id Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.IdExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getIdExpr()
     * @generated
     */
    EClass ID_EXPR = eINSTANCE.getIdExpr();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ID_EXPR__ID = eINSTANCE.getIdExpr_Id();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.RecordExprImpl <em>Record Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.RecordExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRecordExpr()
     * @generated
     */
    EClass RECORD_EXPR = eINSTANCE.getRecordExpr();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_EXPR__TYPE = eINSTANCE.getRecordExpr_Type();

    /**
     * The meta object literal for the '<em><b>Record Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_EXPR__RECORD_FIELDS = eINSTANCE.getRecordExpr_RecordFields();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ArrayExprImpl <em>Array Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ArrayExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getArrayExpr()
     * @generated
     */
    EClass ARRAY_EXPR = eINSTANCE.getArrayExpr();

    /**
     * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_EXPR__EXPRS = eINSTANCE.getArrayExpr_Exprs();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.FnCallExprImpl <em>Fn Call Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.FnCallExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getFnCallExpr()
     * @generated
     */
    EClass FN_CALL_EXPR = eINSTANCE.getFnCallExpr();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FN_CALL_EXPR__ID = eINSTANCE.getFnCallExpr_Id();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FN_CALL_EXPR__ARGS = eINSTANCE.getFnCallExpr_Args();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.BoolExprImpl <em>Bool Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.BoolExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getBoolExpr()
     * @generated
     */
    EClass BOOL_EXPR = eINSTANCE.getBoolExpr();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOL_EXPR__VALUE = eINSTANCE.getBoolExpr_Value();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.IntExprImpl <em>Int Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.IntExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getIntExpr()
     * @generated
     */
    EClass INT_EXPR = eINSTANCE.getIntExpr();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_EXPR__VALUE = eINSTANCE.getIntExpr_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INT_EXPR__UNIT = eINSTANCE.getIntExpr_Unit();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.RealExprImpl <em>Real Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.RealExprImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRealExpr()
     * @generated
     */
    EClass REAL_EXPR = eINSTANCE.getRealExpr();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_EXPR__VALUE = eINSTANCE.getRealExpr_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REAL_EXPR__UNIT = eINSTANCE.getRealExpr_Unit();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.RealTypeImpl <em>Real Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.RealTypeImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRealType()
     * @generated
     */
    EClass REAL_TYPE = eINSTANCE.getRealType();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.IntegerTypeImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getIntegerType()
     * @generated
     */
    EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.BooleanTypeImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getBooleanType()
     * @generated
     */
    EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.NamedTypeImpl <em>Named Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.NamedTypeImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getNamedType()
     * @generated
     */
    EClass NAMED_TYPE = eINSTANCE.getNamedType();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_TYPE__ID = eINSTANCE.getNamedType_Id();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.QuotUnitImpl <em>Quot Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.QuotUnitImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getQuotUnit()
     * @generated
     */
    EClass QUOT_UNIT = eINSTANCE.getQuotUnit();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUOT_UNIT__LEFT = eINSTANCE.getQuotUnit_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUOT_UNIT__RIGHT = eINSTANCE.getQuotUnit_Right();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ProdUnitImpl <em>Prod Unit</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ProdUnitImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getProdUnit()
     * @generated
     */
    EClass PROD_UNIT = eINSTANCE.getProdUnit();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROD_UNIT__LEFT = eINSTANCE.getProdUnit_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROD_UNIT__RIGHT = eINSTANCE.getProdUnit_Right();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.AlwaysImpl <em>Always</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.AlwaysImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getAlways()
     * @generated
     */
    EClass ALWAYS = eINSTANCE.getAlways();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ExistsImpl <em>Exists</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ExistsImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getExists()
     * @generated
     */
    EClass EXISTS = eINSTANCE.getExists();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.RespondsImpl <em>Responds</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.RespondsImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getResponds()
     * @generated
     */
    EClass RESPONDS = eINSTANCE.getResponds();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.PrecedesImpl <em>Precedes</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.PrecedesImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getPrecedes()
     * @generated
     */
    EClass PRECEDES = eINSTANCE.getPrecedes();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.EqualToImpl <em>Equal To</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.EqualToImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getEqualTo()
     * @generated
     */
    EClass EQUAL_TO = eINSTANCE.getEqualTo();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.NotEqualImpl <em>Not Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.NotEqualImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getNotEqual()
     * @generated
     */
    EClass NOT_EQUAL = eINSTANCE.getNotEqual();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.LessThanImpl <em>Less Than</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.LessThanImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getLessThan()
     * @generated
     */
    EClass LESS_THAN = eINSTANCE.getLessThan();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.GreaterThanImpl <em>Greater Than</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.GreaterThanImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGreaterThan()
     * @generated
     */
    EClass GREATER_THAN = eINSTANCE.getGreaterThan();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.LessThanEqualImpl <em>Less Than Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.LessThanEqualImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getLessThanEqual()
     * @generated
     */
    EClass LESS_THAN_EQUAL = eINSTANCE.getLessThanEqual();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.GreaterThanEqualImpl <em>Greater Than Equal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.GreaterThanEqualImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGreaterThanEqual()
     * @generated
     */
    EClass GREATER_THAN_EQUAL = eINSTANCE.getGreaterThanEqual();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.AndImpl <em>And</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.AndImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getAnd()
     * @generated
     */
    EClass AND = eINSTANCE.getAnd();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.OrImpl <em>Or</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.OrImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getOr()
     * @generated
     */
    EClass OR = eINSTANCE.getOr();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.XorImpl <em>Xor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.XorImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getXor()
     * @generated
     */
    EClass XOR = eINSTANCE.getXor();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ImpliesImpl <em>Implies</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ImpliesImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getImplies()
     * @generated
     */
    EClass IMPLIES = eINSTANCE.getImplies();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.UnaryMinusImpl <em>Unary Minus</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.UnaryMinusImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getUnaryMinus()
     * @generated
     */
    EClass UNARY_MINUS = eINSTANCE.getUnaryMinus();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.NotImpl <em>Not</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.NotImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getNot()
     * @generated
     */
    EClass NOT = eINSTANCE.getNot();

  }

} //ReqSpecPackage
