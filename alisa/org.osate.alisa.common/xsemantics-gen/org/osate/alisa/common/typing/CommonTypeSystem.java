package org.osate.alisa.common.typing;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListType;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.ReferenceType;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.alisa.common.common.ABinaryOperation;
import org.osate.alisa.common.common.AConditional;
import org.osate.alisa.common.common.AExpression;
import org.osate.alisa.common.common.AFunctionCall;
import org.osate.alisa.common.common.AModelReference;
import org.osate.alisa.common.common.APropertyReference;
import org.osate.alisa.common.common.ARange;
import org.osate.alisa.common.common.AUnaryOperation;
import org.osate.alisa.common.common.AUnitExpression;
import org.osate.alisa.common.common.AVariableDeclaration;
import org.osate.alisa.common.common.AVariableReference;
import org.osate.alisa.common.common.CommonFactory;
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.ComputeDeclaration;
import org.osate.alisa.common.common.ModelRef;
import org.osate.alisa.common.common.Operation;
import org.osate.alisa.common.common.PropertyRef;
import org.osate.alisa.common.common.TypeRef;
import org.osate.alisa.common.common.ValDeclaration;

@SuppressWarnings("all")
public class CommonTypeSystem extends XsemanticsRuntimeSystem {
  public final static String COMBINENUMERIC = "org.osate.alisa.common.typing.CombineNumeric";
  
  public final static String VALDECLARATION = "org.osate.alisa.common.typing.ValDeclaration";
  
  public final static String COMPUTEDECLARATION = "org.osate.alisa.common.typing.ComputeDeclaration";
  
  public final static String PROPERTYREF = "org.osate.alisa.common.typing.PropertyRef";
  
  public final static String TYPEREF = "org.osate.alisa.common.typing.TypeRef";
  
  public final static String PROPERTYTYPE = "org.osate.alisa.common.typing.PropertyType";
  
  public final static String AEXPRESSION = "org.osate.alisa.common.typing.AExpression";
  
  public final static String ABINARYEXPRESSION = "org.osate.alisa.common.typing.ABinaryExpression";
  
  public final static String UNARYEXPRESSION = "org.osate.alisa.common.typing.UnaryExpression";
  
  public final static String AVARIABLEREFERENCE = "org.osate.alisa.common.typing.AVariableReference";
  
  public final static String RANGEEXPRESSION = "org.osate.alisa.common.typing.RangeExpression";
  
  public final static String IFEXPRESSION = "org.osate.alisa.common.typing.IfExpression";
  
  public final static String FUNCTIONCALL = "org.osate.alisa.common.typing.FunctionCall";
  
  public final static String UNITEXPRESSION = "org.osate.alisa.common.typing.UnitExpression";
  
  public final static String PROPERTYREFERENCE = "org.osate.alisa.common.typing.PropertyReference";
  
  public final static String MODELREFERENCE = "org.osate.alisa.common.typing.ModelReference";
  
  public final static String INTEGERLITERAL = "org.osate.alisa.common.typing.IntegerLiteral";
  
  public final static String REALLITERAL = "org.osate.alisa.common.typing.RealLiteral";
  
  public final static String BOOLEANLITERAL = "org.osate.alisa.common.typing.BooleanLiteral";
  
  public final static String STRINGLITERAL = "org.osate.alisa.common.typing.StringLiteral";
  
  public final static String SAMEBOOLEAN = "org.osate.alisa.common.typing.SameBoolean";
  
  public final static String SAMESTRING = "org.osate.alisa.common.typing.SameString";
  
  public final static String SAMEMODELREF = "org.osate.alisa.common.typing.SameModelRef";
  
  public final static String SAMEENUMERATION = "org.osate.alisa.common.typing.SameEnumeration";
  
  public final static String SAMENUMBER = "org.osate.alisa.common.typing.SameNumber";
  
  public final static String SAMERANGE = "org.osate.alisa.common.typing.SameRange";
  
  public final static String SAMELIST = "org.osate.alisa.common.typing.SameList";
  
  public final static String SAMERECORD = "org.osate.alisa.common.typing.SameRecord";
  
  public final static String SAMETYPELIST = "org.osate.alisa.common.typing.SameTypeList";
  
  public final static String EXPRESSIONASSIGNABLETOTYPE = "org.osate.alisa.common.typing.ExpressionAssignableToType";
  
  public final static String PRIMITIVESTRING = "org.osate.alisa.common.typing.PrimitiveString";
  
  public final static String PRIMITIVEBOOLEAN = "org.osate.alisa.common.typing.PrimitiveBoolean";
  
  public final static String PRIMITIVENUMBER = "org.osate.alisa.common.typing.PrimitiveNumber";
  
  public final static String MODELREF = "org.osate.alisa.common.typing.ModelRef";
  
  public final static String MODELREF1 = "org.osate.alisa.common.typing.ModelRef1";
  
  public final static String RANGE = "org.osate.alisa.common.typing.Range";
  
  public final static String NOTCOMPATIBLE = "org.osate.alisa.common.typing.NotCompatible";
  
  private PolymorphicDispatcher<NumberType> combineNumericDispatcher;
  
  private PolymorphicDispatcher<Result<PropertyType>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> assignableDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> compatibleDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> sameTypeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> sameTypesDispatcher;
  
