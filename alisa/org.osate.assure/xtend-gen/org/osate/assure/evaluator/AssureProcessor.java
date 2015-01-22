package org.osate.assure.evaluator;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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

/**
 * performs the processing of verification activities
 * records the result accordingly
 */
@SuppressWarnings("all")
public class AssureProcessor implements IAssureProcessor {
  @Inject
  private IVerificationMethodDispatcher dispatcher;
  
  public AssureResult doProcess(final CaseResult caseResult) {
    CaseResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(caseResult);
      EList<ClaimResult> _claimResult = caseResult.getClaimResult();
      final Procedure1<ClaimResult> _function = new Procedure1<ClaimResult>() {
        public void apply(final ClaimResult claimResult) {
          AssureResult _process = AssureProcessor.this.process(claimResult);
          AssureUtilExtension.addTo(_process, caseResult);
        }
      };
      IterableExtensions.<ClaimResult>forEach(_claimResult, _function);
      EList<HazardResult> _hazardResult = caseResult.getHazardResult();
      final Procedure1<HazardResult> _function_1 = new Procedure1<HazardResult>() {
        public void apply(final HazardResult hazardResult) {
          AssureResult _process = AssureProcessor.this.process(hazardResult);
          AssureUtilExtension.addTo(_process, caseResult);
        }
      };
      IterableExtensions.<HazardResult>forEach(_hazardResult, _function_1);
      EList<CaseResult> _subCaseResult = caseResult.getSubCaseResult();
      final Procedure1<CaseResult> _function_2 = new Procedure1<CaseResult>() {
        public void apply(final CaseResult subcaseResult) {
          AssureResult _process = AssureProcessor.this.process(subcaseResult);
          AssureUtilExtension.addTo(_process, caseResult);
        }
      };
      IterableExtensions.<CaseResult>forEach(_subCaseResult, _function_2);
      _xblockexpression = caseResult;
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final ClaimResult claimResult) {
    ClaimResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(claimResult);
      EList<VerificationExpr> _verificationActivityResult = claimResult.getVerificationActivityResult();
      final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
        public void apply(final VerificationExpr vaResult) {
          AssureResult _process = AssureProcessor.this.process(vaResult);
          AssureUtilExtension.addTo(_process, claimResult);
        }
      };
      IterableExtensions.<VerificationExpr>forEach(_verificationActivityResult, _function);
      EList<ClaimResult> _subClaimResult = claimResult.getSubClaimResult();
      final Procedure1<ClaimResult> _function_1 = new Procedure1<ClaimResult>() {
        public void apply(final ClaimResult subclaimResult) {
          AssureResult _process = AssureProcessor.this.process(subclaimResult);
          AssureUtilExtension.addTo(_process, claimResult);
        }
      };
      IterableExtensions.<ClaimResult>forEach(_subClaimResult, _function_1);
      _xblockexpression = claimResult;
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final VerificationActivityResult vaResult) {
    VerificationActivityResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<AssumptionResult> _assumptionResult = vaResult.getAssumptionResult();
      final Procedure1<AssumptionResult> _function = new Procedure1<AssumptionResult>() {
        public void apply(final AssumptionResult assumptionResult) {
          AssureResult _process = AssureProcessor.this.process(assumptionResult);
          AssureUtilExtension.addTo(_process, vaResult);
        }
      };
      IterableExtensions.<AssumptionResult>forEach(_assumptionResult, _function);
      EList<PreconditionResult> _preconditionResult = vaResult.getPreconditionResult();
      final Procedure1<PreconditionResult> _function_1 = new Procedure1<PreconditionResult>() {
        public void apply(final PreconditionResult preconditionResult) {
          AssureResult _process = AssureProcessor.this.process(preconditionResult);
          AssureUtilExtension.addTo(_process, vaResult);
        }
      };
      IterableExtensions.<PreconditionResult>forEach(_preconditionResult, _function_1);
      this.dispatcher.runVerificationMethod(vaResult);
      AssureUtilExtension.addOwnResult(vaResult);
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final FailThenResult vaResult) {
    FailThenResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
        public void apply(final VerificationExpr expr) {
          AssureResult _process = AssureProcessor.this.process(expr);
          AssureUtilExtension.addTo(_process, vaResult);
        }
      };
      IterableExtensions.<VerificationExpr>forEach(_first, _function);
      boolean _hasFailedOrError = AssureUtilExtension.hasFailedOrError(vaResult);
      if (_hasFailedOrError) {
        AssureUtilExtension.resetCounts(vaResult);
        AssureUtilExtension.recordFailThen(vaResult);
        EList<VerificationExpr> _second = vaResult.getSecond();
        final Procedure1<VerificationExpr> _function_1 = new Procedure1<VerificationExpr>() {
          public void apply(final VerificationExpr expr) {
            AssureResult _process = AssureProcessor.this.process(expr);
            AssureUtilExtension.addTo(_process, vaResult);
          }
        };
        IterableExtensions.<VerificationExpr>forEach(_second, _function_1);
      }
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final AndThenResult vaResult) {
    AndThenResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
        public void apply(final VerificationExpr expr) {
          AssureResult _process = AssureProcessor.this.process(expr);
          AssureUtilExtension.addTo(_process, vaResult);
        }
      };
      IterableExtensions.<VerificationExpr>forEach(_first, _function);
      boolean _isSuccessFul = AssureUtilExtension.isSuccessFul(vaResult);
      if (_isSuccessFul) {
        EList<VerificationExpr> _second = vaResult.getSecond();
        final Procedure1<VerificationExpr> _function_1 = new Procedure1<VerificationExpr>() {
          public void apply(final VerificationExpr expr) {
            AssureResult _process = AssureProcessor.this.process(expr);
            AssureUtilExtension.addTo(_process, vaResult);
          }
        };
        IterableExtensions.<VerificationExpr>forEach(_second, _function_1);
      } else {
        AssureUtilExtension.recordSkip(vaResult);
      }
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final HazardResult hazardResult) {
    HazardResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(hazardResult);
      EList<ClaimResult> _claimResult = hazardResult.getClaimResult();
      final Procedure1<ClaimResult> _function = new Procedure1<ClaimResult>() {
        public void apply(final ClaimResult subclaimResult) {
          AssureResult _process = AssureProcessor.this.process(subclaimResult);
          AssureUtilExtension.addTo(_process, hazardResult);
        }
      };
      IterableExtensions.<ClaimResult>forEach(_claimResult, _function);
      _xblockexpression = hazardResult;
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final AssumptionResult assumptionResult) {
    AssumptionResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(assumptionResult);
      EList<VerificationExpr> _verificationActivityResult = assumptionResult.getVerificationActivityResult();
      final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
        public void apply(final VerificationExpr vaResult) {
          AssureResult _process = AssureProcessor.this.process(vaResult);
          AssureUtilExtension.addTo(_process, assumptionResult);
        }
      };
      IterableExtensions.<VerificationExpr>forEach(_verificationActivityResult, _function);
      _xblockexpression = assumptionResult;
    }
    return _xblockexpression;
  }
  
  public AssureResult doProcess(final PreconditionResult preconditionResult) {
    PreconditionResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(preconditionResult);
      EList<VerificationExpr> _verificationActivityResult = preconditionResult.getVerificationActivityResult();
      final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
        public void apply(final VerificationExpr vaResult) {
          AssureResult _process = AssureProcessor.this.process(vaResult);
          AssureUtilExtension.addTo(_process, preconditionResult);
        }
      };
      IterableExtensions.<VerificationExpr>forEach(_verificationActivityResult, _function);
      _xblockexpression = preconditionResult;
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
