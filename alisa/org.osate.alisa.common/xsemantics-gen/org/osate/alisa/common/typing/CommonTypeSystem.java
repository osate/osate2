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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlBoolean;
import org.osate.aadl2.AadlInteger;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.AadlString;
import org.osate.aadl2.BooleanLiteral;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.ListType;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.alisa.common.common.ABinaryOperation;
import org.osate.alisa.common.common.AListTerm;
import org.osate.alisa.common.common.ValDeclaration;

@SuppressWarnings("all")
public class CommonTypeSystem extends XsemanticsRuntimeSystem {
  public final static String VALDECLARATION = "org.osate.alisa.common.typing.ValDeclaration";
  
  public final static String AEXPRESSION = "org.osate.alisa.common.typing.AExpression";
  
  public final static String ABINARYEXPRESSION = "org.osate.alisa.common.typing.ABinaryExpression";
  
  public final static String ALISTTERM = "org.osate.alisa.common.typing.AListTerm";
  
  public final static String INTEGERLITERAL = "org.osate.alisa.common.typing.IntegerLiteral";
  
  public final static String REALLITERAL = "org.osate.alisa.common.typing.RealLiteral";
  
  public final static String BOOLEANLITERAL = "org.osate.alisa.common.typing.BooleanLiteral";
  
  public final static String STRINGLITERAL = "org.osate.alisa.common.typing.StringLiteral";
  
  private PolymorphicDispatcher<Result<PropertyType>> typeDispatcher;
  
  public CommonTypeSystem() {
    init();
  }
  
  public void init() {
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
  }
  
  public Result<PropertyType> type(final EObject commonObject) {
    return type(new RuleEnvironment(), null, commonObject);
  }
  
  public Result<PropertyType> type(final RuleEnvironment _environment_, final EObject commonObject) {
    return type(_environment_, null, commonObject);
  }
  
