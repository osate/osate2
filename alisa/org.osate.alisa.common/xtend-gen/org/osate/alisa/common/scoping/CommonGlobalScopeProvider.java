package org.osate.alisa.common.scoping;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class CommonGlobalScopeProvider extends DefaultGlobalScopeProvider {
  @Inject
  private IQualifiedNameProvider qualifiedNameProvider;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  /**
   * Get all global definitions of objects with the qualified name and the same eClass as target.
   */
  public List<IEObjectDescription> getDuplicates(final EObject target) {
    final Stack<IEObjectDescription> res = new Stack<IEObjectDescription>();
    final Resource context = target.eResource();
    boolean _or = false;
    boolean _equals = Objects.equal(context, null);
    if (_equals) {
      _or = true;
    } else {
      ResourceSet _resourceSet = context.getResourceSet();
      boolean _equals_1 = Objects.equal(_resourceSet, null);
      _or = _equals_1;
    }
    if (_or) {
      return Collections.EMPTY_LIST;
    }
    List<IContainer> _visibleContainers = this.getVisibleContainers(context);
    final ArrayList<IContainer> containers = Lists.<IContainer>newArrayList(_visibleContainers);
    QualifiedName _fullyQualifiedName = null;
    if (this.qualifiedNameProvider!=null) {
      _fullyQualifiedName=this.qualifiedNameProvider.getFullyQualifiedName(target);
    }
    final QualifiedName qn = _fullyQualifiedName;
    boolean _equals_2 = Objects.equal(qn, null);
    if (_equals_2) {
      return Collections.EMPTY_LIST;
    }
    for (final IContainer container : containers) {
      {
        EClass _eClass = target.eClass();
        final Iterable<IEObjectDescription> eds = container.getExportedObjects(_eClass, qn, true);
        URI _uRI = context.getURI();
        boolean _hasResourceDescription = container.hasResourceDescription(_uRI);
        boolean _not = (!_hasResourceDescription);
        if (_not) {
          Iterables.<IEObjectDescription>addAll(res, eds);
        } else {
          int _size = IterableExtensions.size(eds);
          boolean _greaterThan = (_size > 1);
          if (_greaterThan) {
            for (final IEObjectDescription ed : eds) {
              URI _eObjectURI = ed.getEObjectURI();
              URI _uRI_1 = EcoreUtil.getURI(target);
              boolean _notEquals = (!Objects.equal(_eObjectURI, _uRI_1));
              if (_notEquals) {
                res.add(ed);
              }
            }
          }
        }
      }
    }
    return res;
  }
  
  public IScope getGlobalScope(final EObject context, final EClass eClass, final Predicate<IEObjectDescription> filter) {
    Resource _eResource = context.eResource();
    return this.getScope(_eResource, true, eClass, filter);
  }
  
  public Iterable<IEObjectDescription> getGlobalEObjectDescriptions(final EObject context, final EClass eClass, final Predicate<IEObjectDescription> filter) {
    Iterable<IEObjectDescription> _xblockexpression = null;
    {
      final IScope gscope = this.getGlobalScope(context, eClass, filter);
      _xblockexpression = gscope.getAllElements();
    }
    return _xblockexpression;
  }
  
  public IEObjectDescription getGlobalEObjectDescription(final EObject context, final EClass eClass, final String qname, final Predicate<IEObjectDescription> filter) {
    IEObjectDescription _xblockexpression = null;
    {
      final IScope gscope = this.getGlobalScope(context, eClass, filter);
      QualifiedName _qualifiedName = null;
      if (this.qualifiedNameConverter!=null) {
        _qualifiedName=this.qualifiedNameConverter.toQualifiedName(qname);
      }
      _xblockexpression = gscope.getSingleElement(_qualifiedName);
    }
    return _xblockexpression;
  }
  
  public IEObjectDescription getGlobalEObjectDescription(final EObject context, final EClass eClass, final String qname) {
    IEObjectDescription _xblockexpression = null;
    {
      final IScope gscope = this.getGlobalScope(context, eClass, null);
      QualifiedName _qualifiedName = null;
      if (this.qualifiedNameConverter!=null) {
        _qualifiedName=this.qualifiedNameConverter.toQualifiedName(qname);
      }
      _xblockexpression = gscope.getSingleElement(_qualifiedName);
    }
    return _xblockexpression;
  }
  
  public EObject getGlobalEObject(final EObject context, final EClass eClass, final String qname, final Predicate<IEObjectDescription> filter) {
    EObject _xblockexpression = null;
    {
      final IEObjectDescription eod = this.getGlobalEObjectDescription(context, eClass, qname, filter);
      EObject _eObjectOrProxy = null;
      if (eod!=null) {
        _eObjectOrProxy=eod.getEObjectOrProxy();
      }
      _xblockexpression = _eObjectOrProxy;
    }
    return _xblockexpression;
  }
  
  public EObject getGlobalEObject(final EObject context, final EClass eClass, final String qname) {
    EObject _xblockexpression = null;
    {
      final IEObjectDescription eod = this.getGlobalEObjectDescription(context, eClass, qname);
      EObject _eObjectOrProxy = null;
      if (eod!=null) {
        _eObjectOrProxy=eod.getEObjectOrProxy();
      }
      _xblockexpression = _eObjectOrProxy;
    }
    return _xblockexpression;
  }
  
  public URI getGlobalEObjectURI(final EObject context, final EClass eClass, final String qname) {
    URI _xblockexpression = null;
    {
      final IEObjectDescription eod = this.getGlobalEObjectDescription(context, eClass, qname);
      URI _eObjectURI = null;
      if (eod!=null) {
        _eObjectURI=eod.getEObjectURI();
      }
      _xblockexpression = _eObjectURI;
    }
    return _xblockexpression;
  }
  
  public void printScope(final Iterable<IEObjectDescription> edl) {
    InputOutput.<String>println("scope content");
    final Procedure1<IEObjectDescription> _function = new Procedure1<IEObjectDescription>() {
      public void apply(final IEObjectDescription ed) {
        QualifiedName _name = ed.getName();
        String _plus = (_name + " URI ");
        URI _eObjectURI = ed.getEObjectURI();
        String _plus_1 = (_plus + _eObjectURI);
        InputOutput.<String>println(_plus_1);
      }
    };
    IterableExtensions.<IEObjectDescription>forEach(edl, _function);
  }
  
  public void printScope(final IScope scope) {
    InputOutput.<String>println("scope");
    final Iterable<IEObjectDescription> edl = scope.getAllElements();
    final Procedure1<IEObjectDescription> _function = new Procedure1<IEObjectDescription>() {
      public void apply(final IEObjectDescription ed) {
        QualifiedName _name = ed.getName();
        String _plus = (_name + " URI ");
        URI _eObjectURI = ed.getEObjectURI();
        String _plus_1 = (_plus + _eObjectURI);
        InputOutput.<String>println(_plus_1);
      }
    };
    IterableExtensions.<IEObjectDescription>forEach(edl, _function);
  }
}
