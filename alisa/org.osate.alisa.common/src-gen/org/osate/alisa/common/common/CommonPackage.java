/**
 */
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.xtext.xbase.XbasePackage;

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
 * @see org.osate.alisa.common.common.CommonFactory
 * @model kind="package"
 * @generated
 */
public interface CommonPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "common";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/alisa/common/Common";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "common";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  CommonPackage eINSTANCE = org.osate.alisa.common.common.impl.CommonPackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.DescriptionImpl <em>Description</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.DescriptionImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getDescription()
   * @generated
   */
  int DESCRIPTION = 0;

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
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.DescriptionElementImpl <em>Description Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.DescriptionElementImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getDescriptionElement()
   * @generated
   */
  int DESCRIPTION_ELEMENT = 1;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT__TEXT = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT__VALUE = 1;

  /**
   * The feature id for the '<em><b>This Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT__THIS_TARGET = 2;

  /**
   * The number of structural features of the '<em>Description Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.XExpressionImpl <em>XExpression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.XExpressionImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getXExpression()
   * @generated
   */
  int XEXPRESSION = 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XEXPRESSION__TYPE = XbasePackage.XEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XEXPRESSION__NAME = XbasePackage.XEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XEXPRESSION__RIGHT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>XExpression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XEXPRESSION_FEATURE_COUNT = XbasePackage.XEXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ShowValueImpl <em>Show Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ShowValueImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getShowValue()
   * @generated
   */
  int SHOW_VALUE = 3;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHOW_VALUE__REF = 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHOW_VALUE__UNIT = 1;

  /**
   * The number of structural features of the '<em>Show Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHOW_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.XNumberLiteralImpl <em>XNumber Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.XNumberLiteralImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getXNumberLiteral()
   * @generated
   */
  int XNUMBER_LITERAL = 4;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XNUMBER_LITERAL__TYPE = XEXPRESSION__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XNUMBER_LITERAL__NAME = XEXPRESSION__NAME;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XNUMBER_LITERAL__RIGHT = XEXPRESSION__RIGHT;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XNUMBER_LITERAL__VALUE = XEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XNUMBER_LITERAL__UNIT = XEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>XNumber Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XNUMBER_LITERAL_FEATURE_COUNT = XEXPRESSION_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.Description <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Description</em>'.
   * @see org.osate.alisa.common.common.Description
   * @generated
   */
  EClass getDescription();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.alisa.common.common.Description#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Description</em>'.
   * @see org.osate.alisa.common.common.Description#getDescription()
   * @see #getDescription()
   * @generated
   */
  EReference getDescription_Description();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.DescriptionElement <em>Description Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Description Element</em>'.
   * @see org.osate.alisa.common.common.DescriptionElement
   * @generated
   */
  EClass getDescriptionElement();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.DescriptionElement#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see org.osate.alisa.common.common.DescriptionElement#getText()
   * @see #getDescriptionElement()
   * @generated
   */
  EAttribute getDescriptionElement_Text();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.DescriptionElement#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.alisa.common.common.DescriptionElement#getValue()
   * @see #getDescriptionElement()
   * @generated
   */
  EReference getDescriptionElement_Value();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.DescriptionElement#isThisTarget <em>This Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>This Target</em>'.
   * @see org.osate.alisa.common.common.DescriptionElement#isThisTarget()
   * @see #getDescriptionElement()
   * @generated
   */
  EAttribute getDescriptionElement_ThisTarget();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.XExpression <em>XExpression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XExpression</em>'.
   * @see org.osate.alisa.common.common.XExpression
   * @generated
   */
  EClass getXExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.XExpression#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.osate.alisa.common.common.XExpression#getType()
   * @see #getXExpression()
   * @generated
   */
  EReference getXExpression_Type();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.XExpression#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.alisa.common.common.XExpression#getName()
   * @see #getXExpression()
   * @generated
   */
  EAttribute getXExpression_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.XExpression#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.osate.alisa.common.common.XExpression#getRight()
   * @see #getXExpression()
   * @generated
   */
  EReference getXExpression_Right();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ShowValue <em>Show Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Show Value</em>'.
   * @see org.osate.alisa.common.common.ShowValue
   * @generated
   */
  EClass getShowValue();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.common.common.ShowValue#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.osate.alisa.common.common.ShowValue#getRef()
   * @see #getShowValue()
   * @generated
   */
  EReference getShowValue_Ref();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.ShowValue#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.osate.alisa.common.common.ShowValue#getUnit()
   * @see #getShowValue()
   * @generated
   */
  EAttribute getShowValue_Unit();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.XNumberLiteral <em>XNumber Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>XNumber Literal</em>'.
   * @see org.osate.alisa.common.common.XNumberLiteral
   * @generated
   */
  EClass getXNumberLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.XNumberLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.alisa.common.common.XNumberLiteral#getValue()
   * @see #getXNumberLiteral()
   * @generated
   */
  EAttribute getXNumberLiteral_Value();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.common.common.XNumberLiteral#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Unit</em>'.
   * @see org.osate.alisa.common.common.XNumberLiteral#getUnit()
   * @see #getXNumberLiteral()
   * @generated
   */
  EReference getXNumberLiteral_Unit();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  CommonFactory getCommonFactory();

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
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.DescriptionImpl <em>Description</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.DescriptionImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getDescription()
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
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.DescriptionElementImpl <em>Description Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.DescriptionElementImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getDescriptionElement()
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
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DESCRIPTION_ELEMENT__VALUE = eINSTANCE.getDescriptionElement_Value();

    /**
     * The meta object literal for the '<em><b>This Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DESCRIPTION_ELEMENT__THIS_TARGET = eINSTANCE.getDescriptionElement_ThisTarget();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.XExpressionImpl <em>XExpression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.XExpressionImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getXExpression()
     * @generated
     */
    EClass XEXPRESSION = eINSTANCE.getXExpression();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XEXPRESSION__TYPE = eINSTANCE.getXExpression_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XEXPRESSION__NAME = eINSTANCE.getXExpression_Name();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XEXPRESSION__RIGHT = eINSTANCE.getXExpression_Right();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ShowValueImpl <em>Show Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ShowValueImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getShowValue()
     * @generated
     */
    EClass SHOW_VALUE = eINSTANCE.getShowValue();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHOW_VALUE__REF = eINSTANCE.getShowValue_Ref();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SHOW_VALUE__UNIT = eINSTANCE.getShowValue_Unit();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.XNumberLiteralImpl <em>XNumber Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.XNumberLiteralImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getXNumberLiteral()
     * @generated
     */
    EClass XNUMBER_LITERAL = eINSTANCE.getXNumberLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute XNUMBER_LITERAL__VALUE = eINSTANCE.getXNumberLiteral_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference XNUMBER_LITERAL__UNIT = eINSTANCE.getXNumberLiteral_Unit();

  }

} //CommonPackage
