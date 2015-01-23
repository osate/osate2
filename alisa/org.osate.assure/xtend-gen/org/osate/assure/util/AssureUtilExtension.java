package org.osate.assure.util;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
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
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.assure.VerificationResultState;
import org.osate.verify.verify.RefExpr;

@SuppressWarnings("all")
public class AssureUtilExtension {
  public static CaseResult getEnclosingCaseResult(final EObject assureObject) {
    EObject result = assureObject;
    while ((!(result instanceof CaseResult))) {
      EObject _eContainer = result.eContainer();
      result = _eContainer;
    }
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      return null;
    }
    return ((CaseResult) result);
  }
  
  public static CaseResult getEnclosingClaimResult(final EObject assureObject) {
    EObject result = assureObject;
    while ((!(result instanceof ClaimResult))) {
      EObject _eContainer = result.eContainer();
      result = _eContainer;
    }
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      return null;
    }
    return ((CaseResult) result);
  }
  
  public static InstanceObject getClaimSubject(final EObject assureObject) {
    InstanceObject _elvis = null;
    CaseResult _enclosingClaimResult = AssureUtilExtension.getEnclosingClaimResult(assureObject);
    InstanceObject _instance = _enclosingClaimResult.getInstance();
    if (_instance != null) {
      _elvis = _instance;
    } else {
      InstanceObject _claimSubject = AssureUtilExtension.getClaimSubject(assureObject);
      _elvis = _claimSubject;
    }
    return _elvis;
  }
  
  public static InstanceObject getCaseSubject(final EObject assureObject) {
    CaseResult _enclosingCaseResult = AssureUtilExtension.getEnclosingCaseResult(assureObject);
    InstanceObject _instance = null;
    if (_enclosingCaseResult!=null) {
      _instance=_enclosingCaseResult.getInstance();
    }
    return _instance;
  }
  
  public static void addErrorMarkers(final VerificationActivityResult verificationActivityResult, final InstanceObject instance, final String markertype) {
    try {
      final Resource res = instance.eResource();
      final EList<Resource.Diagnostic> err = res.getErrors();
      final String mt = "org.osate.analysis.flows.FlowLatencyObjectMarker";
      final IResource irsrc = OsateResourceUtil.convertToIResource(res);
      final IMarker[] markersforanalysis = irsrc.findMarkers(mt, true, IResource.DEPTH_INFINITE);
      final Function1<IMarker, Boolean> _function = new Function1<IMarker, Boolean>() {
        public Boolean apply(final IMarker m) {
          try {
            boolean _and = false;
            Object _attribute = m.getAttribute(AadlConstants.AADLURI);
            URI _uRI = EcoreUtil.getURI(instance);
            String _string = _uRI.toString();
            boolean _equals = Objects.equal(_attribute, _string);
            if (!_equals) {
              _and = false;
            } else {
              Object _attribute_1 = m.getAttribute(IMarker.SEVERITY);
              boolean _equals_1 = Objects.equal(_attribute_1, Integer.valueOf(IMarker.SEVERITY_ERROR));
              _and = _equals_1;
            }
            return Boolean.valueOf(_and);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      final Iterable<IMarker> markers = IterableExtensions.<IMarker>filter(((Iterable<IMarker>)Conversions.doWrapArray(markersforanalysis)), _function);
      final IMarker m = IterableExtensions.<IMarker>head(markers);
      final VerificationResult vr = verificationActivityResult.getResult();
      vr.setResultState(VerificationResultState.FAIL);
      Object _attribute = m.getAttribute(IMarker.MESSAGE);
      vr.setFailMsg(((String) _attribute));
      vr.setType(markertype);
      verificationActivityResult.setResult(vr);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void addSuccess(final VerificationActivityResult verificationActivityResult) {
    VerificationResult _result = verificationActivityResult.getResult();
    _result.setResultState(VerificationResultState.SUCCESS);
  }
  
  public static void addFailure(final VerificationActivityResult verificationActivityResult, final Throwable e) {
    final VerificationResult res = verificationActivityResult.getResult();
    res.setResultState(VerificationResultState.FAIL);
    String _message = e.getMessage();
    res.setFailMsg(_message);
    Class<? extends Throwable> _class = e.getClass();
    String _name = _class.getName();
    res.setType(_name);
    verificationActivityResult.setResult(res);
  }
  
  public static void addError(final VerificationActivityResult verificationActivityResult, final Throwable e) {
    final VerificationResult res = verificationActivityResult.getResult();
    res.setResultState(VerificationResultState.ERROR);
    String _message = e.getMessage();
    res.setFailMsg(_message);
    Class<? extends Throwable> _class = e.getClass();
    String _name = _class.getName();
    res.setType(_name);
  }
  
  public static int sum(final List<Integer> l) {
    final Function2<Integer, Integer, Integer> _function = new Function2<Integer, Integer, Integer>() {
      public Integer apply(final Integer a, final Integer b) {
        return Integer.valueOf(((a).intValue() + (b).intValue()));
      }
    };
    return (int) IterableExtensions.<Integer, Integer>fold(l, Integer.valueOf(0), _function);
  }
  
  public static AssureResult addTo(final AssureResult subresult, final AssureResult result) {
    int _failCount = result.getFailCount();
    int _failCount_1 = subresult.getFailCount();
    int _plus = (_failCount + _failCount_1);
    result.setFailCount(_plus);
    int _successCount = result.getSuccessCount();
    int _successCount_1 = subresult.getSuccessCount();
    int _plus_1 = (_successCount + _successCount_1);
    result.setSuccessCount(_plus_1);
    int _errorCount = result.getErrorCount();
    int _errorCount_1 = subresult.getErrorCount();
    int _plus_2 = (_errorCount + _errorCount_1);
    result.setErrorCount(_plus_2);
    int _skippedCount = result.getSkippedCount();
    int _skippedCount_1 = subresult.getSkippedCount();
    int _plus_3 = (_skippedCount + _skippedCount_1);
    result.setSkippedCount(_plus_3);
    int _failthenCount = result.getFailthenCount();
    int _failthenCount_1 = subresult.getFailthenCount();
    int _plus_4 = (_failthenCount + _failthenCount_1);
    result.setFailthenCount(_plus_4);
    return result;
  }
  
  public static void resetCounts(final AssureResult result) {
    result.setFailCount(0);
    result.setSuccessCount(0);
    result.setErrorCount(0);
    result.setSkippedCount(0);
    result.setFailthenCount(0);
  }
  
  /**
   * the total counts are (re)calculated with this method.
   * The other counts are not touched and can be updated
   * using process from Processor or evaluate from Evaluator
   */
  public static AssureResult computeAndSetTotals(final CaseResult caseResult) {
    AssureResult _xblockexpression = null;
    {
      caseResult.setTotalCount(0);
      EList<ClaimResult> _claimResult = caseResult.getClaimResult();
      AssureUtilExtension.addAllTotals(caseResult, _claimResult);
      EList<HazardResult> _hazardResult = caseResult.getHazardResult();
      AssureUtilExtension.addAllTotals(caseResult, _hazardResult);
      EList<CaseResult> _subCaseResult = caseResult.getSubCaseResult();
      _xblockexpression = AssureUtilExtension.addAllTotals(caseResult, _subCaseResult);
    }
    return _xblockexpression;
  }
  
  public static AssureResult computeAndSetTotals(final ClaimResult claimResult) {
    AssureResult _xblockexpression = null;
    {
      claimResult.setTotalCount(0);
      EList<VerificationExpr> _verificationActivityResult = claimResult.getVerificationActivityResult();
      AssureUtilExtension.addAllTotals(claimResult, _verificationActivityResult);
      EList<ClaimResult> _subClaimResult = claimResult.getSubClaimResult();
      _xblockexpression = AssureUtilExtension.addAllTotals(claimResult, _subClaimResult);
    }
    return _xblockexpression;
  }
  
  public static AssureResult computeAndSetTotals(final VerificationActivityResult vaResult) {
    VerificationActivityResult _xblockexpression = null;
    {
      vaResult.setTotalCount(1);
      EList<AssumptionResult> _assumptionResult = vaResult.getAssumptionResult();
      AssureUtilExtension.addAllTotals(vaResult, _assumptionResult);
      EList<PreconditionResult> _preconditionResult = vaResult.getPreconditionResult();
      AssureUtilExtension.addAllTotals(vaResult, _preconditionResult);
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  public static AssureResult computeAndSetTotals(final FailThenResult vaResult) {
    AssureResult _xblockexpression = null;
    {
      vaResult.setTotalCount(0);
      EList<VerificationExpr> _first = vaResult.getFirst();
      AssureUtilExtension.addAllTotals(vaResult, _first);
      EList<VerificationExpr> _second = vaResult.getSecond();
      _xblockexpression = AssureUtilExtension.addAllTotals(vaResult, _second);
    }
    return _xblockexpression;
  }
  
  public static AssureResult computeAndSetTotals(final AndThenResult vaResult) {
    AssureResult _xblockexpression = null;
    {
      vaResult.setTotalCount(0);
      EList<VerificationExpr> _first = vaResult.getFirst();
      AssureUtilExtension.addAllTotals(vaResult, _first);
      EList<VerificationExpr> _second = vaResult.getSecond();
      _xblockexpression = AssureUtilExtension.addAllTotals(vaResult, _second);
    }
    return _xblockexpression;
  }
  
  public static AssureResult computeAndSetTotals(final HazardResult hazardResult) {
    AssureResult _xblockexpression = null;
    {
      hazardResult.setTotalCount(0);
      EList<ClaimResult> _claimResult = hazardResult.getClaimResult();
      _xblockexpression = AssureUtilExtension.addAllTotals(hazardResult, _claimResult);
    }
    return _xblockexpression;
  }
  
  public static AssureResult computeAndSetTotals(final AssumptionResult assumptionResult) {
    AssureResult _xblockexpression = null;
    {
      assumptionResult.setTotalCount(0);
      EList<VerificationExpr> _verificationActivityResult = assumptionResult.getVerificationActivityResult();
      _xblockexpression = AssureUtilExtension.addAllTotals(assumptionResult, _verificationActivityResult);
    }
    return _xblockexpression;
  }
  
  public static AssureResult computeAndSetTotals(final PreconditionResult preconditionResult) {
    AssureResult _xblockexpression = null;
    {
      preconditionResult.setTotalCount(0);
      EList<VerificationExpr> _verificationActivityResult = preconditionResult.getVerificationActivityResult();
      _xblockexpression = AssureUtilExtension.addAllTotals(preconditionResult, _verificationActivityResult);
    }
    return _xblockexpression;
  }
  
  public static AssureResult computeAndSetTotals(final AssureResult assureResult) {
    AssureResult _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (assureResult instanceof CaseResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.computeAndSetTotals(((CaseResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof ClaimResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.computeAndSetTotals(((ClaimResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof VerificationActivityResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.computeAndSetTotals(((VerificationActivityResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof FailThenResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.computeAndSetTotals(((FailThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AndThenResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.computeAndSetTotals(((AndThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof HazardResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.computeAndSetTotals(((HazardResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AssumptionResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.computeAndSetTotals(((AssumptionResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof PreconditionResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.computeAndSetTotals(((PreconditionResult)assureResult));
      }
    }
    return _switchResult;
  }
  
  public static AssureResult addAllTotals(final AssureResult result, final EList<? extends AssureResult> parts) {
    final Procedure1<AssureResult> _function = new Procedure1<AssureResult>() {
      public void apply(final AssureResult e) {
        AssureResult _computeAndSetTotals = AssureUtilExtension.computeAndSetTotals(e);
        int _totalCount = _computeAndSetTotals.getTotalCount();
        AssureUtilExtension.addToTotal(result, _totalCount);
      }
    };
    IterableExtensions.forEach(parts, _function);
    return result;
  }
  
  public static void addToTotal(final AssureResult result, final int count) {
    int _totalCount = result.getTotalCount();
    int _plus = (_totalCount + count);
    result.setTotalCount(_plus);
  }
  
  /**
   * the next set of methods update the counts other than total count
   */
  public AssureResult computeAndSetCounts(final CaseResult caseResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(caseResult);
      EList<ClaimResult> _claimResult = caseResult.getClaimResult();
      this.computeAndAddAllCounts(caseResult, _claimResult);
      EList<HazardResult> _hazardResult = caseResult.getHazardResult();
      this.computeAndAddAllCounts(caseResult, _hazardResult);
      EList<CaseResult> _subCaseResult = caseResult.getSubCaseResult();
      _xblockexpression = this.computeAndAddAllCounts(caseResult, _subCaseResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult computeAndSetCounts(final ClaimResult claimResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(claimResult);
      EList<VerificationExpr> _verificationActivityResult = claimResult.getVerificationActivityResult();
      this.computeAndAddAllCounts(claimResult, _verificationActivityResult);
      EList<ClaimResult> _subClaimResult = claimResult.getSubClaimResult();
      _xblockexpression = this.computeAndAddAllCounts(claimResult, _subClaimResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult computeAndSetCounts(final VerificationActivityResult vaResult) {
    VerificationActivityResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<AssumptionResult> _assumptionResult = vaResult.getAssumptionResult();
      this.computeAndAddAllCounts(vaResult, _assumptionResult);
      EList<PreconditionResult> _preconditionResult = vaResult.getPreconditionResult();
      this.computeAndAddAllCounts(vaResult, _preconditionResult);
      AssureUtilExtension.addOwnResult(vaResult);
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  public AssureResult computeAndSetCounts(final FailThenResult vaResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      this.computeAndAddAllCounts(vaResult, _first);
      AssureResult _xifexpression = null;
      boolean _hasFailedOrError = AssureUtilExtension.hasFailedOrError(vaResult);
      if (_hasFailedOrError) {
        AssureResult _xblockexpression_1 = null;
        {
          AssureUtilExtension.resetCounts(vaResult);
          EList<VerificationExpr> _second = vaResult.getSecond();
          _xblockexpression_1 = this.computeAndAddAllCounts(vaResult, _second);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public AssureResult computeAndSetCounts(final AndThenResult vaResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      this.computeAndAddAllCounts(vaResult, _first);
      EList<VerificationExpr> _second = vaResult.getSecond();
      _xblockexpression = this.computeAndAddAllCounts(vaResult, _second);
    }
    return _xblockexpression;
  }
  
  public AssureResult computeAndSetCounts(final HazardResult hazardResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(hazardResult);
      EList<ClaimResult> _claimResult = hazardResult.getClaimResult();
      _xblockexpression = this.computeAndAddAllCounts(hazardResult, _claimResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult computeAndSetCounts(final AssumptionResult assumptionResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(assumptionResult);
      EList<VerificationExpr> _verificationActivityResult = assumptionResult.getVerificationActivityResult();
      _xblockexpression = this.computeAndAddAllCounts(assumptionResult, _verificationActivityResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult computeAndSetCounts(final PreconditionResult preconditionResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(preconditionResult);
      EList<VerificationExpr> _verificationActivityResult = preconditionResult.getVerificationActivityResult();
      _xblockexpression = this.computeAndAddAllCounts(preconditionResult, _verificationActivityResult);
    }
    return _xblockexpression;
  }
  
  public AssureResult computeAndSetCounts(final AssureResult assureResult) {
    AssureResult _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (assureResult instanceof CaseResult) {
        _matched=true;
        _switchResult = this.computeAndSetCounts(((CaseResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof ClaimResult) {
        _matched=true;
        _switchResult = this.computeAndSetCounts(((ClaimResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof VerificationActivityResult) {
        _matched=true;
        _switchResult = this.computeAndSetCounts(((VerificationActivityResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof FailThenResult) {
        _matched=true;
        _switchResult = this.computeAndSetCounts(((FailThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AndThenResult) {
        _matched=true;
        _switchResult = this.computeAndSetCounts(((AndThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof HazardResult) {
        _matched=true;
        _switchResult = this.computeAndSetCounts(((HazardResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AssumptionResult) {
        _matched=true;
        _switchResult = this.computeAndSetCounts(((AssumptionResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof PreconditionResult) {
        _matched=true;
        _switchResult = this.computeAndSetCounts(((PreconditionResult)assureResult));
      }
    }
    return _switchResult;
  }
  
  /**
   * recursively compute and then add all sub element counts but total count
   */
  public AssureResult computeAndAddAllCounts(final AssureResult result, final EList<? extends AssureResult> parts) {
    final Procedure1<AssureResult> _function = new Procedure1<AssureResult>() {
      public void apply(final AssureResult e) {
        AssureResult _computeAndSetCounts = AssureUtilExtension.this.computeAndSetCounts(e);
        AssureUtilExtension.addTo(_computeAndSetCounts, result);
      }
    };
    IterableExtensions.forEach(parts, _function);
    return result;
  }
  
  /**
   * the next methods update the counts for FailThen and AndThen
   */
  public static FailThenResult recordFailThen(final FailThenResult result) {
    FailThenResult _xblockexpression = null;
    {
      int _failCount = result.getFailCount();
      int _errorCount = result.getErrorCount();
      int _plus = (_failCount + _errorCount);
      result.setFailthenCount(_plus);
      result.setFailCount(0);
      result.setErrorCount(0);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static AndThenResult recordSkip(final AndThenResult result) {
    AndThenResult _xblockexpression = null;
    {
      EList<VerificationExpr> _second = result.getSecond();
      final Function1<VerificationExpr, Integer> _function = new Function1<VerificationExpr, Integer>() {
        public Integer apply(final VerificationExpr exp) {
          return Integer.valueOf(exp.getTotalCount());
        }
      };
      List<Integer> _map = ListExtensions.<VerificationExpr, Integer>map(_second, _function);
      int _sum = AssureUtilExtension.sum(_map);
      result.setSkippedCount(_sum);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public static VerificationActivityResult addOwnResult(final VerificationActivityResult ar) {
    VerificationActivityResult _xblockexpression = null;
    {
      VerificationResult _result = ar.getResult();
      VerificationResultState _resultState = _result.getResultState();
      if (_resultState != null) {
        switch (_resultState) {
          case SUCCESS:
            int _successCount = ar.getSuccessCount();
            int _plus = (_successCount + 1);
            ar.setSuccessCount(_plus);
            break;
          case FAIL:
            int _failCount = ar.getFailCount();
            int _plus_1 = (_failCount + 1);
            ar.setFailCount(_plus_1);
            break;
          case ERROR:
            int _errorCount = ar.getErrorCount();
            int _plus_2 = (_errorCount + 1);
            ar.setErrorCount(_plus_2);
            break;
          case TBD:
            break;
          default:
            break;
        }
      }
      _xblockexpression = ar;
    }
    return _xblockexpression;
  }
  
  public static AssureResult addAllCounts(final AssureResult result, final List<? extends AssureResult> parts) {
    final Procedure1<AssureResult> _function = new Procedure1<AssureResult>() {
      public void apply(final AssureResult e) {
        AssureUtilExtension.addTo(e, result);
      }
    };
    IterableExtensions.forEach(parts, _function);
    return result;
  }
  
  public static AssureResult addAllCounts(final CaseResult caseResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(caseResult);
      EList<ClaimResult> _claimResult = caseResult.getClaimResult();
      AssureUtilExtension.addAllCounts(caseResult, _claimResult);
      EList<HazardResult> _hazardResult = caseResult.getHazardResult();
      AssureUtilExtension.addAllCounts(caseResult, _hazardResult);
      EList<CaseResult> _subCaseResult = caseResult.getSubCaseResult();
      _xblockexpression = AssureUtilExtension.addAllCounts(caseResult, _subCaseResult);
    }
    return _xblockexpression;
  }
  
  public static AssureResult addAllCounts(final ClaimResult claimResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(claimResult);
      EList<VerificationExpr> _verificationActivityResult = claimResult.getVerificationActivityResult();
      AssureUtilExtension.addAllCounts(claimResult, _verificationActivityResult);
      EList<ClaimResult> _subClaimResult = claimResult.getSubClaimResult();
      _xblockexpression = AssureUtilExtension.addAllCounts(claimResult, _subClaimResult);
    }
    return _xblockexpression;
  }
  
  public static AssureResult addAllCounts(final VerificationActivityResult vaResult) {
    VerificationActivityResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<AssumptionResult> _assumptionResult = vaResult.getAssumptionResult();
      AssureUtilExtension.addAllCounts(vaResult, _assumptionResult);
      EList<PreconditionResult> _preconditionResult = vaResult.getPreconditionResult();
      AssureUtilExtension.addAllCounts(vaResult, _preconditionResult);
      AssureUtilExtension.addOwnResult(vaResult);
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  public static AssureResult addAllCounts(final FailThenResult vaResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      AssureUtilExtension.addAllCounts(vaResult, _first);
      AssureResult _xifexpression = null;
      boolean _hasFailedOrError = AssureUtilExtension.hasFailedOrError(vaResult);
      if (_hasFailedOrError) {
        AssureResult _xblockexpression_1 = null;
        {
          AssureUtilExtension.resetCounts(vaResult);
          EList<VerificationExpr> _second = vaResult.getSecond();
          _xblockexpression_1 = AssureUtilExtension.addAllCounts(vaResult, _second);
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static AssureResult addAllCounts(final AndThenResult vaResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      AssureUtilExtension.addAllCounts(vaResult, _first);
      EList<VerificationExpr> _second = vaResult.getSecond();
      _xblockexpression = AssureUtilExtension.addAllCounts(vaResult, _second);
    }
    return _xblockexpression;
  }
  
  public static AssureResult addAllCounts(final HazardResult hazardResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(hazardResult);
      EList<ClaimResult> _claimResult = hazardResult.getClaimResult();
      _xblockexpression = AssureUtilExtension.addAllCounts(hazardResult, _claimResult);
    }
    return _xblockexpression;
  }
  
  public static AssureResult addAllCounts(final AssumptionResult assumptionResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(assumptionResult);
      EList<VerificationExpr> _verificationActivityResult = assumptionResult.getVerificationActivityResult();
      _xblockexpression = AssureUtilExtension.addAllCounts(assumptionResult, _verificationActivityResult);
    }
    return _xblockexpression;
  }
  
  public static AssureResult addAllCounts(final PreconditionResult preconditionResult) {
    AssureResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(preconditionResult);
      EList<VerificationExpr> _verificationActivityResult = preconditionResult.getVerificationActivityResult();
      _xblockexpression = AssureUtilExtension.addAllCounts(preconditionResult, _verificationActivityResult);
    }
    return _xblockexpression;
  }
  
  public static AssureResult addAllCounts(final AssureResult assureResult) {
    AssureResult _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (assureResult instanceof CaseResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllCounts(((CaseResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof ClaimResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllCounts(((ClaimResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof VerificationActivityResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllCounts(((VerificationActivityResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof FailThenResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllCounts(((FailThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AndThenResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllCounts(((AndThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof HazardResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllCounts(((HazardResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AssumptionResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllCounts(((AssumptionResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof PreconditionResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllCounts(((PreconditionResult)assureResult));
      }
    }
    return _switchResult;
  }
  
  public static VerificationActivityResult addOwnResultAndRecomputeUp(final VerificationActivityResult ar) {
    Object _xblockexpression = null;
    {
      AssureUtilExtension.addOwnResult(ar);
      EObject parent = ar.eContainer();
      while (((!Objects.equal(parent, null)) && (parent instanceof AssureResult))) {
        {
          final AssureResult parentResult = ((AssureResult) parent);
          AssureUtilExtension.addAllCounts(parentResult);
        }
      }
      _xblockexpression = null;
    }
    return ((VerificationActivityResult)_xblockexpression);
  }
  
  public static int countElements(final AssureResult ar) {
    int _xblockexpression = (int) 0;
    {
      boolean _matched = false;
      if (!_matched) {
        if (ar instanceof CaseResult) {
          _matched=true;
          EList<CaseResult> _subCaseResult = ((CaseResult)ar).getSubCaseResult();
          int _length = ((Object[])Conversions.unwrapArray(_subCaseResult, Object.class)).length;
          EList<ClaimResult> _claimResult = ((CaseResult)ar).getClaimResult();
          int _length_1 = ((Object[])Conversions.unwrapArray(_claimResult, Object.class)).length;
          int _plus = (_length + _length_1);
          EList<HazardResult> _hazardResult = ((CaseResult)ar).getHazardResult();
          int _length_2 = ((Object[])Conversions.unwrapArray(_hazardResult, Object.class)).length;
          /* (_plus + _length_2); */
        }
      }
      if (!_matched) {
        if (ar instanceof ClaimResult) {
          _matched=true;
          EList<ClaimResult> _subClaimResult = ((ClaimResult)ar).getSubClaimResult();
          int _length = ((Object[])Conversions.unwrapArray(_subClaimResult, Object.class)).length;
          EList<VerificationExpr> _verificationActivityResult = ((ClaimResult)ar).getVerificationActivityResult();
          int _length_1 = ((Object[])Conversions.unwrapArray(_verificationActivityResult, Object.class)).length;
          /* (_length + _length_1); */
        }
      }
      if (!_matched) {
        if (ar instanceof HazardResult) {
          _matched=true;
          EList<ClaimResult> _claimResult = ((HazardResult)ar).getClaimResult();
          /* ((Object[])Conversions.unwrapArray(_claimResult, Object.class)).length; */
        }
      }
      if (!_matched) {
        if (ar instanceof AssumptionResult) {
          _matched=true;
          EList<VerificationExpr> _verificationActivityResult = ((AssumptionResult)ar).getVerificationActivityResult();
          /* ((Object[])Conversions.unwrapArray(_verificationActivityResult, Object.class)).length; */
        }
      }
      if (!_matched) {
        if (ar instanceof PreconditionResult) {
          _matched=true;
          EList<VerificationExpr> _verificationActivityResult = ((PreconditionResult)ar).getVerificationActivityResult();
          /* ((Object[])Conversions.unwrapArray(_verificationActivityResult, Object.class)).length; */
        }
      }
      if (!_matched) {
        if (ar instanceof VerificationActivityResult) {
          _matched=true;
          EList<AssumptionResult> _assumptionResult = ((VerificationActivityResult)ar).getAssumptionResult();
          int _length = ((Object[])Conversions.unwrapArray(_assumptionResult, Object.class)).length;
          int _plus = (1 + _length);
          EList<PreconditionResult> _preconditionResult = ((VerificationActivityResult)ar).getPreconditionResult();
          int _length_1 = ((Object[])Conversions.unwrapArray(_preconditionResult, Object.class)).length;
          /* (_plus + _length_1); */
        }
      }
      if (!_matched) {
        if (ar instanceof FailThenResult) {
          _matched=true;
          EList<VerificationExpr> _first = ((FailThenResult)ar).getFirst();
          int _length = ((Object[])Conversions.unwrapArray(_first, Object.class)).length;
          EList<VerificationExpr> _second = ((FailThenResult)ar).getSecond();
          int _length_1 = ((Object[])Conversions.unwrapArray(_second, Object.class)).length;
          /* (_length + _length_1); */
        }
      }
      if (!_matched) {
        if (ar instanceof AndThenResult) {
          _matched=true;
          EList<VerificationExpr> _first = ((AndThenResult)ar).getFirst();
          int _length = ((Object[])Conversions.unwrapArray(_first, Object.class)).length;
          EList<VerificationExpr> _second = ((AndThenResult)ar).getSecond();
          int _length_1 = ((Object[])Conversions.unwrapArray(_second, Object.class)).length;
          /* (_length + _length_1); */
        }
      }
      _xblockexpression = 0;
    }
    return _xblockexpression;
  }
  
  public static int getTBDCount(final AssureResult ar) {
    int _totalCount = ar.getTotalCount();
    int _successCount = ar.getSuccessCount();
    int _minus = (_totalCount - _successCount);
    int _failCount = ar.getFailCount();
    int _minus_1 = (_minus - _failCount);
    int _errorCount = ar.getErrorCount();
    int _minus_2 = (_minus_1 - _errorCount);
    int _failthenCount = ar.getFailthenCount();
    int _minus_3 = (_minus_2 - _failthenCount);
    int _skippedCount = ar.getSkippedCount();
    return (_minus_3 - _skippedCount);
  }
  
  public static boolean isSuccessFul(final AssureResult ar) {
    boolean _and = false;
    int _failCount = ar.getFailCount();
    boolean _equals = (_failCount == 0);
    if (!_equals) {
      _and = false;
    } else {
      int _errorCount = ar.getErrorCount();
      boolean _equals_1 = (_errorCount == 0);
      _and = _equals_1;
    }
    return _and;
  }
  
  public static boolean hasFailedOrError(final AssureResult ar) {
    boolean _or = false;
    int _failCount = ar.getFailCount();
    boolean _greaterThan = (_failCount > 0);
    if (_greaterThan) {
      _or = true;
    } else {
      int _errorCount = ar.getErrorCount();
      boolean _greaterThan_1 = (_errorCount > 0);
      _or = _greaterThan_1;
    }
    return _or;
  }
  
  public static int getTheWeight(final RefExpr expr) {
    int _switchResult = (int) 0;
    boolean _matched = false;
    if (!_matched) {
      int _weight = expr.getWeight();
      boolean _equals = (_weight == 0);
      if (_equals) {
        _matched=true;
        _switchResult = 1;
      }
    }
    if (!_matched) {
      _switchResult = expr.getWeight();
    }
    return _switchResult;
  }
  
  public static String getNamePath(final AssureResult ar) {
    EObject _eContainer = ar.eContainer();
    boolean _equals = Objects.equal(_eContainer, null);
    if (_equals) {
      return AssureUtilExtension.getPrintableName(ar);
    } else {
      EObject _eContainer_1 = ar.eContainer();
      String _namePath = AssureUtilExtension.getNamePath(((AssureResult) _eContainer_1));
      String _plus = (_namePath + ".");
      String _printableName = AssureUtilExtension.getPrintableName(ar);
      return (_plus + _printableName);
    }
  }
  
  public static String getPrintableName(final AssureResult ar) {
    boolean _matched = false;
    if (!_matched) {
      if (ar instanceof CaseResult) {
        _matched=true;
        return ((CaseResult)ar).getName();
      }
    }
    if (!_matched) {
      if (ar instanceof ClaimResult) {
        _matched=true;
        return ((ClaimResult)ar).getName();
      }
    }
    if (!_matched) {
      if (ar instanceof VerificationActivityResult) {
        _matched=true;
        return ((VerificationActivityResult)ar).getName();
      }
    }
    if (!_matched) {
      if (ar instanceof AssumptionResult) {
        _matched=true;
        return ((AssumptionResult)ar).getName();
      }
    }
    if (!_matched) {
      if (ar instanceof PreconditionResult) {
        _matched=true;
        return ((PreconditionResult)ar).getName();
      }
    }
    if (!_matched) {
      if (ar instanceof HazardResult) {
        _matched=true;
        return ((HazardResult)ar).getName();
      }
    }
    if (!_matched) {
      if (ar instanceof FailThenResult) {
        _matched=true;
        return "FailThen";
      }
    }
    if (!_matched) {
      if (ar instanceof AndThenResult) {
        _matched=true;
        return "AndThen";
      }
    }
    return null;
  }
  
  private final static Map<Object, Object> hasRunRecord = Collections.<Object, Object>synchronizedMap(CollectionLiterals.<Object, Object>newHashMap());
  
  public static boolean hasRun(final String analysisID, final EObject target) {
    try {
      Object _elvis = null;
      Object _put = AssureUtilExtension.hasRunRecord.put(analysisID, target);
      if (_put != null) {
        _elvis = _put;
      } else {
        EObject _runme = AssureUtilExtension.runme(analysisID, target);
        _elvis = _runme;
      }
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception e = (Exception)_t;
        AssureUtilExtension.hasRunRecord.remove(analysisID);
        return false;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return true;
  }
  
  public static void clearHasRunRecords() {
    AssureUtilExtension.hasRunRecord.clear();
  }
  
  public static EObject runme(final String analysisID, final EObject eo) {
    return eo;
  }
}
