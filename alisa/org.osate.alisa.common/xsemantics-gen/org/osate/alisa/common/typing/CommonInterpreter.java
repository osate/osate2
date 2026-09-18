package org.osate.alisa.common.typing;

import com.google.inject.Provider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyValue;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.alisa.common.common.ABinaryOperation;
import org.osate.alisa.common.common.AConditional;
import org.osate.alisa.common.common.AFunctionCall;
import org.osate.alisa.common.common.AModelReference;
import org.osate.alisa.common.common.APropertyReference;
import org.osate.alisa.common.common.ARange;
import org.osate.alisa.common.common.AUnaryOperation;
import org.osate.alisa.common.common.AUnitExpression;
import org.osate.alisa.common.common.AVariableDeclaration;
import org.osate.alisa.common.common.AVariableReference;
import org.osate.alisa.common.common.ComputeDeclaration;
import org.osate.alisa.common.common.Operation;
import org.osate.alisa.common.common.ValDeclaration;

@SuppressWarnings("all")
public class CommonInterpreter extends XsemanticsRuntimeSystem {
  public static final String COMBINENUMERIC = "org.osate.alisa.common.typing.CombineNumeric";

  public static final String CHOOSEROOT = "org.osate.alisa.common.typing.ChooseRoot";

  public static final String ERRORPOSITION = "org.osate.alisa.common.typing.ErrorPosition";

  public static final String INTERPRETBINARYEXPRESSION = "org.osate.alisa.common.typing.InterpretBinaryExpression";

  public static final String INTERPRETFUNCTIONCALL = "org.osate.alisa.common.typing.InterpretFunctionCall";

  public static final String INTERPRETUNARYEXPRESSION = "org.osate.alisa.common.typing.InterpretUnaryExpression";

  public static final String INTERPRETUNITEXPRESSION = "org.osate.alisa.common.typing.InterpretUnitExpression";

  public static final String INTERPRETVAL = "org.osate.alisa.common.typing.InterpretVal";

  public static final String INTERPRETCOMPUTE = "org.osate.alisa.common.typing.InterpretCompute";

  public static final String INTERPRETVARREF = "org.osate.alisa.common.typing.InterpretVarRef";

  public static final String INTERPETITE = "org.osate.alisa.common.typing.InterpetITE";

  public static final String INTERPRETMODELREFERENCE = "org.osate.alisa.common.typing.InterpretModelReference";

  public static final String INTERPRETPROPERTYREFERENCE = "org.osate.alisa.common.typing.InterpretPropertyReference";

  public static final String INTERPRETINTEGERLITERAL = "org.osate.alisa.common.typing.InterpretIntegerLiteral";

  public static final String INTERPRETREALLITERAL = "org.osate.alisa.common.typing.InterpretRealLiteral";

  public static final String INTERPRETSTRINGLITERAL = "org.osate.alisa.common.typing.InterpretStringLiteral";

  public static final String INTERPRETBOOLEANLITERAL = "org.osate.alisa.common.typing.InterpretBooleanLiteral";

  public static final String INTERPRETRANGE = "org.osate.alisa.common.typing.InterpretRange";

  public static final String NOTIMPLEMENTED = "org.osate.alisa.common.typing.NotImplemented";

  public static final String EQUALBOOLEAN = "org.osate.alisa.common.typing.EqualBoolean";

  public static final String EQUALSTRING = "org.osate.alisa.common.typing.EqualString";

  public static final String EQUALNUMBER = "org.osate.alisa.common.typing.EqualNumber";

  public static final String EQUALRANGE = "org.osate.alisa.common.typing.EqualRange";

  public static final String EQUALRECORD = "org.osate.alisa.common.typing.EqualRecord";

  public static final String EQUALMODELELEMENT = "org.osate.alisa.common.typing.EqualModelElement";

  public static final String EQUAL = "org.osate.alisa.common.typing.Equal";

  public static final String COMPARENUMBERS = "org.osate.alisa.common.typing.CompareNumbers";

  public static final String COMPARENUMBERRANGE = "org.osate.alisa.common.typing.CompareNumberRange";

  public static final String COMPARERANGENUMBER = "org.osate.alisa.common.typing.CompareRangeNumber";

  public static final String COMPARERANGES = "org.osate.alisa.common.typing.CompareRanges";

  public static final String COMPARETONUMBER = "org.osate.alisa.common.typing.CompareToNumber";

  private PolymorphicDispatcher<NumberType> combineNumericDispatcher;

  private PolymorphicDispatcher<NamedElement> chooseRootDispatcher;

  private PolymorphicDispatcher<String> errorPositionDispatcher;

  private PolymorphicDispatcher<Result<PropertyValue>> interpretExpressionDispatcher;

  private PolymorphicDispatcher<Result<PropertyValue>> interpretVariableDispatcher;

  private PolymorphicDispatcher<Result<Boolean>> equalDispatcher;

  private PolymorphicDispatcher<Result<Boolean>> compareDispatcher;

  private PolymorphicDispatcher<Result<Integer>> cmpNumDispatcher;

  public CommonInterpreter() {
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

  public NamedElement chooseRoot(final EObject io, final RuleEnvironment G) throws RuleFailedException {
    return chooseRoot(null, io, G);
  }

  public NamedElement chooseRoot(final RuleApplicationTrace _trace_, final EObject io, final RuleEnvironment G) throws RuleFailedException {
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

  public Result<PropertyValue> interpretExpression(final PropertyExpression expression) {
    return interpretExpression(new RuleEnvironment(), null, expression);
  }

  public Result<PropertyValue> interpretExpression(final RuleEnvironment _environment_, final PropertyExpression expression) {
    return interpretExpression(_environment_, null, expression);
  }

  public Result<PropertyValue> interpretExpression(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyExpression expression) {
    try {
    	return interpretExpressionInternal(_environment_, _trace_, expression);
    } catch (Exception _e_interpretExpression) {
    	return resultForFailure(_e_interpretExpression);
    }
  }

  public Result<PropertyValue> interpretVariable(final AVariableDeclaration decl) {
    return interpretVariable(new RuleEnvironment(), null, decl);
  }

  public Result<PropertyValue> interpretVariable(final RuleEnvironment _environment_, final AVariableDeclaration decl) {
    return interpretVariable(_environment_, null, decl);
  }

  public Result<PropertyValue> interpretVariable(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final AVariableDeclaration decl) {
    try {
    	return interpretVariableInternal(_environment_, _trace_, decl);
    } catch (Exception _e_interpretVariable) {
    	return resultForFailure(_e_interpretVariable);
    }
  }

  public Result<Boolean> equal(final PropertyValue left, final PropertyValue right) {
    return equal(new RuleEnvironment(), null, left, right);
  }

  public Result<Boolean> equal(final RuleEnvironment _environment_, final PropertyValue left, final PropertyValue right) {
    return equal(_environment_, null, left, right);
  }

  public Result<Boolean> equal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyValue left, final PropertyValue right) {
    try {
    	return equalInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_equal) {
    	return resultForFailure(_e_equal);
    }
  }

  public Boolean equalSucceeded(final PropertyValue left, final PropertyValue right) {
    return equalSucceeded(new RuleEnvironment(), null, left, right);
  }

  public Boolean equalSucceeded(final RuleEnvironment _environment_, final PropertyValue left, final PropertyValue right) {
    return equalSucceeded(_environment_, null, left, right);
  }

  public Boolean equalSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyValue left, final PropertyValue right) {
    try {
    	equalInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_equal) {
    	return false;
    }
  }

  public Result<Boolean> compare(final PropertyValue left, final PropertyValue right) {
    return compare(new RuleEnvironment(), null, left, right);
  }

  public Result<Boolean> compare(final RuleEnvironment _environment_, final PropertyValue left, final PropertyValue right) {
    return compare(_environment_, null, left, right);
  }

