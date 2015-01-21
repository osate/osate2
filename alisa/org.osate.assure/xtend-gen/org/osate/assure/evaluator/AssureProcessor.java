package org.osate.assure.evaluator;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.assure.assure.AndThenResult;
import org.osate.assure.assure.AssumptionResult;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.CaseResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.FailThenResult;
import org.osate.assure.assure.HazardResult;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExpr;
import org.osate.assure.evaluator.IAssureProcessor;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.assure.util.IVerificationMethodDispatcher;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;

/**
 * performs the processing of verification activities
 * records the result accordingly
 */
@SuppressWarnings("all")
public class AssureProcessor implements IAssureProcessor {
  @Inject
  private IVerificationMethodDispatcher dispatcher;
  
  @Extension
  private AssureUtilExtension aue = new AssureUtilExtension();
  
  public AssureResult doProcess(final CaseResult caseResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(caseResult);
      EList<ClaimResult> _claimResult = caseResult.getClaimResult();
      final Function1<ClaimResult, AssureResult> _function = new Function1<ClaimResult, AssureResult>() {
        public AssureResult apply(final ClaimResult claimResult) {
          return AssureProcessor.this.process(claimResult);
        }
      };
      final List<AssureResult> x = ListExtensions.<ClaimResult, AssureResult>map(_claimResult, _function);
      final AssureResult y = this.aue.addAllTo(x, caseResult);
      EList<HazardResult> _hazardResult = caseResult.getHazardResult();
      final Function1<HazardResult, AssureResult> _function_1 = new Function1<HazardResult, AssureResult>() {
        public AssureResult apply(final HazardResult hazardResult) {
          return AssureProcessor.this.process(hazardResult);
        }
      };
      List<AssureResult> _map = ListExtensions.<HazardResult, AssureResult>map(_hazardResult, _function_1);
      this.aue.addAllTo(_map, caseResult);
      EList<CaseResult> _subCaseResult = caseResult.getSubCaseResult();
      final Function1<CaseResult, AssureResult> _function_2 = new Function1<CaseResult, AssureResult>() {
        public AssureResult apply(final CaseResult subcaseResult) {
          return AssureProcessor.this.process(subcaseResult);
        }
      };
      List<AssureResult> _map_1 = ListExtensions.<CaseResult, AssureResult>map(_subCaseResult, _function_2);
      _xblockexpression = this.aue.addAllTo(_map_1, caseResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final ClaimResult claimResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(claimResult);
      EList<VerificationExpr> _verificationActivityResult = claimResult.getVerificationActivityResult();
      final Function1<VerificationExpr, AssureResult> _function = new Function1<VerificationExpr, AssureResult>() {
        public AssureResult apply(final VerificationExpr vaResult) {
          return AssureProcessor.this.process(vaResult);
        }
      };
      List<AssureResult> _map = ListExtensions.<VerificationExpr, AssureResult>map(_verificationActivityResult, _function);
      this.aue.addAllTo(_map, claimResult);
      EList<ClaimResult> _subClaimResult = claimResult.getSubClaimResult();
      final Function1<ClaimResult, AssureResult> _function_1 = new Function1<ClaimResult, AssureResult>() {
        public AssureResult apply(final ClaimResult subclaimResult) {
          return AssureProcessor.this.process(subclaimResult);
        }
      };
      List<AssureResult> _map_1 = ListExtensions.<ClaimResult, AssureResult>map(_subClaimResult, _function_1);
      _xblockexpression = this.aue.addAllTo(_map_1, claimResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final VerificationActivityResult vaResult) {
    VerificationActivityResult _xblockexpression = null;
    {
      this.aue.initialize(vaResult);
      EList<AssumptionResult> _assumptionResult = vaResult.getAssumptionResult();
      final Function1<AssumptionResult, AssureResult> _function = new Function1<AssumptionResult, AssureResult>() {
        public AssureResult apply(final AssumptionResult assumptionResult) {
          return AssureProcessor.this.process(assumptionResult);
        }
      };
      final List<AssureResult> xx = ListExtensions.<AssumptionResult, AssureResult>map(_assumptionResult, _function);
      this.aue.addAllTo(xx, vaResult);
      EList<PreconditionResult> _preconditionResult = vaResult.getPreconditionResult();
      final Function1<PreconditionResult, AssureResult> _function_1 = new Function1<PreconditionResult, AssureResult>() {
        public AssureResult apply(final PreconditionResult preconditionResult) {
          return AssureProcessor.this.process(preconditionResult);
        }
      };
      List<AssureResult> _map = ListExtensions.<PreconditionResult, AssureResult>map(_preconditionResult, _function_1);
      this.aue.addAllTo(_map, vaResult);
      VerificationActivity _target = vaResult.getTarget();
      VerificationMethod _method = null;
      if (_target!=null) {
        _method=_target.getMethod();
      }
      String _methodPath = null;
      if (_method!=null) {
        _methodPath=_method.getMethodPath();
      }
      final String path = _methodPath;
      InstanceObject _caseSubject = this.aue.getCaseSubject(vaResult);
      this.dispatcher.dispatchVerificationMethod(path, _caseSubject);
      _xblockexpression = this.aue.addOwnResult(vaResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final FailThenResult vaResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      final Function1<VerificationExpr, AssureResult> _function = new Function1<VerificationExpr, AssureResult>() {
        public AssureResult apply(final VerificationExpr expr) {
          return AssureProcessor.this.process(expr);
        }
      };
      List<AssureResult> _map = ListExtensions.<VerificationExpr, AssureResult>map(_first, _function);
      this.aue.addAllTo(_map, vaResult);
      AssureResult _xifexpression = null;
      boolean _hasFailedOrError = this.aue.hasFailedOrError(vaResult);
      if (_hasFailedOrError) {
        AssureResult _xblockexpression_1 = null;
        {
          this.aue.initialize(vaResult);
          this.aue.recordFailThen(vaResult);
          EList<VerificationExpr> _second = vaResult.getSecond();
          final Function1<VerificationExpr, AssureResult> _function_1 = new Function1<VerificationExpr, AssureResult>() {
            public AssureResult apply(final VerificationExpr expr) {
              return AssureProcessor.this.process(expr);
            }
          };
          List<AssureResult> _map_1 = ListExtensions.<VerificationExpr, AssureResult>map(_second, _function_1);
          _xblockexpression_1 = this.aue.addAllTo(_map_1, vaResult);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final AndThenResult vaResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      final Function1<VerificationExpr, AssureResult> _function = new Function1<VerificationExpr, AssureResult>() {
        public AssureResult apply(final VerificationExpr expr) {
          return AssureProcessor.this.process(expr);
        }
      };
      List<AssureResult> _map = ListExtensions.<VerificationExpr, AssureResult>map(_first, _function);
      this.aue.addAllTo(_map, vaResult);
      AssureResult _xifexpression = null;
      boolean _isSuccessFul = this.aue.isSuccessFul(vaResult);
      if (_isSuccessFul) {
        EList<VerificationExpr> _second = vaResult.getSecond();
        final Function1<VerificationExpr, AssureResult> _function_1 = new Function1<VerificationExpr, AssureResult>() {
          public AssureResult apply(final VerificationExpr expr) {
            return AssureProcessor.this.process(expr);
          }
        };
        List<AssureResult> _map_1 = ListExtensions.<VerificationExpr, AssureResult>map(_second, _function_1);
        _xifexpression = this.aue.addAllTo(_map_1, vaResult);
      } else {
        _xifexpression = this.aue.recordSkip(vaResult);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final HazardResult hazardResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(hazardResult);
      EList<ClaimResult> _claimResult = hazardResult.getClaimResult();
      final Function1<ClaimResult, AssureResult> _function = new Function1<ClaimResult, AssureResult>() {
        public AssureResult apply(final ClaimResult subclaimResult) {
          return AssureProcessor.this.process(subclaimResult);
        }
      };
      List<AssureResult> _map = ListExtensions.<ClaimResult, AssureResult>map(_claimResult, _function);
      _xblockexpression = this.aue.addAllTo(_map, hazardResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final AssumptionResult assumptionResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(assumptionResult);
      EList<VerificationExpr> _verificationActivityResult = assumptionResult.getVerificationActivityResult();
      final Function1<VerificationExpr, AssureResult> _function = new Function1<VerificationExpr, AssureResult>() {
        public AssureResult apply(final VerificationExpr vaResult) {
          return AssureProcessor.this.process(vaResult);
        }
      };
      List<AssureResult> _map = ListExtensions.<VerificationExpr, AssureResult>map(_verificationActivityResult, _function);
      _xblockexpression = this.aue.addAllTo(_map, assumptionResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final PreconditionResult preconditionResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(preconditionResult);
      EList<VerificationExpr> _verificationActivityResult = preconditionResult.getVerificationActivityResult();
      final Function1<VerificationExpr, AssureResult> _function = new Function1<VerificationExpr, AssureResult>() {
        public AssureResult apply(final VerificationExpr vaResult) {
          return AssureProcessor.this.process(vaResult);
        }
      };
      List<AssureResult> _map = ListExtensions.<VerificationExpr, AssureResult>map(_verificationActivityResult, _function);
      _xblockexpression = this.aue.addAllTo(_map, preconditionResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult process(final AssureResult assureResult) {
    AssureResult _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (assureResult instanceof CaseResult) {
        _matched=true;
        _switchResult = this.doProcess(((CaseResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof ClaimResult) {
        _matched=true;
        _switchResult = this.doProcess(((ClaimResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof VerificationActivityResult) {
        _matched=true;
        _switchResult = this.doProcess(((VerificationActivityResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof FailThenResult) {
        _matched=true;
        _switchResult = this.doProcess(((FailThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AndThenResult) {
        _matched=true;
        _switchResult = this.doProcess(((AndThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof HazardResult) {
        _matched=true;
        _switchResult = this.doProcess(((HazardResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AssumptionResult) {
        _matched=true;
        _switchResult = this.doProcess(((AssumptionResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof PreconditionResult) {
        _matched=true;
        _switchResult = this.doProcess(((PreconditionResult)assureResult));
      }
    }
    return _switchResult;
  }
}
