package org.osate.expr;

import com.google.inject.Provider;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Connection;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Flow;
import org.osate.aadl2.ListType;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.Type;
import org.osate.expr.expr.Argument;
import org.osate.expr.expr.BagLiteral;
import org.osate.expr.expr.BagType;
import org.osate.expr.expr.BinaryOperation;
import org.osate.expr.expr.Block;
import org.osate.expr.expr.Conditional;
import org.osate.expr.expr.EBoolean;
import org.osate.expr.expr.EBooleanLiteral;
import org.osate.expr.expr.EInteger;
import org.osate.expr.expr.EIntegerLiteral;
import org.osate.expr.expr.ENumberType;
import org.osate.expr.expr.EReal;
import org.osate.expr.expr.ERealLiteral;
import org.osate.expr.expr.EString;
import org.osate.expr.expr.EStringLiteral;
import org.osate.expr.expr.EnumLiteral;
import org.osate.expr.expr.EnumType;
import org.osate.expr.expr.ExprFactory;
import org.osate.expr.expr.Expression;
import org.osate.expr.expr.Field;
import org.osate.expr.expr.FieldValue;
import org.osate.expr.expr.FunDecl;
import org.osate.expr.expr.ListLiteral;
import org.osate.expr.expr.MapLiteral;
import org.osate.expr.expr.MapType;
import org.osate.expr.expr.MetaClass;
import org.osate.expr.expr.MetaClassEnum;
import org.osate.expr.expr.NamedElementRef;
import org.osate.expr.expr.Operation;
import org.osate.expr.expr.PropertyExpression;
import org.osate.expr.expr.RangeType;
import org.osate.expr.expr.RecordLiteral;
import org.osate.expr.expr.Selection;
import org.osate.expr.expr.SetLiteral;
import org.osate.expr.expr.SetType;
import org.osate.expr.expr.TupleLiteral;
import org.osate.expr.expr.TupleType;
import org.osate.expr.expr.UnaryOperation;
import org.osate.expr.expr.UnionLiteral;
import org.osate.expr.expr.UnionType;
import org.osate.expr.expr.VarDecl;

@SuppressWarnings("all")
public class ExprTypeSystem extends XsemanticsRuntimeSystem {
  public static final String COMBINENUMERIC = "org.osate.expr.CombineNumeric";
  
  public static final String VARDECL = "org.osate.expr.VarDecl";
  
  public static final String FUNDECL = "org.osate.expr.FunDecl";
  
  public static final String TYPE = "org.osate.expr.Type";
  
  public static final String EXPRESSION = "org.osate.expr.Expression";
  
  public static final String BLOCKEXPRESSION = "org.osate.expr.BlockExpression";
  
  public static final String ARGUMENT = "org.osate.expr.Argument";
  
  public static final String BINARYEXPRESSION = "org.osate.expr.BinaryExpression";
  
  public static final String SELECTEXPRESSION = "org.osate.expr.SelectExpression";
  
  public static final String UNARYEXPRESSION = "org.osate.expr.UnaryExpression";
  
  public static final String IFEXPRESSION = "org.osate.expr.IfExpression";
  
  public static final String PROPERTYEXPRESSION = "org.osate.expr.PropertyExpression";
  
  public static final String NAMEDELEMENTREF = "org.osate.expr.NamedElementRef";
  
  public static final String CLASSIFIER = "org.osate.expr.Classifier";
  
  public static final String SUBCOMPONENT = "org.osate.expr.Subcomponent";
  
  public static final String FEATURE = "org.osate.expr.Feature";
  
  public static final String CONNECTION = "org.osate.expr.Connection";
  
  public static final String FLOW = "org.osate.expr.Flow";
  
  public static final String MODE = "org.osate.expr.Mode";
  
  public static final String PROPERTY = "org.osate.expr.Property";
  
  public static final String AADLBOOLEAN = "org.osate.expr.AadlBoolean";
  
  public static final String AADLINTEGER = "org.osate.expr.AadlInteger";
  
  public static final String AADLREAL = "org.osate.expr.AadlReal";
  
  public static final String AADLSTRING = "org.osate.expr.AadlString";
  
  public static final String AADLLISTTYPE = "org.osate.expr.AadlListType";
  
  public static final String AADLRECORDTYPE = "org.osate.expr.AadlRecordType";
  
  public static final String AADLENUMERATIONTYPE = "org.osate.expr.AadlEnumerationType";
  
  public static final String EBOOLEANLITERAL = "org.osate.expr.EBooleanLiteral";
  
  public static final String EINTEGERLITERAL = "org.osate.expr.EIntegerLiteral";
  
  public static final String EREALLITERAL = "org.osate.expr.ERealLiteral";
  
  public static final String ESTRINGLITERAL = "org.osate.expr.EStringLiteral";
  
  public static final String LISTLITERAL = "org.osate.expr.ListLiteral";
  
  public static final String SETLITERAL = "org.osate.expr.SetLiteral";
  
  public static final String RECORDLITERAL = "org.osate.expr.RecordLiteral";
  
  public static final String UNIONLITERAL = "org.osate.expr.UnionLiteral";
  
  public static final String TUPLELITERAL = "org.osate.expr.TupleLiteral";
  
  public static final String BAGLITERAL = "org.osate.expr.BagLiteral";
  
  public static final String MAPLITERAL = "org.osate.expr.MapLiteral";
  
  public static final String ENUMLITERAL = "org.osate.expr.EnumLiteral";
  
  public static final String FIELD = "org.osate.expr.Field";
  
  public static final String FIELDVALUE = "org.osate.expr.FieldValue";
  
  public static final String SAMEEBOOLEAN = "org.osate.expr.SameEBoolean";
  
  public static final String SAMEENUMBER = "org.osate.expr.SameENumber";
  
  public static final String SAMEESTRING = "org.osate.expr.SameEString";
  
  public static final String SAMELIST = "org.osate.expr.SameList";
  
  public static final String PRIMITIVESTRING = "org.osate.expr.PrimitiveString";
  
  public static final String PRIMITIVEBOOLEAN = "org.osate.expr.PrimitiveBoolean";
  
  public static final String PRIMITIVEINTEGER = "org.osate.expr.PrimitiveInteger";
  
  public static final String PRIMITIVEREAL = "org.osate.expr.PrimitiveReal";
  
  private PolymorphicDispatcher<ENumberType> combineNumericDispatcher;
  
  private PolymorphicDispatcher<Result<Type>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> compatibleDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> sameTypeDispatcher;
  
