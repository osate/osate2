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
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALISA_WORK_AREA__NAME = 0;

  /**
   * The feature id for the '<em><b>Cases</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALISA_WORK_AREA__CASES = 1;

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
   * The feature id for the '<em><b>System</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__SYSTEM = 2;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__DESCRIPTION = 3;

  /**
   * The feature id for the '<em><b>Plans</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__PLANS = 4;

  /**
   * The feature id for the '<em><b>Verified Assumption</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN__VERIFIED_ASSUMPTION = 5;

  /**
   * The number of structural features of the '<em>Assurance Plan</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_PLAN_FEATURE_COUNT = 6;

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
   * The feature id for the '<em><b>Filter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK__FILTER = 3;

  /**
   * The number of structural features of the '<em>Assurance Task</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSURANCE_TASK_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.osate.alisa.workbench.alisa.impl.SelectionConditionExprImpl <em>Selection Condition Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.workbench.alisa.impl.SelectionConditionExprImpl
   * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getSelectionConditionExpr()
   * @generated
   */
  int SELECTION_CONDITION_EXPR = 3;

  /**
   * The number of structural features of the '<em>Selection Condition Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CONDITION_EXPR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.alisa.workbench.alisa.impl.SelectionCategoryReferenceImpl <em>Selection Category Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.workbench.alisa.impl.SelectionCategoryReferenceImpl
   * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getSelectionCategoryReference()
   * @generated
   */
  int SELECTION_CATEGORY_REFERENCE = 4;

  /**
   * The feature id for the '<em><b>Cat</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CATEGORY_REFERENCE__CAT = SELECTION_CONDITION_EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Selection Category Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_CATEGORY_REFERENCE_FEATURE_COUNT = SELECTION_CONDITION_EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.workbench.alisa.impl.DescriptionImpl <em>Description</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.workbench.alisa.impl.DescriptionImpl
   * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getDescription()
   * @generated
   */
  int DESCRIPTION = 5;

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
  int DESCRIPTION_ELEMENT = 6;

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
   * The meta object id for the '{@link org.osate.alisa.workbench.alisa.impl.AndSelectionConditionExprImpl <em>And Selection Condition Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.workbench.alisa.impl.AndSelectionConditionExprImpl
   * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getAndSelectionConditionExpr()
   * @generated
   */
  int AND_SELECTION_CONDITION_EXPR = 7;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_SELECTION_CONDITION_EXPR__LEFT = SELECTION_CONDITION_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_SELECTION_CONDITION_EXPR__RIGHT = SELECTION_CONDITION_EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>And Selection Condition Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AND_SELECTION_CONDITION_EXPR_FEATURE_COUNT = SELECTION_CONDITION_EXPR_FEATURE_COUNT + 2;


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
   * Returns the meta object for the attribute '{@link org.osate.alisa.workbench.alisa.AlisaWorkArea#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.alisa.workbench.alisa.AlisaWorkArea#getName()
   * @see #getAlisaWorkArea()
   * @generated
   */
  EAttribute getAlisaWorkArea_Name();

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
   * Returns the meta object for the reference '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getSystem <em>System</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>System</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getSystem()
   * @see #getAssurancePlan()
   * @generated
   */
  EReference getAssurancePlan_System();

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
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getPlans <em>Plans</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Plans</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getPlans()
   * @see #getAssurancePlan()
   * @generated
   */
  EReference getAssurancePlan_Plans();

  /**
   * Returns the meta object for the reference list '{@link org.osate.alisa.workbench.alisa.AssurancePlan#getVerifiedAssumption <em>Verified Assumption</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Verified Assumption</em>'.
   * @see org.osate.alisa.workbench.alisa.AssurancePlan#getVerifiedAssumption()
   * @see #getAssurancePlan()
   * @generated
   */
  EReference getAssurancePlan_VerifiedAssumption();

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
   * Returns the meta object for the containment reference '{@link org.osate.alisa.workbench.alisa.AssuranceTask#getFilter <em>Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Filter</em>'.
   * @see org.osate.alisa.workbench.alisa.AssuranceTask#getFilter()
   * @see #getAssuranceTask()
   * @generated
   */
  EReference getAssuranceTask_Filter();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.workbench.alisa.SelectionConditionExpr <em>Selection Condition Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selection Condition Expr</em>'.
   * @see org.osate.alisa.workbench.alisa.SelectionConditionExpr
   * @generated
   */
  EClass getSelectionConditionExpr();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.workbench.alisa.SelectionCategoryReference <em>Selection Category Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selection Category Reference</em>'.
   * @see org.osate.alisa.workbench.alisa.SelectionCategoryReference
   * @generated
   */
  EClass getSelectionCategoryReference();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.workbench.alisa.SelectionCategoryReference#getCat <em>Cat</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Cat</em>'.
   * @see org.osate.alisa.workbench.alisa.SelectionCategoryReference#getCat()
   * @see #getSelectionCategoryReference()
   * @generated
   */
  EReference getSelectionCategoryReference_Cat();

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
   * Returns the meta object for class '{@link org.osate.alisa.workbench.alisa.AndSelectionConditionExpr <em>And Selection Condition Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>And Selection Condition Expr</em>'.
   * @see org.osate.alisa.workbench.alisa.AndSelectionConditionExpr
   * @generated
   */
  EClass getAndSelectionConditionExpr();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.workbench.alisa.AndSelectionConditionExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.osate.alisa.workbench.alisa.AndSelectionConditionExpr#getLeft()
   * @see #getAndSelectionConditionExpr()
   * @generated
   */
  EReference getAndSelectionConditionExpr_Left();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.workbench.alisa.AndSelectionConditionExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.osate.alisa.workbench.alisa.AndSelectionConditionExpr#getRight()
   * @see #getAndSelectionConditionExpr()
   * @generated
   */
  EReference getAndSelectionConditionExpr_Right();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ALISA_WORK_AREA__NAME = eINSTANCE.getAlisaWorkArea_Name();

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
     * The meta object literal for the '<em><b>System</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_PLAN__SYSTEM = eINSTANCE.getAssurancePlan_System();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_PLAN__DESCRIPTION = eINSTANCE.getAssurancePlan_Description();

    /**
     * The meta object literal for the '<em><b>Plans</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_PLAN__PLANS = eINSTANCE.getAssurancePlan_Plans();

    /**
     * The meta object literal for the '<em><b>Verified Assumption</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_PLAN__VERIFIED_ASSUMPTION = eINSTANCE.getAssurancePlan_VerifiedAssumption();

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
     * The meta object literal for the '<em><b>Filter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSURANCE_TASK__FILTER = eINSTANCE.getAssuranceTask_Filter();

    /**
     * The meta object literal for the '{@link org.osate.alisa.workbench.alisa.impl.SelectionConditionExprImpl <em>Selection Condition Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.workbench.alisa.impl.SelectionConditionExprImpl
     * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getSelectionConditionExpr()
     * @generated
     */
    EClass SELECTION_CONDITION_EXPR = eINSTANCE.getSelectionConditionExpr();

    /**
     * The meta object literal for the '{@link org.osate.alisa.workbench.alisa.impl.SelectionCategoryReferenceImpl <em>Selection Category Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.workbench.alisa.impl.SelectionCategoryReferenceImpl
     * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getSelectionCategoryReference()
     * @generated
     */
    EClass SELECTION_CATEGORY_REFERENCE = eINSTANCE.getSelectionCategoryReference();

    /**
     * The meta object literal for the '<em><b>Cat</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION_CATEGORY_REFERENCE__CAT = eINSTANCE.getSelectionCategoryReference_Cat();

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

    /**
     * The meta object literal for the '{@link org.osate.alisa.workbench.alisa.impl.AndSelectionConditionExprImpl <em>And Selection Condition Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.workbench.alisa.impl.AndSelectionConditionExprImpl
     * @see org.osate.alisa.workbench.alisa.impl.AlisaPackageImpl#getAndSelectionConditionExpr()
     * @generated
     */
    EClass AND_SELECTION_CONDITION_EXPR = eINSTANCE.getAndSelectionConditionExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_SELECTION_CONDITION_EXPR__LEFT = eINSTANCE.getAndSelectionConditionExpr_Left();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AND_SELECTION_CONDITION_EXPR__RIGHT = eINSTANCE.getAndSelectionConditionExpr_Right();

  }

} //AlisaPackage
