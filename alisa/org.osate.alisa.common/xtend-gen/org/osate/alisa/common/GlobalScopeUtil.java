package org.osate.alisa.common;

import com.google.common.base.Objects;
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
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class GlobalScopeUtil extends DefaultGlobalScopeProvider {
  @Inject
  private IQualifiedNameProvider qualifiedNameProvider;
  
  public final static String DUPLICATE_GLOBAL_NAME = "org.osate.alisa.common.DuplicateGlobalName";
  
  /**
   * Get all global definitions of objects with the qualified name and the same eClass as target.
   */
  public List<IEObjectDescription> getDuplicates(final EObject target) {
    final QualifiedName qn = this.qualifiedNameProvider.getFullyQualifiedName(target);
    boolean _equals = Objects.equal(qn, null);
    if (_equals) {
      return Collections.EMPTY_LIST;
    }
    final Stack<IEObjectDescription> res = new Stack<IEObjectDescription>();
    final Resource context = target.eResource();
    boolean _or = false;
    boolean _equals_1 = Objects.equal(context, null);
    if (_equals_1) {
      _or = true;
    } else {
      ResourceSet _resourceSet = context.getResourceSet();
      boolean _equals_2 = Objects.equal(_resourceSet, null);
      _or = _equals_2;
    }
    if (_or) {
      return Collections.EMPTY_LIST;
    }
    List<IContainer> _visibleContainers = this.getVisibleContainers(context);
    final ArrayList<IContainer> containers = Lists.<IContainer>newArrayList(_visibleContainers);
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
  
  public List<URI> getReferences(final EObject target) {
    final QualifiedName qn = this.qualifiedNameProvider.getFullyQualifiedName(target);
    boolean _equals = Objects.equal(qn, null);
    if (_equals) {
      return Collections.EMPTY_LIST;
    }
    final Stack<URI> res = new Stack<URI>();
    final Resource context = target.eResource();
    boolean _or = false;
    boolean _equals_1 = Objects.equal(context, null);
    if (_equals_1) {
      _or = true;
    } else {
      ResourceSet _resourceSet = context.getResourceSet();
      boolean _equals_2 = Objects.equal(_resourceSet, null);
      _or = _equals_2;
    }
    if (_or) {
      return Collections.EMPTY_LIST;
    }
    List<IContainer> _visibleContainers = this.getVisibleContainers(context);
    final ArrayList<IContainer> containers = Lists.<IContainer>newArrayList(_visibleContainers);
    for (final IContainer container : containers) {
      {
        final Iterable<IResourceDescription> rds = container.getResourceDescriptions();
        for (final IResourceDescription rd : rds) {
          {
            final Iterable<QualifiedName> imports = rd.getImportedNames();
            boolean _contains = this.contains(imports, qn);
            if (_contains) {
              final Iterable<IReferenceDescription> refds = rd.getReferenceDescriptions();
              for (final IReferenceDescription red : refds) {
                URI _targetEObjectUri = red.getTargetEObjectUri();
                URI _uRI = EcoreUtil.getURI(target);
                boolean _equals_3 = Objects.equal(_targetEObjectUri, _uRI);
                if (_equals_3) {
                  URI _sourceEObjectUri = red.getSourceEObjectUri();
                  res.add(_sourceEObjectUri);
                }
              }
            }
          }
        }
      }
    }
    return res;
  }
  
  public boolean contains(final Iterable<QualifiedName> names, final QualifiedName qn) {
    for (final QualifiedName match : names) {
      boolean _equals = Objects.equal(match, qn);
      if (_equals) {
        return true;
      }
    }
    return false;
  }
}
