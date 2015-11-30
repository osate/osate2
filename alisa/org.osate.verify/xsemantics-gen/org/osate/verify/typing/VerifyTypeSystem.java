package org.osate.verify.typing;

import com.google.inject.Provider;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.PropertyType;
import org.osate.alisa.common.typing.CommonTypeSystem;
import org.osate.verify.verify.FormalParameter;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationPlan;

@SuppressWarnings("all")
public class VerifyTypeSystem extends CommonTypeSystem {
  public final static String VERIFICATIONACTIVITY = "org.osate.verify.typing.VerificationActivity";
  
  public final static String FORMALPARAMETER = "org.osate.verify.typing.FormalParameter";
  
  private PolymorphicDispatcher<Result<PropertyType>> typeDispatcher;
  
  public VerifyTypeSystem() {
    init();
  }
  
  @Override
  public void init() {
    super.init();
    typeDispatcher = buildPolymorphicDispatcher1(
    	"typeImpl", 3, "|-", ":");
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
  
  public Result<Boolean> checkActivityCalls(final VerificationPlan plan) {
    return checkActivityCalls(null, plan);
  }
  
  public Result<Boolean> checkActivityCalls(final RuleApplicationTrace _trace_, final VerificationPlan plan) {
    try {
    	return checkActivityCallsInternal(_trace_, plan);
    } catch (Exception _e_CheckActivityCalls) {
    	return resultForFailure(_e_CheckActivityCalls);
    }
  }
  
  protected Result<Boolean> checkActivityCallsInternal(final RuleApplicationTrace _trace_, final VerificationPlan plan) throws RuleFailedException {
    final List<VerificationActivity> verificationActivities = EcoreUtil2.<VerificationActivity>getAllContentsOfType(plan, VerificationActivity.class);
    final Consumer<VerificationActivity> _function = (VerificationActivity it) -> {
      /* empty |- it : var PropertyType type */
      PropertyType type = null;
      Result<PropertyType> result = typeInternal(emptyEnvironment(), _trace_, it);
      checkAssignableTo(result.getFirst(), PropertyType.class);
      type = (PropertyType) result.getFirst();
      
    };
    verificationActivities.forEach(_function);
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
    String _parameterType = param.getParameterType();
    switch (_parameterType) {
      case "boolean":
        Aadl2Factory.eINSTANCE.createAadlBoolean();
        break;
      case "integer":
        Aadl2Factory.eINSTANCE.createAadlInteger();
        break;
      case "real":
        Aadl2Factory.eINSTANCE.createAadlReal();
        break;
      case "string":
        Aadl2Factory.eINSTANCE.createAadlString();
        break;
    }
    return new Result<PropertyType>(type);
  }
}
