/**
 */
package com.rockwellcollins.atc.resolute.resolute;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.rockwellcollins.atc.resolute.resolute.ResoluteFactory
 * @model kind="package"
 * @generated
 */
public interface ResolutePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "resolute";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.rockwellcollins.com/atc/resolute/Resolute";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "resolute";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ResolutePackage eINSTANCE = com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl.init();

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ResoluteLibraryImpl <em>Library</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResoluteLibraryImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getResoluteLibrary()
   * @generated
   */
  int RESOLUTE_LIBRARY = 0;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_LIBRARY__OWNED_ELEMENT = Aadl2Package.ANNEX_LIBRARY__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_LIBRARY__OWNED_COMMENT = Aadl2Package.ANNEX_LIBRARY__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_LIBRARY__NAME = Aadl2Package.ANNEX_LIBRARY__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_LIBRARY__QUALIFIED_NAME = Aadl2Package.ANNEX_LIBRARY__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_LIBRARY__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.ANNEX_LIBRARY__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_LIBRARY__DEFINITIONS = Aadl2Package.ANNEX_LIBRARY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Library</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_LIBRARY_FEATURE_COUNT = Aadl2Package.ANNEX_LIBRARY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.DefinitionImpl <em>Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.DefinitionImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getDefinition()
   * @generated
   */
  int DEFINITION = 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__OWNED_ELEMENT = Aadl2Package.NAMED_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__OWNED_COMMENT = Aadl2Package.NAMED_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__NAME = Aadl2Package.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__QUALIFIED_NAME = Aadl2Package.NAMED_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The number of structural features of the '<em>Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_FEATURE_COUNT = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.TypeImpl <em>Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.TypeImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getType()
   * @generated
   */
  int TYPE = 2;

  /**
   * The number of structural features of the '<em>Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.BaseTypeImpl <em>Base Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.BaseTypeImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getBaseType()
   * @generated
   */
  int BASE_TYPE = 3;

  /**
   * The feature id for the '<em><b>Param Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_TYPE__PARAM_TYPE = TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_TYPE__TYPE = TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Base Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BASE_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ArgImpl <em>Arg</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ArgImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getArg()
   * @generated
   */
  int ARG = 4;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARG__OWNED_ELEMENT = Aadl2Package.NAMED_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARG__OWNED_COMMENT = Aadl2Package.NAMED_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARG__NAME = Aadl2Package.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARG__QUALIFIED_NAME = Aadl2Package.NAMED_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARG__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARG__TYPE = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Arg</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARG_FEATURE_COUNT = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ConstantDefinitionImpl <em>Constant Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ConstantDefinitionImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getConstantDefinition()
   * @generated
   */
  int CONSTANT_DEFINITION = 5;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__OWNED_ELEMENT = DEFINITION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__OWNED_COMMENT = DEFINITION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__NAME = DEFINITION__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__QUALIFIED_NAME = DEFINITION__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__OWNED_PROPERTY_ASSOCIATION = DEFINITION__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__TYPE = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__EXPR = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Constant Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.FunctionDefinitionImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getFunctionDefinition()
   * @generated
   */
  int FUNCTION_DEFINITION = 6;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__OWNED_ELEMENT = Aadl2Package.NAMESPACE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__OWNED_COMMENT = Aadl2Package.NAMESPACE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__NAME = Aadl2Package.NAMESPACE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__QUALIFIED_NAME = Aadl2Package.NAMESPACE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.NAMESPACE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Owned Member</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__OWNED_MEMBER = Aadl2Package.NAMESPACE__OWNED_MEMBER;

  /**
   * The feature id for the '<em><b>Member</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__MEMBER = Aadl2Package.NAMESPACE__MEMBER;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__ARGS = Aadl2Package.NAMESPACE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__BODY = Aadl2Package.NAMESPACE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Function Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION_FEATURE_COUNT = Aadl2Package.NAMESPACE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.DefinitionBodyImpl <em>Definition Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.DefinitionBodyImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getDefinitionBody()
   * @generated
   */
  int DEFINITION_BODY = 7;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_BODY__OWNED_ELEMENT = Aadl2Package.ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_BODY__OWNED_COMMENT = Aadl2Package.ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_BODY__EXPR = Aadl2Package.ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Definition Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_BODY_FEATURE_COUNT = Aadl2Package.ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimTextImpl <em>Claim Text</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ClaimTextImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getClaimText()
   * @generated
   */
  int CLAIM_TEXT = 8;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_TEXT__OWNED_ELEMENT = Aadl2Package.ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_TEXT__OWNED_COMMENT = Aadl2Package.ELEMENT__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Claim Text</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_TEXT_FEATURE_COUNT = Aadl2Package.ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimTextVarImpl <em>Claim Text Var</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ClaimTextVarImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getClaimTextVar()
   * @generated
   */
  int CLAIM_TEXT_VAR = 9;

  /**
   * The number of structural features of the '<em>Claim Text Var</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_TEXT_VAR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ExprImpl <em>Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getExpr()
   * @generated
   */
  int EXPR = 10;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR__OWNED_ELEMENT = Aadl2Package.ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR__OWNED_COMMENT = Aadl2Package.ELEMENT__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_FEATURE_COUNT = Aadl2Package.ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.LetBindingImpl <em>Let Binding</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.LetBindingImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getLetBinding()
   * @generated
   */
  int LET_BINDING = 11;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_BINDING__OWNED_ELEMENT = Aadl2Package.NAMED_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_BINDING__OWNED_COMMENT = Aadl2Package.NAMED_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_BINDING__NAME = Aadl2Package.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_BINDING__QUALIFIED_NAME = Aadl2Package.NAMED_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_BINDING__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_BINDING__TYPE = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_BINDING__EXPR = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Let Binding</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_BINDING_FEATURE_COUNT = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ResoluteSubclauseImpl <em>Subclause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResoluteSubclauseImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getResoluteSubclause()
   * @generated
   */
  int RESOLUTE_SUBCLAUSE = 12;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_SUBCLAUSE__OWNED_ELEMENT = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_SUBCLAUSE__OWNED_COMMENT = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_SUBCLAUSE__NAME = Aadl2Package.ANNEX_SUBCLAUSE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_SUBCLAUSE__QUALIFIED_NAME = Aadl2Package.ANNEX_SUBCLAUSE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_SUBCLAUSE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>In Mode</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_SUBCLAUSE__IN_MODE = Aadl2Package.ANNEX_SUBCLAUSE__IN_MODE;

  /**
   * The feature id for the '<em><b>Proves</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_SUBCLAUSE__PROVES = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Subclause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESOLUTE_SUBCLAUSE_FEATURE_COUNT = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.NestedDotIDImpl <em>Nested Dot ID</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.NestedDotIDImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getNestedDotID()
   * @generated
   */
  int NESTED_DOT_ID = 13;

  /**
   * The feature id for the '<em><b>Base</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_DOT_ID__BASE = 0;

  /**
   * The feature id for the '<em><b>Sub</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_DOT_ID__SUB = 1;

  /**
   * The number of structural features of the '<em>Nested Dot ID</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_DOT_ID_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ProveStatementImpl <em>Prove Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ProveStatementImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getProveStatement()
   * @generated
   */
  int PROVE_STATEMENT = 14;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVE_STATEMENT__OWNED_ELEMENT = Aadl2Package.ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVE_STATEMENT__OWNED_COMMENT = Aadl2Package.ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVE_STATEMENT__EXPR = Aadl2Package.ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Prove Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROVE_STATEMENT_FEATURE_COUNT = Aadl2Package.ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ListTypeImpl <em>List Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ListTypeImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getListType()
   * @generated
   */
  int LIST_TYPE = 15;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_TYPE__TYPE = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>List Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.SetTypeImpl <em>Set Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.SetTypeImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getSetType()
   * @generated
   */
  int SET_TYPE = 16;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_TYPE__TYPE = TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Set Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_TYPE_FEATURE_COUNT = TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.QuantArgImpl <em>Quant Arg</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.QuantArgImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getQuantArg()
   * @generated
   */
  int QUANT_ARG = 17;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANT_ARG__OWNED_ELEMENT = ARG__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANT_ARG__OWNED_COMMENT = ARG__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANT_ARG__NAME = ARG__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANT_ARG__QUALIFIED_NAME = ARG__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANT_ARG__OWNED_PROPERTY_ASSOCIATION = ARG__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANT_ARG__TYPE = ARG__TYPE;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANT_ARG__EXPR = ARG_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Quant Arg</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANT_ARG_FEATURE_COUNT = ARG_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.FunctionBodyImpl <em>Function Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.FunctionBodyImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getFunctionBody()
   * @generated
   */
  int FUNCTION_BODY = 18;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_BODY__OWNED_ELEMENT = DEFINITION_BODY__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_BODY__OWNED_COMMENT = DEFINITION_BODY__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_BODY__EXPR = DEFINITION_BODY__EXPR;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_BODY__TYPE = DEFINITION_BODY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Function Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_BODY_FEATURE_COUNT = DEFINITION_BODY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimBodyImpl <em>Claim Body</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ClaimBodyImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getClaimBody()
   * @generated
   */
  int CLAIM_BODY = 19;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_BODY__OWNED_ELEMENT = DEFINITION_BODY__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_BODY__OWNED_COMMENT = DEFINITION_BODY__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_BODY__EXPR = DEFINITION_BODY__EXPR;

  /**
   * The feature id for the '<em><b>Claim</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_BODY__CLAIM = DEFINITION_BODY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Claim Body</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_BODY_FEATURE_COUNT = DEFINITION_BODY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimStringImpl <em>Claim String</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ClaimStringImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getClaimString()
   * @generated
   */
  int CLAIM_STRING = 20;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_STRING__OWNED_ELEMENT = CLAIM_TEXT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_STRING__OWNED_COMMENT = CLAIM_TEXT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Str</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_STRING__STR = CLAIM_TEXT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Claim String</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_STRING_FEATURE_COUNT = CLAIM_TEXT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimArgImpl <em>Claim Arg</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ClaimArgImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getClaimArg()
   * @generated
   */
  int CLAIM_ARG = 21;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_ARG__OWNED_ELEMENT = CLAIM_TEXT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_ARG__OWNED_COMMENT = CLAIM_TEXT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Arg</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_ARG__ARG = CLAIM_TEXT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_ARG__UNIT = CLAIM_TEXT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Claim Arg</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLAIM_ARG_FEATURE_COUNT = CLAIM_TEXT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.BinaryExprImpl <em>Binary Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.BinaryExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getBinaryExpr()
   * @generated
   */
  int BINARY_EXPR = 22;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__LEFT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__OP = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR__RIGHT = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Binary Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.InstanceOfExprImpl <em>Instance Of Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.InstanceOfExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getInstanceOfExpr()
   * @generated
   */
  int INSTANCE_OF_EXPR = 23;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_OF_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_OF_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_OF_EXPR__EXPR = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_OF_EXPR__TYPE = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Instance Of Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INSTANCE_OF_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.UnaryExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getUnaryExpr()
   * @generated
   */
  int UNARY_EXPR = 24;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__OP = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR__EXPR = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.CastExprImpl <em>Cast Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.CastExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getCastExpr()
   * @generated
   */
  int CAST_EXPR = 25;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPR__TYPE = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPR__EXPR = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Cast Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CAST_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.IdExprImpl <em>Id Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.IdExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getIdExpr()
   * @generated
   */
  int ID_EXPR = 26;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Id</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_EXPR__ID = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Id Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ID_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ThisExprImpl <em>This Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ThisExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getThisExpr()
   * @generated
   */
  int THIS_EXPR = 27;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIS_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIS_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Sub</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIS_EXPR__SUB = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>This Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int THIS_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.FailExprImpl <em>Fail Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.FailExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getFailExpr()
   * @generated
   */
  int FAIL_EXPR = 28;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_EXPR__VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Failmsg</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_EXPR__FAILMSG = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Fail Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FAIL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.IntExprImpl <em>Int Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.IntExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getIntExpr()
   * @generated
   */
  int INT_EXPR = 29;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_EXPR__VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.RealExprImpl <em>Real Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.RealExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getRealExpr()
   * @generated
   */
  int REAL_EXPR = 30;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_EXPR__VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Real Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.BoolExprImpl <em>Bool Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.BoolExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getBoolExpr()
   * @generated
   */
  int BOOL_EXPR = 31;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR__VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bool Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.StringExprImpl <em>String Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.StringExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getStringExpr()
   * @generated
   */
  int STRING_EXPR = 32;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Val</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPR__VAL = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.IfThenElseExprImpl <em>If Then Else Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.IfThenElseExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getIfThenElseExpr()
   * @generated
   */
  int IF_THEN_ELSE_EXPR = 33;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__COND = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__THEN = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR__ELSE = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Then Else Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_THEN_ELSE_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.QuantifiedExprImpl <em>Quantified Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.QuantifiedExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getQuantifiedExpr()
   * @generated
   */
  int QUANTIFIED_EXPR = 34;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTIFIED_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTIFIED_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Quant</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTIFIED_EXPR__QUANT = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTIFIED_EXPR__ARGS = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTIFIED_EXPR__EXPR = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Quantified Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUANTIFIED_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.BuiltInFnCallExprImpl <em>Built In Fn Call Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.BuiltInFnCallExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getBuiltInFnCallExpr()
   * @generated
   */
  int BUILT_IN_FN_CALL_EXPR = 35;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILT_IN_FN_CALL_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILT_IN_FN_CALL_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Fn</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILT_IN_FN_CALL_EXPR__FN = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILT_IN_FN_CALL_EXPR__ARGS = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Built In Fn Call Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILT_IN_FN_CALL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.FnCallExprImpl <em>Fn Call Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.FnCallExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getFnCallExpr()
   * @generated
   */
  int FN_CALL_EXPR = 36;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_CALL_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_CALL_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Fn</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_CALL_EXPR__FN = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_CALL_EXPR__ARGS = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Fn Call Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FN_CALL_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ListFilterMapExprImpl <em>List Filter Map Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ListFilterMapExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getListFilterMapExpr()
   * @generated
   */
  int LIST_FILTER_MAP_EXPR = 37;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_FILTER_MAP_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_FILTER_MAP_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Map</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_FILTER_MAP_EXPR__MAP = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_FILTER_MAP_EXPR__ARGS = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Filter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_FILTER_MAP_EXPR__FILTER = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>List Filter Map Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_FILTER_MAP_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ListExprImpl <em>List Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ListExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getListExpr()
   * @generated
   */
  int LIST_EXPR = 38;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_EXPR__EXPRS = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>List Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.SetFilterMapExprImpl <em>Set Filter Map Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.SetFilterMapExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getSetFilterMapExpr()
   * @generated
   */
  int SET_FILTER_MAP_EXPR = 39;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_FILTER_MAP_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_FILTER_MAP_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Map</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_FILTER_MAP_EXPR__MAP = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_FILTER_MAP_EXPR__ARGS = EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Filter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_FILTER_MAP_EXPR__FILTER = EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Set Filter Map Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_FILTER_MAP_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.SetExprImpl <em>Set Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.SetExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getSetExpr()
   * @generated
   */
  int SET_EXPR = 40;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Exprs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR__EXPRS = EXPR_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Set Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.LetExprImpl <em>Let Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.rockwellcollins.atc.resolute.resolute.impl.LetExprImpl
   * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getLetExpr()
   * @generated
   */
  int LET_EXPR = 41;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPR__OWNED_ELEMENT = EXPR__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPR__OWNED_COMMENT = EXPR__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Binding</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPR__BINDING = EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPR__EXPR = EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Let Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPR_FEATURE_COUNT = EXPR_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Library</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary
   * @generated
   */
  EClass getResoluteLibrary();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definitions</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ResoluteLibrary#getDefinitions()
   * @see #getResoluteLibrary()
   * @generated
   */
  EReference getResoluteLibrary_Definitions();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definition</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.Definition
   * @generated
   */
  EClass getDefinition();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.Type
   * @generated
   */
  EClass getType();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.BaseType <em>Base Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Base Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.BaseType
   * @generated
   */
  EClass getBaseType();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.BaseType#getParamType <em>Param Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Param Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.BaseType#getParamType()
   * @see #getBaseType()
   * @generated
   */
  EReference getBaseType_ParamType();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.resolute.resolute.BaseType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.BaseType#getType()
   * @see #getBaseType()
   * @generated
   */
  EAttribute getBaseType_Type();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.Arg <em>Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Arg</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.Arg
   * @generated
   */
  EClass getArg();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.Arg#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.Arg#getType()
   * @see #getArg()
   * @generated
   */
  EReference getArg_Type();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.ConstantDefinition <em>Constant Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Definition</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ConstantDefinition
   * @generated
   */
  EClass getConstantDefinition();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.ConstantDefinition#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ConstantDefinition#getType()
   * @see #getConstantDefinition()
   * @generated
   */
  EReference getConstantDefinition_Type();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.ConstantDefinition#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ConstantDefinition#getExpr()
   * @see #getConstantDefinition()
   * @generated
   */
  EReference getConstantDefinition_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.FunctionDefinition <em>Function Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Definition</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.FunctionDefinition
   * @generated
   */
  EClass getFunctionDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.resolute.resolute.FunctionDefinition#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.FunctionDefinition#getArgs()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Args();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.FunctionDefinition#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.FunctionDefinition#getBody()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Body();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.DefinitionBody <em>Definition Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definition Body</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.DefinitionBody
   * @generated
   */
  EClass getDefinitionBody();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.DefinitionBody#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.DefinitionBody#getExpr()
   * @see #getDefinitionBody()
   * @generated
   */
  EReference getDefinitionBody_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.ClaimText <em>Claim Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Claim Text</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimText
   * @generated
   */
  EClass getClaimText();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.ClaimTextVar <em>Claim Text Var</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Claim Text Var</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimTextVar
   * @generated
   */
  EClass getClaimTextVar();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.Expr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.Expr
   * @generated
   */
  EClass getExpr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.LetBinding <em>Let Binding</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Let Binding</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.LetBinding
   * @generated
   */
  EClass getLetBinding();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.LetBinding#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.LetBinding#getType()
   * @see #getLetBinding()
   * @generated
   */
  EReference getLetBinding_Type();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.LetBinding#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.LetBinding#getExpr()
   * @see #getLetBinding()
   * @generated
   */
  EReference getLetBinding_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause <em>Subclause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subclause</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause
   * @generated
   */
  EClass getResoluteSubclause();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause#getProves <em>Proves</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Proves</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ResoluteSubclause#getProves()
   * @see #getResoluteSubclause()
   * @generated
   */
  EReference getResoluteSubclause_Proves();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.NestedDotID <em>Nested Dot ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Dot ID</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.NestedDotID
   * @generated
   */
  EClass getNestedDotID();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.resolute.resolute.NestedDotID#getBase <em>Base</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Base</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.NestedDotID#getBase()
   * @see #getNestedDotID()
   * @generated
   */
  EReference getNestedDotID_Base();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.NestedDotID#getSub <em>Sub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.NestedDotID#getSub()
   * @see #getNestedDotID()
   * @generated
   */
  EReference getNestedDotID_Sub();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.ProveStatement <em>Prove Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Prove Statement</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ProveStatement
   * @generated
   */
  EClass getProveStatement();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.ProveStatement#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ProveStatement#getExpr()
   * @see #getProveStatement()
   * @generated
   */
  EReference getProveStatement_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.ListType <em>List Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ListType
   * @generated
   */
  EClass getListType();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.ListType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ListType#getType()
   * @see #getListType()
   * @generated
   */
  EReference getListType_Type();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.SetType <em>Set Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Set Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.SetType
   * @generated
   */
  EClass getSetType();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.SetType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.SetType#getType()
   * @see #getSetType()
   * @generated
   */
  EReference getSetType_Type();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.QuantArg <em>Quant Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quant Arg</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.QuantArg
   * @generated
   */
  EClass getQuantArg();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.QuantArg#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.QuantArg#getExpr()
   * @see #getQuantArg()
   * @generated
   */
  EReference getQuantArg_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.FunctionBody <em>Function Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Body</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.FunctionBody
   * @generated
   */
  EClass getFunctionBody();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.FunctionBody#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.FunctionBody#getType()
   * @see #getFunctionBody()
   * @generated
   */
  EReference getFunctionBody_Type();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.ClaimBody <em>Claim Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Claim Body</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimBody
   * @generated
   */
  EClass getClaimBody();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.resolute.resolute.ClaimBody#getClaim <em>Claim</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Claim</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimBody#getClaim()
   * @see #getClaimBody()
   * @generated
   */
  EReference getClaimBody_Claim();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.ClaimString <em>Claim String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Claim String</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimString
   * @generated
   */
  EClass getClaimString();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.resolute.resolute.ClaimString#getStr <em>Str</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Str</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimString#getStr()
   * @see #getClaimString()
   * @generated
   */
  EAttribute getClaimString_Str();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.ClaimArg <em>Claim Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Claim Arg</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimArg
   * @generated
   */
  EClass getClaimArg();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.resolute.resolute.ClaimArg#getArg <em>Arg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Arg</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimArg#getArg()
   * @see #getClaimArg()
   * @generated
   */
  EReference getClaimArg_Arg();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.resolute.resolute.ClaimArg#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Unit</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ClaimArg#getUnit()
   * @see #getClaimArg()
   * @generated
   */
  EReference getClaimArg_Unit();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.BinaryExpr <em>Binary Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.BinaryExpr
   * @generated
   */
  EClass getBinaryExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.BinaryExpr#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.BinaryExpr#getLeft()
   * @see #getBinaryExpr()
   * @generated
   */
  EReference getBinaryExpr_Left();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.resolute.resolute.BinaryExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.BinaryExpr#getOp()
   * @see #getBinaryExpr()
   * @generated
   */
  EAttribute getBinaryExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.BinaryExpr#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.BinaryExpr#getRight()
   * @see #getBinaryExpr()
   * @generated
   */
  EReference getBinaryExpr_Right();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr <em>Instance Of Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Instance Of Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr
   * @generated
   */
  EClass getInstanceOfExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr#getExpr()
   * @see #getInstanceOfExpr()
   * @generated
   */
  EReference getInstanceOfExpr_Expr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.InstanceOfExpr#getType()
   * @see #getInstanceOfExpr()
   * @generated
   */
  EReference getInstanceOfExpr_Type();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.UnaryExpr <em>Unary Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.UnaryExpr
   * @generated
   */
  EClass getUnaryExpr();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.resolute.resolute.UnaryExpr#getOp <em>Op</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Op</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.UnaryExpr#getOp()
   * @see #getUnaryExpr()
   * @generated
   */
  EAttribute getUnaryExpr_Op();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.UnaryExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.UnaryExpr#getExpr()
   * @see #getUnaryExpr()
   * @generated
   */
  EReference getUnaryExpr_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.CastExpr <em>Cast Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Cast Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.CastExpr
   * @generated
   */
  EClass getCastExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.CastExpr#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.CastExpr#getType()
   * @see #getCastExpr()
   * @generated
   */
  EReference getCastExpr_Type();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.CastExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.CastExpr#getExpr()
   * @see #getCastExpr()
   * @generated
   */
  EReference getCastExpr_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.IdExpr <em>Id Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Id Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.IdExpr
   * @generated
   */
  EClass getIdExpr();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.resolute.resolute.IdExpr#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Id</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.IdExpr#getId()
   * @see #getIdExpr()
   * @generated
   */
  EReference getIdExpr_Id();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.ThisExpr <em>This Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>This Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ThisExpr
   * @generated
   */
  EClass getThisExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.ThisExpr#getSub <em>Sub</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Sub</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ThisExpr#getSub()
   * @see #getThisExpr()
   * @generated
   */
  EReference getThisExpr_Sub();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.FailExpr <em>Fail Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fail Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.FailExpr
   * @generated
   */
  EClass getFailExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.FailExpr#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Val</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.FailExpr#getVal()
   * @see #getFailExpr()
   * @generated
   */
  EReference getFailExpr_Val();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.resolute.resolute.FailExpr#getFailmsg <em>Failmsg</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Failmsg</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.FailExpr#getFailmsg()
   * @see #getFailExpr()
   * @generated
   */
  EReference getFailExpr_Failmsg();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.IntExpr <em>Int Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.IntExpr
   * @generated
   */
  EClass getIntExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.IntExpr#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Val</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.IntExpr#getVal()
   * @see #getIntExpr()
   * @generated
   */
  EReference getIntExpr_Val();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.RealExpr <em>Real Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.RealExpr
   * @generated
   */
  EClass getRealExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.RealExpr#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Val</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.RealExpr#getVal()
   * @see #getRealExpr()
   * @generated
   */
  EReference getRealExpr_Val();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.BoolExpr <em>Bool Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.BoolExpr
   * @generated
   */
  EClass getBoolExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.BoolExpr#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Val</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.BoolExpr#getVal()
   * @see #getBoolExpr()
   * @generated
   */
  EReference getBoolExpr_Val();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.StringExpr <em>String Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.StringExpr
   * @generated
   */
  EClass getStringExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.StringExpr#getVal <em>Val</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Val</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.StringExpr#getVal()
   * @see #getStringExpr()
   * @generated
   */
  EReference getStringExpr_Val();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr <em>If Then Else Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Then Else Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr
   * @generated
   */
  EClass getIfThenElseExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getCond <em>Cond</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Cond</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getCond()
   * @see #getIfThenElseExpr()
   * @generated
   */
  EReference getIfThenElseExpr_Cond();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getThen <em>Then</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getThen()
   * @see #getIfThenElseExpr()
   * @generated
   */
  EReference getIfThenElseExpr_Then();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.IfThenElseExpr#getElse()
   * @see #getIfThenElseExpr()
   * @generated
   */
  EReference getIfThenElseExpr_Else();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr <em>Quantified Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Quantified Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr
   * @generated
   */
  EClass getQuantifiedExpr();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr#getQuant <em>Quant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Quant</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr#getQuant()
   * @see #getQuantifiedExpr()
   * @generated
   */
  EAttribute getQuantifiedExpr_Quant();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr#getArgs()
   * @see #getQuantifiedExpr()
   * @generated
   */
  EReference getQuantifiedExpr_Args();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.QuantifiedExpr#getExpr()
   * @see #getQuantifiedExpr()
   * @generated
   */
  EReference getQuantifiedExpr_Expr();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr <em>Built In Fn Call Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Built In Fn Call Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr
   * @generated
   */
  EClass getBuiltInFnCallExpr();

  /**
   * Returns the meta object for the attribute '{@link com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr#getFn <em>Fn</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fn</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr#getFn()
   * @see #getBuiltInFnCallExpr()
   * @generated
   */
  EAttribute getBuiltInFnCallExpr_Fn();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.BuiltInFnCallExpr#getArgs()
   * @see #getBuiltInFnCallExpr()
   * @generated
   */
  EReference getBuiltInFnCallExpr_Args();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.FnCallExpr <em>Fn Call Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fn Call Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.FnCallExpr
   * @generated
   */
  EClass getFnCallExpr();

  /**
   * Returns the meta object for the reference '{@link com.rockwellcollins.atc.resolute.resolute.FnCallExpr#getFn <em>Fn</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Fn</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.FnCallExpr#getFn()
   * @see #getFnCallExpr()
   * @generated
   */
  EReference getFnCallExpr_Fn();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.resolute.resolute.FnCallExpr#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.FnCallExpr#getArgs()
   * @see #getFnCallExpr()
   * @generated
   */
  EReference getFnCallExpr_Args();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr <em>List Filter Map Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Filter Map Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr
   * @generated
   */
  EClass getListFilterMapExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr#getMap <em>Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Map</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr#getMap()
   * @see #getListFilterMapExpr()
   * @generated
   */
  EReference getListFilterMapExpr_Map();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr#getArgs()
   * @see #getListFilterMapExpr()
   * @generated
   */
  EReference getListFilterMapExpr_Args();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr#getFilter <em>Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Filter</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ListFilterMapExpr#getFilter()
   * @see #getListFilterMapExpr()
   * @generated
   */
  EReference getListFilterMapExpr_Filter();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.ListExpr <em>List Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ListExpr
   * @generated
   */
  EClass getListExpr();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.resolute.resolute.ListExpr#getExprs <em>Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exprs</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.ListExpr#getExprs()
   * @see #getListExpr()
   * @generated
   */
  EReference getListExpr_Exprs();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr <em>Set Filter Map Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Set Filter Map Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr
   * @generated
   */
  EClass getSetFilterMapExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr#getMap <em>Map</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Map</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr#getMap()
   * @see #getSetFilterMapExpr()
   * @generated
   */
  EReference getSetFilterMapExpr_Map();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr#getArgs()
   * @see #getSetFilterMapExpr()
   * @generated
   */
  EReference getSetFilterMapExpr_Args();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr#getFilter <em>Filter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Filter</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.SetFilterMapExpr#getFilter()
   * @see #getSetFilterMapExpr()
   * @generated
   */
  EReference getSetFilterMapExpr_Filter();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.SetExpr <em>Set Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Set Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.SetExpr
   * @generated
   */
  EClass getSetExpr();

  /**
   * Returns the meta object for the containment reference list '{@link com.rockwellcollins.atc.resolute.resolute.SetExpr#getExprs <em>Exprs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exprs</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.SetExpr#getExprs()
   * @see #getSetExpr()
   * @generated
   */
  EReference getSetExpr_Exprs();

  /**
   * Returns the meta object for class '{@link com.rockwellcollins.atc.resolute.resolute.LetExpr <em>Let Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Let Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.LetExpr
   * @generated
   */
  EClass getLetExpr();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.LetExpr#getBinding <em>Binding</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Binding</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.LetExpr#getBinding()
   * @see #getLetExpr()
   * @generated
   */
  EReference getLetExpr_Binding();

  /**
   * Returns the meta object for the containment reference '{@link com.rockwellcollins.atc.resolute.resolute.LetExpr#getExpr <em>Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expr</em>'.
   * @see com.rockwellcollins.atc.resolute.resolute.LetExpr#getExpr()
   * @see #getLetExpr()
   * @generated
   */
  EReference getLetExpr_Expr();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ResoluteFactory getResoluteFactory();

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
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ResoluteLibraryImpl <em>Library</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResoluteLibraryImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getResoluteLibrary()
     * @generated
     */
    EClass RESOLUTE_LIBRARY = eINSTANCE.getResoluteLibrary();

    /**
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESOLUTE_LIBRARY__DEFINITIONS = eINSTANCE.getResoluteLibrary_Definitions();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.DefinitionImpl <em>Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.DefinitionImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getDefinition()
     * @generated
     */
    EClass DEFINITION = eINSTANCE.getDefinition();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.TypeImpl <em>Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.TypeImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getType()
     * @generated
     */
    EClass TYPE = eINSTANCE.getType();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.BaseTypeImpl <em>Base Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.BaseTypeImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getBaseType()
     * @generated
     */
    EClass BASE_TYPE = eINSTANCE.getBaseType();

    /**
     * The meta object literal for the '<em><b>Param Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BASE_TYPE__PARAM_TYPE = eINSTANCE.getBaseType_ParamType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BASE_TYPE__TYPE = eINSTANCE.getBaseType_Type();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ArgImpl <em>Arg</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ArgImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getArg()
     * @generated
     */
    EClass ARG = eINSTANCE.getArg();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARG__TYPE = eINSTANCE.getArg_Type();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ConstantDefinitionImpl <em>Constant Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ConstantDefinitionImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getConstantDefinition()
     * @generated
     */
    EClass CONSTANT_DEFINITION = eINSTANCE.getConstantDefinition();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT_DEFINITION__TYPE = eINSTANCE.getConstantDefinition_Type();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT_DEFINITION__EXPR = eINSTANCE.getConstantDefinition_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.FunctionDefinitionImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getFunctionDefinition()
     * @generated
     */
    EClass FUNCTION_DEFINITION = eINSTANCE.getFunctionDefinition();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__ARGS = eINSTANCE.getFunctionDefinition_Args();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__BODY = eINSTANCE.getFunctionDefinition_Body();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.DefinitionBodyImpl <em>Definition Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.DefinitionBodyImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getDefinitionBody()
     * @generated
     */
    EClass DEFINITION_BODY = eINSTANCE.getDefinitionBody();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINITION_BODY__EXPR = eINSTANCE.getDefinitionBody_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimTextImpl <em>Claim Text</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ClaimTextImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getClaimText()
     * @generated
     */
    EClass CLAIM_TEXT = eINSTANCE.getClaimText();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimTextVarImpl <em>Claim Text Var</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ClaimTextVarImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getClaimTextVar()
     * @generated
     */
    EClass CLAIM_TEXT_VAR = eINSTANCE.getClaimTextVar();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ExprImpl <em>Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getExpr()
     * @generated
     */
    EClass EXPR = eINSTANCE.getExpr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.LetBindingImpl <em>Let Binding</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.LetBindingImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getLetBinding()
     * @generated
     */
    EClass LET_BINDING = eINSTANCE.getLetBinding();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_BINDING__TYPE = eINSTANCE.getLetBinding_Type();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_BINDING__EXPR = eINSTANCE.getLetBinding_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ResoluteSubclauseImpl <em>Subclause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResoluteSubclauseImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getResoluteSubclause()
     * @generated
     */
    EClass RESOLUTE_SUBCLAUSE = eINSTANCE.getResoluteSubclause();

    /**
     * The meta object literal for the '<em><b>Proves</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESOLUTE_SUBCLAUSE__PROVES = eINSTANCE.getResoluteSubclause_Proves();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.NestedDotIDImpl <em>Nested Dot ID</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.NestedDotIDImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getNestedDotID()
     * @generated
     */
    EClass NESTED_DOT_ID = eINSTANCE.getNestedDotID();

    /**
     * The meta object literal for the '<em><b>Base</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NESTED_DOT_ID__BASE = eINSTANCE.getNestedDotID_Base();

    /**
     * The meta object literal for the '<em><b>Sub</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NESTED_DOT_ID__SUB = eINSTANCE.getNestedDotID_Sub();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ProveStatementImpl <em>Prove Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ProveStatementImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getProveStatement()
     * @generated
     */
    EClass PROVE_STATEMENT = eINSTANCE.getProveStatement();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROVE_STATEMENT__EXPR = eINSTANCE.getProveStatement_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ListTypeImpl <em>List Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ListTypeImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getListType()
     * @generated
     */
    EClass LIST_TYPE = eINSTANCE.getListType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_TYPE__TYPE = eINSTANCE.getListType_Type();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.SetTypeImpl <em>Set Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.SetTypeImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getSetType()
     * @generated
     */
    EClass SET_TYPE = eINSTANCE.getSetType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_TYPE__TYPE = eINSTANCE.getSetType_Type();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.QuantArgImpl <em>Quant Arg</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.QuantArgImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getQuantArg()
     * @generated
     */
    EClass QUANT_ARG = eINSTANCE.getQuantArg();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUANT_ARG__EXPR = eINSTANCE.getQuantArg_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.FunctionBodyImpl <em>Function Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.FunctionBodyImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getFunctionBody()
     * @generated
     */
    EClass FUNCTION_BODY = eINSTANCE.getFunctionBody();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_BODY__TYPE = eINSTANCE.getFunctionBody_Type();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimBodyImpl <em>Claim Body</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ClaimBodyImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getClaimBody()
     * @generated
     */
    EClass CLAIM_BODY = eINSTANCE.getClaimBody();

    /**
     * The meta object literal for the '<em><b>Claim</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_BODY__CLAIM = eINSTANCE.getClaimBody_Claim();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimStringImpl <em>Claim String</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ClaimStringImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getClaimString()
     * @generated
     */
    EClass CLAIM_STRING = eINSTANCE.getClaimString();

    /**
     * The meta object literal for the '<em><b>Str</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLAIM_STRING__STR = eINSTANCE.getClaimString_Str();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ClaimArgImpl <em>Claim Arg</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ClaimArgImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getClaimArg()
     * @generated
     */
    EClass CLAIM_ARG = eINSTANCE.getClaimArg();

    /**
     * The meta object literal for the '<em><b>Arg</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_ARG__ARG = eINSTANCE.getClaimArg_Arg();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLAIM_ARG__UNIT = eINSTANCE.getClaimArg_Unit();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.BinaryExprImpl <em>Binary Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.BinaryExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getBinaryExpr()
     * @generated
     */
    EClass BINARY_EXPR = eINSTANCE.getBinaryExpr();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_EXPR__LEFT = eINSTANCE.getBinaryExpr_Left();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BINARY_EXPR__OP = eINSTANCE.getBinaryExpr_Op();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_EXPR__RIGHT = eINSTANCE.getBinaryExpr_Right();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.InstanceOfExprImpl <em>Instance Of Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.InstanceOfExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getInstanceOfExpr()
     * @generated
     */
    EClass INSTANCE_OF_EXPR = eINSTANCE.getInstanceOfExpr();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE_OF_EXPR__EXPR = eINSTANCE.getInstanceOfExpr_Expr();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INSTANCE_OF_EXPR__TYPE = eINSTANCE.getInstanceOfExpr_Type();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.UnaryExprImpl <em>Unary Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.UnaryExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getUnaryExpr()
     * @generated
     */
    EClass UNARY_EXPR = eINSTANCE.getUnaryExpr();

    /**
     * The meta object literal for the '<em><b>Op</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_EXPR__OP = eINSTANCE.getUnaryExpr_Op();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_EXPR__EXPR = eINSTANCE.getUnaryExpr_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.CastExprImpl <em>Cast Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.CastExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getCastExpr()
     * @generated
     */
    EClass CAST_EXPR = eINSTANCE.getCastExpr();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAST_EXPR__TYPE = eINSTANCE.getCastExpr_Type();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CAST_EXPR__EXPR = eINSTANCE.getCastExpr_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.IdExprImpl <em>Id Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.IdExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getIdExpr()
     * @generated
     */
    EClass ID_EXPR = eINSTANCE.getIdExpr();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ID_EXPR__ID = eINSTANCE.getIdExpr_Id();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ThisExprImpl <em>This Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ThisExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getThisExpr()
     * @generated
     */
    EClass THIS_EXPR = eINSTANCE.getThisExpr();

    /**
     * The meta object literal for the '<em><b>Sub</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference THIS_EXPR__SUB = eINSTANCE.getThisExpr_Sub();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.FailExprImpl <em>Fail Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.FailExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getFailExpr()
     * @generated
     */
    EClass FAIL_EXPR = eINSTANCE.getFailExpr();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FAIL_EXPR__VAL = eINSTANCE.getFailExpr_Val();

    /**
     * The meta object literal for the '<em><b>Failmsg</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FAIL_EXPR__FAILMSG = eINSTANCE.getFailExpr_Failmsg();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.IntExprImpl <em>Int Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.IntExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getIntExpr()
     * @generated
     */
    EClass INT_EXPR = eINSTANCE.getIntExpr();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INT_EXPR__VAL = eINSTANCE.getIntExpr_Val();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.RealExprImpl <em>Real Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.RealExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getRealExpr()
     * @generated
     */
    EClass REAL_EXPR = eINSTANCE.getRealExpr();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REAL_EXPR__VAL = eINSTANCE.getRealExpr_Val();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.BoolExprImpl <em>Bool Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.BoolExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getBoolExpr()
     * @generated
     */
    EClass BOOL_EXPR = eINSTANCE.getBoolExpr();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BOOL_EXPR__VAL = eINSTANCE.getBoolExpr_Val();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.StringExprImpl <em>String Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.StringExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getStringExpr()
     * @generated
     */
    EClass STRING_EXPR = eINSTANCE.getStringExpr();

    /**
     * The meta object literal for the '<em><b>Val</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRING_EXPR__VAL = eINSTANCE.getStringExpr_Val();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.IfThenElseExprImpl <em>If Then Else Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.IfThenElseExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getIfThenElseExpr()
     * @generated
     */
    EClass IF_THEN_ELSE_EXPR = eINSTANCE.getIfThenElseExpr();

    /**
     * The meta object literal for the '<em><b>Cond</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_EXPR__COND = eINSTANCE.getIfThenElseExpr_Cond();

    /**
     * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_EXPR__THEN = eINSTANCE.getIfThenElseExpr_Then();

    /**
     * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_THEN_ELSE_EXPR__ELSE = eINSTANCE.getIfThenElseExpr_Else();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.QuantifiedExprImpl <em>Quantified Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.QuantifiedExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getQuantifiedExpr()
     * @generated
     */
    EClass QUANTIFIED_EXPR = eINSTANCE.getQuantifiedExpr();

    /**
     * The meta object literal for the '<em><b>Quant</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUANTIFIED_EXPR__QUANT = eINSTANCE.getQuantifiedExpr_Quant();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUANTIFIED_EXPR__ARGS = eINSTANCE.getQuantifiedExpr_Args();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference QUANTIFIED_EXPR__EXPR = eINSTANCE.getQuantifiedExpr_Expr();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.BuiltInFnCallExprImpl <em>Built In Fn Call Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.BuiltInFnCallExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getBuiltInFnCallExpr()
     * @generated
     */
    EClass BUILT_IN_FN_CALL_EXPR = eINSTANCE.getBuiltInFnCallExpr();

    /**
     * The meta object literal for the '<em><b>Fn</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BUILT_IN_FN_CALL_EXPR__FN = eINSTANCE.getBuiltInFnCallExpr_Fn();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BUILT_IN_FN_CALL_EXPR__ARGS = eINSTANCE.getBuiltInFnCallExpr_Args();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.FnCallExprImpl <em>Fn Call Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.FnCallExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getFnCallExpr()
     * @generated
     */
    EClass FN_CALL_EXPR = eINSTANCE.getFnCallExpr();

    /**
     * The meta object literal for the '<em><b>Fn</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FN_CALL_EXPR__FN = eINSTANCE.getFnCallExpr_Fn();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FN_CALL_EXPR__ARGS = eINSTANCE.getFnCallExpr_Args();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ListFilterMapExprImpl <em>List Filter Map Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ListFilterMapExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getListFilterMapExpr()
     * @generated
     */
    EClass LIST_FILTER_MAP_EXPR = eINSTANCE.getListFilterMapExpr();

    /**
     * The meta object literal for the '<em><b>Map</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_FILTER_MAP_EXPR__MAP = eINSTANCE.getListFilterMapExpr_Map();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_FILTER_MAP_EXPR__ARGS = eINSTANCE.getListFilterMapExpr_Args();

    /**
     * The meta object literal for the '<em><b>Filter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_FILTER_MAP_EXPR__FILTER = eINSTANCE.getListFilterMapExpr_Filter();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.ListExprImpl <em>List Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ListExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getListExpr()
     * @generated
     */
    EClass LIST_EXPR = eINSTANCE.getListExpr();

    /**
     * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_EXPR__EXPRS = eINSTANCE.getListExpr_Exprs();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.SetFilterMapExprImpl <em>Set Filter Map Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.SetFilterMapExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getSetFilterMapExpr()
     * @generated
     */
    EClass SET_FILTER_MAP_EXPR = eINSTANCE.getSetFilterMapExpr();

    /**
     * The meta object literal for the '<em><b>Map</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_FILTER_MAP_EXPR__MAP = eINSTANCE.getSetFilterMapExpr_Map();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_FILTER_MAP_EXPR__ARGS = eINSTANCE.getSetFilterMapExpr_Args();

    /**
     * The meta object literal for the '<em><b>Filter</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_FILTER_MAP_EXPR__FILTER = eINSTANCE.getSetFilterMapExpr_Filter();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.SetExprImpl <em>Set Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.SetExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getSetExpr()
     * @generated
     */
    EClass SET_EXPR = eINSTANCE.getSetExpr();

    /**
     * The meta object literal for the '<em><b>Exprs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_EXPR__EXPRS = eINSTANCE.getSetExpr_Exprs();

    /**
     * The meta object literal for the '{@link com.rockwellcollins.atc.resolute.resolute.impl.LetExprImpl <em>Let Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.rockwellcollins.atc.resolute.resolute.impl.LetExprImpl
     * @see com.rockwellcollins.atc.resolute.resolute.impl.ResolutePackageImpl#getLetExpr()
     * @generated
     */
    EClass LET_EXPR = eINSTANCE.getLetExpr();

    /**
     * The meta object literal for the '<em><b>Binding</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_EXPR__BINDING = eINSTANCE.getLetExpr_Binding();

    /**
     * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_EXPR__EXPR = eINSTANCE.getLetExpr_Expr();

  }

} //ResolutePackage
