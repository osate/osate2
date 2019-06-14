/**
 */
package org.osate.expr.expr;

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
 * @see org.osate.expr.expr.ExprFactory
 * @model kind="package"
 * @generated
 */
public interface ExprPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "expr";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.osate.org/expr/Expr";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "expr";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExprPackage eINSTANCE = org.osate.expr.expr.impl.ExprPackageImpl.init();

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.ExprModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.ExprModelImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getExprModel()
   * @generated
   */
  int EXPR_MODEL = 0;

  /**
   * The feature id for the '<em><b>Annex</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_MODEL__ANNEX = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.EDeclarationImpl <em>EDeclaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.EDeclarationImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getEDeclaration()
   * @generated
   */
  int EDECLARATION = 1;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDECLARATION__OWNED_ELEMENT = Aadl2Package.NAMED_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDECLARATION__OWNED_COMMENT = Aadl2Package.NAMED_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDECLARATION__NAME = Aadl2Package.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDECLARATION__QUALIFIED_NAME = Aadl2Package.NAMED_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDECLARATION__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The number of structural features of the '<em>EDeclaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EDECLARATION_FEATURE_COUNT = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.TypeDeclImpl <em>Type Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.TypeDeclImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getTypeDecl()
   * @generated
   */
  int TYPE_DECL = 2;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECL__OWNED_ELEMENT = EDECLARATION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECL__OWNED_COMMENT = EDECLARATION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECL__NAME = EDECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECL__QUALIFIED_NAME = EDECLARATION__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECL__OWNED_PROPERTY_ASSOCIATION = EDECLARATION__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECL__TYPE = EDECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Property Associations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECL__OWNED_PROPERTY_ASSOCIATIONS = EDECLARATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Type Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DECL_FEATURE_COUNT = EDECLARATION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.VarDeclImpl <em>Var Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.VarDeclImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getVarDecl()
   * @generated
   */
  int VAR_DECL = 3;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__OWNED_ELEMENT = EDECLARATION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__OWNED_COMMENT = EDECLARATION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__NAME = EDECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__QUALIFIED_NAME = EDECLARATION__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__OWNED_PROPERTY_ASSOCIATION = EDECLARATION__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Const</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__CONST = EDECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Decl Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__DECL_TYPE = EDECLARATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL__VALUE = EDECLARATION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Var Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VAR_DECL_FEATURE_COUNT = EDECLARATION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.FunDeclImpl <em>Fun Decl</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.FunDeclImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getFunDecl()
   * @generated
   */
  int FUN_DECL = 4;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_DECL__OWNED_ELEMENT = EDECLARATION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_DECL__OWNED_COMMENT = EDECLARATION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_DECL__NAME = EDECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_DECL__QUALIFIED_NAME = EDECLARATION__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_DECL__OWNED_PROPERTY_ASSOCIATION = EDECLARATION__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_DECL__ARGS = EDECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Result Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_DECL__RESULT_TYPE = EDECLARATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Java</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_DECL__JAVA = EDECLARATION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Fqn</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_DECL__FQN = EDECLARATION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_DECL__EXP = EDECLARATION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Fun Decl</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUN_DECL_FEATURE_COUNT = EDECLARATION_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.ArgumentImpl <em>Argument</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.ArgumentImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getArgument()
   * @generated
   */
  int ARGUMENT = 5;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__OWNED_ELEMENT = Aadl2Package.NAMED_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__OWNED_COMMENT = Aadl2Package.NAMED_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__NAME = Aadl2Package.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__QUALIFIED_NAME = Aadl2Package.NAMED_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT__TYPE = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Argument</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARGUMENT_FEATURE_COUNT = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.AssertionImpl <em>Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.AssertionImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getAssertion()
   * @generated
   */
  int ASSERTION = 6;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION__OWNED_ELEMENT = EDECLARATION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION__OWNED_COMMENT = EDECLARATION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION__NAME = EDECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION__QUALIFIED_NAME = EDECLARATION__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION__OWNED_PROPERTY_ASSOCIATION = EDECLARATION__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Assert</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION__ASSERT = EDECLARATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Assertion</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSERTION_FEATURE_COUNT = EDECLARATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.ENumberTypeImpl <em>ENumber Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.ENumberTypeImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getENumberType()
   * @generated
   */
  int ENUMBER_TYPE = 7;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMBER_TYPE__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMBER_TYPE__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMBER_TYPE__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMBER_TYPE__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMBER_TYPE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The number of structural features of the '<em>ENumber Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMBER_TYPE_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.EIntegerImpl <em>EInteger</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.EIntegerImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getEInteger()
   * @generated
   */
  int EINTEGER = 8;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EINTEGER__OWNED_ELEMENT = ENUMBER_TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EINTEGER__OWNED_COMMENT = ENUMBER_TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EINTEGER__NAME = ENUMBER_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EINTEGER__QUALIFIED_NAME = ENUMBER_TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EINTEGER__OWNED_PROPERTY_ASSOCIATION = ENUMBER_TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The number of structural features of the '<em>EInteger</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EINTEGER_FEATURE_COUNT = ENUMBER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.ERealImpl <em>EReal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.ERealImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getEReal()
   * @generated
   */
  int EREAL = 9;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EREAL__OWNED_ELEMENT = ENUMBER_TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EREAL__OWNED_COMMENT = ENUMBER_TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EREAL__NAME = ENUMBER_TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EREAL__QUALIFIED_NAME = ENUMBER_TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EREAL__OWNED_PROPERTY_ASSOCIATION = ENUMBER_TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The number of structural features of the '<em>EReal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EREAL_FEATURE_COUNT = ENUMBER_TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.RangeTypeImpl <em>Range Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.RangeTypeImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getRangeType()
   * @generated
   */
  int RANGE_TYPE = 10;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_TYPE__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_TYPE__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_TYPE__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_TYPE__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_TYPE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_TYPE__TYPE = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Range Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_TYPE_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.CategoryImpl <em>Category</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.CategoryImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getCategory()
   * @generated
   */
  int CATEGORY = 11;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Category</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__CATEGORY = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Category</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.MetaClassImpl <em>Meta Class</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.MetaClassImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getMetaClass()
   * @generated
   */
  int META_CLASS = 12;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_CLASS__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_CLASS__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_CLASS__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_CLASS__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_CLASS__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Class</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_CLASS__CLASS = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Meta Class</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int META_CLASS_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.RecordTypeImpl <em>Record Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.RecordTypeImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getRecordType()
   * @generated
   */
  int RECORD_TYPE = 13;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE__FIELDS = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Record Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_TYPE_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.FieldImpl <em>Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.FieldImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getField()
   * @generated
   */
  int FIELD = 14;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__OWNED_ELEMENT = Aadl2Package.NAMED_ELEMENT__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__OWNED_COMMENT = Aadl2Package.NAMED_ELEMENT__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__NAME = Aadl2Package.NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__QUALIFIED_NAME = Aadl2Package.NAMED_ELEMENT__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.NAMED_ELEMENT__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__TYPE = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_FEATURE_COUNT = Aadl2Package.NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.UnionTypeImpl <em>Union Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.UnionTypeImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getUnionType()
   * @generated
   */
  int UNION_TYPE = 15;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_TYPE__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_TYPE__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_TYPE__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_TYPE__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_TYPE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_TYPE__FIELDS = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Union Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_TYPE_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.TupleTypeImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getTupleType()
   * @generated
   */
  int TUPLE_TYPE = 16;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE__FIELDS = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tuple Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.ListTypeImpl <em>List Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.ListTypeImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getListType()
   * @generated
   */
  int LIST_TYPE = 17;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_TYPE__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_TYPE__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_TYPE__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_TYPE__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_TYPE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_TYPE__TYPE = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>List Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_TYPE_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.SetTypeImpl <em>Set Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.SetTypeImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getSetType()
   * @generated
   */
  int SET_TYPE = 18;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_TYPE__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_TYPE__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_TYPE__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_TYPE__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_TYPE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_TYPE__TYPE = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Set Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_TYPE_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.BagTypeImpl <em>Bag Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.BagTypeImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getBagType()
   * @generated
   */
  int BAG_TYPE = 19;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAG_TYPE__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAG_TYPE__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAG_TYPE__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAG_TYPE__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAG_TYPE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAG_TYPE__TYPE = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bag Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAG_TYPE_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.MapTypeImpl <em>Map Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.MapTypeImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getMapType()
   * @generated
   */
  int MAP_TYPE = 20;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_TYPE__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_TYPE__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_TYPE__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_TYPE__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_TYPE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Domain</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_TYPE__DOMAIN = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Image</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_TYPE__IMAGE = Aadl2Package.TYPE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Map Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_TYPE_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.EnumTypeImpl <em>Enum Type</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.EnumTypeImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getEnumType()
   * @generated
   */
  int ENUM_TYPE = 21;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Literals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE__LITERALS = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enum Type</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_TYPE_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.EnumLiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getEnumLiteral()
   * @generated
   */
  int ENUM_LITERAL = 22;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL__NAME = 0;

  /**
   * The number of structural features of the '<em>Enum Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_LITERAL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.TypeRefImpl <em>Type Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.TypeRefImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getTypeRef()
   * @generated
   */
  int TYPE_REF = 23;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF__REF = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_REF_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.ExpressionImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 24;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__OWNED_ELEMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION__OWNED_COMMENT = Aadl2Package.PROPERTY_EXPRESSION__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = Aadl2Package.PROPERTY_EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.NamedElementRefImpl <em>Named Element Ref</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.NamedElementRefImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getNamedElementRef()
   * @generated
   */
  int NAMED_ELEMENT_REF = 25;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT_REF__OWNED_ELEMENT = EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT_REF__OWNED_COMMENT = EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Core</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT_REF__CORE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT_REF__REF = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT_REF__ARGS = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Named Element Ref</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT_REF_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.LiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 26;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__OWNED_ELEMENT = EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL__OWNED_COMMENT = EXPRESSION__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.ValueImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getValue()
   * @generated
   */
  int VALUE = 27;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.WrappedNamedElementImpl <em>Wrapped Named Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.WrappedNamedElementImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getWrappedNamedElement()
   * @generated
   */
  int WRAPPED_NAMED_ELEMENT = 28;

  /**
   * The feature id for the '<em><b>Elem</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRAPPED_NAMED_ELEMENT__ELEM = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Wrapped Named Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WRAPPED_NAMED_ELEMENT_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.NumberLiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getNumberLiteral()
   * @generated
   */
  int NUMBER_LITERAL = 29;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Number Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.FieldValueImpl <em>Field Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.FieldValueImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getFieldValue()
   * @generated
   */
  int FIELD_VALUE = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_VALUE__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_VALUE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Field Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.ExprLibraryImpl <em>Library</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.ExprLibraryImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getExprLibrary()
   * @generated
   */
  int EXPR_LIBRARY = 31;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_LIBRARY__OWNED_ELEMENT = Aadl2Package.ANNEX_LIBRARY__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_LIBRARY__OWNED_COMMENT = Aadl2Package.ANNEX_LIBRARY__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_LIBRARY__NAME = Aadl2Package.ANNEX_LIBRARY__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_LIBRARY__QUALIFIED_NAME = Aadl2Package.ANNEX_LIBRARY__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_LIBRARY__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.ANNEX_LIBRARY__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>Decls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_LIBRARY__DECLS = Aadl2Package.ANNEX_LIBRARY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Library</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_LIBRARY_FEATURE_COUNT = Aadl2Package.ANNEX_LIBRARY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.ExprSubclauseImpl <em>Subclause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.ExprSubclauseImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getExprSubclause()
   * @generated
   */
  int EXPR_SUBCLAUSE = 32;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_SUBCLAUSE__OWNED_ELEMENT = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_SUBCLAUSE__OWNED_COMMENT = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_SUBCLAUSE__NAME = Aadl2Package.ANNEX_SUBCLAUSE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_SUBCLAUSE__QUALIFIED_NAME = Aadl2Package.ANNEX_SUBCLAUSE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_SUBCLAUSE__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.ANNEX_SUBCLAUSE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The feature id for the '<em><b>In Mode</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_SUBCLAUSE__IN_MODE = Aadl2Package.ANNEX_SUBCLAUSE__IN_MODE;

  /**
   * The feature id for the '<em><b>Decls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_SUBCLAUSE__DECLS = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Subclause</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPR_SUBCLAUSE_FEATURE_COUNT = Aadl2Package.ANNEX_SUBCLAUSE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.EBooleanImpl <em>EBoolean</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.EBooleanImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getEBoolean()
   * @generated
   */
  int EBOOLEAN = 33;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOLEAN__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOLEAN__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOLEAN__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOLEAN__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOLEAN__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The number of structural features of the '<em>EBoolean</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOLEAN_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.EStringImpl <em>EString</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.EStringImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getEString()
   * @generated
   */
  int ESTRING = 34;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESTRING__OWNED_ELEMENT = Aadl2Package.TYPE__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESTRING__OWNED_COMMENT = Aadl2Package.TYPE__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESTRING__NAME = Aadl2Package.TYPE__NAME;

  /**
   * The feature id for the '<em><b>Qualified Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESTRING__QUALIFIED_NAME = Aadl2Package.TYPE__QUALIFIED_NAME;

  /**
   * The feature id for the '<em><b>Owned Property Association</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESTRING__OWNED_PROPERTY_ASSOCIATION = Aadl2Package.TYPE__OWNED_PROPERTY_ASSOCIATION;

  /**
   * The number of structural features of the '<em>EString</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESTRING_FEATURE_COUNT = Aadl2Package.TYPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.BlockImpl <em>Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.BlockImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getBlock()
   * @generated
   */
  int BLOCK = 35;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__OWNED_ELEMENT = EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__OWNED_COMMENT = EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Decls</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__DECLS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__RESULT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.BinaryOperationImpl <em>Binary Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.BinaryOperationImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getBinaryOperation()
   * @generated
   */
  int BINARY_OPERATION = 36;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_OPERATION__OWNED_ELEMENT = EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_OPERATION__OWNED_COMMENT = EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_OPERATION__LEFT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_OPERATION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_OPERATION__RIGHT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Binary Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_OPERATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.UnaryOperationImpl <em>Unary Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.UnaryOperationImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getUnaryOperation()
   * @generated
   */
  int UNARY_OPERATION = 37;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OPERATION__OWNED_ELEMENT = EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OPERATION__OWNED_COMMENT = EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OPERATION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OPERATION__OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_OPERATION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.UnitExpressionImpl <em>Unit Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.UnitExpressionImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getUnitExpression()
   * @generated
   */
  int UNIT_EXPRESSION = 38;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION__OWNED_ELEMENT = EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION__OWNED_COMMENT = EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Convert</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION__CONVERT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Drop</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION__DROP = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Unit</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION__UNIT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Unit Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.PropertyExpressionImpl <em>Property Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.PropertyExpressionImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getPropertyExpression()
   * @generated
   */
  int PROPERTY_EXPRESSION = 39;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_EXPRESSION__OWNED_ELEMENT = EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_EXPRESSION__OWNED_COMMENT = EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Model Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_EXPRESSION__MODEL_ELEMENT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Property</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_EXPRESSION__PROPERTY = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Property Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.SelectionImpl <em>Selection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.SelectionImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getSelection()
   * @generated
   */
  int SELECTION = 40;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION__OWNED_ELEMENT = EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION__OWNED_COMMENT = EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Receiver</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION__RECEIVER = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION__REF = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION__ARGS = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Selection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELECTION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.RangeImpl <em>Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.RangeImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getRange()
   * @generated
   */
  int RANGE = 41;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__OWNED_ELEMENT = EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__OWNED_COMMENT = EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Minimum</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__MINIMUM = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Maximum</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__MAXIMUM = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Delta</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE__DELTA = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Range</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.ConditionalImpl <em>Conditional</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.ConditionalImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getConditional()
   * @generated
   */
  int CONDITIONAL = 42;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL__OWNED_ELEMENT = EXPRESSION__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL__OWNED_COMMENT = EXPRESSION__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>If</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL__IF = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL__THEN = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL__ELSE = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Conditional</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.EBooleanLiteralImpl <em>EBoolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.EBooleanLiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getEBooleanLiteral()
   * @generated
   */
  int EBOOLEAN_LITERAL = 43;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOLEAN_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOLEAN_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOLEAN_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>EBoolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EBOOLEAN_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.EIntegerLiteralImpl <em>EInteger Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.EIntegerLiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getEIntegerLiteral()
   * @generated
   */
  int EINTEGER_LITERAL = 44;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EINTEGER_LITERAL__OWNED_ELEMENT = NUMBER_LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EINTEGER_LITERAL__OWNED_COMMENT = NUMBER_LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EINTEGER_LITERAL__VALUE = NUMBER_LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>EInteger Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EINTEGER_LITERAL_FEATURE_COUNT = NUMBER_LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.ERealLiteralImpl <em>EReal Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.ERealLiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getERealLiteral()
   * @generated
   */
  int EREAL_LITERAL = 45;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EREAL_LITERAL__OWNED_ELEMENT = NUMBER_LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EREAL_LITERAL__OWNED_COMMENT = NUMBER_LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EREAL_LITERAL__VALUE = NUMBER_LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>EReal Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EREAL_LITERAL_FEATURE_COUNT = NUMBER_LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.EStringLiteralImpl <em>EString Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.EStringLiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getEStringLiteral()
   * @generated
   */
  int ESTRING_LITERAL = 46;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESTRING_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESTRING_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESTRING_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>EString Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESTRING_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.ListLiteralImpl <em>List Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.ListLiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getListLiteral()
   * @generated
   */
  int LIST_LITERAL = 47;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_LITERAL__ELEMENTS = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>List Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LIST_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.SetLiteralImpl <em>Set Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.SetLiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getSetLiteral()
   * @generated
   */
  int SET_LITERAL = 48;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_LITERAL__ELEMENTS = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Set Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.RecordLiteralImpl <em>Record Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.RecordLiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getRecordLiteral()
   * @generated
   */
  int RECORD_LITERAL = 49;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Field Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_LITERAL__FIELD_VALUES = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Record Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.UnionLiteralImpl <em>Union Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.UnionLiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getUnionLiteral()
   * @generated
   */
  int UNION_LITERAL = 50;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Field Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_LITERAL__FIELD_VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Union Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNION_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.TupleLiteralImpl <em>Tuple Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.TupleLiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getTupleLiteral()
   * @generated
   */
  int TUPLE_LITERAL = 51;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL__ELEMENTS = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tuple Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.BagLiteralImpl <em>Bag Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.BagLiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getBagLiteral()
   * @generated
   */
  int BAG_LITERAL = 52;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAG_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAG_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAG_LITERAL__ELEMENTS = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bag Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BAG_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.impl.MapLiteralImpl <em>Map Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.impl.MapLiteralImpl
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getMapLiteral()
   * @generated
   */
  int MAP_LITERAL = 53;

  /**
   * The feature id for the '<em><b>Owned Element</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_LITERAL__OWNED_ELEMENT = LITERAL__OWNED_ELEMENT;

  /**
   * The feature id for the '<em><b>Owned Comment</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_LITERAL__OWNED_COMMENT = LITERAL__OWNED_COMMENT;

  /**
   * The number of structural features of the '<em>Map Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MAP_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.MetaClassEnum <em>Meta Class Enum</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.MetaClassEnum
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getMetaClassEnum()
   * @generated
   */
  int META_CLASS_ENUM = 54;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.TargetType <em>Target Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.TargetType
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getTargetType()
   * @generated
   */
  int TARGET_TYPE = 55;

  /**
   * The meta object id for the '{@link org.osate.expr.expr.Operation <em>Operation</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.osate.expr.expr.Operation
   * @see org.osate.expr.expr.impl.ExprPackageImpl#getOperation()
   * @generated
   */
  int OPERATION = 56;


  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.ExprModel <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.osate.expr.expr.ExprModel
   * @generated
   */
  EClass getExprModel();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.ExprModel#getAnnex <em>Annex</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Annex</em>'.
   * @see org.osate.expr.expr.ExprModel#getAnnex()
   * @see #getExprModel()
   * @generated
   */
  EReference getExprModel_Annex();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.EDeclaration <em>EDeclaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EDeclaration</em>'.
   * @see org.osate.expr.expr.EDeclaration
   * @generated
   */
  EClass getEDeclaration();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.TypeDecl <em>Type Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Decl</em>'.
   * @see org.osate.expr.expr.TypeDecl
   * @generated
   */
  EClass getTypeDecl();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.TypeDecl#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.osate.expr.expr.TypeDecl#getType()
   * @see #getTypeDecl()
   * @generated
   */
  EReference getTypeDecl_Type();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.TypeDecl#getOwnedPropertyAssociations <em>Owned Property Associations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Property Associations</em>'.
   * @see org.osate.expr.expr.TypeDecl#getOwnedPropertyAssociations()
   * @see #getTypeDecl()
   * @generated
   */
  EReference getTypeDecl_OwnedPropertyAssociations();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.VarDecl <em>Var Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Var Decl</em>'.
   * @see org.osate.expr.expr.VarDecl
   * @generated
   */
  EClass getVarDecl();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.VarDecl#isConst <em>Const</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Const</em>'.
   * @see org.osate.expr.expr.VarDecl#isConst()
   * @see #getVarDecl()
   * @generated
   */
  EAttribute getVarDecl_Const();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.VarDecl#getDeclType <em>Decl Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Decl Type</em>'.
   * @see org.osate.expr.expr.VarDecl#getDeclType()
   * @see #getVarDecl()
   * @generated
   */
  EReference getVarDecl_DeclType();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.VarDecl#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.expr.expr.VarDecl#getValue()
   * @see #getVarDecl()
   * @generated
   */
  EReference getVarDecl_Value();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.FunDecl <em>Fun Decl</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fun Decl</em>'.
   * @see org.osate.expr.expr.FunDecl
   * @generated
   */
  EClass getFunDecl();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.FunDecl#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.osate.expr.expr.FunDecl#getArgs()
   * @see #getFunDecl()
   * @generated
   */
  EReference getFunDecl_Args();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.FunDecl#getResultType <em>Result Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result Type</em>'.
   * @see org.osate.expr.expr.FunDecl#getResultType()
   * @see #getFunDecl()
   * @generated
   */
  EReference getFunDecl_ResultType();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.FunDecl#isJava <em>Java</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Java</em>'.
   * @see org.osate.expr.expr.FunDecl#isJava()
   * @see #getFunDecl()
   * @generated
   */
  EAttribute getFunDecl_Java();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.FunDecl#getFqn <em>Fqn</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fqn</em>'.
   * @see org.osate.expr.expr.FunDecl#getFqn()
   * @see #getFunDecl()
   * @generated
   */
  EAttribute getFunDecl_Fqn();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.FunDecl#getExp <em>Exp</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exp</em>'.
   * @see org.osate.expr.expr.FunDecl#getExp()
   * @see #getFunDecl()
   * @generated
   */
  EReference getFunDecl_Exp();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.Argument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Argument</em>'.
   * @see org.osate.expr.expr.Argument
   * @generated
   */
  EClass getArgument();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.Argument#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.osate.expr.expr.Argument#getType()
   * @see #getArgument()
   * @generated
   */
  EReference getArgument_Type();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.Assertion <em>Assertion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assertion</em>'.
   * @see org.osate.expr.expr.Assertion
   * @generated
   */
  EClass getAssertion();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.Assertion#getAssert <em>Assert</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Assert</em>'.
   * @see org.osate.expr.expr.Assertion#getAssert()
   * @see #getAssertion()
   * @generated
   */
  EReference getAssertion_Assert();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.ENumberType <em>ENumber Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ENumber Type</em>'.
   * @see org.osate.expr.expr.ENumberType
   * @generated
   */
  EClass getENumberType();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.EInteger <em>EInteger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EInteger</em>'.
   * @see org.osate.expr.expr.EInteger
   * @generated
   */
  EClass getEInteger();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.EReal <em>EReal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EReal</em>'.
   * @see org.osate.expr.expr.EReal
   * @generated
   */
  EClass getEReal();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.RangeType <em>Range Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range Type</em>'.
   * @see org.osate.expr.expr.RangeType
   * @generated
   */
  EClass getRangeType();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.RangeType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.osate.expr.expr.RangeType#getType()
   * @see #getRangeType()
   * @generated
   */
  EReference getRangeType_Type();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.Category <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Category</em>'.
   * @see org.osate.expr.expr.Category
   * @generated
   */
  EClass getCategory();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.Category#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Category</em>'.
   * @see org.osate.expr.expr.Category#getCategory()
   * @see #getCategory()
   * @generated
   */
  EAttribute getCategory_Category();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.MetaClass <em>Meta Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Meta Class</em>'.
   * @see org.osate.expr.expr.MetaClass
   * @generated
   */
  EClass getMetaClass();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.MetaClass#getClass_ <em>Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Class</em>'.
   * @see org.osate.expr.expr.MetaClass#getClass_()
   * @see #getMetaClass()
   * @generated
   */
  EAttribute getMetaClass_Class();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.RecordType <em>Record Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Type</em>'.
   * @see org.osate.expr.expr.RecordType
   * @generated
   */
  EClass getRecordType();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.RecordType#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.osate.expr.expr.RecordType#getFields()
   * @see #getRecordType()
   * @generated
   */
  EReference getRecordType_Fields();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.Field <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field</em>'.
   * @see org.osate.expr.expr.Field
   * @generated
   */
  EClass getField();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.Field#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.osate.expr.expr.Field#getType()
   * @see #getField()
   * @generated
   */
  EReference getField_Type();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.UnionType <em>Union Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Union Type</em>'.
   * @see org.osate.expr.expr.UnionType
   * @generated
   */
  EClass getUnionType();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.UnionType#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.osate.expr.expr.UnionType#getFields()
   * @see #getUnionType()
   * @generated
   */
  EReference getUnionType_Fields();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.TupleType <em>Tuple Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Type</em>'.
   * @see org.osate.expr.expr.TupleType
   * @generated
   */
  EClass getTupleType();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.TupleType#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.osate.expr.expr.TupleType#getFields()
   * @see #getTupleType()
   * @generated
   */
  EReference getTupleType_Fields();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.ListType <em>List Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Type</em>'.
   * @see org.osate.expr.expr.ListType
   * @generated
   */
  EClass getListType();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.ListType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.osate.expr.expr.ListType#getType()
   * @see #getListType()
   * @generated
   */
  EReference getListType_Type();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.SetType <em>Set Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Set Type</em>'.
   * @see org.osate.expr.expr.SetType
   * @generated
   */
  EClass getSetType();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.SetType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.osate.expr.expr.SetType#getType()
   * @see #getSetType()
   * @generated
   */
  EReference getSetType_Type();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.BagType <em>Bag Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bag Type</em>'.
   * @see org.osate.expr.expr.BagType
   * @generated
   */
  EClass getBagType();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.BagType#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.osate.expr.expr.BagType#getType()
   * @see #getBagType()
   * @generated
   */
  EReference getBagType_Type();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.MapType <em>Map Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Map Type</em>'.
   * @see org.osate.expr.expr.MapType
   * @generated
   */
  EClass getMapType();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.MapType#getDomain <em>Domain</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Domain</em>'.
   * @see org.osate.expr.expr.MapType#getDomain()
   * @see #getMapType()
   * @generated
   */
  EReference getMapType_Domain();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.MapType#getImage <em>Image</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Image</em>'.
   * @see org.osate.expr.expr.MapType#getImage()
   * @see #getMapType()
   * @generated
   */
  EReference getMapType_Image();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.EnumType <em>Enum Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Type</em>'.
   * @see org.osate.expr.expr.EnumType
   * @generated
   */
  EClass getEnumType();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.EnumType#getLiterals <em>Literals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Literals</em>'.
   * @see org.osate.expr.expr.EnumType#getLiterals()
   * @see #getEnumType()
   * @generated
   */
  EReference getEnumType_Literals();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.EnumLiteral <em>Enum Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Literal</em>'.
   * @see org.osate.expr.expr.EnumLiteral
   * @generated
   */
  EClass getEnumLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.EnumLiteral#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.expr.expr.EnumLiteral#getName()
   * @see #getEnumLiteral()
   * @generated
   */
  EAttribute getEnumLiteral_Name();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.TypeRef <em>Type Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Ref</em>'.
   * @see org.osate.expr.expr.TypeRef
   * @generated
   */
  EClass getTypeRef();

  /**
   * Returns the meta object for the reference '{@link org.osate.expr.expr.TypeRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.osate.expr.expr.TypeRef#getRef()
   * @see #getTypeRef()
   * @generated
   */
  EReference getTypeRef_Ref();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.osate.expr.expr.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.NamedElementRef <em>Named Element Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Element Ref</em>'.
   * @see org.osate.expr.expr.NamedElementRef
   * @generated
   */
  EClass getNamedElementRef();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.NamedElementRef#isCore <em>Core</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Core</em>'.
   * @see org.osate.expr.expr.NamedElementRef#isCore()
   * @see #getNamedElementRef()
   * @generated
   */
  EAttribute getNamedElementRef_Core();

  /**
   * Returns the meta object for the reference '{@link org.osate.expr.expr.NamedElementRef#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.osate.expr.expr.NamedElementRef#getRef()
   * @see #getNamedElementRef()
   * @generated
   */
  EReference getNamedElementRef_Ref();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.NamedElementRef#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.osate.expr.expr.NamedElementRef#getArgs()
   * @see #getNamedElementRef()
   * @generated
   */
  EReference getNamedElementRef_Args();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see org.osate.expr.expr.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see org.osate.expr.expr.Value
   * @generated
   */
  EClass getValue();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.WrappedNamedElement <em>Wrapped Named Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Wrapped Named Element</em>'.
   * @see org.osate.expr.expr.WrappedNamedElement
   * @generated
   */
  EClass getWrappedNamedElement();

  /**
   * Returns the meta object for the reference '{@link org.osate.expr.expr.WrappedNamedElement#getElem <em>Elem</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Elem</em>'.
   * @see org.osate.expr.expr.WrappedNamedElement#getElem()
   * @see #getWrappedNamedElement()
   * @generated
   */
  EReference getWrappedNamedElement_Elem();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.NumberLiteral <em>Number Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Literal</em>'.
   * @see org.osate.expr.expr.NumberLiteral
   * @generated
   */
  EClass getNumberLiteral();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.FieldValue <em>Field Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field Value</em>'.
   * @see org.osate.expr.expr.FieldValue
   * @generated
   */
  EClass getFieldValue();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.FieldValue#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.osate.expr.expr.FieldValue#getName()
   * @see #getFieldValue()
   * @generated
   */
  EAttribute getFieldValue_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.FieldValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.osate.expr.expr.FieldValue#getValue()
   * @see #getFieldValue()
   * @generated
   */
  EReference getFieldValue_Value();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.ExprLibrary <em>Library</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Library</em>'.
   * @see org.osate.expr.expr.ExprLibrary
   * @generated
   */
  EClass getExprLibrary();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.ExprLibrary#getDecls <em>Decls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Decls</em>'.
   * @see org.osate.expr.expr.ExprLibrary#getDecls()
   * @see #getExprLibrary()
   * @generated
   */
  EReference getExprLibrary_Decls();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.ExprSubclause <em>Subclause</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subclause</em>'.
   * @see org.osate.expr.expr.ExprSubclause
   * @generated
   */
  EClass getExprSubclause();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.ExprSubclause#getDecls <em>Decls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Decls</em>'.
   * @see org.osate.expr.expr.ExprSubclause#getDecls()
   * @see #getExprSubclause()
   * @generated
   */
  EReference getExprSubclause_Decls();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.EBoolean <em>EBoolean</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EBoolean</em>'.
   * @see org.osate.expr.expr.EBoolean
   * @generated
   */
  EClass getEBoolean();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.EString <em>EString</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EString</em>'.
   * @see org.osate.expr.expr.EString
   * @generated
   */
  EClass getEString();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block</em>'.
   * @see org.osate.expr.expr.Block
   * @generated
   */
  EClass getBlock();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.Block#getDecls <em>Decls</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Decls</em>'.
   * @see org.osate.expr.expr.Block#getDecls()
   * @see #getBlock()
   * @generated
   */
  EReference getBlock_Decls();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.Block#getResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result</em>'.
   * @see org.osate.expr.expr.Block#getResult()
   * @see #getBlock()
   * @generated
   */
  EReference getBlock_Result();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.BinaryOperation <em>Binary Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Operation</em>'.
   * @see org.osate.expr.expr.BinaryOperation
   * @generated
   */
  EClass getBinaryOperation();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.BinaryOperation#getLeft <em>Left</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left</em>'.
   * @see org.osate.expr.expr.BinaryOperation#getLeft()
   * @see #getBinaryOperation()
   * @generated
   */
  EReference getBinaryOperation_Left();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.BinaryOperation#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.osate.expr.expr.BinaryOperation#getOperator()
   * @see #getBinaryOperation()
   * @generated
   */
  EAttribute getBinaryOperation_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.BinaryOperation#getRight <em>Right</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right</em>'.
   * @see org.osate.expr.expr.BinaryOperation#getRight()
   * @see #getBinaryOperation()
   * @generated
   */
  EReference getBinaryOperation_Right();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.UnaryOperation <em>Unary Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Operation</em>'.
   * @see org.osate.expr.expr.UnaryOperation
   * @generated
   */
  EClass getUnaryOperation();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.UnaryOperation#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.osate.expr.expr.UnaryOperation#getOperator()
   * @see #getUnaryOperation()
   * @generated
   */
  EAttribute getUnaryOperation_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.UnaryOperation#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.osate.expr.expr.UnaryOperation#getOperand()
   * @see #getUnaryOperation()
   * @generated
   */
  EReference getUnaryOperation_Operand();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.UnitExpression <em>Unit Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Expression</em>'.
   * @see org.osate.expr.expr.UnitExpression
   * @generated
   */
  EClass getUnitExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.UnitExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.osate.expr.expr.UnitExpression#getExpression()
   * @see #getUnitExpression()
   * @generated
   */
  EReference getUnitExpression_Expression();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.UnitExpression#isConvert <em>Convert</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Convert</em>'.
   * @see org.osate.expr.expr.UnitExpression#isConvert()
   * @see #getUnitExpression()
   * @generated
   */
  EAttribute getUnitExpression_Convert();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.UnitExpression#isDrop <em>Drop</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Drop</em>'.
   * @see org.osate.expr.expr.UnitExpression#isDrop()
   * @see #getUnitExpression()
   * @generated
   */
  EAttribute getUnitExpression_Drop();

  /**
   * Returns the meta object for the reference '{@link org.osate.expr.expr.UnitExpression#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Unit</em>'.
   * @see org.osate.expr.expr.UnitExpression#getUnit()
   * @see #getUnitExpression()
   * @generated
   */
  EReference getUnitExpression_Unit();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.PropertyExpression <em>Property Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Expression</em>'.
   * @see org.osate.expr.expr.PropertyExpression
   * @generated
   */
  EClass getPropertyExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.PropertyExpression#getModelElement <em>Model Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Model Element</em>'.
   * @see org.osate.expr.expr.PropertyExpression#getModelElement()
   * @see #getPropertyExpression()
   * @generated
   */
  EReference getPropertyExpression_ModelElement();

  /**
   * Returns the meta object for the reference '{@link org.osate.expr.expr.PropertyExpression#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Property</em>'.
   * @see org.osate.expr.expr.PropertyExpression#getProperty()
   * @see #getPropertyExpression()
   * @generated
   */
  EReference getPropertyExpression_Property();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.Selection <em>Selection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Selection</em>'.
   * @see org.osate.expr.expr.Selection
   * @generated
   */
  EClass getSelection();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.Selection#getReceiver <em>Receiver</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Receiver</em>'.
   * @see org.osate.expr.expr.Selection#getReceiver()
   * @see #getSelection()
   * @generated
   */
  EReference getSelection_Receiver();

  /**
   * Returns the meta object for the reference '{@link org.osate.expr.expr.Selection#getRef <em>Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Ref</em>'.
   * @see org.osate.expr.expr.Selection#getRef()
   * @see #getSelection()
   * @generated
   */
  EReference getSelection_Ref();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.Selection#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.osate.expr.expr.Selection#getArgs()
   * @see #getSelection()
   * @generated
   */
  EReference getSelection_Args();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.Range <em>Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range</em>'.
   * @see org.osate.expr.expr.Range
   * @generated
   */
  EClass getRange();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.Range#getMinimum <em>Minimum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Minimum</em>'.
   * @see org.osate.expr.expr.Range#getMinimum()
   * @see #getRange()
   * @generated
   */
  EReference getRange_Minimum();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.Range#getMaximum <em>Maximum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Maximum</em>'.
   * @see org.osate.expr.expr.Range#getMaximum()
   * @see #getRange()
   * @generated
   */
  EReference getRange_Maximum();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.Range#getDelta <em>Delta</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Delta</em>'.
   * @see org.osate.expr.expr.Range#getDelta()
   * @see #getRange()
   * @generated
   */
  EReference getRange_Delta();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.Conditional <em>Conditional</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional</em>'.
   * @see org.osate.expr.expr.Conditional
   * @generated
   */
  EClass getConditional();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.Conditional#getIf <em>If</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>If</em>'.
   * @see org.osate.expr.expr.Conditional#getIf()
   * @see #getConditional()
   * @generated
   */
  EReference getConditional_If();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.Conditional#getThen <em>Then</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then</em>'.
   * @see org.osate.expr.expr.Conditional#getThen()
   * @see #getConditional()
   * @generated
   */
  EReference getConditional_Then();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.Conditional#getElse <em>Else</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else</em>'.
   * @see org.osate.expr.expr.Conditional#getElse()
   * @see #getConditional()
   * @generated
   */
  EReference getConditional_Else();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.EBooleanLiteral <em>EBoolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EBoolean Literal</em>'.
   * @see org.osate.expr.expr.EBooleanLiteral
   * @generated
   */
  EClass getEBooleanLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.EBooleanLiteral#isValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.expr.expr.EBooleanLiteral#isValue()
   * @see #getEBooleanLiteral()
   * @generated
   */
  EAttribute getEBooleanLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.EIntegerLiteral <em>EInteger Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EInteger Literal</em>'.
   * @see org.osate.expr.expr.EIntegerLiteral
   * @generated
   */
  EClass getEIntegerLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.EIntegerLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.expr.expr.EIntegerLiteral#getValue()
   * @see #getEIntegerLiteral()
   * @generated
   */
  EAttribute getEIntegerLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.ERealLiteral <em>EReal Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EReal Literal</em>'.
   * @see org.osate.expr.expr.ERealLiteral
   * @generated
   */
  EClass getERealLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.ERealLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.expr.expr.ERealLiteral#getValue()
   * @see #getERealLiteral()
   * @generated
   */
  EAttribute getERealLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.EStringLiteral <em>EString Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>EString Literal</em>'.
   * @see org.osate.expr.expr.EStringLiteral
   * @generated
   */
  EClass getEStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.osate.expr.expr.EStringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.osate.expr.expr.EStringLiteral#getValue()
   * @see #getEStringLiteral()
   * @generated
   */
  EAttribute getEStringLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.ListLiteral <em>List Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>List Literal</em>'.
   * @see org.osate.expr.expr.ListLiteral
   * @generated
   */
  EClass getListLiteral();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.ListLiteral#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.osate.expr.expr.ListLiteral#getElements()
   * @see #getListLiteral()
   * @generated
   */
  EReference getListLiteral_Elements();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.SetLiteral <em>Set Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Set Literal</em>'.
   * @see org.osate.expr.expr.SetLiteral
   * @generated
   */
  EClass getSetLiteral();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.SetLiteral#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.osate.expr.expr.SetLiteral#getElements()
   * @see #getSetLiteral()
   * @generated
   */
  EReference getSetLiteral_Elements();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.RecordLiteral <em>Record Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Literal</em>'.
   * @see org.osate.expr.expr.RecordLiteral
   * @generated
   */
  EClass getRecordLiteral();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.RecordLiteral#getFieldValues <em>Field Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Field Values</em>'.
   * @see org.osate.expr.expr.RecordLiteral#getFieldValues()
   * @see #getRecordLiteral()
   * @generated
   */
  EReference getRecordLiteral_FieldValues();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.UnionLiteral <em>Union Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Union Literal</em>'.
   * @see org.osate.expr.expr.UnionLiteral
   * @generated
   */
  EClass getUnionLiteral();

  /**
   * Returns the meta object for the containment reference '{@link org.osate.expr.expr.UnionLiteral#getFieldValue <em>Field Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Field Value</em>'.
   * @see org.osate.expr.expr.UnionLiteral#getFieldValue()
   * @see #getUnionLiteral()
   * @generated
   */
  EReference getUnionLiteral_FieldValue();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.TupleLiteral <em>Tuple Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Literal</em>'.
   * @see org.osate.expr.expr.TupleLiteral
   * @generated
   */
  EClass getTupleLiteral();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.TupleLiteral#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.osate.expr.expr.TupleLiteral#getElements()
   * @see #getTupleLiteral()
   * @generated
   */
  EReference getTupleLiteral_Elements();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.BagLiteral <em>Bag Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bag Literal</em>'.
   * @see org.osate.expr.expr.BagLiteral
   * @generated
   */
  EClass getBagLiteral();

  /**
   * Returns the meta object for the containment reference list '{@link org.osate.expr.expr.BagLiteral#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.osate.expr.expr.BagLiteral#getElements()
   * @see #getBagLiteral()
   * @generated
   */
  EReference getBagLiteral_Elements();

  /**
   * Returns the meta object for class '{@link org.osate.expr.expr.MapLiteral <em>Map Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Map Literal</em>'.
   * @see org.osate.expr.expr.MapLiteral
   * @generated
   */
  EClass getMapLiteral();

  /**
   * Returns the meta object for enum '{@link org.osate.expr.expr.MetaClassEnum <em>Meta Class Enum</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Meta Class Enum</em>'.
   * @see org.osate.expr.expr.MetaClassEnum
   * @generated
   */
  EEnum getMetaClassEnum();

  /**
   * Returns the meta object for enum '{@link org.osate.expr.expr.TargetType <em>Target Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Target Type</em>'.
   * @see org.osate.expr.expr.TargetType
   * @generated
   */
  EEnum getTargetType();

  /**
   * Returns the meta object for enum '{@link org.osate.expr.expr.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Operation</em>'.
   * @see org.osate.expr.expr.Operation
   * @generated
   */
  EEnum getOperation();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ExprFactory getExprFactory();

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
     * The meta object literal for the '{@link org.osate.expr.expr.impl.ExprModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.ExprModelImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getExprModel()
     * @generated
     */
    EClass EXPR_MODEL = eINSTANCE.getExprModel();

    /**
     * The meta object literal for the '<em><b>Annex</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_MODEL__ANNEX = eINSTANCE.getExprModel_Annex();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.EDeclarationImpl <em>EDeclaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.EDeclarationImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getEDeclaration()
     * @generated
     */
    EClass EDECLARATION = eINSTANCE.getEDeclaration();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.TypeDeclImpl <em>Type Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.TypeDeclImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getTypeDecl()
     * @generated
     */
    EClass TYPE_DECL = eINSTANCE.getTypeDecl();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DECL__TYPE = eINSTANCE.getTypeDecl_Type();

    /**
     * The meta object literal for the '<em><b>Owned Property Associations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DECL__OWNED_PROPERTY_ASSOCIATIONS = eINSTANCE.getTypeDecl_OwnedPropertyAssociations();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.VarDeclImpl <em>Var Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.VarDeclImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getVarDecl()
     * @generated
     */
    EClass VAR_DECL = eINSTANCE.getVarDecl();

    /**
     * The meta object literal for the '<em><b>Const</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VAR_DECL__CONST = eINSTANCE.getVarDecl_Const();

    /**
     * The meta object literal for the '<em><b>Decl Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_DECL__DECL_TYPE = eINSTANCE.getVarDecl_DeclType();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VAR_DECL__VALUE = eINSTANCE.getVarDecl_Value();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.FunDeclImpl <em>Fun Decl</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.FunDeclImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getFunDecl()
     * @generated
     */
    EClass FUN_DECL = eINSTANCE.getFunDecl();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_DECL__ARGS = eINSTANCE.getFunDecl_Args();

    /**
     * The meta object literal for the '<em><b>Result Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_DECL__RESULT_TYPE = eINSTANCE.getFunDecl_ResultType();

    /**
     * The meta object literal for the '<em><b>Java</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUN_DECL__JAVA = eINSTANCE.getFunDecl_Java();

    /**
     * The meta object literal for the '<em><b>Fqn</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUN_DECL__FQN = eINSTANCE.getFunDecl_Fqn();

    /**
     * The meta object literal for the '<em><b>Exp</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUN_DECL__EXP = eINSTANCE.getFunDecl_Exp();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.ArgumentImpl <em>Argument</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.ArgumentImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getArgument()
     * @generated
     */
    EClass ARGUMENT = eINSTANCE.getArgument();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARGUMENT__TYPE = eINSTANCE.getArgument_Type();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.AssertionImpl <em>Assertion</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.AssertionImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getAssertion()
     * @generated
     */
    EClass ASSERTION = eINSTANCE.getAssertion();

    /**
     * The meta object literal for the '<em><b>Assert</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSERTION__ASSERT = eINSTANCE.getAssertion_Assert();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.ENumberTypeImpl <em>ENumber Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.ENumberTypeImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getENumberType()
     * @generated
     */
    EClass ENUMBER_TYPE = eINSTANCE.getENumberType();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.EIntegerImpl <em>EInteger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.EIntegerImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getEInteger()
     * @generated
     */
    EClass EINTEGER = eINSTANCE.getEInteger();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.ERealImpl <em>EReal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.ERealImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getEReal()
     * @generated
     */
    EClass EREAL = eINSTANCE.getEReal();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.RangeTypeImpl <em>Range Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.RangeTypeImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getRangeType()
     * @generated
     */
    EClass RANGE_TYPE = eINSTANCE.getRangeType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANGE_TYPE__TYPE = eINSTANCE.getRangeType_Type();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.CategoryImpl <em>Category</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.CategoryImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getCategory()
     * @generated
     */
    EClass CATEGORY = eINSTANCE.getCategory();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CATEGORY__CATEGORY = eINSTANCE.getCategory_Category();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.MetaClassImpl <em>Meta Class</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.MetaClassImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getMetaClass()
     * @generated
     */
    EClass META_CLASS = eINSTANCE.getMetaClass();

    /**
     * The meta object literal for the '<em><b>Class</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute META_CLASS__CLASS = eINSTANCE.getMetaClass_Class();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.RecordTypeImpl <em>Record Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.RecordTypeImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getRecordType()
     * @generated
     */
    EClass RECORD_TYPE = eINSTANCE.getRecordType();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_TYPE__FIELDS = eINSTANCE.getRecordType_Fields();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.FieldImpl <em>Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.FieldImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getField()
     * @generated
     */
    EClass FIELD = eINSTANCE.getField();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD__TYPE = eINSTANCE.getField_Type();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.UnionTypeImpl <em>Union Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.UnionTypeImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getUnionType()
     * @generated
     */
    EClass UNION_TYPE = eINSTANCE.getUnionType();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNION_TYPE__FIELDS = eINSTANCE.getUnionType_Fields();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.TupleTypeImpl <em>Tuple Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.TupleTypeImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getTupleType()
     * @generated
     */
    EClass TUPLE_TYPE = eINSTANCE.getTupleType();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_TYPE__FIELDS = eINSTANCE.getTupleType_Fields();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.ListTypeImpl <em>List Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.ListTypeImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getListType()
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
     * The meta object literal for the '{@link org.osate.expr.expr.impl.SetTypeImpl <em>Set Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.SetTypeImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getSetType()
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
     * The meta object literal for the '{@link org.osate.expr.expr.impl.BagTypeImpl <em>Bag Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.BagTypeImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getBagType()
     * @generated
     */
    EClass BAG_TYPE = eINSTANCE.getBagType();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BAG_TYPE__TYPE = eINSTANCE.getBagType_Type();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.MapTypeImpl <em>Map Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.MapTypeImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getMapType()
     * @generated
     */
    EClass MAP_TYPE = eINSTANCE.getMapType();

    /**
     * The meta object literal for the '<em><b>Domain</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAP_TYPE__DOMAIN = eINSTANCE.getMapType_Domain();

    /**
     * The meta object literal for the '<em><b>Image</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MAP_TYPE__IMAGE = eINSTANCE.getMapType_Image();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.EnumTypeImpl <em>Enum Type</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.EnumTypeImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getEnumType()
     * @generated
     */
    EClass ENUM_TYPE = eINSTANCE.getEnumType();

    /**
     * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_TYPE__LITERALS = eINSTANCE.getEnumType_Literals();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.EnumLiteralImpl <em>Enum Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.EnumLiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getEnumLiteral()
     * @generated
     */
    EClass ENUM_LITERAL = eINSTANCE.getEnumLiteral();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUM_LITERAL__NAME = eINSTANCE.getEnumLiteral_Name();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.TypeRefImpl <em>Type Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.TypeRefImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getTypeRef()
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
     * The meta object literal for the '{@link org.osate.expr.expr.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.ExpressionImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.NamedElementRefImpl <em>Named Element Ref</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.NamedElementRefImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getNamedElementRef()
     * @generated
     */
    EClass NAMED_ELEMENT_REF = eINSTANCE.getNamedElementRef();

    /**
     * The meta object literal for the '<em><b>Core</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_ELEMENT_REF__CORE = eINSTANCE.getNamedElementRef_Core();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_ELEMENT_REF__REF = eINSTANCE.getNamedElementRef_Ref();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_ELEMENT_REF__ARGS = eINSTANCE.getNamedElementRef_Args();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.LiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.ValueImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getValue()
     * @generated
     */
    EClass VALUE = eINSTANCE.getValue();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.WrappedNamedElementImpl <em>Wrapped Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.WrappedNamedElementImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getWrappedNamedElement()
     * @generated
     */
    EClass WRAPPED_NAMED_ELEMENT = eINSTANCE.getWrappedNamedElement();

    /**
     * The meta object literal for the '<em><b>Elem</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WRAPPED_NAMED_ELEMENT__ELEM = eINSTANCE.getWrappedNamedElement_Elem();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.NumberLiteralImpl <em>Number Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.NumberLiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getNumberLiteral()
     * @generated
     */
    EClass NUMBER_LITERAL = eINSTANCE.getNumberLiteral();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.FieldValueImpl <em>Field Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.FieldValueImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getFieldValue()
     * @generated
     */
    EClass FIELD_VALUE = eINSTANCE.getFieldValue();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FIELD_VALUE__NAME = eINSTANCE.getFieldValue_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD_VALUE__VALUE = eINSTANCE.getFieldValue_Value();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.ExprLibraryImpl <em>Library</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.ExprLibraryImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getExprLibrary()
     * @generated
     */
    EClass EXPR_LIBRARY = eINSTANCE.getExprLibrary();

    /**
     * The meta object literal for the '<em><b>Decls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_LIBRARY__DECLS = eINSTANCE.getExprLibrary_Decls();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.ExprSubclauseImpl <em>Subclause</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.ExprSubclauseImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getExprSubclause()
     * @generated
     */
    EClass EXPR_SUBCLAUSE = eINSTANCE.getExprSubclause();

    /**
     * The meta object literal for the '<em><b>Decls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPR_SUBCLAUSE__DECLS = eINSTANCE.getExprSubclause_Decls();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.EBooleanImpl <em>EBoolean</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.EBooleanImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getEBoolean()
     * @generated
     */
    EClass EBOOLEAN = eINSTANCE.getEBoolean();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.EStringImpl <em>EString</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.EStringImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getEString()
     * @generated
     */
    EClass ESTRING = eINSTANCE.getEString();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.BlockImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getBlock()
     * @generated
     */
    EClass BLOCK = eINSTANCE.getBlock();

    /**
     * The meta object literal for the '<em><b>Decls</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK__DECLS = eINSTANCE.getBlock_Decls();

    /**
     * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK__RESULT = eINSTANCE.getBlock_Result();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.BinaryOperationImpl <em>Binary Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.BinaryOperationImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getBinaryOperation()
     * @generated
     */
    EClass BINARY_OPERATION = eINSTANCE.getBinaryOperation();

    /**
     * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_OPERATION__LEFT = eINSTANCE.getBinaryOperation_Left();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BINARY_OPERATION__OPERATOR = eINSTANCE.getBinaryOperation_Operator();

    /**
     * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BINARY_OPERATION__RIGHT = eINSTANCE.getBinaryOperation_Right();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.UnaryOperationImpl <em>Unary Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.UnaryOperationImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getUnaryOperation()
     * @generated
     */
    EClass UNARY_OPERATION = eINSTANCE.getUnaryOperation();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNARY_OPERATION__OPERATOR = eINSTANCE.getUnaryOperation_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_OPERATION__OPERAND = eINSTANCE.getUnaryOperation_Operand();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.UnitExpressionImpl <em>Unit Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.UnitExpressionImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getUnitExpression()
     * @generated
     */
    EClass UNIT_EXPRESSION = eINSTANCE.getUnitExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNIT_EXPRESSION__EXPRESSION = eINSTANCE.getUnitExpression_Expression();

    /**
     * The meta object literal for the '<em><b>Convert</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNIT_EXPRESSION__CONVERT = eINSTANCE.getUnitExpression_Convert();

    /**
     * The meta object literal for the '<em><b>Drop</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNIT_EXPRESSION__DROP = eINSTANCE.getUnitExpression_Drop();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNIT_EXPRESSION__UNIT = eINSTANCE.getUnitExpression_Unit();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.PropertyExpressionImpl <em>Property Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.PropertyExpressionImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getPropertyExpression()
     * @generated
     */
    EClass PROPERTY_EXPRESSION = eINSTANCE.getPropertyExpression();

    /**
     * The meta object literal for the '<em><b>Model Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_EXPRESSION__MODEL_ELEMENT = eINSTANCE.getPropertyExpression_ModelElement();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_EXPRESSION__PROPERTY = eINSTANCE.getPropertyExpression_Property();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.SelectionImpl <em>Selection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.SelectionImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getSelection()
     * @generated
     */
    EClass SELECTION = eINSTANCE.getSelection();

    /**
     * The meta object literal for the '<em><b>Receiver</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION__RECEIVER = eINSTANCE.getSelection_Receiver();

    /**
     * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION__REF = eINSTANCE.getSelection_Ref();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SELECTION__ARGS = eINSTANCE.getSelection_Args();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.RangeImpl <em>Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.RangeImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getRange()
     * @generated
     */
    EClass RANGE = eINSTANCE.getRange();

    /**
     * The meta object literal for the '<em><b>Minimum</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANGE__MINIMUM = eINSTANCE.getRange_Minimum();

    /**
     * The meta object literal for the '<em><b>Maximum</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANGE__MAXIMUM = eINSTANCE.getRange_Maximum();

    /**
     * The meta object literal for the '<em><b>Delta</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANGE__DELTA = eINSTANCE.getRange_Delta();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.ConditionalImpl <em>Conditional</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.ConditionalImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getConditional()
     * @generated
     */
    EClass CONDITIONAL = eINSTANCE.getConditional();

    /**
     * The meta object literal for the '<em><b>If</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL__IF = eINSTANCE.getConditional_If();

    /**
     * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL__THEN = eINSTANCE.getConditional_Then();

    /**
     * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL__ELSE = eINSTANCE.getConditional_Else();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.EBooleanLiteralImpl <em>EBoolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.EBooleanLiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getEBooleanLiteral()
     * @generated
     */
    EClass EBOOLEAN_LITERAL = eINSTANCE.getEBooleanLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EBOOLEAN_LITERAL__VALUE = eINSTANCE.getEBooleanLiteral_Value();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.EIntegerLiteralImpl <em>EInteger Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.EIntegerLiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getEIntegerLiteral()
     * @generated
     */
    EClass EINTEGER_LITERAL = eINSTANCE.getEIntegerLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EINTEGER_LITERAL__VALUE = eINSTANCE.getEIntegerLiteral_Value();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.ERealLiteralImpl <em>EReal Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.ERealLiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getERealLiteral()
     * @generated
     */
    EClass EREAL_LITERAL = eINSTANCE.getERealLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EREAL_LITERAL__VALUE = eINSTANCE.getERealLiteral_Value();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.EStringLiteralImpl <em>EString Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.EStringLiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getEStringLiteral()
     * @generated
     */
    EClass ESTRING_LITERAL = eINSTANCE.getEStringLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ESTRING_LITERAL__VALUE = eINSTANCE.getEStringLiteral_Value();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.ListLiteralImpl <em>List Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.ListLiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getListLiteral()
     * @generated
     */
    EClass LIST_LITERAL = eINSTANCE.getListLiteral();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LIST_LITERAL__ELEMENTS = eINSTANCE.getListLiteral_Elements();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.SetLiteralImpl <em>Set Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.SetLiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getSetLiteral()
     * @generated
     */
    EClass SET_LITERAL = eINSTANCE.getSetLiteral();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET_LITERAL__ELEMENTS = eINSTANCE.getSetLiteral_Elements();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.RecordLiteralImpl <em>Record Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.RecordLiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getRecordLiteral()
     * @generated
     */
    EClass RECORD_LITERAL = eINSTANCE.getRecordLiteral();

    /**
     * The meta object literal for the '<em><b>Field Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_LITERAL__FIELD_VALUES = eINSTANCE.getRecordLiteral_FieldValues();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.UnionLiteralImpl <em>Union Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.UnionLiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getUnionLiteral()
     * @generated
     */
    EClass UNION_LITERAL = eINSTANCE.getUnionLiteral();

    /**
     * The meta object literal for the '<em><b>Field Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNION_LITERAL__FIELD_VALUE = eINSTANCE.getUnionLiteral_FieldValue();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.TupleLiteralImpl <em>Tuple Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.TupleLiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getTupleLiteral()
     * @generated
     */
    EClass TUPLE_LITERAL = eINSTANCE.getTupleLiteral();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_LITERAL__ELEMENTS = eINSTANCE.getTupleLiteral_Elements();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.BagLiteralImpl <em>Bag Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.BagLiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getBagLiteral()
     * @generated
     */
    EClass BAG_LITERAL = eINSTANCE.getBagLiteral();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BAG_LITERAL__ELEMENTS = eINSTANCE.getBagLiteral_Elements();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.impl.MapLiteralImpl <em>Map Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.impl.MapLiteralImpl
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getMapLiteral()
     * @generated
     */
    EClass MAP_LITERAL = eINSTANCE.getMapLiteral();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.MetaClassEnum <em>Meta Class Enum</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.MetaClassEnum
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getMetaClassEnum()
     * @generated
     */
    EEnum META_CLASS_ENUM = eINSTANCE.getMetaClassEnum();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.TargetType <em>Target Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.TargetType
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getTargetType()
     * @generated
     */
    EEnum TARGET_TYPE = eINSTANCE.getTargetType();

    /**
     * The meta object literal for the '{@link org.osate.expr.expr.Operation <em>Operation</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.osate.expr.expr.Operation
     * @see org.osate.expr.expr.impl.ExprPackageImpl#getOperation()
     * @generated
     */
    EEnum OPERATION = eINSTANCE.getOperation();

  }

} //ExprPackage