  public Result<Boolean> compare(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyValue left, final PropertyValue right) {
    try {
    	return compareInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_compare) {
    	return resultForFailure(_e_compare);
    }
  }

  public Boolean compareSucceeded(final PropertyValue left, final PropertyValue right) {
    return compareSucceeded(new RuleEnvironment(), null, left, right);
  }

  public Boolean compareSucceeded(final RuleEnvironment _environment_, final PropertyValue left, final PropertyValue right) {
    return compareSucceeded(_environment_, null, left, right);
  }

  public Boolean compareSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyValue left, final PropertyValue right) {
    try {
    	compareInternal(_environment_, _trace_, left, right);
    	return true;
    } catch (Exception _e_compare) {
    	return false;
    }
  }

  public Result<Integer> cmpNum(final PropertyValue left, final PropertyValue right) {
    return cmpNum(new RuleEnvironment(), null, left, right);
  }

  public Result<Integer> cmpNum(final RuleEnvironment _environment_, final PropertyValue left, final PropertyValue right) {
    return cmpNum(_environment_, null, left, right);
  }

  public Result<Integer> cmpNum(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyValue left, final PropertyValue right) {
    try {
    	return cmpNumInternal(_environment_, _trace_, left, right);
    } catch (Exception _e_cmpNum) {
    	return resultForFailure(_e_cmpNum);
    }
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

  protected NamedElement chooseRootInternal(final RuleApplicationTrace _trace_, final EObject io, final RuleEnvironment G) {
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

  protected Result<PropertyValue> interpretExpressionInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyExpression expression) {
    try {
    	checkParamsNotNull(expression);
    	return interpretExpressionDispatcher.invoke(_environment_, _trace_, expression);
    } catch (Exception _e_interpretExpression) {
    	sneakyThrowRuleFailedException(_e_interpretExpression);
    	return null;
    }
  }

  protected void interpretExpressionThrowException(final String _error, final String _issue, final Exception _ex, final PropertyExpression expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<PropertyValue> interpretVariableInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final AVariableDeclaration decl) {
    try {
    	checkParamsNotNull(decl);
    	return interpretVariableDispatcher.invoke(_environment_, _trace_, decl);
    } catch (Exception _e_interpretVariable) {
    	sneakyThrowRuleFailedException(_e_interpretVariable);
    	return null;
    }
  }

  protected void interpretVariableThrowException(final String _error, final String _issue, final Exception _ex, final AVariableDeclaration decl, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Boolean> equalInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyValue left, final PropertyValue right) {
    try {
    	checkParamsNotNull(left, right);
    	return equalDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_equal) {
    	sneakyThrowRuleFailedException(_e_equal);
    	return null;
    }
  }

  protected void equalThrowException(final String _error, final String _issue, final Exception _ex, final PropertyValue left, final PropertyValue right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Boolean> compareInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyValue left, final PropertyValue right) {
    try {
    	checkParamsNotNull(left, right);
    	return compareDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_compare) {
    	sneakyThrowRuleFailedException(_e_compare);
    	return null;
    }
  }

  protected void compareThrowException(final String _error, final String _issue, final Exception _ex, final PropertyValue left, final PropertyValue right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Integer> cmpNumInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final PropertyValue left, final PropertyValue right) {
    try {
    	checkParamsNotNull(left, right);
    	return cmpNumDispatcher.invoke(_environment_, _trace_, left, right);
    } catch (Exception _e_cmpNum) {
    	sneakyThrowRuleFailedException(_e_cmpNum);
    	return null;
    }
  }

  protected void cmpNumThrowException(final String _error, final String _issue, final Exception _ex, final PropertyValue left, final PropertyValue right, final ErrorInformation[] _errorInformations) throws RuleFailedException {
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
      if (((left instanceof AadlInteger) && (right instanceof AadlInteger))) {
        _xifexpression = Aadl2Factory.eINSTANCE.createAadlInteger();
      } else {
        _xifexpression = Aadl2Factory.eINSTANCE.createAadlReal();
      }
      final NumberType result = _xifexpression;
      UnitsType _xifexpression_1 = null;
      UnitsType _unitsType = left.getUnitsType();
      boolean _tripleNotEquals = (_unitsType != null);
      if (_tripleNotEquals) {
        _xifexpression_1 = left.getUnitsType();
      } else {
        _xifexpression_1 = right.getUnitsType();
      }
      result.setReferencedUnitsType(_xifexpression_1);
      _xblockexpression = (result);
    }
    return _xblockexpression;
  }

  protected NamedElement chooseRootImpl(final RuleApplicationTrace _trace_, final EObject obj, final RuleEnvironment G) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final NamedElement _result_ = applyAuxFunChooseRoot(_subtrace_, obj, G);
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

  protected NamedElement applyAuxFunChooseRoot(final RuleApplicationTrace _trace_, final EObject obj, final RuleEnvironment G) throws RuleFailedException {
    NamedElement _xblockexpression = null;
    {
      final NamedElement element = this.<NamedElement>env(G, "target", NamedElement.class);
      _xblockexpression = (element);
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

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ABinaryOperation binary) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretBinaryExpression(G, _subtrace_, binary);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretBinaryExpression") + stringRepForEnv(G) + " |- " + stringRep(binary) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretBinaryExpression) {
    	interpretExpressionThrowException(ruleName("InterpretBinaryExpression") + stringRepForEnv(G) + " |- " + stringRep(binary) + " ~> " + "PropertyValue",
    		INTERPRETBINARYEXPRESSION,
    		e_applyRuleInterpretBinaryExpression, binary, new ErrorInformation[] {new ErrorInformation(binary)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretBinaryExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ABinaryOperation binary) throws RuleFailedException {
    PropertyValue propVal = null; // output parameter
    /* G |- binary.left ~> var PropertyValue leftVal */
    PropertyExpression _left = binary.getLeft();
    PropertyValue leftVal = null;
    Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _left);
    checkAssignableTo(result.getFirst(), PropertyValue.class);
    leftVal = (PropertyValue) result.getFirst();
    
    /* G |- binary.right ~> var PropertyValue rightVal */
    PropertyExpression _right = binary.getRight();
    PropertyValue rightVal = null;
    Result<PropertyValue> result_1 = interpretExpressionInternal(G, _trace_, _right);
    checkAssignableTo(result_1.getFirst(), PropertyValue.class);
    rightVal = (PropertyValue) result_1.getFirst();
    
    PropertyValue _switchResult = null;
    Operation _operator = binary.getOperator();
    if (_operator != null) {
      switch (_operator) {
        case AND:
        case OR:
        case ALT_AND:
        case ALT_OR:
          BooleanLiteral _xblockexpression = null;
          {
            final BooleanLiteral boolVal = Aadl2Factory.eINSTANCE.createBooleanLiteral();
            final BooleanLiteral left = ((BooleanLiteral) leftVal);
            final BooleanLiteral right = ((BooleanLiteral) rightVal);
            boolean _xifexpression = false;
            Operation _operator_1 = binary.getOperator();
            boolean _equals = Objects.equals(_operator_1, Operation.AND);
            if (_equals) {
              boolean _xifexpression_1 = false;
              if ((left.getValue() && right.getValue())) {
                _xifexpression_1 = true;
              } else {
                _xifexpression_1 = false;
              }
              _xifexpression = _xifexpression_1;
            } else {
              boolean _xifexpression_2 = false;
              if ((left.getValue() || right.getValue())) {
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
          BooleanLiteral _xblockexpression_1 = null;
          {
            final BooleanLiteral boolVal = Aadl2Factory.eINSTANCE.createBooleanLiteral();
            /* G |= leftVal : rightVal */
            boolean _ruleinvocation = equalSucceeded(G, _trace_, leftVal, rightVal);
            boolVal.setValue(_ruleinvocation);
            Operation _operator_1 = binary.getOperator();
            boolean _equals = Objects.equals(_operator_1, Operation.NEQ);
            if (_equals) {
              boolean _value = boolVal.getValue();
              boolean _not = (!_value);
              boolVal.setValue(_not);
            }
            _xblockexpression_1 = (boolVal);
          }
          _switchResult = _xblockexpression_1;
          break;
        case LT:
          BooleanLiteral _xblockexpression_2 = null;
          {
            final BooleanLiteral boolVal = Aadl2Factory.eINSTANCE.createBooleanLiteral();
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
          BooleanLiteral _xblockexpression_3 = null;
          {
            final BooleanLiteral boolVal = Aadl2Factory.eINSTANCE.createBooleanLiteral();
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
          BooleanLiteral _xblockexpression_4 = null;
          {
            final BooleanLiteral boolVal = Aadl2Factory.eINSTANCE.createBooleanLiteral();
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
          BooleanLiteral _xblockexpression_5 = null;
          {
            final BooleanLiteral boolVal = Aadl2Factory.eINSTANCE.createBooleanLiteral();
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
          BooleanLiteral _xblockexpression_6 = null;
          {
            final BooleanLiteral boolVal = Aadl2Factory.eINSTANCE.createBooleanLiteral();
            boolean _matched = false;
            if (leftVal instanceof NumberValue) {
              _matched=true;
              /* G, 'op' <- Operation.LT |> leftVal : rightVal */
              boolean _ruleinvocation = compareSucceeded(environmentComposition(
                G, environmentEntry("op", Operation.LT)
              ), _trace_, ((NumberValue)leftVal), rightVal);
              final boolean lessThan = _ruleinvocation;
              /* G, 'op' <- Operation.GT |> leftVal : rightVal */
              boolean _ruleinvocation_1 = compareSucceeded(environmentComposition(
                G, environmentEntry("op", Operation.GT)
              ), _trace_, ((NumberValue)leftVal), rightVal);
              final boolean greaterThan = _ruleinvocation_1;
              boolVal.setValue((!(lessThan || greaterThan)));
            }
            if (!_matched) {
              if (leftVal instanceof RangeValue) {
                _matched=true;
                /* G |- leftVal.minimum ~> var NumberValue min */
                PropertyExpression _minimum = ((RangeValue)leftVal).getMinimum();
                NumberValue min = null;
                Result<PropertyValue> result_2 = interpretExpressionInternal(G, _trace_, _minimum);
                checkAssignableTo(result_2.getFirst(), NumberValue.class);
                min = (NumberValue) result_2.getFirst();
                
                /* G |- leftVal.maximum ~> var NumberValue max */
                PropertyExpression _maximum = ((RangeValue)leftVal).getMaximum();
                NumberValue max = null;
                Result<PropertyValue> result_3 = interpretExpressionInternal(G, _trace_, _maximum);
                checkAssignableTo(result_3.getFirst(), NumberValue.class);
                max = (NumberValue) result_3.getFirst();
                
                /* G, 'op' <- Operation.LT |> min : rightVal */
                boolean _ruleinvocation = compareSucceeded(environmentComposition(
                  G, environmentEntry("op", Operation.LT)
                ), _trace_, min, rightVal);
                final boolean minLessThan = _ruleinvocation;
                /* G, 'op' <- Operation.GT |> min : rightVal */
                boolean _ruleinvocation_1 = compareSucceeded(environmentComposition(
                  G, environmentEntry("op", Operation.GT)
                ), _trace_, min, rightVal);
                final boolean minGreaterThan = _ruleinvocation_1;
                /* G, 'op' <- Operation.LT |> max : rightVal */
                boolean _ruleinvocation_2 = compareSucceeded(environmentComposition(
                  G, environmentEntry("op", Operation.LT)
                ), _trace_, max, rightVal);
                final boolean maxLessThan = _ruleinvocation_2;
                /* G, 'op' <- Operation.GT |> max : rightVal */
                boolean _ruleinvocation_3 = compareSucceeded(environmentComposition(
                  G, environmentEntry("op", Operation.GT)
                ), _trace_, max, rightVal);
                final boolean maxGreaterThan = _ruleinvocation_3;
                boolVal.setValue(((!(minLessThan || minGreaterThan)) && (!(maxLessThan || maxGreaterThan))));
              }
            }
            _xblockexpression_6 = (boolVal);
          }
          _switchResult = _xblockexpression_6;
          break;
        case PLUS:
          _switchResult = InterpreterUtil.add(((NumberValue) leftVal), ((NumberValue) rightVal));
          break;
        case MINUS:
          _switchResult = InterpreterUtil.subtract(((NumberValue) leftVal), ((NumberValue) rightVal));
          break;
        case MULT:
          _switchResult = InterpreterUtil.multiply(((NumberValue) leftVal), ((NumberValue) rightVal));
          break;
        case DIV:
          _switchResult = InterpreterUtil.divide(((NumberValue) leftVal), ((NumberValue) rightVal));
          break;
        case INTDIV:
          _switchResult = InterpreterUtil.divideInt(((IntegerLiteral) leftVal), ((IntegerLiteral) rightVal));
          break;
        case MOD:
          _switchResult = InterpreterUtil.mod(((IntegerLiteral) leftVal), ((IntegerLiteral) rightVal));
          break;
        default:
          _switchResult = null;
          break;
      }
    } else {
      _switchResult = null;
    }
    propVal = _switchResult;
    return new Result<PropertyValue>(propVal);
  }

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AFunctionCall call) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretFunctionCall(G, _subtrace_, call);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretFunctionCall") + stringRepForEnv(G) + " |- " + stringRep(call) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretFunctionCall) {
    	interpretExpressionThrowException(ruleName("InterpretFunctionCall") + stringRepForEnv(G) + " |- " + stringRep(call) + " ~> " + "PropertyValue",
    		INTERPRETFUNCTIONCALL,
    		e_applyRuleInterpretFunctionCall, call, new ErrorInformation[] {new ErrorInformation(call)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretFunctionCall(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AFunctionCall call) throws RuleFailedException {
    PropertyValue propVal = null; // output parameter
    NumberValue _switchResult = null;
    String _function = call.getFunction();
    if (_function != null) {
      switch (_function) {
        case "min":
          final Function1<PropertyExpression, NumberValue> _function_1 = (PropertyExpression arg) -> {
            NumberValue _xblockexpression = null;
            {
              /* G |- arg ~> var PropertyValue pval */
              PropertyValue pval = null;
              Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, arg);
              checkAssignableTo(result.getFirst(), PropertyValue.class);
              pval = (PropertyValue) result.getFirst();
              
              NumberValue _xifexpression = null;
              if ((pval instanceof RangeValue)) {
                _xifexpression = ((RangeValue)pval).getMinimumValue();
              } else {
                _xifexpression = ((NumberValue) pval);
              }
              _xblockexpression = _xifexpression;
            }
            return _xblockexpression;
          };
          _switchResult = InterpreterUtil.min(ListExtensions.<PropertyExpression, NumberValue>map(call.getArguments(), _function_1));
          break;
        case "max":
          final Function1<PropertyExpression, NumberValue> _function_2 = (PropertyExpression arg) -> {
            NumberValue _xblockexpression = null;
            {
              /* G |- arg ~> var PropertyValue pval */
              PropertyValue pval = null;
              Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, arg);
              checkAssignableTo(result.getFirst(), PropertyValue.class);
              pval = (PropertyValue) result.getFirst();
              
              NumberValue _xifexpression = null;
              if ((pval instanceof RangeValue)) {
                _xifexpression = ((RangeValue)pval).getMaximumValue();
              } else {
                _xifexpression = ((NumberValue) pval);
              }
              _xblockexpression = _xifexpression;
            }
            return _xblockexpression;
          };
          _switchResult = InterpreterUtil.max(ListExtensions.<PropertyExpression, NumberValue>map(call.getArguments(), _function_2));
          break;
        case "abs":
          NumberValue _xblockexpression = null;
          {
            /* G |- call.arguments.get(0) ~> var NumberValue pVal */
            PropertyExpression _get = call.getArguments().get(0);
            NumberValue pVal = null;
            Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _get);
            checkAssignableTo(result.getFirst(), NumberValue.class);
            pVal = (NumberValue) result.getFirst();
            
            boolean _matched = false;
            if (pVal instanceof RealLiteral) {
              _matched=true;
              double _xifexpression = (double) 0;
              double _value = ((RealLiteral)pVal).getValue();
              boolean _lessThan = (_value < 0);
              if (_lessThan) {
                double _value_1 = ((RealLiteral)pVal).getValue();
                _xifexpression = (-_value_1);
              } else {
                _xifexpression = ((RealLiteral)pVal).getValue();
              }
              ((RealLiteral)pVal).setValue(_xifexpression);
            }
            if (!_matched) {
              if (pVal instanceof IntegerLiteral) {
                _matched=true;
                long _xifexpression = (long) 0;
                long _value = ((IntegerLiteral)pVal).getValue();
                boolean _lessThan = (_value < 0);
                if (_lessThan) {
                  long _value_1 = ((IntegerLiteral)pVal).getValue();
                  _xifexpression = (-_value_1);
                } else {
                  _xifexpression = ((IntegerLiteral)pVal).getValue();
                }
                ((IntegerLiteral)pVal).setValue(_xifexpression);
              }
            }
            _xblockexpression = (pVal);
          }
          _switchResult = _xblockexpression;
          break;
        case "round":
          IntegerLiteral _xblockexpression_1 = null;
          {
            /* G |- call.arguments.get(0) ~> var NumberValue pVal */
            PropertyExpression _get = call.getArguments().get(0);
            NumberValue pVal = null;
            Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _get);
            checkAssignableTo(result.getFirst(), NumberValue.class);
            pVal = (NumberValue) result.getFirst();
            
            _xblockexpression_1 = (InterpreterUtil.round(pVal));
          }
          _switchResult = _xblockexpression_1;
          break;
        case "ceil":
          IntegerLiteral _xblockexpression_2 = null;
          {
            /* G |- call.arguments.get(0) ~> var NumberValue pVal */
            PropertyExpression _get = call.getArguments().get(0);
            NumberValue pVal = null;
            Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _get);
            checkAssignableTo(result.getFirst(), NumberValue.class);
            pVal = (NumberValue) result.getFirst();
            
            _xblockexpression_2 = (InterpreterUtil.ceil(pVal));
          }
          _switchResult = _xblockexpression_2;
          break;
        case "floor":
          IntegerLiteral _xblockexpression_3 = null;
          {
            /* G |- call.arguments.get(0) ~> var NumberValue pVal */
            PropertyExpression _get = call.getArguments().get(0);
            NumberValue pVal = null;
            Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _get);
            checkAssignableTo(result.getFirst(), NumberValue.class);
            pVal = (NumberValue) result.getFirst();
            
            _xblockexpression_3 = (InterpreterUtil.floor(pVal));
          }
          _switchResult = _xblockexpression_3;
          break;
      }
    }
    propVal = _switchResult;
    return new Result<PropertyValue>(propVal);
  }

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AUnaryOperation unary) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretUnaryExpression(G, _subtrace_, unary);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretUnaryExpression") + stringRepForEnv(G) + " |- " + stringRep(unary) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretUnaryExpression) {
    	interpretExpressionThrowException(ruleName("InterpretUnaryExpression") + stringRepForEnv(G) + " |- " + stringRep(unary) + " ~> " + "PropertyValue",
    		INTERPRETUNARYEXPRESSION,
    		e_applyRuleInterpretUnaryExpression, unary, new ErrorInformation[] {new ErrorInformation(unary)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretUnaryExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AUnaryOperation unary) throws RuleFailedException {
    PropertyValue propVal = null; // output parameter
    /* G |- unary.operand ~> propVal */
    PropertyExpression _operand = unary.getOperand();
    Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _operand);
    checkAssignableTo(result.getFirst(), PropertyValue.class);
    propVal = (PropertyValue) result.getFirst();
    
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
    return new Result<PropertyValue>(propVal);
  }

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AUnitExpression unit) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretUnitExpression(G, _subtrace_, unit);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretUnitExpression") + stringRepForEnv(G) + " |- " + stringRep(unit) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretUnitExpression) {
    	interpretExpressionThrowException(ruleName("InterpretUnitExpression") + stringRepForEnv(G) + " |- " + stringRep(unit) + " ~> " + "PropertyValue",
    		INTERPRETUNITEXPRESSION,
    		e_applyRuleInterpretUnitExpression, unit, new ErrorInformation[] {new ErrorInformation(unit)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretUnitExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AUnitExpression unit) throws RuleFailedException {
    PropertyValue number = null; // output parameter
    /* G |- unit.expression ~> var PropertyValue propval */
    PropertyExpression _expression = unit.getExpression();
    PropertyValue propval = null;
    Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _expression);
    checkAssignableTo(result.getFirst(), PropertyValue.class);
    propval = (PropertyValue) result.getFirst();
    
    if ((propval instanceof NumberValue)) {
      final NumberValue num = EcoreUtil.<NumberValue>copy(((NumberValue)propval));
      final boolean unit_add = (((!unit.isDrop()) && (!unit.isConvert())) && (unit.getUnit() != null));
      if ((unit.isDrop() || unit.isConvert())) {
        boolean _matched = false;
        if (num instanceof IntegerLiteral) {
          _matched=true;
          ((IntegerLiteral)num).setValue(Math.round(((IntegerLiteral)num).getScaledValue(unit.getUnit())));
        }
        if (!_matched) {
          if (num instanceof RealLiteral) {
            _matched=true;
            ((RealLiteral)num).setValue(((RealLiteral)num).getScaledValue(unit.getUnit()));
          }
        }
        if (!_matched) {
        }
      }
      boolean _isDrop = unit.isDrop();
      if (_isDrop) {
        num.setUnit(null);
      } else {
        if ((unit.isConvert() || unit_add)) {
          num.setUnit(unit.getUnit());
        }
      }
      number = num;
    } else {
      number = propval;
    }
    return new Result<PropertyValue>(number);
  }

  protected Result<PropertyValue> interpretVariableImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ValDeclaration varDecl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretVal(G, _subtrace_, varDecl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretVal") + stringRepForEnv(G) + " ||- " + stringRep(varDecl) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretVal) {
    	interpretVariableThrowException(ruleName("InterpretVal") + stringRepForEnv(G) + " ||- " + stringRep(varDecl) + " ~> " + "PropertyValue",
    		INTERPRETVAL,
    		e_applyRuleInterpretVal, varDecl, new ErrorInformation[] {new ErrorInformation(varDecl)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretVal(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ValDeclaration varDecl) throws RuleFailedException {
    PropertyValue propVal = null; // output parameter
    Object _env = this.<Object>env(G, "vals", Object.class);
    final HashMap<ValDeclaration, PropertyValue> map = ((HashMap<ValDeclaration, PropertyValue>) _env);
    boolean _containsKey = map.containsKey(varDecl);
    if (_containsKey) {
      propVal = map.get(varDecl);
    } else {
      /* G |- varDecl.value ~> propVal */
      PropertyExpression _value = varDecl.getValue();
      Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _value);
      checkAssignableTo(result.getFirst(), PropertyValue.class);
      propVal = (PropertyValue) result.getFirst();
      
      map.put(varDecl, propVal);
    }
    return new Result<PropertyValue>(propVal);
  }

  protected Result<PropertyValue> interpretVariableImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ComputeDeclaration varDecl) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretCompute(G, _subtrace_, varDecl);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretCompute") + stringRepForEnv(G) + " ||- " + stringRep(varDecl) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretCompute) {
    	interpretVariableThrowException(ruleName("InterpretCompute") + stringRepForEnv(G) + " ||- " + stringRep(varDecl) + " ~> " + "PropertyValue",
    		INTERPRETCOMPUTE,
    		e_applyRuleInterpretCompute, varDecl, new ErrorInformation[] {new ErrorInformation(varDecl)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretCompute(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ComputeDeclaration varDecl) throws RuleFailedException {
    PropertyValue propVal = null; // output parameter
    /* { val map = env(G, 'computes', Object) as HashMap<String, PropertyValue> map.containsKey(varDecl.name) propVal = map.get(varDecl.name) } or { fail error 'interpreter: compute variable ' + varDecl.name + ' has no value' } */
    {
      RuleFailedException previousFailure = null;
      try {
        Object _env = this.<Object>env(G, "computes", Object.class);
        final HashMap<String, PropertyValue> map = ((HashMap<String, PropertyValue>) _env);
        boolean _containsKey = map.containsKey(varDecl.getName());
        /* map.containsKey(varDecl.name) */
        if (!_containsKey) {
          sneakyThrowRuleFailedException("map.containsKey(varDecl.name)");
        }
        propVal = map.get(varDecl.getName());
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* fail error 'interpreter: compute variable ' + varDecl.name + ' has no value' */
        String _name = varDecl.getName();
        String _plus = ("interpreter: compute variable " + _name);
        String _plus_1 = (_plus + " has no value");
        String error = _plus_1;
        throwForExplicitFail(error, new ErrorInformation(null, null));
      }
    }
    return new Result<PropertyValue>(propVal);
  }

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AVariableReference varRef) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretVarRef(G, _subtrace_, varRef);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretVarRef") + stringRepForEnv(G) + " |- " + stringRep(varRef) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretVarRef) {
    	interpretExpressionThrowException(ruleName("InterpretVarRef") + stringRepForEnv(G) + " |- " + stringRep(varRef) + " ~> " + "PropertyValue",
    		INTERPRETVARREF,
    		e_applyRuleInterpretVarRef, varRef, new ErrorInformation[] {new ErrorInformation(varRef)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretVarRef(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AVariableReference varRef) throws RuleFailedException {
    PropertyValue propVal = null; // output parameter
    /* G ||- varRef.variable ~> propVal */
    AVariableDeclaration _variable = varRef.getVariable();
    Result<PropertyValue> result = interpretVariableInternal(G, _trace_, _variable);
    checkAssignableTo(result.getFirst(), PropertyValue.class);
    propVal = (PropertyValue) result.getFirst();
    
    return new Result<PropertyValue>(propVal);
  }

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AConditional ite) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpetITE(G, _subtrace_, ite);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpetITE") + stringRepForEnv(G) + " |- " + stringRep(ite) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpetITE) {
    	interpretExpressionThrowException(ruleName("InterpetITE") + stringRepForEnv(G) + " |- " + stringRep(ite) + " ~> " + "PropertyValue",
    		INTERPETITE,
    		e_applyRuleInterpetITE, ite, new ErrorInformation[] {new ErrorInformation(ite)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpetITE(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AConditional ite) throws RuleFailedException {
    PropertyValue propVal = null; // output parameter
    /* G |- ite.^if ~> var BooleanLiteral cond */
    PropertyExpression _if = ite.getIf();
    BooleanLiteral cond = null;
    Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _if);
    checkAssignableTo(result.getFirst(), BooleanLiteral.class);
    cond = (BooleanLiteral) result.getFirst();
    
    boolean _value = cond.getValue();
    if (_value) {
      /* G |- ite.then ~> propVal */
      PropertyExpression _then = ite.getThen();
      Result<PropertyValue> result_1 = interpretExpressionInternal(G, _trace_, _then);
      checkAssignableTo(result_1.getFirst(), PropertyValue.class);
      propVal = (PropertyValue) result_1.getFirst();
      
    } else {
      /* G |- ite.^else ~> propVal */
      PropertyExpression _else = ite.getElse();
      Result<PropertyValue> result_2 = interpretExpressionInternal(G, _trace_, _else);
      checkAssignableTo(result_2.getFirst(), PropertyValue.class);
      propVal = (PropertyValue) result_2.getFirst();
      
    }
    return new Result<PropertyValue>(propVal);
  }

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AModelReference ref) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretModelReference(G, _subtrace_, ref);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretModelReference") + stringRepForEnv(G) + " |- " + stringRep(ref) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretModelReference) {
    	interpretExpressionThrowException(ruleName("InterpretModelReference") + stringRepForEnv(G) + " |- " + stringRep(ref) + " ~> " + "InstanceReferenceValue",
    		INTERPRETMODELREFERENCE,
    		e_applyRuleInterpretModelReference, ref, new ErrorInformation[] {new ErrorInformation(ref)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretModelReference(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AModelReference ref) throws RuleFailedException {
    InstanceReferenceValue propVal = null; // output parameter
    InstanceObject _xblockexpression = null;
    {
      final NamedElement root = this.chooseRootInternal(_trace_, ref, G);
      _xblockexpression = (InterpreterUtil.resolve(ref, root));
    }
    final InstanceObject resolved = _xblockexpression;
    /* { resolved !== null propVal = InstanceFactory.eINSTANCE.createInstanceReferenceValue propVal.referencedInstanceObject = resolved } or { fail error 'cannot resolve reference to model element ' + NodeModelUtils.findActualNodeFor(ref).text + errorPosition(ref) } */
    {
      RuleFailedException previousFailure = null;
      try {
        /* resolved !== null */
        if (!(resolved != null)) {
          sneakyThrowRuleFailedException("resolved !== null");
        }
        propVal = InstanceFactory.eINSTANCE.createInstanceReferenceValue();
        propVal.setReferencedInstanceObject(resolved);
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* fail error 'cannot resolve reference to model element ' + NodeModelUtils.findActualNodeFor(ref).text + errorPosition(ref) */
        String _text = NodeModelUtils.findActualNodeFor(ref).getText();
        String _plus = ("cannot resolve reference to model element " + _text);
        String _errorPosition = this.errorPositionInternal(_trace_, ref);
        String _plus_1 = (_plus + _errorPosition);
        String error = _plus_1;
        throwForExplicitFail(error, new ErrorInformation(null, null));
      }
    }
    return new Result<PropertyValue>(propVal);
  }

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final APropertyReference prop) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretPropertyReference(G, _subtrace_, prop);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretPropertyReference") + stringRepForEnv(G) + " |- " + stringRep(prop) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretPropertyReference) {
    	interpretExpressionThrowException(ruleName("InterpretPropertyReference") + stringRepForEnv(G) + " |- " + stringRep(prop) + " ~> " + "PropertyValue",
    		INTERPRETPROPERTYREFERENCE,
    		e_applyRuleInterpretPropertyReference, prop, new ErrorInformation[] {new ErrorInformation(prop)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretPropertyReference(final RuleEnvironment G, final RuleApplicationTrace _trace_, final APropertyReference prop) throws RuleFailedException {
    PropertyValue propVal = null; // output parameter
    NamedElement io = null;
    /* { prop.modelElementReference !== null G |- prop.modelElementReference ~> var InstanceReferenceValue element io = element.referencedInstanceObject } or { io = chooseRoot(prop, G) } */
    {
      RuleFailedException previousFailure = null;
      try {
        AModelReference _modelElementReference = prop.getModelElementReference();
        boolean _tripleNotEquals = (_modelElementReference != null);
        /* prop.modelElementReference !== null */
        if (!_tripleNotEquals) {
          sneakyThrowRuleFailedException("prop.modelElementReference !== null");
        }
        /* G |- prop.modelElementReference ~> var InstanceReferenceValue element */
        AModelReference _modelElementReference_1 = prop.getModelElementReference();
        InstanceReferenceValue element = null;
        Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _modelElementReference_1);
        checkAssignableTo(result.getFirst(), InstanceReferenceValue.class);
        element = (InstanceReferenceValue) result.getFirst();
        
        io = element.getReferencedInstanceObject();
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        io = this.chooseRootInternal(_trace_, prop, G);
      }
    }
    final AbstractNamedValue namedVal = prop.getProperty();
    PropertyExpression _switchResult = null;
    boolean _matched = false;
    if (namedVal instanceof Property) {
      _matched=true;
      PropertyExpression _xtrycatchfinallyexpression = null;
      try {
        _xtrycatchfinallyexpression = io.getSimplePropertyValue(((Property)namedVal));
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          _xtrycatchfinallyexpression = null;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _switchResult = _xtrycatchfinallyexpression;
    }
    if (!_matched) {
      if (namedVal instanceof PropertyConstant) {
        _matched=true;
        _switchResult = ((PropertyConstant)namedVal).getConstantValue();
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    final PropertyExpression pexp = _switchResult;
    PropertyValue _xifexpression = null;
    if ((pexp instanceof PropertyValue)) {
      _xifexpression = ((PropertyValue)pexp);
    } else {
      _xifexpression = null;
    }
    propVal = _xifexpression;
    /* propVal !== null or { fail error 'cannot retrieve property value ' + NodeModelUtils.findActualNodeFor(prop).text + errorPosition(prop) } */
    {
      RuleFailedException previousFailure = null;
      try {
        /* propVal !== null */
        if (!(propVal != null)) {
          sneakyThrowRuleFailedException("propVal !== null");
        }
      } catch (Exception e_1) {
        previousFailure = extractRuleFailedException(e_1);
        /* fail error 'cannot retrieve property value ' + NodeModelUtils.findActualNodeFor(prop).text + errorPosition(prop) */
        String _text = NodeModelUtils.findActualNodeFor(prop).getText();
        String _plus = ("cannot retrieve property value " + _text);
        String _errorPosition = this.errorPositionInternal(_trace_, prop);
        String _plus_1 = (_plus + _errorPosition);
        String error = _plus_1;
        throwForExplicitFail(error, new ErrorInformation(null, null));
      }
    }
    return new Result<PropertyValue>(propVal);
  }

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final IntegerLiteral integer) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretIntegerLiteral(G, _subtrace_, integer);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretIntegerLiteral") + stringRepForEnv(G) + " |- " + stringRep(integer) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretIntegerLiteral) {
    	interpretExpressionThrowException(ruleName("InterpretIntegerLiteral") + stringRepForEnv(G) + " |- " + stringRep(integer) + " ~> " + "IntegerLiteral",
    		INTERPRETINTEGERLITERAL,
    		e_applyRuleInterpretIntegerLiteral, integer, new ErrorInformation[] {new ErrorInformation(integer)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretIntegerLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final IntegerLiteral integer) throws RuleFailedException {
    
    return new Result<PropertyValue>(_applyRuleInterpretIntegerLiteral_1(G, integer));
  }

  private IntegerLiteral _applyRuleInterpretIntegerLiteral_1(final RuleEnvironment G, final IntegerLiteral integer) throws RuleFailedException {
    IntegerLiteral _xblockexpression = null;
    {
      final IntegerLiteral intVal = Aadl2Factory.eINSTANCE.createIntegerLiteral();
      intVal.setValue(integer.getValue());
      _xblockexpression = (intVal);
    }
    return _xblockexpression;
  }

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RealLiteral real) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretRealLiteral(G, _subtrace_, real);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretRealLiteral") + stringRepForEnv(G) + " |- " + stringRep(real) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretRealLiteral) {
    	interpretExpressionThrowException(ruleName("InterpretRealLiteral") + stringRepForEnv(G) + " |- " + stringRep(real) + " ~> " + "RealLiteral",
    		INTERPRETREALLITERAL,
    		e_applyRuleInterpretRealLiteral, real, new ErrorInformation[] {new ErrorInformation(real)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretRealLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RealLiteral real) throws RuleFailedException {
    
    return new Result<PropertyValue>(_applyRuleInterpretRealLiteral_1(G, real));
  }

  private RealLiteral _applyRuleInterpretRealLiteral_1(final RuleEnvironment G, final RealLiteral real) throws RuleFailedException {
    RealLiteral _xblockexpression = null;
    {
      final RealLiteral realVal = Aadl2Factory.eINSTANCE.createRealLiteral();
      realVal.setValue(real.getValue());
      _xblockexpression = (realVal);
    }
    return _xblockexpression;
  }

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringLiteral string) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretStringLiteral(G, _subtrace_, string);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretStringLiteral") + stringRepForEnv(G) + " |- " + stringRep(string) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretStringLiteral) {
    	interpretExpressionThrowException(ruleName("InterpretStringLiteral") + stringRepForEnv(G) + " |- " + stringRep(string) + " ~> " + "StringLiteral",
    		INTERPRETSTRINGLITERAL,
    		e_applyRuleInterpretStringLiteral, string, new ErrorInformation[] {new ErrorInformation(string)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretStringLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringLiteral string) throws RuleFailedException {
    
    return new Result<PropertyValue>(_applyRuleInterpretStringLiteral_1(G, string));
  }

  private StringLiteral _applyRuleInterpretStringLiteral_1(final RuleEnvironment G, final StringLiteral string) throws RuleFailedException {
    StringLiteral _xblockexpression = null;
    {
      final StringLiteral stringVal = Aadl2Factory.eINSTANCE.createStringLiteral();
      stringVal.setValue(string.getValue());
      _xblockexpression = (stringVal);
    }
    return _xblockexpression;
  }

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanLiteral bool) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretBooleanLiteral(G, _subtrace_, bool);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretBooleanLiteral") + stringRepForEnv(G) + " |- " + stringRep(bool) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretBooleanLiteral) {
    	interpretExpressionThrowException(ruleName("InterpretBooleanLiteral") + stringRepForEnv(G) + " |- " + stringRep(bool) + " ~> " + "BooleanLiteral",
    		INTERPRETBOOLEANLITERAL,
    		e_applyRuleInterpretBooleanLiteral, bool, new ErrorInformation[] {new ErrorInformation(bool)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretBooleanLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanLiteral bool) throws RuleFailedException {
    
    return new Result<PropertyValue>(_applyRuleInterpretBooleanLiteral_1(G, bool));
  }

  private BooleanLiteral _applyRuleInterpretBooleanLiteral_1(final RuleEnvironment G, final BooleanLiteral bool) throws RuleFailedException {
    BooleanLiteral _xblockexpression = null;
    {
      final BooleanLiteral boolVal = Aadl2Factory.eINSTANCE.createBooleanLiteral();
      boolVal.setValue(bool.getValue());
      _xblockexpression = (boolVal);
    }
    return _xblockexpression;
  }

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ARange range) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleInterpretRange(G, _subtrace_, range);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("InterpretRange") + stringRepForEnv(G) + " |- " + stringRep(range) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleInterpretRange) {
    	interpretExpressionThrowException(ruleName("InterpretRange") + stringRepForEnv(G) + " |- " + stringRep(range) + " ~> " + "PropertyValue",
    		INTERPRETRANGE,
    		e_applyRuleInterpretRange, range, new ErrorInformation[] {new ErrorInformation(range)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleInterpretRange(final RuleEnvironment G, final RuleApplicationTrace _trace_, final ARange range) throws RuleFailedException {
    PropertyValue propVal = null; // output parameter
    final RangeValue rangeVal = Aadl2Factory.eINSTANCE.createRangeValue();
    /* G |- range.minimum ~> var NumberValue lower */
    PropertyExpression _minimum = range.getMinimum();
    NumberValue lower = null;
    Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _minimum);
    checkAssignableTo(result.getFirst(), NumberValue.class);
    lower = (NumberValue) result.getFirst();
    
    /* G |- range.maximum ~> var NumberValue upper */
    PropertyExpression _maximum = range.getMaximum();
    NumberValue upper = null;
    Result<PropertyValue> result_1 = interpretExpressionInternal(G, _trace_, _maximum);
    checkAssignableTo(result_1.getFirst(), NumberValue.class);
    upper = (NumberValue) result_1.getFirst();
    
    rangeVal.setMinimum(lower);
    rangeVal.setMaximum(upper);
    propVal = rangeVal;
    return new Result<PropertyValue>(propVal);
  }

  protected Result<PropertyValue> interpretExpressionImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyExpression expression) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyValue> _result_ = applyRuleNotImplemented(G, _subtrace_, expression);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("NotImplemented") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleNotImplemented) {
    	interpretExpressionThrowException(ruleName("NotImplemented") + stringRepForEnv(G) + " |- " + stringRep(expression) + " ~> " + "PropertyValue",
    		NOTIMPLEMENTED,
    		e_applyRuleNotImplemented, expression, new ErrorInformation[] {new ErrorInformation(expression)});
    	return null;
    }
  }

  protected Result<PropertyValue> applyRuleNotImplemented(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyExpression expression) throws RuleFailedException {
    PropertyValue propVal = null; // output parameter
    /* fail error 'not implemented' source expression */
    String error = "not implemented";
    EObject source = expression;
    throwForExplicitFail(error, new ErrorInformation(source, null));
    return new Result<PropertyValue>(propVal);
  }

  protected Result<Boolean> equalImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanLiteral left, final BooleanLiteral right) throws RuleFailedException {
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

  protected Result<Boolean> applyRuleEqualBoolean(final RuleEnvironment G, final RuleApplicationTrace _trace_, final BooleanLiteral left, final BooleanLiteral right) throws RuleFailedException {
    /* left == right */
    if (!Objects.equals(left, right)) {
      sneakyThrowRuleFailedException("left == right");
    }
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> equalImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringLiteral left, final StringLiteral right) throws RuleFailedException {
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

  protected Result<Boolean> applyRuleEqualString(final RuleEnvironment G, final RuleApplicationTrace _trace_, final StringLiteral left, final StringLiteral right) throws RuleFailedException {
    /* left.equals(right) */
    if (!left.equals(right)) {
      sneakyThrowRuleFailedException("left.equals(right)");
    }
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> equalImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberValue left, final NumberValue right) throws RuleFailedException {
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

  protected Result<Boolean> applyRuleEqualNumber(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberValue left, final NumberValue right) throws RuleFailedException {
    int _compareTo = InterpreterUtil.compareTo(left, right);
    /* left.compareTo(right) == 0 */
    if (!(_compareTo == 0)) {
      sneakyThrowRuleFailedException("left.compareTo(right) == 0");
    }
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> equalImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RangeValue left, final RangeValue right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleEqualRange(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EqualRange") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEqualRange) {
    	equalThrowException(ruleName("EqualRange") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right),
    		EQUALRANGE,
    		e_applyRuleEqualRange, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleEqualRange(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RangeValue left, final RangeValue right) throws RuleFailedException {
    /* G |- left.minimum ~> var NumberValue leftMin */
    PropertyExpression _minimum = left.getMinimum();
    NumberValue leftMin = null;
    Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _minimum);
    checkAssignableTo(result.getFirst(), NumberValue.class);
    leftMin = (NumberValue) result.getFirst();
    
    /* G |- right.minimum ~> var NumberValue rightMin */
    PropertyExpression _minimum_1 = right.getMinimum();
    NumberValue rightMin = null;
    Result<PropertyValue> result_1 = interpretExpressionInternal(G, _trace_, _minimum_1);
    checkAssignableTo(result_1.getFirst(), NumberValue.class);
    rightMin = (NumberValue) result_1.getFirst();
    
    /* G |- left.maximum ~> var NumberValue leftMax */
    PropertyExpression _maximum = left.getMaximum();
    NumberValue leftMax = null;
    Result<PropertyValue> result_2 = interpretExpressionInternal(G, _trace_, _maximum);
    checkAssignableTo(result_2.getFirst(), NumberValue.class);
    leftMax = (NumberValue) result_2.getFirst();
    
    /* G |- right.maximum ~> var NumberValue rightMax */
    PropertyExpression _maximum_1 = right.getMaximum();
    NumberValue rightMax = null;
    Result<PropertyValue> result_3 = interpretExpressionInternal(G, _trace_, _maximum_1);
    checkAssignableTo(result_3.getFirst(), NumberValue.class);
    rightMax = (NumberValue) result_3.getFirst();
    
    /* leftMin.compareTo(rightMin) == 0 && leftMax.compareTo(rightMax) == 0 */
    if (!((InterpreterUtil.compareTo(leftMin, rightMin) == 0) && (InterpreterUtil.compareTo(leftMax, rightMax) == 0))) {
      sneakyThrowRuleFailedException("leftMin.compareTo(rightMin) == 0 && leftMax.compareTo(rightMax) == 0");
    }
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> equalImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RecordValue left, final RecordValue right) throws RuleFailedException {
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

  protected Result<Boolean> applyRuleEqualRecord(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RecordValue left, final RecordValue right) throws RuleFailedException {
    final Function1<BasicPropertyAssociation, PropertyValue> _function = (BasicPropertyAssociation it) -> {
      PropertyValue _xblockexpression = null;
      {
        /* G |- it.value ~> var PropertyValue propVal */
        PropertyExpression _value = it.getValue();
        PropertyValue propVal = null;
        Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _value);
        checkAssignableTo(result.getFirst(), PropertyValue.class);
        propVal = (PropertyValue) result.getFirst();
        
        _xblockexpression = propVal;
      }
      return _xblockexpression;
    };
    final List<PropertyValue> leftVals = ListExtensions.<BasicPropertyAssociation, PropertyValue>map(left.getOwnedFieldValues(), _function);
    final Function1<BasicPropertyAssociation, PropertyValue> _function_1 = (BasicPropertyAssociation it) -> {
      PropertyValue _xblockexpression = null;
      {
        /* G |- it.value ~> var PropertyValue propVal */
        PropertyExpression _value = it.getValue();
        PropertyValue propVal = null;
        Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _value);
        checkAssignableTo(result.getFirst(), PropertyValue.class);
        propVal = (PropertyValue) result.getFirst();
        
        _xblockexpression = propVal;
      }
      return _xblockexpression;
    };
    final List<PropertyValue> rightVals = ListExtensions.<BasicPropertyAssociation, PropertyValue>map(right.getOwnedFieldValues(), _function_1);
    final Iterator<PropertyValue> rightIter = rightVals.iterator();
    final Function1<PropertyValue, Boolean> _function_2 = (PropertyValue l) -> {
      boolean _xblockexpression = false;
      {
        final PropertyValue r = rightIter.next();
        /* G |= l : r */
        boolean _ruleinvocation = equalSucceeded(G, _trace_, l, r);
        _xblockexpression = _ruleinvocation;
      }
      return Boolean.valueOf(_xblockexpression);
    };
    /* leftVals.forall[ l | val r = rightIter.next; G |= l : r ] */
    if (!IterableExtensions.<PropertyValue>forall(leftVals, _function_2)) {
      sneakyThrowRuleFailedException("leftVals.forall[ l | val r = rightIter.next; G |= l : r ]");
    }
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> equalImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final InstanceReferenceValue left, final InstanceReferenceValue right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleEqualModelElement(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("EqualModelElement") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEqualModelElement) {
    	equalThrowException(ruleName("EqualModelElement") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right),
    		EQUALMODELELEMENT,
    		e_applyRuleEqualModelElement, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleEqualModelElement(final RuleEnvironment G, final RuleApplicationTrace _trace_, final InstanceReferenceValue left, final InstanceReferenceValue right) throws RuleFailedException {
    InstanceObject _referencedInstanceObject = left.getReferencedInstanceObject();
    InstanceObject _referencedInstanceObject_1 = right.getReferencedInstanceObject();
    /* left.referencedInstanceObject == right.referencedInstanceObject */
    if (!Objects.equals(_referencedInstanceObject, _referencedInstanceObject_1)) {
      sneakyThrowRuleFailedException("left.referencedInstanceObject == right.referencedInstanceObject");
    }
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> equalImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyValue left, final PropertyValue right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleEqual(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Equal") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleEqual) {
    	equalThrowException(ruleName("Equal") + stringRepForEnv(G) + " |= " + stringRep(left) + " : " + stringRep(right),
    		EQUAL,
    		e_applyRuleEqual, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleEqual(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyValue left, final PropertyValue right) throws RuleFailedException {
    /* left.sameAs(right) or fail error 'interpreter: property values are not equal' source left */
    {
      RuleFailedException previousFailure = null;
      try {
        boolean _sameAs = left.sameAs(right);
        /* left.sameAs(right) */
        if (!_sameAs) {
          sneakyThrowRuleFailedException("left.sameAs(right)");
        }
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* fail error 'interpreter: property values are not equal' source left */
        String error = "interpreter: property values are not equal";
        EObject source = left;
        throwForExplicitFail(error, new ErrorInformation(source, null));
      }
    }
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> compareImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberValue left, final NumberValue right) throws RuleFailedException {
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

  protected Result<Boolean> applyRuleCompareNumbers(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberValue left, final NumberValue right) throws RuleFailedException {
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

  protected Result<Boolean> compareImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberValue left, final RangeValue right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCompareNumberRange(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CompareNumberRange") + stringRepForEnv(G) + " |> " + stringRep(left) + " : " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCompareNumberRange) {
    	compareThrowException(ruleName("CompareNumberRange") + stringRepForEnv(G) + " |> " + stringRep(left) + " : " + stringRep(right),
    		COMPARENUMBERRANGE,
    		e_applyRuleCompareNumberRange, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleCompareNumberRange(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberValue left, final RangeValue right) throws RuleFailedException {
    NumberValue rightNum = null;
    Operation op = this.<Operation>env(G, "op", Operation.class);
    if (op != null) {
      switch (op) {
        case LT:
        case LEQ:
          /* G |- right.minimum ~> rightNum */
          PropertyExpression _minimum = right.getMinimum();
          Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _minimum);
          checkAssignableTo(result.getFirst(), NumberValue.class);
          rightNum = (NumberValue) result.getFirst();
          
          break;
        case GT:
        case GEQ:
          /* G |- right.maximum ~> rightNum */
          PropertyExpression _maximum = right.getMaximum();
          Result<PropertyValue> result_1 = interpretExpressionInternal(G, _trace_, _maximum);
          checkAssignableTo(result_1.getFirst(), NumberValue.class);
          rightNum = (NumberValue) result_1.getFirst();
          
          break;
        default:
          break;
      }
    } else {
    }
    /* G |> left : rightNum */
    compareInternal(G, _trace_, left, rightNum);
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> compareImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RangeValue left, final NumberValue right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCompareRangeNumber(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CompareRangeNumber") + stringRepForEnv(G) + " |> " + stringRep(left) + " : " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCompareRangeNumber) {
    	compareThrowException(ruleName("CompareRangeNumber") + stringRepForEnv(G) + " |> " + stringRep(left) + " : " + stringRep(right),
    		COMPARERANGENUMBER,
    		e_applyRuleCompareRangeNumber, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleCompareRangeNumber(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RangeValue left, final NumberValue right) throws RuleFailedException {
    NumberValue leftNum = null;
    final Operation op = this.<Operation>env(G, "op", Operation.class);
    if (op != null) {
      switch (op) {
        case LT:
        case LEQ:
          /* G |- left.maximum ~> leftNum */
          PropertyExpression _maximum = left.getMaximum();
          Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _maximum);
          checkAssignableTo(result.getFirst(), NumberValue.class);
          leftNum = (NumberValue) result.getFirst();
          
          break;
        case GT:
        case GEQ:
          /* G |- left.minimum ~> leftNum */
          PropertyExpression _minimum = left.getMinimum();
          Result<PropertyValue> result_1 = interpretExpressionInternal(G, _trace_, _minimum);
          checkAssignableTo(result_1.getFirst(), NumberValue.class);
          leftNum = (NumberValue) result_1.getFirst();
          
          break;
        default:
          break;
      }
    } else {
    }
    /* G |> leftNum : right */
    compareInternal(G, _trace_, leftNum, right);
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> compareImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RangeValue left, final RangeValue right) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleCompareRanges(G, _subtrace_, left, right);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("CompareRanges") + stringRepForEnv(G) + " |> " + stringRep(left) + " : " + stringRep(right);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleCompareRanges) {
    	compareThrowException(ruleName("CompareRanges") + stringRepForEnv(G) + " |> " + stringRep(left) + " : " + stringRep(right),
    		COMPARERANGES,
    		e_applyRuleCompareRanges, left, right, new ErrorInformation[] {new ErrorInformation(left), new ErrorInformation(right)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleCompareRanges(final RuleEnvironment G, final RuleApplicationTrace _trace_, final RangeValue left, final RangeValue right) throws RuleFailedException {
    NumberValue leftNum = null;
    NumberValue rightNum = null;
    final Operation op = this.<Operation>env(G, "op", Operation.class);
    if (op != null) {
      switch (op) {
        case LT:
        case LEQ:
          /* G |- left.maximum ~> leftNum */
          PropertyExpression _maximum = left.getMaximum();
          Result<PropertyValue> result = interpretExpressionInternal(G, _trace_, _maximum);
          checkAssignableTo(result.getFirst(), NumberValue.class);
          leftNum = (NumberValue) result.getFirst();
          
          /* G |- right.minimum ~> rightNum */
          PropertyExpression _minimum = right.getMinimum();
          Result<PropertyValue> result_1 = interpretExpressionInternal(G, _trace_, _minimum);
          checkAssignableTo(result_1.getFirst(), NumberValue.class);
          rightNum = (NumberValue) result_1.getFirst();
          
          break;
        case GT:
        case GEQ:
          /* G |- left.minimum ~> leftNum */
          PropertyExpression _minimum_1 = left.getMinimum();
          Result<PropertyValue> result_2 = interpretExpressionInternal(G, _trace_, _minimum_1);
          checkAssignableTo(result_2.getFirst(), NumberValue.class);
          leftNum = (NumberValue) result_2.getFirst();
          
          /* G |- right.maximum ~> rightNum */
          PropertyExpression _maximum_1 = right.getMaximum();
          Result<PropertyValue> result_3 = interpretExpressionInternal(G, _trace_, _maximum_1);
          checkAssignableTo(result_3.getFirst(), NumberValue.class);
          rightNum = (NumberValue) result_3.getFirst();
          
          break;
        default:
          break;
      }
    } else {
    }
    /* G |> leftNum : rightNum */
    compareInternal(G, _trace_, leftNum, rightNum);
    return new Result<Boolean>(true);
  }

  protected Result<Integer> cmpNumImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberValue left, final NumberValue right) throws RuleFailedException {
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

  protected Result<Integer> applyRuleCompareToNumber(final RuleEnvironment G, final RuleApplicationTrace _trace_, final NumberValue left, final NumberValue right) throws RuleFailedException {
    Integer cmp = null; // output parameter
    cmp = Integer.valueOf(InterpreterUtil.compareTo(left, right));
    return new Result<Integer>(cmp);
  }
}
