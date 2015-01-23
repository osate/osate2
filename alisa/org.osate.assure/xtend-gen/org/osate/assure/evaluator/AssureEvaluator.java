package org.osate.assure.evaluator;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
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

/**
 * (re)-evaluate the result counts of the complete case (other than the total count)
 */
@SuppressWarnings("all")
public class AssureEvaluator {
  public AssureResult evaluate(final CaseResult caseResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(caseResult);
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
      AssureUtilExtension.resetCounts(claimResult);
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
      AssureUtilExtension.resetCounts(vaResult);
      EList<AssumptionResult> _assumptionResult = vaResult.getAssumptionResult();
      this.addAllEvaluate(vaResult, _assumptionResult);
      EList<PreconditionResult> _preconditionResult = vaResult.getPreconditionResult();
      this.addAllEvaluate(vaResult, _preconditionResult);
      AssureUtilExtension.addOwnResult(vaResult);
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  public AssureResult evaluate(final FailThenResult vaResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      this.addAllEvaluate(vaResult, _first);
      AssureResult _xifexpression = null;
      boolean _hasFailedOrError = AssureUtilExtension.hasFailedOrError(vaResult);
      if (_hasFailedOrError) {
        AssureResult _xblockexpression_1 = null;
        {
          AssureUtilExtension.resetCounts(vaResult);
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
      AssureUtilExtension.resetCounts(vaResult);
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
      AssureUtilExtension.resetCounts(hazardResult);
      EList<ClaimResult> _claimResult = hazardResult.getClaimResult();
      _xblockexpression = this.addAllEvaluate(hazardResult, _claimResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult evaluate(final AssumptionResult assumptionResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(assumptionResult);
      EList<VerificationExpr> _verificationActivityResult = assumptionResult.getVerificationActivityResult();
      _xblockexpression = this.addAllEvaluate(assumptionResult, _verificationActivityResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult evaluate(final PreconditionResult preconditionResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(preconditionResult);
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
    int _sum = AssureUtilExtension.sum(_map);
    int _plus = (_failCount + _sum);
    result.setFailCount(_plus);
    int _successCount = result.getSuccessCount();
    final Function1<AssureResult, Integer> _function_1 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        AssureResult _evaluate = AssureEvaluator.this.evaluate(it);
        return Integer.valueOf(_evaluate.getSuccessCount());
      }
    };
    List<Integer> _map_1 = ListExtensions.map(parts, _function_1);
    int _sum_1 = AssureUtilExtension.sum(_map_1);
    int _plus_1 = (_successCount + _sum_1);
    result.setSuccessCount(_plus_1);
    int _errorCount = result.getErrorCount();
    final Function1<AssureResult, Integer> _function_2 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        AssureResult _evaluate = AssureEvaluator.this.evaluate(it);
        return Integer.valueOf(_evaluate.getErrorCount());
      }
    };
    List<Integer> _map_2 = ListExtensions.map(parts, _function_2);
    int _sum_2 = AssureUtilExtension.sum(_map_2);
    int _plus_2 = (_errorCount + _sum_2);
    result.setErrorCount(_plus_2);
    int _failthenCount = result.getFailthenCount();
    final Function1<AssureResult, Integer> _function_3 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        AssureResult _evaluate = AssureEvaluator.this.evaluate(it);
        return Integer.valueOf(_evaluate.getFailthenCount());
      }
    };
    List<Integer> _map_3 = ListExtensions.map(parts, _function_3);
    int _sum_3 = AssureUtilExtension.sum(_map_3);
    int _plus_3 = (_failthenCount + _sum_3);
    result.setFailthenCount(_plus_3);
    int _skippedCount = result.getSkippedCount();
    final Function1<AssureResult, Integer> _function_4 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        AssureResult _evaluate = AssureEvaluator.this.evaluate(it);
        return Integer.valueOf(_evaluate.getSkippedCount());
      }
    };
    List<Integer> _map_4 = ListExtensions.map(parts, _function_4);
    int _sum_4 = AssureUtilExtension.sum(_map_4);
    int _plus_4 = (_skippedCount + _sum_4);
    result.setSkippedCount(_plus_4);
    return result;
  }
}
