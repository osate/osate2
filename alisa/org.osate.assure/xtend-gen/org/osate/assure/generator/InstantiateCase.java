package org.osate.assure.generator;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.alisa.common.scoping.AlisaGlobalScopeProvider;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationAssumption;

@SuppressWarnings("all")
public class InstantiateCase {
  @Extension
  private AlisaGlobalScopeProvider agsp = new AlisaGlobalScopeProvider();
  
  public String instantiate(final SystemInstance si) {
    return this.generate(si);
  }
  
  public String generate(final ComponentInstance ci) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("case ");
    String _name = ci.getName();
    _builder.append(_name, "");
    _builder.append(" for ");
    String _instanceObjectPath = ci.getInstanceObjectPath();
    _builder.append(_instanceObjectPath, "");
    _builder.newLineIfNotEmpty();
    _builder.append("[");
    _builder.newLine();
    {
      EList<ComponentInstance> _allComponentInstances = ci.getAllComponentInstances();
      for(final ComponentInstance subci : _allComponentInstances) {
        String _generate = this.generate(subci);
        _builder.append(_generate, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      List<Requirement> _requirements = this.getRequirements(ci);
      for(final Requirement reqspec : _requirements) {
        CharSequence _generate_1 = this.generate(reqspec, ci);
        _builder.append(_generate_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("]");
    _builder.newLine();
    return _builder.toString();
  }
  
  public CharSequence generate(final Requirement reqspec, final InstanceObject io) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("claim ");
    String _name = io.getName();
    _builder.append(_name, "");
    _builder.append("-");
    String _name_1 = reqspec.getName();
    _builder.append(_name_1, "");
    _builder.append(" of ");
    _builder.append(reqspec, "");
    _builder.newLineIfNotEmpty();
    _builder.append("for ");
    String _instanceObjectPath = io.getInstanceObjectPath();
    _builder.append(_instanceObjectPath, "");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("[");
    _builder.newLine();
    {
      EList<Requirement> _subrequirement = reqspec.getSubrequirement();
      for(final Requirement subreqspec : _subrequirement) {
        Object _generate = this.generate(subreqspec, io);
        _builder.append(_generate, "");
        _builder.newLineIfNotEmpty();
      }
    }
    {
      List<VerificationActivity> _verificationActivities = this.getVerificationActivities(reqspec);
      for(final VerificationActivity va : _verificationActivities) {
        CharSequence _generate_1 = this.generate(va, io);
        _builder.append(_generate_1, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate(final VerificationActivity va, final InstanceObject io) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("verification ");
    String _name = io.getName();
    _builder.append(_name, "");
    _builder.append("-");
    String _name_1 = va.getName();
    _builder.append(_name_1, "");
    _builder.append(" of ");
    _builder.append(va, "");
    _builder.newLineIfNotEmpty();
    _builder.append("for ");
    String _instanceObjectPath = io.getInstanceObjectPath();
    _builder.append(_instanceObjectPath, "");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("[");
    _builder.newLine();
    {
      EList<VerificationAssumption> _assumption = va.getAssumption();
      for(final VerificationAssumption subva : _assumption) {
        CharSequence _generate = this.generate(subva, io);
        _builder.append(_generate, "");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence generate(final VerificationAssumption va, final InstanceObject io) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("verification ");
    String _name = io.getName();
    _builder.append(_name, "");
    _builder.append("-");
    String _name_1 = va.getName();
    _builder.append(_name_1, "");
    _builder.append(" of ");
    _builder.append(va, "");
    _builder.newLineIfNotEmpty();
    _builder.append("for ");
    String _instanceObjectPath = io.getInstanceObjectPath();
    _builder.append(_instanceObjectPath, "");
    _builder.append(" ");
    _builder.newLineIfNotEmpty();
    _builder.append("[");
    _builder.newLine();
    _builder.append("]");
    _builder.newLine();
    return _builder;
  }
  
  public List<Requirement> getRequirements(final InstanceObject io) {
    List<URI> _references = this.agsp.getReferences(io);
    final Function1<URI, Requirement> _function = new Function1<URI, Requirement>() {
      public Requirement apply(final URI uri) {
        Resource _eResource = io.eResource();
        ResourceSet _resourceSet = _eResource.getResourceSet();
        EObject _eObject = _resourceSet.getEObject(uri, true);
        return ((Requirement) _eObject);
      }
    };
    return ListExtensions.<URI, Requirement>map(_references, _function);
  }
  
  public List<VerificationActivity> getVerificationActivities(final Requirement reqspec) {
    List<URI> _references = this.agsp.getReferences(reqspec);
    final Function1<URI, VerificationActivity> _function = new Function1<URI, VerificationActivity>() {
      public VerificationActivity apply(final URI uri) {
        Resource _eResource = reqspec.eResource();
        ResourceSet _resourceSet = _eResource.getResourceSet();
        EObject _eObject = _resourceSet.getEObject(uri, true);
        return ((VerificationActivity) _eObject);
      }
    };
    return ListExtensions.<URI, VerificationActivity>map(_references, _function);
  }
  
  public NamedElement getRequirementTarget(final Requirement req, final InstanceObject io) {
    NamedElement _target = req.getTarget();
    return this.findElementInstance(io, _target);
  }
  
  public NamedElement findElementInstance(final InstanceObject io, final NamedElement element) {
    NamedElement _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (io instanceof ComponentInstance) {
        _matched=true;
        EList<Element> _allOwnedElements = ((ComponentInstance)io).allOwnedElements();
        final Function1<Element, Boolean> _function = new Function1<Element, Boolean>() {
          public Boolean apply(final Element ei) {
            String _name = ((InstanceObject) ei).getName();
            String _name_1 = element.getName();
            return Boolean.valueOf(_name.equalsIgnoreCase(_name_1));
          }
        };
        Element _findFirst = IterableExtensions.<Element>findFirst(_allOwnedElements, _function);
        _switchResult = ((NamedElement) _findFirst);
      }
    }
    if (!_matched) {
      _switchResult = io;
    }
    return _switchResult;
  }
}
