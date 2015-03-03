package org.osate.verify.util

import com.google.inject.ImplementedBy
import org.osate.aadl2.instance.InstanceObject
import org.osate.verify.verify.VerificationMethod

import org.osate.verify.analysisplugins.DefaultVerificationMethodDispatcher

@ImplementedBy(DefaultVerificationMethodDispatcher)
interface IVerificationMethodDispatcher {
	def Object dispatchVerificationMethod(VerificationMethod vm, InstanceObject target);
}
