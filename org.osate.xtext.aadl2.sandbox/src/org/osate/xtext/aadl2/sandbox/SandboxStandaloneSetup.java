
package org.osate.xtext.aadl2.sandbox;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class SandboxStandaloneSetup extends SandboxStandaloneSetupGenerated{

	public static void doSetup() {
		new SandboxStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

