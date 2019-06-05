/**
 */
package org.osate.expr.expr.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.expr.expr.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExprFactoryImpl extends EFactoryImpl implements ExprFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ExprFactory init()
  {
    try
    {
      ExprFactory theExprFactory = (ExprFactory)EPackage.Registry.INSTANCE.getEFactory(ExprPackage.eNS_URI);
      if (theExprFactory != null)
      {
        return theExprFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ExprFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExprFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ExprPackage.EXPR_MODEL: return createExprModel();
      case ExprPackage.EDECLARATION: return createEDeclaration();
      case ExprPackage.TYPE_DECL: return createTypeDecl();
      case ExprPackage.VAR_DECL: return createVarDecl();
      case ExprPackage.FUN_DECL: return createFunDecl();
      case ExprPackage.ASSERTION: return createAssertion();
      case ExprPackage.ENUMBER_TYPE: return createENumberType();
      case ExprPackage.EINTEGER: return createEInteger();
      case ExprPackage.EREAL: return createEReal();
      case ExprPackage.RANGE_TYPE: return createRangeType();
      case ExprPackage.CATEGORY: return createCategory();
      case ExprPackage.META_CLASS: return createMetaClass();
      case ExprPackage.RECORD_TYPE: return createRecordType();
      case ExprPackage.FIELD: return createField();
      case ExprPackage.UNION_TYPE: return createUnionType();
      case ExprPackage.TUPLE_TYPE: return createTupleType();
      case ExprPackage.LIST_TYPE: return createListType();
      case ExprPackage.SET_TYPE: return createSetType();
      case ExprPackage.BAG_TYPE: return createBagType();
      case ExprPackage.MAP_TYPE: return createMapType();
      case ExprPackage.ENUM_TYPE: return createEnumType();
      case ExprPackage.ENUM_LITERAL: return createEnumLiteral();
      case ExprPackage.TYPE_REF: return createTypeRef();
      case ExprPackage.EXPRESSION: return createExpression();
      case ExprPackage.NAMED_ELEMENT_REF: return createNamedElementRef();
      case ExprPackage.LITERAL: return createLiteral();
      case ExprPackage.VALUE: return createValue();
      case ExprPackage.WRAPPED_NAMED_ELEMENT: return createWrappedNamedElement();
      case ExprPackage.NUMBER_LITERAL: return createNumberLiteral();
      case ExprPackage.FIELD_VALUE: return createFieldValue();
      case ExprPackage.EXPR_LIBRARY: return createExprLibrary();
      case ExprPackage.EXPR_SUBCLAUSE: return createExprSubclause();
      case ExprPackage.EBOOLEAN: return createEBoolean();
      case ExprPackage.ESTRING: return createEString();
      case ExprPackage.BINARY_OPERATION: return createBinaryOperation();
      case ExprPackage.UNARY_OPERATION: return createUnaryOperation();
      case ExprPackage.UNIT_EXPRESSION: return createUnitExpression();
      case ExprPackage.PROPERTY_EXPRESSION: return createPropertyExpression();
      case ExprPackage.SELECTION: return createSelection();
      case ExprPackage.RANGE: return createRange();
      case ExprPackage.CONDITIONAL: return createConditional();
      case ExprPackage.EBOOLEAN_LITERAL: return createEBooleanLiteral();
      case ExprPackage.EINTEGER_LITERAL: return createEIntegerLiteral();
      case ExprPackage.EREAL_LITERAL: return createERealLiteral();
      case ExprPackage.ESTRING_LITERAL: return createEStringLiteral();
      case ExprPackage.LIST_LITERAL: return createListLiteral();
      case ExprPackage.SET_LITERAL: return createSetLiteral();
      case ExprPackage.RECORD_LITERAL: return createRecordLiteral();
      case ExprPackage.UNION_LITERAL: return createUnionLiteral();
      case ExprPackage.TUPLE_LITERAL: return createTupleLiteral();
      case ExprPackage.BAG_LITERAL: return createBagLiteral();
      case ExprPackage.MAP_LITERAL: return createMapLiteral();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ExprPackage.META_CLASS_ENUM:
        return createMetaClassEnumFromString(eDataType, initialValue);
      case ExprPackage.TARGET_TYPE:
        return createTargetTypeFromString(eDataType, initialValue);
      case ExprPackage.OPERATION:
        return createOperationFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ExprPackage.META_CLASS_ENUM:
        return convertMetaClassEnumToString(eDataType, instanceValue);
      case ExprPackage.TARGET_TYPE:
        return convertTargetTypeToString(eDataType, instanceValue);
      case ExprPackage.OPERATION:
        return convertOperationToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExprModel createExprModel()
  {
    ExprModelImpl exprModel = new ExprModelImpl();
    return exprModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EDeclaration createEDeclaration()
  {
    EDeclarationImpl eDeclaration = new EDeclarationImpl();
    return eDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TypeDecl createTypeDecl()
  {
    TypeDeclImpl typeDecl = new TypeDeclImpl();
    return typeDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VarDecl createVarDecl()
  {
    VarDeclImpl varDecl = new VarDeclImpl();
    return varDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FunDecl createFunDecl()
  {
    FunDeclImpl funDecl = new FunDeclImpl();
    return funDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Assertion createAssertion()
  {
    AssertionImpl assertion = new AssertionImpl();
    return assertion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ENumberType createENumberType()
  {
    ENumberTypeImpl eNumberType = new ENumberTypeImpl();
    return eNumberType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EInteger createEInteger()
  {
    EIntegerImpl eInteger = new EIntegerImpl();
    return eInteger;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EReal createEReal()
  {
    ERealImpl eReal = new ERealImpl();
    return eReal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RangeType createRangeType()
  {
    RangeTypeImpl rangeType = new RangeTypeImpl();
    return rangeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Category createCategory()
  {
    CategoryImpl category = new CategoryImpl();
    return category;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MetaClass createMetaClass()
  {
    MetaClassImpl metaClass = new MetaClassImpl();
    return metaClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RecordType createRecordType()
  {
    RecordTypeImpl recordType = new RecordTypeImpl();
    return recordType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Field createField()
  {
    FieldImpl field = new FieldImpl();
    return field;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnionType createUnionType()
  {
    UnionTypeImpl unionType = new UnionTypeImpl();
    return unionType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TupleType createTupleType()
  {
    TupleTypeImpl tupleType = new TupleTypeImpl();
    return tupleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ListType createListType()
  {
    ListTypeImpl listType = new ListTypeImpl();
    return listType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SetType createSetType()
  {
    SetTypeImpl setType = new SetTypeImpl();
    return setType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BagType createBagType()
  {
    BagTypeImpl bagType = new BagTypeImpl();
    return bagType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MapType createMapType()
  {
    MapTypeImpl mapType = new MapTypeImpl();
    return mapType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EnumType createEnumType()
  {
    EnumTypeImpl enumType = new EnumTypeImpl();
    return enumType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EnumLiteral createEnumLiteral()
  {
    EnumLiteralImpl enumLiteral = new EnumLiteralImpl();
    return enumLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TypeRef createTypeRef()
  {
    TypeRefImpl typeRef = new TypeRefImpl();
    return typeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamedElementRef createNamedElementRef()
  {
    NamedElementRefImpl namedElementRef = new NamedElementRefImpl();
    return namedElementRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Literal createLiteral()
  {
    LiteralImpl literal = new LiteralImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Value createValue()
  {
    ValueImpl value = new ValueImpl();
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public WrappedNamedElement createWrappedNamedElement()
  {
    WrappedNamedElementImpl wrappedNamedElement = new WrappedNamedElementImpl();
    return wrappedNamedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NumberLiteral createNumberLiteral()
  {
    NumberLiteralImpl numberLiteral = new NumberLiteralImpl();
    return numberLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FieldValue createFieldValue()
  {
    FieldValueImpl fieldValue = new FieldValueImpl();
    return fieldValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExprLibrary createExprLibrary()
  {
    ExprLibraryImpl exprLibrary = new ExprLibraryImpl();
    return exprLibrary;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExprSubclause createExprSubclause()
  {
    ExprSubclauseImpl exprSubclause = new ExprSubclauseImpl();
    return exprSubclause;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EBoolean createEBoolean()
  {
    EBooleanImpl eBoolean = new EBooleanImpl();
    return eBoolean;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EString createEString()
  {
    EStringImpl eString = new EStringImpl();
    return eString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BinaryOperation createBinaryOperation()
  {
    BinaryOperationImpl binaryOperation = new BinaryOperationImpl();
    return binaryOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnaryOperation createUnaryOperation()
  {
    UnaryOperationImpl unaryOperation = new UnaryOperationImpl();
    return unaryOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnitExpression createUnitExpression()
  {
    UnitExpressionImpl unitExpression = new UnitExpressionImpl();
    return unitExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PropertyExpression createPropertyExpression()
  {
    PropertyExpressionImpl propertyExpression = new PropertyExpressionImpl();
    return propertyExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Selection createSelection()
  {
    SelectionImpl selection = new SelectionImpl();
    return selection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Range createRange()
  {
    RangeImpl range = new RangeImpl();
    return range;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Conditional createConditional()
  {
    ConditionalImpl conditional = new ConditionalImpl();
    return conditional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EBooleanLiteral createEBooleanLiteral()
  {
    EBooleanLiteralImpl eBooleanLiteral = new EBooleanLiteralImpl();
    return eBooleanLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EIntegerLiteral createEIntegerLiteral()
  {
    EIntegerLiteralImpl eIntegerLiteral = new EIntegerLiteralImpl();
    return eIntegerLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ERealLiteral createERealLiteral()
  {
    ERealLiteralImpl eRealLiteral = new ERealLiteralImpl();
    return eRealLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EStringLiteral createEStringLiteral()
  {
    EStringLiteralImpl eStringLiteral = new EStringLiteralImpl();
    return eStringLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ListLiteral createListLiteral()
  {
    ListLiteralImpl listLiteral = new ListLiteralImpl();
    return listLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SetLiteral createSetLiteral()
  {
    SetLiteralImpl setLiteral = new SetLiteralImpl();
    return setLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RecordLiteral createRecordLiteral()
  {
    RecordLiteralImpl recordLiteral = new RecordLiteralImpl();
    return recordLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public UnionLiteral createUnionLiteral()
  {
    UnionLiteralImpl unionLiteral = new UnionLiteralImpl();
    return unionLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TupleLiteral createTupleLiteral()
  {
    TupleLiteralImpl tupleLiteral = new TupleLiteralImpl();
    return tupleLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BagLiteral createBagLiteral()
  {
    BagLiteralImpl bagLiteral = new BagLiteralImpl();
    return bagLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MapLiteral createMapLiteral()
  {
    MapLiteralImpl mapLiteral = new MapLiteralImpl();
    return mapLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetaClassEnum createMetaClassEnumFromString(EDataType eDataType, String initialValue)
  {
    MetaClassEnum result = MetaClassEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertMetaClassEnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TargetType createTargetTypeFromString(EDataType eDataType, String initialValue)
  {
    TargetType result = TargetType.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertTargetTypeToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operation createOperationFromString(EDataType eDataType, String initialValue)
  {
    Operation result = Operation.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOperationToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExprPackage getExprPackage()
  {
    return (ExprPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ExprPackage getPackage()
  {
    return ExprPackage.eINSTANCE;
  }

} //ExprFactoryImpl
