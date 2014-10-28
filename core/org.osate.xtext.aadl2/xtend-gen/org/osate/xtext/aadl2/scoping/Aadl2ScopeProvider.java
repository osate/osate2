/**
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
 * 
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 * 
 * NO WARRANTY
 * 
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 * 
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 * 
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.scoping;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractSubcomponentType;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.BusSubcomponentType;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Connection;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.DeviceSubcomponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureConnection;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.MemorySubcomponentType;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.ParameterConnection;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.ProcessSubcomponentType;
import org.osate.aadl2.ProcessorSubcomponentType;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramGroupSubcomponentType;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.aadl2.SystemSubcomponentType;
import org.osate.aadl2.ThreadGroupSubcomponentType;
import org.osate.aadl2.ThreadSubcomponentType;
import org.osate.aadl2.VirtualBusSubcomponentType;
import org.osate.aadl2.VirtualProcessorSubcomponentType;
import org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 */
@SuppressWarnings("all")
public class Aadl2ScopeProvider extends PropertiesScopeProvider {
  public IScope scope_TypeExtension_extended(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_ComponentImplementation(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_GroupExtension_extended(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_FeatureGroupPrototype_constrainingFeatureGroupType(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_FeatureGroupType_inverse(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_Realization_implemented(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_SubprogramCall_context(final Element context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      IScope scope = this.scope_Classifier(context, reference);
      IScope _elvis = null;
      BehavioredImplementation _containerOfType = EcoreUtil2.<BehavioredImplementation>getContainerOfType(context, BehavioredImplementation.class);
      EList<NamedElement> _members = null;
      if (_containerOfType!=null) {
        _members=_containerOfType.getMembers();
      }
      Iterable<CallContext> _filter = Iterables.<CallContext>filter(_members, CallContext.class);
      IScope _scopeFor = Scopes.scopeFor(_filter, scope);
      if (_scopeFor != null) {
        _elvis = _scopeFor;
      } else {
        _elvis = scope;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
  
  public IScope scope_SubprogramCall_calledSubprogram(final Element context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      IScope scope = this.scope_Classifier(context, reference);
      SubprogramCall _containerOfType = EcoreUtil2.<SubprogramCall>getContainerOfType(context, SubprogramCall.class);
      CallContext _context = null;
      if (_containerOfType!=null) {
        _context=_containerOfType.getContext();
      }
      final CallContext callContext = _context;
      boolean _equals = Objects.equal(callContext, null);
      if (_equals) {
        Classifier _containerOfType_1 = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
        EList<NamedElement> _members = _containerOfType_1.getMembers();
        Iterable<CalledSubprogram> _filter = Iterables.<CalledSubprogram>filter(_members, CalledSubprogram.class);
        IScope _scopeFor = Scopes.scopeFor(_filter, scope);
        scope = _scopeFor;
      } else {
        scope = IScope.NULLSCOPE;
        Classifier callContextNamespace = null;
        boolean _matched = false;
        if (!_matched) {
          if (callContext instanceof ComponentType) {
            _matched=true;
            AadlPackage _containerOfType_2 = EcoreUtil2.<AadlPackage>getContainerOfType(callContext, AadlPackage.class);
            PublicPackageSection _publicSection = _containerOfType_2.getPublicSection();
            EList<Classifier> _ownedClassifiers = _publicSection.getOwnedClassifiers();
            final ArrayList<Classifier> packageClassifiers = new ArrayList<Classifier>(_ownedClassifiers);
            final PackageSection packageSectionForComponentType = EcoreUtil2.<PackageSection>getContainerOfType(callContext, PackageSection.class);
            boolean _and = false;
            if (!(packageSectionForComponentType instanceof PrivatePackageSection)) {
              _and = false;
            } else {
              PrivatePackageSection _containerOfType_3 = EcoreUtil2.<PrivatePackageSection>getContainerOfType(context, PrivatePackageSection.class);
              boolean _equals_1 = Objects.equal(packageSectionForComponentType, _containerOfType_3);
              _and = _equals_1;
            }
            if (_and) {
              EList<Classifier> _ownedClassifiers_1 = packageSectionForComponentType.getOwnedClassifiers();
              packageClassifiers.addAll(_ownedClassifiers_1);
            }
            Iterable<CalledSubprogram> _filter_1 = Iterables.<CalledSubprogram>filter(packageClassifiers, CalledSubprogram.class);
            Iterable<ComponentImplementation> _filter_2 = Iterables.<ComponentImplementation>filter(_filter_1, ComponentImplementation.class);
            final Function1<ComponentImplementation, Boolean> _function = new Function1<ComponentImplementation, Boolean>() {
              public Boolean apply(final ComponentImplementation it) {
                ComponentType _type = it.getType();
                return Boolean.valueOf(Objects.equal(_type, callContext));
              }
            };
            Iterable<ComponentImplementation> _filter_3 = IterableExtensions.<ComponentImplementation>filter(_filter_2, _function);
            final Function<ComponentImplementation, QualifiedName> _function_1 = new Function<ComponentImplementation, QualifiedName>() {
              public QualifiedName apply(final ComponentImplementation it) {
                String _name = it.getName();
                String _name_1 = it.getName();
                int _lastIndexOf = _name_1.lastIndexOf(".");
                int _plus = (_lastIndexOf + 1);
                String _substring = _name.substring(_plus);
                return QualifiedName.create(_substring);
              }
            };
            IScope _scopeFor_1 = Scopes.<ComponentImplementation>scopeFor(_filter_3, _function_1, IScope.NULLSCOPE);
            scope = _scopeFor_1;
            callContextNamespace = ((ComponentType)callContext);
          }
        }
        if (!_matched) {
          if (callContext instanceof SubprogramGroupSubcomponent) {
            _matched=true;
            ComponentType _componentType = ((SubprogramGroupSubcomponent)callContext).getComponentType();
            callContextNamespace = _componentType;
          }
        }
        if (!_matched) {
          if (callContext instanceof SubprogramGroupAccess) {
            _matched=true;
            boolean _and = false;
            AccessType _kind = ((SubprogramGroupAccess)callContext).getKind();
            boolean _equals_1 = Objects.equal(_kind, AccessType.REQUIRES);
            if (!_equals_1) {
              _and = false;
            } else {
              SubprogramGroupSubcomponentType _subprogramGroupFeatureClassifier = ((SubprogramGroupAccess)callContext).getSubprogramGroupFeatureClassifier();
              _and = (_subprogramGroupFeatureClassifier instanceof Classifier);
            }
            if (_and) {
              SubprogramGroupSubcomponentType _subprogramGroupFeatureClassifier_1 = ((SubprogramGroupAccess)callContext).getSubprogramGroupFeatureClassifier();
              callContextNamespace = ((Classifier) _subprogramGroupFeatureClassifier_1);
            }
          }
        }
        if (!_matched) {
          if (callContext instanceof FeatureGroup) {
            _matched=true;
            FeatureGroupType _featureGroupType = ((FeatureGroup)callContext).getFeatureGroupType();
            callContextNamespace = _featureGroupType;
          }
        }
        IScope _elvis = null;
        EList<NamedElement> _members_1 = null;
        if (callContextNamespace!=null) {
          _members_1=callContextNamespace.getMembers();
        }
        Iterable<CalledSubprogram> _filter_1 = Iterables.<CalledSubprogram>filter(_members_1, CalledSubprogram.class);
        IScope _scopeFor_1 = Scopes.scopeFor(_filter_1, scope);
        if (_scopeFor_1 != null) {
          _elvis = _scopeFor_1;
        } else {
          _elvis = scope;
        }
        scope = _elvis;
      }
      _xblockexpression = scope;
    }
    return _xblockexpression;
  }
  
  public IScope scope_ComponentPrototype_constrainingClassifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  /**
   * Reference is from AbstractPrototype, BusPrototype, DataPrototype, DevicePrototype, MemoryPrototype,
   * ProcessPrototype, ProcessorPrototype, SubprogramPrototype, SubprogramGroupPrototype, SystemPrototype,
   * ThreadPrototype, ThreadGroupPrototype, VirtualBusPrototype, VirtualProcessorPrototype,
   * FeatureGroupPrototype and FeaturePrototype in Aadl2.xtext
   */
  public IScope scope_Prototype_refined(final Classifier context, final EReference reference) {
    IScope _elvis = null;
    Classifier _extended = context.getExtended();
    EList<Prototype> _allPrototypes = null;
    if (_extended!=null) {
      _allPrototypes=Aadl2ScopeProvider.allPrototypes(_extended);
    }
    IScope _scopeFor = Scopes.scopeFor(_allPrototypes);
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public IScope scope_FeaturePrototype_constrainingClassifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_PrototypeBinding_formal(final ComponentPrototypeActual context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      final SubcomponentType subcomponentType = context.getSubcomponentType();
      IScope _xifexpression = null;
      if ((subcomponentType instanceof ComponentClassifier)) {
        EList<Prototype> _allPrototypes = ((ComponentClassifier)subcomponentType).getAllPrototypes();
        _xifexpression = Scopes.scopeFor(_allPrototypes);
      } else {
        _xifexpression = IScope.NULLSCOPE;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public IScope scope_PrototypeBinding_formal(final FeatureGroupPrototypeActual context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      final FeatureType featureType = context.getFeatureType();
      IScope _xifexpression = null;
      if ((featureType instanceof FeatureGroupType)) {
        EList<Prototype> _allPrototypes = ((FeatureGroupType)featureType).getAllPrototypes();
        _xifexpression = Scopes.scopeFor(_allPrototypes);
      } else {
        _xifexpression = IScope.NULLSCOPE;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public IScope scope_PrototypeBinding_formal(final ComponentImplementationReference context, final EReference reference) {
    IScope _elvis = null;
    ComponentImplementation _implementation = context.getImplementation();
    EList<Prototype> _allPrototypes = null;
    if (_implementation!=null) {
      _allPrototypes=_implementation.getAllPrototypes();
    }
    IScope _scopeFor = Scopes.scopeFor(_allPrototypes);
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public IScope scope_PrototypeBinding_formal(final Subcomponent context, final EReference reference) {
    IScope _elvis = null;
    ComponentClassifier _allClassifier = context.getAllClassifier();
    EList<Prototype> _allPrototypes = null;
    if (_allClassifier!=null) {
      _allPrototypes=_allClassifier.getAllPrototypes();
    }
    IScope _scopeFor = Scopes.scopeFor(_allPrototypes);
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public IScope scope_PrototypeBinding_formal(final Classifier context, final EReference reference) {
    IScope _elvis = null;
    Classifier _extended = context.getExtended();
    EList<Prototype> _allPrototypes = null;
    if (_extended!=null) {
      _allPrototypes=Aadl2ScopeProvider.allPrototypes(_extended);
    }
    IScope _scopeFor = Scopes.scopeFor(_allPrototypes);
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public IScope scope_FeatureGroupPrototypeActual_featureType(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<FeatureGroupPrototype> _filter = Iterables.<FeatureGroupPrototype>filter(_allPrototypes, FeatureGroupPrototype.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_PortSpecification_classifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_AccessSpecification_classifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_FeaturePrototypeReference_prototype(final Classifier context, final EReference reference) {
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(context);
    Iterable<FeaturePrototype> _filter = Iterables.<FeaturePrototype>filter(_allPrototypes, FeaturePrototype.class);
    return Scopes.scopeFor(_filter);
  }
  
  public IScope scope_ComponentPrototypeActual_subcomponentType(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<SubcomponentType> _filter = Iterables.<SubcomponentType>filter(_allPrototypes, SubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  /**
   * Reference is from AbstractSubcomponent, SystemSubcomponent, ProcessSubcomponent, ThreadGroupSubcomponent,
   * ThreadSubcomponent, SubprogramSubcomponent, SubprogramGroupSubcomponent, ProcessorSubcomponent,
   * VirtualProcessorSubcomponent, DeviceSubcomponent, MemorySubcomponent, BusSubcomponent,
   * VirtualBusSubcomponent, and DataSubcomponent in Aadl2.xtext
   */
  public IScope scope_Subcomponent_refined(final ComponentImplementation context, final EReference reference) {
    IScope _elvis = null;
    ComponentImplementation _extended = context.getExtended();
    EList<Subcomponent> _allSubcomponents = null;
    if (_extended!=null) {
      _allSubcomponents=_extended.getAllSubcomponents();
    }
    IScope _scopeFor = Scopes.scopeFor(_allSubcomponents);
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public IScope scope_AbstractSubcomponent_abstractSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<AbstractSubcomponentType> _filter = Iterables.<AbstractSubcomponentType>filter(_allPrototypes, AbstractSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_SystemSubcomponent_systemSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<SystemSubcomponentType> _filter = Iterables.<SystemSubcomponentType>filter(_allPrototypes, SystemSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_ProcessSubcomponent_processSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<ProcessSubcomponentType> _filter = Iterables.<ProcessSubcomponentType>filter(_allPrototypes, ProcessSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_ThreadGroupSubcomponent_threadGroupSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<ThreadGroupSubcomponentType> _filter = Iterables.<ThreadGroupSubcomponentType>filter(_allPrototypes, ThreadGroupSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_ThreadSubcomponent_threadSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<ThreadSubcomponentType> _filter = Iterables.<ThreadSubcomponentType>filter(_allPrototypes, ThreadSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_SubprogramSubcomponent_subprogramSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<SubprogramSubcomponentType> _filter = Iterables.<SubprogramSubcomponentType>filter(_allPrototypes, SubprogramSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_SubprogramGroupSubcomponent_subprogramGroupSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<SubprogramGroupSubcomponentType> _filter = Iterables.<SubprogramGroupSubcomponentType>filter(_allPrototypes, SubprogramGroupSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_ProcessorSubcomponent_processorSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<ProcessorSubcomponentType> _filter = Iterables.<ProcessorSubcomponentType>filter(_allPrototypes, ProcessorSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_VirtualProcessorSubcomponent_virtualProcessorSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<VirtualProcessorSubcomponentType> _filter = Iterables.<VirtualProcessorSubcomponentType>filter(_allPrototypes, VirtualProcessorSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_DeviceSubcomponent_deviceSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<DeviceSubcomponentType> _filter = Iterables.<DeviceSubcomponentType>filter(_allPrototypes, DeviceSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_MemorySubcomponent_memorySubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<MemorySubcomponentType> _filter = Iterables.<MemorySubcomponentType>filter(_allPrototypes, MemorySubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_BusSubcomponent_busSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<BusSubcomponentType> _filter = Iterables.<BusSubcomponentType>filter(_allPrototypes, BusSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_VirtualBusSubcomponent_virtualBusSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<VirtualBusSubcomponentType> _filter = Iterables.<VirtualBusSubcomponentType>filter(_allPrototypes, VirtualBusSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_DataSubcomponent_dataSubcomponentType(final Element context, final EReference reference) {
    ComponentImplementation _containerOfType = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
    EList<Prototype> _allPrototypes = _containerOfType.getAllPrototypes();
    Iterable<DataSubcomponentType> _filter = Iterables.<DataSubcomponentType>filter(_allPrototypes, DataSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_Feature_refined(final Classifier context, final EReference reference) {
    IScope _elvis = null;
    Classifier _extended = context.getExtended();
    EList<Feature> _allFeatures = null;
    if (_extended!=null) {
      _allFeatures=_extended.getAllFeatures();
    }
    IScope _scopeFor = Scopes.scopeFor(_allFeatures);
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public IScope scope_DataPort_dataFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<DataSubcomponentType> _filter = Iterables.<DataSubcomponentType>filter(_allPrototypes, DataSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_EventDataPort_dataFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<DataSubcomponentType> _filter = Iterables.<DataSubcomponentType>filter(_allPrototypes, DataSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_FeatureGroup_featureType(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<FeatureType> _filter = Iterables.<FeatureType>filter(_allPrototypes, FeatureType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_Parameter_dataFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<DataSubcomponentType> _filter = Iterables.<DataSubcomponentType>filter(_allPrototypes, DataSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_SubprogramAccess_subprogramFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<SubprogramSubcomponentType> _filter = Iterables.<SubprogramSubcomponentType>filter(_allPrototypes, SubprogramSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_SubprogramGroupAccess_subprogramGroupFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<SubprogramGroupSubcomponentType> _filter = Iterables.<SubprogramGroupSubcomponentType>filter(_allPrototypes, SubprogramGroupSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_BusAccess_busFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<BusSubcomponentType> _filter = Iterables.<BusSubcomponentType>filter(_allPrototypes, BusSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_DataAccess_dataFeatureClassifier(final Element context, final EReference reference) {
    Classifier _containerOfType = EcoreUtil2.<Classifier>getContainerOfType(context, Classifier.class);
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(_containerOfType);
    Iterable<DataSubcomponentType> _filter = Iterables.<DataSubcomponentType>filter(_allPrototypes, DataSubcomponentType.class);
    IScope _scope_Classifier = this.scope_Classifier(context, reference);
    return Scopes.scopeFor(_filter, _scope_Classifier);
  }
  
  public IScope scope_AbstractFeature_featurePrototype(final Classifier context, final EReference reference) {
    EList<Prototype> _allPrototypes = Aadl2ScopeProvider.allPrototypes(context);
    Iterable<FeaturePrototype> _filter = Iterables.<FeaturePrototype>filter(_allPrototypes, FeaturePrototype.class);
    return Scopes.scopeFor(_filter);
  }
  
  public IScope scope_EventDataSource_dataClassifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_PortProxy_dataClassifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  public IScope scope_SubprogramProxy_subprogramClassifier(final Element context, final EReference reference) {
    return this.scope_Classifier(context, reference);
  }
  
  /**
   * TODO: This method was written to mimic the functionality of the linking service, which only links correct context objects based upon the type of
   * connection.  What should happen is that the scope provider should return all visible Context objects and the linker should link any visible context
   * Context object.  This check of having the correct Context type for each type of Connection should be moved to the validator.  Let the link exist, but
   * mark a specific validator error message.  Also, the context assist should filter based upon Connection type.
   */
  public IScope scope_ConnectedElement_context(final Connection context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      final ComponentImplementation containingClassifier = EcoreUtil2.<ComponentImplementation>getContainerOfType(context, ComponentImplementation.class);
      final ArrayList<ClassifierFeature> validElements = CollectionLiterals.<ClassifierFeature>newArrayList();
      boolean _matched = false;
      if (!_matched) {
        if (context instanceof FeatureGroupConnection) {
          _matched=true;
          EList<Subcomponent> _allSubcomponents = containingClassifier.getAllSubcomponents();
          validElements.addAll(_allSubcomponents);
          EList<Feature> _allFeatures = containingClassifier.getAllFeatures();
          Iterable<FeatureGroup> _filter = Iterables.<FeatureGroup>filter(_allFeatures, FeatureGroup.class);
          Iterables.<ClassifierFeature>addAll(validElements, _filter);
        }
      }
      if (!_matched) {
        if (context instanceof FeatureConnection) {
          _matched=true;
          EList<Subcomponent> _allSubcomponents = containingClassifier.getAllSubcomponents();
          validElements.addAll(_allSubcomponents);
          EList<Feature> _allFeatures = containingClassifier.getAllFeatures();
          Iterable<FeatureGroup> _filter = Iterables.<FeatureGroup>filter(_allFeatures, FeatureGroup.class);
          Iterables.<ClassifierFeature>addAll(validElements, _filter);
        }
      }
      if (!_matched) {
        if (context instanceof AccessConnection) {
          _matched=true;
          EList<Subcomponent> _allSubcomponents = containingClassifier.getAllSubcomponents();
          validElements.addAll(_allSubcomponents);
          EList<Feature> _allFeatures = containingClassifier.getAllFeatures();
          Iterable<FeatureGroup> _filter = Iterables.<FeatureGroup>filter(_allFeatures, FeatureGroup.class);
          Iterables.<ClassifierFeature>addAll(validElements, _filter);
          if ((containingClassifier instanceof BehavioredImplementation)) {
            ArrayList<SubprogramCall> _allSubprogramCalls = Aadl2ScopeProvider.allSubprogramCalls(((BehavioredImplementation)containingClassifier));
            validElements.addAll(_allSubprogramCalls);
          }
        }
      }
      if (!_matched) {
        if (context instanceof ParameterConnection) {
          _matched=true;
          EList<Feature> _allFeatures = containingClassifier.getAllFeatures();
          final Function1<Feature, Boolean> _function = new Function1<Feature, Boolean>() {
            public Boolean apply(final Feature it) {
              boolean _or = false;
              if ((((it instanceof Parameter) || (it instanceof DataPort)) || (it instanceof EventDataPort))) {
                _or = true;
              } else {
                _or = (it instanceof FeatureGroup);
              }
              return Boolean.valueOf(_or);
            }
          };
          Iterable<Feature> _filter = IterableExtensions.<Feature>filter(_allFeatures, _function);
          Iterables.<ClassifierFeature>addAll(validElements, _filter);
          if ((containingClassifier instanceof BehavioredImplementation)) {
            ArrayList<SubprogramCall> _allSubprogramCalls = Aadl2ScopeProvider.allSubprogramCalls(((BehavioredImplementation)containingClassifier));
            validElements.addAll(_allSubprogramCalls);
          }
        }
      }
      if (!_matched) {
        if (context instanceof PortConnection) {
          _matched=true;
          EList<Subcomponent> _allSubcomponents = containingClassifier.getAllSubcomponents();
          validElements.addAll(_allSubcomponents);
          EList<Feature> _allFeatures = containingClassifier.getAllFeatures();
          final Function1<Feature, Boolean> _function = new Function1<Feature, Boolean>() {
            public Boolean apply(final Feature it) {
              boolean _or = false;
              if (((it instanceof FeatureGroup) || (it instanceof DataPort))) {
                _or = true;
              } else {
                _or = (it instanceof EventDataPort);
              }
              return Boolean.valueOf(_or);
            }
          };
          Iterable<Feature> _filter = IterableExtensions.<Feature>filter(_allFeatures, _function);
          Iterables.<ClassifierFeature>addAll(validElements, _filter);
          if ((containingClassifier instanceof BehavioredImplementation)) {
            ArrayList<SubprogramCall> _allSubprogramCalls = Aadl2ScopeProvider.allSubprogramCalls(((BehavioredImplementation)containingClassifier));
            validElements.addAll(_allSubprogramCalls);
          }
        }
      }
      _xblockexpression = Scopes.scopeFor(validElements);
    }
    return _xblockexpression;
  }
  
  private static EList<Prototype> allPrototypes(final Classifier classifier) {
    EList<Prototype> _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (classifier instanceof ComponentClassifier) {
        _matched=true;
        _switchResult = ((ComponentClassifier)classifier).getAllPrototypes();
      }
    }
    if (!_matched) {
      if (classifier instanceof FeatureGroupType) {
        _matched=true;
        _switchResult = ((FeatureGroupType)classifier).getAllPrototypes();
      }
    }
    return _switchResult;
  }
  
  private static ArrayList<SubprogramCall> allSubprogramCalls(final BehavioredImplementation implementation) {
    ArrayList<SubprogramCall> _xblockexpression = null;
    {
      final ArrayList<SubprogramCall> allSubprogramCalls = CollectionLiterals.<SubprogramCall>newArrayList();
      for (ComponentImplementation currentImplementation = implementation; (!Objects.equal(currentImplementation, null)); currentImplementation = currentImplementation.getExtended()) {
        if ((currentImplementation instanceof BehavioredImplementation)) {
          EList<SubprogramCall> _subprogramCalls = ((BehavioredImplementation)currentImplementation).subprogramCalls();
          allSubprogramCalls.addAll(_subprogramCalls);
        }
      }
      _xblockexpression = allSubprogramCalls;
    }
    return _xblockexpression;
  }
  
  public IScope scope_Mode(final ModalElement context, final EReference reference) {
    IScope _xifexpression = null;
    EReference _modalElement_InMode = Aadl2Package.eINSTANCE.getModalElement_InMode();
    boolean _equals = Objects.equal(reference, _modalElement_InMode);
    if (_equals) {
      IScope _xblockexpression = null;
      {
        final Classifier classifier = context.getContainingClassifier();
        List<Mode> _switchResult = null;
        boolean _matched = false;
        if (!_matched) {
          if (classifier instanceof ComponentClassifier) {
            _matched=true;
            _switchResult = ((ComponentClassifier)classifier).getAllModes();
          }
        }
        if (!_matched) {
          _switchResult = Collections.<Mode>unmodifiableList(CollectionLiterals.<Mode>newArrayList());
        }
        final List<Mode> modes = _switchResult;
        _xblockexpression = Scopes.scopeFor(modes);
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public IScope scope_Mode(final Subcomponent context, final EReference reference) {
    IScope _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      EReference _modeBinding_DerivedMode = Aadl2Package.eINSTANCE.getModeBinding_DerivedMode();
      if (Objects.equal(reference, _modeBinding_DerivedMode)) {
        _matched=true;
        IScope _xblockexpression = null;
        {
          ComponentClassifier _classifier = context.getClassifier();
          final EList<Mode> modes = _classifier.getAllModes();
          _xblockexpression = Scopes.scopeFor(modes);
        }
        _switchResult = _xblockexpression;
      }
    }
    if (!_matched) {
      EReference _modeBinding_ParentMode = Aadl2Package.eINSTANCE.getModeBinding_ParentMode();
      if (Objects.equal(reference, _modeBinding_ParentMode)) {
        _matched=true;
        IScope _xblockexpression_1 = null;
        {
          ComponentImplementation _containingComponentImpl = context.getContainingComponentImpl();
          final EList<Mode> modes = _containingComponentImpl.getAllModes();
          _xblockexpression_1 = Scopes.scopeFor(modes);
        }
        _switchResult = _xblockexpression_1;
      }
    }
    return _switchResult;
  }
}
