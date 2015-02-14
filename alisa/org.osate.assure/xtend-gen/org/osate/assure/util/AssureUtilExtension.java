package org.osate.assure.util;

import com.google.common.base.Objects;
import com.rockwellcollins.atc.resolute.analysis.execution.FeatureToConnectionsMap;
import com.rockwellcollins.atc.resolute.analysis.execution.NamedElementComparator;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.analysis.views.ResoluteResultContentProvider;
import com.rockwellcollins.atc.resolute.resolute.FailExpr;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.validation.BaseType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.alisa.common.common.Description;
import org.osate.alisa.common.util.CommonUtilExtension;
import org.osate.assure.assure.AndThenResult;
import org.osate.assure.assure.AssuranceEvidence;
import org.osate.assure.assure.AssureFactory;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.FailThenResult;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.ResultIssue;
import org.osate.assure.assure.ResultIssueType;
import org.osate.assure.assure.ValidationResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExecutionState;
import org.osate.assure.assure.VerificationExpr;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.assure.VerificationResultState;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.verify.verify.RefExpr;
import org.osate.verify.verify.SupportedReporting;
import org.osate.verify.verify.SupportedScopes;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;
import org.osate.verify.verify.VerificationPrecondition;
import org.osate.verify.verify.VerificationValidation;

