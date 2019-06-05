/**
 */
package org.osate.expr.expr;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.osate.expr.expr.ExprPackage
 * @generated
 */
public interface ExprFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExprFactory eINSTANCE = org.osate.expr.expr.impl.ExprFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  ExprModel createExprModel();

  /**
   * Returns a new object of class '<em>EDeclaration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EDeclaration</em>'.
   * @generated
   */
  EDeclaration createEDeclaration();

  /**
   * Returns a new object of class '<em>Type Decl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Decl</em>'.
   * @generated
   */
  TypeDecl createTypeDecl();

  /**
   * Returns a new object of class '<em>Var Decl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Var Decl</em>'.
   * @generated
   */
  VarDecl createVarDecl();

  /**
   * Returns a new object of class '<em>Fun Decl</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fun Decl</em>'.
   * @generated
   */
  FunDecl createFunDecl();

  /**
   * Returns a new object of class '<em>Assertion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Assertion</em>'.
   * @generated
   */
  Assertion createAssertion();

  /**
   * Returns a new object of class '<em>ENumber Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ENumber Type</em>'.
   * @generated
   */
  ENumberType createENumberType();

  /**
   * Returns a new object of class '<em>EInteger</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EInteger</em>'.
   * @generated
   */
  EInteger createEInteger();

  /**
   * Returns a new object of class '<em>EReal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EReal</em>'.
   * @generated
   */
  EReal createEReal();

  /**
   * Returns a new object of class '<em>Range Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Range Type</em>'.
   * @generated
   */
  RangeType createRangeType();

  /**
   * Returns a new object of class '<em>Category</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Category</em>'.
   * @generated
   */
  Category createCategory();

  /**
   * Returns a new object of class '<em>Meta Class</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Meta Class</em>'.
   * @generated
   */
  MetaClass createMetaClass();

  /**
   * Returns a new object of class '<em>Record Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Type</em>'.
   * @generated
   */
  RecordType createRecordType();

  /**
   * Returns a new object of class '<em>Field</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Field</em>'.
   * @generated
   */
  Field createField();

  /**
   * Returns a new object of class '<em>Union Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Union Type</em>'.
   * @generated
   */
  UnionType createUnionType();

  /**
   * Returns a new object of class '<em>Tuple Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Type</em>'.
   * @generated
   */
  TupleType createTupleType();

  /**
   * Returns a new object of class '<em>List Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Type</em>'.
   * @generated
   */
  ListType createListType();

  /**
   * Returns a new object of class '<em>Set Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Set Type</em>'.
   * @generated
   */
  SetType createSetType();

  /**
   * Returns a new object of class '<em>Bag Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bag Type</em>'.
   * @generated
   */
  BagType createBagType();

  /**
   * Returns a new object of class '<em>Map Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Map Type</em>'.
   * @generated
   */
  MapType createMapType();

  /**
   * Returns a new object of class '<em>Enum Type</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Type</em>'.
   * @generated
   */
  EnumType createEnumType();

  /**
   * Returns a new object of class '<em>Enum Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Literal</em>'.
   * @generated
   */
  EnumLiteral createEnumLiteral();

  /**
   * Returns a new object of class '<em>Type Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Ref</em>'.
   * @generated
   */
  TypeRef createTypeRef();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Named Element Ref</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Element Ref</em>'.
   * @generated
   */
  NamedElementRef createNamedElementRef();

  /**
   * Returns a new object of class '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal</em>'.
   * @generated
   */
  Literal createLiteral();

  /**
   * Returns a new object of class '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value</em>'.
   * @generated
   */
  Value createValue();

  /**
   * Returns a new object of class '<em>Wrapped Named Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Wrapped Named Element</em>'.
   * @generated
   */
  WrappedNamedElement createWrappedNamedElement();

  /**
   * Returns a new object of class '<em>Number Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Number Literal</em>'.
   * @generated
   */
  NumberLiteral createNumberLiteral();

  /**
   * Returns a new object of class '<em>Field Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Field Value</em>'.
   * @generated
   */
  FieldValue createFieldValue();

  /**
   * Returns a new object of class '<em>Library</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Library</em>'.
   * @generated
   */
  ExprLibrary createExprLibrary();

  /**
   * Returns a new object of class '<em>Subclause</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subclause</em>'.
   * @generated
   */
  ExprSubclause createExprSubclause();

  /**
   * Returns a new object of class '<em>EBoolean</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EBoolean</em>'.
   * @generated
   */
  EBoolean createEBoolean();

  /**
   * Returns a new object of class '<em>EString</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EString</em>'.
   * @generated
   */
  EString createEString();

  /**
   * Returns a new object of class '<em>Binary Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary Operation</em>'.
   * @generated
   */
  BinaryOperation createBinaryOperation();

  /**
   * Returns a new object of class '<em>Unary Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Operation</em>'.
   * @generated
   */
  UnaryOperation createUnaryOperation();

  /**
   * Returns a new object of class '<em>Unit Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unit Expression</em>'.
   * @generated
   */
  UnitExpression createUnitExpression();

  /**
   * Returns a new object of class '<em>Property Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Expression</em>'.
   * @generated
   */
  PropertyExpression createPropertyExpression();

  /**
   * Returns a new object of class '<em>Selection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Selection</em>'.
   * @generated
   */
  Selection createSelection();

  /**
   * Returns a new object of class '<em>Range</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Range</em>'.
   * @generated
   */
  Range createRange();

  /**
   * Returns a new object of class '<em>Conditional</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional</em>'.
   * @generated
   */
  Conditional createConditional();

  /**
   * Returns a new object of class '<em>EBoolean Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EBoolean Literal</em>'.
   * @generated
   */
  EBooleanLiteral createEBooleanLiteral();

  /**
   * Returns a new object of class '<em>EInteger Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EInteger Literal</em>'.
   * @generated
   */
  EIntegerLiteral createEIntegerLiteral();

  /**
   * Returns a new object of class '<em>EReal Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EReal Literal</em>'.
   * @generated
   */
  ERealLiteral createERealLiteral();

  /**
   * Returns a new object of class '<em>EString Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>EString Literal</em>'.
   * @generated
   */
  EStringLiteral createEStringLiteral();

  /**
   * Returns a new object of class '<em>List Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>List Literal</em>'.
   * @generated
   */
  ListLiteral createListLiteral();

  /**
   * Returns a new object of class '<em>Set Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Set Literal</em>'.
   * @generated
   */
  SetLiteral createSetLiteral();

  /**
   * Returns a new object of class '<em>Record Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Record Literal</em>'.
   * @generated
   */
  RecordLiteral createRecordLiteral();

  /**
   * Returns a new object of class '<em>Union Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Union Literal</em>'.
   * @generated
   */
  UnionLiteral createUnionLiteral();

  /**
   * Returns a new object of class '<em>Tuple Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Literal</em>'.
   * @generated
   */
  TupleLiteral createTupleLiteral();

  /**
   * Returns a new object of class '<em>Bag Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Bag Literal</em>'.
   * @generated
   */
  BagLiteral createBagLiteral();

  /**
   * Returns a new object of class '<em>Map Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Map Literal</em>'.
   * @generated
   */
  MapLiteral createMapLiteral();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ExprPackage getExprPackage();

} //ExprFactory
