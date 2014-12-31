package org.osate.alisa.common.util;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.Aadl2Package;
import org.osate.alisa.common.scoping.AlisaGlobalScopeProvider;

@SuppressWarnings("all")
public class AlisaUtilExtension {
  @Extension
  private AlisaGlobalScopeProvider agsp = new AlisaGlobalScopeProvider();
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  public IEObjectDescription getGlobalEObjectDescription(final EObject context, final EClass eClass, final String qname) {
    IEObjectDescription _xblockexpression = null;
    {
      final IScope gscope = this.agsp.getGlobalScope(context, eClass, null);
      QualifiedName _qualifiedName = null;
      if (this.qualifiedNameConverter!=null) {
        _qualifiedName=this.qualifiedNameConverter.toQualifiedName(qname);
      }
      _xblockexpression = gscope.getSingleElement(_qualifiedName);
    }
    return _xblockexpression;
  }
  
  public EObject getGlobalEObject(final EObject context, final EClass eClass, final String qname) {
    EObject _xblockexpression = null;
    {
      final IEObjectDescription eod = this.getGlobalEObjectDescription(context, eClass, qname);
      _xblockexpression = eod.getEObjectOrProxy();
    }
    return _xblockexpression;
  }
  
  public URI getGlobalEObjectURI(final EObject context, final EClass eClass, final String qname) {
    URI _xblockexpression = null;
    {
      final IEObjectDescription eod = this.getGlobalEObjectDescription(context, eClass, qname);
      _xblockexpression = eod.getEObjectURI();
    }
    return _xblockexpression;
  }
  
  public EObject getPropertyDefinition(final EObject context, final String qname) {
    EObject _xblockexpression = null;
    {
      EClass _property = Aadl2Package.eINSTANCE.getProperty();
      final IEObjectDescription eod = this.getGlobalEObjectDescription(context, _property, qname);
      _xblockexpression = eod.getEObjectOrProxy();
    }
    return _xblockexpression;
  }
  
  public EObject getClassifier(final EObject context, final String qname) {
    EObject _xblockexpression = null;
    {
      EClass _classifier = Aadl2Package.eINSTANCE.getClassifier();
      final IEObjectDescription eod = this.getGlobalEObjectDescription(context, _classifier, qname);
      _xblockexpression = eod.getEObjectOrProxy();
    }
    return _xblockexpression;
  }
  
  public Iterable<IEObjectDescription> getGlobalEObjectDescriptions(final EObject context, final EClass eClass) {
    Iterable<IEObjectDescription> _xblockexpression = null;
    {
      final IScope gscope = this.agsp.getGlobalScope(context, eClass, null);
      _xblockexpression = gscope.getAllElements();
    }
    return _xblockexpression;
  }
  
  public Iterable<EObject> getClassifiers(final EObject context) {
    EClass _classifier = Aadl2Package.eINSTANCE.getClassifier();
    Iterable<IEObjectDescription> _globalEObjectDescriptions = this.getGlobalEObjectDescriptions(context, _classifier);
    final Function1<IEObjectDescription, EObject> _function = new Function1<IEObjectDescription, EObject>() {
      public EObject apply(final IEObjectDescription it) {
        return it.getEObjectOrProxy();
      }
    };
    return IterableExtensions.<IEObjectDescription, EObject>map(_globalEObjectDescriptions, _function);
  }
  
  public Iterable<EObject> getThreads(final EObject context) {
    EClass _thread = Aadl2Package.eINSTANCE.getThread();
    Iterable<IEObjectDescription> _globalEObjectDescriptions = this.getGlobalEObjectDescriptions(context, _thread);
    final Function1<IEObjectDescription, EObject> _function = new Function1<IEObjectDescription, EObject>() {
      public EObject apply(final IEObjectDescription it) {
        return it.getEObjectOrProxy();
      }
    };
    return IterableExtensions.<IEObjectDescription, EObject>map(_globalEObjectDescriptions, _function);
  }
}
