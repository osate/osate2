package org.osate.verify.util;

import com.google.inject.ImplementedBy;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.verify.analysisplugins.DefaultVerificationMethodDispatcher;
import org.osate.verify.verify.VerificationMethod;

@ImplementedBy(DefaultVerificationMethodDispatcher.class)
@SuppressWarnings("all")
public interface IVerificationMethodDispatcher {
  public abstract Object dispatchVerificationMethod(final VerificationMethod vm, final InstanceObject target);
}
