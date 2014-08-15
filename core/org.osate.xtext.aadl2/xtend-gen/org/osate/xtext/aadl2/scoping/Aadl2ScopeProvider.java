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

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
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
      final BehavioredImplementation containingClassifier = EcoreUtil2.<BehavioredImplementation>getContainerOfType(context, BehavioredImplementation.class);
      boolean _notEquals = (!Objects.equal(containingClassifier, null));
      if (_notEquals) {
        EList<NamedElement> _members = containingClassifier.getMembers();
        final Function1<NamedElement, Boolean> _function = new Function1<NamedElement, Boolean>() {
          public Boolean apply(final NamedElement it) {
            EClass _callContext = Aadl2Package.eINSTANCE.getCallContext();
            EClass _eClass = it.eClass();
            return Boolean.valueOf(_callContext.isSuperTypeOf(_eClass));
          }
        };
        Iterable<NamedElement> _filter = IterableExtensions.<NamedElement>filter(_members, _function);
        IScope _scopeFor = Scopes.scopeFor(_filter, scope);
        scope = _scopeFor;
      }
      _xblockexpression = scope;
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
          _switchResult = Collections.<Mode>unmodifiableList(Lists.<Mode>newArrayList());
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
  
  public IScope scope_Subcomponent(final ComponentImplementation context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      final EList<Subcomponent> subcomponents = context.getAllSubcomponents();
      _xblockexpression = Scopes.scopeFor(subcomponents);
    }
    return _xblockexpression;
  }
}
