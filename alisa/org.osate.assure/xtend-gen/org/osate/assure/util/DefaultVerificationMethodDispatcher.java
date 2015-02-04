package org.osate.assure.util;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.rockwellcollins.atc.resolute.analysis.execution.EvaluationContext;
import com.rockwellcollins.atc.resolute.analysis.execution.FeatureToConnectionsMap;
import com.rockwellcollins.atc.resolute.analysis.execution.ResoluteInterpreter;
import com.rockwellcollins.atc.resolute.analysis.results.ClaimResult;
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
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider;
import org.osate.assure.assure.AssureFactory;
import org.osate.assure.assure.ResultIssue;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.util.AssureUtilExtension;
import org.osate.assure.util.IVerificationMethodDispatcher;
import org.osate.verify.verify.SupportedTypes;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

@SuppressWarnings("all")
public class DefaultVerificationMethodDispatcher implements IVerificationMethodDispatcher {
  public Object dispatchVerificationMethod(final String methodPath, final VerificationActivityResult vr) {
    InstanceObject _claimSubject = AssureUtilExtension.getClaimSubject(vr);
    String _qualifiedName = _claimSubject.getQualifiedName();
    String _plus = ((("Dispatching " + methodPath) + " on ") + _qualifiedName);
    InputOutput.<String>println(_plus);
    return null;
  }
  
  /**
   * who needs to understand the method types?
   * the runVerificationMethod dispatcher may do different catch methods
   * The dispatchVerificationMethod may know from its label what type it is.
   */
  public void runVerificationMethod(final VerificationActivityResult verificationActivityResult) {
    try {
      VerificationActivity _target = verificationActivityResult.getTarget();
      final VerificationMethod method = _target.getMethod();
      final String methodpath = method.getMethodPath();
      SupportedTypes _methodType = method.getMethodType();
      if (_methodType != null) {
        switch (_methodType) {
          case SINGLEPREDICATE:
            try {
              final Object res = this.dispatchVerificationMethod(methodpath, verificationActivityResult);
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
                AssureUtilExtension.setToFail(verificationActivityResult, "");
              } else {
                AssureUtilExtension.setToSuccess(verificationActivityResult);
              }
            } catch (final Throwable _t) {
              if (_t instanceof AssertionError) {
                final AssertionError e = (AssertionError)_t;
                AssureUtilExtension.setToFail(verificationActivityResult, e);
              } else if (_t instanceof ThreadDeath) {
                final ThreadDeath e_1 = (ThreadDeath)_t;
                throw e_1;
              } else if (_t instanceof Throwable) {
                final Throwable e_2 = (Throwable)_t;
                AssureUtilExtension.setToError(verificationActivityResult, e_2);
              } else {
                throw Exceptions.sneakyThrow(_t);
              }
            }
            break;
          case MULTIMARKER:
            try {
              final Object res_1 = this.dispatchVerificationMethod(methodpath, verificationActivityResult);
              boolean _and_2 = false;
              boolean _and_3 = false;
              boolean _notEquals_2 = (!Objects.equal(res_1, null));
              if (!_notEquals_2) {
                _and_3 = false;
              } else {
                _and_3 = (res_1 instanceof Boolean);
              }
              if (!_and_3) {
                _and_2 = false;
              } else {
                boolean _notEquals_3 = (!Objects.equal(res_1, Boolean.valueOf(true)));
                _and_2 = _notEquals_3;
              }
              if (_and_2) {
                AssureUtilExtension.setToFail(verificationActivityResult, "");
              } else {
                AssureUtilExtension.setToSuccess(verificationActivityResult);
              }
            } catch (final Throwable _t_1) {
              if (_t_1 instanceof ThreadDeath) {
                final ThreadDeath e_3 = (ThreadDeath)_t_1;
                throw e_3;
              } else if (_t_1 instanceof Throwable) {
                final Throwable e_4 = (Throwable)_t_1;
                AssureUtilExtension.setToError(verificationActivityResult, e_4);
              } else {
                throw Exceptions.sneakyThrow(_t_1);
              }
            }
            break;
          case RESOLUTEPROVE:
            InstanceObject _caseSubject = AssureUtilExtension.getCaseSubject(verificationActivityResult);
            final SystemInstance si = _caseSubject.getSystemInstance();
            Map<String, SortedSet<NamedElement>> _sets = AssureUtilExtension.getSets();
            FeatureToConnectionsMap _featToConnsMap = AssureUtilExtension.getFeatToConnsMap();
            final EvaluationContext context = new EvaluationContext(si, _sets, _featToConnsMap);
            final ResoluteInterpreter interpreter = new ResoluteInterpreter(context);
            final ProveStatement provecall = this.createWrapperProveCall(verificationActivityResult);
            boolean _equals = Objects.equal(provecall, null);
            if (_equals) {
              String _methodName = AssureUtilExtension.getMethodName(verificationActivityResult);
              String _plus = ("Could not find Resolute Function \'" + _methodName);
              String _plus_1 = (_plus + "\'");
              AssureUtilExtension.setToError(verificationActivityResult, _plus_1);
              return;
            }
            ResoluteResult _evaluateProveStatement = interpreter.evaluateProveStatement(provecall);
            final ClaimResult proof = ((ClaimResult) _evaluateProveStatement);
            boolean _isValid = proof.isValid();
            if (_isValid) {
              AssureUtilExtension.setToSuccess(verificationActivityResult);
            } else {
              final ResultIssue proveri = AssureFactory.eINSTANCE.createResultIssue();
              AssureUtilExtension.doResoluteResults(proof, proveri);
              EList<ResultIssue> _issues = proveri.getIssues();
              AssureUtilExtension.setToFail(verificationActivityResult, _issues);
            }
            break;
          default:
            break;
        }
      }
      Resource _eResource = verificationActivityResult.eResource();
      _eResource.save(null);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public ProveStatement createWrapperProveCall(final VerificationActivityResult vr) {
    ProveStatement _xblockexpression = null;
    {
      final String resoluteFunction = AssureUtilExtension.getMethodName(vr);
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
    final Iterable<IEObjectDescription> foundlist = scope.getGlobalEObjectDescriptions(context, _functionDefinition, null);
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
