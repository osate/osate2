/**
 */
package org.osate.reqspec.reqSpec.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.osate.reqspec.reqSpec.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReqSpecFactoryImpl extends EFactoryImpl implements ReqSpecFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ReqSpecFactory init()
  {
    try
    {
      ReqSpecFactory theReqSpecFactory = (ReqSpecFactory)EPackage.Registry.INSTANCE.getEFactory(ReqSpecPackage.eNS_URI);
      if (theReqSpecFactory != null)
      {
        return theReqSpecFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ReqSpecFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecFactoryImpl()
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
      case ReqSpecPackage.REQ_SPEC: return createReqSpec();
      case ReqSpecPackage.REQ_SPEC_CONTAINER: return createReqSpecContainer();
      case ReqSpecPackage.CONTRACTUAL_ELEMENT: return createContractualElement();
      case ReqSpecPackage.REQ_ROOT: return createReqRoot();
      case ReqSpecPackage.STAKEHOLDER_GOALS: return createStakeholderGoals();
      case ReqSpecPackage.REQ_DOCUMENT: return createReqDocument();
      case ReqSpecPackage.DOCUMENT_SECTION: return createDocumentSection();
      case ReqSpecPackage.REQ_SPECS: return createReqSpecs();
      case ReqSpecPackage.REQ_SPEC_FOLDER: return createReqSpecFolder();
      case ReqSpecPackage.GOAL_FOLDER: return createGoalFolder();
      case ReqSpecPackage.GOAL: return createGoal();
      case ReqSpecPackage.REQUIREMENT: return createRequirement();
      case ReqSpecPackage.REQ_PREDICATE: return createReqPredicate();
      case ReqSpecPackage.INFORMAL_PREDICATE: return createInformalPredicate();
      case ReqSpecPackage.XPREDICATE: return createXPredicate();
      case ReqSpecPackage.SPE_AR_PREDICATE: return createSPeARPredicate();
      case ReqSpecPackage.EXTERNAL_DOCUMENT: return createExternalDocument();
      case ReqSpecPackage.QUANTIFICATION_EXPR: return createQuantificationExpr();
      case ReqSpecPackage.DOMAIN: return createDomain();
      case ReqSpecPackage.QUANTIFIED_VARIABLE: return createQuantifiedVariable();
      case ReqSpecPackage.FORALL_EXPR: return createForallExpr();
      case ReqSpecPackage.EXISTS_EXPR: return createExistsExpr();
      case ReqSpecPackage.SUM_EXPR: return createSumExpr();
      case ReqSpecPackage.EXPR: return createExpr();
      case ReqSpecPackage.VARIABLE_REF: return createVariableRef();
      case ReqSpecPackage.FUNCTION: return createFunction();
      case ReqSpecPackage.CALL_REF: return createCallRef();
      case ReqSpecPackage.RECORD_FIELD_EXPR: return createRecordFieldExpr();
      case ReqSpecPackage.RECORD_FIELD: return createRecordField();
      case ReqSpecPackage.TYPE: return createType();
      case ReqSpecPackage.FINITE_SET_TYPE: return createFiniteSetType();
      case ReqSpecPackage.ARRAY_TYPE: return createArrayType();
      case ReqSpecPackage.INTEGER_SUB_RANGE_TYPE: return createIntegerSubRangeType();
      case ReqSpecPackage.ENUMERATION_TYPE: return createEnumerationType();
      case ReqSpecPackage.ENUMERATOR: return createEnumerator();
      case ReqSpecPackage.TYPE_DEF: return createTypeDef();
      case ReqSpecPackage.RECORD_TYPE: return createRecordType();
      case ReqSpecPackage.UNIT: return createUnit();
      case ReqSpecPackage.SCALAR: return createScalar();
      case ReqSpecPackage.NAMED_UNIT: return createNamedUnit();
      case ReqSpecPackage.UNIT_DEF: return createUnitDef();
      case ReqSpecPackage.FORMULA_OPS: return createFormulaOps();
      case ReqSpecPackage.BINARY_OP: return createBinaryOp();
      case ReqSpecPackage.MULTIPLY: return createMultiply();
      case ReqSpecPackage.EXPONENTIATION: return createExponentiation();
      case ReqSpecPackage.DIVIDE: return createDivide();
      case ReqSpecPackage.PLUS: return createPlus();
      case ReqSpecPackage.MINUS: return createMinus();
      case ReqSpecPackage.MODULUS: return createModulus();
      case ReqSpecPackage.RELATIONAL_OP: return createRelationalOp();
      case ReqSpecPackage.LOGICAL_OP: return createLogicalOp();
      case ReqSpecPackage.UNARY_OP: return createUnaryOp();
      case ReqSpecPackage.DOMAIN_EXPR: return createDomainExpr();
      case ReqSpecPackage.IF_THEN_ELSE_EXPR: return createIfThenElseExpr();
      case ReqSpecPackage.BINARY_EXPR: return createBinaryExpr();
      case ReqSpecPackage.UNARY_EXPR: return createUnaryExpr();
      case ReqSpecPackage.PRE_EXPR: return createPreExpr();
      case ReqSpecPackage.RECORD_ACCESS_EXPR: return createRecordAccessExpr();
      case ReqSpecPackage.ARRAY_ACCESS_EXPR: return createArrayAccessExpr();
      case ReqSpecPackage.ID_EXPR: return createIdExpr();
      case ReqSpecPackage.RECORD_EXPR: return createRecordExpr();
      case ReqSpecPackage.ARRAY_EXPR: return createArrayExpr();
      case ReqSpecPackage.FN_CALL_EXPR: return createFnCallExpr();
      case ReqSpecPackage.BOOL_EXPR: return createBoolExpr();
      case ReqSpecPackage.INT_EXPR: return createIntExpr();
      case ReqSpecPackage.REAL_EXPR: return createRealExpr();
      case ReqSpecPackage.REAL_TYPE: return createRealType();
      case ReqSpecPackage.INTEGER_TYPE: return createIntegerType();
      case ReqSpecPackage.BOOLEAN_TYPE: return createBooleanType();
      case ReqSpecPackage.NAMED_TYPE: return createNamedType();
      case ReqSpecPackage.QUOT_UNIT: return createQuotUnit();
      case ReqSpecPackage.PROD_UNIT: return createProdUnit();
      case ReqSpecPackage.ALWAYS: return createAlways();
      case ReqSpecPackage.EXISTS: return createExists();
      case ReqSpecPackage.RESPONDS: return createResponds();
      case ReqSpecPackage.PRECEDES: return createPrecedes();
      case ReqSpecPackage.EQUAL_TO: return createEqualTo();
      case ReqSpecPackage.NOT_EQUAL: return createNotEqual();
      case ReqSpecPackage.LESS_THAN: return createLessThan();
      case ReqSpecPackage.GREATER_THAN: return createGreaterThan();
      case ReqSpecPackage.LESS_THAN_EQUAL: return createLessThanEqual();
      case ReqSpecPackage.GREATER_THAN_EQUAL: return createGreaterThanEqual();
      case ReqSpecPackage.AND: return createAnd();
      case ReqSpecPackage.OR: return createOr();
      case ReqSpecPackage.XOR: return createXor();
      case ReqSpecPackage.IMPLIES: return createImplies();
      case ReqSpecPackage.UNARY_MINUS: return createUnaryMinus();
      case ReqSpecPackage.NOT: return createNot();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpec createReqSpec()
  {
    ReqSpecImpl reqSpec = new ReqSpecImpl();
    return reqSpec;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecContainer createReqSpecContainer()
  {
    ReqSpecContainerImpl reqSpecContainer = new ReqSpecContainerImpl();
    return reqSpecContainer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContractualElement createContractualElement()
  {
    ContractualElementImpl contractualElement = new ContractualElementImpl();
    return contractualElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqRoot createReqRoot()
  {
    ReqRootImpl reqRoot = new ReqRootImpl();
    return reqRoot;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StakeholderGoals createStakeholderGoals()
  {
    StakeholderGoalsImpl stakeholderGoals = new StakeholderGoalsImpl();
    return stakeholderGoals;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqDocument createReqDocument()
  {
    ReqDocumentImpl reqDocument = new ReqDocumentImpl();
    return reqDocument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DocumentSection createDocumentSection()
  {
    DocumentSectionImpl documentSection = new DocumentSectionImpl();
    return documentSection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecs createReqSpecs()
  {
    ReqSpecsImpl reqSpecs = new ReqSpecsImpl();
    return reqSpecs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecFolder createReqSpecFolder()
  {
    ReqSpecFolderImpl reqSpecFolder = new ReqSpecFolderImpl();
    return reqSpecFolder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GoalFolder createGoalFolder()
  {
    GoalFolderImpl goalFolder = new GoalFolderImpl();
    return goalFolder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Goal createGoal()
  {
    GoalImpl goal = new GoalImpl();
    return goal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Requirement createRequirement()
  {
    RequirementImpl requirement = new RequirementImpl();
    return requirement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqPredicate createReqPredicate()
  {
    ReqPredicateImpl reqPredicate = new ReqPredicateImpl();
    return reqPredicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InformalPredicate createInformalPredicate()
  {
    InformalPredicateImpl informalPredicate = new InformalPredicateImpl();
    return informalPredicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XPredicate createXPredicate()
  {
    XPredicateImpl xPredicate = new XPredicateImpl();
    return xPredicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SPeARPredicate createSPeARPredicate()
  {
    SPeARPredicateImpl sPeARPredicate = new SPeARPredicateImpl();
    return sPeARPredicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalDocument createExternalDocument()
  {
    ExternalDocumentImpl externalDocument = new ExternalDocumentImpl();
    return externalDocument;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QuantificationExpr createQuantificationExpr()
  {
    QuantificationExprImpl quantificationExpr = new QuantificationExprImpl();
    return quantificationExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Domain createDomain()
  {
    DomainImpl domain = new DomainImpl();
    return domain;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QuantifiedVariable createQuantifiedVariable()
  {
    QuantifiedVariableImpl quantifiedVariable = new QuantifiedVariableImpl();
    return quantifiedVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForallExpr createForallExpr()
  {
    ForallExprImpl forallExpr = new ForallExprImpl();
    return forallExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExistsExpr createExistsExpr()
  {
    ExistsExprImpl existsExpr = new ExistsExprImpl();
    return existsExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SumExpr createSumExpr()
  {
    SumExprImpl sumExpr = new SumExprImpl();
    return sumExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr createExpr()
  {
    ExprImpl expr = new ExprImpl();
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableRef createVariableRef()
  {
    VariableRefImpl variableRef = new VariableRefImpl();
    return variableRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Function createFunction()
  {
    FunctionImpl function = new FunctionImpl();
    return function;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CallRef createCallRef()
  {
    CallRefImpl callRef = new CallRefImpl();
    return callRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordFieldExpr createRecordFieldExpr()
  {
    RecordFieldExprImpl recordFieldExpr = new RecordFieldExprImpl();
    return recordFieldExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordField createRecordField()
  {
    RecordFieldImpl recordField = new RecordFieldImpl();
    return recordField;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FiniteSetType createFiniteSetType()
  {
    FiniteSetTypeImpl finiteSetType = new FiniteSetTypeImpl();
    return finiteSetType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayType createArrayType()
  {
    ArrayTypeImpl arrayType = new ArrayTypeImpl();
    return arrayType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegerSubRangeType createIntegerSubRangeType()
  {
    IntegerSubRangeTypeImpl integerSubRangeType = new IntegerSubRangeTypeImpl();
    return integerSubRangeType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumerationType createEnumerationType()
  {
    EnumerationTypeImpl enumerationType = new EnumerationTypeImpl();
    return enumerationType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Enumerator createEnumerator()
  {
    EnumeratorImpl enumerator = new EnumeratorImpl();
    return enumerator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDef createTypeDef()
  {
    TypeDefImpl typeDef = new TypeDefImpl();
    return typeDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
  public Unit createUnit()
  {
    UnitImpl unit = new UnitImpl();
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Scalar createScalar()
  {
    ScalarImpl scalar = new ScalarImpl();
    return scalar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedUnit createNamedUnit()
  {
    NamedUnitImpl namedUnit = new NamedUnitImpl();
    return namedUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnitDef createUnitDef()
  {
    UnitDefImpl unitDef = new UnitDefImpl();
    return unitDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FormulaOps createFormulaOps()
  {
    FormulaOpsImpl formulaOps = new FormulaOpsImpl();
    return formulaOps;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryOp createBinaryOp()
  {
    BinaryOpImpl binaryOp = new BinaryOpImpl();
    return binaryOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Multiply createMultiply()
  {
    MultiplyImpl multiply = new MultiplyImpl();
    return multiply;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exponentiation createExponentiation()
  {
    ExponentiationImpl exponentiation = new ExponentiationImpl();
    return exponentiation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Divide createDivide()
  {
    DivideImpl divide = new DivideImpl();
    return divide;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Plus createPlus()
  {
    PlusImpl plus = new PlusImpl();
    return plus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Minus createMinus()
  {
    MinusImpl minus = new MinusImpl();
    return minus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Modulus createModulus()
  {
    ModulusImpl modulus = new ModulusImpl();
    return modulus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RelationalOp createRelationalOp()
  {
    RelationalOpImpl relationalOp = new RelationalOpImpl();
    return relationalOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LogicalOp createLogicalOp()
  {
    LogicalOpImpl logicalOp = new LogicalOpImpl();
    return logicalOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryOp createUnaryOp()
  {
    UnaryOpImpl unaryOp = new UnaryOpImpl();
    return unaryOp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DomainExpr createDomainExpr()
  {
    DomainExprImpl domainExpr = new DomainExprImpl();
    return domainExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfThenElseExpr createIfThenElseExpr()
  {
    IfThenElseExprImpl ifThenElseExpr = new IfThenElseExprImpl();
    return ifThenElseExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryExpr createBinaryExpr()
  {
    BinaryExprImpl binaryExpr = new BinaryExprImpl();
    return binaryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryExpr createUnaryExpr()
  {
    UnaryExprImpl unaryExpr = new UnaryExprImpl();
    return unaryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PreExpr createPreExpr()
  {
    PreExprImpl preExpr = new PreExprImpl();
    return preExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordAccessExpr createRecordAccessExpr()
  {
    RecordAccessExprImpl recordAccessExpr = new RecordAccessExprImpl();
    return recordAccessExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayAccessExpr createArrayAccessExpr()
  {
    ArrayAccessExprImpl arrayAccessExpr = new ArrayAccessExprImpl();
    return arrayAccessExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdExpr createIdExpr()
  {
    IdExprImpl idExpr = new IdExprImpl();
    return idExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordExpr createRecordExpr()
  {
    RecordExprImpl recordExpr = new RecordExprImpl();
    return recordExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayExpr createArrayExpr()
  {
    ArrayExprImpl arrayExpr = new ArrayExprImpl();
    return arrayExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FnCallExpr createFnCallExpr()
  {
    FnCallExprImpl fnCallExpr = new FnCallExprImpl();
    return fnCallExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolExpr createBoolExpr()
  {
    BoolExprImpl boolExpr = new BoolExprImpl();
    return boolExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntExpr createIntExpr()
  {
    IntExprImpl intExpr = new IntExprImpl();
    return intExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RealExpr createRealExpr()
  {
    RealExprImpl realExpr = new RealExprImpl();
    return realExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RealType createRealType()
  {
    RealTypeImpl realType = new RealTypeImpl();
    return realType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegerType createIntegerType()
  {
    IntegerTypeImpl integerType = new IntegerTypeImpl();
    return integerType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanType createBooleanType()
  {
    BooleanTypeImpl booleanType = new BooleanTypeImpl();
    return booleanType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedType createNamedType()
  {
    NamedTypeImpl namedType = new NamedTypeImpl();
    return namedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public QuotUnit createQuotUnit()
  {
    QuotUnitImpl quotUnit = new QuotUnitImpl();
    return quotUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ProdUnit createProdUnit()
  {
    ProdUnitImpl prodUnit = new ProdUnitImpl();
    return prodUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Always createAlways()
  {
    AlwaysImpl always = new AlwaysImpl();
    return always;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exists createExists()
  {
    ExistsImpl exists = new ExistsImpl();
    return exists;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Responds createResponds()
  {
    RespondsImpl responds = new RespondsImpl();
    return responds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Precedes createPrecedes()
  {
    PrecedesImpl precedes = new PrecedesImpl();
    return precedes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EqualTo createEqualTo()
  {
    EqualToImpl equalTo = new EqualToImpl();
    return equalTo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotEqual createNotEqual()
  {
    NotEqualImpl notEqual = new NotEqualImpl();
    return notEqual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LessThan createLessThan()
  {
    LessThanImpl lessThan = new LessThanImpl();
    return lessThan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GreaterThan createGreaterThan()
  {
    GreaterThanImpl greaterThan = new GreaterThanImpl();
    return greaterThan;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LessThanEqual createLessThanEqual()
  {
    LessThanEqualImpl lessThanEqual = new LessThanEqualImpl();
    return lessThanEqual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GreaterThanEqual createGreaterThanEqual()
  {
    GreaterThanEqualImpl greaterThanEqual = new GreaterThanEqualImpl();
    return greaterThanEqual;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public And createAnd()
  {
    AndImpl and = new AndImpl();
    return and;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Or createOr()
  {
    OrImpl or = new OrImpl();
    return or;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Xor createXor()
  {
    XorImpl xor = new XorImpl();
    return xor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Implies createImplies()
  {
    ImpliesImpl implies = new ImpliesImpl();
    return implies;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryMinus createUnaryMinus()
  {
    UnaryMinusImpl unaryMinus = new UnaryMinusImpl();
    return unaryMinus;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Not createNot()
  {
    NotImpl not = new NotImpl();
    return not;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecPackage getReqSpecPackage()
  {
    return (ReqSpecPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ReqSpecPackage getPackage()
  {
    return ReqSpecPackage.eINSTANCE;
  }

} //ReqSpecFactoryImpl
