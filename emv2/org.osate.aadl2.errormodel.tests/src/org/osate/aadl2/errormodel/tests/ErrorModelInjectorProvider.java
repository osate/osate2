package org.osate.aadl2.errormodel.tests;

import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.xtext.aadl2.errormodel.ErrorModelStandaloneSetup;

import com.google.inject.Injector;

public class ErrorModelInjectorProvider extends Aadl2InjectorProvider {
	@Override
	protected Injector internalCreateInjector() {
		ErrorModelStandaloneSetup.doSetup();
		// new Aadl2InjectorProvider().getInjector();
		return super.internalCreateInjector();
	}
}
