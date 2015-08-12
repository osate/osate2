/**
 */
package org.osate.alisa.workbench.alisa;

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
 * @see org.osate.alisa.workbench.alisa.AlisaFactory
 * @model kind="package"
 * @generated
 */
public interface AlisaPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "alisa";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/alisa/workbench/Alisa";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "alisa";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AlisaPackage eINSTANCE = org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.alisa.workbench.alisa.impl.AlisaWorkAreaImpl <em>Work Area</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.workbench.alisa.impl.AlisaWorkAreaImpl
   * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getAlisaWorkArea()
   * @generated
   */
  int ALISA_WORK_AREA = 0;

  /**
   * The feature id for the '<em><b>Cases</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALISA_WORK_AREA__CASES = 0;

  /**
   * The number of structural features of the '<em>Work Area</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALISA_WORK_AREA_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl <em>Assurance Plan</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl
   * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getAssurancePlan()
   * @generated
   */
  int ASSURANCE_PLAN = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__NAME = 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__TITLE = 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__TARGET = 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__DESCRIPTION = 3;

  /**
   * The feature id for the '<em><b>Assure All</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__ASSURE_ALL = 4;

  /**
   * The feature id for the '<em><b>Assure Plans</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__ASSURE_PLANS = 5;

  /**
   * The feature id for the '<em><b>Assume Subsystems</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__ASSUME_SUBSYSTEMS = 6;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__ISSUES = 7;

  /**
   * The number of structural features of the '<em>Assurance Plan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl <em>Assurance Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl
   * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getAssuranceTask()
   * @generated
   */
  int ASSURANCE_TASK = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__NAME = 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__TITLE = 1;

  /**
   * The feature id for the '<em><b>Assurance Plan</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ASSURANCE_PLAN = 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__DESCRIPTION = 3;

  /**
   * The feature id for the '<em><b>Requirement Filter</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__REQUIREMENT_FILTER = 4;

  /**
   * The feature id for the '<em><b>Verification Filter</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__VERIFICATION_FILTER = 5;

  /**
   * The feature id for the '<em><b>Selection Filter</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__SELECTION_FILTER = 6;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ISSUES = 7;

  /**
   * The number of structural features of the '<em>Assurance Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link org.osate.alisa.workbench.alisa.impl.DescriptionImpl <em>Description</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.workbench.alisa.impl.DescriptionImpl
   * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getDescription()
   * @generated
   */
  int DESCRIPTION = 3;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION__DESCRIPTION = 0;

  /**
   * The number of structural features of the '<em>Description</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.workbench.alisa.impl.DescriptionElementImpl <em>Description Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.workbench.alisa.impl.DescriptionElementImpl
   * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getDescriptionElement()
   * @generated
   */
  int DESCRIPTION_ELEMENT = 4;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT__TEXT = 0;

  /**
   * The feature id for the '<em><b>This Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT__THIS_TARGET = 1;

  /**
   * The number of structural features of the '<em>Description Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.osate.alisa.workbench.alisa.AlisaWorkArea <em>Work Area</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Work Area</em>'.
   * @see org.osate.alisa.workbench.alisa.AlisaWorkArea
   * @generated
   */
  EClass getAlisaWorkArea();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.alisa.workbench.alisa.AlisaWorkArea#getCases <em>Cases</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Cases</em>'.
   * @see org.osate.alisa.workbench.alisa.AlisaWorkArea#getCases()
   * @see #getAlisaWorkArea()
   * @generated
   */
  EReference getAlisaWorkArea_Cases();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.workbench.alisa.AssurancePlan <em>Assurance Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assurance Plan</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan
   * @generated
   */
  EClass getAssurancePlan();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getName()
   * @see #getAssurancePlan()
   * @generated
   */
  EAttribute getAssurancePlan_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getTitle()
   * @see #getAssurancePlan()
   * @generated
   */
  EAttribute getAssurancePlan_Title();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getTarget()
   * @see #getAssurancePlan()
   * @generated
   */
  EReference getAssurancePlan_Target();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getDescription()
   * @see #getAssurancePlan()
   * @generated
   */
  EReference getAssurancePlan_Description();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getAssureAll <em>Assure All</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Assure All</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getAssureAll()
   * @see #getAssurancePlan()
   * @generated
   */
  EReference getAssurancePlan_AssureAll();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getAssurePlans <em>Assure Plans</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Assure Plans</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getAssurePlans()
   * @see #getAssurancePlan()
   * @generated
   */
  EReference getAssurancePlan_AssurePlans();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getAssumeSubsystems <em>Assume Subsystems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Assume Subsystems</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getAssumeSubsystems()
   * @see #getAssurancePlan()
   * @generated
   */
  EReference getAssurancePlan_AssumeSubsystems();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Issues</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getIssues()
   * @see #getAssurancePlan()
   * @generated
   */
  EAttribute getAssurancePlan_Issues();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.workbench.alisa.AssuranceTask <em>Assurance Task</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assurance Task</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask
   * @generated
   */
  EClass getAssuranceTask();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getName()
   * @see #getAssuranceTask()
   * @generated
   */
  EAttribute getAssuranceTask_Name();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getTitle()
   * @see #getAssuranceTask()
   * @generated
   */
  EAttribute getAssuranceTask_Title();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getAssurancePlan <em>Assurance Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Assurance Plan</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getAssurancePlan()
   * @see #getAssuranceTask()
   * @generated
   */
  EReference getAssuranceTask_AssurancePlan();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getDescription()
   * @see #getAssuranceTask()
   * @generated
   */
  EReference getAssuranceTask_Description();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getRequirementFilter <em>Requirement Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Requirement Filter</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getRequirementFilter()
   * @see #getAssuranceTask()
   * @generated
   */
  EReference getAssuranceTask_RequirementFilter();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getVerificationFilter <em>Verification Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Verification Filter</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getVerificationFilter()
   * @see #getAssuranceTask()
   * @generated
   */
  EReference getAssuranceTask_VerificationFilter();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getSelectionFilter <em>Selection Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Selection Filter</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getSelectionFilter()
   * @see #getAssuranceTask()
   * @generated
   */
  EReference getAssuranceTask_SelectionFilter();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Issues</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getIssues()
   * @see #getAssuranceTask()
   * @generated
   */
  EAttribute getAssuranceTask_Issues();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.workbench.alisa.Description <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Description</em>'.
   * @see org.osate.alisa.workbench.alisa.Description
   * @generated
   */
  EClass getDescription();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.alisa.workbench.alisa.Description#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Description</em>'.
   * @see org.osate.alisa.workbench.alisa.Description#getDescription()
   * @see #getDescription()
   * @generated
   */
  EReference getDescription_Description();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.workbench.alisa.DescriptionElement <em>Description Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Description Element</em>'.
   * @see org.osate.alisa.workbench.alisa.DescriptionElement
   * @generated
   */
  EClass getDescriptionElement();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.DescriptionElement#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see org.osate.alisa.workbench.alisa.DescriptionElement#getText()
   * @see #getDescriptionElement()
   * @generated
   */
  EAttribute getDescriptionElement_Text();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.DescriptionElement#isThisTarget <em>This Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>This Target</em>'.
   * @see org.osate.alisa.workbench.alisa.DescriptionElement#isThisTarget()
   * @see #getDescriptionElement()
   * @generated
   */
  EAttribute getDescriptionElement_ThisTarget();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  AlisaFactory getAlisaFactory();

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
     * The meta object literal for the '{@link org.osate.alisa.workbench.alisa.impl.AlisaWorkAreaImpl <em>Work Area</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.workbench.alisa.impl.AlisaWorkAreaImpl
     * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getAlisaWorkArea()
     * @generated
     */
    EClass ALISA_WORK_AREA = eINSTANCE.getAlisaWorkArea();

    /**
     * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALISA_WORK_AREA__CASES = eINSTANCE.getAlisaWorkArea_Cases();

    /**
     * The meta object literal for the '{@link org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl <em>Assurance Plan</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.workbench.alisa.impl.AssurancePlanImpl
     * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getAssurancePlan()
     * @generated
     */
    EClass ASSURANCE_PLAN = eINSTANCE.getAssurancePlan();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_PLAN__NAME = eINSTANCE.getAssurancePlan_Name();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_PLAN__TITLE = eINSTANCE.getAssurancePlan_Title();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_PLAN__TARGET = eINSTANCE.getAssurancePlan_Target();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_PLAN__DESCRIPTION = eINSTANCE.getAssurancePlan_Description();

    /**
     * The meta object literal for the '<em><b>Assure All</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_PLAN__ASSURE_ALL = eINSTANCE.getAssurancePlan_AssureAll();

    /**
     * The meta object literal for the '<em><b>Assure Plans</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_PLAN__ASSURE_PLANS = eINSTANCE.getAssurancePlan_AssurePlans();

    /**
     * The meta object literal for the '<em><b>Assume Subsystems</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_PLAN__ASSUME_SUBSYSTEMS = eINSTANCE.getAssurancePlan_AssumeSubsystems();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_PLAN__ISSUES = eINSTANCE.getAssurancePlan_Issues();

    /**
     * The meta object literal for the '{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl <em>Assurance Task</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl
     * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getAssuranceTask()
     * @generated
     */
    EClass ASSURANCE_TASK = eINSTANCE.getAssuranceTask();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_TASK__NAME = eINSTANCE.getAssuranceTask_Name();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_TASK__TITLE = eINSTANCE.getAssuranceTask_Title();

    /**
     * The meta object literal for the '<em><b>Assurance Plan</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_TASK__ASSURANCE_PLAN = eINSTANCE.getAssuranceTask_AssurancePlan();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_TASK__DESCRIPTION = eINSTANCE.getAssuranceTask_Description();

    /**
     * The meta object literal for the '<em><b>Requirement Filter</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_TASK__REQUIREMENT_FILTER = eINSTANCE.getAssuranceTask_RequirementFilter();

    /**
     * The meta object literal for the '<em><b>Verification Filter</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_TASK__VERIFICATION_FILTER = eINSTANCE.getAssuranceTask_VerificationFilter();

    /**
     * The meta object literal for the '<em><b>Selection Filter</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_TASK__SELECTION_FILTER = eINSTANCE.getAssuranceTask_SelectionFilter();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_TASK__ISSUES = eINSTANCE.getAssuranceTask_Issues();

    /**
     * The meta object literal for the '{@link org.osate.alisa.workbench.alisa.impl.DescriptionImpl <em>Description</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.workbench.alisa.impl.DescriptionImpl
     * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getDescription()
     * @generated
     */
    EClass DESCRIPTION = eINSTANCE.getDescription();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DESCRIPTION__DESCRIPTION = eINSTANCE.getDescription_Description();

    /**
     * The meta object literal for the '{@link org.osate.alisa.workbench.alisa.impl.DescriptionElementImpl <em>Description Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.workbench.alisa.impl.DescriptionElementImpl
     * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getDescriptionElement()
     * @generated
     */
    EClass DESCRIPTION_ELEMENT = eINSTANCE.getDescriptionElement();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DESCRIPTION_ELEMENT__TEXT = eINSTANCE.getDescriptionElement_Text();

    /**
     * The meta object literal for the '<em><b>This Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DESCRIPTION_ELEMENT__THIS_TARGET = eINSTANCE.getDescriptionElement_ThisTarget();

  }

} //AlisaPackage
