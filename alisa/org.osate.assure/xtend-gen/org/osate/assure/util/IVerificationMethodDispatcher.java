package org.osate.assure.util;

import com.google.inject.ImplementedBy;
import org.osate.assure.assure.VerificationActivityResult;
import org.osate.assure.util.DefaultVerificationMethodDispatcher;

@ImplementedBy(DefaultVerificationMethodDispatcher.class)
@SuppressWarnings("all")
public interface IVerificationMethodDispatcher {
  public abstract Object dispatchVerificationMethod(final String methodPath, final VerificationActivityResult vr);
  
  public abstract void runVerificationMethod(final VerificationActivityResult verificationActivityResult);
}
