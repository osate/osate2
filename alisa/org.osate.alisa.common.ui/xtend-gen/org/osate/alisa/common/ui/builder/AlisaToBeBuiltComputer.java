package org.osate.alisa.common.ui.builder;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.builder.impl.IToBeBuiltComputerContribution;
import org.eclipse.xtext.builder.impl.ToBeBuilt;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class AlisaToBeBuiltComputer implements IToBeBuiltComputerContribution {
  @Inject
  private IBuilderState builderState;
  
  @Inject
  private IStorage2UriMapper mapper;
  
  public boolean isPossiblyHandled(final IStorage storage) {
    return this.isAlisaResource(storage);
  }
  
  public boolean isRejected(final IFolder folder) {
    return false;
  }
  
  public void removeProject(final ToBeBuilt toBeBuilt, final IProject project, final IProgressMonitor monitor) {
  }
  
  public boolean removeStorage(final ToBeBuilt toBeBuilt, final IStorage storage, final IProgressMonitor monitor) {
    return this.updateStorage(toBeBuilt, storage, monitor);
  }
  
  public void updateProject(final ToBeBuilt toBeBuilt, final IProject project, final IProgressMonitor monitor) throws CoreException {
  }
  
  public boolean updateStorage(final ToBeBuilt toBeBuilt, final IStorage storage, final IProgressMonitor monitor) {
    boolean _xifexpression = false;
    boolean _isAlisaResource = this.isAlisaResource(storage);
    if (_isAlisaResource) {
      boolean _xblockexpression = false;
      {
        final HashMap<URI, HashSet<URI>> dependencies = new HashMap<URI, HashSet<URI>>();
        Iterable<IResourceDescription> _allResourceDescriptions = this.builderState.getAllResourceDescriptions();
        final Function1<IResourceDescription, Boolean> _function = new Function1<IResourceDescription, Boolean>() {
          public Boolean apply(final IResourceDescription d) {
            URI _uRI = d.getURI();
            return Boolean.valueOf(AlisaToBeBuiltComputer.this.isAlisaResource(_uRI));
          }
        };
        Iterable<IResourceDescription> _filter = IterableExtensions.<IResourceDescription>filter(_allResourceDescriptions, _function);
        for (final IResourceDescription rd : _filter) {
          {
            final URI sourceURI = rd.getURI();
            Iterable<IReferenceDescription> _referenceDescriptions = rd.getReferenceDescriptions();
            for (final IReferenceDescription reference : _referenceDescriptions) {
              {
                URI _targetEObjectUri = reference.getTargetEObjectUri();
                final URI targetURI = _targetEObjectUri.trimFragment();
                boolean _isAlisaResource_1 = this.isAlisaResource(targetURI);
                if (_isAlisaResource_1) {
                  HashSet<URI> _elvis = null;
                  HashSet<URI> _get = dependencies.get(targetURI);
                  if (_get != null) {
                    _elvis = _get;
                  } else {
                    HashSet<URI> _hashSet = new HashSet<URI>();
                    _elvis = _hashSet;
                  }
                  final HashSet<URI> deps = _elvis;
                  deps.add(sourceURI);
                  HashSet<URI> _get_1 = dependencies.get(targetURI);
                  boolean _equals = Objects.equal(_get_1, null);
                  if (_equals) {
                    dependencies.put(targetURI, deps);
                  }
                }
              }
            }
          }
        }
        final URI storageURI = this.mapper.getUri(storage);
        final HashSet<URI> deps = CollectionLiterals.<URI>newHashSet(storageURI);
        int oldSize = 0;
        while ((deps.size() > oldSize)) {
          {
            int _size = deps.size();
            oldSize = _size;
            final Function1<URI, Set<URI>> _function_1 = new Function1<URI, Set<URI>>() {
              public Set<URI> apply(final URI it) {
                Set<URI> _elvis = null;
                HashSet<URI> _get = dependencies.get(it);
                if (_get != null) {
                  _elvis = _get;
                } else {
                  _elvis = Collections.<URI>unmodifiableSet(CollectionLiterals.<URI>newHashSet());
                }
                return _elvis;
              }
            };
            Iterable<Set<URI>> _map = IterableExtensions.<URI, Set<URI>>map(deps, _function_1);
            Iterable<URI> _flatten = Iterables.<URI>concat(_map);
            final List<URI> newDependencies = IterableExtensions.<URI>toList(_flatten);
            deps.addAll(newDependencies);
          }
        }
        Set<URI> _toBeUpdated = toBeBuilt.getToBeUpdated();
        _toBeUpdated.addAll(deps);
        String _name = storage.getName();
        String _plus = ("\n\n======= " + _name);
        System.out.println(_plus);
        final Procedure1<URI> _function_1 = new Procedure1<URI>() {
          public void apply(final URI uri) {
            System.out.println(uri);
          }
        };
        IterableExtensions.<URI>forEach(deps, _function_1);
        System.out.println("======= ");
        _xblockexpression = true;
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  private boolean isAlisaResource(final IStorage storage) {
    boolean _xblockexpression = false;
    {
      final URI uri = this.mapper.getUri(storage);
      boolean _xifexpression = false;
      boolean _notEquals = (!Objects.equal(uri, null));
      if (_notEquals) {
        _xifexpression = this.isAlisaResource(uri);
      } else {
        _xifexpression = false;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  private boolean isAlisaResource(final URI uri) {
    String _fileExtension = uri.fileExtension();
    return this.isAlisaResource(_fileExtension);
  }
  
  public boolean isAlisaResource(final String ext) {
    return Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("cat", "org", "verify", "reqspec", "alisa", "aadl")).contains(ext);
  }
}