  public ExprTypeSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    compatibleDispatcher = buildPolymorphicDispatcher1(
    	"compatibleImpl", 4, "|-", "<|");
    sameTypeDispatcher = buildPolymorphicDispatcher1(
    	"sameTypeImpl", 4, "|-", "~~");
    combineNumericDispatcher = buildPolymorphicDispatcher(
    	"combineNumericImpl", 3);
  }
  
  public ENumberType combineNumeric(final ENumberType left, final ENumberType right) throws RuleFailedException {
    return combineNumeric(null, left, right);
  }
  
  public ENumberType combineNumeric(final RuleApplicationTrace _trace_, final ENumberType left, final ENumberType right) throws RuleFailedException {
    try {
    	return combineNumericInternal(_trace_, left, right);
    } catch (Exception _e_combineNumeric) {
    	throw extractRuleFailedException(_e_combineNumeric);
    }
  }
  
  public Result<Type> type(final EObject o) {
    return type(new RuleEnvironment(), null, o);
  }
  
  public Result<Type> type(final RuleEnvironment _environment_, final EObject o) {
    return type(_environment_, null, o);
  }
  
  public Result<Type> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	return typeInternal(_environment_, _trace_, o);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  public Result<Boolean> compatible(final Type left, final Type right) {
    return compatible(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Boolean> compatible(final RuleEnvironment _environment_, final Type left, final Type right) {
    return compatible(_environment_, null, left, right);
  }
  
  public Result<Boolean> compatible(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	return compatibleInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_compatible) {
    	return resultForFailure(_e_compatible);
    }
  }
  
  public Boolean compatibleSucceeded(final Type left, final Type right) {
    return compatibleSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  public Boolean compatibleSucceeded(final RuleEnvironment _environment_, final Type left, final Type right) {
    return compatibleSucceeded(_environment_, null, left, right);
  }
  
  public Boolean compatibleSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	compatibleInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_compatible) {
    	return false;
    }
  }
  
  public Result<Boolean> sameType(final Type left, final Type right) {
    return sameType(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Boolean> sameType(final RuleEnvironment _environment_, final Type left, final Type right) {
    return sameType(_environment_, null, left, right);
  }
  
  public Result<Boolean> sameType(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	return sameTypeInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_sameType) {
    	return resultForFailure(_e_sameType);
    }
  }
  
  public Boolean sameTypeSucceeded(final Type left, final Type right) {
    return sameTypeSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  public Boolean sameTypeSucceeded(final RuleEnvironment _environment_, final Type left, final Type right) {
    return sameTypeSucceeded(_environment_, null, left, right);
  }
  
  public Boolean sameTypeSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	sameTypeInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_sameType) {
    	return false;
    }
  }
  
  public Result<Boolean> checkVarDecls(final VarDecl varDecl) {
    return checkVarDecls(null, varDecl);
  }
  
  public Result<Boolean> checkVarDecls(final RuleApplicationTrace _trace_, final VarDecl varDecl) {
    try {
    	return checkVarDeclsInternal(_trace_, varDecl);
    } catch (Exception _e_CheckVarDecls) {
    	return resultForFailure(_e_CheckVarDecls);
    }
  }
  
  protected Result<Boolean> checkVarDeclsInternal(final RuleApplicationTrace _trace_, final VarDecl varDecl) throws RuleFailedException {
    String _stringRep = this.stringRep(varDecl);
    String _plus = ("typing " + _stringRep);
    String _plus_1 = (_plus + " => ");
    InputOutput.<String>print(_plus_1);
    Expression _value = varDecl.getValue();
    boolean _tripleNotEquals = (_value != null);
    if (_tripleNotEquals) {
      /* empty |- varDecl.value : var Type assignedType */
      Expression _value_1 = varDecl.getValue();
      Type assignedType = null;
      Result<Type> result = typeInternal(emptyEnvironment(), _trace_, _value_1);
      checkAssignableTo(result.getFirst(), Type.class);
      assignedType = (Type) result.getFirst();
      
      String _name = varDecl.getName();
      String _plus_2 = (_name + ": ");
      String _stringRep_1 = this.stringRep(assignedType);
      String _plus_3 = (_plus_2 + _stringRep_1);
      String _plus_4 = (_plus_3 + " (assigned)");
      InputOutput.<String>print(_plus_4);
      Type _declType = varDecl.getDeclType();
      boolean _tripleNotEquals_1 = (_declType != null);
      if (_tripleNotEquals_1) {
        /* empty |- varDecl : var Type declaredType */
        Type declaredType = null;
        Result<Type> result_1 = typeInternal(emptyEnvironment(), _trace_, varDecl);
        checkAssignableTo(result_1.getFirst(), Type.class);
        declaredType = (Type) result_1.getFirst();
        
        String _stringRep_2 = this.stringRep(declaredType);
        String _plus_5 = (" || " + _stringRep_2);
        String _plus_6 = (_plus_5 + " (declared)");
        InputOutput.<String>print(_plus_6);
        /* empty |- assignedType <| declaredType */
        compatibleInternal(emptyEnvironment(), _trace_, assignedType, declaredType);
      }
    } else {
      String _name_1 = varDecl.getName();
      String _plus_7 = (_name_1 + ": ");
      String _stringRep_3 = this.stringRep(varDecl.getDeclType());
      String _plus_8 = (_plus_7 + _stringRep_3);
      String _plus_9 = (_plus_8 + " (declared)");
      InputOutput.<String>print(_plus_9);
    }
    InputOutput.println();
    return new Result<Boolean>(true);
  }
  
  public Result<Boolean> checkExpressions(final Expression exp) {
    return checkExpressions(null, exp);
  }
  
  public Result<Boolean> checkExpressions(final RuleApplicationTrace _trace_, final Expression exp) {
    try {
    	return checkExpressionsInternal(_trace_, exp);
    } catch (Exception _e_CheckExpressions) {
    	return resultForFailure(_e_CheckExpressions);
    }
  }
  
  protected Result<Boolean> checkExpressionsInternal(final RuleApplicationTrace _trace_, final Expression exp) throws RuleFailedException {
    /* empty |- exp : var Type type */
    Type type = null;
    Result<Type> result = typeInternal(emptyEnvironment(), _trace_, exp);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Boolean>(true);
  }
  
  protected ENumberType combineNumericInternal(final RuleApplicationTrace _trace_, final ENumberType left, final ENumberType right) {
    try {
    	checkParamsNotNull(left, right);
    	return combineNumericDispatcher.invoke(_trace_, left, right);
    } catch (Exception _e_combineNumeric) {
    	sneakyThrowRuleFailedException(_e_combineNumeric);
    	return null;
    }
  }
  
  protected void combineNumericThrowException(final String _error, final String _issue, final Exception _ex, final ENumberType left, final ENumberType right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Type> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject o) {
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
  
  protected Result<Boolean> compatibleInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	checkParamsNotNull(left, right);
    	return compatibleDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_compatible) {
    	sneakyThrowRuleFailedException(_e_compatible);
    	return null;
    }
  }
  
  protected void compatibleThrowException(final String _error, final String _issue, final Exception _ex, final Type left, final Type right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Boolean> sameTypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Type left, final Type right) {
    try {
    	checkParamsNotNull(left, right);
    	return sameTypeDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_sameType) {
    	sneakyThrowRuleFailedException(_e_sameType);
    	return null;
    }
  }
  
  protected void sameTypeThrowException(final String _error, final String _issue, final Exception _ex, final Type left, final Type right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected ENumberType combineNumericImpl(final RuleApplicationTrace _trace_, final ENumberType left, final ENumberType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final ENumberType _result_ = applyAuxFunCombineNumeric(_subtrace_, left, right);
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
  
  protected ENumberType applyAuxFunCombineNumeric(final RuleApplicationTrace _trace_, final ENumberType left, final ENumberType right) throws RuleFailedException {
    ENumberType _xblockexpression = null;
    {
      ENumberType _xifexpression = null;
      if (((left instanceof EInteger) && (right instanceof EInteger))) {
        _xifexpression = ExprFactory.eINSTANCE.createEInteger();
      } else {
        _xifexpression = ExprFactory.eINSTANCE.createEReal();
      }
      final ENumberType result = _xifexpression;
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VarDecl varDecl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleVarDecl(G, _subtrace_, varDecl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("VarDecl") + stringRepForEnv(G) + " |- " + stringRep(varDecl) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleVarDecl) {
    	typeThrowException(ruleName("VarDecl") + stringRepForEnv(G) + " |- " + stringRep(varDecl) + " : " + "Type",
    		VARDECL,
    		e_applyRuleVarDecl, varDecl, new ErrorInformation[] {new ErrorInformation(varDecl)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleVarDecl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VarDecl varDecl) throws RuleFailedException {
    Type type = null; // output parameter
    final Type declared = varDecl.getDeclType();
    /* { declared !== null G |- declared : type } or { declared === null G |- varDecl.value : type } */
    {
      RuleFailedException previousFailure = null;
      try {
        /* declared !== null */
        if (!(declared != null)) {
          sneakyThrowRuleFailedException("declared !== null");
        }
        /* G |- declared : type */
        Result<Type> result = typeInternal(G, _trace_, declared);
        checkAssignableTo(result.getFirst(), Type.class);
        type = (Type) result.getFirst();
        
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* declared === null */
        if (!(declared == null)) {
          sneakyThrowRuleFailedException("declared === null");
        }
        /* G |- varDecl.value : type */
        Expression _value = varDecl.getValue();
        Result<Type> result_1 = typeInternal(G, _trace_, _value);
        checkAssignableTo(result_1.getFirst(), Type.class);
        type = (Type) result_1.getFirst();
        
      }
    }
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final FunDecl fun) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleFunDecl(G, _subtrace_, fun);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("FunDecl") + stringRepForEnv(G) + " |- " + stringRep(fun) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleFunDecl) {
    	typeThrowException(ruleName("FunDecl") + stringRepForEnv(G) + " |- " + stringRep(fun) + " : " + "Type",
    		FUNDECL,
    		e_applyRuleFunDecl, fun, new ErrorInformation[] {new ErrorInformation(fun)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleFunDecl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final FunDecl fun) throws RuleFailedException {
    Type type = null; // output parameter
    /* { fun.java type = fun.resultType } or { type = fun.resultType } */
    {
      RuleFailedException previousFailure = null;
      try {
        boolean _isJava = fun.isJava();
        /* fun.java */
        if (!_isJava) {
          sneakyThrowRuleFailedException("fun.java");
        }
        type = fun.getResultType();
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        type = fun.getResultType();
      }
    }
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Type t) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleType(G, _subtrace_, t);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Type") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleType) {
    	typeThrowException(ruleName("Type") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + "Type",
    		TYPE,
    		e_applyRuleType, t, new ErrorInformation[] {new ErrorInformation(t)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Type t) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleType_1(G, t));
  }
  
  private Type _applyRuleType_1(final RuleEnvironment G, final Type t) throws RuleFailedException {
    return t;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleExpression(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Expression") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleExpression) {
    	expressionThrowException(e_applyRuleExpression, e);
    	return null;
    }
  }
  
  protected Result<Type> applyRuleExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression e) throws RuleFailedException {
    Type type = null; // output parameter
    /* fail */
    throwForExplicitFail();
    return new Result<Type>(type);
  }
  
  private void expressionThrowException(final Exception e_applyRuleExpression, final Expression e) throws RuleFailedException {
    String _stringRep = this.stringRep(e);
    String _plus = ("typing: unhandled case " + _stringRep);
    String error = _plus;
    EObject source = e;
    throwRuleFailedException(error,
    	EXPRESSION, e_applyRuleExpression, new ErrorInformation(source, null));
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Block block) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleBlockExpression(G, _subtrace_, block);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("BlockExpression") + stringRepForEnv(G) + " |- " + stringRep(block) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleBlockExpression) {
    	typeThrowException(ruleName("BlockExpression") + stringRepForEnv(G) + " |- " + stringRep(block) + " : " + "Type",
    		BLOCKEXPRESSION,
    		e_applyRuleBlockExpression, block, new ErrorInformation[] {new ErrorInformation(block)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleBlockExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Block block) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- block.result : type */
    Expression _result = block.getResult();
    Result<Type> result = typeInternal(G, _trace_, _result);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Argument a) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleArgument(G, _subtrace_, a);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Argument") + stringRepForEnv(G) + " |- " + stringRep(a) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleArgument) {
    	typeThrowException(ruleName("Argument") + stringRepForEnv(G) + " |- " + stringRep(a) + " : " + "Type",
    		ARGUMENT,
    		e_applyRuleArgument, a, new ErrorInformation[] {new ErrorInformation(a)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleArgument(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Argument a) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- a.type : type */
    Type _type = a.getType();
    Result<Type> result = typeInternal(G, _trace_, _type);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BinaryOperation binary) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleBinaryExpression(G, _subtrace_, binary);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("BinaryExpression") + stringRepForEnv(G) + " |- " + stringRep(binary) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleBinaryExpression) {
    	typeThrowException(ruleName("BinaryExpression") + stringRepForEnv(G) + " |- " + stringRep(binary) + " : " + "Type",
    		BINARYEXPRESSION,
    		e_applyRuleBinaryExpression, binary, new ErrorInformation[] {new ErrorInformation(binary)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleBinaryExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BinaryOperation binary) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- binary.left : var Type leftType */
    Expression _left = binary.getLeft();
    Type leftType = null;
    Result<Type> result = typeInternal(G, _trace_, _left);
    checkAssignableTo(result.getFirst(), Type.class);
    leftType = (Type) result.getFirst();
    
    /* G |- binary.right : var Type rightType */
    Expression _right = binary.getRight();
    Type rightType = null;
    Result<Type> result_1 = typeInternal(G, _trace_, _right);
    checkAssignableTo(result_1.getFirst(), Type.class);
    rightType = (Type) result_1.getFirst();
    
    final Operation op = binary.getOperator();
    if (op != null) {
      switch (op) {
        case OR:
        case ALT_OR:
        case AND:
        case ALT_AND:
          if ((!(leftType instanceof EBoolean))) {
            /* fail error 'typing: operand must be boolean' source binary.left */
            String error = "typing: operand must be boolean";
            Expression _left_1 = binary.getLeft();
            EObject source = _left_1;
            throwForExplicitFail(error, new ErrorInformation(source, null));
          }
          if ((!(rightType instanceof EBoolean))) {
            /* fail error 'typing: operand must be boolean' source binary.right */
            String error_1 = "typing: operand must be boolean";
            Expression _right_1 = binary.getRight();
            EObject source_1 = _right_1;
            throwForExplicitFail(error_1, new ErrorInformation(source_1, null));
          }
          type = ExprFactory.eINSTANCE.createEBoolean();
          break;
        case EQ:
        case NEQ:
          /* G |- leftType ~~ rightType or { fail error 'typing: cannot compare ' + stringRep(leftType) + ' and ' + stringRep(rightType) source binary } */
          {
            RuleFailedException previousFailure = null;
            try {
              /* G |- leftType ~~ rightType */
              sameTypeInternal(G, _trace_, leftType, rightType);
            } catch (Exception e) {
              previousFailure = extractRuleFailedException(e);
              /* fail error 'typing: cannot compare ' + stringRep(leftType) + ' and ' + stringRep(rightType) source binary */
              String _stringRep = this.stringRep(leftType);
              String _plus = ("typing: cannot compare " + _stringRep);
              String _plus_1 = (_plus + " and ");
              String _stringRep_1 = this.stringRep(rightType);
              String _plus_2 = (_plus_1 + _stringRep_1);
              String error_2 = _plus_2;
              EObject source_2 = binary;
              throwForExplicitFail(error_2, new ErrorInformation(source_2, null));
            }
          }
          type = ExprFactory.eINSTANCE.createEBoolean();
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
          if ((!((leftType instanceof ENumberType) || (leftType instanceof RangeType)))) {
            /* fail error 'typing: operand must be numeric or a range' source binary.left */
            String error_3 = "typing: operand must be numeric or a range";
            Expression _left_2 = binary.getLeft();
            EObject source_3 = _left_2;
            throwForExplicitFail(error_3, new ErrorInformation(source_3, null));
          }
          if ((!((rightType instanceof ENumberType) || (rightType instanceof RangeType)))) {
            /* fail error 'typing: operand must be numeric or a range' source binary.right */
            String error_4 = "typing: operand must be numeric or a range";
            Expression _right_2 = binary.getRight();
            EObject source_4 = _right_2;
            throwForExplicitFail(error_4, new ErrorInformation(source_4, null));
          }
          if (op != null) {
            switch (op) {
              case PLUS:
              case MULT:
                if ((!(((leftType instanceof RangeType) && (rightType instanceof RangeType)) || ((leftType instanceof ENumberType) && (rightType instanceof ENumberType))))) {
                  /* fail error 'typing: operands must be both numeric or both ranges' source binary */
                  String error_5 = "typing: operands must be both numeric or both ranges";
                  EObject source_5 = binary;
                  throwForExplicitFail(error_5, new ErrorInformation(source_5, null));
                }
                break;
              case IN:
                if ((!(rightType instanceof RangeType))) {
                  /* fail error 'typing: operand must be a range' source binary.right */
                  String error_6 = "typing: operand must be a range";
                  Expression _right_3 = binary.getRight();
                  EObject source_6 = _right_3;
                  throwForExplicitFail(error_6, new ErrorInformation(source_6, null));
                }
                break;
              case DIV:
              case MINUS:
                if ((!(leftType instanceof ENumberType))) {
                  /* fail error 'typing: operand must be numeric' source binary.left */
                  String error_7 = "typing: operand must be numeric";
                  Expression _left_3 = binary.getLeft();
                  EObject source_7 = _left_3;
                  throwForExplicitFail(error_7, new ErrorInformation(source_7, null));
                } else {
                  if ((!(rightType instanceof ENumberType))) {
                    /* fail error 'typing: operand must be numeric' source binary.right */
                    String error_8 = "typing: operand must be numeric";
                    Expression _right_4 = binary.getRight();
                    EObject source_8 = _right_4;
                    throwForExplicitFail(error_8, new ErrorInformation(source_8, null));
                  }
                }
                break;
              default:
                break;
            }
          } else {
          }
          Type _xifexpression = null;
          if ((leftType instanceof RangeType)) {
            _xifexpression = ((RangeType)leftType).getType();
          } else {
            _xifexpression = leftType;
          }
          final ENumberType leftNum = ((ENumberType) _xifexpression);
          Type _xifexpression_1 = null;
          if ((rightType instanceof RangeType)) {
            _xifexpression_1 = ((RangeType)rightType).getType();
          } else {
            _xifexpression_1 = rightType;
          }
          final ENumberType rightNum = ((ENumberType) _xifexpression_1);
          if (op != null) {
            switch (op) {
              case LT:
              case LEQ:
              case GT:
              case GEQ:
              case IN:
                /* G |- leftNum ~~ rightNum or { fail error 'typing: arguments have different unit types' source binary } */
                {
                  RuleFailedException previousFailure = null;
                  try {
                    /* G |- leftNum ~~ rightNum */
                    sameTypeInternal(G, _trace_, leftNum, rightNum);
                  } catch (Exception e_1) {
                    previousFailure = extractRuleFailedException(e_1);
                    /* fail error 'typing: arguments have different unit types' source binary */
                    String error_9 = "typing: arguments have different unit types";
                    EObject source_9 = binary;
                    throwForExplicitFail(error_9, new ErrorInformation(source_9, null));
                  }
                }
                type = ExprFactory.eINSTANCE.createEBoolean();
                break;
              case PLUS:
              case MINUS:
                /* G |- leftNum ~~ rightNum or { fail error 'typing: arguments have different unit types' source binary } */
                {
                  RuleFailedException previousFailure = null;
                  try {
                    /* G |- leftNum ~~ rightNum */
                    sameTypeInternal(G, _trace_, leftNum, rightNum);
                  } catch (Exception e_2) {
                    previousFailure = extractRuleFailedException(e_2);
                    /* fail error 'typing: arguments have different unit types' source binary */
                    String error_10 = "typing: arguments have different unit types";
                    EObject source_10 = binary;
                    throwForExplicitFail(error_10, new ErrorInformation(source_10, null));
                  }
                }
                type = this.combineNumericInternal(_trace_, leftNum, rightNum);
                break;
              case MULT:
                type = this.combineNumericInternal(_trace_, leftNum, rightNum);
                break;
              case DIV:
                final EReal t = ExprFactory.eINSTANCE.createEReal();
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
          if ((!(leftType instanceof EInteger))) {
            /* fail error 'typing: argument must be an integer' source binary.left */
            String error_12 = "typing: argument must be an integer";
            Expression _left_4 = binary.getLeft();
            EObject source_12 = _left_4;
            throwForExplicitFail(error_12, new ErrorInformation(source_12, null));
          }
          if ((!(rightType instanceof EInteger))) {
            /* fail error 'typing: argument must be an integer' source binary.right */
            String error_13 = "typing: argument must be an integer";
            Expression _right_5 = binary.getRight();
            EObject source_13 = _right_5;
            throwForExplicitFail(error_13, new ErrorInformation(source_13, null));
          }
          final ENumberType leftNum_1 = ((ENumberType) leftType);
          final ENumberType rightNum_1 = ((ENumberType) rightType);
          final EInteger t_1 = ExprFactory.eINSTANCE.createEInteger();
          type = t_1;
          break;
        default:
          /* fail error 'typing: unhandled binary operator encountered' source binary */
          String error_14 = "typing: unhandled binary operator encountered";
          EObject source_14 = binary;
          throwForExplicitFail(error_14, new ErrorInformation(source_14, null));
          break;
      }
    } else {
      /* fail error 'typing: unhandled binary operator encountered' source binary */
      String error_14 = "typing: unhandled binary operator encountered";
      EObject source_14 = binary;
      throwForExplicitFail(error_14, new ErrorInformation(source_14, null));
    }
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleSelectExpression(G, _subtrace_, selection);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SelectExpression") + stringRepForEnv(G) + " |- " + stringRep(selection) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSelectExpression) {
    	typeThrowException(ruleName("SelectExpression") + stringRepForEnv(G) + " |- " + stringRep(selection) + " : " + "Type",
    		SELECTEXPRESSION,
    		e_applyRuleSelectExpression, selection, new ErrorInformation[] {new ErrorInformation(selection)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleSelectExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Selection selection) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- selection.ref : type */
    NamedElement _ref = selection.getRef();
    Result<Type> result = typeInternal(G, _trace_, _ref);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final UnaryOperation unary) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleUnaryExpression(G, _subtrace_, unary);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("UnaryExpression") + stringRepForEnv(G) + " |- " + stringRep(unary) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnaryExpression) {
    	typeThrowException(ruleName("UnaryExpression") + stringRepForEnv(G) + " |- " + stringRep(unary) + " : " + "Type",
    		UNARYEXPRESSION,
    		e_applyRuleUnaryExpression, unary, new ErrorInformation[] {new ErrorInformation(unary)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleUnaryExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final UnaryOperation unary) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- unary.operand : var Type opType */
    Expression _operand = unary.getOperand();
    Type opType = null;
    Result<Type> result = typeInternal(G, _trace_, _operand);
    checkAssignableTo(result.getFirst(), Type.class);
    opType = (Type) result.getFirst();
    
    Operation _operator = unary.getOperator();
    if (_operator != null) {
      switch (_operator) {
        case PLUS:
        case MINUS:
          if ((opType instanceof ENumberType)) {
            type = opType;
          } else {
            /* fail error 'typing: operand is not numeric' source unary */
            String error = "typing: operand is not numeric";
            EObject source = unary;
            throwForExplicitFail(error, new ErrorInformation(source, null));
          }
          break;
        case NOT:
          if ((opType instanceof EBoolean)) {
            type = ExprFactory.eINSTANCE.createEBoolean();
          } else {
            /* fail error 'typing: operand is not a boolean' source unary */
            String error_1 = "typing: operand is not a boolean";
            EObject source_1 = unary;
            throwForExplicitFail(error_1, new ErrorInformation(source_1, null));
          }
          break;
        default:
          /* fail error 'typing: unhandled unary operator encountered' source unary */
          String error_2 = "typing: unhandled unary operator encountered";
          EObject source_2 = unary;
          throwForExplicitFail(error_2, new ErrorInformation(source_2, null));
          break;
      }
    } else {
      /* fail error 'typing: unhandled unary operator encountered' source unary */
      String error_2 = "typing: unhandled unary operator encountered";
      EObject source_2 = unary;
      throwForExplicitFail(error_2, new ErrorInformation(source_2, null));
    }
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Conditional ifExp) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleIfExpression(G, _subtrace_, ifExp);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("IfExpression") + stringRepForEnv(G) + " |- " + stringRep(ifExp) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleIfExpression) {
    	typeThrowException(ruleName("IfExpression") + stringRepForEnv(G) + " |- " + stringRep(ifExp) + " : " + "Type",
    		IFEXPRESSION,
    		e_applyRuleIfExpression, ifExp, new ErrorInformation[] {new ErrorInformation(ifExp)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleIfExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Conditional ifExp) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- ifExp.^if : var Type ifType */
    Expression _if = ifExp.getIf();
    Type ifType = null;
    Result<Type> result = typeInternal(G, _trace_, _if);
    checkAssignableTo(result.getFirst(), Type.class);
    ifType = (Type) result.getFirst();
    
    /* G |- ifExp.^then : var Type thenType */
    Expression _then = ifExp.getThen();
    Type thenType = null;
    Result<Type> result_1 = typeInternal(G, _trace_, _then);
    checkAssignableTo(result_1.getFirst(), Type.class);
    thenType = (Type) result_1.getFirst();
    
    /* G |- ifExp.^else : var Type elseType */
    Expression _else = ifExp.getElse();
    Type elseType = null;
    Result<Type> result_2 = typeInternal(G, _trace_, _else);
    checkAssignableTo(result_2.getFirst(), Type.class);
    elseType = (Type) result_2.getFirst();
    
    if ((!(ifType instanceof EBoolean))) {
      /* fail error 'typing: condition must be boolean' source ifExp.^if */
      String error = "typing: condition must be boolean";
      Expression _if_1 = ifExp.getIf();
      EObject source = _if_1;
      throwForExplicitFail(error, new ErrorInformation(source, null));
    }
    /* G |- thenType ~~ elseType or { fail error 'typing: then and else part must have the same type' source ifExp } */
    {
      RuleFailedException previousFailure = null;
      try {
        /* G |- thenType ~~ elseType */
        sameTypeInternal(G, _trace_, thenType, elseType);
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* fail error 'typing: then and else part must have the same type' source ifExp */
        String error_1 = "typing: then and else part must have the same type";
        EObject source_1 = ifExp;
        throwForExplicitFail(error_1, new ErrorInformation(source_1, null));
      }
    }
    if ((thenType instanceof ENumberType)) {
      type = this.combineNumericInternal(_trace_, ((ENumberType)thenType), ((ENumberType) elseType));
    } else {
      type = thenType;
    }
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyExpression pe) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRulePropertyExpression(G, _subtrace_, pe);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("PropertyExpression") + stringRepForEnv(G) + " |- " + stringRep(pe) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePropertyExpression) {
    	typeThrowException(ruleName("PropertyExpression") + stringRepForEnv(G) + " |- " + stringRep(pe) + " : " + "Type",
    		PROPERTYEXPRESSION,
    		e_applyRulePropertyExpression, pe, new ErrorInformation[] {new ErrorInformation(pe)});
    	return null;
    }
  }
  
  protected Result<Type> applyRulePropertyExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyExpression pe) throws RuleFailedException {
    Type type = null; // output parameter
    /* { pe.property instanceof Property G |- (pe.property as Property).propertyType : type } or { fail } */
    {
      RuleFailedException previousFailure = null;
      try {
        AbstractNamedValue _property = pe.getProperty();
        /* pe.property instanceof Property */
        if (!(_property instanceof Property)) {
          sneakyThrowRuleFailedException("pe.property instanceof Property");
        }
        /* G |- (pe.property as Property).propertyType : type */
        AbstractNamedValue _property_1 = pe.getProperty();
        PropertyType _propertyType = ((Property) _property_1).getPropertyType();
        Result<Type> result = typeInternal(G, _trace_, _propertyType);
        checkAssignableTo(result.getFirst(), Type.class);
        type = (Type) result.getFirst();
        
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* fail */
        throwForExplicitFail();
      }
    }
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NamedElementRef ner) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleNamedElementRef(G, _subtrace_, ner);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("NamedElementRef") + stringRepForEnv(G) + " |- " + stringRep(ner) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleNamedElementRef) {
    	typeThrowException(ruleName("NamedElementRef") + stringRepForEnv(G) + " |- " + stringRep(ner) + " : " + "Type",
    		NAMEDELEMENTREF,
    		e_applyRuleNamedElementRef, ner, new ErrorInformation[] {new ErrorInformation(ner)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleNamedElementRef(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NamedElementRef ner) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- ner.ref : type */
    NamedElement _ref = ner.getRef();
    Result<Type> result = typeInternal(G, _trace_, _ref);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Classifier c) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleClassifier(G, _subtrace_, c);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Classifier") + stringRepForEnv(G) + " |- " + stringRep(c) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleClassifier) {
    	typeThrowException(ruleName("Classifier") + stringRepForEnv(G) + " |- " + stringRep(c) + " : " + "Classifier",
    		CLASSIFIER,
    		e_applyRuleClassifier, c, new ErrorInformation[] {new ErrorInformation(c)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleClassifier(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Classifier c) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleClassifier_1(G, c));
  }
  
  private Classifier _applyRuleClassifier_1(final RuleEnvironment G, final Classifier c) throws RuleFailedException {
    return c;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Subcomponent s) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleSubcomponent(G, _subtrace_, s);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Subcomponent") + stringRepForEnv(G) + " |- " + stringRep(s) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSubcomponent) {
    	typeThrowException(ruleName("Subcomponent") + stringRepForEnv(G) + " |- " + stringRep(s) + " : " + "MetaClass",
    		SUBCOMPONENT,
    		e_applyRuleSubcomponent, s, new ErrorInformation[] {new ErrorInformation(s)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleSubcomponent(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Subcomponent s) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleSubcomponent_1(G, s));
  }
  
  private MetaClass _applyRuleSubcomponent_1(final RuleEnvironment G, final Subcomponent s) throws RuleFailedException {
    MetaClass _xblockexpression = null;
    {
      final MetaClass type = ExprFactory.eINSTANCE.createMetaClass();
      type.setClass(MetaClassEnum.COMPONENT);
      _xblockexpression = (type);
    }
    return _xblockexpression;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Feature f) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleFeature(G, _subtrace_, f);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Feature") + stringRepForEnv(G) + " |- " + stringRep(f) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleFeature) {
    	typeThrowException(ruleName("Feature") + stringRepForEnv(G) + " |- " + stringRep(f) + " : " + "MetaClass",
    		FEATURE,
    		e_applyRuleFeature, f, new ErrorInformation[] {new ErrorInformation(f)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleFeature(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Feature f) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleFeature_1(G, f));
  }
  
  private MetaClass _applyRuleFeature_1(final RuleEnvironment G, final Feature f) throws RuleFailedException {
    MetaClass _xblockexpression = null;
    {
      final MetaClass type = ExprFactory.eINSTANCE.createMetaClass();
      type.setClass(MetaClassEnum.FEATURE);
      _xblockexpression = (type);
    }
    return _xblockexpression;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Connection c) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleConnection(G, _subtrace_, c);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Connection") + stringRepForEnv(G) + " |- " + stringRep(c) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleConnection) {
    	typeThrowException(ruleName("Connection") + stringRepForEnv(G) + " |- " + stringRep(c) + " : " + "MetaClass",
    		CONNECTION,
    		e_applyRuleConnection, c, new ErrorInformation[] {new ErrorInformation(c)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleConnection(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Connection c) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleConnection_1(G, c));
  }
  
  private MetaClass _applyRuleConnection_1(final RuleEnvironment G, final Connection c) throws RuleFailedException {
    MetaClass _xblockexpression = null;
    {
      final MetaClass type = ExprFactory.eINSTANCE.createMetaClass();
      type.setClass(MetaClassEnum.CONNECTION);
      _xblockexpression = (type);
    }
    return _xblockexpression;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Flow f) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleFlow(G, _subtrace_, f);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Flow") + stringRepForEnv(G) + " |- " + stringRep(f) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleFlow) {
    	typeThrowException(ruleName("Flow") + stringRepForEnv(G) + " |- " + stringRep(f) + " : " + "MetaClass",
    		FLOW,
    		e_applyRuleFlow, f, new ErrorInformation[] {new ErrorInformation(f)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleFlow(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Flow f) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleFlow_1(G, f));
  }
  
  private MetaClass _applyRuleFlow_1(final RuleEnvironment G, final Flow f) throws RuleFailedException {
    MetaClass _xblockexpression = null;
    {
      final MetaClass type = ExprFactory.eINSTANCE.createMetaClass();
      type.setClass(MetaClassEnum.FLOW);
      _xblockexpression = (type);
    }
    return _xblockexpression;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Mode m) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleMode(G, _subtrace_, m);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Mode") + stringRepForEnv(G) + " |- " + stringRep(m) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleMode) {
    	typeThrowException(ruleName("Mode") + stringRepForEnv(G) + " |- " + stringRep(m) + " : " + "MetaClass",
    		MODE,
    		e_applyRuleMode, m, new ErrorInformation[] {new ErrorInformation(m)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleMode(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Mode m) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleMode_1(G, m));
  }
  
  private MetaClass _applyRuleMode_1(final RuleEnvironment G, final Mode m) throws RuleFailedException {
    MetaClass _xblockexpression = null;
    {
      final MetaClass type = ExprFactory.eINSTANCE.createMetaClass();
      type.setClass(MetaClassEnum.MODE);
      _xblockexpression = (type);
    }
    return _xblockexpression;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Property p) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleProperty(G, _subtrace_, p);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Property") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleProperty) {
    	typeThrowException(ruleName("Property") + stringRepForEnv(G) + " |- " + stringRep(p) + " : " + "MetaClass",
    		PROPERTY,
    		e_applyRuleProperty, p, new ErrorInformation[] {new ErrorInformation(p)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleProperty(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Property p) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleProperty_1(G, p));
  }
  
  private MetaClass _applyRuleProperty_1(final RuleEnvironment G, final Property p) throws RuleFailedException {
    MetaClass _xblockexpression = null;
    {
      final MetaClass type = ExprFactory.eINSTANCE.createMetaClass();
      type.setClass(MetaClassEnum.PROPERTY);
      _xblockexpression = (type);
    }
    return _xblockexpression;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlBoolean t) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleAadlBoolean(G, _subtrace_, t);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AadlBoolean") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAadlBoolean) {
    	typeThrowException(ruleName("AadlBoolean") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + "EBoolean",
    		AADLBOOLEAN,
    		e_applyRuleAadlBoolean, t, new ErrorInformation[] {new ErrorInformation(t)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleAadlBoolean(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlBoolean t) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleAadlBoolean_1(G, t));
  }
  
  private EBoolean _applyRuleAadlBoolean_1(final RuleEnvironment G, final AadlBoolean t) throws RuleFailedException {
    EBoolean _createEBoolean = ExprFactory.eINSTANCE.createEBoolean();
    return _createEBoolean;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlInteger t) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleAadlInteger(G, _subtrace_, t);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AadlInteger") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAadlInteger) {
    	typeThrowException(ruleName("AadlInteger") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + "EInteger",
    		AADLINTEGER,
    		e_applyRuleAadlInteger, t, new ErrorInformation[] {new ErrorInformation(t)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleAadlInteger(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlInteger t) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleAadlInteger_1(G, t));
  }
  
  private EInteger _applyRuleAadlInteger_1(final RuleEnvironment G, final AadlInteger t) throws RuleFailedException {
    EInteger _createEInteger = ExprFactory.eINSTANCE.createEInteger();
    return _createEInteger;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlReal t) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleAadlReal(G, _subtrace_, t);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AadlReal") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAadlReal) {
    	typeThrowException(ruleName("AadlReal") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + "EReal",
    		AADLREAL,
    		e_applyRuleAadlReal, t, new ErrorInformation[] {new ErrorInformation(t)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleAadlReal(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlReal t) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleAadlReal_1(G, t));
  }
  
  private EReal _applyRuleAadlReal_1(final RuleEnvironment G, final AadlReal t) throws RuleFailedException {
    EReal _createEReal = ExprFactory.eINSTANCE.createEReal();
    return _createEReal;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlString t) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleAadlString(G, _subtrace_, t);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AadlString") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAadlString) {
    	typeThrowException(ruleName("AadlString") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + "EString",
    		AADLSTRING,
    		e_applyRuleAadlString, t, new ErrorInformation[] {new ErrorInformation(t)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleAadlString(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AadlString t) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleAadlString_1(G, t));
  }
  
  private EString _applyRuleAadlString_1(final RuleEnvironment G, final AadlString t) throws RuleFailedException {
    EString _createEString = ExprFactory.eINSTANCE.createEString();
    return _createEString;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ListType t) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleAadlListType(G, _subtrace_, t);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AadlListType") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAadlListType) {
    	typeThrowException(ruleName("AadlListType") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + "Type",
    		AADLLISTTYPE,
    		e_applyRuleAadlListType, t, new ErrorInformation[] {new ErrorInformation(t)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleAadlListType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ListType t) throws RuleFailedException {
    Type type = null; // output parameter
    final org.osate.expr.expr.ListType lt = ExprFactory.eINSTANCE.createListType();
    lt.setName(t.getName());
    /* G |- t.elementType : var Type elementType */
    PropertyType _elementType = t.getElementType();
    Type elementType = null;
    Result<Type> result = typeInternal(G, _trace_, _elementType);
    checkAssignableTo(result.getFirst(), Type.class);
    elementType = (Type) result.getFirst();
    
    lt.setType(elementType);
    type = lt;
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RecordType t) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleAadlRecordType(G, _subtrace_, t);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AadlRecordType") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAadlRecordType) {
    	typeThrowException(ruleName("AadlRecordType") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + "Type",
    		AADLRECORDTYPE,
    		e_applyRuleAadlRecordType, t, new ErrorInformation[] {new ErrorInformation(t)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleAadlRecordType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RecordType t) throws RuleFailedException {
    Type type = null; // output parameter
    final org.osate.expr.expr.RecordType rt = ExprFactory.eINSTANCE.createRecordType();
    rt.setName(t.getName());
    final Consumer<BasicProperty> _function = (BasicProperty it) -> {
      final Field f = ExprFactory.eINSTANCE.createField();
      f.setName(it.getName());
      /* G |- propertyType : var Type fieldType */
      PropertyType _propertyType = it.getPropertyType();
      Type fieldType = null;
      Result<Type> result = typeInternal(G, _trace_, _propertyType);
      checkAssignableTo(result.getFirst(), Type.class);
      fieldType = (Type) result.getFirst();
      
      f.setType(fieldType);
    };
    t.getOwnedFields().forEach(_function);
    type = rt;
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EnumerationType t) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleAadlEnumerationType(G, _subtrace_, t);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AadlEnumerationType") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAadlEnumerationType) {
    	typeThrowException(ruleName("AadlEnumerationType") + stringRepForEnv(G) + " |- " + stringRep(t) + " : " + "Type",
    		AADLENUMERATIONTYPE,
    		e_applyRuleAadlEnumerationType, t, new ErrorInformation[] {new ErrorInformation(t)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleAadlEnumerationType(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EnumerationType t) throws RuleFailedException {
    Type type = null; // output parameter
    final EnumType et = ExprFactory.eINSTANCE.createEnumType();
    et.setName(t.getName());
    final Consumer<EnumerationLiteral> _function = (EnumerationLiteral it) -> {
      final EnumLiteral l = ExprFactory.eINSTANCE.createEnumLiteral();
      l.setName(it.getName());
    };
    t.getOwnedLiterals().forEach(_function);
    type = et;
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EBooleanLiteral e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleEBooleanLiteral(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EBooleanLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEBooleanLiteral) {
    	typeThrowException(ruleName("EBooleanLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "EBoolean",
    		EBOOLEANLITERAL,
    		e_applyRuleEBooleanLiteral, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleEBooleanLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EBooleanLiteral e) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleEBooleanLiteral_1(G, e));
  }
  
  private EBoolean _applyRuleEBooleanLiteral_1(final RuleEnvironment G, final EBooleanLiteral e) throws RuleFailedException {
    EBoolean _createEBoolean = ExprFactory.eINSTANCE.createEBoolean();
    return _createEBoolean;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EIntegerLiteral e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleEIntegerLiteral(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EIntegerLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEIntegerLiteral) {
    	typeThrowException(ruleName("EIntegerLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "EInteger",
    		EINTEGERLITERAL,
    		e_applyRuleEIntegerLiteral, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleEIntegerLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EIntegerLiteral e) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleEIntegerLiteral_1(G, e));
  }
  
  private EInteger _applyRuleEIntegerLiteral_1(final RuleEnvironment G, final EIntegerLiteral e) throws RuleFailedException {
    EInteger _createEInteger = ExprFactory.eINSTANCE.createEInteger();
    return _createEInteger;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ERealLiteral e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleERealLiteral(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ERealLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleERealLiteral) {
    	typeThrowException(ruleName("ERealLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "EReal",
    		EREALLITERAL,
    		e_applyRuleERealLiteral, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleERealLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ERealLiteral e) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleERealLiteral_1(G, e));
  }
  
  private EReal _applyRuleERealLiteral_1(final RuleEnvironment G, final ERealLiteral e) throws RuleFailedException {
    EReal _createEReal = ExprFactory.eINSTANCE.createEReal();
    return _createEReal;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EStringLiteral e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleEStringLiteral(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EStringLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEStringLiteral) {
    	typeThrowException(ruleName("EStringLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "EString",
    		ESTRINGLITERAL,
    		e_applyRuleEStringLiteral, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleEStringLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EStringLiteral e) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleEStringLiteral_1(G, e));
  }
  
  private EString _applyRuleEStringLiteral_1(final RuleEnvironment G, final EStringLiteral e) throws RuleFailedException {
    EString _createEString = ExprFactory.eINSTANCE.createEString();
    return _createEString;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ListLiteral e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleListLiteral(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ListLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleListLiteral) {
    	typeThrowException(ruleName("ListLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "ListType",
    		LISTLITERAL,
    		e_applyRuleListLiteral, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleListLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ListLiteral e) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleListLiteral_1(G, e));
  }
  
  private org.osate.expr.expr.ListType _applyRuleListLiteral_1(final RuleEnvironment G, final ListLiteral e) throws RuleFailedException {
    org.osate.expr.expr.ListType _createListType = ExprFactory.eINSTANCE.createListType();
    return _createListType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final SetLiteral e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleSetLiteral(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SetLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSetLiteral) {
    	typeThrowException(ruleName("SetLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "SetType",
    		SETLITERAL,
    		e_applyRuleSetLiteral, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleSetLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final SetLiteral e) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleSetLiteral_1(G, e));
  }
  
  private SetType _applyRuleSetLiteral_1(final RuleEnvironment G, final SetLiteral e) throws RuleFailedException {
    SetType _createSetType = ExprFactory.eINSTANCE.createSetType();
    return _createSetType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RecordLiteral e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleRecordLiteral(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("RecordLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleRecordLiteral) {
    	typeThrowException(ruleName("RecordLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "RecordType",
    		RECORDLITERAL,
    		e_applyRuleRecordLiteral, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleRecordLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RecordLiteral e) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleRecordLiteral_1(G, e));
  }
  
  private org.osate.expr.expr.RecordType _applyRuleRecordLiteral_1(final RuleEnvironment G, final RecordLiteral e) throws RuleFailedException {
    org.osate.expr.expr.RecordType _createRecordType = ExprFactory.eINSTANCE.createRecordType();
    return _createRecordType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final UnionLiteral e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleUnionLiteral(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("UnionLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleUnionLiteral) {
    	typeThrowException(ruleName("UnionLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "UnionType",
    		UNIONLITERAL,
    		e_applyRuleUnionLiteral, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleUnionLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final UnionLiteral e) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleUnionLiteral_1(G, e));
  }
  
  private UnionType _applyRuleUnionLiteral_1(final RuleEnvironment G, final UnionLiteral e) throws RuleFailedException {
    UnionType _createUnionType = ExprFactory.eINSTANCE.createUnionType();
    return _createUnionType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TupleLiteral e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleTupleLiteral(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TupleLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTupleLiteral) {
    	typeThrowException(ruleName("TupleLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "TupleType",
    		TUPLELITERAL,
    		e_applyRuleTupleLiteral, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleTupleLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TupleLiteral e) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleTupleLiteral_1(G, e));
  }
  
  private TupleType _applyRuleTupleLiteral_1(final RuleEnvironment G, final TupleLiteral e) throws RuleFailedException {
    TupleType _createTupleType = ExprFactory.eINSTANCE.createTupleType();
    return _createTupleType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BagLiteral e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleBagLiteral(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("BagLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleBagLiteral) {
    	typeThrowException(ruleName("BagLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "BagType",
    		BAGLITERAL,
    		e_applyRuleBagLiteral, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleBagLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BagLiteral e) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleBagLiteral_1(G, e));
  }
  
  private BagType _applyRuleBagLiteral_1(final RuleEnvironment G, final BagLiteral e) throws RuleFailedException {
    BagType _createBagType = ExprFactory.eINSTANCE.createBagType();
    return _createBagType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MapLiteral e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleMapLiteral(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("MapLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleMapLiteral) {
    	typeThrowException(ruleName("MapLiteral") + stringRepForEnv(G) + " |- " + stringRep(e) + " : " + "MapType",
    		MAPLITERAL,
    		e_applyRuleMapLiteral, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleMapLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final MapLiteral e) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleMapLiteral_1(G, e));
  }
  
  private MapType _applyRuleMapLiteral_1(final RuleEnvironment G, final MapLiteral e) throws RuleFailedException {
    MapType _createMapType = ExprFactory.eINSTANCE.createMapType();
    return _createMapType;
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EnumLiteral l) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleEnumLiteral(G, _subtrace_, l);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EnumLiteral") + stringRepForEnv(G) + " |- " + stringRep(l) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEnumLiteral) {
    	typeThrowException(ruleName("EnumLiteral") + stringRepForEnv(G) + " |- " + stringRep(l) + " : " + "EnumType",
    		ENUMLITERAL,
    		e_applyRuleEnumLiteral, l, new ErrorInformation[] {new ErrorInformation(l)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleEnumLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EnumLiteral l) throws RuleFailedException {
    
    return new Result<Type>(_applyRuleEnumLiteral_1(G, l));
  }
  
  private EnumType _applyRuleEnumLiteral_1(final RuleEnvironment G, final EnumLiteral l) throws RuleFailedException {
    EObject _eContainer = l.eContainer();
    return ((EnumType) _eContainer);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Field f) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleField(G, _subtrace_, f);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Field") + stringRepForEnv(G) + " |- " + stringRep(f) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleField) {
    	typeThrowException(ruleName("Field") + stringRepForEnv(G) + " |- " + stringRep(f) + " : " + "Type",
    		FIELD,
    		e_applyRuleField, f, new ErrorInformation[] {new ErrorInformation(f)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleField(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Field f) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- f.type : type */
    Type _type = f.getType();
    Result<Type> result = typeInternal(G, _trace_, _type);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Type>(type);
  }
  
  protected Result<Type> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final FieldValue v) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Type> _result_ = applyRuleFieldValue(G, _subtrace_, v);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("FieldValue") + stringRepForEnv(G) + " |- " + stringRep(v) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleFieldValue) {
    	typeThrowException(ruleName("FieldValue") + stringRepForEnv(G) + " |- " + stringRep(v) + " : " + "Type",
    		FIELDVALUE,
    		e_applyRuleFieldValue, v, new ErrorInformation[] {new ErrorInformation(v)});
    	return null;
    }
  }
  
  protected Result<Type> applyRuleFieldValue(final RuleEnvironment G, final RuleApplicationTrace _trace_, final FieldValue v) throws RuleFailedException {
    Type type = null; // output parameter
    /* G |- v.value : type */
    Expression _value = v.getValue();
    Result<Type> result = typeInternal(G, _trace_, _value);
    checkAssignableTo(result.getFirst(), Type.class);
    type = (Type) result.getFirst();
    
    return new Result<Type>(type);
  }
  
  protected Result<Boolean> sameTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EBoolean t1, final EBoolean t2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSameEBoolean(G, _subtrace_, t1, t2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SameEBoolean") + stringRepForEnv(G) + " |- " + stringRep(t1) + " ~~ " + stringRep(t2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSameEBoolean) {
    	sameTypeThrowException(ruleName("SameEBoolean") + stringRepForEnv(G) + " |- " + stringRep(t1) + " ~~ " + stringRep(t2),
    		SAMEEBOOLEAN,
    		e_applyRuleSameEBoolean, t1, t2, new ErrorInformation[] {new ErrorInformation(t1), new ErrorInformation(t2)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSameEBoolean(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EBoolean t1, final EBoolean t2) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> sameTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ENumberType t1, final ENumberType t2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSameENumber(G, _subtrace_, t1, t2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SameENumber") + stringRepForEnv(G) + " |- " + stringRep(t1) + " ~~ " + stringRep(t2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSameENumber) {
    	sameTypeThrowException(ruleName("SameENumber") + stringRepForEnv(G) + " |- " + stringRep(t1) + " ~~ " + stringRep(t2),
    		SAMEENUMBER,
    		e_applyRuleSameENumber, t1, t2, new ErrorInformation[] {new ErrorInformation(t1), new ErrorInformation(t2)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSameENumber(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ENumberType t1, final ENumberType t2) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> sameTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EString t1, final EString t2) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSameEString(G, _subtrace_, t1, t2);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SameEString") + stringRepForEnv(G) + " |- " + stringRep(t1) + " ~~ " + stringRep(t2);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSameEString) {
    	sameTypeThrowException(ruleName("SameEString") + stringRepForEnv(G) + " |- " + stringRep(t1) + " ~~ " + stringRep(t2),
    		SAMEESTRING,
    		e_applyRuleSameEString, t1, t2, new ErrorInformation[] {new ErrorInformation(t1), new ErrorInformation(t2)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleSameEString(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EString t1, final EString t2) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> sameTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ListType left, final ListType right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleSameList(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("SameList") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleSameList) {
    	sameTypeThrowException(ruleName("SameList") + stringRepForEnv(G) + " |- " + stringRep(left) + " ~~ " + stringRep(right),
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
  
  protected Result<Boolean> compatibleImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EString left, final EString right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRulePrimitiveString(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("PrimitiveString") + stringRepForEnv(G) + " |- " + stringRep(left) + " <| " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePrimitiveString) {
    	compatibleThrowException(ruleName("PrimitiveString") + stringRepForEnv(G) + " |- " + stringRep(left) + " <| " + stringRep(right),
    		PRIMITIVESTRING,
    		e_applyRulePrimitiveString, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRulePrimitiveString(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EString left, final EString right) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> compatibleImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EBoolean left, final EBoolean right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRulePrimitiveBoolean(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("PrimitiveBoolean") + stringRepForEnv(G) + " |- " + stringRep(left) + " <| " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePrimitiveBoolean) {
    	compatibleThrowException(ruleName("PrimitiveBoolean") + stringRepForEnv(G) + " |- " + stringRep(left) + " <| " + stringRep(right),
    		PRIMITIVEBOOLEAN,
    		e_applyRulePrimitiveBoolean, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRulePrimitiveBoolean(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EBoolean left, final EBoolean right) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> compatibleImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EInteger left, final EInteger right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRulePrimitiveInteger(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("PrimitiveInteger") + stringRepForEnv(G) + " |- " + stringRep(left) + " <| " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePrimitiveInteger) {
    	compatibleThrowException(ruleName("PrimitiveInteger") + stringRepForEnv(G) + " |- " + stringRep(left) + " <| " + stringRep(right),
    		PRIMITIVEINTEGER,
    		e_applyRulePrimitiveInteger, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRulePrimitiveInteger(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EInteger left, final EInteger right) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> compatibleImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EReal left, final EReal right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRulePrimitiveReal(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("PrimitiveReal") + stringRepForEnv(G) + " |- " + stringRep(left) + " <| " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePrimitiveReal) {
    	compatibleThrowException(ruleName("PrimitiveReal") + stringRepForEnv(G) + " |- " + stringRep(left) + " <| " + stringRep(right),
    		PRIMITIVEREAL,
    		e_applyRulePrimitiveReal, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRulePrimitiveReal(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EReal left, final EReal right) throws RuleFailedException {
    
    return new Result<Boolean>(true);
  }
}
