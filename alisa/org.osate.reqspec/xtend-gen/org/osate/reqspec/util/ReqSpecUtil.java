package org.osate.reqspec.util;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Classifier;
import org.osate.reqspec.reqSpec.ContractualElement;
import org.osate.reqspec.reqSpec.ReqSpecLibrary;

@SuppressWarnings("all")
public class ReqSpecUtil {
  public Classifier contextClassifier(final ContractualElement context) {
    final ContractualElement ce = ((ContractualElement) context);
    EObject container = context;
    while ((!Objects.equal(container.eContainer(), null))) {
      {
        EObject _eContainer = container.eContainer();
        container = _eContainer;
        if ((container instanceof ReqSpecLibrary)) {
          final ReqSpecLibrary rs = ((ReqSpecLibrary) container);
          Classifier _target = rs.getTarget();
          boolean _notEquals = (!Objects.equal(_target, null));
          if (_notEquals) {
            return rs.getTarget();
          }
        }
      }
    }
    return null;
  }
}
