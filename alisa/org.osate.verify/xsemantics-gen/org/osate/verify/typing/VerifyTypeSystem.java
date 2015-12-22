package org.osate.verify.typing;

import com.google.common.base.Objects;
import com.google.inject.Provider;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import java.util.Iterator;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.NonListType;
import org.osate.aadl2.PropertyType;
import org.osate.alisa.common.common.ValDeclaration;
import org.osate.alisa.common.typing.CommonTypeSystem;
import org.osate.verify.verify.FormalParameter;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerifyPackage;

@SuppressWarnings("all")
public class VerifyTypeSystem extends CommonTypeSystem {
  public final static String VERIFICATIONACTIVITY = "org.osate.verify.typing.VerificationActivity";
  
  public final static String FORMALPARAMETER = "org.osate.verify.typing.FormalParameter";
  
  public final static String ASSIGNABLESEQUENCE = "org.osate.verify.typing.AssignableSequence";
  
  public final static String ASSIGNABLE = "org.osate.verify.typing.Assignable";
  
  private PolymorphicDispatcher<Result<PropertyType>> typeDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> assignableDispatcher;
  
  private PolymorphicDispatcher<Result<Boolean>> assignablesequenceDispatcher;
  
  public VerifyTypeSystem() {
    init();
  }
  
  @Override
  public void init() {
    super.init();
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
    assignableDispatcher = buildPolymorphicDispatcher1(
    	"assignableImpl", 5, "|-", "~>", "<-");
    assignablesequenceDispatcher = buildPolymorphicDispatcher1(
    	"assignablesequenceImpl", 5, "|-", "~>", "<<");
  }
  
  @Override
  public Result<PropertyType> type(final EObject verifyObject) {
    return type(new RuleEnvironment(), null, verifyObject);
  }
  
  @Override
  public Result<PropertyType> type(final RuleEnvironment _environment_, final EObject verifyObject) {
    return type(_environment_, null, verifyObject);
  }
  
  @Override
  public Result<PropertyType> type(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject verifyObject) {
    try {
    	return typeInternal(_environment_, _trace_, verifyObject);
    } catch (Exception _e_type) {
    	return resultForFailure(_e_type);
    }
  }
  
  public Result<Boolean> assignable(final VerificationActivity owner, final FormalParameter type, final ValDeclaration actual) {
    return assignable(new RuleEnvironment(), null, owner, type, actual);
  }
  
  public Result<Boolean> assignable(final RuleEnvironment _environment_, final VerificationActivity owner, final FormalParameter type, final ValDeclaration actual) {
    return assignable(_environment_, null, owner, type, actual);
  }
  
  public Result<Boolean> assignable(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final FormalParameter type, final ValDeclaration actual) {
    try {
    	return assignableInternal(_environment_, _trace_, owner, type, actual);
    } catch (Exception _e_assignable) {
    	return resultForFailure(_e_assignable);
    }
  }
  
  public Boolean assignableSucceeded(final VerificationActivity owner, final FormalParameter type, final ValDeclaration actual) {
    return assignableSucceeded(new RuleEnvironment(), null, owner, type, actual);
  }
  
  public Boolean assignableSucceeded(final RuleEnvironment _environment_, final VerificationActivity owner, final FormalParameter type, final ValDeclaration actual) {
    return assignableSucceeded(_environment_, null, owner, type, actual);
  }
  
