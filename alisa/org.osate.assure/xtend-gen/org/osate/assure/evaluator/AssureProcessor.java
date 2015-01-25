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
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExpr;
import org.osate.assure.evaluator.IAssureProcessor;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.assure.util.IVerificationMethodDispatcher;

/**
 * performs the processing of verification activities
 * records the result propagating up the counts
 * Will process only those that are TBD
 * It assumes the counts are ok
 */
@SuppressWarnings("all")
public class AssureProcessor implements IAssureProcessor {
  @Inject
  private IVerificationMethodDispatcher dispatcher;
  
  public void doProcess(final CaseResult caseResult) {
    EList<ClaimResult> _claimResult = caseResult.getClaimResult();
    final Procedure1<ClaimResult> _function = new Procedure1<ClaimResult>() {
      public void apply(final ClaimResult claimResult) {
        AssureProcessor.this.process(claimResult);
      }
    };
    IterableExtensions.<ClaimResult>forEach(_claimResult, _function);
    EList<CaseResult> _subCaseResult = caseResult.getSubCaseResult();
    final Procedure1<CaseResult> _function_1 = new Procedure1<CaseResult>() {
      public void apply(final CaseResult subcaseResult) {
        AssureProcessor.this.process(subcaseResult);
      }
    };
    IterableExtensions.<CaseResult>forEach(_subCaseResult, _function_1);
  }
  
  public void doProcess(final ClaimResult claimResult) {
    EList<VerificationExpr> _verificationActivityResult = claimResult.getVerificationActivityResult();
    final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
      public void apply(final VerificationExpr vaResult) {
        AssureProcessor.this.process(vaResult);
      }
    };
    IterableExtensions.<VerificationExpr>forEach(_verificationActivityResult, _function);
    EList<ClaimResult> _subClaimResult = claimResult.getSubClaimResult();
    final Procedure1<ClaimResult> _function_1 = new Procedure1<ClaimResult>() {
      public void apply(final ClaimResult subclaimResult) {
        AssureProcessor.this.process(subclaimResult);
      }
    };
    IterableExtensions.<ClaimResult>forEach(_subClaimResult, _function_1);
  }
  
  public void doProcess(final VerificationActivityResult vaResult) {
    EList<AssumptionResult> _assumptionResult = vaResult.getAssumptionResult();
    final Procedure1<AssumptionResult> _function = new Procedure1<AssumptionResult>() {
      public void apply(final AssumptionResult assumptionResult) {
        AssureProcessor.this.process(assumptionResult);
      }
    };
    IterableExtensions.<AssumptionResult>forEach(_assumptionResult, _function);
    EList<PreconditionResult> _preconditionResult = vaResult.getPreconditionResult();
    final Procedure1<PreconditionResult> _function_1 = new Procedure1<PreconditionResult>() {
      public void apply(final PreconditionResult preconditionResult) {
        AssureProcessor.this.process(preconditionResult);
      }
    };
    IterableExtensions.<PreconditionResult>forEach(_preconditionResult, _function_1);
    this.dispatcher.runVerificationMethod(vaResult);
  }
  
  public void doProcess(final FailThenResult vaResult) {
    EList<VerificationExpr> _first = vaResult.getFirst();
    final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
      public void apply(final VerificationExpr expr) {
        AssureProcessor.this.process(expr);
      }
    };
    IterableExtensions.<VerificationExpr>forEach(_first, _function);
    EList<VerificationExpr> _first_1 = vaResult.getFirst();
    boolean _hasFailedOrError = AssureUtilExtension.hasFailedOrError(_first_1);
    if (_hasFailedOrError) {
      boolean _recordFailThen = AssureUtilExtension.recordFailThen(vaResult);
      if (_recordFailThen) {
        AssureUtilExtension.propagateCountChangeUp(vaResult);
      }
      EList<VerificationExpr> _second = vaResult.getSecond();
      final Procedure1<VerificationExpr> _function_1 = new Procedure1<VerificationExpr>() {
        public void apply(final VerificationExpr expr) {
          AssureProcessor.this.process(expr);
        }
      };
      IterableExtensions.<VerificationExpr>forEach(_second, _function_1);
    } else {
      boolean _recordNoFailThen = AssureUtilExtension.recordNoFailThen(vaResult);
      if (_recordNoFailThen) {
        AssureUtilExtension.propagateCountChangeUp(vaResult);
      }
    }
  }
  
  public void doProcess(final AndThenResult vaResult) {
    EList<VerificationExpr> _first = vaResult.getFirst();
    final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
      public void apply(final VerificationExpr expr) {
        AssureProcessor.this.process(expr);
      }
    };
    IterableExtensions.<VerificationExpr>forEach(_first, _function);
    EList<VerificationExpr> _first_1 = vaResult.getFirst();
    boolean _isSuccessFul = AssureUtilExtension.isSuccessFul(_first_1);
    if (_isSuccessFul) {
      EList<VerificationExpr> _second = vaResult.getSecond();
      final Procedure1<VerificationExpr> _function_1 = new Procedure1<VerificationExpr>() {
        public void apply(final VerificationExpr expr) {
          AssureProcessor.this.process(expr);
        }
      };
      IterableExtensions.<VerificationExpr>forEach(_second, _function_1);
      boolean _recordNoSkip = AssureUtilExtension.recordNoSkip(vaResult);
      if (_recordNoSkip) {
        AssureUtilExtension.propagateCountChangeUp(vaResult);
      }
    } else {
      boolean _recordSkip = AssureUtilExtension.recordSkip(vaResult);
      if (_recordSkip) {
        AssureUtilExtension.propagateCountChangeUp(vaResult);
      }
    }
  }
  
  public void doProcess(final AssumptionResult assumptionResult) {
    EList<VerificationExpr> _verificationActivityResult = assumptionResult.getVerificationActivityResult();
    final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
      public void apply(final VerificationExpr vaResult) {
        AssureProcessor.this.process(vaResult);
      }
    };
    IterableExtensions.<VerificationExpr>forEach(_verificationActivityResult, _function);
  }
  
  public void doProcess(final PreconditionResult preconditionResult) {
    EList<VerificationExpr> _verificationActivityResult = preconditionResult.getVerificationActivityResult();
    final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
      public void apply(final VerificationExpr vaResult) {
        AssureProcessor.this.process(vaResult);
      }
    };
    IterableExtensions.<VerificationExpr>forEach(_verificationActivityResult, _function);
  }
  
  public void process(final AssureResult assureResult) {
    boolean _matched = false;
    if (!_matched) {
      if (assureResult instanceof CaseResult) {
        _matched=true;
        this.doProcess(((CaseResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof ClaimResult) {
        _matched=true;
        this.doProcess(((ClaimResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof VerificationActivityResult) {
        _matched=true;
        this.doProcess(((VerificationActivityResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof FailThenResult) {
        _matched=true;
        this.doProcess(((FailThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AndThenResult) {
        _matched=true;
        this.doProcess(((AndThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AssumptionResult) {
        _matched=true;
        this.doProcess(((AssumptionResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof PreconditionResult) {
        _matched=true;
        this.doProcess(((PreconditionResult)assureResult));
      }
    }
  }
}
