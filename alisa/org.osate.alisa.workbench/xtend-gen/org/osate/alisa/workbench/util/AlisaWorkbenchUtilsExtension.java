package org.osate.alisa.workbench.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.alisa.workbench.alisa.AssuranceEvidenceConfiguration;
import org.osate.reqspec.reqSpec.Requirement;
import org.osate.verify.verify.VerificationPlan;

@SuppressWarnings("all")
public class AlisaWorkbenchUtilsExtension {
  public static Iterable<VerificationPlan> getVerificationPlans(final ComponentInstance io, final AssuranceEvidenceConfiguration acp) {
    Iterable<VerificationPlan> _xblockexpression = null;
    {
      EList<VerificationPlan> _plans = acp.getPlans();
      final Function1<VerificationPlan, Boolean> _function = new Function1<VerificationPlan, Boolean>() {
        public Boolean apply(final VerificationPlan vp) {
          ComponentClassifier _target = vp.getTarget();
          ComponentClassifier _componentClassifier = io.getComponentClassifier();
          return Boolean.valueOf(AlisaWorkbenchUtilsExtension.isSame(_target, _componentClassifier));
        }
      };
      final Iterable<VerificationPlan> myplans = IterableExtensions.<VerificationPlan>filter(_plans, _function);
      _xblockexpression = myplans;
    }
    return _xblockexpression;
  }
  
  public static boolean isSame(final ComponentClassifier cl1, final ComponentClassifier cl2) {
    boolean _xblockexpression = false;
    {
      ComponentClassifier lcl1 = cl1;
      ComponentClassifier lcl2 = cl2;
      boolean _and = false;
      if (!(cl1 instanceof ComponentType)) {
        _and = false;
      } else {
        _and = (cl2 instanceof ComponentImplementation);
      }
      if (_and) {
        ComponentType _type = ((ComponentImplementation) cl2).getType();
        lcl2 = _type;
      }
      boolean _and_1 = false;
      if (!(cl2 instanceof ComponentType)) {
        _and_1 = false;
      } else {
        _and_1 = (cl1 instanceof ComponentImplementation);
      }
      if (_and_1) {
        ComponentType _type_1 = ((ComponentImplementation) cl1).getType();
        lcl1 = _type_1;
      }
      String _name = cl1.getName();
      String _name_1 = cl2.getName();
      _xblockexpression = _name.equalsIgnoreCase(_name_1);
    }
    return _xblockexpression;
  }
  
  public static InstanceObject getRequirementTarget(final Requirement req, final ComponentInstance io) {
    Classifier _target = req.getTarget();
    return AlisaWorkbenchUtilsExtension.findElementInstance(io, _target);
  }
  
  public static InstanceObject findElementInstance(final ComponentInstance io, final NamedElement element) {
    InstanceObject _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (io instanceof ComponentInstance) {
        _matched=true;
        EList<Element> _allOwnedElements = io.allOwnedElements();
        final Function1<Element, Boolean> _function = new Function1<Element, Boolean>() {
          public Boolean apply(final Element ei) {
            String _name = ((InstanceObject) ei).getName();
            String _name_1 = element.getName();
            return Boolean.valueOf(_name.equalsIgnoreCase(_name_1));
          }
        };
        Element _findFirst = IterableExtensions.<Element>findFirst(_allOwnedElements, _function);
        _switchResult = ((InstanceObject) _findFirst);
      }
    }
    if (!_matched) {
      _switchResult = io;
    }
    return _switchResult;
  }
}
