
package org.osate.xtext.aadl2;


/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class Aadl2StandaloneSetup extends Aadl2StandaloneSetupGenerated{

	public static void doSetup() {
		new Aadl2StandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

