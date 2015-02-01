package org.osate.verify.util;

import org.osate.verify.verify.VerificationAction;
import org.osate.verify.verify.VerificationActivity;
import org.osate.verify.verify.VerificationMethod;

@SuppressWarnings("all")
public class VerifyUtilExtension {
  public static VerificationMethod getMethod(final VerificationAction va) {
    VerificationMethod _switchResult = null;
    boolean _matched = false;
    if (!_matched) {
      if (va instanceof VerificationMethod) {
        _matched=true;
        _switchResult = ((VerificationMethod)va);
      }
    }
    if (!_matched) {
      if (va instanceof VerificationActivity) {
        _matched=true;
        _switchResult = ((VerificationActivity)va).getMethod();
      }
    }
    return _switchResult;
  }
}
