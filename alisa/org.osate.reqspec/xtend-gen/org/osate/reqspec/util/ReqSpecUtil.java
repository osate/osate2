package org.osate.reqspec.util;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Classifier;
import org.osate.reqspec.reqSpec.ReqSpecContainer;

@SuppressWarnings("all")
public class ReqSpecUtil {
  public static Classifier contextClassifier(final EObject context) {
    EObject container = context;
    while ((!Objects.equal(container.eContainer(), null))) {
      {
        EObject _eContainer = container.eContainer();
        container = _eContainer;
        if ((container instanceof ReqSpecContainer)) {
          final ReqSpecContainer rs = ((ReqSpecContainer) container);
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
