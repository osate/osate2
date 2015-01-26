package org.osate.assure.util;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.FeatureToConnectionsMap;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter;
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
import com.rockwellcollins.atc.resolute.analysis.results.FailResult;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.resolute.Expr;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.ProveStatement;
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory;
import com.rockwellcollins.atc.resolute.resolute.ThisExpr;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.linking.AssureLinkingService;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.assure.util.IVerificationMethodDispatcher;
import org.osate.verify.verify.SupportedTypes;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;

@SuppressWarnings("all")
public class DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher {
  public Object dispatchVerificationMethod(final String methodPath, final VerificationActivityResult vr) {
    InstanceObject _claimSubject = AssureUtilExtension.getClaimSubject(vr);
    String _qualifiedName = _claimSubject.getQualifiedName();
    String _plus = ((("Dispatching " + methodPath) + " on ") + _qualifiedName);
    InputOutput.<String>println(_plus);
    return null;
  }
  
  public void runVerificationMethod(final VerificationActivityResult verificationActivityResult) {
    try {
      VerificationActivity _target = verificationActivityResult.getTarget();
      final VerificationMethod method = _target.getMethod();
      final String methodpath = method.getMethodPath();
      SupportedTypes _methodType = method.getMethodType();
      if (_methodType != null) {
        switch (_methodType) {
          case SINGLEPREDICATE:
            try {
              final Object res = this.dispatchVerificationMethod(methodpath, verificationActivityResult);
              boolean _and = false;
              boolean _and_1 = false;
              boolean _notEquals = (!Objects.equal(res, null));
              if (!_notEquals) {
                _and_1 = false;
              } else {
                _and_1 = (res instanceof Boolean);
              }
              if (!_and_1) {
                _and = false;
              } else {
                boolean _notEquals_1 = (!Objects.equal(res, Boolean.valueOf(true)));
                _and = _notEquals_1;
              }
              if (_and) {
                AssureUtilExtension.setToFail(verificationActivityResult, "");
              } else {
                AssureUtilExtension.setToSuccess(verificationActivityResult);
              }
            } catch (final Throwable _t) {
              if (_t instanceof AssertionError) {
                final AssertionError e = (AssertionError)_t;
                AssureUtilExtension.setToFail(verificationActivityResult, e);
              } else if (_t instanceof ThreadDeath) {
                final ThreadDeath e_1 = (ThreadDeath)_t;
                throw e_1;
              } else if (_t instanceof Throwable) {
                final Throwable e_2 = (Throwable)_t;
                AssureUtilExtension.setToError(verificationActivityResult, e_2);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            break;
          case MULTIMARKER:
            try {
              final Object res_1 = this.dispatchVerificationMethod(methodpath, verificationActivityResult);
              boolean _and_2 = false;
              boolean _and_3 = false;
              boolean _notEquals_2 = (!Objects.equal(res_1, null));
              if (!_notEquals_2) {
                _and_3 = false;
              } else {
                _and_3 = (res_1 instanceof Boolean);
              }
              if (!_and_3) {
                _and_2 = false;
              } else {
                boolean _notEquals_3 = (!Objects.equal(res_1, Boolean.valueOf(true)));
                _and_2 = _notEquals_3;
              }
              if (_and_2) {
                AssureUtilExtension.setToFail(verificationActivityResult, "");
              } else {
                AssureUtilExtension.setToSuccess(verificationActivityResult);
              }
            } catch (final Throwable _t_1) {
              if (_t_1 instanceof ThreadDeath) {
                final ThreadDeath e_3 = (ThreadDeath)_t_1;
                throw e_3;
              } else if (_t_1 instanceof Throwable) {
                final Throwable e_4 = (Throwable)_t_1;
                AssureUtilExtension.setToError(verificationActivityResult, e_4);
              } else {
                throw Exceptions.sneakyThrow(_t_1);
              }
            }
            break;
          case RESOLUTEPROVE:
            InstanceObject _caseSubject = AssureUtilExtension.getCaseSubject(verificationActivityResult);
            final SystemInstance si = _caseSubject.getSystemInstance();
            Map<String, SortedSet<NamedElement>> _sets = AssureUtilExtension.getSets();
            FeatureToConnectionsMap _featToConnsMap = AssureUtilExtension.getFeatToConnsMap();
            final EvaluationContext context = new EvaluationContext(si, _sets, _featToConnsMap);
            final ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
            String _methodName = AssureUtilExtension.getMethodName(verificationActivityResult);
            ProveStatement _createWrapperProveCall = DefaultVerificationMethodDispatcher.createWrapperProveCall(_methodName);
            ResoluteResult _evaluateProveStatement = interpreter.evaluateProveStatement(_createWrapperProveCall);
            final ClaimResult proof = ((ClaimResult) _evaluateProveStatement);
            boolean _isValid = proof.isValid();
            if (_isValid) {
              AssureUtilExtension.setToSuccess(verificationActivityResult);
            } else {
              List<ResoluteResult> _children = proof.getChildren();
              final Function1<ResoluteResult, Boolean> _function = new Function1<ResoluteResult, Boolean>() {
                public Boolean apply(final ResoluteResult r) {
                  return Boolean.valueOf((r instanceof FailResult));
                }
              };
              final Iterable<ResoluteResult> fails = IterableExtensions.<ResoluteResult>filter(_children, _function);
              ResoluteResult _head = IterableExtensions.<ResoluteResult>head(fails);
              final FailResult fail = ((FailResult) _head);
              final String failmsg = fail.getText();
              EObject _location = proof.getLocation();
              String _text = proof.getText();
              AssureUtilExtension.setToFail(verificationActivityResult, _location, _text);
            }
            break;
          default:
            break;
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Inject
  private static AssureLinkingService assureLinking;
  
  public static ProveStatement createWrapperProveCall(final String resoluteFunction) {
    ProveStatement _xblockexpression = null;
    {
      final ResoluteFactory factory = ResoluteFactory.eINSTANCE;
      final FnCallExpr call = factory.createFnCallExpr();
      final FunctionDefinition found = DefaultVerificationMethodDispatcher.assureLinking.resolveResoluteFunction(call, resoluteFunction);
      final FunctionDefinition found1 = DefaultVerificationMethodDispatcher.assureLinking.findResoluteFunction(call, resoluteFunction);
      call.setFn(found);
      EList<Expr> _args = call.getArgs();
      ThisExpr _createThisExpr = factory.createThisExpr();
      _args.add(_createThisExpr);
      final ProveStatement prove = factory.createProveStatement();
      prove.setExpr(call);
      _xblockexpression = prove;
    }
    return _xblockexpression;
  }
}