  public CommonTypeSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    assignableDispatcher = buildPolymorphicDispatcher1(
    	"assignableImpl", 4, "|-", "|>");
    compatibleDispatcher = buildPolymorphicDispatcher1(
    	"compatibleImpl", 4, "|-", "<:");
    sameTypeDispatcher = buildPolymorphicDispatcher1(
    	"sameTypeImpl", 4, "|-", "~~");
    sameTypesDispatcher = buildPolymorphicDispatcher1(
    	"sameTypesImpl", 4, "|=", "~~");
    combineNumericDispatcher = buildPolymorphicDispatcher(
    	"combineNumericImpl", 3);
  }
  
  public NumberType combineNumeric(final NumberType left, final NumberType right) throws RuleFailedException {
    return combineNumeric(null, left, right);
  }
  
  public NumberType combineNumeric(final RuleApplicationTrace _trace_, final NumberType left, final NumberType right) throws RuleFailedException {
    try {
    	return combineNumericInternal(_trace_, left, right);
    } catch (Exception _e_combineNumeric) {
    	throw extractRuleFailedException(_e_combineNumeric);
    }
  }
  
  public Result<PropertyType> type(final EObject o) {
    return type(new RuleEnvironment(), null, o);
  }
  
  public Result<PropertyType> type(final RuleEnvironment _environment_, final EObject o) {
    return type(_environment_, null, o);
  }
  
  public Result<PropertyType> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return typeInternal(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  public Result<Boolean> assignable(final AExpression exp, final PropertyType target) {
    return assignable(new RuleEnvironment(), null, exp, target);
  }
  
  public Result<Boolean> assignable(final RuleEnvironment _environment_, final AExpression exp, final PropertyType target) {
    return assignable(_environment_, null, exp, target);
  }
  
  public Result<Boolean> assignable(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final AExpression exp, final PropertyType target) {
    try {
    	return assignableInternal(_environment_, _trace_, exp, target);
    } catch (Exception _e_assignable) {
    	return resultForFailure(_e_assignable);
    }
  }
  
  public Boolean assignableSucceeded(final AExpression exp, final PropertyType target) {
    return assignableSucceeded(new RuleEnvironment(), null, exp, target);
  }
  
  public Boolean assignableSucceeded(final RuleEnvironment _environment_, final AExpression exp, final PropertyType target) {
    return assignableSucceeded(_environment_, null, exp, target);
  }
  
  public Boolean assignableSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final AExpression exp, final PropertyType target) {
    try {
    	assignableInternal(_environment_, _trace_, exp, target);
    	return true;
    } catch (Exception _e_assignable) {
    	return false;
    }
  }
  
  public Result<Boolean> compatible(final PropertyType left, final PropertyType right) {
    return compatible(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Boolean> compatible(final RuleEnvironment _environment_, final PropertyType left, final PropertyType right) {
    return compatible(_environment_, null, left, right);
  }
  
  public Result<Boolean> compatible(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyType left, final PropertyType right) {
    try {
    	return compatibleInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_compatible) {
    	return resultForFailure(_e_compatible);
    }
  }
  
  public Boolean compatibleSucceeded(final PropertyType left, final PropertyType right) {
    return compatibleSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  public Boolean compatibleSucceeded(final RuleEnvironment _environment_, final PropertyType left, final PropertyType right) {
    return compatibleSucceeded(_environment_, null, left, right);
  }
  
  public Boolean compatibleSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyType left, final PropertyType right) {
    try {
    	compatibleInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_compatible) {
    	return false;
    }
  }
  
  public Result<Boolean> sameType(final PropertyType left, final PropertyType right) {
    return sameType(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Boolean> sameType(final RuleEnvironment _environment_, final PropertyType left, final PropertyType right) {
    return sameType(_environment_, null, left, right);
  }
  
  public Result<Boolean> sameType(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyType left, final PropertyType right) {
    try {
    	return sameTypeInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_sameType) {
    	return resultForFailure(_e_sameType);
    }
  }
  
  public Boolean sameTypeSucceeded(final PropertyType left, final PropertyType right) {
    return sameTypeSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  public Boolean sameTypeSucceeded(final RuleEnvironment _environment_, final PropertyType left, final PropertyType right) {
    return sameTypeSucceeded(_environment_, null, left, right);
  }
  
  public Boolean sameTypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyType left, final PropertyType right) {
    try {
    	sameTypeInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_sameType) {
    	return false;
    }
  }
  
  public Result<Boolean> sameTypes(final EList<BasicProperty> left, final EList<BasicProperty> right) {
    return sameTypes(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Boolean> sameTypes(final RuleEnvironment _environment_, final EList<BasicProperty> left, final EList<BasicProperty> right) {
    return sameTypes(_environment_, null, left, right);
  }
  
  public Result<Boolean> sameTypes(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EList<BasicProperty> left, final EList<BasicProperty> right) {
    try {
    	return sameTypesInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_sameTypes) {
    	return resultForFailure(_e_sameTypes);
    }
  }
  
  public Boolean sameTypesSucceeded(final EList<BasicProperty> left, final EList<BasicProperty> right) {
    return sameTypesSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  public Boolean sameTypesSucceeded(final RuleEnvironment _environment_, final EList<BasicProperty> left, final EList<BasicProperty> right) {
    return sameTypesSucceeded(_environment_, null, left, right);
  }
  
  public Boolean sameTypesSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EList<BasicProperty> left, final EList<BasicProperty> right) {
    try {
    	sameTypesInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_sameTypes) {
    	return false;
    }
  }
  
  public Result<Boolean> checkValDecls(final ValDeclaration valDecl) {
    return checkValDecls(null, valDecl);
  }
  
  public Result<Boolean> checkValDecls(final RuleApplicationTrace _trace_, final ValDeclaration valDecl) {
    try {
    	return checkValDeclsInternal(_trace_, valDecl);
    } catch (Exception _e_CheckValDecls) {
    	return resultForFailure(_e_CheckValDecls);
    }
  }
  
  protected Result<Boolean> checkValDeclsInternal(final RuleApplicationTrace _trace_, final ValDeclaration valDecl) throws RuleFailedException {
    /* empty |- valDecl.value : var PropertyType valueType */
    PropertyExpression _value = valDecl.getValue();
    PropertyType valueType = null;
    Result<PropertyType> result = typeInternal(emptyEnvironment(), _trace_, _value);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    valueType = (PropertyType) result.getFirst();
    
    PropertyType _type = valDecl.getType();
    boolean _notEquals = (!Objects.equal(_type, null));
    if (_notEquals) {
      /* empty |- valDecl : var PropertyType valType */
      PropertyType valType = null;
      Result<PropertyType> result_1 = typeInternal(emptyEnvironment(), _trace_, valDecl);
      checkAssignableTo(result_1.getFirst(), PropertyType.class);
      valType = (PropertyType) result_1.getFirst();
      
      /* empty |- valueType <: valType */
      compatibleInternal(emptyEnvironment(), _trace_, valueType, valType);
    }
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkExpressions(final AExpression exp) {
    return checkExpressions(null, exp);
  }
  
  public Result<Boolean> checkExpressions(final RuleApplicationTrace _trace_, final AExpression exp) {
    try {
    	return checkExpressionsInternal(_trace_, exp);
    } catch (Exception _e_CheckExpressions) {
    	return resultForFailure(_e_CheckExpressions);
    }
  }
  
  protected Result<Boolean> checkExpressionsInternal(final RuleApplicationTrace _trace_, final AExpression exp) throws RuleFailedException {
    return new Result<Boolean>(true);
  }
  
  protected NumberType combineNumericInternal(final RuleApplicationTrace _trace_, final NumberType left, final NumberType right) {
    try {
    	checkParamsNotNull(left, right);
    	return combineNumericDispatcher.invoke(_trace_, left, right);
    } catch (Exception _e_combineNumeric) {
    	sneakyThrowRuleFailedException(_e_combineNumeric);
    	return null;
    }
  }
  
  protected void combineNumericThrowException(final String _error, final String _issue, final Exception _ex, final NumberType left, final NumberType right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<PropertyType> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	checkParamsNotNull(o);
    	return typeDispatcher.invoke(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(o);
    String _plus = ("cannot type " + _stringRep);
    String error = _plus;
    EObject source = o;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  protected Result<Boolean> assignableInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final AExpression exp, final PropertyType target) {
    try {
    	checkParamsNotNull(exp, target);
    	return assignableDispatcher.invoke(_environment_, _trace_, exp, target);
    } catch (Exception _e_assignable) {
    	sneakyThrowRuleFailedException(_e_assignable);
    	return null;
    }
  }
  
  protected void assignableThrowException(final String _error, final String _issue, final Exception _ex, final AExpression exp, final PropertyType target, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(exp);
    String _plus = (_stringRep + " cannot be assigned to ");
    String _stringRep_1 = this.stringRep(target);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    EObject source = exp;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  protected Result<Boolean> compatibleInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyType left, final PropertyType right) {
    try {
    	checkParamsNotNull(left, right);
    	return compatibleDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_compatible) {
    	sneakyThrowRuleFailedException(_e_compatible);
    	return null;
    }
  }
  
  protected void compatibleThrowException(final String _error, final String _issue, final Exception _ex, final PropertyType left, final PropertyType right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(left);
    String _plus = (_stringRep + " is not compatible with ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_1 = (_plus + _stringRep_1);
    String error = _plus_1;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(null, null));
  }
  
  protected Result<Boolean> sameTypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyType left, final PropertyType right) {
    try {
    	checkParamsNotNull(left, right);
    	return sameTypeDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_sameType) {
    	sneakyThrowRuleFailedException(_e_sameType);
    	return null;
    }
  }
  
  protected void sameTypeThrowException(final String _error, final String _issue, final Exception _ex, final PropertyType left, final PropertyType right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Boolean> sameTypesInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EList<BasicProperty> left, final EList<BasicProperty> right) {
    try {
    	checkParamsNotNull(left, right);
    	return sameTypesDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_sameTypes) {
    	sneakyThrowRuleFailedException(_e_sameTypes);
    	return null;
    }
  }
  
  protected void sameTypesThrowException(final String _error, final String _issue, final Exception _ex, final EList<BasicProperty> left, final EList<BasicProperty> right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected NumberType combineNumericImpl(final RuleApplicationTrace _trace_, final NumberType left, final NumberType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final NumberType _result_ = applyAuxFunCombineNumeric(_subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("combineNumeric") + "(" + stringRep(left) + ", " + stringRep(right)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunCombineNumeric) {
    	combineNumericThrowException(auxFunName("combineNumeric") + "(" + stringRep(left) + ", " + stringRep(right)+ ")",
    		COMBINENUMERIC,
    		e_applyAuxFunCombineNumeric, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected NumberType applyAuxFunCombineNumeric(final RuleApplicationTrace _trace_, final NumberType left, final NumberType right) throws RuleFailedException {
    NumberType _xblockexpression = null;
    {
      NumberType _xifexpression = null;
      boolean _and = false;
      if (!(left instanceof AadlInteger)) {
        _and = false;
      } else {
        _and = (right instanceof AadlInteger);
      }
      if (_and) {
        _xifexpression = Aadl2Factory.eINSTANCE.createAadlInteger();
      } else {
        _xifexpression = Aadl2Factory.eINSTANCE.createAadlReal();
      }
      final NumberType result = _xifexpression;
      UnitsType _xifexpression_1 = null;
      UnitsType _unitsType = left.getUnitsType();
      boolean _notEquals = (!Objects.equal(_unitsType, null));
      if (_notEquals) {
        _xifexpression_1 = left.getUnitsType();
      } else {
        _xifexpression_1 = right.getUnitsType();
      }
      result.setReferencedUnitsType(_xifexpression_1);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ValDeclaration valDecl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleValDeclaration(G, _subtrace_, valDecl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ValDeclaration") + stringRepForEnv(G) + " |- " + stringRep(valDecl) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleValDeclaration) {
    	typeThrowException(ruleName("ValDeclaration") + stringRepForEnv(G) + " |- " + stringRep(valDecl) + " : " + "PropertyType",
    		VALDECLARATION,
    		e_applyRuleValDeclaration, valDecl, new ErrorInformation[] {new ErrorInformation(valDecl)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleValDeclaration(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ValDeclaration valDecl) throws RuleFailedException {
    PropertyType type = null; // output parameter
    final PropertyType declared = valDecl.getType();
    /* { declared != null G |- declared : type } or { G |- valDecl.value : type } */
    {
      RuleFailedException previousFailure = null;
      try {
        boolean _notEquals = (!Objects.equal(declared, null));
        /* declared != null */
        if (!_notEquals) {
          sneakyThrowRuleFailedException("declared != null");
        }
        /* G |- declared : type */
        Result<PropertyType> result = typeInternal(G, _trace_, declared);
        checkAssignableTo(result.getFirst(), PropertyType.class);
        type = (PropertyType) result.getFirst();
        
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* G |- valDecl.value : type */
        PropertyExpression _value = valDecl.getValue();
        Result<PropertyType> result_1 = typeInternal(G, _trace_, _value);
        checkAssignableTo(result_1.getFirst(), PropertyType.class);
        type = (PropertyType) result_1.getFirst();
        
      }
    }
    return new Result<PropertyType>(type);
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ComputeDeclaration valDecl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleComputeDeclaration(G, _subtrace_, valDecl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ComputeDeclaration") + stringRepForEnv(G) + " |- " + stringRep(valDecl) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleComputeDeclaration) {
    	typeThrowException(ruleName("ComputeDeclaration") + stringRepForEnv(G) + " |- " + stringRep(valDecl) + " : " + "PropertyType",
    		COMPUTEDECLARATION,
    		e_applyRuleComputeDeclaration, valDecl, new ErrorInformation[] {new ErrorInformation(valDecl)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleComputeDeclaration(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ComputeDeclaration valDecl) throws RuleFailedException {
    PropertyType type = null; // output parameter
    final PropertyType declared = valDecl.getType();
    boolean _notEquals = (!Objects.equal(declared, null));
    /* declared != null */
    if (!_notEquals) {
      sneakyThrowRuleFailedException("declared != null");
    }
    /* G |- declared : type */
    Result<PropertyType> result = typeInternal(G, _trace_, declared);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    type = (PropertyType) result.getFirst();
    
    return new Result<PropertyType>(type);
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyRef propRef) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRulePropertyRef(G, _subtrace_, propRef);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("PropertyRef") + stringRepForEnv(G) + " |- " + stringRep(propRef) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePropertyRef) {
    	typeThrowException(ruleName("PropertyRef") + stringRepForEnv(G) + " |- " + stringRep(propRef) + " : " + "PropertyType",
    		PROPERTYREF,
    		e_applyRulePropertyRef, propRef, new ErrorInformation[] {new ErrorInformation(propRef)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRulePropertyRef(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyRef propRef) throws RuleFailedException {
    
    return new Result<PropertyType>(_applyRulePropertyRef_1(G, propRef));
  }
  
  private PropertyType _applyRulePropertyRef_1(final RuleEnvironment G, final PropertyRef propRef) throws RuleFailedException {
    Property _ref = propRef.getRef();
    PropertyType _propertyType = _ref.getPropertyType();
    return _propertyType;
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeRef typeRef) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleTypeRef(G, _subtrace_, typeRef);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TypeRef") + stringRepForEnv(G) + " |- " + stringRep(typeRef) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTypeRef) {
    	typeThrowException(ruleName("TypeRef") + stringRepForEnv(G) + " |- " + stringRep(typeRef) + " : " + "PropertyType",
    		TYPEREF,
    		e_applyRuleTypeRef, typeRef, new ErrorInformation[] {new ErrorInformation(typeRef)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleTypeRef(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeRef typeRef) throws RuleFailedException {
    
    return new Result<PropertyType>(_applyRuleTypeRef_1(G, typeRef));
  }
  
  private PropertyType _applyRuleTypeRef_1(final RuleEnvironment G, final TypeRef typeRef) throws RuleFailedException {
    PropertyType _ref = typeRef.getRef();
    return _ref;
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyType propType) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRulePropertyType(G, _subtrace_, propType);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("PropertyType") + stringRepForEnv(G) + " |- " + stringRep(propType) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePropertyType) {
    	typeThrowException(ruleName("PropertyType") + stringRepForEnv(G) + " |- " + stringRep(propType) + " : " + "PropertyType",
    		PROPERTYTYPE,
    		e_applyRulePropertyType, propType, new ErrorInformation[] {new ErrorInformation(propType)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRulePropertyType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyType propType) throws RuleFailedException {
    
    return new Result<PropertyType>(_applyRulePropertyType_1(G, propType));
  }
  
  private PropertyType _applyRulePropertyType_1(final RuleEnvironment G, final PropertyType propType) throws RuleFailedException {
    return propType;
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyExpression param) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleAExpression(G, _subtrace_, param);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AExpression") + stringRepForEnv(G) + " |- " + stringRep(param) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAExpression) {
    	aExpressionThrowException(e_applyRuleAExpression, param);
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleAExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyExpression param) throws RuleFailedException {
    PropertyType type = null; // output parameter
    /* fail */
    throwForExplicitFail();
    return new Result<PropertyType>(type);
  }
  
  private void aExpressionThrowException(final Exception e_applyRuleAExpression, final PropertyExpression param) throws RuleFailedException {
    String _stringRep = this.stringRep(param);
    String _plus = ("typing: unhandled case" + _stringRep);
    String error = _plus;
    EObject source = param;
    throwRuleFailedException(error,
    	AEXPRESSION, e_applyRuleAExpression, new ErrorInformation(source, null));
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ABinaryOperation binary) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleABinaryExpression(G, _subtrace_, binary);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ABinaryExpression") + stringRepForEnv(G) + " |- " + stringRep(binary) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleABinaryExpression) {
    	typeThrowException(ruleName("ABinaryExpression") + stringRepForEnv(G) + " |- " + stringRep(binary) + " : " + "PropertyType",
    		ABINARYEXPRESSION,
    		e_applyRuleABinaryExpression, binary, new ErrorInformation[] {new ErrorInformation(binary)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleABinaryExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ABinaryOperation binary) throws RuleFailedException {
    PropertyType type = null; // output parameter
    /* G |- binary.left : var PropertyType leftType */
    PropertyExpression _left = binary.getLeft();
    PropertyType leftType = null;
    Result<PropertyType> result = typeInternal(G, _trace_, _left);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    leftType = (PropertyType) result.getFirst();
    
    /* G |- binary.right : var PropertyType rightType */
    PropertyExpression _right = binary.getRight();
    PropertyType rightType = null;
    Result<PropertyType> result_1 = typeInternal(G, _trace_, _right);
    checkAssignableTo(result_1.getFirst(), PropertyType.class);
    rightType = (PropertyType) result_1.getFirst();
    
    final Operation op = binary.getOperator();
    if (op != null) {
      switch (op) {
        case OR:
        case AND:
          if ((!(leftType instanceof AadlBoolean))) {
            /* fail error 'typing: operand must be boolean' source binary.left */
            String error = "typing: operand must be boolean";
            PropertyExpression _left_1 = binary.getLeft();
            EObject source = _left_1;
            throwForExplicitFail(error, new ErrorInformation(source, null));
          }
          if ((!(rightType instanceof AadlBoolean))) {
            /* fail error 'typing: operand must be boolean' source binary.right */
            String error_1 = "typing: operand must be boolean";
            PropertyExpression _right_1 = binary.getRight();
            EObject source_1 = _right_1;
            throwForExplicitFail(error_1, new ErrorInformation(source_1, null));
          }
          AadlBoolean _createAadlBoolean = Aadl2Factory.eINSTANCE.createAadlBoolean();
          type = _createAadlBoolean;
          break;
        case EQ:
        case NEQ:
          try {
            /* G |- leftType ~~ rightType */
            sameTypeInternal(G, _trace_, leftType, rightType);
          } catch (final Throwable _t) {
            if (_t instanceof RuleFailedException) {
              final RuleFailedException e = (RuleFailedException)_t;
              /* fail error 'typing: cannot compare ' + stringRep(leftType) + ' and ' + stringRep(rightType) source binary */
              String _stringRep = this.stringRep(leftType);
              String _plus = ("typing: cannot compare " + _stringRep);
              String _plus_1 = (_plus + " and ");
              String _stringRep_1 = this.stringRep(rightType);
              String _plus_2 = (_plus_1 + _stringRep_1);
              String error_2 = _plus_2;
              EObject source_2 = binary;
              throwForExplicitFail(error_2, new ErrorInformation(source_2, null));
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          AadlBoolean _createAadlBoolean_1 = Aadl2Factory.eINSTANCE.createAadlBoolean();
          type = _createAadlBoolean_1;
          break;
        case LT:
        case LEQ:
        case GT:
        case GEQ:
        case IN:
        case PLUS:
        case MINUS:
        case MULT:
        case DIV:
          if ((!((leftType instanceof NumberType) || (leftType instanceof RangeType)))) {
            /* fail error 'typing: operand must be numeric or a range' source binary.left */
            String error_3 = "typing: operand must be numeric or a range";
            PropertyExpression _left_2 = binary.getLeft();
            EObject source_3 = _left_2;
            throwForExplicitFail(error_3, new ErrorInformation(source_3, null));
          }
          if ((!((rightType instanceof NumberType) || (rightType instanceof RangeType)))) {
            /* fail error 'typing: operand must be numeric or a range' source binary.right */
            String error_4 = "typing: operand must be numeric or a range";
            PropertyExpression _right_2 = binary.getRight();
            EObject source_4 = _right_2;
            throwForExplicitFail(error_4, new ErrorInformation(source_4, null));
          }
          boolean _equals = Objects.equal(op, Operation.IN);
          if (_equals) {
            if ((!(rightType instanceof RangeType))) {
              /* fail error 'typing: operand must be a range' source binary.right */
              String error_5 = "typing: operand must be a range";
              PropertyExpression _right_3 = binary.getRight();
              EObject source_5 = _right_3;
              throwForExplicitFail(error_5, new ErrorInformation(source_5, null));
            }
          }
          NumberType _xifexpression = null;
          if ((leftType instanceof RangeType)) {
            _xifexpression = ((RangeType)leftType).getNumberType();
          } else {
            _xifexpression = ((NumberType) leftType);
          }
          final NumberType leftNum = _xifexpression;
          NumberType _xifexpression_1 = null;
          if ((rightType instanceof RangeType)) {
            _xifexpression_1 = ((RangeType)rightType).getNumberType();
          } else {
            _xifexpression_1 = ((NumberType) rightType);
          }
          final NumberType rightNum = _xifexpression_1;
          if (op != null) {
            switch (op) {
              case LT:
              case LEQ:
              case GT:
              case GEQ:
              case IN:
                try {
                  /* G |- leftNum ~~ rightNum */
                  sameTypeInternal(G, _trace_, leftNum, rightNum);
                } catch (final Throwable _t_1) {
                  if (_t_1 instanceof RuleFailedException) {
                    final RuleFailedException e_1 = (RuleFailedException)_t_1;
                    /* fail error 'typing: arguments have different unit types' source binary */
                    String error_6 = "typing: arguments have different unit types";
                    EObject source_6 = binary;
                    throwForExplicitFail(error_6, new ErrorInformation(source_6, null));
                  } else {
                    throw Exceptions.sneakyThrow(_t_1);
                  }
                }
                AadlBoolean _createAadlBoolean_2 = Aadl2Factory.eINSTANCE.createAadlBoolean();
                type = _createAadlBoolean_2;
                break;
              case PLUS:
              case MINUS:
                try {
                  /* G |- leftNum ~~ rightNum */
                  sameTypeInternal(G, _trace_, leftNum, rightNum);
                } catch (final Throwable _t_2) {
                  if (_t_2 instanceof RuleFailedException) {
                    final RuleFailedException e_2 = (RuleFailedException)_t_2;
                    /* fail error 'typing: arguments have different unit types' source binary */
                    String error_7 = "typing: arguments have different unit types";
                    EObject source_7 = binary;
                    throwForExplicitFail(error_7, new ErrorInformation(source_7, null));
                  } else {
                    throw Exceptions.sneakyThrow(_t_2);
                  }
                }
                NumberType _combineNumeric = this.combineNumericInternal(_trace_, leftNum, rightNum);
                type = _combineNumeric;
                break;
              case MULT:
                boolean _and = false;
                UnitsType _unitsType = leftNum.getUnitsType();
                boolean _notEquals = (!Objects.equal(_unitsType, null));
                if (!_notEquals) {
                  _and = false;
                } else {
                  UnitsType _unitsType_1 = rightNum.getUnitsType();
                  boolean _notEquals_1 = (!Objects.equal(_unitsType_1, null));
                  _and = _notEquals_1;
                }
                if (_and) {
                  /* fail error 'typing: only one operand may have a unit' source binary */
                  String error_8 = "typing: only one operand may have a unit";
                  EObject source_8 = binary;
                  throwForExplicitFail(error_8, new ErrorInformation(source_8, null));
                }
                NumberType _combineNumeric_1 = this.combineNumericInternal(_trace_, leftNum, rightNum);
                type = _combineNumeric_1;
                break;
              case DIV:
                final AadlReal t = Aadl2Factory.eINSTANCE.createAadlReal();
                boolean _and_1 = false;
                UnitsType _unitsType_2 = leftNum.getUnitsType();
                boolean _notEquals_2 = (!Objects.equal(_unitsType_2, null));
                if (!_notEquals_2) {
                  _and_1 = false;
                } else {
                  UnitsType _unitsType_3 = rightNum.getUnitsType();
                  boolean _notEquals_3 = (!Objects.equal(_unitsType_3, null));
                  _and_1 = _notEquals_3;
                }
                if (_and_1) {
                  try {
                    /* G |- leftNum ~~ rightNum */
                    sameTypeInternal(G, _trace_, leftNum, rightNum);
                  } catch (final Throwable _t_3) {
                    if (_t_3 instanceof RuleFailedException) {
                      final RuleFailedException e_3 = (RuleFailedException)_t_3;
                      /* fail error 'typing: arguments have different unit types' source binary */
                      String error_9 = "typing: arguments have different unit types";
                      EObject source_9 = binary;
                      throwForExplicitFail(error_9, new ErrorInformation(source_9, null));
                    } else {
                      throw Exceptions.sneakyThrow(_t_3);
                    }
                  }
                } else {
                  UnitsType _unitsType_4 = rightNum.getUnitsType();
                  boolean _notEquals_4 = (!Objects.equal(_unitsType_4, null));
                  if (_notEquals_4) {
                    /* fail error 'typing: argument must have a unit when dividing by a number with unit' source binary.left */
                    String error_10 = "typing: argument must have a unit when dividing by a number with unit";
                    PropertyExpression _left_3 = binary.getLeft();
                    EObject source_10 = _left_3;
                    throwForExplicitFail(error_10, new ErrorInformation(source_10, null));
                  } else {
                    UnitsType _unitsType_5 = leftNum.getUnitsType();
                    t.setReferencedUnitsType(_unitsType_5);
                  }
                }
                type = t;
                break;
              default:
                /* fail error 'typing: unhandled binary operator encountered' source binary */
                String error_11 = "typing: unhandled binary operator encountered";
                EObject source_11 = binary;
                throwForExplicitFail(error_11, new ErrorInformation(source_11, null));
                break;
            }
          } else {
            /* fail error 'typing: unhandled binary operator encountered' source binary */
            String error_11 = "typing: unhandled binary operator encountered";
            EObject source_11 = binary;
            throwForExplicitFail(error_11, new ErrorInformation(source_11, null));
          }
          break;
        case INTDIV:
        case MOD:
          if ((!(leftType instanceof AadlInteger))) {
            /* fail error 'typing: argument must be an integer' source binary.left */
            String error_12 = "typing: argument must be an integer";
            PropertyExpression _left_4 = binary.getLeft();
            EObject source_12 = _left_4;
            throwForExplicitFail(error_12, new ErrorInformation(source_12, null));
          } else {
            if ((!(rightType instanceof AadlInteger))) {
              /* fail error 'typing: argument must be an integer' source binary.right */
              String error_13 = "typing: argument must be an integer";
              PropertyExpression _right_4 = binary.getRight();
              EObject source_13 = _right_4;
              throwForExplicitFail(error_13, new ErrorInformation(source_13, null));
            }
          }
          final NumberType leftNum_1 = ((NumberType) leftType);
          final NumberType rightNum_1 = ((NumberType) rightType);
          final AadlInteger t_1 = Aadl2Factory.eINSTANCE.createAadlInteger();
          boolean _and_2 = false;
          UnitsType _unitsType_6 = leftNum_1.getUnitsType();
          boolean _notEquals_5 = (!Objects.equal(_unitsType_6, null));
          if (!_notEquals_5) {
            _and_2 = false;
          } else {
            UnitsType _unitsType_7 = rightNum_1.getUnitsType();
            boolean _notEquals_6 = (!Objects.equal(_unitsType_7, null));
            _and_2 = _notEquals_6;
          }
          if (_and_2) {
            try {
              /* G |- leftNum ~~ rightNum */
              sameTypeInternal(G, _trace_, leftNum_1, rightNum_1);
            } catch (final Throwable _t_4) {
              if (_t_4 instanceof RuleFailedException) {
                final RuleFailedException e_4 = (RuleFailedException)_t_4;
                /* fail error 'typing: arguments have different unit types' source binary */
                String error_14 = "typing: arguments have different unit types";
                EObject source_14 = binary;
                throwForExplicitFail(error_14, new ErrorInformation(source_14, null));
              } else {
                throw Exceptions.sneakyThrow(_t_4);
              }
            }
          } else {
            UnitsType _unitsType_8 = rightNum_1.getUnitsType();
            boolean _notEquals_7 = (!Objects.equal(_unitsType_8, null));
            if (_notEquals_7) {
              /* fail error 'typing: argument must have a unit when dividing by a number with unit' source binary.left */
              String error_15 = "typing: argument must have a unit when dividing by a number with unit";
              PropertyExpression _left_5 = binary.getLeft();
              EObject source_15 = _left_5;
              throwForExplicitFail(error_15, new ErrorInformation(source_15, null));
            } else {
              UnitsType _unitsType_9 = leftNum_1.getUnitsType();
              t_1.setReferencedUnitsType(_unitsType_9);
            }
          }
          type = t_1;
          break;
        default:
          /* fail error 'typing: unhandled binary operator encountered' source binary */
          String error_16 = "typing: unhandled binary operator encountered";
          EObject source_16 = binary;
          throwForExplicitFail(error_16, new ErrorInformation(source_16, null));
          break;
      }
    } else {
      /* fail error 'typing: unhandled binary operator encountered' source binary */
      String error_16 = "typing: unhandled binary operator encountered";
      EObject source_16 = binary;
      throwForExplicitFail(error_16, new ErrorInformation(source_16, null));
    }
    return new Result<PropertyType>(type);
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AUnaryOperation unary) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleUnaryExpression(G, _subtrace_, unary);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("UnaryExpression") + stringRepForEnv(G) + " |- " + stringRep(unary) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnaryExpression) {
    	typeThrowException(ruleName("UnaryExpression") + stringRepForEnv(G) + " |- " + stringRep(unary) + " : " + "PropertyType",
    		UNARYEXPRESSION,
    		e_applyRuleUnaryExpression, unary, new ErrorInformation[] {new ErrorInformation(unary)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleUnaryExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AUnaryOperation unary) throws RuleFailedException {
    PropertyType type = null; // output parameter
    /* G |- unary.operand : var PropertyType opType */
    PropertyExpression _operand = unary.getOperand();
    PropertyType opType = null;
    Result<PropertyType> result = typeInternal(G, _trace_, _operand);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    opType = (PropertyType) result.getFirst();
    
    Operation _operator = unary.getOperator();
    if (_operator != null) {
      switch (_operator) {
        case PLUS:
        case MINUS:
          if ((opType instanceof NumberType)) {
            type = opType;
          } else {
            /* fail error 'typing: operand is not numeric' source unary */
            String error = "typing: operand is not numeric";
            EObject source = unary;
            throwForExplicitFail(error, new ErrorInformation(source, null));
          }
          break;
        case NOT:
          AadlBoolean _createAadlBoolean = Aadl2Factory.eINSTANCE.createAadlBoolean();
          type = _createAadlBoolean;
          break;
        default:
          /* fail error 'typing: unhandled unary operator encountered' source unary */
          String error_1 = "typing: unhandled unary operator encountered";
          EObject source_1 = unary;
          throwForExplicitFail(error_1, new ErrorInformation(source_1, null));
          break;
      }
    } else {
      /* fail error 'typing: unhandled unary operator encountered' source unary */
      String error_1 = "typing: unhandled unary operator encountered";
      EObject source_1 = unary;
      throwForExplicitFail(error_1, new ErrorInformation(source_1, null));
    }
    return new Result<PropertyType>(type);
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AVariableReference vRef) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleAVariableReference(G, _subtrace_, vRef);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AVariableReference") + stringRepForEnv(G) + " |- " + stringRep(vRef) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAVariableReference) {
    	typeThrowException(ruleName("AVariableReference") + stringRepForEnv(G) + " |- " + stringRep(vRef) + " : " + "PropertyType",
    		AVARIABLEREFERENCE,
    		e_applyRuleAVariableReference, vRef, new ErrorInformation[] {new ErrorInformation(vRef)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleAVariableReference(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AVariableReference vRef) throws RuleFailedException {
    PropertyType type = null; // output parameter
    /* G |- vRef.variable : type */
    AVariableDeclaration _variable = vRef.getVariable();
    Result<PropertyType> result = typeInternal(G, _trace_, _variable);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    type = (PropertyType) result.getFirst();
    
    return new Result<PropertyType>(type);
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ARange rangeExp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleRangeExpression(G, _subtrace_, rangeExp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("RangeExpression") + stringRepForEnv(G) + " |- " + stringRep(rangeExp) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleRangeExpression) {
    	typeThrowException(ruleName("RangeExpression") + stringRepForEnv(G) + " |- " + stringRep(rangeExp) + " : " + "PropertyType",
    		RANGEEXPRESSION,
    		e_applyRuleRangeExpression, rangeExp, new ErrorInformation[] {new ErrorInformation(rangeExp)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleRangeExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ARange rangeExp) throws RuleFailedException {
    PropertyType type = null; // output parameter
    /* G |- rangeExp.minimum : var PropertyType minType */
    PropertyExpression _minimum = rangeExp.getMinimum();
    PropertyType minType = null;
    Result<PropertyType> result = typeInternal(G, _trace_, _minimum);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    minType = (PropertyType) result.getFirst();
    
    /* G |- rangeExp.maximum : var PropertyType maxType */
    PropertyExpression _maximum = rangeExp.getMaximum();
    PropertyType maxType = null;
    Result<PropertyType> result_1 = typeInternal(G, _trace_, _maximum);
    checkAssignableTo(result_1.getFirst(), PropertyType.class);
    maxType = (PropertyType) result_1.getFirst();
    
    if ((!(minType instanceof NumberType))) {
      /* fail error 'typing: lower bound must be numeric' source rangeExp.minimum */
      String error = "typing: lower bound must be numeric";
      PropertyExpression _minimum_1 = rangeExp.getMinimum();
      EObject source = _minimum_1;
      throwForExplicitFail(error, new ErrorInformation(source, null));
    }
    if ((!(maxType instanceof NumberType))) {
      /* fail error 'typing: upper bound must be numeric' source rangeExp.maximum */
      String error_1 = "typing: upper bound must be numeric";
      PropertyExpression _maximum_1 = rangeExp.getMaximum();
      EObject source_1 = _maximum_1;
      throwForExplicitFail(error_1, new ErrorInformation(source_1, null));
    }
    try {
      /* G |- minType ~~ maxType */
      sameTypeInternal(G, _trace_, minType, maxType);
    } catch (final Throwable _t) {
      if (_t instanceof RuleFailedException) {
        final RuleFailedException e = (RuleFailedException)_t;
        /* fail error "typing: lower and upper bound have different units" source rangeExp */
        String error_2 = "typing: lower and upper bound have different units";
        EObject source_2 = rangeExp;
        throwForExplicitFail(error_2, new ErrorInformation(source_2, null));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    final RangeType range = Aadl2Factory.eINSTANCE.createRangeType();
    boolean _or = false;
    if ((minType instanceof AadlReal)) {
      _or = true;
    } else {
      _or = (maxType instanceof AadlReal);
    }
    if (_or) {
      EClass _aadlReal = Aadl2Package.eINSTANCE.getAadlReal();
      range.createOwnedNumberType(_aadlReal);
    } else {
      EClass _aadlInteger = Aadl2Package.eINSTANCE.getAadlInteger();
      range.createOwnedNumberType(_aadlInteger);
    }
    NumberType _numberType = range.getNumberType();
    UnitsType _unitsType = ((NumberType) minType).getUnitsType();
    _numberType.setReferencedUnitsType(_unitsType);
    type = range;
    return new Result<PropertyType>(type);
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AConditional ifExp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleIfExpression(G, _subtrace_, ifExp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("IfExpression") + stringRepForEnv(G) + " |- " + stringRep(ifExp) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleIfExpression) {
    	typeThrowException(ruleName("IfExpression") + stringRepForEnv(G) + " |- " + stringRep(ifExp) + " : " + "PropertyType",
    		IFEXPRESSION,
    		e_applyRuleIfExpression, ifExp, new ErrorInformation[] {new ErrorInformation(ifExp)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleIfExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AConditional ifExp) throws RuleFailedException {
    PropertyType type = null; // output parameter
    /* G |- ifExp.^if : var PropertyType ifType */
    PropertyExpression _if = ifExp.getIf();
    PropertyType ifType = null;
    Result<PropertyType> result = typeInternal(G, _trace_, _if);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    ifType = (PropertyType) result.getFirst();
    
    /* G |- ifExp.^then : var PropertyType thenType */
    PropertyExpression _then = ifExp.getThen();
    PropertyType thenType = null;
    Result<PropertyType> result_1 = typeInternal(G, _trace_, _then);
    checkAssignableTo(result_1.getFirst(), PropertyType.class);
    thenType = (PropertyType) result_1.getFirst();
    
    /* G |- ifExp.^else : var PropertyType elseType */
    PropertyExpression _else = ifExp.getElse();
    PropertyType elseType = null;
    Result<PropertyType> result_2 = typeInternal(G, _trace_, _else);
    checkAssignableTo(result_2.getFirst(), PropertyType.class);
    elseType = (PropertyType) result_2.getFirst();
    
    if ((!(ifType instanceof AadlBoolean))) {
      /* fail error 'typing: condition must be boolean' source ifExp.^if */
      String error = "typing: condition must be boolean";
      PropertyExpression _if_1 = ifExp.getIf();
      EObject source = _if_1;
      throwForExplicitFail(error, new ErrorInformation(source, null));
    }
    try {
      /* G |- thenType ~~ elseType */
      sameTypeInternal(G, _trace_, thenType, elseType);
    } catch (final Throwable _t) {
      if (_t instanceof RuleFailedException) {
        final RuleFailedException e = (RuleFailedException)_t;
        /* fail error 'typing: then and else part must have the same type' source ifExp */
        String error_1 = "typing: then and else part must have the same type";
        EObject source_1 = ifExp;
        throwForExplicitFail(error_1, new ErrorInformation(source_1, null));
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    if ((thenType instanceof NumberType)) {
      NumberType _combineNumeric = this.combineNumericInternal(_trace_, ((NumberType)thenType), ((NumberType) elseType));
      type = _combineNumeric;
    } else {
      type = thenType;
    }
    return new Result<PropertyType>(type);
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AFunctionCall _) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleFunctionCall(G, _subtrace_, _);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("FunctionCall") + stringRepForEnv(G) + " |- " + stringRep(_) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleFunctionCall) {
    	functionCallThrowException(e_applyRuleFunctionCall, _);
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleFunctionCall(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AFunctionCall _) throws RuleFailedException {
    PropertyType type = null; // output parameter
    /* fail */
    throwForExplicitFail();
    return new Result<PropertyType>(type);
  }
  
  private void functionCallThrowException(final Exception e_applyRuleFunctionCall, final AFunctionCall _) throws RuleFailedException {
    String error = "typing of built-in functions not implemented";
    throwRuleFailedException(error,
    	FUNCTIONCALL, e_applyRuleFunctionCall, new ErrorInformation(null, null));
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AUnitExpression unitExp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleUnitExpression(G, _subtrace_, unitExp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("UnitExpression") + stringRepForEnv(G) + " |- " + stringRep(unitExp) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnitExpression) {
    	typeThrowException(ruleName("UnitExpression") + stringRepForEnv(G) + " |- " + stringRep(unitExp) + " : " + "PropertyType",
    		UNITEXPRESSION,
    		e_applyRuleUnitExpression, unitExp, new ErrorInformation[] {new ErrorInformation(unitExp)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleUnitExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AUnitExpression unitExp) throws RuleFailedException {
    PropertyType type = null; // output parameter
    /* G |- unitExp.expression : var PropertyType expType */
    PropertyExpression _expression = unitExp.getExpression();
    PropertyType expType = null;
    Result<PropertyType> result = typeInternal(G, _trace_, _expression);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    expType = (PropertyType) result.getFirst();
    
    UnitLiteral _unit = unitExp.getUnit();
    boolean _equals = Objects.equal(_unit, null);
    if (_equals) {
      type = expType;
    } else {
      boolean _or = false;
      boolean _isConvert = unitExp.isConvert();
      if (_isConvert) {
        _or = true;
      } else {
        boolean _isDrop = unitExp.isDrop();
        _or = _isDrop;
      }
      if (_or) {
        UnitLiteral _unit_1 = unitExp.getUnit();
        EObject _eContainer = _unit_1.eContainer();
        final UnitsType targetType = ((UnitsType) _eContainer);
        if ((expType instanceof NumberType)) {
          UnitsType _unitsType = ((NumberType)expType).getUnitsType();
          boolean _equals_1 = Objects.equal(_unitsType, null);
          if (_equals_1) {
            /* fail error 'typing: expression has no unit' source unitExp.expression */
            String error = "typing: expression has no unit";
            PropertyExpression _expression_1 = unitExp.getExpression();
            EObject source = _expression_1;
            throwForExplicitFail(error, new ErrorInformation(source, null));
          }
          try {
            /* G |- expType.unitsType ~~ targetType */
            UnitsType _unitsType_1 = ((NumberType)expType).getUnitsType();
            sameTypeInternal(G, _trace_, _unitsType_1, targetType);
          } catch (final Throwable _t) {
            if (_t instanceof RuleFailedException) {
              final RuleFailedException e = (RuleFailedException)_t;
              /* fail error 'typing: cannot convert ' + stringRep(expType) + ' to ' + stringRep(targetType) source CommonPackage.eINSTANCE.AUnitExpression_Convert */
              String _stringRep = this.stringRep(expType);
              String _plus = ("typing: cannot convert " + _stringRep);
              String _plus_1 = (_plus + " to ");
              String _stringRep_1 = this.stringRep(targetType);
              String _plus_2 = (_plus_1 + _stringRep_1);
              String error_1 = _plus_2;
              EAttribute _aUnitExpression_Convert = CommonPackage.eINSTANCE.getAUnitExpression_Convert();
              EObject source_1 = _aUnitExpression_Convert;
              throwForExplicitFail(error_1, new ErrorInformation(source_1, null));
            } else {
              throw Exceptions.sneakyThrow(_t);
            }
          }
          NumberType _xifexpression = null;
          if ((expType instanceof AadlInteger)) {
            _xifexpression = Aadl2Factory.eINSTANCE.createAadlInteger();
          } else {
            _xifexpression = Aadl2Factory.eINSTANCE.createAadlReal();
          }
          final NumberType result_1 = _xifexpression;
          boolean _isConvert_1 = unitExp.isConvert();
          if (_isConvert_1) {
            UnitLiteral _unit_2 = unitExp.getUnit();
            EObject _eContainer_1 = _unit_2.eContainer();
            result_1.setReferencedUnitsType(((UnitsType) _eContainer_1));
          }
          type = result_1;
        } else {
          /* fail error 'typing: can only convert unit of a numeric type' source unitExp feature CommonPackage.eINSTANCE.AUnitExpression_Convert */
          String error_2 = "typing: can only convert unit of a numeric type";
          EObject source_2 = unitExp;
          EAttribute _aUnitExpression_Convert_1 = CommonPackage.eINSTANCE.getAUnitExpression_Convert();
          EStructuralFeature feature = _aUnitExpression_Convert_1;
          throwForExplicitFail(error_2, new ErrorInformation(source_2, feature));
        }
      } else {
        if ((expType instanceof NumberType)) {
          UnitsType _unitsType_2 = ((NumberType)expType).getUnitsType();
          boolean _notEquals = (!Objects.equal(_unitsType_2, null));
          if (_notEquals) {
            /* fail error 'typing: expression already has a unit' source unitExp.expression */
            String error_3 = "typing: expression already has a unit";
            PropertyExpression _expression_2 = unitExp.getExpression();
            EObject source_3 = _expression_2;
            throwForExplicitFail(error_3, new ErrorInformation(source_3, null));
          }
          NumberType _xifexpression_1 = null;
          if ((expType instanceof AadlInteger)) {
            _xifexpression_1 = Aadl2Factory.eINSTANCE.createAadlInteger();
          } else {
            _xifexpression_1 = Aadl2Factory.eINSTANCE.createAadlReal();
          }
          final NumberType result_2 = _xifexpression_1;
          UnitLiteral _unit_3 = unitExp.getUnit();
          EObject _eContainer_2 = _unit_3.eContainer();
          result_2.setReferencedUnitsType(((UnitsType) _eContainer_2));
          type = result_2;
        } else {
          /* fail error 'typing: can only assign unit to a numeric type' source unitExp feature CommonPackage.eINSTANCE.AUnitExpression_Unit */
          String error_4 = "typing: can only assign unit to a numeric type";
          EObject source_4 = unitExp;
          EReference _aUnitExpression_Unit = CommonPackage.eINSTANCE.getAUnitExpression_Unit();
          EStructuralFeature feature_1 = _aUnitExpression_Unit;
          throwForExplicitFail(error_4, new ErrorInformation(source_4, feature_1));
        }
      }
    }
    return new Result<PropertyType>(type);
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final APropertyReference ref) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRulePropertyReference(G, _subtrace_, ref);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("PropertyReference") + stringRepForEnv(G) + " |- " + stringRep(ref) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePropertyReference) {
    	typeThrowException(ruleName("PropertyReference") + stringRepForEnv(G) + " |- " + stringRep(ref) + " : " + "PropertyType",
    		PROPERTYREFERENCE,
    		e_applyRulePropertyReference, ref, new ErrorInformation[] {new ErrorInformation(ref)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRulePropertyReference(final RuleEnvironment G, final RuleApplicationTrace _trace_, final APropertyReference ref) throws RuleFailedException {
    
    return new Result<PropertyType>(_applyRulePropertyReference_1(G, ref));
  }
  
  private PropertyType _applyRulePropertyReference_1(final RuleEnvironment G, final APropertyReference ref) throws RuleFailedException {
    PropertyType _xblockexpression = null;
    {
      final AbstractNamedValue namedValue = ref.getProperty();
      PropertyType _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (namedValue instanceof PropertyConstant) {
          _matched=true;
          _switchResult = ((PropertyConstant)namedValue).getPropertyType();
        }
      }
      if (!_matched) {
        if (namedValue instanceof Property) {
          _matched=true;
          _switchResult = ((Property)namedValue).getPropertyType();
        }
      }
      if (!_matched) {
        /* fail */
        throwForExplicitFail();
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AModelReference _) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleModelReference(G, _subtrace_, _);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ModelReference") + stringRepForEnv(G) + " |- " + stringRep(_) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleModelReference) {
    	typeThrowException(ruleName("ModelReference") + stringRepForEnv(G) + " |- " + stringRep(_) + " : " + "ModelRef",
    		MODELREFERENCE,
    		e_applyRuleModelReference, _, new ErrorInformation[] {new ErrorInformation(_)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleModelReference(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AModelReference _) throws RuleFailedException {
    
    return new Result<PropertyType>(_applyRuleModelReference_1(G, _));
  }
  
  private ModelRef _applyRuleModelReference_1(final RuleEnvironment G, final AModelReference _) throws RuleFailedException {
    ModelRef _createModelRef = CommonFactory.eINSTANCE.createModelRef();
    return _createModelRef;
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final IntegerLiteral value) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleIntegerLiteral(G, _subtrace_, value);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("IntegerLiteral") + stringRepForEnv(G) + " |- " + stringRep(value) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleIntegerLiteral) {
    	typeThrowException(ruleName("IntegerLiteral") + stringRepForEnv(G) + " |- " + stringRep(value) + " : " + "AadlInteger",
    		INTEGERLITERAL,
    		e_applyRuleIntegerLiteral, value, new ErrorInformation[] {new ErrorInformation(value)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleIntegerLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final IntegerLiteral value) throws RuleFailedException {
    
    return new Result<PropertyType>(_applyRuleIntegerLiteral_1(G, value));
  }
  
  private AadlInteger _applyRuleIntegerLiteral_1(final RuleEnvironment G, final IntegerLiteral value) throws RuleFailedException {
    AadlInteger _createAadlInteger = Aadl2Factory.eINSTANCE.createAadlInteger();
    return _createAadlInteger;
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RealLiteral value) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleRealLiteral(G, _subtrace_, value);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("RealLiteral") + stringRepForEnv(G) + " |- " + stringRep(value) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleRealLiteral) {
    	typeThrowException(ruleName("RealLiteral") + stringRepForEnv(G) + " |- " + stringRep(value) + " : " + "AadlReal",
    		REALLITERAL,
    		e_applyRuleRealLiteral, value, new ErrorInformation[] {new ErrorInformation(value)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleRealLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RealLiteral value) throws RuleFailedException {
    
    return new Result<PropertyType>(_applyRuleRealLiteral_1(G, value));
  }
  
  private AadlReal _applyRuleRealLiteral_1(final RuleEnvironment G, final RealLiteral value) throws RuleFailedException {
    AadlReal _createAadlReal = Aadl2Factory.eINSTANCE.createAadlReal();
    return _createAadlReal;
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanLiteral _) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleBooleanLiteral(G, _subtrace_, _);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("BooleanLiteral") + stringRepForEnv(G) + " |- " + stringRep(_) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleBooleanLiteral) {
    	typeThrowException(ruleName("BooleanLiteral") + stringRepForEnv(G) + " |- " + stringRep(_) + " : " + "AadlBoolean",
    		BOOLEANLITERAL,
    		e_applyRuleBooleanLiteral, _, new ErrorInformation[] {new ErrorInformation(_)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleBooleanLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanLiteral _) throws RuleFailedException {
    
    return new Result<PropertyType>(_applyRuleBooleanLiteral_1(G, _));
  }
  
  private AadlBoolean _applyRuleBooleanLiteral_1(final RuleEnvironment G, final BooleanLiteral _) throws RuleFailedException {
    AadlBoolean _createAadlBoolean = Aadl2Factory.eINSTANCE.createAadlBoolean();
    return _createAadlBoolean;
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringLiteral _) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleStringLiteral(G, _subtrace_, _);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("StringLiteral") + stringRepForEnv(G) + " |- " + stringRep(_) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleStringLiteral) {
    	typeThrowException(ruleName("StringLiteral") + stringRepForEnv(G) + " |- " + stringRep(_) + " : " + "AadlString",
    		STRINGLITERAL,
    		e_applyRuleStringLiteral, _, new ErrorInformation[] {new ErrorInformation(_)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleStringLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringLiteral _) throws RuleFailedException {
    
    return new Result<PropertyType>(_applyRuleStringLiteral_1(G, _));
  }
  
  private AadlString _applyRuleStringLiteral_1(final RuleEnvironment G, final StringLiteral _) throws RuleFailedException {
    AadlString _createAadlString = Aadl2Factory.eINSTANCE.createAadlString();
    return _createAadlString;
  }
  
  protected Result<Boolean> sameTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlBoolean l, final AadlBoolean r) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSameBoolean(G, _subtrace_, l, r);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("sameBoolean") + stringRepForEnv(G) + " |- " + stringRep(l) + " ~~ " + stringRep(r);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSameBoolean) {
    	sameTypeThrowException(ruleName("sameBoolean") + stringRepForEnv(G) + " |- " + stringRep(l) + " ~~ " + stringRep(r),
    		SAMEBOOLEAN,
    		e_applyRuleSameBoolean, l, r, new ErrorInformation[] {new ErrorInformation(l), new ErrorInformation(r)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSameBoolean(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlBoolean l, final AadlBoolean r) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> sameTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlString l, final AadlString r) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSameString(G, _subtrace_, l, r);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("sameString") + stringRepForEnv(G) + " |- " + stringRep(l) + " ~~ " + stringRep(r);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSameString) {
    	sameTypeThrowException(ruleName("sameString") + stringRepForEnv(G) + " |- " + stringRep(l) + " ~~ " + stringRep(r),
    		SAMESTRING,
    		e_applyRuleSameString, l, r, new ErrorInformation[] {new ErrorInformation(l), new ErrorInformation(r)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSameString(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlString l, final AadlString r) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> sameTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ModelRef l, final ModelRef r) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSameModelRef(G, _subtrace_, l, r);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("sameModelRef") + stringRepForEnv(G) + " |- " + stringRep(l) + " ~~ " + stringRep(r);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSameModelRef) {
    	sameTypeThrowException(ruleName("sameModelRef") + stringRepForEnv(G) + " |- " + stringRep(l) + " ~~ " + stringRep(r),
    		SAMEMODELREF,
    		e_applyRuleSameModelRef, l, r, new ErrorInformation[] {new ErrorInformation(l), new ErrorInformation(r)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSameModelRef(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ModelRef l, final ModelRef r) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> sameTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EnumerationType left, final EnumerationType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSameEnumeration(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("sameEnumeration") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSameEnumeration) {
    	sameTypeThrowException(ruleName("sameEnumeration") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right),
    		SAMEENUMERATION,
    		e_applyRuleSameEnumeration, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSameEnumeration(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EnumerationType left, final EnumerationType right) throws RuleFailedException {
    String _qualifiedName = left.qualifiedName();
    String _qualifiedName_1 = right.qualifiedName();
    /* left.qualifiedName().equals(right.qualifiedName()) */
    if (!_qualifiedName.equals(_qualifiedName_1)) {
      sneakyThrowRuleFailedException("left.qualifiedName().equals(right.qualifiedName())");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> sameTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberType left, final NumberType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSameNumber(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("sameNumber") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSameNumber) {
    	sameTypeThrowException(ruleName("sameNumber") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right),
    		SAMENUMBER,
    		e_applyRuleSameNumber, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSameNumber(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberType left, final NumberType right) throws RuleFailedException {
    /* { left.unitsType == null && right.unitsType == null } or { left.unitsType != null && right.unitsType != null G |- left.unitsType ~~ right.unitsType } */
    {
      RuleFailedException previousFailure = null;
      try {
        boolean _and = false;
        UnitsType _unitsType = left.getUnitsType();
        boolean _equals = Objects.equal(_unitsType, null);
        if (!_equals) {
          _and = false;
        } else {
          UnitsType _unitsType_1 = right.getUnitsType();
          boolean _equals_1 = Objects.equal(_unitsType_1, null);
          _and = _equals_1;
        }
        /* left.unitsType == null && right.unitsType == null */
        if (!_and) {
          sneakyThrowRuleFailedException("left.unitsType == null && right.unitsType == null");
        }
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        boolean _and_1 = false;
        UnitsType _unitsType_2 = left.getUnitsType();
        boolean _notEquals = (!Objects.equal(_unitsType_2, null));
        if (!_notEquals) {
          _and_1 = false;
        } else {
          UnitsType _unitsType_3 = right.getUnitsType();
          boolean _notEquals_1 = (!Objects.equal(_unitsType_3, null));
          _and_1 = _notEquals_1;
        }
        /* left.unitsType != null && right.unitsType != null */
        if (!_and_1) {
          sneakyThrowRuleFailedException("left.unitsType != null && right.unitsType != null");
        }
        /* G |- left.unitsType ~~ right.unitsType */
        UnitsType _unitsType_4 = left.getUnitsType();
        UnitsType _unitsType_5 = right.getUnitsType();
        sameTypeInternal(G, _trace_, _unitsType_4, _unitsType_5);
      }
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> sameTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RangeType left, final RangeType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSameRange(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("sameRange") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSameRange) {
    	sameTypeThrowException(ruleName("sameRange") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right),
    		SAMERANGE,
    		e_applyRuleSameRange, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSameRange(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RangeType left, final RangeType right) throws RuleFailedException {
    /* G |- left.numberType ~~ right.numberType */
    NumberType _numberType = left.getNumberType();
    NumberType _numberType_1 = right.getNumberType();
    sameTypeInternal(G, _trace_, _numberType, _numberType_1);
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> sameTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ListType left, final ListType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSameList(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("sameList") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSameList) {
    	sameTypeThrowException(ruleName("sameList") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right),
    		SAMELIST,
    		e_applyRuleSameList, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSameList(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ListType left, final ListType right) throws RuleFailedException {
    /* G |- left.elementType ~~ right.elementType */
    PropertyType _elementType = left.getElementType();
    PropertyType _elementType_1 = right.getElementType();
    sameTypeInternal(G, _trace_, _elementType, _elementType_1);
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> sameTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RecordType left, final RecordType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSameRecord(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("sameRecord") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSameRecord) {
    	sameTypeThrowException(ruleName("sameRecord") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right),
    		SAMERECORD,
    		e_applyRuleSameRecord, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSameRecord(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RecordType left, final RecordType right) throws RuleFailedException {
    /* G |= left.ownedFields ~~ right.ownedFields */
    EList<BasicProperty> _ownedFields = left.getOwnedFields();
    EList<BasicProperty> _ownedFields_1 = right.getOwnedFields();
    sameTypesInternal(G, _trace_, _ownedFields, _ownedFields_1);
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> sameTypesImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EList<BasicProperty> left, final EList<BasicProperty> right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSameTypeList(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("sameTypeList") + stringRepForEnv(G) + " |= " + stringRep(left) + " ~~ " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSameTypeList) {
    	sameTypesThrowException(ruleName("sameTypeList") + stringRepForEnv(G) + " |= " + stringRep(left) + " ~~ " + stringRep(right),
    		SAMETYPELIST,
    		e_applyRuleSameTypeList, left, right, new ErrorInformation[] {});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSameTypeList(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EList<BasicProperty> left, final EList<BasicProperty> right) throws RuleFailedException {
    int _length = ((Object[])Conversions.unwrapArray(left, Object.class)).length;
    int _length_1 = ((Object[])Conversions.unwrapArray(right, Object.class)).length;
    boolean _notEquals = (_length != _length_1);
    /* left.length != right.length */
    if (!_notEquals) {
      sneakyThrowRuleFailedException("left.length != right.length");
    }
    for (int i = 0; (i < ((Object[])Conversions.unwrapArray(left, Object.class)).length); i++) {
      final BasicProperty l = left.get(i);
      final BasicProperty r = right.get(i);
      String _name = l.getName();
      String _name_1 = r.getName();
      boolean _equals = _name.equals(_name_1);
      /* l.name.equals(r.name) */
      if (!_equals) {
        sneakyThrowRuleFailedException("l.name.equals(r.name)");
      }
      boolean _isList = l.isList();
      boolean _isList_1 = r.isList();
      boolean _equals_1 = (_isList == _isList_1);
      /* l.isList() == r.isList() */
      if (!_equals_1) {
        sneakyThrowRuleFailedException("l.isList() == r.isList()");
      }
      /* G |- l.propertyType ~~ r.propertyType */
      PropertyType _propertyType = l.getPropertyType();
      PropertyType _propertyType_1 = r.getPropertyType();
      sameTypeInternal(G, _trace_, _propertyType, _propertyType_1);
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> assignableImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AExpression exp, final PropertyType type) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleExpressionAssignableToType(G, _subtrace_, exp, type);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ExpressionAssignableToType") + stringRepForEnv(G) + " |- " + stringRep(exp) + " |> " + stringRep(type);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleExpressionAssignableToType) {
    	assignableThrowException(ruleName("ExpressionAssignableToType") + stringRepForEnv(G) + " |- " + stringRep(exp) + " |> " + stringRep(type),
    		EXPRESSIONASSIGNABLETOTYPE,
    		e_applyRuleExpressionAssignableToType, exp, type, new ErrorInformation[] {new ErrorInformation(exp), new ErrorInformation(type)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleExpressionAssignableToType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AExpression exp, final PropertyType type) throws RuleFailedException {
    PropertyType expType = null;
    /* G |- exp : expType */
    Result<PropertyType> result = typeInternal(G, _trace_, exp);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    expType = (PropertyType) result.getFirst();
    
    /* G |- expType <: type */
    compatibleInternal(G, _trace_, expType, type);
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> compatibleImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlString left, final AadlString right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRulePrimitiveString(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("PrimitiveString") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePrimitiveString) {
    	compatibleThrowException(ruleName("PrimitiveString") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right),
    		PRIMITIVESTRING,
    		e_applyRulePrimitiveString, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRulePrimitiveString(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlString left, final AadlString right) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> compatibleImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlBoolean left, final AadlBoolean right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRulePrimitiveBoolean(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("PrimitiveBoolean") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePrimitiveBoolean) {
    	compatibleThrowException(ruleName("PrimitiveBoolean") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right),
    		PRIMITIVEBOOLEAN,
    		e_applyRulePrimitiveBoolean, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRulePrimitiveBoolean(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlBoolean left, final AadlBoolean right) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> compatibleImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberType left, final NumberType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRulePrimitiveNumber(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("PrimitiveNumber") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePrimitiveNumber) {
    	compatibleThrowException(ruleName("PrimitiveNumber") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right),
    		PRIMITIVENUMBER,
    		e_applyRulePrimitiveNumber, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRulePrimitiveNumber(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberType left, final NumberType right) throws RuleFailedException {
    UnitsType _unitsType = left.getUnitsType();
    UnitsType _unitsType_1 = right.getUnitsType();
    boolean _equals = Objects.equal(_unitsType, _unitsType_1);
    /* left.unitsType == right.unitsType */
    if (!_equals) {
      sneakyThrowRuleFailedException("left.unitsType == right.unitsType");
    }
    boolean _or = false;
    if ((left instanceof AadlInteger)) {
      _or = true;
    } else {
      _or = (right instanceof AadlReal);
    }
    /* left instanceof AadlInteger || right instanceof AadlReal */
    if (!_or) {
      sneakyThrowRuleFailedException("left instanceof AadlInteger || right instanceof AadlReal");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> compatibleImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ModelRef left, final ModelRef right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleModelRef(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ModelRef") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleModelRef) {
    	compatibleThrowException(ruleName("ModelRef") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right),
    		MODELREF,
    		e_applyRuleModelRef, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleModelRef(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ModelRef left, final ModelRef right) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> compatibleImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ModelRef left, final ReferenceType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleModelRef1(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ModelRef1") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleModelRef1) {
    	compatibleThrowException(ruleName("ModelRef1") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right),
    		MODELREF1,
    		e_applyRuleModelRef1, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleModelRef1(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ModelRef left, final ReferenceType right) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> compatibleImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RangeType left, final RangeType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleRange(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Range") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleRange) {
    	compatibleThrowException(ruleName("Range") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right),
    		RANGE,
    		e_applyRuleRange, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleRange(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RangeType left, final RangeType right) throws RuleFailedException {
    /* G |- left ~~ right */
    sameTypeInternal(G, _trace_, left, right);
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> compatibleImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyType left, final PropertyType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleNotCompatible(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("NotCompatible") + stringRepForEnv(G) + " |- " + stringRep(left) + " <: " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleNotCompatible) {
    	notCompatibleThrowException(e_applyRuleNotCompatible, left, right);
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleNotCompatible(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyType left, final PropertyType right) throws RuleFailedException {
    /* fail */
    throwForExplicitFail();
    return new Result<Boolean>(true);
  }
  
  private void notCompatibleThrowException(final Exception e_applyRuleNotCompatible, final PropertyType left, final PropertyType right) throws RuleFailedException {
    String _stringRep = this.stringRep(left);
    String _plus = ("types not compatible: cannot assign " + _stringRep);
    String _plus_1 = (_plus + " to ");
    String _stringRep_1 = this.stringRep(right);
    String _plus_2 = (_plus_1 + _stringRep_1);
    String error = _plus_2;
    throwRuleFailedException(error,
    	NOTCOMPATIBLE, e_applyRuleNotCompatible, new ErrorInformation(null, null));
  }
}
