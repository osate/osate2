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
  public CaseResult getEnclosingCaseResult(final EObject assureObject) {
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
  
  public InstanceObject getCaseSubject(final EObject assureObject) {
    final CaseResult context = this.getEnclosingCaseResult(assureObject);
    boolean _equals = Objects.equal(context, null);
    if (_equals) {
      return null;
    }
    return context.getInstance();
  }
  
  public void addErrorMarkers(final VerificationActivityResult verificationActivityResult, final InstanceObject instance, final String markertype) {
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
  
  public void addFailure(final VerificationActivityResult verificationActivityResult, final Throwable e) {
    final VerificationResult res = verificationActivityResult.getResult();
    res.setResultState(VerificationResultState.FAIL);
    String _message = e.getMessage();
    res.setFailMsg(_message);
    Class<? extends Throwable> _class = e.getClass();
    String _name = _class.getName();
    res.setType(_name);
    verificationActivityResult.setResult(res);
  }
  
  public void addError(final VerificationActivityResult verificationActivityResult, final Throwable e) {
    final VerificationResult res = verificationActivityResult.getResult();
    res.setResultState(VerificationResultState.ERROR);
    String _message = e.getMessage();
    res.setFailMsg(_message);
    Class<? extends Throwable> _class = e.getClass();
    String _name = _class.getName();
    res.setType(_name);
  }
  
  public int sum(final List<Integer> l) {
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
  public AssureResult addAllTo(final List<? extends AssureResult> parts, final AssureResult result) {
    int _failCount = result.getFailCount();
    final Function1<AssureResult, Integer> _function = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        return Integer.valueOf(it.getFailCount());
      }
    };
    List<Integer> _map = ListExtensions.map(parts, _function);
    int _sum = this.sum(_map);
    int _plus = (_failCount + _sum);
    result.setFailCount(_plus);
    int _successCount = result.getSuccessCount();
    final Function1<AssureResult, Integer> _function_1 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        return Integer.valueOf(it.getSuccessCount());
      }
    };
    List<Integer> _map_1 = ListExtensions.map(parts, _function_1);
    int _sum_1 = this.sum(_map_1);
    int _plus_1 = (_successCount + _sum_1);
    result.setSuccessCount(_plus_1);
    int _errorCount = result.getErrorCount();
    final Function1<AssureResult, Integer> _function_2 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        return Integer.valueOf(it.getErrorCount());
      }
    };
    List<Integer> _map_2 = ListExtensions.map(parts, _function_2);
    int _sum_2 = this.sum(_map_2);
    int _plus_2 = (_errorCount + _sum_2);
    result.setErrorCount(_plus_2);
    int _skippedCount = result.getSkippedCount();
    final Function1<AssureResult, Integer> _function_3 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        return Integer.valueOf(it.getSkippedCount());
      }
    };
    List<Integer> _map_3 = ListExtensions.map(parts, _function_3);
    int _sum_3 = this.sum(_map_3);
    int _plus_3 = (_skippedCount + _sum_3);
    result.setSkippedCount(_plus_3);
    int _failthenCount = result.getFailthenCount();
    final Function1<AssureResult, Integer> _function_4 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        return Integer.valueOf(it.getFailthenCount());
      }
    };
    List<Integer> _map_4 = ListExtensions.map(parts, _function_4);
    int _sum_4 = this.sum(_map_4);
    int _plus_4 = (_failthenCount + _sum_4);
    result.setFailthenCount(_plus_4);
    int _totalCount = result.getTotalCount();
    final Function1<AssureResult, Integer> _function_5 = new Function1<AssureResult, Integer>() {
      public Integer apply(final AssureResult it) {
        return Integer.valueOf(it.getTotalCount());
      }
    };
    List<Integer> _map_5 = ListExtensions.map(parts, _function_5);
    int _sum_5 = this.sum(_map_5);
    int _plus_5 = (_totalCount + _sum_5);
    result.setTotalCount(_plus_5);
    return result;
  }
  
  public void initialize(final AssureResult result) {
    result.setFailCount(0);
    result.setSuccessCount(0);
    result.setErrorCount(0);
    result.setSkippedCount(0);
    result.setFailthenCount(0);
    int _countElements = this.countElements(result);
    result.setTotalCount(_countElements);
  }
  
  public FailThenResult recordFailThen(final FailThenResult result) {
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
  
  public AndThenResult recordSkip(final AndThenResult result) {
    AndThenResult _xblockexpression = null;
    {
      EList<VerificationExpr> _second = result.getSecond();
      final Function1<VerificationExpr, Integer> _function = new Function1<VerificationExpr, Integer>() {
        public Integer apply(final VerificationExpr exp) {
          return Integer.valueOf(exp.getTotalCount());
        }
      };
      List<Integer> _map = ListExtensions.<VerificationExpr, Integer>map(_second, _function);
      final Function2<Integer, Integer, Integer> _function_1 = new Function2<Integer, Integer, Integer>() {
        public Integer apply(final Integer a, final Integer b) {
          return Integer.valueOf(((a).intValue() + (b).intValue()));
        }
      };
      Integer _reduce = IterableExtensions.<Integer>reduce(_map, _function_1);
      result.setSkippedCount((_reduce).intValue());
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public VerificationActivityResult addOwnResult(final VerificationActivityResult ar) {
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
  
  public int countElements(final AssureResult ar) {
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
  
  public int getTBDCount(final AssureResult ar) {
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
  
  public boolean isSuccessFul(final AssureResult ar) {
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
  
  public boolean hasFailedOrError(final AssureResult ar) {
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
  
  public int getTheWeight(final RefExpr expr) {
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
