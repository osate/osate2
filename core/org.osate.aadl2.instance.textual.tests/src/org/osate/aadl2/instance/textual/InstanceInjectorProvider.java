package org.osate.aadl2.instance.textual;

import org.osate.testsupport.Aadl2InjectorProvider;

import com.google.inject.Injector;

public class InstanceInjectorProvider extends Aadl2InjectorProvider {
	@Override
	protected Injector internalCreateInjector() {
		InstanceStandaloneSetup.doSetup();
		return super.internalCreateInjector();
	}
}
