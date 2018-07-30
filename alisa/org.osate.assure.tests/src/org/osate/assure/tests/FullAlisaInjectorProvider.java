package org.osate.assure.tests;

import org.osate.organization.OrganizationStandaloneSetup;
import org.osate.testsupport.Aadl2InjectorProvider;

import com.google.inject.Injector;

public class FullAlisaInjectorProvider extends Aadl2InjectorProvider {
		@Override
		protected Injector internalCreateInjector() {
			// trigger injector creation of other language
//		new CategoriesInjectorProvider().getInjector();
//		new OrganizationInjectorProvider().getInjector();
//		new ReqSpecInjectorProvider().getInjector();
//		new VerifyInjectorProvider().getInjector();
//		new AlisaInjectorProvider().getInjector();
//		new Aadl2InjectorProvider().getInjector();

//		CategoriesStandaloneSetup.doSetup();
		OrganizationStandaloneSetup.doSetup();
//		Aadl2StandaloneSetup.doSetup();
//		ReqSpecStandaloneSetup.doSetup();
//		VerifyStandaloneSetup.doSetup();
//		AlisaStandaloneSetup.doSetup();

			return super.internalCreateInjector();
	}
}
