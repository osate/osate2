package org.osate.alisa.common.typing;

import com.google.inject.Provider;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyType;
import org.osate.alisa.common.common.AExpression;
import org.osate.alisa.common.common.ValDeclaration;

@SuppressWarnings("all")
public class CommonTypeSystem extends XsemanticsRuntimeSystem {
  public final static String VALDECLARATION = "org.osate.alisa.common.typing.ValDeclaration";
  
  public final static String AEXPRESSION = "org.osate.alisa.common.typing.AExpression";
  
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
  
  protected Result<PropertyType> typeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AExpression param) throws RuleFailedException {
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
  
  protected Result<PropertyType> applyRuleAExpression(final RuleEnvironment G, final RuleApplicationTrace _trace_, final AExpression param) throws RuleFailedException {
    PropertyType type = null; // output parameter
    Aadl2Factory.eINSTANCE.createAadlInteger();
    return new Result<PropertyType>(type);
  }
}
