package org.osate.xtext.aadl2.errormodel;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class ErrorModelStandaloneSetup extends ErrorModelStandaloneSetupGenerated {

	public static void doSetup() {
		new ErrorModelStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
