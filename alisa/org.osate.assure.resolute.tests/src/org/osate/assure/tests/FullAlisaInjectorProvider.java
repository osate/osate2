package org.osate.assure.tests;

import org.osate.alisa.workbench.AlisaStandaloneSetup;
import org.osate.categories.CategoriesStandaloneSetup;
import org.osate.organization.OrganizationStandaloneSetup;
import org.osate.reqspec.ReqSpecStandaloneSetup;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.verify.VerifyStandaloneSetup;

import com.google.inject.Injector;
import com.rockwellcollins.atc.resolute.ResoluteStandaloneSetup;

public class FullAlisaInjectorProvider extends Aadl2InjectorProvider {
	@Override
	protected Injector internalCreateInjector() {
		// from online help
		CategoriesStandaloneSetup.doSetup();
		OrganizationStandaloneSetup.doSetup();
		ReqSpecStandaloneSetup.doSetup();
		VerifyStandaloneSetup.doSetup();
		AlisaStandaloneSetup.doSetup();
		ResoluteStandaloneSetup.doSetup();

		return super.internalCreateInjector();
	}
}
