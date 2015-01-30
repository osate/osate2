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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.assure.assure.AndThenResult;
import org.osate.assure.assure.AssumptionResult;
import org.osate.assure.assure.AssureFactory;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.CaseResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.FailThenResult;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.ResultIssue;
import org.osate.assure.assure.ResultIssueType;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExecutionState;
import org.osate.assure.assure.VerificationExpr;
import org.osate.assure.assure.VerificationResultState;
import org.osate.verify.verify.RefExpr;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;

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
    CaseResult _enclosingCaseResult = AssureUtilExtension.getEnclosingCaseResult(assureObject);
    InstanceObject _instance = null;
    if (_enclosingCaseResult!=null) {
      _instance=_enclosingCaseResult.getInstance();
    }
    return _instance;
  }
  
  public static String getMethodName(final VerificationActivityResult vr) {
    String _xblockexpression = null;
    {
      VerificationActivity _target = vr.getTarget();
      VerificationMethod _method = _target.getMethod();
      final String methodpath = _method.getMethodPath();
      final int x = methodpath.lastIndexOf(".");
      if ((x != (-1))) {
        final String methodName = methodpath.substring(x);
        return methodName;
      }
      _xblockexpression = methodpath;
    }
    return _xblockexpression;
  }
  
  /**
   * methods to process results from verificaiton methods
   */
  public static boolean addErrorMarkers(final VerificationActivityResult verificationActivityResult, final InstanceObject instance, final String markertype) {
    try {
      final Resource res = instance.eResource();
      final IResource irsrc = OsateResourceUtil.convertToIResource(res);
      final IMarker[] markersforanalysis = irsrc.findMarkers(markertype, true, IResource.DEPTH_INFINITE);
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
      boolean _isEmpty = IterableExtensions.isEmpty(markers);
      if (_isEmpty) {
        return false;
      }
      final Procedure1<IMarker> _function_1 = new Procedure1<IMarker>() {
        public void apply(final IMarker em) {
          try {
            Object _attribute = em.getAttribute(IMarker.MESSAGE);
            AssureUtilExtension.addErrorIssue(verificationActivityResult, instance, ((String) _attribute));
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      IterableExtensions.<IMarker>forEach(markers, _function_1);
      return true;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static boolean addAllErrorMarkers(final VerificationActivityResult verificationActivityResult, final InstanceObject instance, final String markertype) {
    try {
      final Resource res = instance.eResource();
      final IResource irsrc = OsateResourceUtil.convertToIResource(res);
      final IMarker[] markersforanalysis = irsrc.findMarkers(markertype, true, IResource.DEPTH_INFINITE);
      final Function1<IMarker, Boolean> _function = new Function1<IMarker, Boolean>() {
        public Boolean apply(final IMarker m) {
          try {
            Object _attribute = m.getAttribute(IMarker.SEVERITY);
            return Boolean.valueOf(Objects.equal(_attribute, Integer.valueOf(IMarker.SEVERITY_ERROR)));
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
      final Procedure1<IMarker> _function_1 = new Procedure1<IMarker>() {
        public void apply(final IMarker em) {
          try {
            Object _attribute = em.getAttribute(IMarker.MESSAGE);
            AssureUtilExtension.addErrorIssue(verificationActivityResult, instance, ((String) _attribute));
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      IterableExtensions.<IMarker>forEach(markers, _function_1);
      return true;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void addErrorDiagnostics(final VerificationActivityResult verificationActivityResult, final InstanceObject instance, final String markertype) {
    final Resource res = instance.eResource();
    final EList<Resource.Diagnostic> diagnosticErrors = res.getErrors();
    final String mt = "org.osate.analysis.flows.FlowLatencyObjectMarker";
  }
  
  public void handleXtextIssues() {
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
  
  public static ResultIssue addErrorIssue(final VerificationActivityResult vr, final EObject target, final String message) {
    return AssureUtilExtension.addErrorIssue(vr, target, message, null);
  }
  
  public static ResultIssue addErrorIssue(final VerificationActivityResult vr, final EObject target, final String message, final String issueSource) {
    ResultIssue _xblockexpression = null;
    {
      final ResultIssue issue = AssureFactory.eINSTANCE.createResultIssue();
      AssureUtilExtension.updateOwnResultState(vr, VerificationResultState.FAIL);
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
              String _message = issue.getMessage();
              issue.setName(_message);
            }
          }
        }
      }
      EList<ResultIssue> _issues = vr.getIssues();
      _issues.add(issue);
      _xblockexpression = issue;
    }
    return _xblockexpression;
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
              String _message = issue.getMessage();
              issue.setName(_message);
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
        }
      }
      EList<ResultIssue> _issues = ri.getIssues();
      _issues.add(issue);
      _xblockexpression = issue;
    }
    return _xblockexpression;
  }
  
  public static ResultIssue addWarningIssue(final ResultIssue ri, final EObject target, final String message) {
    ResultIssue _xblockexpression = null;
    {
      final ResultIssue issue = AssureFactory.eINSTANCE.createResultIssue();
      issue.setMessage(message);
      issue.setIssueType(ResultIssueType.WARNING);
      if ((target instanceof FunctionDefinition)) {
        String _name = ((FunctionDefinition)target).getName();
        issue.setName(_name);
      } else {
        if ((!(target instanceof FailExpr))) {
          issue.setTarget(target);
        }
      }
      EList<ResultIssue> _issues = ri.getIssues();
      _issues.add(issue);
      _xblockexpression = issue;
    }
    return _xblockexpression;
  }
  
  public static int getTotalCount(final AssureResult ar) {
    int _errorCount = ar.getErrorCount();
    int _failCount = ar.getFailCount();
    int _plus = (_errorCount + _failCount);
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
      int _errorCount = ar.getErrorCount();
      boolean _equals_1 = (_errorCount == 0);
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
      int _errorCount = ar.getErrorCount();
      boolean _notEquals_1 = (_errorCount != 0);
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
      int _errorCount = ar.getErrorCount();
      boolean _equals_1 = (_errorCount == 0);
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
  public static boolean isSuccessFul(final EList<VerificationExpr> vel) {
    for (final VerificationExpr ar : vel) {
      boolean _or = false;
      int _failCount = ar.getFailCount();
      boolean _notEquals = (_failCount != 0);
      if (_notEquals) {
        _or = true;
      } else {
        int _errorCount = ar.getErrorCount();
        boolean _notEquals_1 = (_errorCount != 0);
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
        int _errorCount = ar.getErrorCount();
        boolean _notEquals_1 = (_errorCount != 0);
        _or = _notEquals_1;
      }
      if (_or) {
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
  
  private static Map<String, SortedSet<NamedElement>> sets;
  
  private static FeatureToConnectionsMap featToConnsMap;
  
  private static SystemInstance systemroot;
  
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
  public static void resetToTBD(final CaseResult root) {
    final List<VerificationActivityResult> vrlist = EcoreUtil2.<VerificationActivityResult>eAllOfType(root, VerificationActivityResult.class);
    final Procedure1<VerificationActivityResult> _function = new Procedure1<VerificationActivityResult>() {
      public void apply(final VerificationActivityResult vr) {
        vr.setResultState(VerificationResultState.TBD);
        vr.setExecutionState(VerificationExecutionState.TODO);
        EList<ResultIssue> _issues = vr.getIssues();
        _issues.clear();
      }
    };
    IterableExtensions.<VerificationActivityResult>forEach(vrlist, _function);
  }
  
  /**
   * Helper methods
   */
  private static void resetCounts(final AssureResult result) {
    result.setFailCount(0);
    result.setSuccessCount(0);
    result.setErrorCount(0);
    result.setAndthenCount(0);
    result.setFailthenCount(0);
    result.setTbdCount(0);
  }
  
  /**
   * update the counts to reflect existing own status
   * Used by complete process and set result
   */
  private static VerificationActivityResult addOwnResultStateToCount(final VerificationActivityResult ar) {
    VerificationActivityResult _xblockexpression = null;
    {
      VerificationResultState _resultState = ar.getResultState();
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
            int _tbdCount = ar.getTbdCount();
            int _plus_3 = (_tbdCount + 1);
            ar.setTbdCount(_plus_3);
            break;
          default:
            break;
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
    int _errorCount = result.getErrorCount();
    int _errorCount_1 = subresult.getErrorCount();
    int _plus_2 = (_errorCount + _errorCount_1);
    result.setErrorCount(_plus_2);
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
  
  public static CaseResult recomputeAllCounts(final CaseResult caseResult) {
    CaseResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(caseResult);
      EList<ClaimResult> _claimResult = caseResult.getClaimResult();
      AssureUtilExtension.recomputeAllCounts(caseResult, _claimResult);
      EList<CaseResult> _subCaseResult = caseResult.getSubCaseResult();
      AssureUtilExtension.recomputeAllCounts(caseResult, _subCaseResult);
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
      EList<AssumptionResult> _assumptionResult = vaResult.getAssumptionResult();
      AssureUtilExtension.recomputeAllCounts(vaResult, _assumptionResult);
      EList<PreconditionResult> _preconditionResult = vaResult.getPreconditionResult();
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
      boolean _hasFailedOrError = AssureUtilExtension.hasFailedOrError(_first_1);
      if (_hasFailedOrError) {
        AssureUtilExtension.recordFailThen(vaResult);
        EList<VerificationExpr> _second = vaResult.getSecond();
        AssureUtilExtension.recomputeAllCounts(vaResult, _second);
      } else {
        AssureUtilExtension.recordNoFailThen(vaResult);
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
  
  private static AssumptionResult recomputeAllCounts(final AssumptionResult assumptionResult) {
    AssumptionResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(assumptionResult);
      EList<VerificationExpr> _verificationActivityResult = assumptionResult.getVerificationActivityResult();
      AssureUtilExtension.recomputeAllCounts(assumptionResult, _verificationActivityResult);
      _xblockexpression = assumptionResult;
    }
    return _xblockexpression;
  }
  
  private static PreconditionResult recomputeAllCounts(final PreconditionResult preconditionResult) {
    PreconditionResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(preconditionResult);
      EList<VerificationExpr> _verificationActivityResult = preconditionResult.getVerificationActivityResult();
      AssureUtilExtension.recomputeAllCounts(preconditionResult, _verificationActivityResult);
      _xblockexpression = preconditionResult;
    }
    return _xblockexpression;
  }
  
  private static AssureResult recomputeAllCounts(final AssureResult assureResult) {
    AssureResult _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (assureResult instanceof CaseResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.recomputeAllCounts(((CaseResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof ClaimResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.recomputeAllCounts(((ClaimResult)assureResult));
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
    if (!_matched) {
      if (assureResult instanceof AssumptionResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.recomputeAllCounts(((AssumptionResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof PreconditionResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.recomputeAllCounts(((PreconditionResult)assureResult));
      }
    }
    return _switchResult;
  }
  
  /**
   * methods to incrementally set the state of a verification activity and propagate the state change
   * up the hierarchy
   */
  public static void setToSuccess(final VerificationActivityResult verificationActivityResult) {
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.SUCCESS);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToSuccess(final VerificationActivityResult verificationActivityResult, final List<ResultIssue> rl) {
    EList<ResultIssue> _issues = verificationActivityResult.getIssues();
    _issues.addAll(rl);
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.SUCCESS);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToTBD(final VerificationActivityResult verificationActivityResult) {
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.TBD);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToFail(final VerificationActivityResult verificationActivityResult, final String message) {
    AssureUtilExtension.addErrorIssue(verificationActivityResult, null, message, null);
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.FAIL);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToFail(final VerificationActivityResult verificationActivityResult, final List<ResultIssue> rl) {
    EList<ResultIssue> _issues = verificationActivityResult.getIssues();
    _issues.addAll(rl);
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.FAIL);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToFail(final VerificationActivityResult verificationActivityResult, final EObject target, final String message) {
    AssureUtilExtension.addErrorIssue(verificationActivityResult, target, message, null);
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.FAIL);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToFail(final VerificationActivityResult verificationActivityResult, final Throwable e) {
    String _message = e.getMessage();
    Class<? extends Throwable> _class = e.getClass();
    String _name = _class.getName();
    AssureUtilExtension.addErrorIssue(verificationActivityResult, null, _message, _name);
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.FAIL);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToError(final VerificationActivityResult verificationActivityResult, final Throwable e) {
    String _message = e.getMessage();
    Class<? extends Throwable> _class = e.getClass();
    String _name = _class.getName();
    AssureUtilExtension.addErrorIssue(verificationActivityResult, null, _message, _name);
    boolean _updateOwnResultState = AssureUtilExtension.updateOwnResultState(verificationActivityResult, VerificationResultState.FAIL);
    if (_updateOwnResultState) {
      AssureUtilExtension.propagateCountChangeUp(verificationActivityResult);
    }
  }
  
  public static void setToError(final VerificationActivityResult verificationActivityResult, final String message) {
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
    boolean _isDidFailThenFail = result.isDidFailThenFail();
    if (_isDidFailThenFail) {
    } else {
      result.setDidFailThenFail(true);
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
    boolean _isDidFailThenFail = result.isDidFailThenFail();
    if (_isDidFailThenFail) {
      result.setDidFailThenFail(false);
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
  private static boolean updateOwnResultState(final VerificationActivityResult ar, final VerificationResultState newState) {
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
              case ERROR:
                int _errorCount_1 = ar.getErrorCount();
                int _minus_3 = (_errorCount_1 - 1);
                ar.setErrorCount(_minus_3);
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
  private static void addAllSubCounts(final AssureResult result, final List<? extends AssureResult> parts) {
    final Procedure1<AssureResult> _function = new Procedure1<AssureResult>() {
      public void apply(final AssureResult e) {
        AssureUtilExtension.addTo(e, result);
      }
    };
    IterableExtensions.forEach(parts, _function);
  }
  
  private static CaseResult addAllSubCounts(final CaseResult caseResult) {
    CaseResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(caseResult);
      EList<ClaimResult> _claimResult = caseResult.getClaimResult();
      AssureUtilExtension.addAllSubCounts(caseResult, _claimResult);
      EList<CaseResult> _subCaseResult = caseResult.getSubCaseResult();
      AssureUtilExtension.addAllSubCounts(caseResult, _subCaseResult);
      _xblockexpression = caseResult;
    }
    return _xblockexpression;
  }
  
  private static ClaimResult addAllSubCounts(final ClaimResult claimResult) {
    ClaimResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(claimResult);
      EList<VerificationExpr> _verificationActivityResult = claimResult.getVerificationActivityResult();
      AssureUtilExtension.addAllSubCounts(claimResult, _verificationActivityResult);
      EList<ClaimResult> _subClaimResult = claimResult.getSubClaimResult();
      AssureUtilExtension.addAllSubCounts(claimResult, _subClaimResult);
      _xblockexpression = claimResult;
    }
    return _xblockexpression;
  }
  
  private static VerificationActivityResult addAllSubCounts(final VerificationActivityResult vaResult) {
    VerificationActivityResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(vaResult);
      EList<AssumptionResult> _assumptionResult = vaResult.getAssumptionResult();
      AssureUtilExtension.addAllSubCounts(vaResult, _assumptionResult);
      EList<PreconditionResult> _preconditionResult = vaResult.getPreconditionResult();
      AssureUtilExtension.addAllSubCounts(vaResult, _preconditionResult);
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
      AssureUtilExtension.addAllSubCounts(vaResult, _first);
      EList<VerificationExpr> _first_1 = vaResult.getFirst();
      boolean _hasFailedOrError = AssureUtilExtension.hasFailedOrError(_first_1);
      if (_hasFailedOrError) {
        AssureUtilExtension.recordFailThen(vaResult);
        EList<VerificationExpr> _second = vaResult.getSecond();
        AssureUtilExtension.addAllSubCounts(vaResult, _second);
      } else {
        AssureUtilExtension.recordNoFailThen(vaResult);
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
      AssureUtilExtension.addAllSubCounts(vaResult, _first);
      EList<VerificationExpr> _first_1 = vaResult.getFirst();
      boolean _isSuccessFul = AssureUtilExtension.isSuccessFul(_first_1);
      if (_isSuccessFul) {
        AssureUtilExtension.recordSkip(vaResult);
        EList<VerificationExpr> _second = vaResult.getSecond();
        AssureUtilExtension.addAllSubCounts(vaResult, _second);
      } else {
        AssureUtilExtension.recordNoSkip(vaResult);
      }
      _xblockexpression = vaResult;
    }
    return _xblockexpression;
  }
  
  private static AssumptionResult addAllSubCounts(final AssumptionResult assumptionResult) {
    AssumptionResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(assumptionResult);
      EList<VerificationExpr> _verificationActivityResult = assumptionResult.getVerificationActivityResult();
      AssureUtilExtension.addAllSubCounts(assumptionResult, _verificationActivityResult);
      _xblockexpression = assumptionResult;
    }
    return _xblockexpression;
  }
  
  private static PreconditionResult addAllSubCounts(final PreconditionResult preconditionResult) {
    PreconditionResult _xblockexpression = null;
    {
      AssureUtilExtension.resetCounts(preconditionResult);
      EList<VerificationExpr> _verificationActivityResult = preconditionResult.getVerificationActivityResult();
      AssureUtilExtension.addAllSubCounts(preconditionResult, _verificationActivityResult);
      _xblockexpression = preconditionResult;
    }
    return _xblockexpression;
  }
  
  private static AssureResult addAllSubCounts(final AssureResult assureResult) {
    AssureResult _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (assureResult instanceof CaseResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllSubCounts(((CaseResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof ClaimResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllSubCounts(((ClaimResult)assureResult));
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
    if (!_matched) {
      if (assureResult instanceof AssumptionResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllSubCounts(((AssumptionResult)assureResult));
      }
    }
    if (!_matched) {
      if (assureResult instanceof PreconditionResult) {
        _matched=true;
        _switchResult = AssureUtilExtension.addAllSubCounts(((PreconditionResult)assureResult));
      }
    }
    return _switchResult;
  }
}
