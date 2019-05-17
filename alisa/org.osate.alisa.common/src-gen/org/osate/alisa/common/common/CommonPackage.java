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
   * The feature id for the '<em><b>This Target</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT__THIS_TARGET = 1;

  /**
   * The feature id for the '<em><b>Image</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT__IMAGE = 2;

  /**
   * The feature id for the '<em><b>Show Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DESCRIPTION_ELEMENT__SHOW_VALUE = 3;

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
   * The feature id for the '<em><b>Description</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RATIONALE__DESCRIPTION = 0;

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
   * The feature id for the '<em><b>Precedence</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAINTY__PRECEDENCE = 1;

  /**
   * The feature id for the '<em><b>Impact</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAINTY__IMPACT = 2;

  /**
   * The number of structural features of the '<em>Uncertainty</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNCERTAINTY_FEATURE_COUNT = 3;

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
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVARIABLE_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVARIABLE_DECLARATION__TYPE = 1;

  /**
   * The feature id for the '<em><b>Range</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVARIABLE_DECLARATION__RANGE = 2;

  /**
   * The number of structural features of the '<em>AVariable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AVARIABLE_DECLARATION_FEATURE_COUNT = 3;

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
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AModelReferenceImpl <em>AModel Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AModelReferenceImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAModelReference()
   * @generated
   */
  int AMODEL_REFERENCE = 6;

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
   * The feature id for the '<em><b>Prev</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMODEL_REFERENCE__PREV = AEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>AModel Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AMODEL_REFERENCE_FEATURE_COUNT = AEXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.APropertyReferenceImpl <em>AProperty Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.APropertyReferenceImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAPropertyReference()
   * @generated
   */
  int APROPERTY_REFERENCE = 7;

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
   * The feature id for the '<em><b>Model Element Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APROPERTY_REFERENCE__MODEL_ELEMENT_REFERENCE = AEXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APROPERTY_REFERENCE__PROPERTY = AEXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>AProperty Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int APROPERTY_REFERENCE_FEATURE_COUNT = AEXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AUnitExpressionImpl <em>AUnit Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AUnitExpressionImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAUnitExpression()
   * @generated
   */
  int AUNIT_EXPRESSION = 8;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNIT_EXPRESSION__OWNED_ELEMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNIT_EXPRESSION__OWNED_COMMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNIT_EXPRESSION__EXPRESSION = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Convert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNIT_EXPRESSION__CONVERT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Drop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNIT_EXPRESSION__DROP = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNIT_EXPRESSION__UNIT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>AUnit Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNIT_EXPRESSION_FEATURE_COUNT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ImageReferenceImpl <em>Image Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ImageReferenceImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getImageReference()
   * @generated
   */
  int IMAGE_REFERENCE = 9;

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
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ModelRefImpl <em>Model Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ModelRefImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getModelRef()
   * @generated
   */
  int MODEL_REF = 10;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_REF__OWNED_ELEMENT = Aadl2Package.PROPERTY_TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_REF__OWNED_COMMENT = Aadl2Package.PROPERTY_TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_REF__NAME = Aadl2Package.PROPERTY_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_REF__QUALIFIED_NAME = Aadl2Package.PROPERTY_TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_REF__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.PROPERTY_TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The number of structural features of the '<em>Model Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_REF_FEATURE_COUNT = Aadl2Package.PROPERTY_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.TypeRefImpl <em>Type Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.TypeRefImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getTypeRef()
   * @generated
   */
  int TYPE_REF = 11;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__OWNED_ELEMENT = Aadl2Package.PROPERTY_TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__OWNED_COMMENT = Aadl2Package.PROPERTY_TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__NAME = Aadl2Package.PROPERTY_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__QUALIFIED_NAME = Aadl2Package.PROPERTY_TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.PROPERTY_TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__REF = Aadl2Package.PROPERTY_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF_FEATURE_COUNT = Aadl2Package.PROPERTY_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.PropertyRefImpl <em>Property Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.PropertyRefImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getPropertyRef()
   * @generated
   */
  int PROPERTY_REF = 12;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REF__OWNED_ELEMENT = Aadl2Package.PROPERTY_TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REF__OWNED_COMMENT = Aadl2Package.PROPERTY_TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REF__NAME = Aadl2Package.PROPERTY_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REF__QUALIFIED_NAME = Aadl2Package.PROPERTY_TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REF__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.PROPERTY_TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REF__REF = Aadl2Package.PROPERTY_TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Property Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REF_FEATURE_COUNT = Aadl2Package.PROPERTY_TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ValDeclarationImpl <em>Val Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ValDeclarationImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getValDeclaration()
   * @generated
   */
  int VAL_DECLARATION = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL_DECLARATION__NAME = AVARIABLE_DECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL_DECLARATION__TYPE = AVARIABLE_DECLARATION__TYPE;

  /**
   * The feature id for the '<em><b>Range</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL_DECLARATION__RANGE = AVARIABLE_DECLARATION__RANGE;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAL_DECLARATION__VALUE = AVARIABLE_DECLARATION_FEATURE_COUNT + 0;

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
  int COMPUTE_DECLARATION = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTE_DECLARATION__NAME = AVARIABLE_DECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTE_DECLARATION__TYPE = AVARIABLE_DECLARATION__TYPE;

  /**
   * The feature id for the '<em><b>Range</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTE_DECLARATION__RANGE = AVARIABLE_DECLARATION__RANGE;

  /**
   * The number of structural features of the '<em>Compute Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPUTE_DECLARATION_FEATURE_COUNT = AVARIABLE_DECLARATION_FEATURE_COUNT + 0;

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
  int ABINARY_OPERATION = 16;

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
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABINARY_OPERATION__LEFT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABINARY_OPERATION__OPERATOR = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABINARY_OPERATION__RIGHT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 2;

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
  int AUNARY_OPERATION = 17;

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
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AUNARY_OPERATION__OPERATOR = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

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
  int AFUNCTION_CALL = 18;

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
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFUNCTION_CALL__ARGUMENTS = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>AFunction Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int AFUNCTION_CALL_FEATURE_COUNT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.ARangeImpl <em>ARange</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.ARangeImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getARange()
   * @generated
   */
  int ARANGE = 19;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARANGE__OWNED_ELEMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARANGE__OWNED_COMMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Minimum</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARANGE__MINIMUM = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Maximum</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARANGE__MAXIMUM = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Delta</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARANGE__DELTA = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>ARange</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARANGE_FEATURE_COUNT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.impl.AConditionalImpl <em>AConditional</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.impl.AConditionalImpl
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAConditional()
   * @generated
   */
  int ACONDITIONAL = 20;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACONDITIONAL__OWNED_ELEMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACONDITIONAL__OWNED_COMMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>If</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACONDITIONAL__IF = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACONDITIONAL__THEN = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACONDITIONAL__ELSE = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>AConditional</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACONDITIONAL_FEATURE_COUNT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.Operation <em>Operation</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.Operation
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getOperation()
   * @generated
   */
  int OPERATION = 21;

  /**
   * The meta object id for the '{@link org.osate.alisa.common.common.TargetType <em>Target Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.alisa.common.common.TargetType
   * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getTargetType()
   * @generated
   */
  int TARGET_TYPE = 22;


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
   * Returns the meta object for class '{@link org.osate.alisa.common.common.Rationale <em>Rationale</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rationale</em>'.
   * @see org.osate.alisa.common.common.Rationale
   * @generated
   */
  EClass getRationale();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.alisa.common.common.Rationale#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Description</em>'.
   * @see org.osate.alisa.common.common.Rationale#getDescription()
   * @see #getRationale()
   * @generated
   */
  EReference getRationale_Description();

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
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.Uncertainty#getPrecedence <em>Precedence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Precedence</em>'.
   * @see org.osate.alisa.common.common.Uncertainty#getPrecedence()
   * @see #getUncertainty()
   * @generated
   */
  EAttribute getUncertainty_Precedence();

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
   * Returns the meta object for class '{@link org.osate.alisa.common.common.AVariableDeclaration <em>AVariable Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AVariable Declaration</em>'.
   * @see org.osate.alisa.common.common.AVariableDeclaration
   * @generated
   */
  EClass getAVariableDeclaration();

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
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.AVariableDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.osate.alisa.common.common.AVariableDeclaration#getType()
   * @see #getAVariableDeclaration()
   * @generated
   */
  EReference getAVariableDeclaration_Type();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.AVariableDeclaration#isRange <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Range</em>'.
   * @see org.osate.alisa.common.common.AVariableDeclaration#isRange()
   * @see #getAVariableDeclaration()
   * @generated
   */
  EAttribute getAVariableDeclaration_Range();

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
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.AModelReference#getPrev <em>Prev</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Prev</em>'.
   * @see org.osate.alisa.common.common.AModelReference#getPrev()
   * @see #getAModelReference()
   * @generated
   */
  EReference getAModelReference_Prev();

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
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.APropertyReference#getModelElementReference <em>Model Element Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Model Element Reference</em>'.
   * @see org.osate.alisa.common.common.APropertyReference#getModelElementReference()
   * @see #getAPropertyReference()
   * @generated
   */
  EReference getAPropertyReference_ModelElementReference();

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
   * Returns the meta object for class '{@link org.osate.alisa.common.common.AUnitExpression <em>AUnit Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AUnit Expression</em>'.
   * @see org.osate.alisa.common.common.AUnitExpression
   * @generated
   */
  EClass getAUnitExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.AUnitExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.osate.alisa.common.common.AUnitExpression#getExpression()
   * @see #getAUnitExpression()
   * @generated
   */
  EReference getAUnitExpression_Expression();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.AUnitExpression#isConvert <em>Convert</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Convert</em>'.
   * @see org.osate.alisa.common.common.AUnitExpression#isConvert()
   * @see #getAUnitExpression()
   * @generated
   */
  EAttribute getAUnitExpression_Convert();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.AUnitExpression#isDrop <em>Drop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Drop</em>'.
   * @see org.osate.alisa.common.common.AUnitExpression#isDrop()
   * @see #getAUnitExpression()
   * @generated
   */
  EAttribute getAUnitExpression_Drop();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.common.common.AUnitExpression#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Unit</em>'.
   * @see org.osate.alisa.common.common.AUnitExpression#getUnit()
   * @see #getAUnitExpression()
   * @generated
   */
  EReference getAUnitExpression_Unit();

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
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ModelRef <em>Model Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Ref</em>'.
   * @see org.osate.alisa.common.common.ModelRef
   * @generated
   */
  EClass getModelRef();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.TypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Ref</em>'.
   * @see org.osate.alisa.common.common.TypeRef
   * @generated
   */
  EClass getTypeRef();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.common.common.TypeRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.osate.alisa.common.common.TypeRef#getRef()
   * @see #getTypeRef()
   * @generated
   */
  EReference getTypeRef_Ref();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.PropertyRef <em>Property Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Ref</em>'.
   * @see org.osate.alisa.common.common.PropertyRef
   * @generated
   */
  EClass getPropertyRef();

  /**
   * Returns the meta object for the reference '{@link org.osate.alisa.common.common.PropertyRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.osate.alisa.common.common.PropertyRef#getRef()
   * @see #getPropertyRef()
   * @generated
   */
  EReference getPropertyRef_Ref();

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
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.ValDeclaration#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.alisa.common.common.ValDeclaration#getValue()
   * @see #getValDeclaration()
   * @generated
   */
  EReference getValDeclaration_Value();

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
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.ABinaryOperation#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.osate.alisa.common.common.ABinaryOperation#getLeft()
   * @see #getABinaryOperation()
   * @generated
   */
  EReference getABinaryOperation_Left();

  /**
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.ABinaryOperation#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.osate.alisa.common.common.ABinaryOperation#getOperator()
   * @see #getABinaryOperation()
   * @generated
   */
  EAttribute getABinaryOperation_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.ABinaryOperation#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.osate.alisa.common.common.ABinaryOperation#getRight()
   * @see #getABinaryOperation()
   * @generated
   */
  EReference getABinaryOperation_Right();

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
   * Returns the meta object for the attribute '{@link org.osate.alisa.common.common.AUnaryOperation#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.osate.alisa.common.common.AUnaryOperation#getOperator()
   * @see #getAUnaryOperation()
   * @generated
   */
  EAttribute getAUnaryOperation_Operator();

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
   * Returns the meta object for the containment reference list '{@link org.osate.alisa.common.common.AFunctionCall#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see org.osate.alisa.common.common.AFunctionCall#getArguments()
   * @see #getAFunctionCall()
   * @generated
   */
  EReference getAFunctionCall_Arguments();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.ARange <em>ARange</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ARange</em>'.
   * @see org.osate.alisa.common.common.ARange
   * @generated
   */
  EClass getARange();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.ARange#getMinimum <em>Minimum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Minimum</em>'.
   * @see org.osate.alisa.common.common.ARange#getMinimum()
   * @see #getARange()
   * @generated
   */
  EReference getARange_Minimum();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.ARange#getMaximum <em>Maximum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Maximum</em>'.
   * @see org.osate.alisa.common.common.ARange#getMaximum()
   * @see #getARange()
   * @generated
   */
  EReference getARange_Maximum();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.ARange#getDelta <em>Delta</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Delta</em>'.
   * @see org.osate.alisa.common.common.ARange#getDelta()
   * @see #getARange()
   * @generated
   */
  EReference getARange_Delta();

  /**
   * Returns the meta object for class '{@link org.osate.alisa.common.common.AConditional <em>AConditional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>AConditional</em>'.
   * @see org.osate.alisa.common.common.AConditional
   * @generated
   */
  EClass getAConditional();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.AConditional#getIf <em>If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If</em>'.
   * @see org.osate.alisa.common.common.AConditional#getIf()
   * @see #getAConditional()
   * @generated
   */
  EReference getAConditional_If();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.AConditional#getThen <em>Then</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then</em>'.
   * @see org.osate.alisa.common.common.AConditional#getThen()
   * @see #getAConditional()
   * @generated
   */
  EReference getAConditional_Then();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.alisa.common.common.AConditional#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see org.osate.alisa.common.common.AConditional#getElse()
   * @see #getAConditional()
   * @generated
   */
  EReference getAConditional_Else();

  /**
   * Returns the meta object for enum '{@link org.osate.alisa.common.common.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Operation</em>'.
   * @see org.osate.alisa.common.common.Operation
   * @generated
   */
  EEnum getOperation();

  /**
   * Returns the meta object for enum '{@link org.osate.alisa.common.common.TargetType <em>Target Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Target Type</em>'.
   * @see org.osate.alisa.common.common.TargetType
   * @generated
   */
  EEnum getTargetType();

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
     * The meta object literal for the '<em><b>Show Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DESCRIPTION_ELEMENT__SHOW_VALUE = eINSTANCE.getDescriptionElement_ShowValue();

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
     * The meta object literal for the '<em><b>Description</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RATIONALE__DESCRIPTION = eINSTANCE.getRationale_Description();

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
     * The meta object literal for the '<em><b>Precedence</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNCERTAINTY__PRECEDENCE = eINSTANCE.getUncertainty_Precedence();

    /**
     * The meta object literal for the '<em><b>Impact</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNCERTAINTY__IMPACT = eINSTANCE.getUncertainty_Impact();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AVARIABLE_DECLARATION__NAME = eINSTANCE.getAVariableDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AVARIABLE_DECLARATION__TYPE = eINSTANCE.getAVariableDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Range</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AVARIABLE_DECLARATION__RANGE = eINSTANCE.getAVariableDeclaration_Range();

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
     * The meta object literal for the '<em><b>Prev</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AMODEL_REFERENCE__PREV = eINSTANCE.getAModelReference_Prev();

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
     * The meta object literal for the '<em><b>Model Element Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APROPERTY_REFERENCE__MODEL_ELEMENT_REFERENCE = eINSTANCE.getAPropertyReference_ModelElementReference();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference APROPERTY_REFERENCE__PROPERTY = eINSTANCE.getAPropertyReference_Property();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.AUnitExpressionImpl <em>AUnit Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.AUnitExpressionImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAUnitExpression()
     * @generated
     */
    EClass AUNIT_EXPRESSION = eINSTANCE.getAUnitExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUNIT_EXPRESSION__EXPRESSION = eINSTANCE.getAUnitExpression_Expression();

    /**
     * The meta object literal for the '<em><b>Convert</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AUNIT_EXPRESSION__CONVERT = eINSTANCE.getAUnitExpression_Convert();

    /**
     * The meta object literal for the '<em><b>Drop</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AUNIT_EXPRESSION__DROP = eINSTANCE.getAUnitExpression_Drop();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AUNIT_EXPRESSION__UNIT = eINSTANCE.getAUnitExpression_Unit();

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
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ModelRefImpl <em>Model Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ModelRefImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getModelRef()
     * @generated
     */
    EClass MODEL_REF = eINSTANCE.getModelRef();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.TypeRefImpl <em>Type Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.TypeRefImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getTypeRef()
     * @generated
     */
    EClass TYPE_REF = eINSTANCE.getTypeRef();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_REF__REF = eINSTANCE.getTypeRef_Ref();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.PropertyRefImpl <em>Property Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.PropertyRefImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getPropertyRef()
     * @generated
     */
    EClass PROPERTY_REF = eINSTANCE.getPropertyRef();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_REF__REF = eINSTANCE.getPropertyRef_Ref();

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
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAL_DECLARATION__VALUE = eINSTANCE.getValDeclaration_Value();

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
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABINARY_OPERATION__LEFT = eINSTANCE.getABinaryOperation_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ABINARY_OPERATION__OPERATOR = eINSTANCE.getABinaryOperation_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ABINARY_OPERATION__RIGHT = eINSTANCE.getABinaryOperation_Right();

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
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute AUNARY_OPERATION__OPERATOR = eINSTANCE.getAUnaryOperation_Operator();

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
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference AFUNCTION_CALL__ARGUMENTS = eINSTANCE.getAFunctionCall_Arguments();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.ARangeImpl <em>ARange</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.ARangeImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getARange()
     * @generated
     */
    EClass ARANGE = eINSTANCE.getARange();

    /**
     * The meta object literal for the '<em><b>Minimum</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARANGE__MINIMUM = eINSTANCE.getARange_Minimum();

    /**
     * The meta object literal for the '<em><b>Maximum</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARANGE__MAXIMUM = eINSTANCE.getARange_Maximum();

    /**
     * The meta object literal for the '<em><b>Delta</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARANGE__DELTA = eINSTANCE.getARange_Delta();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.impl.AConditionalImpl <em>AConditional</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.impl.AConditionalImpl
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getAConditional()
     * @generated
     */
    EClass ACONDITIONAL = eINSTANCE.getAConditional();

    /**
     * The meta object literal for the '<em><b>If</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACONDITIONAL__IF = eINSTANCE.getAConditional_If();

    /**
     * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACONDITIONAL__THEN = eINSTANCE.getAConditional_Then();

    /**
     * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACONDITIONAL__ELSE = eINSTANCE.getAConditional_Else();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.Operation <em>Operation</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.Operation
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getOperation()
     * @generated
     */
    EEnum OPERATION = eINSTANCE.getOperation();

    /**
     * The meta object literal for the '{@link org.osate.alisa.common.common.TargetType <em>Target Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.alisa.common.common.TargetType
     * @see org.osate.alisa.common.common.impl.CommonPackageImpl#getTargetType()
     * @generated
     */
    EEnum TARGET_TYPE = eINSTANCE.getTargetType();

  }

} //CommonPackage
