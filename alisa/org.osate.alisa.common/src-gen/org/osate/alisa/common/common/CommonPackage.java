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
package org.osate.alisa.common.common;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.osate.aadl2.Aadl2Package;

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
   * The feature id for the '<em><b>Impact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAINTY__IMPACT = 1;

  /**
   * The number of structural features of the '<em>Uncertainty</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAINTY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ResultIssueImpl <em>Result Issue</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ResultIssueImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getResultIssue()
   * @generated
   */
  int RESULT_ISSUE = 4;

  /**
   * The feature id for the '<em><b>Issue Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__ISSUE_TYPE = 0;

  /**
   * The feature id for the '<em><b>Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__MESSAGE = 1;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__TARGET = 2;

  /**
   * The feature id for the '<em><b>Exception Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__EXCEPTION_TYPE = 3;

  /**
   * The feature id for the '<em><b>Diagnostic Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__DIAGNOSTIC_ID = 4;

  /**
   * The feature id for the '<em><b>Issues</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE__ISSUES = 5;

  /**
   * The number of structural features of the '<em>Result Issue</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_ISSUE_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AVariableDeclarationImpl <em>AVariable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AVariableDeclarationImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAVariableDeclaration()
   * @generated
   */
  int AVARIABLE_DECLARATION = 5;

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
  int AEXPRESSION = 6;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXPRESSION__OWNED_ELEMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXPRESSION__OWNED_COMMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>AExpression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AEXPRESSION_FEATURE_COUNT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ShowValueImpl <em>Show Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ShowValueImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getShowValue()
   * @generated
   */
  int SHOW_VALUE = 7;

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
  int IMAGE_REFERENCE = 8;

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
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ValDeclarationImpl <em>Val Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ValDeclarationImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getValDeclaration()
   * @generated
   */
  int VAL_DECLARATION = 9;

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
  int COMPUTE_DECLARATION = 10;

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
  int APROPERTY_REFERENCE = 11;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APROPERTY_REFERENCE__OWNED_ELEMENT = AEXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APROPERTY_REFERENCE__OWNED_COMMENT = AEXPRESSION__OWNED_COMMENT;

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
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AModelReferenceImpl <em>AModel Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AModelReferenceImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAModelReference()
   * @generated
   */
  int AMODEL_REFERENCE = 12;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMODEL_REFERENCE__OWNED_ELEMENT = AEXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMODEL_REFERENCE__OWNED_COMMENT = AEXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Model Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMODEL_REFERENCE__MODEL_ELEMENT = AEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>AModel Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMODEL_REFERENCE_FEATURE_COUNT = AEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AVariableReferenceImpl <em>AVariable Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AVariableReferenceImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAVariableReference()
   * @generated
   */
  int AVARIABLE_REFERENCE = 13;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVARIABLE_REFERENCE__OWNED_ELEMENT = AEXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVARIABLE_REFERENCE__OWNED_COMMENT = AEXPRESSION__OWNED_COMMENT;

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
  int ABINARY_OPERATION = 14;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABINARY_OPERATION__OWNED_ELEMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABINARY_OPERATION__OWNED_COMMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABINARY_OPERATION__LEFT_OPERAND = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABINARY_OPERATION__FEATURE = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABINARY_OPERATION__RIGHT_OPERAND = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>ABinary Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABINARY_OPERATION_FEATURE_COUNT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AUnaryOperationImpl <em>AUnary Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AUnaryOperationImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAUnaryOperation()
   * @generated
   */
  int AUNARY_OPERATION = 15;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNARY_OPERATION__OWNED_ELEMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNARY_OPERATION__OWNED_COMMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Feature</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNARY_OPERATION__FEATURE = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNARY_OPERATION__OPERAND = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>AUnary Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNARY_OPERATION_FEATURE_COUNT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AFunctionCallImpl <em>AFunction Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AFunctionCallImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAFunctionCall()
   * @generated
   */
  int AFUNCTION_CALL = 16;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFUNCTION_CALL__OWNED_ELEMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFUNCTION_CALL__OWNED_COMMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Function</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFUNCTION_CALL__FUNCTION = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Function Call Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFUNCTION_CALL__FUNCTION_CALL_ARGUMENTS = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>AFunction Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFUNCTION_CALL_FEATURE_COUNT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AThisImpl <em>AThis</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AThisImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAThis()
   * @generated
   */
  int ATHIS = 17;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATHIS__OWNED_ELEMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATHIS__OWNED_COMMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>AThis</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATHIS_FEATURE_COUNT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ASetLiteralImpl <em>ASet Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ASetLiteralImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getASetLiteral()
   * @generated
   */
  int ASET_LITERAL = 18;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASET_LITERAL__OWNED_ELEMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASET_LITERAL__OWNED_COMMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASET_LITERAL__ELEMENTS = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>ASet Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASET_LITERAL_FEATURE_COUNT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AListTermImpl <em>AList Term</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AListTermImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAListTerm()
   * @generated
   */
  int ALIST_TERM = 19;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIST_TERM__OWNED_ELEMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIST_TERM__OWNED_COMMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIST_TERM__ELEMENTS = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>AList Term</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALIST_TERM_FEATURE_COUNT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ANullLiteralImpl <em>ANull Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ANullLiteralImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getANullLiteral()
   * @generated
   */
  int ANULL_LITERAL = 20;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANULL_LITERAL__OWNED_ELEMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANULL_LITERAL__OWNED_COMMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>ANull Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ANULL_LITERAL_FEATURE_COUNT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.ResultIssueType <em>Result Issue Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.ResultIssueType
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getResultIssueType()
   * @generated
   */
  int RESULT_ISSUE_TYPE = 21;


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
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.Uncertainty#getImpact <em>Impact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Impact</em>'.
   * @see org.osate.alisa.common.common.Uncertainty#getImpact()
   * @see #getUncertainty()
   * @generated
   */
  EAttribute getUncertainty_Impact();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ResultIssue <em>Result Issue</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Issue</em>'.
   * @see org.osate.alisa.common.common.ResultIssue
   * @generated
   */
  EClass getResultIssue();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.ResultIssue#getIssueType <em>Issue Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Issue Type</em>'.
   * @see org.osate.alisa.common.common.ResultIssue#getIssueType()
   * @see #getResultIssue()
   * @generated
   */
  EAttribute getResultIssue_IssueType();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.ResultIssue#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Message</em>'.
   * @see org.osate.alisa.common.common.ResultIssue#getMessage()
   * @see #getResultIssue()
   * @generated
   */
  EAttribute getResultIssue_Message();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.common.common.ResultIssue#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.osate.alisa.common.common.ResultIssue#getTarget()
   * @see #getResultIssue()
   * @generated
   */
  EReference getResultIssue_Target();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.ResultIssue#getExceptionType <em>Exception Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exception Type</em>'.
   * @see org.osate.alisa.common.common.ResultIssue#getExceptionType()
   * @see #getResultIssue()
   * @generated
   */
  EAttribute getResultIssue_ExceptionType();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.ResultIssue#getDiagnosticId <em>Diagnostic Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Diagnostic Id</em>'.
   * @see org.osate.alisa.common.common.ResultIssue#getDiagnosticId()
   * @see #getResultIssue()
   * @generated
   */
  EAttribute getResultIssue_DiagnosticId();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.alisa.common.common.ResultIssue#getIssues <em>Issues</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Issues</em>'.
   * @see org.osate.alisa.common.common.ResultIssue#getIssues()
   * @see #getResultIssue()
   * @generated
   */
  EReference getResultIssue_Issues();

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
   * Returns the meta object for class '{@link org.osate.alisa.common.common.AModelReference <em>AModel Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AModel Reference</em>'.
   * @see org.osate.alisa.common.common.AModelReference
   * @generated
   */
  EClass getAModelReference();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.common.common.AModelReference#getModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Model Element</em>'.
   * @see org.osate.alisa.common.common.AModelReference#getModelElement()
   * @see #getAModelReference()
   * @generated
   */
  EReference getAModelReference_ModelElement();

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
   * Returns the meta object for class '{@link org.osate.alisa.common.common.AFunctionCall <em>AFunction Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AFunction Call</em>'.
   * @see org.osate.alisa.common.common.AFunctionCall
   * @generated
   */
  EClass getAFunctionCall();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.AFunctionCall#getFunction <em>Function</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Function</em>'.
   * @see org.osate.alisa.common.common.AFunctionCall#getFunction()
   * @see #getAFunctionCall()
   * @generated
   */
  EAttribute getAFunctionCall_Function();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.alisa.common.common.AFunctionCall#getFunctionCallArguments <em>Function Call Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Function Call Arguments</em>'.
   * @see org.osate.alisa.common.common.AFunctionCall#getFunctionCallArguments()
   * @see #getAFunctionCall()
   * @generated
   */
  EReference getAFunctionCall_FunctionCallArguments();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.AThis <em>AThis</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AThis</em>'.
   * @see org.osate.alisa.common.common.AThis
   * @generated
   */
  EClass getAThis();

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
   * Returns the meta object for the containment reference list '{@link org.osate.alisa.common.common.ASetLiteral#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.osate.alisa.common.common.ASetLiteral#getElements()
   * @see #getASetLiteral()
   * @generated
   */
  EReference getASetLiteral_Elements();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.AListTerm <em>AList Term</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AList Term</em>'.
   * @see org.osate.alisa.common.common.AListTerm
   * @generated
   */
  EClass getAListTerm();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.alisa.common.common.AListTerm#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.osate.alisa.common.common.AListTerm#getElements()
   * @see #getAListTerm()
   * @generated
   */
  EReference getAListTerm_Elements();

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
   * Returns the meta object for enum '{@link org.osate.alisa.common.common.ResultIssueType <em>Result Issue Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Result Issue Type</em>'.
   * @see org.osate.alisa.common.common.ResultIssueType
   * @generated
   */
  EEnum getResultIssueType();

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
     * The meta object literal for the '<em><b>Impact</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNCERTAINTY__IMPACT = eINSTANCE.getUncertainty_Impact();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ResultIssueImpl <em>Result Issue</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ResultIssueImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getResultIssue()
     * @generated
     */
    EClass RESULT_ISSUE = eINSTANCE.getResultIssue();

    /**
     * The meta object literal for the '<em><b>Issue Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_ISSUE__ISSUE_TYPE = eINSTANCE.getResultIssue_IssueType();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_ISSUE__MESSAGE = eINSTANCE.getResultIssue_Message();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_ISSUE__TARGET = eINSTANCE.getResultIssue_Target();

    /**
     * The meta object literal for the '<em><b>Exception Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_ISSUE__EXCEPTION_TYPE = eINSTANCE.getResultIssue_ExceptionType();

    /**
     * The meta object literal for the '<em><b>Diagnostic Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RESULT_ISSUE__DIAGNOSTIC_ID = eINSTANCE.getResultIssue_DiagnosticId();

    /**
     * The meta object literal for the '<em><b>Issues</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_ISSUE__ISSUES = eINSTANCE.getResultIssue_Issues();

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
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.AModelReferenceImpl <em>AModel Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.AModelReferenceImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAModelReference()
     * @generated
     */
    EClass AMODEL_REFERENCE = eINSTANCE.getAModelReference();

    /**
     * The meta object literal for the '<em><b>Model Element</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AMODEL_REFERENCE__MODEL_ELEMENT = eINSTANCE.getAModelReference_ModelElement();

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
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.AFunctionCallImpl <em>AFunction Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.AFunctionCallImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAFunctionCall()
     * @generated
     */
    EClass AFUNCTION_CALL = eINSTANCE.getAFunctionCall();

    /**
     * The meta object literal for the '<em><b>Function</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AFUNCTION_CALL__FUNCTION = eINSTANCE.getAFunctionCall_Function();

    /**
     * The meta object literal for the '<em><b>Function Call Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AFUNCTION_CALL__FUNCTION_CALL_ARGUMENTS = eINSTANCE.getAFunctionCall_FunctionCallArguments();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.AThisImpl <em>AThis</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.AThisImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAThis()
     * @generated
     */
    EClass ATHIS = eINSTANCE.getAThis();

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
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASET_LITERAL__ELEMENTS = eINSTANCE.getASetLiteral_Elements();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.AListTermImpl <em>AList Term</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.AListTermImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAListTerm()
     * @generated
     */
    EClass ALIST_TERM = eINSTANCE.getAListTerm();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ALIST_TERM__ELEMENTS = eINSTANCE.getAListTerm_Elements();

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
     * The meta object literal for the '{@link org.osate.alisa.common.common.ResultIssueType <em>Result Issue Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.ResultIssueType
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getResultIssueType()
     * @generated
     */
    EEnum RESULT_ISSUE_TYPE = eINSTANCE.getResultIssueType();

  }

} //CommonPackage
