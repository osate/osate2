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
   * The feature id for the '<em><b>Assure</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__ASSURE = 4;

  /**
   * The feature id for the '<em><b>Assure Subsystems</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__ASSURE_SUBSYSTEMS = 5;

  /**
   * The feature id for the '<em><b>Assure All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__ASSURE_ALL = 6;

  /**
   * The feature id for the '<em><b>Assume Subsystems</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__ASSUME_SUBSYSTEMS = 7;

  /**
   * The feature id for the '<em><b>Assume All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__ASSUME_ALL = 8;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__ISSUES = 9;

  /**
   * The number of structural features of the '<em>Assurance Plan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN_FEATURE_COUNT = 10;

  /**
   * The meta object id for the '{@link org.osate.alisa.workbench.alisa.impl.CategoryFilterImpl <em>Category Filter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.workbench.alisa.impl.CategoryFilterImpl
   * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getCategoryFilter()
   * @generated
   */
  int CATEGORY_FILTER = 2;

  /**
   * The number of structural features of the '<em>Category Filter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FILTER_FEATURE_COUNT = 0;

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
  int ASSURANCE_TASK__NAME = CATEGORY_FILTER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__TITLE = CATEGORY_FILTER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Assurance Plan</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ASSURANCE_PLAN = CATEGORY_FILTER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__DESCRIPTION = CATEGORY_FILTER_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Requirement Type</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__REQUIREMENT_TYPE = CATEGORY_FILTER_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Any Requirement Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ANY_REQUIREMENT_TYPE = CATEGORY_FILTER_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Method Type</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__METHOD_TYPE = CATEGORY_FILTER_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Any Method Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ANY_METHOD_TYPE = CATEGORY_FILTER_FEATURE_COUNT + 7;

  /**
   * The feature id for the '<em><b>User Selection</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__USER_SELECTION = CATEGORY_FILTER_FEATURE_COUNT + 8;

  /**
   * The feature id for the '<em><b>Any User Selection</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ANY_USER_SELECTION = CATEGORY_FILTER_FEATURE_COUNT + 9;

  /**
   * The feature id for the '<em><b>Quality Attribute</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__QUALITY_ATTRIBUTE = CATEGORY_FILTER_FEATURE_COUNT + 10;

  /**
   * The feature id for the '<em><b>Any Quality Attribute</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ANY_QUALITY_ATTRIBUTE = CATEGORY_FILTER_FEATURE_COUNT + 11;

  /**
   * The feature id for the '<em><b>Development Phase</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__DEVELOPMENT_PHASE = CATEGORY_FILTER_FEATURE_COUNT + 12;

  /**
   * The feature id for the '<em><b>Any Development Phase</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ANY_DEVELOPMENT_PHASE = CATEGORY_FILTER_FEATURE_COUNT + 13;

  /**
   * The feature id for the '<em><b>Issues</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__ISSUES = CATEGORY_FILTER_FEATURE_COUNT + 14;

  /**
   * The number of structural features of the '<em>Assurance Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK_FEATURE_COUNT = CATEGORY_FILTER_FEATURE_COUNT + 15;


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
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getAssure <em>Assure</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Assure</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getAssure()
   * @see #getAssurancePlan()
   * @generated
   */
  EReference getAssurancePlan_Assure();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getAssureSubsystems <em>Assure Subsystems</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Assure Subsystems</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getAssureSubsystems()
   * @see #getAssurancePlan()
   * @generated
   */
  EReference getAssurancePlan_AssureSubsystems();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.AssurancePlan#isAssureAll <em>Assure All</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Assure All</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#isAssureAll()
   * @see #getAssurancePlan()
   * @generated
   */
  EAttribute getAssurancePlan_AssureAll();

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
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.AssurancePlan#isAssumeAll <em>Assume All</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Assume All</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#isAssumeAll()
   * @see #getAssurancePlan()
   * @generated
   */
  EAttribute getAssurancePlan_AssumeAll();

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
   * Returns the meta object for class '{@link org.osate.alisa.workbench.alisa.CategoryFilter <em>Category Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Category Filter</em>'.
   * @see org.osate.alisa.workbench.alisa.CategoryFilter
   * @generated
   */
  EClass getCategoryFilter();

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
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getRequirementType <em>Requirement Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Requirement Type</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getRequirementType()
   * @see #getAssuranceTask()
   * @generated
   */
  EReference getAssuranceTask_RequirementType();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyRequirementType <em>Any Requirement Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Any Requirement Type</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#isAnyRequirementType()
   * @see #getAssuranceTask()
   * @generated
   */
  EAttribute getAssuranceTask_AnyRequirementType();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getMethodType <em>Method Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Method Type</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getMethodType()
   * @see #getAssuranceTask()
   * @generated
   */
  EReference getAssuranceTask_MethodType();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyMethodType <em>Any Method Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Any Method Type</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#isAnyMethodType()
   * @see #getAssuranceTask()
   * @generated
   */
  EAttribute getAssuranceTask_AnyMethodType();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getUserSelection <em>User Selection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>User Selection</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getUserSelection()
   * @see #getAssuranceTask()
   * @generated
   */
  EReference getAssuranceTask_UserSelection();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyUserSelection <em>Any User Selection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Any User Selection</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#isAnyUserSelection()
   * @see #getAssuranceTask()
   * @generated
   */
  EAttribute getAssuranceTask_AnyUserSelection();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getQualityAttribute <em>Quality Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Quality Attribute</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getQualityAttribute()
   * @see #getAssuranceTask()
   * @generated
   */
  EReference getAssuranceTask_QualityAttribute();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyQualityAttribute <em>Any Quality Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Any Quality Attribute</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#isAnyQualityAttribute()
   * @see #getAssuranceTask()
   * @generated
   */
  EAttribute getAssuranceTask_AnyQualityAttribute();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getDevelopmentPhase <em>Development Phase</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Development Phase</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getDevelopmentPhase()
   * @see #getAssuranceTask()
   * @generated
   */
  EReference getAssuranceTask_DevelopmentPhase();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.AssuranceTask#isAnyDevelopmentPhase <em>Any Development Phase</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Any Development Phase</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#isAnyDevelopmentPhase()
   * @see #getAssuranceTask()
   * @generated
   */
  EAttribute getAssuranceTask_AnyDevelopmentPhase();

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
     * The meta object literal for the '<em><b>Assure</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_PLAN__ASSURE = eINSTANCE.getAssurancePlan_Assure();

    /**
     * The meta object literal for the '<em><b>Assure Subsystems</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_PLAN__ASSURE_SUBSYSTEMS = eINSTANCE.getAssurancePlan_AssureSubsystems();

    /**
     * The meta object literal for the '<em><b>Assure All</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_PLAN__ASSURE_ALL = eINSTANCE.getAssurancePlan_AssureAll();

    /**
     * The meta object literal for the '<em><b>Assume Subsystems</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_PLAN__ASSUME_SUBSYSTEMS = eINSTANCE.getAssurancePlan_AssumeSubsystems();

    /**
     * The meta object literal for the '<em><b>Assume All</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_PLAN__ASSUME_ALL = eINSTANCE.getAssurancePlan_AssumeAll();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_PLAN__ISSUES = eINSTANCE.getAssurancePlan_Issues();

    /**
     * The meta object literal for the '{@link org.osate.alisa.workbench.alisa.impl.CategoryFilterImpl <em>Category Filter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.workbench.alisa.impl.CategoryFilterImpl
     * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getCategoryFilter()
     * @generated
     */
    EClass CATEGORY_FILTER = eINSTANCE.getCategoryFilter();

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
     * The meta object literal for the '<em><b>Requirement Type</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_TASK__REQUIREMENT_TYPE = eINSTANCE.getAssuranceTask_RequirementType();

    /**
     * The meta object literal for the '<em><b>Any Requirement Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_TASK__ANY_REQUIREMENT_TYPE = eINSTANCE.getAssuranceTask_AnyRequirementType();

    /**
     * The meta object literal for the '<em><b>Method Type</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_TASK__METHOD_TYPE = eINSTANCE.getAssuranceTask_MethodType();

    /**
     * The meta object literal for the '<em><b>Any Method Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_TASK__ANY_METHOD_TYPE = eINSTANCE.getAssuranceTask_AnyMethodType();

    /**
     * The meta object literal for the '<em><b>User Selection</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_TASK__USER_SELECTION = eINSTANCE.getAssuranceTask_UserSelection();

    /**
     * The meta object literal for the '<em><b>Any User Selection</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_TASK__ANY_USER_SELECTION = eINSTANCE.getAssuranceTask_AnyUserSelection();

    /**
     * The meta object literal for the '<em><b>Quality Attribute</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_TASK__QUALITY_ATTRIBUTE = eINSTANCE.getAssuranceTask_QualityAttribute();

    /**
     * The meta object literal for the '<em><b>Any Quality Attribute</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_TASK__ANY_QUALITY_ATTRIBUTE = eINSTANCE.getAssuranceTask_AnyQualityAttribute();

    /**
     * The meta object literal for the '<em><b>Development Phase</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_TASK__DEVELOPMENT_PHASE = eINSTANCE.getAssuranceTask_DevelopmentPhase();

    /**
     * The meta object literal for the '<em><b>Any Development Phase</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_TASK__ANY_DEVELOPMENT_PHASE = eINSTANCE.getAssuranceTask_AnyDevelopmentPhase();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSURANCE_TASK__ISSUES = eINSTANCE.getAssuranceTask_Issues();

  }

} //AlisaPackage
