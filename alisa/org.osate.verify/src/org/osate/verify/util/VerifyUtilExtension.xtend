package org.osate.verify.util

import org.osate.verify.verify.VerificationMethod
import org.osate.verify.verify.VerificationAction
import org.osate.verify.verify.VerificationActivity

class VerifyUtilExtension {
	def static VerificationMethod getMethod(VerificationAction va){
		switch (va){
			VerificationMethod: va
			VerificationActivity: va.method
		}
	}
}