  public Result<PropertyType> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject commonObject) {
    try {
    	return typeInternal(_environment_, _trace_, commonObject);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  protected Result<PropertyType> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject commonObject) {
    try {
    	checkParamsNotNull(commonObject);
    	return typeDispatcher.invoke(_environment_, _trace_, commonObject);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject commonObject, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(commonObject);
    String _plus = ("cannot type " + _stringRep);
    String error = _plus;
    EObject source = commonObject;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
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
    /* G |- valDecl.right : type */
    PropertyExpression _right = valDecl.getRight();
    Result<PropertyType> result = typeInternal(G, _trace_, _right);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    type = (PropertyType) result.getFirst();
    
    return new Result<PropertyType>(type);
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
    	typeThrowException(ruleName("AExpression") + stringRepForEnv(G) + " |- " + stringRep(param) + " : " + "PropertyType",
    		AEXPRESSION,
    		e_applyRuleAExpression, param, new ErrorInformation[] {new ErrorInformation(param)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleAExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final PropertyExpression param) throws RuleFailedException {
    PropertyType type = null; // output parameter
    AadlInteger _createAadlInteger = Aadl2Factory.eINSTANCE.createAadlInteger();
    type = _createAadlInteger;
    return new Result<PropertyType>(type);
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
    /* G |- binary.leftOperand : var PropertyType leftType */
    PropertyExpression _leftOperand = binary.getLeftOperand();
    PropertyType leftType = null;
    Result<PropertyType> result = typeInternal(G, _trace_, _leftOperand);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    leftType = (PropertyType) result.getFirst();
    
    /* G |- binary.rightOperand : var PropertyType rightType */
    PropertyExpression _rightOperand = binary.getRightOperand();
    PropertyType rightType = null;
    Result<PropertyType> result_1 = typeInternal(G, _trace_, _rightOperand);
    checkAssignableTo(result_1.getFirst(), PropertyType.class);
    rightType = (PropertyType) result_1.getFirst();
    
    final String op = binary.getFeature();
    switch (op) {
      case "&&":
      case "||":
        boolean _and = false;
        if (!(leftType instanceof AadlBoolean)) {
          _and = false;
        } else {
          _and = (rightType instanceof AadlBoolean);
        }
        /* leftType instanceof AadlBoolean && rightType instanceof AadlBoolean */
        if (!_and) {
          sneakyThrowRuleFailedException("leftType instanceof AadlBoolean && rightType instanceof AadlBoolean");
        }
        type = leftType;
        break;
      case "==":
      case "!=":
        EClass _eClass = leftType.eClass();
        EClass _eClass_1 = rightType.eClass();
        boolean _equals = Objects.equal(_eClass, _eClass_1);
        /* leftType.eClass == rightType.eClass */
        if (!_equals) {
          sneakyThrowRuleFailedException("leftType.eClass == rightType.eClass");
        }
        AadlBoolean _createAadlBoolean = Aadl2Factory.eINSTANCE.createAadlBoolean();
        type = _createAadlBoolean;
        break;
      case "<":
      case "<=":
      case ">":
      case ">=":
        boolean _and_1 = false;
        if (!(leftType instanceof NumberType)) {
          _and_1 = false;
        } else {
          _and_1 = (rightType instanceof NumberType);
        }
        /* leftType instanceof NumberType && rightType instanceof NumberType */
        if (!_and_1) {
          sneakyThrowRuleFailedException("leftType instanceof NumberType && rightType instanceof NumberType");
        }
        AadlBoolean _createAadlBoolean_1 = Aadl2Factory.eINSTANCE.createAadlBoolean();
        type = _createAadlBoolean_1;
        break;
      case "*":
      case "/":
      case "+":
      case "-":
        boolean _and_2 = false;
        if (!(leftType instanceof NumberType)) {
          _and_2 = false;
        } else {
          _and_2 = (rightType instanceof NumberType);
        }
        /* leftType instanceof NumberType && rightType instanceof NumberType */
        if (!_and_2) {
          sneakyThrowRuleFailedException("leftType instanceof NumberType && rightType instanceof NumberType");
        }
        PropertyType _xifexpression = null;
        if ((leftType instanceof AadlReal)) {
          _xifexpression = leftType;
        } else {
          _xifexpression = rightType;
        }
        type = _xifexpression;
        break;
    }
    return new Result<PropertyType>(type);
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AListTerm list) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleAListTerm(G, _subtrace_, list);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AListTerm") + stringRepForEnv(G) + " |- " + stringRep(list) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAListTerm) {
    	typeThrowException(ruleName("AListTerm") + stringRepForEnv(G) + " |- " + stringRep(list) + " : " + "ListType",
    		ALISTTERM,
    		e_applyRuleAListTerm, list, new ErrorInformation[] {new ErrorInformation(list)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleAListTerm(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AListTerm list) throws RuleFailedException {
    ListType type = null; // output parameter
    ListType _createListType = Aadl2Factory.eINSTANCE.createListType();
    type = _createListType;
    PropertyType elementType = null;
    /* G |- list.elements.head : elementType */
    EList<PropertyExpression> _elements = list.getElements();
    PropertyExpression _head = IterableExtensions.<PropertyExpression>head(_elements);
    Result<PropertyType> result = typeInternal(G, _trace_, _head);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    elementType = (PropertyType) result.getFirst();
    
    type.setOwnedElementType(elementType);
    return new Result<PropertyType>(type);
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
    AadlInteger _xblockexpression = null;
    {
      final AadlInteger intType = Aadl2Factory.eINSTANCE.createAadlInteger();
      UnitLiteral _unit = value.getUnit();
      EObject _eContainer = null;
      if (_unit!=null) {
        _eContainer=_unit.eContainer();
      }
      intType.setReferencedUnitsType(((UnitsType) _eContainer));
      _xblockexpression = (intType);
    }
    return _xblockexpression;
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
    AadlReal _xblockexpression = null;
    {
      final AadlReal realType = Aadl2Factory.eINSTANCE.createAadlReal();
      UnitLiteral _unit = value.getUnit();
      EObject _eContainer = null;
      if (_unit!=null) {
        _eContainer=_unit.eContainer();
      }
      realType.setReferencedUnitsType(((UnitsType) _eContainer));
      _xblockexpression = (realType);
    }
    return _xblockexpression;
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
}
