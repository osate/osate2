package org.osate.alisa.workbench.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.alisa.workbench.alisa.AssuranceCasePlan;
import org.osate.verify.verify.VerificationPlan;

@SuppressWarnings("all")
public class AlisaWorkbenchUtilsExtension {
  public Iterable<VerificationPlan> getVerificationPlans(final ComponentInstance io, final AssuranceCasePlan acp) {
    Iterable<VerificationPlan> _xblockexpression = null;
    {
      EList<VerificationPlan> _plans = acp.getPlans();
      final Function1<VerificationPlan, Boolean> _function = new Function1<VerificationPlan, Boolean>() {
        public Boolean apply(final VerificationPlan vp) {
          ComponentClassifier _target = vp.getTarget();
          ComponentClassifier _componentClassifier = io.getComponentClassifier();
          return Boolean.valueOf(AlisaWorkbenchUtilsExtension.this.isSame(_target, _componentClassifier));
        }
      };
      final Iterable<VerificationPlan> myplans = IterableExtensions.<VerificationPlan>filter(_plans, _function);
      _xblockexpression = myplans;
    }
    return _xblockexpression;
  }
  
  public boolean isSame(final ComponentClassifier cl1, final ComponentClassifier cl2) {
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
}
