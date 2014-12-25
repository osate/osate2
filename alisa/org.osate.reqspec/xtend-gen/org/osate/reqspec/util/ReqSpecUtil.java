package org.osate.reqspec.util;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Classifier;
import org.osate.reqspec.reqSpec.ContractualElement;
import org.osate.reqspec.reqSpec.ReqSpecContainer;

@SuppressWarnings("all")
public class ReqSpecUtil {
  public Classifier contextClassifier(final ContractualElement context) {
    final ContractualElement ce = ((ContractualElement) context);
    Classifier _targetContext = ce.getTargetContext();
    boolean _notEquals = (!Objects.equal(_targetContext, null));
    if (_notEquals) {
      return ce.getTargetContext();
    }
    EObject container = context;
    while ((!Objects.equal(container.eContainer(), null))) {
      {
        EObject _eContainer = container.eContainer();
        container = _eContainer;
        if ((container instanceof ReqSpecContainer)) {
          final ReqSpecContainer rs = ((ReqSpecContainer) container);
          Classifier _target = rs.getTarget();
          boolean _notEquals_1 = (!Objects.equal(_target, null));
          if (_notEquals_1) {
            return rs.getTarget();
          }
        }
      }
    }
    return null;
  }
}
