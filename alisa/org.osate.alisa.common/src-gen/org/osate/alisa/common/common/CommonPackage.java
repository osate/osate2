/**
 */
package org.osate.alisa.common.common;

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
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ModelImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Content</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__CONTENT = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.DescriptionImpl <em>Description</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.DescriptionImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getDescription()
   * @generated
   */
  int DESCRIPTION = 1;

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
  int DESCRIPTION_ELEMENT = 2;

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
   * The feature id for the '<em><b>Newline</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT__NEWLINE = 2;

  /**
   * The feature id for the '<em><b>This Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT__THIS_TARGET = 3;

  /**
   * The number of structural features of the '<em>Description Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT_FEATURE_COUNT = 4;

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
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ReferencePathImpl <em>Reference Path</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ReferencePathImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getReferencePath()
   * @generated
   */
  int REFERENCE_PATH = 4;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_PATH__REF = 0;

  /**
   * The feature id for the '<em><b>Subpath</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_PATH__SUBPATH = 1;

  /**
   * The number of structural features of the '<em>Reference Path</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REFERENCE_PATH_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.PredicateExpressionImpl <em>Predicate Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.PredicateExpressionImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getPredicateExpression()
   * @generated
   */
  int PREDICATE_EXPRESSION = 5;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATE_EXPRESSION__OP = 0;

  /**
   * The feature id for the '<em><b>Limit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATE_EXPRESSION__LIMIT = 1;

  /**
   * The number of structural features of the '<em>Predicate Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREDICATE_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ConstantDeclImpl <em>Constant Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ConstantDeclImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getConstantDecl()
   * @generated
   */
  int CONSTANT_DECL = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DECL__NAME = 0;

  /**
   * The feature id for the '<em><b>Constantvalue</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DECL__CONSTANTVALUE = 1;

  /**
   * The number of structural features of the '<em>Constant Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DECL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ConstantValueImpl <em>Constant Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ConstantValueImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getConstantValue()
   * @generated
   */
  int CONSTANT_VALUE = 7;

  /**
   * The number of structural features of the '<em>Constant Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.StringTermImpl <em>String Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.StringTermImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getStringTerm()
   * @generated
   */
  int STRING_TERM = 8;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TERM__VALUE = CONSTANT_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TERM_FEATURE_COUNT = CONSTANT_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.RealTermImpl <em>Real Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.RealTermImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getRealTerm()
   * @generated
   */
  int REAL_TERM = 9;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_TERM__VALUE = CONSTANT_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_TERM__UNIT = CONSTANT_VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Real Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_TERM_FEATURE_COUNT = CONSTANT_VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.IntegerTermImpl <em>Integer Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.IntegerTermImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getIntegerTerm()
   * @generated
   */
  int INTEGER_TERM = 10;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TERM__VALUE = CONSTANT_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TERM__UNIT = CONSTANT_VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Integer Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TERM_FEATURE_COUNT = CONSTANT_VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.MultiLineStringImpl <em>Multi Line String</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.MultiLineStringImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getMultiLineString()
   * @generated
   */
  int MULTI_LINE_STRING = 11;

  /**
   * The feature id for the '<em><b>Description</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_LINE_STRING__DESCRIPTION = 0;

  /**
   * The number of structural features of the '<em>Multi Line String</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTI_LINE_STRING_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.TextElementImpl <em>Text Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.TextElementImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getTextElement()
   * @generated
   */
  int TEXT_ELEMENT = 12;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_ELEMENT__TEXT = 0;

  /**
   * The feature id for the '<em><b>Newline</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_ELEMENT__NEWLINE = 1;

  /**
   * The number of structural features of the '<em>Text Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_ELEMENT_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.osate.alisa.common.common.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.Model#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Content</em>'.
   * @see org.osate.alisa.common.common.Model#getContent()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Content();

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
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.DescriptionElement#isNewline <em>Newline</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Newline</em>'.
   * @see org.osate.alisa.common.common.DescriptionElement#isNewline()
   * @see #getDescriptionElement()
   * @generated
   */
  EAttribute getDescriptionElement_Newline();

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
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ReferencePath <em>Reference Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reference Path</em>'.
   * @see org.osate.alisa.common.common.ReferencePath
   * @generated
   */
  EClass getReferencePath();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.common.common.ReferencePath#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.osate.alisa.common.common.ReferencePath#getRef()
   * @see #getReferencePath()
   * @generated
   */
  EReference getReferencePath_Ref();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.ReferencePath#getSubpath <em>Subpath</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Subpath</em>'.
   * @see org.osate.alisa.common.common.ReferencePath#getSubpath()
   * @see #getReferencePath()
   * @generated
   */
  EReference getReferencePath_Subpath();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.PredicateExpression <em>Predicate Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Predicate Expression</em>'.
   * @see org.osate.alisa.common.common.PredicateExpression
   * @generated
   */
  EClass getPredicateExpression();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.PredicateExpression#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see org.osate.alisa.common.common.PredicateExpression#getOp()
   * @see #getPredicateExpression()
   * @generated
   */
  EAttribute getPredicateExpression_Op();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.common.common.PredicateExpression#getLimit <em>Limit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Limit</em>'.
   * @see org.osate.alisa.common.common.PredicateExpression#getLimit()
   * @see #getPredicateExpression()
   * @generated
   */
  EReference getPredicateExpression_Limit();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ConstantDecl <em>Constant Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Decl</em>'.
   * @see org.osate.alisa.common.common.ConstantDecl
   * @generated
   */
  EClass getConstantDecl();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.ConstantDecl#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.alisa.common.common.ConstantDecl#getName()
   * @see #getConstantDecl()
   * @generated
   */
  EAttribute getConstantDecl_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.ConstantDecl#getConstantvalue <em>Constantvalue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constantvalue</em>'.
   * @see org.osate.alisa.common.common.ConstantDecl#getConstantvalue()
   * @see #getConstantDecl()
   * @generated
   */
  EReference getConstantDecl_Constantvalue();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ConstantValue <em>Constant Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Value</em>'.
   * @see org.osate.alisa.common.common.ConstantValue
   * @generated
   */
  EClass getConstantValue();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.StringTerm <em>String Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Term</em>'.
   * @see org.osate.alisa.common.common.StringTerm
   * @generated
   */
  EClass getStringTerm();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.StringTerm#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.alisa.common.common.StringTerm#getValue()
   * @see #getStringTerm()
   * @generated
   */
  EAttribute getStringTerm_Value();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.RealTerm <em>Real Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Term</em>'.
   * @see org.osate.alisa.common.common.RealTerm
   * @generated
   */
  EClass getRealTerm();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.RealTerm#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.alisa.common.common.RealTerm#getValue()
   * @see #getRealTerm()
   * @generated
   */
  EAttribute getRealTerm_Value();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.RealTerm#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.osate.alisa.common.common.RealTerm#getUnit()
   * @see #getRealTerm()
   * @generated
   */
  EAttribute getRealTerm_Unit();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.IntegerTerm <em>Integer Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Term</em>'.
   * @see org.osate.alisa.common.common.IntegerTerm
   * @generated
   */
  EClass getIntegerTerm();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.IntegerTerm#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.alisa.common.common.IntegerTerm#getValue()
   * @see #getIntegerTerm()
   * @generated
   */
  EAttribute getIntegerTerm_Value();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.IntegerTerm#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.osate.alisa.common.common.IntegerTerm#getUnit()
   * @see #getIntegerTerm()
   * @generated
   */
  EAttribute getIntegerTerm_Unit();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.MultiLineString <em>Multi Line String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multi Line String</em>'.
   * @see org.osate.alisa.common.common.MultiLineString
   * @generated
   */
  EClass getMultiLineString();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.alisa.common.common.MultiLineString#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Description</em>'.
   * @see org.osate.alisa.common.common.MultiLineString#getDescription()
   * @see #getMultiLineString()
   * @generated
   */
  EReference getMultiLineString_Description();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.TextElement <em>Text Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Text Element</em>'.
   * @see org.osate.alisa.common.common.TextElement
   * @generated
   */
  EClass getTextElement();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.TextElement#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see org.osate.alisa.common.common.TextElement#getText()
   * @see #getTextElement()
   * @generated
   */
  EAttribute getTextElement_Text();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.TextElement#isNewline <em>Newline</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Newline</em>'.
   * @see org.osate.alisa.common.common.TextElement#isNewline()
   * @see #getTextElement()
   * @generated
   */
  EAttribute getTextElement_Newline();

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
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ModelImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__CONTENT = eINSTANCE.getModel_Content();

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
     * The meta object literal for the '<em><b>Newline</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DESCRIPTION_ELEMENT__NEWLINE = eINSTANCE.getDescriptionElement_Newline();

    /**
     * The meta object literal for the '<em><b>This Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DESCRIPTION_ELEMENT__THIS_TARGET = eINSTANCE.getDescriptionElement_ThisTarget();

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
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ReferencePathImpl <em>Reference Path</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ReferencePathImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getReferencePath()
     * @generated
     */
    EClass REFERENCE_PATH = eINSTANCE.getReferencePath();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_PATH__REF = eINSTANCE.getReferencePath_Ref();

    /**
     * The meta object literal for the '<em><b>Subpath</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REFERENCE_PATH__SUBPATH = eINSTANCE.getReferencePath_Subpath();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.PredicateExpressionImpl <em>Predicate Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.PredicateExpressionImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getPredicateExpression()
     * @generated
     */
    EClass PREDICATE_EXPRESSION = eINSTANCE.getPredicateExpression();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PREDICATE_EXPRESSION__OP = eINSTANCE.getPredicateExpression_Op();

    /**
     * The meta object literal for the '<em><b>Limit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREDICATE_EXPRESSION__LIMIT = eINSTANCE.getPredicateExpression_Limit();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ConstantDeclImpl <em>Constant Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ConstantDeclImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getConstantDecl()
     * @generated
     */
    EClass CONSTANT_DECL = eINSTANCE.getConstantDecl();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT_DECL__NAME = eINSTANCE.getConstantDecl_Name();

    /**
     * The meta object literal for the '<em><b>Constantvalue</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT_DECL__CONSTANTVALUE = eINSTANCE.getConstantDecl_Constantvalue();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ConstantValueImpl <em>Constant Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ConstantValueImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getConstantValue()
     * @generated
     */
    EClass CONSTANT_VALUE = eINSTANCE.getConstantValue();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.StringTermImpl <em>String Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.StringTermImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getStringTerm()
     * @generated
     */
    EClass STRING_TERM = eINSTANCE.getStringTerm();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_TERM__VALUE = eINSTANCE.getStringTerm_Value();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.RealTermImpl <em>Real Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.RealTermImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getRealTerm()
     * @generated
     */
    EClass REAL_TERM = eINSTANCE.getRealTerm();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_TERM__VALUE = eINSTANCE.getRealTerm_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_TERM__UNIT = eINSTANCE.getRealTerm_Unit();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.IntegerTermImpl <em>Integer Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.IntegerTermImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getIntegerTerm()
     * @generated
     */
    EClass INTEGER_TERM = eINSTANCE.getIntegerTerm();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTEGER_TERM__VALUE = eINSTANCE.getIntegerTerm_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTEGER_TERM__UNIT = eINSTANCE.getIntegerTerm_Unit();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.MultiLineStringImpl <em>Multi Line String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.MultiLineStringImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getMultiLineString()
     * @generated
     */
    EClass MULTI_LINE_STRING = eINSTANCE.getMultiLineString();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTI_LINE_STRING__DESCRIPTION = eINSTANCE.getMultiLineString_Description();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.TextElementImpl <em>Text Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.TextElementImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getTextElement()
     * @generated
     */
    EClass TEXT_ELEMENT = eINSTANCE.getTextElement();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEXT_ELEMENT__TEXT = eINSTANCE.getTextElement_Text();

    /**
     * The meta object literal for the '<em><b>Newline</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEXT_ELEMENT__NEWLINE = eINSTANCE.getTextElement_Newline();

  }

} //CommonPackage
