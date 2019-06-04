package org.osate.expr.evaluation;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.expr.evaluation.ExprInterpreterUtil;
import org.osate.expr.expr.BinaryOperation;
import org.osate.expr.expr.Conditional;
import org.osate.expr.expr.EBooleanLiteral;
import org.osate.expr.expr.EInteger;
import org.osate.expr.expr.EIntegerLiteral;
import org.osate.expr.expr.ENumberType;
import org.osate.expr.expr.EStringLiteral;
import org.osate.expr.expr.ExprFactory;
import org.osate.expr.expr.Expression;
import org.osate.expr.expr.Field;
import org.osate.expr.expr.FieldValue;
import org.osate.expr.expr.Literal;
import org.osate.expr.expr.NamedElementRef;
import org.osate.expr.expr.NumberLiteral;
import org.osate.expr.expr.Operation;
import org.osate.expr.expr.RecordLiteral;
import org.osate.expr.expr.UnaryOperation;
import org.osate.expr.expr.Value;
import org.osate.expr.expr.VarDecl;
import org.osate.expr.expr.WrappedNamedElement;

@SuppressWarnings("all")
public class ExprInterpreter extends XsemanticsRuntimeSystem {
  public static final String COMBINENUMERIC = "org.osate.expr.evaluation.CombineNumeric";
  
  public static final String CHOOSEROOT = "org.osate.expr.evaluation.ChooseRoot";
  
  public static final String ERRORPOSITION = "org.osate.expr.evaluation.ErrorPosition";
  
  public static final String INTERPRETBINARYEXPRESSION = "org.osate.expr.evaluation.InterpretBinaryExpression";
  
  public static final String INTERPRETUNARYEXPRESSION = "org.osate.expr.evaluation.InterpretUnaryExpression";
  
  public static final String INTERPRETVARDECL = "org.osate.expr.evaluation.InterpretVarDecl";
  
  public static final String INTERPRETNAMEDELEMENTREF = "org.osate.expr.evaluation.InterpretNamedElementRef";
  
  public static final String INTERPETITE = "org.osate.expr.evaluation.InterpetITE";
  
  public static final String INTERPRETLITERAL = "org.osate.expr.evaluation.InterpretLiteral";
  
  public static final String NOTIMPLEMENTED = "org.osate.expr.evaluation.NotImplemented";
  
  public static final String EQUALBOOLEAN = "org.osate.expr.evaluation.EqualBoolean";
  
  public static final String EQUALSTRING = "org.osate.expr.evaluation.EqualString";
  
  public static final String EQUALNUMBER = "org.osate.expr.evaluation.EqualNumber";
  
  public static final String EQUALRECORD = "org.osate.expr.evaluation.EqualRecord";
  
  public static final String COMPARENUMBERS = "org.osate.expr.evaluation.CompareNumbers";
  
  public static final String COMPARETONUMBER = "org.osate.expr.evaluation.CompareToNumber";
  
  private PolymorphicDispatcher<ENumberType> combineNumericDispatcher;
  
  private PolymorphicDispatcher<InstanceObject> chooseRootDispatcher;
  
  private PolymorphicDispatcher<String> errorPositionDispatcher;
  
  private PolymorphicDispatcher<Result<Value>> interpretExpressionDispatcher;
  
  private PolymorphicDispatcher<Result<Value>> interpretVariableDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> equalDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> compareDispatcher;
  
  private PolymorphicDispatcher<Result<Integer>> cmpNumDispatcher;
  
  public ExprInterpreter() {
    init();
  }
  
  public void init() {
    interpretExpressionDispatcher = buildPolymorphicDispatcher1(
    	"interpretExpressionImpl", 3, "|-", "~>");
    interpretVariableDispatcher = buildPolymorphicDispatcher1(
    	"interpretVariableImpl", 3, "||-", "~>");
    equalDispatcher = buildPolymorphicDispatcher1(
    	"equalImpl", 4, "|=", ":");
    compareDispatcher = buildPolymorphicDispatcher1(
    	"compareImpl", 4, "|>", ":");
    cmpNumDispatcher = buildPolymorphicDispatcher1(
    	"cmpNumImpl", 4, "|>", ":", "~>");
    combineNumericDispatcher = buildPolymorphicDispatcher(
    	"combineNumericImpl", 3);
    chooseRootDispatcher = buildPolymorphicDispatcher(
    	"chooseRootImpl", 3);
    errorPositionDispatcher = buildPolymorphicDispatcher(
    	"errorPositionImpl", 2);
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
  
  public InstanceObject chooseRoot(final EObject io, final RuleEnvironment G) throws RuleFailedException {
    return chooseRoot(null, io, G);
  }
  
  public InstanceObject chooseRoot(final RuleApplicationTrace _trace_, final EObject io, final RuleEnvironment G) throws RuleFailedException {
    try {
    	return chooseRootInternal(_trace_, io, G);
    } catch (Exception _e_chooseRoot) {
    	throw extractRuleFailedException(_e_chooseRoot);
    }
  }
  
  public String errorPosition(final EObject o) throws RuleFailedException {
    return errorPosition(null, o);
  }
  
  public String errorPosition(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	return errorPositionInternal(_trace_, o);
    } catch (Exception _e_errorPosition) {
    	throw extractRuleFailedException(_e_errorPosition);
    }
  }
  
