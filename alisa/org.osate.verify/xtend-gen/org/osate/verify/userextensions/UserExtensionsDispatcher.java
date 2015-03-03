package org.osate.verify.userextensions;

import org.osate.aadl2.instance.InstanceObject;
import org.osate.verify.analysisplugins.DefaultVerificationMethodDispatcher;
import org.osate.verify.verify.VerificationMethod;

@SuppressWarnings("all")
public class UserExtensionsDispatcher extends DefaultVerificationMethodDispatcher {
  public Object dispatchVerificationMethod(final VerificationMethod vm, final InstanceObject target) {
    String _methodPath = vm.getMethodPath();
    boolean _matched = false;
    return super.dispatchVerificationMethod(vm, target);
  }
}
