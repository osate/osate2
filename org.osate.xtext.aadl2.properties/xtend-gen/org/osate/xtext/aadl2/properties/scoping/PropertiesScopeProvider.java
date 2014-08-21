/**
 * /
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
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
package org.osate.xtext.aadl2.properties.scoping;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ComponentTypeRename;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeatureGroupTypeRename;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.PackageRename;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.modelsupport.util.AadlUtil;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 */
@SuppressWarnings("all")
public class PropertiesScopeProvider extends AbstractDeclarativeScopeProvider {
  public IScope scope_Classifier(final Element context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      IScope scope = this.delegateGetScope(context, reference);
      final ArrayList<IEObjectDescription> renameScopeElements = CollectionLiterals.<IEObjectDescription>newArrayList();
      final PackageSection packageSection = EcoreUtil2.<PackageSection>getContainerOfType(context, PackageSection.class);
      boolean _notEquals = (!Objects.equal(packageSection, null));
      if (_notEquals) {
        EList<ComponentTypeRename> _ownedComponentTypeRenames = packageSection.getOwnedComponentTypeRenames();
        final Function1<ComponentTypeRename, Boolean> _function = new Function1<ComponentTypeRename, Boolean>() {
          public Boolean apply(final ComponentTypeRename it) {
            EClass _eReferenceType = reference.getEReferenceType();
            ComponentType _renamedComponentType = it.getRenamedComponentType();
            EClass _eClass = _renamedComponentType.eClass();
            return Boolean.valueOf(_eReferenceType.isSuperTypeOf(_eClass));
          }
        };
        Iterable<ComponentTypeRename> _filter = IterableExtensions.<ComponentTypeRename>filter(_ownedComponentTypeRenames, _function);
        final Procedure1<ComponentTypeRename> _function_1 = new Procedure1<ComponentTypeRename>() {
          public void apply(final ComponentTypeRename it) {
            String _elvis = null;
            String _name = it.getName();
            if (_name != null) {
              _elvis = _name;
            } else {
              ComponentType _renamedComponentType = it.getRenamedComponentType();
              String _name_1 = _renamedComponentType.getName();
              _elvis = _name_1;
            }
            QualifiedName _create = QualifiedName.create(_elvis);
            ComponentType _renamedComponentType_1 = it.getRenamedComponentType();
            EObjectDescription _eObjectDescription = new EObjectDescription(_create, _renamedComponentType_1, null);
            renameScopeElements.add(_eObjectDescription);
          }
        };
        IterableExtensions.<ComponentTypeRename>forEach(_filter, _function_1);
        EClass _eReferenceType = reference.getEReferenceType();
        EClass _featureGroupType = Aadl2Package.eINSTANCE.getFeatureGroupType();
        boolean _isSuperTypeOf = _eReferenceType.isSuperTypeOf(_featureGroupType);
        if (_isSuperTypeOf) {
          EList<FeatureGroupTypeRename> _ownedFeatureGroupTypeRenames = packageSection.getOwnedFeatureGroupTypeRenames();
          final Procedure1<FeatureGroupTypeRename> _function_2 = new Procedure1<FeatureGroupTypeRename>() {
            public void apply(final FeatureGroupTypeRename it) {
              String _elvis = null;
              String _name = it.getName();
              if (_name != null) {
                _elvis = _name;
              } else {
                FeatureGroupType _renamedFeatureGroupType = it.getRenamedFeatureGroupType();
                String _name_1 = _renamedFeatureGroupType.getName();
                _elvis = _name_1;
              }
              QualifiedName _create = QualifiedName.create(_elvis);
              FeatureGroupType _renamedFeatureGroupType_1 = it.getRenamedFeatureGroupType();
              EObjectDescription _eObjectDescription = new EObjectDescription(_create, _renamedFeatureGroupType_1, null);
              renameScopeElements.add(_eObjectDescription);
            }
          };
          IterableExtensions.<FeatureGroupTypeRename>forEach(_ownedFeatureGroupTypeRenames, _function_2);
        }
        EList<PackageRename> _ownedPackageRenames = packageSection.getOwnedPackageRenames();
        final Procedure1<PackageRename> _function_3 = new Procedure1<PackageRename>() {
          public void apply(final PackageRename packageRename) {
            AadlPackage _renamedPackage = packageRename.getRenamedPackage();
            PublicPackageSection _publicSection = _renamedPackage.getPublicSection();
            EList<Classifier> _ownedClassifiers = _publicSection.getOwnedClassifiers();
            final Function1<Classifier, Boolean> _function = new Function1<Classifier, Boolean>() {
              public Boolean apply(final Classifier it) {
                EClass _eReferenceType = reference.getEReferenceType();
                EClass _eClass = it.eClass();
                return Boolean.valueOf(_eReferenceType.isSuperTypeOf(_eClass));
              }
            };
            Iterable<Classifier> _filter = IterableExtensions.<Classifier>filter(_ownedClassifiers, _function);
            final Procedure1<Classifier> _function_1 = new Procedure1<Classifier>() {
              public void apply(final Classifier classifier) {
                List<String> _xifexpression = null;
                boolean _isRenameAll = packageRename.isRenameAll();
                if (_isRenameAll) {
                  String _name = classifier.getName();
                  _xifexpression = Collections.<String>unmodifiableList(Lists.<String>newArrayList(_name));
                } else {
                  String _name_1 = packageRename.getName();
                  String _name_2 = classifier.getName();
                  _xifexpression = Collections.<String>unmodifiableList(Lists.<String>newArrayList(_name_1, _name_2));
                }
                QualifiedName _create = QualifiedName.create(_xifexpression);
                EObjectDescription _eObjectDescription = new EObjectDescription(_create, classifier, null);
                renameScopeElements.add(_eObjectDescription);
              }
            };
            IterableExtensions.<Classifier>forEach(_filter, _function_1);
          }
        };
        IterableExtensions.<PackageRename>forEach(_ownedPackageRenames, _function_3);
        SimpleScope _simpleScope = new SimpleScope(scope, renameScopeElements);
        scope = _simpleScope;
      }
      _xblockexpression = scope;
    }
    return _xblockexpression;
  }
  
  /**
   * Reference is from ModalPropertyValue and OptionalModalPropertyValue in Properties.xtext
   * and SubprogramCallSequence, InternalFeature, ProcessorFeature, and DefaultAnnexSubclause in Aadl2.xtext
   */
  public IScope scope_ModalElement_inMode(final Element context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      IScope scope = IScope.NULLSCOPE;
      final PropertyAssociation containingPropertyAssociation = EcoreUtil2.<PropertyAssociation>getContainerOfType(context, PropertyAssociation.class);
      boolean _notEquals = (!Objects.equal(containingPropertyAssociation, null));
      if (_notEquals) {
        EList<ContainedNamedElement> _appliesTos = containingPropertyAssociation.getAppliesTos();
        boolean _isEmpty = _appliesTos.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          IScope _elvis = null;
          EList<ContainedNamedElement> _appliesTos_1 = containingPropertyAssociation.getAppliesTos();
          ContainedNamedElement _get = _appliesTos_1.get(0);
          EList<ContainmentPathElement> _containmentPathElements = _get.getContainmentPathElements();
          final Function1<ContainmentPathElement, Boolean> _function = new Function1<ContainmentPathElement, Boolean>() {
            public Boolean apply(final ContainmentPathElement it) {
              NamedElement _namedElement = it.getNamedElement();
              return Boolean.valueOf((_namedElement instanceof Subcomponent));
            }
          };
          ContainmentPathElement _findLast = IterableExtensions.<ContainmentPathElement>findLast(_containmentPathElements, _function);
          NamedElement _namedElement = _findLast.getNamedElement();
          ComponentClassifier _classifier = null;
          if (((Subcomponent) _namedElement)!=null) {
            _classifier=((Subcomponent) _namedElement).getClassifier();
          }
          EList<Mode> _allModes = null;
          if (_classifier!=null) {
            _allModes=_classifier.getAllModes();
          }
          IScope _scopeFor = Scopes.scopeFor(_allModes);
          if (_scopeFor != null) {
            _elvis = _scopeFor;
          } else {
            _elvis = scope;
          }
          scope = _elvis;
        } else {
          Element _owner = containingPropertyAssociation.getOwner();
          if ((_owner instanceof Subcomponent)) {
            IScope _elvis_1 = null;
            Element _owner_1 = containingPropertyAssociation.getOwner();
            ComponentClassifier _allClassifier = ((Subcomponent) _owner_1).getAllClassifier();
            EList<Mode> _allModes_1 = null;
            if (_allClassifier!=null) {
              _allModes_1=_allClassifier.getAllModes();
            }
            IScope _scopeFor_1 = Scopes.scopeFor(_allModes_1);
            if (_scopeFor_1 != null) {
              _elvis_1 = _scopeFor_1;
            } else {
              _elvis_1 = scope;
            }
            scope = _elvis_1;
          }
        }
      }
      boolean _equals = Objects.equal(scope, IScope.NULLSCOPE);
      if (_equals) {
        ComponentClassifier _containerOfType = EcoreUtil2.<ComponentClassifier>getContainerOfType(context, ComponentClassifier.class);
        EList<Mode> _allModes_2 = _containerOfType.getAllModes();
        IScope _scopeFor_2 = Scopes.scopeFor(_allModes_2);
        scope = _scopeFor_2;
      }
      _xblockexpression = scope;
    }
    return _xblockexpression;
  }
  
  public IScope scope_NamedValue_namedValue(final Element context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      IScope scope = this.delegateGetScope(context, reference);
      PropertyType propertyType = null;
      BasicPropertyAssociation _containerOfType = EcoreUtil2.<BasicPropertyAssociation>getContainerOfType(context, BasicPropertyAssociation.class);
      BasicProperty _property = null;
      if (_containerOfType!=null) {
        _property=_containerOfType.getProperty();
      }
      PropertyType _propertyType = null;
      if (_property!=null) {
        _propertyType=_property.getPropertyType();
      }
      propertyType = _propertyType;
      boolean _equals = Objects.equal(propertyType, null);
      if (_equals) {
        PropertyConstant _containerOfType_1 = EcoreUtil2.<PropertyConstant>getContainerOfType(context, PropertyConstant.class);
        PropertyType _propertyType_1 = null;
        if (_containerOfType_1!=null) {
          _propertyType_1=_containerOfType_1.getPropertyType();
        }
        propertyType = _propertyType_1;
      }
      boolean _equals_1 = Objects.equal(propertyType, null);
      if (_equals_1) {
        Property _containerOfType_2 = EcoreUtil2.<Property>getContainerOfType(context, Property.class);
        PropertyType _propertyType_2 = null;
        if (_containerOfType_2!=null) {
          _propertyType_2=_containerOfType_2.getPropertyType();
        }
        propertyType = _propertyType_2;
      }
      boolean _equals_2 = Objects.equal(propertyType, null);
      if (_equals_2) {
        PropertyAssociation _containerOfType_3 = EcoreUtil2.<PropertyAssociation>getContainerOfType(context, PropertyAssociation.class);
        Property _property_1 = null;
        if (_containerOfType_3!=null) {
          _property_1=_containerOfType_3.getProperty();
        }
        PropertyType _propertyType_3 = null;
        if (_property_1!=null) {
          _propertyType_3=_property_1.getPropertyType();
        }
        propertyType = _propertyType_3;
      }
      PropertyType _basePropertyType = AadlUtil.getBasePropertyType(propertyType);
      propertyType = _basePropertyType;
      boolean _matched = false;
      if (!_matched) {
        if (propertyType instanceof EnumerationType) {
          _matched=true;
          EList<EnumerationLiteral> _ownedLiterals = ((EnumerationType)propertyType).getOwnedLiterals();
          IScope _scopeFor = Scopes.scopeFor(_ownedLiterals, scope);
          scope = _scopeFor;
        }
      }
      _xblockexpression = scope;
    }
    return _xblockexpression;
  }
  
  public IScope scope_BasicPropertyAssociation_property(final Element context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      Element _switchResult = null;
      boolean _matched = false;
      if (!_matched) {
        if (context instanceof BasicPropertyAssociation) {
          BasicProperty _property = ((BasicPropertyAssociation)context).getProperty();
          PropertyType _propertyType = _property.getPropertyType();
          boolean _equals = Objects.equal(_propertyType, null);
          if (_equals) {
            _matched=true;
            _switchResult = ((BasicPropertyAssociation)context).getOwner();
          }
        }
      }
      if (!_matched) {
        _switchResult = context;
      }
      Element parent = _switchResult;
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(parent, null));
      if (!_notEquals) {
        _and = false;
      } else {
        _and = (!((((parent instanceof BasicPropertyAssociation) || (parent instanceof PropertyAssociation)) || (parent instanceof Property)) || (parent instanceof PropertyConstant)));
      }
      boolean _while = _and;
      while (_while) {
        Element _owner = parent.getOwner();
        parent = _owner;
        boolean _and_1 = false;
        boolean _notEquals_1 = (!Objects.equal(parent, null));
        if (!_notEquals_1) {
          _and_1 = false;
        } else {
          _and_1 = (!((((parent instanceof BasicPropertyAssociation) || (parent instanceof PropertyAssociation)) || (parent instanceof Property)) || (parent instanceof PropertyConstant)));
        }
        _while = _and_1;
      }
      PropertyType propertyType = null;
      boolean _matched_1 = false;
      if (!_matched_1) {
        if (parent instanceof BasicPropertyAssociation) {
          _matched_1=true;
          BasicProperty _property = ((BasicPropertyAssociation)parent).getProperty();
          PropertyType _propertyType = null;
          if (_property!=null) {
            _propertyType=_property.getPropertyType();
          }
          propertyType = _propertyType;
        }
      }
      if (!_matched_1) {
        if (parent instanceof PropertyAssociation) {
          _matched_1=true;
          Property _property = ((PropertyAssociation)parent).getProperty();
          PropertyType _propertyType = null;
          if (_property!=null) {
            _propertyType=_property.getPropertyType();
          }
          propertyType = _propertyType;
        }
      }
      if (!_matched_1) {
        if (parent instanceof Property) {
          _matched_1=true;
          PropertyType _propertyType = ((Property)parent).getPropertyType();
          propertyType = _propertyType;
        }
      }
      if (!_matched_1) {
        if (parent instanceof PropertyConstant) {
          _matched_1=true;
          PropertyType _propertyType = ((PropertyConstant)parent).getPropertyType();
          propertyType = _propertyType;
        }
      }
      PropertyType _basePropertyType = AadlUtil.getBasePropertyType(propertyType);
      propertyType = _basePropertyType;
      boolean _matched_2 = false;
      if (!_matched_2) {
        if (propertyType instanceof RecordType) {
          _matched_2=true;
          EList<BasicProperty> _ownedFields = ((RecordType)propertyType).getOwnedFields();
          return Scopes.scopeFor(_ownedFields);
        }
      }
      _xblockexpression = IScope.NULLSCOPE;
    }
    return _xblockexpression;
  }
  
  public IScope scope_NumberValue_unit(final NumberType context, final EReference reference) {
    IScope _elvis = null;
    UnitsType _unitsType = context.getUnitsType();
    EList<EnumerationLiteral> _ownedLiterals = null;
    if (_unitsType!=null) {
      _ownedLiterals=_unitsType.getOwnedLiterals();
    }
    IScope _scopeFor = Scopes.scopeFor(_ownedLiterals);
    if (_scopeFor != null) {
      _elvis = _scopeFor;
    } else {
      _elvis = IScope.NULLSCOPE;
    }
    return _elvis;
  }
  
  public IScope scope_NumberValue_unit(final PropertyConstant context, final EReference reference) {
    PropertyType _propertyType = context.getPropertyType();
    return this.createUnitLiteralsScopeFromPropertyType(_propertyType);
  }
  
  public IScope scope_NumberValue_unit(final Property context, final EReference reference) {
    PropertyType _propertyType = context.getPropertyType();
    return this.createUnitLiteralsScopeFromPropertyType(_propertyType);
  }
  
  public IScope scope_NumberValue_unit(final PropertyAssociation context, final EReference reference) {
    Property _property = context.getProperty();
    PropertyType _propertyType = _property.getPropertyType();
    return this.createUnitLiteralsScopeFromPropertyType(_propertyType);
  }
  
  public IScope scope_NumberValue_unit(final BasicPropertyAssociation context, final EReference reference) {
    BasicProperty _property = context.getProperty();
    PropertyType _propertyType = _property.getPropertyType();
    return this.createUnitLiteralsScopeFromPropertyType(_propertyType);
  }
  
  private IScope createUnitLiteralsScopeFromPropertyType(final PropertyType type) {
    IScope _xblockexpression = null;
    {
      final PropertyType baseType = AadlUtil.getBasePropertyType(type);
      UnitsType unitsType = null;
      boolean _matched = false;
      if (!_matched) {
        if (baseType instanceof NumberType) {
          _matched=true;
          UnitsType _unitsType = ((NumberType)baseType).getUnitsType();
          unitsType = _unitsType;
        }
      }
      if (!_matched) {
        if (baseType instanceof RangeType) {
          _matched=true;
          NumberType _numberType = ((RangeType)baseType).getNumberType();
          UnitsType _unitsType = _numberType.getUnitsType();
          unitsType = _unitsType;
        }
      }
      IScope _elvis = null;
      EList<EnumerationLiteral> _ownedLiterals = null;
      if (unitsType!=null) {
        _ownedLiterals=unitsType.getOwnedLiterals();
      }
      IScope _scopeFor = Scopes.scopeFor(_ownedLiterals);
      if (_scopeFor != null) {
        _elvis = _scopeFor;
      } else {
        _elvis = IScope.NULLSCOPE;
      }
      _xblockexpression = _elvis;
    }
    return _xblockexpression;
  }
}