  public Result<Value> interpretExpression(final Expression expression) {
    return interpretExpression(new RuleEnvironment(), null, expression);
  }
  
  public Result<Value> interpretExpression(final RuleEnvironment _environment_, final Expression expression) {
    return interpretExpression(_environment_, null, expression);
  }
  
  public Result<Value> interpretExpression(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	return interpretExpressionInternal(_environment_, _trace_, expression);
    } catch (Exception _e_interpretExpression) {
    	return resultForFailure(_e_interpretExpression);
    }
  }
  
  public Result<Value> interpretVariable(final VarDecl decl) {
    return interpretVariable(new RuleEnvironment(), null, decl);
  }
  
  public Result<Value> interpretVariable(final RuleEnvironment _environment_, final VarDecl decl) {
    return interpretVariable(_environment_, null, decl);
  }
  
  public Result<Value> interpretVariable(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VarDecl decl) {
    try {
    	return interpretVariableInternal(_environment_, _trace_, decl);
    } catch (Exception _e_interpretVariable) {
    	return resultForFailure(_e_interpretVariable);
    }
  }
  
  public Result<Boolean> equal(final Value left, final Value right) {
    return equal(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Boolean> equal(final RuleEnvironment _environment_, final Value left, final Value right) {
    return equal(_environment_, null, left, right);
  }
  
  public Result<Boolean> equal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Value left, final Value right) {
    try {
    	return equalInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_equal) {
    	return resultForFailure(_e_equal);
    }
  }
  
  public Boolean equalSucceeded(final Value left, final Value right) {
    return equalSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  public Boolean equalSucceeded(final RuleEnvironment _environment_, final Value left, final Value right) {
    return equalSucceeded(_environment_, null, left, right);
  }
  
  public Boolean equalSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Value left, final Value right) {
    try {
    	equalInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_equal) {
    	return false;
    }
  }
  
  public Result<Boolean> compare(final Value left, final Value right) {
    return compare(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Boolean> compare(final RuleEnvironment _environment_, final Value left, final Value right) {
    return compare(_environment_, null, left, right);
  }
  
  public Result<Boolean> compare(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Value left, final Value right) {
    try {
    	return compareInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_compare) {
    	return resultForFailure(_e_compare);
    }
  }
  
  public Boolean compareSucceeded(final Value left, final Value right) {
    return compareSucceeded(new RuleEnvironment(), null, left, right);
  }
  
  public Boolean compareSucceeded(final RuleEnvironment _environment_, final Value left, final Value right) {
    return compareSucceeded(_environment_, null, left, right);
  }
  
  public Boolean compareSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Value left, final Value right) {
    try {
    	compareInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_compare) {
    	return false;
    }
  }
  
  public Result<Integer> cmpNum(final Value left, final Value right) {
    return cmpNum(new RuleEnvironment(), null, left, right);
  }
  
  public Result<Integer> cmpNum(final RuleEnvironment _environment_, final Value left, final Value right) {
    return cmpNum(_environment_, null, left, right);
  }
  
  public Result<Integer> cmpNum(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Value left, final Value right) {
    try {
    	return cmpNumInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_cmpNum) {
    	return resultForFailure(_e_cmpNum);
    }
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
  
  protected InstanceObject chooseRootInternal(final RuleApplicationTrace _trace_, final EObject io, final RuleEnvironment G) {
    try {
    	checkParamsNotNull(io, G);
    	return chooseRootDispatcher.invoke(_trace_, io, G);
    } catch (Exception _e_chooseRoot) {
    	sneakyThrowRuleFailedException(_e_chooseRoot);
    	return null;
    }
  }
  
  protected void chooseRootThrowException(final String _error, final String _issue, final Exception _ex, final EObject io, final RuleEnvironment G, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected String errorPositionInternal(final RuleApplicationTrace _trace_, final EObject o) {
    try {
    	checkParamsNotNull(o);
    	return errorPositionDispatcher.invoke(_trace_, o);
    } catch (Exception _e_errorPosition) {
    	sneakyThrowRuleFailedException(_e_errorPosition);
    	return null;
    }
  }
  
  protected void errorPositionThrowException(final String _error, final String _issue, final Exception _ex, final EObject o, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Value> interpretExpressionInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Expression expression) {
    try {
    	checkParamsNotNull(expression);
    	return interpretExpressionDispatcher.invoke(_environment_, _trace_, expression);
    } catch (Exception _e_interpretExpression) {
    	sneakyThrowRuleFailedException(_e_interpretExpression);
    	return null;
    }
  }
  
  protected void interpretExpressionThrowException(final String _error, final String _issue, final Exception _ex, final Expression expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Value> interpretVariableInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VarDecl decl) {
    try {
    	checkParamsNotNull(decl);
    	return interpretVariableDispatcher.invoke(_environment_, _trace_, decl);
    } catch (Exception _e_interpretVariable) {
    	sneakyThrowRuleFailedException(_e_interpretVariable);
    	return null;
    }
  }
  
  protected void interpretVariableThrowException(final String _error, final String _issue, final Exception _ex, final VarDecl decl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Boolean> equalInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Value left, final Value right) {
    try {
    	checkParamsNotNull(left, right);
    	return equalDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_equal) {
    	sneakyThrowRuleFailedException(_e_equal);
    	return null;
    }
  }
  
  protected void equalThrowException(final String _error, final String _issue, final Exception _ex, final Value left, final Value right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Boolean> compareInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Value left, final Value right) {
    try {
    	checkParamsNotNull(left, right);
    	return compareDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_compare) {
    	sneakyThrowRuleFailedException(_e_compare);
    	return null;
    }
  }
  
  protected void compareThrowException(final String _error, final String _issue, final Exception _ex, final Value left, final Value right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Integer> cmpNumInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Value left, final Value right) {
    try {
    	checkParamsNotNull(left, right);
    	return cmpNumDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_cmpNum) {
    	sneakyThrowRuleFailedException(_e_cmpNum);
    	return null;
    }
  }
  
  protected void cmpNumThrowException(final String _error, final String _issue, final Exception _ex, final Value left, final Value right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
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
  
  protected InstanceObject chooseRootImpl(final RuleApplicationTrace _trace_, final EObject obj, final RuleEnvironment G) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final InstanceObject _result_ = applyAuxFunChooseRoot(_subtrace_, obj, G);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("chooseRoot") + "(" + stringRep(obj) + ", " + stringRep(G)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunChooseRoot) {
    	chooseRootThrowException(auxFunName("chooseRoot") + "(" + stringRep(obj) + ", " + stringRep(G)+ ")",
    		CHOOSEROOT,
    		e_applyAuxFunChooseRoot, obj, G, new ErrorInformation[] {new ErrorInformation(obj)});
    	return null;
    }
  }
  
  protected InstanceObject applyAuxFunChooseRoot(final RuleApplicationTrace _trace_, final EObject obj, final RuleEnvironment G) throws RuleFailedException {
    InstanceObject _xblockexpression = null;
    {
      final InstanceObject component = this.<InstanceObject>env(G, "component", InstanceObject.class);
      final NamedElement element = this.<NamedElement>env(G, "element", NamedElement.class);
      InstanceObject _xifexpression = null;
      if ((element instanceof InstanceObject)) {
        _xifexpression = ((InstanceObject)element);
      } else {
        _xifexpression = component;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
  }
  
  protected String errorPositionImpl(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final String _result_ = applyAuxFunErrorPosition(_subtrace_, o);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return auxFunName("errorPosition") + "(" + stringRep(o)+ ")" + " = " + stringRep(_result_);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyAuxFunErrorPosition) {
    	errorPositionThrowException(auxFunName("errorPosition") + "(" + stringRep(o)+ ")",
    		ERRORPOSITION,
    		e_applyAuxFunErrorPosition, o, new ErrorInformation[] {new ErrorInformation(o)});
    	return null;
    }
  }
  
  protected String applyAuxFunErrorPosition(final RuleApplicationTrace _trace_, final EObject o) throws RuleFailedException {
    String _xblockexpression = null;
    {
      final String fileName = o.eResource().getURI().path();
      final int line = NodeModelUtils.findActualNodeFor(o).getStartLine();
      _xblockexpression = (((((" (" + fileName) + ":") + Integer.valueOf(line)) + ")"));
    }
    return _xblockexpression;
  }
  
  protected Result<Value> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BinaryOperation binary) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Value> _result_ = applyRuleInterpretBinaryExpression(G, _subtrace_, binary);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretBinaryExpression") + stringRepForEnv(G) + " |- " + stringRep(binary) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretBinaryExpression) {
    	interpretExpressionThrowException(ruleName("InterpretBinaryExpression") + stringRepForEnv(G) + " |- " + stringRep(binary) + " ~> " + "Value",
    		INTERPRETBINARYEXPRESSION,
    		e_applyRuleInterpretBinaryExpression, binary, new ErrorInformation[] {new ErrorInformation(binary)});
    	return null;
    }
  }
  
  protected Result<Value> applyRuleInterpretBinaryExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BinaryOperation binary) throws RuleFailedException {
    Value value = null; // output parameter
    /* G |- binary.left ~> var Value leftVal */
    Expression _left = binary.getLeft();
    Value leftVal = null;
    Result<Value> result = interpretExpressionInternal(G, _trace_, _left);
    checkAssignableTo(result.getFirst(), Value.class);
    leftVal = (Value) result.getFirst();
    
    /* G |- binary.right ~> var Value rightVal */
    Expression _right = binary.getRight();
    Value rightVal = null;
    Result<Value> result_1 = interpretExpressionInternal(G, _trace_, _right);
    checkAssignableTo(result_1.getFirst(), Value.class);
    rightVal = (Value) result_1.getFirst();
    
    Literal _switchResult = null;
    Operation _operator = binary.getOperator();
    if (_operator != null) {
      switch (_operator) {
        case AND:
        case OR:
        case ALT_AND:
        case ALT_OR:
          EBooleanLiteral _xblockexpression = null;
          {
            final EBooleanLiteral boolVal = ExprFactory.eINSTANCE.createEBooleanLiteral();
            final EBooleanLiteral left = ((EBooleanLiteral) leftVal);
            final EBooleanLiteral right = ((EBooleanLiteral) rightVal);
            boolean _xifexpression = false;
            Operation _operator_1 = binary.getOperator();
            boolean _equals = Objects.equal(_operator_1, Operation.AND);
            if (_equals) {
              boolean _xifexpression_1 = false;
              if ((left.isValue() && right.isValue())) {
                _xifexpression_1 = true;
              } else {
                _xifexpression_1 = false;
              }
              _xifexpression = _xifexpression_1;
            } else {
              boolean _xifexpression_2 = false;
              if ((left.isValue() || right.isValue())) {
                _xifexpression_2 = true;
              } else {
                _xifexpression_2 = false;
              }
              _xifexpression = _xifexpression_2;
            }
            boolVal.setValue(_xifexpression);
            _xblockexpression = (boolVal);
          }
          _switchResult = _xblockexpression;
          break;
        case EQ:
        case NEQ:
          EBooleanLiteral _xblockexpression_1 = null;
          {
            final EBooleanLiteral boolVal = ExprFactory.eINSTANCE.createEBooleanLiteral();
            /* G |= leftVal : rightVal */
            boolean _ruleinvocation = equalSucceeded(G, _trace_, leftVal, rightVal);
            boolVal.setValue(_ruleinvocation);
            Operation _operator_1 = binary.getOperator();
            boolean _equals = Objects.equal(_operator_1, Operation.NEQ);
            if (_equals) {
              boolean _isValue = boolVal.isValue();
              boolean _not = (!_isValue);
              boolVal.setValue(_not);
            }
            _xblockexpression_1 = (boolVal);
          }
          _switchResult = _xblockexpression_1;
          break;
        case LT:
          EBooleanLiteral _xblockexpression_2 = null;
          {
            final EBooleanLiteral boolVal = ExprFactory.eINSTANCE.createEBooleanLiteral();
            /* G, 'op' <- binary.operator |> leftVal : rightVal */
            Operation _operator_1 = binary.getOperator();
            boolean _ruleinvocation = compareSucceeded(environmentComposition(
              G, environmentEntry("op", _operator_1)
            ), _trace_, leftVal, rightVal);
            boolVal.setValue(_ruleinvocation);
            _xblockexpression_2 = (boolVal);
          }
          _switchResult = _xblockexpression_2;
          break;
        case LEQ:
          EBooleanLiteral _xblockexpression_3 = null;
          {
            final EBooleanLiteral boolVal = ExprFactory.eINSTANCE.createEBooleanLiteral();
            /* G, 'op' <- binary.operator |> leftVal : rightVal */
            Operation _operator_1 = binary.getOperator();
            boolean _ruleinvocation = compareSucceeded(environmentComposition(
              G, environmentEntry("op", _operator_1)
            ), _trace_, leftVal, rightVal);
            boolVal.setValue(_ruleinvocation);
            _xblockexpression_3 = (boolVal);
          }
          _switchResult = _xblockexpression_3;
          break;
        case GT:
          EBooleanLiteral _xblockexpression_4 = null;
          {
            final EBooleanLiteral boolVal = ExprFactory.eINSTANCE.createEBooleanLiteral();
            /* G, 'op' <- binary.operator |> leftVal : rightVal */
            Operation _operator_1 = binary.getOperator();
            boolean _ruleinvocation = compareSucceeded(environmentComposition(
              G, environmentEntry("op", _operator_1)
            ), _trace_, leftVal, rightVal);
            boolVal.setValue(_ruleinvocation);
            _xblockexpression_4 = (boolVal);
          }
          _switchResult = _xblockexpression_4;
          break;
        case GEQ:
          EBooleanLiteral _xblockexpression_5 = null;
          {
            final EBooleanLiteral boolVal = ExprFactory.eINSTANCE.createEBooleanLiteral();
            /* G, 'op' <- binary.operator |> leftVal : rightVal */
            Operation _operator_1 = binary.getOperator();
            boolean _ruleinvocation = compareSucceeded(environmentComposition(
              G, environmentEntry("op", _operator_1)
            ), _trace_, leftVal, rightVal);
            boolVal.setValue(_ruleinvocation);
            _xblockexpression_5 = (boolVal);
          }
          _switchResult = _xblockexpression_5;
          break;
        case IN:
          EBooleanLiteral _xblockexpression_6 = null;
          {
            final EBooleanLiteral boolVal = ExprFactory.eINSTANCE.createEBooleanLiteral();
            boolean _matched = false;
            if (leftVal instanceof NumberLiteral) {
              _matched=true;
              /* G, 'op' <- Operation.LT |> leftVal : rightVal */
              boolean _ruleinvocation = compareSucceeded(environmentComposition(
                G, environmentEntry("op", Operation.LT)
              ), _trace_, ((NumberLiteral)leftVal), rightVal);
              final boolean lessThan = _ruleinvocation;
              /* G, 'op' <- Operation.GT |> leftVal : rightVal */
              boolean _ruleinvocation_1 = compareSucceeded(environmentComposition(
                G, environmentEntry("op", Operation.GT)
              ), _trace_, ((NumberLiteral)leftVal), rightVal);
              final boolean greaterThan = _ruleinvocation_1;
              boolVal.setValue((!(lessThan || greaterThan)));
            }
            _xblockexpression_6 = (boolVal);
          }
          _switchResult = _xblockexpression_6;
          break;
        case PLUS:
          _switchResult = ExprInterpreterUtil.add(((NumberLiteral) leftVal), ((NumberLiteral) rightVal));
          break;
        case MINUS:
          _switchResult = ExprInterpreterUtil.subtract(((NumberLiteral) leftVal), ((NumberLiteral) rightVal));
          break;
        case MULT:
          _switchResult = ExprInterpreterUtil.multiply(((NumberLiteral) leftVal), ((NumberLiteral) rightVal));
          break;
        case DIV:
          _switchResult = ExprInterpreterUtil.divide(((NumberLiteral) leftVal), ((NumberLiteral) rightVal));
          break;
        case INTDIV:
          _switchResult = ExprInterpreterUtil.divideInt(((EIntegerLiteral) leftVal), ((EIntegerLiteral) rightVal));
          break;
        case MOD:
          _switchResult = ExprInterpreterUtil.mod(((EIntegerLiteral) leftVal), ((EIntegerLiteral) rightVal));
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    value = _switchResult;
    return new Result<Value>(value);
  }
  
  protected Result<Value> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final UnaryOperation unary) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Value> _result_ = applyRuleInterpretUnaryExpression(G, _subtrace_, unary);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretUnaryExpression") + stringRepForEnv(G) + " |- " + stringRep(unary) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretUnaryExpression) {
    	interpretExpressionThrowException(ruleName("InterpretUnaryExpression") + stringRepForEnv(G) + " |- " + stringRep(unary) + " ~> " + "Literal",
    		INTERPRETUNARYEXPRESSION,
    		e_applyRuleInterpretUnaryExpression, unary, new ErrorInformation[] {new ErrorInformation(unary)});
    	return null;
    }
  }
  
  protected Result<Value> applyRuleInterpretUnaryExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final UnaryOperation unary) throws RuleFailedException {
    Literal propVal = null; // output parameter
    /* G |- unary.operand ~> propVal */
    Expression _operand = unary.getOperand();
    Result<Value> result = interpretExpressionInternal(G, _trace_, _operand);
    checkAssignableTo(result.getFirst(), Literal.class);
    propVal = (Literal) result.getFirst();
    
    Operation _operator = unary.getOperator();
    if (_operator != null) {
      switch (_operator) {
        case MINUS:
          boolean _matched = false;
          if (propVal instanceof RealLiteral) {
            _matched=true;
            double _value = ((RealLiteral)propVal).getValue();
            double _minus = (-_value);
            ((RealLiteral)propVal).setValue(_minus);
          }
          if (!_matched) {
            if (propVal instanceof IntegerLiteral) {
              _matched=true;
              long _value = ((IntegerLiteral)propVal).getValue();
              long _minus = (-_value);
              ((IntegerLiteral)propVal).setValue(_minus);
            }
          }
          break;
        case NOT:
          boolean _matched_1 = false;
          if (propVal instanceof BooleanLiteral) {
            _matched_1=true;
            boolean _value = ((BooleanLiteral)propVal).getValue();
            boolean _not = (!_value);
            ((BooleanLiteral)propVal).setValue(_not);
          }
          break;
        default:
          break;
      }
    } else {
    }
    return new Result<Value>(propVal);
  }
  
  protected Result<Value> interpretVariableImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VarDecl varDecl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Value> _result_ = applyRuleInterpretVarDecl(G, _subtrace_, varDecl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretVarDecl") + stringRepForEnv(G) + " ||- " + stringRep(varDecl) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretVarDecl) {
    	interpretVariableThrowException(ruleName("InterpretVarDecl") + stringRepForEnv(G) + " ||- " + stringRep(varDecl) + " ~> " + "Literal",
    		INTERPRETVARDECL,
    		e_applyRuleInterpretVarDecl, varDecl, new ErrorInformation[] {new ErrorInformation(varDecl)});
    	return null;
    }
  }
  
  protected Result<Value> applyRuleInterpretVarDecl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VarDecl varDecl) throws RuleFailedException {
    Literal propVal = null; // output parameter
    Object _env = this.<Object>env(G, "vals", Object.class);
    final HashMap<VarDecl, Literal> map = ((HashMap<VarDecl, Literal>) _env);
    boolean _containsKey = map.containsKey(varDecl);
    if (_containsKey) {
      propVal = map.get(varDecl);
    } else {
      /* G |- varDecl.value ~> propVal */
      Expression _value = varDecl.getValue();
      Result<Value> result = interpretExpressionInternal(G, _trace_, _value);
      checkAssignableTo(result.getFirst(), Literal.class);
      propVal = (Literal) result.getFirst();
      
      map.put(varDecl, propVal);
    }
    return new Result<Value>(propVal);
  }
  
  protected Result<Value> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NamedElementRef ner) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Value> _result_ = applyRuleInterpretNamedElementRef(G, _subtrace_, ner);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretNamedElementRef") + stringRepForEnv(G) + " |- " + stringRep(ner) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretNamedElementRef) {
    	interpretExpressionThrowException(ruleName("InterpretNamedElementRef") + stringRepForEnv(G) + " |- " + stringRep(ner) + " ~> " + "Value",
    		INTERPRETNAMEDELEMENTREF,
    		e_applyRuleInterpretNamedElementRef, ner, new ErrorInformation[] {new ErrorInformation(ner)});
    	return null;
    }
  }
  
  protected Result<Value> applyRuleInterpretNamedElementRef(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NamedElementRef ner) throws RuleFailedException {
    Value value = null; // output parameter
    final NamedElement ref = ner.getRef();
    boolean _matched = false;
    if (ref instanceof VarDecl) {
      _matched=true;
      /* G |- ref.value ~> value */
      Expression _value = ((VarDecl)ref).getValue();
      Result<Value> result = interpretExpressionInternal(G, _trace_, _value);
      checkAssignableTo(result.getFirst(), Value.class);
      value = (Value) result.getFirst();
      
    }
    if (!_matched) {
      if (ref instanceof Field) {
        _matched=true;
        /* fail error 'not implemented' source ner */
        String error = "not implemented";
        EObject source = ner;
        throwForExplicitFail(error, new ErrorInformation(source, null));
      }
    }
    if (!_matched) {
      InstanceObject _xblockexpression = null;
      {
        final InstanceObject root = this.<InstanceObject>env(G, "component", InstanceObject.class);
        _xblockexpression = (ExprInterpreterUtil.resolve(ner, root));
      }
      final InstanceObject resolved = _xblockexpression;
      final WrappedNamedElement wne = ExprFactory.eINSTANCE.createWrappedNamedElement();
      wne.setElem(resolved);
      value = wne;
    }
    return new Result<Value>(value);
  }
  
  protected Result<Value> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Conditional ite) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Value> _result_ = applyRuleInterpetITE(G, _subtrace_, ite);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpetITE") + stringRepForEnv(G) + " |- " + stringRep(ite) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpetITE) {
    	interpretExpressionThrowException(ruleName("InterpetITE") + stringRepForEnv(G) + " |- " + stringRep(ite) + " ~> " + "Literal",
    		INTERPETITE,
    		e_applyRuleInterpetITE, ite, new ErrorInformation[] {new ErrorInformation(ite)});
    	return null;
    }
  }
  
  protected Result<Value> applyRuleInterpetITE(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Conditional ite) throws RuleFailedException {
    Literal propVal = null; // output parameter
    /* G |- ite.^if ~> var EBooleanLiteral cond */
    Expression _if = ite.getIf();
    EBooleanLiteral cond = null;
    Result<Value> result = interpretExpressionInternal(G, _trace_, _if);
    checkAssignableTo(result.getFirst(), EBooleanLiteral.class);
    cond = (EBooleanLiteral) result.getFirst();
    
    boolean _isValue = cond.isValue();
    if (_isValue) {
      /* G |- ite.then ~> propVal */
      Expression _then = ite.getThen();
      Result<Value> result_1 = interpretExpressionInternal(G, _trace_, _then);
      checkAssignableTo(result_1.getFirst(), Literal.class);
      propVal = (Literal) result_1.getFirst();
      
    } else {
      /* G |- ite.^else ~> propVal */
      Expression _else = ite.getElse();
      Result<Value> result_2 = interpretExpressionInternal(G, _trace_, _else);
      checkAssignableTo(result_2.getFirst(), Literal.class);
      propVal = (Literal) result_2.getFirst();
      
    }
    return new Result<Value>(propVal);
  }
  
  protected Result<Value> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Literal l) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Value> _result_ = applyRuleInterpretLiteral(G, _subtrace_, l);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretLiteral") + stringRepForEnv(G) + " |- " + stringRep(l) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretLiteral) {
    	interpretExpressionThrowException(ruleName("InterpretLiteral") + stringRepForEnv(G) + " |- " + stringRep(l) + " ~> " + "Literal",
    		INTERPRETLITERAL,
    		e_applyRuleInterpretLiteral, l, new ErrorInformation[] {new ErrorInformation(l)});
    	return null;
    }
  }
  
  protected Result<Value> applyRuleInterpretLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Literal l) throws RuleFailedException {
    
    return new Result<Value>(_applyRuleInterpretLiteral_1(G, l));
  }
  
  private Literal _applyRuleInterpretLiteral_1(final RuleEnvironment G, final Literal l) throws RuleFailedException {
    return l;
  }
  
  protected Result<Value> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression e) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Value> _result_ = applyRuleNotImplemented(G, _subtrace_, e);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("NotImplemented") + stringRepForEnv(G) + " |- " + stringRep(e) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleNotImplemented) {
    	interpretExpressionThrowException(ruleName("NotImplemented") + stringRepForEnv(G) + " |- " + stringRep(e) + " ~> " + "Literal",
    		NOTIMPLEMENTED,
    		e_applyRuleNotImplemented, e, new ErrorInformation[] {new ErrorInformation(e)});
    	return null;
    }
  }
  
  protected Result<Value> applyRuleNotImplemented(final RuleEnvironment G, final RuleApplicationTrace _trace_, final Expression e) throws RuleFailedException {
    Literal l = null; // output parameter
    /* fail error 'not implemented' source e */
    String error = "not implemented";
    EObject source = e;
    throwForExplicitFail(error, new ErrorInformation(source, null));
    return new Result<Value>(l);
  }
  
  protected Result<Boolean> equalImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EBooleanLiteral left, final EBooleanLiteral right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleEqualBoolean(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EqualBoolean") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEqualBoolean) {
    	equalThrowException(ruleName("EqualBoolean") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right),
    		EQUALBOOLEAN,
    		e_applyRuleEqualBoolean, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleEqualBoolean(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EBooleanLiteral left, final EBooleanLiteral right) throws RuleFailedException {
    boolean _isValue = left.isValue();
    boolean _isValue_1 = right.isValue();
    /* left.value == right.value */
    if (!(_isValue == _isValue_1)) {
      sneakyThrowRuleFailedException("left.value == right.value");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> equalImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EStringLiteral left, final EStringLiteral right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleEqualString(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EqualString") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEqualString) {
    	equalThrowException(ruleName("EqualString") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right),
    		EQUALSTRING,
    		e_applyRuleEqualString, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleEqualString(final RuleEnvironment G, final RuleApplicationTrace _trace_, final EStringLiteral left, final EStringLiteral right) throws RuleFailedException {
    /* left.value.equals(right.value) */
    if (!left.getValue().equals(right.getValue())) {
      sneakyThrowRuleFailedException("left.value.equals(right.value)");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> equalImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberLiteral left, final NumberLiteral right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleEqualNumber(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EqualNumber") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEqualNumber) {
    	equalThrowException(ruleName("EqualNumber") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right),
    		EQUALNUMBER,
    		e_applyRuleEqualNumber, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleEqualNumber(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberLiteral left, final NumberLiteral right) throws RuleFailedException {
    int _compareTo = ExprInterpreterUtil.compareTo(left, right);
    /* left.compareTo(right) == 0 */
    if (!(_compareTo == 0)) {
      sneakyThrowRuleFailedException("left.compareTo(right) == 0");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> equalImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RecordLiteral left, final RecordLiteral right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleEqualRecord(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EqualRecord") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEqualRecord) {
    	equalThrowException(ruleName("EqualRecord") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right),
    		EQUALRECORD,
    		e_applyRuleEqualRecord, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleEqualRecord(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RecordLiteral left, final RecordLiteral right) throws RuleFailedException {
    final Function1<FieldValue, Literal> _function = (FieldValue it) -> {
      Literal _xblockexpression = null;
      {
        /* G |- it.value ~> var Literal value */
        Expression _value = it.getValue();
        Literal value = null;
        Result<Value> result = interpretExpressionInternal(G, _trace_, _value);
        checkAssignableTo(result.getFirst(), Literal.class);
        value = (Literal) result.getFirst();
        
        _xblockexpression = value;
      }
      return _xblockexpression;
    };
    final List<Literal> leftVals = ListExtensions.<FieldValue, Literal>map(left.getFieldValues(), _function);
    final Function1<FieldValue, Literal> _function_1 = (FieldValue it) -> {
      Literal _xblockexpression = null;
      {
        /* G |- it.value ~> var Literal value */
        Expression _value = it.getValue();
        Literal value = null;
        Result<Value> result = interpretExpressionInternal(G, _trace_, _value);
        checkAssignableTo(result.getFirst(), Literal.class);
        value = (Literal) result.getFirst();
        
        _xblockexpression = value;
      }
      return _xblockexpression;
    };
    final List<Literal> rightVals = ListExtensions.<FieldValue, Literal>map(right.getFieldValues(), _function_1);
    final Iterator<Literal> rightIter = rightVals.iterator();
    final Function1<Literal, Boolean> _function_2 = (Literal l) -> {
      boolean _xblockexpression = false;
      {
        final Literal r = rightIter.next();
        /* G |= l : r */
        boolean _ruleinvocation = equalSucceeded(G, _trace_, l, r);
        _xblockexpression = _ruleinvocation;
      }
      return Boolean.valueOf(_xblockexpression);
    };
    /* leftVals.forall[ l | val r = rightIter.next; G |= l : r ] */
    if (!IterableExtensions.<Literal>forall(leftVals, _function_2)) {
      sneakyThrowRuleFailedException("leftVals.forall[ l | val r = rightIter.next; G |= l : r ]");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> compareImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberLiteral left, final NumberLiteral right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCompareNumbers(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CompareNumbers") + stringRepForEnv(G) + " |> " + stringRep(left) + " : " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCompareNumbers) {
    	compareThrowException(ruleName("CompareNumbers") + stringRepForEnv(G) + " |> " + stringRep(left) + " : " + stringRep(right),
    		COMPARENUMBERS,
    		e_applyRuleCompareNumbers, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleCompareNumbers(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberLiteral left, final NumberLiteral right) throws RuleFailedException {
    /* G |> left : right ~> var Integer cmp */
    Integer cmp = null;
    Result<Integer> result = cmpNumInternal(G, _trace_, left, right);
    checkAssignableTo(result.getFirst(), Integer.class);
    cmp = (Integer) result.getFirst();
    
    final Operation op = this.<Operation>env(G, "op", Operation.class);
    boolean _switchResult = false;
    if (op != null) {
      switch (op) {
        case LT:
          _switchResult = ((cmp).intValue() < 0);
          break;
        case LEQ:
          _switchResult = ((cmp).intValue() <= 0);
          break;
        case GT:
          _switchResult = ((cmp).intValue() > 0);
          break;
        case GEQ:
          _switchResult = ((cmp).intValue() >= 0);
          break;
        default:
          _switchResult = false;
          break;
      }
    } else {
      _switchResult = false;
    }
    final boolean b = _switchResult;
    /* b */
    if (!b) {
      sneakyThrowRuleFailedException("b");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Integer> cmpNumImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberLiteral left, final NumberLiteral right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Integer> _result_ = applyRuleCompareToNumber(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CompareToNumber") + stringRepForEnv(G) + " |> " + stringRep(left) + " : " + stringRep(right) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCompareToNumber) {
    	cmpNumThrowException(ruleName("CompareToNumber") + stringRepForEnv(G) + " |> " + stringRep(left) + " : " + stringRep(right) + " ~> " + "Integer",
    		COMPARETONUMBER,
    		e_applyRuleCompareToNumber, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }
  
  protected Result<Integer> applyRuleCompareToNumber(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberLiteral left, final NumberLiteral right) throws RuleFailedException {
    Integer cmp = null; // output parameter
    cmp = Integer.valueOf(ExprInterpreterUtil.compareTo(left, right));
    return new Result<Integer>(cmp);
  }
}
