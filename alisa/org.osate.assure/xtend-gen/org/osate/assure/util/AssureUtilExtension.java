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
    Integer _elvis = null;
    final Function2<Integer, Integer, Integer> _function = new Function2<Integer, Integer, Integer>() {
      public Integer apply(final Integer a, final Integer b) {
        return Integer.valueOf(((a).intValue() + (b).intValue()));
      }
    };
    Integer _reduce = IterableExtensions.<Integer>reduce(l, _function);
    if (_reduce != null) {
      _elvis = _reduce;
    } else {
      _elvis = Integer.valueOf(0);
    }
    return (int) _elvis;
  }
  
  /**
   * add all subelement counts without reevaluating them
   */
  public static AssureResult addAllTo(final List<? extends AssureResult> parts, final AssureResult result) {
    int _failCount = result.getFailCount();
    final Function1<AssureResult, Integer> _function = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        return Integer.valueOf(it.getFailCount());
      }
    };
    List<Integer> _map = ListExtensions.map(parts, _function);
    int _sum = AssureUtilExtension.sum(_map);
    int _plus = (_failCount + _sum);
    result.setFailCount(_plus);
    int _successCount = result.getSuccessCount();
    final Function1<AssureResult, Integer> _function_1 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        return Integer.valueOf(it.getSuccessCount());
      }
    };
    List<Integer> _map_1 = ListExtensions.map(parts, _function_1);
    int _sum_1 = AssureUtilExtension.sum(_map_1);
    int _plus_1 = (_successCount + _sum_1);
    result.setSuccessCount(_plus_1);
    int _errorCount = result.getErrorCount();
    final Function1<AssureResult, Integer> _function_2 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        return Integer.valueOf(it.getErrorCount());
      }
    };
    List<Integer> _map_2 = ListExtensions.map(parts, _function_2);
    int _sum_2 = AssureUtilExtension.sum(_map_2);
    int _plus_2 = (_errorCount + _sum_2);
    result.setErrorCount(_plus_2);
    int _skippedCount = result.getSkippedCount();
    final Function1<AssureResult, Integer> _function_3 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        return Integer.valueOf(it.getSkippedCount());
      }
    };
    List<Integer> _map_3 = ListExtensions.map(parts, _function_3);
    int _sum_3 = AssureUtilExtension.sum(_map_3);
    int _plus_3 = (_skippedCount + _sum_3);
    result.setSkippedCount(_plus_3);
    int _failthenCount = result.getFailthenCount();
    final Function1<AssureResult, Integer> _function_4 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        return Integer.valueOf(it.getFailthenCount());
      }
    };
    List<Integer> _map_4 = ListExtensions.map(parts, _function_4);
    int _sum_4 = AssureUtilExtension.sum(_map_4);
    int _plus_4 = (_failthenCount + _sum_4);
    result.setFailthenCount(_plus_4);
    return result;
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
    int _totalCount = result.getTotalCount();
    final Function1<AssureResult, Integer> _function = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult e) {
        AssureResult _computeAndSetTotals = AssureUtilExtension.computeAndSetTotals(e);
        return Integer.valueOf(_computeAndSetTotals.getTotalCount());
      }
    };
    List<Integer> _map = ListExtensions.map(parts, _function);
    int _sum = AssureUtilExtension.sum(_map);
    int _plus = (_totalCount + _sum);
    result.setTotalCount(_plus);
    return result;
  }
  
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
