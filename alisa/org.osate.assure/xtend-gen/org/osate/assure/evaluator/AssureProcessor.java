package org.osate.assure.evaluator;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osate.assure.assure.AndThenResult;
import org.osate.assure.assure.AssuranceEvidence;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.FailThenResult;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.ValidationResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExpr;
import org.osate.assure.assure.VerificationResult;
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
  
  public void doProcess(final AssuranceEvidence caseResult) {
    EList<ClaimResult> _claimResult = caseResult.getClaimResult();
    final Procedure1<ClaimResult> _function = new Procedure1<ClaimResult>() {
      public void apply(final ClaimResult claimResult) {
        AssureProcessor.this.process(claimResult);
      }
    };
    IterableExtensions.<ClaimResult>forEach(_claimResult, _function);
    EList<AssuranceEvidence> _subAssuranceEvidence = caseResult.getSubAssuranceEvidence();
    final Procedure1<AssuranceEvidence> _function_1 = new Procedure1<AssuranceEvidence>() {
      public void apply(final AssuranceEvidence subcaseResult) {
        AssureProcessor.this.process(subcaseResult);
      }
    };
    IterableExtensions.<AssuranceEvidence>forEach(_subAssuranceEvidence, _function_1);
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
    EList<VerificationResult> _validationResult = vaResult.getValidationResult();
    final Procedure1<VerificationResult> _function = new Procedure1<VerificationResult>() {
      public void apply(final VerificationResult assumptionResult) {
        AssureProcessor.this.process(assumptionResult);
      }
    };
    IterableExtensions.<VerificationResult>forEach(_validationResult, _function);
    EList<VerificationResult> _preconditionResult = vaResult.getPreconditionResult();
    final Procedure1<VerificationResult> _function_1 = new Procedure1<VerificationResult>() {
      public void apply(final VerificationResult preconditionResult) {
        AssureProcessor.this.process(preconditionResult);
      }
    };
    IterableExtensions.<VerificationResult>forEach(_preconditionResult, _function_1);
    EList<VerificationResult> _preconditionResult_1 = vaResult.getPreconditionResult();
    boolean _success = AssureUtilExtension.success(_preconditionResult_1);
    if (_success) {
      this.dispatcher.runVerificationMethod(vaResult);
    }
  }
  
  public void doProcess(final FailThenResult vaResult) {
    EList<VerificationExpr> _first = vaResult.getFirst();
    final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
      public void apply(final VerificationExpr expr) {
        AssureProcessor.this.process(expr);
      }
    };
    IterableExtensions.<VerificationExpr>forEach(_first, _function);
    boolean _and = false;
    boolean _isUnknownThen = vaResult.isUnknownThen();
    if (!_isUnknownThen) {
      _and = false;
    } else {
      EList<VerificationExpr> _first_1 = vaResult.getFirst();
      boolean _hasError = AssureUtilExtension.hasError(_first_1);
      _and = _hasError;
    }
    if (_and) {
      AssureUtilExtension.recordFailThen(vaResult);
      EList<VerificationExpr> _second = vaResult.getSecond();
      final Procedure1<VerificationExpr> _function_1 = new Procedure1<VerificationExpr>() {
        public void apply(final VerificationExpr expr) {
          AssureProcessor.this.process(expr);
        }
      };
      IterableExtensions.<VerificationExpr>forEach(_second, _function_1);
    } else {
      boolean _and_1 = false;
      boolean _isFailThen = vaResult.isFailThen();
      if (!_isFailThen) {
        _and_1 = false;
      } else {
        EList<VerificationExpr> _first_2 = vaResult.getFirst();
        boolean _hasFailed = AssureUtilExtension.hasFailed(_first_2);
        _and_1 = _hasFailed;
      }
      if (_and_1) {
        AssureUtilExtension.recordFailThen(vaResult);
        EList<VerificationExpr> _second_1 = vaResult.getSecond();
        final Procedure1<VerificationExpr> _function_2 = new Procedure1<VerificationExpr>() {
          public void apply(final VerificationExpr expr) {
            AssureProcessor.this.process(expr);
          }
        };
        IterableExtensions.<VerificationExpr>forEach(_second_1, _function_2);
      } else {
        EList<VerificationExpr> _first_3 = vaResult.getFirst();
        boolean _hasFailedOrError = AssureUtilExtension.hasFailedOrError(_first_3);
        if (_hasFailedOrError) {
          AssureUtilExtension.recordFailThen(vaResult);
          EList<VerificationExpr> _second_2 = vaResult.getSecond();
          final Procedure1<VerificationExpr> _function_3 = new Procedure1<VerificationExpr>() {
            public void apply(final VerificationExpr expr) {
              AssureProcessor.this.process(expr);
            }
          };
          IterableExtensions.<VerificationExpr>forEach(_second_2, _function_3);
        } else {
          AssureUtilExtension.recordNoFailThen(vaResult);
        }
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
      AssureUtilExtension.recordNoSkip(vaResult);
    } else {
      AssureUtilExtension.recordSkip(vaResult);
    }
  }
  
  public void doProcess(final ValidationResult assumptionResult) {
    this.dispatcher.runVerificationMethod(assumptionResult);
  }
  
  public void doProcess(final PreconditionResult preconditionResult) {
    this.dispatcher.runVerificationMethod(preconditionResult);
  }
  
  public void process(final AssureResult assureResult) {
    boolean _matched = false;
    if (!_matched) {
      if (assureResult instanceof AssuranceEvidence) {
        _matched=true;
        this.doProcess(((AssuranceEvidence)assureResult));
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
      if (assureResult instanceof ValidationResult) {
        _matched=true;
        this.doProcess(((ValidationResult)assureResult));
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