  public Boolean assignableSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final FormalParameter type, final ValDeclaration actual) {
    try {
    	assignableInternal(_environment_, _trace_, owner, type, actual);
    	return true;
    } catch (Exception _e_assignable) {
    	return false;
    }
  }
  
  public Result<Boolean> assignablesequence(final VerificationActivity owner, final List<FormalParameter> formalParams, final List<ValDeclaration> actuals) {
    return assignablesequence(new RuleEnvironment(), null, owner, formalParams, actuals);
  }
  
  public Result<Boolean> assignablesequence(final RuleEnvironment _environment_, final VerificationActivity owner, final List<FormalParameter> formalParams, final List<ValDeclaration> actuals) {
    return assignablesequence(_environment_, null, owner, formalParams, actuals);
  }
  
  public Result<Boolean> assignablesequence(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> formalParams, final List<ValDeclaration> actuals) {
    try {
    	return assignablesequenceInternal(_environment_, _trace_, owner, formalParams, actuals);
    } catch (Exception _e_assignablesequence) {
    	return resultForFailure(_e_assignablesequence);
    }
  }
  
  public Boolean assignablesequenceSucceeded(final VerificationActivity owner, final List<FormalParameter> formalParams, final List<ValDeclaration> actuals) {
    return assignablesequenceSucceeded(new RuleEnvironment(), null, owner, formalParams, actuals);
  }
  
  public Boolean assignablesequenceSucceeded(final RuleEnvironment _environment_, final VerificationActivity owner, final List<FormalParameter> formalParams, final List<ValDeclaration> actuals) {
    return assignablesequenceSucceeded(_environment_, null, owner, formalParams, actuals);
  }
  
  public Boolean assignablesequenceSucceeded(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> formalParams, final List<ValDeclaration> actuals) {
    try {
    	assignablesequenceInternal(_environment_, _trace_, owner, formalParams, actuals);
    	return true;
    } catch (Exception _e_assignablesequence) {
    	return false;
    }
  }
  
  public Result<Boolean> checkActivityCalls(final VerificationActivity activity) {
    return checkActivityCalls(null, activity);
  }
  
  public Result<Boolean> checkActivityCalls(final RuleApplicationTrace _trace_, final VerificationActivity activity) {
    try {
    	return checkActivityCallsInternal(_trace_, activity);
    } catch (Exception _e_CheckActivityCalls) {
    	return resultForFailure(_e_CheckActivityCalls);
    }
  }
  
  protected Result<Boolean> checkActivityCallsInternal(final RuleApplicationTrace _trace_, final VerificationActivity activity) throws RuleFailedException {
    /* empty |- activity: var PropertyType type */
    PropertyType type = null;
    Result<PropertyType> result = typeInternal(emptyEnvironment(), _trace_, activity);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    type = (PropertyType) result.getFirst();
    
    return new Result<Boolean>(true);
  }
  
  @Override
  protected Result<PropertyType> typeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final EObject verifyObject) {
    try {
    	checkParamsNotNull(verifyObject);
    	return typeDispatcher.invoke(_environment_, _trace_, verifyObject);
    } catch (Exception _e_type) {
    	sneakyThrowRuleFailedException(_e_type);
    	return null;
    }
  }
  
  @Override
  protected void typeThrowException(final String _error, final String _issue, final Exception _ex, final EObject verifyObject, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String _stringRep = this.stringRep(verifyObject);
    String _plus = ("cannot type " + _stringRep);
    String error = _plus;
    EObject source = verifyObject;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  protected Result<Boolean> assignableInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final FormalParameter type, final ValDeclaration actual) {
    try {
    	checkParamsNotNull(owner, type, actual);
    	return assignableDispatcher.invoke(_environment_, _trace_, owner, type, actual);
    } catch (Exception _e_assignable) {
    	sneakyThrowRuleFailedException(_e_assignable);
    	return null;
    }
  }
  
  protected void assignableThrowException(final String _error, final String _issue, final Exception _ex, final VerificationActivity owner, final FormalParameter type, final ValDeclaration actual, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    throwRuleFailedException(_error, _issue, _ex, _errorInformations);
  }
  
  protected Result<Boolean> assignablesequenceInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> formalParams, final List<ValDeclaration> actuals) {
    try {
    	checkParamsNotNull(owner, formalParams, actuals);
    	return assignablesequenceDispatcher.invoke(_environment_, _trace_, owner, formalParams, actuals);
    } catch (Exception _e_assignablesequence) {
    	sneakyThrowRuleFailedException(_e_assignablesequence);
    	return null;
    }
  }
  
  protected void assignablesequenceThrowException(final String _error, final String _issue, final Exception _ex, final VerificationActivity owner, final List<FormalParameter> formalParams, final List<ValDeclaration> actuals, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String error = "invalid arguments for expected parameters";
    EObject source = owner;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VerificationActivity activity) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleVerificationActivity(G, _subtrace_, activity);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("VerificationActivity") + stringRepForEnv(G) + " |- " + stringRep(activity) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleVerificationActivity) {
    	typeThrowException(ruleName("VerificationActivity") + stringRepForEnv(G) + " |- " + stringRep(activity) + " : " + "PropertyType",
    		VERIFICATIONACTIVITY,
    		e_applyRuleVerificationActivity, activity, new ErrorInformation[] {new ErrorInformation(activity)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleVerificationActivity(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VerificationActivity activity) throws RuleFailedException {
    PropertyType type = null; // output parameter
    final VerificationMethod method = activity.getMethod();
    /* G |- activity ~> method.params << activity.parameters */
    EList<FormalParameter> _params = method.getParams();
    EList<ValDeclaration> _parameters = activity.getParameters();
    assignablesequenceInternal(G, _trace_, activity, _params, _parameters);
    return new Result<PropertyType>(type);
  }
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final FormalParameter param) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<PropertyType> _result_ = applyRuleFormalParameter(G, _subtrace_, param);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("FormalParameter") + stringRepForEnv(G) + " |- " + stringRep(param) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleFormalParameter) {
    	typeThrowException(ruleName("FormalParameter") + stringRepForEnv(G) + " |- " + stringRep(param) + " : " + "PropertyType",
    		FORMALPARAMETER,
    		e_applyRuleFormalParameter, param, new ErrorInformation[] {new ErrorInformation(param)});
    	return null;
    }
  }
  
  protected Result<PropertyType> applyRuleFormalParameter(final RuleEnvironment G, final RuleApplicationTrace _trace_, final FormalParameter param) throws RuleFailedException {
    PropertyType type = null; // output parameter
    NonListType _switchResult = null;
    String _parameterType = param.getParameterType();
    switch (_parameterType) {
      case "boolean":
        _switchResult = Aadl2Factory.eINSTANCE.createAadlBoolean();
        break;
      case "integer":
        _switchResult = Aadl2Factory.eINSTANCE.createAadlInteger();
        break;
      case "real":
        _switchResult = Aadl2Factory.eINSTANCE.createAadlReal();
        break;
      case "string":
        _switchResult = Aadl2Factory.eINSTANCE.createAadlString();
        break;
    }
    type = _switchResult;
    return new Result<PropertyType>(type);
  }
  
  protected Result<Boolean> assignablesequenceImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> formals, final List<ValDeclaration> actuals) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleAssignableSequence(G, _subtrace_, owner, formals, actuals);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("AssignableSequence") + stringRepForEnv(G) + " |- " + stringRep(owner) + " ~> " + stringRep(formals) + " << " + stringRep(actuals);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAssignableSequence) {
    	assignablesequenceThrowException(ruleName("AssignableSequence") + stringRepForEnv(G) + " |- " + stringRep(owner) + " ~> " + stringRep(formals) + " << " + stringRep(actuals),
    		ASSIGNABLESEQUENCE,
    		e_applyRuleAssignableSequence, owner, formals, actuals, new ErrorInformation[] {new ErrorInformation(owner)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleAssignableSequence(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VerificationActivity owner, final List<FormalParameter> formals, final List<ValDeclaration> actuals) throws RuleFailedException {
    /* actuals.size == formals.size or fail error "expected " + formals.size + " arguments, but got " + actuals.size source owner */
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
        /* fail error "expected " + formals.size + " arguments, but got " + actuals.size source owner */
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
    final Iterator<FormalParameter> formalsIterator = formals.iterator();
    for (final ValDeclaration actual : actuals) {
      final FormalParameter formal = formalsIterator.next();
      /* G |- owner ~> formal <- actual or fail error "bla " + previousFailure.message feature VerifyPackage.eINSTANCE.verificationActivity_Parameters source owner */
      {
        RuleFailedException previousFailure = null;
        try {
          /* G |- owner ~> formal <- actual */
          assignableInternal(G, _trace_, owner, formal, actual);
        } catch (Exception e_1) {
          previousFailure = extractRuleFailedException(e_1);
          /* fail error "bla " + previousFailure.message feature VerifyPackage.eINSTANCE.verificationActivity_Parameters source owner */
          RuleFailedException _previousFailure = previousFailure;
          String _message = _previousFailure.getMessage();
          String _plus_3 = ("bla " + _message);
          String error_1 = _plus_3;
          EObject source_1 = owner;
          EReference _verificationActivity_Parameters = VerifyPackage.eINSTANCE.getVerificationActivity_Parameters();
          EStructuralFeature feature = _verificationActivity_Parameters;
          throwForExplicitFail(error_1, new ErrorInformation(source_1, feature));
        }
      }
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<Boolean> assignableImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VerificationActivity owner, final FormalParameter formal, final ValDeclaration actual) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<Boolean> _result_ = applyRuleAssignable(G, _subtrace_, owner, formal, actual);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("Assignable") + stringRepForEnv(G) + " |- " + stringRep(owner) + " ~> " + stringRep(formal) + " <- " + stringRep(actual);
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleAssignable) {
    	assignableThrowException(ruleName("Assignable") + stringRepForEnv(G) + " |- " + stringRep(owner) + " ~> " + stringRep(formal) + " <- " + stringRep(actual),
    		ASSIGNABLE,
    		e_applyRuleAssignable, owner, formal, actual, new ErrorInformation[] {new ErrorInformation(owner), new ErrorInformation(formal), new ErrorInformation(actual)});
    	return null;
    }
  }
  
  protected Result<Boolean> applyRuleAssignable(final RuleEnvironment G, final RuleApplicationTrace _trace_, final VerificationActivity owner, final FormalParameter formal, final ValDeclaration actual) throws RuleFailedException {
    PropertyType formalType = null;
    PropertyType actualType = null;
    /* G |- formal : formalType */
    Result<PropertyType> result = typeInternal(G, _trace_, formal);
    checkAssignableTo(result.getFirst(), PropertyType.class);
    formalType = (PropertyType) result.getFirst();
    
    /* G |- actual : actualType */
    Result<PropertyType> result_1 = typeInternal(G, _trace_, actual);
    checkAssignableTo(result_1.getFirst(), PropertyType.class);
    actualType = (PropertyType) result_1.getFirst();
    
    /* formalType == actualType */
    if (!Objects.equal(formalType, actualType)) {
      sneakyThrowRuleFailedException("formalType == actualType");
    }
    return new Result<Boolean>(true);
  }
}
