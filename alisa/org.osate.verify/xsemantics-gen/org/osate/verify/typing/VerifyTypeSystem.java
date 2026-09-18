package org.osate.verify.typing;

import com.google.inject.Provider;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xsemantics.runtime.ErrorInformation;
import org.eclipse.xsemantics.runtime.Result;
import org.eclipse.xsemantics.runtime.RuleApplicationTrace;
import org.eclipse.xsemantics.runtime.RuleEnvironment;
import org.eclipse.xsemantics.runtime.RuleFailedException;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.alisa.common.common.ComputeDeclaration;
import org.osate.alisa.common.typing.CommonTypeSystem;
import org.osate.verify.verify.ComputeRef;
import org.osate.verify.verify.FormalParameter;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerifyPackage;

@SuppressWarnings("all")
public class VerifyTypeSystem extends CommonTypeSystem {
  public static final String TYPEFORMALPARAMETER = "org.osate.verify.typing.TypeFormalParameter";

  public static final String ARGUMENTSEQUENCE = "org.osate.verify.typing.ArgumentSequence";

  public static final String ARGUMENT = "org.osate.verify.typing.Argument";

  public static final String RETURNSEQUENCE = "org.osate.verify.typing.ReturnSequence";

  public static final String RETURN = "org.osate.verify.typing.Return";

  public static final String PROPERTYVALUES = "org.osate.verify.typing.PropertyValues";

  private PolymorphicDispatcher<Result<Boolean>> assignArgumentDispatcher;

  private PolymorphicDispatcher<Result<Boolean>> assignReturnDispatcher;

  private PolymorphicDispatcher<Result<Boolean>> assignArgumentsDispatcher;

  private PolymorphicDispatcher<Result<Boolean>> assignReturnsDispatcher;

  private PolymorphicDispatcher<Result<Boolean>> assignPropertiesDispatcher;

  public VerifyTypeSystem() {
    init();
  }

  @Override
  public void init() {
    super.init();
    assignArgumentDispatcher = buildPolymorphicDispatcher1(
    	"assignArgumentImpl", 4, "|-", "<-");
    assignReturnDispatcher = buildPolymorphicDispatcher1(
    	"assignReturnImpl", 4, "|-", "-->");
    assignArgumentsDispatcher = buildPolymorphicDispatcher1(
    	"assignArgumentsImpl", 5, "|-", "~>", "<<");
    assignReturnsDispatcher = buildPolymorphicDispatcher1(
    	"assignReturnsImpl", 5, "|-", "~>", ">>");
    assignPropertiesDispatcher = buildPolymorphicDispatcher1(
    	"assignPropertiesImpl", 5, "||-", "~>", "<<");
  }

  public Result<Boolean> assignArgument(final FormalParameter formal, final PropertyExpression actual) {
    return assignArgument(new RuleEnvironment(), null, formal, actual);
  }

  public Result<Boolean> assignArgument(final RuleEnvironment _environment_, final FormalParameter formal, final PropertyExpression actual) {
    return assignArgument(_environment_, null, formal, actual);
  }

  public Result<Boolean> assignArgument(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final FormalParameter formal, final PropertyExpression actual) {
    try {
    	return assignArgumentInternal(_environment_, _trace_, formal, actual);
    } catch (Exception _e_assignArgument) {
    	return resultForFailure(_e_assignArgument);
    }
  }

  public Boolean assignArgumentSucceeded(final FormalParameter formal, final PropertyExpression actual) {
    return assignArgumentSucceeded(new RuleEnvironment(), null, formal, actual);
  }

  public Boolean assignArgumentSucceeded(final RuleEnvironment _environment_, final FormalParameter formal, final PropertyExpression actual) {
    return assignArgumentSucceeded(_environment_, null, formal, actual);
  }

