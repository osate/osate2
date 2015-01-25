package org.osate.reqspec.util;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Classifier;
import org.osate.reqspec.reqSpec.ContractualElement;
import org.osate.reqspec.reqSpec.ReqSpecs;
import org.osate.reqspec.reqSpec.StakeholderGoals;

@SuppressWarnings("all")
public class ReqSpecUtil {
  public Classifier contextClassifier(final ContractualElement context) {
    EObject container = context;
    while ((!Objects.equal(container.eContainer(), null))) {
      {
        EObject _eContainer = container.eContainer();
        container = _eContainer;
        if ((container instanceof ReqSpecs)) {
          final ReqSpecs rs = ((ReqSpecs) container);
          Classifier _target = rs.getTarget();
          boolean _notEquals = (!Objects.equal(_target, null));
          if (_notEquals) {
            return rs.getTarget();
          }
        } else {
          if ((container instanceof StakeholderGoals)) {
            final StakeholderGoals rs_1 = ((StakeholderGoals) container);
            Classifier _target_1 = rs_1.getTarget();
            boolean _notEquals_1 = (!Objects.equal(_target_1, null));
            if (_notEquals_1) {
              return rs_1.getTarget();
            }
          }
        }
      }
    }
    return null;
  }
}
