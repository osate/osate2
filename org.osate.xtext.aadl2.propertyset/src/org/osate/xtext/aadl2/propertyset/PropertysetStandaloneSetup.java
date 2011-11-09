
package org.osate.xtext.aadl2.propertyset;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class PropertysetStandaloneSetup extends PropertysetStandaloneSetupGenerated{

	public static void doSetup() {
		new PropertysetStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

