package org.osate.assure.evaluator;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.FeatureToConnectionsMap;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter;
import com.rockwellcollins.atc.resolute.analysis.results.ResoluteResult;
import com.rockwellcollins.atc.resolute.resolute.Expr;
import com.rockwellcollins.atc.resolute.resolute.FnCallExpr;
import com.rockwellcollins.atc.resolute.resolute.FunctionDefinition;
import com.rockwellcollins.atc.resolute.resolute.ProveStatement;
import com.rockwellcollins.atc.resolute.resolute.ResoluteFactory;
import com.rockwellcollins.atc.resolute.resolute.ResolutePackage;
import com.rockwellcollins.atc.resolute.resolute.ThisExpr;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider;
import org.osate.assure.assure.AndThenResult;
import org.osate.assure.assure.AssuranceEvidence;
import org.osate.assure.assure.AssureFactory;
import org.osate.assure.assure.AssureResult;
import org.osate.assure.assure.ClaimResult;
import org.osate.assure.assure.FailThenResult;
import org.osate.assure.assure.PreconditionResult;
import org.osate.assure.assure.ResultIssue;
import org.osate.assure.assure.ValidationResult;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.assure.VerificationExpr;
import org.osate.assure.assure.VerificationResult;
import org.osate.assure.evaluator.IAssureProcessor;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.results.results.ResultReport;
import org.osate.verify.util.IVerificationMethodDispatcher;
import org.osate.verify.verify.SupportedReporting;
import org.osate.verify.verify.SupportedTypes;
import org.osate.verify.verify.VerificationMethod;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

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
      this.runVerificationMethod(vaResult);
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
      boolean _hasUnknown = AssureUtilExtension.hasUnknown(_first_1);
      _and = _hasUnknown;
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
        boolean _hasFailedOrUnknown = AssureUtilExtension.hasFailedOrUnknown(_first_3);
        if (_hasFailedOrUnknown) {
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
    this.runVerificationMethod(assumptionResult);
  }
  
  public void doProcess(final PreconditionResult preconditionResult) {
    this.runVerificationMethod(preconditionResult);
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
  
  /**
   * who needs to understand the method types?
   * the runVerificationMethod dispatcher may do different catch methods
   * The dispatchVerificationMethod may know from its label what type it is.
   * The methods are expected to return boolean for predicate,
   * null or bool for analysis with results in marker/diagnostic, or the result report object
   */
  public void runVerificationMethod(final VerificationResult verificationResult) {
    try {
      final VerificationMethod method = AssureUtilExtension.getMethod(verificationResult);
      Object res = null;
      final InstanceObject target = AssureUtilExtension.getClaimSubject(verificationResult);
      try {
        SupportedTypes _methodType = method.getMethodType();
        if (_methodType != null) {
          switch (_methodType) {
            case PREDICATE:
              Object _dispatchVerificationMethod = this.dispatcher.dispatchVerificationMethod(method, target);
              res = _dispatchVerificationMethod;
              boolean _and = false;
              boolean _and_1 = false;
              boolean _notEquals = (!Objects.equal(res, null));
              if (!_notEquals) {
                _and_1 = false;
              } else {
                _and_1 = (res instanceof Boolean);
              }
              if (!_and_1) {
                _and = false;
              } else {
                boolean _notEquals_1 = (!Objects.equal(res, Boolean.valueOf(true)));
                _and = _notEquals_1;
              }
              if (_and) {
                AssureUtilExtension.setToFail(verificationResult, "");
              } else {
                AssureUtilExtension.setToSuccess(verificationResult);
              }
              break;
            case ANALYSIS:
              Object _dispatchVerificationMethod_1 = this.dispatcher.dispatchVerificationMethod(method, target);
              res = _dispatchVerificationMethod_1;
              SupportedReporting _reporting = method.getReporting();
              boolean _matched = false;
              if (!_matched) {
                if (Objects.equal(_reporting, SupportedReporting.ASSERTEXCEPTION)) {
                  _matched=true;
                }
              }
              if (!_matched) {
                if (Objects.equal(_reporting, SupportedReporting.DIAGNOSTICS)) {
                  _matched=true;
                }
              }
              if (!_matched) {
                if (Objects.equal(_reporting, null)) {
                  _matched=true;
                }
                if (!_matched) {
                  if (Objects.equal(_reporting, SupportedReporting.ERRORMARKER)) {
                    _matched=true;
                  }
                }
                if (!_matched) {
                  if (Objects.equal(_reporting, SupportedReporting.MARKER)) {
                    _matched=true;
                  }
                }
                if (_matched) {
                  if ((res instanceof String)) {
                    final InstanceObject subject = AssureUtilExtension.getCaseSubject(verificationResult);
                    final boolean errors = AssureUtilExtension.addMarkers(verificationResult, subject, ((String)res), method);
                    if (errors) {
                      AssureUtilExtension.setToFail(verificationResult);
                    } else {
                      AssureUtilExtension.setToSuccess(verificationResult);
                    }
                  } else {
                    AssureUtilExtension.setToFail(verificationResult, "Analysis return type is not a string of MarkerType");
                  }
                }
              }
              if (!_matched) {
                if (Objects.equal(_reporting, SupportedReporting.RESULTREPORT)) {
                  _matched=true;
                  if ((res instanceof ResultReport)) {
                    verificationResult.setResultReport(((ResultReport)res));
                  } else {
                    AssureUtilExtension.setToFail(verificationResult, "No result report from analysis");
                  }
                }
              }
              break;
            case COMPUTE:
              Object _dispatchVerificationMethod_2 = this.dispatcher.dispatchVerificationMethod(method, target);
              res = _dispatchVerificationMethod_2;
              String _string = this.toString(res);
              String _plus = ("Need to compare analysis result " + _string);
              AssureUtilExtension.addInfoIssue(verificationResult, verificationResult, _plus);
              break;
            case RESOLUTEPROVE:
              InstanceObject _caseSubject = AssureUtilExtension.getCaseSubject(verificationResult);
              final SystemInstance si = _caseSubject.getSystemInstance();
              Map<String, SortedSet<NamedElement>> _sets = AssureUtilExtension.getSets();
              FeatureToConnectionsMap _featToConnsMap = AssureUtilExtension.getFeatToConnsMap();
              final EvaluationContext context = new EvaluationContext(si, _sets, _featToConnsMap);
              final ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
              final ProveStatement provecall = this.createWrapperProveCall(verificationResult);
              boolean _equals = Objects.equal(provecall, null);
              if (_equals) {
                VerificationMethod _method = AssureUtilExtension.getMethod(verificationResult);
                String _name = _method.getName();
                String _plus_1 = ("Could not find Resolute Function " + _name);
                AssureUtilExtension.setToError(verificationResult, _plus_1);
              } else {
                ResoluteResult _evaluateProveStatement = interpreter.evaluateProveStatement(provecall);
                final com.rockwellcollins.atc.resolute.analysis.results.ClaimResult proof = ((com.rockwellcollins.atc.resolute.analysis.results.ClaimResult) _evaluateProveStatement);
                boolean _isValid = proof.isValid();
                if (_isValid) {
                  AssureUtilExtension.setToSuccess(verificationResult);
                } else {
                  final ResultIssue proveri = AssureFactory.eINSTANCE.createResultIssue();
                  AssureUtilExtension.doResoluteResults(proof, proveri);
                  EList<ResultIssue> _issues = proveri.getIssues();
                  AssureUtilExtension.setToFail(verificationResult, _issues);
                }
              }
              break;
            case MANUAL:
              break;
            default:
              break;
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof AssertionError) {
          final AssertionError e = (AssertionError)_t;
          AssureUtilExtension.setToFail(verificationResult, e);
        } else if (_t instanceof ThreadDeath) {
          final ThreadDeath e_1 = (ThreadDeath)_t;
          throw e_1;
        } else if (_t instanceof Throwable) {
          final Throwable e_2 = (Throwable)_t;
          AssureUtilExtension.setToError(verificationResult, e_2);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      Resource _eResource = verificationResult.eResource();
      _eResource.save(null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ProveStatement createWrapperProveCall(final VerificationResult vr) {
    ProveStatement _xblockexpression = null;
    {
      VerificationMethod _method = AssureUtilExtension.getMethod(vr);
      final String resoluteFunction = _method.getMethodPath();
      final ResoluteFactory factory = ResoluteFactory.eINSTANCE;
      final FunctionDefinition found = this.resolveResoluteFunction(vr, resoluteFunction);
      boolean _equals = Objects.equal(found, null);
      if (_equals) {
        return null;
      }
      final FnCallExpr call = factory.createFnCallExpr();
      call.setFn(found);
      EList<Expr> _args = call.getArgs();
      ThisExpr _createThisExpr = factory.createThisExpr();
      _args.add(_createThisExpr);
      final ProveStatement prove = factory.createProveStatement();
      prove.setExpr(call);
      _xblockexpression = prove;
    }
    return _xblockexpression;
  }
  
  public String toString(final Object o) {
    String _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (o instanceof Integer) {
        _matched=true;
        _switchResult = ((Integer)o).toString();
      }
    }
    if (!_matched) {
      if (o instanceof Long) {
        _matched=true;
        _switchResult = ((Long)o).toString();
      }
    }
    if (!_matched) {
      if (o instanceof Double) {
        _matched=true;
        _switchResult = ((Double)o).toString();
      }
    }
    if (!_matched) {
      if (o instanceof String) {
        _matched=true;
        _switchResult = ((String)o);
      }
    }
    if (!_matched) {
      _switchResult = "an object";
    }
    return _switchResult;
  }
  
  @Inject
  public IGlobalScopeProvider scopeProvider;
  
  public FunctionDefinition resolveResoluteFunction(final EObject context, final String resoluteFunctionName) {
    EClass _functionDefinition = ResolutePackage.eINSTANCE.getFunctionDefinition();
    final EObject res = this.getNamedElementByType(context, resoluteFunctionName, _functionDefinition);
    return ((FunctionDefinition) res);
  }
  
  public EObject getNamedElementByType(final EObject context, final String name, final EClass eclass) {
    final Iterable<IEObjectDescription> allObjectTypes = EMFIndexRetrieval.getAllEObjectsOfTypeInWorkspace(context, eclass);
    Resource _eResource = context.eResource();
    URI _uRI = _eResource.getURI();
    final String contextProject = _uRI.segment(1);
    final List<String> visibleProjects = this.getVisibleProjects(contextProject);
    for (final IEObjectDescription eod : allObjectTypes) {
      QualifiedName _name = eod.getName();
      String _lastSegment = _name.getLastSegment();
      boolean _equalsIgnoreCase = _lastSegment.equalsIgnoreCase(name);
      if (_equalsIgnoreCase) {
        EObject res = eod.getEObjectOrProxy();
        Resource _eResource_1 = context.eResource();
        ResourceSet _resourceSet = _eResource_1.getResourceSet();
        EObject _resolve = EcoreUtil.resolve(res, _resourceSet);
        res = _resolve;
        boolean _isNull = Aadl2Util.isNull(res);
        boolean _not = (!_isNull);
        if (_not) {
          Resource _eResource_2 = res.eResource();
          final URI linkUri = _eResource_2.getURI();
          final String linkProject = linkUri.segment(1);
          boolean _contains = visibleProjects.contains(linkProject);
          if (_contains) {
            return res;
          }
        }
      }
    }
    return null;
  }
  
  public List<String> getVisibleProjects(final String contextProjectName) {
    final List<String> result = new ArrayList<String>();
    result.add(contextProjectName);
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    final IWorkspaceRoot root = _workspace.getRoot();
    String _decode = URI.decode(contextProjectName);
    final IProject contextProject = root.getProject(_decode);
    boolean _or = false;
    boolean _or_1 = false;
    boolean _exists = contextProject.exists();
    boolean _not = (!_exists);
    if (_not) {
      _or_1 = true;
    } else {
      boolean _isAccessible = contextProject.isAccessible();
      boolean _not_1 = (!_isAccessible);
      _or_1 = _not_1;
    }
    if (_or_1) {
      _or = true;
    } else {
      boolean _isOpen = contextProject.isOpen();
      boolean _not_2 = (!_isOpen);
      _or = _not_2;
    }
    if (_or) {
      return result;
    }
    try {
      final IProjectDescription description = contextProject.getDescription();
      IProject[] _referencedProjects = description.getReferencedProjects();
      for (final IProject referencedProject : _referencedProjects) {
        String _name = referencedProject.getName();
        String _encodeSegment = URI.encodeSegment(_name, false);
        result.add(_encodeSegment);
      }
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException ex = (CoreException)_t;
        ex.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return result;
  }
  
  public FunctionDefinition findResoluteFunction(final EObject context, final String resoluteFunctionName) {
    final CommonGlobalScopeProvider scope = ((CommonGlobalScopeProvider) this.scopeProvider);
    EClass _functionDefinition = ResolutePackage.eINSTANCE.getFunctionDefinition();
    final Iterable<IEObjectDescription> foundlist = scope.getGlobalEObjectDescriptions(context, _functionDefinition, 
      null);
    final Function1<IEObjectDescription, Boolean> _function = new Function1<IEObjectDescription, Boolean>() {
      public Boolean apply(final IEObjectDescription eod) {
        QualifiedName _name = eod.getName();
        String _lastSegment = _name.getLastSegment();
        return Boolean.valueOf(_lastSegment.equalsIgnoreCase(resoluteFunctionName));
      }
    };
    final Iterable<IEObjectDescription> filteredlist = IterableExtensions.<IEObjectDescription>filter(foundlist, _function);
    int _length = ((Object[])Conversions.unwrapArray(filteredlist, Object.class)).length;
    boolean _equals = (_length == 0);
    if (_equals) {
      return null;
    }
    IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(filteredlist);
    return ((FunctionDefinition) _head);
  }
}
