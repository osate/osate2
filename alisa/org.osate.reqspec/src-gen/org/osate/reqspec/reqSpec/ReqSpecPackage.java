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
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_CONTAINER__TARGET = 0;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_CONTAINER__CONTENT = 1;

  /**
   * The feature id for the '<em><b>Issue</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_CONTAINER__ISSUE = 2;

  /**
   * The number of structural features of the '<em>Container</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_CONTAINER_FEATURE_COUNT = 3;

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
   * The feature id for the '<em><b>Target Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__TARGET_CONTEXT = 3;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__RATIONALE = 4;

  /**
   * The feature id for the '<em><b>Issue</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT__ISSUE = 5;

  /**
   * The number of structural features of the '<em>Contractual Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTRACTUAL_ELEMENT_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ReqSpecModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecModelImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqSpecModel()
   * @generated
   */
  int REQ_SPEC_MODEL = 3;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_MODEL__TARGET = REQ_SPEC_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_MODEL__CONTENT = REQ_SPEC_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Issue</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_MODEL__ISSUE = REQ_SPEC_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_MODEL__NAME = REQ_SPEC_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Import</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_MODEL__IMPORT = REQ_SPEC_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_MODEL_FEATURE_COUNT = REQ_SPEC_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ReqSpecFolderImpl <em>Folder</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecFolderImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqSpecFolder()
   * @generated
   */
  int REQ_SPEC_FOLDER = 4;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_FOLDER__TARGET = REQ_SPEC_CONTAINER__TARGET;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_FOLDER__CONTENT = REQ_SPEC_CONTAINER__CONTENT;

  /**
   * The feature id for the '<em><b>Issue</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_FOLDER__ISSUE = REQ_SPEC_CONTAINER__ISSUE;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_FOLDER__LABEL = REQ_SPEC_CONTAINER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Folder</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQ_SPEC_FOLDER_FEATURE_COUNT = REQ_SPEC_CONTAINER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RSLVariableImpl <em>RSL Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RSLVariableImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRSLVariable()
   * @generated
   */
  int RSL_VARIABLE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSL_VARIABLE__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSL_VARIABLE__VALUE = 1;

  /**
   * The number of structural features of the '<em>RSL Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RSL_VARIABLE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.GoalImpl <em>Goal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.GoalImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getGoal()
   * @generated
   */
  int GOAL = 6;

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
   * The feature id for the '<em><b>Target Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__TARGET_CONTEXT = CONTRACTUAL_ELEMENT__TARGET_CONTEXT;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__RATIONALE = CONTRACTUAL_ELEMENT__RATIONALE;

  /**
   * The feature id for the '<em><b>Issue</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__ISSUE = CONTRACTUAL_ELEMENT__ISSUE;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__CATEGORY = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DESCRIPTION = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Assert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__ASSERT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Refines Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__REFINES_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Subgoal</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__SUBGOAL = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Decomposes Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DECOMPOSES_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Evolves Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__EVOLVES_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Conflicts Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__CONFLICTS_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Stakeholder Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__STAKEHOLDER_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Stakeholder Requirement Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__STAKEHOLDER_REQUIREMENT_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>System Requirement Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__SYSTEM_REQUIREMENT_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL__DOC_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 11;

  /**
   * The number of structural features of the '<em>Goal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GOAL_FEATURE_COUNT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 12;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.RequirementImpl <em>Requirement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.RequirementImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRequirement()
   * @generated
   */
  int REQUIREMENT = 7;

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
   * The feature id for the '<em><b>Target Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__TARGET_CONTEXT = CONTRACTUAL_ELEMENT__TARGET_CONTEXT;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__RATIONALE = CONTRACTUAL_ELEMENT__RATIONALE;

  /**
   * The feature id for the '<em><b>Issue</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__ISSUE = CONTRACTUAL_ELEMENT__ISSUE;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__CATEGORY = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__DESCRIPTION = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Assert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__ASSERT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Req Value</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__REQ_VALUE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Goal Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__GOAL_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Hazard Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__HAZARD_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Refines Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__REFINES_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Subrequirement</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__SUBREQUIREMENT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>Decomposes Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__DECOMPOSES_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Evolves Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__EVOLVES_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Stakeholder Requirement Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__STAKEHOLDER_REQUIREMENT_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>System Requirement Reference</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__SYSTEM_REQUIREMENT_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 11;

  /**
   * The feature id for the '<em><b>Doc Reference</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT__DOC_REFERENCE = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 12;

  /**
   * The number of structural features of the '<em>Requirement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIREMENT_FEATURE_COUNT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 13;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.HazardImpl <em>Hazard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.HazardImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getHazard()
   * @generated
   */
  int HAZARD = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD__NAME = CONTRACTUAL_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD__TITLE = CONTRACTUAL_ELEMENT__TITLE;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD__TARGET = CONTRACTUAL_ELEMENT__TARGET;

  /**
   * The feature id for the '<em><b>Target Context</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD__TARGET_CONTEXT = CONTRACTUAL_ELEMENT__TARGET_CONTEXT;

  /**
   * The feature id for the '<em><b>Rationale</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD__RATIONALE = CONTRACTUAL_ELEMENT__RATIONALE;

  /**
   * The feature id for the '<em><b>Issue</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD__ISSUE = CONTRACTUAL_ELEMENT__ISSUE;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD__CATEGORY = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD__DESCRIPTION = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Hazard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HAZARD_FEATURE_COUNT = CONTRACTUAL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.reqspec.reqSpec.impl.ExternalDocumentImpl <em>External Document</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.reqspec.reqSpec.impl.ExternalDocumentImpl
   * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getExternalDocument()
   * @generated
   */
  int EXTERNAL_DOCUMENT = 9;

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
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ReqSpecContainer <em>Container</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Container</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecContainer
   * @generated
   */
  EClass getReqSpecContainer();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.ReqSpecContainer#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecContainer#getTarget()
   * @see #getReqSpecContainer()
   * @generated
   */
  EReference getReqSpecContainer_Target();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.ReqSpecContainer#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Content</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecContainer#getContent()
   * @see #getReqSpecContainer()
   * @generated
   */
  EReference getReqSpecContainer_Content();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.reqspec.reqSpec.ReqSpecContainer#getIssue <em>Issue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Issue</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecContainer#getIssue()
   * @see #getReqSpecContainer()
   * @generated
   */
  EAttribute getReqSpecContainer_Issue();

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
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.ContractualElement#getTargetContext <em>Target Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Context</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getTargetContext()
   * @see #getContractualElement()
   * @generated
   */
  EReference getContractualElement_TargetContext();

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
   * Returns the meta object for the attribute list '{@link org.osate.reqspec.reqSpec.ContractualElement#getIssue <em>Issue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Issue</em>'.
   * @see org.osate.reqspec.reqSpec.ContractualElement#getIssue()
   * @see #getContractualElement()
   * @generated
   */
  EAttribute getContractualElement_Issue();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.ReqSpecModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecModel
   * @generated
   */
  EClass getReqSpecModel();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.ReqSpecModel#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecModel#getName()
   * @see #getReqSpecModel()
   * @generated
   */
  EAttribute getReqSpecModel_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.ReqSpecModel#getImport <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Import</em>'.
   * @see org.osate.reqspec.reqSpec.ReqSpecModel#getImport()
   * @see #getReqSpecModel()
   * @generated
   */
  EReference getReqSpecModel_Import();

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
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.RSLVariable <em>RSL Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>RSL Variable</em>'.
   * @see org.osate.reqspec.reqSpec.RSLVariable
   * @generated
   */
  EClass getRSLVariable();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.RSLVariable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.reqspec.reqSpec.RSLVariable#getName()
   * @see #getRSLVariable()
   * @generated
   */
  EAttribute getRSLVariable_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.RSLVariable#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.reqspec.reqSpec.RSLVariable#getValue()
   * @see #getRSLVariable()
   * @generated
   */
  EAttribute getRSLVariable_Value();

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
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.Goal#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Category</em>'.
   * @see org.osate.reqspec.reqSpec.Goal#getCategory()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_Category();

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
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.Goal#getAssert <em>Assert</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Assert</em>'.
   * @see org.osate.reqspec.reqSpec.Goal#getAssert()
   * @see #getGoal()
   * @generated
   */
  EAttribute getGoal_Assert();

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
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.Goal#getSubgoal <em>Subgoal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Subgoal</em>'.
   * @see org.osate.reqspec.reqSpec.Goal#getSubgoal()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_Subgoal();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Goal#getDecomposesReference <em>Decomposes Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Decomposes Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Goal#getDecomposesReference()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_DecomposesReference();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Goal#getEvolvesReference <em>Evolves Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Evolves Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Goal#getEvolvesReference()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_EvolvesReference();

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
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Goal#getStakeholderRequirementReference <em>Stakeholder Requirement Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Stakeholder Requirement Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Goal#getStakeholderRequirementReference()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_StakeholderRequirementReference();

  /**
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Goal#getSystemRequirementReference <em>System Requirement Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>System Requirement Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Goal#getSystemRequirementReference()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_SystemRequirementReference();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.Goal#getDocReference <em>Doc Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Doc Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Goal#getDocReference()
   * @see #getGoal()
   * @generated
   */
  EReference getGoal_DocReference();

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
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.Requirement#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Category</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getCategory()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_Category();

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
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.Requirement#getAssert <em>Assert</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Assert</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getAssert()
   * @see #getRequirement()
   * @generated
   */
  EAttribute getRequirement_Assert();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.Requirement#getReqValue <em>Req Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Req Value</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getReqValue()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_ReqValue();

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
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Requirement#getHazardReference <em>Hazard Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Hazard Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getHazardReference()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_HazardReference();

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
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.Requirement#getSubrequirement <em>Subrequirement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Subrequirement</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getSubrequirement()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_Subrequirement();

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
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Requirement#getEvolvesReference <em>Evolves Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Evolves Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getEvolvesReference()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_EvolvesReference();

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
   * Returns the meta object for the reference list '{@link org.osate.reqspec.reqSpec.Requirement#getSystemRequirementReference <em>System Requirement Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>System Requirement Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getSystemRequirementReference()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_SystemRequirementReference();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.reqspec.reqSpec.Requirement#getDocReference <em>Doc Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Doc Reference</em>'.
   * @see org.osate.reqspec.reqSpec.Requirement#getDocReference()
   * @see #getRequirement()
   * @generated
   */
  EReference getRequirement_DocReference();

  /**
   * Returns the meta object for class '{@link org.osate.reqspec.reqSpec.Hazard <em>Hazard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hazard</em>'.
   * @see org.osate.reqspec.reqSpec.Hazard
   * @generated
   */
  EClass getHazard();

  /**
   * Returns the meta object for the reference '{@link org.osate.reqspec.reqSpec.Hazard#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Category</em>'.
   * @see org.osate.reqspec.reqSpec.Hazard#getCategory()
   * @see #getHazard()
   * @generated
   */
  EReference getHazard_Category();

  /**
   * Returns the meta object for the attribute '{@link org.osate.reqspec.reqSpec.Hazard#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see org.osate.reqspec.reqSpec.Hazard#getDescription()
   * @see #getHazard()
   * @generated
   */
  EAttribute getHazard_Description();

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
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ReqSpecContainerImpl <em>Container</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecContainerImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqSpecContainer()
     * @generated
     */
    EClass REQ_SPEC_CONTAINER = eINSTANCE.getReqSpecContainer();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_SPEC_CONTAINER__TARGET = eINSTANCE.getReqSpecContainer_Target();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_SPEC_CONTAINER__CONTENT = eINSTANCE.getReqSpecContainer_Content();

    /**
     * The meta object literal for the '<em><b>Issue</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQ_SPEC_CONTAINER__ISSUE = eINSTANCE.getReqSpecContainer_Issue();

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
     * The meta object literal for the '<em><b>Target Context</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTRACTUAL_ELEMENT__TARGET_CONTEXT = eINSTANCE.getContractualElement_TargetContext();

    /**
     * The meta object literal for the '<em><b>Rationale</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACTUAL_ELEMENT__RATIONALE = eINSTANCE.getContractualElement_Rationale();

    /**
     * The meta object literal for the '<em><b>Issue</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONTRACTUAL_ELEMENT__ISSUE = eINSTANCE.getContractualElement_Issue();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.ReqSpecModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecModelImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getReqSpecModel()
     * @generated
     */
    EClass REQ_SPEC_MODEL = eINSTANCE.getReqSpecModel();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQ_SPEC_MODEL__NAME = eINSTANCE.getReqSpecModel_Name();

    /**
     * The meta object literal for the '<em><b>Import</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQ_SPEC_MODEL__IMPORT = eINSTANCE.getReqSpecModel_Import();

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
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.RSLVariableImpl <em>RSL Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.RSLVariableImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getRSLVariable()
     * @generated
     */
    EClass RSL_VARIABLE = eINSTANCE.getRSLVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RSL_VARIABLE__NAME = eINSTANCE.getRSLVariable_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RSL_VARIABLE__VALUE = eINSTANCE.getRSLVariable_Value();

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
     * The meta object literal for the '<em><b>Category</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__CATEGORY = eINSTANCE.getGoal_Category();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__DESCRIPTION = eINSTANCE.getGoal_Description();

    /**
     * The meta object literal for the '<em><b>Assert</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute GOAL__ASSERT = eINSTANCE.getGoal_Assert();

    /**
     * The meta object literal for the '<em><b>Refines Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__REFINES_REFERENCE = eINSTANCE.getGoal_RefinesReference();

    /**
     * The meta object literal for the '<em><b>Subgoal</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__SUBGOAL = eINSTANCE.getGoal_Subgoal();

    /**
     * The meta object literal for the '<em><b>Decomposes Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__DECOMPOSES_REFERENCE = eINSTANCE.getGoal_DecomposesReference();

    /**
     * The meta object literal for the '<em><b>Evolves Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__EVOLVES_REFERENCE = eINSTANCE.getGoal_EvolvesReference();

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
     * The meta object literal for the '<em><b>Stakeholder Requirement Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__STAKEHOLDER_REQUIREMENT_REFERENCE = eINSTANCE.getGoal_StakeholderRequirementReference();

    /**
     * The meta object literal for the '<em><b>System Requirement Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__SYSTEM_REQUIREMENT_REFERENCE = eINSTANCE.getGoal_SystemRequirementReference();

    /**
     * The meta object literal for the '<em><b>Doc Reference</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GOAL__DOC_REFERENCE = eINSTANCE.getGoal_DocReference();

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
     * The meta object literal for the '<em><b>Category</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__CATEGORY = eINSTANCE.getRequirement_Category();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__DESCRIPTION = eINSTANCE.getRequirement_Description();

    /**
     * The meta object literal for the '<em><b>Assert</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQUIREMENT__ASSERT = eINSTANCE.getRequirement_Assert();

    /**
     * The meta object literal for the '<em><b>Req Value</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__REQ_VALUE = eINSTANCE.getRequirement_ReqValue();

    /**
     * The meta object literal for the '<em><b>Goal Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__GOAL_REFERENCE = eINSTANCE.getRequirement_GoalReference();

    /**
     * The meta object literal for the '<em><b>Hazard Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__HAZARD_REFERENCE = eINSTANCE.getRequirement_HazardReference();

    /**
     * The meta object literal for the '<em><b>Refines Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__REFINES_REFERENCE = eINSTANCE.getRequirement_RefinesReference();

    /**
     * The meta object literal for the '<em><b>Subrequirement</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__SUBREQUIREMENT = eINSTANCE.getRequirement_Subrequirement();

    /**
     * The meta object literal for the '<em><b>Decomposes Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__DECOMPOSES_REFERENCE = eINSTANCE.getRequirement_DecomposesReference();

    /**
     * The meta object literal for the '<em><b>Evolves Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__EVOLVES_REFERENCE = eINSTANCE.getRequirement_EvolvesReference();

    /**
     * The meta object literal for the '<em><b>Stakeholder Requirement Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__STAKEHOLDER_REQUIREMENT_REFERENCE = eINSTANCE.getRequirement_StakeholderRequirementReference();

    /**
     * The meta object literal for the '<em><b>System Requirement Reference</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__SYSTEM_REQUIREMENT_REFERENCE = eINSTANCE.getRequirement_SystemRequirementReference();

    /**
     * The meta object literal for the '<em><b>Doc Reference</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIREMENT__DOC_REFERENCE = eINSTANCE.getRequirement_DocReference();

    /**
     * The meta object literal for the '{@link org.osate.reqspec.reqSpec.impl.HazardImpl <em>Hazard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.reqspec.reqSpec.impl.HazardImpl
     * @see org.osate.reqspec.reqSpec.impl.ReqSpecPackageImpl#getHazard()
     * @generated
     */
    EClass HAZARD = eINSTANCE.getHazard();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference HAZARD__CATEGORY = eINSTANCE.getHazard_Category();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HAZARD__DESCRIPTION = eINSTANCE.getHazard_Description();

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
