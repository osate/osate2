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
   * The feature id for the '<em><b>Show Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT__SHOW_VALUE = 1;

  /**
   * The feature id for the '<em><b>This Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT__THIS_TARGET = 2;

  /**
   * The feature id for the '<em><b>Image</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT__IMAGE = 3;

  /**
   * The number of structural features of the '<em>Description Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.RationaleImpl <em>Rationale</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.RationaleImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getRationale()
   * @generated
   */
  int RATIONALE = 2;

  /**
   * The feature id for the '<em><b>Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RATIONALE__TEXT = 0;

  /**
   * The number of structural features of the '<em>Rationale</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RATIONALE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.UncertaintyImpl <em>Uncertainty</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.UncertaintyImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getUncertainty()
   * @generated
   */
  int UNCERTAINTY = 3;

  /**
   * The feature id for the '<em><b>Volatility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAINTY__VOLATILITY = 0;

  /**
   * The feature id for the '<em><b>Costimpact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAINTY__COSTIMPACT = 1;

  /**
   * The feature id for the '<em><b>Scheduleimpact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAINTY__SCHEDULEIMPACT = 2;

  /**
   * The feature id for the '<em><b>Familiarity</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAINTY__FAMILIARITY = 3;

  /**
   * The feature id for the '<em><b>Timecriticality</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAINTY__TIMECRITICALITY = 4;

  /**
   * The feature id for the '<em><b>Riskindex</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAINTY__RISKINDEX = 5;

  /**
   * The feature id for the '<em><b>Maturityindex</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAINTY__MATURITYINDEX = 6;

  /**
   * The number of structural features of the '<em>Uncertainty</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAINTY_FEATURE_COUNT = 7;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AVariableDeclarationImpl <em>AVariable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AVariableDeclarationImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAVariableDeclaration()
   * @generated
   */
  int AVARIABLE_DECLARATION = 4;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVARIABLE_DECLARATION__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVARIABLE_DECLARATION__NAME = 1;

  /**
   * The number of structural features of the '<em>AVariable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVARIABLE_DECLARATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AExpressionImpl <em>AExpression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AExpressionImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAExpression()
   * @generated
   */
  int AEXPRESSION = 5;

  /**
   * The number of structural features of the '<em>AExpression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ShowValueImpl <em>Show Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ShowValueImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getShowValue()
   * @generated
   */
  int SHOW_VALUE = 6;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHOW_VALUE__REF = 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
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
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ImageReferenceImpl <em>Image Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ImageReferenceImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getImageReference()
   * @generated
   */
  int IMAGE_REFERENCE = 7;

  /**
   * The feature id for the '<em><b>Imgfile</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_REFERENCE__IMGFILE = 0;

  /**
   * The number of structural features of the '<em>Image Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_REFERENCE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ACollectionLiteralImpl <em>ACollection Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ACollectionLiteralImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getACollectionLiteral()
   * @generated
   */
  int ACOLLECTION_LITERAL = 8;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACOLLECTION_LITERAL__ELEMENTS = AEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>ACollection Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACOLLECTION_LITERAL_FEATURE_COUNT = AEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ASetLiteralImpl <em>ASet Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ASetLiteralImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getASetLiteral()
   * @generated
   */
  int ASET_LITERAL = 9;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASET_LITERAL__ELEMENTS = ACOLLECTION_LITERAL__ELEMENTS;

  /**
   * The number of structural features of the '<em>ASet Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASET_LITERAL_FEATURE_COUNT = ACOLLECTION_LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AListLiteralImpl <em>AList Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AListLiteralImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAListLiteral()
   * @generated
   */
  int ALIST_LITERAL = 10;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIST_LITERAL__ELEMENTS = ACOLLECTION_LITERAL__ELEMENTS;

  /**
   * The number of structural features of the '<em>AList Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIST_LITERAL_FEATURE_COUNT = ACOLLECTION_LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ANumberLiteralImpl <em>ANumber Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ANumberLiteralImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getANumberLiteral()
   * @generated
   */
  int ANUMBER_LITERAL = 11;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANUMBER_LITERAL__VALUE = AEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANUMBER_LITERAL__UNIT = AEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>ANumber Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANUMBER_LITERAL_FEATURE_COUNT = AEXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ValDeclarationImpl <em>Val Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ValDeclarationImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getValDeclaration()
   * @generated
   */
  int VAL_DECLARATION = 12;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL_DECLARATION__TYPE = AVARIABLE_DECLARATION__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL_DECLARATION__NAME = AVARIABLE_DECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL_DECLARATION__RIGHT = AVARIABLE_DECLARATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Val Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL_DECLARATION_FEATURE_COUNT = AVARIABLE_DECLARATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ComputeDeclarationImpl <em>Compute Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ComputeDeclarationImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getComputeDeclaration()
   * @generated
   */
  int COMPUTE_DECLARATION = 13;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTE_DECLARATION__TYPE = AVARIABLE_DECLARATION__TYPE;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTE_DECLARATION__NAME = AVARIABLE_DECLARATION__NAME;

  /**
   * The number of structural features of the '<em>Compute Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTE_DECLARATION_FEATURE_COUNT = AVARIABLE_DECLARATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.APropertyReferenceImpl <em>AProperty Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.APropertyReferenceImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAPropertyReference()
   * @generated
   */
  int APROPERTY_REFERENCE = 14;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APROPERTY_REFERENCE__PROPERTY = AEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>AProperty Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APROPERTY_REFERENCE_FEATURE_COUNT = AEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AVariableReferenceImpl <em>AVariable Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AVariableReferenceImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAVariableReference()
   * @generated
   */
  int AVARIABLE_REFERENCE = 15;

  /**
   * The feature id for the '<em><b>Variable</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVARIABLE_REFERENCE__VARIABLE = AEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>AVariable Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVARIABLE_REFERENCE_FEATURE_COUNT = AEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ABinaryOperationImpl <em>ABinary Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ABinaryOperationImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getABinaryOperation()
   * @generated
   */
  int ABINARY_OPERATION = 16;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABINARY_OPERATION__LEFT_OPERAND = AEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABINARY_OPERATION__FEATURE = AEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABINARY_OPERATION__RIGHT_OPERAND = AEXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>ABinary Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABINARY_OPERATION_FEATURE_COUNT = AEXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AUnaryOperationImpl <em>AUnary Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AUnaryOperationImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAUnaryOperation()
   * @generated
   */
  int AUNARY_OPERATION = 17;

  /**
   * The feature id for the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNARY_OPERATION__FEATURE = AEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNARY_OPERATION__OPERAND = AEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>AUnary Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNARY_OPERATION_FEATURE_COUNT = AEXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ABooleanLiteralImpl <em>ABoolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ABooleanLiteralImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getABooleanLiteral()
   * @generated
   */
  int ABOOLEAN_LITERAL = 18;

  /**
   * The feature id for the '<em><b>Is True</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABOOLEAN_LITERAL__IS_TRUE = AEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>ABoolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABOOLEAN_LITERAL_FEATURE_COUNT = AEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ANullLiteralImpl <em>ANull Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ANullLiteralImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getANullLiteral()
   * @generated
   */
  int ANULL_LITERAL = 19;

  /**
   * The number of structural features of the '<em>ANull Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANULL_LITERAL_FEATURE_COUNT = AEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AStringLiteralImpl <em>AString Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AStringLiteralImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAStringLiteral()
   * @generated
   */
  int ASTRING_LITERAL = 20;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASTRING_LITERAL__VALUE = AEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>AString Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASTRING_LITERAL_FEATURE_COUNT = AEXPRESSION_FEATURE_COUNT + 1;


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
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.DescriptionElement#getShowValue <em>Show Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Show Value</em>'.
   * @see org.osate.alisa.common.common.DescriptionElement#getShowValue()
   * @see #getDescriptionElement()
   * @generated
   */
  EReference getDescriptionElement_ShowValue();

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
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.DescriptionElement#getImage <em>Image</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Image</em>'.
   * @see org.osate.alisa.common.common.DescriptionElement#getImage()
   * @see #getDescriptionElement()
   * @generated
   */
  EReference getDescriptionElement_Image();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.Rationale <em>Rationale</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rationale</em>'.
   * @see org.osate.alisa.common.common.Rationale
   * @generated
   */
  EClass getRationale();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.Rationale#getText <em>Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Text</em>'.
   * @see org.osate.alisa.common.common.Rationale#getText()
   * @see #getRationale()
   * @generated
   */
  EAttribute getRationale_Text();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.Uncertainty <em>Uncertainty</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Uncertainty</em>'.
   * @see org.osate.alisa.common.common.Uncertainty
   * @generated
   */
  EClass getUncertainty();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.Uncertainty#getVolatility <em>Volatility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Volatility</em>'.
   * @see org.osate.alisa.common.common.Uncertainty#getVolatility()
   * @see #getUncertainty()
   * @generated
   */
  EAttribute getUncertainty_Volatility();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.Uncertainty#getCostimpact <em>Costimpact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Costimpact</em>'.
   * @see org.osate.alisa.common.common.Uncertainty#getCostimpact()
   * @see #getUncertainty()
   * @generated
   */
  EAttribute getUncertainty_Costimpact();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.Uncertainty#getScheduleimpact <em>Scheduleimpact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Scheduleimpact</em>'.
   * @see org.osate.alisa.common.common.Uncertainty#getScheduleimpact()
   * @see #getUncertainty()
   * @generated
   */
  EAttribute getUncertainty_Scheduleimpact();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.Uncertainty#getFamiliarity <em>Familiarity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Familiarity</em>'.
   * @see org.osate.alisa.common.common.Uncertainty#getFamiliarity()
   * @see #getUncertainty()
   * @generated
   */
  EAttribute getUncertainty_Familiarity();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.Uncertainty#getTimecriticality <em>Timecriticality</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Timecriticality</em>'.
   * @see org.osate.alisa.common.common.Uncertainty#getTimecriticality()
   * @see #getUncertainty()
   * @generated
   */
  EAttribute getUncertainty_Timecriticality();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.Uncertainty#getRiskindex <em>Riskindex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Riskindex</em>'.
   * @see org.osate.alisa.common.common.Uncertainty#getRiskindex()
   * @see #getUncertainty()
   * @generated
   */
  EAttribute getUncertainty_Riskindex();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.Uncertainty#getMaturityindex <em>Maturityindex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Maturityindex</em>'.
   * @see org.osate.alisa.common.common.Uncertainty#getMaturityindex()
   * @see #getUncertainty()
   * @generated
   */
  EAttribute getUncertainty_Maturityindex();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.AVariableDeclaration <em>AVariable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AVariable Declaration</em>'.
   * @see org.osate.alisa.common.common.AVariableDeclaration
   * @generated
   */
  EClass getAVariableDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.AVariableDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.osate.alisa.common.common.AVariableDeclaration#getType()
   * @see #getAVariableDeclaration()
   * @generated
   */
  EAttribute getAVariableDeclaration_Type();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.AVariableDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.alisa.common.common.AVariableDeclaration#getName()
   * @see #getAVariableDeclaration()
   * @generated
   */
  EAttribute getAVariableDeclaration_Name();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.AExpression <em>AExpression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AExpression</em>'.
   * @see org.osate.alisa.common.common.AExpression
   * @generated
   */
  EClass getAExpression();

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
   * Returns the meta object for the reference '{@link org.osate.alisa.common.common.ShowValue#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Unit</em>'.
   * @see org.osate.alisa.common.common.ShowValue#getUnit()
   * @see #getShowValue()
   * @generated
   */
  EReference getShowValue_Unit();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ImageReference <em>Image Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Image Reference</em>'.
   * @see org.osate.alisa.common.common.ImageReference
   * @generated
   */
  EClass getImageReference();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.ImageReference#getImgfile <em>Imgfile</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imgfile</em>'.
   * @see org.osate.alisa.common.common.ImageReference#getImgfile()
   * @see #getImageReference()
   * @generated
   */
  EAttribute getImageReference_Imgfile();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ACollectionLiteral <em>ACollection Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ACollection Literal</em>'.
   * @see org.osate.alisa.common.common.ACollectionLiteral
   * @generated
   */
  EClass getACollectionLiteral();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.alisa.common.common.ACollectionLiteral#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.osate.alisa.common.common.ACollectionLiteral#getElements()
   * @see #getACollectionLiteral()
   * @generated
   */
  EReference getACollectionLiteral_Elements();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ASetLiteral <em>ASet Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ASet Literal</em>'.
   * @see org.osate.alisa.common.common.ASetLiteral
   * @generated
   */
  EClass getASetLiteral();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.AListLiteral <em>AList Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AList Literal</em>'.
   * @see org.osate.alisa.common.common.AListLiteral
   * @generated
   */
  EClass getAListLiteral();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ANumberLiteral <em>ANumber Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ANumber Literal</em>'.
   * @see org.osate.alisa.common.common.ANumberLiteral
   * @generated
   */
  EClass getANumberLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.ANumberLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.alisa.common.common.ANumberLiteral#getValue()
   * @see #getANumberLiteral()
   * @generated
   */
  EAttribute getANumberLiteral_Value();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.common.common.ANumberLiteral#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Unit</em>'.
   * @see org.osate.alisa.common.common.ANumberLiteral#getUnit()
   * @see #getANumberLiteral()
   * @generated
   */
  EReference getANumberLiteral_Unit();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ValDeclaration <em>Val Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Val Declaration</em>'.
   * @see org.osate.alisa.common.common.ValDeclaration
   * @generated
   */
  EClass getValDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.ValDeclaration#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.osate.alisa.common.common.ValDeclaration#getRight()
   * @see #getValDeclaration()
   * @generated
   */
  EReference getValDeclaration_Right();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ComputeDeclaration <em>Compute Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Compute Declaration</em>'.
   * @see org.osate.alisa.common.common.ComputeDeclaration
   * @generated
   */
  EClass getComputeDeclaration();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.APropertyReference <em>AProperty Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AProperty Reference</em>'.
   * @see org.osate.alisa.common.common.APropertyReference
   * @generated
   */
  EClass getAPropertyReference();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.common.common.APropertyReference#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see org.osate.alisa.common.common.APropertyReference#getProperty()
   * @see #getAPropertyReference()
   * @generated
   */
  EReference getAPropertyReference_Property();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.AVariableReference <em>AVariable Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AVariable Reference</em>'.
   * @see org.osate.alisa.common.common.AVariableReference
   * @generated
   */
  EClass getAVariableReference();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.common.common.AVariableReference#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Variable</em>'.
   * @see org.osate.alisa.common.common.AVariableReference#getVariable()
   * @see #getAVariableReference()
   * @generated
   */
  EReference getAVariableReference_Variable();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ABinaryOperation <em>ABinary Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ABinary Operation</em>'.
   * @see org.osate.alisa.common.common.ABinaryOperation
   * @generated
   */
  EClass getABinaryOperation();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.ABinaryOperation#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.osate.alisa.common.common.ABinaryOperation#getLeftOperand()
   * @see #getABinaryOperation()
   * @generated
   */
  EReference getABinaryOperation_LeftOperand();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.ABinaryOperation#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature</em>'.
   * @see org.osate.alisa.common.common.ABinaryOperation#getFeature()
   * @see #getABinaryOperation()
   * @generated
   */
  EAttribute getABinaryOperation_Feature();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.ABinaryOperation#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.osate.alisa.common.common.ABinaryOperation#getRightOperand()
   * @see #getABinaryOperation()
   * @generated
   */
  EReference getABinaryOperation_RightOperand();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.AUnaryOperation <em>AUnary Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AUnary Operation</em>'.
   * @see org.osate.alisa.common.common.AUnaryOperation
   * @generated
   */
  EClass getAUnaryOperation();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.AUnaryOperation#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature</em>'.
   * @see org.osate.alisa.common.common.AUnaryOperation#getFeature()
   * @see #getAUnaryOperation()
   * @generated
   */
  EAttribute getAUnaryOperation_Feature();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.AUnaryOperation#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.osate.alisa.common.common.AUnaryOperation#getOperand()
   * @see #getAUnaryOperation()
   * @generated
   */
  EReference getAUnaryOperation_Operand();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ABooleanLiteral <em>ABoolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ABoolean Literal</em>'.
   * @see org.osate.alisa.common.common.ABooleanLiteral
   * @generated
   */
  EClass getABooleanLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.ABooleanLiteral#isIsTrue <em>Is True</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is True</em>'.
   * @see org.osate.alisa.common.common.ABooleanLiteral#isIsTrue()
   * @see #getABooleanLiteral()
   * @generated
   */
  EAttribute getABooleanLiteral_IsTrue();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ANullLiteral <em>ANull Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ANull Literal</em>'.
   * @see org.osate.alisa.common.common.ANullLiteral
   * @generated
   */
  EClass getANullLiteral();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.AStringLiteral <em>AString Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AString Literal</em>'.
   * @see org.osate.alisa.common.common.AStringLiteral
   * @generated
   */
  EClass getAStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.AStringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.alisa.common.common.AStringLiteral#getValue()
   * @see #getAStringLiteral()
   * @generated
   */
  EAttribute getAStringLiteral_Value();

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
     * The meta object literal for the '<em><b>Show Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DESCRIPTION_ELEMENT__SHOW_VALUE = eINSTANCE.getDescriptionElement_ShowValue();

    /**
     * The meta object literal for the '<em><b>This Target</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DESCRIPTION_ELEMENT__THIS_TARGET = eINSTANCE.getDescriptionElement_ThisTarget();

    /**
     * The meta object literal for the '<em><b>Image</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DESCRIPTION_ELEMENT__IMAGE = eINSTANCE.getDescriptionElement_Image();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.RationaleImpl <em>Rationale</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.RationaleImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getRationale()
     * @generated
     */
    EClass RATIONALE = eINSTANCE.getRationale();

    /**
     * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RATIONALE__TEXT = eINSTANCE.getRationale_Text();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.UncertaintyImpl <em>Uncertainty</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.UncertaintyImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getUncertainty()
     * @generated
     */
    EClass UNCERTAINTY = eINSTANCE.getUncertainty();

    /**
     * The meta object literal for the '<em><b>Volatility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNCERTAINTY__VOLATILITY = eINSTANCE.getUncertainty_Volatility();

    /**
     * The meta object literal for the '<em><b>Costimpact</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNCERTAINTY__COSTIMPACT = eINSTANCE.getUncertainty_Costimpact();

    /**
     * The meta object literal for the '<em><b>Scheduleimpact</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNCERTAINTY__SCHEDULEIMPACT = eINSTANCE.getUncertainty_Scheduleimpact();

    /**
     * The meta object literal for the '<em><b>Familiarity</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNCERTAINTY__FAMILIARITY = eINSTANCE.getUncertainty_Familiarity();

    /**
     * The meta object literal for the '<em><b>Timecriticality</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNCERTAINTY__TIMECRITICALITY = eINSTANCE.getUncertainty_Timecriticality();

    /**
     * The meta object literal for the '<em><b>Riskindex</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNCERTAINTY__RISKINDEX = eINSTANCE.getUncertainty_Riskindex();

    /**
     * The meta object literal for the '<em><b>Maturityindex</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNCERTAINTY__MATURITYINDEX = eINSTANCE.getUncertainty_Maturityindex();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.AVariableDeclarationImpl <em>AVariable Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.AVariableDeclarationImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAVariableDeclaration()
     * @generated
     */
    EClass AVARIABLE_DECLARATION = eINSTANCE.getAVariableDeclaration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AVARIABLE_DECLARATION__TYPE = eINSTANCE.getAVariableDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AVARIABLE_DECLARATION__NAME = eINSTANCE.getAVariableDeclaration_Name();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.AExpressionImpl <em>AExpression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.AExpressionImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAExpression()
     * @generated
     */
    EClass AEXPRESSION = eINSTANCE.getAExpression();

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
     * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHOW_VALUE__UNIT = eINSTANCE.getShowValue_Unit();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ImageReferenceImpl <em>Image Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ImageReferenceImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getImageReference()
     * @generated
     */
    EClass IMAGE_REFERENCE = eINSTANCE.getImageReference();

    /**
     * The meta object literal for the '<em><b>Imgfile</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMAGE_REFERENCE__IMGFILE = eINSTANCE.getImageReference_Imgfile();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ACollectionLiteralImpl <em>ACollection Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ACollectionLiteralImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getACollectionLiteral()
     * @generated
     */
    EClass ACOLLECTION_LITERAL = eINSTANCE.getACollectionLiteral();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACOLLECTION_LITERAL__ELEMENTS = eINSTANCE.getACollectionLiteral_Elements();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ASetLiteralImpl <em>ASet Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ASetLiteralImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getASetLiteral()
     * @generated
     */
    EClass ASET_LITERAL = eINSTANCE.getASetLiteral();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.AListLiteralImpl <em>AList Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.AListLiteralImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAListLiteral()
     * @generated
     */
    EClass ALIST_LITERAL = eINSTANCE.getAListLiteral();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ANumberLiteralImpl <em>ANumber Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ANumberLiteralImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getANumberLiteral()
     * @generated
     */
    EClass ANUMBER_LITERAL = eINSTANCE.getANumberLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ANUMBER_LITERAL__VALUE = eINSTANCE.getANumberLiteral_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ANUMBER_LITERAL__UNIT = eINSTANCE.getANumberLiteral_Unit();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ValDeclarationImpl <em>Val Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ValDeclarationImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getValDeclaration()
     * @generated
     */
    EClass VAL_DECLARATION = eINSTANCE.getValDeclaration();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAL_DECLARATION__RIGHT = eINSTANCE.getValDeclaration_Right();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ComputeDeclarationImpl <em>Compute Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ComputeDeclarationImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getComputeDeclaration()
     * @generated
     */
    EClass COMPUTE_DECLARATION = eINSTANCE.getComputeDeclaration();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.APropertyReferenceImpl <em>AProperty Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.APropertyReferenceImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAPropertyReference()
     * @generated
     */
    EClass APROPERTY_REFERENCE = eINSTANCE.getAPropertyReference();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APROPERTY_REFERENCE__PROPERTY = eINSTANCE.getAPropertyReference_Property();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.AVariableReferenceImpl <em>AVariable Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.AVariableReferenceImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAVariableReference()
     * @generated
     */
    EClass AVARIABLE_REFERENCE = eINSTANCE.getAVariableReference();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AVARIABLE_REFERENCE__VARIABLE = eINSTANCE.getAVariableReference_Variable();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ABinaryOperationImpl <em>ABinary Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ABinaryOperationImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getABinaryOperation()
     * @generated
     */
    EClass ABINARY_OPERATION = eINSTANCE.getABinaryOperation();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABINARY_OPERATION__LEFT_OPERAND = eINSTANCE.getABinaryOperation_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABINARY_OPERATION__FEATURE = eINSTANCE.getABinaryOperation_Feature();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABINARY_OPERATION__RIGHT_OPERAND = eINSTANCE.getABinaryOperation_RightOperand();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.AUnaryOperationImpl <em>AUnary Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.AUnaryOperationImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAUnaryOperation()
     * @generated
     */
    EClass AUNARY_OPERATION = eINSTANCE.getAUnaryOperation();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AUNARY_OPERATION__FEATURE = eINSTANCE.getAUnaryOperation_Feature();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUNARY_OPERATION__OPERAND = eINSTANCE.getAUnaryOperation_Operand();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ABooleanLiteralImpl <em>ABoolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ABooleanLiteralImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getABooleanLiteral()
     * @generated
     */
    EClass ABOOLEAN_LITERAL = eINSTANCE.getABooleanLiteral();

    /**
     * The meta object literal for the '<em><b>Is True</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABOOLEAN_LITERAL__IS_TRUE = eINSTANCE.getABooleanLiteral_IsTrue();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ANullLiteralImpl <em>ANull Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ANullLiteralImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getANullLiteral()
     * @generated
     */
    EClass ANULL_LITERAL = eINSTANCE.getANullLiteral();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.AStringLiteralImpl <em>AString Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.AStringLiteralImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAStringLiteral()
     * @generated
     */
    EClass ASTRING_LITERAL = eINSTANCE.getAStringLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASTRING_LITERAL__VALUE = eINSTANCE.getAStringLiteral_Value();

  }

} //CommonPackage