@SuppressWarnings("all")
public class AssureUtilExtension {
  public static AssuranceEvidence getEnclosingAssuranceEvidence(final EObject assureObject) {
    EObject result = assureObject;
    while ((!(result instanceof AssuranceEvidence))) {
      EObject _eContainer = result.eContainer();
      result = _eContainer;
    }
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      return null;
    }
    return ((AssuranceEvidence) result);
  }
  
  public static ClaimResult getEnclosingClaimResult(final EObject assureObject) {
    EObject result = assureObject;
    while ((!(result instanceof ClaimResult))) {
      EObject _eContainer = result.eContainer();
      result = _eContainer;
    }
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      return null;
    }
    return ((ClaimResult) result);
  }
  
  public static InstanceObject getClaimSubject(final EObject assureObject) {
    InstanceObject _elvis = null;
    ClaimResult _enclosingClaimResult = AssureUtilExtension.getEnclosingClaimResult(assureObject);
    InstanceObject _instance = _enclosingClaimResult.getInstance();
    if (_instance != null) {
      _elvis = _instance;
    } else {
      InstanceObject _caseSubject = AssureUtilExtension.getCaseSubject(assureObject);
      _elvis = _caseSubject;
    }
    return _elvis;
  }
  
  public static InstanceObject getCaseSubject(final EObject assureObject) {
    AssuranceEvidence _enclosingAssuranceEvidence = AssureUtilExtension.getEnclosingAssuranceEvidence(assureObject);
    InstanceObject _instance = null;
    if (_enclosingAssuranceEvidence!=null) {
      _instance=_enclosingAssuranceEvidence.getInstance();
    }
    return _instance;
  }
  
  public static VerificationMethod getMethod(final VerificationResult vr) {
    boolean _matched = false;
    if (!_matched) {
      if (vr instanceof VerificationActivityResult) {
        _matched=true;
        VerificationActivity _target = ((VerificationActivityResult)vr).getTarget();
        return _target.getMethod();
      }
    }
    if (!_matched) {
      if (vr instanceof PreconditionResult) {
        _matched=true;
        VerificationPrecondition _target = ((PreconditionResult)vr).getTarget();
        return _target.getMethod();
      }
    }
    if (!_matched) {
      if (vr instanceof ValidationResult) {
        _matched=true;
        VerificationValidation _target = ((ValidationResult)vr).getTarget();
        return _target.getMethod();
      }
    }
    return null;
  }
  
  /**
   * methods to process results from verification methods
   */
  public static boolean addMarkers(final VerificationResult verificationActivityResult, final InstanceObject instance, final String markertype, final VerificationMethod vm) {
    try {
      final SupportedScopes scope = vm.getScope();
      final SupportedReporting reporting = vm.getReporting();
      final Resource res = instance.eResource();
      final IResource irsrc = OsateResourceUtil.convertToIResource(res);
      final IMarker[] markersforanalysis = irsrc.findMarkers(markertype, true, IResource.DEPTH_INFINITE);
      final Function1<IMarker, Boolean> _function = new Function1<IMarker, Boolean>() {
        public Boolean apply(final IMarker m) {
          try {
            boolean _or = false;
            boolean _or_1 = false;
            boolean _equals = Objects.equal(reporting, null);
            if (_equals) {
              _or_1 = true;
            } else {
              boolean _equals_1 = Objects.equal(reporting, SupportedReporting.MARKER);
              _or_1 = _equals_1;
            }
            if (_or_1) {
              _or = true;
            } else {
              Object _attribute = m.getAttribute(IMarker.SEVERITY);
              boolean _equals_2 = Objects.equal(_attribute, Integer.valueOf(IMarker.SEVERITY_ERROR));
              _or = _equals_2;
            }
            return Boolean.valueOf(_or);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      final Iterable<IMarker> markers = IterableExtensions.<IMarker>filter(((Iterable<IMarker>)Conversions.doWrapArray(markersforanalysis)), _function);
      boolean _isEmpty = IterableExtensions.isEmpty(markers);
      if (_isEmpty) {
        return false;
      }
      Iterable<IMarker> finalmarkers = null;
      boolean _equals = Objects.equal(scope, SupportedScopes.SELF);
      if (_equals) {
        final Function1<IMarker, Boolean> _function_1 = new Function1<IMarker, Boolean>() {
          public Boolean apply(final IMarker m) {
            try {
              Object _attribute = m.getAttribute(AadlConstants.AADLURI);
              URI _uRI = EcoreUtil.getURI(instance);
              String _string = _uRI.toString();
              return Boolean.valueOf(Objects.equal(_attribute, _string));
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          }
        };
        Iterable<IMarker> _filter = IterableExtensions.<IMarker>filter(markers, _function_1);
        finalmarkers = _filter;
      } else {
        boolean _equals_1 = Objects.equal(scope, SupportedScopes.PARTS);
        if (_equals_1) {
          final Function1<IMarker, Boolean> _function_2 = new Function1<IMarker, Boolean>() {
            public Boolean apply(final IMarker m) {
              try {
                boolean _xblockexpression = false;
                {
                  Object _attribute = m.getAttribute(AadlConstants.AADLURI);
                  final URI targetURI = URI.createURI(((String) _attribute));
                  ResourceSet _resourceSet = res.getResourceSet();
                  final EObject target = _resourceSet.getEObject(targetURI, false);
                  final ComponentInstance parent = EcoreUtil2.<ComponentInstance>getContainerOfType(target, ComponentInstance.class);
                  URI _uRI = EcoreUtil.getURI(parent);
                  String _string = _uRI.toString();
                  URI _uRI_1 = EcoreUtil.getURI(instance);
                  String _string_1 = _uRI_1.toString();
                  _xblockexpression = Objects.equal(_string, _string_1);
                }
                return Boolean.valueOf(_xblockexpression);
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          };
          Iterable<IMarker> _filter_1 = IterableExtensions.<IMarker>filter(markers, _function_2);
          finalmarkers = _filter_1;
        } else {
          finalmarkers = markers;
        }
      }
      boolean _isEmpty_1 = IterableExtensions.isEmpty(finalmarkers);
      if (_isEmpty_1) {
        return false;
      }
      final Procedure1<IMarker> _function_3 = new Procedure1<IMarker>() {
        public void apply(final IMarker em) {
          AssureUtilExtension.addMarkerIssue(verificationActivityResult, instance, em);
        }
      };
      IterableExtensions.<IMarker>forEach(markers, _function_3);
      EList<ResultIssue> _issues = verificationActivityResult.getIssues();
      final Function1<ResultIssue, Boolean> _function_4 = new Function1<ResultIssue, Boolean>() {
        public Boolean apply(final ResultIssue ri) {
          ResultIssueType _issueType = ri.getIssueType();
          return Boolean.valueOf(Objects.equal(_issueType, ResultIssueType.ERROR));
        }
      };
      return IterableExtensions.<ResultIssue>exists(_issues, _function_4);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void addErrorDiagnostics(final VerificationResult verificationActivityResult, final InstanceObject instance, final String markertype) {
    final Resource res = instance.eResource();
    final EList<Resource.Diagnostic> diagnosticErrors = res.getErrors();
    final String mt = "org.osate.analysis.flows.FlowLatencyObjectMarker";
  }
  
  public void handleXtextIssues() {
  }
  
  public static ResultIssue addMarkerIssue(final VerificationResult vr, final EObject target, final IMarker marker) {
    try {
      ResultIssue _xblockexpression = null;
      {
        Object _attribute = marker.getAttribute(IMarker.MESSAGE);
        final String msg = ((String) _attribute);
        ResultIssue _switchResult = null;
        Object _attribute_1 = marker.getAttribute(IMarker.SEVERITY);
        boolean _matched = false;
        if (!_matched) {
          if (Objects.equal(_attribute_1, IMarker.SEVERITY_ERROR)) {
            _matched=true;
            _switchResult = AssureUtilExtension.addErrorIssue(vr, target, msg);
          }
        }
        if (!_matched) {
          if (Objects.equal(_attribute_1, IMarker.SEVERITY_WARNING)) {
            _matched=true;
            _switchResult = AssureUtilExtension.addWarningIssue(vr, target, msg);
          }
        }
        if (!_matched) {
          if (Objects.equal(_attribute_1, IMarker.SEVERITY_INFO)) {
            _matched=true;
            _switchResult = AssureUtilExtension.addInfoIssue(vr, target, msg);
          }
        }
        _xblockexpression = _switchResult;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static ResultIssue addErrorIssue(final VerificationResult vr, final EObject target, final String message) {
    return AssureUtilExtension.addErrorIssue(vr, target, message, null);
  }
  
  public static ResultIssue addErrorIssue(final VerificationResult vr, final EObject target, final String message, final String issueSource) {
    ResultIssue _xblockexpression = null;
    {
      final ResultIssue issue = AssureFactory.eINSTANCE.createResultIssue();
      issue.setMessage(message);
      issue.setIssueType(ResultIssueType.ERROR);
      issue.setExceptionType(issueSource);
      issue.setTarget(target);
      EList<ResultIssue> _issues = vr.getIssues();
      _issues.add(issue);
      _xblockexpression = issue;
    }
    return _xblockexpression;
  }
  
  public static ResultIssue addInfoIssue(final VerificationResult vr, final EObject target, final String message) {
    return AssureUtilExtension.addInfoIssue(vr, target, message, null);
  }
  
  public static ResultIssue addInfoIssue(final VerificationResult vr, final EObject target, final String message, final String issueSource) {
    ResultIssue _xblockexpression = null;
    {
      final ResultIssue issue = AssureFactory.eINSTANCE.createResultIssue();
      issue.setMessage(message);
      issue.setIssueType(ResultIssueType.INFO);
      issue.setExceptionType(issueSource);
      issue.setTarget(target);
      EList<ResultIssue> _issues = vr.getIssues();
      _issues.add(issue);
      _xblockexpression = issue;
    }
    return _xblockexpression;
  }
  
  public static ResultIssue addWarningIssue(final VerificationResult vr, final EObject target, final String message) {
    return AssureUtilExtension.addWarningIssue(vr, target, message, null);
  }
  
  public static ResultIssue addWarningIssue(final VerificationResult vr, final EObject target, final String message, final String issueSource) {
    ResultIssue _xblockexpression = null;
    {
      final ResultIssue issue = AssureFactory.eINSTANCE.createResultIssue();
      issue.setMessage(message);
      issue.setIssueType(ResultIssueType.WARNING);
      issue.setExceptionType(issueSource);
      issue.setTarget(target);
      EList<ResultIssue> _issues = vr.getIssues();
      _issues.add(issue);
      _xblockexpression = issue;
    }
    return _xblockexpression;
  }
  
  private final static ResoluteResultContentProvider resoluteContent = new ResoluteResultContentProvider();
  
  public static void doResoluteResults(final ResoluteResult rr, final ResultIssue ri) {
    final Object[] subrrs = AssureUtilExtension.resoluteContent.getChildren(rr);
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object subrr) {
        final com.rockwellcollins.atc.resolute.analysis.results.ClaimResult subclaim = ((com.rockwellcollins.atc.resolute.analysis.results.ClaimResult) subrr);
        ResultIssue _xifexpression = null;
        boolean _isValid = subclaim.isValid();
        if (_isValid) {
          EObject _location = subclaim.getLocation();
          String _text = subclaim.getText();
          _xifexpression = AssureUtilExtension.addSuccessIssue(ri, _location, _text);
        } else {
          EObject _location_1 = subclaim.getLocation();
          String _text_1 = subclaim.getText();
          _xifexpression = AssureUtilExtension.addErrorIssue(ri, _location_1, _text_1);
        }
        final ResultIssue subri = _xifexpression;
        AssureUtilExtension.doResoluteResults(subclaim, subri);
      }
    };
    IterableExtensions.<Object>forEach(((Iterable<Object>)Conversions.doWrapArray(subrrs)), _function);
  }
  
  public static ResultIssue addErrorIssue(final ResultIssue ri, final EObject target, final String message) {
    return AssureUtilExtension.addErrorIssue(ri, target, message, null);
  }
  
  public static ResultIssue addErrorIssue(final ResultIssue ri, final EObject target, final String message, final String issueSource) {
    ResultIssue _xblockexpression = null;
    {
      final ResultIssue issue = AssureFactory.eINSTANCE.createResultIssue();
      issue.setMessage(message);
      issue.setIssueType(ResultIssueType.ERROR);
      issue.setExceptionType(issueSource);
      if ((target instanceof FunctionDefinition)) {
        String _name = ((FunctionDefinition)target).getName();
        issue.setName(_name);
      } else {
        if ((!(target instanceof FailExpr))) {
          issue.setTarget(target);
        } else {
          if ((target instanceof FailExpr)) {
            int _length = message.length();
            boolean _greaterThan = (_length > 14);
            if (_greaterThan) {
              String _substring = message.substring(15);
              issue.setMessage(_substring);
            }
          }
        }
      }
      EList<ResultIssue> _issues = ri.getIssues();
      _issues.add(issue);
      _xblockexpression = issue;
    }
    return _xblockexpression;
  }
  
  public static ResultIssue addSuccessIssue(final ResultIssue ri, final EObject target, final String message) {
    return AssureUtilExtension.addSuccessIssue(ri, target, message, null);
  }
  
  public static ResultIssue addSuccessIssue(final ResultIssue ri, final EObject target, final String message, final String issueSource) {
    ResultIssue _xblockexpression = null;
    {
      final ResultIssue issue = AssureFactory.eINSTANCE.createResultIssue();
      issue.setMessage(message);
      issue.setIssueType(ResultIssueType.SUCCESS);
      issue.setExceptionType(issueSource);
      if ((target instanceof FunctionDefinition)) {
        String _name = ((FunctionDefinition)target).getName();
        issue.setName(_name);
      } else {
        if ((!(target instanceof FailExpr))) {
          issue.setTarget(target);
        } else {
          if ((target instanceof FailExpr)) {
            ri.setName("Fail");
            int _length = message.length();
            boolean _greaterThan = (_length > 14);
            if (_greaterThan) {
              String _substring = message.substring(15);
              ri.setMessage(_substring);
            } else {
              ri.setMessage(message);
            }
          }
        }
      }
      EList<ResultIssue> _issues = ri.getIssues();
      _issues.add(issue);
      _xblockexpression = issue;
    }
    return _xblockexpression;
  }
  
  public static int getTotalCount(final AssureResult ar) {
    int _unknownCount = ar.getUnknownCount();
    int _failCount = ar.getFailCount();
    int _plus = (_unknownCount + _failCount);
    int _successCount = ar.getSuccessCount();
    int _plus_1 = (_plus + _successCount);
    int _tbdCount = ar.getTbdCount();
    int _plus_2 = (_plus_1 + _tbdCount);
    int _failthenCount = ar.getFailthenCount();
    int _plus_3 = (_plus_2 + _failthenCount);
    int _andthenCount = ar.getAndthenCount();
    return (_plus_3 + _andthenCount);
  }
  
  public static boolean isSuccessful(final AssureResult ar) {
    boolean _and = false;
    boolean _and_1 = false;
    int _failCount = ar.getFailCount();
    boolean _equals = (_failCount == 0);
    if (!_equals) {
      _and_1 = false;
    } else {
      int _unknownCount = ar.getUnknownCount();
      boolean _equals_1 = (_unknownCount == 0);
      _and_1 = _equals_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      int _tbdCount = ar.getTbdCount();
      boolean _equals_2 = (_tbdCount == 0);
      _and = _equals_2;
    }
    return _and;
  }
  
  public static boolean hasFailedorError(final AssureResult ar) {
    boolean _or = false;
    int _failCount = ar.getFailCount();
    boolean _notEquals = (_failCount != 0);
    if (_notEquals) {
      _or = true;
    } else {
      int _unknownCount = ar.getUnknownCount();
      boolean _notEquals_1 = (_unknownCount != 0);
      _or = _notEquals_1;
    }
    return _or;
  }
  
  public static boolean isTBD(final AssureResult ar) {
    boolean _and = false;
    boolean _and_1 = false;
    int _failCount = ar.getFailCount();
    boolean _equals = (_failCount == 0);
    if (!_equals) {
      _and_1 = false;
    } else {
      int _unknownCount = ar.getUnknownCount();
      boolean _equals_1 = (_unknownCount == 0);
      _and_1 = _equals_1;
    }
    if (!_and_1) {
      _and = false;
    } else {
      int _tbdCount = ar.getTbdCount();
      boolean _greaterThan = (_tbdCount > 0);
      _and = _greaterThan;
    }
    return _and;
  }
  
  /**
   * true iff none of the elements have a fail or error
   */
  public static boolean success(final EList<VerificationResult> vel) {
    for (final VerificationResult ar : vel) {
      boolean _or = false;
      int _failCount = ar.getFailCount();
      boolean _notEquals = (_failCount != 0);
      if (_notEquals) {
        _or = true;
      } else {
        int _unknownCount = ar.getUnknownCount();
        boolean _notEquals_1 = (_unknownCount != 0);
        _or = _notEquals_1;
      }
      if (_or) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean isSuccessFul(final EList<VerificationExpr> vel) {
    for (final VerificationExpr ar : vel) {
      boolean _or = false;
      int _failCount = ar.getFailCount();
      boolean _notEquals = (_failCount != 0);
      if (_notEquals) {
        _or = true;
      } else {
        int _unknownCount = ar.getUnknownCount();
        boolean _notEquals_1 = (_unknownCount != 0);
        _or = _notEquals_1;
      }
      if (_or) {
        return false;
      }
    }
    return true;
  }
  
  /**
   * true iff at least one has a non-zero fail or error count
   */
  public static boolean hasFailedOrError(final EList<VerificationExpr> vel) {
    for (final VerificationExpr ar : vel) {
      boolean _or = false;
      int _failCount = ar.getFailCount();
      boolean _notEquals = (_failCount != 0);
      if (_notEquals) {
        _or = true;
      } else {
        int _unknownCount = ar.getUnknownCount();
        boolean _notEquals_1 = (_unknownCount != 0);
        _or = _notEquals_1;
      }
      if (_or) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean hasError(final EList<VerificationExpr> vel) {
    for (final VerificationExpr ar : vel) {
      int _unknownCount = ar.getUnknownCount();
      boolean _notEquals = (_unknownCount != 0);
      if (_notEquals) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean hasFailed(final EList<VerificationExpr> vel) {
    for (final VerificationExpr ar : vel) {
      int _failCount = ar.getFailCount();
      boolean _notEquals = (_failCount != 0);
      if (_notEquals) {
        return true;
      }
    }
    return false;
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
  
  public static String constructLabel(final EObject obj) {
    String _xblockexpression = null;
    {
      boolean _matched = false;
      if (!_matched) {
        if (obj instanceof SystemInstance) {
          _matched=true;
          ComponentImplementation _componentImplementation = ((SystemInstance)obj).getComponentImplementation();
          String _name = _componentImplementation.getName();
          String _plus = ("top " + _name);
          return (_plus + ": ");
        }
      }
      if (!_matched) {
        if (obj instanceof ComponentInstance) {
          _matched=true;
          ComponentCategory _category = ((ComponentInstance)obj).getCategory();
          String _name = _category.getName();
          String _plus = (_name + " ");
          String _name_1 = ((ComponentInstance)obj).getName();
          String _plus_1 = (_plus + _name_1);
          return (_plus_1 + ": ");
        }
      }
      if (!_matched) {
        if (obj instanceof NamedElement) {
          _matched=true;
          String _name = ((NamedElement)obj).getName();
          /* (_name + ": "); */
        }
      }
      _xblockexpression = "";
    }
    return _xblockexpression;
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
      if (ar instanceof AssuranceEvidence) {
        _matched=true;
        return ((AssuranceEvidence)ar).getName();
      }
    }
    if (!_matched) {
      if (ar instanceof ClaimResult) {
        _matched=true;
        return ((ClaimResult)ar).getName();
      }
    }
    if (!_matched) {
      if (ar instanceof VerificationResult) {
        _matched=true;
        return ((VerificationResult)ar).getName();
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
  
  public static boolean getHasRun(final String analysisID, final EObject target) {
    final Object value = AssureUtilExtension.hasRunRecord.get(analysisID);
    return Objects.equal(value, target);
  }
  
  public static void setHasRun(final String analysisID, final EObject target) {
    final Object x = AssureUtilExtension.hasRunRecord.put(analysisID, target);
  }
  
  public static void unsetHasRun(final String analysisID, final EObject target) {
    AssureUtilExtension.hasRunRecord.remove(analysisID);
  }
  
  public static void clearAllHasRunRecords() {
    AssureUtilExtension.hasRunRecord.clear();
  }
  
  /**
   * interface with Resolute
   * we initialize the sets on demand. See populate function.
   * We reset the sets and maps on an evelaution run.
   */
  private static SystemInstance systemroot;
  
  private static Map<String, SortedSet<NamedElement>> sets;
  
  private static FeatureToConnectionsMap featToConnsMap;
  
  public static FeatureToConnectionsMap getFeatToConnsMap() {
    boolean _equals = Objects.equal(AssureUtilExtension.featToConnsMap, null);
    if (_equals) {
      AssureUtilExtension.populateResoluteContext();
    }
    return AssureUtilExtension.featToConnsMap;
  }
  
  public static Map<String, SortedSet<NamedElement>> getSets() {
    boolean _equals = Objects.equal(AssureUtilExtension.sets, null);
    if (_equals) {
      AssureUtilExtension.populateResoluteContext();
    }
    return AssureUtilExtension.sets;
  }
  
  public static SystemInstance initializeResoluteContext(final SystemInstance si) {
    SystemInstance _xblockexpression = null;
    {
      AssureUtilExtension.sets = null;
      AssureUtilExtension.featToConnsMap = null;
      _xblockexpression = AssureUtilExtension.systemroot = si;
    }
    return _xblockexpression;
  }
  
  private static void populateResoluteContext() {
    HashMap<String, SortedSet<NamedElement>> _hashMap = new HashMap<String, SortedSet<NamedElement>>();
    AssureUtilExtension.sets = _hashMap;
    AssureUtilExtension.initializeSets(AssureUtilExtension.systemroot, AssureUtilExtension.sets);
    FeatureToConnectionsMap _featureToConnectionsMap = new FeatureToConnectionsMap(AssureUtilExtension.systemroot);
    AssureUtilExtension.featToConnsMap = _featureToConnectionsMap;
  }
  
  private static void initializeSets(final ComponentInstance ci, final Map<String, SortedSet<NamedElement>> sets) {
    boolean _equals = Objects.equal(ci, null);
    if (_equals) {
      return;
    }
    ComponentCategory _category = ci.getCategory();
    String _categoryName = AssureUtilExtension.getCategoryName(_category);
    AssureUtilExtension.addToSet(sets, _categoryName, ci);
    AssureUtilExtension.addToSet(sets, "component", ci);
    EList<ComponentInstance> _componentInstances = ci.getComponentInstances();
    for (final ComponentInstance sub : _componentInstances) {
      AssureUtilExtension.initializeSets(sub, sets);
    }
    EList<ConnectionInstance> _connectionInstances = ci.getConnectionInstances();
    for (final ConnectionInstance conn : _connectionInstances) {
      AssureUtilExtension.addToSet(sets, "connection", conn);
    }
  }
  
  private static String getCategoryName(final ComponentCategory category) {
    BaseType _baseType = new BaseType(category);
    return _baseType.toString();
  }
  
  private static void addToSet(final Map<String, SortedSet<NamedElement>> sets, final String name, final NamedElement ne) {
    SortedSet<NamedElement> set = sets.get(name);
    boolean _equals = Objects.equal(set, null);
    if (_equals) {
      NamedElementComparator _namedElementComparator = new NamedElementComparator();
      TreeSet<NamedElement> _treeSet = new TreeSet<NamedElement>(_namedElementComparator);
      set = _treeSet;
      sets.put(name, set);
    }
    set.add(ne);
  }
  
  /**
   * this method resets the execution state of all verification activities to TBD
   */
  public static void resetToTBD(final AssuranceEvidence root) {
    final List<VerificationResult> vrlist = EcoreUtil2.<VerificationResult>eAllOfType(root, VerificationResult.class);
    final Procedure1<VerificationResult> _function = new Procedure1<VerificationResult>() {
      public void apply(final VerificationResult vr) {
        vr.setResultState(VerificationResultState.TBD);
        vr.setExecutionState(VerificationExecutionState.TODO);
        EList<ResultIssue> _issues = vr.getIssues();
        _issues.clear();
      }
    };
    IterableExtensions.<VerificationResult>forEach(vrlist, _function);
  }
  
  /**
   * Helper methods
   */
  private static void resetCounts(final AssureResult result) {
    result.setFailCount(0);
    result.setSuccessCount(0);
    result.setUnknownCount(0);
    result.setAndthenCount(0);
    result.setFailthenCount(0);
    result.setTbdCount(0);
  }
  
  /**
   * update the counts to reflect existing own status
   * Used by complete process and set result
   */
  private static AssureResult addOwnResultStateToCount(final AssureResult ar) {
    AssureResult _xblockexpression = null;
    {
      if ((ar instanceof VerificationResult)) {
        VerificationResultState _resultState = ((VerificationResult)ar).getResultState();
        if (_resultState != null) {
          switch (_resultState) {
            case SUCCESS:
              int _successCount = ((VerificationResult)ar).getSuccessCount();
              int _plus = (_successCount + 1);
              ((VerificationResult)ar).setSuccessCount(_plus);
              break;
            case FAIL:
              int _failCount = ((VerificationResult)ar).getFailCount();
              int _plus_1 = (_failCount + 1);
              ((VerificationResult)ar).setFailCount(_plus_1);
              break;
            case UNKNOWN:
              int _unknownCount = ((VerificationResult)ar).getUnknownCount();
              int _plus_2 = (_unknownCount + 1);
              ((VerificationResult)ar).setUnknownCount(_plus_2);
              break;
            case TBD:
              int _tbdCount = ((VerificationResult)ar).getTbdCount();
              int _plus_3 = (_tbdCount + 1);
              ((VerificationResult)ar).setTbdCount(_plus_3);
              break;
            default:
              break;
          }
        }
      }
      _xblockexpression = ar;
    }
    return _xblockexpression;
  }
  
  /**
   * add all but the total count to the result object
   * This method is used in the process and set result methods
   */
  private static void addTo(final AssureResult subresult, final AssureResult result) {
    int _failCount = result.getFailCount();
    int _failCount_1 = subresult.getFailCount();
    int _plus = (_failCount + _failCount_1);
    result.setFailCount(_plus);
    int _successCount = result.getSuccessCount();
    int _successCount_1 = subresult.getSuccessCount();
    int _plus_1 = (_successCount + _successCount_1);
    result.setSuccessCount(_plus_1);
    int _unknownCount = result.getUnknownCount();
    int _unknownCount_1 = subresult.getUnknownCount();
    int _plus_2 = (_unknownCount + _unknownCount_1);
    result.setUnknownCount(_plus_2);
    int _andthenCount = result.getAndthenCount();
    int _andthenCount_1 = subresult.getAndthenCount();
    int _plus_3 = (_andthenCount + _andthenCount_1);
    result.setAndthenCount(_plus_3);
    int _failthenCount = result.getFailthenCount();
    int _failthenCount_1 = subresult.getFailthenCount();
    int _plus_4 = (_failthenCount + _failthenCount_1);
    result.setFailthenCount(_plus_4);
    int _tbdCount = result.getTbdCount();
    int _tbdCount_1 = subresult.getTbdCount();
    int _plus_5 = (_tbdCount + _tbdCount_1);
    result.setTbdCount(_plus_5);
  }
  
  /**
   * recompute and add the counts of the parts list to the result
   */
  private static void recomputeAllCounts(final AssureResult result, final List<? extends AssureResult> parts) {
    final Procedure1<AssureResult> _function = new Procedure1<AssureResult>() {
      public void apply(final AssureResult e) {
        AssureResult _recomputeAllCounts = AssureUtilExtension.recomputeAllCounts(e);
        AssureUtilExtension.addTo(_recomputeAllCounts, result);
      }
    };
    IterableExtensions.forEach(parts, _function);
  }
  
  public static AssuranceEvidence recomputeAllCounts(final AssuranceEvidence caseResult) {
    AssuranceEvidence _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(caseResult);
      EList<ClaimResult> _claimResult = caseResult.getClaimResult();
      AssureUtilExtension.recomputeAllCounts(caseResult, _claimResult);
      EList<AssuranceEvidence> _subAssuranceEvidence = caseResult.getSubAssuranceEvidence();
      AssureUtilExtension.recomputeAllCounts(caseResult, _subAssuranceEvidence);
      _xblockexpression = caseResult;
    }
    return _xblockexpression;
  }
  
  private static ClaimResult recomputeAllCounts(final ClaimResult claimResult) {
    ClaimResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(claimResult);
      EList<VerificationExpr> _verificationActivityResult = claimResult.getVerificationActivityResult();
      AssureUtilExtension.recomputeAllCounts(claimResult, _verificationActivityResult);
      EList<ClaimResult> _subClaimResult = claimResult.getSubClaimResult();
      AssureUtilExtension.recomputeAllCounts(claimResult, _subClaimResult);
      _xblockexpression = claimResult;
    }
    return _xblockexpression;
  }
  
  private static VerificationActivityResult recomputeAllCounts(final VerificationActivityResult vaResult) {
    VerificationActivityResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<VerificationResult> _validationResult = vaResult.getValidationResult();
      AssureUtilExtension.recomputeAllCounts(vaResult, _validationResult);
      EList<VerificationResult> _preconditionResult = vaResult.getPreconditionResult();
      AssureUtilExtension.recomputeAllCounts(vaResult, _preconditionResult);
      AssureUtilExtension.addOwnResultStateToCount(vaResult);
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  private static FailThenResult recomputeAllCounts(final FailThenResult vaResult) {
    FailThenResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      AssureUtilExtension.recomputeAllCounts(vaResult, _first);
      EList<VerificationExpr> _first_1 = vaResult.getFirst();
      boolean _isSuccessFul = AssureUtilExtension.isSuccessFul(_first_1);
      if (_isSuccessFul) {
        AssureUtilExtension.recordNoFailThen(vaResult);
      } else {
        AssureUtilExtension.recordFailThen(vaResult);
        EList<VerificationExpr> _second = vaResult.getSecond();
        AssureUtilExtension.recomputeAllCounts(vaResult, _second);
      }
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  private static AndThenResult recomputeAllCounts(final AndThenResult vaResult) {
    AndThenResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      AssureUtilExtension.recomputeAllCounts(vaResult, _first);
      EList<VerificationExpr> _first_1 = vaResult.getFirst();
      boolean _isSuccessFul = AssureUtilExtension.isSuccessFul(_first_1);
      if (_isSuccessFul) {
        AssureUtilExtension.recordSkip(vaResult);
        EList<VerificationExpr> _second = vaResult.getSecond();
        AssureUtilExtension.recomputeAllCounts(vaResult, _second);
      } else {
        AssureUtilExtension.recordNoSkip(vaResult);
      }
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  private static ValidationResult recomputeAllCounts(final ValidationResult validationResult) {
    ValidationResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(validationResult);
      AssureUtilExtension.addOwnResultStateToCount(validationResult);
      _xblockexpression = validationResult;
    }
    return _xblockexpression;
  }
  
  private static PreconditionResult recomputeAllCounts(final PreconditionResult preconditionResult) {
    PreconditionResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(preconditionResult);
      AssureUtilExtension.addOwnResultStateToCount(preconditionResult);
      _xblockexpression = preconditionResult;
    }
    return _xblockexpression;
  }
  
  private static AssureResult recomputeAllCounts(final AssureResult assureResult) {
    AssureResult _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (assureResult instanceof AssuranceEvidence) {
        _matched=true;
        _switchResult = AssureUtilExtension.recomputeAllCounts(((AssuranceEvidence)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof ClaimResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.recomputeAllCounts(((ClaimResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof ValidationResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.recomputeAllCounts(((ValidationResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof PreconditionResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.recomputeAllCounts(((PreconditionResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof VerificationActivityResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.recomputeAllCounts(((VerificationActivityResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof FailThenResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.recomputeAllCounts(((FailThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AndThenResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.recomputeAllCounts(((AndThenResult)assureResult));
      }
    }
    return _switchResult;
  }
  
  /**
   * methods to incrementally set the state of a verification activity and propagate the state change
   * up the hierarchy
   */
  public static void setToSuccess(final VerificationResult verificationActivityResult) {
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.SUCCESS);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToSuccess(final VerificationResult verificationActivityResult, final List<ResultIssue> rl) {
    EList<ResultIssue> _issues = verificationActivityResult.getIssues();
    _issues.addAll(rl);
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.SUCCESS);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToTBD(final VerificationResult verificationActivityResult) {
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.TBD);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToFail(final VerificationResult verificationActivityResult) {
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.FAIL);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToFail(final VerificationResult verificationActivityResult, final String message) {
    AssureUtilExtension.addErrorIssue(verificationActivityResult, null, message, null);
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.FAIL);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToFail(final VerificationResult verificationActivityResult, final List<ResultIssue> rl) {
    EList<ResultIssue> _issues = verificationActivityResult.getIssues();
    _issues.addAll(rl);
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.FAIL);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToFail(final VerificationResult verificationActivityResult, final EObject target, final String message) {
    AssureUtilExtension.addErrorIssue(verificationActivityResult, target, message, null);
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.FAIL);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToFail(final VerificationResult verificationActivityResult, final Throwable e) {
    String _message = e.getMessage();
    Class<? extends Throwable> _class = e.getClass();
    String _name = _class.getName();
    AssureUtilExtension.addErrorIssue(verificationActivityResult, null, _message, _name);
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.FAIL);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToError(final VerificationResult verificationActivityResult, final Throwable e) {
    String _message = e.getMessage();
    Class<? extends Throwable> _class = e.getClass();
    String _name = _class.getName();
    AssureUtilExtension.addErrorIssue(verificationActivityResult, null, _message, _name);
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.FAIL);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToError(final VerificationResult verificationActivityResult, final String message) {
    AssureUtilExtension.addErrorIssue(verificationActivityResult, null, message, null);
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.FAIL);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  /**
   * the next methods update the counts for FailThen and AndThen
   * returns true if change of state
   */
  public static void recordFailThen(final FailThenResult result) {
    boolean _isDidFail = result.isDidFail();
    if (_isDidFail) {
    } else {
      result.setDidFail(true);
      int _failthenCount = result.getFailthenCount();
      int _plus = (_failthenCount + 1);
      result.setFailthenCount(_plus);
      AssureUtilExtension.propagateCountChangeUp(result);
    }
  }
  
  /**
   * the next methods update the counts for FailThen and AndThen
   * returns true if change of state
   */
  public static void recordNoFailThen(final FailThenResult result) {
    boolean _isDidFail = result.isDidFail();
    if (_isDidFail) {
      result.setDidFail(false);
      int _failthenCount = result.getFailthenCount();
      int _minus = (_failthenCount - 1);
      result.setFailthenCount(_minus);
      AssureUtilExtension.propagateCountChangeUp(result);
    } else {
    }
  }
  
  /**
   * the next methods update the counts for FailThen and AndThen
   * returns true if change of state
   */
  public static void recordSkip(final AndThenResult result) {
    boolean _isDidAndThenFail = result.isDidAndThenFail();
    if (_isDidAndThenFail) {
    } else {
      result.setDidAndThenFail(true);
      int _andthenCount = result.getAndthenCount();
      int _plus = (_andthenCount + 1);
      result.setAndthenCount(_plus);
      AssureUtilExtension.propagateCountChangeUp(result);
    }
  }
  
  /**
   * the next methods update the counts for FailThen and AndThen
   * returns true if change of state
   */
  public static void recordNoSkip(final AndThenResult result) {
    boolean _isDidAndThenFail = result.isDidAndThenFail();
    if (_isDidAndThenFail) {
      result.setDidAndThenFail(false);
      int _andthenCount = result.getAndthenCount();
      int _minus = (_andthenCount - 1);
      result.setAndthenCount(_minus);
      AssureUtilExtension.propagateCountChangeUp(result);
    } else {
    }
  }
  
  /**
   * set the status and update the counts
   * true if state changed
   */
  private static boolean updateOwnResultState(final VerificationResult ar, final VerificationResultState newState) {
    boolean _xblockexpression = false;
    {
      VerificationResultState _resultState = ar.getResultState();
      boolean _equals = Objects.equal(_resultState, newState);
      if (_equals) {
        return false;
      }
      VerificationResultState _resultState_1 = ar.getResultState();
      boolean _equals_1 = Objects.equal(_resultState_1, VerificationResultState.TBD);
      if (_equals_1) {
        int _tbdCount = ar.getTbdCount();
        int _minus = (_tbdCount - 1);
        ar.setTbdCount(_minus);
        ar.setExecutionState(VerificationExecutionState.COMPLETED);
        if (newState != null) {
          switch (newState) {
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
            case UNKNOWN:
              int _unknownCount = ar.getUnknownCount();
              int _plus_2 = (_unknownCount + 1);
              ar.setUnknownCount(_plus_2);
              break;
            case TBD:
              break;
            default:
              break;
          }
        }
      } else {
        boolean _equals_2 = Objects.equal(newState, VerificationResultState.TBD);
        if (_equals_2) {
          int _tbdCount_1 = ar.getTbdCount();
          int _plus_3 = (_tbdCount_1 + 1);
          ar.setTbdCount(_plus_3);
          ar.setExecutionState(VerificationExecutionState.TODO);
          VerificationResultState _resultState_2 = ar.getResultState();
          if (_resultState_2 != null) {
            switch (_resultState_2) {
              case SUCCESS:
                int _successCount_1 = ar.getSuccessCount();
                int _minus_1 = (_successCount_1 - 1);
                ar.setSuccessCount(_minus_1);
                break;
              case FAIL:
                int _failCount_1 = ar.getFailCount();
                int _minus_2 = (_failCount_1 - 1);
                ar.setFailCount(_minus_2);
                break;
              case UNKNOWN:
                int _unknownCount_1 = ar.getUnknownCount();
                int _minus_3 = (_unknownCount_1 - 1);
                ar.setUnknownCount(_minus_3);
                break;
              case TBD:
                int _tbdCount_2 = ar.getTbdCount();
                int _minus_4 = (_tbdCount_2 - 1);
                ar.setTbdCount(_minus_4);
                break;
              default:
                break;
            }
          }
        } else {
        }
      }
      ar.setResultState(newState);
      _xblockexpression = true;
    }
    return _xblockexpression;
  }
  
  /**
   * Given the state (and count) change to ar, propagate the counts up the hierarchy
   */
  private static void propagateCountChangeUp(final AssureResult ar) {
    EObject parent = ar.eContainer();
    while (((!Objects.equal(parent, null)) && (parent instanceof AssureResult))) {
      {
        final AssureResult parentResult = ((AssureResult) parent);
        AssureUtilExtension.addAllSubCounts(parentResult);
        EObject _eContainer = parent.eContainer();
        parent = _eContainer;
      }
    }
  }
  
  /**
   * recompute the result count from the part list counts without recursing
   */
  private static AssuranceEvidence addAllSubCounts(final AssuranceEvidence caseResult) {
    AssuranceEvidence _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(caseResult);
      EList<ClaimResult> _claimResult = caseResult.getClaimResult();
      final Procedure1<ClaimResult> _function = new Procedure1<ClaimResult>() {
        public void apply(final ClaimResult e) {
          AssureUtilExtension.addTo(e, caseResult);
        }
      };
      IterableExtensions.<ClaimResult>forEach(_claimResult, _function);
      EList<AssuranceEvidence> _subAssuranceEvidence = caseResult.getSubAssuranceEvidence();
      final Procedure1<AssuranceEvidence> _function_1 = new Procedure1<AssuranceEvidence>() {
        public void apply(final AssuranceEvidence e) {
          AssureUtilExtension.addTo(e, caseResult);
        }
      };
      IterableExtensions.<AssuranceEvidence>forEach(_subAssuranceEvidence, _function_1);
      _xblockexpression = caseResult;
    }
    return _xblockexpression;
  }
  
  private static ClaimResult addAllSubCounts(final ClaimResult claimResult) {
    ClaimResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(claimResult);
      EList<VerificationExpr> _verificationActivityResult = claimResult.getVerificationActivityResult();
      final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
        public void apply(final VerificationExpr e) {
          AssureUtilExtension.addTo(e, claimResult);
        }
      };
      IterableExtensions.<VerificationExpr>forEach(_verificationActivityResult, _function);
      EList<ClaimResult> _subClaimResult = claimResult.getSubClaimResult();
      final Procedure1<ClaimResult> _function_1 = new Procedure1<ClaimResult>() {
        public void apply(final ClaimResult e) {
          AssureUtilExtension.addTo(e, claimResult);
        }
      };
      IterableExtensions.<ClaimResult>forEach(_subClaimResult, _function_1);
      _xblockexpression = claimResult;
    }
    return _xblockexpression;
  }
  
  private static VerificationActivityResult addAllSubCounts(final VerificationActivityResult vaResult) {
    VerificationActivityResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<VerificationResult> _validationResult = vaResult.getValidationResult();
      final Procedure1<VerificationResult> _function = new Procedure1<VerificationResult>() {
        public void apply(final VerificationResult e) {
          AssureUtilExtension.addTo(e, vaResult);
        }
      };
      IterableExtensions.<VerificationResult>forEach(_validationResult, _function);
      EList<VerificationResult> _preconditionResult = vaResult.getPreconditionResult();
      final Procedure1<VerificationResult> _function_1 = new Procedure1<VerificationResult>() {
        public void apply(final VerificationResult e) {
          AssureUtilExtension.addTo(e, vaResult);
        }
      };
      IterableExtensions.<VerificationResult>forEach(_preconditionResult, _function_1);
      AssureUtilExtension.addOwnResultStateToCount(vaResult);
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  private static FailThenResult addAllSubCounts(final FailThenResult vaResult) {
    FailThenResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
        public void apply(final VerificationExpr e) {
          AssureUtilExtension.addTo(e, vaResult);
        }
      };
      IterableExtensions.<VerificationExpr>forEach(_first, _function);
      EList<VerificationExpr> _first_1 = vaResult.getFirst();
      boolean _isSuccessFul = AssureUtilExtension.isSuccessFul(_first_1);
      if (_isSuccessFul) {
        AssureUtilExtension.recordNoFailThen(vaResult);
      } else {
        AssureUtilExtension.recordFailThen(vaResult);
        EList<VerificationExpr> _second = vaResult.getSecond();
        final Procedure1<VerificationExpr> _function_1 = new Procedure1<VerificationExpr>() {
          public void apply(final VerificationExpr e) {
            AssureUtilExtension.addTo(e, vaResult);
          }
        };
        IterableExtensions.<VerificationExpr>forEach(_second, _function_1);
      }
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  private static AndThenResult addAllSubCounts(final AndThenResult vaResult) {
    AndThenResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<VerificationExpr> _first = vaResult.getFirst();
      final Procedure1<VerificationExpr> _function = new Procedure1<VerificationExpr>() {
        public void apply(final VerificationExpr e) {
          AssureUtilExtension.addTo(e, vaResult);
        }
      };
      IterableExtensions.<VerificationExpr>forEach(_first, _function);
      EList<VerificationExpr> _first_1 = vaResult.getFirst();
      boolean _isSuccessFul = AssureUtilExtension.isSuccessFul(_first_1);
      if (_isSuccessFul) {
        AssureUtilExtension.recordSkip(vaResult);
        EList<VerificationExpr> _second = vaResult.getSecond();
        final Procedure1<VerificationExpr> _function_1 = new Procedure1<VerificationExpr>() {
          public void apply(final VerificationExpr e) {
            AssureUtilExtension.addTo(e, vaResult);
          }
        };
        IterableExtensions.<VerificationExpr>forEach(_second, _function_1);
      } else {
        AssureUtilExtension.recordNoSkip(vaResult);
      }
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  private static ValidationResult addAllSubCounts(final ValidationResult validationResult) {
    ValidationResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(validationResult);
      AssureUtilExtension.addOwnResultStateToCount(validationResult);
      _xblockexpression = validationResult;
    }
    return _xblockexpression;
  }
  
  private static PreconditionResult addAllSubCounts(final PreconditionResult preconditionResult) {
    PreconditionResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(preconditionResult);
      AssureUtilExtension.addOwnResultStateToCount(preconditionResult);
      _xblockexpression = preconditionResult;
    }
    return _xblockexpression;
  }
  
  private static AssureResult addAllSubCounts(final AssureResult assureResult) {
    AssureResult _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (assureResult instanceof AssuranceEvidence) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllSubCounts(((AssuranceEvidence)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof ClaimResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllSubCounts(((ClaimResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof ValidationResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllSubCounts(((ValidationResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof PreconditionResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllSubCounts(((PreconditionResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof VerificationActivityResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllSubCounts(((VerificationActivityResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof FailThenResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllSubCounts(((FailThenResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof AndThenResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllSubCounts(((AndThenResult)assureResult));
      }
    }
    return _switchResult;
  }
  
  /**
   * methods to retrieve messages and status
   * Note that the message could be in the Result object or if not present we want to get it from the
   * object the result object is derived from.
   */
  public static String toTextLabel(final VerificationResultState vs) {
    if (vs != null) {
      switch (vs) {
        case SUCCESS:
          return "[S]";
        case FAIL:
          return "[F]";
        case UNKNOWN:
          return "[U]";
        case TBD:
          return "[T]";
        default:
          break;
      }
    }
    return null;
  }
  
  public static String constructLabel(final AssureResult ar) {
    String _xblockexpression = null;
    {
      boolean _matched = false;
      if (!_matched) {
        if (ar instanceof AssuranceEvidence) {
          _matched=true;
          return ((AssuranceEvidence)ar).getName();
        }
      }
      if (!_matched) {
        if (ar instanceof ClaimResult) {
          _matched=true;
          String _elvis = null;
          Requirement _target = ((ClaimResult)ar).getTarget();
          String _title = null;
          if (_target!=null) {
            _title=_target.getTitle();
          }
          if (_title != null) {
            _elvis = _title;
          } else {
            String _name = ((ClaimResult)ar).getName();
            _elvis = _name;
          }
          return _elvis;
        }
      }
      if (!_matched) {
        if (ar instanceof ValidationResult) {
          _matched=true;
          String _elvis = null;
          VerificationValidation _target = ((ValidationResult)ar).getTarget();
          String _title = null;
          if (_target!=null) {
            _title=_target.getTitle();
          }
          if (_title != null) {
            _elvis = _title;
          } else {
            String _name = ((ValidationResult)ar).getName();
            _elvis = _name;
          }
          return _elvis;
        }
      }
      if (!_matched) {
        if (ar instanceof PreconditionResult) {
          _matched=true;
          String _elvis = null;
          VerificationPrecondition _target = ((PreconditionResult)ar).getTarget();
          String _title = null;
          if (_target!=null) {
            _title=_target.getTitle();
          }
          if (_title != null) {
            _elvis = _title;
          } else {
            String _name = ((PreconditionResult)ar).getName();
            _elvis = _name;
          }
          return _elvis;
        }
      }
      if (!_matched) {
        if (ar instanceof VerificationActivityResult) {
          _matched=true;
          VerificationActivity _target = ((VerificationActivityResult)ar).getTarget();
          String _title = null;
          if (_target!=null) {
            _title=_target.getTitle();
          }
          final String vatitle = _title;
          String _name = ((VerificationActivityResult)ar).getName();
          String _plus = (_name + ":");
          String _elvis = null;
          if (vatitle != null) {
            _elvis = vatitle;
          } else {
            _elvis = "";
          }
          return (_plus + _elvis);
        }
      }
      _xblockexpression = "";
    }
    return _xblockexpression;
  }
  
  public static String constructMessage(final VerificationActivityResult vr) {
    String _xblockexpression = null;
    {
      String _message = vr.getMessage();
      boolean _notEquals = (!Objects.equal(_message, null));
      if (_notEquals) {
        return vr.getMessage();
      }
      final VerificationActivity va = vr.getTarget();
      Description _description = va.getDescription();
      boolean _notEquals_1 = (!Objects.equal(_description, null));
      if (_notEquals_1) {
        Description _description_1 = va.getDescription();
        InstanceObject _claimSubject = AssureUtilExtension.getClaimSubject(vr);
        return CommonUtilExtension.toText(_description_1, _claimSubject);
      }
      _xblockexpression = "";
    }
    return _xblockexpression;
  }
  
  public static String constructMessage(final AssuranceEvidence ce) {
    String _message = ce.getMessage();
    boolean _notEquals = (!Objects.equal(_message, null));
    if (_notEquals) {
      return ce.getMessage();
    }
    Classifier _target = ce.getTarget();
    String _name = _target.getName();
    return ("for " + _name);
  }
  
  public static String constructMessage(final ClaimResult cr) {
    String _xblockexpression = null;
    {
      String _message = cr.getMessage();
      boolean _notEquals = (!Objects.equal(_message, null));
      if (_notEquals) {
        return cr.getMessage();
      }
      final Requirement r = cr.getTarget();
      Description _description = r.getDescription();
      boolean _notEquals_1 = (!Objects.equal(_description, null));
      if (_notEquals_1) {
        Description _description_1 = r.getDescription();
        InstanceObject _claimSubject = AssureUtilExtension.getClaimSubject(cr);
        return CommonUtilExtension.toText(_description_1, _claimSubject);
      }
      _xblockexpression = "";
    }
    return _xblockexpression;
  }
  
  public static String constructMessage(final ValidationResult cr) {
    String _xblockexpression = null;
    {
      String _message = cr.getMessage();
      boolean _notEquals = (!Objects.equal(_message, null));
      if (_notEquals) {
        return cr.getMessage();
      }
      final VerificationValidation r = cr.getTarget();
      Description _description = r.getDescription();
      boolean _notEquals_1 = (!Objects.equal(_description, null));
      if (_notEquals_1) {
        Description _description_1 = r.getDescription();
        InstanceObject _claimSubject = AssureUtilExtension.getClaimSubject(cr);
        return CommonUtilExtension.toText(_description_1, _claimSubject);
      }
      _xblockexpression = "";
    }
    return _xblockexpression;
  }
  
  public static String constructMessage(final PreconditionResult cr) {
    String _xblockexpression = null;
    {
      String _message = cr.getMessage();
      boolean _notEquals = (!Objects.equal(_message, null));
      if (_notEquals) {
        return cr.getMessage();
      }
      final VerificationPrecondition r = cr.getTarget();
      Description _description = r.getDescription();
      boolean _notEquals_1 = (!Objects.equal(_description, null));
      if (_notEquals_1) {
        Description _description_1 = r.getDescription();
        InstanceObject _claimSubject = AssureUtilExtension.getClaimSubject(cr);
        return CommonUtilExtension.toText(_description_1, _claimSubject);
      }
      _xblockexpression = "";
    }
    return _xblockexpression;
  }
  
  public static String constructMessage(final ResultIssue ri) {
    String _xblockexpression = null;
    {
      String _message = ri.getMessage();
      boolean _notEquals = (!Objects.equal(_message, null));
      if (_notEquals) {
        String _message_1 = ri.getMessage();
        String _xifexpression = null;
        String _exceptionType = ri.getExceptionType();
        boolean _notEquals_1 = (!Objects.equal(_exceptionType, null));
        if (_notEquals_1) {
          String _exceptionType_1 = ri.getExceptionType();
          String _plus = (" [" + _exceptionType_1);
          _xifexpression = (_plus + "]");
        } else {
          _xifexpression = "";
        }
        return (_message_1 + _xifexpression);
      }
      String _exceptionType_2 = ri.getExceptionType();
      boolean _notEquals_2 = (!Objects.equal(_exceptionType_2, null));
      if (_notEquals_2) {
        return ri.getExceptionType();
      }
      _xblockexpression = "";
    }
    return _xblockexpression;
  }
  
  public static String assureResultCounts(final AssureResult ele) {
    int _successCount = ele.getSuccessCount();
    String _plus = ("(S" + Integer.valueOf(_successCount));
    String _plus_1 = (_plus + " F");
    int _failCount = ele.getFailCount();
    String _plus_2 = (_plus_1 + Integer.valueOf(_failCount));
    String _plus_3 = (_plus_2 + " E");
    int _unknownCount = ele.getUnknownCount();
    String _plus_4 = (_plus_3 + Integer.valueOf(_unknownCount));
    String _plus_5 = (_plus_4 + " T");
    int _tbdCount = ele.getTbdCount();
    String _plus_6 = (_plus_5 + Integer.valueOf(_tbdCount));
    return (_plus_6 + ")");
  }
}
