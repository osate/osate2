package org.osate.reqspec

import org.osate.verify.VerifyInjectorProvider
import org.osate.organization.OrganizationInjectorProvider

// taken from http://zarnekow.blogspot.de/2014/10/testing-multiple-xtext-dsls.html
class MultiDSLInjectorProvider extends ReqSpecInjectorProvider {
	override protected internalCreateInjector() {
		// trigger injector creation of other language
		new VerifyInjectorProvider().getInjector
		new OrganizationInjectorProvider().getInjector
		return super.internalCreateInjector()
	}
}