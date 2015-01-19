package org.osate.assure.util;

import com.google.common.base.Objects;
import org.eclipse.emf.ecore.EObject;
import org.osate.assure.assure.CaseResult;

@SuppressWarnings("all")
public class AssureUtilExtension {
  public static CaseResult getEnclosingCaseResult(final EObject assureObject) {
    EObject result = assureObject;
    while ((!(result instanceof CaseResult))) {
      EObject _eContainer = result.eContainer();
      result = _eContainer;
    }
    boolean _equals = Objects.equal(result, null);
    if (_equals) {
      return null;
    }
    return ((CaseResult) result);
  }
}
