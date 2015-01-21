package org.osate.assure.evaluator;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
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
import org.osate.assure.util.AssureUtilExtension;

@SuppressWarnings("all")
public class AssureEvaluator {
  @Extension
  private AssureUtilExtension aue = new AssureUtilExtension();
  
  public AssureResult evaluate(final CaseResult caseResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(caseResult);
      EList<ClaimResult> _claimResult = caseResult.getClaimResult();
      this.addAllEvaluate(caseResult, _claimResult);
      EList<HazardResult> _hazardResult = caseResult.getHazardResult();
      this.addAllEvaluate(caseResult, _hazardResult);
      EList<CaseResult> _subCaseResult = caseResult.getSubCaseResult();
      _xblockexpression = this.addAllEvaluate(caseResult, _subCaseResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult evaluate(final ClaimResult claimResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(claimResult);
      EList<VerificationExpr> _verificationActivityResult = claimResult.getVerificationActivityResult();
      this.addAllEvaluate(claimResult, _verificationActivityResult);
      EList<ClaimResult> _subClaimResult = claimResult.getSubClaimResult();
      _xblockexpression = this.addAllEvaluate(claimResult, _subClaimResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult evaluate(final VerificationActivityResult vaResult) {
    VerificationActivityResult _xblockexpression = null;
    {
      this.aue.initialize(vaResult);
      EList<AssumptionResult> _assumptionResult = vaResult.getAssumptionResult();
      this.addAllEvaluate(vaResult, _assumptionResult);
      EList<PreconditionResult> _preconditionResult = vaResult.getPreconditionResult();
      this.addAllEvaluate(vaResult, _preconditionResult);
      this.aue.addOwnResult(vaResult);
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  public AssureResult evaluate(final FailThenResult vaResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      this.addAllEvaluate(vaResult, _first);
      AssureResult _xifexpression = null;
      boolean _hasFailedOrError = this.aue.hasFailedOrError(vaResult);
      if (_hasFailedOrError) {
        AssureResult _xblockexpression_1 = null;
        {
          this.aue.initialize(vaResult);
          EList<VerificationExpr> _second = vaResult.getSecond();
          _xblockexpression_1 = this.addAllEvaluate(vaResult, _second);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public AssureResult evaluate(final AndThenResult vaResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      this.addAllEvaluate(vaResult, _first);
      EList<VerificationExpr> _second = vaResult.getSecond();
      _xblockexpression = this.addAllEvaluate(vaResult, _second);
    }
    return _xblockexpression;
  }
  
  public AssureResult evaluate(final HazardResult hazardResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(hazardResult);
      EList<ClaimResult> _claimResult = hazardResult.getClaimResult();
      _xblockexpression = this.addAllEvaluate(hazardResult, _claimResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult evaluate(final AssumptionResult assumptionResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(assumptionResult);
      EList<VerificationExpr> _verificationActivityResult = assumptionResult.getVerificationActivityResult();
      _xblockexpression = this.addAllEvaluate(assumptionResult, _verificationActivityResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult evaluate(final PreconditionResult preconditionResult) {
    AssureResult _xblockexpression = null;
    {
      this.aue.initialize(preconditionResult);
      EList<VerificationExpr> _verificationActivityResult = preconditionResult.getVerificationActivityResult();
      _xblockexpression = this.addAllEvaluate(preconditionResult, _verificationActivityResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult evaluate(final AssureResult assureResult) {
    AssureResult _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (assureResult instanceof CaseResult) {
        _matched=true;
        _switchResult = this.evaluate(((CaseResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof ClaimResult) {
        _matched=true;
        _switchResult = this.evaluate(((ClaimResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof VerificationActivityResult) {
        _matched=true;
        _switchResult = this.evaluate(((VerificationActivityResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof FailThenResult) {
        _matched=true;
        _switchResult = this.evaluate(((FailThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AndThenResult) {
        _matched=true;
        _switchResult = this.evaluate(((AndThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof HazardResult) {
        _matched=true;
        _switchResult = this.evaluate(((HazardResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AssumptionResult) {
        _matched=true;
        _switchResult = this.evaluate(((AssumptionResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof PreconditionResult) {
        _matched=true;
        _switchResult = this.evaluate(((PreconditionResult)assureResult));
      }
    }
    return _switchResult;
  }
  
  /**
   * recursively evaluate and then add all sub element counts
   */
  public AssureResult addAllEvaluate(final AssureResult result, final EList<? extends AssureResult> parts) {
    int _failCount = result.getFailCount();
    final Function1<AssureResult, Integer> _function = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        AssureResult _evaluate = AssureEvaluator.this.evaluate(it);
        return Integer.valueOf(_evaluate.getFailCount());
      }
    };
    List<Integer> _map = ListExtensions.map(parts, _function);
    final Function2<Integer, Integer, Integer> _function_1 = new Function2<Integer, Integer, Integer>() {
      public Integer apply(final Integer a, final Integer b) {
        return Integer.valueOf(((a).intValue() + (b).intValue()));
      }
    };
    Integer _reduce = IterableExtensions.<Integer>reduce(_map, _function_1);
    int _plus = (_failCount + (_reduce).intValue());
    result.setFailCount(_plus);
    int _successCount = result.getSuccessCount();
    final Function1<AssureResult, Integer> _function_2 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        AssureResult _evaluate = AssureEvaluator.this.evaluate(it);
        return Integer.valueOf(_evaluate.getSuccessCount());
      }
    };
    List<Integer> _map_1 = ListExtensions.map(parts, _function_2);
    final Function2<Integer, Integer, Integer> _function_3 = new Function2<Integer, Integer, Integer>() {
      public Integer apply(final Integer a, final Integer b) {
        return Integer.valueOf(((a).intValue() + (b).intValue()));
      }
    };
    Integer _reduce_1 = IterableExtensions.<Integer>reduce(_map_1, _function_3);
    int _plus_1 = (_successCount + (_reduce_1).intValue());
    result.setSuccessCount(_plus_1);
    int _errorCount = result.getErrorCount();
    final Function1<AssureResult, Integer> _function_4 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        AssureResult _evaluate = AssureEvaluator.this.evaluate(it);
        return Integer.valueOf(_evaluate.getErrorCount());
      }
    };
    List<Integer> _map_2 = ListExtensions.map(parts, _function_4);
    final Function2<Integer, Integer, Integer> _function_5 = new Function2<Integer, Integer, Integer>() {
      public Integer apply(final Integer a, final Integer b) {
        return Integer.valueOf(((a).intValue() + (b).intValue()));
      }
    };
    Integer _reduce_2 = IterableExtensions.<Integer>reduce(_map_2, _function_5);
    int _plus_2 = (_errorCount + (_reduce_2).intValue());
    result.setErrorCount(_plus_2);
    int _failthenCount = result.getFailthenCount();
    final Function1<AssureResult, Integer> _function_6 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        AssureResult _evaluate = AssureEvaluator.this.evaluate(it);
        return Integer.valueOf(_evaluate.getFailthenCount());
      }
    };
    List<Integer> _map_3 = ListExtensions.map(parts, _function_6);
    final Function2<Integer, Integer, Integer> _function_7 = new Function2<Integer, Integer, Integer>() {
      public Integer apply(final Integer a, final Integer b) {
        return Integer.valueOf(((a).intValue() + (b).intValue()));
      }
    };
    Integer _reduce_3 = IterableExtensions.<Integer>reduce(_map_3, _function_7);
    int _plus_3 = (_failthenCount + (_reduce_3).intValue());
    result.setFailthenCount(_plus_3);
    int _skippedCount = result.getSkippedCount();
    final Function1<AssureResult, Integer> _function_8 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        AssureResult _evaluate = AssureEvaluator.this.evaluate(it);
        return Integer.valueOf(_evaluate.getSkippedCount());
      }
    };
    List<Integer> _map_4 = ListExtensions.map(parts, _function_8);
    final Function2<Integer, Integer, Integer> _function_9 = new Function2<Integer, Integer, Integer>() {
      public Integer apply(final Integer a, final Integer b) {
        return Integer.valueOf(((a).intValue() + (b).intValue()));
      }
    };
    Integer _reduce_4 = IterableExtensions.<Integer>reduce(_map_4, _function_9);
    int _plus_4 = (_skippedCount + (_reduce_4).intValue());
    result.setSkippedCount(_plus_4);
    return result;
  }
}
