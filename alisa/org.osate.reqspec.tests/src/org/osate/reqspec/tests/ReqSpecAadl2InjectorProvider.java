package org.osate.reqspec.tests;

import org.osate.categories.CategoriesStandaloneSetup;
import org.osate.organization.OrganizationStandaloneSetup;
import org.osate.reqspec.ReqSpecInjectorProvider;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;
import com.google.inject.Injector;

public class ReqSpecAadl2InjectorProvider extends ReqSpecInjectorProvider {
		@Override
		protected Injector internalCreateInjector() {
		// from online help
		Aadl2StandaloneSetup.doSetup();
		OrganizationStandaloneSetup.doSetup();
		CategoriesStandaloneSetup.doSetup();

		return super.internalCreateInjector();
	}
}
