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
package org.osate.alisa.workbench.alisa;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.osate.categories.categories.CategoriesPackage;

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
   * The feature id for the '<em><b>Plan</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALISA_WORK_AREA__PLAN = 0;

  /**
   * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALISA_WORK_AREA__TASKS = 1;

  /**
   * The number of structural features of the '<em>Work Area</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALISA_WORK_AREA_FEATURE_COUNT = 2;

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
   * The feature id for the '<em><b>Model Plan</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__MODEL_PLAN = 2;

  /**
   * The number of structural features of the '<em>Assurance Plan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.alisa.workbench.alisa.impl.ModelPlanImpl <em>Model Plan</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.workbench.alisa.impl.ModelPlanImpl
   * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getModelPlan()
   * @generated
   */
  int MODEL_PLAN = 2;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_PLAN__TARGET = 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_PLAN__DESCRIPTION = 1;

  /**
   * The feature id for the '<em><b>Assure</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_PLAN__ASSURE = 2;

  /**
   * The feature id for the '<em><b>Assure Subsystems</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_PLAN__ASSURE_SUBSYSTEMS = 3;

  /**
   * The feature id for the '<em><b>Assure All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_PLAN__ASSURE_ALL = 4;

  /**
   * The feature id for the '<em><b>Assume Subsystems</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_PLAN__ASSUME_SUBSYSTEMS = 5;

  /**
   * The feature id for the '<em><b>Assume All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_PLAN__ASSUME_ALL = 6;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_PLAN__ISSUES = 7;

  /**
   * The number of structural features of the '<em>Model Plan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_PLAN_FEATURE_COUNT = 8;

  /**
   * The meta object id for the '{@link org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl <em>Assurance Task</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.workbench.alisa.impl.AssuranceTaskImpl
   * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getAssuranceTask()
   * @generated
   */
  int ASSURANCE_TASK = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__NAME = CategoriesPackage.CATEGORY_FILTER__NAME;

  /**
   * The feature id for the '<em><b>User Category</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__USER_CATEGORY = CategoriesPackage.CATEGORY_FILTER__USER_CATEGORY;

  /**
   * The feature id for the '<em><b>Any User Selection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ANY_USER_SELECTION = CategoriesPackage.CATEGORY_FILTER__ANY_USER_SELECTION;

  /**
   * The feature id for the '<em><b>Quality Category</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__QUALITY_CATEGORY = CategoriesPackage.CATEGORY_FILTER__QUALITY_CATEGORY;

  /**
   * The feature id for the '<em><b>Any Quality Attribute</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ANY_QUALITY_ATTRIBUTE = CategoriesPackage.CATEGORY_FILTER__ANY_QUALITY_ATTRIBUTE;

  /**
   * The feature id for the '<em><b>Phase Category</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__PHASE_CATEGORY = CategoriesPackage.CATEGORY_FILTER__PHASE_CATEGORY;

  /**
   * The feature id for the '<em><b>Any Development Phase</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ANY_DEVELOPMENT_PHASE = CategoriesPackage.CATEGORY_FILTER__ANY_DEVELOPMENT_PHASE;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__TITLE = CategoriesPackage.CATEGORY_FILTER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Assurance Plan</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ASSURANCE_PLAN = CategoriesPackage.CATEGORY_FILTER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ISSUES = CategoriesPackage.CATEGORY_FILTER_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Assurance Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK_FEATURE_COUNT = CategoriesPackage.CATEGORY_FILTER_FEATURE_COUNT + 3;


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
   * Returns the meta object for the containment reference '{@link org.osate.alisa.workbench.alisa.AlisaWorkArea#getPlan <em>Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Plan</em>'.
   * @see org.osate.alisa.workbench.alisa.AlisaWorkArea#getPlan()
   * @see #getAlisaWorkArea()
   * @generated
   */
  EReference getAlisaWorkArea_Plan();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.alisa.workbench.alisa.AlisaWorkArea#getTasks <em>Tasks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Tasks</em>'.
   * @see org.osate.alisa.workbench.alisa.AlisaWorkArea#getTasks()
   * @see #getAlisaWorkArea()
   * @generated
   */
  EReference getAlisaWorkArea_Tasks();

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
   * Returns the meta object for the containment reference list '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getModelPlan <em>Model Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Model Plan</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getModelPlan()
   * @see #getAssurancePlan()
   * @generated
   */
  EReference getAssurancePlan_ModelPlan();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.workbench.alisa.ModelPlan <em>Model Plan</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Plan</em>'.
   * @see org.osate.alisa.workbench.alisa.ModelPlan
   * @generated
   */
  EClass getModelPlan();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.workbench.alisa.ModelPlan#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.alisa.workbench.alisa.ModelPlan#getTarget()
   * @see #getModelPlan()
   * @generated
   */
  EReference getModelPlan_Target();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.workbench.alisa.ModelPlan#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Description</em>'.
   * @see org.osate.alisa.workbench.alisa.ModelPlan#getDescription()
   * @see #getModelPlan()
   * @generated
   */
  EReference getModelPlan_Description();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.ModelPlan#getAssure <em>Assure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Assure</em>'.
   * @see org.osate.alisa.workbench.alisa.ModelPlan#getAssure()
   * @see #getModelPlan()
   * @generated
   */
  EReference getModelPlan_Assure();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.ModelPlan#getAssureSubsystems <em>Assure Subsystems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Assure Subsystems</em>'.
   * @see org.osate.alisa.workbench.alisa.ModelPlan#getAssureSubsystems()
   * @see #getModelPlan()
   * @generated
   */
  EReference getModelPlan_AssureSubsystems();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.ModelPlan#isAssureAll <em>Assure All</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Assure All</em>'.
   * @see org.osate.alisa.workbench.alisa.ModelPlan#isAssureAll()
   * @see #getModelPlan()
   * @generated
   */
  EAttribute getModelPlan_AssureAll();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.ModelPlan#getAssumeSubsystems <em>Assume Subsystems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Assume Subsystems</em>'.
   * @see org.osate.alisa.workbench.alisa.ModelPlan#getAssumeSubsystems()
   * @see #getModelPlan()
   * @generated
   */
  EReference getModelPlan_AssumeSubsystems();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.ModelPlan#isAssumeAll <em>Assume All</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Assume All</em>'.
   * @see org.osate.alisa.workbench.alisa.ModelPlan#isAssumeAll()
   * @see #getModelPlan()
   * @generated
   */
  EAttribute getModelPlan_AssumeAll();

  /**
   * Returns the meta object for the attribute list '{@link org.osate.alisa.workbench.alisa.ModelPlan#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Issues</em>'.
   * @see org.osate.alisa.workbench.alisa.ModelPlan#getIssues()
   * @see #getModelPlan()
   * @generated
   */
  EAttribute getModelPlan_Issues();

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
     * The meta object literal for the '<em><b>Plan</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALISA_WORK_AREA__PLAN = eINSTANCE.getAlisaWorkArea_Plan();

    /**
     * The meta object literal for the '<em><b>Tasks</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALISA_WORK_AREA__TASKS = eINSTANCE.getAlisaWorkArea_Tasks();

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
     * The meta object literal for the '<em><b>Model Plan</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_PLAN__MODEL_PLAN = eINSTANCE.getAssurancePlan_ModelPlan();

    /**
     * The meta object literal for the '{@link org.osate.alisa.workbench.alisa.impl.ModelPlanImpl <em>Model Plan</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.workbench.alisa.impl.ModelPlanImpl
     * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getModelPlan()
     * @generated
     */
    EClass MODEL_PLAN = eINSTANCE.getModelPlan();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_PLAN__TARGET = eINSTANCE.getModelPlan_Target();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_PLAN__DESCRIPTION = eINSTANCE.getModelPlan_Description();

    /**
     * The meta object literal for the '<em><b>Assure</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_PLAN__ASSURE = eINSTANCE.getModelPlan_Assure();

    /**
     * The meta object literal for the '<em><b>Assure Subsystems</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_PLAN__ASSURE_SUBSYSTEMS = eINSTANCE.getModelPlan_AssureSubsystems();

    /**
     * The meta object literal for the '<em><b>Assure All</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_PLAN__ASSURE_ALL = eINSTANCE.getModelPlan_AssureAll();

    /**
     * The meta object literal for the '<em><b>Assume Subsystems</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL_PLAN__ASSUME_SUBSYSTEMS = eINSTANCE.getModelPlan_AssumeSubsystems();

    /**
     * The meta object literal for the '<em><b>Assume All</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_PLAN__ASSUME_ALL = eINSTANCE.getModelPlan_AssumeAll();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODEL_PLAN__ISSUES = eINSTANCE.getModelPlan_Issues();

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
     * The meta object literal for the '<em><b>Issues</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_TASK__ISSUES = eINSTANCE.getAssuranceTask_Issues();

  }

} //AlisaPackage