  public Boolean assignArgumentSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final FormalParameter formal, final PropertyExpression actual) {
    try {
    	assignArgumentInternal(_environment_, _trace_, formal, actual);
    	return true;
    } catch (Exception _e_assignArgument) {
    	return false;
    }
  }

  public Result<Boolean> assignReturn(final FormalParameter ret, final ComputeRef compute) {
    return assignReturn(new RuleEnvironment(), null, ret, compute);
  }

  public Result<Boolean> assignReturn(final RuleEnvironment _environment_, final FormalParameter ret, final ComputeRef compute) {
    return assignReturn(_environment_, null, ret, compute);
  }

  public Result<Boolean> assignReturn(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final FormalParameter ret, final ComputeRef compute) {
    try {
    	return assignReturnInternal(_environment_, _trace_, ret, compute);
    } catch (Exception _e_assignReturn) {
    	return resultForFailure(_e_assignReturn);
    }
  }

  public Boolean assignReturnSucceeded(final FormalParameter ret, final ComputeRef compute) {
    return assignReturnSucceeded(new RuleEnvironment(), null, ret, compute);
  }

  public Boolean assignReturnSucceeded(final RuleEnvironment _environment_, final FormalParameter ret, final ComputeRef compute) {
    return assignReturnSucceeded(_environment_, null, ret, compute);
  }

  public Boolean assignReturnSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final FormalParameter ret, final ComputeRef compute) {
    try {
    	assignReturnInternal(_environment_, _trace_, ret, compute);
    	return true;
    } catch (Exception _e_assignReturn) {
    	return false;
    }
  }

  public Result<Boolean> assignArguments(final VerificationActivity owner, final List<FormalParameter> formals, final List<PropertyExpression> actuals) {
    return assignArguments(new RuleEnvironment(), null, owner, formals, actuals);
  }

  public Result<Boolean> assignArguments(final RuleEnvironment _environment_, final VerificationActivity owner, final List<FormalParameter> formals, final List<PropertyExpression> actuals) {
    return assignArguments(_environment_, null, owner, formals, actuals);
  }

  public Result<Boolean> assignArguments(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> formals, final List<PropertyExpression> actuals) {
    try {
    	return assignArgumentsInternal(_environment_, _trace_, owner, formals, actuals);
    } catch (Exception _e_assignArguments) {
    	return resultForFailure(_e_assignArguments);
    }
  }

  public Boolean assignArgumentsSucceeded(final VerificationActivity owner, final List<FormalParameter> formals, final List<PropertyExpression> actuals) {
    return assignArgumentsSucceeded(new RuleEnvironment(), null, owner, formals, actuals);
  }

  public Boolean assignArgumentsSucceeded(final RuleEnvironment _environment_, final VerificationActivity owner, final List<FormalParameter> formals, final List<PropertyExpression> actuals) {
    return assignArgumentsSucceeded(_environment_, null, owner, formals, actuals);
  }

  public Boolean assignArgumentsSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> formals, final List<PropertyExpression> actuals) {
    try {
    	assignArgumentsInternal(_environment_, _trace_, owner, formals, actuals);
    	return true;
    } catch (Exception _e_assignArguments) {
    	return false;
    }
  }

  public Result<Boolean> assignReturns(final VerificationActivity owner, final List<FormalParameter> returns, final List<ComputeRef> computes) {
    return assignReturns(new RuleEnvironment(), null, owner, returns, computes);
  }

  public Result<Boolean> assignReturns(final RuleEnvironment _environment_, final VerificationActivity owner, final List<FormalParameter> returns, final List<ComputeRef> computes) {
    return assignReturns(_environment_, null, owner, returns, computes);
  }

  public Result<Boolean> assignReturns(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> returns, final List<ComputeRef> computes) {
    try {
    	return assignReturnsInternal(_environment_, _trace_, owner, returns, computes);
    } catch (Exception _e_assignReturns) {
    	return resultForFailure(_e_assignReturns);
    }
  }

  public Boolean assignReturnsSucceeded(final VerificationActivity owner, final List<FormalParameter> returns, final List<ComputeRef> computes) {
    return assignReturnsSucceeded(new RuleEnvironment(), null, owner, returns, computes);
  }

  public Boolean assignReturnsSucceeded(final RuleEnvironment _environment_, final VerificationActivity owner, final List<FormalParameter> returns, final List<ComputeRef> computes) {
    return assignReturnsSucceeded(_environment_, null, owner, returns, computes);
  }

  public Boolean assignReturnsSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> returns, final List<ComputeRef> computes) {
    try {
    	assignReturnsInternal(_environment_, _trace_, owner, returns, computes);
    	return true;
    } catch (Exception _e_assignReturns) {
    	return false;
    }
  }

  public Result<Boolean> assignProperties(final VerificationActivity owner, final List<Property> properties, final List<PropertyExpression> values) {
    return assignProperties(new RuleEnvironment(), null, owner, properties, values);
  }

  public Result<Boolean> assignProperties(final RuleEnvironment _environment_, final VerificationActivity owner, final List<Property> properties, final List<PropertyExpression> values) {
    return assignProperties(_environment_, null, owner, properties, values);
  }

  public Result<Boolean> assignProperties(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<Property> properties, final List<PropertyExpression> values) {
    try {
    	return assignPropertiesInternal(_environment_, _trace_, owner, properties, values);
    } catch (Exception _e_assignProperties) {
    	return resultForFailure(_e_assignProperties);
    }
  }

  public Boolean assignPropertiesSucceeded(final VerificationActivity owner, final List<Property> properties, final List<PropertyExpression> values) {
    return assignPropertiesSucceeded(new RuleEnvironment(), null, owner, properties, values);
  }

  public Boolean assignPropertiesSucceeded(final RuleEnvironment _environment_, final VerificationActivity owner, final List<Property> properties, final List<PropertyExpression> values) {
    return assignPropertiesSucceeded(_environment_, null, owner, properties, values);
  }

  public Boolean assignPropertiesSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<Property> properties, final List<PropertyExpression> values) {
    try {
    	assignPropertiesInternal(_environment_, _trace_, owner, properties, values);
    	return true;
    } catch (Exception _e_assignProperties) {
    	return false;
    }
  }

  public Result<Boolean> checkVerificationMethodParams(final FormalParameter formal) {
    return checkVerificationMethodParams(null, formal);
  }

  public Result<Boolean> checkVerificationMethodParams(final RuleApplicationTrace _trace_, final FormalParameter formal) {
    try {
    	return checkVerificationMethodParamsInternal(_trace_, formal);
    } catch (Exception _e_CheckVerificationMethodParams) {
    	return resultForFailure(_e_CheckVerificationMethodParams);
    }
  }

  protected Result<Boolean> checkVerificationMethodParamsInternal(final RuleApplicationTrace _trace_, final FormalParameter formal) throws RuleFailedException {
    /* empty |-formal : var PropertyType type */
    PropertyType type = null;
    Result<PropertyType> result = typeInternal(emptyEnvironment(), _trace_, formal);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    type = (PropertyType) result.getFirst();
    
    return new Result<Boolean>(true);
  }

  public Result<Boolean> checkActivityArguments(final VerificationActivity activity) {
    return checkActivityArguments(null, activity);
  }

  public Result<Boolean> checkActivityArguments(final RuleApplicationTrace _trace_, final VerificationActivity activity) {
    try {
    	return checkActivityArgumentsInternal(_trace_, activity);
    } catch (Exception _e_CheckActivityArguments) {
    	return resultForFailure(_e_CheckActivityArguments);
    }
  }

  protected Result<Boolean> checkActivityArgumentsInternal(final RuleApplicationTrace _trace_, final VerificationActivity activity) throws RuleFailedException {
    final VerificationMethod method = activity.getMethod();
    /* empty |- activity ~> method.formals << activity.actuals */
    EList<FormalParameter> _formals = method.getFormals();
    EList<PropertyExpression> _actuals = activity.getActuals();
    assignArgumentsInternal(emptyEnvironment(), _trace_, activity, _formals, _actuals);
    return new Result<Boolean>(true);
  }

  public Result<Boolean> checkActivityReturns(final VerificationActivity activity) {
    return checkActivityReturns(null, activity);
  }

  public Result<Boolean> checkActivityReturns(final RuleApplicationTrace _trace_, final VerificationActivity activity) {
    try {
    	return checkActivityReturnsInternal(_trace_, activity);
    } catch (Exception _e_CheckActivityReturns) {
    	return resultForFailure(_e_CheckActivityReturns);
    }
  }

  protected Result<Boolean> checkActivityReturnsInternal(final RuleApplicationTrace _trace_, final VerificationActivity activity) throws RuleFailedException {
    final VerificationMethod method = activity.getMethod();
    /* empty |- activity ~> method.results >> activity.computes */
    EList<FormalParameter> _results = method.getResults();
    EList<ComputeRef> _computes = activity.getComputes();
    assignReturnsInternal(emptyEnvironment(), _trace_, activity, _results, _computes);
    return new Result<Boolean>(true);
  }

  public Result<Boolean> checkPropertyTypes(final VerificationActivity activity) {
    return checkPropertyTypes(null, activity);
  }

  public Result<Boolean> checkPropertyTypes(final RuleApplicationTrace _trace_, final VerificationActivity activity) {
    try {
    	return checkPropertyTypesInternal(_trace_, activity);
    } catch (Exception _e_CheckPropertyTypes) {
    	return resultForFailure(_e_CheckPropertyTypes);
    }
  }

  protected Result<Boolean> checkPropertyTypesInternal(final RuleApplicationTrace _trace_, final VerificationActivity activity) throws RuleFailedException {
    final VerificationMethod method = activity.getMethod();
    /* empty ||- activity ~> method.properties << activity.propertyValues */
    EList<Property> _properties = method.getProperties();
    EList<PropertyExpression> _propertyValues = activity.getPropertyValues();
    assignPropertiesInternal(emptyEnvironment(), _trace_, activity, _properties, _propertyValues);
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> assignArgumentInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final FormalParameter formal, final PropertyExpression actual) {
    try {
    	checkParamsNotNull(formal, actual);
    	return assignArgumentDispatcher.invoke(_environment_, _trace_, formal, actual);
    } catch (Exception _e_assignArgument) {
    	sneakyThrowRuleFailedException(_e_assignArgument);
    	return null;
    }
  }

  protected void assignArgumentThrowException(final String _error, final String _issue, final Exception _ex, final FormalParameter formal, final PropertyExpression actual, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Boolean> assignReturnInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final FormalParameter ret, final ComputeRef compute) {
    try {
    	checkParamsNotNull(ret, compute);
    	return assignReturnDispatcher.invoke(_environment_, _trace_, ret, compute);
    } catch (Exception _e_assignReturn) {
    	sneakyThrowRuleFailedException(_e_assignReturn);
    	return null;
    }
  }

  protected void assignReturnThrowException(final String _error, final String _issue, final Exception _ex, final FormalParameter ret, final ComputeRef compute, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Boolean> assignArgumentsInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> formals, final List<PropertyExpression> actuals) {
    try {
    	checkParamsNotNull(owner, formals, actuals);
    	return assignArgumentsDispatcher.invoke(_environment_, _trace_, owner, formals, actuals);
    } catch (Exception _e_assignArguments) {
    	sneakyThrowRuleFailedException(_e_assignArguments);
    	return null;
    }
  }

  protected void assignArgumentsThrowException(final String _error, final String _issue, final Exception _ex, final VerificationActivity owner, final List<FormalParameter> formals, final List<PropertyExpression> actuals, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Boolean> assignReturnsInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> returns, final List<ComputeRef> computes) {
    try {
    	checkParamsNotNull(owner, returns, computes);
    	return assignReturnsDispatcher.invoke(_environment_, _trace_, owner, returns, computes);
    } catch (Exception _e_assignReturns) {
    	sneakyThrowRuleFailedException(_e_assignReturns);
    	return null;
    }
  }

  protected void assignReturnsThrowException(final String _error, final String _issue, final Exception _ex, final VerificationActivity owner, final List<FormalParameter> returns, final List<ComputeRef> computes, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<Boolean> assignPropertiesInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<Property> properties, final List<PropertyExpression> values) {
    try {
    	checkParamsNotNull(owner, properties, values);
    	return assignPropertiesDispatcher.invoke(_environment_, _trace_, owner, properties, values);
    } catch (Exception _e_assignProperties) {
    	sneakyThrowRuleFailedException(_e_assignProperties);
    	return null;
    }
  }

  protected void assignPropertiesThrowException(final String _error, final String _issue, final Exception _ex, final VerificationActivity owner, final List<Property> properties, final List<PropertyExpression> values, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }

  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final FormalParameter param) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleTypeFormalParameter(G, _subtrace_, param);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("TypeFormalParameter") + stringRepForEnv(G) + " |- " + stringRep(param) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleTypeFormalParameter) {
    	typeThrowException(ruleName("TypeFormalParameter") + stringRepForEnv(G) + " |- " + stringRep(param) + " : " + "PropertyType",
    		TYPEFORMALPARAMETER,
    		e_applyRuleTypeFormalParameter, param, new ErrorInformation[] {new ErrorInformation(param)});
    	return null;
    }
  }

  protected Result<PropertyType> applyRuleTypeFormalParameter(final RuleEnvironment G, final RuleApplicationTrace _trace_, final FormalParameter param) throws RuleFailedException {
    PropertyType expType = null; // output parameter
    final PropertyType declared = param.getType();
    /* declared !== null */
    if (!(declared != null)) {
      sneakyThrowRuleFailedException("declared !== null");
    }
    /* G |- declared : expType */
    Result<PropertyType> result = typeInternal(G, _trace_, declared);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    expType = (PropertyType) result.getFirst();
    
    UnitLiteral _unit = param.getUnit();
    boolean _tripleNotEquals = (_unit != null);
    if (_tripleNotEquals) {
      EObject _eContainer = param.getUnit().eContainer();
      final UnitsType targetType = ((UnitsType) _eContainer);
      /* expType instanceof NumberType or fail error 'typing: can only convert unit of a numeric type' source param */
      {
        RuleFailedException previousFailure = null;
        try {
        } catch (Exception e) {
          previousFailure = extractRuleFailedException(e);
          /* fail error 'typing: can only convert unit of a numeric type' source param */
          String error = "typing: can only convert unit of a numeric type";
          EObject source = param;
          throwForExplicitFail(error, new ErrorInformation(source, null));
        }
      }
      final NumberType numType = ((NumberType) expType);
      /* numType.unitsType !== null or fail error 'typing: parameter type has no unit' source param */
      {
        RuleFailedException previousFailure = null;
        try {
          UnitsType _unitsType = numType.getUnitsType();
          boolean _tripleNotEquals_1 = (_unitsType != null);
          /* numType.unitsType !== null */
          if (!_tripleNotEquals_1) {
            sneakyThrowRuleFailedException("numType.unitsType !== null");
          }
        } catch (Exception e_1) {
          previousFailure = extractRuleFailedException(e_1);
          /* fail error 'typing: parameter type has no unit' source param */
          String error_1 = "typing: parameter type has no unit";
          EObject source_1 = param;
          throwForExplicitFail(error_1, new ErrorInformation(source_1, null));
        }
      }
      /* G |- numType.unitsType ~~ targetType or fail error 'typing: cannot convert ' + stringRep(numType) + ' to ' + stringRep(targetType) source param */
      {
        RuleFailedException previousFailure = null;
        try {
          /* G |- numType.unitsType ~~ targetType */
          UnitsType _unitsType_1 = numType.getUnitsType();
          sameTypeInternal(G, _trace_, _unitsType_1, targetType);
        } catch (Exception e_2) {
          previousFailure = extractRuleFailedException(e_2);
          /* fail error 'typing: cannot convert ' + stringRep(numType) + ' to ' + stringRep(targetType) source param */
          String _stringRep = this.stringRep(numType);
          String _plus = ("typing: cannot convert " + _stringRep);
          String _plus_1 = (_plus + " to ");
          String _stringRep_1 = this.stringRep(targetType);
          String _plus_2 = (_plus_1 + _stringRep_1);
          String error_2 = _plus_2;
          EObject source_2 = param;
          throwForExplicitFail(error_2, new ErrorInformation(source_2, null));
        }
      }
    }
    return new Result<PropertyType>(expType);
  }

  protected Result<Boolean> assignArgumentsImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> formals, final EList<PropertyExpression> actuals) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleArgumentSequence(G, _subtrace_, owner, formals, actuals);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ArgumentSequence") + stringRepForEnv(G) + " |- " + stringRep(owner) + " ~> " + stringRep(formals) + " << " + stringRep(actuals);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleArgumentSequence) {
    	assignArgumentsThrowException(ruleName("ArgumentSequence") + stringRepForEnv(G) + " |- " + stringRep(owner) + " ~> " + stringRep(formals) + " << " + stringRep(actuals),
    		ARGUMENTSEQUENCE,
    		e_applyRuleArgumentSequence, owner, formals, actuals, new ErrorInformation[] {new ErrorInformation(owner)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleArgumentSequence(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> formals, final EList<PropertyExpression> actuals) throws RuleFailedException {
    /* actuals.size == formals.size or fail error 'expected ' + formals.size + ' arguments, but got ' + actuals.size source owner */
    {
      RuleFailedException previousFailure = null;
      try {
        int _size = actuals.size();
        int _size_1 = formals.size();
        boolean _equals = (_size == _size_1);
        /* actuals.size == formals.size */
        if (!_equals) {
          sneakyThrowRuleFailedException("actuals.size == formals.size");
        }
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* fail error 'expected ' + formals.size + ' arguments, but got ' + actuals.size source owner */
        int _size_2 = formals.size();
        String _plus = ("expected " + Integer.valueOf(_size_2));
        String _plus_1 = (_plus + " arguments, but got ");
        int _size_3 = actuals.size();
        String _plus_2 = (_plus_1 + Integer.valueOf(_size_3));
        String error = _plus_2;
        EObject source = owner;
        throwForExplicitFail(error, new ErrorInformation(source, null));
      }
    }
    final Iterator<PropertyExpression> aIter = actuals.iterator();
    final Iterator<FormalParameter> fIter = formals.iterator();
    while ((aIter.hasNext() && fIter.hasNext())) {
      final PropertyExpression actual = aIter.next();
      final FormalParameter formal = fIter.next();
      /* G |- formal <- actual */
      assignArgumentInternal(G, _trace_, formal, actual);
    }
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> assignArgumentImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final FormalParameter formal, final PropertyExpression actual) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleArgument(G, _subtrace_, formal, actual);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Argument") + stringRepForEnv(G) + " |- " + stringRep(formal) + " <- " + stringRep(actual);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleArgument) {
    	assignArgumentThrowException(ruleName("Argument") + stringRepForEnv(G) + " |- " + stringRep(formal) + " <- " + stringRep(actual),
    		ARGUMENT,
    		e_applyRuleArgument, formal, actual, new ErrorInformation[] {new ErrorInformation(formal), new ErrorInformation(actual)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleArgument(final RuleEnvironment G, final RuleApplicationTrace _trace_, final FormalParameter formal, final PropertyExpression actual) throws RuleFailedException {
    /* G |- actual : var PropertyType actualType */
    PropertyType actualType = null;
    Result<PropertyType> result = typeInternal(G, _trace_, actual);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    actualType = (PropertyType) result.getFirst();
    
    PropertyType formalType = null;
    /* G |- formal : formalType or { } */
    {
      RuleFailedException previousFailure = null;
      try {
        /* G |- formal : formalType */
        Result<PropertyType> result_1 = typeInternal(G, _trace_, formal);
        checkAssignableTo(result_1.getFirst(), PropertyType.class);
        formalType = (PropertyType) result_1.getFirst();
        
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
      }
    }
    if ((formalType != null)) {
      /* G |- formalType <: actualType or fail error 'typing: ' + stringRep(actualType) + 'cannot be assigned to ' + stringRep(formalType) source actual */
      {
        RuleFailedException previousFailure = null;
        try {
          /* G |- formalType <: actualType */
          compatibleInternal(G, _trace_, formalType, actualType);
        } catch (Exception e_1) {
          previousFailure = extractRuleFailedException(e_1);
          /* fail error 'typing: ' + stringRep(actualType) + 'cannot be assigned to ' + stringRep(formalType) source actual */
          String _stringRep = this.stringRep(actualType);
          String _plus = ("typing: " + _stringRep);
          String _plus_1 = (_plus + "cannot be assigned to ");
          String _stringRep_1 = this.stringRep(formalType);
          String _plus_2 = (_plus_1 + _stringRep_1);
          String error = _plus_2;
          EObject source = actual;
          throwForExplicitFail(error, new ErrorInformation(source, null));
        }
      }
    }
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> assignReturnsImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> returns, final List<ComputeRef> computeRefs) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleReturnSequence(G, _subtrace_, owner, returns, computeRefs);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("ReturnSequence") + stringRepForEnv(G) + " |- " + stringRep(owner) + " ~> " + stringRep(returns) + " >> " + stringRep(computeRefs);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleReturnSequence) {
    	assignReturnsThrowException(ruleName("ReturnSequence") + stringRepForEnv(G) + " |- " + stringRep(owner) + " ~> " + stringRep(returns) + " >> " + stringRep(computeRefs),
    		RETURNSEQUENCE,
    		e_applyRuleReturnSequence, owner, returns, computeRefs, new ErrorInformation[] {new ErrorInformation(owner)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleReturnSequence(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> returns, final List<ComputeRef> computeRefs) throws RuleFailedException {
    /* computeRefs.size == returns.size or fail error 'expected ' + returns.size + ' return values, but got ' + computeRefs.size feature VerifyPackage.eINSTANCE.verificationActivity_Computes source owner */
    {
      RuleFailedException previousFailure = null;
      try {
        int _size = computeRefs.size();
        int _size_1 = returns.size();
        boolean _equals = (_size == _size_1);
        /* computeRefs.size == returns.size */
        if (!_equals) {
          sneakyThrowRuleFailedException("computeRefs.size == returns.size");
        }
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* fail error 'expected ' + returns.size + ' return values, but got ' + computeRefs.size feature VerifyPackage.eINSTANCE.verificationActivity_Computes source owner */
        int _size_2 = returns.size();
        String _plus = ("expected " + Integer.valueOf(_size_2));
        String _plus_1 = (_plus + " return values, but got ");
        int _size_3 = computeRefs.size();
        String _plus_2 = (_plus_1 + Integer.valueOf(_size_3));
        String error = _plus_2;
        EObject source = owner;
        EReference _verificationActivity_Computes = VerifyPackage.eINSTANCE.getVerificationActivity_Computes();
        EStructuralFeature feature = _verificationActivity_Computes;
        throwForExplicitFail(error, new ErrorInformation(source, feature));
      }
    }
    final Iterator<ComputeRef> cIter = computeRefs.iterator();
    final Iterator<FormalParameter> rIter = returns.iterator();
    while ((cIter.hasNext() && rIter.hasNext())) {
      final ComputeRef computeRef = cIter.next();
      final FormalParameter ret = rIter.next();
      /* G |- ret --> computeRef */
      assignReturnInternal(G, _trace_, ret, computeRef);
    }
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> assignReturnImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final FormalParameter ret, final ComputeRef computeRef) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleReturn(G, _subtrace_, ret, computeRef);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Return") + stringRepForEnv(G) + " |- " + stringRep(ret) + " --> " + stringRep(computeRef);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleReturn) {
    	assignReturnThrowException(ruleName("Return") + stringRepForEnv(G) + " |- " + stringRep(ret) + " --> " + stringRep(computeRef),
    		RETURN,
    		e_applyRuleReturn, ret, computeRef, new ErrorInformation[] {new ErrorInformation(ret), new ErrorInformation(computeRef)});
    	return null;
    }
  }

  protected Result<Boolean> applyRuleReturn(final RuleEnvironment G, final RuleApplicationTrace _trace_, final FormalParameter ret, final ComputeRef computeRef) throws RuleFailedException {
    ComputeDeclaration _compute = computeRef.getCompute();
    boolean _tripleNotEquals = (_compute != null);
    if (_tripleNotEquals) {
      /* G |- computeRef.compute : var PropertyType computeType */
      ComputeDeclaration _compute_1 = computeRef.getCompute();
      PropertyType computeType = null;
      Result<PropertyType> result = typeInternal(G, _trace_, _compute_1);
      checkAssignableTo(result.getFirst(), PropertyType.class);
      computeType = (PropertyType) result.getFirst();
      
      PropertyType retType = null;
      /* G |- ret : retType or { } */
      {
        RuleFailedException previousFailure = null;
        try {
          /* G |- ret : retType */
          Result<PropertyType> result_1 = typeInternal(G, _trace_, ret);
          checkAssignableTo(result_1.getFirst(), PropertyType.class);
          retType = (PropertyType) result_1.getFirst();
          
        } catch (Exception e) {
          previousFailure = extractRuleFailedException(e);
        }
      }
      if ((retType != null)) {
        /* G |- computeType <: retType or fail error 'typing: ' + stringRep(retType) + 'cannot be assigned to ' + stringRep(computeType) source computeRef */
        {
          RuleFailedException previousFailure = null;
          try {
            /* G |- computeType <: retType */
            compatibleInternal(G, _trace_, computeType, retType);
          } catch (Exception e_1) {
            previousFailure = extractRuleFailedException(e_1);
            /* fail error 'typing: ' + stringRep(retType) + 'cannot be assigned to ' + stringRep(computeType) source computeRef */
            String _stringRep = this.stringRep(retType);
            String _plus = ("typing: " + _stringRep);
            String _plus_1 = (_plus + "cannot be assigned to ");
            String _stringRep_1 = this.stringRep(computeType);
            String _plus_2 = (_plus_1 + _stringRep_1);
            String error = _plus_2;
            EObject source = computeRef;
            throwForExplicitFail(error, new ErrorInformation(source, null));
          }
        }
      }
    }
    return new Result<Boolean>(true);
  }

  protected Result<Boolean> assignPropertiesImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<Property> properties, final List<PropertyExpression> values) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRulePropertyValues(G, _subtrace_, owner, properties, values);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("PropertyValues") + stringRepForEnv(G) + " ||- " + stringRep(owner) + " ~> " + stringRep(properties) + " << " + stringRep(values);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRulePropertyValues) {
    	assignPropertiesThrowException(ruleName("PropertyValues") + stringRepForEnv(G) + " ||- " + stringRep(owner) + " ~> " + stringRep(properties) + " << " + stringRep(values),
    		PROPERTYVALUES,
    		e_applyRulePropertyValues, owner, properties, values, new ErrorInformation[] {new ErrorInformation(owner)});
    	return null;
    }
  }

  protected Result<Boolean> applyRulePropertyValues(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<Property> properties, final List<PropertyExpression> values) throws RuleFailedException {
    /* properties.size == values.size or fail error 'expected ' + properties.size + ' property values, but got ' + values.size feature VerifyPackage.eINSTANCE.verificationActivity_PropertyValues source owner */
    {
      RuleFailedException previousFailure = null;
      try {
        int _size = properties.size();
        int _size_1 = values.size();
        boolean _equals = (_size == _size_1);
        /* properties.size == values.size */
        if (!_equals) {
          sneakyThrowRuleFailedException("properties.size == values.size");
        }
      } catch (Exception e) {
        previousFailure = extractRuleFailedException(e);
        /* fail error 'expected ' + properties.size + ' property values, but got ' + values.size feature VerifyPackage.eINSTANCE.verificationActivity_PropertyValues source owner */
        int _size_2 = properties.size();
        String _plus = ("expected " + Integer.valueOf(_size_2));
        String _plus_1 = (_plus + " property values, but got ");
        int _size_3 = values.size();
        String _plus_2 = (_plus_1 + Integer.valueOf(_size_3));
        String error = _plus_2;
        EObject source = owner;
        EReference _verificationActivity_PropertyValues = VerifyPackage.eINSTANCE.getVerificationActivity_PropertyValues();
        EStructuralFeature feature = _verificationActivity_PropertyValues;
        throwForExplicitFail(error, new ErrorInformation(source, feature));
      }
    }
    final Iterator<Property> pIter = properties.iterator();
    final Iterator<PropertyExpression> vIter = values.iterator();
    while ((pIter.hasNext() && vIter.hasNext())) {
      final Property property = pIter.next();
      final PropertyExpression value = vIter.next();
      final PropertyType left = property.getPropertyType();
      /* G |- value : var PropertyType right */
      PropertyType right = null;
      Result<PropertyType> result = typeInternal(G, _trace_, value);
      checkAssignableTo(result.getFirst(), PropertyType.class);
      right = (PropertyType) result.getFirst();
      
      /* G |- left <: right or fail error 'typing: ' + stringRep(right) + 'cannot be assigned to ' + stringRep(left) source value */
      {
        RuleFailedException previousFailure = null;
        try {
          /* G |- left <: right */
          compatibleInternal(G, _trace_, left, right);
        } catch (Exception e_1) {
          previousFailure = extractRuleFailedException(e_1);
          /* fail error 'typing: ' + stringRep(right) + 'cannot be assigned to ' + stringRep(left) source value */
          String _stringRep = this.stringRep(right);
          String _plus_3 = ("typing: " + _stringRep);
          String _plus_4 = (_plus_3 + "cannot be assigned to ");
          String _stringRep_1 = this.stringRep(left);
          String _plus_5 = (_plus_4 + _stringRep_1);
          String error_1 = _plus_5;
          EObject source_1 = value;
          throwForExplicitFail(error_1, new ErrorInformation(source_1, null));
        }
      }
    }
    return new Result<Boolean>(true);
  }
}
