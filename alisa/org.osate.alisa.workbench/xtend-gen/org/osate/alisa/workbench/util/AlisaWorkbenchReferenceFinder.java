package org.osate.alisa.workbench.util;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.alisa.common.scoping.CommonGlobalScopeProvider;
import org.osate.reqspec.reqSpec.ReqSpecPackage;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.verify.verify.VerificationLibrary;
import org.osate.verify.verify.VerifyPackage;

@SuppressWarnings("all")
public class AlisaWorkbenchReferenceFinder {
  @Inject
  private IGlobalScopeProvider scopeProvider;
  
  @Inject
  private IReferenceFinder reffinder;
  
  @Extension
  private CommonGlobalScopeProvider cgsp = ((CommonGlobalScopeProvider) this.scopeProvider);
  
  public Iterable<Requirement> getRequirements(final ComponentInstance io) {
    Iterable<Requirement> _xblockexpression = null;
    {
      ComponentClassifier _componentClassifier = io.getComponentClassifier();
      EClass _requirement = ReqSpecPackage.eINSTANCE.getRequirement();
      final Iterable<IEObjectDescription> x = this.cgsp.getGlobalEObjectDescriptions(_componentClassifier, _requirement, null);
      final Function1<IEObjectDescription, Requirement> _function = new Function1<IEObjectDescription, Requirement>() {
        public Requirement apply(final IEObjectDescription it) {
          EObject _eObjectOrProxy = it.getEObjectOrProxy();
          return ((Requirement) _eObjectOrProxy);
        }
      };
      final Iterable<Requirement> y = IterableExtensions.<IEObjectDescription, Requirement>map(x, _function);
      for (final Requirement r : y) {
        {
          final Classifier cl1 = r.getTarget();
          final ComponentClassifier t2 = ((ComponentInstance) io).getComponentClassifier();
          final String c1n = cl1.getQualifiedName();
          final String c2n = t2.getQualifiedName();
          InputOutput.<String>println(((c1n + " ") + c2n));
        }
      }
      final Function1<Requirement, Boolean> _function_1 = new Function1<Requirement, Boolean>() {
        public Boolean apply(final Requirement req) {
          Classifier _target = ((Requirement) req).getTarget();
          ComponentClassifier _componentClassifier = ((ComponentInstance) io).getComponentClassifier();
          return Boolean.valueOf(AlisaWorkbenchReferenceFinder.this.isSame(((ComponentClassifier) _target), _componentClassifier));
        }
      };
      _xblockexpression = IterableExtensions.<Requirement>filter(y, _function_1);
    }
    return _xblockexpression;
  }
  
  public boolean isSame(final ComponentClassifier cl1, final ComponentClassifier cl2) {
    String _qualifiedName = cl1.getQualifiedName();
    String _qualifiedName_1 = cl2.getQualifiedName();
    return _qualifiedName.equalsIgnoreCase(_qualifiedName_1);
  }
  
  public Iterable<VerificationLibrary> getVerificationActivities(final Requirement reqspec) {
    EClass _verificationLibrary = VerifyPackage.eINSTANCE.getVerificationLibrary();
    final Predicate<IEObjectDescription> _function = new Predicate<IEObjectDescription>() {
      public boolean apply(final IEObjectDescription ed) {
        EObject _eObjectOrProxy = ed.getEObjectOrProxy();
        ComponentClassifier _target = null;
        if (((VerificationLibrary) _eObjectOrProxy)!=null) {
          _target=((VerificationLibrary) _eObjectOrProxy).getTarget();
        }
        return Objects.equal(_target, reqspec);
      }
    };
    Iterable<IEObjectDescription> _globalEObjectDescriptions = this.cgsp.getGlobalEObjectDescriptions(reqspec, _verificationLibrary, _function);
    final Function1<IEObjectDescription, VerificationLibrary> _function_1 = new Function1<IEObjectDescription, VerificationLibrary>() {
      public VerificationLibrary apply(final IEObjectDescription ed) {
        EObject _eObjectOrProxy = ed.getEObjectOrProxy();
        return ((VerificationLibrary) _eObjectOrProxy);
      }
    };
    return IterableExtensions.<IEObjectDescription, VerificationLibrary>map(_globalEObjectDescriptions, _function_1);
  }
  
  @Inject
  private IReferenceFinder referenceFinder;
  
  public List<IReferenceDescription> myFindReferences(final URI uri) {
    List<IReferenceDescription> _xblockexpression = null;
    {
      final List<IReferenceDescription> references = CollectionLiterals.<IReferenceDescription>newArrayList();
      final IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
        public void accept(final IReferenceDescription reference) {
          references.add(reference);
        }
      };
      final Iterable<URI> targetURIs = Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(uri));
      this.referenceFinder.findAllReferences(targetURIs, null, acceptor, null);
      _xblockexpression = references;
    }
    return _xblockexpression;
  }
}
