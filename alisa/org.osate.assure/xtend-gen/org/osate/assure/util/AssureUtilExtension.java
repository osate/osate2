package org.osate.assure.util;

import com.google.common.base.Objects;
import java.util.Collections;
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
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.assure.assure.CaseResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.assure.VerificationResultState;

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
    res.setResultState(VerificationResultState.UNKNOWN);
    String _message = e.getMessage();
    res.setFailMsg(_message);
    Class<? extends Throwable> _class = e.getClass();
    String _name = _class.getName();
    res.setType(_name);
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
