package org.osate.xtext.aadl2.properties;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
public class PropertiesStandaloneSetup extends PropertiesStandaloneSetupGenerated {

	public static void doSetup() {
		new PropertiesStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}
