/**
 */
package org.osate.reqspec.reqSpec.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.osate.reqspec.reqSpec.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.osate.reqspec.reqSpec.ReqSpecPackage
 * @generated
 */
public class ReqSpecSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ReqSpecPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReqSpecSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = ReqSpecPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case ReqSpecPackage.REQ_SPEC:
      {
        ReqSpec reqSpec = (ReqSpec)theEObject;
        T result = caseReqSpec(reqSpec);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REQ_SPEC_CONTAINER:
      {
        ReqSpecContainer reqSpecContainer = (ReqSpecContainer)theEObject;
        T result = caseReqSpecContainer(reqSpecContainer);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.CONTRACTUAL_ELEMENT:
      {
        ContractualElement contractualElement = (ContractualElement)theEObject;
        T result = caseContractualElement(contractualElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REQ_ROOT:
      {
        ReqRoot reqRoot = (ReqRoot)theEObject;
        T result = caseReqRoot(reqRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.STAKEHOLDER_GOALS:
      {
        StakeholderGoals stakeholderGoals = (StakeholderGoals)theEObject;
        T result = caseStakeholderGoals(stakeholderGoals);
        if (result == null) result = caseReqSpec(stakeholderGoals);
        if (result == null) result = caseReqSpecContainer(stakeholderGoals);
        if (result == null) result = caseReqRoot(stakeholderGoals);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REQ_DOCUMENT:
      {
        ReqDocument reqDocument = (ReqDocument)theEObject;
        T result = caseReqDocument(reqDocument);
        if (result == null) result = caseReqSpec(reqDocument);
        if (result == null) result = caseReqSpecContainer(reqDocument);
        if (result == null) result = caseReqRoot(reqDocument);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.DOCUMENT_SECTION:
      {
        DocumentSection documentSection = (DocumentSection)theEObject;
        T result = caseDocumentSection(documentSection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REQ_SPECS:
      {
        ReqSpecs reqSpecs = (ReqSpecs)theEObject;
        T result = caseReqSpecs(reqSpecs);
        if (result == null) result = caseReqSpec(reqSpecs);
        if (result == null) result = caseReqSpecContainer(reqSpecs);
        if (result == null) result = caseReqRoot(reqSpecs);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REQ_SPEC_FOLDER:
      {
        ReqSpecFolder reqSpecFolder = (ReqSpecFolder)theEObject;
        T result = caseReqSpecFolder(reqSpecFolder);
        if (result == null) result = caseReqSpecContainer(reqSpecFolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.GOAL_FOLDER:
      {
        GoalFolder goalFolder = (GoalFolder)theEObject;
        T result = caseGoalFolder(goalFolder);
        if (result == null) result = caseReqSpecContainer(goalFolder);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.GOAL:
      {
        Goal goal = (Goal)theEObject;
        T result = caseGoal(goal);
        if (result == null) result = caseContractualElement(goal);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REQUIREMENT:
      {
        Requirement requirement = (Requirement)theEObject;
        T result = caseRequirement(requirement);
        if (result == null) result = caseContractualElement(requirement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REQ_PREDICATE:
      {
        ReqPredicate reqPredicate = (ReqPredicate)theEObject;
        T result = caseReqPredicate(reqPredicate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.INFORMAL_PREDICATE:
      {
        InformalPredicate informalPredicate = (InformalPredicate)theEObject;
        T result = caseInformalPredicate(informalPredicate);
        if (result == null) result = caseReqPredicate(informalPredicate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.XPREDICATE:
      {
        XPredicate xPredicate = (XPredicate)theEObject;
        T result = caseXPredicate(xPredicate);
        if (result == null) result = caseReqPredicate(xPredicate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.SPE_AR_PREDICATE:
      {
        SPeARPredicate sPeARPredicate = (SPeARPredicate)theEObject;
        T result = caseSPeARPredicate(sPeARPredicate);
        if (result == null) result = caseReqPredicate(sPeARPredicate);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.EXTERNAL_DOCUMENT:
      {
        ExternalDocument externalDocument = (ExternalDocument)theEObject;
        T result = caseExternalDocument(externalDocument);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.QUANTIFICATION_EXPR:
      {
        QuantificationExpr quantificationExpr = (QuantificationExpr)theEObject;
        T result = caseQuantificationExpr(quantificationExpr);
        if (result == null) result = caseExpr(quantificationExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.DOMAIN:
      {
        Domain domain = (Domain)theEObject;
        T result = caseDomain(domain);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.QUANTIFIED_VARIABLE:
      {
        QuantifiedVariable quantifiedVariable = (QuantifiedVariable)theEObject;
        T result = caseQuantifiedVariable(quantifiedVariable);
        if (result == null) result = caseVariableRef(quantifiedVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.FORALL_EXPR:
      {
        ForallExpr forallExpr = (ForallExpr)theEObject;
        T result = caseForallExpr(forallExpr);
        if (result == null) result = caseQuantificationExpr(forallExpr);
        if (result == null) result = caseExpr(forallExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.EXISTS_EXPR:
      {
        ExistsExpr existsExpr = (ExistsExpr)theEObject;
        T result = caseExistsExpr(existsExpr);
        if (result == null) result = caseQuantificationExpr(existsExpr);
        if (result == null) result = caseExpr(existsExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.SUM_EXPR:
      {
        SumExpr sumExpr = (SumExpr)theEObject;
        T result = caseSumExpr(sumExpr);
        if (result == null) result = caseQuantificationExpr(sumExpr);
        if (result == null) result = caseExpr(sumExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.EXPR:
      {
        Expr expr = (Expr)theEObject;
        T result = caseExpr(expr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.VARIABLE_REF:
      {
        VariableRef variableRef = (VariableRef)theEObject;
        T result = caseVariableRef(variableRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.FUNCTION:
      {
        Function function = (Function)theEObject;
        T result = caseFunction(function);
        if (result == null) result = caseCallRef(function);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.CALL_REF:
      {
        CallRef callRef = (CallRef)theEObject;
        T result = caseCallRef(callRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.RECORD_FIELD_EXPR:
      {
        RecordFieldExpr recordFieldExpr = (RecordFieldExpr)theEObject;
        T result = caseRecordFieldExpr(recordFieldExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.RECORD_FIELD:
      {
        RecordField recordField = (RecordField)theEObject;
        T result = caseRecordField(recordField);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.TYPE:
      {
        Type type = (Type)theEObject;
        T result = caseType(type);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.FINITE_SET_TYPE:
      {
        FiniteSetType finiteSetType = (FiniteSetType)theEObject;
        T result = caseFiniteSetType(finiteSetType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.ARRAY_TYPE:
      {
        ArrayType arrayType = (ArrayType)theEObject;
        T result = caseArrayType(arrayType);
        if (result == null) result = caseType(arrayType);
        if (result == null) result = caseFiniteSetType(arrayType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.INTEGER_SUB_RANGE_TYPE:
      {
        IntegerSubRangeType integerSubRangeType = (IntegerSubRangeType)theEObject;
        T result = caseIntegerSubRangeType(integerSubRangeType);
        if (result == null) result = caseType(integerSubRangeType);
        if (result == null) result = caseFiniteSetType(integerSubRangeType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.ENUMERATION_TYPE:
      {
        EnumerationType enumerationType = (EnumerationType)theEObject;
        T result = caseEnumerationType(enumerationType);
        if (result == null) result = caseFiniteSetType(enumerationType);
        if (result == null) result = caseType(enumerationType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.ENUMERATOR:
      {
        Enumerator enumerator = (Enumerator)theEObject;
        T result = caseEnumerator(enumerator);
        if (result == null) result = caseVariableRef(enumerator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.TYPE_DEF:
      {
        TypeDef typeDef = (TypeDef)theEObject;
        T result = caseTypeDef(typeDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.RECORD_TYPE:
      {
        RecordType recordType = (RecordType)theEObject;
        T result = caseRecordType(recordType);
        if (result == null) result = caseType(recordType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.UNIT:
      {
        Unit unit = (Unit)theEObject;
        T result = caseUnit(unit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.SCALAR:
      {
        Scalar scalar = (Scalar)theEObject;
        T result = caseScalar(scalar);
        if (result == null) result = caseUnit(scalar);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.NAMED_UNIT:
      {
        NamedUnit namedUnit = (NamedUnit)theEObject;
        T result = caseNamedUnit(namedUnit);
        if (result == null) result = caseUnit(namedUnit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.UNIT_DEF:
      {
        UnitDef unitDef = (UnitDef)theEObject;
        T result = caseUnitDef(unitDef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.FORMULA_OPS:
      {
        FormulaOps formulaOps = (FormulaOps)theEObject;
        T result = caseFormulaOps(formulaOps);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.BINARY_OP:
      {
        BinaryOp binaryOp = (BinaryOp)theEObject;
        T result = caseBinaryOp(binaryOp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.MULTIPLY:
      {
        Multiply multiply = (Multiply)theEObject;
        T result = caseMultiply(multiply);
        if (result == null) result = caseBinaryOp(multiply);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.EXPONENTIATION:
      {
        Exponentiation exponentiation = (Exponentiation)theEObject;
        T result = caseExponentiation(exponentiation);
        if (result == null) result = caseBinaryOp(exponentiation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.DIVIDE:
      {
        Divide divide = (Divide)theEObject;
        T result = caseDivide(divide);
        if (result == null) result = caseBinaryOp(divide);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.PLUS:
      {
        Plus plus = (Plus)theEObject;
        T result = casePlus(plus);
        if (result == null) result = caseBinaryOp(plus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.MINUS:
      {
        Minus minus = (Minus)theEObject;
        T result = caseMinus(minus);
        if (result == null) result = caseBinaryOp(minus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.MODULUS:
      {
        Modulus modulus = (Modulus)theEObject;
        T result = caseModulus(modulus);
        if (result == null) result = caseBinaryOp(modulus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.RELATIONAL_OP:
      {
        RelationalOp relationalOp = (RelationalOp)theEObject;
        T result = caseRelationalOp(relationalOp);
        if (result == null) result = caseBinaryOp(relationalOp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.LOGICAL_OP:
      {
        LogicalOp logicalOp = (LogicalOp)theEObject;
        T result = caseLogicalOp(logicalOp);
        if (result == null) result = caseBinaryOp(logicalOp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.UNARY_OP:
      {
        UnaryOp unaryOp = (UnaryOp)theEObject;
        T result = caseUnaryOp(unaryOp);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.DOMAIN_EXPR:
      {
        DomainExpr domainExpr = (DomainExpr)theEObject;
        T result = caseDomainExpr(domainExpr);
        if (result == null) result = caseDomain(domainExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.IF_THEN_ELSE_EXPR:
      {
        IfThenElseExpr ifThenElseExpr = (IfThenElseExpr)theEObject;
        T result = caseIfThenElseExpr(ifThenElseExpr);
        if (result == null) result = caseExpr(ifThenElseExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.BINARY_EXPR:
      {
        BinaryExpr binaryExpr = (BinaryExpr)theEObject;
        T result = caseBinaryExpr(binaryExpr);
        if (result == null) result = caseExpr(binaryExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.UNARY_EXPR:
      {
        UnaryExpr unaryExpr = (UnaryExpr)theEObject;
        T result = caseUnaryExpr(unaryExpr);
        if (result == null) result = caseExpr(unaryExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.PRE_EXPR:
      {
        PreExpr preExpr = (PreExpr)theEObject;
        T result = casePreExpr(preExpr);
        if (result == null) result = caseExpr(preExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.RECORD_ACCESS_EXPR:
      {
        RecordAccessExpr recordAccessExpr = (RecordAccessExpr)theEObject;
        T result = caseRecordAccessExpr(recordAccessExpr);
        if (result == null) result = caseExpr(recordAccessExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.ARRAY_ACCESS_EXPR:
      {
        ArrayAccessExpr arrayAccessExpr = (ArrayAccessExpr)theEObject;
        T result = caseArrayAccessExpr(arrayAccessExpr);
        if (result == null) result = caseExpr(arrayAccessExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.ID_EXPR:
      {
        IdExpr idExpr = (IdExpr)theEObject;
        T result = caseIdExpr(idExpr);
        if (result == null) result = caseExpr(idExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.RECORD_EXPR:
      {
        RecordExpr recordExpr = (RecordExpr)theEObject;
        T result = caseRecordExpr(recordExpr);
        if (result == null) result = caseExpr(recordExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.ARRAY_EXPR:
      {
        ArrayExpr arrayExpr = (ArrayExpr)theEObject;
        T result = caseArrayExpr(arrayExpr);
        if (result == null) result = caseExpr(arrayExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.FN_CALL_EXPR:
      {
        FnCallExpr fnCallExpr = (FnCallExpr)theEObject;
        T result = caseFnCallExpr(fnCallExpr);
        if (result == null) result = caseExpr(fnCallExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.BOOL_EXPR:
      {
        BoolExpr boolExpr = (BoolExpr)theEObject;
        T result = caseBoolExpr(boolExpr);
        if (result == null) result = caseExpr(boolExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.INT_EXPR:
      {
        IntExpr intExpr = (IntExpr)theEObject;
        T result = caseIntExpr(intExpr);
        if (result == null) result = caseExpr(intExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REAL_EXPR:
      {
        RealExpr realExpr = (RealExpr)theEObject;
        T result = caseRealExpr(realExpr);
        if (result == null) result = caseExpr(realExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.REAL_TYPE:
      {
        RealType realType = (RealType)theEObject;
        T result = caseRealType(realType);
        if (result == null) result = caseType(realType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.INTEGER_TYPE:
      {
        IntegerType integerType = (IntegerType)theEObject;
        T result = caseIntegerType(integerType);
        if (result == null) result = caseType(integerType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.BOOLEAN_TYPE:
      {
        BooleanType booleanType = (BooleanType)theEObject;
        T result = caseBooleanType(booleanType);
        if (result == null) result = caseType(booleanType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.NAMED_TYPE:
      {
        NamedType namedType = (NamedType)theEObject;
        T result = caseNamedType(namedType);
        if (result == null) result = caseType(namedType);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.QUOT_UNIT:
      {
        QuotUnit quotUnit = (QuotUnit)theEObject;
        T result = caseQuotUnit(quotUnit);
        if (result == null) result = caseUnit(quotUnit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.PROD_UNIT:
      {
        ProdUnit prodUnit = (ProdUnit)theEObject;
        T result = caseProdUnit(prodUnit);
        if (result == null) result = caseUnit(prodUnit);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.ALWAYS:
      {
        Always always = (Always)theEObject;
        T result = caseAlways(always);
        if (result == null) result = caseFormulaOps(always);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.EXISTS:
      {
        Exists exists = (Exists)theEObject;
        T result = caseExists(exists);
        if (result == null) result = caseFormulaOps(exists);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.RESPONDS:
      {
        Responds responds = (Responds)theEObject;
        T result = caseResponds(responds);
        if (result == null) result = caseFormulaOps(responds);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.PRECEDES:
      {
        Precedes precedes = (Precedes)theEObject;
        T result = casePrecedes(precedes);
        if (result == null) result = caseFormulaOps(precedes);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.EQUAL_TO:
      {
        EqualTo equalTo = (EqualTo)theEObject;
        T result = caseEqualTo(equalTo);
        if (result == null) result = caseRelationalOp(equalTo);
        if (result == null) result = caseBinaryOp(equalTo);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.NOT_EQUAL:
      {
        NotEqual notEqual = (NotEqual)theEObject;
        T result = caseNotEqual(notEqual);
        if (result == null) result = caseRelationalOp(notEqual);
        if (result == null) result = caseBinaryOp(notEqual);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.LESS_THAN:
      {
        LessThan lessThan = (LessThan)theEObject;
        T result = caseLessThan(lessThan);
        if (result == null) result = caseRelationalOp(lessThan);
        if (result == null) result = caseBinaryOp(lessThan);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.GREATER_THAN:
      {
        GreaterThan greaterThan = (GreaterThan)theEObject;
        T result = caseGreaterThan(greaterThan);
        if (result == null) result = caseRelationalOp(greaterThan);
        if (result == null) result = caseBinaryOp(greaterThan);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.LESS_THAN_EQUAL:
      {
        LessThanEqual lessThanEqual = (LessThanEqual)theEObject;
        T result = caseLessThanEqual(lessThanEqual);
        if (result == null) result = caseRelationalOp(lessThanEqual);
        if (result == null) result = caseBinaryOp(lessThanEqual);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.GREATER_THAN_EQUAL:
      {
        GreaterThanEqual greaterThanEqual = (GreaterThanEqual)theEObject;
        T result = caseGreaterThanEqual(greaterThanEqual);
        if (result == null) result = caseRelationalOp(greaterThanEqual);
        if (result == null) result = caseBinaryOp(greaterThanEqual);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.AND:
      {
        And and = (And)theEObject;
        T result = caseAnd(and);
        if (result == null) result = caseLogicalOp(and);
        if (result == null) result = caseBinaryOp(and);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.OR:
      {
        Or or = (Or)theEObject;
        T result = caseOr(or);
        if (result == null) result = caseLogicalOp(or);
        if (result == null) result = caseBinaryOp(or);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.XOR:
      {
        Xor xor = (Xor)theEObject;
        T result = caseXor(xor);
        if (result == null) result = caseLogicalOp(xor);
        if (result == null) result = caseBinaryOp(xor);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.IMPLIES:
      {
        Implies implies = (Implies)theEObject;
        T result = caseImplies(implies);
        if (result == null) result = caseLogicalOp(implies);
        if (result == null) result = caseBinaryOp(implies);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.UNARY_MINUS:
      {
        UnaryMinus unaryMinus = (UnaryMinus)theEObject;
        T result = caseUnaryMinus(unaryMinus);
        if (result == null) result = caseUnaryOp(unaryMinus);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ReqSpecPackage.NOT:
      {
        Not not = (Not)theEObject;
        T result = caseNot(not);
        if (result == null) result = caseUnaryOp(not);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Req Spec</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Req Spec</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReqSpec(ReqSpec object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Container</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Container</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReqSpecContainer(ReqSpecContainer object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Contractual Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Contractual Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContractualElement(ContractualElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Req Root</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Req Root</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReqRoot(ReqRoot object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Stakeholder Goals</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Stakeholder Goals</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStakeholderGoals(StakeholderGoals object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Req Document</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Req Document</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReqDocument(ReqDocument object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Document Section</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Document Section</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDocumentSection(DocumentSection object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Req Specs</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Req Specs</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReqSpecs(ReqSpecs object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Folder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Folder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReqSpecFolder(ReqSpecFolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Goal Folder</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Goal Folder</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGoalFolder(GoalFolder object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Goal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Goal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGoal(Goal object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Requirement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Requirement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequirement(Requirement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Req Predicate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Req Predicate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseReqPredicate(ReqPredicate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Informal Predicate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Informal Predicate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInformalPredicate(InformalPredicate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>XPredicate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>XPredicate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXPredicate(XPredicate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>SPe AR Predicate</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>SPe AR Predicate</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSPeARPredicate(SPeARPredicate object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>External Document</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>External Document</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExternalDocument(ExternalDocument object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Quantification Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Quantification Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQuantificationExpr(QuantificationExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomain(Domain object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Quantified Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Quantified Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQuantifiedVariable(QuantifiedVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Forall Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Forall Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForallExpr(ForallExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exists Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exists Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExistsExpr(ExistsExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Sum Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Sum Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSumExpr(SumExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpr(Expr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableRef(VariableRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Function</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFunction(Function object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Call Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Call Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCallRef(CallRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Field Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Field Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordFieldExpr(RecordFieldExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Field</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Field</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordField(RecordField object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseType(Type object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Finite Set Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Finite Set Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFiniteSetType(FiniteSetType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayType(ArrayType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Sub Range Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Sub Range Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerSubRangeType(IntegerSubRangeType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumeration Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerationType(EnumerationType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enumerator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enumerator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumerator(Enumerator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeDef(TypeDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordType(RecordType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unit</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnit(Unit object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Scalar</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Scalar</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScalar(Scalar object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Unit</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Unit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedUnit(NamedUnit object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unit Def</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unit Def</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnitDef(UnitDef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Formula Ops</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Formula Ops</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFormulaOps(FormulaOps object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binary Op</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binary Op</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinaryOp(BinaryOp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiply</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiply</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiply(Multiply object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exponentiation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exponentiation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExponentiation(Exponentiation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Divide</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Divide</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDivide(Divide object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Plus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Plus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePlus(Plus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Minus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Minus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMinus(Minus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Modulus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Modulus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModulus(Modulus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Relational Op</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Relational Op</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRelationalOp(RelationalOp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Logical Op</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Logical Op</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLogicalOp(LogicalOp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Op</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Op</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryOp(UnaryOp object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Domain Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Domain Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDomainExpr(DomainExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Then Else Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Then Else Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfThenElseExpr(IfThenElseExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binary Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binary Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinaryExpr(BinaryExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryExpr(UnaryExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Pre Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Pre Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePreExpr(PreExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Access Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Access Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordAccessExpr(RecordAccessExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Access Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Access Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayAccessExpr(ArrayAccessExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Id Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Id Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIdExpr(IdExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Record Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Record Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRecordExpr(RecordExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Array Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Array Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArrayExpr(ArrayExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fn Call Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fn Call Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFnCallExpr(FnCallExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Bool Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Bool Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBoolExpr(BoolExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Int Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Int Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntExpr(IntExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Real Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Real Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRealExpr(RealExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Real Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Real Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRealType(RealType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerType(IntegerType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanType(BooleanType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Type</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Type</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedType(NamedType object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Quot Unit</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Quot Unit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseQuotUnit(QuotUnit object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Prod Unit</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Prod Unit</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseProdUnit(ProdUnit object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Always</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Always</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAlways(Always object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exists</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exists</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExists(Exists object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Responds</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Responds</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResponds(Responds object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Precedes</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Precedes</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrecedes(Precedes object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equal To</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equal To</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqualTo(EqualTo object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Not Equal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Not Equal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNotEqual(NotEqual object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Less Than</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Less Than</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLessThan(LessThan object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Greater Than</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Greater Than</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGreaterThan(GreaterThan object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Less Than Equal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Less Than Equal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLessThanEqual(LessThanEqual object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Greater Than Equal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Greater Than Equal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseGreaterThanEqual(GreaterThanEqual object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>And</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>And</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAnd(And object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Or</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Or</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOr(Or object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Xor</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Xor</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXor(Xor object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Implies</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Implies</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImplies(Implies object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unary Minus</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unary Minus</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnaryMinus(UnaryMinus object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Not</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Not</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNot(Not object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //ReqSpecSwitch
